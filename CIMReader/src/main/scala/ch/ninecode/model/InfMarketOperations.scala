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
 * Bilateral transaction
 *
 * @param Element Reference to the superclass object.
 * @param curtailTimeMax Maximum curtailment time in number of trading intervals
 * @param curtailTimeMin Minimum curtailment time in number of trading intervals
 * @param marketType Market type (default=DA)
 *        DA - Day Ahead
 *        RT - Real Time
 *        HA - Hour Ahead
 * @param purchaseTimeMax Maximum purchase time in number of trading intervals
 * @param purchaseTimeMin Minimum purchase time in number of trading intervals
 * @param scope Transaction scope:
 *        'Internal' (default)
 *        'External'
 * @param totalTranChargeMax Maximum total transmission (congestion) charges in monetary units
 * @param transactionType Transaction type (default 1)
 *        1 - Fixed
 *        2 - Dispatchable continuous
 *        3 - Dispatchable block-loading
 * @group InfMarketOperations
 * @groupname InfMarketOperations Package InfMarketOperations
 */
final case class BilateralTransaction
(
    Element: BasicElement = null,
    curtailTimeMax: Int = 0,
    curtailTimeMin: Int = 0,
    marketType: String = null,
    purchaseTimeMax: Int = 0,
    purchaseTimeMin: Int = 0,
    scope: String = null,
    totalTranChargeMax: Double = 0.0,
    transactionType: String = null
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
        implicit val clz: String = BilateralTransaction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BilateralTransaction.fields (position), value)
        emitelem (0, curtailTimeMax)
        emitelem (1, curtailTimeMin)
        emitelem (2, marketType)
        emitelem (3, purchaseTimeMax)
        emitelem (4, purchaseTimeMin)
        emitelem (5, scope)
        emitelem (6, totalTranChargeMax)
        emitelem (7, transactionType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BilateralTransaction rdf:%s=\"%s\">\n%s\t</cim:BilateralTransaction>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object BilateralTransaction
extends
    CIMParseable[BilateralTransaction]
{
    override val fields: Array[String] = Array[String] (
        "curtailTimeMax",
        "curtailTimeMin",
        "marketType",
        "purchaseTimeMax",
        "purchaseTimeMin",
        "scope",
        "totalTranChargeMax",
        "transactionType"
    )
    val curtailTimeMax: Fielder = parse_element (element (cls, fields(0)))
    val curtailTimeMin: Fielder = parse_element (element (cls, fields(1)))
    val marketType: Fielder = parse_element (element (cls, fields(2)))
    val purchaseTimeMax: Fielder = parse_element (element (cls, fields(3)))
    val purchaseTimeMin: Fielder = parse_element (element (cls, fields(4)))
    val scope: Fielder = parse_element (element (cls, fields(5)))
    val totalTranChargeMax: Fielder = parse_element (element (cls, fields(6)))
    val transactionType: Fielder = parse_element (element (cls, fields(7)))

    def parse (context: CIMContext): BilateralTransaction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BilateralTransaction (
            BasicElement.parse (context),
            toInteger (mask (curtailTimeMax (), 0)),
            toInteger (mask (curtailTimeMin (), 1)),
            mask (marketType (), 2),
            toInteger (mask (purchaseTimeMax (), 3)),
            toInteger (mask (purchaseTimeMin (), 4)),
            mask (scope (), 5),
            toDouble (mask (totalTranChargeMax (), 6)),
            mask (transactionType (), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BilateralTransaction] = BilateralTransactionSerializer
}

object BilateralTransactionSerializer extends CIMSerializer[BilateralTransaction]
{
    def write (kryo: Kryo, output: Output, obj: BilateralTransaction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.curtailTimeMax),
            () => output.writeInt (obj.curtailTimeMin),
            () => output.writeString (obj.marketType),
            () => output.writeInt (obj.purchaseTimeMax),
            () => output.writeInt (obj.purchaseTimeMin),
            () => output.writeString (obj.scope),
            () => output.writeDouble (obj.totalTranChargeMax),
            () => output.writeString (obj.transactionType)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BilateralTransaction]): BilateralTransaction =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BilateralTransaction (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readInt else 0,
            if (isSet (4)) input.readInt else 0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Participation level of a given Pnode in a given AggregatePnode.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param factor Used to calculate "participation" of Pnode in an AggregatePnode.
 *        For example, for regulation region this factor is 1 and total sum of all factors for a specific regulation region does not have to be 1. For pricing zone the total sum of all factors has to be 1.
 * @group InfMarketOperations
 * @groupname InfMarketOperations Package InfMarketOperations
 */
final case class Participation
(
    IdentifiedObject: IdentifiedObject = null,
    factor: Double = 0.0
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
        implicit val clz: String = Participation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Participation.fields (position), value)
        emitelem (0, factor)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Participation rdf:%s=\"%s\">\n%s\t</cim:Participation>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Participation
extends
    CIMParseable[Participation]
{
    override val fields: Array[String] = Array[String] (
        "factor"
    )
    val factor: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): Participation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Participation (
            IdentifiedObject.parse (context),
            toDouble (mask (factor (), 0))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Participation] = ParticipationSerializer
}

object ParticipationSerializer extends CIMSerializer[Participation]
{
    def write (kryo: Kryo, output: Output, obj: Participation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.factor)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Participation]): Participation =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Participation (
            parent,
            if (isSet (0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This class represent the resource certification for a specific product type.
 *
 * For example, a resource is certified for Non-Spinning reserve for RTM.
 *
 * @param Element Reference to the superclass object.
 * @param certifiedDAM <em>undocumented</em>
 * @param certifiedNonspinDAM <em>undocumented</em>
 * @param certifiedNonspinDAMMw <em>undocumented</em>
 * @param certifiedNonspinRTM <em>undocumented</em>
 * @param certifiedNonspinRTMMw <em>undocumented</em>
 * @param certifiedPIRP <em>undocumented</em>
 * @param certifiedRTM <em>undocumented</em>
 * @param certifiedRUC <em>undocumented</em>
 * @param certifiedRegulation <em>undocumented</em>
 * @param certifiedRegulationMw <em>undocumented</em>
 * @param certifiedReplaceAS <em>undocumented</em>
 * @param certifiedSpin <em>undocumented</em>
 * @param certifiedSpinMw <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group InfMarketOperations
 * @groupname InfMarketOperations Package InfMarketOperations
 */
final case class ResourceCertification2
(
    Element: BasicElement = null,
    certifiedDAM: String = null,
    certifiedNonspinDAM: String = null,
    certifiedNonspinDAMMw: Double = 0.0,
    certifiedNonspinRTM: String = null,
    certifiedNonspinRTMMw: Double = 0.0,
    certifiedPIRP: String = null,
    certifiedRTM: String = null,
    certifiedRUC: String = null,
    certifiedRegulation: String = null,
    certifiedRegulationMw: Double = 0.0,
    certifiedReplaceAS: String = null,
    certifiedSpin: String = null,
    certifiedSpinMw: Double = 0.0,
    RegisteredResource: List[String] = null
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
        implicit val clz: String = ResourceCertification2.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourceCertification2.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceCertification2.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ResourceCertification2.fields (position), x))
        emitattr (0, certifiedDAM)
        emitattr (1, certifiedNonspinDAM)
        emitelem (2, certifiedNonspinDAMMw)
        emitattr (3, certifiedNonspinRTM)
        emitelem (4, certifiedNonspinRTMMw)
        emitattr (5, certifiedPIRP)
        emitattr (6, certifiedRTM)
        emitattr (7, certifiedRUC)
        emitattr (8, certifiedRegulation)
        emitelem (9, certifiedRegulationMw)
        emitattr (10, certifiedReplaceAS)
        emitattr (11, certifiedSpin)
        emitelem (12, certifiedSpinMw)
        emitattrs (13, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceCertification2 rdf:%s=\"%s\">\n%s\t</cim:ResourceCertification2>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ResourceCertification2
extends
    CIMParseable[ResourceCertification2]
{
    override val fields: Array[String] = Array[String] (
        "certifiedDAM",
        "certifiedNonspinDAM",
        "certifiedNonspinDAMMw",
        "certifiedNonspinRTM",
        "certifiedNonspinRTMMw",
        "certifiedPIRP",
        "certifiedRTM",
        "certifiedRUC",
        "certifiedRegulation",
        "certifiedRegulationMw",
        "certifiedReplaceAS",
        "certifiedSpin",
        "certifiedSpinMw",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*")
    )
    val certifiedDAM: Fielder = parse_attribute (attribute (cls, fields(0)))
    val certifiedNonspinDAM: Fielder = parse_attribute (attribute (cls, fields(1)))
    val certifiedNonspinDAMMw: Fielder = parse_element (element (cls, fields(2)))
    val certifiedNonspinRTM: Fielder = parse_attribute (attribute (cls, fields(3)))
    val certifiedNonspinRTMMw: Fielder = parse_element (element (cls, fields(4)))
    val certifiedPIRP: Fielder = parse_attribute (attribute (cls, fields(5)))
    val certifiedRTM: Fielder = parse_attribute (attribute (cls, fields(6)))
    val certifiedRUC: Fielder = parse_attribute (attribute (cls, fields(7)))
    val certifiedRegulation: Fielder = parse_attribute (attribute (cls, fields(8)))
    val certifiedRegulationMw: Fielder = parse_element (element (cls, fields(9)))
    val certifiedReplaceAS: Fielder = parse_attribute (attribute (cls, fields(10)))
    val certifiedSpin: Fielder = parse_attribute (attribute (cls, fields(11)))
    val certifiedSpinMw: Fielder = parse_element (element (cls, fields(12)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(13)))

    def parse (context: CIMContext): ResourceCertification2 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ResourceCertification2 (
            BasicElement.parse (context),
            mask (certifiedDAM (), 0),
            mask (certifiedNonspinDAM (), 1),
            toDouble (mask (certifiedNonspinDAMMw (), 2)),
            mask (certifiedNonspinRTM (), 3),
            toDouble (mask (certifiedNonspinRTMMw (), 4)),
            mask (certifiedPIRP (), 5),
            mask (certifiedRTM (), 6),
            mask (certifiedRUC (), 7),
            mask (certifiedRegulation (), 8),
            toDouble (mask (certifiedRegulationMw (), 9)),
            mask (certifiedReplaceAS (), 10),
            mask (certifiedSpin (), 11),
            toDouble (mask (certifiedSpinMw (), 12)),
            masks (RegisteredResource (), 13)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ResourceCertification2] = ResourceCertification2Serializer
}

object ResourceCertification2Serializer extends CIMSerializer[ResourceCertification2]
{
    def write (kryo: Kryo, output: Output, obj: ResourceCertification2): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.certifiedDAM),
            () => output.writeString (obj.certifiedNonspinDAM),
            () => output.writeDouble (obj.certifiedNonspinDAMMw),
            () => output.writeString (obj.certifiedNonspinRTM),
            () => output.writeDouble (obj.certifiedNonspinRTMMw),
            () => output.writeString (obj.certifiedPIRP),
            () => output.writeString (obj.certifiedRTM),
            () => output.writeString (obj.certifiedRUC),
            () => output.writeString (obj.certifiedRegulation),
            () => output.writeDouble (obj.certifiedRegulationMw),
            () => output.writeString (obj.certifiedReplaceAS),
            () => output.writeString (obj.certifiedSpin),
            () => output.writeDouble (obj.certifiedSpinMw),
            () => writeList (obj.RegisteredResource, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ResourceCertification2]): ResourceCertification2 =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ResourceCertification2 (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readDouble else 0.0,
            if (isSet (13)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfMarketOperations
{
    def register: List[CIMClassInfo] =
    {
        List (
            BilateralTransaction.register,
            Participation.register,
            ResourceCertification2.register
        )
    }
}