package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Catalogue of available types of products and materials that are used to build or install, maintain or operate an Asset.
 *
 * Each catalogue item is for a specific product (AssetModel) available from a specific supplier.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
case class AssetModelCatalogue
(
    override val sup: IdentifiedObject,
    status: String
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
    override def copy (): Row = { clone ().asInstanceOf[AssetModelCatalogue] }
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
        implicit val clz: String = AssetModelCatalogue.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AssetModelCatalogue.fields (position), value)
        emitattr (0, status)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetModelCatalogue rdf:ID=\"%s\">\n%s\t</cim:AssetModelCatalogue>".format (id, export_fields)
    }
}

object AssetModelCatalogue
extends
    Parseable[AssetModelCatalogue]
{
    val fields: Array[String] = Array[String] (
        "status"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): AssetModelCatalogue =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AssetModelCatalogue (
            IdentifiedObject.parse (context),
            mask (status (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Provides pricing and other relevant information about a specific manufacturer's product (i.e., AssetModel), and its price from a given supplier.
 *
 * A single AssetModel may be availble from multiple suppliers. Note that manufacturer and supplier are both types of organisation, which the association is inherited from Document.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param unitCost Unit cost for an asset model from a specific supplier, either for a unit cost or cost per unit length.
 *        Cost is for material or asset only and does not include labor to install/construct or configure it.
 * @param AssetModel [[ch.ninecode.model.ProductAssetModel ProductAssetModel]] <em>undocumented</em>
 * @param AssetModelCatalogue [[ch.ninecode.model.AssetModelCatalogue AssetModelCatalogue]] <em>undocumented</em>
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
case class AssetModelCatalogueItem
(
    override val sup: Document,
    unitCost: Double,
    AssetModel: String,
    AssetModelCatalogue: String
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[AssetModelCatalogueItem] }
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
        implicit val clz: String = AssetModelCatalogueItem.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AssetModelCatalogueItem.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AssetModelCatalogueItem.fields (position), value)
        emitelem (0, unitCost)
        emitattr (1, AssetModel)
        emitattr (2, AssetModelCatalogue)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetModelCatalogueItem rdf:ID=\"%s\">\n%s\t</cim:AssetModelCatalogueItem>".format (id, export_fields)
    }
}

object AssetModelCatalogueItem
extends
    Parseable[AssetModelCatalogueItem]
{
    val fields: Array[String] = Array[String] (
        "unitCost",
        "AssetModel",
        "AssetModelCatalogue"
    )
    val unitCost: Fielder = parse_element (element (cls, fields(0)))
    val AssetModel: Fielder = parse_attribute (attribute (cls, fields(1)))
    val AssetModelCatalogue: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): AssetModelCatalogueItem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AssetModelCatalogueItem (
            Document.parse (context),
            toDouble (mask (unitCost (), 0)),
            mask (AssetModel (), 1),
            mask (AssetModelCatalogue (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AssetModel", "ProductAssetModel", false),
        Relationship ("AssetModelCatalogue", "AssetModelCatalogue", false)
    )
}

/**
 * Properties of breaker assets.
 *
 * @param sup [[ch.ninecode.model.OldSwitchInfo OldSwitchInfo]] Reference to the superclass object.
 * @param phaseTrip Phase trip rating.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
case class BreakerInfo
(
    override val sup: OldSwitchInfo,
    phaseTrip: Double
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
    def OldSwitchInfo: OldSwitchInfo = sup.asInstanceOf[OldSwitchInfo]
    override def copy (): Row = { clone ().asInstanceOf[BreakerInfo] }
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
        implicit val clz: String = BreakerInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BreakerInfo.fields (position), value)
        emitelem (0, phaseTrip)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BreakerInfo rdf:ID=\"%s\">\n%s\t</cim:BreakerInfo>".format (id, export_fields)
    }
}

object BreakerInfo
extends
    Parseable[BreakerInfo]
{
    val fields: Array[String] = Array[String] (
        "phaseTrip"
    )
    val phaseTrip: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): BreakerInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BreakerInfo (
            OldSwitchInfo.parse (context),
            toDouble (mask (phaseTrip (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Properties of a composite switch.
 *
 * @param sup [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param ganged True if multi-phase switch controls all phases concurrently.
 * @param initOpMode Initial operating mode, with the following values: Automatic, Manual.
 * @param interruptingRating Breaking capacity, or short circuit rating, is the maximum rated current which the device can safely interrupt at the rated voltage.
 * @param kind Kind of composite switch.
 * @param phaseCode Phases carried, if applicable.
 * @param phaseCount Supported number of phases, typically 0, 1 or 3.
 * @param ratedVoltage Rated voltage.
 * @param remote True if device is capable of being operated by remote control.
 * @param switchStateCount Number of switch states represented by the composite switch.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
case class CompositeSwitchInfo
(
    override val sup: AssetInfo,
    ganged: Boolean,
    initOpMode: String,
    interruptingRating: Double,
    kind: String,
    phaseCode: String,
    phaseCount: Int,
    ratedVoltage: Double,
    remote: Boolean,
    switchStateCount: Int
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null, 0.0, null, null, 0, 0.0, false, 0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { clone ().asInstanceOf[CompositeSwitchInfo] }
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
        implicit val clz: String = CompositeSwitchInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CompositeSwitchInfo.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CompositeSwitchInfo.fields (position), value)
        emitelem (0, ganged)
        emitelem (1, initOpMode)
        emitelem (2, interruptingRating)
        emitattr (3, kind)
        emitattr (4, phaseCode)
        emitelem (5, phaseCount)
        emitelem (6, ratedVoltage)
        emitelem (7, remote)
        emitelem (8, switchStateCount)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CompositeSwitchInfo rdf:ID=\"%s\">\n%s\t</cim:CompositeSwitchInfo>".format (id, export_fields)
    }
}

object CompositeSwitchInfo
extends
    Parseable[CompositeSwitchInfo]
{
    val fields: Array[String] = Array[String] (
        "ganged",
        "initOpMode",
        "interruptingRating",
        "kind",
        "phaseCode",
        "phaseCount",
        "ratedVoltage",
        "remote",
        "switchStateCount"
    )
    val ganged: Fielder = parse_element (element (cls, fields(0)))
    val initOpMode: Fielder = parse_element (element (cls, fields(1)))
    val interruptingRating: Fielder = parse_element (element (cls, fields(2)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(3)))
    val phaseCode: Fielder = parse_attribute (attribute (cls, fields(4)))
    val phaseCount: Fielder = parse_element (element (cls, fields(5)))
    val ratedVoltage: Fielder = parse_element (element (cls, fields(6)))
    val remote: Fielder = parse_element (element (cls, fields(7)))
    val switchStateCount: Fielder = parse_element (element (cls, fields(8)))

    def parse (context: Context): CompositeSwitchInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CompositeSwitchInfo (
            AssetInfo.parse (context),
            toBoolean (mask (ganged (), 0)),
            mask (initOpMode (), 1),
            toDouble (mask (interruptingRating (), 2)),
            mask (kind (), 3),
            mask (phaseCode (), 4),
            toInteger (mask (phaseCount (), 5)),
            toDouble (mask (ratedVoltage (), 6)),
            toBoolean (mask (remote (), 7)),
            toInteger (mask (switchStateCount (), 8))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Properties of current transformer asset.
 *
 * @param sup [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param accuracyClass CT accuracy classification.
 * @param accuracyLimit Accuracy limit.
 * @param coreCount Number of cores.
 * @param ctClass <em>undocumented</em>
 * @param kneePointCurrent Maximum primary current where the CT still displays linear characteristicts.
 * @param kneePointVoltage Maximum voltage across the secondary terminals where the CT still displays linear characteristicts.
 * @param maxRatio Maximum ratio between the primary and secondary current.
 * @param nominalRatio Nominal ratio between the primary and secondary current; i.e. 100:5.
 * @param primaryFlsRating Full load secondary (FLS) rating for primary winding.
 * @param primaryRatio Ratio for the primary winding tap changer.
 * @param ratedCurrent Rated current on the primary side.
 * @param secondaryFlsRating Full load secondary (FLS) rating for secondary winding.
 * @param secondaryRatio Ratio for the secondary winding tap changer.
 * @param tertiaryFlsRating Full load secondary (FLS) rating for tertiary winding.
 * @param tertiaryRatio Ratio for the tertiary winding tap changer.
 * @param usage Usage: eg. metering, protection, etc.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
case class CurrentTransformerInfo
(
    override val sup: AssetInfo,
    accuracyClass: String,
    accuracyLimit: Double,
    coreCount: Int,
    ctClass: String,
    kneePointCurrent: Double,
    kneePointVoltage: Double,
    maxRatio: String,
    nominalRatio: String,
    primaryFlsRating: Double,
    primaryRatio: String,
    ratedCurrent: Double,
    secondaryFlsRating: Double,
    secondaryRatio: String,
    tertiaryFlsRating: Double,
    tertiaryRatio: String,
    usage: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0, null, 0.0, 0.0, null, null, 0.0, null, 0.0, 0.0, null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { clone ().asInstanceOf[CurrentTransformerInfo] }
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
        implicit val clz: String = CurrentTransformerInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CurrentTransformerInfo.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CurrentTransformerInfo.fields (position), value)
        emitelem (0, accuracyClass)
        emitelem (1, accuracyLimit)
        emitelem (2, coreCount)
        emitelem (3, ctClass)
        emitelem (4, kneePointCurrent)
        emitelem (5, kneePointVoltage)
        emitattr (6, maxRatio)
        emitattr (7, nominalRatio)
        emitelem (8, primaryFlsRating)
        emitattr (9, primaryRatio)
        emitelem (10, ratedCurrent)
        emitelem (11, secondaryFlsRating)
        emitattr (12, secondaryRatio)
        emitelem (13, tertiaryFlsRating)
        emitattr (14, tertiaryRatio)
        emitelem (15, usage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CurrentTransformerInfo rdf:ID=\"%s\">\n%s\t</cim:CurrentTransformerInfo>".format (id, export_fields)
    }
}

object CurrentTransformerInfo
extends
    Parseable[CurrentTransformerInfo]
{
    val fields: Array[String] = Array[String] (
        "accuracyClass",
        "accuracyLimit",
        "coreCount",
        "ctClass",
        "kneePointCurrent",
        "kneePointVoltage",
        "maxRatio",
        "nominalRatio",
        "primaryFlsRating",
        "primaryRatio",
        "ratedCurrent",
        "secondaryFlsRating",
        "secondaryRatio",
        "tertiaryFlsRating",
        "tertiaryRatio",
        "usage"
    )
    val accuracyClass: Fielder = parse_element (element (cls, fields(0)))
    val accuracyLimit: Fielder = parse_element (element (cls, fields(1)))
    val coreCount: Fielder = parse_element (element (cls, fields(2)))
    val ctClass: Fielder = parse_element (element (cls, fields(3)))
    val kneePointCurrent: Fielder = parse_element (element (cls, fields(4)))
    val kneePointVoltage: Fielder = parse_element (element (cls, fields(5)))
    val maxRatio: Fielder = parse_attribute (attribute (cls, fields(6)))
    val nominalRatio: Fielder = parse_attribute (attribute (cls, fields(7)))
    val primaryFlsRating: Fielder = parse_element (element (cls, fields(8)))
    val primaryRatio: Fielder = parse_attribute (attribute (cls, fields(9)))
    val ratedCurrent: Fielder = parse_element (element (cls, fields(10)))
    val secondaryFlsRating: Fielder = parse_element (element (cls, fields(11)))
    val secondaryRatio: Fielder = parse_attribute (attribute (cls, fields(12)))
    val tertiaryFlsRating: Fielder = parse_element (element (cls, fields(13)))
    val tertiaryRatio: Fielder = parse_attribute (attribute (cls, fields(14)))
    val usage: Fielder = parse_element (element (cls, fields(15)))

    def parse (context: Context): CurrentTransformerInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CurrentTransformerInfo (
            AssetInfo.parse (context),
            mask (accuracyClass (), 0),
            toDouble (mask (accuracyLimit (), 1)),
            toInteger (mask (coreCount (), 2)),
            mask (ctClass (), 3),
            toDouble (mask (kneePointCurrent (), 4)),
            toDouble (mask (kneePointVoltage (), 5)),
            mask (maxRatio (), 6),
            mask (nominalRatio (), 7),
            toDouble (mask (primaryFlsRating (), 8)),
            mask (primaryRatio (), 9),
            toDouble (mask (ratedCurrent (), 10)),
            toDouble (mask (secondaryFlsRating (), 11)),
            mask (secondaryRatio (), 12),
            toDouble (mask (tertiaryFlsRating (), 13)),
            mask (tertiaryRatio (), 14),
            mask (usage (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Parameters of fault indicator asset.
 *
 * @param sup [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param resetKind Kind of reset mechanisim of this fault indicator.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
case class FaultIndicatorInfo
(
    override val sup: AssetInfo,
    resetKind: String
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
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { clone ().asInstanceOf[FaultIndicatorInfo] }
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
        implicit val clz: String = FaultIndicatorInfo.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FaultIndicatorInfo.fields (position), value)
        emitattr (0, resetKind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FaultIndicatorInfo rdf:ID=\"%s\">\n%s\t</cim:FaultIndicatorInfo>".format (id, export_fields)
    }
}

object FaultIndicatorInfo
extends
    Parseable[FaultIndicatorInfo]
{
    val fields: Array[String] = Array[String] (
        "resetKind"
    )
    val resetKind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): FaultIndicatorInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FaultIndicatorInfo (
            AssetInfo.parse (context),
            mask (resetKind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Properties of switch assets.
 *
 * @param sup [[ch.ninecode.model.SwitchInfo SwitchInfo]] Reference to the superclass object.
 * @param dielectricStrength The maximum rms voltage that may be applied across an open contact without breaking down the dielectric properties of the switch in the open position.
 * @param loadBreak True if switch has load breaking capabiity.
 *        Unless specified false, this is always assumed to be true for breakers and reclosers.
 * @param makingCapacity The highest value of current the switch can make at the rated voltage under specified operating conditions without suffering significant deterioration of its performance.
 * @param minimumCurrent The lowest value of current that the switch can make, carry and break in uninterrupted duty at the rated voltage under specified operating conditions without suffering significant deterioration of its performance.
 * @param poleCount Number of poles (i.e. of current carrying conductors that are switched).
 * @param remote True if device is capable of being operated by remote control.
 * @param withstandCurrent The highest value of current the switch can carry in the closed position at the rated voltage under specified operating conditions without suffering significant deterioration of its performance.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
case class OldSwitchInfo
(
    override val sup: SwitchInfo,
    dielectricStrength: Double,
    loadBreak: Boolean,
    makingCapacity: Double,
    minimumCurrent: Double,
    poleCount: Int,
    remote: Boolean,
    withstandCurrent: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, false, 0.0, 0.0, 0, false, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SwitchInfo: SwitchInfo = sup.asInstanceOf[SwitchInfo]
    override def copy (): Row = { clone ().asInstanceOf[OldSwitchInfo] }
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
        implicit val clz: String = OldSwitchInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OldSwitchInfo.fields (position), value)
        emitelem (0, dielectricStrength)
        emitelem (1, loadBreak)
        emitelem (2, makingCapacity)
        emitelem (3, minimumCurrent)
        emitelem (4, poleCount)
        emitelem (5, remote)
        emitelem (6, withstandCurrent)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OldSwitchInfo rdf:ID=\"%s\">\n%s\t</cim:OldSwitchInfo>".format (id, export_fields)
    }
}

object OldSwitchInfo
extends
    Parseable[OldSwitchInfo]
{
    val fields: Array[String] = Array[String] (
        "dielectricStrength",
        "loadBreak",
        "makingCapacity",
        "minimumCurrent",
        "poleCount",
        "remote",
        "withstandCurrent"
    )
    val dielectricStrength: Fielder = parse_element (element (cls, fields(0)))
    val loadBreak: Fielder = parse_element (element (cls, fields(1)))
    val makingCapacity: Fielder = parse_element (element (cls, fields(2)))
    val minimumCurrent: Fielder = parse_element (element (cls, fields(3)))
    val poleCount: Fielder = parse_element (element (cls, fields(4)))
    val remote: Fielder = parse_element (element (cls, fields(5)))
    val withstandCurrent: Fielder = parse_element (element (cls, fields(6)))

    def parse (context: Context): OldSwitchInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OldSwitchInfo (
            SwitchInfo.parse (context),
            toDouble (mask (dielectricStrength (), 0)),
            toBoolean (mask (loadBreak (), 1)),
            toDouble (mask (makingCapacity (), 2)),
            toDouble (mask (minimumCurrent (), 3)),
            toInteger (mask (poleCount (), 4)),
            toBoolean (mask (remote (), 5)),
            toDouble (mask (withstandCurrent (), 6))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**

 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
case class OldTransformerEndInfo
(
    override val sup: TransformerEndInfo,
    dayOverLoadRating: Double,
    hourOverLoadRating: Double,
    solidInsulationWeight: Double,
    windingInsulationKind: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def TransformerEndInfo: TransformerEndInfo = sup.asInstanceOf[TransformerEndInfo]
    override def copy (): Row = { clone ().asInstanceOf[OldTransformerEndInfo] }
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
        implicit val clz: String = OldTransformerEndInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OldTransformerEndInfo.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OldTransformerEndInfo.fields (position), value)
        emitelem (0, dayOverLoadRating)
        emitelem (1, hourOverLoadRating)
        emitelem (2, solidInsulationWeight)
        emitattr (3, windingInsulationKind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OldTransformerEndInfo rdf:ID=\"%s\">\n%s\t</cim:OldTransformerEndInfo>".format (id, export_fields)
    }
}

object OldTransformerEndInfo
extends
    Parseable[OldTransformerEndInfo]
{
    val fields: Array[String] = Array[String] (
        "dayOverLoadRating",
        "hourOverLoadRating",
        "solidInsulationWeight",
        "windingInsulationKind"
    )
    val dayOverLoadRating: Fielder = parse_element (element (cls, fields(0)))
    val hourOverLoadRating: Fielder = parse_element (element (cls, fields(1)))
    val solidInsulationWeight: Fielder = parse_element (element (cls, fields(2)))
    val windingInsulationKind: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): OldTransformerEndInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OldTransformerEndInfo (
            TransformerEndInfo.parse (context),
            toDouble (mask (dayOverLoadRating (), 0)),
            toDouble (mask (hourOverLoadRating (), 1)),
            toDouble (mask (solidInsulationWeight (), 2)),
            mask (windingInsulationKind (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**

 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
case class OldTransformerTankInfo
(
    override val sup: TransformerTankInfo,
    constructionKind: String,
    coreCoilsWeight: Double,
    coreKind: String,
    function: String,
    neutralBIL: Double,
    oilPreservationKind: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def TransformerTankInfo: TransformerTankInfo = sup.asInstanceOf[TransformerTankInfo]
    override def copy (): Row = { clone ().asInstanceOf[OldTransformerTankInfo] }
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
        implicit val clz: String = OldTransformerTankInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OldTransformerTankInfo.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OldTransformerTankInfo.fields (position), value)
        emitattr (0, constructionKind)
        emitelem (1, coreCoilsWeight)
        emitattr (2, coreKind)
        emitattr (3, function)
        emitelem (4, neutralBIL)
        emitattr (5, oilPreservationKind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OldTransformerTankInfo rdf:ID=\"%s\">\n%s\t</cim:OldTransformerTankInfo>".format (id, export_fields)
    }
}

object OldTransformerTankInfo
extends
    Parseable[OldTransformerTankInfo]
{
    val fields: Array[String] = Array[String] (
        "constructionKind",
        "coreCoilsWeight",
        "coreKind",
        "function",
        "neutralBIL",
        "oilPreservationKind"
    )
    val constructionKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val coreCoilsWeight: Fielder = parse_element (element (cls, fields(1)))
    val coreKind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val function: Fielder = parse_attribute (attribute (cls, fields(3)))
    val neutralBIL: Fielder = parse_element (element (cls, fields(4)))
    val oilPreservationKind: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): OldTransformerTankInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OldTransformerTankInfo (
            TransformerTankInfo.parse (context),
            mask (constructionKind (), 0),
            toDouble (mask (coreCoilsWeight (), 1)),
            mask (coreKind (), 2),
            mask (function (), 3),
            toDouble (mask (neutralBIL (), 4)),
            mask (oilPreservationKind (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Properties of potential transformer asset.
 *
 * @param sup [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param accuracyClass <em>undocumented</em>
 * @param nominalRatio <em>undocumented</em>
 * @param primaryRatio Ratio for the primary winding tap changer.
 * @param ptClass <em>undocumented</em>
 * @param ratedVoltage Rated voltage on the primary side.
 * @param secondaryRatio Ratio for the secondary winding tap changer.
 * @param tertiaryRatio Ratio for the tertiary winding tap changer.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
case class PotentialTransformerInfo
(
    override val sup: AssetInfo,
    accuracyClass: String,
    nominalRatio: String,
    primaryRatio: String,
    ptClass: String,
    ratedVoltage: Double,
    secondaryRatio: String,
    tertiaryRatio: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { clone ().asInstanceOf[PotentialTransformerInfo] }
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
        implicit val clz: String = PotentialTransformerInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PotentialTransformerInfo.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PotentialTransformerInfo.fields (position), value)
        emitelem (0, accuracyClass)
        emitattr (1, nominalRatio)
        emitattr (2, primaryRatio)
        emitelem (3, ptClass)
        emitelem (4, ratedVoltage)
        emitattr (5, secondaryRatio)
        emitattr (6, tertiaryRatio)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PotentialTransformerInfo rdf:ID=\"%s\">\n%s\t</cim:PotentialTransformerInfo>".format (id, export_fields)
    }
}

object PotentialTransformerInfo
extends
    Parseable[PotentialTransformerInfo]
{
    val fields: Array[String] = Array[String] (
        "accuracyClass",
        "nominalRatio",
        "primaryRatio",
        "ptClass",
        "ratedVoltage",
        "secondaryRatio",
        "tertiaryRatio"
    )
    val accuracyClass: Fielder = parse_element (element (cls, fields(0)))
    val nominalRatio: Fielder = parse_attribute (attribute (cls, fields(1)))
    val primaryRatio: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ptClass: Fielder = parse_element (element (cls, fields(3)))
    val ratedVoltage: Fielder = parse_element (element (cls, fields(4)))
    val secondaryRatio: Fielder = parse_attribute (attribute (cls, fields(5)))
    val tertiaryRatio: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): PotentialTransformerInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PotentialTransformerInfo (
            AssetInfo.parse (context),
            mask (accuracyClass (), 0),
            mask (nominalRatio (), 1),
            mask (primaryRatio (), 2),
            mask (ptClass (), 3),
            toDouble (mask (ratedVoltage (), 4)),
            mask (secondaryRatio (), 5),
            mask (tertiaryRatio (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Properties of protection equipment asset.
 *
 * @param sup [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param groundTrip Actual ground trip for this type of relay, if applicable.
 * @param phaseTrip Actual phase trip for this type of relay, if applicable.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
case class ProtectionEquipmentInfo
(
    override val sup: AssetInfo,
    groundTrip: Double,
    phaseTrip: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { clone ().asInstanceOf[ProtectionEquipmentInfo] }
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
        implicit val clz: String = ProtectionEquipmentInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProtectionEquipmentInfo.fields (position), value)
        emitelem (0, groundTrip)
        emitelem (1, phaseTrip)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProtectionEquipmentInfo rdf:ID=\"%s\">\n%s\t</cim:ProtectionEquipmentInfo>".format (id, export_fields)
    }
}

object ProtectionEquipmentInfo
extends
    Parseable[ProtectionEquipmentInfo]
{
    val fields: Array[String] = Array[String] (
        "groundTrip",
        "phaseTrip"
    )
    val groundTrip: Fielder = parse_element (element (cls, fields(0)))
    val phaseTrip: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): ProtectionEquipmentInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ProtectionEquipmentInfo (
            AssetInfo.parse (context),
            toDouble (mask (groundTrip (), 0)),
            toDouble (mask (phaseTrip (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Properties of recloser assets.
 *
 * @param sup [[ch.ninecode.model.OldSwitchInfo OldSwitchInfo]] Reference to the superclass object.
 * @param groundTripCapable True if device has ground trip capability.
 * @param groundTripNormalEnabled True if normal status of ground trip is enabled.
 * @param groundTripRating Ground trip rating.
 * @param phaseTripRating Phase trip rating.
 * @param recloseLockoutCount Total number of phase reclose operations.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
case class RecloserInfo
(
    override val sup: OldSwitchInfo,
    groundTripCapable: Boolean,
    groundTripNormalEnabled: Boolean,
    groundTripRating: Double,
    phaseTripRating: Double,
    recloseLockoutCount: Int
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, 0.0, 0.0, 0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OldSwitchInfo: OldSwitchInfo = sup.asInstanceOf[OldSwitchInfo]
    override def copy (): Row = { clone ().asInstanceOf[RecloserInfo] }
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
        implicit val clz: String = RecloserInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RecloserInfo.fields (position), value)
        emitelem (0, groundTripCapable)
        emitelem (1, groundTripNormalEnabled)
        emitelem (2, groundTripRating)
        emitelem (3, phaseTripRating)
        emitelem (4, recloseLockoutCount)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RecloserInfo rdf:ID=\"%s\">\n%s\t</cim:RecloserInfo>".format (id, export_fields)
    }
}

object RecloserInfo
extends
    Parseable[RecloserInfo]
{
    val fields: Array[String] = Array[String] (
        "groundTripCapable",
        "groundTripNormalEnabled",
        "groundTripRating",
        "phaseTripRating",
        "recloseLockoutCount"
    )
    val groundTripCapable: Fielder = parse_element (element (cls, fields(0)))
    val groundTripNormalEnabled: Fielder = parse_element (element (cls, fields(1)))
    val groundTripRating: Fielder = parse_element (element (cls, fields(2)))
    val phaseTripRating: Fielder = parse_element (element (cls, fields(3)))
    val recloseLockoutCount: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: Context): RecloserInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RecloserInfo (
            OldSwitchInfo.parse (context),
            toBoolean (mask (groundTripCapable (), 0)),
            toBoolean (mask (groundTripNormalEnabled (), 1)),
            toDouble (mask (groundTripRating (), 2)),
            toDouble (mask (phaseTripRating (), 3)),
            toInteger (mask (recloseLockoutCount (), 4))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Properties of surge arrester.
 *
 * @param sup [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param continuousOperatingVoltage Maximum continuous power frequency voltage allowed on the surge arrester.
 * @param isPolymer If true, the arrester has a polymer housing, porcelain otherwise.
 * @param lightningImpulseDischargeVoltage Residual voltage during an 8x20 microsecond current impulse at the nominal discharge current level.
 * @param lineDischargeClass Determines the arrester energy discharge capability.
 *        Choices are limited to 0 (none) through 5 (highest) by IEC 60099. Classes 1..3 require a 10-kA nominal discharge current. Classes 4..5 require a 20-kA nominal discharge current. Lower nominal discharge currents must use class 0.
 * @param nominalDischargeCurrent The lightning discharge current used to classify the arrester.
 *        Choices are limited to 1.5, 2.5, 5, 10, and 20 kA by IEC 60099.
 * @param pressureReliefClass Fault current level at which all parts of the failed arrester lie within a circle prescribed by IEC 60099.
 * @param ratedVoltage The temporary overvoltage (TOV) level at power frequency that the surge arrester withstands for 10 seconds.
 * @param steepFrontDischargeVoltage Residual voltage during a current impulse with front time of 1 microsecond, and magnitude equal to the nominal discharge current level.
 * @param switchingImpulseDischargeVoltage Residual voltage during a current impulse with front time of at least 30 microseconds, and magnitude specified in IEC 60099 for the line discharge class.
 *        Does not apply to line discharge class 0.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
case class SurgeArresterInfo
(
    override val sup: AssetInfo,
    continuousOperatingVoltage: Double,
    isPolymer: Boolean,
    lightningImpulseDischargeVoltage: Double,
    lineDischargeClass: Int,
    nominalDischargeCurrent: Double,
    pressureReliefClass: Double,
    ratedVoltage: Double,
    steepFrontDischargeVoltage: Double,
    switchingImpulseDischargeVoltage: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, false, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { clone ().asInstanceOf[SurgeArresterInfo] }
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
        implicit val clz: String = SurgeArresterInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SurgeArresterInfo.fields (position), value)
        emitelem (0, continuousOperatingVoltage)
        emitelem (1, isPolymer)
        emitelem (2, lightningImpulseDischargeVoltage)
        emitelem (3, lineDischargeClass)
        emitelem (4, nominalDischargeCurrent)
        emitelem (5, pressureReliefClass)
        emitelem (6, ratedVoltage)
        emitelem (7, steepFrontDischargeVoltage)
        emitelem (8, switchingImpulseDischargeVoltage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SurgeArresterInfo rdf:ID=\"%s\">\n%s\t</cim:SurgeArresterInfo>".format (id, export_fields)
    }
}

object SurgeArresterInfo
extends
    Parseable[SurgeArresterInfo]
{
    val fields: Array[String] = Array[String] (
        "continuousOperatingVoltage",
        "isPolymer",
        "lightningImpulseDischargeVoltage",
        "lineDischargeClass",
        "nominalDischargeCurrent",
        "pressureReliefClass",
        "ratedVoltage",
        "steepFrontDischargeVoltage",
        "switchingImpulseDischargeVoltage"
    )
    val continuousOperatingVoltage: Fielder = parse_element (element (cls, fields(0)))
    val isPolymer: Fielder = parse_element (element (cls, fields(1)))
    val lightningImpulseDischargeVoltage: Fielder = parse_element (element (cls, fields(2)))
    val lineDischargeClass: Fielder = parse_element (element (cls, fields(3)))
    val nominalDischargeCurrent: Fielder = parse_element (element (cls, fields(4)))
    val pressureReliefClass: Fielder = parse_element (element (cls, fields(5)))
    val ratedVoltage: Fielder = parse_element (element (cls, fields(6)))
    val steepFrontDischargeVoltage: Fielder = parse_element (element (cls, fields(7)))
    val switchingImpulseDischargeVoltage: Fielder = parse_element (element (cls, fields(8)))

    def parse (context: Context): SurgeArresterInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SurgeArresterInfo (
            AssetInfo.parse (context),
            toDouble (mask (continuousOperatingVoltage (), 0)),
            toBoolean (mask (isPolymer (), 1)),
            toDouble (mask (lightningImpulseDischargeVoltage (), 2)),
            toInteger (mask (lineDischargeClass (), 3)),
            toDouble (mask (nominalDischargeCurrent (), 4)),
            toDouble (mask (pressureReliefClass (), 5)),
            toDouble (mask (ratedVoltage (), 6)),
            toDouble (mask (steepFrontDischargeVoltage (), 7)),
            toDouble (mask (switchingImpulseDischargeVoltage (), 8))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

private[ninecode] object _InfAssetInfo
{
    def register: List[ClassInfo] =
    {
        List (
            AssetModelCatalogue.register,
            AssetModelCatalogueItem.register,
            BreakerInfo.register,
            CompositeSwitchInfo.register,
            CurrentTransformerInfo.register,
            FaultIndicatorInfo.register,
            OldSwitchInfo.register,
            OldTransformerEndInfo.register,
            OldTransformerTankInfo.register,
            PotentialTransformerInfo.register,
            ProtectionEquipmentInfo.register,
            RecloserInfo.register,
            SurgeArresterInfo.register
        )
    }
}