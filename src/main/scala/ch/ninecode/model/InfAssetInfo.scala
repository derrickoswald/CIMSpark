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
        "\t</cim:AssetModelCatalogue>\n"
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
        "\t</cim:AssetModelCatalogueItem>\n"
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
        "\t</cim:BreakerInfo>\n"
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
        "\t</cim:CompositeSwitchInfo>\n"
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
 * Kind of composite switch.
 * @param sup Reference to the superclass object.
 * @param escoThrowOver <em>undocumented</em>
 * @param gral <em>undocumented</em>
 * @param other <em>undocumented</em>
 * @param ral <em>undocumented</em>
 * @param regulatorBypass <em>undocumented</em>
 * @param throwOver <em>undocumented</em>
 * @param ugMultiSwitch <em>undocumented</em>
 */
case class CompositeSwitchKind
(
    override val sup: BasicElement,
    escoThrowOver: String,
    gral: String,
    other: String,
    ral: String,
    regulatorBypass: String,
    throwOver: String,
    ugMultiSwitch: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CompositeSwitchKind] }
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
        (if (null != escoThrowOver) "\t\t<cim:CompositeSwitchKind.escoThrowOver rdf:resource=\"#" + escoThrowOver + "\"/>\n" else "") +
        (if (null != gral) "\t\t<cim:CompositeSwitchKind.gral rdf:resource=\"#" + gral + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:CompositeSwitchKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != ral) "\t\t<cim:CompositeSwitchKind.ral rdf:resource=\"#" + ral + "\"/>\n" else "") +
        (if (null != regulatorBypass) "\t\t<cim:CompositeSwitchKind.regulatorBypass rdf:resource=\"#" + regulatorBypass + "\"/>\n" else "") +
        (if (null != throwOver) "\t\t<cim:CompositeSwitchKind.throwOver rdf:resource=\"#" + throwOver + "\"/>\n" else "") +
        (if (null != ugMultiSwitch) "\t\t<cim:CompositeSwitchKind.ugMultiSwitch rdf:resource=\"#" + ugMultiSwitch + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CompositeSwitchKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CompositeSwitchKind>\n"
    }
}

object CompositeSwitchKind
extends
    Parseable[CompositeSwitchKind]
{
    val escoThrowOver: (Context) => String = parse_attribute (attribute ("""CompositeSwitchKind.escoThrowOver"""))
    val gral: (Context) => String = parse_attribute (attribute ("""CompositeSwitchKind.gral"""))
    val other: (Context) => String = parse_attribute (attribute ("""CompositeSwitchKind.other"""))
    val ral: (Context) => String = parse_attribute (attribute ("""CompositeSwitchKind.ral"""))
    val regulatorBypass: (Context) => String = parse_attribute (attribute ("""CompositeSwitchKind.regulatorBypass"""))
    val throwOver: (Context) => String = parse_attribute (attribute ("""CompositeSwitchKind.throwOver"""))
    val ugMultiSwitch: (Context) => String = parse_attribute (attribute ("""CompositeSwitchKind.ugMultiSwitch"""))
    def parse (context: Context): CompositeSwitchKind =
    {
        CompositeSwitchKind(
            BasicElement.parse (context),
            escoThrowOver (context),
            gral (context),
            other (context),
            ral (context),
            regulatorBypass (context),
            throwOver (context),
            ugMultiSwitch (context)
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
        "\t</cim:CurrentTransformerInfo>\n"
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
        "\t</cim:FaultIndicatorInfo>\n"
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
 * Kind of resetting the fault indicators.
 * @param sup Reference to the superclass object.
 * @param automatic <em>undocumented</em>
 * @param manual <em>undocumented</em>
 * @param other <em>undocumented</em>
 * @param remote <em>undocumented</em>
 */
case class FaultIndicatorResetKind
(
    override val sup: BasicElement,
    automatic: String,
    manual: String,
    other: String,
    remote: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FaultIndicatorResetKind] }
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
        (if (null != automatic) "\t\t<cim:FaultIndicatorResetKind.automatic rdf:resource=\"#" + automatic + "\"/>\n" else "") +
        (if (null != manual) "\t\t<cim:FaultIndicatorResetKind.manual rdf:resource=\"#" + manual + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:FaultIndicatorResetKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != remote) "\t\t<cim:FaultIndicatorResetKind.remote rdf:resource=\"#" + remote + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FaultIndicatorResetKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FaultIndicatorResetKind>\n"
    }
}

object FaultIndicatorResetKind
extends
    Parseable[FaultIndicatorResetKind]
{
    val automatic: (Context) => String = parse_attribute (attribute ("""FaultIndicatorResetKind.automatic"""))
    val manual: (Context) => String = parse_attribute (attribute ("""FaultIndicatorResetKind.manual"""))
    val other: (Context) => String = parse_attribute (attribute ("""FaultIndicatorResetKind.other"""))
    val remote: (Context) => String = parse_attribute (attribute ("""FaultIndicatorResetKind.remote"""))
    def parse (context: Context): FaultIndicatorResetKind =
    {
        FaultIndicatorResetKind(
            BasicElement.parse (context),
            automatic (context),
            manual (context),
            other (context),
            remote (context)
        )
    }
}

/**
 * Kind of oil preservation.
 * @param sup Reference to the superclass object.
 * @param conservator <em>undocumented</em>
 * @param freeBreathing <em>undocumented</em>
 * @param nitrogenBlanket <em>undocumented</em>
 * @param other <em>undocumented</em>
 */
case class OilPreservationKind
(
    override val sup: BasicElement,
    conservator: String,
    freeBreathing: String,
    nitrogenBlanket: String,
    other: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OilPreservationKind] }
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
        (if (null != conservator) "\t\t<cim:OilPreservationKind.conservator rdf:resource=\"#" + conservator + "\"/>\n" else "") +
        (if (null != freeBreathing) "\t\t<cim:OilPreservationKind.freeBreathing rdf:resource=\"#" + freeBreathing + "\"/>\n" else "") +
        (if (null != nitrogenBlanket) "\t\t<cim:OilPreservationKind.nitrogenBlanket rdf:resource=\"#" + nitrogenBlanket + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:OilPreservationKind.other rdf:resource=\"#" + other + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OilPreservationKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OilPreservationKind>\n"
    }
}

object OilPreservationKind
extends
    Parseable[OilPreservationKind]
{
    val conservator: (Context) => String = parse_attribute (attribute ("""OilPreservationKind.conservator"""))
    val freeBreathing: (Context) => String = parse_attribute (attribute ("""OilPreservationKind.freeBreathing"""))
    val nitrogenBlanket: (Context) => String = parse_attribute (attribute ("""OilPreservationKind.nitrogenBlanket"""))
    val other: (Context) => String = parse_attribute (attribute ("""OilPreservationKind.other"""))
    def parse (context: Context): OilPreservationKind =
    {
        OilPreservationKind(
            BasicElement.parse (context),
            conservator (context),
            freeBreathing (context),
            nitrogenBlanket (context),
            other (context)
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
        "\t</cim:OldSwitchInfo>\n"
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
        "\t</cim:OldTransformerEndInfo>\n"
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
        "\t</cim:OldTransformerTankInfo>\n"
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
        "\t</cim:PotentialTransformerInfo>\n"
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
        "\t</cim:ProtectionEquipmentInfo>\n"
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
        "\t</cim:RecloserInfo>\n"
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
 * Kind of regulation branch for shunt impedance.
 * @param sup Reference to the superclass object.
 * @param breaker <em>undocumented</em>
 * @param fuse <em>undocumented</em>
 * @param line <em>undocumented</em>
 * @param other <em>undocumented</em>
 * @param recloser <em>undocumented</em>
 * @param sectionner <em>undocumented</em>
 * @param switch1 <em>undocumented</em>
 * @param transformer <em>undocumented</em>
 */
case class RegulationBranchKind
(
    override val sup: BasicElement,
    breaker: String,
    fuse: String,
    line: String,
    other: String,
    recloser: String,
    sectionner: String,
    switch1: String,
    transformer: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[RegulationBranchKind] }
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
        (if (null != breaker) "\t\t<cim:RegulationBranchKind.breaker rdf:resource=\"#" + breaker + "\"/>\n" else "") +
        (if (null != fuse) "\t\t<cim:RegulationBranchKind.fuse rdf:resource=\"#" + fuse + "\"/>\n" else "") +
        (if (null != line) "\t\t<cim:RegulationBranchKind.line rdf:resource=\"#" + line + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:RegulationBranchKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != recloser) "\t\t<cim:RegulationBranchKind.recloser rdf:resource=\"#" + recloser + "\"/>\n" else "") +
        (if (null != sectionner) "\t\t<cim:RegulationBranchKind.sectionner rdf:resource=\"#" + sectionner + "\"/>\n" else "") +
        (if (null != switch1) "\t\t<cim:RegulationBranchKind.switch rdf:resource=\"#" + switch1 + "\"/>\n" else "") +
        (if (null != transformer) "\t\t<cim:RegulationBranchKind.transformer rdf:resource=\"#" + transformer + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RegulationBranchKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RegulationBranchKind>\n"
    }
}

object RegulationBranchKind
extends
    Parseable[RegulationBranchKind]
{
    val breaker: (Context) => String = parse_attribute (attribute ("""RegulationBranchKind.breaker"""))
    val fuse: (Context) => String = parse_attribute (attribute ("""RegulationBranchKind.fuse"""))
    val line: (Context) => String = parse_attribute (attribute ("""RegulationBranchKind.line"""))
    val other: (Context) => String = parse_attribute (attribute ("""RegulationBranchKind.other"""))
    val recloser: (Context) => String = parse_attribute (attribute ("""RegulationBranchKind.recloser"""))
    val sectionner: (Context) => String = parse_attribute (attribute ("""RegulationBranchKind.sectionner"""))
    val switch1: (Context) => String = parse_attribute (attribute ("""RegulationBranchKind.switch"""))
    val transformer: (Context) => String = parse_attribute (attribute ("""RegulationBranchKind.transformer"""))
    def parse (context: Context): RegulationBranchKind =
    {
        RegulationBranchKind(
            BasicElement.parse (context),
            breaker (context),
            fuse (context),
            line (context),
            other (context),
            recloser (context),
            sectionner (context),
            switch1 (context),
            transformer (context)
        )
    }
}

/**
 * Kind of control for shunt impedance.
 * @param sup Reference to the superclass object.
 * @param fixed <em>undocumented</em>
 * @param localOnly <em>undocumented</em>
 * @param remoteOnly <em>undocumented</em>
 * @param remoteWithLocalOverride <em>undocumented</em>
 */
case class ShuntImpedanceControlKind
(
    override val sup: BasicElement,
    fixed: String,
    localOnly: String,
    remoteOnly: String,
    remoteWithLocalOverride: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ShuntImpedanceControlKind] }
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
        (if (null != fixed) "\t\t<cim:ShuntImpedanceControlKind.fixed rdf:resource=\"#" + fixed + "\"/>\n" else "") +
        (if (null != localOnly) "\t\t<cim:ShuntImpedanceControlKind.localOnly rdf:resource=\"#" + localOnly + "\"/>\n" else "") +
        (if (null != remoteOnly) "\t\t<cim:ShuntImpedanceControlKind.remoteOnly rdf:resource=\"#" + remoteOnly + "\"/>\n" else "") +
        (if (null != remoteWithLocalOverride) "\t\t<cim:ShuntImpedanceControlKind.remoteWithLocalOverride rdf:resource=\"#" + remoteWithLocalOverride + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ShuntImpedanceControlKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ShuntImpedanceControlKind>\n"
    }
}

object ShuntImpedanceControlKind
extends
    Parseable[ShuntImpedanceControlKind]
{
    val fixed: (Context) => String = parse_attribute (attribute ("""ShuntImpedanceControlKind.fixed"""))
    val localOnly: (Context) => String = parse_attribute (attribute ("""ShuntImpedanceControlKind.localOnly"""))
    val remoteOnly: (Context) => String = parse_attribute (attribute ("""ShuntImpedanceControlKind.remoteOnly"""))
    val remoteWithLocalOverride: (Context) => String = parse_attribute (attribute ("""ShuntImpedanceControlKind.remoteWithLocalOverride"""))
    def parse (context: Context): ShuntImpedanceControlKind =
    {
        ShuntImpedanceControlKind(
            BasicElement.parse (context),
            fixed (context),
            localOnly (context),
            remoteOnly (context),
            remoteWithLocalOverride (context)
        )
    }
}

/**
 * Kind of local control for shunt impedance.
 * @param sup Reference to the superclass object.
 * @param current <em>undocumented</em>
 * @param none <em>undocumented</em>
 * @param powerFactor <em>undocumented</em>
 * @param reactivePower <em>undocumented</em>
 * @param temperature <em>undocumented</em>
 * @param time <em>undocumented</em>
 * @param voltage <em>undocumented</em>
 */
case class ShuntImpedanceLocalControlKind
(
    override val sup: BasicElement,
    current: String,
    none: String,
    powerFactor: String,
    reactivePower: String,
    temperature: String,
    time: String,
    voltage: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ShuntImpedanceLocalControlKind] }
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
        (if (null != current) "\t\t<cim:ShuntImpedanceLocalControlKind.current rdf:resource=\"#" + current + "\"/>\n" else "") +
        (if (null != none) "\t\t<cim:ShuntImpedanceLocalControlKind.none rdf:resource=\"#" + none + "\"/>\n" else "") +
        (if (null != powerFactor) "\t\t<cim:ShuntImpedanceLocalControlKind.powerFactor rdf:resource=\"#" + powerFactor + "\"/>\n" else "") +
        (if (null != reactivePower) "\t\t<cim:ShuntImpedanceLocalControlKind.reactivePower rdf:resource=\"#" + reactivePower + "\"/>\n" else "") +
        (if (null != temperature) "\t\t<cim:ShuntImpedanceLocalControlKind.temperature rdf:resource=\"#" + temperature + "\"/>\n" else "") +
        (if (null != time) "\t\t<cim:ShuntImpedanceLocalControlKind.time rdf:resource=\"#" + time + "\"/>\n" else "") +
        (if (null != voltage) "\t\t<cim:ShuntImpedanceLocalControlKind.voltage rdf:resource=\"#" + voltage + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ShuntImpedanceLocalControlKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ShuntImpedanceLocalControlKind>\n"
    }
}

object ShuntImpedanceLocalControlKind
extends
    Parseable[ShuntImpedanceLocalControlKind]
{
    val current: (Context) => String = parse_attribute (attribute ("""ShuntImpedanceLocalControlKind.current"""))
    val none: (Context) => String = parse_attribute (attribute ("""ShuntImpedanceLocalControlKind.none"""))
    val powerFactor: (Context) => String = parse_attribute (attribute ("""ShuntImpedanceLocalControlKind.powerFactor"""))
    val reactivePower: (Context) => String = parse_attribute (attribute ("""ShuntImpedanceLocalControlKind.reactivePower"""))
    val temperature: (Context) => String = parse_attribute (attribute ("""ShuntImpedanceLocalControlKind.temperature"""))
    val time: (Context) => String = parse_attribute (attribute ("""ShuntImpedanceLocalControlKind.time"""))
    val voltage: (Context) => String = parse_attribute (attribute ("""ShuntImpedanceLocalControlKind.voltage"""))
    def parse (context: Context): ShuntImpedanceLocalControlKind =
    {
        ShuntImpedanceLocalControlKind(
            BasicElement.parse (context),
            current (context),
            none (context),
            powerFactor (context),
            reactivePower (context),
            temperature (context),
            time (context),
            voltage (context)
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
        "\t</cim:SurgeArresterInfo>\n"
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

/**
 * Kind of transformer construction.
 * @param sup Reference to the superclass object.
 * @param aerial <em>undocumented</em>
 * @param dryType <em>undocumented</em>
 * @param network <em>undocumented</em>
 * @param onePhase <em>undocumented</em>
 * @param overhead <em>undocumented</em>
 * @param padmountDeadFront <em>undocumented</em>
 * @param padmountFeedThrough <em>undocumented</em>
 * @param padmountLiveFront <em>undocumented</em>
 * @param padmountLoopThrough <em>undocumented</em>
 * @param padmounted <em>undocumented</em>
 * @param subway <em>undocumented</em>
 * @param threePhase <em>undocumented</em>
 * @param underground <em>undocumented</em>
 * @param unknown <em>undocumented</em>
 * @param vault <em>undocumented</em>
 * @param vaultThreePhase <em>undocumented</em>
 */
case class TransformerConstructionKind
(
    override val sup: BasicElement,
    aerial: String,
    dryType: String,
    network: String,
    onePhase: String,
    overhead: String,
    padmountDeadFront: String,
    padmountFeedThrough: String,
    padmountLiveFront: String,
    padmountLoopThrough: String,
    padmounted: String,
    subway: String,
    threePhase: String,
    underground: String,
    unknown: String,
    vault: String,
    vaultThreePhase: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TransformerConstructionKind] }
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
        (if (null != aerial) "\t\t<cim:TransformerConstructionKind.aerial rdf:resource=\"#" + aerial + "\"/>\n" else "") +
        (if (null != dryType) "\t\t<cim:TransformerConstructionKind.dryType rdf:resource=\"#" + dryType + "\"/>\n" else "") +
        (if (null != network) "\t\t<cim:TransformerConstructionKind.network rdf:resource=\"#" + network + "\"/>\n" else "") +
        (if (null != onePhase) "\t\t<cim:TransformerConstructionKind.onePhase rdf:resource=\"#" + onePhase + "\"/>\n" else "") +
        (if (null != overhead) "\t\t<cim:TransformerConstructionKind.overhead rdf:resource=\"#" + overhead + "\"/>\n" else "") +
        (if (null != padmountDeadFront) "\t\t<cim:TransformerConstructionKind.padmountDeadFront rdf:resource=\"#" + padmountDeadFront + "\"/>\n" else "") +
        (if (null != padmountFeedThrough) "\t\t<cim:TransformerConstructionKind.padmountFeedThrough rdf:resource=\"#" + padmountFeedThrough + "\"/>\n" else "") +
        (if (null != padmountLiveFront) "\t\t<cim:TransformerConstructionKind.padmountLiveFront rdf:resource=\"#" + padmountLiveFront + "\"/>\n" else "") +
        (if (null != padmountLoopThrough) "\t\t<cim:TransformerConstructionKind.padmountLoopThrough rdf:resource=\"#" + padmountLoopThrough + "\"/>\n" else "") +
        (if (null != padmounted) "\t\t<cim:TransformerConstructionKind.padmounted rdf:resource=\"#" + padmounted + "\"/>\n" else "") +
        (if (null != subway) "\t\t<cim:TransformerConstructionKind.subway rdf:resource=\"#" + subway + "\"/>\n" else "") +
        (if (null != threePhase) "\t\t<cim:TransformerConstructionKind.threePhase rdf:resource=\"#" + threePhase + "\"/>\n" else "") +
        (if (null != underground) "\t\t<cim:TransformerConstructionKind.underground rdf:resource=\"#" + underground + "\"/>\n" else "") +
        (if (null != unknown) "\t\t<cim:TransformerConstructionKind.unknown rdf:resource=\"#" + unknown + "\"/>\n" else "") +
        (if (null != vault) "\t\t<cim:TransformerConstructionKind.vault rdf:resource=\"#" + vault + "\"/>\n" else "") +
        (if (null != vaultThreePhase) "\t\t<cim:TransformerConstructionKind.vaultThreePhase rdf:resource=\"#" + vaultThreePhase + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransformerConstructionKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransformerConstructionKind>\n"
    }
}

object TransformerConstructionKind
extends
    Parseable[TransformerConstructionKind]
{
    val aerial: (Context) => String = parse_attribute (attribute ("""TransformerConstructionKind.aerial"""))
    val dryType: (Context) => String = parse_attribute (attribute ("""TransformerConstructionKind.dryType"""))
    val network: (Context) => String = parse_attribute (attribute ("""TransformerConstructionKind.network"""))
    val onePhase: (Context) => String = parse_attribute (attribute ("""TransformerConstructionKind.onePhase"""))
    val overhead: (Context) => String = parse_attribute (attribute ("""TransformerConstructionKind.overhead"""))
    val padmountDeadFront: (Context) => String = parse_attribute (attribute ("""TransformerConstructionKind.padmountDeadFront"""))
    val padmountFeedThrough: (Context) => String = parse_attribute (attribute ("""TransformerConstructionKind.padmountFeedThrough"""))
    val padmountLiveFront: (Context) => String = parse_attribute (attribute ("""TransformerConstructionKind.padmountLiveFront"""))
    val padmountLoopThrough: (Context) => String = parse_attribute (attribute ("""TransformerConstructionKind.padmountLoopThrough"""))
    val padmounted: (Context) => String = parse_attribute (attribute ("""TransformerConstructionKind.padmounted"""))
    val subway: (Context) => String = parse_attribute (attribute ("""TransformerConstructionKind.subway"""))
    val threePhase: (Context) => String = parse_attribute (attribute ("""TransformerConstructionKind.threePhase"""))
    val underground: (Context) => String = parse_attribute (attribute ("""TransformerConstructionKind.underground"""))
    val unknown: (Context) => String = parse_attribute (attribute ("""TransformerConstructionKind.unknown"""))
    val vault: (Context) => String = parse_attribute (attribute ("""TransformerConstructionKind.vault"""))
    val vaultThreePhase: (Context) => String = parse_attribute (attribute ("""TransformerConstructionKind.vaultThreePhase"""))
    def parse (context: Context): TransformerConstructionKind =
    {
        TransformerConstructionKind(
            BasicElement.parse (context),
            aerial (context),
            dryType (context),
            network (context),
            onePhase (context),
            overhead (context),
            padmountDeadFront (context),
            padmountFeedThrough (context),
            padmountLiveFront (context),
            padmountLoopThrough (context),
            padmounted (context),
            subway (context),
            threePhase (context),
            underground (context),
            unknown (context),
            vault (context),
            vaultThreePhase (context)
        )
    }
}

/**
 * Kind of transformer construction.
 * @param sup Reference to the superclass object.
 * @param core <em>undocumented</em>
 * @param shell <em>undocumented</em>
 */
case class TransformerCoreKind
(
    override val sup: BasicElement,
    core: String,
    shell: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TransformerCoreKind] }
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
        (if (null != core) "\t\t<cim:TransformerCoreKind.core rdf:resource=\"#" + core + "\"/>\n" else "") +
        (if (null != shell) "\t\t<cim:TransformerCoreKind.shell rdf:resource=\"#" + shell + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransformerCoreKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransformerCoreKind>\n"
    }
}

object TransformerCoreKind
extends
    Parseable[TransformerCoreKind]
{
    val core: (Context) => String = parse_attribute (attribute ("""TransformerCoreKind.core"""))
    val shell: (Context) => String = parse_attribute (attribute ("""TransformerCoreKind.shell"""))
    def parse (context: Context): TransformerCoreKind =
    {
        TransformerCoreKind(
            BasicElement.parse (context),
            core (context),
            shell (context)
        )
    }
}

/**
 * Function of a transformer.
 * @param sup Reference to the superclass object.
 * @param autotransformer <em>undocumented</em>
 * @param other <em>undocumented</em>
 * @param powerTransformer <em>undocumented</em>
 * @param secondaryTransformer <em>undocumented</em>
 * @param voltageRegulator <em>undocumented</em>
 */
case class TransformerFunctionKind
(
    override val sup: BasicElement,
    autotransformer: String,
    other: String,
    powerTransformer: String,
    secondaryTransformer: String,
    voltageRegulator: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TransformerFunctionKind] }
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
        (if (null != autotransformer) "\t\t<cim:TransformerFunctionKind.autotransformer rdf:resource=\"#" + autotransformer + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:TransformerFunctionKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != powerTransformer) "\t\t<cim:TransformerFunctionKind.powerTransformer rdf:resource=\"#" + powerTransformer + "\"/>\n" else "") +
        (if (null != secondaryTransformer) "\t\t<cim:TransformerFunctionKind.secondaryTransformer rdf:resource=\"#" + secondaryTransformer + "\"/>\n" else "") +
        (if (null != voltageRegulator) "\t\t<cim:TransformerFunctionKind.voltageRegulator rdf:resource=\"#" + voltageRegulator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransformerFunctionKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransformerFunctionKind>\n"
    }
}

object TransformerFunctionKind
extends
    Parseable[TransformerFunctionKind]
{
    val autotransformer: (Context) => String = parse_attribute (attribute ("""TransformerFunctionKind.autotransformer"""))
    val other: (Context) => String = parse_attribute (attribute ("""TransformerFunctionKind.other"""))
    val powerTransformer: (Context) => String = parse_attribute (attribute ("""TransformerFunctionKind.powerTransformer"""))
    val secondaryTransformer: (Context) => String = parse_attribute (attribute ("""TransformerFunctionKind.secondaryTransformer"""))
    val voltageRegulator: (Context) => String = parse_attribute (attribute ("""TransformerFunctionKind.voltageRegulator"""))
    def parse (context: Context): TransformerFunctionKind =
    {
        TransformerFunctionKind(
            BasicElement.parse (context),
            autotransformer (context),
            other (context),
            powerTransformer (context),
            secondaryTransformer (context),
            voltageRegulator (context)
        )
    }
}

/**
 * Insulation kind for windings.
 * @param sup Reference to the superclass object.
 * @param nomex <em>undocumented</em>
 * @param other <em>undocumented</em>
 * @param paper <em>undocumented</em>
 * @param thermallyUpgradedPaper <em>undocumented</em>
 */
case class WindingInsulationKind
(
    override val sup: BasicElement,
    nomex: String,
    other: String,
    paper: String,
    thermallyUpgradedPaper: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[WindingInsulationKind] }
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
        (if (null != nomex) "\t\t<cim:WindingInsulationKind.nomex rdf:resource=\"#" + nomex + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:WindingInsulationKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != paper) "\t\t<cim:WindingInsulationKind.paper rdf:resource=\"#" + paper + "\"/>\n" else "") +
        (if (null != thermallyUpgradedPaper) "\t\t<cim:WindingInsulationKind.thermallyUpgradedPaper rdf:resource=\"#" + thermallyUpgradedPaper + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindingInsulationKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindingInsulationKind>\n"
    }
}

object WindingInsulationKind
extends
    Parseable[WindingInsulationKind]
{
    val nomex: (Context) => String = parse_attribute (attribute ("""WindingInsulationKind.nomex"""))
    val other: (Context) => String = parse_attribute (attribute ("""WindingInsulationKind.other"""))
    val paper: (Context) => String = parse_attribute (attribute ("""WindingInsulationKind.paper"""))
    val thermallyUpgradedPaper: (Context) => String = parse_attribute (attribute ("""WindingInsulationKind.thermallyUpgradedPaper"""))
    def parse (context: Context): WindingInsulationKind =
    {
        WindingInsulationKind(
            BasicElement.parse (context),
            nomex (context),
            other (context),
            paper (context),
            thermallyUpgradedPaper (context)
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
            CompositeSwitchKind.register,
            CurrentTransformerInfo.register,
            FaultIndicatorInfo.register,
            FaultIndicatorResetKind.register,
            OilPreservationKind.register,
            OldSwitchInfo.register,
            OldTransformerEndInfo.register,
            OldTransformerTankInfo.register,
            PotentialTransformerInfo.register,
            ProtectionEquipmentInfo.register,
            RecloserInfo.register,
            RegulationBranchKind.register,
            ShuntImpedanceControlKind.register,
            ShuntImpedanceLocalControlKind.register,
            SurgeArresterInfo.register,
            TransformerConstructionKind.register,
            TransformerCoreKind.register,
            TransformerFunctionKind.register,
            WindingInsulationKind.register
        )
    }
}