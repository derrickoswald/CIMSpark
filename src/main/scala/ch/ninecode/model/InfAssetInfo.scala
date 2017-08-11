package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable


/**
 * Catalogue of available types of products and materials that are used to build or install, maintain or operate an Asset.
 * Each catalogue item is for a specific product (AssetModel) available from a specific supplier.
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 */
case class AssetModelCatalogue
(
    override val sup: IdentifiedObject,
    status: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:AssetModelCatalogue.status rdf:resource=\"#" + status + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AssetModelCatalogue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AssetModelCatalogue>"
    }
}

object AssetModelCatalogue
extends
    Parseable[AssetModelCatalogue]
{
    val status: (Context) => String = parse_attribute (attribute ("""AssetModelCatalogue.status"""))
    def parse (context: Context): AssetModelCatalogue =
    {
        AssetModelCatalogue(
            IdentifiedObject.parse (context),
            status (context)
        )
    }
}

/**
 * Provides pricing and other relevant information about a specific manufacturer's product (i.e., AssetModel), and its price from a given supplier.
 * A single AssetModel may be availble from multiple suppliers. Note that manufacturer and supplier are both types of organisation, which the association is inherited from Document.
 * @param sup Reference to the superclass object.
 * @param unitCost Unit cost for an asset model from a specific supplier, either for a unit cost or cost per unit length.
 *        Cost is for material or asset only and does not include labor to install/construct or configure it.
 * @param AssetModel <em>undocumented</em>
 * @param AssetModelCatalogue <em>undocumented</em>
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
    def this () = { this (null, 0.0, null, null) }
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
        sup.export_fields +
        "\t\t<cim:AssetModelCatalogueItem.unitCost>" + unitCost + "</cim:AssetModelCatalogueItem.unitCost>\n" +
        (if (null != AssetModel) "\t\t<cim:AssetModelCatalogueItem.AssetModel rdf:resource=\"#" + AssetModel + "\"/>\n" else "") +
        (if (null != AssetModelCatalogue) "\t\t<cim:AssetModelCatalogueItem.AssetModelCatalogue rdf:resource=\"#" + AssetModelCatalogue + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AssetModelCatalogueItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AssetModelCatalogueItem>"
    }
}

object AssetModelCatalogueItem
extends
    Parseable[AssetModelCatalogueItem]
{
    val unitCost: (Context) => String = parse_element (element ("""AssetModelCatalogueItem.unitCost"""))
    val AssetModel: (Context) => String = parse_attribute (attribute ("""AssetModelCatalogueItem.AssetModel"""))
    val AssetModelCatalogue: (Context) => String = parse_attribute (attribute ("""AssetModelCatalogueItem.AssetModelCatalogue"""))
    def parse (context: Context): AssetModelCatalogueItem =
    {
        AssetModelCatalogueItem(
            Document.parse (context),
            toDouble (unitCost (context), context),
            AssetModel (context),
            AssetModelCatalogue (context)
        )
    }
}

/**
 * Properties of breaker assets.
 * @param sup Reference to the superclass object.
 * @param phaseTrip Phase trip rating.
 */
case class BreakerInfo
(
    override val sup: OldSwitchInfo,
    phaseTrip: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:BreakerInfo.phaseTrip>" + phaseTrip + "</cim:BreakerInfo.phaseTrip>\n"
    }
    override def export: String =
    {
        "\t<cim:BreakerInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BreakerInfo>"
    }
}

object BreakerInfo
extends
    Parseable[BreakerInfo]
{
    val phaseTrip: (Context) => String = parse_element (element ("""BreakerInfo.phaseTrip"""))
    def parse (context: Context): BreakerInfo =
    {
        BreakerInfo(
            OldSwitchInfo.parse (context),
            toDouble (phaseTrip (context), context)
        )
    }
}

/**
 * Properties of a composite switch.
 * @param sup Reference to the superclass object.
 * @param ganged True if multi-phase switch controls all phases concurrently.
 * @param initOpMode Initial operating mode, with the following values: Automatic, Manual.
 * @param interruptingRating Breaking capacity, or short circuit rating, is the maximum rated current which the device can safely interrupt at the rated voltage.
 * @param kind Kind of composite switch.
 * @param phaseCode Phases carried, if applicable.
 * @param phaseCount Supported number of phases, typically 0, 1 or 3.
 * @param ratedVoltage Rated voltage.
 * @param remote True if device is capable of being operated by remote control.
 * @param switchStateCount Number of switch states represented by the composite switch.
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
    def this () = { this (null, false, null, 0.0, null, null, 0, 0.0, false, 0) }
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
        sup.export_fields +
        "\t\t<cim:CompositeSwitchInfo.ganged>" + ganged + "</cim:CompositeSwitchInfo.ganged>\n" +
        (if (null != initOpMode) "\t\t<cim:CompositeSwitchInfo.initOpMode>" + initOpMode + "</cim:CompositeSwitchInfo.initOpMode>\n" else "") +
        "\t\t<cim:CompositeSwitchInfo.interruptingRating>" + interruptingRating + "</cim:CompositeSwitchInfo.interruptingRating>\n" +
        (if (null != kind) "\t\t<cim:CompositeSwitchInfo.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != phaseCode) "\t\t<cim:CompositeSwitchInfo.phaseCode rdf:resource=\"#" + phaseCode + "\"/>\n" else "") +
        "\t\t<cim:CompositeSwitchInfo.phaseCount>" + phaseCount + "</cim:CompositeSwitchInfo.phaseCount>\n" +
        "\t\t<cim:CompositeSwitchInfo.ratedVoltage>" + ratedVoltage + "</cim:CompositeSwitchInfo.ratedVoltage>\n" +
        "\t\t<cim:CompositeSwitchInfo.remote>" + remote + "</cim:CompositeSwitchInfo.remote>\n" +
        "\t\t<cim:CompositeSwitchInfo.switchStateCount>" + switchStateCount + "</cim:CompositeSwitchInfo.switchStateCount>\n"
    }
    override def export: String =
    {
        "\t<cim:CompositeSwitchInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CompositeSwitchInfo>"
    }
}

object CompositeSwitchInfo
extends
    Parseable[CompositeSwitchInfo]
{
    val ganged: (Context) => String = parse_element (element ("""CompositeSwitchInfo.ganged"""))
    val initOpMode: (Context) => String = parse_element (element ("""CompositeSwitchInfo.initOpMode"""))
    val interruptingRating: (Context) => String = parse_element (element ("""CompositeSwitchInfo.interruptingRating"""))
    val kind: (Context) => String = parse_attribute (attribute ("""CompositeSwitchInfo.kind"""))
    val phaseCode: (Context) => String = parse_attribute (attribute ("""CompositeSwitchInfo.phaseCode"""))
    val phaseCount: (Context) => String = parse_element (element ("""CompositeSwitchInfo.phaseCount"""))
    val ratedVoltage: (Context) => String = parse_element (element ("""CompositeSwitchInfo.ratedVoltage"""))
    val remote: (Context) => String = parse_element (element ("""CompositeSwitchInfo.remote"""))
    val switchStateCount: (Context) => String = parse_element (element ("""CompositeSwitchInfo.switchStateCount"""))
    def parse (context: Context): CompositeSwitchInfo =
    {
        CompositeSwitchInfo(
            AssetInfo.parse (context),
            toBoolean (ganged (context), context),
            initOpMode (context),
            toDouble (interruptingRating (context), context),
            kind (context),
            phaseCode (context),
            toInteger (phaseCount (context), context),
            toDouble (ratedVoltage (context), context),
            toBoolean (remote (context), context),
            toInteger (switchStateCount (context), context)
        )
    }
}

/**
 * Properties of current transformer asset.
 * @param sup Reference to the superclass object.
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
    def this () = { this (null, null, 0.0, 0, null, 0.0, 0.0, null, null, 0.0, null, 0.0, 0.0, null, 0.0, null, null) }
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
        sup.export_fields +
        (if (null != accuracyClass) "\t\t<cim:CurrentTransformerInfo.accuracyClass>" + accuracyClass + "</cim:CurrentTransformerInfo.accuracyClass>\n" else "") +
        "\t\t<cim:CurrentTransformerInfo.accuracyLimit>" + accuracyLimit + "</cim:CurrentTransformerInfo.accuracyLimit>\n" +
        "\t\t<cim:CurrentTransformerInfo.coreCount>" + coreCount + "</cim:CurrentTransformerInfo.coreCount>\n" +
        (if (null != ctClass) "\t\t<cim:CurrentTransformerInfo.ctClass>" + ctClass + "</cim:CurrentTransformerInfo.ctClass>\n" else "") +
        "\t\t<cim:CurrentTransformerInfo.kneePointCurrent>" + kneePointCurrent + "</cim:CurrentTransformerInfo.kneePointCurrent>\n" +
        "\t\t<cim:CurrentTransformerInfo.kneePointVoltage>" + kneePointVoltage + "</cim:CurrentTransformerInfo.kneePointVoltage>\n" +
        (if (null != maxRatio) "\t\t<cim:CurrentTransformerInfo.maxRatio rdf:resource=\"#" + maxRatio + "\"/>\n" else "") +
        (if (null != nominalRatio) "\t\t<cim:CurrentTransformerInfo.nominalRatio rdf:resource=\"#" + nominalRatio + "\"/>\n" else "") +
        "\t\t<cim:CurrentTransformerInfo.primaryFlsRating>" + primaryFlsRating + "</cim:CurrentTransformerInfo.primaryFlsRating>\n" +
        (if (null != primaryRatio) "\t\t<cim:CurrentTransformerInfo.primaryRatio rdf:resource=\"#" + primaryRatio + "\"/>\n" else "") +
        "\t\t<cim:CurrentTransformerInfo.ratedCurrent>" + ratedCurrent + "</cim:CurrentTransformerInfo.ratedCurrent>\n" +
        "\t\t<cim:CurrentTransformerInfo.secondaryFlsRating>" + secondaryFlsRating + "</cim:CurrentTransformerInfo.secondaryFlsRating>\n" +
        (if (null != secondaryRatio) "\t\t<cim:CurrentTransformerInfo.secondaryRatio rdf:resource=\"#" + secondaryRatio + "\"/>\n" else "") +
        "\t\t<cim:CurrentTransformerInfo.tertiaryFlsRating>" + tertiaryFlsRating + "</cim:CurrentTransformerInfo.tertiaryFlsRating>\n" +
        (if (null != tertiaryRatio) "\t\t<cim:CurrentTransformerInfo.tertiaryRatio rdf:resource=\"#" + tertiaryRatio + "\"/>\n" else "") +
        (if (null != usage) "\t\t<cim:CurrentTransformerInfo.usage>" + usage + "</cim:CurrentTransformerInfo.usage>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CurrentTransformerInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CurrentTransformerInfo>"
    }
}

object CurrentTransformerInfo
extends
    Parseable[CurrentTransformerInfo]
{
    val accuracyClass: (Context) => String = parse_element (element ("""CurrentTransformerInfo.accuracyClass"""))
    val accuracyLimit: (Context) => String = parse_element (element ("""CurrentTransformerInfo.accuracyLimit"""))
    val coreCount: (Context) => String = parse_element (element ("""CurrentTransformerInfo.coreCount"""))
    val ctClass: (Context) => String = parse_element (element ("""CurrentTransformerInfo.ctClass"""))
    val kneePointCurrent: (Context) => String = parse_element (element ("""CurrentTransformerInfo.kneePointCurrent"""))
    val kneePointVoltage: (Context) => String = parse_element (element ("""CurrentTransformerInfo.kneePointVoltage"""))
    val maxRatio: (Context) => String = parse_attribute (attribute ("""CurrentTransformerInfo.maxRatio"""))
    val nominalRatio: (Context) => String = parse_attribute (attribute ("""CurrentTransformerInfo.nominalRatio"""))
    val primaryFlsRating: (Context) => String = parse_element (element ("""CurrentTransformerInfo.primaryFlsRating"""))
    val primaryRatio: (Context) => String = parse_attribute (attribute ("""CurrentTransformerInfo.primaryRatio"""))
    val ratedCurrent: (Context) => String = parse_element (element ("""CurrentTransformerInfo.ratedCurrent"""))
    val secondaryFlsRating: (Context) => String = parse_element (element ("""CurrentTransformerInfo.secondaryFlsRating"""))
    val secondaryRatio: (Context) => String = parse_attribute (attribute ("""CurrentTransformerInfo.secondaryRatio"""))
    val tertiaryFlsRating: (Context) => String = parse_element (element ("""CurrentTransformerInfo.tertiaryFlsRating"""))
    val tertiaryRatio: (Context) => String = parse_attribute (attribute ("""CurrentTransformerInfo.tertiaryRatio"""))
    val usage: (Context) => String = parse_element (element ("""CurrentTransformerInfo.usage"""))
    def parse (context: Context): CurrentTransformerInfo =
    {
        CurrentTransformerInfo(
            AssetInfo.parse (context),
            accuracyClass (context),
            toDouble (accuracyLimit (context), context),
            toInteger (coreCount (context), context),
            ctClass (context),
            toDouble (kneePointCurrent (context), context),
            toDouble (kneePointVoltage (context), context),
            maxRatio (context),
            nominalRatio (context),
            toDouble (primaryFlsRating (context), context),
            primaryRatio (context),
            toDouble (ratedCurrent (context), context),
            toDouble (secondaryFlsRating (context), context),
            secondaryRatio (context),
            toDouble (tertiaryFlsRating (context), context),
            tertiaryRatio (context),
            usage (context)
        )
    }
}

/**
 * Parameters of fault indicator asset.
 * @param sup Reference to the superclass object.
 * @param resetKind Kind of reset mechanisim of this fault indicator.
 */
case class FaultIndicatorInfo
(
    override val sup: AssetInfo,
    resetKind: String
)
extends
    Element
{
    def this () = { this (null, null) }
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
        sup.export_fields +
        (if (null != resetKind) "\t\t<cim:FaultIndicatorInfo.resetKind rdf:resource=\"#" + resetKind + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FaultIndicatorInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FaultIndicatorInfo>"
    }
}

object FaultIndicatorInfo
extends
    Parseable[FaultIndicatorInfo]
{
    val resetKind: (Context) => String = parse_attribute (attribute ("""FaultIndicatorInfo.resetKind"""))
    def parse (context: Context): FaultIndicatorInfo =
    {
        FaultIndicatorInfo(
            AssetInfo.parse (context),
            resetKind (context)
        )
    }
}

/**
 * Properties of switch assets.
 * @param sup Reference to the superclass object.
 * @param dielectricStrength The maximum rms voltage that may be applied across an open contact without breaking down the dielectric properties of the switch in the open position.
 * @param loadBreak True if switch has load breaking capabiity.
 *        Unless specified false, this is always assumed to be true for breakers and reclosers.
 * @param makingCapacity The highest value of current the switch can make at the rated voltage under specified operating conditions without suffering significant deterioration of its performance.
 * @param minimumCurrent The lowest value of current that the switch can make, carry and break in uninterrupted duty at the rated voltage under specified operating conditions without suffering significant deterioration of its performance.
 * @param poleCount Number of poles (i.e. of current carrying conductors that are switched).
 * @param remote True if device is capable of being operated by remote control.
 * @param withstandCurrent The highest value of current the switch can carry in the closed position at the rated voltage under specified operating conditions without suffering significant deterioration of its performance.
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
    def this () = { this (null, 0.0, false, 0.0, 0.0, 0, false, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:OldSwitchInfo.dielectricStrength>" + dielectricStrength + "</cim:OldSwitchInfo.dielectricStrength>\n" +
        "\t\t<cim:OldSwitchInfo.loadBreak>" + loadBreak + "</cim:OldSwitchInfo.loadBreak>\n" +
        "\t\t<cim:OldSwitchInfo.makingCapacity>" + makingCapacity + "</cim:OldSwitchInfo.makingCapacity>\n" +
        "\t\t<cim:OldSwitchInfo.minimumCurrent>" + minimumCurrent + "</cim:OldSwitchInfo.minimumCurrent>\n" +
        "\t\t<cim:OldSwitchInfo.poleCount>" + poleCount + "</cim:OldSwitchInfo.poleCount>\n" +
        "\t\t<cim:OldSwitchInfo.remote>" + remote + "</cim:OldSwitchInfo.remote>\n" +
        "\t\t<cim:OldSwitchInfo.withstandCurrent>" + withstandCurrent + "</cim:OldSwitchInfo.withstandCurrent>\n"
    }
    override def export: String =
    {
        "\t<cim:OldSwitchInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OldSwitchInfo>"
    }
}

object OldSwitchInfo
extends
    Parseable[OldSwitchInfo]
{
    val dielectricStrength: (Context) => String = parse_element (element ("""OldSwitchInfo.dielectricStrength"""))
    val loadBreak: (Context) => String = parse_element (element ("""OldSwitchInfo.loadBreak"""))
    val makingCapacity: (Context) => String = parse_element (element ("""OldSwitchInfo.makingCapacity"""))
    val minimumCurrent: (Context) => String = parse_element (element ("""OldSwitchInfo.minimumCurrent"""))
    val poleCount: (Context) => String = parse_element (element ("""OldSwitchInfo.poleCount"""))
    val remote: (Context) => String = parse_element (element ("""OldSwitchInfo.remote"""))
    val withstandCurrent: (Context) => String = parse_element (element ("""OldSwitchInfo.withstandCurrent"""))
    def parse (context: Context): OldSwitchInfo =
    {
        OldSwitchInfo(
            SwitchInfo.parse (context),
            toDouble (dielectricStrength (context), context),
            toBoolean (loadBreak (context), context),
            toDouble (makingCapacity (context), context),
            toDouble (minimumCurrent (context), context),
            toInteger (poleCount (context), context),
            toBoolean (remote (context), context),
            toDouble (withstandCurrent (context), context)
        )
    }
}

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
    def this () = { this (null, 0.0, 0.0, 0.0, null) }
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
        sup.export_fields +
        "\t\t<cim:OldTransformerEndInfo.dayOverLoadRating>" + dayOverLoadRating + "</cim:OldTransformerEndInfo.dayOverLoadRating>\n" +
        "\t\t<cim:OldTransformerEndInfo.hourOverLoadRating>" + hourOverLoadRating + "</cim:OldTransformerEndInfo.hourOverLoadRating>\n" +
        "\t\t<cim:OldTransformerEndInfo.solidInsulationWeight>" + solidInsulationWeight + "</cim:OldTransformerEndInfo.solidInsulationWeight>\n" +
        (if (null != windingInsulationKind) "\t\t<cim:OldTransformerEndInfo.windingInsulationKind rdf:resource=\"#" + windingInsulationKind + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OldTransformerEndInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OldTransformerEndInfo>"
    }
}

object OldTransformerEndInfo
extends
    Parseable[OldTransformerEndInfo]
{
    val dayOverLoadRating: (Context) => String = parse_element (element ("""OldTransformerEndInfo.dayOverLoadRating"""))
    val hourOverLoadRating: (Context) => String = parse_element (element ("""OldTransformerEndInfo.hourOverLoadRating"""))
    val solidInsulationWeight: (Context) => String = parse_element (element ("""OldTransformerEndInfo.solidInsulationWeight"""))
    val windingInsulationKind: (Context) => String = parse_attribute (attribute ("""OldTransformerEndInfo.windingInsulationKind"""))
    def parse (context: Context): OldTransformerEndInfo =
    {
        OldTransformerEndInfo(
            TransformerEndInfo.parse (context),
            toDouble (dayOverLoadRating (context), context),
            toDouble (hourOverLoadRating (context), context),
            toDouble (solidInsulationWeight (context), context),
            windingInsulationKind (context)
        )
    }
}

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
    def this () = { this (null, null, 0.0, null, null, 0.0, null) }
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
        sup.export_fields +
        (if (null != constructionKind) "\t\t<cim:OldTransformerTankInfo.constructionKind rdf:resource=\"#" + constructionKind + "\"/>\n" else "") +
        "\t\t<cim:OldTransformerTankInfo.coreCoilsWeight>" + coreCoilsWeight + "</cim:OldTransformerTankInfo.coreCoilsWeight>\n" +
        (if (null != coreKind) "\t\t<cim:OldTransformerTankInfo.coreKind rdf:resource=\"#" + coreKind + "\"/>\n" else "") +
        (if (null != function) "\t\t<cim:OldTransformerTankInfo.function rdf:resource=\"#" + function + "\"/>\n" else "") +
        "\t\t<cim:OldTransformerTankInfo.neutralBIL>" + neutralBIL + "</cim:OldTransformerTankInfo.neutralBIL>\n" +
        (if (null != oilPreservationKind) "\t\t<cim:OldTransformerTankInfo.oilPreservationKind rdf:resource=\"#" + oilPreservationKind + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OldTransformerTankInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OldTransformerTankInfo>"
    }
}

object OldTransformerTankInfo
extends
    Parseable[OldTransformerTankInfo]
{
    val constructionKind: (Context) => String = parse_attribute (attribute ("""OldTransformerTankInfo.constructionKind"""))
    val coreCoilsWeight: (Context) => String = parse_element (element ("""OldTransformerTankInfo.coreCoilsWeight"""))
    val coreKind: (Context) => String = parse_attribute (attribute ("""OldTransformerTankInfo.coreKind"""))
    val function: (Context) => String = parse_attribute (attribute ("""OldTransformerTankInfo.function"""))
    val neutralBIL: (Context) => String = parse_element (element ("""OldTransformerTankInfo.neutralBIL"""))
    val oilPreservationKind: (Context) => String = parse_attribute (attribute ("""OldTransformerTankInfo.oilPreservationKind"""))
    def parse (context: Context): OldTransformerTankInfo =
    {
        OldTransformerTankInfo(
            TransformerTankInfo.parse (context),
            constructionKind (context),
            toDouble (coreCoilsWeight (context), context),
            coreKind (context),
            function (context),
            toDouble (neutralBIL (context), context),
            oilPreservationKind (context)
        )
    }
}

/**
 * Properties of potential transformer asset.
 * @param sup Reference to the superclass object.
 * @param accuracyClass <em>undocumented</em>
 * @param nominalRatio <em>undocumented</em>
 * @param primaryRatio Ratio for the primary winding tap changer.
 * @param ptClass <em>undocumented</em>
 * @param ratedVoltage Rated voltage on the primary side.
 * @param secondaryRatio Ratio for the secondary winding tap changer.
 * @param tertiaryRatio Ratio for the tertiary winding tap changer.
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
    def this () = { this (null, null, null, null, null, 0.0, null, null) }
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
        sup.export_fields +
        (if (null != accuracyClass) "\t\t<cim:PotentialTransformerInfo.accuracyClass>" + accuracyClass + "</cim:PotentialTransformerInfo.accuracyClass>\n" else "") +
        (if (null != nominalRatio) "\t\t<cim:PotentialTransformerInfo.nominalRatio rdf:resource=\"#" + nominalRatio + "\"/>\n" else "") +
        (if (null != primaryRatio) "\t\t<cim:PotentialTransformerInfo.primaryRatio rdf:resource=\"#" + primaryRatio + "\"/>\n" else "") +
        (if (null != ptClass) "\t\t<cim:PotentialTransformerInfo.ptClass>" + ptClass + "</cim:PotentialTransformerInfo.ptClass>\n" else "") +
        "\t\t<cim:PotentialTransformerInfo.ratedVoltage>" + ratedVoltage + "</cim:PotentialTransformerInfo.ratedVoltage>\n" +
        (if (null != secondaryRatio) "\t\t<cim:PotentialTransformerInfo.secondaryRatio rdf:resource=\"#" + secondaryRatio + "\"/>\n" else "") +
        (if (null != tertiaryRatio) "\t\t<cim:PotentialTransformerInfo.tertiaryRatio rdf:resource=\"#" + tertiaryRatio + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PotentialTransformerInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PotentialTransformerInfo>"
    }
}

object PotentialTransformerInfo
extends
    Parseable[PotentialTransformerInfo]
{
    val accuracyClass: (Context) => String = parse_element (element ("""PotentialTransformerInfo.accuracyClass"""))
    val nominalRatio: (Context) => String = parse_attribute (attribute ("""PotentialTransformerInfo.nominalRatio"""))
    val primaryRatio: (Context) => String = parse_attribute (attribute ("""PotentialTransformerInfo.primaryRatio"""))
    val ptClass: (Context) => String = parse_element (element ("""PotentialTransformerInfo.ptClass"""))
    val ratedVoltage: (Context) => String = parse_element (element ("""PotentialTransformerInfo.ratedVoltage"""))
    val secondaryRatio: (Context) => String = parse_attribute (attribute ("""PotentialTransformerInfo.secondaryRatio"""))
    val tertiaryRatio: (Context) => String = parse_attribute (attribute ("""PotentialTransformerInfo.tertiaryRatio"""))
    def parse (context: Context): PotentialTransformerInfo =
    {
        PotentialTransformerInfo(
            AssetInfo.parse (context),
            accuracyClass (context),
            nominalRatio (context),
            primaryRatio (context),
            ptClass (context),
            toDouble (ratedVoltage (context), context),
            secondaryRatio (context),
            tertiaryRatio (context)
        )
    }
}

/**
 * Properties of protection equipment asset.
 * @param sup Reference to the superclass object.
 * @param groundTrip Actual ground trip for this type of relay, if applicable.
 * @param phaseTrip Actual phase trip for this type of relay, if applicable.
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
    def this () = { this (null, 0.0, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:ProtectionEquipmentInfo.groundTrip>" + groundTrip + "</cim:ProtectionEquipmentInfo.groundTrip>\n" +
        "\t\t<cim:ProtectionEquipmentInfo.phaseTrip>" + phaseTrip + "</cim:ProtectionEquipmentInfo.phaseTrip>\n"
    }
    override def export: String =
    {
        "\t<cim:ProtectionEquipmentInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ProtectionEquipmentInfo>"
    }
}

object ProtectionEquipmentInfo
extends
    Parseable[ProtectionEquipmentInfo]
{
    val groundTrip: (Context) => String = parse_element (element ("""ProtectionEquipmentInfo.groundTrip"""))
    val phaseTrip: (Context) => String = parse_element (element ("""ProtectionEquipmentInfo.phaseTrip"""))
    def parse (context: Context): ProtectionEquipmentInfo =
    {
        ProtectionEquipmentInfo(
            AssetInfo.parse (context),
            toDouble (groundTrip (context), context),
            toDouble (phaseTrip (context), context)
        )
    }
}

/**
 * Properties of recloser assets.
 * @param sup Reference to the superclass object.
 * @param groundTripCapable True if device has ground trip capability.
 * @param groundTripNormalEnabled True if normal status of ground trip is enabled.
 * @param groundTripRating Ground trip rating.
 * @param phaseTripRating Phase trip rating.
 * @param recloseLockoutCount Total number of phase reclose operations.
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
    def this () = { this (null, false, false, 0.0, 0.0, 0) }
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
        sup.export_fields +
        "\t\t<cim:RecloserInfo.groundTripCapable>" + groundTripCapable + "</cim:RecloserInfo.groundTripCapable>\n" +
        "\t\t<cim:RecloserInfo.groundTripNormalEnabled>" + groundTripNormalEnabled + "</cim:RecloserInfo.groundTripNormalEnabled>\n" +
        "\t\t<cim:RecloserInfo.groundTripRating>" + groundTripRating + "</cim:RecloserInfo.groundTripRating>\n" +
        "\t\t<cim:RecloserInfo.phaseTripRating>" + phaseTripRating + "</cim:RecloserInfo.phaseTripRating>\n" +
        "\t\t<cim:RecloserInfo.recloseLockoutCount>" + recloseLockoutCount + "</cim:RecloserInfo.recloseLockoutCount>\n"
    }
    override def export: String =
    {
        "\t<cim:RecloserInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RecloserInfo>"
    }
}

object RecloserInfo
extends
    Parseable[RecloserInfo]
{
    val groundTripCapable: (Context) => String = parse_element (element ("""RecloserInfo.groundTripCapable"""))
    val groundTripNormalEnabled: (Context) => String = parse_element (element ("""RecloserInfo.groundTripNormalEnabled"""))
    val groundTripRating: (Context) => String = parse_element (element ("""RecloserInfo.groundTripRating"""))
    val phaseTripRating: (Context) => String = parse_element (element ("""RecloserInfo.phaseTripRating"""))
    val recloseLockoutCount: (Context) => String = parse_element (element ("""RecloserInfo.recloseLockoutCount"""))
    def parse (context: Context): RecloserInfo =
    {
        RecloserInfo(
            OldSwitchInfo.parse (context),
            toBoolean (groundTripCapable (context), context),
            toBoolean (groundTripNormalEnabled (context), context),
            toDouble (groundTripRating (context), context),
            toDouble (phaseTripRating (context), context),
            toInteger (recloseLockoutCount (context), context)
        )
    }
}

/**
 * Properties of surge arrester.
 * @param sup Reference to the superclass object.
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
    def this () = { this (null, 0.0, false, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
        sup.export_fields +
        "\t\t<cim:SurgeArresterInfo.continuousOperatingVoltage>" + continuousOperatingVoltage + "</cim:SurgeArresterInfo.continuousOperatingVoltage>\n" +
        "\t\t<cim:SurgeArresterInfo.isPolymer>" + isPolymer + "</cim:SurgeArresterInfo.isPolymer>\n" +
        "\t\t<cim:SurgeArresterInfo.lightningImpulseDischargeVoltage>" + lightningImpulseDischargeVoltage + "</cim:SurgeArresterInfo.lightningImpulseDischargeVoltage>\n" +
        "\t\t<cim:SurgeArresterInfo.lineDischargeClass>" + lineDischargeClass + "</cim:SurgeArresterInfo.lineDischargeClass>\n" +
        "\t\t<cim:SurgeArresterInfo.nominalDischargeCurrent>" + nominalDischargeCurrent + "</cim:SurgeArresterInfo.nominalDischargeCurrent>\n" +
        "\t\t<cim:SurgeArresterInfo.pressureReliefClass>" + pressureReliefClass + "</cim:SurgeArresterInfo.pressureReliefClass>\n" +
        "\t\t<cim:SurgeArresterInfo.ratedVoltage>" + ratedVoltage + "</cim:SurgeArresterInfo.ratedVoltage>\n" +
        "\t\t<cim:SurgeArresterInfo.steepFrontDischargeVoltage>" + steepFrontDischargeVoltage + "</cim:SurgeArresterInfo.steepFrontDischargeVoltage>\n" +
        "\t\t<cim:SurgeArresterInfo.switchingImpulseDischargeVoltage>" + switchingImpulseDischargeVoltage + "</cim:SurgeArresterInfo.switchingImpulseDischargeVoltage>\n"
    }
    override def export: String =
    {
        "\t<cim:SurgeArresterInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SurgeArresterInfo>"
    }
}

object SurgeArresterInfo
extends
    Parseable[SurgeArresterInfo]
{
    val continuousOperatingVoltage: (Context) => String = parse_element (element ("""SurgeArresterInfo.continuousOperatingVoltage"""))
    val isPolymer: (Context) => String = parse_element (element ("""SurgeArresterInfo.isPolymer"""))
    val lightningImpulseDischargeVoltage: (Context) => String = parse_element (element ("""SurgeArresterInfo.lightningImpulseDischargeVoltage"""))
    val lineDischargeClass: (Context) => String = parse_element (element ("""SurgeArresterInfo.lineDischargeClass"""))
    val nominalDischargeCurrent: (Context) => String = parse_element (element ("""SurgeArresterInfo.nominalDischargeCurrent"""))
    val pressureReliefClass: (Context) => String = parse_element (element ("""SurgeArresterInfo.pressureReliefClass"""))
    val ratedVoltage: (Context) => String = parse_element (element ("""SurgeArresterInfo.ratedVoltage"""))
    val steepFrontDischargeVoltage: (Context) => String = parse_element (element ("""SurgeArresterInfo.steepFrontDischargeVoltage"""))
    val switchingImpulseDischargeVoltage: (Context) => String = parse_element (element ("""SurgeArresterInfo.switchingImpulseDischargeVoltage"""))
    def parse (context: Context): SurgeArresterInfo =
    {
        SurgeArresterInfo(
            AssetInfo.parse (context),
            toDouble (continuousOperatingVoltage (context), context),
            toBoolean (isPolymer (context), context),
            toDouble (lightningImpulseDischargeVoltage (context), context),
            toInteger (lineDischargeClass (context), context),
            toDouble (nominalDischargeCurrent (context), context),
            toDouble (pressureReliefClass (context), context),
            toDouble (ratedVoltage (context), context),
            toDouble (steepFrontDischargeVoltage (context), context),
            toDouble (switchingImpulseDischargeVoltage (context), context)
        )
    }
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