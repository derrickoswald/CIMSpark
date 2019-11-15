package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * This is a environmental based limit dependency model for calculating operational limits.
 *
 * @param sup [[ch.ninecode.model.LimitDependency LimitDependency]] Reference to the superclass object.
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class EnvironmentalDependentLimit
(
    override val sup: LimitDependency = null
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
    def LimitDependency: LimitDependency = sup.asInstanceOf[LimitDependency]
    override def copy (): Row = { clone ().asInstanceOf[EnvironmentalDependentLimit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[EnvironmentalDependentLimit]
{

    def parse (context: Context): EnvironmentalDependentLimit =
    {
        implicit val ctx: Context = context
        val ret = EnvironmentalDependentLimit (
            LimitDependency.parse (context)
        )
        ret
    }
}

/**
 * This represents one instance of an equipment that contributes to the calculation of an operational limit.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    override val sup: IdentifiedObject = null,
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[EquipmentLimitSeriesComponent] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[EquipmentLimitSeriesComponent]
{
    override val fields: Array[String] = Array[String] (
        "Equipment",
        "SeriesEquipmentDependentLimit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Equipment", "Equipment", "1", "0..*"),
        Relationship ("SeriesEquipmentDependentLimit", "SeriesEquipmentDependentLimit", "1", "0..*")
    )
    val Equipment: Fielder = parse_attribute (attribute (cls, fields(0)))
    val SeriesEquipmentDependentLimit: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): EquipmentLimitSeriesComponent =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EquipmentLimitSeriesComponent (
            IdentifiedObject.parse (context),
            mask (Equipment (), 0),
            mask (SeriesEquipmentDependentLimit (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A limit calculation model used to compute an operational limit based on external input such as temperature.
 *
 * These are intended to be shared among operational limits with the same calculation form that apply to a piece of equipment..
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] The equipment for which this limit dependency model is organized under.
 * @param OperationalLimit [[ch.ninecode.model.OperationalLimit OperationalLimit]] The operational limits to which this limit dependency model applies.
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class LimitDependency
(
    override val sup: IdentifiedObject = null,
    Equipment: String = null,
    OperationalLimit: List[String] = List()
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[LimitDependency] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[LimitDependency]
{
    override val fields: Array[String] = Array[String] (
        "Equipment",
        "OperationalLimit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Equipment", "Equipment", "0..1", "0..*"),
        Relationship ("OperationalLimit", "OperationalLimit", "0..*", "0..*")
    )
    val Equipment: Fielder = parse_attribute (attribute (cls, fields(0)))
    val OperationalLimit: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): LimitDependency =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LimitDependency (
            IdentifiedObject.parse (context),
            mask (Equipment (), 0),
            masks (OperationalLimit (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Specifies an operational  limit is calculated by scaling another operational limit.
 *
 * @param sup [[ch.ninecode.model.LimitDependency LimitDependency]] Reference to the superclass object.
 * @param limitScalingPercent The associated source limit is scaled by this value to compute the limit of the dependency model.
 * @param SourceOperationalLimit [[ch.ninecode.model.OperationalLimit OperationalLimit]] <em>undocumented</em>
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class LimitScalingLimit
(
    override val sup: LimitDependency = null,
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
    def LimitDependency: LimitDependency = sup.asInstanceOf[LimitDependency]
    override def copy (): Row = { clone ().asInstanceOf[LimitScalingLimit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[LimitScalingLimit]
{
    override val fields: Array[String] = Array[String] (
        "limitScalingPercent",
        "SourceOperationalLimit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SourceOperationalLimit", "OperationalLimit", "1", "0..*")
    )
    val limitScalingPercent: Fielder = parse_element (element (cls, fields(0)))
    val SourceOperationalLimit: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): LimitScalingLimit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LimitScalingLimit (
            LimitDependency.parse (context),
            toDouble (mask (limitScalingPercent (), 0)),
            mask (SourceOperationalLimit (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * One operational limit type scales values of another operational limit type when under the same operational limit set.
 *
 * This applies to any operational limit assigned to the target operational limit type and without other limit dependency models.
 *
 * @param sup Reference to the superclass object.
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
    override val sup: BasicElement = null,
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OperatonalLimitTypeScaling] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[OperatonalLimitTypeScaling]
{
    override val fields: Array[String] = Array[String] (
        "scalingPercent",
        "SourceOperationalLimitType",
        "TargetOperationalLimit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SourceOperationalLimitType", "OperationalLimitType", "0..1", "0..*"),
        Relationship ("TargetOperationalLimit", "OperationalLimitType", "1", "0..1")
    )
    val scalingPercent: Fielder = parse_element (element (cls, fields(0)))
    val SourceOperationalLimitType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TargetOperationalLimit: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): OperatonalLimitTypeScaling =
    {
        implicit val ctx: Context = context
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
}

/**

 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class ScheduledActivePowerLimitValue
(
    override val sup: ScheduledLimitValue = null,
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
    def ScheduledLimitValue: ScheduledLimitValue = sup.asInstanceOf[ScheduledLimitValue]
    override def copy (): Row = { clone ().asInstanceOf[ScheduledActivePowerLimitValue] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[ScheduledActivePowerLimitValue]
{
    override val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): ScheduledActivePowerLimitValue =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ScheduledActivePowerLimitValue (
            ScheduledLimitValue.parse (context),
            toDouble (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A time scheduled value for apparent power limit.
 *
 * @param sup [[ch.ninecode.model.ScheduledLimitValue ScheduledLimitValue]] Reference to the superclass object.
 * @param value The apparent power limit value for the scheduled time.
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class ScheduledApparentPowerLimitValue
(
    override val sup: ScheduledLimitValue = null,
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
    def ScheduledLimitValue: ScheduledLimitValue = sup.asInstanceOf[ScheduledLimitValue]
    override def copy (): Row = { clone ().asInstanceOf[ScheduledApparentPowerLimitValue] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[ScheduledApparentPowerLimitValue]
{
    override val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): ScheduledApparentPowerLimitValue =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ScheduledApparentPowerLimitValue (
            ScheduledLimitValue.parse (context),
            toDouble (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A current limit that is scheduled.
 *
 * @param sup [[ch.ninecode.model.ScheduledLimitValue ScheduledLimitValue]] Reference to the superclass object.
 * @param value The current flow limit value applicable at the scheduled time.
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class ScheduledCurrentLimitValue
(
    override val sup: ScheduledLimitValue = null,
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
    def ScheduledLimitValue: ScheduledLimitValue = sup.asInstanceOf[ScheduledLimitValue]
    override def copy (): Row = { clone ().asInstanceOf[ScheduledCurrentLimitValue] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[ScheduledCurrentLimitValue]
{
    override val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): ScheduledCurrentLimitValue =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ScheduledCurrentLimitValue (
            ScheduledLimitValue.parse (context),
            toDouble (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
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
    override val sup: LimitDependency = null,
    ScheduledLimitValues: List[String] = List()
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
    def LimitDependency: LimitDependency = sup.asInstanceOf[LimitDependency]
    override def copy (): Row = { clone ().asInstanceOf[ScheduledLimitDependency] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[ScheduledLimitDependency]
{
    override val fields: Array[String] = Array[String] (
        "ScheduledLimitValues"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ScheduledLimitValues", "ScheduledLimitValue", "0..*", "1")
    )
    val ScheduledLimitValues: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): ScheduledLimitDependency =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ScheduledLimitDependency (
            LimitDependency.parse (context),
            masks (ScheduledLimitValues (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A limit that is applicable during a scheduled time period.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    override val sup: IdentifiedObject = null,
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ScheduledLimitValue] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[ScheduledLimitValue]
{
    override val fields: Array[String] = Array[String] (
        "ScheduledLimitDependency",
        "Season"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ScheduledLimitDependency", "ScheduledLimitDependency", "1", "0..*"),
        Relationship ("Season", "Season", "0..1", "0..*")
    )
    val ScheduledLimitDependency: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Season: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ScheduledLimitValue =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ScheduledLimitValue (
            IdentifiedObject.parse (context),
            mask (ScheduledLimitDependency (), 0),
            mask (Season (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A voltage limit value for a scheduled time.
 *
 * @param sup [[ch.ninecode.model.ScheduledLimitValue ScheduledLimitValue]] Reference to the superclass object.
 * @param value The voltage limit value for the scheduled time.
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class ScheduledVoltageLimitValue
(
    override val sup: ScheduledLimitValue = null,
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
    def ScheduledLimitValue: ScheduledLimitValue = sup.asInstanceOf[ScheduledLimitValue]
    override def copy (): Row = { clone ().asInstanceOf[ScheduledVoltageLimitValue] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[ScheduledVoltageLimitValue]
{
    override val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): ScheduledVoltageLimitValue =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ScheduledVoltageLimitValue (
            ScheduledLimitValue.parse (context),
            toDouble (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Limit based on most restrictive series equipment limit.
 *
 * A specification of  of equipment that determines the calculated operational limit values based upon other equipment and their ratings.  The most restrictive limit connected in series within the group is used.   The physical connection based on switch status for example may also impact which elements in the group are considered. Any equipment in the group that are presently connected in series with the equipment of the directly associated operational limit are used.   This provides a means to indicate which potentially series equipment limits are considered for a computed operational limit. The operational limit of the same operational limit type is assumed to be used from the grouped equipment.   It is also possible to make assumptions or calculations regarding how flow might split if the equipment is not simply in series.
 *
 * @param sup [[ch.ninecode.model.LimitDependency LimitDependency]] Reference to the superclass object.
 * @param EquipmentLimitSeriesComponent [[ch.ninecode.model.EquipmentLimitSeriesComponent EquipmentLimitSeriesComponent]] Equipment linkages that participates in the limit calculation.
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class SeriesEquipmentDependentLimit
(
    override val sup: LimitDependency = null,
    EquipmentLimitSeriesComponent: List[String] = List()
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
    def LimitDependency: LimitDependency = sup.asInstanceOf[LimitDependency]
    override def copy (): Row = { clone ().asInstanceOf[SeriesEquipmentDependentLimit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[SeriesEquipmentDependentLimit]
{
    override val fields: Array[String] = Array[String] (
        "EquipmentLimitSeriesComponent"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EquipmentLimitSeriesComponent", "EquipmentLimitSeriesComponent", "0..*", "1")
    )
    val EquipmentLimitSeriesComponent: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): SeriesEquipmentDependentLimit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SeriesEquipmentDependentLimit (
            LimitDependency.parse (context),
            masks (EquipmentLimitSeriesComponent (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A point on a table of limit verses temperature.
 *
 * @param sup Reference to the superclass object.
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
    override val sup: BasicElement = null,
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TemperatureDependentLimitPoint] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[TemperatureDependentLimitPoint]
{
    override val fields: Array[String] = Array[String] (
        "limitPercent",
        "temperature",
        "TemperatureDependentLimitTable"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TemperatureDependentLimitTable", "TemperatureDependentLimitTable", "1", "0..*")
    )
    val limitPercent: Fielder = parse_element (element (cls, fields(0)))
    val temperature: Fielder = parse_element (element (cls, fields(1)))
    val TemperatureDependentLimitTable: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): TemperatureDependentLimitPoint =
    {
        implicit val ctx: Context = context
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
}

/**
 * This is a table lookup that provides limit values corresponding to a temperature input.
 *
 * @param sup [[ch.ninecode.model.EnvironmentalDependentLimit EnvironmentalDependentLimit]] Reference to the superclass object.
 * @param TemperatureLimitTablePoint [[ch.ninecode.model.TemperatureDependentLimitPoint TemperatureDependentLimitPoint]] <em>undocumented</em>
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class TemperatureDependentLimitTable
(
    override val sup: EnvironmentalDependentLimit = null,
    TemperatureLimitTablePoint: List[String] = List()
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
    def EnvironmentalDependentLimit: EnvironmentalDependentLimit = sup.asInstanceOf[EnvironmentalDependentLimit]
    override def copy (): Row = { clone ().asInstanceOf[TemperatureDependentLimitTable] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[TemperatureDependentLimitTable]
{
    override val fields: Array[String] = Array[String] (
        "TemperatureLimitTablePoint"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TemperatureLimitTablePoint", "TemperatureDependentLimitPoint", "0..*", "1")
    )
    val TemperatureLimitTablePoint: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): TemperatureDependentLimitTable =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TemperatureDependentLimitTable (
            EnvironmentalDependentLimit.parse (context),
            masks (TemperatureLimitTablePoint (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This describes the coefficients of a polynomial function that has temperature as input and calculates limit values as output.
 *
 * @param sup [[ch.ninecode.model.EnvironmentalDependentLimit EnvironmentalDependentLimit]] Reference to the superclass object.
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
    override val sup: EnvironmentalDependentLimit = null,
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
    def EnvironmentalDependentLimit: EnvironmentalDependentLimit = sup.asInstanceOf[EnvironmentalDependentLimit]
    override def copy (): Row = { clone ().asInstanceOf[TemperaturePolynomialLimit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[TemperaturePolynomialLimit]
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

    def parse (context: Context): TemperaturePolynomialLimit =
    {
        implicit val ctx: Context = context
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
}

/**
 * This represents a source of ambient temperature.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] <em>undocumented</em>
 * @group InfOperationalLimits
 * @groupname InfOperationalLimits Package InfOperationalLimits
 * @groupdesc InfOperationalLimits The description of computed or dynamic limits.
These classes would likely go into the OperationalLimits package.
 */
final case class WeatherStation
(
    override val sup: PowerSystemResource = null,
    Equipment: List[String] = List()
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
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[WeatherStation] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[WeatherStation]
{
    override val fields: Array[String] = Array[String] (
        "Equipment"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Equipment", "Equipment", "0..*", "0..*")
    )
    val Equipment: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): WeatherStation =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WeatherStation (
            PowerSystemResource.parse (context),
            masks (Equipment (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _InfOperationalLimits
{
    def register: List[ClassInfo] =
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