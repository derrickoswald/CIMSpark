package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class ADSInstructionTypeCommitment
(
    override val sup: BasicElement = null,
    SHUT_DOWN: String = null,
    START_UP: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[ADSInstructionTypeCommitment] }
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
        implicit val clz: String = ADSInstructionTypeCommitment.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ADSInstructionTypeCommitment.fields (position), value)
        emitattr (0, SHUT_DOWN)
        emitattr (1, START_UP)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ADSInstructionTypeCommitment rdf:ID=\"%s\">\n%s\t</cim:ADSInstructionTypeCommitment>".format (id, export_fields)
    }
}

object ADSInstructionTypeCommitment
extends
    Parseable[ADSInstructionTypeCommitment]
{
    override val fields: Array[String] = Array[String] (
        "SHUT_DOWN",
        "START_UP"
    )
    val SHUT_DOWN: Fielder = parse_attribute (attribute (cls, fields(0)))
    val START_UP: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ADSInstructionTypeCommitment =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ADSInstructionTypeCommitment (
            BasicElement.parse (context),
            mask (SHUT_DOWN (), 0),
            mask (START_UP (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * MIN_CONSTRAINT
 * MAX_CONSTRAINT
 *
 * FIXED_CONSTRAINT
 *
 * @param sup Reference to the superclass object.
 * @param FIXED_CONSTRAINT <em>undocumented</em>
 * @param MAX_CONSTRAINT <em>undocumented</em>
 * @param MIN_CONSTRAINT <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class ADSInstructionTypeOOS
(
    override val sup: BasicElement = null,
    FIXED_CONSTRAINT: String = null,
    MAX_CONSTRAINT: String = null,
    MIN_CONSTRAINT: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[ADSInstructionTypeOOS] }
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
        implicit val clz: String = ADSInstructionTypeOOS.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ADSInstructionTypeOOS.fields (position), value)
        emitattr (0, FIXED_CONSTRAINT)
        emitattr (1, MAX_CONSTRAINT)
        emitattr (2, MIN_CONSTRAINT)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ADSInstructionTypeOOS rdf:ID=\"%s\">\n%s\t</cim:ADSInstructionTypeOOS>".format (id, export_fields)
    }
}

object ADSInstructionTypeOOS
extends
    Parseable[ADSInstructionTypeOOS]
{
    override val fields: Array[String] = Array[String] (
        "FIXED_CONSTRAINT",
        "MAX_CONSTRAINT",
        "MIN_CONSTRAINT"
    )
    val FIXED_CONSTRAINT: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MAX_CONSTRAINT: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MIN_CONSTRAINT: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ADSInstructionTypeOOS =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ADSInstructionTypeOOS (
            BasicElement.parse (context),
            mask (FIXED_CONSTRAINT (), 0),
            mask (MAX_CONSTRAINT (), 1),
            mask (MIN_CONSTRAINT (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * BASELI NE
 *
 * NEGOTIATED
 *
 * @param sup Reference to the superclass object.
 * @param BASELINE <em>undocumented</em>
 * @param NEGOTIATED <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class AdderType
(
    override val sup: BasicElement = null,
    BASELINE: String = null,
    NEGOTIATED: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[AdderType] }
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
        implicit val clz: String = AdderType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AdderType.fields (position), value)
        emitattr (0, BASELINE)
        emitattr (1, NEGOTIATED)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AdderType rdf:ID=\"%s\">\n%s\t</cim:AdderType>".format (id, export_fields)
    }
}

object AdderType
extends
    Parseable[AdderType]
{
    override val fields: Array[String] = Array[String] (
        "BASELINE",
        "NEGOTIATED"
    )
    val BASELINE: Fielder = parse_attribute (attribute (cls, fields(0)))
    val NEGOTIATED: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): AdderType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AdderType (
            BasicElement.parse (context),
            mask (BASELINE (), 0),
            mask (NEGOTIATED (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class AlarmDisplayType
(
    override val sup: BasicElement = null,
    Appear: String = null,
    Disappear: String = null,
    Fleeting: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[AlarmDisplayType] }
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
        implicit val clz: String = AlarmDisplayType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AlarmDisplayType.fields (position), value)
        emitattr (0, Appear)
        emitattr (1, Disappear)
        emitattr (2, Fleeting)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AlarmDisplayType rdf:ID=\"%s\">\n%s\t</cim:AlarmDisplayType>".format (id, export_fields)
    }
}

object AlarmDisplayType
extends
    Parseable[AlarmDisplayType]
{
    override val fields: Array[String] = Array[String] (
        "Appear",
        "Disappear",
        "Fleeting"
    )
    val Appear: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Disappear: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Fleeting: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): AlarmDisplayType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AlarmDisplayType (
            BasicElement.parse (context),
            mask (Appear (), 0),
            mask (Disappear (), 1),
            mask (Fleeting (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class AllocationEnergyTypeCode
(
    override val sup: BasicElement = null,
    ACNG: String = null,
    BS: String = null,
    DAPE: String = null,
    DASE: String = null,
    ESRT: String = null,
    ESYS: String = null,
    ETC: String = null,
    HASE: String = null,
    LMPM: String = null,
    MINL: String = null,
    MLE: String = null,
    MSSLFE: String = null,
    OE: String = null,
    OTHER: String = null,
    OVGN: String = null,
    PE: String = null,
    RCNG: String = null,
    RE: String = null,
    RED: String = null,
    RMRD: String = null,
    RMRH: String = null,
    RMRR: String = null,
    RMRS: String = null,
    RMRT: String = null,
    RSYS: String = null,
    RTSSE: String = null,
    SDWN: String = null,
    SE: String = null,
    SLIC: String = null,
    SRE: String = null,
    STRT: String = null,
    SUMR: String = null,
    TCNG: String = null,
    TEST: String = null,
    TOR: String = null,
    VS: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[AllocationEnergyTypeCode] }
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
        implicit val clz: String = AllocationEnergyTypeCode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AllocationEnergyTypeCode.fields (position), value)
        emitattr (0, ACNG)
        emitattr (1, BS)
        emitattr (2, DAPE)
        emitattr (3, DASE)
        emitattr (4, ESRT)
        emitattr (5, ESYS)
        emitattr (6, ETC)
        emitattr (7, HASE)
        emitattr (8, LMPM)
        emitattr (9, MINL)
        emitattr (10, MLE)
        emitattr (11, MSSLFE)
        emitattr (12, OE)
        emitattr (13, OTHER)
        emitattr (14, OVGN)
        emitattr (15, PE)
        emitattr (16, RCNG)
        emitattr (17, RE)
        emitattr (18, RED)
        emitattr (19, RMRD)
        emitattr (20, RMRH)
        emitattr (21, RMRR)
        emitattr (22, RMRS)
        emitattr (23, RMRT)
        emitattr (24, RSYS)
        emitattr (25, RTSSE)
        emitattr (26, SDWN)
        emitattr (27, SE)
        emitattr (28, SLIC)
        emitattr (29, SRE)
        emitattr (30, STRT)
        emitattr (31, SUMR)
        emitattr (32, TCNG)
        emitattr (33, TEST)
        emitattr (34, TOR)
        emitattr (35, VS)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AllocationEnergyTypeCode rdf:ID=\"%s\">\n%s\t</cim:AllocationEnergyTypeCode>".format (id, export_fields)
    }
}

object AllocationEnergyTypeCode
extends
    Parseable[AllocationEnergyTypeCode]
{
    override val fields: Array[String] = Array[String] (
        "ACNG",
        "BS",
        "DAPE",
        "DASE",
        "ESRT",
        "ESYS",
        "ETC",
        "HASE",
        "LMPM",
        "MINL",
        "MLE",
        "MSSLFE",
        "OE",
        "OTHER",
        "OVGN",
        "PE",
        "RCNG",
        "RE",
        "RED",
        "RMRD",
        "RMRH",
        "RMRR",
        "RMRS",
        "RMRT",
        "RSYS",
        "RTSSE",
        "SDWN",
        "SE",
        "SLIC",
        "SRE",
        "STRT",
        "SUMR",
        "TCNG",
        "TEST",
        "TOR",
        "VS"
    )
    val ACNG: Fielder = parse_attribute (attribute (cls, fields(0)))
    val BS: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DAPE: Fielder = parse_attribute (attribute (cls, fields(2)))
    val DASE: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ESRT: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ESYS: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ETC: Fielder = parse_attribute (attribute (cls, fields(6)))
    val HASE: Fielder = parse_attribute (attribute (cls, fields(7)))
    val LMPM: Fielder = parse_attribute (attribute (cls, fields(8)))
    val MINL: Fielder = parse_attribute (attribute (cls, fields(9)))
    val MLE: Fielder = parse_attribute (attribute (cls, fields(10)))
    val MSSLFE: Fielder = parse_attribute (attribute (cls, fields(11)))
    val OE: Fielder = parse_attribute (attribute (cls, fields(12)))
    val OTHER: Fielder = parse_attribute (attribute (cls, fields(13)))
    val OVGN: Fielder = parse_attribute (attribute (cls, fields(14)))
    val PE: Fielder = parse_attribute (attribute (cls, fields(15)))
    val RCNG: Fielder = parse_attribute (attribute (cls, fields(16)))
    val RE: Fielder = parse_attribute (attribute (cls, fields(17)))
    val RED: Fielder = parse_attribute (attribute (cls, fields(18)))
    val RMRD: Fielder = parse_attribute (attribute (cls, fields(19)))
    val RMRH: Fielder = parse_attribute (attribute (cls, fields(20)))
    val RMRR: Fielder = parse_attribute (attribute (cls, fields(21)))
    val RMRS: Fielder = parse_attribute (attribute (cls, fields(22)))
    val RMRT: Fielder = parse_attribute (attribute (cls, fields(23)))
    val RSYS: Fielder = parse_attribute (attribute (cls, fields(24)))
    val RTSSE: Fielder = parse_attribute (attribute (cls, fields(25)))
    val SDWN: Fielder = parse_attribute (attribute (cls, fields(26)))
    val SE: Fielder = parse_attribute (attribute (cls, fields(27)))
    val SLIC: Fielder = parse_attribute (attribute (cls, fields(28)))
    val SRE: Fielder = parse_attribute (attribute (cls, fields(29)))
    val STRT: Fielder = parse_attribute (attribute (cls, fields(30)))
    val SUMR: Fielder = parse_attribute (attribute (cls, fields(31)))
    val TCNG: Fielder = parse_attribute (attribute (cls, fields(32)))
    val TEST: Fielder = parse_attribute (attribute (cls, fields(33)))
    val TOR: Fielder = parse_attribute (attribute (cls, fields(34)))
    val VS: Fielder = parse_attribute (attribute (cls, fields(35)))

    def parse (context: Context): AllocationEnergyTypeCode =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = AllocationEnergyTypeCode (
            BasicElement.parse (context),
            mask (ACNG (), 0),
            mask (BS (), 1),
            mask (DAPE (), 2),
            mask (DASE (), 3),
            mask (ESRT (), 4),
            mask (ESYS (), 5),
            mask (ETC (), 6),
            mask (HASE (), 7),
            mask (LMPM (), 8),
            mask (MINL (), 9),
            mask (MLE (), 10),
            mask (MSSLFE (), 11),
            mask (OE (), 12),
            mask (OTHER (), 13),
            mask (OVGN (), 14),
            mask (PE (), 15),
            mask (RCNG (), 16),
            mask (RE (), 17),
            mask (RED (), 18),
            mask (RMRD (), 19),
            mask (RMRH (), 20),
            mask (RMRR (), 21),
            mask (RMRS (), 22),
            mask (RMRT (), 23),
            mask (RSYS (), 24),
            mask (RTSSE (), 25),
            mask (SDWN (), 26),
            mask (SE (), 27),
            mask (SLIC (), 28),
            mask (SRE (), 29),
            mask (STRT (), 30),
            mask (SUMR (), 31),
            mask (TCNG (), 32),
            mask (TEST (), 33),
            mask (TOR (), 34),
            mask (VS (), 35)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * ancillary serivce types
 *
 * @param sup Reference to the superclass object.
 * @param NONSPIN non spinning reserve
 * @param REGDN regulation down
 * @param REGUP regulation up
 * @param SPIN spinning reserve
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class AncillaryCommodityType
(
    override val sup: BasicElement = null,
    NONSPIN: String = null,
    REGDN: String = null,
    REGUP: String = null,
    SPIN: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[AncillaryCommodityType] }
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
        implicit val clz: String = AncillaryCommodityType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AncillaryCommodityType.fields (position), value)
        emitattr (0, NONSPIN)
        emitattr (1, REGDN)
        emitattr (2, REGUP)
        emitattr (3, SPIN)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AncillaryCommodityType rdf:ID=\"%s\">\n%s\t</cim:AncillaryCommodityType>".format (id, export_fields)
    }
}

object AncillaryCommodityType
extends
    Parseable[AncillaryCommodityType]
{
    override val fields: Array[String] = Array[String] (
        "NONSPIN",
        "REGDN",
        "REGUP",
        "SPIN"
    )
    val NONSPIN: Fielder = parse_attribute (attribute (cls, fields(0)))
    val REGDN: Fielder = parse_attribute (attribute (cls, fields(1)))
    val REGUP: Fielder = parse_attribute (attribute (cls, fields(2)))
    val SPIN: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): AncillaryCommodityType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AncillaryCommodityType (
            BasicElement.parse (context),
            mask (NONSPIN (), 0),
            mask (REGDN (), 1),
            mask (REGUP (), 2),
            mask (SPIN (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class BidPriceCapType
(
    override val sup: BasicElement = null,
    AS: String = null,
    ENERGY: String = null,
    RUC: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[BidPriceCapType] }
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
        implicit val clz: String = BidPriceCapType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BidPriceCapType.fields (position), value)
        emitattr (0, AS)
        emitattr (1, ENERGY)
        emitattr (2, RUC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BidPriceCapType rdf:ID=\"%s\">\n%s\t</cim:BidPriceCapType>".format (id, export_fields)
    }
}

object BidPriceCapType
extends
    Parseable[BidPriceCapType]
{
    override val fields: Array[String] = Array[String] (
        "AS",
        "ENERGY",
        "RUC"
    )
    val AS: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ENERGY: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RUC: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): BidPriceCapType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BidPriceCapType (
            BasicElement.parse (context),
            mask (AS (), 0),
            mask (ENERGY (), 1),
            mask (RUC (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class CleanTradeProductType
(
    override val sup: BasicElement = null,
    APN: String = null,
    CPT: String = null,
    NRT: String = null,
    PHY: String = null,
    RDT: String = null,
    RUT: String = null,
    SRT: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[CleanTradeProductType] }
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
        implicit val clz: String = CleanTradeProductType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CleanTradeProductType.fields (position), value)
        emitattr (0, APN)
        emitattr (1, CPT)
        emitattr (2, NRT)
        emitattr (3, PHY)
        emitattr (4, RDT)
        emitattr (5, RUT)
        emitattr (6, SRT)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CleanTradeProductType rdf:ID=\"%s\">\n%s\t</cim:CleanTradeProductType>".format (id, export_fields)
    }
}

object CleanTradeProductType
extends
    Parseable[CleanTradeProductType]
{
    override val fields: Array[String] = Array[String] (
        "APN",
        "CPT",
        "NRT",
        "PHY",
        "RDT",
        "RUT",
        "SRT"
    )
    val APN: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CPT: Fielder = parse_attribute (attribute (cls, fields(1)))
    val NRT: Fielder = parse_attribute (attribute (cls, fields(2)))
    val PHY: Fielder = parse_attribute (attribute (cls, fields(3)))
    val RDT: Fielder = parse_attribute (attribute (cls, fields(4)))
    val RUT: Fielder = parse_attribute (attribute (cls, fields(5)))
    val SRT: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): CleanTradeProductType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CleanTradeProductType (
            BasicElement.parse (context),
            mask (APN (), 0),
            mask (CPT (), 1),
            mask (NRT (), 2),
            mask (PHY (), 3),
            mask (RDT (), 4),
            mask (RUT (), 5),
            mask (SRT (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * ACTIVE
 *
 * INACTIVE
 *
 * @param sup Reference to the superclass object.
 * @param ACTIVE <em>undocumented</em>
 * @param INACTIVE <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class CurrentStatusSC
(
    override val sup: BasicElement = null,
    ACTIVE: String = null,
    INACTIVE: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[CurrentStatusSC] }
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
        implicit val clz: String = CurrentStatusSC.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CurrentStatusSC.fields (position), value)
        emitattr (0, ACTIVE)
        emitattr (1, INACTIVE)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CurrentStatusSC rdf:ID=\"%s\">\n%s\t</cim:CurrentStatusSC>".format (id, export_fields)
    }
}

object CurrentStatusSC
extends
    Parseable[CurrentStatusSC]
{
    override val fields: Array[String] = Array[String] (
        "ACTIVE",
        "INACTIVE"
    )
    val ACTIVE: Fielder = parse_attribute (attribute (cls, fields(0)))
    val INACTIVE: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): CurrentStatusSC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CurrentStatusSC (
            BasicElement.parse (context),
            mask (ACTIVE (), 0),
            mask (INACTIVE (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class DAMMarketType
(
    override val sup: BasicElement = null,
    DAM: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[DAMMarketType] }
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
        implicit val clz: String = DAMMarketType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DAMMarketType.fields (position), value)
        emitattr (0, DAM)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DAMMarketType rdf:ID=\"%s\">\n%s\t</cim:DAMMarketType>".format (id, export_fields)
    }
}

object DAMMarketType
extends
    Parseable[DAMMarketType]
{
    override val fields: Array[String] = Array[String] (
        "DAM"
    )
    val DAM: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): DAMMarketType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DAMMarketType (
            BasicElement.parse (context),
            mask (DAM (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class DispatchAcceptStatus
(
    override val sup: BasicElement = null,
    ACCEPT: String = null,
    CANNOT: String = null,
    DECLINE: String = null,
    NON_RESPONSE: String = null,
    OK: String = null,
    PARTIAL: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[DispatchAcceptStatus] }
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
        implicit val clz: String = DispatchAcceptStatus.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DispatchAcceptStatus.fields (position), value)
        emitattr (0, ACCEPT)
        emitattr (1, CANNOT)
        emitattr (2, DECLINE)
        emitattr (3, NON_RESPONSE)
        emitattr (4, OK)
        emitattr (5, PARTIAL)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DispatchAcceptStatus rdf:ID=\"%s\">\n%s\t</cim:DispatchAcceptStatus>".format (id, export_fields)
    }
}

object DispatchAcceptStatus
extends
    Parseable[DispatchAcceptStatus]
{
    override val fields: Array[String] = Array[String] (
        "ACCEPT",
        "CANNOT",
        "DECLINE",
        "NON_RESPONSE",
        "OK",
        "PARTIAL"
    )
    val ACCEPT: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CANNOT: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DECLINE: Fielder = parse_attribute (attribute (cls, fields(2)))
    val NON_RESPONSE: Fielder = parse_attribute (attribute (cls, fields(3)))
    val OK: Fielder = parse_attribute (attribute (cls, fields(4)))
    val PARTIAL: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): DispatchAcceptStatus =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DispatchAcceptStatus (
            BasicElement.parse (context),
            mask (ACCEPT (), 0),
            mask (CANNOT (), 1),
            mask (DECLINE (), 2),
            mask (NON_RESPONSE (), 3),
            mask (OK (), 4),
            mask (PARTIAL (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class DispatchTransactionType
(
    override val sup: BasicElement = null,
    Purchase: String = null,
    Sale: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[DispatchTransactionType] }
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
        implicit val clz: String = DispatchTransactionType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DispatchTransactionType.fields (position), value)
        emitattr (0, Purchase)
        emitattr (1, Sale)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DispatchTransactionType rdf:ID=\"%s\">\n%s\t</cim:DispatchTransactionType>".format (id, export_fields)
    }
}

object DispatchTransactionType
extends
    Parseable[DispatchTransactionType]
{
    override val fields: Array[String] = Array[String] (
        "Purchase",
        "Sale"
    )
    val Purchase: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Sale: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): DispatchTransactionType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DispatchTransactionType (
            BasicElement.parse (context),
            mask (Purchase (), 0),
            mask (Sale (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Valid Enumerations:
 * 1) DASE Day Ahead Scheduled Energy;
 * 2) DSSE Day Ahead Incremental Self Schedule Energy;
 * 3) DABE Day Ahead Incremental Energy Bid Awarded Energy;
 * 4) OE Optimal Energy;
 * 5) HASE Hour ahead pre-dispatched schedule energy;
 * 6) SRE Standard Ramping Energy;
 * 7) RED Ramping Energy Deviation;
 * 8) EDE Exceptional Dispatch energy;
 * 9) RMRE RMR Energy;
 * 10) MSSLFE MSSLF Energy;
 * 11) RE Residual Energy;
 * 12) MLE Minimum Load Energy;
 * 13) SE SLIC Energy;
 * 14) RTSSE Real time self scheduled energy;
 * 15) DMLE Day ahead minimum load energy;
 * 16) PE Pumping Energy;
 * 17) TEE Total Expected Energy;
 *
 * 18) DAPE - Day-Ahead Pumping Energy;
 *
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
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class EnergyTypeCode
(
    override val sup: BasicElement = null,
    DABE: String = null,
    DAPE: String = null,
    DASE: String = null,
    DMLE: String = null,
    DSSE: String = null,
    EDE: String = null,
    HASE: String = null,
    MLE: String = null,
    MSSLFE: String = null,
    OE: String = null,
    PE: String = null,
    RE: String = null,
    RED: String = null,
    RMRE: String = null,
    RTSSE: String = null,
    SE: String = null,
    SRE: String = null,
    TEE: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[EnergyTypeCode] }
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
        implicit val clz: String = EnergyTypeCode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyTypeCode.fields (position), value)
        emitattr (0, DABE)
        emitattr (1, DAPE)
        emitattr (2, DASE)
        emitattr (3, DMLE)
        emitattr (4, DSSE)
        emitattr (5, EDE)
        emitattr (6, HASE)
        emitattr (7, MLE)
        emitattr (8, MSSLFE)
        emitattr (9, OE)
        emitattr (10, PE)
        emitattr (11, RE)
        emitattr (12, RED)
        emitattr (13, RMRE)
        emitattr (14, RTSSE)
        emitattr (15, SE)
        emitattr (16, SRE)
        emitattr (17, TEE)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergyTypeCode rdf:ID=\"%s\">\n%s\t</cim:EnergyTypeCode>".format (id, export_fields)
    }
}

object EnergyTypeCode
extends
    Parseable[EnergyTypeCode]
{
    override val fields: Array[String] = Array[String] (
        "DABE",
        "DAPE",
        "DASE",
        "DMLE",
        "DSSE",
        "EDE",
        "HASE",
        "MLE",
        "MSSLFE",
        "OE",
        "PE",
        "RE",
        "RED",
        "RMRE",
        "RTSSE",
        "SE",
        "SRE",
        "TEE"
    )
    val DABE: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DAPE: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DASE: Fielder = parse_attribute (attribute (cls, fields(2)))
    val DMLE: Fielder = parse_attribute (attribute (cls, fields(3)))
    val DSSE: Fielder = parse_attribute (attribute (cls, fields(4)))
    val EDE: Fielder = parse_attribute (attribute (cls, fields(5)))
    val HASE: Fielder = parse_attribute (attribute (cls, fields(6)))
    val MLE: Fielder = parse_attribute (attribute (cls, fields(7)))
    val MSSLFE: Fielder = parse_attribute (attribute (cls, fields(8)))
    val OE: Fielder = parse_attribute (attribute (cls, fields(9)))
    val PE: Fielder = parse_attribute (attribute (cls, fields(10)))
    val RE: Fielder = parse_attribute (attribute (cls, fields(11)))
    val RED: Fielder = parse_attribute (attribute (cls, fields(12)))
    val RMRE: Fielder = parse_attribute (attribute (cls, fields(13)))
    val RTSSE: Fielder = parse_attribute (attribute (cls, fields(14)))
    val SE: Fielder = parse_attribute (attribute (cls, fields(15)))
    val SRE: Fielder = parse_attribute (attribute (cls, fields(16)))
    val TEE: Fielder = parse_attribute (attribute (cls, fields(17)))

    def parse (context: Context): EnergyTypeCode =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnergyTypeCode (
            BasicElement.parse (context),
            mask (DABE (), 0),
            mask (DAPE (), 1),
            mask (DASE (), 2),
            mask (DMLE (), 3),
            mask (DSSE (), 4),
            mask (EDE (), 5),
            mask (HASE (), 6),
            mask (MLE (), 7),
            mask (MSSLFE (), 8),
            mask (OE (), 9),
            mask (PE (), 10),
            mask (RE (), 11),
            mask (RED (), 12),
            mask (RMRE (), 13),
            mask (RTSSE (), 14),
            mask (SE (), 15),
            mask (SRE (), 16),
            mask (TEE (), 17)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class JobFlagType
(
    override val sup: BasicElement = null,
    CREATED: String = null,
    DELETED: String = null,
    MODIFIED: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[JobFlagType] }
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
        implicit val clz: String = JobFlagType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (JobFlagType.fields (position), value)
        emitattr (0, CREATED)
        emitattr (1, DELETED)
        emitattr (2, MODIFIED)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:JobFlagType rdf:ID=\"%s\">\n%s\t</cim:JobFlagType>".format (id, export_fields)
    }
}

object JobFlagType
extends
    Parseable[JobFlagType]
{
    override val fields: Array[String] = Array[String] (
        "CREATED",
        "DELETED",
        "MODIFIED"
    )
    val CREATED: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DELETED: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MODIFIED: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): JobFlagType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = JobFlagType (
            BasicElement.parse (context),
            mask (CREATED (), 0),
            mask (DELETED (), 1),
            mask (MODIFIED (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class JobScheduleType
(
    override val sup: BasicElement = null,
    CRITICAL: String = null,
    NONCRITICAL: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[JobScheduleType] }
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
        implicit val clz: String = JobScheduleType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (JobScheduleType.fields (position), value)
        emitattr (0, CRITICAL)
        emitattr (1, NONCRITICAL)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:JobScheduleType rdf:ID=\"%s\">\n%s\t</cim:JobScheduleType>".format (id, export_fields)
    }
}

object JobScheduleType
extends
    Parseable[JobScheduleType]
{
    override val fields: Array[String] = Array[String] (
        "CRITICAL",
        "NONCRITICAL"
    )
    val CRITICAL: Fielder = parse_attribute (attribute (cls, fields(0)))
    val NONCRITICAL: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): JobScheduleType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = JobScheduleType (
            BasicElement.parse (context),
            mask (CRITICAL (), 0),
            mask (NONCRITICAL (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class JobStartEndType
(
    override val sup: BasicElement = null,
    END: String = null,
    NA: String = null,
    START: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[JobStartEndType] }
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
        implicit val clz: String = JobStartEndType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (JobStartEndType.fields (position), value)
        emitattr (0, END)
        emitattr (1, NA)
        emitattr (2, START)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:JobStartEndType rdf:ID=\"%s\">\n%s\t</cim:JobStartEndType>".format (id, export_fields)
    }
}

object JobStartEndType
extends
    Parseable[JobStartEndType]
{
    override val fields: Array[String] = Array[String] (
        "END",
        "NA",
        "START"
    )
    val END: Fielder = parse_attribute (attribute (cls, fields(0)))
    val NA: Fielder = parse_attribute (attribute (cls, fields(1)))
    val START: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): JobStartEndType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = JobStartEndType (
            BasicElement.parse (context),
            mask (END (), 0),
            mask (NA (), 1),
            mask (START (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class LFCResourceType
(
    override val sup: BasicElement = null,
    GEN: String = null,
    PUMP: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[LFCResourceType] }
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
        implicit val clz: String = LFCResourceType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LFCResourceType.fields (position), value)
        emitattr (0, GEN)
        emitattr (1, PUMP)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LFCResourceType rdf:ID=\"%s\">\n%s\t</cim:LFCResourceType>".format (id, export_fields)
    }
}

object LFCResourceType
extends
    Parseable[LFCResourceType]
{
    override val fields: Array[String] = Array[String] (
        "GEN",
        "PUMP"
    )
    val GEN: Fielder = parse_attribute (attribute (cls, fields(0)))
    val PUMP: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): LFCResourceType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LFCResourceType (
            BasicElement.parse (context),
            mask (GEN (), 0),
            mask (PUMP (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class LoadFollowingCapacityType
(
    override val sup: BasicElement = null,
    DOWN: String = null,
    UP: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[LoadFollowingCapacityType] }
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
        implicit val clz: String = LoadFollowingCapacityType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LoadFollowingCapacityType.fields (position), value)
        emitattr (0, DOWN)
        emitattr (1, UP)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LoadFollowingCapacityType rdf:ID=\"%s\">\n%s\t</cim:LoadFollowingCapacityType>".format (id, export_fields)
    }
}

object LoadFollowingCapacityType
extends
    Parseable[LoadFollowingCapacityType]
{
    override val fields: Array[String] = Array[String] (
        "DOWN",
        "UP"
    )
    val DOWN: Fielder = parse_attribute (attribute (cls, fields(0)))
    val UP: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): LoadFollowingCapacityType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LoadFollowingCapacityType (
            BasicElement.parse (context),
            mask (DOWN (), 0),
            mask (UP (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * ADD - add
 * DEL - delete
 *
 * CHG - change
 *
 * @param sup Reference to the superclass object.
 * @param ADD <em>undocumented</em>
 * @param CHG <em>undocumented</em>
 * @param DEL <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MQSDELType
(
    override val sup: BasicElement = null,
    ADD: String = null,
    CHG: String = null,
    DEL: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[MQSDELType] }
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
        implicit val clz: String = MQSDELType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MQSDELType.fields (position), value)
        emitattr (0, ADD)
        emitattr (1, CHG)
        emitattr (2, DEL)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MQSDELType rdf:ID=\"%s\">\n%s\t</cim:MQSDELType>".format (id, export_fields)
    }
}

object MQSDELType
extends
    Parseable[MQSDELType]
{
    override val fields: Array[String] = Array[String] (
        "ADD",
        "CHG",
        "DEL"
    )
    val ADD: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CHG: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DEL: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): MQSDELType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MQSDELType (
            BasicElement.parse (context),
            mask (ADD (), 0),
            mask (CHG (), 1),
            mask (DEL (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * RU - Regulation Up
 * RD - Regulation Down
 * SR - Spin Reserve
 * NR - Nonspin Reserve
 *
 * AS - Upward Ancillary Service
 *
 * @param sup Reference to the superclass object.
 * @param AS <em>undocumented</em>
 * @param NR non spinning reserve
 * @param RD regulation down
 * @param RU regulation up
 * @param SR spinning reserve
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MarketProductTypeAsReq
(
    override val sup: BasicElement = null,
    AS: String = null,
    NR: String = null,
    RD: String = null,
    RU: String = null,
    SR: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[MarketProductTypeAsReq] }
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
        implicit val clz: String = MarketProductTypeAsReq.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketProductTypeAsReq.fields (position), value)
        emitattr (0, AS)
        emitattr (1, NR)
        emitattr (2, RD)
        emitattr (3, RU)
        emitattr (4, SR)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketProductTypeAsReq rdf:ID=\"%s\">\n%s\t</cim:MarketProductTypeAsReq>".format (id, export_fields)
    }
}

object MarketProductTypeAsReq
extends
    Parseable[MarketProductTypeAsReq]
{
    override val fields: Array[String] = Array[String] (
        "AS",
        "NR",
        "RD",
        "RU",
        "SR"
    )
    val AS: Fielder = parse_attribute (attribute (cls, fields(0)))
    val NR: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RD: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RU: Fielder = parse_attribute (attribute (cls, fields(3)))
    val SR: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): MarketProductTypeAsReq =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketProductTypeAsReq (
            BasicElement.parse (context),
            mask (AS (), 0),
            mask (NR (), 1),
            mask (RD (), 2),
            mask (RU (), 3),
            mask (SR (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MarketScheduleServices
(
    override val sup: BasicElement = null,
    retrieveDefaultBidCurves: String = null,
    retrieveMPMResults: String = null,
    retrieveMarketAwards: String = null,
    retrieveSchedulePrices: String = null,
    retrieveStartUpShutDownInstructions: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[MarketScheduleServices] }
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
        implicit val clz: String = MarketScheduleServices.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketScheduleServices.fields (position), value)
        emitattr (0, retrieveDefaultBidCurves)
        emitattr (1, retrieveMPMResults)
        emitattr (2, retrieveMarketAwards)
        emitattr (3, retrieveSchedulePrices)
        emitattr (4, retrieveStartUpShutDownInstructions)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketScheduleServices rdf:ID=\"%s\">\n%s\t</cim:MarketScheduleServices>".format (id, export_fields)
    }
}

object MarketScheduleServices
extends
    Parseable[MarketScheduleServices]
{
    override val fields: Array[String] = Array[String] (
        "retrieveDefaultBidCurves",
        "retrieveMPMResults",
        "retrieveMarketAwards",
        "retrieveSchedulePrices",
        "retrieveStartUpShutDownInstructions"
    )
    val retrieveDefaultBidCurves: Fielder = parse_attribute (attribute (cls, fields(0)))
    val retrieveMPMResults: Fielder = parse_attribute (attribute (cls, fields(1)))
    val retrieveMarketAwards: Fielder = parse_attribute (attribute (cls, fields(2)))
    val retrieveSchedulePrices: Fielder = parse_attribute (attribute (cls, fields(3)))
    val retrieveStartUpShutDownInstructions: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): MarketScheduleServices =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketScheduleServices (
            BasicElement.parse (context),
            mask (retrieveDefaultBidCurves (), 0),
            mask (retrieveMPMResults (), 1),
            mask (retrieveMarketAwards (), 2),
            mask (retrieveSchedulePrices (), 3),
            mask (retrieveStartUpShutDownInstructions (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Description of market statement
 *
 * @param sup Reference to the superclass object.
 * @param DAILY_INITIAL_CREDIT <em>undocumented</em>
 * @param DAILY_INITIAL_MARKET <em>undocumented</em>
 * @param DAILY_RECALC_MARKET <em>undocumented</em>
 * @param MONTHLY_INITIAL_MARKET <em>undocumented</em>
 * @param MONTHLY_RECALC_MARKET <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MarketStatementDescription
(
    override val sup: BasicElement = null,
    DAILY_INITIAL_CREDIT: String = null,
    DAILY_INITIAL_MARKET: String = null,
    DAILY_RECALC_MARKET: String = null,
    MONTHLY_INITIAL_MARKET: String = null,
    MONTHLY_RECALC_MARKET: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[MarketStatementDescription] }
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
        implicit val clz: String = MarketStatementDescription.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketStatementDescription.fields (position), value)
        emitattr (0, DAILY_INITIAL_CREDIT)
        emitattr (1, DAILY_INITIAL_MARKET)
        emitattr (2, DAILY_RECALC_MARKET)
        emitattr (3, MONTHLY_INITIAL_MARKET)
        emitattr (4, MONTHLY_RECALC_MARKET)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketStatementDescription rdf:ID=\"%s\">\n%s\t</cim:MarketStatementDescription>".format (id, export_fields)
    }
}

object MarketStatementDescription
extends
    Parseable[MarketStatementDescription]
{
    override val fields: Array[String] = Array[String] (
        "DAILY_INITIAL_CREDIT",
        "DAILY_INITIAL_MARKET",
        "DAILY_RECALC_MARKET",
        "MONTHLY_INITIAL_MARKET",
        "MONTHLY_RECALC_MARKET"
    )
    val DAILY_INITIAL_CREDIT: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DAILY_INITIAL_MARKET: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DAILY_RECALC_MARKET: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MONTHLY_INITIAL_MARKET: Fielder = parse_attribute (attribute (cls, fields(3)))
    val MONTHLY_RECALC_MARKET: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): MarketStatementDescription =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketStatementDescription (
            BasicElement.parse (context),
            mask (DAILY_INITIAL_CREDIT (), 0),
            mask (DAILY_INITIAL_MARKET (), 1),
            mask (DAILY_RECALC_MARKET (), 2),
            mask (MONTHLY_INITIAL_MARKET (), 3),
            mask (MONTHLY_RECALC_MARKET (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * market statement document status
 *
 * @param sup Reference to the superclass object.
 * @param APPROVED <em>undocumented</em>
 * @param CANCELLED <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MarketStatementDocStatus
(
    override val sup: BasicElement = null,
    APPROVED: String = null,
    CANCELLED: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[MarketStatementDocStatus] }
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
        implicit val clz: String = MarketStatementDocStatus.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketStatementDocStatus.fields (position), value)
        emitattr (0, APPROVED)
        emitattr (1, CANCELLED)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketStatementDocStatus rdf:ID=\"%s\">\n%s\t</cim:MarketStatementDocStatus>".format (id, export_fields)
    }
}

object MarketStatementDocStatus
extends
    Parseable[MarketStatementDocStatus]
{
    override val fields: Array[String] = Array[String] (
        "APPROVED",
        "CANCELLED"
    )
    val APPROVED: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CANCELLED: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): MarketStatementDocStatus =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketStatementDocStatus (
            BasicElement.parse (context),
            mask (APPROVED (), 0),
            mask (CANCELLED (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * market statement document type
 *
 * @param sup Reference to the superclass object.
 * @param CREDIT <em>undocumented</em>
 * @param MARKET_INITIAL <em>undocumented</em>
 * @param MARKET_RECALC <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MarketStatementDocType
(
    override val sup: BasicElement = null,
    CREDIT: String = null,
    MARKET_INITIAL: String = null,
    MARKET_RECALC: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[MarketStatementDocType] }
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
        implicit val clz: String = MarketStatementDocType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketStatementDocType.fields (position), value)
        emitattr (0, CREDIT)
        emitattr (1, MARKET_INITIAL)
        emitattr (2, MARKET_RECALC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketStatementDocType rdf:ID=\"%s\">\n%s\t</cim:MarketStatementDocType>".format (id, export_fields)
    }
}

object MarketStatementDocType
extends
    Parseable[MarketStatementDocType]
{
    override val fields: Array[String] = Array[String] (
        "CREDIT",
        "MARKET_INITIAL",
        "MARKET_RECALC"
    )
    val CREDIT: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MARKET_INITIAL: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MARKET_RECALC: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): MarketStatementDocType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketStatementDocType (
            BasicElement.parse (context),
            mask (CREDIT (), 0),
            mask (MARKET_INITIAL (), 1),
            mask (MARKET_RECALC (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * market statement line item alias name
 *
 * @param sup Reference to the superclass object.
 * @param CHARGE_CODE_INTERVAL_DETAIL <em>undocumented</em>
 * @param CHARGE_CODE_INTERVAL_TOTAL <em>undocumented</em>
 * @param CHARGE_CODE_SUMMARY <em>undocumented</em>
 * @param CHARGE_GROUP <em>undocumented</em>
 * @param PARENT_CHARGE_GROUP <em>undocumented</em>
 * @param TRADE_DATE <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MarketStatementLineItemAliasName
(
    override val sup: BasicElement = null,
    CHARGE_CODE_INTERVAL_DETAIL: String = null,
    CHARGE_CODE_INTERVAL_TOTAL: String = null,
    CHARGE_CODE_SUMMARY: String = null,
    CHARGE_GROUP: String = null,
    PARENT_CHARGE_GROUP: String = null,
    TRADE_DATE: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[MarketStatementLineItemAliasName] }
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
        implicit val clz: String = MarketStatementLineItemAliasName.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketStatementLineItemAliasName.fields (position), value)
        emitattr (0, CHARGE_CODE_INTERVAL_DETAIL)
        emitattr (1, CHARGE_CODE_INTERVAL_TOTAL)
        emitattr (2, CHARGE_CODE_SUMMARY)
        emitattr (3, CHARGE_GROUP)
        emitattr (4, PARENT_CHARGE_GROUP)
        emitattr (5, TRADE_DATE)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketStatementLineItemAliasName rdf:ID=\"%s\">\n%s\t</cim:MarketStatementLineItemAliasName>".format (id, export_fields)
    }
}

object MarketStatementLineItemAliasName
extends
    Parseable[MarketStatementLineItemAliasName]
{
    override val fields: Array[String] = Array[String] (
        "CHARGE_CODE_INTERVAL_DETAIL",
        "CHARGE_CODE_INTERVAL_TOTAL",
        "CHARGE_CODE_SUMMARY",
        "CHARGE_GROUP",
        "PARENT_CHARGE_GROUP",
        "TRADE_DATE"
    )
    val CHARGE_CODE_INTERVAL_DETAIL: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CHARGE_CODE_INTERVAL_TOTAL: Fielder = parse_attribute (attribute (cls, fields(1)))
    val CHARGE_CODE_SUMMARY: Fielder = parse_attribute (attribute (cls, fields(2)))
    val CHARGE_GROUP: Fielder = parse_attribute (attribute (cls, fields(3)))
    val PARENT_CHARGE_GROUP: Fielder = parse_attribute (attribute (cls, fields(4)))
    val TRADE_DATE: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): MarketStatementLineItemAliasName =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketStatementLineItemAliasName (
            BasicElement.parse (context),
            mask (CHARGE_CODE_INTERVAL_DETAIL (), 0),
            mask (CHARGE_CODE_INTERVAL_TOTAL (), 1),
            mask (CHARGE_CODE_SUMMARY (), 2),
            mask (CHARGE_GROUP (), 3),
            mask (PARENT_CHARGE_GROUP (), 4),
            mask (TRADE_DATE (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Path Flow - PF
 * Path Inflow Limit - PIL
 * Path Inflow Available Limit - PIAL
 * Path Inflow Armed Limit - PIML
 * Path Outflow Limit - POL
 * Path Outflow Available Limit - POAL
 * Path Outflow Armed Limit - OARL
 * Generation Output - GO
 * Generation Max Operating Limit - GMOL
 * Generation Min Operating Limit - GNOL
 * Generation Regulation - GR
 * Generation Status - GS
 * Pump Production - PP
 * System Load - SL
 * System ACE - ACE
 *
 * System INADV - INADV
 *
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
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MeasurementTypeEMS
(
    override val sup: BasicElement = null,
    ACE: String = null,
    GMOL: String = null,
    GNOL: String = null,
    GO: String = null,
    GR: String = null,
    GS: String = null,
    INADV: String = null,
    OARL: String = null,
    PF: String = null,
    PIAL: String = null,
    PIL: String = null,
    PIML: String = null,
    POAL: String = null,
    POL: String = null,
    PP: String = null,
    SL: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[MeasurementTypeEMS] }
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
        implicit val clz: String = MeasurementTypeEMS.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MeasurementTypeEMS.fields (position), value)
        emitattr (0, ACE)
        emitattr (1, GMOL)
        emitattr (2, GNOL)
        emitattr (3, GO)
        emitattr (4, GR)
        emitattr (5, GS)
        emitattr (6, INADV)
        emitattr (7, OARL)
        emitattr (8, PF)
        emitattr (9, PIAL)
        emitattr (10, PIL)
        emitattr (11, PIML)
        emitattr (12, POAL)
        emitattr (13, POL)
        emitattr (14, PP)
        emitattr (15, SL)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MeasurementTypeEMS rdf:ID=\"%s\">\n%s\t</cim:MeasurementTypeEMS>".format (id, export_fields)
    }
}

object MeasurementTypeEMS
extends
    Parseable[MeasurementTypeEMS]
{
    override val fields: Array[String] = Array[String] (
        "ACE",
        "GMOL",
        "GNOL",
        "GO",
        "GR",
        "GS",
        "INADV",
        "OARL",
        "PF",
        "PIAL",
        "PIL",
        "PIML",
        "POAL",
        "POL",
        "PP",
        "SL"
    )
    val ACE: Fielder = parse_attribute (attribute (cls, fields(0)))
    val GMOL: Fielder = parse_attribute (attribute (cls, fields(1)))
    val GNOL: Fielder = parse_attribute (attribute (cls, fields(2)))
    val GO: Fielder = parse_attribute (attribute (cls, fields(3)))
    val GR: Fielder = parse_attribute (attribute (cls, fields(4)))
    val GS: Fielder = parse_attribute (attribute (cls, fields(5)))
    val INADV: Fielder = parse_attribute (attribute (cls, fields(6)))
    val OARL: Fielder = parse_attribute (attribute (cls, fields(7)))
    val PF: Fielder = parse_attribute (attribute (cls, fields(8)))
    val PIAL: Fielder = parse_attribute (attribute (cls, fields(9)))
    val PIL: Fielder = parse_attribute (attribute (cls, fields(10)))
    val PIML: Fielder = parse_attribute (attribute (cls, fields(11)))
    val POAL: Fielder = parse_attribute (attribute (cls, fields(12)))
    val POL: Fielder = parse_attribute (attribute (cls, fields(13)))
    val PP: Fielder = parse_attribute (attribute (cls, fields(14)))
    val SL: Fielder = parse_attribute (attribute (cls, fields(15)))

    def parse (context: Context): MeasurementTypeEMS =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MeasurementTypeEMS (
            BasicElement.parse (context),
            mask (ACE (), 0),
            mask (GMOL (), 1),
            mask (GNOL (), 2),
            mask (GO (), 3),
            mask (GR (), 4),
            mask (GS (), 5),
            mask (INADV (), 6),
            mask (OARL (), 7),
            mask (PF (), 8),
            mask (PIAL (), 9),
            mask (PIL (), 10),
            mask (PIML (), 11),
            mask (POAL (), 12),
            mask (POL (), 13),
            mask (PP (), 14),
            mask (SL (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MktSubClassType
(
    override val sup: BasicElement = null,
    Branch_Group_Derates: String = null,
    Day_Ahead_Final_Market_Info: String = null,
    Day_Ahead_Forecast_Information: String = null,
    Day_Ahead_Interim_Market_Info: String = null,
    Day_Ahead_RMR: String = null,
    Forecasted_UDC_Direct_Access_Load: String = null,
    Hour_Ahead_Market_Info: String = null,
    Hourly_Expost_Market_Info: String = null,
    Public_Bid_Data: String = null,
    TTC_ATC_Forecast_Information: String = null,
    TTC_ATC_Hourly_Forecast: String = null,
    Ten_Min_Expost_Market_Info: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[MktSubClassType] }
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
        implicit val clz: String = MktSubClassType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktSubClassType.fields (position), value)
        emitattr (0, Branch_Group_Derates)
        emitattr (1, Day_Ahead_Final_Market_Info)
        emitattr (2, Day_Ahead_Forecast_Information)
        emitattr (3, Day_Ahead_Interim_Market_Info)
        emitattr (4, Day_Ahead_RMR)
        emitattr (5, Forecasted_UDC_Direct_Access_Load)
        emitattr (6, Hour_Ahead_Market_Info)
        emitattr (7, Hourly_Expost_Market_Info)
        emitattr (8, Public_Bid_Data)
        emitattr (9, TTC_ATC_Forecast_Information)
        emitattr (10, TTC_ATC_Hourly_Forecast)
        emitattr (11, Ten_Min_Expost_Market_Info)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktSubClassType rdf:ID=\"%s\">\n%s\t</cim:MktSubClassType>".format (id, export_fields)
    }
}

object MktSubClassType
extends
    Parseable[MktSubClassType]
{
    override val fields: Array[String] = Array[String] (
        "Branch_Group_Derates",
        "Day_Ahead_Final_Market_Info",
        "Day_Ahead_Forecast_Information",
        "Day_Ahead_Interim_Market_Info",
        "Day_Ahead_RMR",
        "Forecasted_UDC_Direct_Access_Load",
        "Hour_Ahead_Market_Info",
        "Hourly_Expost_Market_Info",
        "Public_Bid_Data",
        "TTC/ATC_Forecast_Information",
        "TTC/ATC_Hourly_Forecast",
        "Ten_Min_Expost_Market_Info"
    )
    val Branch_Group_Derates: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Day_Ahead_Final_Market_Info: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Day_Ahead_Forecast_Information: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Day_Ahead_Interim_Market_Info: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Day_Ahead_RMR: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Forecasted_UDC_Direct_Access_Load: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Hour_Ahead_Market_Info: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Hourly_Expost_Market_Info: Fielder = parse_attribute (attribute (cls, fields(7)))
    val Public_Bid_Data: Fielder = parse_attribute (attribute (cls, fields(8)))
    val TTC_ATC_Forecast_Information: Fielder = parse_attribute (attribute (cls, fields(9)))
    val TTC_ATC_Hourly_Forecast: Fielder = parse_attribute (attribute (cls, fields(10)))
    val Ten_Min_Expost_Market_Info: Fielder = parse_attribute (attribute (cls, fields(11)))

    def parse (context: Context): MktSubClassType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktSubClassType (
            BasicElement.parse (context),
            mask (Branch_Group_Derates (), 0),
            mask (Day_Ahead_Final_Market_Info (), 1),
            mask (Day_Ahead_Forecast_Information (), 2),
            mask (Day_Ahead_Interim_Market_Info (), 3),
            mask (Day_Ahead_RMR (), 4),
            mask (Forecasted_UDC_Direct_Access_Load (), 5),
            mask (Hour_Ahead_Market_Info (), 6),
            mask (Hourly_Expost_Market_Info (), 7),
            mask (Public_Bid_Data (), 8),
            mask (TTC_ATC_Forecast_Information (), 9),
            mask (TTC_ATC_Hourly_Forecast (), 10),
            mask (Ten_Min_Expost_Market_Info (), 11)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISBidReportType
(
    override val sup: BasicElement = null,
    BIDS_PUBLIC: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[OASISBidReportType] }
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
        implicit val clz: String = OASISBidReportType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISBidReportType.fields (position), value)
        emitattr (0, BIDS_PUBLIC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISBidReportType rdf:ID=\"%s\">\n%s\t</cim:OASISBidReportType>".format (id, export_fields)
    }
}

object OASISBidReportType
extends
    Parseable[OASISBidReportType]
{
    override val fields: Array[String] = Array[String] (
        "BIDS_PUBLIC"
    )
    val BIDS_PUBLIC: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): OASISBidReportType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISBidReportType (
            BasicElement.parse (context),
            mask (BIDS_PUBLIC (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISDataItems
(
    override val sup: BasicElement = null,
    AS_CLEAR_ASMP_IFM: String = null,
    AS_CLEAR_ASMP_RTM: String = null,
    AS_CLEAR_COST_IFM: String = null,
    AS_CLEAR_COST_RTM: String = null,
    AS_CLEAR_MW_IFM: String = null,
    AS_CLEAR_MW_RTM: String = null,
    AS_GEN_TOTAL_MW_IFM: String = null,
    AS_GEN_TOTAL_MW_RTM: String = null,
    AS_IMP_TOTAL_MW_IFM: String = null,
    AS_IMP_TOTAL_MW_RTM: String = null,
    AS_LOAD_TOTAL_MW_IFM: String = null,
    AS_LOAD_TOTAL_MW_RTM: String = null,
    AS_REGION_REQ_MAX: String = null,
    AS_REGION_REQ_MIN: String = null,
    AS_REGION_value: String = null,
    AS_SELF_MW_IFM: String = null,
    AS_SELF_MW_RTM: String = null,
    AS_TOTAL_MW: String = null,
    AS_TOTAL_MW_IFM: String = null,
    AS_TOTAL_MW_RTM: String = null,
    AS_TYPE: String = null,
    AS_USER_RATE: String = null,
    CA_value: String = null,
    CMMT_MINLOAD_MLC: String = null,
    CMMT_MINLOAD_MW: String = null,
    CMMT_RA_MLC: String = null,
    CMMT_RA_MW: String = null,
    CMMT_RA_START_COST: String = null,
    CMMT_RA_UNITS: String = null,
    CMMT_TOTAL_MW: String = null,
    CMMT_TOTAL_START_COST: String = null,
    CMMT_TOTAL_UNITS: String = null,
    CRR_CAT: String = null,
    CRR_MARKET_value: String = null,
    CRR_MW: String = null,
    CRR_NSR: String = null,
    CRR_OPTION: String = null,
    CRR_OWNER: String = null,
    CRR_SEGMENT: String = null,
    CRR_TERM: String = null,
    CRR_TOU: String = null,
    CRR_TYPE: String = null,
    ENE_EA_DA: String = null,
    ENE_EA_EXCEPT: String = null,
    ENE_EA_HASP: String = null,
    ENE_EA_MLE: String = null,
    ENE_EA_MSSLF: String = null,
    ENE_EA_OPTIMAL: String = null,
    ENE_EA_RAMP_DEV: String = null,
    ENE_EA_RAMP_STD: String = null,
    ENE_EA_RESIDUAL: String = null,
    ENE_EA_RMR: String = null,
    ENE_EA_SELF: String = null,
    ENE_EA_SLIC: String = null,
    ENE_EXP_CLEAR_HASP: String = null,
    ENE_EXP_CLEAR_IFM: String = null,
    ENE_EXP_CLEAR_RTM: String = null,
    ENE_GEN_CLEAR_HASP: String = null,
    ENE_GEN_CLEAR_IFM: String = null,
    ENE_GEN_CLEAR_RTM: String = null,
    ENE_IMP_CLEAR_HASP: String = null,
    ENE_IMP_CLEAR_IFM: String = null,
    ENE_IMP_CLEAR_RTM: String = null,
    ENE_LOAD_ACTUAL: String = null,
    ENE_LOAD_CLEAR_HASP: String = null,
    ENE_LOAD_CLEAR_IFM: String = null,
    ENE_LOAD_CLEAR_RTM: String = null,
    ENE_LOAD_FCST: String = null,
    ENE_PEAK_HOUR: String = null,
    ENE_PEAK_LOAD: String = null,
    FUEL_REGION_value: String = null,
    INVT_DATETIME: String = null,
    LOAD_ACTUAL: String = null,
    LOAD_CLEAR_RTM: String = null,
    LOSS_TOTAL_COST_HASP: String = null,
    LOSS_TOTAL_COST_RTM: String = null,
    LOSS_TOTAL_MW_HASP: String = null,
    LOSS_TOTAL_MW_RTM: String = null,
    MPM_FLAG: String = null,
    OP_RSRV_TOTAL: String = null,
    PRC_NG: String = null,
    PRC_SHADOW: String = null,
    RATING_ATC: String = null,
    RMR_DETER_DAM: String = null,
    RMR_DETER_HASP: String = null,
    RMR_DISPATCH_DAM: String = null,
    RMR_DISPATCH_HASP: String = null,
    RMR_TOTAL: String = null,
    RMR_TOTAL_AVAIL: String = null,
    RUC_GEN_CLEAR_RUC: String = null,
    RUC_IMP_CLEAR_RUC: String = null,
    RUC_LOAD_CLEAR_RUC: String = null,
    RUC_ZONE_value: String = null,
    TAC_AREA_value: String = null,
    TINTRFCE_value: String = null,
    TRNS_AS_IMPORT: String = null,
    TRNS_ENE_IMPORT: String = null,
    TRNS_EQUIP_value: String = null,
    TRNS_RATING_CBM: String = null,
    TRNS_RATING_DIRECTION: String = null,
    TRNS_RATING_OTC: String = null,
    TRNS_RATING_OTC_DERATE: String = null,
    TRNS_RATING_TTC: String = null,
    TRNS_TI_value: String = null,
    TRNS_TR_ENTMTS: String = null,
    TRNS_TR_USEAGE: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[OASISDataItems] }
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
        implicit val clz: String = OASISDataItems.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISDataItems.fields (position), value)
        emitattr (0, AS_CLEAR_ASMP_IFM)
        emitattr (1, AS_CLEAR_ASMP_RTM)
        emitattr (2, AS_CLEAR_COST_IFM)
        emitattr (3, AS_CLEAR_COST_RTM)
        emitattr (4, AS_CLEAR_MW_IFM)
        emitattr (5, AS_CLEAR_MW_RTM)
        emitattr (6, AS_GEN_TOTAL_MW_IFM)
        emitattr (7, AS_GEN_TOTAL_MW_RTM)
        emitattr (8, AS_IMP_TOTAL_MW_IFM)
        emitattr (9, AS_IMP_TOTAL_MW_RTM)
        emitattr (10, AS_LOAD_TOTAL_MW_IFM)
        emitattr (11, AS_LOAD_TOTAL_MW_RTM)
        emitattr (12, AS_REGION_REQ_MAX)
        emitattr (13, AS_REGION_REQ_MIN)
        emitattr (14, AS_REGION_value)
        emitattr (15, AS_SELF_MW_IFM)
        emitattr (16, AS_SELF_MW_RTM)
        emitattr (17, AS_TOTAL_MW)
        emitattr (18, AS_TOTAL_MW_IFM)
        emitattr (19, AS_TOTAL_MW_RTM)
        emitattr (20, AS_TYPE)
        emitattr (21, AS_USER_RATE)
        emitattr (22, CA_value)
        emitattr (23, CMMT_MINLOAD_MLC)
        emitattr (24, CMMT_MINLOAD_MW)
        emitattr (25, CMMT_RA_MLC)
        emitattr (26, CMMT_RA_MW)
        emitattr (27, CMMT_RA_START_COST)
        emitattr (28, CMMT_RA_UNITS)
        emitattr (29, CMMT_TOTAL_MW)
        emitattr (30, CMMT_TOTAL_START_COST)
        emitattr (31, CMMT_TOTAL_UNITS)
        emitattr (32, CRR_CAT)
        emitattr (33, CRR_MARKET_value)
        emitattr (34, CRR_MW)
        emitattr (35, CRR_NSR)
        emitattr (36, CRR_OPTION)
        emitattr (37, CRR_OWNER)
        emitattr (38, CRR_SEGMENT)
        emitattr (39, CRR_TERM)
        emitattr (40, CRR_TOU)
        emitattr (41, CRR_TYPE)
        emitattr (42, ENE_EA_DA)
        emitattr (43, ENE_EA_EXCEPT)
        emitattr (44, ENE_EA_HASP)
        emitattr (45, ENE_EA_MLE)
        emitattr (46, ENE_EA_MSSLF)
        emitattr (47, ENE_EA_OPTIMAL)
        emitattr (48, ENE_EA_RAMP_DEV)
        emitattr (49, ENE_EA_RAMP_STD)
        emitattr (50, ENE_EA_RESIDUAL)
        emitattr (51, ENE_EA_RMR)
        emitattr (52, ENE_EA_SELF)
        emitattr (53, ENE_EA_SLIC)
        emitattr (54, ENE_EXP_CLEAR_HASP)
        emitattr (55, ENE_EXP_CLEAR_IFM)
        emitattr (56, ENE_EXP_CLEAR_RTM)
        emitattr (57, ENE_GEN_CLEAR_HASP)
        emitattr (58, ENE_GEN_CLEAR_IFM)
        emitattr (59, ENE_GEN_CLEAR_RTM)
        emitattr (60, ENE_IMP_CLEAR_HASP)
        emitattr (61, ENE_IMP_CLEAR_IFM)
        emitattr (62, ENE_IMP_CLEAR_RTM)
        emitattr (63, ENE_LOAD_ACTUAL)
        emitattr (64, ENE_LOAD_CLEAR_HASP)
        emitattr (65, ENE_LOAD_CLEAR_IFM)
        emitattr (66, ENE_LOAD_CLEAR_RTM)
        emitattr (67, ENE_LOAD_FCST)
        emitattr (68, ENE_PEAK_HOUR)
        emitattr (69, ENE_PEAK_LOAD)
        emitattr (70, FUEL_REGION_value)
        emitattr (71, INVT_DATETIME)
        emitattr (72, LOAD_ACTUAL)
        emitattr (73, LOAD_CLEAR_RTM)
        emitattr (74, LOSS_TOTAL_COST_HASP)
        emitattr (75, LOSS_TOTAL_COST_RTM)
        emitattr (76, LOSS_TOTAL_MW_HASP)
        emitattr (77, LOSS_TOTAL_MW_RTM)
        emitattr (78, MPM_FLAG)
        emitattr (79, OP_RSRV_TOTAL)
        emitattr (80, PRC_NG)
        emitattr (81, PRC_SHADOW)
        emitattr (82, RATING_ATC)
        emitattr (83, RMR_DETER_DAM)
        emitattr (84, RMR_DETER_HASP)
        emitattr (85, RMR_DISPATCH_DAM)
        emitattr (86, RMR_DISPATCH_HASP)
        emitattr (87, RMR_TOTAL)
        emitattr (88, RMR_TOTAL_AVAIL)
        emitattr (89, RUC_GEN_CLEAR_RUC)
        emitattr (90, RUC_IMP_CLEAR_RUC)
        emitattr (91, RUC_LOAD_CLEAR_RUC)
        emitattr (92, RUC_ZONE_value)
        emitattr (93, TAC_AREA_value)
        emitattr (94, TINTRFCE_value)
        emitattr (95, TRNS_AS_IMPORT)
        emitattr (96, TRNS_ENE_IMPORT)
        emitattr (97, TRNS_EQUIP_value)
        emitattr (98, TRNS_RATING_CBM)
        emitattr (99, TRNS_RATING_DIRECTION)
        emitattr (100, TRNS_RATING_OTC)
        emitattr (101, TRNS_RATING_OTC_DERATE)
        emitattr (102, TRNS_RATING_TTC)
        emitattr (103, TRNS_TI_value)
        emitattr (104, TRNS_TR_ENTMTS)
        emitattr (105, TRNS_TR_USEAGE)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISDataItems rdf:ID=\"%s\">\n%s\t</cim:OASISDataItems>".format (id, export_fields)
    }
}

object OASISDataItems
extends
    Parseable[OASISDataItems]
{
    override val fields: Array[String] = Array[String] (
        "AS_CLEAR_ASMP_IFM",
        "AS_CLEAR_ASMP_RTM",
        "AS_CLEAR_COST_IFM",
        "AS_CLEAR_COST_RTM",
        "AS_CLEAR_MW_IFM",
        "AS_CLEAR_MW_RTM",
        "AS_GEN_TOTAL_MW_IFM",
        "AS_GEN_TOTAL_MW_RTM",
        "AS_IMP_TOTAL_MW_IFM",
        "AS_IMP_TOTAL_MW_RTM",
        "AS_LOAD_TOTAL_MW_IFM",
        "AS_LOAD_TOTAL_MW_RTM",
        "AS_REGION_REQ_MAX",
        "AS_REGION_REQ_MIN",
        "AS_REGION_value",
        "AS_SELF_MW_IFM",
        "AS_SELF_MW_RTM",
        "AS_TOTAL_MW",
        "AS_TOTAL_MW_IFM",
        "AS_TOTAL_MW_RTM",
        "AS_TYPE",
        "AS_USER_RATE",
        "CA_value",
        "CMMT_MINLOAD_MLC",
        "CMMT_MINLOAD_MW",
        "CMMT_RA_MLC",
        "CMMT_RA_MW",
        "CMMT_RA_START_COST",
        "CMMT_RA_UNITS",
        "CMMT_TOTAL_MW",
        "CMMT_TOTAL_START_COST",
        "CMMT_TOTAL_UNITS",
        "CRR_CAT",
        "CRR_MARKET_value",
        "CRR_MW",
        "CRR_NSR",
        "CRR_OPTION",
        "CRR_OWNER",
        "CRR_SEGMENT",
        "CRR_TERM",
        "CRR_TOU",
        "CRR_TYPE",
        "ENE_EA_DA",
        "ENE_EA_EXCEPT",
        "ENE_EA_HASP",
        "ENE_EA_MLE",
        "ENE_EA_MSSLF",
        "ENE_EA_OPTIMAL",
        "ENE_EA_RAMP_DEV",
        "ENE_EA_RAMP_STD",
        "ENE_EA_RESIDUAL",
        "ENE_EA_RMR",
        "ENE_EA_SELF",
        "ENE_EA_SLIC",
        "ENE_EXP_CLEAR_HASP",
        "ENE_EXP_CLEAR_IFM",
        "ENE_EXP_CLEAR_RTM",
        "ENE_GEN_CLEAR_HASP",
        "ENE_GEN_CLEAR_IFM",
        "ENE_GEN_CLEAR_RTM",
        "ENE_IMP_CLEAR_HASP",
        "ENE_IMP_CLEAR_IFM",
        "ENE_IMP_CLEAR_RTM",
        "ENE_LOAD_ACTUAL",
        "ENE_LOAD_CLEAR_HASP",
        "ENE_LOAD_CLEAR_IFM",
        "ENE_LOAD_CLEAR_RTM",
        "ENE_LOAD_FCST",
        "ENE_PEAK_HOUR",
        "ENE_PEAK_LOAD",
        "FUEL_REGION_value",
        "INVT_DATETIME",
        "LOAD_ACTUAL",
        "LOAD_CLEAR_RTM",
        "LOSS_TOTAL_COST_HASP",
        "LOSS_TOTAL_COST_RTM",
        "LOSS_TOTAL_MW_HASP",
        "LOSS_TOTAL_MW_RTM",
        "MPM_FLAG",
        "OP_RSRV_TOTAL",
        "PRC_NG",
        "PRC_SHADOW",
        "RATING_ATC",
        "RMR_DETER_DAM",
        "RMR_DETER_HASP",
        "RMR_DISPATCH_DAM",
        "RMR_DISPATCH_HASP",
        "RMR_TOTAL",
        "RMR_TOTAL_AVAIL",
        "RUC_GEN_CLEAR_RUC",
        "RUC_IMP_CLEAR_RUC",
        "RUC_LOAD_CLEAR_RUC",
        "RUC_ZONE_value",
        "TAC_AREA_value",
        "TINTRFCE_value",
        "TRNS_AS_IMPORT",
        "TRNS_ENE_IMPORT",
        "TRNS_EQUIP_value",
        "TRNS_RATING_CBM",
        "TRNS_RATING_DIRECTION",
        "TRNS_RATING_OTC",
        "TRNS_RATING_OTC_DERATE",
        "TRNS_RATING_TTC",
        "TRNS_TI_value",
        "TRNS_TR_ENTMTS",
        "TRNS_TR_USEAGE"
    )
    val AS_CLEAR_ASMP_IFM: Fielder = parse_attribute (attribute (cls, fields(0)))
    val AS_CLEAR_ASMP_RTM: Fielder = parse_attribute (attribute (cls, fields(1)))
    val AS_CLEAR_COST_IFM: Fielder = parse_attribute (attribute (cls, fields(2)))
    val AS_CLEAR_COST_RTM: Fielder = parse_attribute (attribute (cls, fields(3)))
    val AS_CLEAR_MW_IFM: Fielder = parse_attribute (attribute (cls, fields(4)))
    val AS_CLEAR_MW_RTM: Fielder = parse_attribute (attribute (cls, fields(5)))
    val AS_GEN_TOTAL_MW_IFM: Fielder = parse_attribute (attribute (cls, fields(6)))
    val AS_GEN_TOTAL_MW_RTM: Fielder = parse_attribute (attribute (cls, fields(7)))
    val AS_IMP_TOTAL_MW_IFM: Fielder = parse_attribute (attribute (cls, fields(8)))
    val AS_IMP_TOTAL_MW_RTM: Fielder = parse_attribute (attribute (cls, fields(9)))
    val AS_LOAD_TOTAL_MW_IFM: Fielder = parse_attribute (attribute (cls, fields(10)))
    val AS_LOAD_TOTAL_MW_RTM: Fielder = parse_attribute (attribute (cls, fields(11)))
    val AS_REGION_REQ_MAX: Fielder = parse_attribute (attribute (cls, fields(12)))
    val AS_REGION_REQ_MIN: Fielder = parse_attribute (attribute (cls, fields(13)))
    val AS_REGION_value: Fielder = parse_attribute (attribute (cls, fields(14)))
    val AS_SELF_MW_IFM: Fielder = parse_attribute (attribute (cls, fields(15)))
    val AS_SELF_MW_RTM: Fielder = parse_attribute (attribute (cls, fields(16)))
    val AS_TOTAL_MW: Fielder = parse_attribute (attribute (cls, fields(17)))
    val AS_TOTAL_MW_IFM: Fielder = parse_attribute (attribute (cls, fields(18)))
    val AS_TOTAL_MW_RTM: Fielder = parse_attribute (attribute (cls, fields(19)))
    val AS_TYPE: Fielder = parse_attribute (attribute (cls, fields(20)))
    val AS_USER_RATE: Fielder = parse_attribute (attribute (cls, fields(21)))
    val CA_value: Fielder = parse_attribute (attribute (cls, fields(22)))
    val CMMT_MINLOAD_MLC: Fielder = parse_attribute (attribute (cls, fields(23)))
    val CMMT_MINLOAD_MW: Fielder = parse_attribute (attribute (cls, fields(24)))
    val CMMT_RA_MLC: Fielder = parse_attribute (attribute (cls, fields(25)))
    val CMMT_RA_MW: Fielder = parse_attribute (attribute (cls, fields(26)))
    val CMMT_RA_START_COST: Fielder = parse_attribute (attribute (cls, fields(27)))
    val CMMT_RA_UNITS: Fielder = parse_attribute (attribute (cls, fields(28)))
    val CMMT_TOTAL_MW: Fielder = parse_attribute (attribute (cls, fields(29)))
    val CMMT_TOTAL_START_COST: Fielder = parse_attribute (attribute (cls, fields(30)))
    val CMMT_TOTAL_UNITS: Fielder = parse_attribute (attribute (cls, fields(31)))
    val CRR_CAT: Fielder = parse_attribute (attribute (cls, fields(32)))
    val CRR_MARKET_value: Fielder = parse_attribute (attribute (cls, fields(33)))
    val CRR_MW: Fielder = parse_attribute (attribute (cls, fields(34)))
    val CRR_NSR: Fielder = parse_attribute (attribute (cls, fields(35)))
    val CRR_OPTION: Fielder = parse_attribute (attribute (cls, fields(36)))
    val CRR_OWNER: Fielder = parse_attribute (attribute (cls, fields(37)))
    val CRR_SEGMENT: Fielder = parse_attribute (attribute (cls, fields(38)))
    val CRR_TERM: Fielder = parse_attribute (attribute (cls, fields(39)))
    val CRR_TOU: Fielder = parse_attribute (attribute (cls, fields(40)))
    val CRR_TYPE: Fielder = parse_attribute (attribute (cls, fields(41)))
    val ENE_EA_DA: Fielder = parse_attribute (attribute (cls, fields(42)))
    val ENE_EA_EXCEPT: Fielder = parse_attribute (attribute (cls, fields(43)))
    val ENE_EA_HASP: Fielder = parse_attribute (attribute (cls, fields(44)))
    val ENE_EA_MLE: Fielder = parse_attribute (attribute (cls, fields(45)))
    val ENE_EA_MSSLF: Fielder = parse_attribute (attribute (cls, fields(46)))
    val ENE_EA_OPTIMAL: Fielder = parse_attribute (attribute (cls, fields(47)))
    val ENE_EA_RAMP_DEV: Fielder = parse_attribute (attribute (cls, fields(48)))
    val ENE_EA_RAMP_STD: Fielder = parse_attribute (attribute (cls, fields(49)))
    val ENE_EA_RESIDUAL: Fielder = parse_attribute (attribute (cls, fields(50)))
    val ENE_EA_RMR: Fielder = parse_attribute (attribute (cls, fields(51)))
    val ENE_EA_SELF: Fielder = parse_attribute (attribute (cls, fields(52)))
    val ENE_EA_SLIC: Fielder = parse_attribute (attribute (cls, fields(53)))
    val ENE_EXP_CLEAR_HASP: Fielder = parse_attribute (attribute (cls, fields(54)))
    val ENE_EXP_CLEAR_IFM: Fielder = parse_attribute (attribute (cls, fields(55)))
    val ENE_EXP_CLEAR_RTM: Fielder = parse_attribute (attribute (cls, fields(56)))
    val ENE_GEN_CLEAR_HASP: Fielder = parse_attribute (attribute (cls, fields(57)))
    val ENE_GEN_CLEAR_IFM: Fielder = parse_attribute (attribute (cls, fields(58)))
    val ENE_GEN_CLEAR_RTM: Fielder = parse_attribute (attribute (cls, fields(59)))
    val ENE_IMP_CLEAR_HASP: Fielder = parse_attribute (attribute (cls, fields(60)))
    val ENE_IMP_CLEAR_IFM: Fielder = parse_attribute (attribute (cls, fields(61)))
    val ENE_IMP_CLEAR_RTM: Fielder = parse_attribute (attribute (cls, fields(62)))
    val ENE_LOAD_ACTUAL: Fielder = parse_attribute (attribute (cls, fields(63)))
    val ENE_LOAD_CLEAR_HASP: Fielder = parse_attribute (attribute (cls, fields(64)))
    val ENE_LOAD_CLEAR_IFM: Fielder = parse_attribute (attribute (cls, fields(65)))
    val ENE_LOAD_CLEAR_RTM: Fielder = parse_attribute (attribute (cls, fields(66)))
    val ENE_LOAD_FCST: Fielder = parse_attribute (attribute (cls, fields(67)))
    val ENE_PEAK_HOUR: Fielder = parse_attribute (attribute (cls, fields(68)))
    val ENE_PEAK_LOAD: Fielder = parse_attribute (attribute (cls, fields(69)))
    val FUEL_REGION_value: Fielder = parse_attribute (attribute (cls, fields(70)))
    val INVT_DATETIME: Fielder = parse_attribute (attribute (cls, fields(71)))
    val LOAD_ACTUAL: Fielder = parse_attribute (attribute (cls, fields(72)))
    val LOAD_CLEAR_RTM: Fielder = parse_attribute (attribute (cls, fields(73)))
    val LOSS_TOTAL_COST_HASP: Fielder = parse_attribute (attribute (cls, fields(74)))
    val LOSS_TOTAL_COST_RTM: Fielder = parse_attribute (attribute (cls, fields(75)))
    val LOSS_TOTAL_MW_HASP: Fielder = parse_attribute (attribute (cls, fields(76)))
    val LOSS_TOTAL_MW_RTM: Fielder = parse_attribute (attribute (cls, fields(77)))
    val MPM_FLAG: Fielder = parse_attribute (attribute (cls, fields(78)))
    val OP_RSRV_TOTAL: Fielder = parse_attribute (attribute (cls, fields(79)))
    val PRC_NG: Fielder = parse_attribute (attribute (cls, fields(80)))
    val PRC_SHADOW: Fielder = parse_attribute (attribute (cls, fields(81)))
    val RATING_ATC: Fielder = parse_attribute (attribute (cls, fields(82)))
    val RMR_DETER_DAM: Fielder = parse_attribute (attribute (cls, fields(83)))
    val RMR_DETER_HASP: Fielder = parse_attribute (attribute (cls, fields(84)))
    val RMR_DISPATCH_DAM: Fielder = parse_attribute (attribute (cls, fields(85)))
    val RMR_DISPATCH_HASP: Fielder = parse_attribute (attribute (cls, fields(86)))
    val RMR_TOTAL: Fielder = parse_attribute (attribute (cls, fields(87)))
    val RMR_TOTAL_AVAIL: Fielder = parse_attribute (attribute (cls, fields(88)))
    val RUC_GEN_CLEAR_RUC: Fielder = parse_attribute (attribute (cls, fields(89)))
    val RUC_IMP_CLEAR_RUC: Fielder = parse_attribute (attribute (cls, fields(90)))
    val RUC_LOAD_CLEAR_RUC: Fielder = parse_attribute (attribute (cls, fields(91)))
    val RUC_ZONE_value: Fielder = parse_attribute (attribute (cls, fields(92)))
    val TAC_AREA_value: Fielder = parse_attribute (attribute (cls, fields(93)))
    val TINTRFCE_value: Fielder = parse_attribute (attribute (cls, fields(94)))
    val TRNS_AS_IMPORT: Fielder = parse_attribute (attribute (cls, fields(95)))
    val TRNS_ENE_IMPORT: Fielder = parse_attribute (attribute (cls, fields(96)))
    val TRNS_EQUIP_value: Fielder = parse_attribute (attribute (cls, fields(97)))
    val TRNS_RATING_CBM: Fielder = parse_attribute (attribute (cls, fields(98)))
    val TRNS_RATING_DIRECTION: Fielder = parse_attribute (attribute (cls, fields(99)))
    val TRNS_RATING_OTC: Fielder = parse_attribute (attribute (cls, fields(100)))
    val TRNS_RATING_OTC_DERATE: Fielder = parse_attribute (attribute (cls, fields(101)))
    val TRNS_RATING_TTC: Fielder = parse_attribute (attribute (cls, fields(102)))
    val TRNS_TI_value: Fielder = parse_attribute (attribute (cls, fields(103)))
    val TRNS_TR_ENTMTS: Fielder = parse_attribute (attribute (cls, fields(104)))
    val TRNS_TR_USEAGE: Fielder = parse_attribute (attribute (cls, fields(105)))

    def parse (context: Context): OASISDataItems =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0,0,0)
        val ret = OASISDataItems (
            BasicElement.parse (context),
            mask (AS_CLEAR_ASMP_IFM (), 0),
            mask (AS_CLEAR_ASMP_RTM (), 1),
            mask (AS_CLEAR_COST_IFM (), 2),
            mask (AS_CLEAR_COST_RTM (), 3),
            mask (AS_CLEAR_MW_IFM (), 4),
            mask (AS_CLEAR_MW_RTM (), 5),
            mask (AS_GEN_TOTAL_MW_IFM (), 6),
            mask (AS_GEN_TOTAL_MW_RTM (), 7),
            mask (AS_IMP_TOTAL_MW_IFM (), 8),
            mask (AS_IMP_TOTAL_MW_RTM (), 9),
            mask (AS_LOAD_TOTAL_MW_IFM (), 10),
            mask (AS_LOAD_TOTAL_MW_RTM (), 11),
            mask (AS_REGION_REQ_MAX (), 12),
            mask (AS_REGION_REQ_MIN (), 13),
            mask (AS_REGION_value (), 14),
            mask (AS_SELF_MW_IFM (), 15),
            mask (AS_SELF_MW_RTM (), 16),
            mask (AS_TOTAL_MW (), 17),
            mask (AS_TOTAL_MW_IFM (), 18),
            mask (AS_TOTAL_MW_RTM (), 19),
            mask (AS_TYPE (), 20),
            mask (AS_USER_RATE (), 21),
            mask (CA_value (), 22),
            mask (CMMT_MINLOAD_MLC (), 23),
            mask (CMMT_MINLOAD_MW (), 24),
            mask (CMMT_RA_MLC (), 25),
            mask (CMMT_RA_MW (), 26),
            mask (CMMT_RA_START_COST (), 27),
            mask (CMMT_RA_UNITS (), 28),
            mask (CMMT_TOTAL_MW (), 29),
            mask (CMMT_TOTAL_START_COST (), 30),
            mask (CMMT_TOTAL_UNITS (), 31),
            mask (CRR_CAT (), 32),
            mask (CRR_MARKET_value (), 33),
            mask (CRR_MW (), 34),
            mask (CRR_NSR (), 35),
            mask (CRR_OPTION (), 36),
            mask (CRR_OWNER (), 37),
            mask (CRR_SEGMENT (), 38),
            mask (CRR_TERM (), 39),
            mask (CRR_TOU (), 40),
            mask (CRR_TYPE (), 41),
            mask (ENE_EA_DA (), 42),
            mask (ENE_EA_EXCEPT (), 43),
            mask (ENE_EA_HASP (), 44),
            mask (ENE_EA_MLE (), 45),
            mask (ENE_EA_MSSLF (), 46),
            mask (ENE_EA_OPTIMAL (), 47),
            mask (ENE_EA_RAMP_DEV (), 48),
            mask (ENE_EA_RAMP_STD (), 49),
            mask (ENE_EA_RESIDUAL (), 50),
            mask (ENE_EA_RMR (), 51),
            mask (ENE_EA_SELF (), 52),
            mask (ENE_EA_SLIC (), 53),
            mask (ENE_EXP_CLEAR_HASP (), 54),
            mask (ENE_EXP_CLEAR_IFM (), 55),
            mask (ENE_EXP_CLEAR_RTM (), 56),
            mask (ENE_GEN_CLEAR_HASP (), 57),
            mask (ENE_GEN_CLEAR_IFM (), 58),
            mask (ENE_GEN_CLEAR_RTM (), 59),
            mask (ENE_IMP_CLEAR_HASP (), 60),
            mask (ENE_IMP_CLEAR_IFM (), 61),
            mask (ENE_IMP_CLEAR_RTM (), 62),
            mask (ENE_LOAD_ACTUAL (), 63),
            mask (ENE_LOAD_CLEAR_HASP (), 64),
            mask (ENE_LOAD_CLEAR_IFM (), 65),
            mask (ENE_LOAD_CLEAR_RTM (), 66),
            mask (ENE_LOAD_FCST (), 67),
            mask (ENE_PEAK_HOUR (), 68),
            mask (ENE_PEAK_LOAD (), 69),
            mask (FUEL_REGION_value (), 70),
            mask (INVT_DATETIME (), 71),
            mask (LOAD_ACTUAL (), 72),
            mask (LOAD_CLEAR_RTM (), 73),
            mask (LOSS_TOTAL_COST_HASP (), 74),
            mask (LOSS_TOTAL_COST_RTM (), 75),
            mask (LOSS_TOTAL_MW_HASP (), 76),
            mask (LOSS_TOTAL_MW_RTM (), 77),
            mask (MPM_FLAG (), 78),
            mask (OP_RSRV_TOTAL (), 79),
            mask (PRC_NG (), 80),
            mask (PRC_SHADOW (), 81),
            mask (RATING_ATC (), 82),
            mask (RMR_DETER_DAM (), 83),
            mask (RMR_DETER_HASP (), 84),
            mask (RMR_DISPATCH_DAM (), 85),
            mask (RMR_DISPATCH_HASP (), 86),
            mask (RMR_TOTAL (), 87),
            mask (RMR_TOTAL_AVAIL (), 88),
            mask (RUC_GEN_CLEAR_RUC (), 89),
            mask (RUC_IMP_CLEAR_RUC (), 90),
            mask (RUC_LOAD_CLEAR_RUC (), 91),
            mask (RUC_ZONE_value (), 92),
            mask (TAC_AREA_value (), 93),
            mask (TINTRFCE_value (), 94),
            mask (TRNS_AS_IMPORT (), 95),
            mask (TRNS_ENE_IMPORT (), 96),
            mask (TRNS_EQUIP_value (), 97),
            mask (TRNS_RATING_CBM (), 98),
            mask (TRNS_RATING_DIRECTION (), 99),
            mask (TRNS_RATING_OTC (), 100),
            mask (TRNS_RATING_OTC_DERATE (), 101),
            mask (TRNS_RATING_TTC (), 102),
            mask (TRNS_TI_value (), 103),
            mask (TRNS_TR_ENTMTS (), 104),
            mask (TRNS_TR_USEAGE (), 105)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISErrCode
(
    override val sup: BasicElement = null,
    _1000: String = null,
    _1001: String = null,
    _1002: String = null,
    _1003: String = null,
    _1004: String = null,
    _1005: String = null,
    _1006: String = null,
    _1007: String = null,
    _1008: String = null,
    _1009: String = null,
    _1010: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[OASISErrCode] }
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
        implicit val clz: String = OASISErrCode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISErrCode.fields (position), value)
        emitattr (0, _1000)
        emitattr (1, _1001)
        emitattr (2, _1002)
        emitattr (3, _1003)
        emitattr (4, _1004)
        emitattr (5, _1005)
        emitattr (6, _1006)
        emitattr (7, _1007)
        emitattr (8, _1008)
        emitattr (9, _1009)
        emitattr (10, _1010)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISErrCode rdf:ID=\"%s\">\n%s\t</cim:OASISErrCode>".format (id, export_fields)
    }
}

object OASISErrCode
extends
    Parseable[OASISErrCode]
{
    override val fields: Array[String] = Array[String] (
        "1000",
        "1001",
        "1002",
        "1003",
        "1004",
        "1005",
        "1006",
        "1007",
        "1008",
        "1009",
        "1010"
    )
    val _1000: Fielder = parse_attribute (attribute (cls, fields(0)))
    val _1001: Fielder = parse_attribute (attribute (cls, fields(1)))
    val _1002: Fielder = parse_attribute (attribute (cls, fields(2)))
    val _1003: Fielder = parse_attribute (attribute (cls, fields(3)))
    val _1004: Fielder = parse_attribute (attribute (cls, fields(4)))
    val _1005: Fielder = parse_attribute (attribute (cls, fields(5)))
    val _1006: Fielder = parse_attribute (attribute (cls, fields(6)))
    val _1007: Fielder = parse_attribute (attribute (cls, fields(7)))
    val _1008: Fielder = parse_attribute (attribute (cls, fields(8)))
    val _1009: Fielder = parse_attribute (attribute (cls, fields(9)))
    val _1010: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: Context): OASISErrCode =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISErrCode (
            BasicElement.parse (context),
            mask (_1000 (), 0),
            mask (_1001 (), 1),
            mask (_1002 (), 2),
            mask (_1003 (), 3),
            mask (_1004 (), 4),
            mask (_1005 (), 5),
            mask (_1006 (), 6),
            mask (_1007 (), 7),
            mask (_1008 (), 8),
            mask (_1009 (), 9),
            mask (_1010 (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISErrDescription
(
    override val sup: BasicElement = null,
    Data_can_be_requested_for_period_of_31_days_only: String = null,
    Exceptions_in_reading_and_writing_of_XML_files: String = null,
    Invalid_date_format__please_use_valid_date_format: String = null,
    No_data_returned_for_the_specified_selection: String = null,
    Out_of_memory_exception: String = null,
    Report_name_does_not_exit__please_use_valid_report_name: String = null,
    Required_file_does_not_exist: String = null,
    System_Error: String = null,
    Timed_out_waiting_for_query_response: String = null,
    Validation_exception_during_transformation_of_XML: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[OASISErrDescription] }
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
        implicit val clz: String = OASISErrDescription.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISErrDescription.fields (position), value)
        emitattr (0, Data_can_be_requested_for_period_of_31_days_only)
        emitattr (1, Exceptions_in_reading_and_writing_of_XML_files)
        emitattr (2, Invalid_date_format__please_use_valid_date_format)
        emitattr (3, No_data_returned_for_the_specified_selection)
        emitattr (4, Out_of_memory_exception)
        emitattr (5, Report_name_does_not_exit__please_use_valid_report_name)
        emitattr (6, Required_file_does_not_exist)
        emitattr (7, System_Error)
        emitattr (8, Timed_out_waiting_for_query_response)
        emitattr (9, Validation_exception_during_transformation_of_XML)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISErrDescription rdf:ID=\"%s\">\n%s\t</cim:OASISErrDescription>".format (id, export_fields)
    }
}

object OASISErrDescription
extends
    Parseable[OASISErrDescription]
{
    override val fields: Array[String] = Array[String] (
        "Data can be requested for period of 31 days only",
        "Exceptions in reading and writing of XML files",
        "Invalid date format, please use valid date format",
        "No data returned for the specified selection",
        "Out of memory exception",
        "Report name does not exit, please use valid report name",
        "Required file does not exist",
        "System Error",
        "Timed out waiting for query response",
        "Validation exception during transformation of XML"
    )
    val Data_can_be_requested_for_period_of_31_days_only: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Exceptions_in_reading_and_writing_of_XML_files: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Invalid_date_format__please_use_valid_date_format: Fielder = parse_attribute (attribute (cls, fields(2)))
    val No_data_returned_for_the_specified_selection: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Out_of_memory_exception: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Report_name_does_not_exit__please_use_valid_report_name: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Required_file_does_not_exist: Fielder = parse_attribute (attribute (cls, fields(6)))
    val System_Error: Fielder = parse_attribute (attribute (cls, fields(7)))
    val Timed_out_waiting_for_query_response: Fielder = parse_attribute (attribute (cls, fields(8)))
    val Validation_exception_during_transformation_of_XML: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: Context): OASISErrDescription =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISErrDescription (
            BasicElement.parse (context),
            mask (Data_can_be_requested_for_period_of_31_days_only (), 0),
            mask (Exceptions_in_reading_and_writing_of_XML_files (), 1),
            mask (Invalid_date_format__please_use_valid_date_format (), 2),
            mask (No_data_returned_for_the_specified_selection (), 3),
            mask (Out_of_memory_exception (), 4),
            mask (Report_name_does_not_exit__please_use_valid_report_name (), 5),
            mask (Required_file_does_not_exist (), 6),
            mask (System_Error (), 7),
            mask (Timed_out_waiting_for_query_response (), 8),
            mask (Validation_exception_during_transformation_of_XML (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISIntervalType
(
    override val sup: BasicElement = null,
    BEGINNING: String = null,
    ENDING: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[OASISIntervalType] }
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
        implicit val clz: String = OASISIntervalType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISIntervalType.fields (position), value)
        emitattr (0, BEGINNING)
        emitattr (1, ENDING)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISIntervalType rdf:ID=\"%s\">\n%s\t</cim:OASISIntervalType>".format (id, export_fields)
    }
}

object OASISIntervalType
extends
    Parseable[OASISIntervalType]
{
    override val fields: Array[String] = Array[String] (
        "BEGINNING",
        "ENDING"
    )
    val BEGINNING: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ENDING: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): OASISIntervalType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISIntervalType (
            BasicElement.parse (context),
            mask (BEGINNING (), 0),
            mask (ENDING (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISMarketType
(
    override val sup: BasicElement = null,
    All: String = null,
    HASP: String = null,
    IFM: String = null,
    N_A: String = null,
    RTM: String = null,
    RUC: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[OASISMarketType] }
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
        implicit val clz: String = OASISMarketType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISMarketType.fields (position), value)
        emitattr (0, All)
        emitattr (1, HASP)
        emitattr (2, IFM)
        emitattr (3, N_A)
        emitattr (4, RTM)
        emitattr (5, RUC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISMarketType rdf:ID=\"%s\">\n%s\t</cim:OASISMarketType>".format (id, export_fields)
    }
}

object OASISMarketType
extends
    Parseable[OASISMarketType]
{
    override val fields: Array[String] = Array[String] (
        "All",
        "HASP",
        "IFM",
        "N/A",
        "RTM",
        "RUC"
    )
    val All: Fielder = parse_attribute (attribute (cls, fields(0)))
    val HASP: Fielder = parse_attribute (attribute (cls, fields(1)))
    val IFM: Fielder = parse_attribute (attribute (cls, fields(2)))
    val N_A: Fielder = parse_attribute (attribute (cls, fields(3)))
    val RTM: Fielder = parse_attribute (attribute (cls, fields(4)))
    val RUC: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): OASISMarketType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISMarketType (
            BasicElement.parse (context),
            mask (All (), 0),
            mask (HASP (), 1),
            mask (IFM (), 2),
            mask (N_A (), 3),
            mask (RTM (), 4),
            mask (RUC (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISMasterType
(
    override val sup: BasicElement = null,
    ATL_APNODE: String = null,
    ATL_AS_REGION: String = null,
    ATL_AS_REGION_MAP: String = null,
    ATL_HUB: String = null,
    ATL_LAP: String = null,
    ATL_LDF: String = null,
    ATL_PNODE: String = null,
    ATL_PNODE_MAP: String = null,
    ATL_PUB: String = null,
    ATL_PUB_SCHED: String = null,
    ATL_RESOURCE: String = null,
    ATL_RUC_ZONE: String = null,
    ATL_RUC_ZONE_MAP: String = null,
    ATL_STAT: String = null,
    ATL_TAC_AREA: String = null,
    ATL_TAC_AREA_MAP: String = null,
    ATL_TI: String = null,
    ATL_TIEPOINT: String = null,
    ATL_XREF: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[OASISMasterType] }
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
        implicit val clz: String = OASISMasterType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISMasterType.fields (position), value)
        emitattr (0, ATL_APNODE)
        emitattr (1, ATL_AS_REGION)
        emitattr (2, ATL_AS_REGION_MAP)
        emitattr (3, ATL_HUB)
        emitattr (4, ATL_LAP)
        emitattr (5, ATL_LDF)
        emitattr (6, ATL_PNODE)
        emitattr (7, ATL_PNODE_MAP)
        emitattr (8, ATL_PUB)
        emitattr (9, ATL_PUB_SCHED)
        emitattr (10, ATL_RESOURCE)
        emitattr (11, ATL_RUC_ZONE)
        emitattr (12, ATL_RUC_ZONE_MAP)
        emitattr (13, ATL_STAT)
        emitattr (14, ATL_TAC_AREA)
        emitattr (15, ATL_TAC_AREA_MAP)
        emitattr (16, ATL_TI)
        emitattr (17, ATL_TIEPOINT)
        emitattr (18, ATL_XREF)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISMasterType rdf:ID=\"%s\">\n%s\t</cim:OASISMasterType>".format (id, export_fields)
    }
}

object OASISMasterType
extends
    Parseable[OASISMasterType]
{
    override val fields: Array[String] = Array[String] (
        "ATL_APNODE",
        "ATL_AS_REGION",
        "ATL_AS_REGION_MAP",
        "ATL_HUB",
        "ATL_LAP",
        "ATL_LDF",
        "ATL_PNODE",
        "ATL_PNODE_MAP",
        "ATL_PUB",
        "ATL_PUB_SCHED",
        "ATL_RESOURCE",
        "ATL_RUC_ZONE",
        "ATL_RUC_ZONE_MAP",
        "ATL_STAT",
        "ATL_TAC_AREA",
        "ATL_TAC_AREA_MAP",
        "ATL_TI",
        "ATL_TIEPOINT",
        "ATL_XREF"
    )
    val ATL_APNODE: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ATL_AS_REGION: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ATL_AS_REGION_MAP: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ATL_HUB: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ATL_LAP: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ATL_LDF: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ATL_PNODE: Fielder = parse_attribute (attribute (cls, fields(6)))
    val ATL_PNODE_MAP: Fielder = parse_attribute (attribute (cls, fields(7)))
    val ATL_PUB: Fielder = parse_attribute (attribute (cls, fields(8)))
    val ATL_PUB_SCHED: Fielder = parse_attribute (attribute (cls, fields(9)))
    val ATL_RESOURCE: Fielder = parse_attribute (attribute (cls, fields(10)))
    val ATL_RUC_ZONE: Fielder = parse_attribute (attribute (cls, fields(11)))
    val ATL_RUC_ZONE_MAP: Fielder = parse_attribute (attribute (cls, fields(12)))
    val ATL_STAT: Fielder = parse_attribute (attribute (cls, fields(13)))
    val ATL_TAC_AREA: Fielder = parse_attribute (attribute (cls, fields(14)))
    val ATL_TAC_AREA_MAP: Fielder = parse_attribute (attribute (cls, fields(15)))
    val ATL_TI: Fielder = parse_attribute (attribute (cls, fields(16)))
    val ATL_TIEPOINT: Fielder = parse_attribute (attribute (cls, fields(17)))
    val ATL_XREF: Fielder = parse_attribute (attribute (cls, fields(18)))

    def parse (context: Context): OASISMasterType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISMasterType (
            BasicElement.parse (context),
            mask (ATL_APNODE (), 0),
            mask (ATL_AS_REGION (), 1),
            mask (ATL_AS_REGION_MAP (), 2),
            mask (ATL_HUB (), 3),
            mask (ATL_LAP (), 4),
            mask (ATL_LDF (), 5),
            mask (ATL_PNODE (), 6),
            mask (ATL_PNODE_MAP (), 7),
            mask (ATL_PUB (), 8),
            mask (ATL_PUB_SCHED (), 9),
            mask (ATL_RESOURCE (), 10),
            mask (ATL_RUC_ZONE (), 11),
            mask (ATL_RUC_ZONE_MAP (), 12),
            mask (ATL_STAT (), 13),
            mask (ATL_TAC_AREA (), 14),
            mask (ATL_TAC_AREA_MAP (), 15),
            mask (ATL_TI (), 16),
            mask (ATL_TIEPOINT (), 17),
            mask (ATL_XREF (), 18)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISMeasType
(
    override val sup: BasicElement = null,
    percent: String = null,
    FACTOR: String = null,
    FLAG: String = null,
    INTEGER: String = null,
    MW: String = null,
    MWh: String = null,
    US$: String = null,
    US$_MW: String = null,
    US$_MWh: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[OASISMeasType] }
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
        implicit val clz: String = OASISMeasType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISMeasType.fields (position), value)
        emitattr (0, percent)
        emitattr (1, FACTOR)
        emitattr (2, FLAG)
        emitattr (3, INTEGER)
        emitattr (4, MW)
        emitattr (5, MWh)
        emitattr (6, US$)
        emitattr (7, US$_MW)
        emitattr (8, US$_MWh)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISMeasType rdf:ID=\"%s\">\n%s\t</cim:OASISMeasType>".format (id, export_fields)
    }
}

object OASISMeasType
extends
    Parseable[OASISMeasType]
{
    override val fields: Array[String] = Array[String] (
        "%",
        "FACTOR",
        "FLAG",
        "INTEGER",
        "MW",
        "MWh",
        "US$",
        "US$/MW",
        "US$/MWh"
    )
    val percent: Fielder = parse_attribute (attribute (cls, fields(0)))
    val FACTOR: Fielder = parse_attribute (attribute (cls, fields(1)))
    val FLAG: Fielder = parse_attribute (attribute (cls, fields(2)))
    val INTEGER: Fielder = parse_attribute (attribute (cls, fields(3)))
    val MW: Fielder = parse_attribute (attribute (cls, fields(4)))
    val MWh: Fielder = parse_attribute (attribute (cls, fields(5)))
    val US$: Fielder = parse_attribute (attribute (cls, fields(6)))
    val US$_MW: Fielder = parse_attribute (attribute (cls, fields(7)))
    val US$_MWh: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): OASISMeasType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISMeasType (
            BasicElement.parse (context),
            mask (percent (), 0),
            mask (FACTOR (), 1),
            mask (FLAG (), 2),
            mask (INTEGER (), 3),
            mask (MW (), 4),
            mask (MWh (), 5),
            mask (US$ (), 6),
            mask (US$_MW (), 7),
            mask (US$_MWh (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISReportType
(
    override val sup: BasicElement = null,
    AS_DA_RESULT: String = null,
    AS_OP_RSRV: String = null,
    AS_REQ: String = null,
    AS_RTM_RESULT: String = null,
    BIDS_PUBLIC: String = null,
    CMMT_RA_MLC: String = null,
    CMMT_RMR: String = null,
    CRR_CLEARING: String = null,
    CRR_INVENTORY: String = null,
    ENE_EA: String = null,
    ENE_HASP: String = null,
    ENE_IFM: String = null,
    ENE_MPM: String = null,
    ENE_RTM: String = null,
    ENE_RUC: String = null,
    LOSS_DA_HASP: String = null,
    LOSS_RTM: String = null,
    PRC_AS: String = null,
    PRC_CNSTR: String = null,
    PRC_FUEL: String = null,
    PRC_HRLY_LMP: String = null,
    PRC_INTVL_LMP: String = null,
    SLD_FCST: String = null,
    SLD_FCST_PEAK: String = null,
    SLD_MKTS: String = null,
    TRNS_ATC: String = null,
    TRNS_OUTAGE: String = null,
    TRNS_USAGE: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[OASISReportType] }
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
        implicit val clz: String = OASISReportType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISReportType.fields (position), value)
        emitattr (0, AS_DA_RESULT)
        emitattr (1, AS_OP_RSRV)
        emitattr (2, AS_REQ)
        emitattr (3, AS_RTM_RESULT)
        emitattr (4, BIDS_PUBLIC)
        emitattr (5, CMMT_RA_MLC)
        emitattr (6, CMMT_RMR)
        emitattr (7, CRR_CLEARING)
        emitattr (8, CRR_INVENTORY)
        emitattr (9, ENE_EA)
        emitattr (10, ENE_HASP)
        emitattr (11, ENE_IFM)
        emitattr (12, ENE_MPM)
        emitattr (13, ENE_RTM)
        emitattr (14, ENE_RUC)
        emitattr (15, LOSS_DA_HASP)
        emitattr (16, LOSS_RTM)
        emitattr (17, PRC_AS)
        emitattr (18, PRC_CNSTR)
        emitattr (19, PRC_FUEL)
        emitattr (20, PRC_HRLY_LMP)
        emitattr (21, PRC_INTVL_LMP)
        emitattr (22, SLD_FCST)
        emitattr (23, SLD_FCST_PEAK)
        emitattr (24, SLD_MKTS)
        emitattr (25, TRNS_ATC)
        emitattr (26, TRNS_OUTAGE)
        emitattr (27, TRNS_USAGE)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISReportType rdf:ID=\"%s\">\n%s\t</cim:OASISReportType>".format (id, export_fields)
    }
}

object OASISReportType
extends
    Parseable[OASISReportType]
{
    override val fields: Array[String] = Array[String] (
        "AS_DA_RESULT",
        "AS_OP_RSRV",
        "AS_REQ",
        "AS_RTM_RESULT",
        "BIDS_PUBLIC",
        "CMMT_RA_MLC",
        "CMMT_RMR",
        "CRR_CLEARING",
        "CRR_INVENTORY",
        "ENE_EA",
        "ENE_HASP",
        "ENE_IFM",
        "ENE_MPM",
        "ENE_RTM",
        "ENE_RUC",
        "LOSS_DA_HASP",
        "LOSS_RTM",
        "PRC_AS",
        "PRC_CNSTR",
        "PRC_FUEL",
        "PRC_HRLY_LMP",
        "PRC_INTVL_LMP",
        "SLD_FCST",
        "SLD_FCST_PEAK",
        "SLD_MKTS",
        "TRNS_ATC",
        "TRNS_OUTAGE",
        "TRNS_USAGE"
    )
    val AS_DA_RESULT: Fielder = parse_attribute (attribute (cls, fields(0)))
    val AS_OP_RSRV: Fielder = parse_attribute (attribute (cls, fields(1)))
    val AS_REQ: Fielder = parse_attribute (attribute (cls, fields(2)))
    val AS_RTM_RESULT: Fielder = parse_attribute (attribute (cls, fields(3)))
    val BIDS_PUBLIC: Fielder = parse_attribute (attribute (cls, fields(4)))
    val CMMT_RA_MLC: Fielder = parse_attribute (attribute (cls, fields(5)))
    val CMMT_RMR: Fielder = parse_attribute (attribute (cls, fields(6)))
    val CRR_CLEARING: Fielder = parse_attribute (attribute (cls, fields(7)))
    val CRR_INVENTORY: Fielder = parse_attribute (attribute (cls, fields(8)))
    val ENE_EA: Fielder = parse_attribute (attribute (cls, fields(9)))
    val ENE_HASP: Fielder = parse_attribute (attribute (cls, fields(10)))
    val ENE_IFM: Fielder = parse_attribute (attribute (cls, fields(11)))
    val ENE_MPM: Fielder = parse_attribute (attribute (cls, fields(12)))
    val ENE_RTM: Fielder = parse_attribute (attribute (cls, fields(13)))
    val ENE_RUC: Fielder = parse_attribute (attribute (cls, fields(14)))
    val LOSS_DA_HASP: Fielder = parse_attribute (attribute (cls, fields(15)))
    val LOSS_RTM: Fielder = parse_attribute (attribute (cls, fields(16)))
    val PRC_AS: Fielder = parse_attribute (attribute (cls, fields(17)))
    val PRC_CNSTR: Fielder = parse_attribute (attribute (cls, fields(18)))
    val PRC_FUEL: Fielder = parse_attribute (attribute (cls, fields(19)))
    val PRC_HRLY_LMP: Fielder = parse_attribute (attribute (cls, fields(20)))
    val PRC_INTVL_LMP: Fielder = parse_attribute (attribute (cls, fields(21)))
    val SLD_FCST: Fielder = parse_attribute (attribute (cls, fields(22)))
    val SLD_FCST_PEAK: Fielder = parse_attribute (attribute (cls, fields(23)))
    val SLD_MKTS: Fielder = parse_attribute (attribute (cls, fields(24)))
    val TRNS_ATC: Fielder = parse_attribute (attribute (cls, fields(25)))
    val TRNS_OUTAGE: Fielder = parse_attribute (attribute (cls, fields(26)))
    val TRNS_USAGE: Fielder = parse_attribute (attribute (cls, fields(27)))

    def parse (context: Context): OASISReportType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISReportType (
            BasicElement.parse (context),
            mask (AS_DA_RESULT (), 0),
            mask (AS_OP_RSRV (), 1),
            mask (AS_REQ (), 2),
            mask (AS_RTM_RESULT (), 3),
            mask (BIDS_PUBLIC (), 4),
            mask (CMMT_RA_MLC (), 5),
            mask (CMMT_RMR (), 6),
            mask (CRR_CLEARING (), 7),
            mask (CRR_INVENTORY (), 8),
            mask (ENE_EA (), 9),
            mask (ENE_HASP (), 10),
            mask (ENE_IFM (), 11),
            mask (ENE_MPM (), 12),
            mask (ENE_RTM (), 13),
            mask (ENE_RUC (), 14),
            mask (LOSS_DA_HASP (), 15),
            mask (LOSS_RTM (), 16),
            mask (PRC_AS (), 17),
            mask (PRC_CNSTR (), 18),
            mask (PRC_FUEL (), 19),
            mask (PRC_HRLY_LMP (), 20),
            mask (PRC_INTVL_LMP (), 21),
            mask (SLD_FCST (), 22),
            mask (SLD_FCST_PEAK (), 23),
            mask (SLD_MKTS (), 24),
            mask (TRNS_ATC (), 25),
            mask (TRNS_OUTAGE (), 26),
            mask (TRNS_USAGE (), 27)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISStatusType
(
    override val sup: BasicElement = null,
    Data_Transfer_Procedure_Initiated: String = null,
    Data_Transfer_Succesful: String = null,
    Forced_Termination: String = null,
    Obsolete: String = null,
    Push_Failed: String = null,
    Valid: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[OASISStatusType] }
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
        implicit val clz: String = OASISStatusType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISStatusType.fields (position), value)
        emitattr (0, Data_Transfer_Procedure_Initiated)
        emitattr (1, Data_Transfer_Succesful)
        emitattr (2, Forced_Termination)
        emitattr (3, Obsolete)
        emitattr (4, Push_Failed)
        emitattr (5, Valid)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISStatusType rdf:ID=\"%s\">\n%s\t</cim:OASISStatusType>".format (id, export_fields)
    }
}

object OASISStatusType
extends
    Parseable[OASISStatusType]
{
    override val fields: Array[String] = Array[String] (
        "Data_Transfer_Procedure_Initiated",
        "Data_Transfer_Succesful",
        "Forced_Termination",
        "Obsolete",
        "Push_Failed",
        "Valid"
    )
    val Data_Transfer_Procedure_Initiated: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Data_Transfer_Succesful: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Forced_Termination: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Obsolete: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Push_Failed: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Valid: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): OASISStatusType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISStatusType (
            BasicElement.parse (context),
            mask (Data_Transfer_Procedure_Initiated (), 0),
            mask (Data_Transfer_Succesful (), 1),
            mask (Forced_Termination (), 2),
            mask (Obsolete (), 3),
            mask (Push_Failed (), 4),
            mask (Valid (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * organization code
 *
 * @param sup Reference to the superclass object.
 * @param BILL_TO <em>undocumented</em>
 * @param PAY_TO <em>undocumented</em>
 * @param PROVIDED_BY <em>undocumented</em>
 * @param SOLD_TO <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OrganisationCode
(
    override val sup: BasicElement = null,
    BILL_TO: String = null,
    PAY_TO: String = null,
    PROVIDED_BY: String = null,
    SOLD_TO: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[OrganisationCode] }
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
        implicit val clz: String = OrganisationCode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OrganisationCode.fields (position), value)
        emitattr (0, BILL_TO)
        emitattr (1, PAY_TO)
        emitattr (2, PROVIDED_BY)
        emitattr (3, SOLD_TO)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OrganisationCode rdf:ID=\"%s\">\n%s\t</cim:OrganisationCode>".format (id, export_fields)
    }
}

object OrganisationCode
extends
    Parseable[OrganisationCode]
{
    override val fields: Array[String] = Array[String] (
        "BILL_TO",
        "PAY_TO",
        "PROVIDED_BY",
        "SOLD_TO"
    )
    val BILL_TO: Fielder = parse_attribute (attribute (cls, fields(0)))
    val PAY_TO: Fielder = parse_attribute (attribute (cls, fields(1)))
    val PROVIDED_BY: Fielder = parse_attribute (attribute (cls, fields(2)))
    val SOLD_TO: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): OrganisationCode =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OrganisationCode (
            BasicElement.parse (context),
            mask (BILL_TO (), 0),
            mask (PAY_TO (), 1),
            mask (PROVIDED_BY (), 2),
            mask (SOLD_TO (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * organization type
 *
 * @param sup Reference to the superclass object.
 * @param CUSTOMER <em>undocumented</em>
 * @param RTO <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OrganisationType
(
    override val sup: BasicElement = null,
    CUSTOMER: String = null,
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OrganisationType] }
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
        implicit val clz: String = OrganisationType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OrganisationType.fields (position), value)
        emitattr (0, CUSTOMER)
        emitattr (1, RTO)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OrganisationType rdf:ID=\"%s\">\n%s\t</cim:OrganisationType>".format (id, export_fields)
    }
}

object OrganisationType
extends
    Parseable[OrganisationType]
{
    override val fields: Array[String] = Array[String] (
        "CUSTOMER",
        "RTO"
    )
    val CUSTOMER: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): OrganisationType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OrganisationType (
            BasicElement.parse (context),
            mask (CUSTOMER (), 0),
            mask (RTO (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Y - indicates a resource is capable of setting the Markte Clearing Price
 * S - indicates the resource must submit bids for energy at \$ 0
 *
 * N - indicates the resource does not have to submit bids for energy at \$ 0
 *
 * @param sup Reference to the superclass object.
 * @param N <em>undocumented</em>
 * @param S <em>undocumented</em>
 * @param Y <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class PriceSetFlag
(
    override val sup: BasicElement = null,
    N: String = null,
    S: String = null,
    Y: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[PriceSetFlag] }
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
        implicit val clz: String = PriceSetFlag.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PriceSetFlag.fields (position), value)
        emitattr (0, N)
        emitattr (1, S)
        emitattr (2, Y)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PriceSetFlag rdf:ID=\"%s\">\n%s\t</cim:PriceSetFlag>".format (id, export_fields)
    }
}

object PriceSetFlag
extends
    Parseable[PriceSetFlag]
{
    override val fields: Array[String] = Array[String] (
        "N",
        "S",
        "Y"
    )
    val N: Fielder = parse_attribute (attribute (cls, fields(0)))
    val S: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Y: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): PriceSetFlag =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PriceSetFlag (
            BasicElement.parse (context),
            mask (N (), 0),
            mask (S (), 1),
            mask (Y (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * MP
 *
 * ISO
 *
 * @param sup Reference to the superclass object.
 * @param ISO <em>undocumented</em>
 * @param MP <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class RequestorRmrTest
(
    override val sup: BasicElement = null,
    ISO: String = null,
    MP: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[RequestorRmrTest] }
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
        implicit val clz: String = RequestorRmrTest.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RequestorRmrTest.fields (position), value)
        emitattr (0, ISO)
        emitattr (1, MP)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RequestorRmrTest rdf:ID=\"%s\">\n%s\t</cim:RequestorRmrTest>".format (id, export_fields)
    }
}

object RequestorRmrTest
extends
    Parseable[RequestorRmrTest]
{
    override val fields: Array[String] = Array[String] (
        "ISO",
        "MP"
    )
    val ISO: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MP: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): RequestorRmrTest =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RequestorRmrTest (
            BasicElement.parse (context),
            mask (ISO (), 0),
            mask (MP (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class ResourceCertificationCategory
(
    override val sup: BasicElement = null,
    DAM: String = null,
    GT: String = null,
    RC: String = null,
    RTM: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[ResourceCertificationCategory] }
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
        implicit val clz: String = ResourceCertificationCategory.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceCertificationCategory.fields (position), value)
        emitattr (0, DAM)
        emitattr (1, GT)
        emitattr (2, RC)
        emitattr (3, RTM)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceCertificationCategory rdf:ID=\"%s\">\n%s\t</cim:ResourceCertificationCategory>".format (id, export_fields)
    }
}

object ResourceCertificationCategory
extends
    Parseable[ResourceCertificationCategory]
{
    override val fields: Array[String] = Array[String] (
        "DAM",
        "GT",
        "RC",
        "RTM"
    )
    val DAM: Fielder = parse_attribute (attribute (cls, fields(0)))
    val GT: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RC: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RTM: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): ResourceCertificationCategory =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ResourceCertificationCategory (
            BasicElement.parse (context),
            mask (DAM (), 0),
            mask (GT (), 1),
            mask (RC (), 2),
            mask (RTM (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class ResourceCertificationType
(
    override val sup: BasicElement = null,
    GT: String = null,
    IR: String = null,
    NR: String = null,
    RG: String = null,
    SR: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[ResourceCertificationType] }
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
        implicit val clz: String = ResourceCertificationType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceCertificationType.fields (position), value)
        emitattr (0, GT)
        emitattr (1, IR)
        emitattr (2, NR)
        emitattr (3, RG)
        emitattr (4, SR)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceCertificationType rdf:ID=\"%s\">\n%s\t</cim:ResourceCertificationType>".format (id, export_fields)
    }
}

object ResourceCertificationType
extends
    Parseable[ResourceCertificationType]
{
    override val fields: Array[String] = Array[String] (
        "GT",
        "IR",
        "NR",
        "RG",
        "SR"
    )
    val GT: Fielder = parse_attribute (attribute (cls, fields(0)))
    val IR: Fielder = parse_attribute (attribute (cls, fields(1)))
    val NR: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RG: Fielder = parse_attribute (attribute (cls, fields(3)))
    val SR: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): ResourceCertificationType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ResourceCertificationType (
            BasicElement.parse (context),
            mask (GT (), 0),
            mask (IR (), 1),
            mask (NR (), 2),
            mask (RG (), 3),
            mask (SR (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SchedClassType
(
    override val sup: BasicElement = null,
    F: String = null,
    P: String = null,
    R: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[SchedClassType] }
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
        implicit val clz: String = SchedClassType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SchedClassType.fields (position), value)
        emitattr (0, F)
        emitattr (1, P)
        emitattr (2, R)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SchedClassType rdf:ID=\"%s\">\n%s\t</cim:SchedClassType>".format (id, export_fields)
    }
}

object SchedClassType
extends
    Parseable[SchedClassType]
{
    override val fields: Array[String] = Array[String] (
        "F",
        "P",
        "R"
    )
    val F: Fielder = parse_attribute (attribute (cls, fields(0)))
    val P: Fielder = parse_attribute (attribute (cls, fields(1)))
    val R: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): SchedClassType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SchedClassType (
            BasicElement.parse (context),
            mask (F (), 0),
            mask (P (), 1),
            mask (R (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SegmentCurveType
(
    override val sup: BasicElement = null,
    CONSULTATIVE: String = null,
    COST: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[SegmentCurveType] }
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
        implicit val clz: String = SegmentCurveType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SegmentCurveType.fields (position), value)
        emitattr (0, CONSULTATIVE)
        emitattr (1, COST)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SegmentCurveType rdf:ID=\"%s\">\n%s\t</cim:SegmentCurveType>".format (id, export_fields)
    }
}

object SegmentCurveType
extends
    Parseable[SegmentCurveType]
{
    override val fields: Array[String] = Array[String] (
        "CONSULTATIVE",
        "COST"
    )
    val CONSULTATIVE: Fielder = parse_attribute (attribute (cls, fields(0)))
    val COST: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): SegmentCurveType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SegmentCurveType (
            BasicElement.parse (context),
            mask (CONSULTATIVE (), 0),
            mask (COST (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SelfSchedTypeCleanBid
(
    override val sup: BasicElement = null,
    BAS: String = null,
    ETC: String = null,
    IFM: String = null,
    LOF: String = null,
    LPT: String = null,
    PT: String = null,
    RA: String = null,
    RMT: String = null,
    SP: String = null,
    TOR: String = null,
    WHL: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[SelfSchedTypeCleanBid] }
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
        implicit val clz: String = SelfSchedTypeCleanBid.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SelfSchedTypeCleanBid.fields (position), value)
        emitattr (0, BAS)
        emitattr (1, ETC)
        emitattr (2, IFM)
        emitattr (3, LOF)
        emitattr (4, LPT)
        emitattr (5, PT)
        emitattr (6, RA)
        emitattr (7, RMT)
        emitattr (8, SP)
        emitattr (9, TOR)
        emitattr (10, WHL)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SelfSchedTypeCleanBid rdf:ID=\"%s\">\n%s\t</cim:SelfSchedTypeCleanBid>".format (id, export_fields)
    }
}

object SelfSchedTypeCleanBid
extends
    Parseable[SelfSchedTypeCleanBid]
{
    override val fields: Array[String] = Array[String] (
        "BAS",
        "ETC",
        "IFM",
        "LOF",
        "LPT",
        "PT",
        "RA",
        "RMT",
        "SP",
        "TOR",
        "WHL"
    )
    val BAS: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ETC: Fielder = parse_attribute (attribute (cls, fields(1)))
    val IFM: Fielder = parse_attribute (attribute (cls, fields(2)))
    val LOF: Fielder = parse_attribute (attribute (cls, fields(3)))
    val LPT: Fielder = parse_attribute (attribute (cls, fields(4)))
    val PT: Fielder = parse_attribute (attribute (cls, fields(5)))
    val RA: Fielder = parse_attribute (attribute (cls, fields(6)))
    val RMT: Fielder = parse_attribute (attribute (cls, fields(7)))
    val SP: Fielder = parse_attribute (attribute (cls, fields(8)))
    val TOR: Fielder = parse_attribute (attribute (cls, fields(9)))
    val WHL: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: Context): SelfSchedTypeCleanBid =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SelfSchedTypeCleanBid (
            BasicElement.parse (context),
            mask (BAS (), 0),
            mask (ETC (), 1),
            mask (IFM (), 2),
            mask (LOF (), 3),
            mask (LPT (), 4),
            mask (PT (), 5),
            mask (RA (), 6),
            mask (RMT (), 7),
            mask (SP (), 8),
            mask (TOR (), 9),
            mask (WHL (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SelfSchedTypeRawBid
(
    override val sup: BasicElement = null,
    BAS: String = null,
    ETC: String = null,
    LOF: String = null,
    LPT: String = null,
    PT: String = null,
    RA: String = null,
    RMT: String = null,
    SP: String = null,
    TOR: String = null,
    WHL: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[SelfSchedTypeRawBid] }
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
        implicit val clz: String = SelfSchedTypeRawBid.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SelfSchedTypeRawBid.fields (position), value)
        emitattr (0, BAS)
        emitattr (1, ETC)
        emitattr (2, LOF)
        emitattr (3, LPT)
        emitattr (4, PT)
        emitattr (5, RA)
        emitattr (6, RMT)
        emitattr (7, SP)
        emitattr (8, TOR)
        emitattr (9, WHL)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SelfSchedTypeRawBid rdf:ID=\"%s\">\n%s\t</cim:SelfSchedTypeRawBid>".format (id, export_fields)
    }
}

object SelfSchedTypeRawBid
extends
    Parseable[SelfSchedTypeRawBid]
{
    override val fields: Array[String] = Array[String] (
        "BAS",
        "ETC",
        "LOF",
        "LPT",
        "PT",
        "RA",
        "RMT",
        "SP",
        "TOR",
        "WHL"
    )
    val BAS: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ETC: Fielder = parse_attribute (attribute (cls, fields(1)))
    val LOF: Fielder = parse_attribute (attribute (cls, fields(2)))
    val LPT: Fielder = parse_attribute (attribute (cls, fields(3)))
    val PT: Fielder = parse_attribute (attribute (cls, fields(4)))
    val RA: Fielder = parse_attribute (attribute (cls, fields(5)))
    val RMT: Fielder = parse_attribute (attribute (cls, fields(6)))
    val SP: Fielder = parse_attribute (attribute (cls, fields(7)))
    val TOR: Fielder = parse_attribute (attribute (cls, fields(8)))
    val WHL: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: Context): SelfSchedTypeRawBid =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SelfSchedTypeRawBid (
            BasicElement.parse (context),
            mask (BAS (), 0),
            mask (ETC (), 1),
            mask (LOF (), 2),
            mask (LPT (), 3),
            mask (PT (), 4),
            mask (RA (), 5),
            mask (RMT (), 6),
            mask (SP (), 7),
            mask (TOR (), 8),
            mask (WHL (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * self schedule types
 * 
 * PT
 * ETC
 * TOR
 * RMR
 * RMT
 * RGMR
 * ORFC
 *
 * SP
 *
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
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SelfScheduleType
(
    override val sup: BasicElement = null,
    BAS: String = null,
    ETC: String = null,
    IFM: String = null,
    LOF: String = null,
    ORFC: String = null,
    PT: String = null,
    PUMP_ETC: String = null,
    PUMP_TOR: String = null,
    RA: String = null,
    RGMR: String = null,
    RMR: String = null,
    RMT: String = null,
    RUC: String = null,
    SP: String = null,
    TOR: String = null,
    WHL: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[SelfScheduleType] }
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
        implicit val clz: String = SelfScheduleType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SelfScheduleType.fields (position), value)
        emitattr (0, BAS)
        emitattr (1, ETC)
        emitattr (2, IFM)
        emitattr (3, LOF)
        emitattr (4, ORFC)
        emitattr (5, PT)
        emitattr (6, PUMP_ETC)
        emitattr (7, PUMP_TOR)
        emitattr (8, RA)
        emitattr (9, RGMR)
        emitattr (10, RMR)
        emitattr (11, RMT)
        emitattr (12, RUC)
        emitattr (13, SP)
        emitattr (14, TOR)
        emitattr (15, WHL)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SelfScheduleType rdf:ID=\"%s\">\n%s\t</cim:SelfScheduleType>".format (id, export_fields)
    }
}

object SelfScheduleType
extends
    Parseable[SelfScheduleType]
{
    override val fields: Array[String] = Array[String] (
        "BAS",
        "ETC",
        "IFM",
        "LOF",
        "ORFC",
        "PT",
        "PUMP_ETC",
        "PUMP_TOR",
        "RA",
        "RGMR",
        "RMR",
        "RMT",
        "RUC",
        "SP",
        "TOR",
        "WHL"
    )
    val BAS: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ETC: Fielder = parse_attribute (attribute (cls, fields(1)))
    val IFM: Fielder = parse_attribute (attribute (cls, fields(2)))
    val LOF: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ORFC: Fielder = parse_attribute (attribute (cls, fields(4)))
    val PT: Fielder = parse_attribute (attribute (cls, fields(5)))
    val PUMP_ETC: Fielder = parse_attribute (attribute (cls, fields(6)))
    val PUMP_TOR: Fielder = parse_attribute (attribute (cls, fields(7)))
    val RA: Fielder = parse_attribute (attribute (cls, fields(8)))
    val RGMR: Fielder = parse_attribute (attribute (cls, fields(9)))
    val RMR: Fielder = parse_attribute (attribute (cls, fields(10)))
    val RMT: Fielder = parse_attribute (attribute (cls, fields(11)))
    val RUC: Fielder = parse_attribute (attribute (cls, fields(12)))
    val SP: Fielder = parse_attribute (attribute (cls, fields(13)))
    val TOR: Fielder = parse_attribute (attribute (cls, fields(14)))
    val WHL: Fielder = parse_attribute (attribute (cls, fields(15)))

    def parse (context: Context): SelfScheduleType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SelfScheduleType (
            BasicElement.parse (context),
            mask (BAS (), 0),
            mask (ETC (), 1),
            mask (IFM (), 2),
            mask (LOF (), 3),
            mask (ORFC (), 4),
            mask (PT (), 5),
            mask (PUMP_ETC (), 6),
            mask (PUMP_TOR (), 7),
            mask (RA (), 8),
            mask (RGMR (), 9),
            mask (RMR (), 10),
            mask (RMT (), 11),
            mask (RUC (), 12),
            mask (SP (), 13),
            mask (TOR (), 14),
            mask (WHL (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Self Schedule Types applicable to Mitigated Bid
 *
 * @param sup Reference to the superclass object.
 * @param RMR <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SelfScheduleTypeMB
(
    override val sup: BasicElement = null,
    RMR: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[SelfScheduleTypeMB] }
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
        implicit val clz: String = SelfScheduleTypeMB.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SelfScheduleTypeMB.fields (position), value)
        emitattr (0, RMR)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SelfScheduleTypeMB rdf:ID=\"%s\">\n%s\t</cim:SelfScheduleTypeMB>".format (id, export_fields)
    }
}

object SelfScheduleTypeMB
extends
    Parseable[SelfScheduleTypeMB]
{
    override val fields: Array[String] = Array[String] (
        "RMR"
    )
    val RMR: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): SelfScheduleTypeMB =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SelfScheduleTypeMB (
            BasicElement.parse (context),
            mask (RMR (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SourceSinkFlag
(
    override val sup: BasicElement = null,
    CSNK: String = null,
    CSRC: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[SourceSinkFlag] }
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
        implicit val clz: String = SourceSinkFlag.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SourceSinkFlag.fields (position), value)
        emitattr (0, CSNK)
        emitattr (1, CSRC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SourceSinkFlag rdf:ID=\"%s\">\n%s\t</cim:SourceSinkFlag>".format (id, export_fields)
    }
}

object SourceSinkFlag
extends
    Parseable[SourceSinkFlag]
{
    override val fields: Array[String] = Array[String] (
        "CSNK",
        "CSRC"
    )
    val CSNK: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CSRC: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): SourceSinkFlag =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SourceSinkFlag (
            BasicElement.parse (context),
            mask (CSNK (), 0),
            mask (CSRC (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SourceSinkType
(
    override val sup: BasicElement = null,
    Neither: String = null,
    Sink: String = null,
    Source: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[SourceSinkType] }
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
        implicit val clz: String = SourceSinkType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SourceSinkType.fields (position), value)
        emitattr (0, Neither)
        emitattr (1, Sink)
        emitattr (2, Source)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SourceSinkType rdf:ID=\"%s\">\n%s\t</cim:SourceSinkType>".format (id, export_fields)
    }
}

object SourceSinkType
extends
    Parseable[SourceSinkType]
{
    override val fields: Array[String] = Array[String] (
        "Neither",
        "Sink",
        "Source"
    )
    val Neither: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Sink: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Source: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): SourceSinkType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SourceSinkType (
            BasicElement.parse (context),
            mask (Neither (), 0),
            mask (Sink (), 1),
            mask (Source (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SpinningEventNameType
(
    override val sup: BasicElement = null,
    EASTERN: String = null,
    PJM: String = null,
    RFC_SR: String = null,
    SOUTH_S: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[SpinningEventNameType] }
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
        implicit val clz: String = SpinningEventNameType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SpinningEventNameType.fields (position), value)
        emitattr (0, EASTERN)
        emitattr (1, PJM)
        emitattr (2, RFC_SR)
        emitattr (3, SOUTH_S)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SpinningEventNameType rdf:ID=\"%s\">\n%s\t</cim:SpinningEventNameType>".format (id, export_fields)
    }
}

object SpinningEventNameType
extends
    Parseable[SpinningEventNameType]
{
    override val fields: Array[String] = Array[String] (
        "EASTERN",
        "PJM",
        "RFC-SR",
        "SOUTH-S"
    )
    val EASTERN: Fielder = parse_attribute (attribute (cls, fields(0)))
    val PJM: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RFC_SR: Fielder = parse_attribute (attribute (cls, fields(2)))
    val SOUTH_S: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): SpinningEventNameType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SpinningEventNameType (
            BasicElement.parse (context),
            mask (EASTERN (), 0),
            mask (PJM (), 1),
            mask (RFC_SR (), 2),
            mask (SOUTH_S (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SpinningEventType
(
    override val sup: BasicElement = null,
    AA: String = null,
    CA: String = null,
    RZ: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[SpinningEventType] }
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
        implicit val clz: String = SpinningEventType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SpinningEventType.fields (position), value)
        emitattr (0, AA)
        emitattr (1, CA)
        emitattr (2, RZ)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SpinningEventType rdf:ID=\"%s\">\n%s\t</cim:SpinningEventType>".format (id, export_fields)
    }
}

object SpinningEventType
extends
    Parseable[SpinningEventType]
{
    override val fields: Array[String] = Array[String] (
        "AA",
        "CA",
        "RZ"
    )
    val AA: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CA: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RZ: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): SpinningEventType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SpinningEventType (
            BasicElement.parse (context),
            mask (AA (), 0),
            mask (CA (), 1),
            mask (RZ (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SystemType
(
    override val sup: BasicElement = null,
    OASIS: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[SystemType] }
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
        implicit val clz: String = SystemType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SystemType.fields (position), value)
        emitattr (0, OASIS)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SystemType rdf:ID=\"%s\">\n%s\t</cim:SystemType>".format (id, export_fields)
    }
}

object SystemType
extends
    Parseable[SystemType]
{
    override val fields: Array[String] = Array[String] (
        "OASIS"
    )
    val OASIS: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): SystemType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SystemType (
            BasicElement.parse (context),
            mask (OASIS (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class TimeZoneType
(
    override val sup: BasicElement = null,
    PPT: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[TimeZoneType] }
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
        implicit val clz: String = TimeZoneType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TimeZoneType.fields (position), value)
        emitattr (0, PPT)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TimeZoneType rdf:ID=\"%s\">\n%s\t</cim:TimeZoneType>".format (id, export_fields)
    }
}

object TimeZoneType
extends
    Parseable[TimeZoneType]
{
    override val fields: Array[String] = Array[String] (
        "PPT"
    )
    val PPT: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): TimeZoneType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TimeZoneType (
            BasicElement.parse (context),
            mask (PPT (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class TradeProductType
(
    override val sup: BasicElement = null,
    APN: String = null,
    CAP: String = null,
    NRT: String = null,
    PHY: String = null,
    RDT: String = null,
    RUT: String = null,
    SRT: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[TradeProductType] }
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
        implicit val clz: String = TradeProductType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TradeProductType.fields (position), value)
        emitattr (0, APN)
        emitattr (1, CAP)
        emitattr (2, NRT)
        emitattr (3, PHY)
        emitattr (4, RDT)
        emitattr (5, RUT)
        emitattr (6, SRT)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TradeProductType rdf:ID=\"%s\">\n%s\t</cim:TradeProductType>".format (id, export_fields)
    }
}

object TradeProductType
extends
    Parseable[TradeProductType]
{
    override val fields: Array[String] = Array[String] (
        "APN",
        "CAP",
        "NRT",
        "PHY",
        "RDT",
        "RUT",
        "SRT"
    )
    val APN: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CAP: Fielder = parse_attribute (attribute (cls, fields(1)))
    val NRT: Fielder = parse_attribute (attribute (cls, fields(2)))
    val PHY: Fielder = parse_attribute (attribute (cls, fields(3)))
    val RDT: Fielder = parse_attribute (attribute (cls, fields(4)))
    val RUT: Fielder = parse_attribute (attribute (cls, fields(5)))
    val SRT: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): TradeProductType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TradeProductType (
            BasicElement.parse (context),
            mask (APN (), 0),
            mask (CAP (), 1),
            mask (NRT (), 2),
            mask (PHY (), 3),
            mask (RDT (), 4),
            mask (RUT (), 5),
            mask (SRT (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class UOMType
(
    override val sup: BasicElement = null,
    percent: String = null,
    $_lb: String = null,
    $_mmBTU: String = null,
    FACTOR: String = null,
    FLAG: String = null,
    INTEGER: String = null,
    MW: String = null,
    MWh: String = null,
    US$: String = null,
    US$_MW: String = null,
    US$_MWh: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[UOMType] }
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
        implicit val clz: String = UOMType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (UOMType.fields (position), value)
        emitattr (0, percent)
        emitattr (1, $_lb)
        emitattr (2, $_mmBTU)
        emitattr (3, FACTOR)
        emitattr (4, FLAG)
        emitattr (5, INTEGER)
        emitattr (6, MW)
        emitattr (7, MWh)
        emitattr (8, US$)
        emitattr (9, US$_MW)
        emitattr (10, US$_MWh)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UOMType rdf:ID=\"%s\">\n%s\t</cim:UOMType>".format (id, export_fields)
    }
}

object UOMType
extends
    Parseable[UOMType]
{
    override val fields: Array[String] = Array[String] (
        "%",
        "$/lb",
        "$/mmBTU",
        "FACTOR",
        "FLAG",
        "INTEGER",
        "MW",
        "MWh",
        "US$",
        "US$/MW",
        "US$/MWh"
    )
    val percent: Fielder = parse_attribute (attribute (cls, fields(0)))
    val $_lb: Fielder = parse_attribute (attribute (cls, fields(1)))
    val $_mmBTU: Fielder = parse_attribute (attribute (cls, fields(2)))
    val FACTOR: Fielder = parse_attribute (attribute (cls, fields(3)))
    val FLAG: Fielder = parse_attribute (attribute (cls, fields(4)))
    val INTEGER: Fielder = parse_attribute (attribute (cls, fields(5)))
    val MW: Fielder = parse_attribute (attribute (cls, fields(6)))
    val MWh: Fielder = parse_attribute (attribute (cls, fields(7)))
    val US$: Fielder = parse_attribute (attribute (cls, fields(8)))
    val US$_MW: Fielder = parse_attribute (attribute (cls, fields(9)))
    val US$_MWh: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: Context): UOMType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UOMType (
            BasicElement.parse (context),
            mask (percent (), 0),
            mask ($_lb (), 1),
            mask ($_mmBTU (), 2),
            mask (FACTOR (), 3),
            mask (FLAG (), 4),
            mask (INTEGER (), 5),
            mask (MW (), 6),
            mask (MWh (), 7),
            mask (US$ (), 8),
            mask (US$_MW (), 9),
            mask (US$_MWh (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * MW
 *
 * FLAG
 *
 * @param sup Reference to the superclass object.
 * @param FLAG <em>undocumented</em>
 * @param MW <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class UnitTypeEMS
(
    override val sup: BasicElement = null,
    FLAG: String = null,
    MW: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[UnitTypeEMS] }
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
        implicit val clz: String = UnitTypeEMS.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (UnitTypeEMS.fields (position), value)
        emitattr (0, FLAG)
        emitattr (1, MW)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UnitTypeEMS rdf:ID=\"%s\">\n%s\t</cim:UnitTypeEMS>".format (id, export_fields)
    }
}

object UnitTypeEMS
extends
    Parseable[UnitTypeEMS]
{
    override val fields: Array[String] = Array[String] (
        "FLAG",
        "MW"
    )
    val FLAG: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MW: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): UnitTypeEMS =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UnitTypeEMS (
            BasicElement.parse (context),
            mask (FLAG (), 0),
            mask (MW (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * zone type
 *
 * @param sup Reference to the superclass object.
 * @param ASREGION ancillary service region
 * @param DCA designated congestion area
 * @param LOADZONE load zone
 * @param RUCZONE RUC zone
 * @param TRADINGHUB trading hub
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class ZoneType
(
    override val sup: BasicElement = null,
    ASREGION: String = null,
    DCA: String = null,
    LOADZONE: String = null,
    RUCZONE: String = null,
    TRADINGHUB: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[ZoneType] }
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
        implicit val clz: String = ZoneType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ZoneType.fields (position), value)
        emitattr (0, ASREGION)
        emitattr (1, DCA)
        emitattr (2, LOADZONE)
        emitattr (3, RUCZONE)
        emitattr (4, TRADINGHUB)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ZoneType rdf:ID=\"%s\">\n%s\t</cim:ZoneType>".format (id, export_fields)
    }
}

object ZoneType
extends
    Parseable[ZoneType]
{
    override val fields: Array[String] = Array[String] (
        "ASREGION",
        "DCA",
        "LOADZONE",
        "RUCZONE",
        "TRADINGHUB"
    )
    val ASREGION: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DCA: Fielder = parse_attribute (attribute (cls, fields(1)))
    val LOADZONE: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RUCZONE: Fielder = parse_attribute (attribute (cls, fields(3)))
    val TRADINGHUB: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): ZoneType =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ZoneType (
            BasicElement.parse (context),
            mask (ASREGION (), 0),
            mask (DCA (), 1),
            mask (LOADZONE (), 2),
            mask (RUCZONE (), 3),
            mask (TRADINGHUB (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * S - Scheduling
 *
 * P - Pricing
 *
 * @param sup Reference to the superclass object.
 * @param P <em>undocumented</em>
 * @param S <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class runTypeCAISO
(
    override val sup: BasicElement = null,
    P: String = null,
    S: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[runTypeCAISO] }
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
        implicit val clz: String = runTypeCAISO.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (runTypeCAISO.fields (position), value)
        emitattr (0, P)
        emitattr (1, S)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:runTypeCAISO rdf:ID=\"%s\">\n%s\t</cim:runTypeCAISO>".format (id, export_fields)
    }
}

object runTypeCAISO
extends
    Parseable[runTypeCAISO]
{
    override val fields: Array[String] = Array[String] (
        "P",
        "S"
    )
    val P: Fielder = parse_attribute (attribute (cls, fields(0)))
    val S: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): runTypeCAISO =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = runTypeCAISO (
            BasicElement.parse (context),
            mask (P (), 0),
            mask (S (), 1)
        )
        ret.bitfields = bitfields
        ret
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
            UOMType.register,
            UnitTypeEMS.register,
            ZoneType.register,
            runTypeCAISO.register
        )
    }
}