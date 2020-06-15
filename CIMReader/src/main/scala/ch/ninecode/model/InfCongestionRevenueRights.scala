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
 * Financial Transmission Rights (FTR) regarding transmission capacity at a flowgate.
 *
 * @param Agreement [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @param action Buy, Sell
 * @param baseEnergy Quantity, typically MWs - Seller owns all rights being offered, MWs over time on same Point of Receipt, Point of Delivery, or Resource.
 * @param class Peak, Off-peak, 24-hour
 * @param ftrType Type of rights being offered (product) allowed to be auctioned (option, obligation).
 * @param optimized Fixed (covers re-configuration, grandfathering) or Optimized (up for sale/purchase
 * @param EnergyPriceCurve [[ch.ninecode.model.EnergyPriceCurve EnergyPriceCurve]] <em>undocumented</em>
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param Pnodes [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @group InfCongestionRevenueRights
 * @groupname InfCongestionRevenueRights Package InfCongestionRevenueRights
 */
final case class FTR
(
    Agreement: Agreement = null,
    action: String = null,
    baseEnergy: Double = 0.0,
    `class`: String = null,
    ftrType: String = null,
    optimized: String = null,
    EnergyPriceCurve: String = null,
    Flowgate: String = null,
    Pnodes: List[String] = null
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
    override def sup: Agreement = Agreement

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
        implicit val clz: String = FTR.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FTR.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FTR.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (FTR.fields (position), x))
        emitelem (0, action)
        emitelem (1, baseEnergy)
        emitelem (2, `class`)
        emitelem (3, ftrType)
        emitelem (4, optimized)
        emitattr (5, EnergyPriceCurve)
        emitattr (6, Flowgate)
        emitattrs (7, Pnodes)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FTR rdf:ID=\"%s\">\n%s\t</cim:FTR>".format (id, export_fields)
    }
}

object FTR
extends
    CIMParseable[FTR]
{
    override val fields: Array[String] = Array[String] (
        "action",
        "baseEnergy",
        "class",
        "ftrType",
        "optimized",
        "EnergyPriceCurve",
        "Flowgate",
        "Pnodes"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnergyPriceCurve", "EnergyPriceCurve", "0..1", "0..*"),
        CIMRelationship ("Flowgate", "Flowgate", "0..1", "0..*"),
        CIMRelationship ("Pnodes", "Pnode", "0..*", "0..*")
    )
    val action: Fielder = parse_element (element (cls, fields(0)))
    val baseEnergy: Fielder = parse_element (element (cls, fields(1)))
    val `class`: Fielder = parse_element (element (cls, fields(2)))
    val ftrType: Fielder = parse_element (element (cls, fields(3)))
    val optimized: Fielder = parse_element (element (cls, fields(4)))
    val EnergyPriceCurve: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Pnodes: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: CIMContext): FTR =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FTR (
            Agreement.parse (context),
            mask (action (), 0),
            toDouble (mask (baseEnergy (), 1)),
            mask (`class` (), 2),
            mask (ftrType (), 3),
            mask (optimized (), 4),
            mask (EnergyPriceCurve (), 5),
            mask (Flowgate (), 6),
            masks (Pnodes (), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[FTR] = FTRSerializer
}

object FTRSerializer extends CIMSerializer[FTR]
{
    def write (kryo: Kryo, output: Output, obj: FTR): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.action),
            () => output.writeDouble (obj.baseEnergy),
            () => output.writeString (obj.`class`),
            () => output.writeString (obj.ftrType),
            () => output.writeString (obj.optimized),
            () => output.writeString (obj.EnergyPriceCurve),
            () => output.writeString (obj.Flowgate),
            () => writeList (obj.Pnodes, output)
        )
        AgreementSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FTR]): FTR =
    {
        val parent = AgreementSerializer.read (kryo, input, classOf[Agreement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FTR (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A type of limit that indicates if it is enforced and, through association, the organisation responsible for setting the limit.
 *
 * @param Limit [[ch.ninecode.model.Limit Limit]] Reference to the superclass object.
 * @param enforced True if limit is enforced.
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param MktMeasurement [[ch.ninecode.model.MktMeasurement MktMeasurement]] <em>undocumented</em>
 * @group InfCongestionRevenueRights
 * @groupname InfCongestionRevenueRights Package InfCongestionRevenueRights
 */
final case class ViolationLimit
(
    Limit: Limit = null,
    enforced: Boolean = false,
    Flowgate: String = null,
    MktMeasurement: String = null
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
    override def sup: Limit = Limit

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
        implicit val clz: String = ViolationLimit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ViolationLimit.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ViolationLimit.fields (position), value)
        emitelem (0, enforced)
        emitattr (1, Flowgate)
        emitattr (2, MktMeasurement)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ViolationLimit rdf:ID=\"%s\">\n%s\t</cim:ViolationLimit>".format (id, export_fields)
    }
}

object ViolationLimit
extends
    CIMParseable[ViolationLimit]
{
    override val fields: Array[String] = Array[String] (
        "enforced",
        "Flowgate",
        "MktMeasurement"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Flowgate", "Flowgate", "0..1", "0..*"),
        CIMRelationship ("MktMeasurement", "MktMeasurement", "0..1", "0..*")
    )
    val enforced: Fielder = parse_element (element (cls, fields(0)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MktMeasurement: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): ViolationLimit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ViolationLimit (
            Limit.parse (context),
            toBoolean (mask (enforced (), 0)),
            mask (Flowgate (), 1),
            mask (MktMeasurement (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ViolationLimit] = ViolationLimitSerializer
}

object ViolationLimitSerializer extends CIMSerializer[ViolationLimit]
{
    def write (kryo: Kryo, output: Output, obj: ViolationLimit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.enforced),
            () => output.writeString (obj.Flowgate),
            () => output.writeString (obj.MktMeasurement)
        )
        LimitSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ViolationLimit]): ViolationLimit =
    {
        val parent = LimitSerializer.read (kryo, input, classOf[Limit])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ViolationLimit (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfCongestionRevenueRights
{
    def register: List[CIMClassInfo] =
    {
        List (
            FTR.register,
            ViolationLimit.register
        )
    }
}