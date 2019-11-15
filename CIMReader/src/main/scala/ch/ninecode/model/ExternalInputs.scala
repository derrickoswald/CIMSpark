package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Models Ancillary Service Requirements.
 *
 * Describes interval for which the requirement is applicable.
 *
 * @param sup Reference to the superclass object.
 * @param intervalStartTime The start of the time interval for which requirement is defined.
 * @param ReserveDemandCurve [[ch.ninecode.model.ReserveDemandCurve ReserveDemandCurve]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class ASRequirements
(
    override val sup: BasicElement = null,
    intervalStartTime: String = null,
    ReserveDemandCurve: List[String] = List()
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
    override def copy (): Row = { clone ().asInstanceOf[ASRequirements] }
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
        implicit val clz: String = ASRequirements.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ASRequirements.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ASRequirements.fields (position), x))
        emitelem (0, intervalStartTime)
        emitattrs (1, ReserveDemandCurve)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ASRequirements rdf:ID=\"%s\">\n%s\t</cim:ASRequirements>".format (id, export_fields)
    }
}

object ASRequirements
extends
    Parseable[ASRequirements]
{
    override val fields: Array[String] = Array[String] (
        "intervalStartTime",
        "ReserveDemandCurve"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ReserveDemandCurve", "ReserveDemandCurve", "1..*", "1")
    )
    val intervalStartTime: Fielder = parse_element (element (cls, fields(0)))
    val ReserveDemandCurve: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): ASRequirements =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ASRequirements (
            BasicElement.parse (context),
            mask (intervalStartTime (), 0),
            masks (ReserveDemandCurve (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Measurement quality flags for Analog Values.
 *
 * @param sup [[ch.ninecode.model.MeasurementValueQuality MeasurementValueQuality]] Reference to the superclass object.
 * @param scadaQualityCode The quality code for the given Analog Value.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class AnalogMeasurementValueQuality
(
    override val sup: MeasurementValueQuality = null,
    scadaQualityCode: String = null
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
    def MeasurementValueQuality: MeasurementValueQuality = sup.asInstanceOf[MeasurementValueQuality]
    override def copy (): Row = { clone ().asInstanceOf[AnalogMeasurementValueQuality] }
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
        implicit val clz: String = AnalogMeasurementValueQuality.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AnalogMeasurementValueQuality.fields (position), value)
        emitelem (0, scadaQualityCode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AnalogMeasurementValueQuality rdf:ID=\"%s\">\n%s\t</cim:AnalogMeasurementValueQuality>".format (id, export_fields)
    }
}

object AnalogMeasurementValueQuality
extends
    Parseable[AnalogMeasurementValueQuality]
{
    override val fields: Array[String] = Array[String] (
        "scadaQualityCode"
    )
    val scadaQualityCode: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): AnalogMeasurementValueQuality =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AnalogMeasurementValueQuality (
            MeasurementValueQuality.parse (context),
            mask (scadaQualityCode (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Area load curve definition.
 *
 * @param sup [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Reference to the superclass object.
 * @param forecastType Load forecast area type.
 * @param AggregateNode [[ch.ninecode.model.AggregateNode AggregateNode]] <em>undocumented</em>
 * @param TACArea [[ch.ninecode.model.TACArea TACArea]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class AreaLoadCurve
(
    override val sup: RegularIntervalSchedule = null,
    forecastType: String = null,
    AggregateNode: String = null,
    TACArea: String = null
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
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[AreaLoadCurve] }
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
        implicit val clz: String = AreaLoadCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AreaLoadCurve.fields (position), value)
        emitattr (0, forecastType)
        emitattr (1, AggregateNode)
        emitattr (2, TACArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AreaLoadCurve rdf:ID=\"%s\">\n%s\t</cim:AreaLoadCurve>".format (id, export_fields)
    }
}

object AreaLoadCurve
extends
    Parseable[AreaLoadCurve]
{
    override val fields: Array[String] = Array[String] (
        "forecastType",
        "AggregateNode",
        "TACArea"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AggregateNode", "AggregateNode", "0..1", "0..*"),
        Relationship ("TACArea", "TACArea", "0..1", "0..*")
    )
    val forecastType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val AggregateNode: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TACArea: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): AreaLoadCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AreaLoadCurve (
            RegularIntervalSchedule.parse (context),
            mask (forecastType (), 0),
            mask (AggregateNode (), 1),
            mask (TACArea (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Possibly time-varying max MW or MVA and optionally Min MW limit or MVA limit (Y1 and Y2, respectively) assigned to a contingency analysis base case.
 *
 * Use CurveSchedule XAxisUnits to specify MW or MVA. To be used only if the BaseCaseConstraintLimit differs from the DefaultConstraintLimit.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param SecurityConstraintSum [[ch.ninecode.model.SecurityConstraintSum SecurityConstraintSum]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class BaseCaseConstraintLimit
(
    override val sup: Curve = null,
    SecurityConstraintSum: String = null
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[BaseCaseConstraintLimit] }
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
        implicit val clz: String = BaseCaseConstraintLimit.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BaseCaseConstraintLimit.fields (position), value)
        emitattr (0, SecurityConstraintSum)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BaseCaseConstraintLimit rdf:ID=\"%s\">\n%s\t</cim:BaseCaseConstraintLimit>".format (id, export_fields)
    }
}

object BaseCaseConstraintLimit
extends
    Parseable[BaseCaseConstraintLimit]
{
    override val fields: Array[String] = Array[String] (
        "SecurityConstraintSum"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SecurityConstraintSum", "SecurityConstraintSum", "1", "0..1")
    )
    val SecurityConstraintSum: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): BaseCaseConstraintLimit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BaseCaseConstraintLimit (
            Curve.parse (context),
            mask (SecurityConstraintSum (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Dynamic flows and ratings associated with a branch end.
 *
 * @param sup Reference to the superclass object.
 * @param loadDumpRating The Load Dump Rating for the branch
 * @param longTermRating The Long Term Rating for the branch
 * @param mVARFlow The MVAR flow on the branch
 *        Attribute Usage: Reactive power flow at the series device, transformer, phase shifter, or line end
 * @param mwFlow The MW flow on the branch
 *        Attribute Usage: Active power flow at the series device, transformer, phase shifter, or line end
 * @param normalRating The Normal Rating for the branch
 * @param shortTermRating The Short Term Rating for the branch
 * @param MktACLineSegmentEndAFlow [[ch.ninecode.model.MktACLineSegment MktACLineSegment]] <em>undocumented</em>
 * @param MktACLineSegmentEndBFlow [[ch.ninecode.model.MktACLineSegment MktACLineSegment]] <em>undocumented</em>
 * @param MktPowerTransformerEndAFlow [[ch.ninecode.model.MktPowerTransformer MktPowerTransformer]] <em>undocumented</em>
 * @param MktPowerTransformerEndBFlow [[ch.ninecode.model.MktPowerTransformer MktPowerTransformer]] <em>undocumented</em>
 * @param MktSeriesCompensatorEndBFlow [[ch.ninecode.model.MktSeriesCompensator MktSeriesCompensator]] <em>undocumented</em>
 * @param MktSeriresCompensatorEndAFlow [[ch.ninecode.model.MktSeriesCompensator MktSeriesCompensator]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class BranchEndFlow
(
    override val sup: BasicElement = null,
    loadDumpRating: Double = 0.0,
    longTermRating: Double = 0.0,
    mVARFlow: Double = 0.0,
    mwFlow: Double = 0.0,
    normalRating: Double = 0.0,
    shortTermRating: Double = 0.0,
    MktACLineSegmentEndAFlow: List[String] = List(),
    MktACLineSegmentEndBFlow: List[String] = List(),
    MktPowerTransformerEndAFlow: List[String] = List(),
    MktPowerTransformerEndBFlow: List[String] = List(),
    MktSeriesCompensatorEndBFlow: List[String] = List(),
    MktSeriresCompensatorEndAFlow: List[String] = List()
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
    override def copy (): Row = { clone ().asInstanceOf[BranchEndFlow] }
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
        implicit val clz: String = BranchEndFlow.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BranchEndFlow.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (BranchEndFlow.fields (position), x))
        emitelem (0, loadDumpRating)
        emitelem (1, longTermRating)
        emitelem (2, mVARFlow)
        emitelem (3, mwFlow)
        emitelem (4, normalRating)
        emitelem (5, shortTermRating)
        emitattrs (6, MktACLineSegmentEndAFlow)
        emitattrs (7, MktACLineSegmentEndBFlow)
        emitattrs (8, MktPowerTransformerEndAFlow)
        emitattrs (9, MktPowerTransformerEndBFlow)
        emitattrs (10, MktSeriesCompensatorEndBFlow)
        emitattrs (11, MktSeriresCompensatorEndAFlow)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BranchEndFlow rdf:ID=\"%s\">\n%s\t</cim:BranchEndFlow>".format (id, export_fields)
    }
}

object BranchEndFlow
extends
    Parseable[BranchEndFlow]
{
    override val fields: Array[String] = Array[String] (
        "loadDumpRating",
        "longTermRating",
        "mVARFlow",
        "mwFlow",
        "normalRating",
        "shortTermRating",
        "MktACLineSegmentEndAFlow",
        "MktACLineSegmentEndBFlow",
        "MktPowerTransformerEndAFlow",
        "MktPowerTransformerEndBFlow",
        "MktSeriesCompensatorEndBFlow",
        "MktSeriresCompensatorEndAFlow"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MktACLineSegmentEndAFlow", "MktACLineSegment", "0..*", "0..1"),
        Relationship ("MktACLineSegmentEndBFlow", "MktACLineSegment", "0..*", "0..1"),
        Relationship ("MktPowerTransformerEndAFlow", "MktPowerTransformer", "0..*", "0..1"),
        Relationship ("MktPowerTransformerEndBFlow", "MktPowerTransformer", "0..*", "0..1"),
        Relationship ("MktSeriesCompensatorEndBFlow", "MktSeriesCompensator", "0..*", "0..1"),
        Relationship ("MktSeriresCompensatorEndAFlow", "MktSeriesCompensator", "0..*", "0..1")
    )
    val loadDumpRating: Fielder = parse_element (element (cls, fields(0)))
    val longTermRating: Fielder = parse_element (element (cls, fields(1)))
    val mVARFlow: Fielder = parse_element (element (cls, fields(2)))
    val mwFlow: Fielder = parse_element (element (cls, fields(3)))
    val normalRating: Fielder = parse_element (element (cls, fields(4)))
    val shortTermRating: Fielder = parse_element (element (cls, fields(5)))
    val MktACLineSegmentEndAFlow: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val MktACLineSegmentEndBFlow: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val MktPowerTransformerEndAFlow: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val MktPowerTransformerEndBFlow: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val MktSeriesCompensatorEndBFlow: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val MktSeriresCompensatorEndAFlow: FielderMultiple = parse_attributes (attribute (cls, fields(11)))

    def parse (context: Context): BranchEndFlow =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BranchEndFlow (
            BasicElement.parse (context),
            toDouble (mask (loadDumpRating (), 0)),
            toDouble (mask (longTermRating (), 1)),
            toDouble (mask (mVARFlow (), 2)),
            toDouble (mask (mwFlow (), 3)),
            toDouble (mask (normalRating (), 4)),
            toDouble (mask (shortTermRating (), 5)),
            masks (MktACLineSegmentEndAFlow (), 6),
            masks (MktACLineSegmentEndBFlow (), 7),
            masks (MktPowerTransformerEndAFlow (), 8),
            masks (MktPowerTransformerEndBFlow (), 9),
            masks (MktSeriesCompensatorEndBFlow (), 10),
            masks (MktSeriresCompensatorEndAFlow (), 11)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A constraint term is one element of a linear constraint.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param factor <em>undocumented</em>
 * @param function The function is an enumerated value that can be 'active', 'reactive', or 'VA' to indicate the type of flow.
 * @param SecurityConstraintSum [[ch.ninecode.model.SecurityConstraintSum SecurityConstraintSum]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class ConstraintTerm
(
    override val sup: IdentifiedObject = null,
    factor: String = null,
    function: String = null,
    SecurityConstraintSum: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[ConstraintTerm] }
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
        implicit val clz: String = ConstraintTerm.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ConstraintTerm.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ConstraintTerm.fields (position), value)
        emitelem (0, factor)
        emitelem (1, function)
        emitattr (2, SecurityConstraintSum)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ConstraintTerm rdf:ID=\"%s\">\n%s\t</cim:ConstraintTerm>".format (id, export_fields)
    }
}

object ConstraintTerm
extends
    Parseable[ConstraintTerm]
{
    override val fields: Array[String] = Array[String] (
        "factor",
        "function",
        "SecurityConstraintSum"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SecurityConstraintSum", "SecurityConstraintSum", "1", "0..*")
    )
    val factor: Fielder = parse_element (element (cls, fields(0)))
    val function: Fielder = parse_element (element (cls, fields(1)))
    val SecurityConstraintSum: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ConstraintTerm =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ConstraintTerm (
            IdentifiedObject.parse (context),
            mask (factor (), 0),
            mask (function (), 1),
            mask (SecurityConstraintSum (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Possibly time-varying max MW or MVA and optionally Min MW limit or MVA limit (Y1 and Y2, respectively) assigned to a constraint for a specific contingency.
 *
 * Use CurveSchedule XAxisUnits to specify MW or MVA.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param MWLimitSchedules [[ch.ninecode.model.MWLimitSchedule MWLimitSchedule]] <em>undocumented</em>
 * @param MktContingency [[ch.ninecode.model.MktContingency MktContingency]] <em>undocumented</em>
 * @param SecurityConstraintSum [[ch.ninecode.model.SecurityConstraintSum SecurityConstraintSum]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class ContingencyConstraintLimit
(
    override val sup: Curve = null,
    MWLimitSchedules: String = null,
    MktContingency: String = null,
    SecurityConstraintSum: String = null
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[ContingencyConstraintLimit] }
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
        implicit val clz: String = ContingencyConstraintLimit.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ContingencyConstraintLimit.fields (position), value)
        emitattr (0, MWLimitSchedules)
        emitattr (1, MktContingency)
        emitattr (2, SecurityConstraintSum)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ContingencyConstraintLimit rdf:ID=\"%s\">\n%s\t</cim:ContingencyConstraintLimit>".format (id, export_fields)
    }
}

object ContingencyConstraintLimit
extends
    Parseable[ContingencyConstraintLimit]
{
    override val fields: Array[String] = Array[String] (
        "MWLimitSchedules",
        "MktContingency",
        "SecurityConstraintSum"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MWLimitSchedules", "MWLimitSchedule", "1", "1"),
        Relationship ("MktContingency", "MktContingency", "1", "0..*"),
        Relationship ("SecurityConstraintSum", "SecurityConstraintSum", "1", "0..*")
    )
    val MWLimitSchedules: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MktContingency: Fielder = parse_attribute (attribute (cls, fields(1)))
    val SecurityConstraintSum: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ContingencyConstraintLimit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ContingencyConstraintLimit (
            Curve.parse (context),
            mask (MWLimitSchedules (), 0),
            mask (MktContingency (), 1),
            mask (SecurityConstraintSum (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * State Estimator Solution Pool Interchange and Losses.
 *
 * @param sup Reference to the superclass object.
 * @param solvedInterchange Pool MW Interchange
 *        Attribute Usage: The active power interchange of the pool
 * @param solvedLosses Pool Losses MW
 *        Attribute Usage: The active power losses of the pool in MW
 * @param MktControlArea [[ch.ninecode.model.MktControlArea MktControlArea]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class ControlAreaSolutionData
(
    override val sup: BasicElement = null,
    solvedInterchange: Double = 0.0,
    solvedLosses: Double = 0.0,
    MktControlArea: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[ControlAreaSolutionData] }
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
        implicit val clz: String = ControlAreaSolutionData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ControlAreaSolutionData.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ControlAreaSolutionData.fields (position), value)
        emitelem (0, solvedInterchange)
        emitelem (1, solvedLosses)
        emitattr (2, MktControlArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ControlAreaSolutionData rdf:ID=\"%s\">\n%s\t</cim:ControlAreaSolutionData>".format (id, export_fields)
    }
}

object ControlAreaSolutionData
extends
    Parseable[ControlAreaSolutionData]
{
    override val fields: Array[String] = Array[String] (
        "solvedInterchange",
        "solvedLosses",
        "MktControlArea"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MktControlArea", "MktControlArea", "0..1", "0..*")
    )
    val solvedInterchange: Fielder = parse_element (element (cls, fields(0)))
    val solvedLosses: Fielder = parse_element (element (cls, fields(1)))
    val MktControlArea: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ControlAreaSolutionData =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ControlAreaSolutionData (
            BasicElement.parse (context),
            toDouble (mask (solvedInterchange (), 0)),
            toDouble (mask (solvedLosses (), 1)),
            mask (MktControlArea (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * DefaultBid is a generic class to hold Default Energy Bid, Default Startup Bid, and Default Minimum Load Bid:
 * 
 * Default Energy Bid
 * A Default Energy Bid is a monotonically increasing staircase function consisting at maximum 10 economic bid segments, or 10 (\$/MW, MW) pairs.
 *
 * There are three methods for determining the Default Energy Bid:
 * <ul>
 * <li>Cost Based: derived from the Heat Rate or Average Cost multiplied by the Gas Price Index plus 10%.</li>
 * <li>LMP Based: a weighted average of LMPs in the preceding 90 days.</li>
 * <li>Negotiated: an amount negotiated with the designated Independent Entity.</li>
 * </ul>
 * 
 * Default Startup Bid
 * A Default Startup Bid (DSUB) shall be calculated for each RMR unit based on the Startup Cost stored in the Master File and the applicable GPI and EPI.
 * 
 * Default Minimum Load Bid
 * A Default Minimum Load Bid (DMLB) shall be calculated for each RMR unit based on the Minimum Load Cost stored in the Master File and the applicable GPI.
 *
 * @param sup [[ch.ninecode.model.Bid Bid]] Reference to the superclass object.
 * @param bidType Default bid type such as Default Energy Bid, Default Minimum Load Bid, and Default Startup Bid
 * @param minLoadCost Minimum load cost in \$/hr
 * @param peakFlag on-peak, off-peak, or all
 * @param DefaultBidCurve [[ch.ninecode.model.DefaultBidCurve DefaultBidCurve]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class DefaultBid
(
    override val sup: Bid = null,
    bidType: String = null,
    minLoadCost: Double = 0.0,
    peakFlag: String = null,
    DefaultBidCurve: String = null,
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
    def Bid: Bid = sup.asInstanceOf[Bid]
    override def copy (): Row = { clone ().asInstanceOf[DefaultBid] }
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
        implicit val clz: String = DefaultBid.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DefaultBid.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DefaultBid.fields (position), value)
        emitattr (0, bidType)
        emitelem (1, minLoadCost)
        emitattr (2, peakFlag)
        emitattr (3, DefaultBidCurve)
        emitattr (4, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DefaultBid rdf:ID=\"%s\">\n%s\t</cim:DefaultBid>".format (id, export_fields)
    }
}

object DefaultBid
extends
    Parseable[DefaultBid]
{
    override val fields: Array[String] = Array[String] (
        "bidType",
        "minLoadCost",
        "peakFlag",
        "DefaultBidCurve",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DefaultBidCurve", "DefaultBidCurve", "0..1", "0..1"),
        Relationship ("RegisteredResource", "RegisteredResource", "1", "0..1")
    )
    val bidType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val minLoadCost: Fielder = parse_element (element (cls, fields(1)))
    val peakFlag: Fielder = parse_attribute (attribute (cls, fields(2)))
    val DefaultBidCurve: Fielder = parse_attribute (attribute (cls, fields(3)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): DefaultBid =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DefaultBid (
            Bid.parse (context),
            mask (bidType (), 0),
            toDouble (mask (minLoadCost (), 1)),
            mask (peakFlag (), 2),
            mask (DefaultBidCurve (), 3),
            mask (RegisteredResource (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Default bid curve for default energy bid curve and default startup curves (cost and time).
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param curveType To indicate a type used for a default energy bid curve, such as LMP, cost or consultative based.
 * @param debAdderFlag Default energy bid adder flag
 * @param DefaultBid [[ch.ninecode.model.DefaultBid DefaultBid]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class DefaultBidCurve
(
    override val sup: Curve = null,
    curveType: String = null,
    debAdderFlag: String = null,
    DefaultBid: String = null
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[DefaultBidCurve] }
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
        implicit val clz: String = DefaultBidCurve.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DefaultBidCurve.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DefaultBidCurve.fields (position), value)
        emitelem (0, curveType)
        emitattr (1, debAdderFlag)
        emitattr (2, DefaultBid)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DefaultBidCurve rdf:ID=\"%s\">\n%s\t</cim:DefaultBidCurve>".format (id, export_fields)
    }
}

object DefaultBidCurve
extends
    Parseable[DefaultBidCurve]
{
    override val fields: Array[String] = Array[String] (
        "curveType",
        "debAdderFlag",
        "DefaultBid"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DefaultBid", "DefaultBid", "0..1", "0..1")
    )
    val curveType: Fielder = parse_element (element (cls, fields(0)))
    val debAdderFlag: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DefaultBid: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): DefaultBidCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DefaultBidCurve (
            Curve.parse (context),
            mask (curveType (), 0),
            mask (debAdderFlag (), 1),
            mask (DefaultBid (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Curve data for default bid curve and startup cost curve.
 *
 * @param sup [[ch.ninecode.model.CurveData CurveData]] Reference to the superclass object.
 * @param bidSegmentCalcType Type of calculation basis used to define the default bid segment curve.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class DefaultBidCurveData
(
    override val sup: CurveData = null,
    bidSegmentCalcType: String = null
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
    def CurveData: CurveData = sup.asInstanceOf[CurveData]
    override def copy (): Row = { clone ().asInstanceOf[DefaultBidCurveData] }
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
        implicit val clz: String = DefaultBidCurveData.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DefaultBidCurveData.fields (position), value)
        emitattr (0, bidSegmentCalcType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DefaultBidCurveData rdf:ID=\"%s\">\n%s\t</cim:DefaultBidCurveData>".format (id, export_fields)
    }
}

object DefaultBidCurveData
extends
    Parseable[DefaultBidCurveData]
{
    override val fields: Array[String] = Array[String] (
        "bidSegmentCalcType"
    )
    val bidSegmentCalcType: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): DefaultBidCurveData =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DefaultBidCurveData (
            CurveData.parse (context),
            mask (bidSegmentCalcType (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Possibly time-varying max MW or MVA and optionally Min MW limit or MVA limit (Y1 and Y2, respectively) applied as a default value if no specific constraint limits are specified for a contingency analysis.
 *
 * Use CurveSchedule XAxisUnits to specify MW or MVA.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param SecurityConstraintSum [[ch.ninecode.model.SecurityConstraintSum SecurityConstraintSum]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class DefaultConstraintLimit
(
    override val sup: Curve = null,
    SecurityConstraintSum: String = null
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[DefaultConstraintLimit] }
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
        implicit val clz: String = DefaultConstraintLimit.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DefaultConstraintLimit.fields (position), value)
        emitattr (0, SecurityConstraintSum)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DefaultConstraintLimit rdf:ID=\"%s\">\n%s\t</cim:DefaultConstraintLimit>".format (id, export_fields)
    }
}

object DefaultConstraintLimit
extends
    Parseable[DefaultConstraintLimit]
{
    override val fields: Array[String] = Array[String] (
        "SecurityConstraintSum"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SecurityConstraintSum", "SecurityConstraintSum", "1", "0..1")
    )
    val SecurityConstraintSum: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): DefaultConstraintLimit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DefaultConstraintLimit (
            Curve.parse (context),
            mask (SecurityConstraintSum (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Measurement quality flags for Discrete Values.
 *
 * @param sup [[ch.ninecode.model.MeasurementValueQuality MeasurementValueQuality]] Reference to the superclass object.
 * @param manualReplaceIndicator Switch Manual Replace Indicator.
 *        Flag indicating that the switch is manual replace.
 * @param removeFromOperationIndicator Removed From Operation Indicator.
 *        Flag indicating that the switch is removed from operation.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class DiscreteMeasurementValueQuality
(
    override val sup: MeasurementValueQuality = null,
    manualReplaceIndicator: Boolean = false,
    removeFromOperationIndicator: Boolean = false
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
    def MeasurementValueQuality: MeasurementValueQuality = sup.asInstanceOf[MeasurementValueQuality]
    override def copy (): Row = { clone ().asInstanceOf[DiscreteMeasurementValueQuality] }
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
        implicit val clz: String = DiscreteMeasurementValueQuality.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DiscreteMeasurementValueQuality.fields (position), value)
        emitelem (0, manualReplaceIndicator)
        emitelem (1, removeFromOperationIndicator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DiscreteMeasurementValueQuality rdf:ID=\"%s\">\n%s\t</cim:DiscreteMeasurementValueQuality>".format (id, export_fields)
    }
}

object DiscreteMeasurementValueQuality
extends
    Parseable[DiscreteMeasurementValueQuality]
{
    override val fields: Array[String] = Array[String] (
        "manualReplaceIndicator",
        "removeFromOperationIndicator"
    )
    val manualReplaceIndicator: Fielder = parse_element (element (cls, fields(0)))
    val removeFromOperationIndicator: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): DiscreteMeasurementValueQuality =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DiscreteMeasurementValueQuality (
            MeasurementValueQuality.parse (context),
            toBoolean (mask (manualReplaceIndicator (), 0)),
            toBoolean (mask (removeFromOperationIndicator (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A containing class that groups all the distribution factors within a market.
 *
 * This is calculated daily for DA factors and hourly for RT factors.
 *
 * @param sup Reference to the superclass object.
 * @param intervalEndTime The end of the time interval for which requirement is defined.
 * @param intervalStartTime The start of the time interval for which requirement is defined.
 * @param marketType Market type.
 * @param GenDistributionFactor [[ch.ninecode.model.GenDistributionFactor GenDistributionFactor]] <em>undocumented</em>
 * @param LoadDistributionFactor [[ch.ninecode.model.LoadDistributionFactor LoadDistributionFactor]] <em>undocumented</em>
 * @param SysLoadDistribuFactor [[ch.ninecode.model.SysLoadDistributionFactor SysLoadDistributionFactor]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class DistributionFactorSet
(
    override val sup: BasicElement = null,
    intervalEndTime: String = null,
    intervalStartTime: String = null,
    marketType: String = null,
    GenDistributionFactor: List[String] = List(),
    LoadDistributionFactor: List[String] = List(),
    SysLoadDistribuFactor: List[String] = List()
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
    override def copy (): Row = { clone ().asInstanceOf[DistributionFactorSet] }
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
        implicit val clz: String = DistributionFactorSet.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DistributionFactorSet.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DistributionFactorSet.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DistributionFactorSet.fields (position), x))
        emitelem (0, intervalEndTime)
        emitelem (1, intervalStartTime)
        emitattr (2, marketType)
        emitattrs (3, GenDistributionFactor)
        emitattrs (4, LoadDistributionFactor)
        emitattrs (5, SysLoadDistribuFactor)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DistributionFactorSet rdf:ID=\"%s\">\n%s\t</cim:DistributionFactorSet>".format (id, export_fields)
    }
}

object DistributionFactorSet
extends
    Parseable[DistributionFactorSet]
{
    override val fields: Array[String] = Array[String] (
        "intervalEndTime",
        "intervalStartTime",
        "marketType",
        "GenDistributionFactor",
        "LoadDistributionFactor",
        "SysLoadDistribuFactor"
    )
    override val relations: List[Relationship] = List (
        Relationship ("GenDistributionFactor", "GenDistributionFactor", "0..*", "0..*"),
        Relationship ("LoadDistributionFactor", "LoadDistributionFactor", "0..*", "0..*"),
        Relationship ("SysLoadDistribuFactor", "SysLoadDistributionFactor", "0..*", "0..*")
    )
    val intervalEndTime: Fielder = parse_element (element (cls, fields(0)))
    val intervalStartTime: Fielder = parse_element (element (cls, fields(1)))
    val marketType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val GenDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val LoadDistributionFactor: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val SysLoadDistribuFactor: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): DistributionFactorSet =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DistributionFactorSet (
            BasicElement.parse (context),
            mask (intervalEndTime (), 0),
            mask (intervalStartTime (), 1),
            mask (marketType (), 2),
            masks (GenDistributionFactor (), 3),
            masks (LoadDistributionFactor (), 4),
            masks (SysLoadDistribuFactor (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An Energy Price Index for each Resource is valid for a period (e.g. daily) that is identified by a Valid Period Start Time and a Valid Period End Time.
 *
 * An Energy Price Index is in \$/MWh.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param energyPriceIndex Energy price index
 * @param energyPriceIndexType EPI type such as wholesale or retail
 * @param lastModified Time updated
 * @param validPeriod Valid period for which the energy price index is valid.
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class EnergyPriceIndex
(
    override val sup: IdentifiedObject = null,
    energyPriceIndex: Double = 0.0,
    energyPriceIndexType: String = null,
    lastModified: String = null,
    validPeriod: String = null,
    RegisteredGenerator: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[EnergyPriceIndex] }
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
        implicit val clz: String = EnergyPriceIndex.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EnergyPriceIndex.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyPriceIndex.fields (position), value)
        emitelem (0, energyPriceIndex)
        emitattr (1, energyPriceIndexType)
        emitelem (2, lastModified)
        emitattr (3, validPeriod)
        emitattr (4, RegisteredGenerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergyPriceIndex rdf:ID=\"%s\">\n%s\t</cim:EnergyPriceIndex>".format (id, export_fields)
    }
}

object EnergyPriceIndex
extends
    Parseable[EnergyPriceIndex]
{
    override val fields: Array[String] = Array[String] (
        "energyPriceIndex",
        "energyPriceIndexType",
        "lastModified",
        "validPeriod",
        "RegisteredGenerator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", "1", "1")
    )
    val energyPriceIndex: Fielder = parse_element (element (cls, fields(0)))
    val energyPriceIndexType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val lastModified: Fielder = parse_element (element (cls, fields(2)))
    val validPeriod: Fielder = parse_attribute (attribute (cls, fields(3)))
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): EnergyPriceIndex =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnergyPriceIndex (
            IdentifiedObject.parse (context),
            toDouble (mask (energyPriceIndex (), 0)),
            mask (energyPriceIndexType (), 1),
            mask (lastModified (), 2),
            mask (validPeriod (), 3),
            mask (RegisteredGenerator (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Specifies the start time, stop time, level for an EnergyTransaction.
 *
 * @param sup [[ch.ninecode.model.Profile Profile]] Reference to the superclass object.
 * @param EnergyTransaction [[ch.ninecode.model.EnergyTransaction EnergyTransaction]] An EnergyTransaction shall have at least one EnergyProfile.
 * @param TransactionBid [[ch.ninecode.model.TransactionBid TransactionBid]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class EnergyProfile
(
    override val sup: Profile = null,
    EnergyTransaction: String = null,
    TransactionBid: String = null
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
    def Profile: Profile = sup.asInstanceOf[Profile]
    override def copy (): Row = { clone ().asInstanceOf[EnergyProfile] }
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
        implicit val clz: String = EnergyProfile.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyProfile.fields (position), value)
        emitattr (0, EnergyTransaction)
        emitattr (1, TransactionBid)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergyProfile rdf:ID=\"%s\">\n%s\t</cim:EnergyProfile>".format (id, export_fields)
    }
}

object EnergyProfile
extends
    Parseable[EnergyProfile]
{
    override val fields: Array[String] = Array[String] (
        "EnergyTransaction",
        "TransactionBid"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnergyTransaction", "EnergyTransaction", "1", "1..*"),
        Relationship ("TransactionBid", "TransactionBid", "1", "1..*")
    )
    val EnergyTransaction: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TransactionBid: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): EnergyProfile =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnergyProfile (
            Profile.parse (context),
            mask (EnergyTransaction (), 0),
            mask (TransactionBid (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Specifies the schedule for energy transfers between interchange areas that are necessary to satisfy the associated interchange transaction.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param capacityBacked Interchange capacity flag.
 *        When the flag is set to true, it indicates a transaction is capacity backed.
 * @param congestChargeMax Maximum congestion charges in monetary units.
 * @param deliveryPointP Delivery point active power.
 * @param energyMin Transaction minimum active power if dispatchable.
 * @param firmInterchangeFlag Firm interchange flag indicates whether or not this energy transaction can be changed without potential financial consequences.
 * @param payCongestion Willing to Pay congestion flag
 * @param reason Reason for energy transaction.
 * @param receiptPointP Receipt point active power.
 * @param state { Approve | Deny | Study }
 * @param CurtailmentProfiles [[ch.ninecode.model.CurtailmentProfile CurtailmentProfile]] An EnergyTransaction may be curtailed by any of the participating entities.
 * @param EnergyPriceCurves [[ch.ninecode.model.EnergyPriceCurve EnergyPriceCurve]] <em>undocumented</em>
 * @param EnergyProduct [[ch.ninecode.model.EnergyProduct EnergyProduct]] The "Source" for an EnergyTransaction is an EnergyProduct which is injected into a ControlArea.
 *        Typically this is a ServicePoint.
 * @param EnergyProfiles [[ch.ninecode.model.EnergyProfile EnergyProfile]] An EnergyTransaction shall have at least one EnergyProfile.
 * @param Export_SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] Energy is transferred between interchange areas
 * @param Import_SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] Energy is transferred between interchange areas
 * @param LossProfiles [[ch.ninecode.model.LossProfile LossProfile]] An EnergyTransaction may have a LossProfile.
 * @param TieLines [[ch.ninecode.model.TieLine TieLine]] A dynamic energy transaction can act as a pseudo tie line.
 * @param TransmissionReservation [[ch.ninecode.model.TransmissionReservation TransmissionReservation]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class EnergyTransaction
(
    override val sup: Document = null,
    capacityBacked: Boolean = false,
    congestChargeMax: Double = 0.0,
    deliveryPointP: Double = 0.0,
    energyMin: Double = 0.0,
    firmInterchangeFlag: Boolean = false,
    payCongestion: Boolean = false,
    reason: String = null,
    receiptPointP: Double = 0.0,
    state: String = null,
    CurtailmentProfiles: List[String] = List(),
    EnergyPriceCurves: List[String] = List(),
    EnergyProduct: String = null,
    EnergyProfiles: List[String] = List(),
    Export_SubControlArea: String = null,
    Import_SubControlArea: String = null,
    LossProfiles: List[String] = List(),
    TieLines: List[String] = List(),
    TransmissionReservation: String = null
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[EnergyTransaction] }
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
        implicit val clz: String = EnergyTransaction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EnergyTransaction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyTransaction.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EnergyTransaction.fields (position), x))
        emitelem (0, capacityBacked)
        emitelem (1, congestChargeMax)
        emitelem (2, deliveryPointP)
        emitelem (3, energyMin)
        emitelem (4, firmInterchangeFlag)
        emitelem (5, payCongestion)
        emitelem (6, reason)
        emitelem (7, receiptPointP)
        emitattr (8, state)
        emitattrs (9, CurtailmentProfiles)
        emitattrs (10, EnergyPriceCurves)
        emitattr (11, EnergyProduct)
        emitattrs (12, EnergyProfiles)
        emitattr (13, Export_SubControlArea)
        emitattr (14, Import_SubControlArea)
        emitattrs (15, LossProfiles)
        emitattrs (16, TieLines)
        emitattr (17, TransmissionReservation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergyTransaction rdf:ID=\"%s\">\n%s\t</cim:EnergyTransaction>".format (id, export_fields)
    }
}

object EnergyTransaction
extends
    Parseable[EnergyTransaction]
{
    override val fields: Array[String] = Array[String] (
        "capacityBacked",
        "congestChargeMax",
        "deliveryPointP",
        "energyMin",
        "firmInterchangeFlag",
        "payCongestion",
        "reason",
        "receiptPointP",
        "state",
        "CurtailmentProfiles",
        "EnergyPriceCurves",
        "EnergyProduct",
        "EnergyProfiles",
        "Export_SubControlArea",
        "Import_SubControlArea",
        "LossProfiles",
        "TieLines",
        "TransmissionReservation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CurtailmentProfiles", "CurtailmentProfile", "0..*", "1"),
        Relationship ("EnergyPriceCurves", "EnergyPriceCurve", "0..*", "0..*"),
        Relationship ("EnergyProduct", "EnergyProduct", "1", "1..*"),
        Relationship ("EnergyProfiles", "EnergyProfile", "1..*", "1"),
        Relationship ("Export_SubControlArea", "SubControlArea", "1", "0..*"),
        Relationship ("Import_SubControlArea", "SubControlArea", "1", "0..*"),
        Relationship ("LossProfiles", "LossProfile", "0..*", "1"),
        Relationship ("TieLines", "TieLine", "0..*", "0..1"),
        Relationship ("TransmissionReservation", "TransmissionReservation", "0..1", "0..1")
    )
    val capacityBacked: Fielder = parse_element (element (cls, fields(0)))
    val congestChargeMax: Fielder = parse_element (element (cls, fields(1)))
    val deliveryPointP: Fielder = parse_element (element (cls, fields(2)))
    val energyMin: Fielder = parse_element (element (cls, fields(3)))
    val firmInterchangeFlag: Fielder = parse_element (element (cls, fields(4)))
    val payCongestion: Fielder = parse_element (element (cls, fields(5)))
    val reason: Fielder = parse_element (element (cls, fields(6)))
    val receiptPointP: Fielder = parse_element (element (cls, fields(7)))
    val state: Fielder = parse_attribute (attribute (cls, fields(8)))
    val CurtailmentProfiles: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val EnergyPriceCurves: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val EnergyProduct: Fielder = parse_attribute (attribute (cls, fields(11)))
    val EnergyProfiles: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val Export_SubControlArea: Fielder = parse_attribute (attribute (cls, fields(13)))
    val Import_SubControlArea: Fielder = parse_attribute (attribute (cls, fields(14)))
    val LossProfiles: FielderMultiple = parse_attributes (attribute (cls, fields(15)))
    val TieLines: FielderMultiple = parse_attributes (attribute (cls, fields(16)))
    val TransmissionReservation: Fielder = parse_attribute (attribute (cls, fields(17)))

    def parse (context: Context): EnergyTransaction =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnergyTransaction (
            Document.parse (context),
            toBoolean (mask (capacityBacked (), 0)),
            toDouble (mask (congestChargeMax (), 1)),
            toDouble (mask (deliveryPointP (), 2)),
            toDouble (mask (energyMin (), 3)),
            toBoolean (mask (firmInterchangeFlag (), 4)),
            toBoolean (mask (payCongestion (), 5)),
            mask (reason (), 6),
            toDouble (mask (receiptPointP (), 7)),
            mask (state (), 8),
            masks (CurtailmentProfiles (), 9),
            masks (EnergyPriceCurves (), 10),
            mask (EnergyProduct (), 11),
            masks (EnergyProfiles (), 12),
            mask (Export_SubControlArea (), 13),
            mask (Import_SubControlArea (), 14),
            masks (LossProfiles (), 15),
            masks (TieLines (), 16),
            mask (TransmissionReservation (), 17)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class models the generation distribution factors.
 *
 * This class needs to be used along with the AggregatedPnode and the IndividualPnode to show the distribution of each individual party.
 *
 * @param sup Reference to the superclass object.
 * @param factor Used to calculate generation "participation" of an individual pnond in an AggregatePnode.
 * @param AggregatedPnode [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param DistributionFactorSet [[ch.ninecode.model.DistributionFactorSet DistributionFactorSet]] <em>undocumented</em>
 * @param IndividualPnode [[ch.ninecode.model.IndividualPnode IndividualPnode]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class GenDistributionFactor
(
    override val sup: BasicElement = null,
    factor: Double = 0.0,
    AggregatedPnode: String = null,
    DistributionFactorSet: List[String] = List(),
    IndividualPnode: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[GenDistributionFactor] }
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
        implicit val clz: String = GenDistributionFactor.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GenDistributionFactor.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GenDistributionFactor.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (GenDistributionFactor.fields (position), x))
        emitelem (0, factor)
        emitattr (1, AggregatedPnode)
        emitattrs (2, DistributionFactorSet)
        emitattr (3, IndividualPnode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GenDistributionFactor rdf:ID=\"%s\">\n%s\t</cim:GenDistributionFactor>".format (id, export_fields)
    }
}

object GenDistributionFactor
extends
    Parseable[GenDistributionFactor]
{
    override val fields: Array[String] = Array[String] (
        "factor",
        "AggregatedPnode",
        "DistributionFactorSet",
        "IndividualPnode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AggregatedPnode", "AggregatedPnode", "0..1", "1..*"),
        Relationship ("DistributionFactorSet", "DistributionFactorSet", "0..*", "0..*"),
        Relationship ("IndividualPnode", "IndividualPnode", "0..1", "0..1")
    )
    val factor: Fielder = parse_element (element (cls, fields(0)))
    val AggregatedPnode: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DistributionFactorSet: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val IndividualPnode: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): GenDistributionFactor =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GenDistributionFactor (
            BasicElement.parse (context),
            toDouble (mask (factor (), 0)),
            mask (AggregatedPnode (), 1),
            masks (DistributionFactorSet (), 2),
            mask (IndividualPnode (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Optimal Power Flow or State Estimator Unit Data for Operator Training Simulator.
 *
 * This is used for RealTime, Study and Maintenance Users.
 *
 * @param sup Reference to the superclass object.
 * @param lossFactor Loss Factor
 * @param mVAR Unit reactive power generation in MVAR
 * @param maximumMW The maximum active power generation of the unit in MW
 * @param minimumMW The minimum active power generation of the unit in MW
 * @param mw Unit active power generation in MW
 * @param sensitivity Unit sencivity factor.
 *        The distribution factors (DFAX) for the unit
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param MktGeneratingUnit [[ch.ninecode.model.MktGeneratingUnit MktGeneratingUnit]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class GeneratingUnitDynamicValues
(
    override val sup: BasicElement = null,
    lossFactor: Double = 0.0,
    mVAR: Double = 0.0,
    maximumMW: Double = 0.0,
    minimumMW: Double = 0.0,
    mw: Double = 0.0,
    sensitivity: Double = 0.0,
    Flowgate: String = null,
    MktGeneratingUnit: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[GeneratingUnitDynamicValues] }
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
        implicit val clz: String = GeneratingUnitDynamicValues.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GeneratingUnitDynamicValues.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GeneratingUnitDynamicValues.fields (position), value)
        emitelem (0, lossFactor)
        emitelem (1, mVAR)
        emitelem (2, maximumMW)
        emitelem (3, minimumMW)
        emitelem (4, mw)
        emitelem (5, sensitivity)
        emitattr (6, Flowgate)
        emitattr (7, MktGeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GeneratingUnitDynamicValues rdf:ID=\"%s\">\n%s\t</cim:GeneratingUnitDynamicValues>".format (id, export_fields)
    }
}

object GeneratingUnitDynamicValues
extends
    Parseable[GeneratingUnitDynamicValues]
{
    override val fields: Array[String] = Array[String] (
        "lossFactor",
        "mVAR",
        "maximumMW",
        "minimumMW",
        "mw",
        "sensitivity",
        "Flowgate",
        "MktGeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", "0..1", "0..*"),
        Relationship ("MktGeneratingUnit", "MktGeneratingUnit", "1", "0..*")
    )
    val lossFactor: Fielder = parse_element (element (cls, fields(0)))
    val mVAR: Fielder = parse_element (element (cls, fields(1)))
    val maximumMW: Fielder = parse_element (element (cls, fields(2)))
    val minimumMW: Fielder = parse_element (element (cls, fields(3)))
    val mw: Fielder = parse_element (element (cls, fields(4)))
    val sensitivity: Fielder = parse_element (element (cls, fields(5)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(6)))
    val MktGeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): GeneratingUnitDynamicValues =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GeneratingUnitDynamicValues (
            BasicElement.parse (context),
            toDouble (mask (lossFactor (), 0)),
            toDouble (mask (mVAR (), 1)),
            toDouble (mask (maximumMW (), 2)),
            toDouble (mask (minimumMW (), 3)),
            toDouble (mask (mw (), 4)),
            toDouble (mask (sensitivity (), 5)),
            mask (Flowgate (), 6),
            mask (MktGeneratingUnit (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Generic constraints can represent secure areas, voltage profile, transient stability and voltage collapse limits.
 *
 * The generic constraints can be one of the following forms:
 * a)	Thermal MW limit constraints type
 * b)	Group line flow constraint type
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param intervalEndTime Interval End Time
 * @param intervalStartTime Interval Start Time
 * @param maxLimit Maximum Limit (MW)
 * @param minLimit Minimum Limit (MW)
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param TransmissionCapacity [[ch.ninecode.model.TransmissionCapacity TransmissionCapacity]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class GenericConstraints
(
    override val sup: IdentifiedObject = null,
    intervalEndTime: String = null,
    intervalStartTime: String = null,
    maxLimit: Double = 0.0,
    minLimit: Double = 0.0,
    Flowgate: List[String] = List(),
    TransmissionCapacity: List[String] = List()
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
    override def copy (): Row = { clone ().asInstanceOf[GenericConstraints] }
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
        implicit val clz: String = GenericConstraints.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GenericConstraints.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (GenericConstraints.fields (position), x))
        emitelem (0, intervalEndTime)
        emitelem (1, intervalStartTime)
        emitelem (2, maxLimit)
        emitelem (3, minLimit)
        emitattrs (4, Flowgate)
        emitattrs (5, TransmissionCapacity)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GenericConstraints rdf:ID=\"%s\">\n%s\t</cim:GenericConstraints>".format (id, export_fields)
    }
}

object GenericConstraints
extends
    Parseable[GenericConstraints]
{
    override val fields: Array[String] = Array[String] (
        "intervalEndTime",
        "intervalStartTime",
        "maxLimit",
        "minLimit",
        "Flowgate",
        "TransmissionCapacity"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", "0..*", "0..1"),
        Relationship ("TransmissionCapacity", "TransmissionCapacity", "0..*", "0..1")
    )
    val intervalEndTime: Fielder = parse_element (element (cls, fields(0)))
    val intervalStartTime: Fielder = parse_element (element (cls, fields(1)))
    val maxLimit: Fielder = parse_element (element (cls, fields(2)))
    val minLimit: Fielder = parse_element (element (cls, fields(3)))
    val Flowgate: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val TransmissionCapacity: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): GenericConstraints =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GenericConstraints (
            IdentifiedObject.parse (context),
            mask (intervalEndTime (), 0),
            mask (intervalStartTime (), 1),
            toDouble (mask (maxLimit (), 2)),
            toDouble (mask (minLimit (), 3)),
            masks (Flowgate (), 4),
            masks (TransmissionCapacity (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Existing Transmission Contract data for an interchange schedule.
 *
 * @param sup Reference to the superclass object.
 * @param contractNumber Existing transmission contract number
 * @param usageMW Existing transmission contract usage MW value
 * @param InterchangeSchedule [[ch.ninecode.model.InterchangeSchedule InterchangeSchedule]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class InterchangeETCData
(
    override val sup: BasicElement = null,
    contractNumber: String = null,
    usageMW: Double = 0.0,
    InterchangeSchedule: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[InterchangeETCData] }
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
        implicit val clz: String = InterchangeETCData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (InterchangeETCData.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (InterchangeETCData.fields (position), value)
        emitelem (0, contractNumber)
        emitelem (1, usageMW)
        emitattr (2, InterchangeSchedule)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InterchangeETCData rdf:ID=\"%s\">\n%s\t</cim:InterchangeETCData>".format (id, export_fields)
    }
}

object InterchangeETCData
extends
    Parseable[InterchangeETCData]
{
    override val fields: Array[String] = Array[String] (
        "contractNumber",
        "usageMW",
        "InterchangeSchedule"
    )
    override val relations: List[Relationship] = List (
        Relationship ("InterchangeSchedule", "InterchangeSchedule", "0..1", "0..*")
    )
    val contractNumber: Fielder = parse_element (element (cls, fields(0)))
    val usageMW: Fielder = parse_element (element (cls, fields(1)))
    val InterchangeSchedule: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): InterchangeETCData =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = InterchangeETCData (
            BasicElement.parse (context),
            mask (contractNumber (), 0),
            toDouble (mask (usageMW (), 1)),
            mask (InterchangeSchedule (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Interchange schedule class to hold information for interchange schedules such as import export type, energy type, and etc.
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param checkOutType To indicate a check out type such as adjusted capacity or dispatch capacity.
 * @param directionType Import or export.
 * @param energyType Energy product type.
 * @param intervalLength Interval length.
 * @param marketType Market type.
 * @param operatingDate Operating date, hour.
 * @param outOfMarketType To indicate an out-of-market (OOM) schedule.
 * @param scheduleType Schedule type.
 * @param wcrID Wheeling Counter-Resource ID (required when Schedule Type=Wheel).
 * @param InterTie [[ch.ninecode.model.SchedulingPoint SchedulingPoint]] <em>undocumented</em>
 * @param InterchangeETCData [[ch.ninecode.model.InterchangeETCData InterchangeETCData]] <em>undocumented</em>
 * @param RegisteredInterTie [[ch.ninecode.model.RegisteredInterTie RegisteredInterTie]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class InterchangeSchedule
(
    override val sup: Curve = null,
    checkOutType: String = null,
    directionType: String = null,
    energyType: String = null,
    intervalLength: Int = 0,
    marketType: String = null,
    operatingDate: String = null,
    outOfMarketType: Boolean = false,
    scheduleType: String = null,
    wcrID: String = null,
    InterTie: String = null,
    InterchangeETCData: List[String] = List(),
    RegisteredInterTie: String = null
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[InterchangeSchedule] }
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
        implicit val clz: String = InterchangeSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (InterchangeSchedule.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (InterchangeSchedule.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (InterchangeSchedule.fields (position), x))
        emitattr (0, checkOutType)
        emitattr (1, directionType)
        emitattr (2, energyType)
        emitelem (3, intervalLength)
        emitattr (4, marketType)
        emitelem (5, operatingDate)
        emitelem (6, outOfMarketType)
        emitattr (7, scheduleType)
        emitelem (8, wcrID)
        emitattr (9, InterTie)
        emitattrs (10, InterchangeETCData)
        emitattr (11, RegisteredInterTie)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InterchangeSchedule rdf:ID=\"%s\">\n%s\t</cim:InterchangeSchedule>".format (id, export_fields)
    }
}

object InterchangeSchedule
extends
    Parseable[InterchangeSchedule]
{
    override val fields: Array[String] = Array[String] (
        "checkOutType",
        "directionType",
        "energyType",
        "intervalLength",
        "marketType",
        "operatingDate",
        "outOfMarketType",
        "scheduleType",
        "wcrID",
        "InterTie",
        "InterchangeETCData",
        "RegisteredInterTie"
    )
    override val relations: List[Relationship] = List (
        Relationship ("InterTie", "SchedulingPoint", "0..1", "0..*"),
        Relationship ("InterchangeETCData", "InterchangeETCData", "0..*", "0..1"),
        Relationship ("RegisteredInterTie", "RegisteredInterTie", "0..1", "0..*")
    )
    val checkOutType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val directionType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val energyType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val intervalLength: Fielder = parse_element (element (cls, fields(3)))
    val marketType: Fielder = parse_attribute (attribute (cls, fields(4)))
    val operatingDate: Fielder = parse_element (element (cls, fields(5)))
    val outOfMarketType: Fielder = parse_element (element (cls, fields(6)))
    val scheduleType: Fielder = parse_attribute (attribute (cls, fields(7)))
    val wcrID: Fielder = parse_element (element (cls, fields(8)))
    val InterTie: Fielder = parse_attribute (attribute (cls, fields(9)))
    val InterchangeETCData: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val RegisteredInterTie: Fielder = parse_attribute (attribute (cls, fields(11)))

    def parse (context: Context): InterchangeSchedule =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = InterchangeSchedule (
            Curve.parse (context),
            mask (checkOutType (), 0),
            mask (directionType (), 1),
            mask (energyType (), 2),
            toInteger (mask (intervalLength (), 3)),
            mask (marketType (), 4),
            mask (operatingDate (), 5),
            toBoolean (mask (outOfMarketType (), 6)),
            mask (scheduleType (), 7),
            mask (wcrID (), 8),
            mask (InterTie (), 9),
            masks (InterchangeETCData (), 10),
            mask (RegisteredInterTie (), 11)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Indicates whether unit is eligible for treatment as a intermittent variable renewable resource.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param eligibilityStatus Indicates whether a resource is eligible for PIRP program for a given hour
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class IntermittentResourceEligibility
(
    override val sup: MarketFactors = null,
    eligibilityStatus: String = null,
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[IntermittentResourceEligibility] }
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
        implicit val clz: String = IntermittentResourceEligibility.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (IntermittentResourceEligibility.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IntermittentResourceEligibility.fields (position), value)
        emitelem (0, eligibilityStatus)
        emitattr (1, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IntermittentResourceEligibility rdf:ID=\"%s\">\n%s\t</cim:IntermittentResourceEligibility>".format (id, export_fields)
    }
}

object IntermittentResourceEligibility
extends
    Parseable[IntermittentResourceEligibility]
{
    override val fields: Array[String] = Array[String] (
        "eligibilityStatus",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", "1", "0..*")
    )
    val eligibilityStatus: Fielder = parse_element (element (cls, fields(0)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): IntermittentResourceEligibility =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IntermittentResourceEligibility (
            MarketFactors.parse (context),
            mask (eligibilityStatus (), 0),
            mask (RegisteredResource (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class models the load distribution factors.
 *
 * This class should be used in one of two ways:
 * 
 * Use it along with the AggregatedPnode and the IndividualPnode to show the distriubtion of each individual party
 * 
 * OR
 * 
 * Use it with Mkt_EnergyConsumer to represent the current MW/Mvar distribution within it's parnet load group.
 *
 * @param sup Reference to the superclass object.
 * @param pDistFactor Real power (MW) load distribution factor
 * @param qDistFactor Reactive power (MVAr) load distribution factor
 * @param AggregatedPnode [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param DistributionFactorSet [[ch.ninecode.model.DistributionFactorSet DistributionFactorSet]] <em>undocumented</em>
 * @param IndividualPnode [[ch.ninecode.model.IndividualPnode IndividualPnode]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class LoadDistributionFactor
(
    override val sup: BasicElement = null,
    pDistFactor: Double = 0.0,
    qDistFactor: Double = 0.0,
    AggregatedPnode: String = null,
    DistributionFactorSet: List[String] = List(),
    IndividualPnode: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[LoadDistributionFactor] }
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
        implicit val clz: String = LoadDistributionFactor.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LoadDistributionFactor.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LoadDistributionFactor.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (LoadDistributionFactor.fields (position), x))
        emitelem (0, pDistFactor)
        emitelem (1, qDistFactor)
        emitattr (2, AggregatedPnode)
        emitattrs (3, DistributionFactorSet)
        emitattr (4, IndividualPnode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LoadDistributionFactor rdf:ID=\"%s\">\n%s\t</cim:LoadDistributionFactor>".format (id, export_fields)
    }
}

object LoadDistributionFactor
extends
    Parseable[LoadDistributionFactor]
{
    override val fields: Array[String] = Array[String] (
        "pDistFactor",
        "qDistFactor",
        "AggregatedPnode",
        "DistributionFactorSet",
        "IndividualPnode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AggregatedPnode", "AggregatedPnode", "0..1", "1..*"),
        Relationship ("DistributionFactorSet", "DistributionFactorSet", "0..*", "0..*"),
        Relationship ("IndividualPnode", "IndividualPnode", "0..1", "0..1")
    )
    val pDistFactor: Fielder = parse_element (element (cls, fields(0)))
    val qDistFactor: Fielder = parse_element (element (cls, fields(1)))
    val AggregatedPnode: Fielder = parse_attribute (attribute (cls, fields(2)))
    val DistributionFactorSet: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val IndividualPnode: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): LoadDistributionFactor =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LoadDistributionFactor (
            BasicElement.parse (context),
            toDouble (mask (pDistFactor (), 0)),
            toDouble (mask (qDistFactor (), 1)),
            mask (AggregatedPnode (), 2),
            masks (DistributionFactorSet (), 3),
            mask (IndividualPnode (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Loss sensitivity applied to a ConnectivityNode for a given time interval.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param lossFactor Loss penalty factor.
 *        Defined as: 1 / ( 1 - Incremental Transmission Loss); with the Incremental Transmission Loss expressed as a plus or minus value. The typical range of penalty factors is (0,9 to 1,1).
 * @param MktConnectivityNode [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class LossSensitivity
(
    override val sup: MarketFactors = null,
    lossFactor: Double = 0.0,
    MktConnectivityNode: String = null
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[LossSensitivity] }
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
        implicit val clz: String = LossSensitivity.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LossSensitivity.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LossSensitivity.fields (position), value)
        emitelem (0, lossFactor)
        emitattr (1, MktConnectivityNode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LossSensitivity rdf:ID=\"%s\">\n%s\t</cim:LossSensitivity>".format (id, export_fields)
    }
}

object LossSensitivity
extends
    Parseable[LossSensitivity]
{
    override val fields: Array[String] = Array[String] (
        "lossFactor",
        "MktConnectivityNode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MktConnectivityNode", "MktConnectivityNode", "1", "0..*")
    )
    val lossFactor: Fielder = parse_element (element (cls, fields(0)))
    val MktConnectivityNode: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): LossSensitivity =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LossSensitivity (
            MarketFactors.parse (context),
            toDouble (mask (lossFactor (), 0)),
            mask (MktConnectivityNode (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Maximum MW and optionally Minimum MW (Y1 and Y2, respectively).
 *
 * @param sup Reference to the superclass object.
 * @param SecurityConstraintLimit [[ch.ninecode.model.ContingencyConstraintLimit ContingencyConstraintLimit]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class MWLimitSchedule
(
    override val sup: BasicElement = null,
    SecurityConstraintLimit: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[MWLimitSchedule] }
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
        implicit val clz: String = MWLimitSchedule.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MWLimitSchedule.fields (position), value)
        emitattr (0, SecurityConstraintLimit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MWLimitSchedule rdf:ID=\"%s\">\n%s\t</cim:MWLimitSchedule>".format (id, export_fields)
    }
}

object MWLimitSchedule
extends
    Parseable[MWLimitSchedule]
{
    override val fields: Array[String] = Array[String] (
        "SecurityConstraintLimit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SecurityConstraintLimit", "ContingencyConstraintLimit", "1", "1")
    )
    val SecurityConstraintLimit: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): MWLimitSchedule =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MWLimitSchedule (
            BasicElement.parse (context),
            mask (SecurityConstraintLimit (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC 61970:Wires:ACLineSegment.
 *
 * @param sup [[ch.ninecode.model.ACLineSegment ACLineSegment]] Reference to the superclass object.
 * @param EndAFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @param EndBFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class MktACLineSegment
(
    override val sup: ACLineSegment = null,
    EndAFlow: String = null,
    EndBFlow: String = null
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
    def ACLineSegment: ACLineSegment = sup.asInstanceOf[ACLineSegment]
    override def copy (): Row = { clone ().asInstanceOf[MktACLineSegment] }
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
        implicit val clz: String = MktACLineSegment.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktACLineSegment.fields (position), value)
        emitattr (0, EndAFlow)
        emitattr (1, EndBFlow)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktACLineSegment rdf:ID=\"%s\">\n%s\t</cim:MktACLineSegment>".format (id, export_fields)
    }
}

object MktACLineSegment
extends
    Parseable[MktACLineSegment]
{
    override val fields: Array[String] = Array[String] (
        "EndAFlow",
        "EndBFlow"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EndAFlow", "BranchEndFlow", "0..1", "0..*"),
        Relationship ("EndBFlow", "BranchEndFlow", "0..1", "0..*")
    )
    val EndAFlow: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EndBFlow: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): MktACLineSegment =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktACLineSegment (
            ACLineSegment.parse (context),
            mask (EndAFlow (), 0),
            mask (EndBFlow (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC 61970:Meas:AnalogLimit.
 *
 * @param sup [[ch.ninecode.model.AnalogLimit AnalogLimit]] Reference to the superclass object.
 * @param exceededLimit true if limit exceeded
 * @param limitType The type of limit the value represents
 *        Branch Limit Types:
 *        Short Term
 *        Medium Term
 *        Long Term
 *        Voltage Limits:
 *        High
 *        Low
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class MktAnalogLimit
(
    override val sup: AnalogLimit = null,
    exceededLimit: Boolean = false,
    limitType: String = null
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
    def AnalogLimit: AnalogLimit = sup.asInstanceOf[AnalogLimit]
    override def copy (): Row = { clone ().asInstanceOf[MktAnalogLimit] }
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
        implicit val clz: String = MktAnalogLimit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MktAnalogLimit.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktAnalogLimit.fields (position), value)
        emitelem (0, exceededLimit)
        emitattr (1, limitType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktAnalogLimit rdf:ID=\"%s\">\n%s\t</cim:MktAnalogLimit>".format (id, export_fields)
    }
}

object MktAnalogLimit
extends
    Parseable[MktAnalogLimit]
{
    override val fields: Array[String] = Array[String] (
        "exceededLimit",
        "limitType"
    )
    val exceededLimit: Fielder = parse_element (element (cls, fields(0)))
    val limitType: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): MktAnalogLimit =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktAnalogLimit (
            AnalogLimit.parse (context),
            toBoolean (mask (exceededLimit (), 0)),
            mask (limitType (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC 61970:Meas:AnalogLimitSet.
 *
 * @param sup [[ch.ninecode.model.AnalogLimitSet AnalogLimitSet]] Reference to the superclass object.
 * @param ratingSet Rating set numbers
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class MktAnalogLimitSet
(
    override val sup: AnalogLimitSet = null,
    ratingSet: Int = 0
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
    def AnalogLimitSet: AnalogLimitSet = sup.asInstanceOf[AnalogLimitSet]
    override def copy (): Row = { clone ().asInstanceOf[MktAnalogLimitSet] }
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
        implicit val clz: String = MktAnalogLimitSet.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MktAnalogLimitSet.fields (position), value)
        emitelem (0, ratingSet)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktAnalogLimitSet rdf:ID=\"%s\">\n%s\t</cim:MktAnalogLimitSet>".format (id, export_fields)
    }
}

object MktAnalogLimitSet
extends
    Parseable[MktAnalogLimitSet]
{
    override val fields: Array[String] = Array[String] (
        "ratingSet"
    )
    val ratingSet: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): MktAnalogLimitSet =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktAnalogLimitSet (
            AnalogLimitSet.parse (context),
            toInteger (mask (ratingSet (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Market subclass of IEC 61970:ControlArea.
 *
 * @param sup [[ch.ninecode.model.ControlArea ControlArea]] Reference to the superclass object.
 * @param ControlAreaSolutionData [[ch.ninecode.model.ControlAreaSolutionData ControlAreaSolutionData]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class MktControlArea
(
    override val sup: ControlArea = null,
    ControlAreaSolutionData: List[String] = List()
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
    def ControlArea: ControlArea = sup.asInstanceOf[ControlArea]
    override def copy (): Row = { clone ().asInstanceOf[MktControlArea] }
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
        implicit val clz: String = MktControlArea.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MktControlArea.fields (position), x))
        emitattrs (0, ControlAreaSolutionData)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktControlArea rdf:ID=\"%s\">\n%s\t</cim:MktControlArea>".format (id, export_fields)
    }
}

object MktControlArea
extends
    Parseable[MktControlArea]
{
    override val fields: Array[String] = Array[String] (
        "ControlAreaSolutionData"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ControlAreaSolutionData", "ControlAreaSolutionData", "0..*", "0..1")
    )
    val ControlAreaSolutionData: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): MktControlArea =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktControlArea (
            ControlArea.parse (context),
            masks (ControlAreaSolutionData (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC 61970:Wires:SeriesCompensator.
 *
 * @param sup [[ch.ninecode.model.SeriesCompensator SeriesCompensator]] Reference to the superclass object.
 * @param EndAFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @param EndBFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class MktSeriesCompensator
(
    override val sup: SeriesCompensator = null,
    EndAFlow: String = null,
    EndBFlow: String = null
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
    def SeriesCompensator: SeriesCompensator = sup.asInstanceOf[SeriesCompensator]
    override def copy (): Row = { clone ().asInstanceOf[MktSeriesCompensator] }
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
        implicit val clz: String = MktSeriesCompensator.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktSeriesCompensator.fields (position), value)
        emitattr (0, EndAFlow)
        emitattr (1, EndBFlow)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktSeriesCompensator rdf:ID=\"%s\">\n%s\t</cim:MktSeriesCompensator>".format (id, export_fields)
    }
}

object MktSeriesCompensator
extends
    Parseable[MktSeriesCompensator]
{
    override val fields: Array[String] = Array[String] (
        "EndAFlow",
        "EndBFlow"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EndAFlow", "BranchEndFlow", "0..1", "0..*"),
        Relationship ("EndBFlow", "BranchEndFlow", "0..1", "0..*")
    )
    val EndAFlow: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EndBFlow: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): MktSeriesCompensator =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktSeriesCompensator (
            SeriesCompensator.parse (context),
            mask (EndAFlow (), 0),
            mask (EndBFlow (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC 61970:Wires:ShuntCompensator.
 *
 * @param sup [[ch.ninecode.model.ShuntCompensator ShuntCompensator]] Reference to the superclass object.
 * @param ShuntCompensatorDynamicData [[ch.ninecode.model.ShuntCompensatorDynamicData ShuntCompensatorDynamicData]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class MktShuntCompensator
(
    override val sup: ShuntCompensator = null,
    ShuntCompensatorDynamicData: List[String] = List()
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
    def ShuntCompensator: ShuntCompensator = sup.asInstanceOf[ShuntCompensator]
    override def copy (): Row = { clone ().asInstanceOf[MktShuntCompensator] }
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
        implicit val clz: String = MktShuntCompensator.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MktShuntCompensator.fields (position), x))
        emitattrs (0, ShuntCompensatorDynamicData)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktShuntCompensator rdf:ID=\"%s\">\n%s\t</cim:MktShuntCompensator>".format (id, export_fields)
    }
}

object MktShuntCompensator
extends
    Parseable[MktShuntCompensator]
{
    override val fields: Array[String] = Array[String] (
        "ShuntCompensatorDynamicData"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ShuntCompensatorDynamicData", "ShuntCompensatorDynamicData", "0..*", "1")
    )
    val ShuntCompensatorDynamicData: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): MktShuntCompensator =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktShuntCompensator (
            ShuntCompensator.parse (context),
            masks (ShuntCompensatorDynamicData (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC 61970:Wires:Switch.
 *
 * @param sup [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @param SwitchStatus [[ch.ninecode.model.SwitchStatus SwitchStatus]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class MktSwitch
(
    override val sup: Switch = null,
    SwitchStatus: List[String] = List()
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
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { clone ().asInstanceOf[MktSwitch] }
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
        implicit val clz: String = MktSwitch.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MktSwitch.fields (position), x))
        emitattrs (0, SwitchStatus)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktSwitch rdf:ID=\"%s\">\n%s\t</cim:MktSwitch>".format (id, export_fields)
    }
}

object MktSwitch
extends
    Parseable[MktSwitch]
{
    override val fields: Array[String] = Array[String] (
        "SwitchStatus"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SwitchStatus", "SwitchStatus", "0..*", "1")
    )
    val SwitchStatus: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): MktSwitch =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktSwitch (
            Switch.parse (context),
            masks (SwitchStatus (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Subclass of IEC 61970:Wires:TapChanger.
 *
 * @param sup [[ch.ninecode.model.TapChanger TapChanger]] Reference to the superclass object.
 * @param TapChangerDynamicData [[ch.ninecode.model.TapChangerDynamicData TapChangerDynamicData]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class MktTapChanger
(
    override val sup: TapChanger = null,
    TapChangerDynamicData: List[String] = List()
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
    def TapChanger: TapChanger = sup.asInstanceOf[TapChanger]
    override def copy (): Row = { clone ().asInstanceOf[MktTapChanger] }
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
        implicit val clz: String = MktTapChanger.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MktTapChanger.fields (position), x))
        emitattrs (0, TapChangerDynamicData)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktTapChanger rdf:ID=\"%s\">\n%s\t</cim:MktTapChanger>".format (id, export_fields)
    }
}

object MktTapChanger
extends
    Parseable[MktTapChanger]
{
    override val fields: Array[String] = Array[String] (
        "TapChangerDynamicData"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TapChangerDynamicData", "TapChangerDynamicData", "0..*", "1")
    )
    val TapChangerDynamicData: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): MktTapChanger =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktTapChanger (
            TapChanger.parse (context),
            masks (TapChangerDynamicData (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * To be used only to constrain a quantity that cannot be associated with a terminal.
 *
 * For example, a registered generating unit that is not electrically connected to the network.
 *
 * @param sup [[ch.ninecode.model.ConstraintTerm ConstraintTerm]] Reference to the superclass object.
 * @param MktConnectivityNode [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class NodeConstraintTerm
(
    override val sup: ConstraintTerm = null,
    MktConnectivityNode: String = null
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
    def ConstraintTerm: ConstraintTerm = sup.asInstanceOf[ConstraintTerm]
    override def copy (): Row = { clone ().asInstanceOf[NodeConstraintTerm] }
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
        implicit val clz: String = NodeConstraintTerm.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (NodeConstraintTerm.fields (position), value)
        emitattr (0, MktConnectivityNode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NodeConstraintTerm rdf:ID=\"%s\">\n%s\t</cim:NodeConstraintTerm>".format (id, export_fields)
    }
}

object NodeConstraintTerm
extends
    Parseable[NodeConstraintTerm]
{
    override val fields: Array[String] = Array[String] (
        "MktConnectivityNode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MktConnectivityNode", "MktConnectivityNode", "1", "0..*")
    )
    val MktConnectivityNode: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): NodeConstraintTerm =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NodeConstraintTerm (
            ConstraintTerm.parse (context),
            mask (MktConnectivityNode (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A profile is a simpler curve type.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ProfileDatas [[ch.ninecode.model.ProfileData ProfileData]] A profile has profile data associated with it.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class Profile
(
    override val sup: IdentifiedObject = null,
    ProfileDatas: List[String] = List()
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
    override def copy (): Row = { clone ().asInstanceOf[Profile] }
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
        implicit val clz: String = Profile.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Profile.fields (position), x))
        emitattrs (0, ProfileDatas)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Profile rdf:ID=\"%s\">\n%s\t</cim:Profile>".format (id, export_fields)
    }
}

object Profile
extends
    Parseable[Profile]
{
    override val fields: Array[String] = Array[String] (
        "ProfileDatas"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProfileDatas", "ProfileData", "0..*", "0..*")
    )
    val ProfileDatas: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): Profile =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Profile (
            IdentifiedObject.parse (context),
            masks (ProfileDatas (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Data for profile.
 *
 * @param sup Reference to the superclass object.
 * @param bidPrice Bid price associated with contract
 * @param capacityLevel Capacity level for the profile, in MW.
 * @param energyLevel Energy level for the profile, in MWH.
 * @param minimumLevel Minimum MW value of contract
 * @param sequenceNumber Sequence to provide item numbering for the profile. { greater than or equal to 1 }
 * @param startDateTime Start date/time for this profile.
 * @param stopDateTime Stop date/time for this profile.
 * @param Profile [[ch.ninecode.model.Profile Profile]] A profile has profile data associated with it.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class ProfileData
(
    override val sup: BasicElement = null,
    bidPrice: Double = 0.0,
    capacityLevel: Double = 0.0,
    energyLevel: Double = 0.0,
    minimumLevel: Double = 0.0,
    sequenceNumber: Int = 0,
    startDateTime: String = null,
    stopDateTime: String = null,
    Profile: List[String] = List()
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
    override def copy (): Row = { clone ().asInstanceOf[ProfileData] }
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
        implicit val clz: String = ProfileData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProfileData.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ProfileData.fields (position), x))
        emitelem (0, bidPrice)
        emitelem (1, capacityLevel)
        emitelem (2, energyLevel)
        emitelem (3, minimumLevel)
        emitelem (4, sequenceNumber)
        emitelem (5, startDateTime)
        emitelem (6, stopDateTime)
        emitattrs (7, Profile)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProfileData rdf:ID=\"%s\">\n%s\t</cim:ProfileData>".format (id, export_fields)
    }
}

object ProfileData
extends
    Parseable[ProfileData]
{
    override val fields: Array[String] = Array[String] (
        "bidPrice",
        "capacityLevel",
        "energyLevel",
        "minimumLevel",
        "sequenceNumber",
        "startDateTime",
        "stopDateTime",
        "Profile"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Profile", "Profile", "0..*", "0..*")
    )
    val bidPrice: Fielder = parse_element (element (cls, fields(0)))
    val capacityLevel: Fielder = parse_element (element (cls, fields(1)))
    val energyLevel: Fielder = parse_element (element (cls, fields(2)))
    val minimumLevel: Fielder = parse_element (element (cls, fields(3)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(4)))
    val startDateTime: Fielder = parse_element (element (cls, fields(5)))
    val stopDateTime: Fielder = parse_element (element (cls, fields(6)))
    val Profile: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): ProfileData =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ProfileData (
            BasicElement.parse (context),
            toDouble (mask (bidPrice (), 0)),
            toDouble (mask (capacityLevel (), 1)),
            toDouble (mask (energyLevel (), 2)),
            toDouble (mask (minimumLevel (), 3)),
            toInteger (mask (sequenceNumber (), 4)),
            mask (startDateTime (), 5),
            mask (stopDateTime (), 6),
            masks (Profile (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Reserve demand curve.
 *
 * Models maximum quantities of reserve required per Market Region and models a reserve demand curve for the minimum quantities of reserve. The ReserveDemandCurve is a relationship between unit operating reserve price in \$/MWhr (Y-axis) and unit reserves in MW (X-axis).
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param reqMaxMW Region requirement maximum limit
 * @param reserveRequirementType Reserve requirement type that the max and curve apply to.
 *        For example, operating reserve, regulation and contingency.
 * @param ASRequirements [[ch.ninecode.model.ASRequirements ASRequirements]] <em>undocumented</em>
 * @param MarketRegion [[ch.ninecode.model.MarketRegion MarketRegion]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class ReserveDemandCurve
(
    override val sup: Curve = null,
    reqMaxMW: Double = 0.0,
    reserveRequirementType: String = null,
    ASRequirements: String = null,
    MarketRegion: String = null
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[ReserveDemandCurve] }
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
        implicit val clz: String = ReserveDemandCurve.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ReserveDemandCurve.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ReserveDemandCurve.fields (position), value)
        emitelem (0, reqMaxMW)
        emitattr (1, reserveRequirementType)
        emitattr (2, ASRequirements)
        emitattr (3, MarketRegion)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ReserveDemandCurve rdf:ID=\"%s\">\n%s\t</cim:ReserveDemandCurve>".format (id, export_fields)
    }
}

object ReserveDemandCurve
extends
    Parseable[ReserveDemandCurve]
{
    override val fields: Array[String] = Array[String] (
        "reqMaxMW",
        "reserveRequirementType",
        "ASRequirements",
        "MarketRegion"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ASRequirements", "ASRequirements", "1", "1..*"),
        Relationship ("MarketRegion", "MarketRegion", "1", "0..*")
    )
    val reqMaxMW: Fielder = parse_element (element (cls, fields(0)))
    val reserveRequirementType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ASRequirements: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MarketRegion: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): ReserveDemandCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ReserveDemandCurve (
            Curve.parse (context),
            toDouble (mask (reqMaxMW (), 0)),
            mask (reserveRequirementType (), 1),
            mask (ASRequirements (), 2),
            mask (MarketRegion (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Contains information about the update from SCADA.
 *
 * @param sup Reference to the superclass object.
 * @param timeStamp time of the update from SCADA
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class SCADAInformation
(
    override val sup: BasicElement = null,
    timeStamp: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[SCADAInformation] }
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
        implicit val clz: String = SCADAInformation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SCADAInformation.fields (position), value)
        emitelem (0, timeStamp)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SCADAInformation rdf:ID=\"%s\">\n%s\t</cim:SCADAInformation>".format (id, export_fields)
    }
}

object SCADAInformation
extends
    Parseable[SCADAInformation]
{
    override val fields: Array[String] = Array[String] (
        "timeStamp"
    )
    val timeStamp: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): SCADAInformation =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SCADAInformation (
            BasicElement.parse (context),
            mask (timeStamp (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Typically provided by RTO systems, constraints identified in both base case and critical contingency cases have to be transferred.
 *
 * A constraint has N (&gt;=1) constraint terms. A term is represented by an instance of TerminalConstraintTerm.
 * The constraint expression is:
 * minValue &lt;= c1*x1 + c2*x2 + .... cn*xn + k &lt;= maxValue
 * where:
 * - cn is ConstraintTerm.factor
 * - xn is the flow at the terminal
 * Flow into the associated equipment is positive for the purpose of ConnectivityNode NodeConstraintTerm.
 * 
 * k is SecurityConstraintsLinear.resourceMW.
 * The units of k are assumed to be same as the units of the flows, xn.  The constants, cn, are dimensionless.
 * With these conventions, cn and k are all positive for a typical constraint such as "weighted sum of generation shall be less than limit". Furthermore, cn are all 1.0 for a case such as "interface flow shall be less than limit", assuming the terminals are chosen on the importing side of the interface.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param BaseCaseConstraintLimit [[ch.ninecode.model.BaseCaseConstraintLimit BaseCaseConstraintLimit]] <em>undocumented</em>
 * @param ConstraintTerms [[ch.ninecode.model.ConstraintTerm ConstraintTerm]] <em>undocumented</em>
 * @param ContingencyConstraintLimits [[ch.ninecode.model.ContingencyConstraintLimit ContingencyConstraintLimit]] <em>undocumented</em>
 * @param DefaultConstraintLimit [[ch.ninecode.model.DefaultConstraintLimit DefaultConstraintLimit]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class SecurityConstraintSum
(
    override val sup: MarketFactors = null,
    BaseCaseConstraintLimit: String = null,
    ConstraintTerms: List[String] = List(),
    ContingencyConstraintLimits: List[String] = List(),
    DefaultConstraintLimit: String = null,
    RTO: String = null
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[SecurityConstraintSum] }
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
        implicit val clz: String = SecurityConstraintSum.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SecurityConstraintSum.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SecurityConstraintSum.fields (position), x))
        emitattr (0, BaseCaseConstraintLimit)
        emitattrs (1, ConstraintTerms)
        emitattrs (2, ContingencyConstraintLimits)
        emitattr (3, DefaultConstraintLimit)
        emitattr (4, RTO)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SecurityConstraintSum rdf:ID=\"%s\">\n%s\t</cim:SecurityConstraintSum>".format (id, export_fields)
    }
}

object SecurityConstraintSum
extends
    Parseable[SecurityConstraintSum]
{
    override val fields: Array[String] = Array[String] (
        "BaseCaseConstraintLimit",
        "ConstraintTerms",
        "ContingencyConstraintLimits",
        "DefaultConstraintLimit",
        "RTO"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BaseCaseConstraintLimit", "BaseCaseConstraintLimit", "0..1", "1"),
        Relationship ("ConstraintTerms", "ConstraintTerm", "0..*", "1"),
        Relationship ("ContingencyConstraintLimits", "ContingencyConstraintLimit", "0..*", "1"),
        Relationship ("DefaultConstraintLimit", "DefaultConstraintLimit", "0..1", "1"),
        Relationship ("RTO", "RTO", "0..1", "0..*")
    )
    val BaseCaseConstraintLimit: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ConstraintTerms: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ContingencyConstraintLimits: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val DefaultConstraintLimit: Fielder = parse_attribute (attribute (cls, fields(3)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): SecurityConstraintSum =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SecurityConstraintSum (
            MarketFactors.parse (context),
            mask (BaseCaseConstraintLimit (), 0),
            masks (ConstraintTerms (), 1),
            masks (ContingencyConstraintLimits (), 2),
            mask (DefaultConstraintLimit (), 3),
            mask (RTO (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Typical for regional transmission operators (RTOs), these constraints include transmission as well as generation group constraints identified in both base case and critical contingency cases.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param actualMW Actual branch or group of branches MW flow (only for transmission constraints)
 * @param maxMW Maximum MW limit
 * @param minMW Minimum MW limit (only for transmission constraints).
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param GeneratingBid [[ch.ninecode.model.GeneratingBid GeneratingBid]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class SecurityConstraints
(
    override val sup: IdentifiedObject = null,
    actualMW: Double = 0.0,
    maxMW: Double = 0.0,
    minMW: Double = 0.0,
    Flowgate: String = null,
    GeneratingBid: String = null,
    RTO: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[SecurityConstraints] }
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
        implicit val clz: String = SecurityConstraints.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SecurityConstraints.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SecurityConstraints.fields (position), value)
        emitelem (0, actualMW)
        emitelem (1, maxMW)
        emitelem (2, minMW)
        emitattr (3, Flowgate)
        emitattr (4, GeneratingBid)
        emitattr (5, RTO)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SecurityConstraints rdf:ID=\"%s\">\n%s\t</cim:SecurityConstraints>".format (id, export_fields)
    }
}

object SecurityConstraints
extends
    Parseable[SecurityConstraints]
{
    override val fields: Array[String] = Array[String] (
        "actualMW",
        "maxMW",
        "minMW",
        "Flowgate",
        "GeneratingBid",
        "RTO"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", "0..1", "0..1"),
        Relationship ("GeneratingBid", "GeneratingBid", "0..1", "0..*"),
        Relationship ("RTO", "RTO", "0..1", "0..*")
    )
    val actualMW: Fielder = parse_element (element (cls, fields(0)))
    val maxMW: Fielder = parse_element (element (cls, fields(1)))
    val minMW: Fielder = parse_element (element (cls, fields(2)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(3)))
    val GeneratingBid: Fielder = parse_attribute (attribute (cls, fields(4)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): SecurityConstraints =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SecurityConstraints (
            IdentifiedObject.parse (context),
            toDouble (mask (actualMW (), 0)),
            toDouble (mask (maxMW (), 1)),
            toDouble (mask (minMW (), 2)),
            mask (Flowgate (), 3),
            mask (GeneratingBid (), 4),
            mask (RTO (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The defined termination points of a transmission path.
 *
 * Service points are defined from the viewpoint of the transmission service. Each service point is contained within (or on the boundary of) an interchange area. A service point is source or destination of a transaction.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param PODTransmissionPath [[ch.ninecode.model.TransmissionPath TransmissionPath]] A transmission path has a "point-of-delivery" service point
 * @param PORTransmissionPath [[ch.ninecode.model.TransmissionPath TransmissionPath]] A transmission path has a "point-of-receipt" service point
 * @param SinkReservation [[ch.ninecode.model.TransmissionReservation TransmissionReservation]] <em>undocumented</em>
 * @param SourceReservation [[ch.ninecode.model.TransmissionReservation TransmissionReservation]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class ServicePoint
(
    override val sup: IdentifiedObject = null,
    PODTransmissionPath: List[String] = List(),
    PORTransmissionPath: List[String] = List(),
    SinkReservation: List[String] = List(),
    SourceReservation: List[String] = List()
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
    override def copy (): Row = { clone ().asInstanceOf[ServicePoint] }
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
        implicit val clz: String = ServicePoint.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ServicePoint.fields (position), x))
        emitattrs (0, PODTransmissionPath)
        emitattrs (1, PORTransmissionPath)
        emitattrs (2, SinkReservation)
        emitattrs (3, SourceReservation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ServicePoint rdf:ID=\"%s\">\n%s\t</cim:ServicePoint>".format (id, export_fields)
    }
}

object ServicePoint
extends
    Parseable[ServicePoint]
{
    override val fields: Array[String] = Array[String] (
        "PODTransmissionPath",
        "PORTransmissionPath",
        "SinkReservation",
        "SourceReservation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PODTransmissionPath", "TransmissionPath", "0..*", "1"),
        Relationship ("PORTransmissionPath", "TransmissionPath", "0..*", "1"),
        Relationship ("SinkReservation", "TransmissionReservation", "0..*", "0..1"),
        Relationship ("SourceReservation", "TransmissionReservation", "0..*", "0..1")
    )
    val PODTransmissionPath: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val PORTransmissionPath: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val SinkReservation: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val SourceReservation: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): ServicePoint =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ServicePoint (
            IdentifiedObject.parse (context),
            masks (PODTransmissionPath (), 0),
            masks (PORTransmissionPath (), 1),
            masks (SinkReservation (), 2),
            masks (SourceReservation (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Optimal Power Flow or State Estimator Filter Bank Data for OTS.
 *
 * This is used for RealTime, Study and Maintenance Users.
 *
 * @param sup Reference to the superclass object.
 * @param connectionStatus The current status for the Voltage Control Capacitor 1= Connected 0 = Disconnected
 * @param desiredVoltage The desired voltage for the Voltage Control Capacitor
 * @param mVARInjection The injection of reactive power of the filter bank in the NA solution or VCS reactive power production
 * @param stepPosition Voltage control capacitor step position
 * @param voltageRegulationStatus Indicator if the voltage control this is regulating True = Yes, False = No
 * @param MktShuntCompensator [[ch.ninecode.model.MktShuntCompensator MktShuntCompensator]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class ShuntCompensatorDynamicData
(
    override val sup: BasicElement = null,
    connectionStatus: Int = 0,
    desiredVoltage: Double = 0.0,
    mVARInjection: Double = 0.0,
    stepPosition: Int = 0,
    voltageRegulationStatus: Boolean = false,
    MktShuntCompensator: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[ShuntCompensatorDynamicData] }
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
        implicit val clz: String = ShuntCompensatorDynamicData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ShuntCompensatorDynamicData.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ShuntCompensatorDynamicData.fields (position), value)
        emitelem (0, connectionStatus)
        emitelem (1, desiredVoltage)
        emitelem (2, mVARInjection)
        emitelem (3, stepPosition)
        emitelem (4, voltageRegulationStatus)
        emitattr (5, MktShuntCompensator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ShuntCompensatorDynamicData rdf:ID=\"%s\">\n%s\t</cim:ShuntCompensatorDynamicData>".format (id, export_fields)
    }
}

object ShuntCompensatorDynamicData
extends
    Parseable[ShuntCompensatorDynamicData]
{
    override val fields: Array[String] = Array[String] (
        "connectionStatus",
        "desiredVoltage",
        "mVARInjection",
        "stepPosition",
        "voltageRegulationStatus",
        "MktShuntCompensator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MktShuntCompensator", "MktShuntCompensator", "1", "0..*")
    )
    val connectionStatus: Fielder = parse_element (element (cls, fields(0)))
    val desiredVoltage: Fielder = parse_element (element (cls, fields(1)))
    val mVARInjection: Fielder = parse_element (element (cls, fields(2)))
    val stepPosition: Fielder = parse_element (element (cls, fields(3)))
    val voltageRegulationStatus: Fielder = parse_element (element (cls, fields(4)))
    val MktShuntCompensator: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): ShuntCompensatorDynamicData =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ShuntCompensatorDynamicData (
            BasicElement.parse (context),
            toInteger (mask (connectionStatus (), 0)),
            toDouble (mask (desiredVoltage (), 1)),
            toDouble (mask (mVARInjection (), 2)),
            toInteger (mask (stepPosition (), 3)),
            toBoolean (mask (voltageRegulationStatus (), 4)),
            mask (MktShuntCompensator (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Optimal Power Flow or State Estimator Circuit Breaker Status.
 *
 * @param sup Reference to the superclass object.
 * @param switchStatus Circuit Breaker Status (closed or open) of the circuit breaker from the power flow.
 * @param MktSwitch [[ch.ninecode.model.MktSwitch MktSwitch]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class SwitchStatus
(
    override val sup: BasicElement = null,
    switchStatus: String = null,
    MktSwitch: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[SwitchStatus] }
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
        implicit val clz: String = SwitchStatus.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchStatus.fields (position), value)
        emitattr (0, switchStatus)
        emitattr (1, MktSwitch)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SwitchStatus rdf:ID=\"%s\">\n%s\t</cim:SwitchStatus>".format (id, export_fields)
    }
}

object SwitchStatus
extends
    Parseable[SwitchStatus]
{
    override val fields: Array[String] = Array[String] (
        "switchStatus",
        "MktSwitch"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MktSwitch", "MktSwitch", "1", "0..*")
    )
    val switchStatus: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MktSwitch: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): SwitchStatus =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SwitchStatus (
            BasicElement.parse (context),
            mask (switchStatus (), 0),
            mask (MktSwitch (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class models the system distribution factors.
 *
 * This class needs to be used along with the HostControlArea and the ConnectivityNode to show the distribution of each individual party.
 *
 * @param sup Reference to the superclass object.
 * @param factor Used to calculate load "participation" of a connectivity node in an host control area
 * @param DistributionFactorSet [[ch.ninecode.model.DistributionFactorSet DistributionFactorSet]] <em>undocumented</em>
 * @param HostControlArea [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param MktConnectivityNode [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class SysLoadDistributionFactor
(
    override val sup: BasicElement = null,
    factor: Double = 0.0,
    DistributionFactorSet: List[String] = List(),
    HostControlArea: String = null,
    MktConnectivityNode: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[SysLoadDistributionFactor] }
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
        implicit val clz: String = SysLoadDistributionFactor.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SysLoadDistributionFactor.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SysLoadDistributionFactor.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SysLoadDistributionFactor.fields (position), x))
        emitelem (0, factor)
        emitattrs (1, DistributionFactorSet)
        emitattr (2, HostControlArea)
        emitattr (3, MktConnectivityNode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SysLoadDistributionFactor rdf:ID=\"%s\">\n%s\t</cim:SysLoadDistributionFactor>".format (id, export_fields)
    }
}

object SysLoadDistributionFactor
extends
    Parseable[SysLoadDistributionFactor]
{
    override val fields: Array[String] = Array[String] (
        "factor",
        "DistributionFactorSet",
        "HostControlArea",
        "MktConnectivityNode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DistributionFactorSet", "DistributionFactorSet", "0..*", "0..*"),
        Relationship ("HostControlArea", "HostControlArea", "1", "0..*"),
        Relationship ("MktConnectivityNode", "MktConnectivityNode", "1", "0..1")
    )
    val factor: Fielder = parse_element (element (cls, fields(0)))
    val DistributionFactorSet: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MktConnectivityNode: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): SysLoadDistributionFactor =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SysLoadDistributionFactor (
            BasicElement.parse (context),
            toDouble (mask (factor (), 0)),
            masks (DistributionFactorSet (), 1),
            mask (HostControlArea (), 2),
            mask (MktConnectivityNode (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A Transmission Right(TR) can be a chain of TR's or on individual.
 *
 * When a transmission right is not a chain, this is formally the ETC/TOR Entitlement for each ETC/TOR contract with the inclusion of CVR(Converted Rights) as an ETC. This is the sum of all entitlements on all related transmission interfaces for the same TR.
 * 
 * When TR is a chain, its entitlement is the minimum of all entitlements for the individual TRs in the chain.
 *
 * @param sup Reference to the superclass object.
 * @param entitlement The entitlement
 * @param startOperatingDate Operating date and hour when the entitlement applies
 * @param TransmissionContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class TREntitlement
(
    override val sup: BasicElement = null,
    entitlement: Double = 0.0,
    startOperatingDate: String = null,
    TransmissionContractRight: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[TREntitlement] }
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
        implicit val clz: String = TREntitlement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TREntitlement.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TREntitlement.fields (position), value)
        emitelem (0, entitlement)
        emitelem (1, startOperatingDate)
        emitattr (2, TransmissionContractRight)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TREntitlement rdf:ID=\"%s\">\n%s\t</cim:TREntitlement>".format (id, export_fields)
    }
}

object TREntitlement
extends
    Parseable[TREntitlement]
{
    override val fields: Array[String] = Array[String] (
        "entitlement",
        "startOperatingDate",
        "TransmissionContractRight"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TransmissionContractRight", "ContractRight", "1", "0..*")
    )
    val entitlement: Fielder = parse_element (element (cls, fields(0)))
    val startOperatingDate: Fielder = parse_element (element (cls, fields(1)))
    val TransmissionContractRight: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): TREntitlement =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TREntitlement (
            BasicElement.parse (context),
            toDouble (mask (entitlement (), 0)),
            mask (startOperatingDate (), 1),
            mask (TransmissionContractRight (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Optimal Power Flow or State Estimator Phase Shifter Data.
 *
 * This is used for RealTime, Study and Maintenance Users. SE Solution Phase Shifter Measurements from the last run of SE.
 *
 * @param sup Reference to the superclass object.
 * @param angleRegulationStatus True means the phase shifter is regulating.
 * @param desiredMW Phase Shifter Desired MW.
 *        The active power regulation setpoint of the phase shifter
 * @param desiredVoltage The desired voltage for the LTC
 * @param maximumAngle The maximum phase angle shift of the phase shifter
 * @param minimumAngle The minimum phase angle shift of the phase shifter
 * @param solvedAngle Phase Shifter Angle.
 *        The solved phase angle shift of the phase shifter
 * @param tapPosition Tap position of the phase shifter, high-side tap position of the transformer, or  low-side tap position of the transformer
 * @param voltageRegulationStatus Indicator if the LTC transformer is regulating True = Yes, False = No
 * @param MktTapChanger [[ch.ninecode.model.MktTapChanger MktTapChanger]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class TapChangerDynamicData
(
    override val sup: BasicElement = null,
    angleRegulationStatus: Boolean = false,
    desiredMW: Double = 0.0,
    desiredVoltage: Double = 0.0,
    maximumAngle: Double = 0.0,
    minimumAngle: Double = 0.0,
    solvedAngle: Double = 0.0,
    tapPosition: Double = 0.0,
    voltageRegulationStatus: Boolean = false,
    MktTapChanger: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[TapChangerDynamicData] }
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
        implicit val clz: String = TapChangerDynamicData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TapChangerDynamicData.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TapChangerDynamicData.fields (position), value)
        emitelem (0, angleRegulationStatus)
        emitelem (1, desiredMW)
        emitelem (2, desiredVoltage)
        emitelem (3, maximumAngle)
        emitelem (4, minimumAngle)
        emitelem (5, solvedAngle)
        emitelem (6, tapPosition)
        emitelem (7, voltageRegulationStatus)
        emitattr (8, MktTapChanger)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TapChangerDynamicData rdf:ID=\"%s\">\n%s\t</cim:TapChangerDynamicData>".format (id, export_fields)
    }
}

object TapChangerDynamicData
extends
    Parseable[TapChangerDynamicData]
{
    override val fields: Array[String] = Array[String] (
        "angleRegulationStatus",
        "desiredMW",
        "desiredVoltage",
        "maximumAngle",
        "minimumAngle",
        "solvedAngle",
        "tapPosition",
        "voltageRegulationStatus",
        "MktTapChanger"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MktTapChanger", "MktTapChanger", "1", "0..*")
    )
    val angleRegulationStatus: Fielder = parse_element (element (cls, fields(0)))
    val desiredMW: Fielder = parse_element (element (cls, fields(1)))
    val desiredVoltage: Fielder = parse_element (element (cls, fields(2)))
    val maximumAngle: Fielder = parse_element (element (cls, fields(3)))
    val minimumAngle: Fielder = parse_element (element (cls, fields(4)))
    val solvedAngle: Fielder = parse_element (element (cls, fields(5)))
    val tapPosition: Fielder = parse_element (element (cls, fields(6)))
    val voltageRegulationStatus: Fielder = parse_element (element (cls, fields(7)))
    val MktTapChanger: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): TapChangerDynamicData =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TapChangerDynamicData (
            BasicElement.parse (context),
            toBoolean (mask (angleRegulationStatus (), 0)),
            toDouble (mask (desiredMW (), 1)),
            toDouble (mask (desiredVoltage (), 2)),
            toDouble (mask (maximumAngle (), 3)),
            toDouble (mask (minimumAngle (), 4)),
            toDouble (mask (solvedAngle (), 5)),
            toDouble (mask (tapPosition (), 6)),
            toBoolean (mask (voltageRegulationStatus (), 7)),
            mask (MktTapChanger (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A constraint term associated with a specific terminal on a physical piece of equipment.
 *
 * @param sup [[ch.ninecode.model.ConstraintTerm ConstraintTerm]] Reference to the superclass object.
 * @param MktTerminal [[ch.ninecode.model.MktTerminal MktTerminal]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class TerminalConstraintTerm
(
    override val sup: ConstraintTerm = null,
    MktTerminal: String = null
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
    def ConstraintTerm: ConstraintTerm = sup.asInstanceOf[ConstraintTerm]
    override def copy (): Row = { clone ().asInstanceOf[TerminalConstraintTerm] }
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
        implicit val clz: String = TerminalConstraintTerm.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TerminalConstraintTerm.fields (position), value)
        emitattr (0, MktTerminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TerminalConstraintTerm rdf:ID=\"%s\">\n%s\t</cim:TerminalConstraintTerm>".format (id, export_fields)
    }
}

object TerminalConstraintTerm
extends
    Parseable[TerminalConstraintTerm]
{
    override val fields: Array[String] = Array[String] (
        "MktTerminal"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MktTerminal", "MktTerminal", "1", "0..*")
    )
    val MktTerminal: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): TerminalConstraintTerm =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TerminalConstraintTerm (
            ConstraintTerm.parse (context),
            mask (MktTerminal (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A Transfer Interface is made up of branches such as transmission lines and transformers.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param HostControlArea [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param TransferInterfaceSolution [[ch.ninecode.model.TransferInterfaceSolution TransferInterfaceSolution]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class TransferInterface
(
    override val sup: IdentifiedObject = null,
    HostControlArea: String = null,
    TransferInterfaceSolution: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[TransferInterface] }
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
        implicit val clz: String = TransferInterface.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransferInterface.fields (position), value)
        emitattr (0, HostControlArea)
        emitattr (1, TransferInterfaceSolution)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransferInterface rdf:ID=\"%s\">\n%s\t</cim:TransferInterface>".format (id, export_fields)
    }
}

object TransferInterface
extends
    Parseable[TransferInterface]
{
    override val fields: Array[String] = Array[String] (
        "HostControlArea",
        "TransferInterfaceSolution"
    )
    override val relations: List[Relationship] = List (
        Relationship ("HostControlArea", "HostControlArea", "0..1", "0..*"),
        Relationship ("TransferInterfaceSolution", "TransferInterfaceSolution", "1", "1")
    )
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TransferInterfaceSolution: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): TransferInterface =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransferInterface (
            IdentifiedObject.parse (context),
            mask (HostControlArea (), 0),
            mask (TransferInterfaceSolution (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * TNA Interface Definitions from OPF for VSA.
 *
 * @param sup Reference to the superclass object.
 * @param interfaceMargin The margin for the interface
 * @param postTransferMW Post Transfer MW for step
 * @param transferLimit Transfer Interface + Limit
 *        Attribute Usage: The absoloute of the maximum flow on the transfer interface.
 *        This is a positive MW value.
 * @param MktContingencyB [[ch.ninecode.model.MktContingency MktContingency]] <em>undocumented</em>
 * @param TransferInterface [[ch.ninecode.model.TransferInterface TransferInterface]] <em>undocumented</em>
 * @param  MktContingencyA [[ch.ninecode.model.MktContingency MktContingency]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class TransferInterfaceSolution
(
    override val sup: BasicElement = null,
    interfaceMargin: Double = 0.0,
    postTransferMW: Double = 0.0,
    transferLimit: Double = 0.0,
    MktContingencyB: String = null,
    TransferInterface: String = null,
    _MktContingencyA: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[TransferInterfaceSolution] }
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
        implicit val clz: String = TransferInterfaceSolution.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransferInterfaceSolution.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransferInterfaceSolution.fields (position), value)
        emitelem (0, interfaceMargin)
        emitelem (1, postTransferMW)
        emitelem (2, transferLimit)
        emitattr (3, MktContingencyB)
        emitattr (4, TransferInterface)
        emitattr (5, _MktContingencyA)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransferInterfaceSolution rdf:ID=\"%s\">\n%s\t</cim:TransferInterfaceSolution>".format (id, export_fields)
    }
}

object TransferInterfaceSolution
extends
    Parseable[TransferInterfaceSolution]
{
    override val fields: Array[String] = Array[String] (
        "interfaceMargin",
        "postTransferMW",
        "transferLimit",
        "MktContingencyB",
        "TransferInterface",
        " MktContingencyA"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MktContingencyB", "MktContingency", "0..1", "0..1"),
        Relationship ("TransferInterface", "TransferInterface", "1", "1"),
        Relationship ("_MktContingencyA", "MktContingency", "0..1", "0..1")
    )
    val interfaceMargin: Fielder = parse_element (element (cls, fields(0)))
    val postTransferMW: Fielder = parse_element (element (cls, fields(1)))
    val transferLimit: Fielder = parse_element (element (cls, fields(2)))
    val MktContingencyB: Fielder = parse_attribute (attribute (cls, fields(3)))
    val TransferInterface: Fielder = parse_attribute (attribute (cls, fields(4)))
    val _MktContingencyA: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): TransferInterfaceSolution =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransferInterfaceSolution (
            BasicElement.parse (context),
            toDouble (mask (interfaceMargin (), 0)),
            toDouble (mask (postTransferMW (), 1)),
            toDouble (mask (transferLimit (), 2)),
            mask (MktContingencyB (), 3),
            mask (TransferInterface (), 4),
            mask (_MktContingencyA (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class models the transmission (either a transmission interface or a POR/POD pair) capacity including Total Transfer Capacity (TTC), Operating Transfer Capacity (OTC), and Capacity Benefit Margin (CBM).
 *
 * @param sup Reference to the superclass object.
 * @param capacityBenefitMargin Capacity Benefit Margin (CBM) is used by Markets to calculate the transmission interface limits.
 *        This number could be manually or procedurally determined. The CBM is defined per transmission interface (branch group).
 * @param operationalTransmissionCapacity The Operational Transmission Capacity (OTC) is the transmission capacity under the operating condition during a specific time period, incorporating the effects of derates and current settings of operation controls.
 *        The OTCs for all transmission interface (branch group) are always provided regardless of outage or switching conditions.
 * @param startOperatingDate Operating date &amp; hour when the entitlement applies
 * @param totalTransmissionCapacity Total Transmission Capacity
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param GenericConstraints [[ch.ninecode.model.GenericConstraints GenericConstraints]] <em>undocumented</em>
 * @param OTC15min_emergency The Operational Transmission Capacity (OTC) 15 minute Emergency Limit
 * @param OTCemergency The Operational Transmission Capacity (OTC) Emergency Limit.
 * @param POD point of delivery
 * @param POR point of receipt
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class TransmissionCapacity
(
    override val sup: BasicElement = null,
    capacityBenefitMargin: Double = 0.0,
    operationalTransmissionCapacity: Double = 0.0,
    startOperatingDate: String = null,
    totalTransmissionCapacity: Double = 0.0,
    Flowgate: String = null,
    GenericConstraints: String = null,
    OTC15min_emergency: Double = 0.0,
    OTCemergency: Double = 0.0,
    POD: String = null,
    POR: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[TransmissionCapacity] }
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
        implicit val clz: String = TransmissionCapacity.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransmissionCapacity.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransmissionCapacity.fields (position), value)
        emitelem (0, capacityBenefitMargin)
        emitelem (1, operationalTransmissionCapacity)
        emitelem (2, startOperatingDate)
        emitelem (3, totalTransmissionCapacity)
        emitattr (4, Flowgate)
        emitattr (5, GenericConstraints)
        emitelem (6, OTC15min_emergency)
        emitelem (7, OTCemergency)
        emitelem (8, POD)
        emitelem (9, POR)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransmissionCapacity rdf:ID=\"%s\">\n%s\t</cim:TransmissionCapacity>".format (id, export_fields)
    }
}

object TransmissionCapacity
extends
    Parseable[TransmissionCapacity]
{
    override val fields: Array[String] = Array[String] (
        "capacityBenefitMargin",
        "operationalTransmissionCapacity",
        "startOperatingDate",
        "totalTransmissionCapacity",
        "Flowgate",
        "GenericConstraints",
        "OTC15min_emergency",
        "OTCemergency",
        "POD",
        "POR"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", "0..1", "0..*"),
        Relationship ("GenericConstraints", "GenericConstraints", "0..1", "0..*")
    )
    val capacityBenefitMargin: Fielder = parse_element (element (cls, fields(0)))
    val operationalTransmissionCapacity: Fielder = parse_element (element (cls, fields(1)))
    val startOperatingDate: Fielder = parse_element (element (cls, fields(2)))
    val totalTransmissionCapacity: Fielder = parse_element (element (cls, fields(3)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(4)))
    val GenericConstraints: Fielder = parse_attribute (attribute (cls, fields(5)))
    val OTC15min_emergency: Fielder = parse_element (element (cls, fields(6)))
    val OTCemergency: Fielder = parse_element (element (cls, fields(7)))
    val POD: Fielder = parse_element (element (cls, fields(8)))
    val POR: Fielder = parse_element (element (cls, fields(9)))

    def parse (context: Context): TransmissionCapacity =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransmissionCapacity (
            BasicElement.parse (context),
            toDouble (mask (capacityBenefitMargin (), 0)),
            toDouble (mask (operationalTransmissionCapacity (), 1)),
            mask (startOperatingDate (), 2),
            toDouble (mask (totalTransmissionCapacity (), 3)),
            mask (Flowgate (), 4),
            mask (GenericConstraints (), 5),
            toDouble (mask (OTC15min_emergency (), 6)),
            toDouble (mask (OTCemergency (), 7)),
            mask (POD (), 8),
            mask (POR (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This is formally called the branch group ETC/TOR entitlement with the inclusion of CVR as ETC.
 *
 * This could be also used to represent the TR entitlement on a POR/POD.
 *
 * @param sup Reference to the superclass object.
 * @param entitlement the entitlement
 * @param startOperatingDate Operating date and hour when the entitlement applies
 * @param ContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param POD point of delivery
 * @param POR point of receipt
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class TransmissionInterfaceRightEntitlement
(
    override val sup: BasicElement = null,
    entitlement: Double = 0.0,
    startOperatingDate: String = null,
    ContractRight: String = null,
    Flowgate: String = null,
    POD: String = null,
    POR: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[TransmissionInterfaceRightEntitlement] }
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
        implicit val clz: String = TransmissionInterfaceRightEntitlement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransmissionInterfaceRightEntitlement.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransmissionInterfaceRightEntitlement.fields (position), value)
        emitelem (0, entitlement)
        emitelem (1, startOperatingDate)
        emitattr (2, ContractRight)
        emitattr (3, Flowgate)
        emitelem (4, POD)
        emitelem (5, POR)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransmissionInterfaceRightEntitlement rdf:ID=\"%s\">\n%s\t</cim:TransmissionInterfaceRightEntitlement>".format (id, export_fields)
    }
}

object TransmissionInterfaceRightEntitlement
extends
    Parseable[TransmissionInterfaceRightEntitlement]
{
    override val fields: Array[String] = Array[String] (
        "entitlement",
        "startOperatingDate",
        "ContractRight",
        "Flowgate",
        "POD",
        "POR"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ContractRight", "ContractRight", "1", "0..*"),
        Relationship ("Flowgate", "Flowgate", "0..1", "0..*")
    )
    val entitlement: Fielder = parse_element (element (cls, fields(0)))
    val startOperatingDate: Fielder = parse_element (element (cls, fields(1)))
    val ContractRight: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(3)))
    val POD: Fielder = parse_element (element (cls, fields(4)))
    val POR: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: Context): TransmissionInterfaceRightEntitlement =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransmissionInterfaceRightEntitlement (
            BasicElement.parse (context),
            toDouble (mask (entitlement (), 0)),
            mask (startOperatingDate (), 1),
            mask (ContractRight (), 2),
            mask (Flowgate (), 3),
            mask (POD (), 4),
            mask (POR (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An electrical connection, link, or line consisting of one or more parallel transmission elements between two areas of the interconnected electric systems, or portions thereof.
 *
 * TransmissionCorridor and TransmissionRightOfWay refer to legal aspects. The TransmissionPath refers to the segments between a TransmissionProvider's ServicePoints.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param availTransferCapability The available transmission capability of a transmission path for the reference direction.
 * @param parallelPathFlag Flag which indicates if the transmission path is also a designated interconnection "parallel path".
 * @param totalTransferCapability The total transmission capability of a transmission path in the reference direction.
 * @param DeliveryPoint [[ch.ninecode.model.ServicePoint ServicePoint]] A transmission path has a "point-of-delivery" service point
 * @param For [[ch.ninecode.model.TransmissionCorridor TransmissionCorridor]] A TransmissionPath is contained in a TransmissionCorridor.
 * @param LocatedOn [[ch.ninecode.model.TransmissionProduct TransmissionProduct]] A transmission product is located on a transmission path.
 * @param PointOfReceipt [[ch.ninecode.model.ServicePoint ServicePoint]] A transmission path has a "point-of-receipt" service point
 * @param TransmissionReservation [[ch.ninecode.model.TransmissionReservation TransmissionReservation]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class TransmissionPath
(
    override val sup: IdentifiedObject = null,
    availTransferCapability: Double = 0.0,
    parallelPathFlag: Boolean = false,
    totalTransferCapability: Double = 0.0,
    DeliveryPoint: String = null,
    For: String = null,
    LocatedOn: List[String] = List(),
    PointOfReceipt: String = null,
    TransmissionReservation: List[String] = List()
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
    override def copy (): Row = { clone ().asInstanceOf[TransmissionPath] }
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
        implicit val clz: String = TransmissionPath.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransmissionPath.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransmissionPath.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TransmissionPath.fields (position), x))
        emitelem (0, availTransferCapability)
        emitelem (1, parallelPathFlag)
        emitelem (2, totalTransferCapability)
        emitattr (3, DeliveryPoint)
        emitattr (4, For)
        emitattrs (5, LocatedOn)
        emitattr (6, PointOfReceipt)
        emitattrs (7, TransmissionReservation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransmissionPath rdf:ID=\"%s\">\n%s\t</cim:TransmissionPath>".format (id, export_fields)
    }
}

object TransmissionPath
extends
    Parseable[TransmissionPath]
{
    override val fields: Array[String] = Array[String] (
        "availTransferCapability",
        "parallelPathFlag",
        "totalTransferCapability",
        "DeliveryPoint",
        "For",
        "LocatedOn",
        "PointOfReceipt",
        "TransmissionReservation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DeliveryPoint", "ServicePoint", "1", "0..*"),
        Relationship ("For", "TransmissionCorridor", "1", "0..*"),
        Relationship ("LocatedOn", "TransmissionProduct", "0..*", "0..*"),
        Relationship ("PointOfReceipt", "ServicePoint", "1", "0..*"),
        Relationship ("TransmissionReservation", "TransmissionReservation", "0..*", "1")
    )
    val availTransferCapability: Fielder = parse_element (element (cls, fields(0)))
    val parallelPathFlag: Fielder = parse_element (element (cls, fields(1)))
    val totalTransferCapability: Fielder = parse_element (element (cls, fields(2)))
    val DeliveryPoint: Fielder = parse_attribute (attribute (cls, fields(3)))
    val For: Fielder = parse_attribute (attribute (cls, fields(4)))
    val LocatedOn: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val PointOfReceipt: Fielder = parse_attribute (attribute (cls, fields(6)))
    val TransmissionReservation: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): TransmissionPath =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransmissionPath (
            IdentifiedObject.parse (context),
            toDouble (mask (availTransferCapability (), 0)),
            toBoolean (mask (parallelPathFlag (), 1)),
            toDouble (mask (totalTransferCapability (), 2)),
            mask (DeliveryPoint (), 3),
            mask (For (), 4),
            masks (LocatedOn (), 5),
            mask (PointOfReceipt (), 6),
            masks (TransmissionReservation (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A transmission reservation is obtained from the OASIS system to reserve transmission for a specified time period, transmission path and transmission product.
 *
 * @param sup Reference to the superclass object.
 * @param EnergyTransaction [[ch.ninecode.model.EnergyTransaction EnergyTransaction]] <em>undocumented</em>
 * @param Sink [[ch.ninecode.model.ServicePoint ServicePoint]] <em>undocumented</em>
 * @param Source [[ch.ninecode.model.ServicePoint ServicePoint]] <em>undocumented</em>
 * @param TransactionBid [[ch.ninecode.model.TransactionBid TransactionBid]] <em>undocumented</em>
 * @param TransmissionPath [[ch.ninecode.model.TransmissionPath TransmissionPath]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class TransmissionReservation
(
    override val sup: BasicElement = null,
    EnergyTransaction: String = null,
    Sink: String = null,
    Source: String = null,
    TransactionBid: String = null,
    TransmissionPath: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[TransmissionReservation] }
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
        implicit val clz: String = TransmissionReservation.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransmissionReservation.fields (position), value)
        emitattr (0, EnergyTransaction)
        emitattr (1, Sink)
        emitattr (2, Source)
        emitattr (3, TransactionBid)
        emitattr (4, TransmissionPath)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransmissionReservation rdf:ID=\"%s\">\n%s\t</cim:TransmissionReservation>".format (id, export_fields)
    }
}

object TransmissionReservation
extends
    Parseable[TransmissionReservation]
{
    override val fields: Array[String] = Array[String] (
        "EnergyTransaction",
        "Sink",
        "Source",
        "TransactionBid",
        "TransmissionPath"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnergyTransaction", "EnergyTransaction", "0..1", "0..1"),
        Relationship ("Sink", "ServicePoint", "0..1", "0..*"),
        Relationship ("Source", "ServicePoint", "0..1", "0..*"),
        Relationship ("TransactionBid", "TransactionBid", "0..1", "0..1"),
        Relationship ("TransmissionPath", "TransmissionPath", "1", "0..*")
    )
    val EnergyTransaction: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Sink: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Source: Fielder = parse_attribute (attribute (cls, fields(2)))
    val TransactionBid: Fielder = parse_attribute (attribute (cls, fields(3)))
    val TransmissionPath: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): TransmissionReservation =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransmissionReservation (
            BasicElement.parse (context),
            mask (EnergyTransaction (), 0),
            mask (Sink (), 1),
            mask (Source (), 2),
            mask (TransactionBid (), 3),
            mask (TransmissionPath (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Resource status at the end of a given clearing period.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param cumEnergy Cumulative energy production over trading period.
 * @param cumStatusChanges Cumulative number of status changes of the resource.
 * @param numberOfStartups Number of start ups in the Operating Day until the end of previous hour.
 * @param onlineStatus 'true' if the GeneratingUnit is currently On-Line
 * @param resourceMW Resource MW output at the end of previous clearing period.
 * @param resourceStatus Resource status at the end of previous clearing period:
 *        0 - off-line
 *        1 - on-line production
 *        2 - in shutdown process
 *        3 - in startup process
 * @param statusDate Time and date for resourceStatus
 * @param timeInStatus Time in market trading intervals the resource is in the state as of the end of the previous clearing period.
 * @param timeInterval Time interval
 * @param GeneratingUnit [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
final case class UnitInitialConditions
(
    override val sup: IdentifiedObject = null,
    cumEnergy: Double = 0.0,
    cumStatusChanges: Int = 0,
    numberOfStartups: Int = 0,
    onlineStatus: Boolean = false,
    resourceMW: Double = 0.0,
    resourceStatus: Int = 0,
    statusDate: String = null,
    timeInStatus: Double = 0.0,
    timeInterval: String = null,
    GeneratingUnit: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[UnitInitialConditions] }
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
        implicit val clz: String = UnitInitialConditions.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (UnitInitialConditions.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (UnitInitialConditions.fields (position), value)
        emitelem (0, cumEnergy)
        emitelem (1, cumStatusChanges)
        emitelem (2, numberOfStartups)
        emitelem (3, onlineStatus)
        emitelem (4, resourceMW)
        emitelem (5, resourceStatus)
        emitelem (6, statusDate)
        emitelem (7, timeInStatus)
        emitelem (8, timeInterval)
        emitattr (9, GeneratingUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UnitInitialConditions rdf:ID=\"%s\">\n%s\t</cim:UnitInitialConditions>".format (id, export_fields)
    }
}

object UnitInitialConditions
extends
    Parseable[UnitInitialConditions]
{
    override val fields: Array[String] = Array[String] (
        "cumEnergy",
        "cumStatusChanges",
        "numberOfStartups",
        "onlineStatus",
        "resourceMW",
        "resourceStatus",
        "statusDate",
        "timeInStatus",
        "timeInterval",
        "GeneratingUnit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("GeneratingUnit", "RegisteredGenerator", "0..1", "0..*")
    )
    val cumEnergy: Fielder = parse_element (element (cls, fields(0)))
    val cumStatusChanges: Fielder = parse_element (element (cls, fields(1)))
    val numberOfStartups: Fielder = parse_element (element (cls, fields(2)))
    val onlineStatus: Fielder = parse_element (element (cls, fields(3)))
    val resourceMW: Fielder = parse_element (element (cls, fields(4)))
    val resourceStatus: Fielder = parse_element (element (cls, fields(5)))
    val statusDate: Fielder = parse_element (element (cls, fields(6)))
    val timeInStatus: Fielder = parse_element (element (cls, fields(7)))
    val timeInterval: Fielder = parse_element (element (cls, fields(8)))
    val GeneratingUnit: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: Context): UnitInitialConditions =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UnitInitialConditions (
            IdentifiedObject.parse (context),
            toDouble (mask (cumEnergy (), 0)),
            toInteger (mask (cumStatusChanges (), 1)),
            toInteger (mask (numberOfStartups (), 2)),
            toBoolean (mask (onlineStatus (), 3)),
            toDouble (mask (resourceMW (), 4)),
            toInteger (mask (resourceStatus (), 5)),
            mask (statusDate (), 6),
            toDouble (mask (timeInStatus (), 7)),
            mask (timeInterval (), 8),
            mask (GeneratingUnit (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _ExternalInputs
{
    def register: List[ClassInfo] =
    {
        List (
            ASRequirements.register,
            AnalogMeasurementValueQuality.register,
            AreaLoadCurve.register,
            BaseCaseConstraintLimit.register,
            BranchEndFlow.register,
            ConstraintTerm.register,
            ContingencyConstraintLimit.register,
            ControlAreaSolutionData.register,
            DefaultBid.register,
            DefaultBidCurve.register,
            DefaultBidCurveData.register,
            DefaultConstraintLimit.register,
            DiscreteMeasurementValueQuality.register,
            DistributionFactorSet.register,
            EnergyPriceIndex.register,
            EnergyProfile.register,
            EnergyTransaction.register,
            GenDistributionFactor.register,
            GeneratingUnitDynamicValues.register,
            GenericConstraints.register,
            InterchangeETCData.register,
            InterchangeSchedule.register,
            IntermittentResourceEligibility.register,
            LoadDistributionFactor.register,
            LossSensitivity.register,
            MWLimitSchedule.register,
            MktACLineSegment.register,
            MktAnalogLimit.register,
            MktAnalogLimitSet.register,
            MktControlArea.register,
            MktSeriesCompensator.register,
            MktShuntCompensator.register,
            MktSwitch.register,
            MktTapChanger.register,
            NodeConstraintTerm.register,
            Profile.register,
            ProfileData.register,
            ReserveDemandCurve.register,
            SCADAInformation.register,
            SecurityConstraintSum.register,
            SecurityConstraints.register,
            ServicePoint.register,
            ShuntCompensatorDynamicData.register,
            SwitchStatus.register,
            SysLoadDistributionFactor.register,
            TREntitlement.register,
            TapChangerDynamicData.register,
            TerminalConstraintTerm.register,
            TransferInterface.register,
            TransferInterfaceSolution.register,
            TransmissionCapacity.register,
            TransmissionInterfaceRightEntitlement.register,
            TransmissionPath.register,
            TransmissionReservation.register,
            UnitInitialConditions.register
        )
    }
}