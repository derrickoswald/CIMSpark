package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * The Area Control Error tariff type that is applied or used.
 *
 * @param Element Reference to the superclass object.
 * @param type The coded type of an ACE tariff.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param Point [[ch.ninecode.model.Point Point]] <em>undocumented</em>
 * @param Unit [[ch.ninecode.model.Unit_ Unit_]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
final case class AceTariffType
(
    Element: BasicElement = null,
    `type`: String = null,
    MarketDocument: List[String] = null,
    Point: List[String] = null,
    Unit: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AceTariffType.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AceTariffType.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AceTariffType.fields (position), x))
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
    CIMParseable[AceTariffType]
{
    override val fields: Array[String] = Array[String] (
        "type",
        "MarketDocument",
        "Point",
        "Unit"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketDocument", "MarketDocument", "0..*", "0..*"),
        CIMRelationship ("Point", "Point", "0..*", "0..*"),
        CIMRelationship ("Unit", "Unit_", "0..*", "0..*")
    )
    val `type`: Fielder = parse_element (element (cls, fields(0)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Point: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Unit: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): AceTariffType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[AceTariffType] = AceTariffTypeSerializer
}

object AceTariffTypeSerializer extends CIMSerializer[AceTariffType]
{
    def write (kryo: Kryo, output: Output, obj: AceTariffType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.`type`),
            () => writeList (obj.MarketDocument, output),
            () => writeList (obj.Point, output),
            () => writeList (obj.Unit, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AceTariffType]): AceTariffType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AceTariffType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A class used to provide information about an attribute.
 *
 * @param Element Reference to the superclass object.
 * @param attribute The identification of the formal name of an attribute.
 * @param attributeValue The instance value of the attribute.
 * @param position A sequential value representing a relative sequence number.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
final case class AttributeInstanceComponent
(
    Element: BasicElement = null,
    attribute: String = null,
    attributeValue: String = null,
    position: Int = 0,
    MarketDocument: List[String] = null,
    TimeSeries: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AttributeInstanceComponent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AttributeInstanceComponent.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AttributeInstanceComponent.fields (position), x))
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
    CIMParseable[AttributeInstanceComponent]
{
    override val fields: Array[String] = Array[String] (
        "attribute",
        "attributeValue",
        "position",
        "MarketDocument",
        "TimeSeries"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketDocument", "MarketDocument", "0..*", "0..*"),
        CIMRelationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val attribute: Fielder = parse_element (element (cls, fields(0)))
    val attributeValue: Fielder = parse_element (element (cls, fields(1)))
    val position: Fielder = parse_element (element (cls, fields(2)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): AttributeInstanceComponent =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[AttributeInstanceComponent] = AttributeInstanceComponentSerializer
}

object AttributeInstanceComponentSerializer extends CIMSerializer[AttributeInstanceComponent]
{
    def write (kryo: Kryo, output: Output, obj: AttributeInstanceComponent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.attribute),
            () => output.writeString (obj.attributeValue),
            () => output.writeInt (obj.position),
            () => writeList (obj.MarketDocument, output),
            () => writeList (obj.TimeSeries, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AttributeInstanceComponent]): AttributeInstanceComponent =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AttributeInstanceComponent (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readInt else 0,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A class providing the identification and type of an auction.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
final case class Auction
(
    IdentifiedObject: IdentifiedObject = null,
    allocationMode: String = null,
    cancelled: String = null,
    category: String = null,
    paymentTerms: String = null,
    rights: String = null,
    `type`: String = null,
    TimeSeries: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Auction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Auction.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Auction.fields (position), x))
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
    CIMParseable[Auction]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val allocationMode: Fielder = parse_element (element (cls, fields(0)))
    val cancelled: Fielder = parse_element (element (cls, fields(1)))
    val category: Fielder = parse_element (element (cls, fields(2)))
    val paymentTerms: Fielder = parse_element (element (cls, fields(3)))
    val rights: Fielder = parse_element (element (cls, fields(4)))
    val `type`: Fielder = parse_element (element (cls, fields(5)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: CIMContext): Auction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[Auction] = AuctionSerializer
}

object AuctionSerializer extends CIMSerializer[Auction]
{
    def write (kryo: Kryo, output: Output, obj: Auction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.allocationMode),
            () => output.writeString (obj.cancelled),
            () => output.writeString (obj.category),
            () => output.writeString (obj.paymentTerms),
            () => output.writeString (obj.rights),
            () => output.writeString (obj.`type`),
            () => writeList (obj.TimeSeries, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Auction]): Auction =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Auction (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The formal specification of specific characteristics related to a bid.
 *
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] Reference to the superclass object.
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
final case class BidTimeSeries
(
    TimeSeries: TimeSeries = null,
    blockBid: String = null,
    direction: String = null,
    divisible: String = null,
    exclusiveBidsIdentification: String = null,
    linkedBidsIdentification: String = null,
    minimumActivationQuantity: Double = 0.0,
    priority: Int = 0,
    status: String = null,
    stepIncrementQuantity: Double = 0.0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: TimeSeries = TimeSeries

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[BidTimeSeries]
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

    def parse (context: CIMContext): BidTimeSeries =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[BidTimeSeries] = BidTimeSeriesSerializer
}

object BidTimeSeriesSerializer extends CIMSerializer[BidTimeSeries]
{
    def write (kryo: Kryo, output: Output, obj: BidTimeSeries): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.blockBid),
            () => output.writeString (obj.direction),
            () => output.writeString (obj.divisible),
            () => output.writeString (obj.exclusiveBidsIdentification),
            () => output.writeString (obj.linkedBidsIdentification),
            () => output.writeDouble (obj.minimumActivationQuantity),
            () => output.writeInt (obj.priority),
            () => output.writeString (obj.status),
            () => output.writeDouble (obj.stepIncrementQuantity)
        )
        TimeSeriesSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BidTimeSeries]): BidTimeSeries =
    {
        val parent = TimeSeriesSerializer.read (kryo, input, classOf[TimeSeries])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BidTimeSeries (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readInt else 0,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Duration constraint to activate, to put in operation, to deactivate, ... a given event.
 *
 * @param Element Reference to the superclass object.
 * @param duration The duration of the constraint.
 * @param type The type of the constraint.
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
final case class ConstraintDuration
(
    Element: BasicElement = null,
    duration: String = null,
    `type`: String = null,
    TimeSeries: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ConstraintDuration.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ConstraintDuration.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ConstraintDuration.fields (position), x))
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
    CIMParseable[ConstraintDuration]
{
    override val fields: Array[String] = Array[String] (
        "duration",
        "type",
        "TimeSeries"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val duration: Fielder = parse_element (element (cls, fields(0)))
    val `type`: Fielder = parse_element (element (cls, fields(1)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): ConstraintDuration =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ConstraintDuration (
            BasicElement.parse (context),
            mask (duration (), 0),
            mask (`type` (), 1),
            masks (TimeSeries (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ConstraintDuration] = ConstraintDurationSerializer
}

object ConstraintDurationSerializer extends CIMSerializer[ConstraintDuration]
{
    def write (kryo: Kryo, output: Output, obj: ConstraintDuration): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.duration),
            () => output.writeString (obj.`type`),
            () => writeList (obj.TimeSeries, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ConstraintDuration]): ConstraintDuration =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ConstraintDuration (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The date and/or the time.
 *
 * @param Element Reference to the superclass object.
 * @param date Date as "yyyy-mm-dd", which conforms with ISO 8601
 * @param time Time as "hh:mm:ss.sssZ", which conforms with ISO 8601.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
final case class DateAndOrTime
(
    Element: BasicElement = null,
    date: String = null,
    time: String = null,
    MarketDocument: List[String] = null,
    TimeSeries: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DateAndOrTime.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DateAndOrTime.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DateAndOrTime.fields (position), x))
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
    CIMParseable[DateAndOrTime]
{
    override val fields: Array[String] = Array[String] (
        "date",
        "time",
        "MarketDocument",
        "TimeSeries"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketDocument", "MarketDocument", "0..*", "0..*"),
        CIMRelationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val date: Fielder = parse_element (element (cls, fields(0)))
    val time: Fielder = parse_element (element (cls, fields(1)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): DateAndOrTime =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[DateAndOrTime] = DateAndOrTimeSerializer
}

object DateAndOrTimeSerializer extends CIMSerializer[DateAndOrTime]
{
    def write (kryo: Kryo, output: Output, obj: DateAndOrTime): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.date),
            () => output.writeString (obj.time),
            () => writeList (obj.MarketDocument, output),
            () => writeList (obj.TimeSeries, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DateAndOrTime]): DateAndOrTime =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DateAndOrTime (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An area of activity defined within the energy market.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param Price [[ch.ninecode.model.Price Price]] <em>undocumented</em>
 * @param Quantity [[ch.ninecode.model.Quantity Quantity]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
final case class Domain
(
    IdentifiedObject: IdentifiedObject = null,
    MarketDocument: List[String] = null,
    Price: List[String] = null,
    Quantity: List[String] = null,
    RegisteredResource: List[String] = null,
    TimeSeries: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Domain.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Domain.fields (position), x))
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
    CIMParseable[Domain]
{
    override val fields: Array[String] = Array[String] (
        "MarketDocument",
        "Price",
        "Quantity",
        "RegisteredResource",
        "TimeSeries"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketDocument", "MarketDocument", "0..*", "0..*"),
        CIMRelationship ("Price", "Price", "0..*", "0..*"),
        CIMRelationship ("Quantity", "Quantity", "0..*", "0..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*"),
        CIMRelationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Price: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Quantity: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): Domain =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[Domain] = DomainSerializer
}

object DomainSerializer extends CIMSerializer[Domain]
{
    def write (kryo: Kryo, output: Output, obj: Domain): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.MarketDocument, output),
            () => writeList (obj.Price, output),
            () => writeList (obj.Quantity, output),
            () => writeList (obj.RegisteredResource, output),
            () => writeList (obj.TimeSeries, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Domain]): Domain =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Domain (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The coded identification of the direction of energy flow.
 *
 * @param Element Reference to the superclass object.
 * @param direction The coded identification of the direction of energy flow.
 * @param Point [[ch.ninecode.model.Point Point]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
final case class FlowDirection
(
    Element: BasicElement = null,
    direction: String = null,
    Point: List[String] = null,
    TimeSeries: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FlowDirection.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FlowDirection.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (FlowDirection.fields (position), x))
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
    CIMParseable[FlowDirection]
{
    override val fields: Array[String] = Array[String] (
        "direction",
        "Point",
        "TimeSeries"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Point", "Point", "0..*", "0..*"),
        CIMRelationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val direction: Fielder = parse_element (element (cls, fields(0)))
    val Point: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): FlowDirection =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FlowDirection (
            BasicElement.parse (context),
            mask (direction (), 0),
            masks (Point (), 1),
            masks (TimeSeries (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[FlowDirection] = FlowDirectionSerializer
}

object FlowDirectionSerializer extends CIMSerializer[FlowDirection]
{
    def write (kryo: Kryo, output: Output, obj: FlowDirection): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.direction),
            () => writeList (obj.Point, output),
            () => writeList (obj.TimeSeries, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FlowDirection]): FlowDirection =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FlowDirection (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An identification  or eventually the contents of an agreement between two or more parties.
 *
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] Reference to the superclass object.
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
final case class MarketAgreement
(
    MarketDocument: MarketDocument = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: MarketDocument = MarketDocument

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[MarketAgreement]
{

    def parse (context: CIMContext): MarketAgreement =
    {
        val ret = MarketAgreement (
            MarketDocument.parse (context)
        )
        ret
    }

    def serializer: Serializer[MarketAgreement] = MarketAgreementSerializer
}

object MarketAgreementSerializer extends CIMSerializer[MarketAgreement]
{
    def write (kryo: Kryo, output: Output, obj: MarketAgreement): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        MarketDocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketAgreement]): MarketAgreement =
    {
        val parent = MarketDocumentSerializer.read (kryo, input, classOf[MarketDocument])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketAgreement (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Electronic document containing the information necessary to satisfy a given business process set of requirements.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param AceTariffType [[ch.ninecode.model.AceTariffType AceTariffType]] <em>undocumented</em>
 * @param AttributeInstanceComponent [[ch.ninecode.model.AttributeInstanceComponent AttributeInstanceComponent]] <em>undocumented</em>
 * @param DateAndOrTime [[ch.ninecode.model.DateAndOrTime DateAndOrTime]] <em>undocumented</em>
 * @param Domain [[ch.ninecode.model.Domain Domain]] <em>undocumented</em>
 * @param MarketDocument_attr [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
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
final case class MarketDocument
(
    Document: Document = null,
    AceTariffType: List[String] = null,
    AttributeInstanceComponent: List[String] = null,
    DateAndOrTime: List[String] = null,
    Domain: List[String] = null,
    MarketDocument_attr: List[String] = null,
    MarketParticipant: List[String] = null,
    Period: List[String] = null,
    Process: List[String] = null,
    Reason: List[String] = null,
    SelfMarketDocument: List[String] = null,
    TimeSeries: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Document = Document

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketDocument.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketDocument.fields (position), x))
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
    CIMParseable[MarketDocument]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AceTariffType", "AceTariffType", "0..*", "0..*"),
        CIMRelationship ("AttributeInstanceComponent", "AttributeInstanceComponent", "0..*", "0..*"),
        CIMRelationship ("DateAndOrTime", "DateAndOrTime", "0..*", "0..*"),
        CIMRelationship ("Domain", "Domain", "0..*", "0..*"),
        CIMRelationship ("MarketDocument_attr", "MarketDocument", "0..*", "0..*"),
        CIMRelationship ("MarketParticipant", "MarketParticipant", "0..*", "0..*"),
        CIMRelationship ("Period", "Period", "0..*", "0..*"),
        CIMRelationship ("Process", "Process", "0..*", "0..*"),
        CIMRelationship ("Reason", "Reason", "0..*", "0..*"),
        CIMRelationship ("SelfMarketDocument", "MarketDocument", "0..*", "0..*"),
        CIMRelationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
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

    def parse (context: CIMContext): MarketDocument =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[MarketDocument] = MarketDocumentSerializer
}

object MarketDocumentSerializer extends CIMSerializer[MarketDocument]
{
    def write (kryo: Kryo, output: Output, obj: MarketDocument): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.AceTariffType, output),
            () => writeList (obj.AttributeInstanceComponent, output),
            () => writeList (obj.DateAndOrTime, output),
            () => writeList (obj.Domain, output),
            () => writeList (obj.MarketDocument_attr, output),
            () => writeList (obj.MarketParticipant, output),
            () => writeList (obj.Period, output),
            () => writeList (obj.Process, output),
            () => writeList (obj.Reason, output),
            () => writeList (obj.SelfMarketDocument, output),
            () => writeList (obj.TimeSeries, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketDocument]): MarketDocument =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketDocument (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The identification of an entity where energy products are measured or computed.
 *
 * @param UsagePoint [[ch.ninecode.model.UsagePoint UsagePoint]] Reference to the superclass object.
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
final case class MarketEvaluationPoint
(
    UsagePoint: UsagePoint = null,
    TimeSeries: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: UsagePoint = UsagePoint

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketEvaluationPoint.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketEvaluationPoint.fields (position), x))
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
    CIMParseable[MarketEvaluationPoint]
{
    override val fields: Array[String] = Array[String] (
        "TimeSeries"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): MarketEvaluationPoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketEvaluationPoint (
            UsagePoint.parse (context),
            masks (TimeSeries (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MarketEvaluationPoint] = MarketEvaluationPointSerializer
}

object MarketEvaluationPointSerializer extends CIMSerializer[MarketEvaluationPoint]
{
    def write (kryo: Kryo, output: Output, obj: MarketEvaluationPoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.TimeSeries, output)
        )
        UsagePointSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketEvaluationPoint]): MarketEvaluationPoint =
    {
        val parent = UsagePointSerializer.read (kryo, input, classOf[UsagePoint])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketEvaluationPoint (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The condition or position of an object with regard to its standing.
 *
 * @param Element Reference to the superclass object.
 * @param status The coded condition or position of an object with regard to its standing.
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
final case class MarketObjectStatus
(
    Element: BasicElement = null,
    status: String = null,
    RegisteredResource: List[String] = null,
    TimeSeries: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketObjectStatus.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketObjectStatus.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketObjectStatus.fields (position), x))
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
    CIMParseable[MarketObjectStatus]
{
    override val fields: Array[String] = Array[String] (
        "status",
        "RegisteredResource",
        "TimeSeries"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*"),
        CIMRelationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val status: Fielder = parse_element (element (cls, fields(0)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): MarketObjectStatus =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketObjectStatus (
            BasicElement.parse (context),
            mask (status (), 0),
            masks (RegisteredResource (), 1),
            masks (TimeSeries (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MarketObjectStatus] = MarketObjectStatusSerializer
}

object MarketObjectStatusSerializer extends CIMSerializer[MarketObjectStatus]
{
    def write (kryo: Kryo, output: Output, obj: MarketObjectStatus): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.status),
            () => writeList (obj.RegisteredResource, output),
            () => writeList (obj.TimeSeries, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketObjectStatus]): MarketObjectStatus =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketObjectStatus (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The type of a power system resource.
 *
 * @param PSRType [[ch.ninecode.model.PSRType PSRType]] Reference to the superclass object.
 * @param psrType The coded type of a power system resource.
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
final case class MktPSRType
(
    PSRType: PSRType = null,
    psrType: String = null,
    TimeSeries: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: PSRType = PSRType

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktPSRType.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MktPSRType.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MktPSRType.fields (position), x))
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
    CIMParseable[MktPSRType]
{
    override val fields: Array[String] = Array[String] (
        "psrType",
        "TimeSeries"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val psrType: Fielder = parse_element (element (cls, fields(0)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): MktPSRType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktPSRType (
            PSRType.parse (context),
            mask (psrType (), 0),
            masks (TimeSeries (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MktPSRType] = MktPSRTypeSerializer
}

object MktPSRTypeSerializer extends CIMSerializer[MktPSRType]
{
    def write (kryo: Kryo, output: Output, obj: MktPSRType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.psrType),
            () => writeList (obj.TimeSeries, output)
        )
        PSRTypeSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MktPSRType]): MktPSRType =
    {
        val parent = PSRTypeSerializer.read (kryo, input, classOf[PSRType])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MktPSRType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An identification of a time interval that may have a given resolution.
 *
 * @param Element Reference to the superclass object.
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
final case class Period
(
    Element: BasicElement = null,
    resolution: String = null,
    timeInterval: String = null,
    MarketDocument: List[String] = null,
    Point: List[String] = null,
    Reason: List[String] = null,
    TimeSeries: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Period.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Period.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Period.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Period.fields (position), x))
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
    CIMParseable[Period]
{
    override val fields: Array[String] = Array[String] (
        "resolution",
        "timeInterval",
        "MarketDocument",
        "Point",
        "Reason",
        "TimeSeries"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketDocument", "MarketDocument", "0..*", "0..*"),
        CIMRelationship ("Point", "Point", "0..*", "1"),
        CIMRelationship ("Reason", "Reason", "0..*", "0..*"),
        CIMRelationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val resolution: Fielder = parse_element (element (cls, fields(0)))
    val timeInterval: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Point: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Reason: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: CIMContext): Period =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[Period] = PeriodSerializer
}

object PeriodSerializer extends CIMSerializer[Period]
{
    def write (kryo: Kryo, output: Output, obj: Period): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.resolution),
            () => output.writeString (obj.timeInterval),
            () => writeList (obj.MarketDocument, output),
            () => writeList (obj.Point, output),
            () => writeList (obj.Reason, output),
            () => writeList (obj.TimeSeries, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Period]): Period =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Period (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An identification of a set of values beeing adressed within a specific interval of time.
 *
 * @param Element Reference to the superclass object.
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
final case class Point
(
    Element: BasicElement = null,
    position: Int = 0,
    quality: String = null,
    quantity: Double = 0.0,
    secondaryQuantity: Double = 0.0,
    AceTariffType: List[String] = null,
    FlowDirection: List[String] = null,
    Period: String = null,
    Price: List[String] = null,
    Quantity: List[String] = null,
    Reason: List[String] = null,
    TimeSeries: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Point.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Point.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Point.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Point.fields (position), x))
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
    CIMParseable[Point]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AceTariffType", "AceTariffType", "0..*", "0..*"),
        CIMRelationship ("FlowDirection", "FlowDirection", "0..*", "0..*"),
        CIMRelationship ("Period", "Period", "1", "0..*"),
        CIMRelationship ("Price", "Price", "0..*", "0..1"),
        CIMRelationship ("Quantity", "Quantity", "0..*", "0..*"),
        CIMRelationship ("Reason", "Reason", "0..*", "0..*"),
        CIMRelationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
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

    def parse (context: CIMContext): Point =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[Point] = PointSerializer
}

object PointSerializer extends CIMSerializer[Point]
{
    def write (kryo: Kryo, output: Output, obj: Point): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.position),
            () => output.writeString (obj.quality),
            () => output.writeDouble (obj.quantity),
            () => output.writeDouble (obj.secondaryQuantity),
            () => writeList (obj.AceTariffType, output),
            () => writeList (obj.FlowDirection, output),
            () => output.writeString (obj.Period),
            () => writeList (obj.Price, output),
            () => writeList (obj.Quantity, output),
            () => writeList (obj.Reason, output),
            () => writeList (obj.TimeSeries, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Point]): Point =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Point (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The cost corresponding to a specific measure and expressed in a currency.
 *
 * @param Element Reference to the superclass object.
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
final case class Price
(
    Element: BasicElement = null,
    amount: Double = 0.0,
    category: String = null,
    direction: String = null,
    Domain: List[String] = null,
    Point: String = null,
    TimeSeries: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Price.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Price.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Price.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Price.fields (position), x))
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
    CIMParseable[Price]
{
    override val fields: Array[String] = Array[String] (
        "amount",
        "category",
        "direction",
        "Domain",
        "Point",
        "TimeSeries"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Domain", "Domain", "0..*", "0..*"),
        CIMRelationship ("Point", "Point", "0..1", "0..*"),
        CIMRelationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val amount: Fielder = parse_element (element (cls, fields(0)))
    val category: Fielder = parse_element (element (cls, fields(1)))
    val direction: Fielder = parse_element (element (cls, fields(2)))
    val Domain: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Point: Fielder = parse_attribute (attribute (cls, fields(4)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: CIMContext): Price =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[Price] = PriceSerializer
}

object PriceSerializer extends CIMSerializer[Price]
{
    def write (kryo: Kryo, output: Output, obj: Price): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.amount),
            () => output.writeString (obj.category),
            () => output.writeString (obj.direction),
            () => writeList (obj.Domain, output),
            () => output.writeString (obj.Point),
            () => writeList (obj.TimeSeries, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Price]): Price =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Price (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The formal specification of a set of business transactions having the same business goal.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param classificationType The classification mechanism used to group a set of objects together within a business process.
 *        The grouping may be of a detailed or a summary nature.
 * @param processType The kind of business process.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
final case class Process
(
    IdentifiedObject: IdentifiedObject = null,
    classificationType: String = null,
    processType: String = null,
    MarketDocument: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Process.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Process.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Process.fields (position), x))
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
    CIMParseable[Process]
{
    override val fields: Array[String] = Array[String] (
        "classificationType",
        "processType",
        "MarketDocument"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketDocument", "MarketDocument", "0..*", "0..*")
    )
    val classificationType: Fielder = parse_element (element (cls, fields(0)))
    val processType: Fielder = parse_element (element (cls, fields(1)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): Process =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Process (
            IdentifiedObject.parse (context),
            mask (classificationType (), 0),
            mask (processType (), 1),
            masks (MarketDocument (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Process] = ProcessSerializer
}

object ProcessSerializer extends CIMSerializer[Process]
{
    def write (kryo: Kryo, output: Output, obj: Process): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.classificationType),
            () => output.writeString (obj.processType),
            () => writeList (obj.MarketDocument, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Process]): Process =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Process (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Description of quantities needed in the data exchange.
 *
 * The type of the quantity is described either by the role of the association or the type attribute.
 * The quality attribute provides the information about the quality of the quantity (measured, estimated, etc.).
 *
 * @param Element Reference to the superclass object.
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
final case class Quantity
(
    Element: BasicElement = null,
    quality: String = null,
    quantity: Double = 0.0,
    `type`: String = null,
    Detail_Quantity: List[String] = null,
    Domain: List[String] = null,
    Point: List[String] = null,
    TimeSeries: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Quantity.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Quantity.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Quantity.fields (position), x))
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
    CIMParseable[Quantity]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Detail_Quantity", "Quantity", "0..*", "0..1"),
        CIMRelationship ("Domain", "Domain", "0..*", "0..*"),
        CIMRelationship ("Point", "Point", "0..*", "0..*"),
        CIMRelationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val quality: Fielder = parse_element (element (cls, fields(0)))
    val quantity: Fielder = parse_element (element (cls, fields(1)))
    val `type`: Fielder = parse_element (element (cls, fields(2)))
    val Detail_Quantity: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Domain: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Point: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: CIMContext): Quantity =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[Quantity] = QuantitySerializer
}

object QuantitySerializer extends CIMSerializer[Quantity]
{
    def write (kryo: Kryo, output: Output, obj: Quantity): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.quality),
            () => output.writeDouble (obj.quantity),
            () => output.writeString (obj.`type`),
            () => writeList (obj.Detail_Quantity, output),
            () => writeList (obj.Domain, output),
            () => writeList (obj.Point, output),
            () => writeList (obj.TimeSeries, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Quantity]): Quantity =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Quantity (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The motivation of an act.
 *
 * @param Element Reference to the superclass object.
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
final case class Reason
(
    Element: BasicElement = null,
    code: String = null,
    text: String = null,
    MarketDocument: List[String] = null,
    Period: List[String] = null,
    Point: List[String] = null,
    RegisteredResource: List[String] = null,
    TimeSeries: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Reason.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Reason.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Reason.fields (position), x))
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
    CIMParseable[Reason]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketDocument", "MarketDocument", "0..*", "0..*"),
        CIMRelationship ("Period", "Period", "0..*", "0..*"),
        CIMRelationship ("Point", "Point", "0..*", "0..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*"),
        CIMRelationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val code: Fielder = parse_element (element (cls, fields(0)))
    val text: Fielder = parse_element (element (cls, fields(1)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Period: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Point: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: CIMContext): Reason =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[Reason] = ReasonSerializer
}

object ReasonSerializer extends CIMSerializer[Reason]
{
    def write (kryo: Kryo, output: Output, obj: Reason): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.code),
            () => output.writeString (obj.text),
            () => writeList (obj.MarketDocument, output),
            () => writeList (obj.Period, output),
            () => writeList (obj.Point, output),
            () => writeList (obj.RegisteredResource, output),
            () => writeList (obj.TimeSeries, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Reason]): Reason =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Reason (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A set of similar physical or conceptual objects defined for the same period or point of time.
 *
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] Reference to the superclass object.
 * @param lastUpdateDate The date of the last update related to this market object.
 * @param methodType Type of method used in the business process related to this Series, e.g. metering method.
 * @param registrationDate For a market object, the date of registration of a contract, e.g. the date of change of supplier for a customer.
 * @param SelfSeries [[ch.ninecode.model.Series Series]] <em>undocumented</em>
 * @param Series_attr [[ch.ninecode.model.Series Series]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
final case class Series
(
    TimeSeries: TimeSeries = null,
    lastUpdateDate: String = null,
    methodType: String = null,
    registrationDate: String = null,
    SelfSeries: List[String] = null,
    Series_attr: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: TimeSeries = TimeSeries

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Series.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Series.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Series.fields (position), x))
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
    CIMParseable[Series]
{
    override val fields: Array[String] = Array[String] (
        "lastUpdateDate",
        "methodType",
        "registrationDate",
        "SelfSeries",
        "Series"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SelfSeries", "Series", "0..*", "0..*"),
        CIMRelationship ("Series_attr", "Series", "0..*", "0..*")
    )
    val lastUpdateDate: Fielder = parse_element (element (cls, fields(0)))
    val methodType: Fielder = parse_element (element (cls, fields(1)))
    val registrationDate: Fielder = parse_element (element (cls, fields(2)))
    val SelfSeries: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Series_attr: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): Series =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[Series] = SeriesSerializer
}

object SeriesSerializer extends CIMSerializer[Series]
{
    def write (kryo: Kryo, output: Output, obj: Series): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.lastUpdateDate),
            () => output.writeString (obj.methodType),
            () => output.writeString (obj.registrationDate),
            () => writeList (obj.SelfSeries, output),
            () => writeList (obj.Series_attr, output)
        )
        TimeSeriesSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Series]): Series =
    {
        val parent = TimeSeriesSerializer.read (kryo, input, classOf[TimeSeries])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Series (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A set of regular time-ordered measurements or values of quantitative nature of an individual or collective phenomenon taken at successive, in most cases equidistant, periods / points of time.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
final case class TimeSeries
(
    IdentifiedObject: IdentifiedObject = null,
    businessType: String = null,
    cancelledTS: String = null,
    curveType: String = null,
    objectAggregation: String = null,
    product: String = null,
    version: String = null,
    AttributeInstanceComponent: List[String] = null,
    Auction: List[String] = null,
    ConstraintDuration: List[String] = null,
    DateAndOrTime: List[String] = null,
    Domain: List[String] = null,
    EnvironmentalMonitoringStation: List[String] = null,
    FlowDirection: List[String] = null,
    MarketDocument: List[String] = null,
    MarketEvaluationPoint: List[String] = null,
    MarketObjectStatus: List[String] = null,
    MarketParticipant: List[String] = null,
    MktPSRType: List[String] = null,
    Period: List[String] = null,
    Point: List[String] = null,
    Price: List[String] = null,
    Quantity: List[String] = null,
    Reason: List[String] = null,
    RegisteredResource: List[String] = null,
    Unit: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TimeSeries.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TimeSeries.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TimeSeries.fields (position), x))
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
    CIMParseable[TimeSeries]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AttributeInstanceComponent", "AttributeInstanceComponent", "0..*", "0..*"),
        CIMRelationship ("Auction", "Auction", "0..*", "0..*"),
        CIMRelationship ("ConstraintDuration", "ConstraintDuration", "0..*", "0..*"),
        CIMRelationship ("DateAndOrTime", "DateAndOrTime", "0..*", "0..*"),
        CIMRelationship ("Domain", "Domain", "0..*", "0..*"),
        CIMRelationship ("EnvironmentalMonitoringStation", "EnvironmentalMonitoringStation", "0..*", "0..*"),
        CIMRelationship ("FlowDirection", "FlowDirection", "0..*", "0..*"),
        CIMRelationship ("MarketDocument", "MarketDocument", "0..*", "0..*"),
        CIMRelationship ("MarketEvaluationPoint", "MarketEvaluationPoint", "0..*", "0..*"),
        CIMRelationship ("MarketObjectStatus", "MarketObjectStatus", "0..*", "0..*"),
        CIMRelationship ("MarketParticipant", "MarketParticipant", "0..*", "0..*"),
        CIMRelationship ("MktPSRType", "MktPSRType", "0..*", "0..*"),
        CIMRelationship ("Period", "Period", "0..*", "0..*"),
        CIMRelationship ("Point", "Point", "0..*", "0..*"),
        CIMRelationship ("Price", "Price", "0..*", "0..*"),
        CIMRelationship ("Quantity", "Quantity", "0..*", "0..*"),
        CIMRelationship ("Reason", "Reason", "0..*", "0..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*"),
        CIMRelationship ("Unit", "Unit_", "0..*", "0..*")
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

    def parse (context: CIMContext): TimeSeries =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[TimeSeries] = TimeSeriesSerializer
}

object TimeSeriesSerializer extends CIMSerializer[TimeSeries]
{
    def write (kryo: Kryo, output: Output, obj: TimeSeries): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.businessType),
            () => output.writeString (obj.cancelledTS),
            () => output.writeString (obj.curveType),
            () => output.writeString (obj.objectAggregation),
            () => output.writeString (obj.product),
            () => output.writeString (obj.version),
            () => writeList (obj.AttributeInstanceComponent, output),
            () => writeList (obj.Auction, output),
            () => writeList (obj.ConstraintDuration, output),
            () => writeList (obj.DateAndOrTime, output),
            () => writeList (obj.Domain, output),
            () => writeList (obj.EnvironmentalMonitoringStation, output),
            () => writeList (obj.FlowDirection, output),
            () => writeList (obj.MarketDocument, output),
            () => writeList (obj.MarketEvaluationPoint, output),
            () => writeList (obj.MarketObjectStatus, output),
            () => writeList (obj.MarketParticipant, output),
            () => writeList (obj.MktPSRType, output),
            () => writeList (obj.Period, output),
            () => writeList (obj.Point, output),
            () => writeList (obj.Price, output),
            () => writeList (obj.Quantity, output),
            () => writeList (obj.Reason, output),
            () => writeList (obj.RegisteredResource, output),
            () => writeList (obj.Unit, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TimeSeries]): TimeSeries =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TimeSeries (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) readList (input) else null,
            if (isSet (12)) readList (input) else null,
            if (isSet (13)) readList (input) else null,
            if (isSet (14)) readList (input) else null,
            if (isSet (15)) readList (input) else null,
            if (isSet (16)) readList (input) else null,
            if (isSet (17)) readList (input) else null,
            if (isSet (18)) readList (input) else null,
            if (isSet (19)) readList (input) else null,
            if (isSet (20)) readList (input) else null,
            if (isSet (21)) readList (input) else null,
            if (isSet (22)) readList (input) else null,
            if (isSet (23)) readList (input) else null,
            if (isSet (24)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The identification of the unit name for the time series quantities.
 *
 * @param Element Reference to the superclass object.
 * @param name The coded representation of the unit.
 * @param AceTariffType [[ch.ninecode.model.AceTariffType AceTariffType]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
final case class Unit_
(
    Element: BasicElement = null,
    name: String = null,
    AceTariffType: List[String] = null,
    TimeSeries: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Unit_.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Unit_.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Unit_.fields (position), x))
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
    CIMParseable[Unit_]
{
    override val fields: Array[String] = Array[String] (
        "name",
        "AceTariffType",
        "TimeSeries"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AceTariffType", "AceTariffType", "0..*", "0..*"),
        CIMRelationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val name: Fielder = parse_element (element (cls, fields(0)))
    val AceTariffType: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): Unit_ =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Unit_ (
            BasicElement.parse (context),
            mask (name (), 0),
            masks (AceTariffType (), 1),
            masks (TimeSeries (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Unit_] = Unit_Serializer
}

object Unit_Serializer extends CIMSerializer[Unit_]
{
    def write (kryo: Kryo, output: Output, obj: Unit_): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.name),
            () => writeList (obj.AceTariffType, output),
            () => writeList (obj.TimeSeries, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Unit_]): Unit_ =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Unit_ (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _MarketManagement
{
    def register: List[CIMClassInfo] =
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