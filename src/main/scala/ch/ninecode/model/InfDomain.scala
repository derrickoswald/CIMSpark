package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable


case class ADSInstructionTypeCommitment
(
    override val sup: BasicElement,
    SHUT_DOWN: String,
    START_UP: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ADSInstructionTypeCommitment] }
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
        sup.export_fields +
        (if (null != SHUT_DOWN) "\t\t<cim:ADSInstructionTypeCommitment.SHUT_DOWN rdf:resource=\"#" + SHUT_DOWN + "\"/>\n" else "") +
        (if (null != START_UP) "\t\t<cim:ADSInstructionTypeCommitment.START_UP rdf:resource=\"#" + START_UP + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ADSInstructionTypeCommitment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ADSInstructionTypeCommitment>\n"
    }
}

object ADSInstructionTypeCommitment
extends
    Parseable[ADSInstructionTypeCommitment]
{
    val SHUT_DOWN: (Context) => String = parse_attribute (attribute ("""ADSInstructionTypeCommitment.SHUT_DOWN"""))
    val START_UP: (Context) => String = parse_attribute (attribute ("""ADSInstructionTypeCommitment.START_UP"""))
    def parse (context: Context): ADSInstructionTypeCommitment =
    {
        ADSInstructionTypeCommitment(
            BasicElement.parse (context),
            SHUT_DOWN (context),
            START_UP (context)
        )
    }
}

/**
 * MIN_CONSTRAINT
MAX_CONSTRAINT
 * FIXED_CONSTRAINT
 * @param sup Reference to the superclass object.
 * @param FIXED_CONSTRAINT <em>undocumented</em>
 * @param MAX_CONSTRAINT <em>undocumented</em>
 * @param MIN_CONSTRAINT <em>undocumented</em>
 */
case class ADSInstructionTypeOOS
(
    override val sup: BasicElement,
    FIXED_CONSTRAINT: String,
    MAX_CONSTRAINT: String,
    MIN_CONSTRAINT: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ADSInstructionTypeOOS] }
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
        sup.export_fields +
        (if (null != FIXED_CONSTRAINT) "\t\t<cim:ADSInstructionTypeOOS.FIXED_CONSTRAINT rdf:resource=\"#" + FIXED_CONSTRAINT + "\"/>\n" else "") +
        (if (null != MAX_CONSTRAINT) "\t\t<cim:ADSInstructionTypeOOS.MAX_CONSTRAINT rdf:resource=\"#" + MAX_CONSTRAINT + "\"/>\n" else "") +
        (if (null != MIN_CONSTRAINT) "\t\t<cim:ADSInstructionTypeOOS.MIN_CONSTRAINT rdf:resource=\"#" + MIN_CONSTRAINT + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ADSInstructionTypeOOS rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ADSInstructionTypeOOS>\n"
    }
}

object ADSInstructionTypeOOS
extends
    Parseable[ADSInstructionTypeOOS]
{
    val FIXED_CONSTRAINT: (Context) => String = parse_attribute (attribute ("""ADSInstructionTypeOOS.FIXED_CONSTRAINT"""))
    val MAX_CONSTRAINT: (Context) => String = parse_attribute (attribute ("""ADSInstructionTypeOOS.MAX_CONSTRAINT"""))
    val MIN_CONSTRAINT: (Context) => String = parse_attribute (attribute ("""ADSInstructionTypeOOS.MIN_CONSTRAINT"""))
    def parse (context: Context): ADSInstructionTypeOOS =
    {
        ADSInstructionTypeOOS(
            BasicElement.parse (context),
            FIXED_CONSTRAINT (context),
            MAX_CONSTRAINT (context),
            MIN_CONSTRAINT (context)
        )
    }
}

/**
 * BASELI NE
 * NEGOTIATED
 * @param sup Reference to the superclass object.
 * @param BASELINE <em>undocumented</em>
 * @param NEGOTIATED <em>undocumented</em>
 */
case class AdderType
(
    override val sup: BasicElement,
    BASELINE: String,
    NEGOTIATED: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AdderType] }
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
        sup.export_fields +
        (if (null != BASELINE) "\t\t<cim:AdderType.BASELINE rdf:resource=\"#" + BASELINE + "\"/>\n" else "") +
        (if (null != NEGOTIATED) "\t\t<cim:AdderType.NEGOTIATED rdf:resource=\"#" + NEGOTIATED + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AdderType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AdderType>\n"
    }
}

object AdderType
extends
    Parseable[AdderType]
{
    val BASELINE: (Context) => String = parse_attribute (attribute ("""AdderType.BASELINE"""))
    val NEGOTIATED: (Context) => String = parse_attribute (attribute ("""AdderType.NEGOTIATED"""))
    def parse (context: Context): AdderType =
    {
        AdderType(
            BasicElement.parse (context),
            BASELINE (context),
            NEGOTIATED (context)
        )
    }
}

case class AlarmDisplayType
(
    override val sup: BasicElement,
    Appear: String,
    Disappear: String,
    Fleeting: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AlarmDisplayType] }
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
        sup.export_fields +
        (if (null != Appear) "\t\t<cim:AlarmDisplayType.Appear rdf:resource=\"#" + Appear + "\"/>\n" else "") +
        (if (null != Disappear) "\t\t<cim:AlarmDisplayType.Disappear rdf:resource=\"#" + Disappear + "\"/>\n" else "") +
        (if (null != Fleeting) "\t\t<cim:AlarmDisplayType.Fleeting rdf:resource=\"#" + Fleeting + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AlarmDisplayType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AlarmDisplayType>\n"
    }
}

object AlarmDisplayType
extends
    Parseable[AlarmDisplayType]
{
    val Appear: (Context) => String = parse_attribute (attribute ("""AlarmDisplayType.Appear"""))
    val Disappear: (Context) => String = parse_attribute (attribute ("""AlarmDisplayType.Disappear"""))
    val Fleeting: (Context) => String = parse_attribute (attribute ("""AlarmDisplayType.Fleeting"""))
    def parse (context: Context): AlarmDisplayType =
    {
        AlarmDisplayType(
            BasicElement.parse (context),
            Appear (context),
            Disappear (context),
            Fleeting (context)
        )
    }
}

case class AllocationEnergyTypeCode
(
    override val sup: BasicElement,
    ACNG: String,
    BS: String,
    DAPE: String,
    DASE: String,
    ESRT: String,
    ESYS: String,
    ETC: String,
    HASE: String,
    LMPM: String,
    MINL: String,
    MLE: String,
    MSSLFE: String,
    OE: String,
    OTHER: String,
    OVGN: String,
    PE: String,
    RCNG: String,
    RE: String,
    RED: String,
    RMRD: String,
    RMRH: String,
    RMRR: String,
    RMRS: String,
    RMRT: String,
    RSYS: String,
    RTSSE: String,
    SDWN: String,
    SE: String,
    SLIC: String,
    SRE: String,
    STRT: String,
    SUMR: String,
    TCNG: String,
    TEST: String,
    TOR: String,
    VS: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AllocationEnergyTypeCode] }
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
        sup.export_fields +
        (if (null != ACNG) "\t\t<cim:AllocationEnergyTypeCode.ACNG rdf:resource=\"#" + ACNG + "\"/>\n" else "") +
        (if (null != BS) "\t\t<cim:AllocationEnergyTypeCode.BS rdf:resource=\"#" + BS + "\"/>\n" else "") +
        (if (null != DAPE) "\t\t<cim:AllocationEnergyTypeCode.DAPE rdf:resource=\"#" + DAPE + "\"/>\n" else "") +
        (if (null != DASE) "\t\t<cim:AllocationEnergyTypeCode.DASE rdf:resource=\"#" + DASE + "\"/>\n" else "") +
        (if (null != ESRT) "\t\t<cim:AllocationEnergyTypeCode.ESRT rdf:resource=\"#" + ESRT + "\"/>\n" else "") +
        (if (null != ESYS) "\t\t<cim:AllocationEnergyTypeCode.ESYS rdf:resource=\"#" + ESYS + "\"/>\n" else "") +
        (if (null != ETC) "\t\t<cim:AllocationEnergyTypeCode.ETC rdf:resource=\"#" + ETC + "\"/>\n" else "") +
        (if (null != HASE) "\t\t<cim:AllocationEnergyTypeCode.HASE rdf:resource=\"#" + HASE + "\"/>\n" else "") +
        (if (null != LMPM) "\t\t<cim:AllocationEnergyTypeCode.LMPM rdf:resource=\"#" + LMPM + "\"/>\n" else "") +
        (if (null != MINL) "\t\t<cim:AllocationEnergyTypeCode.MINL rdf:resource=\"#" + MINL + "\"/>\n" else "") +
        (if (null != MLE) "\t\t<cim:AllocationEnergyTypeCode.MLE rdf:resource=\"#" + MLE + "\"/>\n" else "") +
        (if (null != MSSLFE) "\t\t<cim:AllocationEnergyTypeCode.MSSLFE rdf:resource=\"#" + MSSLFE + "\"/>\n" else "") +
        (if (null != OE) "\t\t<cim:AllocationEnergyTypeCode.OE rdf:resource=\"#" + OE + "\"/>\n" else "") +
        (if (null != OTHER) "\t\t<cim:AllocationEnergyTypeCode.OTHER rdf:resource=\"#" + OTHER + "\"/>\n" else "") +
        (if (null != OVGN) "\t\t<cim:AllocationEnergyTypeCode.OVGN rdf:resource=\"#" + OVGN + "\"/>\n" else "") +
        (if (null != PE) "\t\t<cim:AllocationEnergyTypeCode.PE rdf:resource=\"#" + PE + "\"/>\n" else "") +
        (if (null != RCNG) "\t\t<cim:AllocationEnergyTypeCode.RCNG rdf:resource=\"#" + RCNG + "\"/>\n" else "") +
        (if (null != RE) "\t\t<cim:AllocationEnergyTypeCode.RE rdf:resource=\"#" + RE + "\"/>\n" else "") +
        (if (null != RED) "\t\t<cim:AllocationEnergyTypeCode.RED rdf:resource=\"#" + RED + "\"/>\n" else "") +
        (if (null != RMRD) "\t\t<cim:AllocationEnergyTypeCode.RMRD rdf:resource=\"#" + RMRD + "\"/>\n" else "") +
        (if (null != RMRH) "\t\t<cim:AllocationEnergyTypeCode.RMRH rdf:resource=\"#" + RMRH + "\"/>\n" else "") +
        (if (null != RMRR) "\t\t<cim:AllocationEnergyTypeCode.RMRR rdf:resource=\"#" + RMRR + "\"/>\n" else "") +
        (if (null != RMRS) "\t\t<cim:AllocationEnergyTypeCode.RMRS rdf:resource=\"#" + RMRS + "\"/>\n" else "") +
        (if (null != RMRT) "\t\t<cim:AllocationEnergyTypeCode.RMRT rdf:resource=\"#" + RMRT + "\"/>\n" else "") +
        (if (null != RSYS) "\t\t<cim:AllocationEnergyTypeCode.RSYS rdf:resource=\"#" + RSYS + "\"/>\n" else "") +
        (if (null != RTSSE) "\t\t<cim:AllocationEnergyTypeCode.RTSSE rdf:resource=\"#" + RTSSE + "\"/>\n" else "") +
        (if (null != SDWN) "\t\t<cim:AllocationEnergyTypeCode.SDWN rdf:resource=\"#" + SDWN + "\"/>\n" else "") +
        (if (null != SE) "\t\t<cim:AllocationEnergyTypeCode.SE rdf:resource=\"#" + SE + "\"/>\n" else "") +
        (if (null != SLIC) "\t\t<cim:AllocationEnergyTypeCode.SLIC rdf:resource=\"#" + SLIC + "\"/>\n" else "") +
        (if (null != SRE) "\t\t<cim:AllocationEnergyTypeCode.SRE rdf:resource=\"#" + SRE + "\"/>\n" else "") +
        (if (null != STRT) "\t\t<cim:AllocationEnergyTypeCode.STRT rdf:resource=\"#" + STRT + "\"/>\n" else "") +
        (if (null != SUMR) "\t\t<cim:AllocationEnergyTypeCode.SUMR rdf:resource=\"#" + SUMR + "\"/>\n" else "") +
        (if (null != TCNG) "\t\t<cim:AllocationEnergyTypeCode.TCNG rdf:resource=\"#" + TCNG + "\"/>\n" else "") +
        (if (null != TEST) "\t\t<cim:AllocationEnergyTypeCode.TEST rdf:resource=\"#" + TEST + "\"/>\n" else "") +
        (if (null != TOR) "\t\t<cim:AllocationEnergyTypeCode.TOR rdf:resource=\"#" + TOR + "\"/>\n" else "") +
        (if (null != VS) "\t\t<cim:AllocationEnergyTypeCode.VS rdf:resource=\"#" + VS + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AllocationEnergyTypeCode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AllocationEnergyTypeCode>\n"
    }
}

object AllocationEnergyTypeCode
extends
    Parseable[AllocationEnergyTypeCode]
{
    val ACNG: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.ACNG"""))
    val BS: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.BS"""))
    val DAPE: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.DAPE"""))
    val DASE: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.DASE"""))
    val ESRT: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.ESRT"""))
    val ESYS: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.ESYS"""))
    val ETC: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.ETC"""))
    val HASE: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.HASE"""))
    val LMPM: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.LMPM"""))
    val MINL: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.MINL"""))
    val MLE: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.MLE"""))
    val MSSLFE: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.MSSLFE"""))
    val OE: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.OE"""))
    val OTHER: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.OTHER"""))
    val OVGN: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.OVGN"""))
    val PE: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.PE"""))
    val RCNG: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.RCNG"""))
    val RE: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.RE"""))
    val RED: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.RED"""))
    val RMRD: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.RMRD"""))
    val RMRH: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.RMRH"""))
    val RMRR: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.RMRR"""))
    val RMRS: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.RMRS"""))
    val RMRT: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.RMRT"""))
    val RSYS: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.RSYS"""))
    val RTSSE: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.RTSSE"""))
    val SDWN: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.SDWN"""))
    val SE: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.SE"""))
    val SLIC: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.SLIC"""))
    val SRE: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.SRE"""))
    val STRT: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.STRT"""))
    val SUMR: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.SUMR"""))
    val TCNG: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.TCNG"""))
    val TEST: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.TEST"""))
    val TOR: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.TOR"""))
    val VS: (Context) => String = parse_attribute (attribute ("""AllocationEnergyTypeCode.VS"""))
    def parse (context: Context): AllocationEnergyTypeCode =
    {
        AllocationEnergyTypeCode(
            BasicElement.parse (context),
            ACNG (context),
            BS (context),
            DAPE (context),
            DASE (context),
            ESRT (context),
            ESYS (context),
            ETC (context),
            HASE (context),
            LMPM (context),
            MINL (context),
            MLE (context),
            MSSLFE (context),
            OE (context),
            OTHER (context),
            OVGN (context),
            PE (context),
            RCNG (context),
            RE (context),
            RED (context),
            RMRD (context),
            RMRH (context),
            RMRR (context),
            RMRS (context),
            RMRT (context),
            RSYS (context),
            RTSSE (context),
            SDWN (context),
            SE (context),
            SLIC (context),
            SRE (context),
            STRT (context),
            SUMR (context),
            TCNG (context),
            TEST (context),
            TOR (context),
            VS (context)
        )
    }
}

/**
 * ancillary serivce types
 * @param sup Reference to the superclass object.
 * @param NONSPIN non spinning reserve
 * @param REGDN regulation down
 * @param REGUP regulation up
 * @param SPIN spinning reserve
 */
case class AncillaryCommodityType
(
    override val sup: BasicElement,
    NONSPIN: String,
    REGDN: String,
    REGUP: String,
    SPIN: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AncillaryCommodityType] }
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
        sup.export_fields +
        (if (null != NONSPIN) "\t\t<cim:AncillaryCommodityType.NONSPIN rdf:resource=\"#" + NONSPIN + "\"/>\n" else "") +
        (if (null != REGDN) "\t\t<cim:AncillaryCommodityType.REGDN rdf:resource=\"#" + REGDN + "\"/>\n" else "") +
        (if (null != REGUP) "\t\t<cim:AncillaryCommodityType.REGUP rdf:resource=\"#" + REGUP + "\"/>\n" else "") +
        (if (null != SPIN) "\t\t<cim:AncillaryCommodityType.SPIN rdf:resource=\"#" + SPIN + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AncillaryCommodityType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AncillaryCommodityType>\n"
    }
}

object AncillaryCommodityType
extends
    Parseable[AncillaryCommodityType]
{
    val NONSPIN: (Context) => String = parse_attribute (attribute ("""AncillaryCommodityType.NONSPIN"""))
    val REGDN: (Context) => String = parse_attribute (attribute ("""AncillaryCommodityType.REGDN"""))
    val REGUP: (Context) => String = parse_attribute (attribute ("""AncillaryCommodityType.REGUP"""))
    val SPIN: (Context) => String = parse_attribute (attribute ("""AncillaryCommodityType.SPIN"""))
    def parse (context: Context): AncillaryCommodityType =
    {
        AncillaryCommodityType(
            BasicElement.parse (context),
            NONSPIN (context),
            REGDN (context),
            REGUP (context),
            SPIN (context)
        )
    }
}

case class BidPriceCapType
(
    override val sup: BasicElement,
    AS: String,
    ENERGY: String,
    RUC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BidPriceCapType] }
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
        sup.export_fields +
        (if (null != AS) "\t\t<cim:BidPriceCapType.AS rdf:resource=\"#" + AS + "\"/>\n" else "") +
        (if (null != ENERGY) "\t\t<cim:BidPriceCapType.ENERGY rdf:resource=\"#" + ENERGY + "\"/>\n" else "") +
        (if (null != RUC) "\t\t<cim:BidPriceCapType.RUC rdf:resource=\"#" + RUC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BidPriceCapType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidPriceCapType>\n"
    }
}

object BidPriceCapType
extends
    Parseable[BidPriceCapType]
{
    val AS: (Context) => String = parse_attribute (attribute ("""BidPriceCapType.AS"""))
    val ENERGY: (Context) => String = parse_attribute (attribute ("""BidPriceCapType.ENERGY"""))
    val RUC: (Context) => String = parse_attribute (attribute ("""BidPriceCapType.RUC"""))
    def parse (context: Context): BidPriceCapType =
    {
        BidPriceCapType(
            BasicElement.parse (context),
            AS (context),
            ENERGY (context),
            RUC (context)
        )
    }
}

/**
 * Status indication for bids

CV - Conditionally Valid Bid
CM - Conditionally Modified Bid
V - Valid Bid
M - Modified Bid
RJ - Rejected Bid
I - Invalid Bid
CX - Cancelled Bid
O - Obsolete Bid
CL - Clean Bid
 * RP - Replicated Bid
 * @param sup Reference to the superclass object.
 * @param CL Clean
 * @param CM <em>undocumented</em>
 * @param CV <em>undocumented</em>
 * @param CX <em>undocumented</em>
 * @param I <em>undocumented</em>
 * @param M <em>undocumented</em>
 * @param O <em>undocumented</em>
 * @param RJ <em>undocumented</em>
 * @param RP Replicated
 * @param V <em>undocumented</em>
 */
case class BidStatusType
(
    override val sup: BasicElement,
    CL: String,
    CM: String,
    CV: String,
    CX: String,
    I: String,
    M: String,
    O: String,
    RJ: String,
    RP: String,
    V: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BidStatusType] }
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
        sup.export_fields +
        (if (null != CL) "\t\t<cim:BidStatusType.CL rdf:resource=\"#" + CL + "\"/>\n" else "") +
        (if (null != CM) "\t\t<cim:BidStatusType.CM rdf:resource=\"#" + CM + "\"/>\n" else "") +
        (if (null != CV) "\t\t<cim:BidStatusType.CV rdf:resource=\"#" + CV + "\"/>\n" else "") +
        (if (null != CX) "\t\t<cim:BidStatusType.CX rdf:resource=\"#" + CX + "\"/>\n" else "") +
        (if (null != I) "\t\t<cim:BidStatusType.I rdf:resource=\"#" + I + "\"/>\n" else "") +
        (if (null != M) "\t\t<cim:BidStatusType.M rdf:resource=\"#" + M + "\"/>\n" else "") +
        (if (null != O) "\t\t<cim:BidStatusType.O rdf:resource=\"#" + O + "\"/>\n" else "") +
        (if (null != RJ) "\t\t<cim:BidStatusType.RJ rdf:resource=\"#" + RJ + "\"/>\n" else "") +
        (if (null != RP) "\t\t<cim:BidStatusType.RP rdf:resource=\"#" + RP + "\"/>\n" else "") +
        (if (null != V) "\t\t<cim:BidStatusType.V rdf:resource=\"#" + V + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BidStatusType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidStatusType>\n"
    }
}

object BidStatusType
extends
    Parseable[BidStatusType]
{
    val CL: (Context) => String = parse_attribute (attribute ("""BidStatusType.CL"""))
    val CM: (Context) => String = parse_attribute (attribute ("""BidStatusType.CM"""))
    val CV: (Context) => String = parse_attribute (attribute ("""BidStatusType.CV"""))
    val CX: (Context) => String = parse_attribute (attribute ("""BidStatusType.CX"""))
    val I: (Context) => String = parse_attribute (attribute ("""BidStatusType.I"""))
    val M: (Context) => String = parse_attribute (attribute ("""BidStatusType.M"""))
    val O: (Context) => String = parse_attribute (attribute ("""BidStatusType.O"""))
    val RJ: (Context) => String = parse_attribute (attribute ("""BidStatusType.RJ"""))
    val RP: (Context) => String = parse_attribute (attribute ("""BidStatusType.RP"""))
    val V: (Context) => String = parse_attribute (attribute ("""BidStatusType.V"""))
    def parse (context: Context): BidStatusType =
    {
        BidStatusType(
            BasicElement.parse (context),
            CL (context),
            CM (context),
            CV (context),
            CX (context),
            I (context),
            M (context),
            O (context),
            RJ (context),
            RP (context),
            V (context)
        )
    }
}

case class CleanTradeProductType
(
    override val sup: BasicElement,
    APN: String,
    CPT: String,
    NRT: String,
    PHY: String,
    RDT: String,
    RUT: String,
    SRT: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CleanTradeProductType] }
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
        sup.export_fields +
        (if (null != APN) "\t\t<cim:CleanTradeProductType.APN rdf:resource=\"#" + APN + "\"/>\n" else "") +
        (if (null != CPT) "\t\t<cim:CleanTradeProductType.CPT rdf:resource=\"#" + CPT + "\"/>\n" else "") +
        (if (null != NRT) "\t\t<cim:CleanTradeProductType.NRT rdf:resource=\"#" + NRT + "\"/>\n" else "") +
        (if (null != PHY) "\t\t<cim:CleanTradeProductType.PHY rdf:resource=\"#" + PHY + "\"/>\n" else "") +
        (if (null != RDT) "\t\t<cim:CleanTradeProductType.RDT rdf:resource=\"#" + RDT + "\"/>\n" else "") +
        (if (null != RUT) "\t\t<cim:CleanTradeProductType.RUT rdf:resource=\"#" + RUT + "\"/>\n" else "") +
        (if (null != SRT) "\t\t<cim:CleanTradeProductType.SRT rdf:resource=\"#" + SRT + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CleanTradeProductType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CleanTradeProductType>\n"
    }
}

object CleanTradeProductType
extends
    Parseable[CleanTradeProductType]
{
    val APN: (Context) => String = parse_attribute (attribute ("""CleanTradeProductType.APN"""))
    val CPT: (Context) => String = parse_attribute (attribute ("""CleanTradeProductType.CPT"""))
    val NRT: (Context) => String = parse_attribute (attribute ("""CleanTradeProductType.NRT"""))
    val PHY: (Context) => String = parse_attribute (attribute ("""CleanTradeProductType.PHY"""))
    val RDT: (Context) => String = parse_attribute (attribute ("""CleanTradeProductType.RDT"""))
    val RUT: (Context) => String = parse_attribute (attribute ("""CleanTradeProductType.RUT"""))
    val SRT: (Context) => String = parse_attribute (attribute ("""CleanTradeProductType.SRT"""))
    def parse (context: Context): CleanTradeProductType =
    {
        CleanTradeProductType(
            BasicElement.parse (context),
            APN (context),
            CPT (context),
            NRT (context),
            PHY (context),
            RDT (context),
            RUT (context),
            SRT (context)
        )
    }
}

/**
 * ACTIVE
 * INACTIVE
 * @param sup Reference to the superclass object.
 * @param ACTIVE <em>undocumented</em>
 * @param INACTIVE <em>undocumented</em>
 */
case class CurrentStatusSC
(
    override val sup: BasicElement,
    ACTIVE: String,
    INACTIVE: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CurrentStatusSC] }
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
        sup.export_fields +
        (if (null != ACTIVE) "\t\t<cim:CurrentStatusSC.ACTIVE rdf:resource=\"#" + ACTIVE + "\"/>\n" else "") +
        (if (null != INACTIVE) "\t\t<cim:CurrentStatusSC.INACTIVE rdf:resource=\"#" + INACTIVE + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CurrentStatusSC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CurrentStatusSC>\n"
    }
}

object CurrentStatusSC
extends
    Parseable[CurrentStatusSC]
{
    val ACTIVE: (Context) => String = parse_attribute (attribute ("""CurrentStatusSC.ACTIVE"""))
    val INACTIVE: (Context) => String = parse_attribute (attribute ("""CurrentStatusSC.INACTIVE"""))
    def parse (context: Context): CurrentStatusSC =
    {
        CurrentStatusSC(
            BasicElement.parse (context),
            ACTIVE (context),
            INACTIVE (context)
        )
    }
}

case class DAMMarketType
(
    override val sup: BasicElement,
    DAM: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DAMMarketType] }
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
        sup.export_fields +
        (if (null != DAM) "\t\t<cim:DAMMarketType.DAM rdf:resource=\"#" + DAM + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DAMMarketType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DAMMarketType>\n"
    }
}

object DAMMarketType
extends
    Parseable[DAMMarketType]
{
    val DAM: (Context) => String = parse_attribute (attribute ("""DAMMarketType.DAM"""))
    def parse (context: Context): DAMMarketType =
    {
        DAMMarketType(
            BasicElement.parse (context),
            DAM (context)
        )
    }
}

case class DispatchAcceptStatus
(
    override val sup: BasicElement,
    ACCEPT: String,
    CANNOT: String,
    DECLINE: String,
    NON_RESPONSE: String,
    OK: String,
    PARTIAL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DispatchAcceptStatus] }
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
        sup.export_fields +
        (if (null != ACCEPT) "\t\t<cim:DispatchAcceptStatus.ACCEPT rdf:resource=\"#" + ACCEPT + "\"/>\n" else "") +
        (if (null != CANNOT) "\t\t<cim:DispatchAcceptStatus.CANNOT rdf:resource=\"#" + CANNOT + "\"/>\n" else "") +
        (if (null != DECLINE) "\t\t<cim:DispatchAcceptStatus.DECLINE rdf:resource=\"#" + DECLINE + "\"/>\n" else "") +
        (if (null != NON_RESPONSE) "\t\t<cim:DispatchAcceptStatus.NON_RESPONSE rdf:resource=\"#" + NON_RESPONSE + "\"/>\n" else "") +
        (if (null != OK) "\t\t<cim:DispatchAcceptStatus.OK rdf:resource=\"#" + OK + "\"/>\n" else "") +
        (if (null != PARTIAL) "\t\t<cim:DispatchAcceptStatus.PARTIAL rdf:resource=\"#" + PARTIAL + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DispatchAcceptStatus rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DispatchAcceptStatus>\n"
    }
}

object DispatchAcceptStatus
extends
    Parseable[DispatchAcceptStatus]
{
    val ACCEPT: (Context) => String = parse_attribute (attribute ("""DispatchAcceptStatus.ACCEPT"""))
    val CANNOT: (Context) => String = parse_attribute (attribute ("""DispatchAcceptStatus.CANNOT"""))
    val DECLINE: (Context) => String = parse_attribute (attribute ("""DispatchAcceptStatus.DECLINE"""))
    val NON_RESPONSE: (Context) => String = parse_attribute (attribute ("""DispatchAcceptStatus.NON_RESPONSE"""))
    val OK: (Context) => String = parse_attribute (attribute ("""DispatchAcceptStatus.OK"""))
    val PARTIAL: (Context) => String = parse_attribute (attribute ("""DispatchAcceptStatus.PARTIAL"""))
    def parse (context: Context): DispatchAcceptStatus =
    {
        DispatchAcceptStatus(
            BasicElement.parse (context),
            ACCEPT (context),
            CANNOT (context),
            DECLINE (context),
            NON_RESPONSE (context),
            OK (context),
            PARTIAL (context)
        )
    }
}

case class DispatchTransactionType
(
    override val sup: BasicElement,
    Purchase: String,
    Sale: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DispatchTransactionType] }
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
        sup.export_fields +
        (if (null != Purchase) "\t\t<cim:DispatchTransactionType.Purchase rdf:resource=\"#" + Purchase + "\"/>\n" else "") +
        (if (null != Sale) "\t\t<cim:DispatchTransactionType.Sale rdf:resource=\"#" + Sale + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DispatchTransactionType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DispatchTransactionType>\n"
    }
}

object DispatchTransactionType
extends
    Parseable[DispatchTransactionType]
{
    val Purchase: (Context) => String = parse_attribute (attribute ("""DispatchTransactionType.Purchase"""))
    val Sale: (Context) => String = parse_attribute (attribute ("""DispatchTransactionType.Sale"""))
    def parse (context: Context): DispatchTransactionType =
    {
        DispatchTransactionType(
            BasicElement.parse (context),
            Purchase (context),
            Sale (context)
        )
    }
}

/**
 * Valid Enumerations:
1) DASE Day Ahead Scheduled Energy; 
2) DSSE Day Ahead Incremental Self Schedule Energy; 
3) DABE Day Ahead Incremental Energy Bid Awarded Energy; 
4) OE Optimal Energy; 
5) HASE Hour ahead pre-dispatched schedule energy; 
6) SRE Standard Ramping Energy; 
7) RED Ramping Energy Deviation; 
8) EDE Exceptional Dispatch energy; 
9) RMRE RMR Energy; 
10) MSSLFE MSSLF Energy; 
11) RE Residual Energy; 
12) MLE Minimum Load Energy; 
13) SE SLIC Energy; 
14) RTSSE Real time self scheduled energy; 
15) DMLE Day ahead minimum load energy; 
16) PE Pumping Energy; 
17) TEE Total Expected Energy;
 * 18) DAPE - Day-Ahead Pumping Energy;
 * @param sup Reference to the superclass object.
 * @param DABE <em>undocumented</em>
 * @param DAPE <em>undocumented</em>
 * @param DASE <em>undocumented</em>
 * @param DMLE <em>undocumented</em>
 * @param DSSE <em>undocumented</em>
 * @param EDE <em>undocumented</em>
 * @param HASE <em>undocumented</em>
 * @param MLE <em>undocumented</em>
 * @param MSSLFE <em>undocumented</em>
 * @param OE <em>undocumented</em>
 * @param PE <em>undocumented</em>
 * @param RE <em>undocumented</em>
 * @param RED <em>undocumented</em>
 * @param RMRE <em>undocumented</em>
 * @param RTSSE <em>undocumented</em>
 * @param SE <em>undocumented</em>
 * @param SRE <em>undocumented</em>
 * @param TEE <em>undocumented</em>
 */
case class EnergyTypeCode
(
    override val sup: BasicElement,
    DABE: String,
    DAPE: String,
    DASE: String,
    DMLE: String,
    DSSE: String,
    EDE: String,
    HASE: String,
    MLE: String,
    MSSLFE: String,
    OE: String,
    PE: String,
    RE: String,
    RED: String,
    RMRE: String,
    RTSSE: String,
    SE: String,
    SRE: String,
    TEE: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[EnergyTypeCode] }
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
        sup.export_fields +
        (if (null != DABE) "\t\t<cim:EnergyTypeCode.DABE rdf:resource=\"#" + DABE + "\"/>\n" else "") +
        (if (null != DAPE) "\t\t<cim:EnergyTypeCode.DAPE rdf:resource=\"#" + DAPE + "\"/>\n" else "") +
        (if (null != DASE) "\t\t<cim:EnergyTypeCode.DASE rdf:resource=\"#" + DASE + "\"/>\n" else "") +
        (if (null != DMLE) "\t\t<cim:EnergyTypeCode.DMLE rdf:resource=\"#" + DMLE + "\"/>\n" else "") +
        (if (null != DSSE) "\t\t<cim:EnergyTypeCode.DSSE rdf:resource=\"#" + DSSE + "\"/>\n" else "") +
        (if (null != EDE) "\t\t<cim:EnergyTypeCode.EDE rdf:resource=\"#" + EDE + "\"/>\n" else "") +
        (if (null != HASE) "\t\t<cim:EnergyTypeCode.HASE rdf:resource=\"#" + HASE + "\"/>\n" else "") +
        (if (null != MLE) "\t\t<cim:EnergyTypeCode.MLE rdf:resource=\"#" + MLE + "\"/>\n" else "") +
        (if (null != MSSLFE) "\t\t<cim:EnergyTypeCode.MSSLFE rdf:resource=\"#" + MSSLFE + "\"/>\n" else "") +
        (if (null != OE) "\t\t<cim:EnergyTypeCode.OE rdf:resource=\"#" + OE + "\"/>\n" else "") +
        (if (null != PE) "\t\t<cim:EnergyTypeCode.PE rdf:resource=\"#" + PE + "\"/>\n" else "") +
        (if (null != RE) "\t\t<cim:EnergyTypeCode.RE rdf:resource=\"#" + RE + "\"/>\n" else "") +
        (if (null != RED) "\t\t<cim:EnergyTypeCode.RED rdf:resource=\"#" + RED + "\"/>\n" else "") +
        (if (null != RMRE) "\t\t<cim:EnergyTypeCode.RMRE rdf:resource=\"#" + RMRE + "\"/>\n" else "") +
        (if (null != RTSSE) "\t\t<cim:EnergyTypeCode.RTSSE rdf:resource=\"#" + RTSSE + "\"/>\n" else "") +
        (if (null != SE) "\t\t<cim:EnergyTypeCode.SE rdf:resource=\"#" + SE + "\"/>\n" else "") +
        (if (null != SRE) "\t\t<cim:EnergyTypeCode.SRE rdf:resource=\"#" + SRE + "\"/>\n" else "") +
        (if (null != TEE) "\t\t<cim:EnergyTypeCode.TEE rdf:resource=\"#" + TEE + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EnergyTypeCode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergyTypeCode>\n"
    }
}

object EnergyTypeCode
extends
    Parseable[EnergyTypeCode]
{
    val DABE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.DABE"""))
    val DAPE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.DAPE"""))
    val DASE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.DASE"""))
    val DMLE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.DMLE"""))
    val DSSE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.DSSE"""))
    val EDE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.EDE"""))
    val HASE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.HASE"""))
    val MLE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.MLE"""))
    val MSSLFE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.MSSLFE"""))
    val OE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.OE"""))
    val PE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.PE"""))
    val RE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.RE"""))
    val RED: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.RED"""))
    val RMRE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.RMRE"""))
    val RTSSE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.RTSSE"""))
    val SE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.SE"""))
    val SRE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.SRE"""))
    val TEE: (Context) => String = parse_attribute (attribute ("""EnergyTypeCode.TEE"""))
    def parse (context: Context): EnergyTypeCode =
    {
        EnergyTypeCode(
            BasicElement.parse (context),
            DABE (context),
            DAPE (context),
            DASE (context),
            DMLE (context),
            DSSE (context),
            EDE (context),
            HASE (context),
            MLE (context),
            MSSLFE (context),
            OE (context),
            PE (context),
            RE (context),
            RED (context),
            RMRE (context),
            RTSSE (context),
            SE (context),
            SRE (context),
            TEE (context)
        )
    }
}

case class JobFlagType
(
    override val sup: BasicElement,
    CREATED: String,
    DELETED: String,
    MODIFIED: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[JobFlagType] }
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
        sup.export_fields +
        (if (null != CREATED) "\t\t<cim:JobFlagType.CREATED rdf:resource=\"#" + CREATED + "\"/>\n" else "") +
        (if (null != DELETED) "\t\t<cim:JobFlagType.DELETED rdf:resource=\"#" + DELETED + "\"/>\n" else "") +
        (if (null != MODIFIED) "\t\t<cim:JobFlagType.MODIFIED rdf:resource=\"#" + MODIFIED + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:JobFlagType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:JobFlagType>\n"
    }
}

object JobFlagType
extends
    Parseable[JobFlagType]
{
    val CREATED: (Context) => String = parse_attribute (attribute ("""JobFlagType.CREATED"""))
    val DELETED: (Context) => String = parse_attribute (attribute ("""JobFlagType.DELETED"""))
    val MODIFIED: (Context) => String = parse_attribute (attribute ("""JobFlagType.MODIFIED"""))
    def parse (context: Context): JobFlagType =
    {
        JobFlagType(
            BasicElement.parse (context),
            CREATED (context),
            DELETED (context),
            MODIFIED (context)
        )
    }
}

case class JobScheduleType
(
    override val sup: BasicElement,
    CRITICAL: String,
    NONCRITICAL: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[JobScheduleType] }
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
        sup.export_fields +
        (if (null != CRITICAL) "\t\t<cim:JobScheduleType.CRITICAL rdf:resource=\"#" + CRITICAL + "\"/>\n" else "") +
        (if (null != NONCRITICAL) "\t\t<cim:JobScheduleType.NONCRITICAL rdf:resource=\"#" + NONCRITICAL + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:JobScheduleType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:JobScheduleType>\n"
    }
}

object JobScheduleType
extends
    Parseable[JobScheduleType]
{
    val CRITICAL: (Context) => String = parse_attribute (attribute ("""JobScheduleType.CRITICAL"""))
    val NONCRITICAL: (Context) => String = parse_attribute (attribute ("""JobScheduleType.NONCRITICAL"""))
    def parse (context: Context): JobScheduleType =
    {
        JobScheduleType(
            BasicElement.parse (context),
            CRITICAL (context),
            NONCRITICAL (context)
        )
    }
}

case class JobStartEndType
(
    override val sup: BasicElement,
    END: String,
    NA: String,
    START: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[JobStartEndType] }
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
        sup.export_fields +
        (if (null != END) "\t\t<cim:JobStartEndType.END rdf:resource=\"#" + END + "\"/>\n" else "") +
        (if (null != NA) "\t\t<cim:JobStartEndType.NA rdf:resource=\"#" + NA + "\"/>\n" else "") +
        (if (null != START) "\t\t<cim:JobStartEndType.START rdf:resource=\"#" + START + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:JobStartEndType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:JobStartEndType>\n"
    }
}

object JobStartEndType
extends
    Parseable[JobStartEndType]
{
    val END: (Context) => String = parse_attribute (attribute ("""JobStartEndType.END"""))
    val NA: (Context) => String = parse_attribute (attribute ("""JobStartEndType.NA"""))
    val START: (Context) => String = parse_attribute (attribute ("""JobStartEndType.START"""))
    def parse (context: Context): JobStartEndType =
    {
        JobStartEndType(
            BasicElement.parse (context),
            END (context),
            NA (context),
            START (context)
        )
    }
}

case class LFCResourceType
(
    override val sup: BasicElement,
    GEN: String,
    PUMP: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[LFCResourceType] }
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
        sup.export_fields +
        (if (null != GEN) "\t\t<cim:LFCResourceType.GEN rdf:resource=\"#" + GEN + "\"/>\n" else "") +
        (if (null != PUMP) "\t\t<cim:LFCResourceType.PUMP rdf:resource=\"#" + PUMP + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LFCResourceType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LFCResourceType>\n"
    }
}

object LFCResourceType
extends
    Parseable[LFCResourceType]
{
    val GEN: (Context) => String = parse_attribute (attribute ("""LFCResourceType.GEN"""))
    val PUMP: (Context) => String = parse_attribute (attribute ("""LFCResourceType.PUMP"""))
    def parse (context: Context): LFCResourceType =
    {
        LFCResourceType(
            BasicElement.parse (context),
            GEN (context),
            PUMP (context)
        )
    }
}

case class LoadFollowingCapacityType
(
    override val sup: BasicElement,
    DOWN: String,
    UP: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[LoadFollowingCapacityType] }
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
        sup.export_fields +
        (if (null != DOWN) "\t\t<cim:LoadFollowingCapacityType.DOWN rdf:resource=\"#" + DOWN + "\"/>\n" else "") +
        (if (null != UP) "\t\t<cim:LoadFollowingCapacityType.UP rdf:resource=\"#" + UP + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LoadFollowingCapacityType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadFollowingCapacityType>\n"
    }
}

object LoadFollowingCapacityType
extends
    Parseable[LoadFollowingCapacityType]
{
    val DOWN: (Context) => String = parse_attribute (attribute ("""LoadFollowingCapacityType.DOWN"""))
    val UP: (Context) => String = parse_attribute (attribute ("""LoadFollowingCapacityType.UP"""))
    def parse (context: Context): LoadFollowingCapacityType =
    {
        LoadFollowingCapacityType(
            BasicElement.parse (context),
            DOWN (context),
            UP (context)
        )
    }
}

/**
 * ADD - add
DEL - delete
 * CHG - change
 * @param sup Reference to the superclass object.
 * @param ADD <em>undocumented</em>
 * @param CHG <em>undocumented</em>
 * @param DEL <em>undocumented</em>
 */
case class MQSDELType
(
    override val sup: BasicElement,
    ADD: String,
    CHG: String,
    DEL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MQSDELType] }
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
        sup.export_fields +
        (if (null != ADD) "\t\t<cim:MQSDELType.ADD rdf:resource=\"#" + ADD + "\"/>\n" else "") +
        (if (null != CHG) "\t\t<cim:MQSDELType.CHG rdf:resource=\"#" + CHG + "\"/>\n" else "") +
        (if (null != DEL) "\t\t<cim:MQSDELType.DEL rdf:resource=\"#" + DEL + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MQSDELType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MQSDELType>\n"
    }
}

object MQSDELType
extends
    Parseable[MQSDELType]
{
    val ADD: (Context) => String = parse_attribute (attribute ("""MQSDELType.ADD"""))
    val CHG: (Context) => String = parse_attribute (attribute ("""MQSDELType.CHG"""))
    val DEL: (Context) => String = parse_attribute (attribute ("""MQSDELType.DEL"""))
    def parse (context: Context): MQSDELType =
    {
        MQSDELType(
            BasicElement.parse (context),
            ADD (context),
            CHG (context),
            DEL (context)
        )
    }
}

/**
 * RU - Regulation Up
RD - Regulation Down
SR - Spin Reserve
NR - Nonspin Reserve
 * AS - Upward Ancillary Service
 * @param sup Reference to the superclass object.
 * @param AS <em>undocumented</em>
 * @param NR non spinning reserve
 * @param RD regulation down
 * @param RU regulation up
 * @param SR spinning reserve
 */
case class MarketProductTypeAsReq
(
    override val sup: BasicElement,
    AS: String,
    NR: String,
    RD: String,
    RU: String,
    SR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketProductTypeAsReq] }
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
        sup.export_fields +
        (if (null != AS) "\t\t<cim:MarketProductTypeAsReq.AS rdf:resource=\"#" + AS + "\"/>\n" else "") +
        (if (null != NR) "\t\t<cim:MarketProductTypeAsReq.NR rdf:resource=\"#" + NR + "\"/>\n" else "") +
        (if (null != RD) "\t\t<cim:MarketProductTypeAsReq.RD rdf:resource=\"#" + RD + "\"/>\n" else "") +
        (if (null != RU) "\t\t<cim:MarketProductTypeAsReq.RU rdf:resource=\"#" + RU + "\"/>\n" else "") +
        (if (null != SR) "\t\t<cim:MarketProductTypeAsReq.SR rdf:resource=\"#" + SR + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketProductTypeAsReq rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketProductTypeAsReq>\n"
    }
}

object MarketProductTypeAsReq
extends
    Parseable[MarketProductTypeAsReq]
{
    val AS: (Context) => String = parse_attribute (attribute ("""MarketProductTypeAsReq.AS"""))
    val NR: (Context) => String = parse_attribute (attribute ("""MarketProductTypeAsReq.NR"""))
    val RD: (Context) => String = parse_attribute (attribute ("""MarketProductTypeAsReq.RD"""))
    val RU: (Context) => String = parse_attribute (attribute ("""MarketProductTypeAsReq.RU"""))
    val SR: (Context) => String = parse_attribute (attribute ("""MarketProductTypeAsReq.SR"""))
    def parse (context: Context): MarketProductTypeAsReq =
    {
        MarketProductTypeAsReq(
            BasicElement.parse (context),
            AS (context),
            NR (context),
            RD (context),
            RU (context),
            SR (context)
        )
    }
}

case class MarketScheduleServices
(
    override val sup: BasicElement,
    retrieveDefaultBidCurves: String,
    retrieveMPMResults: String,
    retrieveMarketAwards: String,
    retrieveSchedulePrices: String,
    retrieveStartUpShutDownInstructions: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketScheduleServices] }
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
        sup.export_fields +
        (if (null != retrieveDefaultBidCurves) "\t\t<cim:MarketScheduleServices.retrieveDefaultBidCurves rdf:resource=\"#" + retrieveDefaultBidCurves + "\"/>\n" else "") +
        (if (null != retrieveMPMResults) "\t\t<cim:MarketScheduleServices.retrieveMPMResults rdf:resource=\"#" + retrieveMPMResults + "\"/>\n" else "") +
        (if (null != retrieveMarketAwards) "\t\t<cim:MarketScheduleServices.retrieveMarketAwards rdf:resource=\"#" + retrieveMarketAwards + "\"/>\n" else "") +
        (if (null != retrieveSchedulePrices) "\t\t<cim:MarketScheduleServices.retrieveSchedulePrices rdf:resource=\"#" + retrieveSchedulePrices + "\"/>\n" else "") +
        (if (null != retrieveStartUpShutDownInstructions) "\t\t<cim:MarketScheduleServices.retrieveStartUpShutDownInstructions rdf:resource=\"#" + retrieveStartUpShutDownInstructions + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketScheduleServices rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketScheduleServices>\n"
    }
}

object MarketScheduleServices
extends
    Parseable[MarketScheduleServices]
{
    val retrieveDefaultBidCurves: (Context) => String = parse_attribute (attribute ("""MarketScheduleServices.retrieveDefaultBidCurves"""))
    val retrieveMPMResults: (Context) => String = parse_attribute (attribute ("""MarketScheduleServices.retrieveMPMResults"""))
    val retrieveMarketAwards: (Context) => String = parse_attribute (attribute ("""MarketScheduleServices.retrieveMarketAwards"""))
    val retrieveSchedulePrices: (Context) => String = parse_attribute (attribute ("""MarketScheduleServices.retrieveSchedulePrices"""))
    val retrieveStartUpShutDownInstructions: (Context) => String = parse_attribute (attribute ("""MarketScheduleServices.retrieveStartUpShutDownInstructions"""))
    def parse (context: Context): MarketScheduleServices =
    {
        MarketScheduleServices(
            BasicElement.parse (context),
            retrieveDefaultBidCurves (context),
            retrieveMPMResults (context),
            retrieveMarketAwards (context),
            retrieveSchedulePrices (context),
            retrieveStartUpShutDownInstructions (context)
        )
    }
}

/**
 * Description of market statement
 * @param sup Reference to the superclass object.
 * @param DAILY_INITIAL_CREDIT <em>undocumented</em>
 * @param DAILY_INITIAL_MARKET <em>undocumented</em>
 * @param DAILY_RECALC_MARKET <em>undocumented</em>
 * @param MONTHLY_INITIAL_MARKET <em>undocumented</em>
 * @param MONTHLY_RECALC_MARKET <em>undocumented</em>
 */
case class MarketStatementDescription
(
    override val sup: BasicElement,
    DAILY_INITIAL_CREDIT: String,
    DAILY_INITIAL_MARKET: String,
    DAILY_RECALC_MARKET: String,
    MONTHLY_INITIAL_MARKET: String,
    MONTHLY_RECALC_MARKET: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketStatementDescription] }
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
        sup.export_fields +
        (if (null != DAILY_INITIAL_CREDIT) "\t\t<cim:MarketStatementDescription.DAILY_INITIAL_CREDIT rdf:resource=\"#" + DAILY_INITIAL_CREDIT + "\"/>\n" else "") +
        (if (null != DAILY_INITIAL_MARKET) "\t\t<cim:MarketStatementDescription.DAILY_INITIAL_MARKET rdf:resource=\"#" + DAILY_INITIAL_MARKET + "\"/>\n" else "") +
        (if (null != DAILY_RECALC_MARKET) "\t\t<cim:MarketStatementDescription.DAILY_RECALC_MARKET rdf:resource=\"#" + DAILY_RECALC_MARKET + "\"/>\n" else "") +
        (if (null != MONTHLY_INITIAL_MARKET) "\t\t<cim:MarketStatementDescription.MONTHLY_INITIAL_MARKET rdf:resource=\"#" + MONTHLY_INITIAL_MARKET + "\"/>\n" else "") +
        (if (null != MONTHLY_RECALC_MARKET) "\t\t<cim:MarketStatementDescription.MONTHLY_RECALC_MARKET rdf:resource=\"#" + MONTHLY_RECALC_MARKET + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketStatementDescription rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketStatementDescription>\n"
    }
}

object MarketStatementDescription
extends
    Parseable[MarketStatementDescription]
{
    val DAILY_INITIAL_CREDIT: (Context) => String = parse_attribute (attribute ("""MarketStatementDescription.DAILY_INITIAL_CREDIT"""))
    val DAILY_INITIAL_MARKET: (Context) => String = parse_attribute (attribute ("""MarketStatementDescription.DAILY_INITIAL_MARKET"""))
    val DAILY_RECALC_MARKET: (Context) => String = parse_attribute (attribute ("""MarketStatementDescription.DAILY_RECALC_MARKET"""))
    val MONTHLY_INITIAL_MARKET: (Context) => String = parse_attribute (attribute ("""MarketStatementDescription.MONTHLY_INITIAL_MARKET"""))
    val MONTHLY_RECALC_MARKET: (Context) => String = parse_attribute (attribute ("""MarketStatementDescription.MONTHLY_RECALC_MARKET"""))
    def parse (context: Context): MarketStatementDescription =
    {
        MarketStatementDescription(
            BasicElement.parse (context),
            DAILY_INITIAL_CREDIT (context),
            DAILY_INITIAL_MARKET (context),
            DAILY_RECALC_MARKET (context),
            MONTHLY_INITIAL_MARKET (context),
            MONTHLY_RECALC_MARKET (context)
        )
    }
}

/**
 * market statement document status
 * @param sup Reference to the superclass object.
 * @param APPROVED <em>undocumented</em>
 * @param CANCELLED <em>undocumented</em>
 */
case class MarketStatementDocStatus
(
    override val sup: BasicElement,
    APPROVED: String,
    CANCELLED: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketStatementDocStatus] }
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
        sup.export_fields +
        (if (null != APPROVED) "\t\t<cim:MarketStatementDocStatus.APPROVED rdf:resource=\"#" + APPROVED + "\"/>\n" else "") +
        (if (null != CANCELLED) "\t\t<cim:MarketStatementDocStatus.CANCELLED rdf:resource=\"#" + CANCELLED + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketStatementDocStatus rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketStatementDocStatus>\n"
    }
}

object MarketStatementDocStatus
extends
    Parseable[MarketStatementDocStatus]
{
    val APPROVED: (Context) => String = parse_attribute (attribute ("""MarketStatementDocStatus.APPROVED"""))
    val CANCELLED: (Context) => String = parse_attribute (attribute ("""MarketStatementDocStatus.CANCELLED"""))
    def parse (context: Context): MarketStatementDocStatus =
    {
        MarketStatementDocStatus(
            BasicElement.parse (context),
            APPROVED (context),
            CANCELLED (context)
        )
    }
}

/**
 * market statement document type
 * @param sup Reference to the superclass object.
 * @param CREDIT <em>undocumented</em>
 * @param MARKET_INITIAL <em>undocumented</em>
 * @param MARKET_RECALC <em>undocumented</em>
 */
case class MarketStatementDocType
(
    override val sup: BasicElement,
    CREDIT: String,
    MARKET_INITIAL: String,
    MARKET_RECALC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketStatementDocType] }
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
        sup.export_fields +
        (if (null != CREDIT) "\t\t<cim:MarketStatementDocType.CREDIT rdf:resource=\"#" + CREDIT + "\"/>\n" else "") +
        (if (null != MARKET_INITIAL) "\t\t<cim:MarketStatementDocType.MARKET_INITIAL rdf:resource=\"#" + MARKET_INITIAL + "\"/>\n" else "") +
        (if (null != MARKET_RECALC) "\t\t<cim:MarketStatementDocType.MARKET_RECALC rdf:resource=\"#" + MARKET_RECALC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketStatementDocType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketStatementDocType>\n"
    }
}

object MarketStatementDocType
extends
    Parseable[MarketStatementDocType]
{
    val CREDIT: (Context) => String = parse_attribute (attribute ("""MarketStatementDocType.CREDIT"""))
    val MARKET_INITIAL: (Context) => String = parse_attribute (attribute ("""MarketStatementDocType.MARKET_INITIAL"""))
    val MARKET_RECALC: (Context) => String = parse_attribute (attribute ("""MarketStatementDocType.MARKET_RECALC"""))
    def parse (context: Context): MarketStatementDocType =
    {
        MarketStatementDocType(
            BasicElement.parse (context),
            CREDIT (context),
            MARKET_INITIAL (context),
            MARKET_RECALC (context)
        )
    }
}

/**
 * market statement line item alias name
 * @param sup Reference to the superclass object.
 * @param CHARGE_CODE_INTERVAL_DETAIL <em>undocumented</em>
 * @param CHARGE_CODE_INTERVAL_TOTAL <em>undocumented</em>
 * @param CHARGE_CODE_SUMMARY <em>undocumented</em>
 * @param CHARGE_GROUP <em>undocumented</em>
 * @param PARENT_CHARGE_GROUP <em>undocumented</em>
 * @param TRADE_DATE <em>undocumented</em>
 */
case class MarketStatementLineItemAliasName
(
    override val sup: BasicElement,
    CHARGE_CODE_INTERVAL_DETAIL: String,
    CHARGE_CODE_INTERVAL_TOTAL: String,
    CHARGE_CODE_SUMMARY: String,
    CHARGE_GROUP: String,
    PARENT_CHARGE_GROUP: String,
    TRADE_DATE: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketStatementLineItemAliasName] }
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
        sup.export_fields +
        (if (null != CHARGE_CODE_INTERVAL_DETAIL) "\t\t<cim:MarketStatementLineItemAliasName.CHARGE_CODE_INTERVAL_DETAIL rdf:resource=\"#" + CHARGE_CODE_INTERVAL_DETAIL + "\"/>\n" else "") +
        (if (null != CHARGE_CODE_INTERVAL_TOTAL) "\t\t<cim:MarketStatementLineItemAliasName.CHARGE_CODE_INTERVAL_TOTAL rdf:resource=\"#" + CHARGE_CODE_INTERVAL_TOTAL + "\"/>\n" else "") +
        (if (null != CHARGE_CODE_SUMMARY) "\t\t<cim:MarketStatementLineItemAliasName.CHARGE_CODE_SUMMARY rdf:resource=\"#" + CHARGE_CODE_SUMMARY + "\"/>\n" else "") +
        (if (null != CHARGE_GROUP) "\t\t<cim:MarketStatementLineItemAliasName.CHARGE_GROUP rdf:resource=\"#" + CHARGE_GROUP + "\"/>\n" else "") +
        (if (null != PARENT_CHARGE_GROUP) "\t\t<cim:MarketStatementLineItemAliasName.PARENT_CHARGE_GROUP rdf:resource=\"#" + PARENT_CHARGE_GROUP + "\"/>\n" else "") +
        (if (null != TRADE_DATE) "\t\t<cim:MarketStatementLineItemAliasName.TRADE_DATE rdf:resource=\"#" + TRADE_DATE + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketStatementLineItemAliasName rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketStatementLineItemAliasName>\n"
    }
}

object MarketStatementLineItemAliasName
extends
    Parseable[MarketStatementLineItemAliasName]
{
    val CHARGE_CODE_INTERVAL_DETAIL: (Context) => String = parse_attribute (attribute ("""MarketStatementLineItemAliasName.CHARGE_CODE_INTERVAL_DETAIL"""))
    val CHARGE_CODE_INTERVAL_TOTAL: (Context) => String = parse_attribute (attribute ("""MarketStatementLineItemAliasName.CHARGE_CODE_INTERVAL_TOTAL"""))
    val CHARGE_CODE_SUMMARY: (Context) => String = parse_attribute (attribute ("""MarketStatementLineItemAliasName.CHARGE_CODE_SUMMARY"""))
    val CHARGE_GROUP: (Context) => String = parse_attribute (attribute ("""MarketStatementLineItemAliasName.CHARGE_GROUP"""))
    val PARENT_CHARGE_GROUP: (Context) => String = parse_attribute (attribute ("""MarketStatementLineItemAliasName.PARENT_CHARGE_GROUP"""))
    val TRADE_DATE: (Context) => String = parse_attribute (attribute ("""MarketStatementLineItemAliasName.TRADE_DATE"""))
    def parse (context: Context): MarketStatementLineItemAliasName =
    {
        MarketStatementLineItemAliasName(
            BasicElement.parse (context),
            CHARGE_CODE_INTERVAL_DETAIL (context),
            CHARGE_CODE_INTERVAL_TOTAL (context),
            CHARGE_CODE_SUMMARY (context),
            CHARGE_GROUP (context),
            PARENT_CHARGE_GROUP (context),
            TRADE_DATE (context)
        )
    }
}

/**
 * Path Flow - PF
Path Inflow Limit - PIL
Path Inflow Available Limit - PIAL 
Path Inflow Armed Limit - PIML
Path Outflow Limit - POL
Path Outflow Available Limit - POAL 
Path Outflow Armed Limit - OARL
Generation Output - GO 
Generation Max Operating Limit - GMOL 
Generation Min Operating Limit - GNOL 
Generation Regulation - GR 
Generation Status - GS 
Pump Production - PP 
System Load - SL 
System ACE - ACE
 * System INADV - INADV
 * @param sup Reference to the superclass object.
 * @param ACE <em>undocumented</em>
 * @param GMOL <em>undocumented</em>
 * @param GNOL <em>undocumented</em>
 * @param GO <em>undocumented</em>
 * @param GR <em>undocumented</em>
 * @param GS <em>undocumented</em>
 * @param INADV <em>undocumented</em>
 * @param OARL <em>undocumented</em>
 * @param PF <em>undocumented</em>
 * @param PIAL <em>undocumented</em>
 * @param PIL <em>undocumented</em>
 * @param PIML <em>undocumented</em>
 * @param POAL <em>undocumented</em>
 * @param POL <em>undocumented</em>
 * @param PP <em>undocumented</em>
 * @param SL <em>undocumented</em>
 */
case class MeasurementTypeEMS
(
    override val sup: BasicElement,
    ACE: String,
    GMOL: String,
    GNOL: String,
    GO: String,
    GR: String,
    GS: String,
    INADV: String,
    OARL: String,
    PF: String,
    PIAL: String,
    PIL: String,
    PIML: String,
    POAL: String,
    POL: String,
    PP: String,
    SL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MeasurementTypeEMS] }
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
        sup.export_fields +
        (if (null != ACE) "\t\t<cim:MeasurementTypeEMS.ACE rdf:resource=\"#" + ACE + "\"/>\n" else "") +
        (if (null != GMOL) "\t\t<cim:MeasurementTypeEMS.GMOL rdf:resource=\"#" + GMOL + "\"/>\n" else "") +
        (if (null != GNOL) "\t\t<cim:MeasurementTypeEMS.GNOL rdf:resource=\"#" + GNOL + "\"/>\n" else "") +
        (if (null != GO) "\t\t<cim:MeasurementTypeEMS.GO rdf:resource=\"#" + GO + "\"/>\n" else "") +
        (if (null != GR) "\t\t<cim:MeasurementTypeEMS.GR rdf:resource=\"#" + GR + "\"/>\n" else "") +
        (if (null != GS) "\t\t<cim:MeasurementTypeEMS.GS rdf:resource=\"#" + GS + "\"/>\n" else "") +
        (if (null != INADV) "\t\t<cim:MeasurementTypeEMS.INADV rdf:resource=\"#" + INADV + "\"/>\n" else "") +
        (if (null != OARL) "\t\t<cim:MeasurementTypeEMS.OARL rdf:resource=\"#" + OARL + "\"/>\n" else "") +
        (if (null != PF) "\t\t<cim:MeasurementTypeEMS.PF rdf:resource=\"#" + PF + "\"/>\n" else "") +
        (if (null != PIAL) "\t\t<cim:MeasurementTypeEMS.PIAL rdf:resource=\"#" + PIAL + "\"/>\n" else "") +
        (if (null != PIL) "\t\t<cim:MeasurementTypeEMS.PIL rdf:resource=\"#" + PIL + "\"/>\n" else "") +
        (if (null != PIML) "\t\t<cim:MeasurementTypeEMS.PIML rdf:resource=\"#" + PIML + "\"/>\n" else "") +
        (if (null != POAL) "\t\t<cim:MeasurementTypeEMS.POAL rdf:resource=\"#" + POAL + "\"/>\n" else "") +
        (if (null != POL) "\t\t<cim:MeasurementTypeEMS.POL rdf:resource=\"#" + POL + "\"/>\n" else "") +
        (if (null != PP) "\t\t<cim:MeasurementTypeEMS.PP rdf:resource=\"#" + PP + "\"/>\n" else "") +
        (if (null != SL) "\t\t<cim:MeasurementTypeEMS.SL rdf:resource=\"#" + SL + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MeasurementTypeEMS rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MeasurementTypeEMS>\n"
    }
}

object MeasurementTypeEMS
extends
    Parseable[MeasurementTypeEMS]
{
    val ACE: (Context) => String = parse_attribute (attribute ("""MeasurementTypeEMS.ACE"""))
    val GMOL: (Context) => String = parse_attribute (attribute ("""MeasurementTypeEMS.GMOL"""))
    val GNOL: (Context) => String = parse_attribute (attribute ("""MeasurementTypeEMS.GNOL"""))
    val GO: (Context) => String = parse_attribute (attribute ("""MeasurementTypeEMS.GO"""))
    val GR: (Context) => String = parse_attribute (attribute ("""MeasurementTypeEMS.GR"""))
    val GS: (Context) => String = parse_attribute (attribute ("""MeasurementTypeEMS.GS"""))
    val INADV: (Context) => String = parse_attribute (attribute ("""MeasurementTypeEMS.INADV"""))
    val OARL: (Context) => String = parse_attribute (attribute ("""MeasurementTypeEMS.OARL"""))
    val PF: (Context) => String = parse_attribute (attribute ("""MeasurementTypeEMS.PF"""))
    val PIAL: (Context) => String = parse_attribute (attribute ("""MeasurementTypeEMS.PIAL"""))
    val PIL: (Context) => String = parse_attribute (attribute ("""MeasurementTypeEMS.PIL"""))
    val PIML: (Context) => String = parse_attribute (attribute ("""MeasurementTypeEMS.PIML"""))
    val POAL: (Context) => String = parse_attribute (attribute ("""MeasurementTypeEMS.POAL"""))
    val POL: (Context) => String = parse_attribute (attribute ("""MeasurementTypeEMS.POL"""))
    val PP: (Context) => String = parse_attribute (attribute ("""MeasurementTypeEMS.PP"""))
    val SL: (Context) => String = parse_attribute (attribute ("""MeasurementTypeEMS.SL"""))
    def parse (context: Context): MeasurementTypeEMS =
    {
        MeasurementTypeEMS(
            BasicElement.parse (context),
            ACE (context),
            GMOL (context),
            GNOL (context),
            GO (context),
            GR (context),
            GS (context),
            INADV (context),
            OARL (context),
            PF (context),
            PIAL (context),
            PIL (context),
            PIML (context),
            POAL (context),
            POL (context),
            PP (context),
            SL (context)
        )
    }
}

case class MktSubClassType
(
    override val sup: BasicElement,
    Branch_Group_Derates: String,
    Day_Ahead_Final_Market_Info: String,
    Day_Ahead_Forecast_Information: String,
    Day_Ahead_Interim_Market_Info: String,
    Day_Ahead_RMR: String,
    Forecasted_UDC_Direct_Access_Load: String,
    Hour_Ahead_Market_Info: String,
    Hourly_Expost_Market_Info: String,
    Public_Bid_Data: String,
    TTC_ATC_Forecast_Information: String,
    TTC_ATC_Hourly_Forecast: String,
    Ten_Min_Expost_Market_Info: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MktSubClassType] }
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
        sup.export_fields +
        (if (null != Branch_Group_Derates) "\t\t<cim:MktSubClassType.Branch_Group_Derates rdf:resource=\"#" + Branch_Group_Derates + "\"/>\n" else "") +
        (if (null != Day_Ahead_Final_Market_Info) "\t\t<cim:MktSubClassType.Day_Ahead_Final_Market_Info rdf:resource=\"#" + Day_Ahead_Final_Market_Info + "\"/>\n" else "") +
        (if (null != Day_Ahead_Forecast_Information) "\t\t<cim:MktSubClassType.Day_Ahead_Forecast_Information rdf:resource=\"#" + Day_Ahead_Forecast_Information + "\"/>\n" else "") +
        (if (null != Day_Ahead_Interim_Market_Info) "\t\t<cim:MktSubClassType.Day_Ahead_Interim_Market_Info rdf:resource=\"#" + Day_Ahead_Interim_Market_Info + "\"/>\n" else "") +
        (if (null != Day_Ahead_RMR) "\t\t<cim:MktSubClassType.Day_Ahead_RMR rdf:resource=\"#" + Day_Ahead_RMR + "\"/>\n" else "") +
        (if (null != Forecasted_UDC_Direct_Access_Load) "\t\t<cim:MktSubClassType.Forecasted_UDC_Direct_Access_Load rdf:resource=\"#" + Forecasted_UDC_Direct_Access_Load + "\"/>\n" else "") +
        (if (null != Hour_Ahead_Market_Info) "\t\t<cim:MktSubClassType.Hour_Ahead_Market_Info rdf:resource=\"#" + Hour_Ahead_Market_Info + "\"/>\n" else "") +
        (if (null != Hourly_Expost_Market_Info) "\t\t<cim:MktSubClassType.Hourly_Expost_Market_Info rdf:resource=\"#" + Hourly_Expost_Market_Info + "\"/>\n" else "") +
        (if (null != Public_Bid_Data) "\t\t<cim:MktSubClassType.Public_Bid_Data rdf:resource=\"#" + Public_Bid_Data + "\"/>\n" else "") +
        (if (null != TTC_ATC_Forecast_Information) "\t\t<cim:MktSubClassType.TTC/ATC_Forecast_Information rdf:resource=\"#" + TTC_ATC_Forecast_Information + "\"/>\n" else "") +
        (if (null != TTC_ATC_Hourly_Forecast) "\t\t<cim:MktSubClassType.TTC/ATC_Hourly_Forecast rdf:resource=\"#" + TTC_ATC_Hourly_Forecast + "\"/>\n" else "") +
        (if (null != Ten_Min_Expost_Market_Info) "\t\t<cim:MktSubClassType.Ten_Min_Expost_Market_Info rdf:resource=\"#" + Ten_Min_Expost_Market_Info + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktSubClassType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktSubClassType>\n"
    }
}

object MktSubClassType
extends
    Parseable[MktSubClassType]
{
    val Branch_Group_Derates: (Context) => String = parse_attribute (attribute ("""MktSubClassType.Branch_Group_Derates"""))
    val Day_Ahead_Final_Market_Info: (Context) => String = parse_attribute (attribute ("""MktSubClassType.Day_Ahead_Final_Market_Info"""))
    val Day_Ahead_Forecast_Information: (Context) => String = parse_attribute (attribute ("""MktSubClassType.Day_Ahead_Forecast_Information"""))
    val Day_Ahead_Interim_Market_Info: (Context) => String = parse_attribute (attribute ("""MktSubClassType.Day_Ahead_Interim_Market_Info"""))
    val Day_Ahead_RMR: (Context) => String = parse_attribute (attribute ("""MktSubClassType.Day_Ahead_RMR"""))
    val Forecasted_UDC_Direct_Access_Load: (Context) => String = parse_attribute (attribute ("""MktSubClassType.Forecasted_UDC_Direct_Access_Load"""))
    val Hour_Ahead_Market_Info: (Context) => String = parse_attribute (attribute ("""MktSubClassType.Hour_Ahead_Market_Info"""))
    val Hourly_Expost_Market_Info: (Context) => String = parse_attribute (attribute ("""MktSubClassType.Hourly_Expost_Market_Info"""))
    val Public_Bid_Data: (Context) => String = parse_attribute (attribute ("""MktSubClassType.Public_Bid_Data"""))
    val TTC_ATC_Forecast_Information: (Context) => String = parse_attribute (attribute ("""MktSubClassType.TTC/ATC_Forecast_Information"""))
    val TTC_ATC_Hourly_Forecast: (Context) => String = parse_attribute (attribute ("""MktSubClassType.TTC/ATC_Hourly_Forecast"""))
    val Ten_Min_Expost_Market_Info: (Context) => String = parse_attribute (attribute ("""MktSubClassType.Ten_Min_Expost_Market_Info"""))
    def parse (context: Context): MktSubClassType =
    {
        MktSubClassType(
            BasicElement.parse (context),
            Branch_Group_Derates (context),
            Day_Ahead_Final_Market_Info (context),
            Day_Ahead_Forecast_Information (context),
            Day_Ahead_Interim_Market_Info (context),
            Day_Ahead_RMR (context),
            Forecasted_UDC_Direct_Access_Load (context),
            Hour_Ahead_Market_Info (context),
            Hourly_Expost_Market_Info (context),
            Public_Bid_Data (context),
            TTC_ATC_Forecast_Information (context),
            TTC_ATC_Hourly_Forecast (context),
            Ten_Min_Expost_Market_Info (context)
        )
    }
}

case class OASISBidReportType
(
    override val sup: BasicElement,
    BIDS_PUBLIC: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OASISBidReportType] }
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
        sup.export_fields +
        (if (null != BIDS_PUBLIC) "\t\t<cim:OASISBidReportType.BIDS_PUBLIC rdf:resource=\"#" + BIDS_PUBLIC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OASISBidReportType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OASISBidReportType>\n"
    }
}

object OASISBidReportType
extends
    Parseable[OASISBidReportType]
{
    val BIDS_PUBLIC: (Context) => String = parse_attribute (attribute ("""OASISBidReportType.BIDS_PUBLIC"""))
    def parse (context: Context): OASISBidReportType =
    {
        OASISBidReportType(
            BasicElement.parse (context),
            BIDS_PUBLIC (context)
        )
    }
}

case class OASISDataItems
(
    override val sup: BasicElement,
    AS_CLEAR_ASMP_IFM: String,
    AS_CLEAR_ASMP_RTM: String,
    AS_CLEAR_COST_IFM: String,
    AS_CLEAR_COST_RTM: String,
    AS_CLEAR_MW_IFM: String,
    AS_CLEAR_MW_RTM: String,
    AS_GEN_TOTAL_MW_IFM: String,
    AS_GEN_TOTAL_MW_RTM: String,
    AS_IMP_TOTAL_MW_IFM: String,
    AS_IMP_TOTAL_MW_RTM: String,
    AS_LOAD_TOTAL_MW_IFM: String,
    AS_LOAD_TOTAL_MW_RTM: String,
    AS_REGION_REQ_MAX: String,
    AS_REGION_REQ_MIN: String,
    AS_REGION_value: String,
    AS_SELF_MW_IFM: String,
    AS_SELF_MW_RTM: String,
    AS_TOTAL_MW: String,
    AS_TOTAL_MW_IFM: String,
    AS_TOTAL_MW_RTM: String,
    AS_TYPE: String,
    AS_USER_RATE: String,
    CA_value: String,
    CMMT_MINLOAD_MLC: String,
    CMMT_MINLOAD_MW: String,
    CMMT_RA_MLC: String,
    CMMT_RA_MW: String,
    CMMT_RA_START_COST: String,
    CMMT_RA_UNITS: String,
    CMMT_TOTAL_MW: String,
    CMMT_TOTAL_START_COST: String,
    CMMT_TOTAL_UNITS: String,
    CRR_CAT: String,
    CRR_MARKET_value: String,
    CRR_MW: String,
    CRR_NSR: String,
    CRR_OPTION: String,
    CRR_OWNER: String,
    CRR_SEGMENT: String,
    CRR_TERM: String,
    CRR_TOU: String,
    CRR_TYPE: String,
    ENE_EA_DA: String,
    ENE_EA_EXCEPT: String,
    ENE_EA_HASP: String,
    ENE_EA_MLE: String,
    ENE_EA_MSSLF: String,
    ENE_EA_OPTIMAL: String,
    ENE_EA_RAMP_DEV: String,
    ENE_EA_RAMP_STD: String,
    ENE_EA_RESIDUAL: String,
    ENE_EA_RMR: String,
    ENE_EA_SELF: String,
    ENE_EA_SLIC: String,
    ENE_EXP_CLEAR_HASP: String,
    ENE_EXP_CLEAR_IFM: String,
    ENE_EXP_CLEAR_RTM: String,
    ENE_GEN_CLEAR_HASP: String,
    ENE_GEN_CLEAR_IFM: String,
    ENE_GEN_CLEAR_RTM: String,
    ENE_IMP_CLEAR_HASP: String,
    ENE_IMP_CLEAR_IFM: String,
    ENE_IMP_CLEAR_RTM: String,
    ENE_LOAD_ACTUAL: String,
    ENE_LOAD_CLEAR_HASP: String,
    ENE_LOAD_CLEAR_IFM: String,
    ENE_LOAD_CLEAR_RTM: String,
    ENE_LOAD_FCST: String,
    ENE_PEAK_HOUR: String,
    ENE_PEAK_LOAD: String,
    FUEL_REGION_value: String,
    INVT_DATETIME: String,
    LOAD_ACTUAL: String,
    LOAD_CLEAR_RTM: String,
    LOSS_TOTAL_COST_HASP: String,
    LOSS_TOTAL_COST_RTM: String,
    LOSS_TOTAL_MW_HASP: String,
    LOSS_TOTAL_MW_RTM: String,
    MPM_FLAG: String,
    OP_RSRV_TOTAL: String,
    PRC_NG: String,
    PRC_SHADOW: String,
    RATING_ATC: String,
    RMR_DETER_DAM: String,
    RMR_DETER_HASP: String,
    RMR_DISPATCH_DAM: String,
    RMR_DISPATCH_HASP: String,
    RMR_TOTAL: String,
    RMR_TOTAL_AVAIL: String,
    RUC_GEN_CLEAR_RUC: String,
    RUC_IMP_CLEAR_RUC: String,
    RUC_LOAD_CLEAR_RUC: String,
    RUC_ZONE_value: String,
    TAC_AREA_value: String,
    TINTRFCE_value: String,
    TRNS_AS_IMPORT: String,
    TRNS_ENE_IMPORT: String,
    TRNS_EQUIP_value: String,
    TRNS_RATING_CBM: String,
    TRNS_RATING_DIRECTION: String,
    TRNS_RATING_OTC: String,
    TRNS_RATING_OTC_DERATE: String,
    TRNS_RATING_TTC: String,
    TRNS_TI_value: String,
    TRNS_TR_ENTMTS: String,
    TRNS_TR_USEAGE: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OASISDataItems] }
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
        sup.export_fields +
        (if (null != AS_CLEAR_ASMP_IFM) "\t\t<cim:OASISDataItems.AS_CLEAR_ASMP_IFM rdf:resource=\"#" + AS_CLEAR_ASMP_IFM + "\"/>\n" else "") +
        (if (null != AS_CLEAR_ASMP_RTM) "\t\t<cim:OASISDataItems.AS_CLEAR_ASMP_RTM rdf:resource=\"#" + AS_CLEAR_ASMP_RTM + "\"/>\n" else "") +
        (if (null != AS_CLEAR_COST_IFM) "\t\t<cim:OASISDataItems.AS_CLEAR_COST_IFM rdf:resource=\"#" + AS_CLEAR_COST_IFM + "\"/>\n" else "") +
        (if (null != AS_CLEAR_COST_RTM) "\t\t<cim:OASISDataItems.AS_CLEAR_COST_RTM rdf:resource=\"#" + AS_CLEAR_COST_RTM + "\"/>\n" else "") +
        (if (null != AS_CLEAR_MW_IFM) "\t\t<cim:OASISDataItems.AS_CLEAR_MW_IFM rdf:resource=\"#" + AS_CLEAR_MW_IFM + "\"/>\n" else "") +
        (if (null != AS_CLEAR_MW_RTM) "\t\t<cim:OASISDataItems.AS_CLEAR_MW_RTM rdf:resource=\"#" + AS_CLEAR_MW_RTM + "\"/>\n" else "") +
        (if (null != AS_GEN_TOTAL_MW_IFM) "\t\t<cim:OASISDataItems.AS_GEN_TOTAL_MW_IFM rdf:resource=\"#" + AS_GEN_TOTAL_MW_IFM + "\"/>\n" else "") +
        (if (null != AS_GEN_TOTAL_MW_RTM) "\t\t<cim:OASISDataItems.AS_GEN_TOTAL_MW_RTM rdf:resource=\"#" + AS_GEN_TOTAL_MW_RTM + "\"/>\n" else "") +
        (if (null != AS_IMP_TOTAL_MW_IFM) "\t\t<cim:OASISDataItems.AS_IMP_TOTAL_MW_IFM rdf:resource=\"#" + AS_IMP_TOTAL_MW_IFM + "\"/>\n" else "") +
        (if (null != AS_IMP_TOTAL_MW_RTM) "\t\t<cim:OASISDataItems.AS_IMP_TOTAL_MW_RTM rdf:resource=\"#" + AS_IMP_TOTAL_MW_RTM + "\"/>\n" else "") +
        (if (null != AS_LOAD_TOTAL_MW_IFM) "\t\t<cim:OASISDataItems.AS_LOAD_TOTAL_MW_IFM rdf:resource=\"#" + AS_LOAD_TOTAL_MW_IFM + "\"/>\n" else "") +
        (if (null != AS_LOAD_TOTAL_MW_RTM) "\t\t<cim:OASISDataItems.AS_LOAD_TOTAL_MW_RTM rdf:resource=\"#" + AS_LOAD_TOTAL_MW_RTM + "\"/>\n" else "") +
        (if (null != AS_REGION_REQ_MAX) "\t\t<cim:OASISDataItems.AS_REGION_REQ_MAX rdf:resource=\"#" + AS_REGION_REQ_MAX + "\"/>\n" else "") +
        (if (null != AS_REGION_REQ_MIN) "\t\t<cim:OASISDataItems.AS_REGION_REQ_MIN rdf:resource=\"#" + AS_REGION_REQ_MIN + "\"/>\n" else "") +
        (if (null != AS_REGION_value) "\t\t<cim:OASISDataItems.AS_REGION_value rdf:resource=\"#" + AS_REGION_value + "\"/>\n" else "") +
        (if (null != AS_SELF_MW_IFM) "\t\t<cim:OASISDataItems.AS_SELF_MW_IFM rdf:resource=\"#" + AS_SELF_MW_IFM + "\"/>\n" else "") +
        (if (null != AS_SELF_MW_RTM) "\t\t<cim:OASISDataItems.AS_SELF_MW_RTM rdf:resource=\"#" + AS_SELF_MW_RTM + "\"/>\n" else "") +
        (if (null != AS_TOTAL_MW) "\t\t<cim:OASISDataItems.AS_TOTAL_MW rdf:resource=\"#" + AS_TOTAL_MW + "\"/>\n" else "") +
        (if (null != AS_TOTAL_MW_IFM) "\t\t<cim:OASISDataItems.AS_TOTAL_MW_IFM rdf:resource=\"#" + AS_TOTAL_MW_IFM + "\"/>\n" else "") +
        (if (null != AS_TOTAL_MW_RTM) "\t\t<cim:OASISDataItems.AS_TOTAL_MW_RTM rdf:resource=\"#" + AS_TOTAL_MW_RTM + "\"/>\n" else "") +
        (if (null != AS_TYPE) "\t\t<cim:OASISDataItems.AS_TYPE rdf:resource=\"#" + AS_TYPE + "\"/>\n" else "") +
        (if (null != AS_USER_RATE) "\t\t<cim:OASISDataItems.AS_USER_RATE rdf:resource=\"#" + AS_USER_RATE + "\"/>\n" else "") +
        (if (null != CA_value) "\t\t<cim:OASISDataItems.CA_value rdf:resource=\"#" + CA_value + "\"/>\n" else "") +
        (if (null != CMMT_MINLOAD_MLC) "\t\t<cim:OASISDataItems.CMMT_MINLOAD_MLC rdf:resource=\"#" + CMMT_MINLOAD_MLC + "\"/>\n" else "") +
        (if (null != CMMT_MINLOAD_MW) "\t\t<cim:OASISDataItems.CMMT_MINLOAD_MW rdf:resource=\"#" + CMMT_MINLOAD_MW + "\"/>\n" else "") +
        (if (null != CMMT_RA_MLC) "\t\t<cim:OASISDataItems.CMMT_RA_MLC rdf:resource=\"#" + CMMT_RA_MLC + "\"/>\n" else "") +
        (if (null != CMMT_RA_MW) "\t\t<cim:OASISDataItems.CMMT_RA_MW rdf:resource=\"#" + CMMT_RA_MW + "\"/>\n" else "") +
        (if (null != CMMT_RA_START_COST) "\t\t<cim:OASISDataItems.CMMT_RA_START_COST rdf:resource=\"#" + CMMT_RA_START_COST + "\"/>\n" else "") +
        (if (null != CMMT_RA_UNITS) "\t\t<cim:OASISDataItems.CMMT_RA_UNITS rdf:resource=\"#" + CMMT_RA_UNITS + "\"/>\n" else "") +
        (if (null != CMMT_TOTAL_MW) "\t\t<cim:OASISDataItems.CMMT_TOTAL_MW rdf:resource=\"#" + CMMT_TOTAL_MW + "\"/>\n" else "") +
        (if (null != CMMT_TOTAL_START_COST) "\t\t<cim:OASISDataItems.CMMT_TOTAL_START_COST rdf:resource=\"#" + CMMT_TOTAL_START_COST + "\"/>\n" else "") +
        (if (null != CMMT_TOTAL_UNITS) "\t\t<cim:OASISDataItems.CMMT_TOTAL_UNITS rdf:resource=\"#" + CMMT_TOTAL_UNITS + "\"/>\n" else "") +
        (if (null != CRR_CAT) "\t\t<cim:OASISDataItems.CRR_CAT rdf:resource=\"#" + CRR_CAT + "\"/>\n" else "") +
        (if (null != CRR_MARKET_value) "\t\t<cim:OASISDataItems.CRR_MARKET_value rdf:resource=\"#" + CRR_MARKET_value + "\"/>\n" else "") +
        (if (null != CRR_MW) "\t\t<cim:OASISDataItems.CRR_MW rdf:resource=\"#" + CRR_MW + "\"/>\n" else "") +
        (if (null != CRR_NSR) "\t\t<cim:OASISDataItems.CRR_NSR rdf:resource=\"#" + CRR_NSR + "\"/>\n" else "") +
        (if (null != CRR_OPTION) "\t\t<cim:OASISDataItems.CRR_OPTION rdf:resource=\"#" + CRR_OPTION + "\"/>\n" else "") +
        (if (null != CRR_OWNER) "\t\t<cim:OASISDataItems.CRR_OWNER rdf:resource=\"#" + CRR_OWNER + "\"/>\n" else "") +
        (if (null != CRR_SEGMENT) "\t\t<cim:OASISDataItems.CRR_SEGMENT rdf:resource=\"#" + CRR_SEGMENT + "\"/>\n" else "") +
        (if (null != CRR_TERM) "\t\t<cim:OASISDataItems.CRR_TERM rdf:resource=\"#" + CRR_TERM + "\"/>\n" else "") +
        (if (null != CRR_TOU) "\t\t<cim:OASISDataItems.CRR_TOU rdf:resource=\"#" + CRR_TOU + "\"/>\n" else "") +
        (if (null != CRR_TYPE) "\t\t<cim:OASISDataItems.CRR_TYPE rdf:resource=\"#" + CRR_TYPE + "\"/>\n" else "") +
        (if (null != ENE_EA_DA) "\t\t<cim:OASISDataItems.ENE_EA_DA rdf:resource=\"#" + ENE_EA_DA + "\"/>\n" else "") +
        (if (null != ENE_EA_EXCEPT) "\t\t<cim:OASISDataItems.ENE_EA_EXCEPT rdf:resource=\"#" + ENE_EA_EXCEPT + "\"/>\n" else "") +
        (if (null != ENE_EA_HASP) "\t\t<cim:OASISDataItems.ENE_EA_HASP rdf:resource=\"#" + ENE_EA_HASP + "\"/>\n" else "") +
        (if (null != ENE_EA_MLE) "\t\t<cim:OASISDataItems.ENE_EA_MLE rdf:resource=\"#" + ENE_EA_MLE + "\"/>\n" else "") +
        (if (null != ENE_EA_MSSLF) "\t\t<cim:OASISDataItems.ENE_EA_MSSLF rdf:resource=\"#" + ENE_EA_MSSLF + "\"/>\n" else "") +
        (if (null != ENE_EA_OPTIMAL) "\t\t<cim:OASISDataItems.ENE_EA_OPTIMAL rdf:resource=\"#" + ENE_EA_OPTIMAL + "\"/>\n" else "") +
        (if (null != ENE_EA_RAMP_DEV) "\t\t<cim:OASISDataItems.ENE_EA_RAMP_DEV rdf:resource=\"#" + ENE_EA_RAMP_DEV + "\"/>\n" else "") +
        (if (null != ENE_EA_RAMP_STD) "\t\t<cim:OASISDataItems.ENE_EA_RAMP_STD rdf:resource=\"#" + ENE_EA_RAMP_STD + "\"/>\n" else "") +
        (if (null != ENE_EA_RESIDUAL) "\t\t<cim:OASISDataItems.ENE_EA_RESIDUAL rdf:resource=\"#" + ENE_EA_RESIDUAL + "\"/>\n" else "") +
        (if (null != ENE_EA_RMR) "\t\t<cim:OASISDataItems.ENE_EA_RMR rdf:resource=\"#" + ENE_EA_RMR + "\"/>\n" else "") +
        (if (null != ENE_EA_SELF) "\t\t<cim:OASISDataItems.ENE_EA_SELF rdf:resource=\"#" + ENE_EA_SELF + "\"/>\n" else "") +
        (if (null != ENE_EA_SLIC) "\t\t<cim:OASISDataItems.ENE_EA_SLIC rdf:resource=\"#" + ENE_EA_SLIC + "\"/>\n" else "") +
        (if (null != ENE_EXP_CLEAR_HASP) "\t\t<cim:OASISDataItems.ENE_EXP_CLEAR_HASP rdf:resource=\"#" + ENE_EXP_CLEAR_HASP + "\"/>\n" else "") +
        (if (null != ENE_EXP_CLEAR_IFM) "\t\t<cim:OASISDataItems.ENE_EXP_CLEAR_IFM rdf:resource=\"#" + ENE_EXP_CLEAR_IFM + "\"/>\n" else "") +
        (if (null != ENE_EXP_CLEAR_RTM) "\t\t<cim:OASISDataItems.ENE_EXP_CLEAR_RTM rdf:resource=\"#" + ENE_EXP_CLEAR_RTM + "\"/>\n" else "") +
        (if (null != ENE_GEN_CLEAR_HASP) "\t\t<cim:OASISDataItems.ENE_GEN_CLEAR_HASP rdf:resource=\"#" + ENE_GEN_CLEAR_HASP + "\"/>\n" else "") +
        (if (null != ENE_GEN_CLEAR_IFM) "\t\t<cim:OASISDataItems.ENE_GEN_CLEAR_IFM rdf:resource=\"#" + ENE_GEN_CLEAR_IFM + "\"/>\n" else "") +
        (if (null != ENE_GEN_CLEAR_RTM) "\t\t<cim:OASISDataItems.ENE_GEN_CLEAR_RTM rdf:resource=\"#" + ENE_GEN_CLEAR_RTM + "\"/>\n" else "") +
        (if (null != ENE_IMP_CLEAR_HASP) "\t\t<cim:OASISDataItems.ENE_IMP_CLEAR_HASP rdf:resource=\"#" + ENE_IMP_CLEAR_HASP + "\"/>\n" else "") +
        (if (null != ENE_IMP_CLEAR_IFM) "\t\t<cim:OASISDataItems.ENE_IMP_CLEAR_IFM rdf:resource=\"#" + ENE_IMP_CLEAR_IFM + "\"/>\n" else "") +
        (if (null != ENE_IMP_CLEAR_RTM) "\t\t<cim:OASISDataItems.ENE_IMP_CLEAR_RTM rdf:resource=\"#" + ENE_IMP_CLEAR_RTM + "\"/>\n" else "") +
        (if (null != ENE_LOAD_ACTUAL) "\t\t<cim:OASISDataItems.ENE_LOAD_ACTUAL rdf:resource=\"#" + ENE_LOAD_ACTUAL + "\"/>\n" else "") +
        (if (null != ENE_LOAD_CLEAR_HASP) "\t\t<cim:OASISDataItems.ENE_LOAD_CLEAR_HASP rdf:resource=\"#" + ENE_LOAD_CLEAR_HASP + "\"/>\n" else "") +
        (if (null != ENE_LOAD_CLEAR_IFM) "\t\t<cim:OASISDataItems.ENE_LOAD_CLEAR_IFM rdf:resource=\"#" + ENE_LOAD_CLEAR_IFM + "\"/>\n" else "") +
        (if (null != ENE_LOAD_CLEAR_RTM) "\t\t<cim:OASISDataItems.ENE_LOAD_CLEAR_RTM rdf:resource=\"#" + ENE_LOAD_CLEAR_RTM + "\"/>\n" else "") +
        (if (null != ENE_LOAD_FCST) "\t\t<cim:OASISDataItems.ENE_LOAD_FCST rdf:resource=\"#" + ENE_LOAD_FCST + "\"/>\n" else "") +
        (if (null != ENE_PEAK_HOUR) "\t\t<cim:OASISDataItems.ENE_PEAK_HOUR rdf:resource=\"#" + ENE_PEAK_HOUR + "\"/>\n" else "") +
        (if (null != ENE_PEAK_LOAD) "\t\t<cim:OASISDataItems.ENE_PEAK_LOAD rdf:resource=\"#" + ENE_PEAK_LOAD + "\"/>\n" else "") +
        (if (null != FUEL_REGION_value) "\t\t<cim:OASISDataItems.FUEL_REGION_value rdf:resource=\"#" + FUEL_REGION_value + "\"/>\n" else "") +
        (if (null != INVT_DATETIME) "\t\t<cim:OASISDataItems.INVT_DATETIME rdf:resource=\"#" + INVT_DATETIME + "\"/>\n" else "") +
        (if (null != LOAD_ACTUAL) "\t\t<cim:OASISDataItems.LOAD_ACTUAL rdf:resource=\"#" + LOAD_ACTUAL + "\"/>\n" else "") +
        (if (null != LOAD_CLEAR_RTM) "\t\t<cim:OASISDataItems.LOAD_CLEAR_RTM rdf:resource=\"#" + LOAD_CLEAR_RTM + "\"/>\n" else "") +
        (if (null != LOSS_TOTAL_COST_HASP) "\t\t<cim:OASISDataItems.LOSS_TOTAL_COST_HASP rdf:resource=\"#" + LOSS_TOTAL_COST_HASP + "\"/>\n" else "") +
        (if (null != LOSS_TOTAL_COST_RTM) "\t\t<cim:OASISDataItems.LOSS_TOTAL_COST_RTM rdf:resource=\"#" + LOSS_TOTAL_COST_RTM + "\"/>\n" else "") +
        (if (null != LOSS_TOTAL_MW_HASP) "\t\t<cim:OASISDataItems.LOSS_TOTAL_MW_HASP rdf:resource=\"#" + LOSS_TOTAL_MW_HASP + "\"/>\n" else "") +
        (if (null != LOSS_TOTAL_MW_RTM) "\t\t<cim:OASISDataItems.LOSS_TOTAL_MW_RTM rdf:resource=\"#" + LOSS_TOTAL_MW_RTM + "\"/>\n" else "") +
        (if (null != MPM_FLAG) "\t\t<cim:OASISDataItems.MPM_FLAG rdf:resource=\"#" + MPM_FLAG + "\"/>\n" else "") +
        (if (null != OP_RSRV_TOTAL) "\t\t<cim:OASISDataItems.OP_RSRV_TOTAL rdf:resource=\"#" + OP_RSRV_TOTAL + "\"/>\n" else "") +
        (if (null != PRC_NG) "\t\t<cim:OASISDataItems.PRC_NG rdf:resource=\"#" + PRC_NG + "\"/>\n" else "") +
        (if (null != PRC_SHADOW) "\t\t<cim:OASISDataItems.PRC_SHADOW rdf:resource=\"#" + PRC_SHADOW + "\"/>\n" else "") +
        (if (null != RATING_ATC) "\t\t<cim:OASISDataItems.RATING_ATC rdf:resource=\"#" + RATING_ATC + "\"/>\n" else "") +
        (if (null != RMR_DETER_DAM) "\t\t<cim:OASISDataItems.RMR_DETER_DAM rdf:resource=\"#" + RMR_DETER_DAM + "\"/>\n" else "") +
        (if (null != RMR_DETER_HASP) "\t\t<cim:OASISDataItems.RMR_DETER_HASP rdf:resource=\"#" + RMR_DETER_HASP + "\"/>\n" else "") +
        (if (null != RMR_DISPATCH_DAM) "\t\t<cim:OASISDataItems.RMR_DISPATCH_DAM rdf:resource=\"#" + RMR_DISPATCH_DAM + "\"/>\n" else "") +
        (if (null != RMR_DISPATCH_HASP) "\t\t<cim:OASISDataItems.RMR_DISPATCH_HASP rdf:resource=\"#" + RMR_DISPATCH_HASP + "\"/>\n" else "") +
        (if (null != RMR_TOTAL) "\t\t<cim:OASISDataItems.RMR_TOTAL rdf:resource=\"#" + RMR_TOTAL + "\"/>\n" else "") +
        (if (null != RMR_TOTAL_AVAIL) "\t\t<cim:OASISDataItems.RMR_TOTAL_AVAIL rdf:resource=\"#" + RMR_TOTAL_AVAIL + "\"/>\n" else "") +
        (if (null != RUC_GEN_CLEAR_RUC) "\t\t<cim:OASISDataItems.RUC_GEN_CLEAR_RUC rdf:resource=\"#" + RUC_GEN_CLEAR_RUC + "\"/>\n" else "") +
        (if (null != RUC_IMP_CLEAR_RUC) "\t\t<cim:OASISDataItems.RUC_IMP_CLEAR_RUC rdf:resource=\"#" + RUC_IMP_CLEAR_RUC + "\"/>\n" else "") +
        (if (null != RUC_LOAD_CLEAR_RUC) "\t\t<cim:OASISDataItems.RUC_LOAD_CLEAR_RUC rdf:resource=\"#" + RUC_LOAD_CLEAR_RUC + "\"/>\n" else "") +
        (if (null != RUC_ZONE_value) "\t\t<cim:OASISDataItems.RUC_ZONE_value rdf:resource=\"#" + RUC_ZONE_value + "\"/>\n" else "") +
        (if (null != TAC_AREA_value) "\t\t<cim:OASISDataItems.TAC_AREA_value rdf:resource=\"#" + TAC_AREA_value + "\"/>\n" else "") +
        (if (null != TINTRFCE_value) "\t\t<cim:OASISDataItems.TINTRFCE_value rdf:resource=\"#" + TINTRFCE_value + "\"/>\n" else "") +
        (if (null != TRNS_AS_IMPORT) "\t\t<cim:OASISDataItems.TRNS_AS_IMPORT rdf:resource=\"#" + TRNS_AS_IMPORT + "\"/>\n" else "") +
        (if (null != TRNS_ENE_IMPORT) "\t\t<cim:OASISDataItems.TRNS_ENE_IMPORT rdf:resource=\"#" + TRNS_ENE_IMPORT + "\"/>\n" else "") +
        (if (null != TRNS_EQUIP_value) "\t\t<cim:OASISDataItems.TRNS_EQUIP_value rdf:resource=\"#" + TRNS_EQUIP_value + "\"/>\n" else "") +
        (if (null != TRNS_RATING_CBM) "\t\t<cim:OASISDataItems.TRNS_RATING_CBM rdf:resource=\"#" + TRNS_RATING_CBM + "\"/>\n" else "") +
        (if (null != TRNS_RATING_DIRECTION) "\t\t<cim:OASISDataItems.TRNS_RATING_DIRECTION rdf:resource=\"#" + TRNS_RATING_DIRECTION + "\"/>\n" else "") +
        (if (null != TRNS_RATING_OTC) "\t\t<cim:OASISDataItems.TRNS_RATING_OTC rdf:resource=\"#" + TRNS_RATING_OTC + "\"/>\n" else "") +
        (if (null != TRNS_RATING_OTC_DERATE) "\t\t<cim:OASISDataItems.TRNS_RATING_OTC_DERATE rdf:resource=\"#" + TRNS_RATING_OTC_DERATE + "\"/>\n" else "") +
        (if (null != TRNS_RATING_TTC) "\t\t<cim:OASISDataItems.TRNS_RATING_TTC rdf:resource=\"#" + TRNS_RATING_TTC + "\"/>\n" else "") +
        (if (null != TRNS_TI_value) "\t\t<cim:OASISDataItems.TRNS_TI_value rdf:resource=\"#" + TRNS_TI_value + "\"/>\n" else "") +
        (if (null != TRNS_TR_ENTMTS) "\t\t<cim:OASISDataItems.TRNS_TR_ENTMTS rdf:resource=\"#" + TRNS_TR_ENTMTS + "\"/>\n" else "") +
        (if (null != TRNS_TR_USEAGE) "\t\t<cim:OASISDataItems.TRNS_TR_USEAGE rdf:resource=\"#" + TRNS_TR_USEAGE + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OASISDataItems rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OASISDataItems>\n"
    }
}

object OASISDataItems
extends
    Parseable[OASISDataItems]
{
    val AS_CLEAR_ASMP_IFM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_CLEAR_ASMP_IFM"""))
    val AS_CLEAR_ASMP_RTM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_CLEAR_ASMP_RTM"""))
    val AS_CLEAR_COST_IFM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_CLEAR_COST_IFM"""))
    val AS_CLEAR_COST_RTM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_CLEAR_COST_RTM"""))
    val AS_CLEAR_MW_IFM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_CLEAR_MW_IFM"""))
    val AS_CLEAR_MW_RTM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_CLEAR_MW_RTM"""))
    val AS_GEN_TOTAL_MW_IFM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_GEN_TOTAL_MW_IFM"""))
    val AS_GEN_TOTAL_MW_RTM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_GEN_TOTAL_MW_RTM"""))
    val AS_IMP_TOTAL_MW_IFM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_IMP_TOTAL_MW_IFM"""))
    val AS_IMP_TOTAL_MW_RTM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_IMP_TOTAL_MW_RTM"""))
    val AS_LOAD_TOTAL_MW_IFM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_LOAD_TOTAL_MW_IFM"""))
    val AS_LOAD_TOTAL_MW_RTM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_LOAD_TOTAL_MW_RTM"""))
    val AS_REGION_REQ_MAX: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_REGION_REQ_MAX"""))
    val AS_REGION_REQ_MIN: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_REGION_REQ_MIN"""))
    val AS_REGION_value: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_REGION_value"""))
    val AS_SELF_MW_IFM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_SELF_MW_IFM"""))
    val AS_SELF_MW_RTM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_SELF_MW_RTM"""))
    val AS_TOTAL_MW: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_TOTAL_MW"""))
    val AS_TOTAL_MW_IFM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_TOTAL_MW_IFM"""))
    val AS_TOTAL_MW_RTM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_TOTAL_MW_RTM"""))
    val AS_TYPE: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_TYPE"""))
    val AS_USER_RATE: (Context) => String = parse_attribute (attribute ("""OASISDataItems.AS_USER_RATE"""))
    val CA_value: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CA_value"""))
    val CMMT_MINLOAD_MLC: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CMMT_MINLOAD_MLC"""))
    val CMMT_MINLOAD_MW: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CMMT_MINLOAD_MW"""))
    val CMMT_RA_MLC: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CMMT_RA_MLC"""))
    val CMMT_RA_MW: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CMMT_RA_MW"""))
    val CMMT_RA_START_COST: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CMMT_RA_START_COST"""))
    val CMMT_RA_UNITS: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CMMT_RA_UNITS"""))
    val CMMT_TOTAL_MW: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CMMT_TOTAL_MW"""))
    val CMMT_TOTAL_START_COST: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CMMT_TOTAL_START_COST"""))
    val CMMT_TOTAL_UNITS: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CMMT_TOTAL_UNITS"""))
    val CRR_CAT: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CRR_CAT"""))
    val CRR_MARKET_value: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CRR_MARKET_value"""))
    val CRR_MW: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CRR_MW"""))
    val CRR_NSR: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CRR_NSR"""))
    val CRR_OPTION: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CRR_OPTION"""))
    val CRR_OWNER: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CRR_OWNER"""))
    val CRR_SEGMENT: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CRR_SEGMENT"""))
    val CRR_TERM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CRR_TERM"""))
    val CRR_TOU: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CRR_TOU"""))
    val CRR_TYPE: (Context) => String = parse_attribute (attribute ("""OASISDataItems.CRR_TYPE"""))
    val ENE_EA_DA: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_EA_DA"""))
    val ENE_EA_EXCEPT: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_EA_EXCEPT"""))
    val ENE_EA_HASP: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_EA_HASP"""))
    val ENE_EA_MLE: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_EA_MLE"""))
    val ENE_EA_MSSLF: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_EA_MSSLF"""))
    val ENE_EA_OPTIMAL: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_EA_OPTIMAL"""))
    val ENE_EA_RAMP_DEV: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_EA_RAMP_DEV"""))
    val ENE_EA_RAMP_STD: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_EA_RAMP_STD"""))
    val ENE_EA_RESIDUAL: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_EA_RESIDUAL"""))
    val ENE_EA_RMR: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_EA_RMR"""))
    val ENE_EA_SELF: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_EA_SELF"""))
    val ENE_EA_SLIC: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_EA_SLIC"""))
    val ENE_EXP_CLEAR_HASP: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_EXP_CLEAR_HASP"""))
    val ENE_EXP_CLEAR_IFM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_EXP_CLEAR_IFM"""))
    val ENE_EXP_CLEAR_RTM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_EXP_CLEAR_RTM"""))
    val ENE_GEN_CLEAR_HASP: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_GEN_CLEAR_HASP"""))
    val ENE_GEN_CLEAR_IFM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_GEN_CLEAR_IFM"""))
    val ENE_GEN_CLEAR_RTM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_GEN_CLEAR_RTM"""))
    val ENE_IMP_CLEAR_HASP: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_IMP_CLEAR_HASP"""))
    val ENE_IMP_CLEAR_IFM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_IMP_CLEAR_IFM"""))
    val ENE_IMP_CLEAR_RTM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_IMP_CLEAR_RTM"""))
    val ENE_LOAD_ACTUAL: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_LOAD_ACTUAL"""))
    val ENE_LOAD_CLEAR_HASP: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_LOAD_CLEAR_HASP"""))
    val ENE_LOAD_CLEAR_IFM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_LOAD_CLEAR_IFM"""))
    val ENE_LOAD_CLEAR_RTM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_LOAD_CLEAR_RTM"""))
    val ENE_LOAD_FCST: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_LOAD_FCST"""))
    val ENE_PEAK_HOUR: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_PEAK_HOUR"""))
    val ENE_PEAK_LOAD: (Context) => String = parse_attribute (attribute ("""OASISDataItems.ENE_PEAK_LOAD"""))
    val FUEL_REGION_value: (Context) => String = parse_attribute (attribute ("""OASISDataItems.FUEL_REGION_value"""))
    val INVT_DATETIME: (Context) => String = parse_attribute (attribute ("""OASISDataItems.INVT_DATETIME"""))
    val LOAD_ACTUAL: (Context) => String = parse_attribute (attribute ("""OASISDataItems.LOAD_ACTUAL"""))
    val LOAD_CLEAR_RTM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.LOAD_CLEAR_RTM"""))
    val LOSS_TOTAL_COST_HASP: (Context) => String = parse_attribute (attribute ("""OASISDataItems.LOSS_TOTAL_COST_HASP"""))
    val LOSS_TOTAL_COST_RTM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.LOSS_TOTAL_COST_RTM"""))
    val LOSS_TOTAL_MW_HASP: (Context) => String = parse_attribute (attribute ("""OASISDataItems.LOSS_TOTAL_MW_HASP"""))
    val LOSS_TOTAL_MW_RTM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.LOSS_TOTAL_MW_RTM"""))
    val MPM_FLAG: (Context) => String = parse_attribute (attribute ("""OASISDataItems.MPM_FLAG"""))
    val OP_RSRV_TOTAL: (Context) => String = parse_attribute (attribute ("""OASISDataItems.OP_RSRV_TOTAL"""))
    val PRC_NG: (Context) => String = parse_attribute (attribute ("""OASISDataItems.PRC_NG"""))
    val PRC_SHADOW: (Context) => String = parse_attribute (attribute ("""OASISDataItems.PRC_SHADOW"""))
    val RATING_ATC: (Context) => String = parse_attribute (attribute ("""OASISDataItems.RATING_ATC"""))
    val RMR_DETER_DAM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.RMR_DETER_DAM"""))
    val RMR_DETER_HASP: (Context) => String = parse_attribute (attribute ("""OASISDataItems.RMR_DETER_HASP"""))
    val RMR_DISPATCH_DAM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.RMR_DISPATCH_DAM"""))
    val RMR_DISPATCH_HASP: (Context) => String = parse_attribute (attribute ("""OASISDataItems.RMR_DISPATCH_HASP"""))
    val RMR_TOTAL: (Context) => String = parse_attribute (attribute ("""OASISDataItems.RMR_TOTAL"""))
    val RMR_TOTAL_AVAIL: (Context) => String = parse_attribute (attribute ("""OASISDataItems.RMR_TOTAL_AVAIL"""))
    val RUC_GEN_CLEAR_RUC: (Context) => String = parse_attribute (attribute ("""OASISDataItems.RUC_GEN_CLEAR_RUC"""))
    val RUC_IMP_CLEAR_RUC: (Context) => String = parse_attribute (attribute ("""OASISDataItems.RUC_IMP_CLEAR_RUC"""))
    val RUC_LOAD_CLEAR_RUC: (Context) => String = parse_attribute (attribute ("""OASISDataItems.RUC_LOAD_CLEAR_RUC"""))
    val RUC_ZONE_value: (Context) => String = parse_attribute (attribute ("""OASISDataItems.RUC_ZONE_value"""))
    val TAC_AREA_value: (Context) => String = parse_attribute (attribute ("""OASISDataItems.TAC_AREA_value"""))
    val TINTRFCE_value: (Context) => String = parse_attribute (attribute ("""OASISDataItems.TINTRFCE_value"""))
    val TRNS_AS_IMPORT: (Context) => String = parse_attribute (attribute ("""OASISDataItems.TRNS_AS_IMPORT"""))
    val TRNS_ENE_IMPORT: (Context) => String = parse_attribute (attribute ("""OASISDataItems.TRNS_ENE_IMPORT"""))
    val TRNS_EQUIP_value: (Context) => String = parse_attribute (attribute ("""OASISDataItems.TRNS_EQUIP_value"""))
    val TRNS_RATING_CBM: (Context) => String = parse_attribute (attribute ("""OASISDataItems.TRNS_RATING_CBM"""))
    val TRNS_RATING_DIRECTION: (Context) => String = parse_attribute (attribute ("""OASISDataItems.TRNS_RATING_DIRECTION"""))
    val TRNS_RATING_OTC: (Context) => String = parse_attribute (attribute ("""OASISDataItems.TRNS_RATING_OTC"""))
    val TRNS_RATING_OTC_DERATE: (Context) => String = parse_attribute (attribute ("""OASISDataItems.TRNS_RATING_OTC_DERATE"""))
    val TRNS_RATING_TTC: (Context) => String = parse_attribute (attribute ("""OASISDataItems.TRNS_RATING_TTC"""))
    val TRNS_TI_value: (Context) => String = parse_attribute (attribute ("""OASISDataItems.TRNS_TI_value"""))
    val TRNS_TR_ENTMTS: (Context) => String = parse_attribute (attribute ("""OASISDataItems.TRNS_TR_ENTMTS"""))
    val TRNS_TR_USEAGE: (Context) => String = parse_attribute (attribute ("""OASISDataItems.TRNS_TR_USEAGE"""))
    def parse (context: Context): OASISDataItems =
    {
        OASISDataItems(
            BasicElement.parse (context),
            AS_CLEAR_ASMP_IFM (context),
            AS_CLEAR_ASMP_RTM (context),
            AS_CLEAR_COST_IFM (context),
            AS_CLEAR_COST_RTM (context),
            AS_CLEAR_MW_IFM (context),
            AS_CLEAR_MW_RTM (context),
            AS_GEN_TOTAL_MW_IFM (context),
            AS_GEN_TOTAL_MW_RTM (context),
            AS_IMP_TOTAL_MW_IFM (context),
            AS_IMP_TOTAL_MW_RTM (context),
            AS_LOAD_TOTAL_MW_IFM (context),
            AS_LOAD_TOTAL_MW_RTM (context),
            AS_REGION_REQ_MAX (context),
            AS_REGION_REQ_MIN (context),
            AS_REGION_value (context),
            AS_SELF_MW_IFM (context),
            AS_SELF_MW_RTM (context),
            AS_TOTAL_MW (context),
            AS_TOTAL_MW_IFM (context),
            AS_TOTAL_MW_RTM (context),
            AS_TYPE (context),
            AS_USER_RATE (context),
            CA_value (context),
            CMMT_MINLOAD_MLC (context),
            CMMT_MINLOAD_MW (context),
            CMMT_RA_MLC (context),
            CMMT_RA_MW (context),
            CMMT_RA_START_COST (context),
            CMMT_RA_UNITS (context),
            CMMT_TOTAL_MW (context),
            CMMT_TOTAL_START_COST (context),
            CMMT_TOTAL_UNITS (context),
            CRR_CAT (context),
            CRR_MARKET_value (context),
            CRR_MW (context),
            CRR_NSR (context),
            CRR_OPTION (context),
            CRR_OWNER (context),
            CRR_SEGMENT (context),
            CRR_TERM (context),
            CRR_TOU (context),
            CRR_TYPE (context),
            ENE_EA_DA (context),
            ENE_EA_EXCEPT (context),
            ENE_EA_HASP (context),
            ENE_EA_MLE (context),
            ENE_EA_MSSLF (context),
            ENE_EA_OPTIMAL (context),
            ENE_EA_RAMP_DEV (context),
            ENE_EA_RAMP_STD (context),
            ENE_EA_RESIDUAL (context),
            ENE_EA_RMR (context),
            ENE_EA_SELF (context),
            ENE_EA_SLIC (context),
            ENE_EXP_CLEAR_HASP (context),
            ENE_EXP_CLEAR_IFM (context),
            ENE_EXP_CLEAR_RTM (context),
            ENE_GEN_CLEAR_HASP (context),
            ENE_GEN_CLEAR_IFM (context),
            ENE_GEN_CLEAR_RTM (context),
            ENE_IMP_CLEAR_HASP (context),
            ENE_IMP_CLEAR_IFM (context),
            ENE_IMP_CLEAR_RTM (context),
            ENE_LOAD_ACTUAL (context),
            ENE_LOAD_CLEAR_HASP (context),
            ENE_LOAD_CLEAR_IFM (context),
            ENE_LOAD_CLEAR_RTM (context),
            ENE_LOAD_FCST (context),
            ENE_PEAK_HOUR (context),
            ENE_PEAK_LOAD (context),
            FUEL_REGION_value (context),
            INVT_DATETIME (context),
            LOAD_ACTUAL (context),
            LOAD_CLEAR_RTM (context),
            LOSS_TOTAL_COST_HASP (context),
            LOSS_TOTAL_COST_RTM (context),
            LOSS_TOTAL_MW_HASP (context),
            LOSS_TOTAL_MW_RTM (context),
            MPM_FLAG (context),
            OP_RSRV_TOTAL (context),
            PRC_NG (context),
            PRC_SHADOW (context),
            RATING_ATC (context),
            RMR_DETER_DAM (context),
            RMR_DETER_HASP (context),
            RMR_DISPATCH_DAM (context),
            RMR_DISPATCH_HASP (context),
            RMR_TOTAL (context),
            RMR_TOTAL_AVAIL (context),
            RUC_GEN_CLEAR_RUC (context),
            RUC_IMP_CLEAR_RUC (context),
            RUC_LOAD_CLEAR_RUC (context),
            RUC_ZONE_value (context),
            TAC_AREA_value (context),
            TINTRFCE_value (context),
            TRNS_AS_IMPORT (context),
            TRNS_ENE_IMPORT (context),
            TRNS_EQUIP_value (context),
            TRNS_RATING_CBM (context),
            TRNS_RATING_DIRECTION (context),
            TRNS_RATING_OTC (context),
            TRNS_RATING_OTC_DERATE (context),
            TRNS_RATING_TTC (context),
            TRNS_TI_value (context),
            TRNS_TR_ENTMTS (context),
            TRNS_TR_USEAGE (context)
        )
    }
}

case class OASISErrCode
(
    override val sup: BasicElement,
    _1000: String,
    _1001: String,
    _1002: String,
    _1003: String,
    _1004: String,
    _1005: String,
    _1006: String,
    _1007: String,
    _1008: String,
    _1009: String,
    _1010: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OASISErrCode] }
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
        sup.export_fields +
        (if (null != _1000) "\t\t<cim:OASISErrCode.1000 rdf:resource=\"#" + _1000 + "\"/>\n" else "") +
        (if (null != _1001) "\t\t<cim:OASISErrCode.1001 rdf:resource=\"#" + _1001 + "\"/>\n" else "") +
        (if (null != _1002) "\t\t<cim:OASISErrCode.1002 rdf:resource=\"#" + _1002 + "\"/>\n" else "") +
        (if (null != _1003) "\t\t<cim:OASISErrCode.1003 rdf:resource=\"#" + _1003 + "\"/>\n" else "") +
        (if (null != _1004) "\t\t<cim:OASISErrCode.1004 rdf:resource=\"#" + _1004 + "\"/>\n" else "") +
        (if (null != _1005) "\t\t<cim:OASISErrCode.1005 rdf:resource=\"#" + _1005 + "\"/>\n" else "") +
        (if (null != _1006) "\t\t<cim:OASISErrCode.1006 rdf:resource=\"#" + _1006 + "\"/>\n" else "") +
        (if (null != _1007) "\t\t<cim:OASISErrCode.1007 rdf:resource=\"#" + _1007 + "\"/>\n" else "") +
        (if (null != _1008) "\t\t<cim:OASISErrCode.1008 rdf:resource=\"#" + _1008 + "\"/>\n" else "") +
        (if (null != _1009) "\t\t<cim:OASISErrCode.1009 rdf:resource=\"#" + _1009 + "\"/>\n" else "") +
        (if (null != _1010) "\t\t<cim:OASISErrCode.1010 rdf:resource=\"#" + _1010 + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OASISErrCode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OASISErrCode>\n"
    }
}

object OASISErrCode
extends
    Parseable[OASISErrCode]
{
    val _1000: (Context) => String = parse_attribute (attribute ("""OASISErrCode.1000"""))
    val _1001: (Context) => String = parse_attribute (attribute ("""OASISErrCode.1001"""))
    val _1002: (Context) => String = parse_attribute (attribute ("""OASISErrCode.1002"""))
    val _1003: (Context) => String = parse_attribute (attribute ("""OASISErrCode.1003"""))
    val _1004: (Context) => String = parse_attribute (attribute ("""OASISErrCode.1004"""))
    val _1005: (Context) => String = parse_attribute (attribute ("""OASISErrCode.1005"""))
    val _1006: (Context) => String = parse_attribute (attribute ("""OASISErrCode.1006"""))
    val _1007: (Context) => String = parse_attribute (attribute ("""OASISErrCode.1007"""))
    val _1008: (Context) => String = parse_attribute (attribute ("""OASISErrCode.1008"""))
    val _1009: (Context) => String = parse_attribute (attribute ("""OASISErrCode.1009"""))
    val _1010: (Context) => String = parse_attribute (attribute ("""OASISErrCode.1010"""))
    def parse (context: Context): OASISErrCode =
    {
        OASISErrCode(
            BasicElement.parse (context),
            _1000 (context),
            _1001 (context),
            _1002 (context),
            _1003 (context),
            _1004 (context),
            _1005 (context),
            _1006 (context),
            _1007 (context),
            _1008 (context),
            _1009 (context),
            _1010 (context)
        )
    }
}

case class OASISErrDescription
(
    override val sup: BasicElement,
    Data_can_be_requested_for_period_of_31_days_only: String,
    Exceptions_in_reading_and_writing_of_XML_files: String,
    Invalid_date_format__please_use_valid_date_format: String,
    No_data_returned_for_the_specified_selection: String,
    Out_of_memory_exception: String,
    Report_name_does_not_exit__please_use_valid_report_name: String,
    Required_file_does_not_exist: String,
    System_Error: String,
    Timed_out_waiting_for_query_response: String,
    Validation_exception_during_transformation_of_XML: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OASISErrDescription] }
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
        sup.export_fields +
        (if (null != Data_can_be_requested_for_period_of_31_days_only) "\t\t<cim:OASISErrDescription.Data can be requested for period of 31 days only rdf:resource=\"#" + Data_can_be_requested_for_period_of_31_days_only + "\"/>\n" else "") +
        (if (null != Exceptions_in_reading_and_writing_of_XML_files) "\t\t<cim:OASISErrDescription.Exceptions in reading and writing of XML files rdf:resource=\"#" + Exceptions_in_reading_and_writing_of_XML_files + "\"/>\n" else "") +
        (if (null != Invalid_date_format__please_use_valid_date_format) "\t\t<cim:OASISErrDescription.Invalid date format, please use valid date format rdf:resource=\"#" + Invalid_date_format__please_use_valid_date_format + "\"/>\n" else "") +
        (if (null != No_data_returned_for_the_specified_selection) "\t\t<cim:OASISErrDescription.No data returned for the specified selection rdf:resource=\"#" + No_data_returned_for_the_specified_selection + "\"/>\n" else "") +
        (if (null != Out_of_memory_exception) "\t\t<cim:OASISErrDescription.Out of memory exception rdf:resource=\"#" + Out_of_memory_exception + "\"/>\n" else "") +
        (if (null != Report_name_does_not_exit__please_use_valid_report_name) "\t\t<cim:OASISErrDescription.Report name does not exit, please use valid report name rdf:resource=\"#" + Report_name_does_not_exit__please_use_valid_report_name + "\"/>\n" else "") +
        (if (null != Required_file_does_not_exist) "\t\t<cim:OASISErrDescription.Required file does not exist rdf:resource=\"#" + Required_file_does_not_exist + "\"/>\n" else "") +
        (if (null != System_Error) "\t\t<cim:OASISErrDescription.System Error rdf:resource=\"#" + System_Error + "\"/>\n" else "") +
        (if (null != Timed_out_waiting_for_query_response) "\t\t<cim:OASISErrDescription.Timed out waiting for query response rdf:resource=\"#" + Timed_out_waiting_for_query_response + "\"/>\n" else "") +
        (if (null != Validation_exception_during_transformation_of_XML) "\t\t<cim:OASISErrDescription.Validation exception during transformation of XML rdf:resource=\"#" + Validation_exception_during_transformation_of_XML + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OASISErrDescription rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OASISErrDescription>\n"
    }
}

object OASISErrDescription
extends
    Parseable[OASISErrDescription]
{
    val Data_can_be_requested_for_period_of_31_days_only: (Context) => String = parse_attribute (attribute ("""OASISErrDescription.Data can be requested for period of 31 days only"""))
    val Exceptions_in_reading_and_writing_of_XML_files: (Context) => String = parse_attribute (attribute ("""OASISErrDescription.Exceptions in reading and writing of XML files"""))
    val Invalid_date_format__please_use_valid_date_format: (Context) => String = parse_attribute (attribute ("""OASISErrDescription.Invalid date format, please use valid date format"""))
    val No_data_returned_for_the_specified_selection: (Context) => String = parse_attribute (attribute ("""OASISErrDescription.No data returned for the specified selection"""))
    val Out_of_memory_exception: (Context) => String = parse_attribute (attribute ("""OASISErrDescription.Out of memory exception"""))
    val Report_name_does_not_exit__please_use_valid_report_name: (Context) => String = parse_attribute (attribute ("""OASISErrDescription.Report name does not exit, please use valid report name"""))
    val Required_file_does_not_exist: (Context) => String = parse_attribute (attribute ("""OASISErrDescription.Required file does not exist"""))
    val System_Error: (Context) => String = parse_attribute (attribute ("""OASISErrDescription.System Error"""))
    val Timed_out_waiting_for_query_response: (Context) => String = parse_attribute (attribute ("""OASISErrDescription.Timed out waiting for query response"""))
    val Validation_exception_during_transformation_of_XML: (Context) => String = parse_attribute (attribute ("""OASISErrDescription.Validation exception during transformation of XML"""))
    def parse (context: Context): OASISErrDescription =
    {
        OASISErrDescription(
            BasicElement.parse (context),
            Data_can_be_requested_for_period_of_31_days_only (context),
            Exceptions_in_reading_and_writing_of_XML_files (context),
            Invalid_date_format__please_use_valid_date_format (context),
            No_data_returned_for_the_specified_selection (context),
            Out_of_memory_exception (context),
            Report_name_does_not_exit__please_use_valid_report_name (context),
            Required_file_does_not_exist (context),
            System_Error (context),
            Timed_out_waiting_for_query_response (context),
            Validation_exception_during_transformation_of_XML (context)
        )
    }
}

case class OASISIntervalType
(
    override val sup: BasicElement,
    BEGINNING: String,
    ENDING: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OASISIntervalType] }
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
        sup.export_fields +
        (if (null != BEGINNING) "\t\t<cim:OASISIntervalType.BEGINNING rdf:resource=\"#" + BEGINNING + "\"/>\n" else "") +
        (if (null != ENDING) "\t\t<cim:OASISIntervalType.ENDING rdf:resource=\"#" + ENDING + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OASISIntervalType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OASISIntervalType>\n"
    }
}

object OASISIntervalType
extends
    Parseable[OASISIntervalType]
{
    val BEGINNING: (Context) => String = parse_attribute (attribute ("""OASISIntervalType.BEGINNING"""))
    val ENDING: (Context) => String = parse_attribute (attribute ("""OASISIntervalType.ENDING"""))
    def parse (context: Context): OASISIntervalType =
    {
        OASISIntervalType(
            BasicElement.parse (context),
            BEGINNING (context),
            ENDING (context)
        )
    }
}

case class OASISMarketType
(
    override val sup: BasicElement,
    All: String,
    HASP: String,
    IFM: String,
    N_A: String,
    RTM: String,
    RUC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OASISMarketType] }
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
        sup.export_fields +
        (if (null != All) "\t\t<cim:OASISMarketType.All rdf:resource=\"#" + All + "\"/>\n" else "") +
        (if (null != HASP) "\t\t<cim:OASISMarketType.HASP rdf:resource=\"#" + HASP + "\"/>\n" else "") +
        (if (null != IFM) "\t\t<cim:OASISMarketType.IFM rdf:resource=\"#" + IFM + "\"/>\n" else "") +
        (if (null != N_A) "\t\t<cim:OASISMarketType.N/A rdf:resource=\"#" + N_A + "\"/>\n" else "") +
        (if (null != RTM) "\t\t<cim:OASISMarketType.RTM rdf:resource=\"#" + RTM + "\"/>\n" else "") +
        (if (null != RUC) "\t\t<cim:OASISMarketType.RUC rdf:resource=\"#" + RUC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OASISMarketType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OASISMarketType>\n"
    }
}

object OASISMarketType
extends
    Parseable[OASISMarketType]
{
    val All: (Context) => String = parse_attribute (attribute ("""OASISMarketType.All"""))
    val HASP: (Context) => String = parse_attribute (attribute ("""OASISMarketType.HASP"""))
    val IFM: (Context) => String = parse_attribute (attribute ("""OASISMarketType.IFM"""))
    val N_A: (Context) => String = parse_attribute (attribute ("""OASISMarketType.N/A"""))
    val RTM: (Context) => String = parse_attribute (attribute ("""OASISMarketType.RTM"""))
    val RUC: (Context) => String = parse_attribute (attribute ("""OASISMarketType.RUC"""))
    def parse (context: Context): OASISMarketType =
    {
        OASISMarketType(
            BasicElement.parse (context),
            All (context),
            HASP (context),
            IFM (context),
            N_A (context),
            RTM (context),
            RUC (context)
        )
    }
}

case class OASISMasterType
(
    override val sup: BasicElement,
    ATL_APNODE: String,
    ATL_AS_REGION: String,
    ATL_AS_REGION_MAP: String,
    ATL_HUB: String,
    ATL_LAP: String,
    ATL_LDF: String,
    ATL_PNODE: String,
    ATL_PNODE_MAP: String,
    ATL_PUB: String,
    ATL_PUB_SCHED: String,
    ATL_RESOURCE: String,
    ATL_RUC_ZONE: String,
    ATL_RUC_ZONE_MAP: String,
    ATL_STAT: String,
    ATL_TAC_AREA: String,
    ATL_TAC_AREA_MAP: String,
    ATL_TI: String,
    ATL_TIEPOINT: String,
    ATL_XREF: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OASISMasterType] }
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
        sup.export_fields +
        (if (null != ATL_APNODE) "\t\t<cim:OASISMasterType.ATL_APNODE rdf:resource=\"#" + ATL_APNODE + "\"/>\n" else "") +
        (if (null != ATL_AS_REGION) "\t\t<cim:OASISMasterType.ATL_AS_REGION rdf:resource=\"#" + ATL_AS_REGION + "\"/>\n" else "") +
        (if (null != ATL_AS_REGION_MAP) "\t\t<cim:OASISMasterType.ATL_AS_REGION_MAP rdf:resource=\"#" + ATL_AS_REGION_MAP + "\"/>\n" else "") +
        (if (null != ATL_HUB) "\t\t<cim:OASISMasterType.ATL_HUB rdf:resource=\"#" + ATL_HUB + "\"/>\n" else "") +
        (if (null != ATL_LAP) "\t\t<cim:OASISMasterType.ATL_LAP rdf:resource=\"#" + ATL_LAP + "\"/>\n" else "") +
        (if (null != ATL_LDF) "\t\t<cim:OASISMasterType.ATL_LDF rdf:resource=\"#" + ATL_LDF + "\"/>\n" else "") +
        (if (null != ATL_PNODE) "\t\t<cim:OASISMasterType.ATL_PNODE rdf:resource=\"#" + ATL_PNODE + "\"/>\n" else "") +
        (if (null != ATL_PNODE_MAP) "\t\t<cim:OASISMasterType.ATL_PNODE_MAP rdf:resource=\"#" + ATL_PNODE_MAP + "\"/>\n" else "") +
        (if (null != ATL_PUB) "\t\t<cim:OASISMasterType.ATL_PUB rdf:resource=\"#" + ATL_PUB + "\"/>\n" else "") +
        (if (null != ATL_PUB_SCHED) "\t\t<cim:OASISMasterType.ATL_PUB_SCHED rdf:resource=\"#" + ATL_PUB_SCHED + "\"/>\n" else "") +
        (if (null != ATL_RESOURCE) "\t\t<cim:OASISMasterType.ATL_RESOURCE rdf:resource=\"#" + ATL_RESOURCE + "\"/>\n" else "") +
        (if (null != ATL_RUC_ZONE) "\t\t<cim:OASISMasterType.ATL_RUC_ZONE rdf:resource=\"#" + ATL_RUC_ZONE + "\"/>\n" else "") +
        (if (null != ATL_RUC_ZONE_MAP) "\t\t<cim:OASISMasterType.ATL_RUC_ZONE_MAP rdf:resource=\"#" + ATL_RUC_ZONE_MAP + "\"/>\n" else "") +
        (if (null != ATL_STAT) "\t\t<cim:OASISMasterType.ATL_STAT rdf:resource=\"#" + ATL_STAT + "\"/>\n" else "") +
        (if (null != ATL_TAC_AREA) "\t\t<cim:OASISMasterType.ATL_TAC_AREA rdf:resource=\"#" + ATL_TAC_AREA + "\"/>\n" else "") +
        (if (null != ATL_TAC_AREA_MAP) "\t\t<cim:OASISMasterType.ATL_TAC_AREA_MAP rdf:resource=\"#" + ATL_TAC_AREA_MAP + "\"/>\n" else "") +
        (if (null != ATL_TI) "\t\t<cim:OASISMasterType.ATL_TI rdf:resource=\"#" + ATL_TI + "\"/>\n" else "") +
        (if (null != ATL_TIEPOINT) "\t\t<cim:OASISMasterType.ATL_TIEPOINT rdf:resource=\"#" + ATL_TIEPOINT + "\"/>\n" else "") +
        (if (null != ATL_XREF) "\t\t<cim:OASISMasterType.ATL_XREF rdf:resource=\"#" + ATL_XREF + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OASISMasterType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OASISMasterType>\n"
    }
}

object OASISMasterType
extends
    Parseable[OASISMasterType]
{
    val ATL_APNODE: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_APNODE"""))
    val ATL_AS_REGION: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_AS_REGION"""))
    val ATL_AS_REGION_MAP: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_AS_REGION_MAP"""))
    val ATL_HUB: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_HUB"""))
    val ATL_LAP: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_LAP"""))
    val ATL_LDF: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_LDF"""))
    val ATL_PNODE: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_PNODE"""))
    val ATL_PNODE_MAP: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_PNODE_MAP"""))
    val ATL_PUB: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_PUB"""))
    val ATL_PUB_SCHED: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_PUB_SCHED"""))
    val ATL_RESOURCE: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_RESOURCE"""))
    val ATL_RUC_ZONE: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_RUC_ZONE"""))
    val ATL_RUC_ZONE_MAP: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_RUC_ZONE_MAP"""))
    val ATL_STAT: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_STAT"""))
    val ATL_TAC_AREA: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_TAC_AREA"""))
    val ATL_TAC_AREA_MAP: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_TAC_AREA_MAP"""))
    val ATL_TI: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_TI"""))
    val ATL_TIEPOINT: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_TIEPOINT"""))
    val ATL_XREF: (Context) => String = parse_attribute (attribute ("""OASISMasterType.ATL_XREF"""))
    def parse (context: Context): OASISMasterType =
    {
        OASISMasterType(
            BasicElement.parse (context),
            ATL_APNODE (context),
            ATL_AS_REGION (context),
            ATL_AS_REGION_MAP (context),
            ATL_HUB (context),
            ATL_LAP (context),
            ATL_LDF (context),
            ATL_PNODE (context),
            ATL_PNODE_MAP (context),
            ATL_PUB (context),
            ATL_PUB_SCHED (context),
            ATL_RESOURCE (context),
            ATL_RUC_ZONE (context),
            ATL_RUC_ZONE_MAP (context),
            ATL_STAT (context),
            ATL_TAC_AREA (context),
            ATL_TAC_AREA_MAP (context),
            ATL_TI (context),
            ATL_TIEPOINT (context),
            ATL_XREF (context)
        )
    }
}

case class OASISMeasType
(
    override val sup: BasicElement,
    percent: String,
    FACTOR: String,
    FLAG: String,
    INTEGER: String,
    MW: String,
    MWh: String,
    US$: String,
    US$_MW: String,
    US$_MWh: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OASISMeasType] }
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
        sup.export_fields +
        (if (null != percent) "\t\t<cim:OASISMeasType.% rdf:resource=\"#" + percent + "\"/>\n" else "") +
        (if (null != FACTOR) "\t\t<cim:OASISMeasType.FACTOR rdf:resource=\"#" + FACTOR + "\"/>\n" else "") +
        (if (null != FLAG) "\t\t<cim:OASISMeasType.FLAG rdf:resource=\"#" + FLAG + "\"/>\n" else "") +
        (if (null != INTEGER) "\t\t<cim:OASISMeasType.INTEGER rdf:resource=\"#" + INTEGER + "\"/>\n" else "") +
        (if (null != MW) "\t\t<cim:OASISMeasType.MW rdf:resource=\"#" + MW + "\"/>\n" else "") +
        (if (null != MWh) "\t\t<cim:OASISMeasType.MWh rdf:resource=\"#" + MWh + "\"/>\n" else "") +
        (if (null != US$) "\t\t<cim:OASISMeasType.US$ rdf:resource=\"#" + US$ + "\"/>\n" else "") +
        (if (null != US$_MW) "\t\t<cim:OASISMeasType.US$/MW rdf:resource=\"#" + US$_MW + "\"/>\n" else "") +
        (if (null != US$_MWh) "\t\t<cim:OASISMeasType.US$/MWh rdf:resource=\"#" + US$_MWh + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OASISMeasType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OASISMeasType>\n"
    }
}

object OASISMeasType
extends
    Parseable[OASISMeasType]
{
    val percent: (Context) => String = parse_attribute (attribute ("""OASISMeasType.%"""))
    val FACTOR: (Context) => String = parse_attribute (attribute ("""OASISMeasType.FACTOR"""))
    val FLAG: (Context) => String = parse_attribute (attribute ("""OASISMeasType.FLAG"""))
    val INTEGER: (Context) => String = parse_attribute (attribute ("""OASISMeasType.INTEGER"""))
    val MW: (Context) => String = parse_attribute (attribute ("""OASISMeasType.MW"""))
    val MWh: (Context) => String = parse_attribute (attribute ("""OASISMeasType.MWh"""))
    val US$: (Context) => String = parse_attribute (attribute ("""OASISMeasType.US$"""))
    val US$_MW: (Context) => String = parse_attribute (attribute ("""OASISMeasType.US$/MW"""))
    val US$_MWh: (Context) => String = parse_attribute (attribute ("""OASISMeasType.US$/MWh"""))
    def parse (context: Context): OASISMeasType =
    {
        OASISMeasType(
            BasicElement.parse (context),
            percent (context),
            FACTOR (context),
            FLAG (context),
            INTEGER (context),
            MW (context),
            MWh (context),
            US$ (context),
            US$_MW (context),
            US$_MWh (context)
        )
    }
}

case class OASISReportType
(
    override val sup: BasicElement,
    AS_DA_RESULT: String,
    AS_OP_RSRV: String,
    AS_REQ: String,
    AS_RTM_RESULT: String,
    BIDS_PUBLIC: String,
    CMMT_RA_MLC: String,
    CMMT_RMR: String,
    CRR_CLEARING: String,
    CRR_INVENTORY: String,
    ENE_EA: String,
    ENE_HASP: String,
    ENE_IFM: String,
    ENE_MPM: String,
    ENE_RTM: String,
    ENE_RUC: String,
    LOSS_DA_HASP: String,
    LOSS_RTM: String,
    PRC_AS: String,
    PRC_CNSTR: String,
    PRC_FUEL: String,
    PRC_HRLY_LMP: String,
    PRC_INTVL_LMP: String,
    SLD_FCST: String,
    SLD_FCST_PEAK: String,
    SLD_MKTS: String,
    TRNS_ATC: String,
    TRNS_OUTAGE: String,
    TRNS_USAGE: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OASISReportType] }
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
        sup.export_fields +
        (if (null != AS_DA_RESULT) "\t\t<cim:OASISReportType.AS_DA_RESULT rdf:resource=\"#" + AS_DA_RESULT + "\"/>\n" else "") +
        (if (null != AS_OP_RSRV) "\t\t<cim:OASISReportType.AS_OP_RSRV rdf:resource=\"#" + AS_OP_RSRV + "\"/>\n" else "") +
        (if (null != AS_REQ) "\t\t<cim:OASISReportType.AS_REQ rdf:resource=\"#" + AS_REQ + "\"/>\n" else "") +
        (if (null != AS_RTM_RESULT) "\t\t<cim:OASISReportType.AS_RTM_RESULT rdf:resource=\"#" + AS_RTM_RESULT + "\"/>\n" else "") +
        (if (null != BIDS_PUBLIC) "\t\t<cim:OASISReportType.BIDS_PUBLIC rdf:resource=\"#" + BIDS_PUBLIC + "\"/>\n" else "") +
        (if (null != CMMT_RA_MLC) "\t\t<cim:OASISReportType.CMMT_RA_MLC rdf:resource=\"#" + CMMT_RA_MLC + "\"/>\n" else "") +
        (if (null != CMMT_RMR) "\t\t<cim:OASISReportType.CMMT_RMR rdf:resource=\"#" + CMMT_RMR + "\"/>\n" else "") +
        (if (null != CRR_CLEARING) "\t\t<cim:OASISReportType.CRR_CLEARING rdf:resource=\"#" + CRR_CLEARING + "\"/>\n" else "") +
        (if (null != CRR_INVENTORY) "\t\t<cim:OASISReportType.CRR_INVENTORY rdf:resource=\"#" + CRR_INVENTORY + "\"/>\n" else "") +
        (if (null != ENE_EA) "\t\t<cim:OASISReportType.ENE_EA rdf:resource=\"#" + ENE_EA + "\"/>\n" else "") +
        (if (null != ENE_HASP) "\t\t<cim:OASISReportType.ENE_HASP rdf:resource=\"#" + ENE_HASP + "\"/>\n" else "") +
        (if (null != ENE_IFM) "\t\t<cim:OASISReportType.ENE_IFM rdf:resource=\"#" + ENE_IFM + "\"/>\n" else "") +
        (if (null != ENE_MPM) "\t\t<cim:OASISReportType.ENE_MPM rdf:resource=\"#" + ENE_MPM + "\"/>\n" else "") +
        (if (null != ENE_RTM) "\t\t<cim:OASISReportType.ENE_RTM rdf:resource=\"#" + ENE_RTM + "\"/>\n" else "") +
        (if (null != ENE_RUC) "\t\t<cim:OASISReportType.ENE_RUC rdf:resource=\"#" + ENE_RUC + "\"/>\n" else "") +
        (if (null != LOSS_DA_HASP) "\t\t<cim:OASISReportType.LOSS_DA_HASP rdf:resource=\"#" + LOSS_DA_HASP + "\"/>\n" else "") +
        (if (null != LOSS_RTM) "\t\t<cim:OASISReportType.LOSS_RTM rdf:resource=\"#" + LOSS_RTM + "\"/>\n" else "") +
        (if (null != PRC_AS) "\t\t<cim:OASISReportType.PRC_AS rdf:resource=\"#" + PRC_AS + "\"/>\n" else "") +
        (if (null != PRC_CNSTR) "\t\t<cim:OASISReportType.PRC_CNSTR rdf:resource=\"#" + PRC_CNSTR + "\"/>\n" else "") +
        (if (null != PRC_FUEL) "\t\t<cim:OASISReportType.PRC_FUEL rdf:resource=\"#" + PRC_FUEL + "\"/>\n" else "") +
        (if (null != PRC_HRLY_LMP) "\t\t<cim:OASISReportType.PRC_HRLY_LMP rdf:resource=\"#" + PRC_HRLY_LMP + "\"/>\n" else "") +
        (if (null != PRC_INTVL_LMP) "\t\t<cim:OASISReportType.PRC_INTVL_LMP rdf:resource=\"#" + PRC_INTVL_LMP + "\"/>\n" else "") +
        (if (null != SLD_FCST) "\t\t<cim:OASISReportType.SLD_FCST rdf:resource=\"#" + SLD_FCST + "\"/>\n" else "") +
        (if (null != SLD_FCST_PEAK) "\t\t<cim:OASISReportType.SLD_FCST_PEAK rdf:resource=\"#" + SLD_FCST_PEAK + "\"/>\n" else "") +
        (if (null != SLD_MKTS) "\t\t<cim:OASISReportType.SLD_MKTS rdf:resource=\"#" + SLD_MKTS + "\"/>\n" else "") +
        (if (null != TRNS_ATC) "\t\t<cim:OASISReportType.TRNS_ATC rdf:resource=\"#" + TRNS_ATC + "\"/>\n" else "") +
        (if (null != TRNS_OUTAGE) "\t\t<cim:OASISReportType.TRNS_OUTAGE rdf:resource=\"#" + TRNS_OUTAGE + "\"/>\n" else "") +
        (if (null != TRNS_USAGE) "\t\t<cim:OASISReportType.TRNS_USAGE rdf:resource=\"#" + TRNS_USAGE + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OASISReportType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OASISReportType>\n"
    }
}

object OASISReportType
extends
    Parseable[OASISReportType]
{
    val AS_DA_RESULT: (Context) => String = parse_attribute (attribute ("""OASISReportType.AS_DA_RESULT"""))
    val AS_OP_RSRV: (Context) => String = parse_attribute (attribute ("""OASISReportType.AS_OP_RSRV"""))
    val AS_REQ: (Context) => String = parse_attribute (attribute ("""OASISReportType.AS_REQ"""))
    val AS_RTM_RESULT: (Context) => String = parse_attribute (attribute ("""OASISReportType.AS_RTM_RESULT"""))
    val BIDS_PUBLIC: (Context) => String = parse_attribute (attribute ("""OASISReportType.BIDS_PUBLIC"""))
    val CMMT_RA_MLC: (Context) => String = parse_attribute (attribute ("""OASISReportType.CMMT_RA_MLC"""))
    val CMMT_RMR: (Context) => String = parse_attribute (attribute ("""OASISReportType.CMMT_RMR"""))
    val CRR_CLEARING: (Context) => String = parse_attribute (attribute ("""OASISReportType.CRR_CLEARING"""))
    val CRR_INVENTORY: (Context) => String = parse_attribute (attribute ("""OASISReportType.CRR_INVENTORY"""))
    val ENE_EA: (Context) => String = parse_attribute (attribute ("""OASISReportType.ENE_EA"""))
    val ENE_HASP: (Context) => String = parse_attribute (attribute ("""OASISReportType.ENE_HASP"""))
    val ENE_IFM: (Context) => String = parse_attribute (attribute ("""OASISReportType.ENE_IFM"""))
    val ENE_MPM: (Context) => String = parse_attribute (attribute ("""OASISReportType.ENE_MPM"""))
    val ENE_RTM: (Context) => String = parse_attribute (attribute ("""OASISReportType.ENE_RTM"""))
    val ENE_RUC: (Context) => String = parse_attribute (attribute ("""OASISReportType.ENE_RUC"""))
    val LOSS_DA_HASP: (Context) => String = parse_attribute (attribute ("""OASISReportType.LOSS_DA_HASP"""))
    val LOSS_RTM: (Context) => String = parse_attribute (attribute ("""OASISReportType.LOSS_RTM"""))
    val PRC_AS: (Context) => String = parse_attribute (attribute ("""OASISReportType.PRC_AS"""))
    val PRC_CNSTR: (Context) => String = parse_attribute (attribute ("""OASISReportType.PRC_CNSTR"""))
    val PRC_FUEL: (Context) => String = parse_attribute (attribute ("""OASISReportType.PRC_FUEL"""))
    val PRC_HRLY_LMP: (Context) => String = parse_attribute (attribute ("""OASISReportType.PRC_HRLY_LMP"""))
    val PRC_INTVL_LMP: (Context) => String = parse_attribute (attribute ("""OASISReportType.PRC_INTVL_LMP"""))
    val SLD_FCST: (Context) => String = parse_attribute (attribute ("""OASISReportType.SLD_FCST"""))
    val SLD_FCST_PEAK: (Context) => String = parse_attribute (attribute ("""OASISReportType.SLD_FCST_PEAK"""))
    val SLD_MKTS: (Context) => String = parse_attribute (attribute ("""OASISReportType.SLD_MKTS"""))
    val TRNS_ATC: (Context) => String = parse_attribute (attribute ("""OASISReportType.TRNS_ATC"""))
    val TRNS_OUTAGE: (Context) => String = parse_attribute (attribute ("""OASISReportType.TRNS_OUTAGE"""))
    val TRNS_USAGE: (Context) => String = parse_attribute (attribute ("""OASISReportType.TRNS_USAGE"""))
    def parse (context: Context): OASISReportType =
    {
        OASISReportType(
            BasicElement.parse (context),
            AS_DA_RESULT (context),
            AS_OP_RSRV (context),
            AS_REQ (context),
            AS_RTM_RESULT (context),
            BIDS_PUBLIC (context),
            CMMT_RA_MLC (context),
            CMMT_RMR (context),
            CRR_CLEARING (context),
            CRR_INVENTORY (context),
            ENE_EA (context),
            ENE_HASP (context),
            ENE_IFM (context),
            ENE_MPM (context),
            ENE_RTM (context),
            ENE_RUC (context),
            LOSS_DA_HASP (context),
            LOSS_RTM (context),
            PRC_AS (context),
            PRC_CNSTR (context),
            PRC_FUEL (context),
            PRC_HRLY_LMP (context),
            PRC_INTVL_LMP (context),
            SLD_FCST (context),
            SLD_FCST_PEAK (context),
            SLD_MKTS (context),
            TRNS_ATC (context),
            TRNS_OUTAGE (context),
            TRNS_USAGE (context)
        )
    }
}

case class OASISStatusType
(
    override val sup: BasicElement,
    Data_Transfer_Procedure_Initiated: String,
    Data_Transfer_Succesful: String,
    Forced_Termination: String,
    Obsolete: String,
    Push_Failed: String,
    Valid: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OASISStatusType] }
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
        sup.export_fields +
        (if (null != Data_Transfer_Procedure_Initiated) "\t\t<cim:OASISStatusType.Data_Transfer_Procedure_Initiated rdf:resource=\"#" + Data_Transfer_Procedure_Initiated + "\"/>\n" else "") +
        (if (null != Data_Transfer_Succesful) "\t\t<cim:OASISStatusType.Data_Transfer_Succesful rdf:resource=\"#" + Data_Transfer_Succesful + "\"/>\n" else "") +
        (if (null != Forced_Termination) "\t\t<cim:OASISStatusType.Forced_Termination rdf:resource=\"#" + Forced_Termination + "\"/>\n" else "") +
        (if (null != Obsolete) "\t\t<cim:OASISStatusType.Obsolete rdf:resource=\"#" + Obsolete + "\"/>\n" else "") +
        (if (null != Push_Failed) "\t\t<cim:OASISStatusType.Push_Failed rdf:resource=\"#" + Push_Failed + "\"/>\n" else "") +
        (if (null != Valid) "\t\t<cim:OASISStatusType.Valid rdf:resource=\"#" + Valid + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OASISStatusType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OASISStatusType>\n"
    }
}

object OASISStatusType
extends
    Parseable[OASISStatusType]
{
    val Data_Transfer_Procedure_Initiated: (Context) => String = parse_attribute (attribute ("""OASISStatusType.Data_Transfer_Procedure_Initiated"""))
    val Data_Transfer_Succesful: (Context) => String = parse_attribute (attribute ("""OASISStatusType.Data_Transfer_Succesful"""))
    val Forced_Termination: (Context) => String = parse_attribute (attribute ("""OASISStatusType.Forced_Termination"""))
    val Obsolete: (Context) => String = parse_attribute (attribute ("""OASISStatusType.Obsolete"""))
    val Push_Failed: (Context) => String = parse_attribute (attribute ("""OASISStatusType.Push_Failed"""))
    val Valid: (Context) => String = parse_attribute (attribute ("""OASISStatusType.Valid"""))
    def parse (context: Context): OASISStatusType =
    {
        OASISStatusType(
            BasicElement.parse (context),
            Data_Transfer_Procedure_Initiated (context),
            Data_Transfer_Succesful (context),
            Forced_Termination (context),
            Obsolete (context),
            Push_Failed (context),
            Valid (context)
        )
    }
}

/**
 * organization code
 * @param sup Reference to the superclass object.
 * @param BILL_TO <em>undocumented</em>
 * @param PAY_TO <em>undocumented</em>
 * @param PROVIDED_BY <em>undocumented</em>
 * @param SOLD_TO <em>undocumented</em>
 */
case class OrganisationCode
(
    override val sup: BasicElement,
    BILL_TO: String,
    PAY_TO: String,
    PROVIDED_BY: String,
    SOLD_TO: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OrganisationCode] }
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
        sup.export_fields +
        (if (null != BILL_TO) "\t\t<cim:OrganisationCode.BILL_TO rdf:resource=\"#" + BILL_TO + "\"/>\n" else "") +
        (if (null != PAY_TO) "\t\t<cim:OrganisationCode.PAY_TO rdf:resource=\"#" + PAY_TO + "\"/>\n" else "") +
        (if (null != PROVIDED_BY) "\t\t<cim:OrganisationCode.PROVIDED_BY rdf:resource=\"#" + PROVIDED_BY + "\"/>\n" else "") +
        (if (null != SOLD_TO) "\t\t<cim:OrganisationCode.SOLD_TO rdf:resource=\"#" + SOLD_TO + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OrganisationCode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OrganisationCode>\n"
    }
}

object OrganisationCode
extends
    Parseable[OrganisationCode]
{
    val BILL_TO: (Context) => String = parse_attribute (attribute ("""OrganisationCode.BILL_TO"""))
    val PAY_TO: (Context) => String = parse_attribute (attribute ("""OrganisationCode.PAY_TO"""))
    val PROVIDED_BY: (Context) => String = parse_attribute (attribute ("""OrganisationCode.PROVIDED_BY"""))
    val SOLD_TO: (Context) => String = parse_attribute (attribute ("""OrganisationCode.SOLD_TO"""))
    def parse (context: Context): OrganisationCode =
    {
        OrganisationCode(
            BasicElement.parse (context),
            BILL_TO (context),
            PAY_TO (context),
            PROVIDED_BY (context),
            SOLD_TO (context)
        )
    }
}

/**
 * organization type
 * @param sup Reference to the superclass object.
 * @param CUSTOMER <em>undocumented</em>
 * @param RTO <em>undocumented</em>
 */
case class OrganisationType
(
    override val sup: BasicElement,
    CUSTOMER: String,
    RTO: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OrganisationType] }
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
        sup.export_fields +
        (if (null != CUSTOMER) "\t\t<cim:OrganisationType.CUSTOMER rdf:resource=\"#" + CUSTOMER + "\"/>\n" else "") +
        (if (null != RTO) "\t\t<cim:OrganisationType.RTO rdf:resource=\"#" + RTO + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OrganisationType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OrganisationType>\n"
    }
}

object OrganisationType
extends
    Parseable[OrganisationType]
{
    val CUSTOMER: (Context) => String = parse_attribute (attribute ("""OrganisationType.CUSTOMER"""))
    val RTO: (Context) => String = parse_attribute (attribute ("""OrganisationType.RTO"""))
    def parse (context: Context): OrganisationType =
    {
        OrganisationType(
            BasicElement.parse (context),
            CUSTOMER (context),
            RTO (context)
        )
    }
}

/**
 * Y - indicates a resource is capable of setting the Markte Clearing Price 
S - indicates the resource must submit bids for energy at $ 0
 * N - indicates the resource does not have to submit bids for energy at $ 0
 * @param sup Reference to the superclass object.
 * @param N <em>undocumented</em>
 * @param S <em>undocumented</em>
 * @param Y <em>undocumented</em>
 */
case class PriceSetFlag
(
    override val sup: BasicElement,
    N: String,
    S: String,
    Y: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PriceSetFlag] }
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
        sup.export_fields +
        (if (null != N) "\t\t<cim:PriceSetFlag.N rdf:resource=\"#" + N + "\"/>\n" else "") +
        (if (null != S) "\t\t<cim:PriceSetFlag.S rdf:resource=\"#" + S + "\"/>\n" else "") +
        (if (null != Y) "\t\t<cim:PriceSetFlag.Y rdf:resource=\"#" + Y + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PriceSetFlag rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PriceSetFlag>\n"
    }
}

object PriceSetFlag
extends
    Parseable[PriceSetFlag]
{
    val N: (Context) => String = parse_attribute (attribute ("""PriceSetFlag.N"""))
    val S: (Context) => String = parse_attribute (attribute ("""PriceSetFlag.S"""))
    val Y: (Context) => String = parse_attribute (attribute ("""PriceSetFlag.Y"""))
    def parse (context: Context): PriceSetFlag =
    {
        PriceSetFlag(
            BasicElement.parse (context),
            N (context),
            S (context),
            Y (context)
        )
    }
}

/**
 * MP
 * ISO
 * @param sup Reference to the superclass object.
 * @param ISO <em>undocumented</em>
 * @param MP <em>undocumented</em>
 */
case class RequestorRmrTest
(
    override val sup: BasicElement,
    ISO: String,
    MP: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[RequestorRmrTest] }
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
        sup.export_fields +
        (if (null != ISO) "\t\t<cim:RequestorRmrTest.ISO rdf:resource=\"#" + ISO + "\"/>\n" else "") +
        (if (null != MP) "\t\t<cim:RequestorRmrTest.MP rdf:resource=\"#" + MP + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RequestorRmrTest rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RequestorRmrTest>\n"
    }
}

object RequestorRmrTest
extends
    Parseable[RequestorRmrTest]
{
    val ISO: (Context) => String = parse_attribute (attribute ("""RequestorRmrTest.ISO"""))
    val MP: (Context) => String = parse_attribute (attribute ("""RequestorRmrTest.MP"""))
    def parse (context: Context): RequestorRmrTest =
    {
        RequestorRmrTest(
            BasicElement.parse (context),
            ISO (context),
            MP (context)
        )
    }
}

case class ResourceCertificationCategory
(
    override val sup: BasicElement,
    DAM: String,
    GT: String,
    RC: String,
    RTM: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceCertificationCategory] }
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
        sup.export_fields +
        (if (null != DAM) "\t\t<cim:ResourceCertificationCategory.DAM rdf:resource=\"#" + DAM + "\"/>\n" else "") +
        (if (null != GT) "\t\t<cim:ResourceCertificationCategory.GT rdf:resource=\"#" + GT + "\"/>\n" else "") +
        (if (null != RC) "\t\t<cim:ResourceCertificationCategory.RC rdf:resource=\"#" + RC + "\"/>\n" else "") +
        (if (null != RTM) "\t\t<cim:ResourceCertificationCategory.RTM rdf:resource=\"#" + RTM + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceCertificationCategory rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceCertificationCategory>\n"
    }
}

object ResourceCertificationCategory
extends
    Parseable[ResourceCertificationCategory]
{
    val DAM: (Context) => String = parse_attribute (attribute ("""ResourceCertificationCategory.DAM"""))
    val GT: (Context) => String = parse_attribute (attribute ("""ResourceCertificationCategory.GT"""))
    val RC: (Context) => String = parse_attribute (attribute ("""ResourceCertificationCategory.RC"""))
    val RTM: (Context) => String = parse_attribute (attribute ("""ResourceCertificationCategory.RTM"""))
    def parse (context: Context): ResourceCertificationCategory =
    {
        ResourceCertificationCategory(
            BasicElement.parse (context),
            DAM (context),
            GT (context),
            RC (context),
            RTM (context)
        )
    }
}

case class ResourceCertificationType
(
    override val sup: BasicElement,
    GT: String,
    IR: String,
    NR: String,
    RG: String,
    SR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceCertificationType] }
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
        sup.export_fields +
        (if (null != GT) "\t\t<cim:ResourceCertificationType.GT rdf:resource=\"#" + GT + "\"/>\n" else "") +
        (if (null != IR) "\t\t<cim:ResourceCertificationType.IR rdf:resource=\"#" + IR + "\"/>\n" else "") +
        (if (null != NR) "\t\t<cim:ResourceCertificationType.NR rdf:resource=\"#" + NR + "\"/>\n" else "") +
        (if (null != RG) "\t\t<cim:ResourceCertificationType.RG rdf:resource=\"#" + RG + "\"/>\n" else "") +
        (if (null != SR) "\t\t<cim:ResourceCertificationType.SR rdf:resource=\"#" + SR + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceCertificationType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceCertificationType>\n"
    }
}

object ResourceCertificationType
extends
    Parseable[ResourceCertificationType]
{
    val GT: (Context) => String = parse_attribute (attribute ("""ResourceCertificationType.GT"""))
    val IR: (Context) => String = parse_attribute (attribute ("""ResourceCertificationType.IR"""))
    val NR: (Context) => String = parse_attribute (attribute ("""ResourceCertificationType.NR"""))
    val RG: (Context) => String = parse_attribute (attribute ("""ResourceCertificationType.RG"""))
    val SR: (Context) => String = parse_attribute (attribute ("""ResourceCertificationType.SR"""))
    def parse (context: Context): ResourceCertificationType =
    {
        ResourceCertificationType(
            BasicElement.parse (context),
            GT (context),
            IR (context),
            NR (context),
            RG (context),
            SR (context)
        )
    }
}

case class SchedClassType
(
    override val sup: BasicElement,
    F: String,
    P: String,
    R: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SchedClassType] }
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
        sup.export_fields +
        (if (null != F) "\t\t<cim:SchedClassType.F rdf:resource=\"#" + F + "\"/>\n" else "") +
        (if (null != P) "\t\t<cim:SchedClassType.P rdf:resource=\"#" + P + "\"/>\n" else "") +
        (if (null != R) "\t\t<cim:SchedClassType.R rdf:resource=\"#" + R + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SchedClassType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SchedClassType>\n"
    }
}

object SchedClassType
extends
    Parseable[SchedClassType]
{
    val F: (Context) => String = parse_attribute (attribute ("""SchedClassType.F"""))
    val P: (Context) => String = parse_attribute (attribute ("""SchedClassType.P"""))
    val R: (Context) => String = parse_attribute (attribute ("""SchedClassType.R"""))
    def parse (context: Context): SchedClassType =
    {
        SchedClassType(
            BasicElement.parse (context),
            F (context),
            P (context),
            R (context)
        )
    }
}

case class SegmentCurveType
(
    override val sup: BasicElement,
    CONSULTATIVE: String,
    COST: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SegmentCurveType] }
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
        sup.export_fields +
        (if (null != CONSULTATIVE) "\t\t<cim:SegmentCurveType.CONSULTATIVE rdf:resource=\"#" + CONSULTATIVE + "\"/>\n" else "") +
        (if (null != COST) "\t\t<cim:SegmentCurveType.COST rdf:resource=\"#" + COST + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SegmentCurveType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SegmentCurveType>\n"
    }
}

object SegmentCurveType
extends
    Parseable[SegmentCurveType]
{
    val CONSULTATIVE: (Context) => String = parse_attribute (attribute ("""SegmentCurveType.CONSULTATIVE"""))
    val COST: (Context) => String = parse_attribute (attribute ("""SegmentCurveType.COST"""))
    def parse (context: Context): SegmentCurveType =
    {
        SegmentCurveType(
            BasicElement.parse (context),
            CONSULTATIVE (context),
            COST (context)
        )
    }
}

case class SelfSchedTypeCleanBid
(
    override val sup: BasicElement,
    BAS: String,
    ETC: String,
    IFM: String,
    LOF: String,
    LPT: String,
    PT: String,
    RA: String,
    RMT: String,
    SP: String,
    TOR: String,
    WHL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SelfSchedTypeCleanBid] }
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
        sup.export_fields +
        (if (null != BAS) "\t\t<cim:SelfSchedTypeCleanBid.BAS rdf:resource=\"#" + BAS + "\"/>\n" else "") +
        (if (null != ETC) "\t\t<cim:SelfSchedTypeCleanBid.ETC rdf:resource=\"#" + ETC + "\"/>\n" else "") +
        (if (null != IFM) "\t\t<cim:SelfSchedTypeCleanBid.IFM rdf:resource=\"#" + IFM + "\"/>\n" else "") +
        (if (null != LOF) "\t\t<cim:SelfSchedTypeCleanBid.LOF rdf:resource=\"#" + LOF + "\"/>\n" else "") +
        (if (null != LPT) "\t\t<cim:SelfSchedTypeCleanBid.LPT rdf:resource=\"#" + LPT + "\"/>\n" else "") +
        (if (null != PT) "\t\t<cim:SelfSchedTypeCleanBid.PT rdf:resource=\"#" + PT + "\"/>\n" else "") +
        (if (null != RA) "\t\t<cim:SelfSchedTypeCleanBid.RA rdf:resource=\"#" + RA + "\"/>\n" else "") +
        (if (null != RMT) "\t\t<cim:SelfSchedTypeCleanBid.RMT rdf:resource=\"#" + RMT + "\"/>\n" else "") +
        (if (null != SP) "\t\t<cim:SelfSchedTypeCleanBid.SP rdf:resource=\"#" + SP + "\"/>\n" else "") +
        (if (null != TOR) "\t\t<cim:SelfSchedTypeCleanBid.TOR rdf:resource=\"#" + TOR + "\"/>\n" else "") +
        (if (null != WHL) "\t\t<cim:SelfSchedTypeCleanBid.WHL rdf:resource=\"#" + WHL + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SelfSchedTypeCleanBid rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SelfSchedTypeCleanBid>\n"
    }
}

object SelfSchedTypeCleanBid
extends
    Parseable[SelfSchedTypeCleanBid]
{
    val BAS: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeCleanBid.BAS"""))
    val ETC: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeCleanBid.ETC"""))
    val IFM: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeCleanBid.IFM"""))
    val LOF: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeCleanBid.LOF"""))
    val LPT: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeCleanBid.LPT"""))
    val PT: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeCleanBid.PT"""))
    val RA: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeCleanBid.RA"""))
    val RMT: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeCleanBid.RMT"""))
    val SP: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeCleanBid.SP"""))
    val TOR: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeCleanBid.TOR"""))
    val WHL: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeCleanBid.WHL"""))
    def parse (context: Context): SelfSchedTypeCleanBid =
    {
        SelfSchedTypeCleanBid(
            BasicElement.parse (context),
            BAS (context),
            ETC (context),
            IFM (context),
            LOF (context),
            LPT (context),
            PT (context),
            RA (context),
            RMT (context),
            SP (context),
            TOR (context),
            WHL (context)
        )
    }
}

case class SelfSchedTypeRawBid
(
    override val sup: BasicElement,
    BAS: String,
    ETC: String,
    LOF: String,
    LPT: String,
    PT: String,
    RA: String,
    RMT: String,
    SP: String,
    TOR: String,
    WHL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SelfSchedTypeRawBid] }
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
        sup.export_fields +
        (if (null != BAS) "\t\t<cim:SelfSchedTypeRawBid.BAS rdf:resource=\"#" + BAS + "\"/>\n" else "") +
        (if (null != ETC) "\t\t<cim:SelfSchedTypeRawBid.ETC rdf:resource=\"#" + ETC + "\"/>\n" else "") +
        (if (null != LOF) "\t\t<cim:SelfSchedTypeRawBid.LOF rdf:resource=\"#" + LOF + "\"/>\n" else "") +
        (if (null != LPT) "\t\t<cim:SelfSchedTypeRawBid.LPT rdf:resource=\"#" + LPT + "\"/>\n" else "") +
        (if (null != PT) "\t\t<cim:SelfSchedTypeRawBid.PT rdf:resource=\"#" + PT + "\"/>\n" else "") +
        (if (null != RA) "\t\t<cim:SelfSchedTypeRawBid.RA rdf:resource=\"#" + RA + "\"/>\n" else "") +
        (if (null != RMT) "\t\t<cim:SelfSchedTypeRawBid.RMT rdf:resource=\"#" + RMT + "\"/>\n" else "") +
        (if (null != SP) "\t\t<cim:SelfSchedTypeRawBid.SP rdf:resource=\"#" + SP + "\"/>\n" else "") +
        (if (null != TOR) "\t\t<cim:SelfSchedTypeRawBid.TOR rdf:resource=\"#" + TOR + "\"/>\n" else "") +
        (if (null != WHL) "\t\t<cim:SelfSchedTypeRawBid.WHL rdf:resource=\"#" + WHL + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SelfSchedTypeRawBid rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SelfSchedTypeRawBid>\n"
    }
}

object SelfSchedTypeRawBid
extends
    Parseable[SelfSchedTypeRawBid]
{
    val BAS: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeRawBid.BAS"""))
    val ETC: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeRawBid.ETC"""))
    val LOF: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeRawBid.LOF"""))
    val LPT: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeRawBid.LPT"""))
    val PT: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeRawBid.PT"""))
    val RA: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeRawBid.RA"""))
    val RMT: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeRawBid.RMT"""))
    val SP: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeRawBid.SP"""))
    val TOR: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeRawBid.TOR"""))
    val WHL: (Context) => String = parse_attribute (attribute ("""SelfSchedTypeRawBid.WHL"""))
    def parse (context: Context): SelfSchedTypeRawBid =
    {
        SelfSchedTypeRawBid(
            BasicElement.parse (context),
            BAS (context),
            ETC (context),
            LOF (context),
            LPT (context),
            PT (context),
            RA (context),
            RMT (context),
            SP (context),
            TOR (context),
            WHL (context)
        )
    }
}

/**
 * self schedule types

PT
ETC
TOR
RMR
RMT
RGMR
ORFC
 * SP
 * @param sup Reference to the superclass object.
 * @param BAS Base Schedule
 * @param ETC <em>undocumented</em>
 * @param IFM <em>undocumented</em>
 * @param LOF Lay-off schedule
 * @param ORFC <em>undocumented</em>
 * @param PT <em>undocumented</em>
 * @param PUMP_ETC <em>undocumented</em>
 * @param PUMP_TOR <em>undocumented</em>
 * @param RA RA Obligations
 * @param RGMR <em>undocumented</em>
 * @param RMR <em>undocumented</em>
 * @param RMT <em>undocumented</em>
 * @param RUC <em>undocumented</em>
 * @param SP Self-Provision
 * @param TOR <em>undocumented</em>
 * @param WHL <em>undocumented</em>
 */
case class SelfScheduleType
(
    override val sup: BasicElement,
    BAS: String,
    ETC: String,
    IFM: String,
    LOF: String,
    ORFC: String,
    PT: String,
    PUMP_ETC: String,
    PUMP_TOR: String,
    RA: String,
    RGMR: String,
    RMR: String,
    RMT: String,
    RUC: String,
    SP: String,
    TOR: String,
    WHL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SelfScheduleType] }
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
        sup.export_fields +
        (if (null != BAS) "\t\t<cim:SelfScheduleType.BAS rdf:resource=\"#" + BAS + "\"/>\n" else "") +
        (if (null != ETC) "\t\t<cim:SelfScheduleType.ETC rdf:resource=\"#" + ETC + "\"/>\n" else "") +
        (if (null != IFM) "\t\t<cim:SelfScheduleType.IFM rdf:resource=\"#" + IFM + "\"/>\n" else "") +
        (if (null != LOF) "\t\t<cim:SelfScheduleType.LOF rdf:resource=\"#" + LOF + "\"/>\n" else "") +
        (if (null != ORFC) "\t\t<cim:SelfScheduleType.ORFC rdf:resource=\"#" + ORFC + "\"/>\n" else "") +
        (if (null != PT) "\t\t<cim:SelfScheduleType.PT rdf:resource=\"#" + PT + "\"/>\n" else "") +
        (if (null != PUMP_ETC) "\t\t<cim:SelfScheduleType.PUMP_ETC rdf:resource=\"#" + PUMP_ETC + "\"/>\n" else "") +
        (if (null != PUMP_TOR) "\t\t<cim:SelfScheduleType.PUMP_TOR rdf:resource=\"#" + PUMP_TOR + "\"/>\n" else "") +
        (if (null != RA) "\t\t<cim:SelfScheduleType.RA rdf:resource=\"#" + RA + "\"/>\n" else "") +
        (if (null != RGMR) "\t\t<cim:SelfScheduleType.RGMR rdf:resource=\"#" + RGMR + "\"/>\n" else "") +
        (if (null != RMR) "\t\t<cim:SelfScheduleType.RMR rdf:resource=\"#" + RMR + "\"/>\n" else "") +
        (if (null != RMT) "\t\t<cim:SelfScheduleType.RMT rdf:resource=\"#" + RMT + "\"/>\n" else "") +
        (if (null != RUC) "\t\t<cim:SelfScheduleType.RUC rdf:resource=\"#" + RUC + "\"/>\n" else "") +
        (if (null != SP) "\t\t<cim:SelfScheduleType.SP rdf:resource=\"#" + SP + "\"/>\n" else "") +
        (if (null != TOR) "\t\t<cim:SelfScheduleType.TOR rdf:resource=\"#" + TOR + "\"/>\n" else "") +
        (if (null != WHL) "\t\t<cim:SelfScheduleType.WHL rdf:resource=\"#" + WHL + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SelfScheduleType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SelfScheduleType>\n"
    }
}

object SelfScheduleType
extends
    Parseable[SelfScheduleType]
{
    val BAS: (Context) => String = parse_attribute (attribute ("""SelfScheduleType.BAS"""))
    val ETC: (Context) => String = parse_attribute (attribute ("""SelfScheduleType.ETC"""))
    val IFM: (Context) => String = parse_attribute (attribute ("""SelfScheduleType.IFM"""))
    val LOF: (Context) => String = parse_attribute (attribute ("""SelfScheduleType.LOF"""))
    val ORFC: (Context) => String = parse_attribute (attribute ("""SelfScheduleType.ORFC"""))
    val PT: (Context) => String = parse_attribute (attribute ("""SelfScheduleType.PT"""))
    val PUMP_ETC: (Context) => String = parse_attribute (attribute ("""SelfScheduleType.PUMP_ETC"""))
    val PUMP_TOR: (Context) => String = parse_attribute (attribute ("""SelfScheduleType.PUMP_TOR"""))
    val RA: (Context) => String = parse_attribute (attribute ("""SelfScheduleType.RA"""))
    val RGMR: (Context) => String = parse_attribute (attribute ("""SelfScheduleType.RGMR"""))
    val RMR: (Context) => String = parse_attribute (attribute ("""SelfScheduleType.RMR"""))
    val RMT: (Context) => String = parse_attribute (attribute ("""SelfScheduleType.RMT"""))
    val RUC: (Context) => String = parse_attribute (attribute ("""SelfScheduleType.RUC"""))
    val SP: (Context) => String = parse_attribute (attribute ("""SelfScheduleType.SP"""))
    val TOR: (Context) => String = parse_attribute (attribute ("""SelfScheduleType.TOR"""))
    val WHL: (Context) => String = parse_attribute (attribute ("""SelfScheduleType.WHL"""))
    def parse (context: Context): SelfScheduleType =
    {
        SelfScheduleType(
            BasicElement.parse (context),
            BAS (context),
            ETC (context),
            IFM (context),
            LOF (context),
            ORFC (context),
            PT (context),
            PUMP_ETC (context),
            PUMP_TOR (context),
            RA (context),
            RGMR (context),
            RMR (context),
            RMT (context),
            RUC (context),
            SP (context),
            TOR (context),
            WHL (context)
        )
    }
}

/**
 * Self Schedule Types applicable to Mitigated Bid
 * @param sup Reference to the superclass object.
 * @param RMR <em>undocumented</em>
 */
case class SelfScheduleTypeMB
(
    override val sup: BasicElement,
    RMR: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SelfScheduleTypeMB] }
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
        sup.export_fields +
        (if (null != RMR) "\t\t<cim:SelfScheduleTypeMB.RMR rdf:resource=\"#" + RMR + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SelfScheduleTypeMB rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SelfScheduleTypeMB>\n"
    }
}

object SelfScheduleTypeMB
extends
    Parseable[SelfScheduleTypeMB]
{
    val RMR: (Context) => String = parse_attribute (attribute ("""SelfScheduleTypeMB.RMR"""))
    def parse (context: Context): SelfScheduleTypeMB =
    {
        SelfScheduleTypeMB(
            BasicElement.parse (context),
            RMR (context)
        )
    }
}

case class SourceSinkFlag
(
    override val sup: BasicElement,
    CSNK: String,
    CSRC: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SourceSinkFlag] }
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
        sup.export_fields +
        (if (null != CSNK) "\t\t<cim:SourceSinkFlag.CSNK rdf:resource=\"#" + CSNK + "\"/>\n" else "") +
        (if (null != CSRC) "\t\t<cim:SourceSinkFlag.CSRC rdf:resource=\"#" + CSRC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SourceSinkFlag rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SourceSinkFlag>\n"
    }
}

object SourceSinkFlag
extends
    Parseable[SourceSinkFlag]
{
    val CSNK: (Context) => String = parse_attribute (attribute ("""SourceSinkFlag.CSNK"""))
    val CSRC: (Context) => String = parse_attribute (attribute ("""SourceSinkFlag.CSRC"""))
    def parse (context: Context): SourceSinkFlag =
    {
        SourceSinkFlag(
            BasicElement.parse (context),
            CSNK (context),
            CSRC (context)
        )
    }
}

case class SourceSinkType
(
    override val sup: BasicElement,
    Neither: String,
    Sink: String,
    Source: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SourceSinkType] }
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
        sup.export_fields +
        (if (null != Neither) "\t\t<cim:SourceSinkType.Neither rdf:resource=\"#" + Neither + "\"/>\n" else "") +
        (if (null != Sink) "\t\t<cim:SourceSinkType.Sink rdf:resource=\"#" + Sink + "\"/>\n" else "") +
        (if (null != Source) "\t\t<cim:SourceSinkType.Source rdf:resource=\"#" + Source + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SourceSinkType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SourceSinkType>\n"
    }
}

object SourceSinkType
extends
    Parseable[SourceSinkType]
{
    val Neither: (Context) => String = parse_attribute (attribute ("""SourceSinkType.Neither"""))
    val Sink: (Context) => String = parse_attribute (attribute ("""SourceSinkType.Sink"""))
    val Source: (Context) => String = parse_attribute (attribute ("""SourceSinkType.Source"""))
    def parse (context: Context): SourceSinkType =
    {
        SourceSinkType(
            BasicElement.parse (context),
            Neither (context),
            Sink (context),
            Source (context)
        )
    }
}

case class SpinningEventNameType
(
    override val sup: BasicElement,
    EASTERN: String,
    PJM: String,
    RFC_SR: String,
    SOUTH_S: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SpinningEventNameType] }
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
        sup.export_fields +
        (if (null != EASTERN) "\t\t<cim:SpinningEventNameType.EASTERN rdf:resource=\"#" + EASTERN + "\"/>\n" else "") +
        (if (null != PJM) "\t\t<cim:SpinningEventNameType.PJM rdf:resource=\"#" + PJM + "\"/>\n" else "") +
        (if (null != RFC_SR) "\t\t<cim:SpinningEventNameType.RFC-SR rdf:resource=\"#" + RFC_SR + "\"/>\n" else "") +
        (if (null != SOUTH_S) "\t\t<cim:SpinningEventNameType.SOUTH-S rdf:resource=\"#" + SOUTH_S + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SpinningEventNameType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SpinningEventNameType>\n"
    }
}

object SpinningEventNameType
extends
    Parseable[SpinningEventNameType]
{
    val EASTERN: (Context) => String = parse_attribute (attribute ("""SpinningEventNameType.EASTERN"""))
    val PJM: (Context) => String = parse_attribute (attribute ("""SpinningEventNameType.PJM"""))
    val RFC_SR: (Context) => String = parse_attribute (attribute ("""SpinningEventNameType.RFC-SR"""))
    val SOUTH_S: (Context) => String = parse_attribute (attribute ("""SpinningEventNameType.SOUTH-S"""))
    def parse (context: Context): SpinningEventNameType =
    {
        SpinningEventNameType(
            BasicElement.parse (context),
            EASTERN (context),
            PJM (context),
            RFC_SR (context),
            SOUTH_S (context)
        )
    }
}

case class SpinningEventType
(
    override val sup: BasicElement,
    AA: String,
    CA: String,
    RZ: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SpinningEventType] }
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
        sup.export_fields +
        (if (null != AA) "\t\t<cim:SpinningEventType.AA rdf:resource=\"#" + AA + "\"/>\n" else "") +
        (if (null != CA) "\t\t<cim:SpinningEventType.CA rdf:resource=\"#" + CA + "\"/>\n" else "") +
        (if (null != RZ) "\t\t<cim:SpinningEventType.RZ rdf:resource=\"#" + RZ + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SpinningEventType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SpinningEventType>\n"
    }
}

object SpinningEventType
extends
    Parseable[SpinningEventType]
{
    val AA: (Context) => String = parse_attribute (attribute ("""SpinningEventType.AA"""))
    val CA: (Context) => String = parse_attribute (attribute ("""SpinningEventType.CA"""))
    val RZ: (Context) => String = parse_attribute (attribute ("""SpinningEventType.RZ"""))
    def parse (context: Context): SpinningEventType =
    {
        SpinningEventType(
            BasicElement.parse (context),
            AA (context),
            CA (context),
            RZ (context)
        )
    }
}

case class SystemType
(
    override val sup: BasicElement,
    OASIS: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SystemType] }
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
        sup.export_fields +
        (if (null != OASIS) "\t\t<cim:SystemType.OASIS rdf:resource=\"#" + OASIS + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SystemType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SystemType>\n"
    }
}

object SystemType
extends
    Parseable[SystemType]
{
    val OASIS: (Context) => String = parse_attribute (attribute ("""SystemType.OASIS"""))
    def parse (context: Context): SystemType =
    {
        SystemType(
            BasicElement.parse (context),
            OASIS (context)
        )
    }
}

case class TimeZoneType
(
    override val sup: BasicElement,
    PPT: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TimeZoneType] }
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
        sup.export_fields +
        (if (null != PPT) "\t\t<cim:TimeZoneType.PPT rdf:resource=\"#" + PPT + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TimeZoneType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TimeZoneType>\n"
    }
}

object TimeZoneType
extends
    Parseable[TimeZoneType]
{
    val PPT: (Context) => String = parse_attribute (attribute ("""TimeZoneType.PPT"""))
    def parse (context: Context): TimeZoneType =
    {
        TimeZoneType(
            BasicElement.parse (context),
            PPT (context)
        )
    }
}

case class TradeProductType
(
    override val sup: BasicElement,
    APN: String,
    CAP: String,
    NRT: String,
    PHY: String,
    RDT: String,
    RUT: String,
    SRT: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TradeProductType] }
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
        sup.export_fields +
        (if (null != APN) "\t\t<cim:TradeProductType.APN rdf:resource=\"#" + APN + "\"/>\n" else "") +
        (if (null != CAP) "\t\t<cim:TradeProductType.CAP rdf:resource=\"#" + CAP + "\"/>\n" else "") +
        (if (null != NRT) "\t\t<cim:TradeProductType.NRT rdf:resource=\"#" + NRT + "\"/>\n" else "") +
        (if (null != PHY) "\t\t<cim:TradeProductType.PHY rdf:resource=\"#" + PHY + "\"/>\n" else "") +
        (if (null != RDT) "\t\t<cim:TradeProductType.RDT rdf:resource=\"#" + RDT + "\"/>\n" else "") +
        (if (null != RUT) "\t\t<cim:TradeProductType.RUT rdf:resource=\"#" + RUT + "\"/>\n" else "") +
        (if (null != SRT) "\t\t<cim:TradeProductType.SRT rdf:resource=\"#" + SRT + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TradeProductType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TradeProductType>\n"
    }
}

object TradeProductType
extends
    Parseable[TradeProductType]
{
    val APN: (Context) => String = parse_attribute (attribute ("""TradeProductType.APN"""))
    val CAP: (Context) => String = parse_attribute (attribute ("""TradeProductType.CAP"""))
    val NRT: (Context) => String = parse_attribute (attribute ("""TradeProductType.NRT"""))
    val PHY: (Context) => String = parse_attribute (attribute ("""TradeProductType.PHY"""))
    val RDT: (Context) => String = parse_attribute (attribute ("""TradeProductType.RDT"""))
    val RUT: (Context) => String = parse_attribute (attribute ("""TradeProductType.RUT"""))
    val SRT: (Context) => String = parse_attribute (attribute ("""TradeProductType.SRT"""))
    def parse (context: Context): TradeProductType =
    {
        TradeProductType(
            BasicElement.parse (context),
            APN (context),
            CAP (context),
            NRT (context),
            PHY (context),
            RDT (context),
            RUT (context),
            SRT (context)
        )
    }
}

/**
 * RJ - Rejected Trade
I - Invalid Trade
V - Valid Trade
M - Modified Trade
CV - Conditionally Valid Trade
CM - Conditionally Modified Trade
CI - Conditionally Invalid Trade
CX - Cancelled Trade
O - Obsolete Trade
MT - Matched Trade
 * U - Unmatched Trade
 * @param sup Reference to the superclass object.
 * @param CI <em>undocumented</em>
 * @param CM <em>undocumented</em>
 * @param CV <em>undocumented</em>
 * @param CX <em>undocumented</em>
 * @param I <em>undocumented</em>
 * @param M <em>undocumented</em>
 * @param MT <em>undocumented</em>
 * @param O <em>undocumented</em>
 * @param RJ <em>undocumented</em>
 * @param U <em>undocumented</em>
 * @param V <em>undocumented</em>
 */
case class TradeStatusType
(
    override val sup: BasicElement,
    CI: String,
    CM: String,
    CV: String,
    CX: String,
    I: String,
    M: String,
    MT: String,
    O: String,
    RJ: String,
    U: String,
    V: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TradeStatusType] }
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
        sup.export_fields +
        (if (null != CI) "\t\t<cim:TradeStatusType.CI rdf:resource=\"#" + CI + "\"/>\n" else "") +
        (if (null != CM) "\t\t<cim:TradeStatusType.CM rdf:resource=\"#" + CM + "\"/>\n" else "") +
        (if (null != CV) "\t\t<cim:TradeStatusType.CV rdf:resource=\"#" + CV + "\"/>\n" else "") +
        (if (null != CX) "\t\t<cim:TradeStatusType.CX rdf:resource=\"#" + CX + "\"/>\n" else "") +
        (if (null != I) "\t\t<cim:TradeStatusType.I rdf:resource=\"#" + I + "\"/>\n" else "") +
        (if (null != M) "\t\t<cim:TradeStatusType.M rdf:resource=\"#" + M + "\"/>\n" else "") +
        (if (null != MT) "\t\t<cim:TradeStatusType.MT rdf:resource=\"#" + MT + "\"/>\n" else "") +
        (if (null != O) "\t\t<cim:TradeStatusType.O rdf:resource=\"#" + O + "\"/>\n" else "") +
        (if (null != RJ) "\t\t<cim:TradeStatusType.RJ rdf:resource=\"#" + RJ + "\"/>\n" else "") +
        (if (null != U) "\t\t<cim:TradeStatusType.U rdf:resource=\"#" + U + "\"/>\n" else "") +
        (if (null != V) "\t\t<cim:TradeStatusType.V rdf:resource=\"#" + V + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TradeStatusType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TradeStatusType>\n"
    }
}

object TradeStatusType
extends
    Parseable[TradeStatusType]
{
    val CI: (Context) => String = parse_attribute (attribute ("""TradeStatusType.CI"""))
    val CM: (Context) => String = parse_attribute (attribute ("""TradeStatusType.CM"""))
    val CV: (Context) => String = parse_attribute (attribute ("""TradeStatusType.CV"""))
    val CX: (Context) => String = parse_attribute (attribute ("""TradeStatusType.CX"""))
    val I: (Context) => String = parse_attribute (attribute ("""TradeStatusType.I"""))
    val M: (Context) => String = parse_attribute (attribute ("""TradeStatusType.M"""))
    val MT: (Context) => String = parse_attribute (attribute ("""TradeStatusType.MT"""))
    val O: (Context) => String = parse_attribute (attribute ("""TradeStatusType.O"""))
    val RJ: (Context) => String = parse_attribute (attribute ("""TradeStatusType.RJ"""))
    val U: (Context) => String = parse_attribute (attribute ("""TradeStatusType.U"""))
    val V: (Context) => String = parse_attribute (attribute ("""TradeStatusType.V"""))
    def parse (context: Context): TradeStatusType =
    {
        TradeStatusType(
            BasicElement.parse (context),
            CI (context),
            CM (context),
            CV (context),
            CX (context),
            I (context),
            M (context),
            MT (context),
            O (context),
            RJ (context),
            U (context),
            V (context)
        )
    }
}

case class UOMType
(
    override val sup: BasicElement,
    percent: String,
    $_lb: String,
    $_mmBTU: String,
    FACTOR: String,
    FLAG: String,
    INTEGER: String,
    MW: String,
    MWh: String,
    US$: String,
    US$_MW: String,
    US$_MWh: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[UOMType] }
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
        sup.export_fields +
        (if (null != percent) "\t\t<cim:UOMType.% rdf:resource=\"#" + percent + "\"/>\n" else "") +
        (if (null != $_lb) "\t\t<cim:UOMType.$/lb rdf:resource=\"#" + $_lb + "\"/>\n" else "") +
        (if (null != $_mmBTU) "\t\t<cim:UOMType.$/mmBTU rdf:resource=\"#" + $_mmBTU + "\"/>\n" else "") +
        (if (null != FACTOR) "\t\t<cim:UOMType.FACTOR rdf:resource=\"#" + FACTOR + "\"/>\n" else "") +
        (if (null != FLAG) "\t\t<cim:UOMType.FLAG rdf:resource=\"#" + FLAG + "\"/>\n" else "") +
        (if (null != INTEGER) "\t\t<cim:UOMType.INTEGER rdf:resource=\"#" + INTEGER + "\"/>\n" else "") +
        (if (null != MW) "\t\t<cim:UOMType.MW rdf:resource=\"#" + MW + "\"/>\n" else "") +
        (if (null != MWh) "\t\t<cim:UOMType.MWh rdf:resource=\"#" + MWh + "\"/>\n" else "") +
        (if (null != US$) "\t\t<cim:UOMType.US$ rdf:resource=\"#" + US$ + "\"/>\n" else "") +
        (if (null != US$_MW) "\t\t<cim:UOMType.US$/MW rdf:resource=\"#" + US$_MW + "\"/>\n" else "") +
        (if (null != US$_MWh) "\t\t<cim:UOMType.US$/MWh rdf:resource=\"#" + US$_MWh + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:UOMType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UOMType>\n"
    }
}

object UOMType
extends
    Parseable[UOMType]
{
    val percent: (Context) => String = parse_attribute (attribute ("""UOMType.%"""))
    val $_lb: (Context) => String = parse_attribute (attribute ("""UOMType.$/lb"""))
    val $_mmBTU: (Context) => String = parse_attribute (attribute ("""UOMType.$/mmBTU"""))
    val FACTOR: (Context) => String = parse_attribute (attribute ("""UOMType.FACTOR"""))
    val FLAG: (Context) => String = parse_attribute (attribute ("""UOMType.FLAG"""))
    val INTEGER: (Context) => String = parse_attribute (attribute ("""UOMType.INTEGER"""))
    val MW: (Context) => String = parse_attribute (attribute ("""UOMType.MW"""))
    val MWh: (Context) => String = parse_attribute (attribute ("""UOMType.MWh"""))
    val US$: (Context) => String = parse_attribute (attribute ("""UOMType.US$"""))
    val US$_MW: (Context) => String = parse_attribute (attribute ("""UOMType.US$/MW"""))
    val US$_MWh: (Context) => String = parse_attribute (attribute ("""UOMType.US$/MWh"""))
    def parse (context: Context): UOMType =
    {
        UOMType(
            BasicElement.parse (context),
            percent (context),
            $_lb (context),
            $_mmBTU (context),
            FACTOR (context),
            FLAG (context),
            INTEGER (context),
            MW (context),
            MWh (context),
            US$ (context),
            US$_MW (context),
            US$_MWh (context)
        )
    }
}

/**
 * MW
 * FLAG
 * @param sup Reference to the superclass object.
 * @param FLAG <em>undocumented</em>
 * @param MW <em>undocumented</em>
 */
case class UnitTypeEMS
(
    override val sup: BasicElement,
    FLAG: String,
    MW: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[UnitTypeEMS] }
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
        sup.export_fields +
        (if (null != FLAG) "\t\t<cim:UnitTypeEMS.FLAG rdf:resource=\"#" + FLAG + "\"/>\n" else "") +
        (if (null != MW) "\t\t<cim:UnitTypeEMS.MW rdf:resource=\"#" + MW + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:UnitTypeEMS rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UnitTypeEMS>\n"
    }
}

object UnitTypeEMS
extends
    Parseable[UnitTypeEMS]
{
    val FLAG: (Context) => String = parse_attribute (attribute ("""UnitTypeEMS.FLAG"""))
    val MW: (Context) => String = parse_attribute (attribute ("""UnitTypeEMS.MW"""))
    def parse (context: Context): UnitTypeEMS =
    {
        UnitTypeEMS(
            BasicElement.parse (context),
            FLAG (context),
            MW (context)
        )
    }
}

/**
 * zone type
 * @param sup Reference to the superclass object.
 * @param ASREGION ancillary service region
 * @param DCA designated congestion area
 * @param LOADZONE load zone
 * @param RUCZONE RUC zone
 * @param TRADINGHUB trading hub
 */
case class ZoneType
(
    override val sup: BasicElement,
    ASREGION: String,
    DCA: String,
    LOADZONE: String,
    RUCZONE: String,
    TRADINGHUB: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ZoneType] }
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
        sup.export_fields +
        (if (null != ASREGION) "\t\t<cim:ZoneType.ASREGION rdf:resource=\"#" + ASREGION + "\"/>\n" else "") +
        (if (null != DCA) "\t\t<cim:ZoneType.DCA rdf:resource=\"#" + DCA + "\"/>\n" else "") +
        (if (null != LOADZONE) "\t\t<cim:ZoneType.LOADZONE rdf:resource=\"#" + LOADZONE + "\"/>\n" else "") +
        (if (null != RUCZONE) "\t\t<cim:ZoneType.RUCZONE rdf:resource=\"#" + RUCZONE + "\"/>\n" else "") +
        (if (null != TRADINGHUB) "\t\t<cim:ZoneType.TRADINGHUB rdf:resource=\"#" + TRADINGHUB + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ZoneType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ZoneType>\n"
    }
}

object ZoneType
extends
    Parseable[ZoneType]
{
    val ASREGION: (Context) => String = parse_attribute (attribute ("""ZoneType.ASREGION"""))
    val DCA: (Context) => String = parse_attribute (attribute ("""ZoneType.DCA"""))
    val LOADZONE: (Context) => String = parse_attribute (attribute ("""ZoneType.LOADZONE"""))
    val RUCZONE: (Context) => String = parse_attribute (attribute ("""ZoneType.RUCZONE"""))
    val TRADINGHUB: (Context) => String = parse_attribute (attribute ("""ZoneType.TRADINGHUB"""))
    def parse (context: Context): ZoneType =
    {
        ZoneType(
            BasicElement.parse (context),
            ASREGION (context),
            DCA (context),
            LOADZONE (context),
            RUCZONE (context),
            TRADINGHUB (context)
        )
    }
}

/**
 * S - Scheduling
 * P - Pricing
 * @param sup Reference to the superclass object.
 * @param P <em>undocumented</em>
 * @param S <em>undocumented</em>
 */
case class runTypeCAISO
(
    override val sup: BasicElement,
    P: String,
    S: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[runTypeCAISO] }
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
        sup.export_fields +
        (if (null != P) "\t\t<cim:runTypeCAISO.P rdf:resource=\"#" + P + "\"/>\n" else "") +
        (if (null != S) "\t\t<cim:runTypeCAISO.S rdf:resource=\"#" + S + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:runTypeCAISO rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:runTypeCAISO>\n"
    }
}

object runTypeCAISO
extends
    Parseable[runTypeCAISO]
{
    val P: (Context) => String = parse_attribute (attribute ("""runTypeCAISO.P"""))
    val S: (Context) => String = parse_attribute (attribute ("""runTypeCAISO.S"""))
    def parse (context: Context): runTypeCAISO =
    {
        runTypeCAISO(
            BasicElement.parse (context),
            P (context),
            S (context)
        )
    }
}

private[ninecode] object _InfDomain
{
    def register: List[ClassInfo] =
    {
        List (
            ADSInstructionTypeCommitment.register,
            ADSInstructionTypeOOS.register,
            AdderType.register,
            AlarmDisplayType.register,
            AllocationEnergyTypeCode.register,
            AncillaryCommodityType.register,
            BidPriceCapType.register,
            BidStatusType.register,
            CleanTradeProductType.register,
            CurrentStatusSC.register,
            DAMMarketType.register,
            DispatchAcceptStatus.register,
            DispatchTransactionType.register,
            EnergyTypeCode.register,
            JobFlagType.register,
            JobScheduleType.register,
            JobStartEndType.register,
            LFCResourceType.register,
            LoadFollowingCapacityType.register,
            MQSDELType.register,
            MarketProductTypeAsReq.register,
            MarketScheduleServices.register,
            MarketStatementDescription.register,
            MarketStatementDocStatus.register,
            MarketStatementDocType.register,
            MarketStatementLineItemAliasName.register,
            MeasurementTypeEMS.register,
            MktSubClassType.register,
            OASISBidReportType.register,
            OASISDataItems.register,
            OASISErrCode.register,
            OASISErrDescription.register,
            OASISIntervalType.register,
            OASISMarketType.register,
            OASISMasterType.register,
            OASISMeasType.register,
            OASISReportType.register,
            OASISStatusType.register,
            OrganisationCode.register,
            OrganisationType.register,
            PriceSetFlag.register,
            RequestorRmrTest.register,
            ResourceCertificationCategory.register,
            ResourceCertificationType.register,
            SchedClassType.register,
            SegmentCurveType.register,
            SelfSchedTypeCleanBid.register,
            SelfSchedTypeRawBid.register,
            SelfScheduleType.register,
            SelfScheduleTypeMB.register,
            SourceSinkFlag.register,
            SourceSinkType.register,
            SpinningEventNameType.register,
            SpinningEventType.register,
            SystemType.register,
            TimeZoneType.register,
            TradeProductType.register,
            TradeStatusType.register,
            UOMType.register,
            UnitTypeEMS.register,
            ZoneType.register,
            runTypeCAISO.register
        )
    }
}