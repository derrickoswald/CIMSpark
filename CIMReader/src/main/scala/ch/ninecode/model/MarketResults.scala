package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship

/**
 * Model of results of market clearing with respect to  Ancillary Service products.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param MarketCaseClearing [[ch.ninecode.model.MarketCaseClearing MarketCaseClearing]] <em>undocumented</em>
 * @param MarketRegionResults [[ch.ninecode.model.MarketRegionResults MarketRegionResults]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class AncillaryServiceClearing
(
    MarketFactors: MarketFactors = null,
    MarketCaseClearing: String = null,
    MarketRegionResults: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = AncillaryServiceClearing.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AncillaryServiceClearing.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AncillaryServiceClearing.fields (position), x))
        emitattr (0, MarketCaseClearing)
        emitattrs (1, MarketRegionResults)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AncillaryServiceClearing rdf:ID=\"%s\">\n%s\t</cim:AncillaryServiceClearing>".format (id, export_fields)
    }
}

object AncillaryServiceClearing
extends
    CIMParseable[AncillaryServiceClearing]
{
    override val fields: Array[String] = Array[String] (
        "MarketCaseClearing",
        "MarketRegionResults"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketCaseClearing", "MarketCaseClearing", "0..1", "0..*"),
        CIMRelationship ("MarketRegionResults", "MarketRegionResults", "1..*", "0..1")
    )
    val MarketCaseClearing: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MarketRegionResults: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): AncillaryServiceClearing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AncillaryServiceClearing (
            MarketFactors.parse (context),
            mask (MarketCaseClearing (), 0),
            masks (MarketRegionResults (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Models various charges to support billing and settlement.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param calculationLevel Level in charge calculation order.
 * @param configVersion The version of configuration of calculation logic in the settlement.
 * @param deleteStatus <em>undocumented</em>
 * @param effectiveDate <em>undocumented</em>
 * @param exception <em>undocumented</em>
 * @param factor <em>undocumented</em>
 * @param frequency <em>undocumented</em>
 * @param numberInterval Number of intervals of bill determiant in trade day, e.g. 300 for five minute intervals.
 * @param offset <em>undocumented</em>
 * @param precisionLevel The level of precision in the current value.
 * @param primaryYN <em>undocumented</em>
 * @param referenceFlag <em>undocumented</em>
 * @param reportable <em>undocumented</em>
 * @param roundOff <em>undocumented</em>
 * @param source <em>undocumented</em>
 * @param terminationDate <em>undocumented</em>
 * @param unitOfMeasure The UOM for the current value of the Bill Determinant.
 * @param ChargeComponents [[ch.ninecode.model.ChargeComponent ChargeComponent]] A BillDeterminant can have 0-n ChargeComponent and a ChargeComponent can associate to 0-n BillDeterminant.
 * @param ChargeProfile [[ch.ninecode.model.ChargeProfile ChargeProfile]] <em>undocumented</em>
 * @param ChargeProfileData [[ch.ninecode.model.ChargeProfileData ChargeProfileData]] <em>undocumented</em>
 * @param MktUserAttribute [[ch.ninecode.model.MktUserAttribute MktUserAttribute]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class BillDeterminant
(
    Document: Document = null,
    calculationLevel: String = null,
    configVersion: String = null,
    deleteStatus: String = null,
    effectiveDate: String = null,
    exception: String = null,
    factor: String = null,
    frequency: String = null,
    numberInterval: Int = 0,
    offset: String = null,
    precisionLevel: String = null,
    primaryYN: String = null,
    referenceFlag: String = null,
    reportable: String = null,
    roundOff: String = null,
    source: String = null,
    terminationDate: String = null,
    unitOfMeasure: String = null,
    ChargeComponents: List[String] = null,
    ChargeProfile: String = null,
    ChargeProfileData: List[String] = null,
    MktUserAttribute: List[String] = null
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
        implicit val clz: String = BillDeterminant.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BillDeterminant.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BillDeterminant.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (BillDeterminant.fields (position), x))
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
        emitattrs (17, ChargeComponents)
        emitattr (18, ChargeProfile)
        emitattrs (19, ChargeProfileData)
        emitattrs (20, MktUserAttribute)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BillDeterminant rdf:ID=\"%s\">\n%s\t</cim:BillDeterminant>".format (id, export_fields)
    }
}

object BillDeterminant
extends
    CIMParseable[BillDeterminant]
{
    override val fields: Array[String] = Array[String] (
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
        "ChargeComponents",
        "ChargeProfile",
        "ChargeProfileData",
        "MktUserAttribute"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ChargeComponents", "ChargeComponent", "0..*", "0..*"),
        CIMRelationship ("ChargeProfile", "ChargeProfile", "0..1", "0..1"),
        CIMRelationship ("ChargeProfileData", "ChargeProfileData", "0..*", "0..1"),
        CIMRelationship ("MktUserAttribute", "MktUserAttribute", "0..*", "0..*")
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
    val ChargeComponents: FielderMultiple = parse_attributes (attribute (cls, fields(17)))
    val ChargeProfile: Fielder = parse_attribute (attribute (cls, fields(18)))
    val ChargeProfileData: FielderMultiple = parse_attributes (attribute (cls, fields(19)))
    val MktUserAttribute: FielderMultiple = parse_attributes (attribute (cls, fields(20)))

    def parse (context: CIMContext): BillDeterminant =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
            masks (ChargeComponents (), 17),
            mask (ChargeProfile (), 18),
            masks (ChargeProfileData (), 19),
            masks (MktUserAttribute (), 20)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A type of profile for financial charges.
 *
 * @param Profile [[ch.ninecode.model.Profile Profile]] Reference to the superclass object.
 * @param frequency The calculation frequency, daily or monthly.
 * @param numberInterval The number of intervals in the profile data.
 * @param type The type of profile.
 *        It could be amount, price, or quantity.
 * @param unitOfMeasure The unit of measure applied to the value attribute of the profile data.
 * @param Bid [[ch.ninecode.model.Bid Bid]] <em>undocumented</em>
 * @param BillDeterminant [[ch.ninecode.model.BillDeterminant BillDeterminant]] <em>undocumented</em>
 * @param ChargeProfileData [[ch.ninecode.model.ChargeProfileData ChargeProfileData]] <em>undocumented</em>
 * @param PassTroughBill [[ch.ninecode.model.PassThroughBill PassThroughBill]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class ChargeProfile
(
    Profile: Profile = null,
    frequency: String = null,
    numberInterval: Int = 0,
    `type`: String = null,
    unitOfMeasure: String = null,
    Bid: String = null,
    BillDeterminant: String = null,
    ChargeProfileData: List[String] = null,
    PassTroughBill: String = null
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
    override def sup: Profile = Profile

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
        implicit val clz: String = ChargeProfile.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ChargeProfile.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ChargeProfile.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ChargeProfile.fields (position), x))
        emitelem (0, frequency)
        emitelem (1, numberInterval)
        emitelem (2, `type`)
        emitelem (3, unitOfMeasure)
        emitattr (4, Bid)
        emitattr (5, BillDeterminant)
        emitattrs (6, ChargeProfileData)
        emitattr (7, PassTroughBill)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ChargeProfile rdf:ID=\"%s\">\n%s\t</cim:ChargeProfile>".format (id, export_fields)
    }
}

object ChargeProfile
extends
    CIMParseable[ChargeProfile]
{
    override val fields: Array[String] = Array[String] (
        "frequency",
        "numberInterval",
        "type",
        "unitOfMeasure",
        "Bid",
        "BillDeterminant",
        "ChargeProfileData",
        "PassTroughBill"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Bid", "Bid", "0..1", "0..*"),
        CIMRelationship ("BillDeterminant", "BillDeterminant", "0..1", "0..1"),
        CIMRelationship ("ChargeProfileData", "ChargeProfileData", "0..*", "0..1"),
        CIMRelationship ("PassTroughBill", "PassThroughBill", "0..1", "0..*")
    )
    val frequency: Fielder = parse_element (element (cls, fields(0)))
    val numberInterval: Fielder = parse_element (element (cls, fields(1)))
    val `type`: Fielder = parse_element (element (cls, fields(2)))
    val unitOfMeasure: Fielder = parse_element (element (cls, fields(3)))
    val Bid: Fielder = parse_attribute (attribute (cls, fields(4)))
    val BillDeterminant: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ChargeProfileData: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val PassTroughBill: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: CIMContext): ChargeProfile =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ChargeProfile (
            Profile.parse (context),
            mask (frequency (), 0),
            toInteger (mask (numberInterval (), 1)),
            mask (`type` (), 2),
            mask (unitOfMeasure (), 3),
            mask (Bid (), 4),
            mask (BillDeterminant (), 5),
            masks (ChargeProfileData (), 6),
            mask (PassTroughBill (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of various charges associated with an energy profile to support billing and settlement.
 *
 * @param Element Reference to the superclass object.
 * @param sequence The sequence number of the profile.
 * @param timeStamp The date and time of an interval.
 * @param value The value of an interval given a profile type (amount, price, or quantity), subject to the UOM.
 * @param BillDeterminant [[ch.ninecode.model.BillDeterminant BillDeterminant]] <em>undocumented</em>
 * @param ChargeProfile [[ch.ninecode.model.ChargeProfile ChargeProfile]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class ChargeProfileData
(
    Element: BasicElement = null,
    sequence: Int = 0,
    timeStamp: String = null,
    value: Double = 0.0,
    BillDeterminant: String = null,
    ChargeProfile: String = null
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
    CIMParseable[ChargeProfileData]
{
    override val fields: Array[String] = Array[String] (
        "sequence",
        "timeStamp",
        "value",
        "BillDeterminant",
        "ChargeProfile"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BillDeterminant", "BillDeterminant", "0..1", "0..*"),
        CIMRelationship ("ChargeProfile", "ChargeProfile", "0..1", "0..*")
    )
    val sequence: Fielder = parse_element (element (cls, fields(0)))
    val timeStamp: Fielder = parse_element (element (cls, fields(1)))
    val value: Fielder = parse_element (element (cls, fields(2)))
    val BillDeterminant: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ChargeProfile: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): ChargeProfileData =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Models results of market clearing which call for commitment of units.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param Commitments [[ch.ninecode.model.Commitments Commitments]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class CommitmentClearing
(
    MarketFactors: MarketFactors = null,
    Commitments: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = CommitmentClearing.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CommitmentClearing.fields (position), x))
        emitattrs (0, Commitments)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CommitmentClearing rdf:ID=\"%s\">\n%s\t</cim:CommitmentClearing>".format (id, export_fields)
    }
}

object CommitmentClearing
extends
    CIMParseable[CommitmentClearing]
{
    override val fields: Array[String] = Array[String] (
        "Commitments"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Commitments", "Commitments", "1..*", "1..*")
    )
    val Commitments: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): CommitmentClearing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CommitmentClearing (
            MarketFactors.parse (context),
            masks (Commitments (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Provides the necessary information (on a resource basis) to capture the Startup/Shutdown commitment results.
 *
 * This information is relevant to all markets.
 *
 * @param Element Reference to the superclass object.
 * @param commitmentType the type of UC status (self commitment, ISO commitment, or SCUC commitment)
 * @param instructionCost Total cost associated with changing the status of the resource.
 * @param instructionType Indicator of either a Start-Up or a Shut-Down.
 * @param intervalEndTime End time for the commitment period.
 *        This will be on an interval boundary.
 * @param intervalStartTime Start time for the commitment period.
 *        This will be on an interval boundary.
 * @param minStatusChangeTime SCUC commitment period start-up time.
 *        Calculated start up time based on the StartUpTimeCurve provided with the Bid.
 *        
 *        This is a combination of StartUp time bid and Unit down time.
 *        
 *        Units is minutes
 * @param noLoadCost Unit no load cost in case of energy commodity
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param CommitmentClearing [[ch.ninecode.model.CommitmentClearing CommitmentClearing]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class Commitments
(
    Element: BasicElement = null,
    commitmentType: String = null,
    instructionCost: Double = 0.0,
    instructionType: String = null,
    intervalEndTime: String = null,
    intervalStartTime: String = null,
    minStatusChangeTime: Int = 0,
    noLoadCost: Double = 0.0,
    updateTimeStamp: String = null,
    updateType: String = null,
    updateUser: String = null,
    CommitmentClearing: List[String] = null,
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
        implicit val clz: String = Commitments.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Commitments.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Commitments.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Commitments.fields (position), x))
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
        emitattrs (10, CommitmentClearing)
        emitattr (11, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Commitments rdf:ID=\"%s\">\n%s\t</cim:Commitments>".format (id, export_fields)
    }
}

object Commitments
extends
    CIMParseable[Commitments]
{
    override val fields: Array[String] = Array[String] (
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
        "CommitmentClearing",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CommitmentClearing", "CommitmentClearing", "1..*", "1..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "1", "0..*")
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
    val CommitmentClearing: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(11)))

    def parse (context: CIMContext): Commitments =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
            masks (CommitmentClearing (), 10),
            mask (RegisteredResource (), 11)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The CommodityPrice class is used to define the price of a commodity during a given time interval.
 *
 * The interval may be long, e.g. a year, or very short, e.g. 5 minutes.  There will be many instances of the CommodityPrice class for each instance of the CommodityDefinition to which it is associated.  Note that there may be more than once price associated with a given interval and these variances are described by the association (or associations) with the PriceDescriptor class.
 *
 * @param Element Reference to the superclass object.
 * @param timeIntervalPeriod The time interval over which the CommodityPrice is valid, using the standard conventions associated with the DateTimeInterval class.
 * @param value The price of the Commodity, expressed as a floating point value with the currency and unit of measure defined in the associated CommodityDefinition class.
 * @param CommodityDefinition [[ch.ninecode.model.CommodityDefinition CommodityDefinition]] <em>undocumented</em>
 * @param PnodeClearing [[ch.ninecode.model.PnodeClearing PnodeClearing]] <em>undocumented</em>
 * @param PriceDescriptor [[ch.ninecode.model.PriceDescriptor PriceDescriptor]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class CommodityPrice
(
    Element: BasicElement = null,
    timeIntervalPeriod: String = null,
    value: Double = 0.0,
    CommodityDefinition: String = null,
    PnodeClearing: String = null,
    PriceDescriptor: String = null
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
        implicit val clz: String = CommodityPrice.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CommodityPrice.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CommodityPrice.fields (position), value)
        emitattr (0, timeIntervalPeriod)
        emitelem (1, value)
        emitattr (2, CommodityDefinition)
        emitattr (3, PnodeClearing)
        emitattr (4, PriceDescriptor)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CommodityPrice rdf:ID=\"%s\">\n%s\t</cim:CommodityPrice>".format (id, export_fields)
    }
}

object CommodityPrice
extends
    CIMParseable[CommodityPrice]
{
    override val fields: Array[String] = Array[String] (
        "timeIntervalPeriod",
        "value",
        "CommodityDefinition",
        "PnodeClearing",
        "PriceDescriptor"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CommodityDefinition", "CommodityDefinition", "1", "1..*"),
        CIMRelationship ("PnodeClearing", "PnodeClearing", "0..1", "0..*"),
        CIMRelationship ("PriceDescriptor", "PriceDescriptor", "1", "1..*")
    )
    val timeIntervalPeriod: Fielder = parse_attribute (attribute (cls, fields(0)))
    val value: Fielder = parse_element (element (cls, fields(1)))
    val CommodityDefinition: Fielder = parse_attribute (attribute (cls, fields(2)))
    val PnodeClearing: Fielder = parse_attribute (attribute (cls, fields(3)))
    val PriceDescriptor: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): CommodityPrice =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CommodityPrice (
            BasicElement.parse (context),
            mask (timeIntervalPeriod (), 0),
            toDouble (mask (value (), 1)),
            mask (CommodityDefinition (), 2),
            mask (PnodeClearing (), 3),
            mask (PriceDescriptor (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Groups all items associated with Binding Constraints and Constraint Violations per interval and market.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param ConstraintResults [[ch.ninecode.model.ConstraintResults ConstraintResults]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class ConstraintClearing
(
    MarketFactors: MarketFactors = null,
    ConstraintResults: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = ConstraintClearing.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ConstraintClearing.fields (position), x))
        emitattrs (0, ConstraintResults)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ConstraintClearing rdf:ID=\"%s\">\n%s\t</cim:ConstraintClearing>".format (id, export_fields)
    }
}

object ConstraintClearing
extends
    CIMParseable[ConstraintClearing]
{
    override val fields: Array[String] = Array[String] (
        "ConstraintResults"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ConstraintResults", "ConstraintResults", "0..*", "0..1")
    )
    val ConstraintResults: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): ConstraintClearing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ConstraintClearing (
            MarketFactors.parse (context),
            masks (ConstraintResults (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Provides the Market results for the constraint processing for either the DAM or RTM.
 *
 * The data includes the constraint type (binding or violated), the solved value for the constraint, and the associated shadow price.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
final case class ConstraintResults
(
    IdentifiedObject: IdentifiedObject = null,
    baseFlow: Double = 0.0,
    bindingLimit: Double = 0.0,
    clearedValue: Double = 0.0,
    competitivePathConstraint: String = null,
    constraintType: String = null,
    limitFlag: String = null,
    optimizationFlag: String = null,
    overloadMW: Double = 0.0,
    percentMW: Double = 0.0,
    shadowPrice: Double = 0.0,
    updateTimeStamp: String = null,
    updateType: String = null,
    updateUser: String = null,
    BGLimit: Double = 0.0,
    BGTRResCap: Double = 0.0,
    ConstraintClearing: String = null,
    Flowgate: String = null,
    MktContingency: String = null
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
    CIMParseable[ConstraintResults]
{
    override val fields: Array[String] = Array[String] (
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ConstraintClearing", "ConstraintClearing", "0..1", "0..*"),
        CIMRelationship ("Flowgate", "Flowgate", "1", "1..*"),
        CIMRelationship ("MktContingency", "MktContingency", "1", "0..*")
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

    def parse (context: CIMContext): ConstraintResults =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Provides the necessary information (on a resource basis) to capture the Dispatch Operating Point (DOP) results on a Dispatch interval.
 *
 * This information is only relevant to the RT interval market.
 *
 * @param Element Reference to the superclass object.
 * @param mwDOP Dispatched Operating Point (MW)
 * @param plotPriority A value used to establish priority of the DOP when plotting.
 *        This is only applicable when two DOPs exist for the same time, but with different MW values.  E.g. when indicating a step in the curve.  Its used to determine if the curve steps up or down.
 * @param runIndicatorDOP Indication of DOP validity.
 *        Shows the DOP is calculated from the latest run (YES). A NO indicator shows that the DOP is copied from a previous execution.
 *        
 *        Up to 2 intervals can be missed.
 * @param timestampDOP DOP time stamp
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param InstructionClearingDOP [[ch.ninecode.model.InstructionClearingDOP InstructionClearingDOP]] <em>undocumented</em>
 * @param RegisteredResouce [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class DopInstruction
(
    Element: BasicElement = null,
    mwDOP: Double = 0.0,
    plotPriority: Int = 0,
    runIndicatorDOP: String = null,
    timestampDOP: String = null,
    updateTimeStamp: String = null,
    updateType: String = null,
    updateUser: String = null,
    InstructionClearingDOP: List[String] = null,
    RegisteredResouce: String = null
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
        implicit val clz: String = DopInstruction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DopInstruction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DopInstruction.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DopInstruction.fields (position), x))
        emitelem (0, mwDOP)
        emitelem (1, plotPriority)
        emitattr (2, runIndicatorDOP)
        emitelem (3, timestampDOP)
        emitelem (4, updateTimeStamp)
        emitattr (5, updateType)
        emitelem (6, updateUser)
        emitattrs (7, InstructionClearingDOP)
        emitattr (8, RegisteredResouce)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DopInstruction rdf:ID=\"%s\">\n%s\t</cim:DopInstruction>".format (id, export_fields)
    }
}

object DopInstruction
extends
    CIMParseable[DopInstruction]
{
    override val fields: Array[String] = Array[String] (
        "mwDOP",
        "plotPriority",
        "runIndicatorDOP",
        "timestampDOP",
        "updateTimeStamp",
        "updateType",
        "updateUser",
        "InstructionClearingDOP",
        "RegisteredResouce"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("InstructionClearingDOP", "InstructionClearingDOP", "1..*", "1..*"),
        CIMRelationship ("RegisteredResouce", "RegisteredResource", "0..1", "0..*")
    )
    val mwDOP: Fielder = parse_element (element (cls, fields(0)))
    val plotPriority: Fielder = parse_element (element (cls, fields(1)))
    val runIndicatorDOP: Fielder = parse_attribute (attribute (cls, fields(2)))
    val timestampDOP: Fielder = parse_element (element (cls, fields(3)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(4)))
    val updateType: Fielder = parse_attribute (attribute (cls, fields(5)))
    val updateUser: Fielder = parse_element (element (cls, fields(6)))
    val InstructionClearingDOP: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val RegisteredResouce: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: CIMContext): DopInstruction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DopInstruction (
            BasicElement.parse (context),
            toDouble (mask (mwDOP (), 0)),
            toInteger (mask (plotPriority (), 1)),
            mask (runIndicatorDOP (), 2),
            mask (timestampDOP (), 3),
            mask (updateTimeStamp (), 4),
            mask (updateType (), 5),
            mask (updateUser (), 6),
            masks (InstructionClearingDOP (), 7),
            mask (RegisteredResouce (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Provides the necessary information (on a resource basis) to capture the Dispatch Operating Target (DOT) results on a Dispatch interval.
 *
 * This information is only relevant to the RT interval market.
 *
 * @param Element Reference to the superclass object.
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
 * @param InstructionClearingDOT [[ch.ninecode.model.InstructionClearingDOT InstructionClearingDOT]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class DotInstruction
(
    Element: BasicElement = null,
    actualRampRate: Double = 0.0,
    compliantIndicator: String = null,
    economicMaxOverride: Double = 0.0,
    expectedEnergy: Double = 0.0,
    generatorPerformanceDegree: Double = 0.0,
    hourAheadSchedEnergy: Double = 0.0,
    hourlySchedule: Double = 0.0,
    instructionTime: String = null,
    maximumEmergencyInd: Boolean = false,
    meterLoadFollowing: Double = 0.0,
    nonRampRestrictedMW: Double = 0.0,
    nonSpinReserve: Double = 0.0,
    previousDOTTimeStamp: String = null,
    rampRateLimit: Double = 0.0,
    regulationStatus: String = null,
    spinReserve: Double = 0.0,
    standardRampEnergy: Double = 0.0,
    supplementalEnergy: Double = 0.0,
    unitStatus: Int = 0,
    DOT: Double = 0.0,
    InstructionClearingDOT: List[String] = null,
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
        implicit val clz: String = DotInstruction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DotInstruction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DotInstruction.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DotInstruction.fields (position), x))
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
        emitattrs (20, InstructionClearingDOT)
        emitattr (21, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DotInstruction rdf:ID=\"%s\">\n%s\t</cim:DotInstruction>".format (id, export_fields)
    }
}

object DotInstruction
extends
    CIMParseable[DotInstruction]
{
    override val fields: Array[String] = Array[String] (
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
        "InstructionClearingDOT",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("InstructionClearingDOT", "InstructionClearingDOT", "1..*", "1..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*")
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
    val InstructionClearingDOT: FielderMultiple = parse_attributes (attribute (cls, fields(20)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(21)))

    def parse (context: CIMContext): DotInstruction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
            masks (InstructionClearingDOT (), 20),
            mask (RegisteredResource (), 21)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of ex-post calcultion of MW losses.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param ExPostLossResults [[ch.ninecode.model.ExPostLossResults ExPostLossResults]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class ExPostLoss
(
    MarketFactors: MarketFactors = null,
    ExPostLossResults: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = ExPostLoss.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ExPostLoss.fields (position), x))
        emitattrs (0, ExPostLossResults)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExPostLoss rdf:ID=\"%s\">\n%s\t</cim:ExPostLoss>".format (id, export_fields)
    }
}

object ExPostLoss
extends
    CIMParseable[ExPostLoss]
{
    override val fields: Array[String] = Array[String] (
        "ExPostLossResults"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ExPostLossResults", "ExPostLossResults", "0..*", "1")
    )
    val ExPostLossResults: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): ExPostLoss =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ExPostLoss (
            MarketFactors.parse (context),
            masks (ExPostLossResults (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model results of ex-post calculation of MW losses.
 *
 * Summarizes loss in two categories losses on the the extra high voltage transmission and total losses. Calculated for each subcontrol area.
 *
 * @param Element Reference to the superclass object.
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
final case class ExPostLossResults
(
    Element: BasicElement = null,
    ehvLossMW: Double = 0.0,
    totalLossMW: Double = 0.0,
    ExPostLoss: String = null,
    SubControlArea: String = null
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
    CIMParseable[ExPostLossResults]
{
    override val fields: Array[String] = Array[String] (
        "ehvLossMW",
        "totalLossMW",
        "ExPostLoss",
        "SubControlArea"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ExPostLoss", "ExPostLoss", "1", "0..*"),
        CIMRelationship ("SubControlArea", "SubControlArea", "0..1", "0..*")
    )
    val ehvLossMW: Fielder = parse_element (element (cls, fields(0)))
    val totalLossMW: Fielder = parse_element (element (cls, fields(1)))
    val ExPostLoss: Fielder = parse_attribute (attribute (cls, fields(2)))
    val SubControlArea: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): ExPostLossResults =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Model of ex-post calculation of cleared MW on a regional basis.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param ExPostMarketRegionResults [[ch.ninecode.model.ExPostMarketRegionResults ExPostMarketRegionResults]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class ExPostMarketRegion
(
    MarketFactors: MarketFactors = null,
    ExPostMarketRegionResults: String = null
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
    override def sup: MarketFactors = MarketFactors

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
    CIMParseable[ExPostMarketRegion]
{
    override val fields: Array[String] = Array[String] (
        "ExPostMarketRegionResults"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ExPostMarketRegionResults", "ExPostMarketRegionResults", "0..1", "1")
    )
    val ExPostMarketRegionResults: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): ExPostMarketRegion =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ExPostMarketRegion (
            MarketFactors.parse (context),
            mask (ExPostMarketRegionResults (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of expost calculation of cleared MW on a region basis.
 *
 * Includes cleared price.
 *
 * @param Element Reference to the superclass object.
 * @param exPostClearedPrice <em>undocumented</em>
 * @param ExPostMarketRegion [[ch.ninecode.model.ExPostMarketRegion ExPostMarketRegion]] <em>undocumented</em>
 * @param MarketRegion [[ch.ninecode.model.MarketRegion MarketRegion]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class ExPostMarketRegionResults
(
    Element: BasicElement = null,
    exPostClearedPrice: Double = 0.0,
    ExPostMarketRegion: String = null,
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
    CIMParseable[ExPostMarketRegionResults]
{
    override val fields: Array[String] = Array[String] (
        "exPostClearedPrice",
        "ExPostMarketRegion",
        "MarketRegion"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ExPostMarketRegion", "ExPostMarketRegion", "1", "0..1"),
        CIMRelationship ("MarketRegion", "MarketRegion", "1", "0..*")
    )
    val exPostClearedPrice: Fielder = parse_element (element (cls, fields(0)))
    val ExPostMarketRegion: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MarketRegion: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): ExPostMarketRegionResults =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ExPostMarketRegionResults (
            BasicElement.parse (context),
            toDouble (mask (exPostClearedPrice (), 0)),
            mask (ExPostMarketRegion (), 1),
            mask (MarketRegion (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of ex-post pricing of nodes.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param energyPrice market energy price
 * @param ExPostResults [[ch.ninecode.model.ExPostPricingResults ExPostPricingResults]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class ExPostPricing
(
    MarketFactors: MarketFactors = null,
    energyPrice: Double = 0.0,
    ExPostResults: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = ExPostPricing.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExPostPricing.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ExPostPricing.fields (position), x))
        emitelem (0, energyPrice)
        emitattrs (1, ExPostResults)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExPostPricing rdf:ID=\"%s\">\n%s\t</cim:ExPostPricing>".format (id, export_fields)
    }
}

object ExPostPricing
extends
    CIMParseable[ExPostPricing]
{
    override val fields: Array[String] = Array[String] (
        "energyPrice",
        "ExPostResults"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ExPostResults", "ExPostPricingResults", "0..*", "1")
    )
    val energyPrice: Fielder = parse_element (element (cls, fields(0)))
    val ExPostResults: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): ExPostPricing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ExPostPricing (
            MarketFactors.parse (context),
            toDouble (mask (energyPrice (), 0)),
            masks (ExPostResults (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of ex-post pricing of nodes.
 *
 * Includes LMP information, pnode based.
 *
 * @param Element Reference to the superclass object.
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
final case class ExPostPricingResults
(
    Element: BasicElement = null,
    congestLMP: Double = 0.0,
    lmp: Double = 0.0,
    lossLMP: Double = 0.0,
    ExPostPricing: String = null,
    Pnode: String = null
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
    CIMParseable[ExPostPricingResults]
{
    override val fields: Array[String] = Array[String] (
        "congestLMP",
        "lmp",
        "lossLMP",
        "ExPostPricing",
        "Pnode"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ExPostPricing", "ExPostPricing", "1", "0..*"),
        CIMRelationship ("Pnode", "Pnode", "1", "0..*")
    )
    val congestLMP: Fielder = parse_element (element (cls, fields(0)))
    val lmp: Fielder = parse_element (element (cls, fields(1)))
    val lossLMP: Fielder = parse_element (element (cls, fields(2)))
    val ExPostPricing: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Pnode: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): ExPostPricingResults =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Model of ex-post pricing of resources.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param ExPostResourceResults [[ch.ninecode.model.ExPostResourceResults ExPostResourceResults]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class ExPostResource
(
    MarketFactors: MarketFactors = null,
    ExPostResourceResults: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = ExPostResource.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ExPostResource.fields (position), x))
        emitattrs (0, ExPostResourceResults)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExPostResource rdf:ID=\"%s\">\n%s\t</cim:ExPostResource>".format (id, export_fields)
    }
}

object ExPostResource
extends
    CIMParseable[ExPostResource]
{
    override val fields: Array[String] = Array[String] (
        "ExPostResourceResults"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ExPostResourceResults", "ExPostResourceResults", "0..*", "1")
    )
    val ExPostResourceResults: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): ExPostResource =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ExPostResource (
            MarketFactors.parse (context),
            masks (ExPostResourceResults (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of ex-post pricing of resources contains components of LMPs: energy, congestion, loss.
 *
 * Resource based.
 *
 * @param Element Reference to the superclass object.
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
final case class ExPostResourceResults
(
    Element: BasicElement = null,
    congestionLMP: Double = 0.0,
    desiredMW: Double = 0.0,
    dispatchRate: Double = 0.0,
    lmp: Double = 0.0,
    lossLMP: Double = 0.0,
    maxEconomicMW: Double = 0.0,
    minEconomicMW: Double = 0.0,
    resourceMW: Double = 0.0,
    status: String = null,
    ExPostResource: String = null,
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
    CIMParseable[ExPostResourceResults]
{
    override val fields: Array[String] = Array[String] (
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ExPostResource", "ExPostResource", "1", "0..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*")
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

    def parse (context: CIMContext): ExPostResourceResults =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Model of clearing result of the market run at the market level.
 *
 * Identifies interval.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param GeneralClearingResults [[ch.ninecode.model.GeneralClearingResults GeneralClearingResults]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class GeneralClearing
(
    MarketFactors: MarketFactors = null,
    GeneralClearingResults: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = GeneralClearing.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (GeneralClearing.fields (position), x))
        emitattrs (0, GeneralClearingResults)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GeneralClearing rdf:ID=\"%s\">\n%s\t</cim:GeneralClearing>".format (id, export_fields)
    }
}

object GeneralClearing
extends
    CIMParseable[GeneralClearing]
{
    override val fields: Array[String] = Array[String] (
        "GeneralClearingResults"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("GeneralClearingResults", "GeneralClearingResults", "0..*", "0..1")
    )
    val GeneralClearingResults: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): GeneralClearing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GeneralClearing (
            MarketFactors.parse (context),
            masks (GeneralClearingResults (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Provides the adjusted load forecast value on a load forecast zone basis.
 *
 * @param Element Reference to the superclass object.
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
final case class GeneralClearingResults
(
    Element: BasicElement = null,
    loadForecast: Double = 0.0,
    totalLoad: Double = 0.0,
    totalNetInterchange: Double = 0.0,
    GeneralClearing: String = null,
    SubControlArea: String = null
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
    CIMParseable[GeneralClearingResults]
{
    override val fields: Array[String] = Array[String] (
        "loadForecast",
        "totalLoad",
        "totalNetInterchange",
        "GeneralClearing",
        "SubControlArea"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("GeneralClearing", "GeneralClearing", "0..1", "0..*"),
        CIMRelationship ("SubControlArea", "SubControlArea", "0..1", "0..*")
    )
    val loadForecast: Fielder = parse_element (element (cls, fields(0)))
    val totalLoad: Fielder = parse_element (element (cls, fields(1)))
    val totalNetInterchange: Fielder = parse_element (element (cls, fields(2)))
    val GeneralClearing: Fielder = parse_attribute (attribute (cls, fields(3)))
    val SubControlArea: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): GeneralClearingResults =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Model of market clearing, relating to commitment instructions.
 *
 * Identifies interval.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param ActualDemandResponseEvent [[ch.ninecode.model.DistributedResourceActualEvent DistributedResourceActualEvent]] ActualDemandResponseEvents may exist that are not part of a cordinated MarketActualEvent associated to a Market.
 *        These ActualDemandResponseEvents can have many InstructionClearing Instructions for specified RegisteredResources or Distributed Energy Resource type of AggregateNodes.
 * @param Instructions [[ch.ninecode.model.Instructions Instructions]] <em>undocumented</em>
 * @param ResourceDeploymentStatus [[ch.ninecode.model.ResourceDeploymentStatus ResourceDeploymentStatus]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class InstructionClearing
(
    MarketFactors: MarketFactors = null,
    ActualDemandResponseEvent: String = null,
    Instructions: List[String] = null,
    ResourceDeploymentStatus: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = InstructionClearing.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (InstructionClearing.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (InstructionClearing.fields (position), x))
        emitattr (0, ActualDemandResponseEvent)
        emitattrs (1, Instructions)
        emitattrs (2, ResourceDeploymentStatus)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InstructionClearing rdf:ID=\"%s\">\n%s\t</cim:InstructionClearing>".format (id, export_fields)
    }
}

object InstructionClearing
extends
    CIMParseable[InstructionClearing]
{
    override val fields: Array[String] = Array[String] (
        "ActualDemandResponseEvent",
        "Instructions",
        "ResourceDeploymentStatus"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ActualDemandResponseEvent", "DistributedResourceActualEvent", "0..1", "0..*"),
        CIMRelationship ("Instructions", "Instructions", "1..*", "1..*"),
        CIMRelationship ("ResourceDeploymentStatus", "ResourceDeploymentStatus", "0..*", "0..1")
    )
    val ActualDemandResponseEvent: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Instructions: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ResourceDeploymentStatus: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): InstructionClearing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = InstructionClearing (
            MarketFactors.parse (context),
            mask (ActualDemandResponseEvent (), 0),
            masks (Instructions (), 1),
            masks (ResourceDeploymentStatus (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of market clearing, related to Dispatch Operating Point.
 *
 * Identifies interval.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param DopInstruction [[ch.ninecode.model.DopInstruction DopInstruction]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class InstructionClearingDOP
(
    MarketFactors: MarketFactors = null,
    DopInstruction: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = InstructionClearingDOP.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (InstructionClearingDOP.fields (position), x))
        emitattrs (0, DopInstruction)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InstructionClearingDOP rdf:ID=\"%s\">\n%s\t</cim:InstructionClearingDOP>".format (id, export_fields)
    }
}

object InstructionClearingDOP
extends
    CIMParseable[InstructionClearingDOP]
{
    override val fields: Array[String] = Array[String] (
        "DopInstruction"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DopInstruction", "DopInstruction", "1..*", "1..*")
    )
    val DopInstruction: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): InstructionClearingDOP =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = InstructionClearingDOP (
            MarketFactors.parse (context),
            masks (DopInstruction (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of market clearing, related to Dispatch Operating Target (model of anticipatory dispatch).
 *
 * Identifies interval.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param contingencyActive Indication that the system is currently operating in a contingency mode.
 * @param dispatchMode <em>undocumented</em>
 * @param DemandResponseActualEvent [[ch.ninecode.model.DistributedResourceActualEvent DistributedResourceActualEvent]] <em>undocumented</em>
 * @param DotInstruction [[ch.ninecode.model.DotInstruction DotInstruction]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class InstructionClearingDOT
(
    MarketFactors: MarketFactors = null,
    contingencyActive: String = null,
    dispatchMode: String = null,
    DemandResponseActualEvent: String = null,
    DotInstruction: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = InstructionClearingDOT.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (InstructionClearingDOT.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (InstructionClearingDOT.fields (position), x))
        emitattr (0, contingencyActive)
        emitattr (1, dispatchMode)
        emitattr (2, DemandResponseActualEvent)
        emitattrs (3, DotInstruction)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InstructionClearingDOT rdf:ID=\"%s\">\n%s\t</cim:InstructionClearingDOT>".format (id, export_fields)
    }
}

object InstructionClearingDOT
extends
    CIMParseable[InstructionClearingDOT]
{
    override val fields: Array[String] = Array[String] (
        "contingencyActive",
        "dispatchMode",
        "DemandResponseActualEvent",
        "DotInstruction"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DemandResponseActualEvent", "DistributedResourceActualEvent", "0..1", "0..*"),
        CIMRelationship ("DotInstruction", "DotInstruction", "1..*", "1..*")
    )
    val contingencyActive: Fielder = parse_attribute (attribute (cls, fields(0)))
    val dispatchMode: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DemandResponseActualEvent: Fielder = parse_attribute (attribute (cls, fields(2)))
    val DotInstruction: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): InstructionClearingDOT =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = InstructionClearingDOT (
            MarketFactors.parse (context),
            mask (contingencyActive (), 0),
            mask (dispatchMode (), 1),
            mask (DemandResponseActualEvent (), 2),
            masks (DotInstruction (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Provides the necessary information (on a resource basis) to capture the Startup/Shutdown instruction results.
 *
 * This information is relevant to the DA Market (RUC only) as well as the RT Market (HASP, Pre-dispatch, and Interval).
 *
 * @param Element Reference to the superclass object.
 * @param bindingDOD Binding dispatch operating delta provides a relative delta to be applied.
 *        Typically used in demand response instructions. The binding<font color="#0f0f0f">DOD instructions are cumulative; in other words a second DOD instruction does not replace the previous DOD, instead the second DOD adds to the previous DODs.</font>
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
 *        
 *        This is a combination of StartUp time bid and Unit down time.
 *        
 *        Units is minutes
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param AggregateNode [[ch.ninecode.model.AggregateNode AggregateNode]] <em>undocumented</em>
 * @param InstructionClearing [[ch.ninecode.model.InstructionClearing InstructionClearing]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class Instructions
(
    Element: BasicElement = null,
    bindingDOD: Double = 0.0,
    bindingDOT: Double = 0.0,
    bindingInstruction: String = null,
    instructionCost: Double = 0.0,
    instructionSource: String = null,
    instructionStartTime: String = null,
    instructionType: String = null,
    manuallyBlocked: String = null,
    minStatusChangeTime: Int = 0,
    updateTimeStamp: String = null,
    updateType: String = null,
    updateUser: String = null,
    AggregateNode: String = null,
    InstructionClearing: List[String] = null,
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
        implicit val clz: String = Instructions.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Instructions.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Instructions.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Instructions.fields (position), x))
        emitelem (0, bindingDOD)
        emitelem (1, bindingDOT)
        emitattr (2, bindingInstruction)
        emitelem (3, instructionCost)
        emitattr (4, instructionSource)
        emitelem (5, instructionStartTime)
        emitattr (6, instructionType)
        emitattr (7, manuallyBlocked)
        emitelem (8, minStatusChangeTime)
        emitelem (9, updateTimeStamp)
        emitattr (10, updateType)
        emitelem (11, updateUser)
        emitattr (12, AggregateNode)
        emitattrs (13, InstructionClearing)
        emitattr (14, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Instructions rdf:ID=\"%s\">\n%s\t</cim:Instructions>".format (id, export_fields)
    }
}

object Instructions
extends
    CIMParseable[Instructions]
{
    override val fields: Array[String] = Array[String] (
        "bindingDOD",
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
        "AggregateNode",
        "InstructionClearing",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AggregateNode", "AggregateNode", "0..1", "0..*"),
        CIMRelationship ("InstructionClearing", "InstructionClearing", "1..*", "1..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "1", "0..*")
    )
    val bindingDOD: Fielder = parse_element (element (cls, fields(0)))
    val bindingDOT: Fielder = parse_element (element (cls, fields(1)))
    val bindingInstruction: Fielder = parse_attribute (attribute (cls, fields(2)))
    val instructionCost: Fielder = parse_element (element (cls, fields(3)))
    val instructionSource: Fielder = parse_attribute (attribute (cls, fields(4)))
    val instructionStartTime: Fielder = parse_element (element (cls, fields(5)))
    val instructionType: Fielder = parse_attribute (attribute (cls, fields(6)))
    val manuallyBlocked: Fielder = parse_attribute (attribute (cls, fields(7)))
    val minStatusChangeTime: Fielder = parse_element (element (cls, fields(8)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(9)))
    val updateType: Fielder = parse_attribute (attribute (cls, fields(10)))
    val updateUser: Fielder = parse_element (element (cls, fields(11)))
    val AggregateNode: Fielder = parse_attribute (attribute (cls, fields(12)))
    val InstructionClearing: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(14)))

    def parse (context: CIMContext): Instructions =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Instructions (
            BasicElement.parse (context),
            toDouble (mask (bindingDOD (), 0)),
            toDouble (mask (bindingDOT (), 1)),
            mask (bindingInstruction (), 2),
            toDouble (mask (instructionCost (), 3)),
            mask (instructionSource (), 4),
            mask (instructionStartTime (), 5),
            mask (instructionType (), 6),
            mask (manuallyBlocked (), 7),
            toInteger (mask (minStatusChangeTime (), 8)),
            mask (updateTimeStamp (), 9),
            mask (updateType (), 10),
            mask (updateUser (), 11),
            mask (AggregateNode (), 12),
            masks (InstructionClearing (), 13),
            mask (RegisteredResource (), 14)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of load following capabilities that are entered by operators on a temporary basis.
 *
 * Related to Registered Resources in Metered Subsystems.
 *
 * @param Element Reference to the superclass object.
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
final case class LoadFollowingOperatorInput
(
    Element: BasicElement = null,
    dataEntryTimeStamp: String = null,
    tempLoadFollowingDownManualCap: Double = 0.0,
    tempLoadFollowingUpManualCap: Double = 0.0,
    updateTimeStamp: String = null,
    updateType: String = null,
    updateUser: String = null,
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
    CIMParseable[LoadFollowingOperatorInput]
{
    override val fields: Array[String] = Array[String] (
        "dataEntryTimeStamp",
        "tempLoadFollowingDownManualCap",
        "tempLoadFollowingUpManualCap",
        "updateTimeStamp",
        "updateType",
        "updateUser",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*")
    )
    val dataEntryTimeStamp: Fielder = parse_element (element (cls, fields(0)))
    val tempLoadFollowingDownManualCap: Fielder = parse_element (element (cls, fields(1)))
    val tempLoadFollowingUpManualCap: Fielder = parse_element (element (cls, fields(2)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(3)))
    val updateType: Fielder = parse_attribute (attribute (cls, fields(4)))
    val updateUser: Fielder = parse_element (element (cls, fields(5)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): LoadFollowingOperatorInput =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * RT only and is published on 5 minute intervals for the previous RT time interval results.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param LossClearingResults [[ch.ninecode.model.LossClearingResults LossClearingResults]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class LossClearing
(
    MarketFactors: MarketFactors = null,
    LossClearingResults: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = LossClearing.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (LossClearing.fields (position), x))
        emitattrs (0, LossClearingResults)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LossClearing rdf:ID=\"%s\">\n%s\t</cim:LossClearing>".format (id, export_fields)
    }
}

object LossClearing
extends
    CIMParseable[LossClearing]
{
    override val fields: Array[String] = Array[String] (
        "LossClearingResults"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("LossClearingResults", "LossClearingResults", "0..*", "0..1")
    )
    val LossClearingResults: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): LossClearing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LossClearing (
            MarketFactors.parse (context),
            masks (LossClearingResults (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Provides the MW loss for RUC Zones, subcontrol areas, and the total loss.
 *
 * @param Element Reference to the superclass object.
 * @param lossMW <em>undocumented</em>
 * @param HostControlArea [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param LossClearing [[ch.ninecode.model.LossClearing LossClearing]] <em>undocumented</em>
 * @param RUCZone [[ch.ninecode.model.RUCZone RUCZone]] <em>undocumented</em>
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class LossClearingResults
(
    Element: BasicElement = null,
    lossMW: Double = 0.0,
    HostControlArea: String = null,
    LossClearing: String = null,
    RUCZone: String = null,
    SubControlArea: String = null
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
    CIMParseable[LossClearingResults]
{
    override val fields: Array[String] = Array[String] (
        "lossMW",
        "HostControlArea",
        "LossClearing",
        "RUCZone",
        "SubControlArea"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("HostControlArea", "HostControlArea", "0..1", "0..*"),
        CIMRelationship ("LossClearing", "LossClearing", "0..1", "0..*"),
        CIMRelationship ("RUCZone", "RUCZone", "0..1", "0..*"),
        CIMRelationship ("SubControlArea", "SubControlArea", "0..1", "1..*")
    )
    val lossMW: Fielder = parse_element (element (cls, fields(0)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields(1)))
    val LossClearing: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RUCZone: Fielder = parse_attribute (attribute (cls, fields(3)))
    val SubControlArea: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): LossClearingResults =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Model of results of Market Power tests, and possible mitigation.
 *
 * Interval based.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param mitigationOccuredFlag <em>undocumented</em>
 * @param LMPMFinalFlag <em>undocumented</em>
 * @param MPMTestResults [[ch.ninecode.model.MPMTestResults MPMTestResults]] <em>undocumented</em>
 * @param SMPMFinalFlag <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class MPMClearing
(
    MarketFactors: MarketFactors = null,
    mitigationOccuredFlag: String = null,
    LMPMFinalFlag: String = null,
    MPMTestResults: List[String] = null,
    SMPMFinalFlag: String = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = MPMClearing.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MPMClearing.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MPMClearing.fields (position), x))
        emitattr (0, mitigationOccuredFlag)
        emitattr (1, LMPMFinalFlag)
        emitattrs (2, MPMTestResults)
        emitattr (3, SMPMFinalFlag)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MPMClearing rdf:ID=\"%s\">\n%s\t</cim:MPMClearing>".format (id, export_fields)
    }
}

object MPMClearing
extends
    CIMParseable[MPMClearing]
{
    override val fields: Array[String] = Array[String] (
        "mitigationOccuredFlag",
        "LMPMFinalFlag",
        "MPMTestResults",
        "SMPMFinalFlag"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MPMTestResults", "MPMTestResults", "0..*", "0..1")
    )
    val mitigationOccuredFlag: Fielder = parse_attribute (attribute (cls, fields(0)))
    val LMPMFinalFlag: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MPMTestResults: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val SMPMFinalFlag: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): MPMClearing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MPMClearing (
            MarketFactors.parse (context),
            mask (mitigationOccuredFlag (), 0),
            mask (LMPMFinalFlag (), 1),
            masks (MPMTestResults (), 2),
            mask (SMPMFinalFlag (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of results of Market Power tests, gives status of resource for the associated interval.
 *
 * @param Element Reference to the superclass object.
 * @param resourceStatus Interval Test Status
 *        'N' - not applicable
 * @param MPMTestCategory [[ch.ninecode.model.MPMTestCategory MPMTestCategory]] <em>undocumented</em>
 * @param MitigatedBidClearing [[ch.ninecode.model.MitigatedBidClearing MitigatedBidClearing]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class MPMResourceStatus
(
    Element: BasicElement = null,
    resourceStatus: String = null,
    MPMTestCategory: String = null,
    MitigatedBidClearing: List[String] = null,
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
        implicit val clz: String = MPMResourceStatus.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MPMResourceStatus.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MPMResourceStatus.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MPMResourceStatus.fields (position), x))
        emitelem (0, resourceStatus)
        emitattr (1, MPMTestCategory)
        emitattrs (2, MitigatedBidClearing)
        emitattr (3, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MPMResourceStatus rdf:ID=\"%s\">\n%s\t</cim:MPMResourceStatus>".format (id, export_fields)
    }
}

object MPMResourceStatus
extends
    CIMParseable[MPMResourceStatus]
{
    override val fields: Array[String] = Array[String] (
        "resourceStatus",
        "MPMTestCategory",
        "MitigatedBidClearing",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MPMTestCategory", "MPMTestCategory", "1", "0..*"),
        CIMRelationship ("MitigatedBidClearing", "MitigatedBidClearing", "1..*", "0..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*")
    )
    val resourceStatus: Fielder = parse_element (element (cls, fields(0)))
    val MPMTestCategory: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MitigatedBidClearing: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): MPMResourceStatus =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MPMResourceStatus (
            BasicElement.parse (context),
            mask (resourceStatus (), 0),
            mask (MPMTestCategory (), 1),
            masks (MitigatedBidClearing (), 2),
            mask (RegisteredResource (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Provides the outcome and margin percent (as appropriate) result data for the MPM tests.
 *
 * There are relationships to Zone for Designated Congestion Area Tests, CurveSchedData for bid segment tests, to the SubControlArea for the system wide level tests, and Pnodes for the LMPM impact tests.
 *
 * @param Element Reference to the superclass object.
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
final case class MPMTestResults
(
    Element: BasicElement = null,
    marginPercent: Double = 0.0,
    outcome: String = null,
    AggregatedPnode: String = null,
    MPMClearing: String = null,
    MPMTestCategory: String = null
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
    CIMParseable[MPMTestResults]
{
    override val fields: Array[String] = Array[String] (
        "marginPercent",
        "outcome",
        "AggregatedPnode",
        "MPMClearing",
        "MPMTestCategory"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AggregatedPnode", "AggregatedPnode", "1", "1..*"),
        CIMRelationship ("MPMClearing", "MPMClearing", "0..1", "0..*"),
        CIMRelationship ("MPMTestCategory", "MPMTestCategory", "1", "0..*")
    )
    val marginPercent: Fielder = parse_element (element (cls, fields(0)))
    val outcome: Fielder = parse_attribute (attribute (cls, fields(1)))
    val AggregatedPnode: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MPMClearing: Fielder = parse_attribute (attribute (cls, fields(3)))
    val MPMTestCategory: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): MPMTestResults =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Provides all Region Ancillary Service results for the DA and RT markets.
 *
 * The specific data is commodity type (Regulation Up, Regulation Down, Spinning Reserve, Non-spinning Reserve, or Total Up reserves) based for the cleared MW, cleared price, and total capacity required for the region.
 *
 * @param Element Reference to the superclass object.
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
final case class MarketRegionResults
(
    Element: BasicElement = null,
    clearedMW: Double = 0.0,
    clearedPrice: Double = 0.0,
    dispatchCtMW: Double = 0.0,
    dispatchHydroMW: Double = 0.0,
    dispatchRate: Double = 0.0,
    dispatchSteamMW: Double = 0.0,
    imbalanceEnergyBias: Double = 0.0,
    limitFlag: String = null,
    lumpyIndicator: String = null,
    maxSufficiencyIndex: Double = 0.0,
    minSufficiencyIndex: Double = 0.0,
    reqMaxMW: Double = 0.0,
    reqMinMW: Double = 0.0,
    selfScheduleMW: Double = 0.0,
    AncillaryServiceClearing: String = null,
    MarketProduct: String = null,
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
    CIMParseable[MarketRegionResults]
{
    override val fields: Array[String] = Array[String] (
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AncillaryServiceClearing", "AncillaryServiceClearing", "0..1", "1..*"),
        CIMRelationship ("MarketProduct", "MarketProduct", "0..1", "0..1"),
        CIMRelationship ("MarketRegion", "MarketRegion", "1", "1..*")
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

    def parse (context: CIMContext): MarketRegionResults =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * This class holds elements that are single values for the entire market time horizon.
 *
 * That is, for the Day Ahead market, there is 1 value for each element, not hourly based.  Is a summary of the market run.
 *
 * @param Element Reference to the superclass object.
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
final case class MarketResults
(
    Element: BasicElement = null,
    ancillarySvcCost: Double = 0.0,
    contingentOperatingResAvail: String = null,
    energyCost: Double = 0.0,
    minimumLoadCost: Double = 0.0,
    startUpCost: Double = 0.0,
    totalCost: Double = 0.0,
    totalRucCost: Double = 0.0,
    EnergyMarket: String = null
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
    CIMParseable[MarketResults]
{
    override val fields: Array[String] = Array[String] (
        "ancillarySvcCost",
        "contingentOperatingResAvail",
        "energyCost",
        "minimumLoadCost",
        "startUpCost",
        "totalCost",
        "totalRucCost",
        "EnergyMarket"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnergyMarket", "EnergyMarket", "1", "0..1")
    )
    val ancillarySvcCost: Fielder = parse_element (element (cls, fields(0)))
    val contingentOperatingResAvail: Fielder = parse_attribute (attribute (cls, fields(1)))
    val energyCost: Fielder = parse_element (element (cls, fields(2)))
    val minimumLoadCost: Fielder = parse_element (element (cls, fields(3)))
    val startUpCost: Fielder = parse_element (element (cls, fields(4)))
    val totalCost: Fielder = parse_element (element (cls, fields(5)))
    val totalRucCost: Fielder = parse_element (element (cls, fields(6)))
    val EnergyMarket: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: CIMContext): MarketResults =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * A statement is a roll up of statement line items.
 *
 * Each statement along with its line items provide the details of specific charges at any given time.  Used by Billing and Settlement.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param end The end of a bill period.
 * @param referenceNumber The version number of previous statement (in the case of true up).
 * @param start The start of a bill period.
 * @param tradeDate The date of which Settlement is run.
 * @param transactionDate The date of which this statement is issued.
 * @param MarketStatementLineItem [[ch.ninecode.model.MarketStatementLineItem MarketStatementLineItem]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class MarketStatement
(
    Document: Document = null,
    end: String = null,
    referenceNumber: String = null,
    start: String = null,
    tradeDate: String = null,
    transactionDate: String = null,
    MarketStatementLineItem: List[String] = null
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
        implicit val clz: String = MarketStatement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketStatement.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketStatement.fields (position), x))
        emitelem (0, end)
        emitelem (1, referenceNumber)
        emitelem (2, start)
        emitelem (3, tradeDate)
        emitelem (4, transactionDate)
        emitattrs (5, MarketStatementLineItem)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketStatement rdf:ID=\"%s\">\n%s\t</cim:MarketStatement>".format (id, export_fields)
    }
}

object MarketStatement
extends
    CIMParseable[MarketStatement]
{
    override val fields: Array[String] = Array[String] (
        "end",
        "referenceNumber",
        "start",
        "tradeDate",
        "transactionDate",
        "MarketStatementLineItem"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MarketStatementLineItem", "MarketStatementLineItem", "0..*", "1")
    )
    val end: Fielder = parse_element (element (cls, fields(0)))
    val referenceNumber: Fielder = parse_element (element (cls, fields(1)))
    val start: Fielder = parse_element (element (cls, fields(2)))
    val tradeDate: Fielder = parse_element (element (cls, fields(3)))
    val transactionDate: Fielder = parse_element (element (cls, fields(4)))
    val MarketStatementLineItem: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: CIMContext): MarketStatement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketStatement (
            Document.parse (context),
            mask (end (), 0),
            mask (referenceNumber (), 1),
            mask (start (), 2),
            mask (tradeDate (), 3),
            mask (transactionDate (), 4),
            masks (MarketStatementLineItem (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An individual line item on an ISO settlement statement.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
 * @param previousPrice Previous settlement price.
 * @param previousQuantity Previous settlement quantity, subject to the UOM.
 * @param quantityUOM The unit of measure for the quantity element of the line item.
 * @param ComponentMarketStatementLineItem [[ch.ninecode.model.MarketStatementLineItem MarketStatementLineItem]] <em>undocumented</em>
 * @param ContainerMarketStatementLineItem [[ch.ninecode.model.MarketStatementLineItem MarketStatementLineItem]] <em>undocumented</em>
 * @param MarketStatement [[ch.ninecode.model.MarketStatement MarketStatement]] <em>undocumented</em>
 * @param MktUserAttribute [[ch.ninecode.model.MktUserAttribute MktUserAttribute]] <em>undocumented</em>
 * @param PassThroughBill [[ch.ninecode.model.PassThroughBill PassThroughBill]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class MarketStatementLineItem
(
    IdentifiedObject: IdentifiedObject = null,
    currentAmount: Double = 0.0,
    currentISOAmount: Double = 0.0,
    currentISOQuantity: Double = 0.0,
    currentPrice: Double = 0.0,
    currentQuantity: Double = 0.0,
    intervalDate: String = null,
    intervalNumber: String = null,
    netAmount: Double = 0.0,
    netISOAmount: Double = 0.0,
    netISOQuantity: Double = 0.0,
    netPrice: Double = 0.0,
    netQuantity: Double = 0.0,
    previousAmount: Double = 0.0,
    previousISOAmount: Double = 0.0,
    previousISOQuantity: Double = 0.0,
    previousPrice: Double = 0.0,
    previousQuantity: Double = 0.0,
    quantityUOM: String = null,
    ComponentMarketStatementLineItem: List[String] = null,
    ContainerMarketStatementLineItem: String = null,
    MarketStatement: String = null,
    MktUserAttribute: List[String] = null,
    PassThroughBill: String = null
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
        implicit val clz: String = MarketStatementLineItem.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketStatementLineItem.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketStatementLineItem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MarketStatementLineItem.fields (position), x))
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
        emitelem (15, previousPrice)
        emitelem (16, previousQuantity)
        emitelem (17, quantityUOM)
        emitattrs (18, ComponentMarketStatementLineItem)
        emitattr (19, ContainerMarketStatementLineItem)
        emitattr (20, MarketStatement)
        emitattrs (21, MktUserAttribute)
        emitattr (22, PassThroughBill)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketStatementLineItem rdf:ID=\"%s\">\n%s\t</cim:MarketStatementLineItem>".format (id, export_fields)
    }
}

object MarketStatementLineItem
extends
    CIMParseable[MarketStatementLineItem]
{
    override val fields: Array[String] = Array[String] (
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
        "previousPrice",
        "previousQuantity",
        "quantityUOM",
        "ComponentMarketStatementLineItem",
        "ContainerMarketStatementLineItem",
        "MarketStatement",
        "MktUserAttribute",
        "PassThroughBill"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ComponentMarketStatementLineItem", "MarketStatementLineItem", "0..*", "0..1"),
        CIMRelationship ("ContainerMarketStatementLineItem", "MarketStatementLineItem", "0..1", "0..*"),
        CIMRelationship ("MarketStatement", "MarketStatement", "1", "0..*"),
        CIMRelationship ("MktUserAttribute", "MktUserAttribute", "0..*", "0..*"),
        CIMRelationship ("PassThroughBill", "PassThroughBill", "0..1", "0..1")
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
    val previousPrice: Fielder = parse_element (element (cls, fields(15)))
    val previousQuantity: Fielder = parse_element (element (cls, fields(16)))
    val quantityUOM: Fielder = parse_element (element (cls, fields(17)))
    val ComponentMarketStatementLineItem: FielderMultiple = parse_attributes (attribute (cls, fields(18)))
    val ContainerMarketStatementLineItem: Fielder = parse_attribute (attribute (cls, fields(19)))
    val MarketStatement: Fielder = parse_attribute (attribute (cls, fields(20)))
    val MktUserAttribute: FielderMultiple = parse_attributes (attribute (cls, fields(21)))
    val PassThroughBill: Fielder = parse_attribute (attribute (cls, fields(22)))

    def parse (context: CIMContext): MarketStatementLineItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
            toDouble (mask (previousPrice (), 15)),
            toDouble (mask (previousQuantity (), 16)),
            mask (quantityUOM (), 17),
            masks (ComponentMarketStatementLineItem (), 18),
            mask (ContainerMarketStatementLineItem (), 19),
            mask (MarketStatement (), 20),
            masks (MktUserAttribute (), 21),
            mask (PassThroughBill (), 22)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Mitigated bid results posted for a given settlement period.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Bid [[ch.ninecode.model.Bid Bid]] <em>undocumented</em>
 * @param MitigatedBidClearing [[ch.ninecode.model.MitigatedBidClearing MitigatedBidClearing]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class MitigatedBid
(
    IdentifiedObject: IdentifiedObject = null,
    Bid: String = null,
    MitigatedBidClearing: List[String] = null
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
        implicit val clz: String = MitigatedBid.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MitigatedBid.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MitigatedBid.fields (position), x))
        emitattr (0, Bid)
        emitattrs (1, MitigatedBidClearing)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MitigatedBid rdf:ID=\"%s\">\n%s\t</cim:MitigatedBid>".format (id, export_fields)
    }
}

object MitigatedBid
extends
    CIMParseable[MitigatedBid]
{
    override val fields: Array[String] = Array[String] (
        "Bid",
        "MitigatedBidClearing"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Bid", "Bid", "0..1", "0..*"),
        CIMRelationship ("MitigatedBidClearing", "MitigatedBidClearing", "1..*", "0..*")
    )
    val Bid: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MitigatedBidClearing: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): MitigatedBid =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MitigatedBid (
            IdentifiedObject.parse (context),
            mask (Bid (), 0),
            masks (MitigatedBidClearing (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of market power mitigation through reference or mitigated bids.
 *
 * Interval based.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param MPMResourceStatus [[ch.ninecode.model.MPMResourceStatus MPMResourceStatus]] <em>undocumented</em>
 * @param MitigatedBid [[ch.ninecode.model.MitigatedBid MitigatedBid]] <em>undocumented</em>
 * @param RMRDetermination [[ch.ninecode.model.RMRDetermination RMRDetermination]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class MitigatedBidClearing
(
    MarketFactors: MarketFactors = null,
    MPMResourceStatus: List[String] = null,
    MitigatedBid: List[String] = null,
    RMRDetermination: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = MitigatedBidClearing.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MitigatedBidClearing.fields (position), x))
        emitattrs (0, MPMResourceStatus)
        emitattrs (1, MitigatedBid)
        emitattrs (2, RMRDetermination)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MitigatedBidClearing rdf:ID=\"%s\">\n%s\t</cim:MitigatedBidClearing>".format (id, export_fields)
    }
}

object MitigatedBidClearing
extends
    CIMParseable[MitigatedBidClearing]
{
    override val fields: Array[String] = Array[String] (
        "MPMResourceStatus",
        "MitigatedBid",
        "RMRDetermination"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MPMResourceStatus", "MPMResourceStatus", "0..*", "1..*"),
        CIMRelationship ("MitigatedBid", "MitigatedBid", "0..*", "1..*"),
        CIMRelationship ("RMRDetermination", "RMRDetermination", "0..*", "1..*")
    )
    val MPMResourceStatus: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val MitigatedBid: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val RMRDetermination: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): MitigatedBidClearing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MitigatedBidClearing (
            MarketFactors.parse (context),
            masks (MPMResourceStatus (), 0),
            masks (MitigatedBid (), 1),
            masks (RMRDetermination (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of mitigated bid.
 *
 * Indicates segment of piece-wise linear bid, that has been mitigated.
 *
 * @param Element Reference to the superclass object.
 * @param intervalStartTime <em>undocumented</em>
 * @param segmentMW Mitigated bid segment MW value
 * @param segmentNumber Mitigated Bid Segment Number
 * @param thresholdType <em>undocumented</em>
 * @param Bid [[ch.ninecode.model.Bid Bid]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class MitigatedBidSegment
(
    Element: BasicElement = null,
    intervalStartTime: String = null,
    segmentMW: Double = 0.0,
    segmentNumber: Int = 0,
    thresholdType: String = null,
    Bid: String = null
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
    CIMParseable[MitigatedBidSegment]
{
    override val fields: Array[String] = Array[String] (
        "intervalStartTime",
        "segmentMW",
        "segmentNumber",
        "thresholdType",
        "Bid"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Bid", "Bid", "1", "0..*")
    )
    val intervalStartTime: Fielder = parse_element (element (cls, fields(0)))
    val segmentMW: Fielder = parse_element (element (cls, fields(1)))
    val segmentNumber: Fielder = parse_element (element (cls, fields(2)))
    val thresholdType: Fielder = parse_element (element (cls, fields(3)))
    val Bid: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): MitigatedBidSegment =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Pass Through Bill is used for:
 * 1)Two sided charge transactions with or without ISO involvement
 * 2) Specific direct charges or payments that are calculated outside or provided directly to settlements
 *
 * 3) Specific charge bill determinants that are externally supplied and used in charge calculations
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
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
 * @param ChargeProfiles [[ch.ninecode.model.ChargeProfile ChargeProfile]] <em>undocumented</em>
 * @param MarketStatementLineItem [[ch.ninecode.model.MarketStatementLineItem MarketStatementLineItem]] <em>undocumented</em>
 * @param MktUserAttribute [[ch.ninecode.model.MktUserAttribute MktUserAttribute]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class PassThroughBill
(
    Document: Document = null,
    adjustedAmount: Double = 0.0,
    amount: Double = 0.0,
    billEnd: String = null,
    billRunType: String = null,
    billStart: String = null,
    billedTo: String = null,
    effectiveDate: String = null,
    isDisputed: Boolean = false,
    isProfiled: Boolean = false,
    paidTo: String = null,
    previousEnd: String = null,
    previousStart: String = null,
    price: Double = 0.0,
    productCode: String = null,
    providedBy: String = null,
    quantity: String = null,
    serviceEnd: String = null,
    serviceStart: String = null,
    soldTo: String = null,
    taxAmount: Double = 0.0,
    timeZone: String = null,
    tradeDate: String = null,
    transactionDate: String = null,
    transactionType: String = null,
    ChargeProfiles: List[String] = null,
    MarketStatementLineItem: String = null,
    MktUserAttribute: List[String] = null
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
        implicit val clz: String = PassThroughBill.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PassThroughBill.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PassThroughBill.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PassThroughBill.fields (position), x))
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
        emitattrs (24, ChargeProfiles)
        emitattr (25, MarketStatementLineItem)
        emitattrs (26, MktUserAttribute)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PassThroughBill rdf:ID=\"%s\">\n%s\t</cim:PassThroughBill>".format (id, export_fields)
    }
}

object PassThroughBill
extends
    CIMParseable[PassThroughBill]
{
    override val fields: Array[String] = Array[String] (
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
        "ChargeProfiles",
        "MarketStatementLineItem",
        "MktUserAttribute"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ChargeProfiles", "ChargeProfile", "0..*", "0..1"),
        CIMRelationship ("MarketStatementLineItem", "MarketStatementLineItem", "0..1", "0..1"),
        CIMRelationship ("MktUserAttribute", "MktUserAttribute", "0..*", "0..*")
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
    val ChargeProfiles: FielderMultiple = parse_attributes (attribute (cls, fields(24)))
    val MarketStatementLineItem: Fielder = parse_attribute (attribute (cls, fields(25)))
    val MktUserAttribute: FielderMultiple = parse_attributes (attribute (cls, fields(26)))

    def parse (context: CIMContext): PassThroughBill =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
            masks (ChargeProfiles (), 24),
            mask (MarketStatementLineItem (), 25),
            masks (MktUserAttribute (), 26)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Pricing node clearing results posted for a given settlement period.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param CommodityPrice [[ch.ninecode.model.CommodityPrice CommodityPrice]] <em>undocumented</em>
 * @param PnodeResults [[ch.ninecode.model.PnodeResults PnodeResults]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class PnodeClearing
(
    MarketFactors: MarketFactors = null,
    CommodityPrice: List[String] = null,
    PnodeResults: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = PnodeClearing.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PnodeClearing.fields (position), x))
        emitattrs (0, CommodityPrice)
        emitattrs (1, PnodeResults)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PnodeClearing rdf:ID=\"%s\">\n%s\t</cim:PnodeClearing>".format (id, export_fields)
    }
}

object PnodeClearing
extends
    CIMParseable[PnodeClearing]
{
    override val fields: Array[String] = Array[String] (
        "CommodityPrice",
        "PnodeResults"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CommodityPrice", "CommodityPrice", "0..*", "0..1"),
        CIMRelationship ("PnodeResults", "PnodeResults", "1..*", "0..1")
    )
    val CommodityPrice: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val PnodeResults: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): PnodeClearing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PnodeClearing (
            MarketFactors.parse (context),
            masks (CommodityPrice (), 0),
            masks (PnodeResults (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Provides the total price, the cost component, the loss component, and the congestion component for Pnodes for the forward and real time markets.
 *
 * There are several prices produced based on the run type (MPM, RUC, Pricing, or Scheduling/Dispatch).
 *
 * @param Element Reference to the superclass object.
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
final case class PnodeResults
(
    Element: BasicElement = null,
    congestLMP: Double = 0.0,
    costLMP: Double = 0.0,
    lossLMP: Double = 0.0,
    marginalClearingPrice: Double = 0.0,
    scheduledMW: Double = 0.0,
    updateTimeStamp: String = null,
    updateType: String = null,
    updateUser: String = null,
    Pnode: String = null,
    PnodeClearing: String = null
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
    CIMParseable[PnodeResults]
{
    override val fields: Array[String] = Array[String] (
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Pnode", "Pnode", "0..1", "1..*"),
        CIMRelationship ("PnodeClearing", "PnodeClearing", "0..1", "1..*")
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

    def parse (context: CIMContext): PnodeResults =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * The price of a Commodity during a given time interval may change over time.
 *
 * For example, a price may be forecasted a year ahead, a month ahead, a day ahead, an hour ahead, and in real time; this is defined using the MarketType. Additionally a price may have one or more components. For example, a locational marginal energy price may be the arithmetic sum of the system price, the congestion price, and the loss price.  The priceType enumeration is used determine if the price is the complete price (priceType="total") or one of potentially many constituent components.
 *
 * @param Element Reference to the superclass object.
 * @param marketType The time frame for the price, using the standard conventions associated with the MarketType enumeration.
 * @param priceType The "kind" of price being described.
 *        In general, the priceType will either be "total" to signify that the price is the price paid to buy or sell the commodity, sometimes referred to as an "all-in" price, or one of potentially many components.
 * @param CommodityPrice [[ch.ninecode.model.CommodityPrice CommodityPrice]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class PriceDescriptor
(
    Element: BasicElement = null,
    marketType: String = null,
    priceType: String = null,
    CommodityPrice: List[String] = null
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
        implicit val clz: String = PriceDescriptor.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PriceDescriptor.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PriceDescriptor.fields (position), x))
        emitattr (0, marketType)
        emitattr (1, priceType)
        emitattrs (2, CommodityPrice)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PriceDescriptor rdf:ID=\"%s\">\n%s\t</cim:PriceDescriptor>".format (id, export_fields)
    }
}

object PriceDescriptor
extends
    CIMParseable[PriceDescriptor]
{
    override val fields: Array[String] = Array[String] (
        "marketType",
        "priceType",
        "CommodityPrice"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CommodityPrice", "CommodityPrice", "1..*", "1")
    )
    val marketType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val priceType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val CommodityPrice: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): PriceDescriptor =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PriceDescriptor (
            BasicElement.parse (context),
            mask (marketType (), 0),
            mask (priceType (), 1),
            masks (CommodityPrice (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Indicates whether unit is a reliablity must run unit: required to be on to satisfy Grid Code Reliablitiy criteria, load demand, or voltage support.
 *
 * @param Element Reference to the superclass object.
 * @param Bid [[ch.ninecode.model.Bid Bid]] <em>undocumented</em>
 * @param MitigatedBidClearing [[ch.ninecode.model.MitigatedBidClearing MitigatedBidClearing]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class RMRDetermination
(
    Element: BasicElement = null,
    Bid: String = null,
    MitigatedBidClearing: List[String] = null
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
        implicit val clz: String = RMRDetermination.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RMRDetermination.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RMRDetermination.fields (position), x))
        emitattr (0, Bid)
        emitattrs (1, MitigatedBidClearing)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RMRDetermination rdf:ID=\"%s\">\n%s\t</cim:RMRDetermination>".format (id, export_fields)
    }
}

object RMRDetermination
extends
    CIMParseable[RMRDetermination]
{
    override val fields: Array[String] = Array[String] (
        "Bid",
        "MitigatedBidClearing"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Bid", "Bid", "0..1", "0..*"),
        CIMRelationship ("MitigatedBidClearing", "MitigatedBidClearing", "1..*", "0..*")
    )
    val Bid: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MitigatedBidClearing: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): RMRDetermination =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RMRDetermination (
            BasicElement.parse (context),
            mask (Bid (), 0),
            masks (MitigatedBidClearing (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * RMR Operator's entry of the RMR requirement per market interval.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param manuallySchedRMRMw The lower of the original pre-dispatch or the AC run schedule (Also known as the RMR Reguirement) becomes the pre-dispatch value.
 * @param updateTimeStamp <em>undocumented</em>
 * @param updateType <em>undocumented</em>
 * @param updateUser <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class RMROperatorInput
(
    MarketFactors: MarketFactors = null,
    manuallySchedRMRMw: Double = 0.0,
    updateTimeStamp: String = null,
    updateType: String = null,
    updateUser: String = null,
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
    override def sup: MarketFactors = MarketFactors

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
    CIMParseable[RMROperatorInput]
{
    override val fields: Array[String] = Array[String] (
        "manuallySchedRMRMw",
        "updateTimeStamp",
        "updateType",
        "updateUser",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*")
    )
    val manuallySchedRMRMw: Fielder = parse_element (element (cls, fields(0)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(1)))
    val updateType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val updateUser: Fielder = parse_element (element (cls, fields(3)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): RMROperatorInput =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * This class models the information about the RUC awards.
 *
 * @param Element Reference to the superclass object.
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
 * @param ClearingResourceAward [[ch.ninecode.model.ResourceAwardClearing ResourceAwardClearing]] <em>undocumented</em>
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
final case class RUCAwardInstruction
(
    Element: BasicElement = null,
    clearedPrice: Double = 0.0,
    marketProductType: String = null,
    updateTimeStamp: String = null,
    updateType: String = null,
    updateUser: String = null,
    ClearingResourceAward: List[String] = null,
    RUCAward: Double = 0.0,
    RUCCapacity: Double = 0.0,
    RUCSchedule: Double = 0.0,
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
        implicit val clz: String = RUCAwardInstruction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RUCAwardInstruction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RUCAwardInstruction.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RUCAwardInstruction.fields (position), x))
        emitelem (0, clearedPrice)
        emitattr (1, marketProductType)
        emitelem (2, updateTimeStamp)
        emitattr (3, updateType)
        emitelem (4, updateUser)
        emitattrs (5, ClearingResourceAward)
        emitelem (6, RUCAward)
        emitelem (7, RUCCapacity)
        emitelem (8, RUCSchedule)
        emitattr (9, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RUCAwardInstruction rdf:ID=\"%s\">\n%s\t</cim:RUCAwardInstruction>".format (id, export_fields)
    }
}

object RUCAwardInstruction
extends
    CIMParseable[RUCAwardInstruction]
{
    override val fields: Array[String] = Array[String] (
        "clearedPrice",
        "marketProductType",
        "updateTimeStamp",
        "updateType",
        "updateUser",
        "ClearingResourceAward",
        "RUCAward",
        "RUCCapacity",
        "RUCSchedule",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ClearingResourceAward", "ResourceAwardClearing", "1..*", "1..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*")
    )
    val clearedPrice: Fielder = parse_element (element (cls, fields(0)))
    val marketProductType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val updateTimeStamp: Fielder = parse_element (element (cls, fields(2)))
    val updateType: Fielder = parse_attribute (attribute (cls, fields(3)))
    val updateUser: Fielder = parse_element (element (cls, fields(4)))
    val ClearingResourceAward: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val RUCAward: Fielder = parse_element (element (cls, fields(6)))
    val RUCCapacity: Fielder = parse_element (element (cls, fields(7)))
    val RUCSchedule: Fielder = parse_element (element (cls, fields(8)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: CIMContext): RUCAwardInstruction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RUCAwardInstruction (
            BasicElement.parse (context),
            toDouble (mask (clearedPrice (), 0)),
            mask (marketProductType (), 1),
            mask (updateTimeStamp (), 2),
            mask (updateType (), 3),
            mask (updateUser (), 4),
            masks (ClearingResourceAward (), 5),
            toDouble (mask (RUCAward (), 6)),
            toDouble (mask (RUCCapacity (), 7)),
            toDouble (mask (RUCSchedule (), 8)),
            mask (RegisteredResource (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Models details of bid and offer market clearing.
 *
 * Class indicates whether a contingency is active and whether the automatic dispatching system is active for this interval of the market solution.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param contingencyActive Indication that the system is currently operating in a contingency mode.
 * @param dispatchMode <em>undocumented</em>
 * @param RUCAwardInstruction [[ch.ninecode.model.RUCAwardInstruction RUCAwardInstruction]] <em>undocumented</em>
 * @param ResourceAwardInstruction [[ch.ninecode.model.ResourceAwardInstruction ResourceAwardInstruction]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class ResourceAwardClearing
(
    MarketFactors: MarketFactors = null,
    contingencyActive: String = null,
    dispatchMode: String = null,
    RUCAwardInstruction: List[String] = null,
    ResourceAwardInstruction: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = ResourceAwardClearing.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceAwardClearing.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ResourceAwardClearing.fields (position), x))
        emitattr (0, contingencyActive)
        emitattr (1, dispatchMode)
        emitattrs (2, RUCAwardInstruction)
        emitattrs (3, ResourceAwardInstruction)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceAwardClearing rdf:ID=\"%s\">\n%s\t</cim:ResourceAwardClearing>".format (id, export_fields)
    }
}

object ResourceAwardClearing
extends
    CIMParseable[ResourceAwardClearing]
{
    override val fields: Array[String] = Array[String] (
        "contingencyActive",
        "dispatchMode",
        "RUCAwardInstruction",
        "ResourceAwardInstruction"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RUCAwardInstruction", "RUCAwardInstruction", "1..*", "1..*"),
        CIMRelationship ("ResourceAwardInstruction", "ResourceAwardInstruction", "1..*", "1..*")
    )
    val contingencyActive: Fielder = parse_attribute (attribute (cls, fields(0)))
    val dispatchMode: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RUCAwardInstruction: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ResourceAwardInstruction: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): ResourceAwardClearing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ResourceAwardClearing (
            MarketFactors.parse (context),
            mask (contingencyActive (), 0),
            mask (dispatchMode (), 1),
            masks (RUCAwardInstruction (), 2),
            masks (ResourceAwardInstruction (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of market results, instruction for resource.
 *
 * Contains details of award as attributes.
 *
 * @param Element Reference to the superclass object.
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
 * @param ClearingResourceAward [[ch.ninecode.model.ResourceAwardClearing ResourceAwardClearing]] <em>undocumented</em>
 * @param MarketProduct [[ch.ninecode.model.MarketProduct MarketProduct]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param SelfScheduleBreakdown [[ch.ninecode.model.SelfScheduleBreakdown SelfScheduleBreakdown]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class ResourceAwardInstruction
(
    Element: BasicElement = null,
    awardMW: Double = 0.0,
    clearedMW: Double = 0.0,
    clearedPrice: Double = 0.0,
    congestLMP: Double = 0.0,
    costLMP: Double = 0.0,
    dispatcherAddedMW: Double = 0.0,
    economicMax: Double = 0.0,
    economicMin: Double = 0.0,
    effRegulationDownLimit: Double = 0.0,
    effRegulationUpLimit: Double = 0.0,
    lmp: Double = 0.0,
    lossLMP: Double = 0.0,
    manuallyBlocked: String = null,
    marginalResourceIndicator: String = null,
    mustRunInd: Boolean = false,
    noLoadCost: Double = 0.0,
    optimalBidCost: Double = 0.0,
    optimalBidPay: Double = 0.0,
    optimalMargin: Double = 0.0,
    overrideTimeStamp: String = null,
    overrideValue: Double = 0.0,
    selfSchedMW: Double = 0.0,
    startUpCost: Double = 0.0,
    status: String = null,
    totalRevenue: Double = 0.0,
    updateTimeStamp: String = null,
    updateType: String = null,
    updateUser: String = null,
    ClearingResourceAward: List[String] = null,
    MarketProduct: String = null,
    RegisteredResource: String = null,
    SelfScheduleBreakdown: List[String] = null
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
        implicit val clz: String = ResourceAwardInstruction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourceAwardInstruction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceAwardInstruction.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ResourceAwardInstruction.fields (position), x))
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
        emitattrs (28, ClearingResourceAward)
        emitattr (29, MarketProduct)
        emitattr (30, RegisteredResource)
        emitattrs (31, SelfScheduleBreakdown)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceAwardInstruction rdf:ID=\"%s\">\n%s\t</cim:ResourceAwardInstruction>".format (id, export_fields)
    }
}

object ResourceAwardInstruction
extends
    CIMParseable[ResourceAwardInstruction]
{
    override val fields: Array[String] = Array[String] (
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
        "ClearingResourceAward",
        "MarketProduct",
        "RegisteredResource",
        "SelfScheduleBreakdown"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ClearingResourceAward", "ResourceAwardClearing", "1..*", "1..*"),
        CIMRelationship ("MarketProduct", "MarketProduct", "1", "0..*"),
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*"),
        CIMRelationship ("SelfScheduleBreakdown", "SelfScheduleBreakdown", "0..*", "1")
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
    val ClearingResourceAward: FielderMultiple = parse_attributes (attribute (cls, fields(28)))
    val MarketProduct: Fielder = parse_attribute (attribute (cls, fields(29)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(30)))
    val SelfScheduleBreakdown: FielderMultiple = parse_attributes (attribute (cls, fields(31)))

    def parse (context: CIMContext): ResourceAwardInstruction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0,0)
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
            masks (ClearingResourceAward (), 28),
            mask (MarketProduct (), 29),
            mask (RegisteredResource (), 30),
            masks (SelfScheduleBreakdown (), 31)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of market results, including cleaing result of resources.
 *
 * Associated with ResourceDispatchResults.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param ResourceDispatchResults [[ch.ninecode.model.ResourceDispatchResults ResourceDispatchResults]] <em>undocumented</em>
 * @param ResourceLoadFollowingInst [[ch.ninecode.model.ResourceLoadFollowingInst ResourceLoadFollowingInst]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class ResourceClearing
(
    MarketFactors: MarketFactors = null,
    ResourceDispatchResults: List[String] = null,
    ResourceLoadFollowingInst: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = ResourceClearing.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ResourceClearing.fields (position), x))
        emitattrs (0, ResourceDispatchResults)
        emitattrs (1, ResourceLoadFollowingInst)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceClearing rdf:ID=\"%s\">\n%s\t</cim:ResourceClearing>".format (id, export_fields)
    }
}

object ResourceClearing
extends
    CIMParseable[ResourceClearing]
{
    override val fields: Array[String] = Array[String] (
        "ResourceDispatchResults",
        "ResourceLoadFollowingInst"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ResourceDispatchResults", "ResourceDispatchResults", "1..*", "0..1"),
        CIMRelationship ("ResourceLoadFollowingInst", "ResourceLoadFollowingInst", "0..*", "0..1")
    )
    val ResourceDispatchResults: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ResourceLoadFollowingInst: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): ResourceClearing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ResourceClearing (
            MarketFactors.parse (context),
            masks (ResourceDispatchResults (), 0),
            masks (ResourceLoadFollowingInst (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class ResourceDeploymentStatus
(
    Element: BasicElement = null,
    acceptComments: String = null,
    acceptStatus: String = null,
    resourceResponseMW: Double = 0.0,
    InstructionClearing: String = null
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
        implicit val clz: String = ResourceDeploymentStatus.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourceDeploymentStatus.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceDeploymentStatus.fields (position), value)
        emitelem (0, acceptComments)
        emitelem (1, acceptStatus)
        emitelem (2, resourceResponseMW)
        emitattr (3, InstructionClearing)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceDeploymentStatus rdf:ID=\"%s\">\n%s\t</cim:ResourceDeploymentStatus>".format (id, export_fields)
    }
}

object ResourceDeploymentStatus
extends
    CIMParseable[ResourceDeploymentStatus]
{
    override val fields: Array[String] = Array[String] (
        "acceptComments",
        "acceptStatus",
        "resourceResponseMW",
        "InstructionClearing"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("InstructionClearing", "InstructionClearing", "0..1", "0..*")
    )
    val acceptComments: Fielder = parse_element (element (cls, fields(0)))
    val acceptStatus: Fielder = parse_element (element (cls, fields(1)))
    val resourceResponseMW: Fielder = parse_element (element (cls, fields(2)))
    val InstructionClearing: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): ResourceDeploymentStatus =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ResourceDeploymentStatus (
            BasicElement.parse (context),
            mask (acceptComments (), 0),
            mask (acceptStatus (), 1),
            toDouble (mask (resourceResponseMW (), 2)),
            mask (InstructionClearing (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The ResourceDispatchResults class provides market results that can be provided to a SC.
 *
 * The specific data provided consists of several indicators such as contingency flags, blocked start up, and RMR dispatch. It also provides the projected overall and the regulating status of the resource.
 *
 * @param Element Reference to the superclass object.
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
final case class ResourceDispatchResults
(
    Element: BasicElement = null,
    blockedDispatch: String = null,
    blockedPublishDOP: String = null,
    contingencyFlag: String = null,
    limitIndicator: String = null,
    lowerLimit: Double = 0.0,
    maxRampRate: Double = 0.0,
    operatingLimitHigh: Double = 0.0,
    operatingLimitLow: Double = 0.0,
    penaltyDispatchIndicator: String = null,
    regulatingLimitHigh: Double = 0.0,
    regulatingLimitLow: Double = 0.0,
    resourceStatus: String = null,
    totalSchedule: Double = 0.0,
    updateTimeStamp: String = null,
    updateType: String = null,
    updateUser: String = null,
    upperLimit: Double = 0.0,
    RegisteredResource: String = null,
    ResourceClearing: String = null
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
    CIMParseable[ResourceDispatchResults]
{
    override val fields: Array[String] = Array[String] (
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*"),
        CIMRelationship ("ResourceClearing", "ResourceClearing", "0..1", "1..*")
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

    def parse (context: CIMContext): ResourceDispatchResults =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Model of market clearing results for resources that bid to follow load.
 *
 * @param Element Reference to the superclass object.
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
final case class ResourceLoadFollowingInst
(
    Element: BasicElement = null,
    calcLoadFollowingMW: Double = 0.0,
    dispWindowHighLimt: Double = 0.0,
    dispWindowLowLimt: Double = 0.0,
    instructionID: String = null,
    intervalStartTime: String = null,
    RegisteredResource: String = null,
    ResourceClearing: String = null
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
    CIMParseable[ResourceLoadFollowingInst]
{
    override val fields: Array[String] = Array[String] (
        "calcLoadFollowingMW",
        "dispWindowHighLimt",
        "dispWindowLowLimt",
        "instructionID",
        "intervalStartTime",
        "RegisteredResource",
        "ResourceClearing"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredResource", "RegisteredResource", "0..1", "0..*"),
        CIMRelationship ("ResourceClearing", "ResourceClearing", "0..1", "0..*")
    )
    val calcLoadFollowingMW: Fielder = parse_element (element (cls, fields(0)))
    val dispWindowHighLimt: Fielder = parse_element (element (cls, fields(1)))
    val dispWindowLowLimt: Fielder = parse_element (element (cls, fields(2)))
    val instructionID: Fielder = parse_element (element (cls, fields(3)))
    val intervalStartTime: Fielder = parse_element (element (cls, fields(4)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ResourceClearing: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): ResourceLoadFollowingInst =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Represents an the performance evaluation of a resource deployment.
 *
 * Every resource deployment may have many performance evaluations, using different evaluation metrics or algorithms, or produced by different evaluation authorities.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param effectiveEndTime <em>undocumented</em>
 * @param effectiveStartTime <em>undocumented</em>
 * @param evaluationDescription Description of the performance evaluation, e.g. the rating classification used (any is allowed), why the evaluation was performed, anything that describes the demand response performance evaluation.
 * @param evaluationValue The value of the performance. as a String, any rating scheme is supported (e.g. "1","2","3" or "low", "medium", "high").
 *        The rating scheme is described in the performanceValueDescription attribute.
 * @param DemandResponseActualEvent [[ch.ninecode.model.DistributedResourceActualEvent DistributedResourceActualEvent]] <em>undocumented</em>
 * @param ResorcePerformanceGlobalFactor [[ch.ninecode.model.ResourcePerformanceGlobalFactor ResourcePerformanceGlobalFactor]] <em>undocumented</em>
 * @param ResourcePerformanceTimeSeriesFactors [[ch.ninecode.model.ResourcePerformanceTimeSeriesFactor ResourcePerformanceTimeSeriesFactor]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class ResourcePerformanceEvaluation
(
    IdentifiedObject: IdentifiedObject = null,
    effectiveEndTime: String = null,
    effectiveStartTime: String = null,
    evaluationDescription: String = null,
    evaluationValue: String = null,
    DemandResponseActualEvent: String = null,
    ResorcePerformanceGlobalFactor: List[String] = null,
    ResourcePerformanceTimeSeriesFactors: List[String] = null
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
        implicit val clz: String = ResourcePerformanceEvaluation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourcePerformanceEvaluation.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourcePerformanceEvaluation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ResourcePerformanceEvaluation.fields (position), x))
        emitelem (0, effectiveEndTime)
        emitelem (1, effectiveStartTime)
        emitelem (2, evaluationDescription)
        emitelem (3, evaluationValue)
        emitattr (4, DemandResponseActualEvent)
        emitattrs (5, ResorcePerformanceGlobalFactor)
        emitattrs (6, ResourcePerformanceTimeSeriesFactors)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourcePerformanceEvaluation rdf:ID=\"%s\">\n%s\t</cim:ResourcePerformanceEvaluation>".format (id, export_fields)
    }
}

object ResourcePerformanceEvaluation
extends
    CIMParseable[ResourcePerformanceEvaluation]
{
    override val fields: Array[String] = Array[String] (
        "effectiveEndTime",
        "effectiveStartTime",
        "evaluationDescription",
        "evaluationValue",
        "DemandResponseActualEvent",
        "ResorcePerformanceGlobalFactor",
        "ResourcePerformanceTimeSeriesFactors"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DemandResponseActualEvent", "DistributedResourceActualEvent", "1", "0..*"),
        CIMRelationship ("ResorcePerformanceGlobalFactor", "ResourcePerformanceGlobalFactor", "0..*", "0..*"),
        CIMRelationship ("ResourcePerformanceTimeSeriesFactors", "ResourcePerformanceTimeSeriesFactor", "0..*", "1")
    )
    val effectiveEndTime: Fielder = parse_element (element (cls, fields(0)))
    val effectiveStartTime: Fielder = parse_element (element (cls, fields(1)))
    val evaluationDescription: Fielder = parse_element (element (cls, fields(2)))
    val evaluationValue: Fielder = parse_element (element (cls, fields(3)))
    val DemandResponseActualEvent: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ResorcePerformanceGlobalFactor: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val ResourcePerformanceTimeSeriesFactors: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: CIMContext): ResourcePerformanceEvaluation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ResourcePerformanceEvaluation (
            IdentifiedObject.parse (context),
            mask (effectiveEndTime (), 0),
            mask (effectiveStartTime (), 1),
            mask (evaluationDescription (), 2),
            mask (evaluationValue (), 3),
            mask (DemandResponseActualEvent (), 4),
            masks (ResorcePerformanceGlobalFactor (), 5),
            masks (ResourcePerformanceTimeSeriesFactors (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Global factors are property/value pairs that are used to adjust resource performance values.
 *
 * Example include scale factors (e.g. scale a baseline up or down), adders (positive or negative), etc.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param factorDescription Description (name) of the property (factor).
 * @param factorValue Value of the property (factor).
 * @param ResourcePerformanceEvaluation [[ch.ninecode.model.ResourcePerformanceEvaluation ResourcePerformanceEvaluation]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class ResourcePerformanceGlobalFactor
(
    IdentifiedObject: IdentifiedObject = null,
    factorDescription: String = null,
    factorValue: String = null,
    ResourcePerformanceEvaluation: List[String] = null
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
        implicit val clz: String = ResourcePerformanceGlobalFactor.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourcePerformanceGlobalFactor.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ResourcePerformanceGlobalFactor.fields (position), x))
        emitelem (0, factorDescription)
        emitelem (1, factorValue)
        emitattrs (2, ResourcePerformanceEvaluation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourcePerformanceGlobalFactor rdf:ID=\"%s\">\n%s\t</cim:ResourcePerformanceGlobalFactor>".format (id, export_fields)
    }
}

object ResourcePerformanceGlobalFactor
extends
    CIMParseable[ResourcePerformanceGlobalFactor]
{
    override val fields: Array[String] = Array[String] (
        "factorDescription",
        "factorValue",
        "ResourcePerformanceEvaluation"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ResourcePerformanceEvaluation", "ResourcePerformanceEvaluation", "0..*", "0..*")
    )
    val factorDescription: Fielder = parse_element (element (cls, fields(0)))
    val factorValue: Fielder = parse_element (element (cls, fields(1)))
    val ResourcePerformanceEvaluation: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): ResourcePerformanceGlobalFactor =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ResourcePerformanceGlobalFactor (
            IdentifiedObject.parse (context),
            mask (factorDescription (), 0),
            mask (factorValue (), 1),
            masks (ResourcePerformanceEvaluation (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Rating of a resource for its demand response performance. e.g. given a set on monthly resource demand response performance evaluations, the resource may be rated with excellent, average, or poor performance for the sample set.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param effectiveEndTime starting date time that the rating is valid for
 * @param effectiveStartTime ending date time that the rating is valid for
 * @param ratingDescription the resource's demand response rating description
 * @param ratingType the type of performance rating, e.g. which market or product the rating is for
 * @param ratingValue the resource's demand response rating
 * @param RegisteredResource [[ch.ninecode.model.RegisteredDistributedResource RegisteredDistributedResource]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class ResourcePerformanceRating
(
    IdentifiedObject: IdentifiedObject = null,
    effectiveEndTime: String = null,
    effectiveStartTime: String = null,
    ratingDescription: String = null,
    ratingType: String = null,
    ratingValue: String = null,
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
        implicit val clz: String = ResourcePerformanceRating.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourcePerformanceRating.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourcePerformanceRating.fields (position), value)
        emitelem (0, effectiveEndTime)
        emitelem (1, effectiveStartTime)
        emitelem (2, ratingDescription)
        emitelem (3, ratingType)
        emitelem (4, ratingValue)
        emitattr (5, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourcePerformanceRating rdf:ID=\"%s\">\n%s\t</cim:ResourcePerformanceRating>".format (id, export_fields)
    }
}

object ResourcePerformanceRating
extends
    CIMParseable[ResourcePerformanceRating]
{
    override val fields: Array[String] = Array[String] (
        "effectiveEndTime",
        "effectiveStartTime",
        "ratingDescription",
        "ratingType",
        "ratingValue",
        "RegisteredResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RegisteredResource", "RegisteredDistributedResource", "1", "0..*")
    )
    val effectiveEndTime: Fielder = parse_element (element (cls, fields(0)))
    val effectiveStartTime: Fielder = parse_element (element (cls, fields(1)))
    val ratingDescription: Fielder = parse_element (element (cls, fields(2)))
    val ratingType: Fielder = parse_element (element (cls, fields(3)))
    val ratingValue: Fielder = parse_element (element (cls, fields(4)))
    val RegisteredResource: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): ResourcePerformanceRating =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ResourcePerformanceRating (
            IdentifiedObject.parse (context),
            mask (effectiveEndTime (), 0),
            mask (effectiveStartTime (), 1),
            mask (ratingDescription (), 2),
            mask (ratingType (), 3),
            mask (ratingValue (), 4),
            mask (RegisteredResource (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Represents the performance of a resource as time series data for a specified time period, time interval, and evaluation criteria.
 *
 * @param RegularIntervalSchedule [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Reference to the superclass object.
 * @param timeSeriesDataType Type of the time series data, e.g. baseline data, meter read data, computed performance data.
 * @param timeSeriesDescription Optional description of the time series data, e.g. baseline data, meter read data, computed performance data.
 * @param value1Description Description for the value1 contained within the TimeSeriesFactor.
 * @param value2Description Description for the value2 contained within the TimeSeriesFactor.
 * @param ResourcePerformanceEvaluation [[ch.ninecode.model.ResourcePerformanceEvaluation ResourcePerformanceEvaluation]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class ResourcePerformanceTimeSeriesFactor
(
    RegularIntervalSchedule: RegularIntervalSchedule = null,
    timeSeriesDataType: String = null,
    timeSeriesDescription: String = null,
    value1Description: String = null,
    value2Description: String = null,
    ResourcePerformanceEvaluation: String = null
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
    override def sup: RegularIntervalSchedule = RegularIntervalSchedule

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
        implicit val clz: String = ResourcePerformanceTimeSeriesFactor.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourcePerformanceTimeSeriesFactor.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourcePerformanceTimeSeriesFactor.fields (position), value)
        emitelem (0, timeSeriesDataType)
        emitelem (1, timeSeriesDescription)
        emitelem (2, value1Description)
        emitelem (3, value2Description)
        emitattr (4, ResourcePerformanceEvaluation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourcePerformanceTimeSeriesFactor rdf:ID=\"%s\">\n%s\t</cim:ResourcePerformanceTimeSeriesFactor>".format (id, export_fields)
    }
}

object ResourcePerformanceTimeSeriesFactor
extends
    CIMParseable[ResourcePerformanceTimeSeriesFactor]
{
    override val fields: Array[String] = Array[String] (
        "timeSeriesDataType",
        "timeSeriesDescription",
        "value1Description",
        "value2Description",
        "ResourcePerformanceEvaluation"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ResourcePerformanceEvaluation", "ResourcePerformanceEvaluation", "1", "0..*")
    )
    val timeSeriesDataType: Fielder = parse_element (element (cls, fields(0)))
    val timeSeriesDescription: Fielder = parse_element (element (cls, fields(1)))
    val value1Description: Fielder = parse_element (element (cls, fields(2)))
    val value2Description: Fielder = parse_element (element (cls, fields(3)))
    val ResourcePerformanceEvaluation: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): ResourcePerformanceTimeSeriesFactor =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ResourcePerformanceTimeSeriesFactor (
            RegularIntervalSchedule.parse (context),
            mask (timeSeriesDataType (), 0),
            mask (timeSeriesDescription (), 1),
            mask (value1Description (), 2),
            mask (value2Description (), 3),
            mask (ResourcePerformanceEvaluation (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of Self Schedules Results.
 *
 * Includes self schedule MW,and type of self schedule for each self schedule type included in total self schedule MW value found in ResourceAwardInstruction.
 *
 * @param Element Reference to the superclass object.
 * @param selfSchedMW Cleared value for the specific self schedule type listed.
 * @param selfSchedType Self schedule breakdown type.
 * @param ResourceAwardInstruction [[ch.ninecode.model.ResourceAwardInstruction ResourceAwardInstruction]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class SelfScheduleBreakdown
(
    Element: BasicElement = null,
    selfSchedMW: Double = 0.0,
    selfSchedType: String = null,
    ResourceAwardInstruction: String = null
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
    CIMParseable[SelfScheduleBreakdown]
{
    override val fields: Array[String] = Array[String] (
        "selfSchedMW",
        "selfSchedType",
        "ResourceAwardInstruction"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ResourceAwardInstruction", "ResourceAwardInstruction", "1", "0..*")
    )
    val selfSchedMW: Fielder = parse_element (element (cls, fields(0)))
    val selfSchedType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ResourceAwardInstruction: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): SelfScheduleBreakdown =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SelfScheduleBreakdown (
            BasicElement.parse (context),
            toDouble (mask (selfSchedMW (), 0)),
            mask (selfSchedType (), 1),
            mask (ResourceAwardInstruction (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Specifies a settlement run.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param tradeDate The trade date on which the settlement is run.
 * @param EnergyMarket [[ch.ninecode.model.EnergyMarket EnergyMarket]] <em>undocumented</em>
 * @param MajorChargeGroup [[ch.ninecode.model.MajorChargeGroup MajorChargeGroup]] <em>undocumented</em>
 * @param MarketInvoiceLineItem [[ch.ninecode.model.MarketInvoiceLineItem MarketInvoiceLineItem]] <em>undocumented</em>
 * @param MarketLedgerEntry [[ch.ninecode.model.MarketLedgerEntry MarketLedgerEntry]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class Settlement
(
    Document: Document = null,
    tradeDate: String = null,
    EnergyMarket: String = null,
    MajorChargeGroup: List[String] = null,
    MarketInvoiceLineItem: List[String] = null,
    MarketLedgerEntry: List[String] = null
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
        implicit val clz: String = Settlement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Settlement.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Settlement.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Settlement.fields (position), x))
        emitelem (0, tradeDate)
        emitattr (1, EnergyMarket)
        emitattrs (2, MajorChargeGroup)
        emitattrs (3, MarketInvoiceLineItem)
        emitattrs (4, MarketLedgerEntry)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Settlement rdf:ID=\"%s\">\n%s\t</cim:Settlement>".format (id, export_fields)
    }
}

object Settlement
extends
    CIMParseable[Settlement]
{
    override val fields: Array[String] = Array[String] (
        "tradeDate",
        "EnergyMarket",
        "MajorChargeGroup",
        "MarketInvoiceLineItem",
        "MarketLedgerEntry"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnergyMarket", "EnergyMarket", "0..1", "0..*"),
        CIMRelationship ("MajorChargeGroup", "MajorChargeGroup", "1..*", "0..*"),
        CIMRelationship ("MarketInvoiceLineItem", "MarketInvoiceLineItem", "0..*", "0..*"),
        CIMRelationship ("MarketLedgerEntry", "MarketLedgerEntry", "0..*", "0..*")
    )
    val tradeDate: Fielder = parse_element (element (cls, fields(0)))
    val EnergyMarket: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MajorChargeGroup: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val MarketInvoiceLineItem: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val MarketLedgerEntry: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): Settlement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Settlement (
            Document.parse (context),
            mask (tradeDate (), 0),
            mask (EnergyMarket (), 1),
            masks (MajorChargeGroup (), 2),
            masks (MarketInvoiceLineItem (), 3),
            masks (MarketLedgerEntry (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Contains the intervals relavent for the associated TransactionBidResults.
 *
 * For example, Day Ahead cleared results for the transaction bids for each interval of the market day.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param TransactionBidResults [[ch.ninecode.model.TransactionBidResults TransactionBidResults]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class TransactionBidClearing
(
    MarketFactors: MarketFactors = null,
    TransactionBidResults: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
        implicit val clz: String = TransactionBidClearing.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TransactionBidClearing.fields (position), x))
        emitattrs (0, TransactionBidResults)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransactionBidClearing rdf:ID=\"%s\">\n%s\t</cim:TransactionBidClearing>".format (id, export_fields)
    }
}

object TransactionBidClearing
extends
    CIMParseable[TransactionBidClearing]
{
    override val fields: Array[String] = Array[String] (
        "TransactionBidResults"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TransactionBidResults", "TransactionBidResults", "0..*", "1")
    )
    val TransactionBidResults: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): TransactionBidClearing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransactionBidClearing (
            MarketFactors.parse (context),
            masks (TransactionBidResults (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Contains the cleared results for each TransactionBid submitted to and accepted by the market.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param clearedMW The market transaction megawatt
 * @param clearedPrice The price of the market transaction
 * @param TransactionBid [[ch.ninecode.model.TransactionBid TransactionBid]] <em>undocumented</em>
 * @param TransactionBidClearing [[ch.ninecode.model.TransactionBidClearing TransactionBidClearing]] <em>undocumented</em>
 * @group MarketResults
 * @groupname MarketResults Package MarketResults
 * @groupdesc MarketResults Results from the execution of a market.
 */
final case class TransactionBidResults
(
    IdentifiedObject: IdentifiedObject = null,
    clearedMW: Double = 0.0,
    clearedPrice: Double = 0.0,
    TransactionBid: String = null,
    TransactionBidClearing: String = null
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
    CIMParseable[TransactionBidResults]
{
    override val fields: Array[String] = Array[String] (
        "clearedMW",
        "clearedPrice",
        "TransactionBid",
        "TransactionBidClearing"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TransactionBid", "TransactionBid", "0..1", "0..*"),
        CIMRelationship ("TransactionBidClearing", "TransactionBidClearing", "1", "0..*")
    )
    val clearedMW: Fielder = parse_element (element (cls, fields(0)))
    val clearedPrice: Fielder = parse_element (element (cls, fields(1)))
    val TransactionBid: Fielder = parse_attribute (attribute (cls, fields(2)))
    val TransactionBidClearing: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): TransactionBidResults =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

private[ninecode] object _MarketResults
{
    def register: List[CIMClassInfo] =
    {
        List (
            AncillaryServiceClearing.register,
            BillDeterminant.register,
            ChargeProfile.register,
            ChargeProfileData.register,
            CommitmentClearing.register,
            Commitments.register,
            CommodityPrice.register,
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
            PriceDescriptor.register,
            RMRDetermination.register,
            RMROperatorInput.register,
            RUCAwardInstruction.register,
            ResourceAwardClearing.register,
            ResourceAwardInstruction.register,
            ResourceClearing.register,
            ResourceDeploymentStatus.register,
            ResourceDispatchResults.register,
            ResourceLoadFollowingInst.register,
            ResourcePerformanceEvaluation.register,
            ResourcePerformanceGlobalFactor.register,
            ResourcePerformanceRating.register,
            ResourcePerformanceTimeSeriesFactor.register,
            SelfScheduleBreakdown.register,
            Settlement.register,
            TransactionBidClearing.register,
            TransactionBidResults.register
        )
    }
}