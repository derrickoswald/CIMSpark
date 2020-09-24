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
 * Models Market clearing results.
 *
 * Indicates market horizon, interval based. Used by a market quality system for billing and settlement purposes.
 *
 * @param Element Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param AllocationResultValues [[ch.ninecode.model.AllocationResultValues AllocationResultValues]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
final case class AllocationResult
(
    Element: BasicElement = null,
    intervalStartTime: String = null,
    updateTimeStamp: String = null,
    updateUser: String = null,
    AllocationResultValues: List[String] = null
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
        implicit val clz: String = AllocationResult.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AllocationResult.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AllocationResult.fields (position), x))
        emitelem (0, intervalStartTime)
        emitelem (1, updateTimeStamp)
        emitelem (2, updateUser)
        emitattrs (3, AllocationResultValues)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AllocationResult rdf:%s=\"%s\">\n%s\t</cim:AllocationResult>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object AllocationResult
extends
    CIMParseable[AllocationResult]
{
    override val fields: Array[String] = Array[String] (
        "intervalStartTime",
        "updateTimeStamp",
        "updateUser",
        "AllocationResultValues"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AllocationResultValues", "AllocationResultValues", "1..*", "1")
    )
    val intervalStartTime: Fielder = parse_element (element (cls, fields(0)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(1)))
    val updateUser: Fielder = parse_element (element (cls, fields(2)))
    val AllocationResultValues: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): AllocationResult =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AllocationResult (
            BasicElement.parse (context),
            mask (intervalStartTime (), 0),
            mask (updateTimeStamp (), 1),
            mask (updateUser (), 2),
            masks (AllocationResultValues (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AllocationResult] = AllocationResultSerializer
}

object AllocationResultSerializer extends CIMSerializer[AllocationResult]
{
    def write (kryo: Kryo, output: Output, obj: AllocationResult): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.intervalStartTime),
            () => output.writeString (obj.updateTimeStamp),
            () => output.writeString (obj.updateUser),
            () => writeList (obj.AllocationResultValues, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AllocationResult]): AllocationResult =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AllocationResult (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Models Market clearing results in terms of price and MW values.
 *
 * @param Element Reference to the superclass object.
 * @param aggregateType "1" --  "Detail",
 *        "2" --  "Aggregate by Market service type", in which case, the "AllocationEnergyType" field will not be filled;
 *        "3" --  "Aggregate by "AllocationEnergyType", in which case "MarketServiceType" will not be filled.
 * @param allocationMwHour <em>undocumented</em>
 * @param allocationPrice <em>undocumented</em>
 * @param energyTypeCode <em>undocumented</em>
 * @param marketServiceType Choices are:
 *        ME - Market Energy Capacity;
 *        SR - Spinning Reserve Capacity;
 *        NR - Non-Spinning Reserve Capacity;
 *        DAC - Day Ahead Capacity;
 *        DEC - Derate Capacity
 * @param AllocationResult [[ch.ninecode.model.AllocationResult AllocationResult]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
final case class AllocationResultValues
(
    Element: BasicElement = null,
    aggregateType: String = null,
    allocationMwHour: Double = 0.0,
    allocationPrice: Double = 0.0,
    energyTypeCode: String = null,
    marketServiceType: String = null,
    AllocationResult: String = null,
    RegisteredResource: String = null
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
        implicit val clz: String = AllocationResultValues.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AllocationResultValues.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AllocationResultValues.fields (position), value)
        emitelem (0, aggregateType)
        emitelem (1, allocationMwHour)
        emitelem (2, allocationPrice)
        emitelem (3, energyTypeCode)
        emitelem (4, marketServiceType)
        emitattr (5, AllocationResult)
        emitattr (6, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AllocationResultValues rdf:%s=\"%s\">\n%s\t</cim:AllocationResultValues>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object AllocationResultValues
extends
    CIMParseable[AllocationResultValues]
{
    override val fields: Array[String] = Array[String] (
        "aggregateType",
        "allocationMwHour",
        "allocationPrice",
        "energyTypeCode",
        "marketServiceType",
        "AllocationResult",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AllocationResult", "AllocationResult", "1", "1..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*")
    )
    val aggregateType: Fielder = parse_element (element (cls, fields(0)))
    val allocationMwHour: Fielder = parse_element (element (cls, fields(1)))
    val allocationPrice: Fielder = parse_element (element (cls, fields(2)))
    val energyTypeCode: Fielder = parse_element (element (cls, fields(3)))
    val marketServiceType: Fielder = parse_element (element (cls, fields(4)))
    val AllocationResult: Fielder = parse_attribute (attribute (cls, fields(5)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): AllocationResultValues =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AllocationResultValues (
            BasicElement.parse (context),
            mask (aggregateType (), 0),
            toDouble (mask (allocationMwHour (), 1)),
            toDouble (mask (allocationPrice (), 2)),
            mask (energyTypeCode (), 3),
            mask (marketServiceType (), 4),
            mask (AllocationResult (), 5),
            mask (RegisteredResource (), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AllocationResultValues] = AllocationResultValuesSerializer
}

object AllocationResultValuesSerializer extends CIMSerializer[AllocationResultValues]
{
    def write (kryo: Kryo, output: Output, obj: AllocationResultValues): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.aggregateType),
            () => output.writeDouble (obj.allocationMwHour),
            () => output.writeDouble (obj.allocationPrice),
            () => output.writeString (obj.energyTypeCode),
            () => output.writeString (obj.marketServiceType),
            () => output.writeString (obj.AllocationResult),
            () => output.writeString (obj.RegisteredResource)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AllocationResultValues]): AllocationResultValues =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AllocationResultValues (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Models Market clearing results for Auxiliary costs.
 *
 * @param Element Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param marketType <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param AuxillaryValues [[ch.ninecode.model.AuxiliaryValues AuxiliaryValues]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
final case class AuxiliaryCost
(
    Element: BasicElement = null,
    intervalStartTime: String = null,
    marketType: String = null,
    updateTimeStamp: String = null,
    updateUser: String = null,
    AuxillaryValues: List[String] = null
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
        implicit val clz: String = AuxiliaryCost.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AuxiliaryCost.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AuxiliaryCost.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AuxiliaryCost.fields (position), x))
        emitelem (0, intervalStartTime)
        emitattr (1, marketType)
        emitelem (2, updateTimeStamp)
        emitelem (3, updateUser)
        emitattrs (4, AuxillaryValues)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryCost rdf:%s=\"%s\">\n%s\t</cim:AuxiliaryCost>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object AuxiliaryCost
extends
    CIMParseable[AuxiliaryCost]
{
    override val fields: Array[String] = Array[String] (
        "intervalStartTime",
        "marketType",
        "updateTimeStamp",
        "updateUser",
        "AuxillaryValues"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AuxillaryValues", "AuxiliaryValues", "1..*", "1")
    )
    val intervalStartTime: Fielder = parse_element (element (cls, fields(0)))
    val marketType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(2)))
    val updateUser: Fielder = parse_element (element (cls, fields(3)))
    val AuxillaryValues: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): AuxiliaryCost =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AuxiliaryCost (
            BasicElement.parse (context),
            mask (intervalStartTime (), 0),
            mask (marketType (), 1),
            mask (updateTimeStamp (), 2),
            mask (updateUser (), 3),
            masks (AuxillaryValues (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AuxiliaryCost] = AuxiliaryCostSerializer
}

object AuxiliaryCostSerializer extends CIMSerializer[AuxiliaryCost]
{
    def write (kryo: Kryo, output: Output, obj: AuxiliaryCost): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.intervalStartTime),
            () => output.writeString (obj.marketType),
            () => output.writeString (obj.updateTimeStamp),
            () => output.writeString (obj.updateUser),
            () => writeList (obj.AuxillaryValues, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AuxiliaryCost]): AuxiliaryCost =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AuxiliaryCost (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Models Auxiliary Values.
 *
 * @param Element Reference to the superclass object.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @param RegisteredLoad [[ch.ninecode.model.RegisteredLoad RegisteredLoad]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
final case class AuxiliaryObject
(
    Element: BasicElement = null,
    RegisteredGenerator: String = null,
    RegisteredLoad: String = null
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
        implicit val clz: String = AuxiliaryObject.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AuxiliaryObject.fields (position), value)
        emitattr (0, RegisteredGenerator)
        emitattr (1, RegisteredLoad)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryObject rdf:%s=\"%s\">\n%s\t</cim:AuxiliaryObject>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object AuxiliaryObject
extends
    CIMParseable[AuxiliaryObject]
{
    override val fields: Array[String] = Array[String] (
        "RegisteredGenerator",
        "RegisteredLoad"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredGenerator", "RegisteredGenerator", "0..1", "0..*"),
        CIMRelationship ("RegisteredLoad", "RegisteredLoad", "0..1", "0..*")
    )
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RegisteredLoad: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): AuxiliaryObject =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AuxiliaryObject (
            BasicElement.parse (context),
            mask (RegisteredGenerator (), 0),
            mask (RegisteredLoad (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AuxiliaryObject] = AuxiliaryObjectSerializer
}

object AuxiliaryObjectSerializer extends CIMSerializer[AuxiliaryObject]
{
    def write (kryo: Kryo, output: Output, obj: AuxiliaryObject): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.RegisteredGenerator),
            () => output.writeString (obj.RegisteredLoad)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AuxiliaryObject]): AuxiliaryObject =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AuxiliaryObject (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Models Auxiliary Values.
 *
 * @param AuxiliaryObject [[ch.ninecode.model.AuxiliaryObject AuxiliaryObject]] Reference to the superclass object.
 * @param availUndispatchedQ <em>undocumented</em>
 * @param incrementalORAvail <em>undocumented</em>
 * @param maxExpostCapacity <em>undocumented</em>
 * @param minExpostCapacity <em>undocumented</em>
 * @param noLoadCost <em>undocumented</em>
 * @param noLoadCostEligibilityFlag <em>undocumented</em>
 * @param startUpCost <em>undocumented</em>
 * @param startUpCostEligibilityFlag <em>undocumented</em>
 * @param AuxillaryCost [[ch.ninecode.model.AuxiliaryCost AuxiliaryCost]] <em>undocumented</em>
 * @param FiveMinAuxillaryData [[ch.ninecode.model.FiveMinAuxiliaryData FiveMinAuxiliaryData]] <em>undocumented</em>
 * @param TenMinAuxillaryData [[ch.ninecode.model.TenMinAuxiliaryData TenMinAuxiliaryData]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
final case class AuxiliaryValues
(
    AuxiliaryObject: AuxiliaryObject = null,
    availUndispatchedQ: Double = 0.0,
    incrementalORAvail: Double = 0.0,
    maxExpostCapacity: Double = 0.0,
    minExpostCapacity: Double = 0.0,
    noLoadCost: Double = 0.0,
    noLoadCostEligibilityFlag: String = null,
    startUpCost: Double = 0.0,
    startUpCostEligibilityFlag: String = null,
    AuxillaryCost: String = null,
    FiveMinAuxillaryData: String = null,
    TenMinAuxillaryData: String = null
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
    override def sup: AuxiliaryObject = AuxiliaryObject

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
        implicit val clz: String = AuxiliaryValues.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AuxiliaryValues.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AuxiliaryValues.fields (position), value)
        emitelem (0, availUndispatchedQ)
        emitelem (1, incrementalORAvail)
        emitelem (2, maxExpostCapacity)
        emitelem (3, minExpostCapacity)
        emitelem (4, noLoadCost)
        emitattr (5, noLoadCostEligibilityFlag)
        emitelem (6, startUpCost)
        emitattr (7, startUpCostEligibilityFlag)
        emitattr (8, AuxillaryCost)
        emitattr (9, FiveMinAuxillaryData)
        emitattr (10, TenMinAuxillaryData)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryValues rdf:%s=\"%s\">\n%s\t</cim:AuxiliaryValues>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object AuxiliaryValues
extends
    CIMParseable[AuxiliaryValues]
{
    override val fields: Array[String] = Array[String] (
        "availUndispatchedQ",
        "incrementalORAvail",
        "maxExpostCapacity",
        "minExpostCapacity",
        "noLoadCost",
        "noLoadCostEligibilityFlag",
        "startUpCost",
        "startUpCostEligibilityFlag",
        "AuxillaryCost",
        "FiveMinAuxillaryData",
        "TenMinAuxillaryData"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AuxillaryCost", "AuxiliaryCost", "1", "1..*"),
        CIMRelationship ("FiveMinAuxillaryData", "FiveMinAuxiliaryData", "1", "1..*"),
        CIMRelationship ("TenMinAuxillaryData", "TenMinAuxiliaryData", "1", "1..*")
    )
    val availUndispatchedQ: Fielder = parse_element (element (cls, fields(0)))
    val incrementalORAvail: Fielder = parse_element (element (cls, fields(1)))
    val maxExpostCapacity: Fielder = parse_element (element (cls, fields(2)))
    val minExpostCapacity: Fielder = parse_element (element (cls, fields(3)))
    val noLoadCost: Fielder = parse_element (element (cls, fields(4)))
    val noLoadCostEligibilityFlag: Fielder = parse_attribute (attribute (cls, fields(5)))
    val startUpCost: Fielder = parse_element (element (cls, fields(6)))
    val startUpCostEligibilityFlag: Fielder = parse_attribute (attribute (cls, fields(7)))
    val AuxillaryCost: Fielder = parse_attribute (attribute (cls, fields(8)))
    val FiveMinAuxillaryData: Fielder = parse_attribute (attribute (cls, fields(9)))
    val TenMinAuxillaryData: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: CIMContext): AuxiliaryValues =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AuxiliaryValues (
            AuxiliaryObject.parse (context),
            toDouble (mask (availUndispatchedQ (), 0)),
            toDouble (mask (incrementalORAvail (), 1)),
            toDouble (mask (maxExpostCapacity (), 2)),
            toDouble (mask (minExpostCapacity (), 3)),
            toDouble (mask (noLoadCost (), 4)),
            mask (noLoadCostEligibilityFlag (), 5),
            toDouble (mask (startUpCost (), 6)),
            mask (startUpCostEligibilityFlag (), 7),
            mask (AuxillaryCost (), 8),
            mask (FiveMinAuxillaryData (), 9),
            mask (TenMinAuxillaryData (), 10)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AuxiliaryValues] = AuxiliaryValuesSerializer
}

object AuxiliaryValuesSerializer extends CIMSerializer[AuxiliaryValues]
{
    def write (kryo: Kryo, output: Output, obj: AuxiliaryValues): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.availUndispatchedQ),
            () => output.writeDouble (obj.incrementalORAvail),
            () => output.writeDouble (obj.maxExpostCapacity),
            () => output.writeDouble (obj.minExpostCapacity),
            () => output.writeDouble (obj.noLoadCost),
            () => output.writeString (obj.noLoadCostEligibilityFlag),
            () => output.writeDouble (obj.startUpCost),
            () => output.writeString (obj.startUpCostEligibilityFlag),
            () => output.writeString (obj.AuxillaryCost),
            () => output.writeString (obj.FiveMinAuxillaryData),
            () => output.writeString (obj.TenMinAuxillaryData)
        )
        AuxiliaryObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AuxiliaryValues]): AuxiliaryValues =
    {
        val parent = AuxiliaryObjectSerializer.read (kryo, input, classOf[AuxiliaryObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AuxiliaryValues (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Model Expected Energy from Market Clearing, interval based.
 *
 * @param Element Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param ExpectedEnergyValues [[ch.ninecode.model.ExpectedEnergyValues ExpectedEnergyValues]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
final case class ExpectedEnergy
(
    Element: BasicElement = null,
    intervalStartTime: String = null,
    updateTimeStamp: String = null,
    updateUser: String = null,
    ExpectedEnergyValues: List[String] = null
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
        implicit val clz: String = ExpectedEnergy.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExpectedEnergy.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ExpectedEnergy.fields (position), x))
        emitelem (0, intervalStartTime)
        emitelem (1, updateTimeStamp)
        emitelem (2, updateUser)
        emitattrs (3, ExpectedEnergyValues)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExpectedEnergy rdf:%s=\"%s\">\n%s\t</cim:ExpectedEnergy>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ExpectedEnergy
extends
    CIMParseable[ExpectedEnergy]
{
    override val fields: Array[String] = Array[String] (
        "intervalStartTime",
        "updateTimeStamp",
        "updateUser",
        "ExpectedEnergyValues"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ExpectedEnergyValues", "ExpectedEnergyValues", "1..*", "1")
    )
    val intervalStartTime: Fielder = parse_element (element (cls, fields(0)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(1)))
    val updateUser: Fielder = parse_element (element (cls, fields(2)))
    val ExpectedEnergyValues: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): ExpectedEnergy =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ExpectedEnergy (
            BasicElement.parse (context),
            mask (intervalStartTime (), 0),
            mask (updateTimeStamp (), 1),
            mask (updateUser (), 2),
            masks (ExpectedEnergyValues (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ExpectedEnergy] = ExpectedEnergySerializer
}

object ExpectedEnergySerializer extends CIMSerializer[ExpectedEnergy]
{
    def write (kryo: Kryo, output: Output, obj: ExpectedEnergy): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.intervalStartTime),
            () => output.writeString (obj.updateTimeStamp),
            () => output.writeString (obj.updateUser),
            () => writeList (obj.ExpectedEnergyValues, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ExpectedEnergy]): ExpectedEnergy =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ExpectedEnergy (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Model Expected Energy from Market Clearing.
 *
 * @param Element Reference to the superclass object.
 * @param energyTypeCode <em>undocumented</em>
 * @param expectedMwh <em>undocumented</em>
 * @param ExpectedEnergy [[ch.ninecode.model.ExpectedEnergy ExpectedEnergy]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
final case class ExpectedEnergyValues
(
    Element: BasicElement = null,
    energyTypeCode: String = null,
    expectedMwh: Double = 0.0,
    ExpectedEnergy: String = null,
    RegisteredResource: String = null
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
        implicit val clz: String = ExpectedEnergyValues.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExpectedEnergyValues.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ExpectedEnergyValues.fields (position), value)
        emitelem (0, energyTypeCode)
        emitelem (1, expectedMwh)
        emitattr (2, ExpectedEnergy)
        emitattr (3, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExpectedEnergyValues rdf:%s=\"%s\">\n%s\t</cim:ExpectedEnergyValues>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ExpectedEnergyValues
extends
    CIMParseable[ExpectedEnergyValues]
{
    override val fields: Array[String] = Array[String] (
        "energyTypeCode",
        "expectedMwh",
        "ExpectedEnergy",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ExpectedEnergy", "ExpectedEnergy", "1", "1..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*")
    )
    val energyTypeCode: Fielder = parse_element (element (cls, fields(0)))
    val expectedMwh: Fielder = parse_element (element (cls, fields(1)))
    val ExpectedEnergy: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): ExpectedEnergyValues =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ExpectedEnergyValues (
            BasicElement.parse (context),
            mask (energyTypeCode (), 0),
            toDouble (mask (expectedMwh (), 1)),
            mask (ExpectedEnergy (), 2),
            mask (RegisteredResource (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ExpectedEnergyValues] = ExpectedEnergyValuesSerializer
}

object ExpectedEnergyValuesSerializer extends CIMSerializer[ExpectedEnergyValues]
{
    def write (kryo: Kryo, output: Output, obj: ExpectedEnergyValues): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.energyTypeCode),
            () => output.writeDouble (obj.expectedMwh),
            () => output.writeString (obj.ExpectedEnergy),
            () => output.writeString (obj.RegisteredResource)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ExpectedEnergyValues]): ExpectedEnergyValues =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ExpectedEnergyValues (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Models 5-Minutes Auxiliary Data.
 *
 * @param Element Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param AuxillaryValues [[ch.ninecode.model.AuxiliaryValues AuxiliaryValues]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
final case class FiveMinAuxiliaryData
(
    Element: BasicElement = null,
    intervalStartTime: String = null,
    updateTimeStamp: String = null,
    updateUser: String = null,
    AuxillaryValues: List[String] = null
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
        implicit val clz: String = FiveMinAuxiliaryData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FiveMinAuxiliaryData.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (FiveMinAuxiliaryData.fields (position), x))
        emitelem (0, intervalStartTime)
        emitelem (1, updateTimeStamp)
        emitelem (2, updateUser)
        emitattrs (3, AuxillaryValues)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FiveMinAuxiliaryData rdf:%s=\"%s\">\n%s\t</cim:FiveMinAuxiliaryData>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object FiveMinAuxiliaryData
extends
    CIMParseable[FiveMinAuxiliaryData]
{
    override val fields: Array[String] = Array[String] (
        "intervalStartTime",
        "updateTimeStamp",
        "updateUser",
        "AuxillaryValues"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AuxillaryValues", "AuxiliaryValues", "1..*", "1")
    )
    val intervalStartTime: Fielder = parse_element (element (cls, fields(0)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(1)))
    val updateUser: Fielder = parse_element (element (cls, fields(2)))
    val AuxillaryValues: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): FiveMinAuxiliaryData =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FiveMinAuxiliaryData (
            BasicElement.parse (context),
            mask (intervalStartTime (), 0),
            mask (updateTimeStamp (), 1),
            mask (updateUser (), 2),
            masks (AuxillaryValues (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[FiveMinAuxiliaryData] = FiveMinAuxiliaryDataSerializer
}

object FiveMinAuxiliaryDataSerializer extends CIMSerializer[FiveMinAuxiliaryData]
{
    def write (kryo: Kryo, output: Output, obj: FiveMinAuxiliaryData): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.intervalStartTime),
            () => output.writeString (obj.updateTimeStamp),
            () => output.writeString (obj.updateUser),
            () => writeList (obj.AuxillaryValues, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FiveMinAuxiliaryData]): FiveMinAuxiliaryData =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FiveMinAuxiliaryData (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Models 10-Minutes Auxiliary Data.
 *
 * @param Element Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param AuxillaryData [[ch.ninecode.model.AuxiliaryValues AuxiliaryValues]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
final case class TenMinAuxiliaryData
(
    Element: BasicElement = null,
    intervalStartTime: String = null,
    updateTimeStamp: String = null,
    updateUser: String = null,
    AuxillaryData: List[String] = null
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
        implicit val clz: String = TenMinAuxiliaryData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TenMinAuxiliaryData.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TenMinAuxiliaryData.fields (position), x))
        emitelem (0, intervalStartTime)
        emitelem (1, updateTimeStamp)
        emitelem (2, updateUser)
        emitattrs (3, AuxillaryData)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TenMinAuxiliaryData rdf:%s=\"%s\">\n%s\t</cim:TenMinAuxiliaryData>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object TenMinAuxiliaryData
extends
    CIMParseable[TenMinAuxiliaryData]
{
    override val fields: Array[String] = Array[String] (
        "intervalStartTime",
        "updateTimeStamp",
        "updateUser",
        "AuxillaryData"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AuxillaryData", "AuxiliaryValues", "1..*", "1")
    )
    val intervalStartTime: Fielder = parse_element (element (cls, fields(0)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(1)))
    val updateUser: Fielder = parse_element (element (cls, fields(2)))
    val AuxillaryData: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): TenMinAuxiliaryData =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TenMinAuxiliaryData (
            BasicElement.parse (context),
            mask (intervalStartTime (), 0),
            mask (updateTimeStamp (), 1),
            mask (updateUser (), 2),
            masks (AuxillaryData (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TenMinAuxiliaryData] = TenMinAuxiliaryDataSerializer
}

object TenMinAuxiliaryDataSerializer extends CIMSerializer[TenMinAuxiliaryData]
{
    def write (kryo: Kryo, output: Output, obj: TenMinAuxiliaryData): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.intervalStartTime),
            () => output.writeString (obj.updateTimeStamp),
            () => output.writeString (obj.updateUser),
            () => writeList (obj.AuxillaryData, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TenMinAuxiliaryData]): TenMinAuxiliaryData =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TenMinAuxiliaryData (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Models prices at Trading Hubs, interval based.
 *
 * @param Element Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param marketType <em>undocumented</em>
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param TradingHubValues [[ch.ninecode.model.TradingHubValues TradingHubValues]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
final case class TradingHubPrice
(
    Element: BasicElement = null,
    intervalStartTime: String = null,
    marketType: String = null,
    updateTimeStamp: String = null,
    updateUser: String = null,
    TradingHubValues: List[String] = null
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
        implicit val clz: String = TradingHubPrice.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TradingHubPrice.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TradingHubPrice.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TradingHubPrice.fields (position), x))
        emitelem (0, intervalStartTime)
        emitattr (1, marketType)
        emitelem (2, updateTimeStamp)
        emitelem (3, updateUser)
        emitattrs (4, TradingHubValues)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TradingHubPrice rdf:%s=\"%s\">\n%s\t</cim:TradingHubPrice>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object TradingHubPrice
extends
    CIMParseable[TradingHubPrice]
{
    override val fields: Array[String] = Array[String] (
        "intervalStartTime",
        "marketType",
        "updateTimeStamp",
        "updateUser",
        "TradingHubValues"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TradingHubValues", "TradingHubValues", "1..*", "1")
    )
    val intervalStartTime: Fielder = parse_element (element (cls, fields(0)))
    val marketType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(2)))
    val updateUser: Fielder = parse_element (element (cls, fields(3)))
    val TradingHubValues: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): TradingHubPrice =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TradingHubPrice (
            BasicElement.parse (context),
            mask (intervalStartTime (), 0),
            mask (marketType (), 1),
            mask (updateTimeStamp (), 2),
            mask (updateUser (), 3),
            masks (TradingHubValues (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TradingHubPrice] = TradingHubPriceSerializer
}

object TradingHubPriceSerializer extends CIMSerializer[TradingHubPrice]
{
    def write (kryo: Kryo, output: Output, obj: TradingHubPrice): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.intervalStartTime),
            () => output.writeString (obj.marketType),
            () => output.writeString (obj.updateTimeStamp),
            () => output.writeString (obj.updateUser),
            () => writeList (obj.TradingHubValues, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TradingHubPrice]): TradingHubPrice =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TradingHubPrice (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Models prices at Trading Hubs.
 *
 * @param Element Reference to the superclass object.
 * @param price Utilizes the Market type.
 *        For DA, the price is hourly. For RTM the price is a 5 minute price.
 * @param AggregatedPnode [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param TradingHubPrice [[ch.ninecode.model.TradingHubPrice TradingHubPrice]] <em>undocumented</em>
 * @group MarketQualitySystem
 * @groupname MarketQualitySystem Package MarketQualitySystem
 * @groupdesc MarketQualitySystem Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes. Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */
final case class TradingHubValues
(
    Element: BasicElement = null,
    price: Double = 0.0,
    AggregatedPnode: String = null,
    TradingHubPrice: String = null
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
        implicit val clz: String = TradingHubValues.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TradingHubValues.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TradingHubValues.fields (position), value)
        emitelem (0, price)
        emitattr (1, AggregatedPnode)
        emitattr (2, TradingHubPrice)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TradingHubValues rdf:%s=\"%s\">\n%s\t</cim:TradingHubValues>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object TradingHubValues
extends
    CIMParseable[TradingHubValues]
{
    override val fields: Array[String] = Array[String] (
        "price",
        "AggregatedPnode",
        "TradingHubPrice"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AggregatedPnode", "AggregatedPnode", "1", "0..*"),
        CIMRelationship ("TradingHubPrice", "TradingHubPrice", "1", "1..*")
    )
    val price: Fielder = parse_element (element (cls, fields(0)))
    val AggregatedPnode: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TradingHubPrice: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): TradingHubValues =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TradingHubValues (
            BasicElement.parse (context),
            toDouble (mask (price (), 0)),
            mask (AggregatedPnode (), 1),
            mask (TradingHubPrice (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TradingHubValues] = TradingHubValuesSerializer
}

object TradingHubValuesSerializer extends CIMSerializer[TradingHubValues]
{
    def write (kryo: Kryo, output: Output, obj: TradingHubValues): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.price),
            () => output.writeString (obj.AggregatedPnode),
            () => output.writeString (obj.TradingHubPrice)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TradingHubValues]): TradingHubValues =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TradingHubValues (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _MarketQualitySystem
{
    def register: List[CIMClassInfo] =
    {
        List (
            AllocationResult.register,
            AllocationResultValues.register,
            AuxiliaryCost.register,
            AuxiliaryObject.register,
            AuxiliaryValues.register,
            ExpectedEnergy.register,
            ExpectedEnergyValues.register,
            FiveMinAuxiliaryData.register,
            TenMinAuxiliaryData.register,
            TradingHubPrice.register,
            TradingHubValues.register
        )
    }
}