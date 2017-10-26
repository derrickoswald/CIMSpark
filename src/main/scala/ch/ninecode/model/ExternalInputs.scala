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
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class ASRequirements
(
    override val sup: BasicElement,
    intervalStartTime: String
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
    override def copy (): Row = { clone ().asInstanceOf[ASRequirements] }
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
        implicit val clz: String = ASRequirements.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ASRequirements.fields (position), value)
        emitelem (0, intervalStartTime)
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
    val fields: Array[String] = Array[String] (
        "intervalStartTime"
    )
    val intervalStartTime: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): ASRequirements =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ASRequirements (
            BasicElement.parse (context),
            mask (intervalStartTime (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Measurement quality flags for Analog Values.
 *
 * @param sup [[ch.ninecode.model.MeasurementValueQuality MeasurementValueQuality]] Reference to the superclass object.
 * @param scadaQualityCode The quality code for the given Analog Value.
 * @param MktAnalogValue [[ch.ninecode.model.MktAnalogValue MktAnalogValue]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class AnalogMeasurementValueQuality
(
    override val sup: MeasurementValueQuality,
    scadaQualityCode: String,
    MktAnalogValue: String
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
    def MeasurementValueQuality: MeasurementValueQuality = sup.asInstanceOf[MeasurementValueQuality]
    override def copy (): Row = { clone ().asInstanceOf[AnalogMeasurementValueQuality] }
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
        implicit val clz: String = AnalogMeasurementValueQuality.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AnalogMeasurementValueQuality.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AnalogMeasurementValueQuality.fields (position), value)
        emitelem (0, scadaQualityCode)
        emitattr (1, MktAnalogValue)
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
    val fields: Array[String] = Array[String] (
        "scadaQualityCode",
        "MktAnalogValue"
    )
    val scadaQualityCode: Fielder = parse_element (element (cls, fields(0)))
    val MktAnalogValue: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): AnalogMeasurementValueQuality =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AnalogMeasurementValueQuality (
            MeasurementValueQuality.parse (context),
            mask (scadaQualityCode (), 0),
            mask (MktAnalogValue (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MktAnalogValue", "MktAnalogValue", false)
    )
}

/**
 * Area load curve definition.
 *
 * @param sup [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Reference to the superclass object.
 * @param forecastType Load forecast area type.
 * @param AggregateNode [[ch.ninecode.model.AggregateNode AggregateNode]] <em>undocumented</em>
 * @param MktLoadArea [[ch.ninecode.model.MktLoadArea MktLoadArea]] <em>undocumented</em>
 * @param TACArea [[ch.ninecode.model.TACArea TACArea]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class AreaLoadCurve
(
    override val sup: RegularIntervalSchedule,
    forecastType: String,
    AggregateNode: String,
    MktLoadArea: String,
    TACArea: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AreaLoadCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AreaLoadCurve.fields (position), value)
        emitattr (0, forecastType)
        emitattr (1, AggregateNode)
        emitattr (2, MktLoadArea)
        emitattr (3, TACArea)
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
    val fields: Array[String] = Array[String] (
        "forecastType",
        "AggregateNode",
        "MktLoadArea",
        "TACArea"
    )
    val forecastType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val AggregateNode: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MktLoadArea: Fielder = parse_attribute (attribute (cls, fields(2)))
    val TACArea: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): AreaLoadCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AreaLoadCurve (
            RegularIntervalSchedule.parse (context),
            mask (forecastType (), 0),
            mask (AggregateNode (), 1),
            mask (MktLoadArea (), 2),
            mask (TACArea (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AggregateNode", "AggregateNode", false),
        Relationship ("MktLoadArea", "MktLoadArea", false),
        Relationship ("TACArea", "TACArea", false)
    )
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
case class BaseCaseConstraintLimit
(
    override val sup: Curve,
    SecurityConstraintSum: String
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[BaseCaseConstraintLimit] }
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
    val fields: Array[String] = Array[String] (
        "SecurityConstraintSum"
    )
    val SecurityConstraintSum: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): BaseCaseConstraintLimit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BaseCaseConstraintLimit (
            Curve.parse (context),
            mask (SecurityConstraintSum (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("SecurityConstraintSum", "SecurityConstraintSum", false)
    )
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
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class BranchEndFlow
(
    override val sup: BasicElement,
    loadDumpRating: Double,
    longTermRating: Double,
    mVARFlow: Double,
    mwFlow: Double,
    normalRating: Double,
    shortTermRating: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BranchEndFlow.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BranchEndFlow.fields (position), value)
        emitelem (0, loadDumpRating)
        emitelem (1, longTermRating)
        emitelem (2, mVARFlow)
        emitelem (3, mwFlow)
        emitelem (4, normalRating)
        emitelem (5, shortTermRating)
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
    val fields: Array[String] = Array[String] (
        "loadDumpRating",
        "longTermRating",
        "mVARFlow",
        "mwFlow",
        "normalRating",
        "shortTermRating"
    )
    val loadDumpRating: Fielder = parse_element (element (cls, fields(0)))
    val longTermRating: Fielder = parse_element (element (cls, fields(1)))
    val mVARFlow: Fielder = parse_element (element (cls, fields(2)))
    val mwFlow: Fielder = parse_element (element (cls, fields(3)))
    val normalRating: Fielder = parse_element (element (cls, fields(4)))
    val shortTermRating: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: Context): BranchEndFlow =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BranchEndFlow (
            BasicElement.parse (context),
            toDouble (mask (loadDumpRating (), 0)),
            toDouble (mask (longTermRating (), 1)),
            toDouble (mask (mVARFlow (), 2)),
            toDouble (mask (mwFlow (), 3)),
            toDouble (mask (normalRating (), 4)),
            toDouble (mask (shortTermRating (), 5))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
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
case class ConstraintTerm
(
    override val sup: IdentifiedObject,
    factor: String,
    function: String,
    SecurityConstraintSum: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "factor",
        "function",
        "SecurityConstraintSum"
    )
    val factor: Fielder = parse_element (element (cls, fields(0)))
    val function: Fielder = parse_element (element (cls, fields(1)))
    val SecurityConstraintSum: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ConstraintTerm =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ConstraintTerm (
            IdentifiedObject.parse (context),
            mask (factor (), 0),
            mask (function (), 1),
            mask (SecurityConstraintSum (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("SecurityConstraintSum", "SecurityConstraintSum", false)
    )
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
case class ContingencyConstraintLimit
(
    override val sup: Curve,
    MWLimitSchedules: String,
    MktContingency: String,
    SecurityConstraintSum: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "MWLimitSchedules",
        "MktContingency",
        "SecurityConstraintSum"
    )
    val MWLimitSchedules: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MktContingency: Fielder = parse_attribute (attribute (cls, fields(1)))
    val SecurityConstraintSum: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ContingencyConstraintLimit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ContingencyConstraintLimit (
            Curve.parse (context),
            mask (MWLimitSchedules (), 0),
            mask (MktContingency (), 1),
            mask (SecurityConstraintSum (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MWLimitSchedules", "MWLimitSchedule", false),
        Relationship ("MktContingency", "MktContingency", false),
        Relationship ("SecurityConstraintSum", "SecurityConstraintSum", false)
    )
}

/**
 * State Estimator Solution Pool Interchange and Losses
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
case class ControlAreaSolutionData
(
    override val sup: BasicElement,
    solvedInterchange: Double,
    solvedLosses: Double,
    MktControlArea: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "solvedInterchange",
        "solvedLosses",
        "MktControlArea"
    )
    val solvedInterchange: Fielder = parse_element (element (cls, fields(0)))
    val solvedLosses: Fielder = parse_element (element (cls, fields(1)))
    val MktControlArea: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ControlAreaSolutionData =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ControlAreaSolutionData (
            BasicElement.parse (context),
            toDouble (mask (solvedInterchange (), 0)),
            toDouble (mask (solvedLosses (), 1)),
            mask (MktControlArea (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MktControlArea", "MktControlArea", false)
    )
}

/**
 * DefaultBid is a generic class to hold Default Energy Bid, Default Startup Bid, and Default Minimum Load Bid:
 * 
 * Default Energy Bid
 * A Default Energy Bid is a monotonically increasing staircase function consisting at maximum 10 economic bid segments, or 10 (\$/MW, MW) pairs.
 *
 * There are three methods for determining the Default Energy Bid:
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
case class DefaultBid
(
    override val sup: Bid,
    bidType: String,
    minLoadCost: Double,
    peakFlag: String,
    DefaultBidCurve: String,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "bidType",
        "minLoadCost",
        "peakFlag",
        "DefaultBidCurve",
        "RegisteredResource"
    )
    val bidType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val minLoadCost: Fielder = parse_element (element (cls, fields(1)))
    val peakFlag: Fielder = parse_attribute (attribute (cls, fields(2)))
    val DefaultBidCurve: Fielder = parse_attribute (attribute (cls, fields(3)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): DefaultBid =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("DefaultBidCurve", "DefaultBidCurve", false),
        Relationship ("RegisteredResource", "RegisteredResource", false)
    )
}

/**
 * Default bid curve for default energy bid curve and default startup curves (cost and time)
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param curveType To indicate a type used for a default energy bid curve, such as LMP, cost or consultative based.
 * @param debAdderFlag Default energy bid adder flag
 * @param DefaultBid [[ch.ninecode.model.DefaultBid DefaultBid]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class DefaultBidCurve
(
    override val sup: Curve,
    curveType: String,
    debAdderFlag: String,
    DefaultBid: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "curveType",
        "debAdderFlag",
        "DefaultBid"
    )
    val curveType: Fielder = parse_element (element (cls, fields(0)))
    val debAdderFlag: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DefaultBid: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): DefaultBidCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DefaultBidCurve (
            Curve.parse (context),
            mask (curveType (), 0),
            mask (debAdderFlag (), 1),
            mask (DefaultBid (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("DefaultBid", "DefaultBid", false)
    )
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
case class DefaultBidCurveData
(
    override val sup: CurveData,
    bidSegmentCalcType: String
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
    def CurveData: CurveData = sup.asInstanceOf[CurveData]
    override def copy (): Row = { clone ().asInstanceOf[DefaultBidCurveData] }
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
    val fields: Array[String] = Array[String] (
        "bidSegmentCalcType"
    )
    val bidSegmentCalcType: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): DefaultBidCurveData =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DefaultBidCurveData (
            CurveData.parse (context),
            mask (bidSegmentCalcType (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
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
case class DefaultConstraintLimit
(
    override val sup: Curve,
    SecurityConstraintSum: String
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[DefaultConstraintLimit] }
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
    val fields: Array[String] = Array[String] (
        "SecurityConstraintSum"
    )
    val SecurityConstraintSum: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): DefaultConstraintLimit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DefaultConstraintLimit (
            Curve.parse (context),
            mask (SecurityConstraintSum (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("SecurityConstraintSum", "SecurityConstraintSum", false)
    )
}

/**
 * Measurement quality flags for Discrete Values.
 *
 * @param sup [[ch.ninecode.model.MeasurementValueQuality MeasurementValueQuality]] Reference to the superclass object.
 * @param manualReplaceIndicator Switch Manual Replace Indicator.
 *        Flag indicating that the switch is manual replace.
 * @param removeFromOperationIndicator Removed From Operation Indicator.
 *        Flag indicating that the switch is removed from operation.
 * @param MktDiscreteValue [[ch.ninecode.model.MktDiscreteValue MktDiscreteValue]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class DiscreteMeasurementValueQuality
(
    override val sup: MeasurementValueQuality,
    manualReplaceIndicator: Boolean,
    removeFromOperationIndicator: Boolean,
    MktDiscreteValue: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DiscreteMeasurementValueQuality.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DiscreteMeasurementValueQuality.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DiscreteMeasurementValueQuality.fields (position), value)
        emitelem (0, manualReplaceIndicator)
        emitelem (1, removeFromOperationIndicator)
        emitattr (2, MktDiscreteValue)
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
    val fields: Array[String] = Array[String] (
        "manualReplaceIndicator",
        "removeFromOperationIndicator",
        "MktDiscreteValue"
    )
    val manualReplaceIndicator: Fielder = parse_element (element (cls, fields(0)))
    val removeFromOperationIndicator: Fielder = parse_element (element (cls, fields(1)))
    val MktDiscreteValue: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): DiscreteMeasurementValueQuality =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DiscreteMeasurementValueQuality (
            MeasurementValueQuality.parse (context),
            toBoolean (mask (manualReplaceIndicator (), 0)),
            toBoolean (mask (removeFromOperationIndicator (), 1)),
            mask (MktDiscreteValue (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MktDiscreteValue", "MktDiscreteValue", false)
    )
}

/**
 * A containing class that groups all the distribution factors within a market.
 *
 * This is calculated daily for DA factors and hourly for RT factors.
 *
 * @param sup Reference to the superclass object.
 * @param intervalEndTime The end of the time interval for which requirement is defined.
 * @param intervalStartTime The start of the time interval for which requirement is defined.
 * @param marketType <em>undocumented</em>
 * @param GenDistributionFactor [[ch.ninecode.model.GenDistributionFactor GenDistributionFactor]] <em>undocumented</em>
 * @param LoadDistributionFactor [[ch.ninecode.model.LoadDistributionFactor LoadDistributionFactor]] <em>undocumented</em>
 * @param SysLoadDistribuFactor [[ch.ninecode.model.SysLoadDistributionFactor SysLoadDistributionFactor]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class DistributionFactorSet
(
    override val sup: BasicElement,
    intervalEndTime: String,
    intervalStartTime: String,
    marketType: String,
    GenDistributionFactor: List[String],
    LoadDistributionFactor: List[String],
    SysLoadDistribuFactor: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), List(), List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DistributionFactorSet.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DistributionFactorSet.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DistributionFactorSet.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (DistributionFactorSet.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "intervalEndTime",
        "intervalStartTime",
        "marketType",
        "GenDistributionFactor",
        "LoadDistributionFactor",
        "SysLoadDistribuFactor"
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("GenDistributionFactor", "GenDistributionFactor", true),
        Relationship ("LoadDistributionFactor", "LoadDistributionFactor", true),
        Relationship ("SysLoadDistribuFactor", "SysLoadDistributionFactor", true)
    )
}

/**
 * Optimal Power Flow or State Estimator Load Data for OTS.
 *
 * This is used for RealTime, Study and Maintenance Users
 *
 * @param sup Reference to the superclass object.
 * @param loadMVAR The MVAR load
 *        Attribute Usage: The reactive power consumption of the load in MW
 * @param loadMW The active power consumption of the load in MW
 * @param MktEnergyConsumer [[ch.ninecode.model.MktEnergyConsumer MktEnergyConsumer]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class EnergyConsumerData
(
    override val sup: BasicElement,
    loadMVAR: Double,
    loadMW: Double,
    MktEnergyConsumer: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[EnergyConsumerData] }
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
        implicit val clz: String = EnergyConsumerData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EnergyConsumerData.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyConsumerData.fields (position), value)
        emitelem (0, loadMVAR)
        emitelem (1, loadMW)
        emitattr (2, MktEnergyConsumer)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergyConsumerData rdf:ID=\"%s\">\n%s\t</cim:EnergyConsumerData>".format (id, export_fields)
    }
}

object EnergyConsumerData
extends
    Parseable[EnergyConsumerData]
{
    val fields: Array[String] = Array[String] (
        "loadMVAR",
        "loadMW",
        "MktEnergyConsumer"
    )
    val loadMVAR: Fielder = parse_element (element (cls, fields(0)))
    val loadMW: Fielder = parse_element (element (cls, fields(1)))
    val MktEnergyConsumer: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): EnergyConsumerData =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = EnergyConsumerData (
            BasicElement.parse (context),
            toDouble (mask (loadMVAR (), 0)),
            toDouble (mask (loadMW (), 1)),
            mask (MktEnergyConsumer (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MktEnergyConsumer", "MktEnergyConsumer", false)
    )
}

/**
 * An Energy Price Index for each Resource is valid for a period (e.g. daily) that is identified by a Valid Period Start Time and a Valid Period End Time.
 *
 * An Energy Price Index is in \$/MWh.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param endEffectiveDate End effective date
 * @param energyPriceIndex Energy price index
 * @param energyPriceIndexType EPI type such as wholesale or retail
 * @param lastModified Time updated
 * @param startEffectiveDate Start effective date
 * @param RegisteredGenerator [[ch.ninecode.model.RegisteredGenerator RegisteredGenerator]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class EnergyPriceIndex
(
    override val sup: IdentifiedObject,
    endEffectiveDate: String,
    energyPriceIndex: Double,
    energyPriceIndexType: String,
    lastModified: String,
    startEffectiveDate: String,
    RegisteredGenerator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnergyPriceIndex.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EnergyPriceIndex.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyPriceIndex.fields (position), value)
        emitelem (0, endEffectiveDate)
        emitelem (1, energyPriceIndex)
        emitattr (2, energyPriceIndexType)
        emitelem (3, lastModified)
        emitelem (4, startEffectiveDate)
        emitattr (5, RegisteredGenerator)
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
    val fields: Array[String] = Array[String] (
        "endEffectiveDate",
        "energyPriceIndex",
        "energyPriceIndexType",
        "lastModified",
        "startEffectiveDate",
        "RegisteredGenerator"
    )
    val endEffectiveDate: Fielder = parse_element (element (cls, fields(0)))
    val energyPriceIndex: Fielder = parse_element (element (cls, fields(1)))
    val energyPriceIndexType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val lastModified: Fielder = parse_element (element (cls, fields(3)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields(4)))
    val RegisteredGenerator: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): EnergyPriceIndex =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = EnergyPriceIndex (
            IdentifiedObject.parse (context),
            mask (endEffectiveDate (), 0),
            toDouble (mask (energyPriceIndex (), 1)),
            mask (energyPriceIndexType (), 2),
            mask (lastModified (), 3),
            mask (startEffectiveDate (), 4),
            mask (RegisteredGenerator (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredGenerator", "RegisteredGenerator", false)
    )
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
case class EnergyProfile
(
    override val sup: Profile,
    EnergyTransaction: String,
    TransactionBid: String
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
    def Profile: Profile = sup.asInstanceOf[Profile]
    override def copy (): Row = { clone ().asInstanceOf[EnergyProfile] }
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
    val fields: Array[String] = Array[String] (
        "EnergyTransaction",
        "TransactionBid"
    )
    val EnergyTransaction: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TransactionBid: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): EnergyProfile =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = EnergyProfile (
            Profile.parse (context),
            mask (EnergyTransaction (), 0),
            mask (TransactionBid (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("EnergyTransaction", "EnergyTransaction", false),
        Relationship ("TransactionBid", "TransactionBid", false)
    )
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
 * @param EnergyPriceCurves [[ch.ninecode.model.EnergyPriceCurve EnergyPriceCurve]] <em>undocumented</em>
 * @param EnergyProduct [[ch.ninecode.model.EnergyProduct EnergyProduct]] The "Source" for an EnergyTransaction is an EnergyProduct which is injected into a ControlArea.
 *        Typically this is a ServicePoint.
 * @param Export_SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] Energy is transferred between interchange areas
 * @param Import_SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] Energy is transferred between interchange areas
 * @param TransmissionReservation [[ch.ninecode.model.TransmissionReservation TransmissionReservation]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class EnergyTransaction
(
    override val sup: Document,
    capacityBacked: Boolean,
    congestChargeMax: Double,
    deliveryPointP: Double,
    energyMin: Double,
    firmInterchangeFlag: Boolean,
    payCongestion: Boolean,
    reason: String,
    receiptPointP: Double,
    state: String,
    EnergyPriceCurves: List[String],
    EnergyProduct: String,
    Export_SubControlArea: String,
    Import_SubControlArea: String,
    TransmissionReservation: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, 0.0, 0.0, false, false, null, 0.0, null, List(), null, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnergyTransaction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EnergyTransaction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyTransaction.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (EnergyTransaction.fields (position), x))
        emitelem (0, capacityBacked)
        emitelem (1, congestChargeMax)
        emitelem (2, deliveryPointP)
        emitelem (3, energyMin)
        emitelem (4, firmInterchangeFlag)
        emitelem (5, payCongestion)
        emitelem (6, reason)
        emitelem (7, receiptPointP)
        emitattr (8, state)
        emitattrs (9, EnergyPriceCurves)
        emitattr (10, EnergyProduct)
        emitattr (11, Export_SubControlArea)
        emitattr (12, Import_SubControlArea)
        emitattr (13, TransmissionReservation)
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
    val fields: Array[String] = Array[String] (
        "capacityBacked",
        "congestChargeMax",
        "deliveryPointP",
        "energyMin",
        "firmInterchangeFlag",
        "payCongestion",
        "reason",
        "receiptPointP",
        "state",
        "EnergyPriceCurves",
        "EnergyProduct",
        "Export_SubControlArea",
        "Import_SubControlArea",
        "TransmissionReservation"
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
    val EnergyPriceCurves: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val EnergyProduct: Fielder = parse_attribute (attribute (cls, fields(10)))
    val Export_SubControlArea: Fielder = parse_attribute (attribute (cls, fields(11)))
    val Import_SubControlArea: Fielder = parse_attribute (attribute (cls, fields(12)))
    val TransmissionReservation: Fielder = parse_attribute (attribute (cls, fields(13)))

    def parse (context: Context): EnergyTransaction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
            masks (EnergyPriceCurves (), 9),
            mask (EnergyProduct (), 10),
            mask (Export_SubControlArea (), 11),
            mask (Import_SubControlArea (), 12),
            mask (TransmissionReservation (), 13)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("EnergyPriceCurves", "EnergyPriceCurve", true),
        Relationship ("EnergyProduct", "EnergyProduct", false),
        Relationship ("Export_SubControlArea", "SubControlArea", false),
        Relationship ("Import_SubControlArea", "SubControlArea", false),
        Relationship ("TransmissionReservation", "TransmissionReservation", false)
    )
}

/**
 * This class models the generation distribution factors.
 *
 * This class needs to be used along with the AggregatedPnode and the IndividualPnode to show the distriubtion of each individual party.
 *
 * @param sup Reference to the superclass object.
 * @param factor Used to calculate generation "participation" of an individual pnond in an AggregatePnode.
 * @param AggregatedPnode [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param IndividualPnode [[ch.ninecode.model.IndividualPnode IndividualPnode]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class GenDistributionFactor
(
    override val sup: BasicElement,
    factor: Double,
    AggregatedPnode: String,
    IndividualPnode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GenDistributionFactor.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GenDistributionFactor.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GenDistributionFactor.fields (position), value)
        emitelem (0, factor)
        emitattr (1, AggregatedPnode)
        emitattr (2, IndividualPnode)
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
    val fields: Array[String] = Array[String] (
        "factor",
        "AggregatedPnode",
        "IndividualPnode"
    )
    val factor: Fielder = parse_element (element (cls, fields(0)))
    val AggregatedPnode: Fielder = parse_attribute (attribute (cls, fields(1)))
    val IndividualPnode: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): GenDistributionFactor =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = GenDistributionFactor (
            BasicElement.parse (context),
            toDouble (mask (factor (), 0)),
            mask (AggregatedPnode (), 1),
            mask (IndividualPnode (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AggregatedPnode", "AggregatedPnode", false),
        Relationship ("IndividualPnode", "IndividualPnode", false)
    )
}

/**
 * Optimal Power Flow or State Estimator Unit Data for Operator Training Simulator.
 *
 * This is used for RealTime, Study and Maintenance Users
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
case class GeneratingUnitDynamicValues
(
    override val sup: BasicElement,
    lossFactor: Double,
    mVAR: Double,
    maximumMW: Double,
    minimumMW: Double,
    mw: Double,
    sensitivity: Double,
    Flowgate: String,
    MktGeneratingUnit: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "lossFactor",
        "mVAR",
        "maximumMW",
        "minimumMW",
        "mw",
        "sensitivity",
        "Flowgate",
        "MktGeneratingUnit"
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", false),
        Relationship ("MktGeneratingUnit", "MktGeneratingUnit", false)
    )
}

/**
 * Generic constraints can represent secure areas, voltage profile, transient stability and voltage collapse limits.
 *
 * The generic constraints can be one of the following forms:
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param intervalEndTime Interval End Time
 * @param intervalStartTime Interval Start Time
 * @param maxLimit Maximum Limit (MW)
 * @param minLimit Minimum Limit (MW)
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class GenericConstraints
(
    override val sup: IdentifiedObject,
    intervalEndTime: String,
    intervalStartTime: String,
    maxLimit: Double,
    minLimit: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GenericConstraints.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GenericConstraints.fields (position), value)
        emitelem (0, intervalEndTime)
        emitelem (1, intervalStartTime)
        emitelem (2, maxLimit)
        emitelem (3, minLimit)
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
    val fields: Array[String] = Array[String] (
        "intervalEndTime",
        "intervalStartTime",
        "maxLimit",
        "minLimit"
    )
    val intervalEndTime: Fielder = parse_element (element (cls, fields(0)))
    val intervalStartTime: Fielder = parse_element (element (cls, fields(1)))
    val maxLimit: Fielder = parse_element (element (cls, fields(2)))
    val minLimit: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): GenericConstraints =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = GenericConstraints (
            IdentifiedObject.parse (context),
            mask (intervalEndTime (), 0),
            mask (intervalStartTime (), 1),
            toDouble (mask (maxLimit (), 2)),
            toDouble (mask (minLimit (), 3))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Existing Transmission Contract data for an interchange schedule
 *
 * @param sup Reference to the superclass object.
 * @param contractNumber Existing transmission contract number
 * @param usageMW Existing transmission contract usage MW value
 * @param InterchangeSchedule [[ch.ninecode.model.InterchangeSchedule InterchangeSchedule]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class InterchangeETCData
(
    override val sup: BasicElement,
    contractNumber: String,
    usageMW: Double,
    InterchangeSchedule: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "contractNumber",
        "usageMW",
        "InterchangeSchedule"
    )
    val contractNumber: Fielder = parse_element (element (cls, fields(0)))
    val usageMW: Fielder = parse_element (element (cls, fields(1)))
    val InterchangeSchedule: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): InterchangeETCData =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = InterchangeETCData (
            BasicElement.parse (context),
            mask (contractNumber (), 0),
            toDouble (mask (usageMW (), 1)),
            mask (InterchangeSchedule (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("InterchangeSchedule", "InterchangeSchedule", false)
    )
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
 * @param RegisteredInterTie [[ch.ninecode.model.RegisteredInterTie RegisteredInterTie]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class InterchangeSchedule
(
    override val sup: Curve,
    checkOutType: String,
    directionType: String,
    energyType: String,
    intervalLength: Int,
    marketType: String,
    operatingDate: String,
    outOfMarketType: Boolean,
    scheduleType: String,
    wcrID: String,
    InterTie: String,
    RegisteredInterTie: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, 0, null, null, false, null, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = InterchangeSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (InterchangeSchedule.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (InterchangeSchedule.fields (position), value)
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
        emitattr (10, RegisteredInterTie)
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
    val fields: Array[String] = Array[String] (
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
        "RegisteredInterTie"
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
    val RegisteredInterTie: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: Context): InterchangeSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
            mask (RegisteredInterTie (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("InterTie", "SchedulingPoint", false),
        Relationship ("RegisteredInterTie", "RegisteredInterTie", false)
    )
}

/**
 * Indicates whether unit is eligible for treatment as a intermittent variable renewable resource
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param eligibilityStatus Indicates whether a resource is eligible for PIRP program for a given hour
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class IntermittentResourceEligibility
(
    override val sup: MarketFactors,
    eligibilityStatus: String,
    RegisteredResource: String
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[IntermittentResourceEligibility] }
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
    val fields: Array[String] = Array[String] (
        "eligibilityStatus",
        "RegisteredResource"
    )
    val eligibilityStatus: Fielder = parse_element (element (cls, fields(0)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): IntermittentResourceEligibility =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = IntermittentResourceEligibility (
            MarketFactors.parse (context),
            mask (eligibilityStatus (), 0),
            mask (RegisteredResource (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", false)
    )
}

/**
 * This class models the load distribution factors.
 *
 * This class should be used in one of two ways:
 *
 * @param sup Reference to the superclass object.
 * @param pDistFactor Real power (MW) load distribution factor
 * @param qDistFactor Reactive power (MVAr) load distribution factor
 * @param AggregatedPnode [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param IndividualPnode [[ch.ninecode.model.IndividualPnode IndividualPnode]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class LoadDistributionFactor
(
    override val sup: BasicElement,
    pDistFactor: Double,
    qDistFactor: Double,
    AggregatedPnode: String,
    IndividualPnode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LoadDistributionFactor.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LoadDistributionFactor.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LoadDistributionFactor.fields (position), value)
        emitelem (0, pDistFactor)
        emitelem (1, qDistFactor)
        emitattr (2, AggregatedPnode)
        emitattr (3, IndividualPnode)
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
    val fields: Array[String] = Array[String] (
        "pDistFactor",
        "qDistFactor",
        "AggregatedPnode",
        "IndividualPnode"
    )
    val pDistFactor: Fielder = parse_element (element (cls, fields(0)))
    val qDistFactor: Fielder = parse_element (element (cls, fields(1)))
    val AggregatedPnode: Fielder = parse_attribute (attribute (cls, fields(2)))
    val IndividualPnode: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): LoadDistributionFactor =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LoadDistributionFactor (
            BasicElement.parse (context),
            toDouble (mask (pDistFactor (), 0)),
            toDouble (mask (qDistFactor (), 1)),
            mask (AggregatedPnode (), 2),
            mask (IndividualPnode (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AggregatedPnode", "AggregatedPnode", false),
        Relationship ("IndividualPnode", "IndividualPnode", false)
    )
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
case class LossSensitivity
(
    override val sup: MarketFactors,
    lossFactor: Double,
    MktConnectivityNode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "lossFactor",
        "MktConnectivityNode"
    )
    val lossFactor: Fielder = parse_element (element (cls, fields(0)))
    val MktConnectivityNode: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): LossSensitivity =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LossSensitivity (
            MarketFactors.parse (context),
            toDouble (mask (lossFactor (), 0)),
            mask (MktConnectivityNode (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MktConnectivityNode", "MktConnectivityNode", false)
    )
}

/**
 * Maximum MW and optionally Minimum MW (Y1 and Y2, respectively)
 *
 * @param sup Reference to the superclass object.
 * @param SecurityConstraintLimit [[ch.ninecode.model.ContingencyConstraintLimit ContingencyConstraintLimit]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MWLimitSchedule
(
    override val sup: BasicElement,
    SecurityConstraintLimit: String
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
    override def copy (): Row = { clone ().asInstanceOf[MWLimitSchedule] }
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
    val fields: Array[String] = Array[String] (
        "SecurityConstraintLimit"
    )
    val SecurityConstraintLimit: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): MWLimitSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MWLimitSchedule (
            BasicElement.parse (context),
            mask (SecurityConstraintLimit (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("SecurityConstraintLimit", "ContingencyConstraintLimit", false)
    )
}

/**
 * Subclass of IEC61970:Wires:ACLineSegment
 *
 * @param sup [[ch.ninecode.model.ACLineSegment ACLineSegment]] Reference to the superclass object.
 * @param EndAFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @param EndBFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktACLineSegment
(
    override val sup: ACLineSegment,
    EndAFlow: String,
    EndBFlow: String
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
    def ACLineSegment: ACLineSegment = sup.asInstanceOf[ACLineSegment]
    override def copy (): Row = { clone ().asInstanceOf[MktACLineSegment] }
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
    val fields: Array[String] = Array[String] (
        "EndAFlow",
        "EndBFlow"
    )
    val EndAFlow: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EndBFlow: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): MktACLineSegment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktACLineSegment (
            ACLineSegment.parse (context),
            mask (EndAFlow (), 0),
            mask (EndBFlow (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("EndAFlow", "BranchEndFlow", false),
        Relationship ("EndBFlow", "BranchEndFlow", false)
    )
}

/**
 * Subclass of IEC61970:Meas:AnalogLimit
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
case class MktAnalogLimit
(
    override val sup: AnalogLimit,
    exceededLimit: Boolean,
    limitType: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "exceededLimit",
        "limitType"
    )
    val exceededLimit: Fielder = parse_element (element (cls, fields(0)))
    val limitType: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): MktAnalogLimit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktAnalogLimit (
            AnalogLimit.parse (context),
            toBoolean (mask (exceededLimit (), 0)),
            mask (limitType (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Subclass of IEC61970:Meas:AnalogLimitSet
 *
 * @param sup [[ch.ninecode.model.AnalogLimitSet AnalogLimitSet]] Reference to the superclass object.
 * @param ratingSet Rating set numbers
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktAnalogLimitSet
(
    override val sup: AnalogLimitSet,
    ratingSet: Int
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "ratingSet"
    )
    val ratingSet: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): MktAnalogLimitSet =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktAnalogLimitSet (
            AnalogLimitSet.parse (context),
            toInteger (mask (ratingSet (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Subclass of IEC61970:Meas:AnalogValue
 *
 * @param sup [[ch.ninecode.model.AnalogValue AnalogValue]] Reference to the superclass object.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktAnalogValue
(
    override val sup: AnalogValue
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
    def AnalogValue: AnalogValue = sup.asInstanceOf[AnalogValue]
    override def copy (): Row = { clone ().asInstanceOf[MktAnalogValue] }
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
        "\t<cim:MktAnalogValue rdf:ID=\"%s\">\n%s\t</cim:MktAnalogValue>".format (id, export_fields)
    }
}

object MktAnalogValue
extends
    Parseable[MktAnalogValue]
{

    def parse (context: Context): MktAnalogValue =
    {
        implicit val ctx: Context = context
        val ret = MktAnalogValue (
            AnalogValue.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Market subclass of IEC61970:ControlArea
 *
 * @param sup [[ch.ninecode.model.ControlArea ControlArea]] Reference to the superclass object.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktControlArea
(
    override val sup: ControlArea
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
    def ControlArea: ControlArea = sup.asInstanceOf[ControlArea]
    override def copy (): Row = { clone ().asInstanceOf[MktControlArea] }
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
        "\t<cim:MktControlArea rdf:ID=\"%s\">\n%s\t</cim:MktControlArea>".format (id, export_fields)
    }
}

object MktControlArea
extends
    Parseable[MktControlArea]
{

    def parse (context: Context): MktControlArea =
    {
        implicit val ctx: Context = context
        val ret = MktControlArea (
            ControlArea.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Subclass of IEC61970:Meas:DiscreteValue
 *
 * @param sup [[ch.ninecode.model.DiscreteValue DiscreteValue]] Reference to the superclass object.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktDiscreteValue
(
    override val sup: DiscreteValue
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
    def DiscreteValue: DiscreteValue = sup.asInstanceOf[DiscreteValue]
    override def copy (): Row = { clone ().asInstanceOf[MktDiscreteValue] }
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
        "\t<cim:MktDiscreteValue rdf:ID=\"%s\">\n%s\t</cim:MktDiscreteValue>".format (id, export_fields)
    }
}

object MktDiscreteValue
extends
    Parseable[MktDiscreteValue]
{

    def parse (context: Context): MktDiscreteValue =
    {
        implicit val ctx: Context = context
        val ret = MktDiscreteValue (
            DiscreteValue.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Subclass of IEC61970:Wires:SeriesCompensator
 *
 * @param sup [[ch.ninecode.model.SeriesCompensator SeriesCompensator]] Reference to the superclass object.
 * @param EndAFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @param EndBFlow [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktSeriesCompensator
(
    override val sup: SeriesCompensator,
    EndAFlow: String,
    EndBFlow: String
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
    def SeriesCompensator: SeriesCompensator = sup.asInstanceOf[SeriesCompensator]
    override def copy (): Row = { clone ().asInstanceOf[MktSeriesCompensator] }
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
    val fields: Array[String] = Array[String] (
        "EndAFlow",
        "EndBFlow"
    )
    val EndAFlow: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EndBFlow: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): MktSeriesCompensator =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktSeriesCompensator (
            SeriesCompensator.parse (context),
            mask (EndAFlow (), 0),
            mask (EndBFlow (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("EndAFlow", "BranchEndFlow", false),
        Relationship ("EndBFlow", "BranchEndFlow", false)
    )
}

/**
 * Subclass of IEC61970:Wires:ShuntCompensator
 *
 * @param sup [[ch.ninecode.model.ShuntCompensator ShuntCompensator]] Reference to the superclass object.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktShuntCompensator
(
    override val sup: ShuntCompensator
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
    def ShuntCompensator: ShuntCompensator = sup.asInstanceOf[ShuntCompensator]
    override def copy (): Row = { clone ().asInstanceOf[MktShuntCompensator] }
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
        "\t<cim:MktShuntCompensator rdf:ID=\"%s\">\n%s\t</cim:MktShuntCompensator>".format (id, export_fields)
    }
}

object MktShuntCompensator
extends
    Parseable[MktShuntCompensator]
{

    def parse (context: Context): MktShuntCompensator =
    {
        implicit val ctx: Context = context
        val ret = MktShuntCompensator (
            ShuntCompensator.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Subclass of IEC61970:Wires:Switch
 *
 * @param sup [[ch.ninecode.model.Switch Switch]] Reference to the superclass object.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktSwitch
(
    override val sup: Switch
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
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { clone ().asInstanceOf[MktSwitch] }
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
        "\t<cim:MktSwitch rdf:ID=\"%s\">\n%s\t</cim:MktSwitch>".format (id, export_fields)
    }
}

object MktSwitch
extends
    Parseable[MktSwitch]
{

    def parse (context: Context): MktSwitch =
    {
        implicit val ctx: Context = context
        val ret = MktSwitch (
            Switch.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Subclass of IEC61970:Wires:TapChanger
 *
 * @param sup [[ch.ninecode.model.TapChanger TapChanger]] Reference to the superclass object.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class MktTapChanger
(
    override val sup: TapChanger
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
    def TapChanger: TapChanger = sup.asInstanceOf[TapChanger]
    override def copy (): Row = { clone ().asInstanceOf[MktTapChanger] }
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
        "\t<cim:MktTapChanger rdf:ID=\"%s\">\n%s\t</cim:MktTapChanger>".format (id, export_fields)
    }
}

object MktTapChanger
extends
    Parseable[MktTapChanger]
{

    def parse (context: Context): MktTapChanger =
    {
        implicit val ctx: Context = context
        val ret = MktTapChanger (
            TapChanger.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
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
case class NodeConstraintTerm
(
    override val sup: ConstraintTerm,
    MktConnectivityNode: String
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
    def ConstraintTerm: ConstraintTerm = sup.asInstanceOf[ConstraintTerm]
    override def copy (): Row = { clone ().asInstanceOf[NodeConstraintTerm] }
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
    val fields: Array[String] = Array[String] (
        "MktConnectivityNode"
    )
    val MktConnectivityNode: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): NodeConstraintTerm =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = NodeConstraintTerm (
            ConstraintTerm.parse (context),
            mask (MktConnectivityNode (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MktConnectivityNode", "MktConnectivityNode", false)
    )
}

/**
 * A profile is a simpler curve type.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class Profile
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
    override def copy (): Row = { clone ().asInstanceOf[Profile] }
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
        "\t<cim:Profile rdf:ID=\"%s\">\n%s\t</cim:Profile>".format (id, export_fields)
    }
}

object Profile
extends
    Parseable[Profile]
{

    def parse (context: Context): Profile =
    {
        implicit val ctx: Context = context
        val ret = Profile (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
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
case class ProfileData
(
    override val sup: BasicElement,
    bidPrice: Double,
    capacityLevel: Double,
    energyLevel: Double,
    minimumLevel: Double,
    sequenceNumber: Int,
    startDateTime: String,
    stopDateTime: String,
    Profile: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0, null, null, List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ProfileData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProfileData.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ProfileData.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "bidPrice",
        "capacityLevel",
        "energyLevel",
        "minimumLevel",
        "sequenceNumber",
        "startDateTime",
        "stopDateTime",
        "Profile"
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("Profile", "Profile", true)
    )
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
case class ReserveDemandCurve
(
    override val sup: Curve,
    reqMaxMW: Double,
    reserveRequirementType: String,
    ASRequirements: String,
    MarketRegion: String
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[ReserveDemandCurve] }
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
    val fields: Array[String] = Array[String] (
        "reqMaxMW",
        "reserveRequirementType",
        "ASRequirements",
        "MarketRegion"
    )
    val reqMaxMW: Fielder = parse_element (element (cls, fields(0)))
    val reserveRequirementType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ASRequirements: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MarketRegion: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): ReserveDemandCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("ASRequirements", "ASRequirements", false),
        Relationship ("MarketRegion", "MarketRegion", false)
    )
}

/**
 * Contains information about the update from SCADA
 *
 * @param sup Reference to the superclass object.
 * @param timeStamp time of the update from SCADA
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class SCADAInformation
(
    override val sup: BasicElement,
    timeStamp: String
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
    override def copy (): Row = { clone ().asInstanceOf[SCADAInformation] }
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
    val fields: Array[String] = Array[String] (
        "timeStamp"
    )
    val timeStamp: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): SCADAInformation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SCADAInformation (
            BasicElement.parse (context),
            mask (timeStamp (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Typically provided by RTO systems, constraints identified in both base case and critical contingency cases have to be transferred.
 *
 * A constraint has N (&gt;=1) constraint terms. A term is represented by an
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param BaseCaseConstraintLimit [[ch.ninecode.model.BaseCaseConstraintLimit BaseCaseConstraintLimit]] <em>undocumented</em>
 * @param DefaultConstraintLimit [[ch.ninecode.model.DefaultConstraintLimit DefaultConstraintLimit]] <em>undocumented</em>
 * @param RTO [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class SecurityConstraintSum
(
    override val sup: MarketFactors,
    BaseCaseConstraintLimit: String,
    DefaultConstraintLimit: String,
    RTO: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SecurityConstraintSum.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SecurityConstraintSum.fields (position), value)
        emitattr (0, BaseCaseConstraintLimit)
        emitattr (1, DefaultConstraintLimit)
        emitattr (2, RTO)
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
    val fields: Array[String] = Array[String] (
        "BaseCaseConstraintLimit",
        "DefaultConstraintLimit",
        "RTO"
    )
    val BaseCaseConstraintLimit: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DefaultConstraintLimit: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): SecurityConstraintSum =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SecurityConstraintSum (
            MarketFactors.parse (context),
            mask (BaseCaseConstraintLimit (), 0),
            mask (DefaultConstraintLimit (), 1),
            mask (RTO (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("BaseCaseConstraintLimit", "BaseCaseConstraintLimit", false),
        Relationship ("DefaultConstraintLimit", "DefaultConstraintLimit", false),
        Relationship ("RTO", "RTO", false)
    )
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
case class SecurityConstraints
(
    override val sup: IdentifiedObject,
    actualMW: Double,
    maxMW: Double,
    minMW: Double,
    Flowgate: String,
    GeneratingBid: String,
    RTO: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "actualMW",
        "maxMW",
        "minMW",
        "Flowgate",
        "GeneratingBid",
        "RTO"
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", false),
        Relationship ("GeneratingBid", "GeneratingBid", false),
        Relationship ("RTO", "RTO", false)
    )
}

/**
 * The defined termination points of a transmission path (down to distribution level or to a customer - generation or consumption or both).
 *
 * Service points are defined from the viewpoint of the transmission service. Each service point is contained within (or on the boundary of) an interchange area. A service point is source or destination of a transaction.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class ServicePoint
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
    override def copy (): Row = { clone ().asInstanceOf[ServicePoint] }
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
        "\t<cim:ServicePoint rdf:ID=\"%s\">\n%s\t</cim:ServicePoint>".format (id, export_fields)
    }
}

object ServicePoint
extends
    Parseable[ServicePoint]
{

    def parse (context: Context): ServicePoint =
    {
        implicit val ctx: Context = context
        val ret = ServicePoint (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Optimal Power Flow or State Estimator Filter Bank Data for OTS.
 *
 * This is used for RealTime, Study and Maintenance Users
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
case class ShuntCompensatorDynamicData
(
    override val sup: BasicElement,
    connectionStatus: Int,
    desiredVoltage: Double,
    mVARInjection: Double,
    stepPosition: Int,
    voltageRegulationStatus: Boolean,
    MktShuntCompensator: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0.0, 0.0, 0, false, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "connectionStatus",
        "desiredVoltage",
        "mVARInjection",
        "stepPosition",
        "voltageRegulationStatus",
        "MktShuntCompensator"
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("MktShuntCompensator", "MktShuntCompensator", false)
    )
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
case class SwitchStatus
(
    override val sup: BasicElement,
    switchStatus: String,
    MktSwitch: String
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
    override def copy (): Row = { clone ().asInstanceOf[SwitchStatus] }
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
    val fields: Array[String] = Array[String] (
        "switchStatus",
        "MktSwitch"
    )
    val switchStatus: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MktSwitch: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): SwitchStatus =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SwitchStatus (
            BasicElement.parse (context),
            mask (switchStatus (), 0),
            mask (MktSwitch (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MktSwitch", "MktSwitch", false)
    )
}

/**
 * This class models the system distribution factors.
 *
 * This class needs to be used along with the HostControlArea and the ConnectivityNode to show the distribution of each individual party.
 *
 * @param sup Reference to the superclass object.
 * @param factor Used to calculate load "participation" of a connectivity node in an host control area
 * @param HostControlArea [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param MktConnectivityNode [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class SysLoadDistributionFactor
(
    override val sup: BasicElement,
    factor: Double,
    HostControlArea: String,
    MktConnectivityNode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SysLoadDistributionFactor.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SysLoadDistributionFactor.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SysLoadDistributionFactor.fields (position), value)
        emitelem (0, factor)
        emitattr (1, HostControlArea)
        emitattr (2, MktConnectivityNode)
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
    val fields: Array[String] = Array[String] (
        "factor",
        "HostControlArea",
        "MktConnectivityNode"
    )
    val factor: Fielder = parse_element (element (cls, fields(0)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MktConnectivityNode: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): SysLoadDistributionFactor =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SysLoadDistributionFactor (
            BasicElement.parse (context),
            toDouble (mask (factor (), 0)),
            mask (HostControlArea (), 1),
            mask (MktConnectivityNode (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("HostControlArea", "HostControlArea", false),
        Relationship ("MktConnectivityNode", "MktConnectivityNode", false)
    )
}

/**
 * A Transmission Right(TR) can be a chain of TR's or on individual.
 *
 * When a transmission right is not a chain, this is formally the ETC/TOR Entitlement for each ETC/TOR contract with the inclusion of CVR(Converted Rights) as an ETC. This is the sum of all entitlements on all related transmission interfaces for the same TR.
 *
 * @param sup Reference to the superclass object.
 * @param entitlement The entitlement
 * @param startOperatingDate Operating date and hour when the entitlement applies
 * @param TransmissionContractRight [[ch.ninecode.model.ContractRight ContractRight]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class TREntitlement
(
    override val sup: BasicElement,
    entitlement: Double,
    startOperatingDate: String,
    TransmissionContractRight: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "entitlement",
        "startOperatingDate",
        "TransmissionContractRight"
    )
    val entitlement: Fielder = parse_element (element (cls, fields(0)))
    val startOperatingDate: Fielder = parse_element (element (cls, fields(1)))
    val TransmissionContractRight: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): TREntitlement =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TREntitlement (
            BasicElement.parse (context),
            toDouble (mask (entitlement (), 0)),
            mask (startOperatingDate (), 1),
            mask (TransmissionContractRight (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("TransmissionContractRight", "ContractRight", false)
    )
}

/**
 * Optimal Power Flow or State Estimator Phase Shifter Data.
 *
 * This is used for RealTime, Study and Maintenance Users. SE Solution Phase Shifter Measurements from the last run of SE
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
case class TapChangerDynamicData
(
    override val sup: BasicElement,
    angleRegulationStatus: Boolean,
    desiredMW: Double,
    desiredVoltage: Double,
    maximumAngle: Double,
    minimumAngle: Double,
    solvedAngle: Double,
    tapPosition: Double,
    voltageRegulationStatus: Boolean,
    MktTapChanger: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("MktTapChanger", "MktTapChanger", false)
    )
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
case class TerminalConstraintTerm
(
    override val sup: ConstraintTerm,
    MktTerminal: String
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
    def ConstraintTerm: ConstraintTerm = sup.asInstanceOf[ConstraintTerm]
    override def copy (): Row = { clone ().asInstanceOf[TerminalConstraintTerm] }
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
    val fields: Array[String] = Array[String] (
        "MktTerminal"
    )
    val MktTerminal: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): TerminalConstraintTerm =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TerminalConstraintTerm (
            ConstraintTerm.parse (context),
            mask (MktTerminal (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MktTerminal", "MktTerminal", false)
    )
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
case class TransferInterface
(
    override val sup: IdentifiedObject,
    HostControlArea: String,
    TransferInterfaceSolution: String
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TransferInterface] }
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
    val fields: Array[String] = Array[String] (
        "HostControlArea",
        "TransferInterfaceSolution"
    )
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TransferInterfaceSolution: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): TransferInterface =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TransferInterface (
            IdentifiedObject.parse (context),
            mask (HostControlArea (), 0),
            mask (TransferInterfaceSolution (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("HostControlArea", "HostControlArea", false),
        Relationship ("TransferInterfaceSolution", "TransferInterfaceSolution", false)
    )
}

/**
 * TNA Interface Definitions from OPF for VSA
 *
 * @param sup Reference to the superclass object.
 * @param interfaceMargin The margin for the interface
 * @param postTransferMW Post Transfer MW for step
 * @param transferLimit Transfer Interface + Limit
 *        Attribute Usage: The absoloute of the maximum flow on the transfer interface.
 *        This is a positive MW value.
 * @param MktContingencyB [[ch.ninecode.model.MktContingency MktContingency]] <em>undocumented</em>
 * @param TransferInterface [[ch.ninecode.model.TransferInterface TransferInterface]] <em>undocumented</em>
 * @param _MktContingencyA [[ch.ninecode.model.MktContingency MktContingency]] <em>undocumented</em>
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class TransferInterfaceSolution
(
    override val sup: BasicElement,
    interfaceMargin: Double,
    postTransferMW: Double,
    transferLimit: Double,
    MktContingencyB: String,
    TransferInterface: String,
    _MktContingencyA: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "interfaceMargin",
        "postTransferMW",
        "transferLimit",
        "MktContingencyB",
        "TransferInterface",
        " MktContingencyA"
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("MktContingencyB", "MktContingency", false),
        Relationship ("TransferInterface", "TransferInterface", false),
        Relationship ("_MktContingencyA", "MktContingency", false)
    )
}

/**
 * This class models the transmission (either a transmission interface or a POR/POD pair) capacity including Total Transfer Capacity (TTC), Operating Transfer Capacity (OTC), and Capacity Benefit Margin (CBM)
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
case class TransmissionCapacity
(
    override val sup: BasicElement,
    capacityBenefitMargin: Double,
    operationalTransmissionCapacity: Double,
    startOperatingDate: String,
    totalTransmissionCapacity: Double,
    Flowgate: String,
    GenericConstraints: String,
    OTC15min_emergency: Double,
    OTCemergency: Double,
    POD: String,
    POR: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, 0.0, null, null, 0.0, 0.0, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("Flowgate", "Flowgate", false),
        Relationship ("GenericConstraints", "GenericConstraints", false)
    )
}

/**
 * This is formally called the branch group ETC/TOR entitlement with the inclusion of CVR as ETC.
 *
 * Is used to represent the entitlements. This could be also used to represent the TR entitlement on a POR/POD.
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
case class TransmissionInterfaceRightEntitlement
(
    override val sup: BasicElement,
    entitlement: Double,
    startOperatingDate: String,
    ContractRight: String,
    Flowgate: String,
    POD: String,
    POR: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "entitlement",
        "startOperatingDate",
        "ContractRight",
        "Flowgate",
        "POD",
        "POR"
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("ContractRight", "ContractRight", false),
        Relationship ("Flowgate", "Flowgate", false)
    )
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
 * @param PointOfReceipt [[ch.ninecode.model.ServicePoint ServicePoint]] A transmission path has a "point-of-receipt" service point
 * @group ExternalInputs
 * @groupname ExternalInputs Package ExternalInputs
 * @groupdesc ExternalInputs Inputs to the market system from external sources.
 */
case class TransmissionPath
(
    override val sup: IdentifiedObject,
    availTransferCapability: Double,
    parallelPathFlag: Boolean,
    totalTransferCapability: Double,
    DeliveryPoint: String,
    For: String,
    PointOfReceipt: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, false, 0.0, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TransmissionPath.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransmissionPath.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransmissionPath.fields (position), value)
        emitelem (0, availTransferCapability)
        emitelem (1, parallelPathFlag)
        emitelem (2, totalTransferCapability)
        emitattr (3, DeliveryPoint)
        emitattr (4, For)
        emitattr (5, PointOfReceipt)
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
    val fields: Array[String] = Array[String] (
        "availTransferCapability",
        "parallelPathFlag",
        "totalTransferCapability",
        "DeliveryPoint",
        "For",
        "PointOfReceipt"
    )
    val availTransferCapability: Fielder = parse_element (element (cls, fields(0)))
    val parallelPathFlag: Fielder = parse_element (element (cls, fields(1)))
    val totalTransferCapability: Fielder = parse_element (element (cls, fields(2)))
    val DeliveryPoint: Fielder = parse_attribute (attribute (cls, fields(3)))
    val For: Fielder = parse_attribute (attribute (cls, fields(4)))
    val PointOfReceipt: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): TransmissionPath =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TransmissionPath (
            IdentifiedObject.parse (context),
            toDouble (mask (availTransferCapability (), 0)),
            toBoolean (mask (parallelPathFlag (), 1)),
            toDouble (mask (totalTransferCapability (), 2)),
            mask (DeliveryPoint (), 3),
            mask (For (), 4),
            mask (PointOfReceipt (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("DeliveryPoint", "ServicePoint", false),
        Relationship ("For", "TransmissionCorridor", false),
        Relationship ("PointOfReceipt", "ServicePoint", false)
    )
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
case class TransmissionReservation
(
    override val sup: BasicElement,
    EnergyTransaction: String,
    Sink: String,
    Source: String,
    TransactionBid: String,
    TransmissionPath: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
        "EnergyTransaction",
        "Sink",
        "Source",
        "TransactionBid",
        "TransmissionPath"
    )
    val EnergyTransaction: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Sink: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Source: Fielder = parse_attribute (attribute (cls, fields(2)))
    val TransactionBid: Fielder = parse_attribute (attribute (cls, fields(3)))
    val TransmissionPath: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): TransmissionReservation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("EnergyTransaction", "EnergyTransaction", false),
        Relationship ("Sink", "ServicePoint", false),
        Relationship ("Source", "ServicePoint", false),
        Relationship ("TransactionBid", "TransactionBid", false),
        Relationship ("TransmissionPath", "TransmissionPath", false)
    )
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
case class UnitInitialConditions
(
    override val sup: IdentifiedObject,
    cumEnergy: Double,
    cumStatusChanges: Int,
    numberOfStartups: Int,
    onlineStatus: Boolean,
    resourceMW: Double,
    resourceStatus: Int,
    statusDate: String,
    timeInStatus: Double,
    timeInterval: String,
    GeneratingUnit: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0, 0, false, 0.0, 0, null, 0.0, null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val fields: Array[String] = Array[String] (
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
        implicit var bitfields: Array[Int] = Array(0)
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
    val relations: List[Relationship] = List (
        Relationship ("GeneratingUnit", "RegisteredGenerator", false)
    )
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
            EnergyConsumerData.register,
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
            MktAnalogValue.register,
            MktControlArea.register,
            MktDiscreteValue.register,
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