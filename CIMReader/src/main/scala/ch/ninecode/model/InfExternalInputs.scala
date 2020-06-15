package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Requirements for minimum amount of reserve and/or regulation to be supplied by a set of qualified resources.
 *
 * @param ResourceGroupReq [[ch.ninecode.model.ResourceGroupReq ResourceGroupReq]] Reference to the superclass object.
 * @param MarketProduct [[ch.ninecode.model.MarketProduct MarketProduct]] Market product associated with reserve requirement must be a reserve or regulation product.
 * @param ReserveReqCurve [[ch.ninecode.model.ReserveReqCurve ReserveReqCurve]] <em>undocumented</em>
 * @param SensitivityPriceCurve [[ch.ninecode.model.SensitivityPriceCurve SensitivityPriceCurve]] <em>undocumented</em>
 * @group InfExternalInputs
 * @groupname InfExternalInputs Package InfExternalInputs
 */
final case class ReserveReq
(
    ResourceGroupReq: ResourceGroupReq = null,
    MarketProduct: String = null,
    ReserveReqCurve: String = null,
    SensitivityPriceCurve: String = null
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
    override def sup: ResourceGroupReq = ResourceGroupReq

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
        implicit val clz: String = ReserveReq.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ReserveReq.fields (position), value)
        emitattr (0, MarketProduct)
        emitattr (1, ReserveReqCurve)
        emitattr (2, SensitivityPriceCurve)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ReserveReq rdf:ID=\"%s\">\n%s\t</cim:ReserveReq>".format (id, export_fields)
    }
}

object ReserveReq
extends
    CIMParseable[ReserveReq]
{
    override val fields: Array[String] = Array[String] (
        "MarketProduct",
        "ReserveReqCurve",
        "SensitivityPriceCurve"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketProduct", "MarketProduct", "1", "0..*"),
        CIMRelationship ("ReserveReqCurve", "ReserveReqCurve", "1", "1"),
        CIMRelationship ("SensitivityPriceCurve", "SensitivityPriceCurve", "0..1", "0..1")
    )
    val MarketProduct: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ReserveReqCurve: Fielder = parse_attribute (attribute (cls, fields(1)))
    val SensitivityPriceCurve: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): ReserveReq =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ReserveReq (
            ResourceGroupReq.parse (context),
            mask (MarketProduct (), 0),
            mask (ReserveReqCurve (), 1),
            mask (SensitivityPriceCurve (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ReserveReqSerializer extends CIMSerializer[ReserveReq]
{
    def write (kryo: Kryo, output: Output, obj: ReserveReq): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.MarketProduct),
            () => output.writeString (obj.ReserveReqCurve),
            () => output.writeString (obj.SensitivityPriceCurve)
        )
        ResourceGroupReqSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ReserveReq]): ReserveReq =
    {
        val parent = ResourceGroupReqSerializer.read (kryo, input, classOf[ResourceGroupReq])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ReserveReq (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A curve relating  reserve requirement versus time, showing the values of a specific reserve requirement for each unit of the period covered.
 *
 * The  curve can be based on "absolute" time or on "normalized' time.
 * X is time, typically expressed in absolute time
 * Y1 is reserve requirement, typically expressed in MW
 *
 * @param Curve [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param ReserveReq [[ch.ninecode.model.ReserveReq ReserveReq]] <em>undocumented</em>
 * @group InfExternalInputs
 * @groupname InfExternalInputs Package InfExternalInputs
 */
final case class ReserveReqCurve
(
    Curve: Curve = null,
    ReserveReq: String = null
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
    override def sup: Curve = Curve

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
        implicit val clz: String = ReserveReqCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ReserveReqCurve.fields (position), value)
        emitattr (0, ReserveReq)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ReserveReqCurve rdf:ID=\"%s\">\n%s\t</cim:ReserveReqCurve>".format (id, export_fields)
    }
}

object ReserveReqCurve
extends
    CIMParseable[ReserveReqCurve]
{
    override val fields: Array[String] = Array[String] (
        "ReserveReq"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ReserveReq", "ReserveReq", "1", "1")
    )
    val ReserveReq: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): ReserveReqCurve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ReserveReqCurve (
            Curve.parse (context),
            mask (ReserveReq (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ReserveReqCurveSerializer extends CIMSerializer[ReserveReqCurve]
{
    def write (kryo: Kryo, output: Output, obj: ReserveReqCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ReserveReq)
        )
        CurveSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ReserveReqCurve]): ReserveReqCurve =
    {
        val parent = CurveSerializer.read (kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ReserveReqCurve (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A logical grouping of resources that are used to model location of types of requirements for ancillary services such as spinning reserve zones, regulation zones, etc.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status Status of this group.
 * @param type Type of this group.
 * @param RegisteredResources [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param ResourceGroupReqs [[ch.ninecode.model.ResourceGroupReq ResourceGroupReq]] <em>undocumented</em>
 * @group InfExternalInputs
 * @groupname InfExternalInputs Package InfExternalInputs
 */
final case class ResourceGroup
(
    IdentifiedObject: IdentifiedObject = null,
    status: String = null,
    `type`: String = null,
    RegisteredResources: List[String] = null,
    ResourceGroupReqs: List[String] = null
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
        implicit val clz: String = ResourceGroup.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourceGroup.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceGroup.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ResourceGroup.fields (position), x))
        emitattr (0, status)
        emitelem (1, `type`)
        emitattrs (2, RegisteredResources)
        emitattrs (3, ResourceGroupReqs)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceGroup rdf:ID=\"%s\">\n%s\t</cim:ResourceGroup>".format (id, export_fields)
    }
}

object ResourceGroup
extends
    CIMParseable[ResourceGroup]
{
    override val fields: Array[String] = Array[String] (
        "status",
        "type",
        "RegisteredResources",
        "ResourceGroupReqs"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredResources", "RegisteredResource", "1..*", "0..*"),
        CIMRelationship ("ResourceGroupReqs", "ResourceGroupReq", "0..*", "1")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val `type`: Fielder = parse_element (element (cls, fields(1)))
    val RegisteredResources: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ResourceGroupReqs: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): ResourceGroup =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ResourceGroup (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            mask (`type` (), 1),
            masks (RegisteredResources (), 2),
            masks (ResourceGroupReqs (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ResourceGroupSerializer extends CIMSerializer[ResourceGroup]
{
    def write (kryo: Kryo, output: Output, obj: ResourceGroup): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.status),
            () => output.writeString (obj.`type`),
            () => writeList (obj.RegisteredResources, output),
            () => writeList (obj.ResourceGroupReqs, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ResourceGroup]): ResourceGroup =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ResourceGroup (
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
 * Ancillary service requirements for a market.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param RTOs [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param ResourceGroup [[ch.ninecode.model.ResourceGroup ResourceGroup]] <em>undocumented</em>
 * @group InfExternalInputs
 * @groupname InfExternalInputs Package InfExternalInputs
 */
final case class ResourceGroupReq
(
    IdentifiedObject: IdentifiedObject = null,
    RTOs: List[String] = null,
    ResourceGroup: String = null
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
        implicit val clz: String = ResourceGroupReq.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceGroupReq.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ResourceGroupReq.fields (position), x))
        emitattrs (0, RTOs)
        emitattr (1, ResourceGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceGroupReq rdf:ID=\"%s\">\n%s\t</cim:ResourceGroupReq>".format (id, export_fields)
    }
}

object ResourceGroupReq
extends
    CIMParseable[ResourceGroupReq]
{
    override val fields: Array[String] = Array[String] (
        "RTOs",
        "ResourceGroup"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RTOs", "RTO", "0..*", "0..*"),
        CIMRelationship ("ResourceGroup", "ResourceGroup", "1", "0..*")
    )
    val RTOs: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ResourceGroup: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): ResourceGroupReq =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ResourceGroupReq (
            IdentifiedObject.parse (context),
            masks (RTOs (), 0),
            mask (ResourceGroup (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ResourceGroupReqSerializer extends CIMSerializer[ResourceGroupReq]
{
    def write (kryo: Kryo, output: Output, obj: ResourceGroupReq): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.RTOs, output),
            () => output.writeString (obj.ResourceGroup)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ResourceGroupReq]): ResourceGroupReq =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ResourceGroupReq (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Optionally, this curve expresses elasticity of the associated requirement.
 *
 * For example, used to reduce requirements when clearing price exceeds reasonable values when the supply quantity becomes scarce. For example, a single point value of \$1000/MW for a spinning reserve will cause a reduction in the required spinning reserve.
 * X axis is constrained quantity (e.g., MW)
 * Y1 axis is money per constrained quantity
 *
 * @param Curve [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param ReserveReq [[ch.ninecode.model.ReserveReq ReserveReq]] <em>undocumented</em>
 * @group InfExternalInputs
 * @groupname InfExternalInputs Package InfExternalInputs
 */
final case class SensitivityPriceCurve
(
    Curve: Curve = null,
    ReserveReq: String = null
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
    override def sup: Curve = Curve

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
        implicit val clz: String = SensitivityPriceCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SensitivityPriceCurve.fields (position), value)
        emitattr (0, ReserveReq)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SensitivityPriceCurve rdf:ID=\"%s\">\n%s\t</cim:SensitivityPriceCurve>".format (id, export_fields)
    }
}

object SensitivityPriceCurve
extends
    CIMParseable[SensitivityPriceCurve]
{
    override val fields: Array[String] = Array[String] (
        "ReserveReq"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ReserveReq", "ReserveReq", "0..1", "0..1")
    )
    val ReserveReq: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): SensitivityPriceCurve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SensitivityPriceCurve (
            Curve.parse (context),
            mask (ReserveReq (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SensitivityPriceCurveSerializer extends CIMSerializer[SensitivityPriceCurve]
{
    def write (kryo: Kryo, output: Output, obj: SensitivityPriceCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ReserveReq)
        )
        CurveSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SensitivityPriceCurve]): SensitivityPriceCurve =
    {
        val parent = CurveSerializer.read (kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SensitivityPriceCurve (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfExternalInputs
{
    def register: List[CIMClassInfo] =
    {
        List (
            ReserveReq.register,
            ReserveReqCurve.register,
            ResourceGroup.register,
            ResourceGroupReq.register,
            SensitivityPriceCurve.register
        )
    }
}