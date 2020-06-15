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
 * This is a environmental based limit dependency model for calculating operational limits.
 *
 * @param LimitDependency [[ch.ninecode.model.LimitDependency LimitDependency]] Reference to the superclass object.
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class EnvironmentalDependentLimit
(
    LimitDependency: LimitDependency = null
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
    override def sup: LimitDependency = LimitDependency

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
        "\t<cim:EnvironmentalDependentLimit rdf:ID=\"%s\">\n%s\t</cim:EnvironmentalDependentLimit>".format (id, export_fields)
    }
}

object EnvironmentalDependentLimit
extends
    CIMParseable[EnvironmentalDependentLimit]
{

    def parse (context: CIMContext): EnvironmentalDependentLimit =
    {
        val ret = EnvironmentalDependentLimit (
            LimitDependency.parse (context)
        )
        ret
    }

    def serializer: Serializer[EnvironmentalDependentLimit] = EnvironmentalDependentLimitSerializer
}

object EnvironmentalDependentLimitSerializer extends CIMSerializer[EnvironmentalDependentLimit]
{
    def write (kryo: Kryo, output: Output, obj: EnvironmentalDependentLimit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        LimitDependencySerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnvironmentalDependentLimit]): EnvironmentalDependentLimit =
    {
        val parent = LimitDependencySerializer.read (kryo, input, classOf[LimitDependency])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnvironmentalDependentLimit (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This represents one instance of an equipment that contributes to the calculation of an operational limit.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] Equipment contributing toward the series limit.
 *        The reference here is to Equipment rather than a specific limit on the equipment so the grouiping can be reused for multiple limits of different types on the same instance of equipment.
 * @param SeriesEquipmentDependentLimit [[ch.ninecode.model.SeriesEquipmentDependentLimit SeriesEquipmentDependentLimit]] Calculation in which the refernce to equipment applies.
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class EquipmentLimitSeriesComponent
(
    IdentifiedObject: IdentifiedObject = null,
    Equipment: String = null,
    SeriesEquipmentDependentLimit: String = null
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
        implicit val clz: String = EquipmentLimitSeriesComponent.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EquipmentLimitSeriesComponent.fields (position), value)
        emitattr (0, Equipment)
        emitattr (1, SeriesEquipmentDependentLimit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EquipmentLimitSeriesComponent rdf:ID=\"%s\">\n%s\t</cim:EquipmentLimitSeriesComponent>".format (id, export_fields)
    }
}

object EquipmentLimitSeriesComponent
extends
    CIMParseable[EquipmentLimitSeriesComponent]
{
    override val fields: Array[String] = Array[String] (
        "Equipment",
        "SeriesEquipmentDependentLimit"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Equipment", "Equipment", "1", "0..*"),
        CIMRelationship ("SeriesEquipmentDependentLimit", "SeriesEquipmentDependentLimit", "1", "0..*")
    )
    val Equipment: Fielder = parse_attribute (attribute (cls, fields(0)))
    val SeriesEquipmentDependentLimit: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): EquipmentLimitSeriesComponent =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EquipmentLimitSeriesComponent (
            IdentifiedObject.parse (context),
            mask (Equipment (), 0),
            mask (SeriesEquipmentDependentLimit (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[EquipmentLimitSeriesComponent] = EquipmentLimitSeriesComponentSerializer
}

object EquipmentLimitSeriesComponentSerializer extends CIMSerializer[EquipmentLimitSeriesComponent]
{
    def write (kryo: Kryo, output: Output, obj: EquipmentLimitSeriesComponent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Equipment),
            () => output.writeString (obj.SeriesEquipmentDependentLimit)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EquipmentLimitSeriesComponent]): EquipmentLimitSeriesComponent =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EquipmentLimitSeriesComponent (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A limit calculation model used to compute an operational limit based on external input such as temperature.
 *
 * These are intended to be shared among operational limits with the same calculation form that apply to a piece of equipment..
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] The equipment for which this limit dependency model is organized under.
 * @param OperationalLimit [[ch.ninecode.model.OperationalLimit OperationalLimit]] The operational limits to which this limit dependency model applies.
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class LimitDependency
(
    IdentifiedObject: IdentifiedObject = null,
    Equipment: String = null,
    OperationalLimit: List[String] = null
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
        implicit val clz: String = LimitDependency.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LimitDependency.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (LimitDependency.fields (position), x))
        emitattr (0, Equipment)
        emitattrs (1, OperationalLimit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LimitDependency rdf:ID=\"%s\">\n%s\t</cim:LimitDependency>".format (id, export_fields)
    }
}

object LimitDependency
extends
    CIMParseable[LimitDependency]
{
    override val fields: Array[String] = Array[String] (
        "Equipment",
        "OperationalLimit"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Equipment", "Equipment", "0..1", "0..*"),
        CIMRelationship ("OperationalLimit", "OperationalLimit", "0..*", "0..*")
    )
    val Equipment: Fielder = parse_attribute (attribute (cls, fields(0)))
    val OperationalLimit: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): LimitDependency =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LimitDependency (
            IdentifiedObject.parse (context),
            mask (Equipment (), 0),
            masks (OperationalLimit (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[LimitDependency] = LimitDependencySerializer
}

object LimitDependencySerializer extends CIMSerializer[LimitDependency]
{
    def write (kryo: Kryo, output: Output, obj: LimitDependency): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Equipment),
            () => writeList (obj.OperationalLimit, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LimitDependency]): LimitDependency =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LimitDependency (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Specifies an operational  limit is calculated by scaling another operational limit.
 *
 * @param LimitDependency [[ch.ninecode.model.LimitDependency LimitDependency]] Reference to the superclass object.
 * @param limitScalingPercent The associated source limit is scaled by this value to compute the limit of the dependency model.
 * @param SourceOperationalLimit [[ch.ninecode.model.OperationalLimit OperationalLimit]] <em>undocumented</em>
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class LimitScalingLimit
(
    LimitDependency: LimitDependency = null,
    limitScalingPercent: Double = 0.0,
    SourceOperationalLimit: String = null
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
    override def sup: LimitDependency = LimitDependency

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
        implicit val clz: String = LimitScalingLimit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LimitScalingLimit.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LimitScalingLimit.fields (position), value)
        emitelem (0, limitScalingPercent)
        emitattr (1, SourceOperationalLimit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LimitScalingLimit rdf:ID=\"%s\">\n%s\t</cim:LimitScalingLimit>".format (id, export_fields)
    }
}

object LimitScalingLimit
extends
    CIMParseable[LimitScalingLimit]
{
    override val fields: Array[String] = Array[String] (
        "limitScalingPercent",
        "SourceOperationalLimit"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SourceOperationalLimit", "OperationalLimit", "1", "0..*")
    )
    val limitScalingPercent: Fielder = parse_element (element (cls, fields(0)))
    val SourceOperationalLimit: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): LimitScalingLimit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LimitScalingLimit (
            LimitDependency.parse (context),
            toDouble (mask (limitScalingPercent (), 0)),
            mask (SourceOperationalLimit (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[LimitScalingLimit] = LimitScalingLimitSerializer
}

object LimitScalingLimitSerializer extends CIMSerializer[LimitScalingLimit]
{
    def write (kryo: Kryo, output: Output, obj: LimitScalingLimit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.limitScalingPercent),
            () => output.writeString (obj.SourceOperationalLimit)
        )
        LimitDependencySerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LimitScalingLimit]): LimitScalingLimit =
    {
        val parent = LimitDependencySerializer.read (kryo, input, classOf[LimitDependency])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LimitScalingLimit (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * One operational limit type scales values of another operational limit type when under the same operational limit set.
 *
 * This applies to any operational limit assigned to the target operational limit type and without other limit dependency models.
 *
 * @param Element Reference to the superclass object.
 * @param scalingPercent The percentage scaling of the source limit to compute the target limit.
 *        Applys to operational limits within an operaitonal limit set when both source and target operational limit types exist.
 * @param SourceOperationalLimitType [[ch.ninecode.model.OperationalLimitType OperationalLimitType]] <em>undocumented</em>
 * @param TargetOperationalLimit [[ch.ninecode.model.OperationalLimitType OperationalLimitType]] <em>undocumented</em>
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class OperatonalLimitTypeScaling
(
    Element: BasicElement = null,
    scalingPercent: Double = 0.0,
    SourceOperationalLimitType: String = null,
    TargetOperationalLimit: String = null
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
        implicit val clz: String = OperatonalLimitTypeScaling.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OperatonalLimitTypeScaling.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OperatonalLimitTypeScaling.fields (position), value)
        emitelem (0, scalingPercent)
        emitattr (1, SourceOperationalLimitType)
        emitattr (2, TargetOperationalLimit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OperatonalLimitTypeScaling rdf:ID=\"%s\">\n%s\t</cim:OperatonalLimitTypeScaling>".format (id, export_fields)
    }
}

object OperatonalLimitTypeScaling
extends
    CIMParseable[OperatonalLimitTypeScaling]
{
    override val fields: Array[String] = Array[String] (
        "scalingPercent",
        "SourceOperationalLimitType",
        "TargetOperationalLimit"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SourceOperationalLimitType", "OperationalLimitType", "0..1", "0..*"),
        CIMRelationship ("TargetOperationalLimit", "OperationalLimitType", "1", "0..1")
    )
    val scalingPercent: Fielder = parse_element (element (cls, fields(0)))
    val SourceOperationalLimitType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TargetOperationalLimit: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): OperatonalLimitTypeScaling =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OperatonalLimitTypeScaling (
            BasicElement.parse (context),
            toDouble (mask (scalingPercent (), 0)),
            mask (SourceOperationalLimitType (), 1),
            mask (TargetOperationalLimit (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OperatonalLimitTypeScaling] = OperatonalLimitTypeScalingSerializer
}

object OperatonalLimitTypeScalingSerializer extends CIMSerializer[OperatonalLimitTypeScaling]
{
    def write (kryo: Kryo, output: Output, obj: OperatonalLimitTypeScaling): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.scalingPercent),
            () => output.writeString (obj.SourceOperationalLimitType),
            () => output.writeString (obj.TargetOperationalLimit)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OperatonalLimitTypeScaling]): OperatonalLimitTypeScaling =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OperatonalLimitTypeScaling (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class ScheduledActivePowerLimitValue
(
    ScheduledLimitValue: ScheduledLimitValue = null,
    value: Double = 0.0
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
    override def sup: ScheduledLimitValue = ScheduledLimitValue

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
        implicit val clz: String = ScheduledActivePowerLimitValue.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ScheduledActivePowerLimitValue.fields (position), value)
        emitelem (0, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ScheduledActivePowerLimitValue rdf:ID=\"%s\">\n%s\t</cim:ScheduledActivePowerLimitValue>".format (id, export_fields)
    }
}

object ScheduledActivePowerLimitValue
extends
    CIMParseable[ScheduledActivePowerLimitValue]
{
    override val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): ScheduledActivePowerLimitValue =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ScheduledActivePowerLimitValue (
            ScheduledLimitValue.parse (context),
            toDouble (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ScheduledActivePowerLimitValue] = ScheduledActivePowerLimitValueSerializer
}

object ScheduledActivePowerLimitValueSerializer extends CIMSerializer[ScheduledActivePowerLimitValue]
{
    def write (kryo: Kryo, output: Output, obj: ScheduledActivePowerLimitValue): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.value)
        )
        ScheduledLimitValueSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ScheduledActivePowerLimitValue]): ScheduledActivePowerLimitValue =
    {
        val parent = ScheduledLimitValueSerializer.read (kryo, input, classOf[ScheduledLimitValue])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ScheduledActivePowerLimitValue (
            parent,
            if (isSet (0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A time scheduled value for apparent power limit.
 *
 * @param ScheduledLimitValue [[ch.ninecode.model.ScheduledLimitValue ScheduledLimitValue]] Reference to the superclass object.
 * @param value The apparent power limit value for the scheduled time.
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class ScheduledApparentPowerLimitValue
(
    ScheduledLimitValue: ScheduledLimitValue = null,
    value: Double = 0.0
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
    override def sup: ScheduledLimitValue = ScheduledLimitValue

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
        implicit val clz: String = ScheduledApparentPowerLimitValue.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ScheduledApparentPowerLimitValue.fields (position), value)
        emitelem (0, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ScheduledApparentPowerLimitValue rdf:ID=\"%s\">\n%s\t</cim:ScheduledApparentPowerLimitValue>".format (id, export_fields)
    }
}

object ScheduledApparentPowerLimitValue
extends
    CIMParseable[ScheduledApparentPowerLimitValue]
{
    override val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): ScheduledApparentPowerLimitValue =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ScheduledApparentPowerLimitValue (
            ScheduledLimitValue.parse (context),
            toDouble (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ScheduledApparentPowerLimitValue] = ScheduledApparentPowerLimitValueSerializer
}

object ScheduledApparentPowerLimitValueSerializer extends CIMSerializer[ScheduledApparentPowerLimitValue]
{
    def write (kryo: Kryo, output: Output, obj: ScheduledApparentPowerLimitValue): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.value)
        )
        ScheduledLimitValueSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ScheduledApparentPowerLimitValue]): ScheduledApparentPowerLimitValue =
    {
        val parent = ScheduledLimitValueSerializer.read (kryo, input, classOf[ScheduledLimitValue])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ScheduledApparentPowerLimitValue (
            parent,
            if (isSet (0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A current limit that is scheduled.
 *
 * @param ScheduledLimitValue [[ch.ninecode.model.ScheduledLimitValue ScheduledLimitValue]] Reference to the superclass object.
 * @param value The current flow limit value applicable at the scheduled time.
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class ScheduledCurrentLimitValue
(
    ScheduledLimitValue: ScheduledLimitValue = null,
    value: Double = 0.0
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
    override def sup: ScheduledLimitValue = ScheduledLimitValue

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
        implicit val clz: String = ScheduledCurrentLimitValue.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ScheduledCurrentLimitValue.fields (position), value)
        emitelem (0, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ScheduledCurrentLimitValue rdf:ID=\"%s\">\n%s\t</cim:ScheduledCurrentLimitValue>".format (id, export_fields)
    }
}

object ScheduledCurrentLimitValue
extends
    CIMParseable[ScheduledCurrentLimitValue]
{
    override val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): ScheduledCurrentLimitValue =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ScheduledCurrentLimitValue (
            ScheduledLimitValue.parse (context),
            toDouble (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ScheduledCurrentLimitValue] = ScheduledCurrentLimitValueSerializer
}

object ScheduledCurrentLimitValueSerializer extends CIMSerializer[ScheduledCurrentLimitValue]
{
    def write (kryo: Kryo, output: Output, obj: ScheduledCurrentLimitValue): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.value)
        )
        ScheduledLimitValueSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ScheduledCurrentLimitValue]): ScheduledCurrentLimitValue =
    {
        val parent = ScheduledLimitValueSerializer.read (kryo, input, classOf[ScheduledLimitValue])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ScheduledCurrentLimitValue (
            parent,
            if (isSet (0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class ScheduledLimitDependency
(
    LimitDependency: LimitDependency = null,
    ScheduledLimitValues: List[String] = null
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
    override def sup: LimitDependency = LimitDependency

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
        implicit val clz: String = ScheduledLimitDependency.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ScheduledLimitDependency.fields (position), x))
        emitattrs (0, ScheduledLimitValues)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ScheduledLimitDependency rdf:ID=\"%s\">\n%s\t</cim:ScheduledLimitDependency>".format (id, export_fields)
    }
}

object ScheduledLimitDependency
extends
    CIMParseable[ScheduledLimitDependency]
{
    override val fields: Array[String] = Array[String] (
        "ScheduledLimitValues"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ScheduledLimitValues", "ScheduledLimitValue", "0..*", "1")
    )
    val ScheduledLimitValues: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): ScheduledLimitDependency =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ScheduledLimitDependency (
            LimitDependency.parse (context),
            masks (ScheduledLimitValues (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ScheduledLimitDependency] = ScheduledLimitDependencySerializer
}

object ScheduledLimitDependencySerializer extends CIMSerializer[ScheduledLimitDependency]
{
    def write (kryo: Kryo, output: Output, obj: ScheduledLimitDependency): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ScheduledLimitValues, output)
        )
        LimitDependencySerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ScheduledLimitDependency]): ScheduledLimitDependency =
    {
        val parent = LimitDependencySerializer.read (kryo, input, classOf[LimitDependency])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ScheduledLimitDependency (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A limit that is applicable during a scheduled time period.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ScheduledLimitDependency [[ch.ninecode.model.ScheduledLimitDependency ScheduledLimitDependency]] <em>undocumented</em>
 * @param Season [[ch.ninecode.model.Season Season]] The season for which the scheduled limits applies.
 *        If not specified, then applicable ot any season.
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class ScheduledLimitValue
(
    IdentifiedObject: IdentifiedObject = null,
    ScheduledLimitDependency: String = null,
    Season: String = null
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
        implicit val clz: String = ScheduledLimitValue.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ScheduledLimitValue.fields (position), value)
        emitattr (0, ScheduledLimitDependency)
        emitattr (1, Season)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ScheduledLimitValue rdf:ID=\"%s\">\n%s\t</cim:ScheduledLimitValue>".format (id, export_fields)
    }
}

object ScheduledLimitValue
extends
    CIMParseable[ScheduledLimitValue]
{
    override val fields: Array[String] = Array[String] (
        "ScheduledLimitDependency",
        "Season"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ScheduledLimitDependency", "ScheduledLimitDependency", "1", "0..*"),
        CIMRelationship ("Season", "Season", "0..1", "0..*")
    )
    val ScheduledLimitDependency: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Season: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): ScheduledLimitValue =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ScheduledLimitValue (
            IdentifiedObject.parse (context),
            mask (ScheduledLimitDependency (), 0),
            mask (Season (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ScheduledLimitValue] = ScheduledLimitValueSerializer
}

object ScheduledLimitValueSerializer extends CIMSerializer[ScheduledLimitValue]
{
    def write (kryo: Kryo, output: Output, obj: ScheduledLimitValue): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ScheduledLimitDependency),
            () => output.writeString (obj.Season)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ScheduledLimitValue]): ScheduledLimitValue =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ScheduledLimitValue (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A voltage limit value for a scheduled time.
 *
 * @param ScheduledLimitValue [[ch.ninecode.model.ScheduledLimitValue ScheduledLimitValue]] Reference to the superclass object.
 * @param value The voltage limit value for the scheduled time.
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class ScheduledVoltageLimitValue
(
    ScheduledLimitValue: ScheduledLimitValue = null,
    value: Double = 0.0
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
    override def sup: ScheduledLimitValue = ScheduledLimitValue

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
        implicit val clz: String = ScheduledVoltageLimitValue.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ScheduledVoltageLimitValue.fields (position), value)
        emitelem (0, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ScheduledVoltageLimitValue rdf:ID=\"%s\">\n%s\t</cim:ScheduledVoltageLimitValue>".format (id, export_fields)
    }
}

object ScheduledVoltageLimitValue
extends
    CIMParseable[ScheduledVoltageLimitValue]
{
    override val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): ScheduledVoltageLimitValue =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ScheduledVoltageLimitValue (
            ScheduledLimitValue.parse (context),
            toDouble (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ScheduledVoltageLimitValue] = ScheduledVoltageLimitValueSerializer
}

object ScheduledVoltageLimitValueSerializer extends CIMSerializer[ScheduledVoltageLimitValue]
{
    def write (kryo: Kryo, output: Output, obj: ScheduledVoltageLimitValue): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.value)
        )
        ScheduledLimitValueSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ScheduledVoltageLimitValue]): ScheduledVoltageLimitValue =
    {
        val parent = ScheduledLimitValueSerializer.read (kryo, input, classOf[ScheduledLimitValue])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ScheduledVoltageLimitValue (
            parent,
            if (isSet (0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Limit based on most restrictive series equipment limit.
 *
 * A specification of  of equipment that determines the calculated operational limit values based upon other equipment and their ratings.  The most restrictive limit connected in series within the group is used.   The physical connection based on switch status for example may also impact which elements in the group are considered. Any equipment in the group that are presently connected in series with the equipment of the directly associated operational limit are used.   This provides a means to indicate which potentially series equipment limits are considered for a computed operational limit. The operational limit of the same operational limit type is assumed to be used from the grouped equipment.   It is also possible to make assumptions or calculations regarding how flow might split if the equipment is not simply in series.
 *
 * @param LimitDependency [[ch.ninecode.model.LimitDependency LimitDependency]] Reference to the superclass object.
 * @param EquipmentLimitSeriesComponent [[ch.ninecode.model.EquipmentLimitSeriesComponent EquipmentLimitSeriesComponent]] Equipment linkages that participates in the limit calculation.
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class SeriesEquipmentDependentLimit
(
    LimitDependency: LimitDependency = null,
    EquipmentLimitSeriesComponent: List[String] = null
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
    override def sup: LimitDependency = LimitDependency

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
        implicit val clz: String = SeriesEquipmentDependentLimit.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SeriesEquipmentDependentLimit.fields (position), x))
        emitattrs (0, EquipmentLimitSeriesComponent)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SeriesEquipmentDependentLimit rdf:ID=\"%s\">\n%s\t</cim:SeriesEquipmentDependentLimit>".format (id, export_fields)
    }
}

object SeriesEquipmentDependentLimit
extends
    CIMParseable[SeriesEquipmentDependentLimit]
{
    override val fields: Array[String] = Array[String] (
        "EquipmentLimitSeriesComponent"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EquipmentLimitSeriesComponent", "EquipmentLimitSeriesComponent", "0..*", "1")
    )
    val EquipmentLimitSeriesComponent: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): SeriesEquipmentDependentLimit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SeriesEquipmentDependentLimit (
            LimitDependency.parse (context),
            masks (EquipmentLimitSeriesComponent (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SeriesEquipmentDependentLimit] = SeriesEquipmentDependentLimitSerializer
}

object SeriesEquipmentDependentLimitSerializer extends CIMSerializer[SeriesEquipmentDependentLimit]
{
    def write (kryo: Kryo, output: Output, obj: SeriesEquipmentDependentLimit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.EquipmentLimitSeriesComponent, output)
        )
        LimitDependencySerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SeriesEquipmentDependentLimit]): SeriesEquipmentDependentLimit =
    {
        val parent = LimitDependencySerializer.read (kryo, input, classOf[LimitDependency])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SeriesEquipmentDependentLimit (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A point on a table of limit verses temperature.
 *
 * @param Element Reference to the superclass object.
 * @param limitPercent The scaling of the operational limit in percent.
 * @param temperature The temperature of the table point.
 * @param TemperatureDependentLimitTable [[ch.ninecode.model.TemperatureDependentLimitTable TemperatureDependentLimitTable]] <em>undocumented</em>
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class TemperatureDependentLimitPoint
(
    Element: BasicElement = null,
    limitPercent: Double = 0.0,
    temperature: Double = 0.0,
    TemperatureDependentLimitTable: String = null
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
        implicit val clz: String = TemperatureDependentLimitPoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TemperatureDependentLimitPoint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TemperatureDependentLimitPoint.fields (position), value)
        emitelem (0, limitPercent)
        emitelem (1, temperature)
        emitattr (2, TemperatureDependentLimitTable)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TemperatureDependentLimitPoint rdf:ID=\"%s\">\n%s\t</cim:TemperatureDependentLimitPoint>".format (id, export_fields)
    }
}

object TemperatureDependentLimitPoint
extends
    CIMParseable[TemperatureDependentLimitPoint]
{
    override val fields: Array[String] = Array[String] (
        "limitPercent",
        "temperature",
        "TemperatureDependentLimitTable"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TemperatureDependentLimitTable", "TemperatureDependentLimitTable", "1", "0..*")
    )
    val limitPercent: Fielder = parse_element (element (cls, fields(0)))
    val temperature: Fielder = parse_element (element (cls, fields(1)))
    val TemperatureDependentLimitTable: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): TemperatureDependentLimitPoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TemperatureDependentLimitPoint (
            BasicElement.parse (context),
            toDouble (mask (limitPercent (), 0)),
            toDouble (mask (temperature (), 1)),
            mask (TemperatureDependentLimitTable (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TemperatureDependentLimitPoint] = TemperatureDependentLimitPointSerializer
}

object TemperatureDependentLimitPointSerializer extends CIMSerializer[TemperatureDependentLimitPoint]
{
    def write (kryo: Kryo, output: Output, obj: TemperatureDependentLimitPoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.limitPercent),
            () => output.writeDouble (obj.temperature),
            () => output.writeString (obj.TemperatureDependentLimitTable)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TemperatureDependentLimitPoint]): TemperatureDependentLimitPoint =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TemperatureDependentLimitPoint (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This is a table lookup that provides limit values corresponding to a temperature input.
 *
 * @param EnvironmentalDependentLimit [[ch.ninecode.model.EnvironmentalDependentLimit EnvironmentalDependentLimit]] Reference to the superclass object.
 * @param TemperatureLimitTablePoint [[ch.ninecode.model.TemperatureDependentLimitPoint TemperatureDependentLimitPoint]] <em>undocumented</em>
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class TemperatureDependentLimitTable
(
    EnvironmentalDependentLimit: EnvironmentalDependentLimit = null,
    TemperatureLimitTablePoint: List[String] = null
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
    override def sup: EnvironmentalDependentLimit = EnvironmentalDependentLimit

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
        implicit val clz: String = TemperatureDependentLimitTable.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TemperatureDependentLimitTable.fields (position), x))
        emitattrs (0, TemperatureLimitTablePoint)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TemperatureDependentLimitTable rdf:ID=\"%s\">\n%s\t</cim:TemperatureDependentLimitTable>".format (id, export_fields)
    }
}

object TemperatureDependentLimitTable
extends
    CIMParseable[TemperatureDependentLimitTable]
{
    override val fields: Array[String] = Array[String] (
        "TemperatureLimitTablePoint"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TemperatureLimitTablePoint", "TemperatureDependentLimitPoint", "0..*", "1")
    )
    val TemperatureLimitTablePoint: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): TemperatureDependentLimitTable =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TemperatureDependentLimitTable (
            EnvironmentalDependentLimit.parse (context),
            masks (TemperatureLimitTablePoint (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TemperatureDependentLimitTable] = TemperatureDependentLimitTableSerializer
}

object TemperatureDependentLimitTableSerializer extends CIMSerializer[TemperatureDependentLimitTable]
{
    def write (kryo: Kryo, output: Output, obj: TemperatureDependentLimitTable): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.TemperatureLimitTablePoint, output)
        )
        EnvironmentalDependentLimitSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TemperatureDependentLimitTable]): TemperatureDependentLimitTable =
    {
        val parent = EnvironmentalDependentLimitSerializer.read (kryo, input, classOf[EnvironmentalDependentLimit])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TemperatureDependentLimitTable (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This describes the coefficients of a polynomial function that has temperature as input and calculates limit values as output.
 *
 * @param EnvironmentalDependentLimit [[ch.ninecode.model.EnvironmentalDependentLimit EnvironmentalDependentLimit]] Reference to the superclass object.
 * @param coefficient0 The polinomial coefficent of power 0.
 * @param coefficient1 The polinomial coefficent of power 1.
 * @param coefficient2 The polinomial coefficent of power 2.
 * @param coefficient3 The polinomial coefficent of power 3.
 * @param coefficient4 The polinomial coefficent of power 4.
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class TemperaturePolynomialLimit
(
    EnvironmentalDependentLimit: EnvironmentalDependentLimit = null,
    coefficient0: Double = 0.0,
    coefficient1: Double = 0.0,
    coefficient2: Double = 0.0,
    coefficient3: Double = 0.0,
    coefficient4: Double = 0.0
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
    override def sup: EnvironmentalDependentLimit = EnvironmentalDependentLimit

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
        implicit val clz: String = TemperaturePolynomialLimit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TemperaturePolynomialLimit.fields (position), value)
        emitelem (0, coefficient0)
        emitelem (1, coefficient1)
        emitelem (2, coefficient2)
        emitelem (3, coefficient3)
        emitelem (4, coefficient4)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TemperaturePolynomialLimit rdf:ID=\"%s\">\n%s\t</cim:TemperaturePolynomialLimit>".format (id, export_fields)
    }
}

object TemperaturePolynomialLimit
extends
    CIMParseable[TemperaturePolynomialLimit]
{
    override val fields: Array[String] = Array[String] (
        "coefficient0",
        "coefficient1",
        "coefficient2",
        "coefficient3",
        "coefficient4"
    )
    val coefficient0: Fielder = parse_element (element (cls, fields(0)))
    val coefficient1: Fielder = parse_element (element (cls, fields(1)))
    val coefficient2: Fielder = parse_element (element (cls, fields(2)))
    val coefficient3: Fielder = parse_element (element (cls, fields(3)))
    val coefficient4: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: CIMContext): TemperaturePolynomialLimit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TemperaturePolynomialLimit (
            EnvironmentalDependentLimit.parse (context),
            toDouble (mask (coefficient0 (), 0)),
            toDouble (mask (coefficient1 (), 1)),
            toDouble (mask (coefficient2 (), 2)),
            toDouble (mask (coefficient3 (), 3)),
            toDouble (mask (coefficient4 (), 4))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TemperaturePolynomialLimit] = TemperaturePolynomialLimitSerializer
}

object TemperaturePolynomialLimitSerializer extends CIMSerializer[TemperaturePolynomialLimit]
{
    def write (kryo: Kryo, output: Output, obj: TemperaturePolynomialLimit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.coefficient0),
            () => output.writeDouble (obj.coefficient1),
            () => output.writeDouble (obj.coefficient2),
            () => output.writeDouble (obj.coefficient3),
            () => output.writeDouble (obj.coefficient4)
        )
        EnvironmentalDependentLimitSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TemperaturePolynomialLimit]): TemperaturePolynomialLimit =
    {
        val parent = EnvironmentalDependentLimitSerializer.read (kryo, input, classOf[EnvironmentalDependentLimit])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TemperaturePolynomialLimit (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This represents a source of ambient temperature.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] <em>undocumented</em>
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class WeatherStation
(
    PowerSystemResource: PowerSystemResource = null,
    Equipment: List[String] = null
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
    override def sup: PowerSystemResource = PowerSystemResource

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
        implicit val clz: String = WeatherStation.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WeatherStation.fields (position), x))
        emitattrs (0, Equipment)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WeatherStation rdf:ID=\"%s\">\n%s\t</cim:WeatherStation>".format (id, export_fields)
    }
}

object WeatherStation
extends
    CIMParseable[WeatherStation]
{
    override val fields: Array[String] = Array[String] (
        "Equipment"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Equipment", "Equipment", "0..*", "0..*")
    )
    val Equipment: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): WeatherStation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WeatherStation (
            PowerSystemResource.parse (context),
            masks (Equipment (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WeatherStation] = WeatherStationSerializer
}

object WeatherStationSerializer extends CIMSerializer[WeatherStation]
{
    def write (kryo: Kryo, output: Output, obj: WeatherStation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Equipment, output)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WeatherStation]): WeatherStation =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = WeatherStation (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfOperationalLimits
{
    def register: List[CIMClassInfo] =
    {
        List (
            EnvironmentalDependentLimit.register,
            EquipmentLimitSeriesComponent.register,
            LimitDependency.register,
            LimitScalingLimit.register,
            OperatonalLimitTypeScaling.register,
            ScheduledActivePowerLimitValue.register,
            ScheduledApparentPowerLimitValue.register,
            ScheduledCurrentLimitValue.register,
            ScheduledLimitDependency.register,
            ScheduledLimitValue.register,
            ScheduledVoltageLimitValue.register,
            SeriesEquipmentDependentLimit.register,
            TemperatureDependentLimitPoint.register,
            TemperatureDependentLimitTable.register,
            TemperaturePolynomialLimit.register,
            WeatherStation.register
        )
    }
}