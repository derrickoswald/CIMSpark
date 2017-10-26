package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Model of results of market clearing with respect to  Ancillary Service products
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param MarketCaseClearing [[ch.ninecode.model.MarketCaseClearing MarketCaseClearing]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class AncillaryServiceClearing
(
    override val sup: MarketFactors,
    MarketCaseClearing: String
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[AncillaryServiceClearing] }
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
        implicit val clz: String = AncillaryServiceClearing.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AncillaryServiceClearing.fields (position), value)
        emitattr (0, MarketCaseClearing)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AncillaryServiceClearing rdf:ID=\"%s\">\n%s\t</cim:AncillaryServiceClearing>".format (id, export_fields)
    }
}

object AncillaryServiceClearing
extends
    Parseable[AncillaryServiceClearing]
{
    val fields: Array[String] = Array[String] (
        "MarketCaseClearing"
    )
    val MarketCaseClearing: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): AncillaryServiceClearing =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AncillaryServiceClearing (
            MarketFactors.parse (context),
            mask (MarketCaseClearing (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MarketCaseClearing", "MarketCaseClearing", false)
    )
}

/**
 * Model various charges to support billing and settlement of
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param calculationLevel Level in charge calculation order.
 * @param configVersion The version of configuration of calculation logic in the settlement.
 * @param deleteStatus <em>undocumented</em>
 * @param effectiveDate <em>undocumented</em>
 * @param exception <em>undocumented</em>
 * @param factor <em>undocumented</em>
 * @param frequency <em>undocumented</em>
 * @param numberInterval Number of intervals of bill determiant in trade day, eg 300 for five minute intervals.
 * @param offset <em>undocumented</em>
 * @param precisionLevel The level of precision in the current value.
 * @param primaryYN <em>undocumented</em>
 * @param referenceFlag <em>undocumented</em>
 * @param reportable <em>undocumented</em>
 * @param roundOff <em>undocumented</em>
 * @param source <em>undocumented</em>
 * @param terminationDate <em>undocumented</em>
 * @param unitOfMeasure The UOM for the current value of the Bill Determinant.
 * @param ChargeProfile [[ch.ninecode.model.ChargeProfile ChargeProfile]] <em>undocumented</em>
 * @param MktUserAttribute [[ch.ninecode.model.MktUserAttribute MktUserAttribute]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class BillDeterminant
(
    override val sup: Document,
    calculationLevel: String,
    configVersion: String,
    deleteStatus: String,
    effectiveDate: String,
    exception: String,
    factor: String,
    frequency: String,
    numberInterval: Int,
    offset: String,
    precisionLevel: String,
    primaryYN: String,
    referenceFlag: String,
    reportable: String,
    roundOff: String,
    source: String,
    terminationDate: String,
    unitOfMeasure: String,
    ChargeProfile: String,
    MktUserAttribute: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[BillDeterminant] }
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
        implicit val clz: String = BillDeterminant.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BillDeterminant.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BillDeterminant.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (BillDeterminant.fields (position), x))
        emitelem (0, calculationLevel)
        emitelem (1, configVersion)
        emitelem (2, deleteStatus)
        emitelem (3, effectiveDate)
        emitelem (4, exception)
        emitelem (5, factor)
        emitelem (6, frequency)
        emitelem (7, numberInterval)
        emitelem (8, offset)
        emitelem (9, precisionLevel)
        emitelem (10, primaryYN)
        emitelem (11, referenceFlag)
        emitelem (12, reportable)
        emitelem (13, roundOff)
        emitelem (14, source)
        emitelem (15, terminationDate)
        emitelem (16, unitOfMeasure)
        emitattr (17, ChargeProfile)
        emitattrs (18, MktUserAttribute)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BillDeterminant rdf:ID=\"%s\">\n%s\t</cim:BillDeterminant>".format (id, export_fields)
    }
}

object BillDeterminant
extends
    Parseable[BillDeterminant]
{
    val fields: Array[String] = Array[String] (
        "calculationLevel",
        "configVersion",
        "deleteStatus",
        "effectiveDate",
        "exception",
        "factor",
        "frequency",
        "numberInterval",
        "offset",
        "precisionLevel",
        "primaryYN",
        "referenceFlag",
        "reportable",
        "roundOff",
        "source",
        "terminationDate",
        "unitOfMeasure",
        "ChargeProfile",
        "MktUserAttribute"
    )
    val calculationLevel: Fielder = parse_element (element (cls, fields(0)))
    val configVersion: Fielder = parse_element (element (cls, fields(1)))
    val deleteStatus: Fielder = parse_element (element (cls, fields(2)))
    val effectiveDate: Fielder = parse_element (element (cls, fields(3)))
    val exception: Fielder = parse_element (element (cls, fields(4)))
    val factor: Fielder = parse_element (element (cls, fields(5)))
    val frequency: Fielder = parse_element (element (cls, fields(6)))
    val numberInterval: Fielder = parse_element (element (cls, fields(7)))
    val offset: Fielder = parse_element (element (cls, fields(8)))
    val precisionLevel: Fielder = parse_element (element (cls, fields(9)))
    val primaryYN: Fielder = parse_element (element (cls, fields(10)))
    val referenceFlag: Fielder = parse_element (element (cls, fields(11)))
    val reportable: Fielder = parse_element (element (cls, fields(12)))
    val roundOff: Fielder = parse_element (element (cls, fields(13)))
    val source: Fielder = parse_element (element (cls, fields(14)))
    val terminationDate: Fielder = parse_element (element (cls, fields(15)))
    val unitOfMeasure: Fielder = parse_element (element (cls, fields(16)))
    val ChargeProfile: Fielder = parse_attribute (attribute (cls, fields(17)))
    val MktUserAttribute: FielderMultiple = parse_attributes (attribute (cls, fields(18)))

    def parse (context: Context): BillDeterminant =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BillDeterminant (
            Document.parse (context),
            mask (calculationLevel (), 0),
            mask (configVersion (), 1),
            mask (deleteStatus (), 2),
            mask (effectiveDate (), 3),
            mask (exception (), 4),
            mask (factor (), 5),
            mask (frequency (), 6),
            toInteger (mask (numberInterval (), 7)),
            mask (offset (), 8),
            mask (precisionLevel (), 9),
            mask (primaryYN (), 10),
            mask (referenceFlag (), 11),
            mask (reportable (), 12),
            mask (roundOff (), 13),
            mask (source (), 14),
            mask (terminationDate (), 15),
            mask (unitOfMeasure (), 16),
            mask (ChargeProfile (), 17),
            masks (MktUserAttribute (), 18)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ChargeProfile", "ChargeProfile", false),
        Relationship ("MktUserAttribute", "MktUserAttribute", true)
    )
}

/**
 * A type of profile for financial charges
 *
 * @param sup [[ch.ninecode.model.Profile Profile]] Reference to the superclass object.
 * @param frequency The calculation frequency, daily or monthly.
 * @param numberInterval The number of intervals in the profile data.
 * @param typ The type of profile.
 *        It could be amount, price, or quantity.
 * @param unitOfMeasure The unit of measure applied to the value attribute of the profile data.
 * @param Bid [[ch.ninecode.model.Bid Bid]] <em>undocumented</em>
 * @param BillDeterminant [[ch.ninecode.model.BillDeterminant BillDeterminant]] <em>undocumented</em>
 * @param PassTroughBill [[ch.ninecode.model.PassThroughBill PassThroughBill]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ChargeProfile
(
    override val sup: Profile,
    frequency: String,
    numberInterval: Int,
    typ: String,
    unitOfMeasure: String,
    Bid: String,
    BillDeterminant: String,
    PassTroughBill: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Profile: Profile = sup.asInstanceOf[Profile]
    override def copy (): Row = { clone ().asInstanceOf[ChargeProfile] }
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
        implicit val clz: String = ChargeProfile.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ChargeProfile.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ChargeProfile.fields (position), value)
        emitelem (0, frequency)
        emitelem (1, numberInterval)
        emitelem (2, typ)
        emitelem (3, unitOfMeasure)
        emitattr (4, Bid)
        emitattr (5, BillDeterminant)
        emitattr (6, PassTroughBill)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ChargeProfile rdf:ID=\"%s\">\n%s\t</cim:ChargeProfile>".format (id, export_fields)
    }
}

object ChargeProfile
extends
    Parseable[ChargeProfile]
{
    val fields: Array[String] = Array[String] (
        "frequency",
        "numberInterval",
        "type",
        "unitOfMeasure",
        "Bid",
        "BillDeterminant",
        "PassTroughBill"
    )
    val frequency: Fielder = parse_element (element (cls, fields(0)))
    val numberInterval: Fielder = parse_element (element (cls, fields(1)))
    val typ: Fielder = parse_element (element (cls, fields(2)))
    val unitOfMeasure: Fielder = parse_element (element (cls, fields(3)))
    val Bid: Fielder = parse_attribute (attribute (cls, fields(4)))
    val BillDeterminant: Fielder = parse_attribute (attribute (cls, fields(5)))
    val PassTroughBill: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): ChargeProfile =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ChargeProfile (
            Profile.parse (context),
            mask (frequency (), 0),
            toInteger (mask (numberInterval (), 1)),
            mask (typ (), 2),
            mask (unitOfMeasure (), 3),
            mask (Bid (), 4),
            mask (BillDeterminant (), 5),
            mask (PassTroughBill (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Bid", "Bid", false),
        Relationship ("BillDeterminant", "BillDeterminant", false),
        Relationship ("PassTroughBill", "PassThroughBill", false)
    )
}

/**
 * Model of various charges associated with an energy profile to support billing and settlement
 *
 * @param sup Reference to the superclass object.
 * @param sequence The sequence number of the profile.
 * @param timeStamp The date and time of an interval.
 * @param value The value of an interval given a profile type (amount, price, or quantity), subject to the UOM.
 * @param BillDeterminant [[ch.ninecode.model.BillDeterminant BillDeterminant]] <em>undocumented</em>
 * @param ChargeProfile [[ch.ninecode.model.ChargeProfile ChargeProfile]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ChargeProfileData
(
    override val sup: BasicElement,
    sequence: Int,
    timeStamp: String,
    value: Double,
    BillDeterminant: String,
    ChargeProfile: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ChargeProfileData] }
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
        implicit val clz: String = ChargeProfileData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ChargeProfileData.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ChargeProfileData.fields (position), value)
        emitelem (0, sequence)
        emitelem (1, timeStamp)
        emitelem (2, value)
        emitattr (3, BillDeterminant)
        emitattr (4, ChargeProfile)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ChargeProfileData rdf:ID=\"%s\">\n%s\t</cim:ChargeProfileData>".format (id, export_fields)
    }
}

object ChargeProfileData
extends
    Parseable[ChargeProfileData]
{
    val fields: Array[String] = Array[String] (
        "sequence",
        "timeStamp",
        "value",
        "BillDeterminant",
        "ChargeProfile"
    )
    val sequence: Fielder = parse_element (element (cls, fields(0)))
    val timeStamp: Fielder = parse_element (element (cls, fields(1)))
    val value: Fielder = parse_element (element (cls, fields(2)))
    val BillDeterminant: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ChargeProfile: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): ChargeProfileData =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ChargeProfileData (
            BasicElement.parse (context),
            toInteger (mask (sequence (), 0)),
            mask (timeStamp (), 1),
            toDouble (mask (value (), 2)),
            mask (BillDeterminant (), 3),
            mask (ChargeProfile (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("BillDeterminant", "BillDeterminant", false),
        Relationship ("ChargeProfile", "ChargeProfile", false)
    )
}

/**
 * Models results of market clearing which call for commitment of units.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class CommitmentClearing
(
    override val sup: MarketFactors
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[CommitmentClearing] }
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
        "\t<cim:CommitmentClearing rdf:ID=\"%s\">\n%s\t</cim:CommitmentClearing>".format (id, export_fields)
    }
}

object CommitmentClearing
extends
    Parseable[CommitmentClearing]
{

    def parse (context: Context): CommitmentClearing =
    {
        implicit val ctx: Context = context
        val ret = CommitmentClearing (
            MarketFactors.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Provides the necessary information (on a resource basis) to capture the Startup/Shutdown commitment results.
 *
 * This information is relevant to all markets.
 *
 * @param sup Reference to the superclass object.
 * @param commitmentType the type of UC status (self commitment, ISO commitment, or SCUC commitment)
 * @param instructionCost Total cost associated with changing the status of the resource.
 * @param instructionType Indicator of either a Start-Up or a Shut-Down.
 * @param intervalEndTime End time for the commitment period.
 *        This will be on an interval boundary.
 * @param intervalStartTime Start time for the commitment period.
 *        This will be on an interval boundary.
 * @param minStatusChangeTime SCUC commitment period start-up time.
 *        Calculated start up time based on the StartUpTimeCurve provided with the Bid.
 * @param noLoadCost Unit no load cost in case of energy commodity
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class Commitments
(
    override val sup: BasicElement,
    commitmentType: String,
    instructionCost: Double,
    instructionType: String,
    intervalEndTime: String,
    intervalStartTime: String,
    minStatusChangeTime: Int,
    noLoadCost: Double,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null, null, 0, 0.0, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Commitments] }
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
        implicit val clz: String = Commitments.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Commitments.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Commitments.fields (position), value)
        emitattr (0, commitmentType)
        emitelem (1, instructionCost)
        emitattr (2, instructionType)
        emitelem (3, intervalEndTime)
        emitelem (4, intervalStartTime)
        emitelem (5, minStatusChangeTime)
        emitelem (6, noLoadCost)
        emitelem (7, updateTimeStamp)
        emitattr (8, updateType)
        emitelem (9, updateUser)
        emitattr (10, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Commitments rdf:ID=\"%s\">\n%s\t</cim:Commitments>".format (id, export_fields)
    }
}

object Commitments
extends
    Parseable[Commitments]
{
    val fields: Array[String] = Array[String] (
        "commitmentType",
        "instructionCost",
        "instructionType",
        "intervalEndTime",
        "intervalStartTime",
        "minStatusChangeTime",
        "noLoadCost",
        "updateTimeStamp",
        "updateType",
        "updateUser",
        "RegisteredResource"
    )
    val commitmentType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val instructionCost: Fielder = parse_element (element (cls, fields(1)))
    val instructionType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val intervalEndTime: Fielder = parse_element (element (cls, fields(3)))
    val intervalStartTime: Fielder = parse_element (element (cls, fields(4)))
    val minStatusChangeTime: Fielder = parse_element (element (cls, fields(5)))
    val noLoadCost: Fielder = parse_element (element (cls, fields(6)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(7)))
    val updateType: Fielder = parse_attribute (attribute (cls, fields(8)))
    val updateUser: Fielder = parse_element (element (cls, fields(9)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: Context): Commitments =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Commitments (
            BasicElement.parse (context),
            mask (commitmentType (), 0),
            toDouble (mask (instructionCost (), 1)),
            mask (instructionType (), 2),
            mask (intervalEndTime (), 3),
            mask (intervalStartTime (), 4),
            toInteger (mask (minStatusChangeTime (), 5)),
            toDouble (mask (noLoadCost (), 6)),
            mask (updateTimeStamp (), 7),
            mask (updateType (), 8),
            mask (updateUser (), 9),
            mask (RegisteredResource (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", false)
    )
}

/**
 * Groups all items associated with Binding Constraints and Constraint Violations per interval and market.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ConstraintClearing
(
    override val sup: MarketFactors
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[ConstraintClearing] }
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
        "\t<cim:ConstraintClearing rdf:ID=\"%s\">\n%s\t</cim:ConstraintClearing>".format (id, export_fields)
    }
}

object ConstraintClearing
extends
    Parseable[ConstraintClearing]
{

    def parse (context: Context): ConstraintClearing =
    {
        implicit val ctx: Context = context
        val ret = ConstraintClearing (
            MarketFactors.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Provides the Market results for the constraint processing for either the DAM or RTM.
 *
 * The data includes the constraint type (binding or violated), the solved value for the constraint, and the associated shadow price.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param baseFlow Branch base Power Flow.
 * @param bindingLimit MW Limit.
 * @param clearedValue Cleared MW.
 * @param competitivePathConstraint Non-competitive path constraint Flag"(Y/N)  indicating whether the shadow price on a non-competitive path was non-zero.
 * @param constraintType Type of constraint.
 * @param limitFlag Limit flag ('Maximum', 'Minimum').
 * @param optimizationFlag Included in optimization Y/N.
 * @param overloadMW Transmission overload MW.
 * @param percentMW Actual MW flow as percent of limit.
 * @param shadowPrice Shadow Price (\$/MW) for the commodity.
 *        Shadow price for the corresponding constraint.
 * @param updateTimeStamp Update time stamp.
 * @param updateType MQS change type.
 * @param updateUser Updated user.
 * @param BGLimit This value is determined in DA and RTM.
 *        The SCUC optimization ensures that the MW flow on the Branch Group will not exceed this limit in the relevant direction.
 * @param BGTRResCap Branch Group TR Reservation Capacity - This value is determined in DA and RTM.
 *        It is the amount of spare transmission capacity that is left for the TR holder to use.
 * @param ConstraintClearing [[ch.ninecode.model.ConstraintClearing ConstraintClearing]] <em>undocumented</em>
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param MktContingency [[ch.ninecode.model.MktContingency MktContingency]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ConstraintResults
(
    override val sup: IdentifiedObject,
    baseFlow: Double,
    bindingLimit: Double,
    clearedValue: Double,
    competitivePathConstraint: String,
    constraintType: String,
    limitFlag: String,
    optimizationFlag: String,
    overloadMW: Double,
    percentMW: Double,
    shadowPrice: Double,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    BGLimit: Double,
    BGTRResCap: Double,
    ConstraintClearing: String,
    Flowgate: String,
    MktContingency: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null, null, null, null, 0.0, 0.0, 0.0, null, null, null, 0.0, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ConstraintResults] }
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
        implicit val clz: String = ConstraintResults.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ConstraintResults.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ConstraintResults.fields (position), value)
        emitelem (0, baseFlow)
        emitelem (1, bindingLimit)
        emitelem (2, clearedValue)
        emitattr (3, competitivePathConstraint)
        emitattr (4, constraintType)
        emitattr (5, limitFlag)
        emitattr (6, optimizationFlag)
        emitelem (7, overloadMW)
        emitelem (8, percentMW)
        emitelem (9, shadowPrice)
        emitelem (10, updateTimeStamp)
        emitattr (11, updateType)
        emitelem (12, updateUser)
        emitelem (13, BGLimit)
        emitelem (14, BGTRResCap)
        emitattr (15, ConstraintClearing)
        emitattr (16, Flowgate)
        emitattr (17, MktContingency)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ConstraintResults rdf:ID=\"%s\">\n%s\t</cim:ConstraintResults>".format (id, export_fields)
    }
}

object ConstraintResults
extends
    Parseable[ConstraintResults]
{
    val fields: Array[String] = Array[String] (
        "baseFlow",
        "bindingLimit",
        "clearedValue",
        "competitivePathConstraint",
        "constraintType",
        "limitFlag",
        "optimizationFlag",
        "overloadMW",
        "percentMW",
        "shadowPrice",
        "updateTimeStamp",
        "updateType",
        "updateUser",
        "BGLimit",
        "BGTRResCap",
        "ConstraintClearing",
        "Flowgate",
        "MktContingency"
    )
    val baseFlow: Fielder = parse_element (element (cls, fields(0)))
    val bindingLimit: Fielder = parse_element (element (cls, fields(1)))
    val clearedValue: Fielder = parse_element (element (cls, fields(2)))
    val competitivePathConstraint: Fielder = parse_attribute (attribute (cls, fields(3)))
    val constraintType: Fielder = parse_attribute (attribute (cls, fields(4)))
    val limitFlag: Fielder = parse_attribute (attribute (cls, fields(5)))
    val optimizationFlag: Fielder = parse_attribute (attribute (cls, fields(6)))
    val overloadMW: Fielder = parse_element (element (cls, fields(7)))
    val percentMW: Fielder = parse_element (element (cls, fields(8)))
    val shadowPrice: Fielder = parse_element (element (cls, fields(9)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(10)))
    val updateType: Fielder = parse_attribute (attribute (cls, fields(11)))
    val updateUser: Fielder = parse_element (element (cls, fields(12)))
    val BGLimit: Fielder = parse_element (element (cls, fields(13)))
    val BGTRResCap: Fielder = parse_element (element (cls, fields(14)))
    val ConstraintClearing: Fielder = parse_attribute (attribute (cls, fields(15)))
    val Flowgate: Fielder = parse_attribute (attribute (cls, fields(16)))
    val MktContingency: Fielder = parse_attribute (attribute (cls, fields(17)))

    def parse (context: Context): ConstraintResults =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ConstraintResults (
            IdentifiedObject.parse (context),
            toDouble (mask (baseFlow (), 0)),
            toDouble (mask (bindingLimit (), 1)),
            toDouble (mask (clearedValue (), 2)),
            mask (competitivePathConstraint (), 3),
            mask (constraintType (), 4),
            mask (limitFlag (), 5),
            mask (optimizationFlag (), 6),
            toDouble (mask (overloadMW (), 7)),
            toDouble (mask (percentMW (), 8)),
            toDouble (mask (shadowPrice (), 9)),
            mask (updateTimeStamp (), 10),
            mask (updateType (), 11),
            mask (updateUser (), 12),
            toDouble (mask (BGLimit (), 13)),
            toDouble (mask (BGTRResCap (), 14)),
            mask (ConstraintClearing (), 15),
            mask (Flowgate (), 16),
            mask (MktContingency (), 17)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ConstraintClearing", "ConstraintClearing", false),
        Relationship ("Flowgate", "Flowgate", false),
        Relationship ("MktContingency", "MktContingency", false)
    )
}

/**
 * Provides the necessary information (on a resource basis) to capture the Dispatch Operating Point (DOP) results on a Dispatch interval.
 *
 * This information is only relevant to the RT interval market.
 *
 * @param sup Reference to the superclass object.
 * @param mwDOP Dispatched Operating Point (MW)
 * @param plotPriority A value used to establish priority of the DOP when plotting.
 *        This is only applicable when two DOPs exist for the same time, but with different MW values.  E.g. when indicating a step in the curve.  Its used to determine if the curve steps up or down.
 * @param runIndicatorDOP Indication of DOP validity.
 *        Shows the DOP is calculated from the latest run (YES). A NO indicator shows that the DOP is copied from a previous execution.
 * @param timestampDOP DOP time stamp
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param RegisteredResouce [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class DopInstruction
(
    override val sup: BasicElement,
    mwDOP: Double,
    plotPriority: Int,
    runIndicatorDOP: String,
    timestampDOP: String,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    RegisteredResouce: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DopInstruction] }
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
        implicit val clz: String = DopInstruction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DopInstruction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DopInstruction.fields (position), value)
        emitelem (0, mwDOP)
        emitelem (1, plotPriority)
        emitattr (2, runIndicatorDOP)
        emitelem (3, timestampDOP)
        emitelem (4, updateTimeStamp)
        emitattr (5, updateType)
        emitelem (6, updateUser)
        emitattr (7, RegisteredResouce)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DopInstruction rdf:ID=\"%s\">\n%s\t</cim:DopInstruction>".format (id, export_fields)
    }
}

object DopInstruction
extends
    Parseable[DopInstruction]
{
    val fields: Array[String] = Array[String] (
        "mwDOP",
        "plotPriority",
        "runIndicatorDOP",
        "timestampDOP",
        "updateTimeStamp",
        "updateType",
        "updateUser",
        "RegisteredResouce"
    )
    val mwDOP: Fielder = parse_element (element (cls, fields(0)))
    val plotPriority: Fielder = parse_element (element (cls, fields(1)))
    val runIndicatorDOP: Fielder = parse_attribute (attribute (cls, fields(2)))
    val timestampDOP: Fielder = parse_element (element (cls, fields(3)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(4)))
    val updateType: Fielder = parse_attribute (attribute (cls, fields(5)))
    val updateUser: Fielder = parse_element (element (cls, fields(6)))
    val RegisteredResouce: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): DopInstruction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DopInstruction (
            BasicElement.parse (context),
            toDouble (mask (mwDOP (), 0)),
            toInteger (mask (plotPriority (), 1)),
            mask (runIndicatorDOP (), 2),
            mask (timestampDOP (), 3),
            mask (updateTimeStamp (), 4),
            mask (updateType (), 5),
            mask (updateUser (), 6),
            mask (RegisteredResouce (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredResouce", "RegisteredResource", false)
    )
}

/**
 * Provides the necessary information (on a resource basis) to capture the Dispatch Operating Target (DOT) results on a Dispatch interval.
 *
 * This information is only relevant to the RT interval market.
 *
 * @param sup Reference to the superclass object.
 * @param actualRampRate Actual ramp rate.
 * @param compliantIndicator Flag indicating whether or not the resource was in compliance with the instruction (plus/minus 10%).
 *        Directs if a unit is allowed to set the price (ex-post pricing).
 * @param economicMaxOverride Economic Max Limit override for unit, this value is null, if it is not, this value overrides the Energy column value.
 *        Allows dispatcher to override the unit's energy value.
 * @param expectedEnergy Expected energy.
 * @param generatorPerformanceDegree The Degree of Generator Performance (DGP) used for the unit.
 *        Measure of how a generator responds to raise /lower signals.  Calculated every five minutes.
 * @param hourAheadSchedEnergy HASP results.
 * @param hourlySchedule Hourly Schedule (DA Energy Schedule).
 * @param instructionTime The date/time for the instruction.
 * @param maximumEmergencyInd True if maximum emergency limit activated; false otherwise.
 *        If unit is requested  to move up to its max emergency limit., this flag is set to true.
 * @param meterLoadFollowing Meter Sub System Load Following.
 * @param nonRampRestrictedMW Desired MW that is not ramp restricted.
 *        If no ramp rate limit existed for the unit, this is the MW value tha t the unit was requested to move to.
 * @param nonSpinReserve Non Spin Reserve used to procure energy.
 * @param previousDOTTimeStamp Timestamp when the previous DOT value was issued.
 * @param rampRateLimit The ramp rate limit for the unit in MWs per minute.
 *        Participant bidding data.
 * @param regulationStatus Regulation Status (Yes/No).
 * @param spinReserve Spin Reserve used to procure energy.
 * @param standardRampEnergy Standard ramping energy (MWH).
 * @param supplementalEnergy Supplemental Energy procure by Real Time Dispatch.
 * @param unitStatus Output results from the case identifying the reason the unit was committed by the software.
 * @param DOT Dispatch operating target value.
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class DotInstruction
(
    override val sup: BasicElement,
    actualRampRate: Double,
    compliantIndicator: String,
    economicMaxOverride: Double,
    expectedEnergy: Double,
    generatorPerformanceDegree: Double,
    hourAheadSchedEnergy: Double,
    hourlySchedule: Double,
    instructionTime: String,
    maximumEmergencyInd: Boolean,
    meterLoadFollowing: Double,
    nonRampRestrictedMW: Double,
    nonSpinReserve: Double,
    previousDOTTimeStamp: String,
    rampRateLimit: Double,
    regulationStatus: String,
    spinReserve: Double,
    standardRampEnergy: Double,
    supplementalEnergy: Double,
    unitStatus: Int,
    DOT: Double,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, false, 0.0, 0.0, 0.0, null, 0.0, null, 0.0, 0.0, 0.0, 0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DotInstruction] }
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
        implicit val clz: String = DotInstruction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DotInstruction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DotInstruction.fields (position), value)
        emitelem (0, actualRampRate)
        emitattr (1, compliantIndicator)
        emitelem (2, economicMaxOverride)
        emitelem (3, expectedEnergy)
        emitelem (4, generatorPerformanceDegree)
        emitelem (5, hourAheadSchedEnergy)
        emitelem (6, hourlySchedule)
        emitelem (7, instructionTime)
        emitelem (8, maximumEmergencyInd)
        emitelem (9, meterLoadFollowing)
        emitelem (10, nonRampRestrictedMW)
        emitelem (11, nonSpinReserve)
        emitelem (12, previousDOTTimeStamp)
        emitelem (13, rampRateLimit)
        emitattr (14, regulationStatus)
        emitelem (15, spinReserve)
        emitelem (16, standardRampEnergy)
        emitelem (17, supplementalEnergy)
        emitelem (18, unitStatus)
        emitelem (19, DOT)
        emitattr (20, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DotInstruction rdf:ID=\"%s\">\n%s\t</cim:DotInstruction>".format (id, export_fields)
    }
}

object DotInstruction
extends
    Parseable[DotInstruction]
{
    val fields: Array[String] = Array[String] (
        "actualRampRate",
        "compliantIndicator",
        "economicMaxOverride",
        "expectedEnergy",
        "generatorPerformanceDegree",
        "hourAheadSchedEnergy",
        "hourlySchedule",
        "instructionTime",
        "maximumEmergencyInd",
        "meterLoadFollowing",
        "nonRampRestrictedMW",
        "nonSpinReserve",
        "previousDOTTimeStamp",
        "rampRateLimit",
        "regulationStatus",
        "spinReserve",
        "standardRampEnergy",
        "supplementalEnergy",
        "unitStatus",
        "DOT",
        "RegisteredResource"
    )
    val actualRampRate: Fielder = parse_element (element (cls, fields(0)))
    val compliantIndicator: Fielder = parse_attribute (attribute (cls, fields(1)))
    val economicMaxOverride: Fielder = parse_element (element (cls, fields(2)))
    val expectedEnergy: Fielder = parse_element (element (cls, fields(3)))
    val generatorPerformanceDegree: Fielder = parse_element (element (cls, fields(4)))
    val hourAheadSchedEnergy: Fielder = parse_element (element (cls, fields(5)))
    val hourlySchedule: Fielder = parse_element (element (cls, fields(6)))
    val instructionTime: Fielder = parse_element (element (cls, fields(7)))
    val maximumEmergencyInd: Fielder = parse_element (element (cls, fields(8)))
    val meterLoadFollowing: Fielder = parse_element (element (cls, fields(9)))
    val nonRampRestrictedMW: Fielder = parse_element (element (cls, fields(10)))
    val nonSpinReserve: Fielder = parse_element (element (cls, fields(11)))
    val previousDOTTimeStamp: Fielder = parse_element (element (cls, fields(12)))
    val rampRateLimit: Fielder = parse_element (element (cls, fields(13)))
    val regulationStatus: Fielder = parse_attribute (attribute (cls, fields(14)))
    val spinReserve: Fielder = parse_element (element (cls, fields(15)))
    val standardRampEnergy: Fielder = parse_element (element (cls, fields(16)))
    val supplementalEnergy: Fielder = parse_element (element (cls, fields(17)))
    val unitStatus: Fielder = parse_element (element (cls, fields(18)))
    val DOT: Fielder = parse_element (element (cls, fields(19)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(20)))

    def parse (context: Context): DotInstruction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DotInstruction (
            BasicElement.parse (context),
            toDouble (mask (actualRampRate (), 0)),
            mask (compliantIndicator (), 1),
            toDouble (mask (economicMaxOverride (), 2)),
            toDouble (mask (expectedEnergy (), 3)),
            toDouble (mask (generatorPerformanceDegree (), 4)),
            toDouble (mask (hourAheadSchedEnergy (), 5)),
            toDouble (mask (hourlySchedule (), 6)),
            mask (instructionTime (), 7),
            toBoolean (mask (maximumEmergencyInd (), 8)),
            toDouble (mask (meterLoadFollowing (), 9)),
            toDouble (mask (nonRampRestrictedMW (), 10)),
            toDouble (mask (nonSpinReserve (), 11)),
            mask (previousDOTTimeStamp (), 12),
            toDouble (mask (rampRateLimit (), 13)),
            mask (regulationStatus (), 14),
            toDouble (mask (spinReserve (), 15)),
            toDouble (mask (standardRampEnergy (), 16)),
            toDouble (mask (supplementalEnergy (), 17)),
            toInteger (mask (unitStatus (), 18)),
            toDouble (mask (DOT (), 19)),
            mask (RegisteredResource (), 20)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", false)
    )
}

/**
 * Model of ex-post calcultion of MW losses.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ExPostLoss
(
    override val sup: MarketFactors
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[ExPostLoss] }
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
        "\t<cim:ExPostLoss rdf:ID=\"%s\">\n%s\t</cim:ExPostLoss>".format (id, export_fields)
    }
}

object ExPostLoss
extends
    Parseable[ExPostLoss]
{

    def parse (context: Context): ExPostLoss =
    {
        implicit val ctx: Context = context
        val ret = ExPostLoss (
            MarketFactors.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Model results of ex-post calculation of MW losses.
 *
 * Summarizes loss in two categories losses on the the extra high voltage transmission and total losses. Calculated for each subcontrol area.
 *
 * @param sup Reference to the superclass object.
 * @param ehvLossMW EHV MW losses in the company
 *        Attribute Usage: Information purposes - Output of LPA engine.
 * @param totalLossMW Total MW losses in the company
 *        Attribute Usage: Information purposes - Output of LPA engine.
 * @param ExPostLoss [[ch.ninecode.model.ExPostLoss ExPostLoss]] <em>undocumented</em>
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ExPostLossResults
(
    override val sup: BasicElement,
    ehvLossMW: Double,
    totalLossMW: Double,
    ExPostLoss: String,
    SubControlArea: String
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
    override def copy (): Row = { clone ().asInstanceOf[ExPostLossResults] }
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
        implicit val clz: String = ExPostLossResults.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExPostLossResults.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ExPostLossResults.fields (position), value)
        emitelem (0, ehvLossMW)
        emitelem (1, totalLossMW)
        emitattr (2, ExPostLoss)
        emitattr (3, SubControlArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExPostLossResults rdf:ID=\"%s\">\n%s\t</cim:ExPostLossResults>".format (id, export_fields)
    }
}

object ExPostLossResults
extends
    Parseable[ExPostLossResults]
{
    val fields: Array[String] = Array[String] (
        "ehvLossMW",
        "totalLossMW",
        "ExPostLoss",
        "SubControlArea"
    )
    val ehvLossMW: Fielder = parse_element (element (cls, fields(0)))
    val totalLossMW: Fielder = parse_element (element (cls, fields(1)))
    val ExPostLoss: Fielder = parse_attribute (attribute (cls, fields(2)))
    val SubControlArea: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): ExPostLossResults =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExPostLossResults (
            BasicElement.parse (context),
            toDouble (mask (ehvLossMW (), 0)),
            toDouble (mask (totalLossMW (), 1)),
            mask (ExPostLoss (), 2),
            mask (SubControlArea (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ExPostLoss", "ExPostLoss", false),
        Relationship ("SubControlArea", "SubControlArea", false)
    )
}

/**
 * Model of ex-post calculation of cleared MW on a regional basis
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param ExPostMarketRegionResults [[ch.ninecode.model.ExPostMarketRegionResults ExPostMarketRegionResults]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ExPostMarketRegion
(
    override val sup: MarketFactors,
    ExPostMarketRegionResults: String
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[ExPostMarketRegion] }
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
        implicit val clz: String = ExPostMarketRegion.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ExPostMarketRegion.fields (position), value)
        emitattr (0, ExPostMarketRegionResults)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExPostMarketRegion rdf:ID=\"%s\">\n%s\t</cim:ExPostMarketRegion>".format (id, export_fields)
    }
}

object ExPostMarketRegion
extends
    Parseable[ExPostMarketRegion]
{
    val fields: Array[String] = Array[String] (
        "ExPostMarketRegionResults"
    )
    val ExPostMarketRegionResults: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): ExPostMarketRegion =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExPostMarketRegion (
            MarketFactors.parse (context),
            mask (ExPostMarketRegionResults (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ExPostMarketRegionResults", "ExPostMarketRegionResults", false)
    )
}

/**
 * Model of expost calculation of cleared MW on a region basis.
 *
 * Includes cleared price
 *
 * @param sup Reference to the superclass object.
 * @param exPostClearedPrice <em>undocumented</em>
 * @param ExPostMarketRegion [[ch.ninecode.model.ExPostMarketRegion ExPostMarketRegion]] <em>undocumented</em>
 * @param MarketRegion [[ch.ninecode.model.MarketRegion MarketRegion]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ExPostMarketRegionResults
(
    override val sup: BasicElement,
    exPostClearedPrice: Double,
    ExPostMarketRegion: String,
    MarketRegion: String
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
    override def copy (): Row = { clone ().asInstanceOf[ExPostMarketRegionResults] }
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
        implicit val clz: String = ExPostMarketRegionResults.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExPostMarketRegionResults.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ExPostMarketRegionResults.fields (position), value)
        emitelem (0, exPostClearedPrice)
        emitattr (1, ExPostMarketRegion)
        emitattr (2, MarketRegion)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExPostMarketRegionResults rdf:ID=\"%s\">\n%s\t</cim:ExPostMarketRegionResults>".format (id, export_fields)
    }
}

object ExPostMarketRegionResults
extends
    Parseable[ExPostMarketRegionResults]
{
    val fields: Array[String] = Array[String] (
        "exPostClearedPrice",
        "ExPostMarketRegion",
        "MarketRegion"
    )
    val exPostClearedPrice: Fielder = parse_element (element (cls, fields(0)))
    val ExPostMarketRegion: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MarketRegion: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ExPostMarketRegionResults =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExPostMarketRegionResults (
            BasicElement.parse (context),
            toDouble (mask (exPostClearedPrice (), 0)),
            mask (ExPostMarketRegion (), 1),
            mask (MarketRegion (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ExPostMarketRegion", "ExPostMarketRegion", false),
        Relationship ("MarketRegion", "MarketRegion", false)
    )
}

/**
 * Model of ex-post pricing of nodes
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param energyPrice market energy price
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ExPostPricing
(
    override val sup: MarketFactors,
    energyPrice: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[ExPostPricing] }
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
        implicit val clz: String = ExPostPricing.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExPostPricing.fields (position), value)
        emitelem (0, energyPrice)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExPostPricing rdf:ID=\"%s\">\n%s\t</cim:ExPostPricing>".format (id, export_fields)
    }
}

object ExPostPricing
extends
    Parseable[ExPostPricing]
{
    val fields: Array[String] = Array[String] (
        "energyPrice"
    )
    val energyPrice: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): ExPostPricing =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExPostPricing (
            MarketFactors.parse (context),
            toDouble (mask (energyPrice (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Model of ex-post pricing of nodes.
 *
 * Includes LMP information, pnode based.
 *
 * @param sup Reference to the superclass object.
 * @param congestLMP Congestion component of Location Marginal Price (LMP) in monetary units per MW; congestion component of the hourly LMP at a specific pricing node
 *        Attribute Usage: Result of the Security, Pricing, and Dispatch(SPD)/Simultaneous Feasibility Test(SFT) software and denotes the hourly congestion component of LMP for each pricing node.
 * @param lmp 5 min weighted average LMP; the Location Marginal Price of the Pnode for which price calculation is carried out.
 *        Attribute Usage: 5 min weighted average LMP  to be displayed on UI
 * @param lossLMP Loss component of Location Marginal Price (LMP) in monetary units per MW; loss component of the hourly LMP at a specific pricing node
 *        Attribute Usage: Result of the Security, Pricing, and Dispatch(SPD)/Simultaneous Feasibility Test(SFT) software and denotes the hourly loss component of LMP for each pricing node.
 * @param ExPostPricing [[ch.ninecode.model.ExPostPricing ExPostPricing]] <em>undocumented</em>
 * @param Pnode [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ExPostPricingResults
(
    override val sup: BasicElement,
    congestLMP: Double,
    lmp: Double,
    lossLMP: Double,
    ExPostPricing: String,
    Pnode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ExPostPricingResults] }
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
        implicit val clz: String = ExPostPricingResults.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExPostPricingResults.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ExPostPricingResults.fields (position), value)
        emitelem (0, congestLMP)
        emitelem (1, lmp)
        emitelem (2, lossLMP)
        emitattr (3, ExPostPricing)
        emitattr (4, Pnode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExPostPricingResults rdf:ID=\"%s\">\n%s\t</cim:ExPostPricingResults>".format (id, export_fields)
    }
}

object ExPostPricingResults
extends
    Parseable[ExPostPricingResults]
{
    val fields: Array[String] = Array[String] (
        "congestLMP",
        "lmp",
        "lossLMP",
        "ExPostPricing",
        "Pnode"
    )
    val congestLMP: Fielder = parse_element (element (cls, fields(0)))
    val lmp: Fielder = parse_element (element (cls, fields(1)))
    val lossLMP: Fielder = parse_element (element (cls, fields(2)))
    val ExPostPricing: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Pnode: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): ExPostPricingResults =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExPostPricingResults (
            BasicElement.parse (context),
            toDouble (mask (congestLMP (), 0)),
            toDouble (mask (lmp (), 1)),
            toDouble (mask (lossLMP (), 2)),
            mask (ExPostPricing (), 3),
            mask (Pnode (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ExPostPricing", "ExPostPricing", false),
        Relationship ("Pnode", "Pnode", false)
    )
}

/**
 * Model of ex-post pricing of resources.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ExPostResource
(
    override val sup: MarketFactors
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[ExPostResource] }
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
        "\t<cim:ExPostResource rdf:ID=\"%s\">\n%s\t</cim:ExPostResource>".format (id, export_fields)
    }
}

object ExPostResource
extends
    Parseable[ExPostResource]
{

    def parse (context: Context): ExPostResource =
    {
        implicit val ctx: Context = context
        val ret = ExPostResource (
            MarketFactors.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Model of ex-post pricing of resources contains components of LMPs: energy, congestion, loss.
 *
 * Resource based.
 *
 * @param sup Reference to the superclass object.
 * @param congestionLMP LMP component in USD (deprecated)
 * @param desiredMW Desired output of unit
 * @param dispatchRate Unit Dispatch rate from real time unit dispatch.
 * @param lmp LMP (Local Marginal Price) in USD at the equipment (deprecated)
 * @param lossLMP loss lmp (deprecated)
 * @param maxEconomicMW Economic Maximum MW
 * @param minEconomicMW Economic Minimum MW
 * @param resourceMW Current MW output of the equipment
 *        Attribute Usage: Information purposes - Information purposes - Output of LPA engine.
 * @param status Status of equipment
 * @param ExPostResource [[ch.ninecode.model.ExPostResource ExPostResource]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ExPostResourceResults
(
    override val sup: BasicElement,
    congestionLMP: Double,
    desiredMW: Double,
    dispatchRate: Double,
    lmp: Double,
    lossLMP: Double,
    maxEconomicMW: Double,
    minEconomicMW: Double,
    resourceMW: Double,
    status: String,
    ExPostResource: String,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ExPostResourceResults] }
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
        implicit val clz: String = ExPostResourceResults.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExPostResourceResults.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ExPostResourceResults.fields (position), value)
        emitelem (0, congestionLMP)
        emitelem (1, desiredMW)
        emitelem (2, dispatchRate)
        emitelem (3, lmp)
        emitelem (4, lossLMP)
        emitelem (5, maxEconomicMW)
        emitelem (6, minEconomicMW)
        emitelem (7, resourceMW)
        emitattr (8, status)
        emitattr (9, ExPostResource)
        emitattr (10, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExPostResourceResults rdf:ID=\"%s\">\n%s\t</cim:ExPostResourceResults>".format (id, export_fields)
    }
}

object ExPostResourceResults
extends
    Parseable[ExPostResourceResults]
{
    val fields: Array[String] = Array[String] (
        "congestionLMP",
        "desiredMW",
        "dispatchRate",
        "lmp",
        "lossLMP",
        "maxEconomicMW",
        "minEconomicMW",
        "resourceMW",
        "status",
        "ExPostResource",
        "RegisteredResource"
    )
    val congestionLMP: Fielder = parse_element (element (cls, fields(0)))
    val desiredMW: Fielder = parse_element (element (cls, fields(1)))
    val dispatchRate: Fielder = parse_element (element (cls, fields(2)))
    val lmp: Fielder = parse_element (element (cls, fields(3)))
    val lossLMP: Fielder = parse_element (element (cls, fields(4)))
    val maxEconomicMW: Fielder = parse_element (element (cls, fields(5)))
    val minEconomicMW: Fielder = parse_element (element (cls, fields(6)))
    val resourceMW: Fielder = parse_element (element (cls, fields(7)))
    val status: Fielder = parse_attribute (attribute (cls, fields(8)))
    val ExPostResource: Fielder = parse_attribute (attribute (cls, fields(9)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: Context): ExPostResourceResults =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExPostResourceResults (
            BasicElement.parse (context),
            toDouble (mask (congestionLMP (), 0)),
            toDouble (mask (desiredMW (), 1)),
            toDouble (mask (dispatchRate (), 2)),
            toDouble (mask (lmp (), 3)),
            toDouble (mask (lossLMP (), 4)),
            toDouble (mask (maxEconomicMW (), 5)),
            toDouble (mask (minEconomicMW (), 6)),
            toDouble (mask (resourceMW (), 7)),
            mask (status (), 8),
            mask (ExPostResource (), 9),
            mask (RegisteredResource (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ExPostResource", "ExPostResource", false),
        Relationship ("RegisteredResource", "RegisteredResource", false)
    )
}

/**
 * Model of clearing result of the market run at the market level.
 *
 * Identifies interval
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class GeneralClearing
(
    override val sup: MarketFactors
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[GeneralClearing] }
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
        "\t<cim:GeneralClearing rdf:ID=\"%s\">\n%s\t</cim:GeneralClearing>".format (id, export_fields)
    }
}

object GeneralClearing
extends
    Parseable[GeneralClearing]
{

    def parse (context: Context): GeneralClearing =
    {
        implicit val ctx: Context = context
        val ret = GeneralClearing (
            MarketFactors.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Provides the adjusted load forecast value on a load forecast zone basis.
 *
 * @param sup Reference to the superclass object.
 * @param loadForecast Load Prediction/Forecast (MW), by Time Period (5', 10', 15')
 * @param totalLoad Amount of load in the control zone
 *        Attribute Usage: hourly load value for the specific area
 * @param totalNetInterchange Amount of interchange for the control zone
 *        Attribute Usage: hourly interchange value for the specific area
 * @param GeneralClearing [[ch.ninecode.model.GeneralClearing GeneralClearing]] <em>undocumented</em>
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class GeneralClearingResults
(
    override val sup: BasicElement,
    loadForecast: Double,
    totalLoad: Double,
    totalNetInterchange: Double,
    GeneralClearing: String,
    SubControlArea: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[GeneralClearingResults] }
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
        implicit val clz: String = GeneralClearingResults.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GeneralClearingResults.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GeneralClearingResults.fields (position), value)
        emitelem (0, loadForecast)
        emitelem (1, totalLoad)
        emitelem (2, totalNetInterchange)
        emitattr (3, GeneralClearing)
        emitattr (4, SubControlArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GeneralClearingResults rdf:ID=\"%s\">\n%s\t</cim:GeneralClearingResults>".format (id, export_fields)
    }
}

object GeneralClearingResults
extends
    Parseable[GeneralClearingResults]
{
    val fields: Array[String] = Array[String] (
        "loadForecast",
        "totalLoad",
        "totalNetInterchange",
        "GeneralClearing",
        "SubControlArea"
    )
    val loadForecast: Fielder = parse_element (element (cls, fields(0)))
    val totalLoad: Fielder = parse_element (element (cls, fields(1)))
    val totalNetInterchange: Fielder = parse_element (element (cls, fields(2)))
    val GeneralClearing: Fielder = parse_attribute (attribute (cls, fields(3)))
    val SubControlArea: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): GeneralClearingResults =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = GeneralClearingResults (
            BasicElement.parse (context),
            toDouble (mask (loadForecast (), 0)),
            toDouble (mask (totalLoad (), 1)),
            toDouble (mask (totalNetInterchange (), 2)),
            mask (GeneralClearing (), 3),
            mask (SubControlArea (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("GeneralClearing", "GeneralClearing", false),
        Relationship ("SubControlArea", "SubControlArea", false)
    )
}

/**
 * Model of market clearing, relating to commitment instructions.
 *
 * Identifies interval
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class InstructionClearing
(
    override val sup: MarketFactors
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[InstructionClearing] }
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
        "\t<cim:InstructionClearing rdf:ID=\"%s\">\n%s\t</cim:InstructionClearing>".format (id, export_fields)
    }
}

object InstructionClearing
extends
    Parseable[InstructionClearing]
{

    def parse (context: Context): InstructionClearing =
    {
        implicit val ctx: Context = context
        val ret = InstructionClearing (
            MarketFactors.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Model of market clearing, related to Dispatch Operating Point.
 *
 * Identifies interval
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class InstructionClearingDOP
(
    override val sup: MarketFactors
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[InstructionClearingDOP] }
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
        "\t<cim:InstructionClearingDOP rdf:ID=\"%s\">\n%s\t</cim:InstructionClearingDOP>".format (id, export_fields)
    }
}

object InstructionClearingDOP
extends
    Parseable[InstructionClearingDOP]
{

    def parse (context: Context): InstructionClearingDOP =
    {
        implicit val ctx: Context = context
        val ret = InstructionClearingDOP (
            MarketFactors.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Model of market clearing, related to Dispatch Operating Target (model of anticipatory dispatch).
 *
 * Identifies interval
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param contingencyActive Indication that the system is currently operating in a contingency mode.
 * @param dispatchMode <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class InstructionClearingDOT
(
    override val sup: MarketFactors,
    contingencyActive: String,
    dispatchMode: String
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
    override def copy (): Row = { clone ().asInstanceOf[InstructionClearingDOT] }
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
        implicit val clz: String = InstructionClearingDOT.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (InstructionClearingDOT.fields (position), value)
        emitattr (0, contingencyActive)
        emitattr (1, dispatchMode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InstructionClearingDOT rdf:ID=\"%s\">\n%s\t</cim:InstructionClearingDOT>".format (id, export_fields)
    }
}

object InstructionClearingDOT
extends
    Parseable[InstructionClearingDOT]
{
    val fields: Array[String] = Array[String] (
        "contingencyActive",
        "dispatchMode"
    )
    val contingencyActive: Fielder = parse_attribute (attribute (cls, fields(0)))
    val dispatchMode: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): InstructionClearingDOT =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = InstructionClearingDOT (
            MarketFactors.parse (context),
            mask (contingencyActive (), 0),
            mask (dispatchMode (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Provides the necessary information (on a resource basis) to capture the Startup/Shutdown instruction results.
 *
 * This information is relevant to the DA Market (RUC only) as well as the RT Market (HASP, Pre-dispatch, and Interval).
 *
 * @param sup Reference to the superclass object.
 * @param bindingDOT <em>undocumented</em>
 * @param bindingInstruction <em>undocumented</em>
 * @param instructionCost Total cost associated with changing the status of the resource.
 * @param instructionSource instruction source for market quality results (INS, ACT)
 * @param instructionStartTime Time the resource should be at Pmin (for start ups).
 *        Time the resource is off line.
 * @param instructionType Indicator of either a Start-Up or a Shut-Down.
 * @param manuallyBlocked Manually Blocked Indicator (Yes/No).
 *        The instruction has been blocked by an Operator.
 * @param minStatusChangeTime Minimum start up time required to bring the unit online (minutes).
 *        SCUC commitment period start-up time. Calculated start up time based on the StartUpTimeCurve provided with the Bid.
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class Instructions
(
    override val sup: BasicElement,
    bindingDOT: Double,
    bindingInstruction: String,
    instructionCost: Double,
    instructionSource: String,
    instructionStartTime: String,
    instructionType: String,
    manuallyBlocked: String,
    minStatusChangeTime: Int,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, 0.0, null, null, null, null, 0, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Instructions] }
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
        implicit val clz: String = Instructions.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Instructions.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Instructions.fields (position), value)
        emitelem (0, bindingDOT)
        emitattr (1, bindingInstruction)
        emitelem (2, instructionCost)
        emitattr (3, instructionSource)
        emitelem (4, instructionStartTime)
        emitattr (5, instructionType)
        emitattr (6, manuallyBlocked)
        emitelem (7, minStatusChangeTime)
        emitelem (8, updateTimeStamp)
        emitattr (9, updateType)
        emitelem (10, updateUser)
        emitattr (11, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Instructions rdf:ID=\"%s\">\n%s\t</cim:Instructions>".format (id, export_fields)
    }
}

object Instructions
extends
    Parseable[Instructions]
{
    val fields: Array[String] = Array[String] (
        "bindingDOT",
        "bindingInstruction",
        "instructionCost",
        "instructionSource",
        "instructionStartTime",
        "instructionType",
        "manuallyBlocked",
        "minStatusChangeTime",
        "updateTimeStamp",
        "updateType",
        "updateUser",
        "RegisteredResource"
    )
    val bindingDOT: Fielder = parse_element (element (cls, fields(0)))
    val bindingInstruction: Fielder = parse_attribute (attribute (cls, fields(1)))
    val instructionCost: Fielder = parse_element (element (cls, fields(2)))
    val instructionSource: Fielder = parse_attribute (attribute (cls, fields(3)))
    val instructionStartTime: Fielder = parse_element (element (cls, fields(4)))
    val instructionType: Fielder = parse_attribute (attribute (cls, fields(5)))
    val manuallyBlocked: Fielder = parse_attribute (attribute (cls, fields(6)))
    val minStatusChangeTime: Fielder = parse_element (element (cls, fields(7)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(8)))
    val updateType: Fielder = parse_attribute (attribute (cls, fields(9)))
    val updateUser: Fielder = parse_element (element (cls, fields(10)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(11)))

    def parse (context: Context): Instructions =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Instructions (
            BasicElement.parse (context),
            toDouble (mask (bindingDOT (), 0)),
            mask (bindingInstruction (), 1),
            toDouble (mask (instructionCost (), 2)),
            mask (instructionSource (), 3),
            mask (instructionStartTime (), 4),
            mask (instructionType (), 5),
            mask (manuallyBlocked (), 6),
            toInteger (mask (minStatusChangeTime (), 7)),
            mask (updateTimeStamp (), 8),
            mask (updateType (), 9),
            mask (updateUser (), 10),
            mask (RegisteredResource (), 11)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", false)
    )
}

/**
 * Model of load following capabilities that are entered by operators on a temporary basis.
 *
 * Related to Registered Resources in Metered Subsystems
 *
 * @param sup Reference to the superclass object.
 * @param dataEntryTimeStamp Time the data entry was performed
 * @param tempLoadFollowingDownManualCap temporarily manually entered LFD capacity
 * @param tempLoadFollowingUpManualCap temporarily manually entered LFU capacity.
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class LoadFollowingOperatorInput
(
    override val sup: BasicElement,
    dataEntryTimeStamp: String,
    tempLoadFollowingDownManualCap: Double,
    tempLoadFollowingUpManualCap: Double,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[LoadFollowingOperatorInput] }
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
        implicit val clz: String = LoadFollowingOperatorInput.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LoadFollowingOperatorInput.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LoadFollowingOperatorInput.fields (position), value)
        emitelem (0, dataEntryTimeStamp)
        emitelem (1, tempLoadFollowingDownManualCap)
        emitelem (2, tempLoadFollowingUpManualCap)
        emitelem (3, updateTimeStamp)
        emitattr (4, updateType)
        emitelem (5, updateUser)
        emitattr (6, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LoadFollowingOperatorInput rdf:ID=\"%s\">\n%s\t</cim:LoadFollowingOperatorInput>".format (id, export_fields)
    }
}

object LoadFollowingOperatorInput
extends
    Parseable[LoadFollowingOperatorInput]
{
    val fields: Array[String] = Array[String] (
        "dataEntryTimeStamp",
        "tempLoadFollowingDownManualCap",
        "tempLoadFollowingUpManualCap",
        "updateTimeStamp",
        "updateType",
        "updateUser",
        "RegisteredResource"
    )
    val dataEntryTimeStamp: Fielder = parse_element (element (cls, fields(0)))
    val tempLoadFollowingDownManualCap: Fielder = parse_element (element (cls, fields(1)))
    val tempLoadFollowingUpManualCap: Fielder = parse_element (element (cls, fields(2)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(3)))
    val updateType: Fielder = parse_attribute (attribute (cls, fields(4)))
    val updateUser: Fielder = parse_element (element (cls, fields(5)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): LoadFollowingOperatorInput =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LoadFollowingOperatorInput (
            BasicElement.parse (context),
            mask (dataEntryTimeStamp (), 0),
            toDouble (mask (tempLoadFollowingDownManualCap (), 1)),
            toDouble (mask (tempLoadFollowingUpManualCap (), 2)),
            mask (updateTimeStamp (), 3),
            mask (updateType (), 4),
            mask (updateUser (), 5),
            mask (RegisteredResource (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", false)
    )
}

/**
 * RT only and is published on 5 minute intervals for the previous RT time interval results.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class LossClearing
(
    override val sup: MarketFactors
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[LossClearing] }
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
        "\t<cim:LossClearing rdf:ID=\"%s\">\n%s\t</cim:LossClearing>".format (id, export_fields)
    }
}

object LossClearing
extends
    Parseable[LossClearing]
{

    def parse (context: Context): LossClearing =
    {
        implicit val ctx: Context = context
        val ret = LossClearing (
            MarketFactors.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Provides the MW loss for RUC Zones, subcontrol areas, and the total loss.
 *
 * @param sup Reference to the superclass object.
 * @param lossMW <em>undocumented</em>
 * @param HostControlArea [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param LossClearing [[ch.ninecode.model.LossClearing LossClearing]] <em>undocumented</em>
 * @param RUCZone [[ch.ninecode.model.RUCZone RUCZone]] <em>undocumented</em>
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class LossClearingResults
(
    override val sup: BasicElement,
    lossMW: Double,
    HostControlArea: String,
    LossClearing: String,
    RUCZone: String,
    SubControlArea: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[LossClearingResults] }
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
        implicit val clz: String = LossClearingResults.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LossClearingResults.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LossClearingResults.fields (position), value)
        emitelem (0, lossMW)
        emitattr (1, HostControlArea)
        emitattr (2, LossClearing)
        emitattr (3, RUCZone)
        emitattr (4, SubControlArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LossClearingResults rdf:ID=\"%s\">\n%s\t</cim:LossClearingResults>".format (id, export_fields)
    }
}

object LossClearingResults
extends
    Parseable[LossClearingResults]
{
    val fields: Array[String] = Array[String] (
        "lossMW",
        "HostControlArea",
        "LossClearing",
        "RUCZone",
        "SubControlArea"
    )
    val lossMW: Fielder = parse_element (element (cls, fields(0)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields(1)))
    val LossClearing: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RUCZone: Fielder = parse_attribute (attribute (cls, fields(3)))
    val SubControlArea: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): LossClearingResults =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LossClearingResults (
            BasicElement.parse (context),
            toDouble (mask (lossMW (), 0)),
            mask (HostControlArea (), 1),
            mask (LossClearing (), 2),
            mask (RUCZone (), 3),
            mask (SubControlArea (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("HostControlArea", "HostControlArea", false),
        Relationship ("LossClearing", "LossClearing", false),
        Relationship ("RUCZone", "RUCZone", false),
        Relationship ("SubControlArea", "SubControlArea", false)
    )
}

/**
 * Model of results of Market Power tests, and possible mitigation.
 *
 * Interval based
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param mitigationOccuredFlag <em>undocumented</em>
 * @param LMPMFinalFlag <em>undocumented</em>
 * @param SMPMFinalFlag <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class MPMClearing
(
    override val sup: MarketFactors,
    mitigationOccuredFlag: String,
    LMPMFinalFlag: String,
    SMPMFinalFlag: String
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
    override def copy (): Row = { clone ().asInstanceOf[MPMClearing] }
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
        implicit val clz: String = MPMClearing.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MPMClearing.fields (position), value)
        emitattr (0, mitigationOccuredFlag)
        emitattr (1, LMPMFinalFlag)
        emitattr (2, SMPMFinalFlag)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MPMClearing rdf:ID=\"%s\">\n%s\t</cim:MPMClearing>".format (id, export_fields)
    }
}

object MPMClearing
extends
    Parseable[MPMClearing]
{
    val fields: Array[String] = Array[String] (
        "mitigationOccuredFlag",
        "LMPMFinalFlag",
        "SMPMFinalFlag"
    )
    val mitigationOccuredFlag: Fielder = parse_attribute (attribute (cls, fields(0)))
    val LMPMFinalFlag: Fielder = parse_attribute (attribute (cls, fields(1)))
    val SMPMFinalFlag: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): MPMClearing =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MPMClearing (
            MarketFactors.parse (context),
            mask (mitigationOccuredFlag (), 0),
            mask (LMPMFinalFlag (), 1),
            mask (SMPMFinalFlag (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Model of results of Market Power tests, gives status of resource for the associated interval
 *
 * @param sup Reference to the superclass object.
 * @param resourceStatus Interval Test Status
 *        'N' - not applicable
 * @param MPMTestCategory [[ch.ninecode.model.MPMTestCategory MPMTestCategory]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class MPMResourceStatus
(
    override val sup: BasicElement,
    resourceStatus: String,
    MPMTestCategory: String,
    RegisteredResource: String
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MPMResourceStatus] }
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
        implicit val clz: String = MPMResourceStatus.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MPMResourceStatus.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MPMResourceStatus.fields (position), value)
        emitelem (0, resourceStatus)
        emitattr (1, MPMTestCategory)
        emitattr (2, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MPMResourceStatus rdf:ID=\"%s\">\n%s\t</cim:MPMResourceStatus>".format (id, export_fields)
    }
}

object MPMResourceStatus
extends
    Parseable[MPMResourceStatus]
{
    val fields: Array[String] = Array[String] (
        "resourceStatus",
        "MPMTestCategory",
        "RegisteredResource"
    )
    val resourceStatus: Fielder = parse_element (element (cls, fields(0)))
    val MPMTestCategory: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): MPMResourceStatus =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MPMResourceStatus (
            BasicElement.parse (context),
            mask (resourceStatus (), 0),
            mask (MPMTestCategory (), 1),
            mask (RegisteredResource (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MPMTestCategory", "MPMTestCategory", false),
        Relationship ("RegisteredResource", "RegisteredResource", false)
    )
}

/**
 * Provides the outcome and margin percent (as appropriate) result data for the MPM tests.
 *
 * There are relationships to Zone for Designated Congestion Area Tests, CurveSchedData for bid segment tests, to the SubControlArea for the system wide level tests, and Pnodes for the LMPM impact tests.
 *
 * @param sup Reference to the superclass object.
 * @param marginPercent Used to show the Margin % result of the Impact test
 * @param outcome The results of the test.
 *        For the Price, Impact, and Conduct tests, typical values are NA, Pass, Fail, Disable, or Skip.
 * @param AggregatedPnode [[ch.ninecode.model.AggregatedPnode AggregatedPnode]] <em>undocumented</em>
 * @param MPMClearing [[ch.ninecode.model.MPMClearing MPMClearing]] <em>undocumented</em>
 * @param MPMTestCategory [[ch.ninecode.model.MPMTestCategory MPMTestCategory]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class MPMTestResults
(
    override val sup: BasicElement,
    marginPercent: Double,
    outcome: String,
    AggregatedPnode: String,
    MPMClearing: String,
    MPMTestCategory: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MPMTestResults] }
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
        implicit val clz: String = MPMTestResults.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MPMTestResults.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MPMTestResults.fields (position), value)
        emitelem (0, marginPercent)
        emitattr (1, outcome)
        emitattr (2, AggregatedPnode)
        emitattr (3, MPMClearing)
        emitattr (4, MPMTestCategory)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MPMTestResults rdf:ID=\"%s\">\n%s\t</cim:MPMTestResults>".format (id, export_fields)
    }
}

object MPMTestResults
extends
    Parseable[MPMTestResults]
{
    val fields: Array[String] = Array[String] (
        "marginPercent",
        "outcome",
        "AggregatedPnode",
        "MPMClearing",
        "MPMTestCategory"
    )
    val marginPercent: Fielder = parse_element (element (cls, fields(0)))
    val outcome: Fielder = parse_attribute (attribute (cls, fields(1)))
    val AggregatedPnode: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MPMClearing: Fielder = parse_attribute (attribute (cls, fields(3)))
    val MPMTestCategory: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): MPMTestResults =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MPMTestResults (
            BasicElement.parse (context),
            toDouble (mask (marginPercent (), 0)),
            mask (outcome (), 1),
            mask (AggregatedPnode (), 2),
            mask (MPMClearing (), 3),
            mask (MPMTestCategory (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AggregatedPnode", "AggregatedPnode", false),
        Relationship ("MPMClearing", "MPMClearing", false),
        Relationship ("MPMTestCategory", "MPMTestCategory", false)
    )
}

/**
 * Provides all Region Ancillary Service results for the DA and RT markets.
 *
 * The specific data is commodity type (Regulation Up, Regulation Down, Spinning Reserve, Non-spinning Reserve, or Total Up reserves) based for the cleared MW, cleared price, and total capacity required for the region.
 *
 * @param sup Reference to the superclass object.
 * @param clearedMW Cleared generation Value in MW.
 *        For AS, this value is clearedMW = AS Total.  For AS, clearedMW - selfScheduleMW = AS Procured
 * @param clearedPrice Marginal Price (\$/MW) for the commodity (Energy, Regulation Up, Regulation Down, Spinning Reserve, or Non-spinning reserve) based on the pricing run.
 * @param dispatchCtMW Dispatchable MW for Combustion units.
 * @param dispatchHydroMW Dispatchable MW for Hydro units.
 * @param dispatchRate Dispatch rate in MW/minutes.
 * @param dispatchSteamMW Dispatchable MW for Steam units.
 * @param imbalanceEnergyBias Imbalance Energy Bias (MW) by Time Period (5' only)
 * @param limitFlag Locational AS Flags indicating whether the Upper or Lower Bound limit of the AS regional procurment is binding
 * @param lumpyIndicator The "Lumpy Flag"(Y/N)  indicates whether the resource that sets the price is a lumpy generator by hour over the time horizon.
 *        Only applicable for the Day Ahead Market
 * @param maxSufficiencyIndex Region requirement maximum limit
 * @param minSufficiencyIndex Region requirement minimum limit
 * @param reqMaxMW Region requirement maximum limit
 * @param reqMinMW Region requirement minimum limit
 * @param selfScheduleMW Aof AS, selfScheduleMW = AS Self-Provided
 * @param AncillaryServiceClearing [[ch.ninecode.model.AncillaryServiceClearing AncillaryServiceClearing]] <em>undocumented</em>
 * @param MarketProduct [[ch.ninecode.model.MarketProduct MarketProduct]] <em>undocumented</em>
 * @param MarketRegion [[ch.ninecode.model.MarketRegion MarketRegion]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class MarketRegionResults
(
    override val sup: BasicElement,
    clearedMW: Double,
    clearedPrice: Double,
    dispatchCtMW: Double,
    dispatchHydroMW: Double,
    dispatchRate: Double,
    dispatchSteamMW: Double,
    imbalanceEnergyBias: Double,
    limitFlag: String,
    lumpyIndicator: String,
    maxSufficiencyIndex: Double,
    minSufficiencyIndex: Double,
    reqMaxMW: Double,
    reqMinMW: Double,
    selfScheduleMW: Double,
    AncillaryServiceClearing: String,
    MarketProduct: String,
    MarketRegion: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketRegionResults] }
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
        implicit val clz: String = MarketRegionResults.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketRegionResults.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketRegionResults.fields (position), value)
        emitelem (0, clearedMW)
        emitelem (1, clearedPrice)
        emitelem (2, dispatchCtMW)
        emitelem (3, dispatchHydroMW)
        emitelem (4, dispatchRate)
        emitelem (5, dispatchSteamMW)
        emitelem (6, imbalanceEnergyBias)
        emitattr (7, limitFlag)
        emitattr (8, lumpyIndicator)
        emitelem (9, maxSufficiencyIndex)
        emitelem (10, minSufficiencyIndex)
        emitelem (11, reqMaxMW)
        emitelem (12, reqMinMW)
        emitelem (13, selfScheduleMW)
        emitattr (14, AncillaryServiceClearing)
        emitattr (15, MarketProduct)
        emitattr (16, MarketRegion)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketRegionResults rdf:ID=\"%s\">\n%s\t</cim:MarketRegionResults>".format (id, export_fields)
    }
}

object MarketRegionResults
extends
    Parseable[MarketRegionResults]
{
    val fields: Array[String] = Array[String] (
        "clearedMW",
        "clearedPrice",
        "dispatchCtMW",
        "dispatchHydroMW",
        "dispatchRate",
        "dispatchSteamMW",
        "imbalanceEnergyBias",
        "limitFlag",
        "lumpyIndicator",
        "maxSufficiencyIndex",
        "minSufficiencyIndex",
        "reqMaxMW",
        "reqMinMW",
        "selfScheduleMW",
        "AncillaryServiceClearing",
        "MarketProduct",
        "MarketRegion"
    )
    val clearedMW: Fielder = parse_element (element (cls, fields(0)))
    val clearedPrice: Fielder = parse_element (element (cls, fields(1)))
    val dispatchCtMW: Fielder = parse_element (element (cls, fields(2)))
    val dispatchHydroMW: Fielder = parse_element (element (cls, fields(3)))
    val dispatchRate: Fielder = parse_element (element (cls, fields(4)))
    val dispatchSteamMW: Fielder = parse_element (element (cls, fields(5)))
    val imbalanceEnergyBias: Fielder = parse_element (element (cls, fields(6)))
    val limitFlag: Fielder = parse_attribute (attribute (cls, fields(7)))
    val lumpyIndicator: Fielder = parse_attribute (attribute (cls, fields(8)))
    val maxSufficiencyIndex: Fielder = parse_element (element (cls, fields(9)))
    val minSufficiencyIndex: Fielder = parse_element (element (cls, fields(10)))
    val reqMaxMW: Fielder = parse_element (element (cls, fields(11)))
    val reqMinMW: Fielder = parse_element (element (cls, fields(12)))
    val selfScheduleMW: Fielder = parse_element (element (cls, fields(13)))
    val AncillaryServiceClearing: Fielder = parse_attribute (attribute (cls, fields(14)))
    val MarketProduct: Fielder = parse_attribute (attribute (cls, fields(15)))
    val MarketRegion: Fielder = parse_attribute (attribute (cls, fields(16)))

    def parse (context: Context): MarketRegionResults =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketRegionResults (
            BasicElement.parse (context),
            toDouble (mask (clearedMW (), 0)),
            toDouble (mask (clearedPrice (), 1)),
            toDouble (mask (dispatchCtMW (), 2)),
            toDouble (mask (dispatchHydroMW (), 3)),
            toDouble (mask (dispatchRate (), 4)),
            toDouble (mask (dispatchSteamMW (), 5)),
            toDouble (mask (imbalanceEnergyBias (), 6)),
            mask (limitFlag (), 7),
            mask (lumpyIndicator (), 8),
            toDouble (mask (maxSufficiencyIndex (), 9)),
            toDouble (mask (minSufficiencyIndex (), 10)),
            toDouble (mask (reqMaxMW (), 11)),
            toDouble (mask (reqMinMW (), 12)),
            toDouble (mask (selfScheduleMW (), 13)),
            mask (AncillaryServiceClearing (), 14),
            mask (MarketProduct (), 15),
            mask (MarketRegion (), 16)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AncillaryServiceClearing", "AncillaryServiceClearing", false),
        Relationship ("MarketProduct", "MarketProduct", false),
        Relationship ("MarketRegion", "MarketRegion", false)
    )
}

/**
 * This class holds elements that are single values for the entire market time horizon.
 *
 * That is, for the Day Ahead market, there is 1 value for each element, not hourly based.  Is a summary of the market run
 *
 * @param sup Reference to the superclass object.
 * @param ancillarySvcCost Total  AS Cost (i.e., payment) (\$) over the time horizon
 * @param contingentOperatingResAvail Global Contingent Operating Reserve Availability Indicator (Yes/No)
 * @param energyCost Total Energy Cost (\$) over the time horizon
 * @param minimumLoadCost Total Minimum Load Cost (\$) over the time horizon
 * @param startUpCost Total Start-up Cost (\$) over the time horizon
 * @param totalCost Total Cost (Energy + AS) cost (\$) by over the time horizon
 * @param totalRucCost The total RUC capacity cost for this interval
 * @param EnergyMarket [[ch.ninecode.model.EnergyMarket EnergyMarket]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class MarketResults
(
    override val sup: BasicElement,
    ancillarySvcCost: Double,
    contingentOperatingResAvail: String,
    energyCost: Double,
    minimumLoadCost: Double,
    startUpCost: Double,
    totalCost: Double,
    totalRucCost: Double,
    EnergyMarket: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketResults] }
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
        implicit val clz: String = MarketResults.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketResults.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketResults.fields (position), value)
        emitelem (0, ancillarySvcCost)
        emitattr (1, contingentOperatingResAvail)
        emitelem (2, energyCost)
        emitelem (3, minimumLoadCost)
        emitelem (4, startUpCost)
        emitelem (5, totalCost)
        emitelem (6, totalRucCost)
        emitattr (7, EnergyMarket)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketResults rdf:ID=\"%s\">\n%s\t</cim:MarketResults>".format (id, export_fields)
    }
}

object MarketResults
extends
    Parseable[MarketResults]
{
    val fields: Array[String] = Array[String] (
        "ancillarySvcCost",
        "contingentOperatingResAvail",
        "energyCost",
        "minimumLoadCost",
        "startUpCost",
        "totalCost",
        "totalRucCost",
        "EnergyMarket"
    )
    val ancillarySvcCost: Fielder = parse_element (element (cls, fields(0)))
    val contingentOperatingResAvail: Fielder = parse_attribute (attribute (cls, fields(1)))
    val energyCost: Fielder = parse_element (element (cls, fields(2)))
    val minimumLoadCost: Fielder = parse_element (element (cls, fields(3)))
    val startUpCost: Fielder = parse_element (element (cls, fields(4)))
    val totalCost: Fielder = parse_element (element (cls, fields(5)))
    val totalRucCost: Fielder = parse_element (element (cls, fields(6)))
    val EnergyMarket: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): MarketResults =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketResults (
            BasicElement.parse (context),
            toDouble (mask (ancillarySvcCost (), 0)),
            mask (contingentOperatingResAvail (), 1),
            toDouble (mask (energyCost (), 2)),
            toDouble (mask (minimumLoadCost (), 3)),
            toDouble (mask (startUpCost (), 4)),
            toDouble (mask (totalCost (), 5)),
            toDouble (mask (totalRucCost (), 6)),
            mask (EnergyMarket (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("EnergyMarket", "EnergyMarket", false)
    )
}

/**
 * A statement is a roll up of statement line items.
 *
 * Each statement along with its line items provide the details of specific charges at any given time.  Used by Billing and Settlement
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param end The end of a bill period.
 * @param referenceNumber The version number of previous statement (in the case of true up).
 * @param start The start of a bill period.
 * @param tradeDate The date of which Settlement is run.
 * @param transactionDate The date of which this statement is issued.
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class MarketStatement
(
    override val sup: Document,
    end: String,
    referenceNumber: String,
    start: String,
    tradeDate: String,
    transactionDate: String
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[MarketStatement] }
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
        implicit val clz: String = MarketStatement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketStatement.fields (position), value)
        emitelem (0, end)
        emitelem (1, referenceNumber)
        emitelem (2, start)
        emitelem (3, tradeDate)
        emitelem (4, transactionDate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketStatement rdf:ID=\"%s\">\n%s\t</cim:MarketStatement>".format (id, export_fields)
    }
}

object MarketStatement
extends
    Parseable[MarketStatement]
{
    val fields: Array[String] = Array[String] (
        "end",
        "referenceNumber",
        "start",
        "tradeDate",
        "transactionDate"
    )
    val end: Fielder = parse_element (element (cls, fields(0)))
    val referenceNumber: Fielder = parse_element (element (cls, fields(1)))
    val start: Fielder = parse_element (element (cls, fields(2)))
    val tradeDate: Fielder = parse_element (element (cls, fields(3)))
    val transactionDate: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: Context): MarketStatement =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketStatement (
            Document.parse (context),
            mask (end (), 0),
            mask (referenceNumber (), 1),
            mask (start (), 2),
            mask (tradeDate (), 3),
            mask (transactionDate (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * An individual line item on a statement.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param currentAmount Current settlement amount.
 * @param currentISOAmount Current ISO settlement amount.
 * @param currentISOQuantity Current ISO settlement quantity.
 * @param currentPrice Current settlement price.
 * @param currentQuantity Current settlement quantity, subject to the UOM.
 * @param intervalDate The date of which the settlement is run.
 * @param intervalNumber The number of intervals.
 * @param netAmount Net settlement amount.
 * @param netISOAmount Net ISO settlement amount.
 * @param netISOQuantity Net ISO settlement quantity.
 * @param netPrice Net settlement price.
 * @param netQuantity Net settlement quantity, subject to the UOM.
 * @param previousAmount Previous settlement amount.
 * @param previousISOAmount Previous ISO settlement amount.
 * @param previousISOQuantity Previous ISO settlement quantity.
 * @param previousQuantity Previous settlement quantity, subject to the UOM.
 * @param previsouPrice Previous settlement price.
 * @param quantityUOM The unit of measure for the quantity element of the line item.
 * @param ContainerMarketStatementLineItem [[ch.ninecode.model.MarketStatementLineItem MarketStatementLineItem]] <em>undocumented</em>
 * @param MarketStatement [[ch.ninecode.model.MarketStatement MarketStatement]] <em>undocumented</em>
 * @param MktUserAttribute [[ch.ninecode.model.MktUserAttribute MktUserAttribute]] <em>undocumented</em>
 * @param PassThroughBill [[ch.ninecode.model.PassThroughBill PassThroughBill]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class MarketStatementLineItem
(
    override val sup: IdentifiedObject,
    currentAmount: Double,
    currentISOAmount: Double,
    currentISOQuantity: Double,
    currentPrice: Double,
    currentQuantity: Double,
    intervalDate: String,
    intervalNumber: String,
    netAmount: Double,
    netISOAmount: Double,
    netISOQuantity: Double,
    netPrice: Double,
    netQuantity: Double,
    previousAmount: Double,
    previousISOAmount: Double,
    previousISOQuantity: Double,
    previousQuantity: Double,
    previsouPrice: Double,
    quantityUOM: String,
    ContainerMarketStatementLineItem: String,
    MarketStatement: String,
    MktUserAttribute: List[String],
    PassThroughBill: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MarketStatementLineItem] }
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
        implicit val clz: String = MarketStatementLineItem.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketStatementLineItem.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketStatementLineItem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MarketStatementLineItem.fields (position), x))
        emitelem (0, currentAmount)
        emitelem (1, currentISOAmount)
        emitelem (2, currentISOQuantity)
        emitelem (3, currentPrice)
        emitelem (4, currentQuantity)
        emitelem (5, intervalDate)
        emitelem (6, intervalNumber)
        emitelem (7, netAmount)
        emitelem (8, netISOAmount)
        emitelem (9, netISOQuantity)
        emitelem (10, netPrice)
        emitelem (11, netQuantity)
        emitelem (12, previousAmount)
        emitelem (13, previousISOAmount)
        emitelem (14, previousISOQuantity)
        emitelem (15, previousQuantity)
        emitelem (16, previsouPrice)
        emitelem (17, quantityUOM)
        emitattr (18, ContainerMarketStatementLineItem)
        emitattr (19, MarketStatement)
        emitattrs (20, MktUserAttribute)
        emitattr (21, PassThroughBill)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketStatementLineItem rdf:ID=\"%s\">\n%s\t</cim:MarketStatementLineItem>".format (id, export_fields)
    }
}

object MarketStatementLineItem
extends
    Parseable[MarketStatementLineItem]
{
    val fields: Array[String] = Array[String] (
        "currentAmount",
        "currentISOAmount",
        "currentISOQuantity",
        "currentPrice",
        "currentQuantity",
        "intervalDate",
        "intervalNumber",
        "netAmount",
        "netISOAmount",
        "netISOQuantity",
        "netPrice",
        "netQuantity",
        "previousAmount",
        "previousISOAmount",
        "previousISOQuantity",
        "previousQuantity",
        "previsouPrice",
        "quantityUOM",
        "ContainerMarketStatementLineItem",
        "MarketStatement",
        "MktUserAttribute",
        "PassThroughBill"
    )
    val currentAmount: Fielder = parse_element (element (cls, fields(0)))
    val currentISOAmount: Fielder = parse_element (element (cls, fields(1)))
    val currentISOQuantity: Fielder = parse_element (element (cls, fields(2)))
    val currentPrice: Fielder = parse_element (element (cls, fields(3)))
    val currentQuantity: Fielder = parse_element (element (cls, fields(4)))
    val intervalDate: Fielder = parse_element (element (cls, fields(5)))
    val intervalNumber: Fielder = parse_element (element (cls, fields(6)))
    val netAmount: Fielder = parse_element (element (cls, fields(7)))
    val netISOAmount: Fielder = parse_element (element (cls, fields(8)))
    val netISOQuantity: Fielder = parse_element (element (cls, fields(9)))
    val netPrice: Fielder = parse_element (element (cls, fields(10)))
    val netQuantity: Fielder = parse_element (element (cls, fields(11)))
    val previousAmount: Fielder = parse_element (element (cls, fields(12)))
    val previousISOAmount: Fielder = parse_element (element (cls, fields(13)))
    val previousISOQuantity: Fielder = parse_element (element (cls, fields(14)))
    val previousQuantity: Fielder = parse_element (element (cls, fields(15)))
    val previsouPrice: Fielder = parse_element (element (cls, fields(16)))
    val quantityUOM: Fielder = parse_element (element (cls, fields(17)))
    val ContainerMarketStatementLineItem: Fielder = parse_attribute (attribute (cls, fields(18)))
    val MarketStatement: Fielder = parse_attribute (attribute (cls, fields(19)))
    val MktUserAttribute: FielderMultiple = parse_attributes (attribute (cls, fields(20)))
    val PassThroughBill: Fielder = parse_attribute (attribute (cls, fields(21)))

    def parse (context: Context): MarketStatementLineItem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketStatementLineItem (
            IdentifiedObject.parse (context),
            toDouble (mask (currentAmount (), 0)),
            toDouble (mask (currentISOAmount (), 1)),
            toDouble (mask (currentISOQuantity (), 2)),
            toDouble (mask (currentPrice (), 3)),
            toDouble (mask (currentQuantity (), 4)),
            mask (intervalDate (), 5),
            mask (intervalNumber (), 6),
            toDouble (mask (netAmount (), 7)),
            toDouble (mask (netISOAmount (), 8)),
            toDouble (mask (netISOQuantity (), 9)),
            toDouble (mask (netPrice (), 10)),
            toDouble (mask (netQuantity (), 11)),
            toDouble (mask (previousAmount (), 12)),
            toDouble (mask (previousISOAmount (), 13)),
            toDouble (mask (previousISOQuantity (), 14)),
            toDouble (mask (previousQuantity (), 15)),
            toDouble (mask (previsouPrice (), 16)),
            mask (quantityUOM (), 17),
            mask (ContainerMarketStatementLineItem (), 18),
            mask (MarketStatement (), 19),
            masks (MktUserAttribute (), 20),
            mask (PassThroughBill (), 21)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ContainerMarketStatementLineItem", "MarketStatementLineItem", false),
        Relationship ("MarketStatement", "MarketStatement", false),
        Relationship ("MktUserAttribute", "MktUserAttribute", true),
        Relationship ("PassThroughBill", "PassThroughBill", false)
    )
}

/**
 * Mitigated bid results posted for a given settlement period.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Bid [[ch.ninecode.model.Bid Bid]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class MitigatedBid
(
    override val sup: IdentifiedObject,
    Bid: String
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MitigatedBid] }
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
        implicit val clz: String = MitigatedBid.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MitigatedBid.fields (position), value)
        emitattr (0, Bid)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MitigatedBid rdf:ID=\"%s\">\n%s\t</cim:MitigatedBid>".format (id, export_fields)
    }
}

object MitigatedBid
extends
    Parseable[MitigatedBid]
{
    val fields: Array[String] = Array[String] (
        "Bid"
    )
    val Bid: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): MitigatedBid =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MitigatedBid (
            IdentifiedObject.parse (context),
            mask (Bid (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Bid", "Bid", false)
    )
}

/**
 * Model of market power mitigation through reference or mitigated bids.
 *
 * Interval based.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class MitigatedBidClearing
(
    override val sup: MarketFactors
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[MitigatedBidClearing] }
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
        "\t<cim:MitigatedBidClearing rdf:ID=\"%s\">\n%s\t</cim:MitigatedBidClearing>".format (id, export_fields)
    }
}

object MitigatedBidClearing
extends
    Parseable[MitigatedBidClearing]
{

    def parse (context: Context): MitigatedBidClearing =
    {
        implicit val ctx: Context = context
        val ret = MitigatedBidClearing (
            MarketFactors.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Model of mitigated bid.
 *
 * Indicates segment of piece-wise linear bid, that has been mitigated
 *
 * @param sup Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param segmentMW Mitigated bid segment MW value
 * @param segmentNumber Mitigated Bid Segment Number
 * @param thresholdType <em>undocumented</em>
 * @param Bid [[ch.ninecode.model.Bid Bid]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class MitigatedBidSegment
(
    override val sup: BasicElement,
    intervalStartTime: String,
    segmentMW: Double,
    segmentNumber: Int,
    thresholdType: String,
    Bid: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MitigatedBidSegment] }
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
        implicit val clz: String = MitigatedBidSegment.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MitigatedBidSegment.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MitigatedBidSegment.fields (position), value)
        emitelem (0, intervalStartTime)
        emitelem (1, segmentMW)
        emitelem (2, segmentNumber)
        emitelem (3, thresholdType)
        emitattr (4, Bid)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MitigatedBidSegment rdf:ID=\"%s\">\n%s\t</cim:MitigatedBidSegment>".format (id, export_fields)
    }
}

object MitigatedBidSegment
extends
    Parseable[MitigatedBidSegment]
{
    val fields: Array[String] = Array[String] (
        "intervalStartTime",
        "segmentMW",
        "segmentNumber",
        "thresholdType",
        "Bid"
    )
    val intervalStartTime: Fielder = parse_element (element (cls, fields(0)))
    val segmentMW: Fielder = parse_element (element (cls, fields(1)))
    val segmentNumber: Fielder = parse_element (element (cls, fields(2)))
    val thresholdType: Fielder = parse_element (element (cls, fields(3)))
    val Bid: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): MitigatedBidSegment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MitigatedBidSegment (
            BasicElement.parse (context),
            mask (intervalStartTime (), 0),
            toDouble (mask (segmentMW (), 1)),
            toInteger (mask (segmentNumber (), 2)),
            mask (thresholdType (), 3),
            mask (Bid (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Bid", "Bid", false)
    )
}

/**
 * Pass Through Bill is used for:
 * 1)Two sided charge transactions with or without ISO involvement (hence the ?pass thru?)
 * 2) Specific direct charges or payments that are calculated outside or provided directly to settlements
 *
 * 3) Specific charge bill determinants that are externally supplied and used in charge calculations
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param adjustedAmount <em>undocumented</em>
 * @param amount The charge amount of the product/service.
 * @param billEnd Bill period end date
 * @param billRunType The settlement run type, for example: prelim, final, and rerun.
 * @param billStart Bill period start date
 * @param billedTo The company to which the PTB transaction is billed.
 * @param effectiveDate The effective date of the transaction
 * @param isDisputed Disputed transaction indicator
 * @param isProfiled A flag indicating whether there is a profile data associated with the PTB.
 * @param paidTo The company to which the PTB transaction is paid.
 * @param previousEnd The previous bill period end date
 * @param previousStart The previous bill period start date
 * @param price The price of product/service.
 * @param productCode The product identifier for determining the charge type of the transaction.
 * @param providedBy The company by which the PTB transaction service is provided.
 * @param quantity The product quantity.
 * @param serviceEnd The end date of service provided, if periodic.
 * @param serviceStart The start date of service provided, if periodic.
 * @param soldTo The company to which the PTB transaction is sold.
 * @param taxAmount The tax on services taken.
 * @param timeZone The time zone code
 * @param tradeDate The trade date
 * @param transactionDate The date the transaction occurs.
 * @param transactionType The type of transaction.
 *        For example, charge customer, bill customer, matching AR/AP, or bill determinant
 * @param MarketStatementLineItem [[ch.ninecode.model.MarketStatementLineItem MarketStatementLineItem]] <em>undocumented</em>
 * @param MktUserAttribute [[ch.ninecode.model.MktUserAttribute MktUserAttribute]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class PassThroughBill
(
    override val sup: Document,
    adjustedAmount: Double,
    amount: Double,
    billEnd: String,
    billRunType: String,
    billStart: String,
    billedTo: String,
    effectiveDate: String,
    isDisputed: Boolean,
    isProfiled: Boolean,
    paidTo: String,
    previousEnd: String,
    previousStart: String,
    price: Double,
    productCode: String,
    providedBy: String,
    quantity: String,
    serviceEnd: String,
    serviceStart: String,
    soldTo: String,
    taxAmount: Double,
    timeZone: String,
    tradeDate: String,
    transactionDate: String,
    transactionType: String,
    MarketStatementLineItem: String,
    MktUserAttribute: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, null, null, null, null, false, false, null, null, null, 0.0, null, null, null, null, null, null, 0.0, null, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[PassThroughBill] }
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
        implicit val clz: String = PassThroughBill.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PassThroughBill.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PassThroughBill.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (PassThroughBill.fields (position), x))
        emitelem (0, adjustedAmount)
        emitelem (1, amount)
        emitelem (2, billEnd)
        emitelem (3, billRunType)
        emitelem (4, billStart)
        emitelem (5, billedTo)
        emitelem (6, effectiveDate)
        emitelem (7, isDisputed)
        emitelem (8, isProfiled)
        emitelem (9, paidTo)
        emitelem (10, previousEnd)
        emitelem (11, previousStart)
        emitelem (12, price)
        emitelem (13, productCode)
        emitelem (14, providedBy)
        emitattr (15, quantity)
        emitelem (16, serviceEnd)
        emitelem (17, serviceStart)
        emitelem (18, soldTo)
        emitelem (19, taxAmount)
        emitelem (20, timeZone)
        emitelem (21, tradeDate)
        emitelem (22, transactionDate)
        emitelem (23, transactionType)
        emitattr (24, MarketStatementLineItem)
        emitattrs (25, MktUserAttribute)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PassThroughBill rdf:ID=\"%s\">\n%s\t</cim:PassThroughBill>".format (id, export_fields)
    }
}

object PassThroughBill
extends
    Parseable[PassThroughBill]
{
    val fields: Array[String] = Array[String] (
        "adjustedAmount",
        "amount",
        "billEnd",
        "billRunType",
        "billStart",
        "billedTo",
        "effectiveDate",
        "isDisputed",
        "isProfiled",
        "paidTo",
        "previousEnd",
        "previousStart",
        "price",
        "productCode",
        "providedBy",
        "quantity",
        "serviceEnd",
        "serviceStart",
        "soldTo",
        "taxAmount",
        "timeZone",
        "tradeDate",
        "transactionDate",
        "transactionType",
        "MarketStatementLineItem",
        "MktUserAttribute"
    )
    val adjustedAmount: Fielder = parse_element (element (cls, fields(0)))
    val amount: Fielder = parse_element (element (cls, fields(1)))
    val billEnd: Fielder = parse_element (element (cls, fields(2)))
    val billRunType: Fielder = parse_element (element (cls, fields(3)))
    val billStart: Fielder = parse_element (element (cls, fields(4)))
    val billedTo: Fielder = parse_element (element (cls, fields(5)))
    val effectiveDate: Fielder = parse_element (element (cls, fields(6)))
    val isDisputed: Fielder = parse_element (element (cls, fields(7)))
    val isProfiled: Fielder = parse_element (element (cls, fields(8)))
    val paidTo: Fielder = parse_element (element (cls, fields(9)))
    val previousEnd: Fielder = parse_element (element (cls, fields(10)))
    val previousStart: Fielder = parse_element (element (cls, fields(11)))
    val price: Fielder = parse_element (element (cls, fields(12)))
    val productCode: Fielder = parse_element (element (cls, fields(13)))
    val providedBy: Fielder = parse_element (element (cls, fields(14)))
    val quantity: Fielder = parse_attribute (attribute (cls, fields(15)))
    val serviceEnd: Fielder = parse_element (element (cls, fields(16)))
    val serviceStart: Fielder = parse_element (element (cls, fields(17)))
    val soldTo: Fielder = parse_element (element (cls, fields(18)))
    val taxAmount: Fielder = parse_element (element (cls, fields(19)))
    val timeZone: Fielder = parse_element (element (cls, fields(20)))
    val tradeDate: Fielder = parse_element (element (cls, fields(21)))
    val transactionDate: Fielder = parse_element (element (cls, fields(22)))
    val transactionType: Fielder = parse_element (element (cls, fields(23)))
    val MarketStatementLineItem: Fielder = parse_attribute (attribute (cls, fields(24)))
    val MktUserAttribute: FielderMultiple = parse_attributes (attribute (cls, fields(25)))

    def parse (context: Context): PassThroughBill =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PassThroughBill (
            Document.parse (context),
            toDouble (mask (adjustedAmount (), 0)),
            toDouble (mask (amount (), 1)),
            mask (billEnd (), 2),
            mask (billRunType (), 3),
            mask (billStart (), 4),
            mask (billedTo (), 5),
            mask (effectiveDate (), 6),
            toBoolean (mask (isDisputed (), 7)),
            toBoolean (mask (isProfiled (), 8)),
            mask (paidTo (), 9),
            mask (previousEnd (), 10),
            mask (previousStart (), 11),
            toDouble (mask (price (), 12)),
            mask (productCode (), 13),
            mask (providedBy (), 14),
            mask (quantity (), 15),
            mask (serviceEnd (), 16),
            mask (serviceStart (), 17),
            mask (soldTo (), 18),
            toDouble (mask (taxAmount (), 19)),
            mask (timeZone (), 20),
            mask (tradeDate (), 21),
            mask (transactionDate (), 22),
            mask (transactionType (), 23),
            mask (MarketStatementLineItem (), 24),
            masks (MktUserAttribute (), 25)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MarketStatementLineItem", "MarketStatementLineItem", false),
        Relationship ("MktUserAttribute", "MktUserAttribute", true)
    )
}

/**
 * Pricing node clearing results posted for a given settlement period.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class PnodeClearing
(
    override val sup: MarketFactors
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[PnodeClearing] }
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
        "\t<cim:PnodeClearing rdf:ID=\"%s\">\n%s\t</cim:PnodeClearing>".format (id, export_fields)
    }
}

object PnodeClearing
extends
    Parseable[PnodeClearing]
{

    def parse (context: Context): PnodeClearing =
    {
        implicit val ctx: Context = context
        val ret = PnodeClearing (
            MarketFactors.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Provides the total price, the cost component, the loss component, and the congestion component for Pnodes for the forward and real time markets.
 *
 * There are several prices produced based on the run type (MPM, RUC, Pricing, or Scheduling/Dispatch).
 *
 * @param sup Reference to the superclass object.
 * @param congestLMP Congestion component of Location Marginal Price (LMP) in monetary units per MW.
 * @param costLMP Cost component of Locational Marginal Pricing (LMP) in monetary units per MW.
 * @param lossLMP Loss component of Location Marginal Price (LMP) in monetary units per MW.
 * @param marginalClearingPrice Locational Marginal Price (LMP) (\$/MWh)
 * @param scheduledMW total MW schedule at the pnode
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param Pnode [[ch.ninecode.model.Pnode Pnode]] <em>undocumented</em>
 * @param PnodeClearing [[ch.ninecode.model.PnodeClearing PnodeClearing]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class PnodeResults
(
    override val sup: BasicElement,
    congestLMP: Double,
    costLMP: Double,
    lossLMP: Double,
    marginalClearingPrice: Double,
    scheduledMW: Double,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    Pnode: String,
    PnodeClearing: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PnodeResults] }
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
        implicit val clz: String = PnodeResults.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PnodeResults.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PnodeResults.fields (position), value)
        emitelem (0, congestLMP)
        emitelem (1, costLMP)
        emitelem (2, lossLMP)
        emitelem (3, marginalClearingPrice)
        emitelem (4, scheduledMW)
        emitelem (5, updateTimeStamp)
        emitattr (6, updateType)
        emitelem (7, updateUser)
        emitattr (8, Pnode)
        emitattr (9, PnodeClearing)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PnodeResults rdf:ID=\"%s\">\n%s\t</cim:PnodeResults>".format (id, export_fields)
    }
}

object PnodeResults
extends
    Parseable[PnodeResults]
{
    val fields: Array[String] = Array[String] (
        "congestLMP",
        "costLMP",
        "lossLMP",
        "marginalClearingPrice",
        "scheduledMW",
        "updateTimeStamp",
        "updateType",
        "updateUser",
        "Pnode",
        "PnodeClearing"
    )
    val congestLMP: Fielder = parse_element (element (cls, fields(0)))
    val costLMP: Fielder = parse_element (element (cls, fields(1)))
    val lossLMP: Fielder = parse_element (element (cls, fields(2)))
    val marginalClearingPrice: Fielder = parse_element (element (cls, fields(3)))
    val scheduledMW: Fielder = parse_element (element (cls, fields(4)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(5)))
    val updateType: Fielder = parse_attribute (attribute (cls, fields(6)))
    val updateUser: Fielder = parse_element (element (cls, fields(7)))
    val Pnode: Fielder = parse_attribute (attribute (cls, fields(8)))
    val PnodeClearing: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: Context): PnodeResults =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PnodeResults (
            BasicElement.parse (context),
            toDouble (mask (congestLMP (), 0)),
            toDouble (mask (costLMP (), 1)),
            toDouble (mask (lossLMP (), 2)),
            toDouble (mask (marginalClearingPrice (), 3)),
            toDouble (mask (scheduledMW (), 4)),
            mask (updateTimeStamp (), 5),
            mask (updateType (), 6),
            mask (updateUser (), 7),
            mask (Pnode (), 8),
            mask (PnodeClearing (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Pnode", "Pnode", false),
        Relationship ("PnodeClearing", "PnodeClearing", false)
    )
}

/**
 * Indicates whether unit is a reliablity must run unit: required to be on to satisfy Grid Code Reliablitiy criteria, load demand, or voltage support.
 *
 * @param sup Reference to the superclass object.
 * @param Bid [[ch.ninecode.model.Bid Bid]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class RMRDetermination
(
    override val sup: BasicElement,
    Bid: String
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
    override def copy (): Row = { clone ().asInstanceOf[RMRDetermination] }
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
        implicit val clz: String = RMRDetermination.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RMRDetermination.fields (position), value)
        emitattr (0, Bid)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RMRDetermination rdf:ID=\"%s\">\n%s\t</cim:RMRDetermination>".format (id, export_fields)
    }
}

object RMRDetermination
extends
    Parseable[RMRDetermination]
{
    val fields: Array[String] = Array[String] (
        "Bid"
    )
    val Bid: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): RMRDetermination =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RMRDetermination (
            BasicElement.parse (context),
            mask (Bid (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Bid", "Bid", false)
    )
}

/**
 * RMR Operator's entry of the RMR requirement per market interval.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param manuallySchedRMRMw The lower of the original pre-dispatch or the AC run schedule (Also known as the RMR Reguirement) becomes the pre-dispatch value.
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class RMROperatorInput
(
    override val sup: MarketFactors,
    manuallySchedRMRMw: Double,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[RMROperatorInput] }
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
        implicit val clz: String = RMROperatorInput.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RMROperatorInput.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RMROperatorInput.fields (position), value)
        emitelem (0, manuallySchedRMRMw)
        emitelem (1, updateTimeStamp)
        emitattr (2, updateType)
        emitelem (3, updateUser)
        emitattr (4, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RMROperatorInput rdf:ID=\"%s\">\n%s\t</cim:RMROperatorInput>".format (id, export_fields)
    }
}

object RMROperatorInput
extends
    Parseable[RMROperatorInput]
{
    val fields: Array[String] = Array[String] (
        "manuallySchedRMRMw",
        "updateTimeStamp",
        "updateType",
        "updateUser",
        "RegisteredResource"
    )
    val manuallySchedRMRMw: Fielder = parse_element (element (cls, fields(0)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(1)))
    val updateType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val updateUser: Fielder = parse_element (element (cls, fields(3)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): RMROperatorInput =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RMROperatorInput (
            MarketFactors.parse (context),
            toDouble (mask (manuallySchedRMRMw (), 0)),
            mask (updateTimeStamp (), 1),
            mask (updateType (), 2),
            mask (updateUser (), 3),
            mask (RegisteredResource (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", false)
    )
}

/**
 * This class models the information about the RUC awards
 *
 * @param sup Reference to the superclass object.
 * @param clearedPrice Marginal Price (\$/MW) for the commodity (Regulation Up, Regulation Down, Spinning Reserve, or Non-spinning reserve) for pricing run.
 * @param marketProductType major product type may include the following but not limited to:
 *        
 *        Energy
 *        Regulation Up
 *        Regulation Dn
 *        Spinning Reserve
 *        Non-Spinning Reserve
 *        Operating Reserve
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param RUCAward The RUC Award of a resource is the portion of the RUC Capacity that is not under RA or RMR contracts.
 *        The RUC Award of a resource is the portion of the RUC Capacity that is eligible for RUC Availability payment.
 * @param RUCCapacity The RUC Capacity of a resource is the difference between (i) the RUC Schedule and (ii) the higher of the DA Schedule and the Minimum Load.
 * @param RUCSchedule The RUC Schedule of a resource is its output level that balances the load forecast used in RUC.
 *        The RUC Schedule in RUC is similar to the DA Schedule in DAM.
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class RUCAwardInstruction
(
    override val sup: BasicElement,
    clearedPrice: Double,
    marketProductType: String,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    RUCAward: Double,
    RUCCapacity: Double,
    RUCSchedule: Double,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null, null, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[RUCAwardInstruction] }
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
        implicit val clz: String = RUCAwardInstruction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RUCAwardInstruction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RUCAwardInstruction.fields (position), value)
        emitelem (0, clearedPrice)
        emitattr (1, marketProductType)
        emitelem (2, updateTimeStamp)
        emitattr (3, updateType)
        emitelem (4, updateUser)
        emitelem (5, RUCAward)
        emitelem (6, RUCCapacity)
        emitelem (7, RUCSchedule)
        emitattr (8, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RUCAwardInstruction rdf:ID=\"%s\">\n%s\t</cim:RUCAwardInstruction>".format (id, export_fields)
    }
}

object RUCAwardInstruction
extends
    Parseable[RUCAwardInstruction]
{
    val fields: Array[String] = Array[String] (
        "clearedPrice",
        "marketProductType",
        "updateTimeStamp",
        "updateType",
        "updateUser",
        "RUCAward",
        "RUCCapacity",
        "RUCSchedule",
        "RegisteredResource"
    )
    val clearedPrice: Fielder = parse_element (element (cls, fields(0)))
    val marketProductType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(2)))
    val updateType: Fielder = parse_attribute (attribute (cls, fields(3)))
    val updateUser: Fielder = parse_element (element (cls, fields(4)))
    val RUCAward: Fielder = parse_element (element (cls, fields(5)))
    val RUCCapacity: Fielder = parse_element (element (cls, fields(6)))
    val RUCSchedule: Fielder = parse_element (element (cls, fields(7)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): RUCAwardInstruction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RUCAwardInstruction (
            BasicElement.parse (context),
            toDouble (mask (clearedPrice (), 0)),
            mask (marketProductType (), 1),
            mask (updateTimeStamp (), 2),
            mask (updateType (), 3),
            mask (updateUser (), 4),
            toDouble (mask (RUCAward (), 5)),
            toDouble (mask (RUCCapacity (), 6)),
            toDouble (mask (RUCSchedule (), 7)),
            mask (RegisteredResource (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", false)
    )
}

/**
 * Models details of bid and offer market clearing.
 *
 * Class indicates whether a contingency is active and whether the automatic dispatching system is active for this interval of the market solution
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param contingencyActive Indication that the system is currently operating in a contingency mode.
 * @param dispatchMode <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ResourceAwardClearing
(
    override val sup: MarketFactors,
    contingencyActive: String,
    dispatchMode: String
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
    override def copy (): Row = { clone ().asInstanceOf[ResourceAwardClearing] }
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
        implicit val clz: String = ResourceAwardClearing.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceAwardClearing.fields (position), value)
        emitattr (0, contingencyActive)
        emitattr (1, dispatchMode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceAwardClearing rdf:ID=\"%s\">\n%s\t</cim:ResourceAwardClearing>".format (id, export_fields)
    }
}

object ResourceAwardClearing
extends
    Parseable[ResourceAwardClearing]
{
    val fields: Array[String] = Array[String] (
        "contingencyActive",
        "dispatchMode"
    )
    val contingencyActive: Fielder = parse_attribute (attribute (cls, fields(0)))
    val dispatchMode: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ResourceAwardClearing =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ResourceAwardClearing (
            MarketFactors.parse (context),
            mask (contingencyActive (), 0),
            mask (dispatchMode (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Model of market results, instruction for resource.
 *
 * Contains details of award as attributes
 *
 * @param sup Reference to the superclass object.
 * @param awardMW For DA Energy: Not Applicable;
 *        
 *        For DA AS: DA AS market award;
 *        
 *        For RT Energy: Not Applicable;
 *        For RT AS: RT AS market award (excluding DA AS market or self-proviison awards)
 * @param clearedMW For DA Energy: Total Schedule = DA market schedule + DA self-schedule award;
 *        
 *        For DA AS: DA Ancillary Service Awards = DA AS market award + DA AS self-provision award;
 *        
 *        For RT Energy: Total Schedule = RT market schedule + RT self-schedule award;
 *        For RT AS: RT Ancillary Service Awards = RT AS self-provision award + RT AS market award + DA AS market award + DA AS self-provision award;
 * @param clearedPrice Marginal Price (\$/MW) for the commodity (Regulation Up, Regulation Down, Spinning Reserve, or Non-spinning reserve) for pricing run.
 * @param congestLMP Congestion component of Location Marginal Price (LMP) in monetary units per MW.
 * @param costLMP Cost component of Locational Marginal Pricing (LMP) in monetary units per MW.
 * @param dispatcherAddedMW The tier2 mw added by dispatcher action
 *        Market results of the synchronized reserve market
 * @param economicMax Unit max output for dispatch; bid in economic maximum
 * @param economicMin Unit min output for dispatch; bid in economic minimum
 * @param effRegulationDownLimit Effective Regulation Down Limit (MW)
 * @param effRegulationUpLimit Effective Regulation Up Limit
 * @param lmp Locational marginal price value
 * @param lossLMP Loss component of Location Marginal Price (LMP) in monetary units per MW.
 * @param manuallyBlocked Indicates if an award was manually blocked (Y/N).
 *        Valid for Spinning and Non-spinning.
 * @param marginalResourceIndicator Indicator (Yes / No) that this resource set the price for this dispatch / schedule.
 * @param mustRunInd Identifes if the unit was set to must run by the market participant responsible for bidding in the unit
 * @param noLoadCost Unit no-load cost in case of energy commodity
 * @param optimalBidCost Optimal Bid cost
 * @param optimalBidPay Optimal Bid production payment based on LMP
 * @param optimalMargin Optimal Bid production margin
 * @param overrideTimeStamp Time the manual data entry occured.
 * @param overrideValue Provides the ability for the grid operator to override items, such as spin capacity requirements, prior to running the algorithm.
 *        This value is market product based (spin, non-spin, reg up, reg down, or RUC).
 * @param selfSchedMW For DA Energy: DA total self-schedule award;
 *        For DA AS: DA AS self-provision award;
 *        For RT Energy: RT total self-schedule award;
 *        For RT AS: RT AS self-provision award (excluding DA AS market or self-provision awards)
 * @param startUpCost Unit start up cost in case of energy commodity
 * @param status In or out status of resource
 * @param totalRevenue Total bid revenue (startup_cost + no_load_cost + bid_pay)
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param MarketProduct [[ch.ninecode.model.MarketProduct MarketProduct]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ResourceAwardInstruction
(
    override val sup: BasicElement,
    awardMW: Double,
    clearedMW: Double,
    clearedPrice: Double,
    congestLMP: Double,
    costLMP: Double,
    dispatcherAddedMW: Double,
    economicMax: Double,
    economicMin: Double,
    effRegulationDownLimit: Double,
    effRegulationUpLimit: Double,
    lmp: Double,
    lossLMP: Double,
    manuallyBlocked: String,
    marginalResourceIndicator: String,
    mustRunInd: Boolean,
    noLoadCost: Double,
    optimalBidCost: Double,
    optimalBidPay: Double,
    optimalMargin: Double,
    overrideTimeStamp: String,
    overrideValue: Double,
    selfSchedMW: Double,
    startUpCost: Double,
    status: String,
    totalRevenue: Double,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    MarketProduct: String,
    RegisteredResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, false, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, null, 0.0, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceAwardInstruction] }
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
        implicit val clz: String = ResourceAwardInstruction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourceAwardInstruction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceAwardInstruction.fields (position), value)
        emitelem (0, awardMW)
        emitelem (1, clearedMW)
        emitelem (2, clearedPrice)
        emitelem (3, congestLMP)
        emitelem (4, costLMP)
        emitelem (5, dispatcherAddedMW)
        emitelem (6, economicMax)
        emitelem (7, economicMin)
        emitelem (8, effRegulationDownLimit)
        emitelem (9, effRegulationUpLimit)
        emitelem (10, lmp)
        emitelem (11, lossLMP)
        emitattr (12, manuallyBlocked)
        emitattr (13, marginalResourceIndicator)
        emitelem (14, mustRunInd)
        emitelem (15, noLoadCost)
        emitelem (16, optimalBidCost)
        emitelem (17, optimalBidPay)
        emitelem (18, optimalMargin)
        emitelem (19, overrideTimeStamp)
        emitelem (20, overrideValue)
        emitelem (21, selfSchedMW)
        emitelem (22, startUpCost)
        emitelem (23, status)
        emitelem (24, totalRevenue)
        emitelem (25, updateTimeStamp)
        emitattr (26, updateType)
        emitelem (27, updateUser)
        emitattr (28, MarketProduct)
        emitattr (29, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceAwardInstruction rdf:ID=\"%s\">\n%s\t</cim:ResourceAwardInstruction>".format (id, export_fields)
    }
}

object ResourceAwardInstruction
extends
    Parseable[ResourceAwardInstruction]
{
    val fields: Array[String] = Array[String] (
        "awardMW",
        "clearedMW",
        "clearedPrice",
        "congestLMP",
        "costLMP",
        "dispatcherAddedMW",
        "economicMax",
        "economicMin",
        "effRegulationDownLimit",
        "effRegulationUpLimit",
        "lmp",
        "lossLMP",
        "manuallyBlocked",
        "marginalResourceIndicator",
        "mustRunInd",
        "noLoadCost",
        "optimalBidCost",
        "optimalBidPay",
        "optimalMargin",
        "overrideTimeStamp",
        "overrideValue",
        "selfSchedMW",
        "startUpCost",
        "status",
        "totalRevenue",
        "updateTimeStamp",
        "updateType",
        "updateUser",
        "MarketProduct",
        "RegisteredResource"
    )
    val awardMW: Fielder = parse_element (element (cls, fields(0)))
    val clearedMW: Fielder = parse_element (element (cls, fields(1)))
    val clearedPrice: Fielder = parse_element (element (cls, fields(2)))
    val congestLMP: Fielder = parse_element (element (cls, fields(3)))
    val costLMP: Fielder = parse_element (element (cls, fields(4)))
    val dispatcherAddedMW: Fielder = parse_element (element (cls, fields(5)))
    val economicMax: Fielder = parse_element (element (cls, fields(6)))
    val economicMin: Fielder = parse_element (element (cls, fields(7)))
    val effRegulationDownLimit: Fielder = parse_element (element (cls, fields(8)))
    val effRegulationUpLimit: Fielder = parse_element (element (cls, fields(9)))
    val lmp: Fielder = parse_element (element (cls, fields(10)))
    val lossLMP: Fielder = parse_element (element (cls, fields(11)))
    val manuallyBlocked: Fielder = parse_attribute (attribute (cls, fields(12)))
    val marginalResourceIndicator: Fielder = parse_attribute (attribute (cls, fields(13)))
    val mustRunInd: Fielder = parse_element (element (cls, fields(14)))
    val noLoadCost: Fielder = parse_element (element (cls, fields(15)))
    val optimalBidCost: Fielder = parse_element (element (cls, fields(16)))
    val optimalBidPay: Fielder = parse_element (element (cls, fields(17)))
    val optimalMargin: Fielder = parse_element (element (cls, fields(18)))
    val overrideTimeStamp: Fielder = parse_element (element (cls, fields(19)))
    val overrideValue: Fielder = parse_element (element (cls, fields(20)))
    val selfSchedMW: Fielder = parse_element (element (cls, fields(21)))
    val startUpCost: Fielder = parse_element (element (cls, fields(22)))
    val status: Fielder = parse_element (element (cls, fields(23)))
    val totalRevenue: Fielder = parse_element (element (cls, fields(24)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(25)))
    val updateType: Fielder = parse_attribute (attribute (cls, fields(26)))
    val updateUser: Fielder = parse_element (element (cls, fields(27)))
    val MarketProduct: Fielder = parse_attribute (attribute (cls, fields(28)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(29)))

    def parse (context: Context): ResourceAwardInstruction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ResourceAwardInstruction (
            BasicElement.parse (context),
            toDouble (mask (awardMW (), 0)),
            toDouble (mask (clearedMW (), 1)),
            toDouble (mask (clearedPrice (), 2)),
            toDouble (mask (congestLMP (), 3)),
            toDouble (mask (costLMP (), 4)),
            toDouble (mask (dispatcherAddedMW (), 5)),
            toDouble (mask (economicMax (), 6)),
            toDouble (mask (economicMin (), 7)),
            toDouble (mask (effRegulationDownLimit (), 8)),
            toDouble (mask (effRegulationUpLimit (), 9)),
            toDouble (mask (lmp (), 10)),
            toDouble (mask (lossLMP (), 11)),
            mask (manuallyBlocked (), 12),
            mask (marginalResourceIndicator (), 13),
            toBoolean (mask (mustRunInd (), 14)),
            toDouble (mask (noLoadCost (), 15)),
            toDouble (mask (optimalBidCost (), 16)),
            toDouble (mask (optimalBidPay (), 17)),
            toDouble (mask (optimalMargin (), 18)),
            mask (overrideTimeStamp (), 19),
            toDouble (mask (overrideValue (), 20)),
            toDouble (mask (selfSchedMW (), 21)),
            toDouble (mask (startUpCost (), 22)),
            mask (status (), 23),
            toDouble (mask (totalRevenue (), 24)),
            mask (updateTimeStamp (), 25),
            mask (updateType (), 26),
            mask (updateUser (), 27),
            mask (MarketProduct (), 28),
            mask (RegisteredResource (), 29)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MarketProduct", "MarketProduct", false),
        Relationship ("RegisteredResource", "RegisteredResource", false)
    )
}

/**
 * Model of market results, including cleaing result of resources.
 *
 * Associated with ResourceDispatchResults.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ResourceClearing
(
    override val sup: MarketFactors
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[ResourceClearing] }
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
        "\t<cim:ResourceClearing rdf:ID=\"%s\">\n%s\t</cim:ResourceClearing>".format (id, export_fields)
    }
}

object ResourceClearing
extends
    Parseable[ResourceClearing]
{

    def parse (context: Context): ResourceClearing =
    {
        implicit val ctx: Context = context
        val ret = ResourceClearing (
            MarketFactors.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * The ResourceDispatchResults class provides market results that can be provided to a SC.
 *
 * The specific data provided consists of several indicators such as contingency flags, blocked start up, and RMR dispatch. It also provides the projected overall and the regulating status of the resource.
 *
 * @param sup Reference to the superclass object.
 * @param blockedDispatch Blocked Dispatch Indicator (Yes/No)
 * @param blockedPublishDOP Block sending DOP to ADS (Y/N)
 * @param contingencyFlag Contingent Operating Reserve Indicator (Yes/No).
 *        Resource participating with AS capacity in contingency dispatch.
 * @param limitIndicator indicate which limit is the constraints
 * @param lowerLimit resource energy ramping lower limit
 * @param maxRampRate maximum ramp rate
 * @param operatingLimitHigh The upper operating limit incorporating any derate used by the RTD for the Binding Interval.
 * @param operatingLimitLow The lower operating limit incorporating any derate used by the RTD for the Binding Interval.
 * @param penaltyDispatchIndicator Penalty Dispatch Indicator (Yes / No) indicating an un-economic adjustment.
 * @param regulatingLimitHigh The upper regulating limit incorporating any derate used by the RTD for the Binding Interval.
 * @param regulatingLimitLow The lower regulating limit incorporating any derate used by the RTD for the Binding Interval.
 * @param resourceStatus Unit Commitment Status (On/Off/Starting)
 * @param totalSchedule Resource total upward schedule.  total schedule = En + all AS per resource per interval
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param upperLimit resource energy ramping upper limit
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param ResourceClearing [[ch.ninecode.model.ResourceClearing ResourceClearing]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ResourceDispatchResults
(
    override val sup: BasicElement,
    blockedDispatch: String,
    blockedPublishDOP: String,
    contingencyFlag: String,
    limitIndicator: String,
    lowerLimit: Double,
    maxRampRate: Double,
    operatingLimitHigh: Double,
    operatingLimitLow: Double,
    penaltyDispatchIndicator: String,
    regulatingLimitHigh: Double,
    regulatingLimitLow: Double,
    resourceStatus: String,
    totalSchedule: Double,
    updateTimeStamp: String,
    updateType: String,
    updateUser: String,
    upperLimit: Double,
    RegisteredResource: String,
    ResourceClearing: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, null, 0.0, null, null, null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceDispatchResults] }
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
        implicit val clz: String = ResourceDispatchResults.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourceDispatchResults.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceDispatchResults.fields (position), value)
        emitelem (0, blockedDispatch)
        emitelem (1, blockedPublishDOP)
        emitattr (2, contingencyFlag)
        emitelem (3, limitIndicator)
        emitelem (4, lowerLimit)
        emitelem (5, maxRampRate)
        emitelem (6, operatingLimitHigh)
        emitelem (7, operatingLimitLow)
        emitattr (8, penaltyDispatchIndicator)
        emitelem (9, regulatingLimitHigh)
        emitelem (10, regulatingLimitLow)
        emitelem (11, resourceStatus)
        emitelem (12, totalSchedule)
        emitelem (13, updateTimeStamp)
        emitattr (14, updateType)
        emitelem (15, updateUser)
        emitelem (16, upperLimit)
        emitattr (17, RegisteredResource)
        emitattr (18, ResourceClearing)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceDispatchResults rdf:ID=\"%s\">\n%s\t</cim:ResourceDispatchResults>".format (id, export_fields)
    }
}

object ResourceDispatchResults
extends
    Parseable[ResourceDispatchResults]
{
    val fields: Array[String] = Array[String] (
        "blockedDispatch",
        "blockedPublishDOP",
        "contingencyFlag",
        "limitIndicator",
        "lowerLimit",
        "maxRampRate",
        "operatingLimitHigh",
        "operatingLimitLow",
        "penaltyDispatchIndicator",
        "regulatingLimitHigh",
        "regulatingLimitLow",
        "resourceStatus",
        "totalSchedule",
        "updateTimeStamp",
        "updateType",
        "updateUser",
        "upperLimit",
        "RegisteredResource",
        "ResourceClearing"
    )
    val blockedDispatch: Fielder = parse_element (element (cls, fields(0)))
    val blockedPublishDOP: Fielder = parse_element (element (cls, fields(1)))
    val contingencyFlag: Fielder = parse_attribute (attribute (cls, fields(2)))
    val limitIndicator: Fielder = parse_element (element (cls, fields(3)))
    val lowerLimit: Fielder = parse_element (element (cls, fields(4)))
    val maxRampRate: Fielder = parse_element (element (cls, fields(5)))
    val operatingLimitHigh: Fielder = parse_element (element (cls, fields(6)))
    val operatingLimitLow: Fielder = parse_element (element (cls, fields(7)))
    val penaltyDispatchIndicator: Fielder = parse_attribute (attribute (cls, fields(8)))
    val regulatingLimitHigh: Fielder = parse_element (element (cls, fields(9)))
    val regulatingLimitLow: Fielder = parse_element (element (cls, fields(10)))
    val resourceStatus: Fielder = parse_element (element (cls, fields(11)))
    val totalSchedule: Fielder = parse_element (element (cls, fields(12)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(13)))
    val updateType: Fielder = parse_attribute (attribute (cls, fields(14)))
    val updateUser: Fielder = parse_element (element (cls, fields(15)))
    val upperLimit: Fielder = parse_element (element (cls, fields(16)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(17)))
    val ResourceClearing: Fielder = parse_attribute (attribute (cls, fields(18)))

    def parse (context: Context): ResourceDispatchResults =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ResourceDispatchResults (
            BasicElement.parse (context),
            mask (blockedDispatch (), 0),
            mask (blockedPublishDOP (), 1),
            mask (contingencyFlag (), 2),
            mask (limitIndicator (), 3),
            toDouble (mask (lowerLimit (), 4)),
            toDouble (mask (maxRampRate (), 5)),
            toDouble (mask (operatingLimitHigh (), 6)),
            toDouble (mask (operatingLimitLow (), 7)),
            mask (penaltyDispatchIndicator (), 8),
            toDouble (mask (regulatingLimitHigh (), 9)),
            toDouble (mask (regulatingLimitLow (), 10)),
            mask (resourceStatus (), 11),
            toDouble (mask (totalSchedule (), 12)),
            mask (updateTimeStamp (), 13),
            mask (updateType (), 14),
            mask (updateUser (), 15),
            toDouble (mask (upperLimit (), 16)),
            mask (RegisteredResource (), 17),
            mask (ResourceClearing (), 18)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", false),
        Relationship ("ResourceClearing", "ResourceClearing", false)
    )
}

/**
 * Model of market clearing results for resources that bid to follow load
 *
 * @param sup Reference to the superclass object.
 * @param calcLoadFollowingMW weighted average for RTPD and RTCD and same for RTID
 * @param dispWindowHighLimt <em>undocumented</em>
 * @param dispWindowLowLimt <em>undocumented</em>
 * @param instructionID Unique instruction id per instruction, assigned by the SC and provided to ADS.
 *        ADS passes through.
 * @param intervalStartTime The start of the time interval for which requirement is defined.
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param ResourceClearing [[ch.ninecode.model.ResourceClearing ResourceClearing]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class ResourceLoadFollowingInst
(
    override val sup: BasicElement,
    calcLoadFollowingMW: Double,
    dispWindowHighLimt: Double,
    dispWindowLowLimt: Double,
    instructionID: String,
    intervalStartTime: String,
    RegisteredResource: String,
    ResourceClearing: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceLoadFollowingInst] }
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
        implicit val clz: String = ResourceLoadFollowingInst.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourceLoadFollowingInst.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceLoadFollowingInst.fields (position), value)
        emitelem (0, calcLoadFollowingMW)
        emitelem (1, dispWindowHighLimt)
        emitelem (2, dispWindowLowLimt)
        emitelem (3, instructionID)
        emitelem (4, intervalStartTime)
        emitattr (5, RegisteredResource)
        emitattr (6, ResourceClearing)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceLoadFollowingInst rdf:ID=\"%s\">\n%s\t</cim:ResourceLoadFollowingInst>".format (id, export_fields)
    }
}

object ResourceLoadFollowingInst
extends
    Parseable[ResourceLoadFollowingInst]
{
    val fields: Array[String] = Array[String] (
        "calcLoadFollowingMW",
        "dispWindowHighLimt",
        "dispWindowLowLimt",
        "instructionID",
        "intervalStartTime",
        "RegisteredResource",
        "ResourceClearing"
    )
    val calcLoadFollowingMW: Fielder = parse_element (element (cls, fields(0)))
    val dispWindowHighLimt: Fielder = parse_element (element (cls, fields(1)))
    val dispWindowLowLimt: Fielder = parse_element (element (cls, fields(2)))
    val instructionID: Fielder = parse_element (element (cls, fields(3)))
    val intervalStartTime: Fielder = parse_element (element (cls, fields(4)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ResourceClearing: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): ResourceLoadFollowingInst =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ResourceLoadFollowingInst (
            BasicElement.parse (context),
            toDouble (mask (calcLoadFollowingMW (), 0)),
            toDouble (mask (dispWindowHighLimt (), 1)),
            toDouble (mask (dispWindowLowLimt (), 2)),
            mask (instructionID (), 3),
            mask (intervalStartTime (), 4),
            mask (RegisteredResource (), 5),
            mask (ResourceClearing (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", false),
        Relationship ("ResourceClearing", "ResourceClearing", false)
    )
}

/**
 * Model of Self Schedules Results.
 *
 * Includes self schedule MW,and type of self schedule for each self schedule type included in total self schedule MW value found in ResourceAwardInstruction.
 *
 * @param sup Reference to the superclass object.
 * @param selfSchedMW Cleared value for the specific self schedule type listed.
 * @param selfSchedType Self schedule breakdown type.
 * @param ResourceAwardInstruction [[ch.ninecode.model.ResourceAwardInstruction ResourceAwardInstruction]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class SelfScheduleBreakdown
(
    override val sup: BasicElement,
    selfSchedMW: Double,
    selfSchedType: String,
    ResourceAwardInstruction: String
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
    override def copy (): Row = { clone ().asInstanceOf[SelfScheduleBreakdown] }
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
        implicit val clz: String = SelfScheduleBreakdown.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SelfScheduleBreakdown.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SelfScheduleBreakdown.fields (position), value)
        emitelem (0, selfSchedMW)
        emitattr (1, selfSchedType)
        emitattr (2, ResourceAwardInstruction)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SelfScheduleBreakdown rdf:ID=\"%s\">\n%s\t</cim:SelfScheduleBreakdown>".format (id, export_fields)
    }
}

object SelfScheduleBreakdown
extends
    Parseable[SelfScheduleBreakdown]
{
    val fields: Array[String] = Array[String] (
        "selfSchedMW",
        "selfSchedType",
        "ResourceAwardInstruction"
    )
    val selfSchedMW: Fielder = parse_element (element (cls, fields(0)))
    val selfSchedType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ResourceAwardInstruction: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): SelfScheduleBreakdown =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SelfScheduleBreakdown (
            BasicElement.parse (context),
            toDouble (mask (selfSchedMW (), 0)),
            mask (selfSchedType (), 1),
            mask (ResourceAwardInstruction (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ResourceAwardInstruction", "ResourceAwardInstruction", false)
    )
}

/**
 * Specifies a settlement run.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param tradeDate The trade date on which the settlement is run.
 * @param EnergyMarket [[ch.ninecode.model.EnergyMarket EnergyMarket]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class Settlement
(
    override val sup: Document,
    tradeDate: String,
    EnergyMarket: String
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[Settlement] }
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
        implicit val clz: String = Settlement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Settlement.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Settlement.fields (position), value)
        emitelem (0, tradeDate)
        emitattr (1, EnergyMarket)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Settlement rdf:ID=\"%s\">\n%s\t</cim:Settlement>".format (id, export_fields)
    }
}

object Settlement
extends
    Parseable[Settlement]
{
    val fields: Array[String] = Array[String] (
        "tradeDate",
        "EnergyMarket"
    )
    val tradeDate: Fielder = parse_element (element (cls, fields(0)))
    val EnergyMarket: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): Settlement =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Settlement (
            Document.parse (context),
            mask (tradeDate (), 0),
            mask (EnergyMarket (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("EnergyMarket", "EnergyMarket", false)
    )
}

/**
 * Contains the intervals relavent for the associated TransactionBidResults.
 *
 * For example, Day Ahead cleared results for the transaction bids for each interval of the market day.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class TransactionBidClearing
(
    override val sup: MarketFactors
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[TransactionBidClearing] }
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
        "\t<cim:TransactionBidClearing rdf:ID=\"%s\">\n%s\t</cim:TransactionBidClearing>".format (id, export_fields)
    }
}

object TransactionBidClearing
extends
    Parseable[TransactionBidClearing]
{

    def parse (context: Context): TransactionBidClearing =
    {
        implicit val ctx: Context = context
        val ret = TransactionBidClearing (
            MarketFactors.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Contains the cleared results for each TransactionBid submitted to and accepted by the market.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param clearedMW The market transaction megawatt
 * @param clearedPrice The price of the market transaction
 * @param TransactionBid [[ch.ninecode.model.TransactionBid TransactionBid]] <em>undocumented</em>
 * @param TransactionBidClearing [[ch.ninecode.model.TransactionBidClearing TransactionBidClearing]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
case class TransactionBidResults
(
    override val sup: IdentifiedObject,
    clearedMW: Double,
    clearedPrice: Double,
    TransactionBid: String,
    TransactionBidClearing: String
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TransactionBidResults] }
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
        implicit val clz: String = TransactionBidResults.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransactionBidResults.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransactionBidResults.fields (position), value)
        emitelem (0, clearedMW)
        emitelem (1, clearedPrice)
        emitattr (2, TransactionBid)
        emitattr (3, TransactionBidClearing)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransactionBidResults rdf:ID=\"%s\">\n%s\t</cim:TransactionBidResults>".format (id, export_fields)
    }
}

object TransactionBidResults
extends
    Parseable[TransactionBidResults]
{
    val fields: Array[String] = Array[String] (
        "clearedMW",
        "clearedPrice",
        "TransactionBid",
        "TransactionBidClearing"
    )
    val clearedMW: Fielder = parse_element (element (cls, fields(0)))
    val clearedPrice: Fielder = parse_element (element (cls, fields(1)))
    val TransactionBid: Fielder = parse_attribute (attribute (cls, fields(2)))
    val TransactionBidClearing: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): TransactionBidResults =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TransactionBidResults (
            IdentifiedObject.parse (context),
            toDouble (mask (clearedMW (), 0)),
            toDouble (mask (clearedPrice (), 1)),
            mask (TransactionBid (), 2),
            mask (TransactionBidClearing (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("TransactionBid", "TransactionBid", false),
        Relationship ("TransactionBidClearing", "TransactionBidClearing", false)
    )
}

private[ninecode] object _MarketResults
{
    def register: List[ClassInfo] =
    {
        List (
            AncillaryServiceClearing.register,
            BillDeterminant.register,
            ChargeProfile.register,
            ChargeProfileData.register,
            CommitmentClearing.register,
            Commitments.register,
            ConstraintClearing.register,
            ConstraintResults.register,
            DopInstruction.register,
            DotInstruction.register,
            ExPostLoss.register,
            ExPostLossResults.register,
            ExPostMarketRegion.register,
            ExPostMarketRegionResults.register,
            ExPostPricing.register,
            ExPostPricingResults.register,
            ExPostResource.register,
            ExPostResourceResults.register,
            GeneralClearing.register,
            GeneralClearingResults.register,
            InstructionClearing.register,
            InstructionClearingDOP.register,
            InstructionClearingDOT.register,
            Instructions.register,
            LoadFollowingOperatorInput.register,
            LossClearing.register,
            LossClearingResults.register,
            MPMClearing.register,
            MPMResourceStatus.register,
            MPMTestResults.register,
            MarketRegionResults.register,
            MarketResults.register,
            MarketStatement.register,
            MarketStatementLineItem.register,
            MitigatedBid.register,
            MitigatedBidClearing.register,
            MitigatedBidSegment.register,
            PassThroughBill.register,
            PnodeClearing.register,
            PnodeResults.register,
            RMRDetermination.register,
            RMROperatorInput.register,
            RUCAwardInstruction.register,
            ResourceAwardClearing.register,
            ResourceAwardInstruction.register,
            ResourceClearing.register,
            ResourceDispatchResults.register,
            ResourceLoadFollowingInst.register,
            SelfScheduleBreakdown.register,
            Settlement.register,
            TransactionBidClearing.register,
            TransactionBidResults.register
        )
    }
}