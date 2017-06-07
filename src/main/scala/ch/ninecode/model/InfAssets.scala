package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/*
 * Package: InfAssets
 */

case class AssetPropertyCurve
(
    override val sup: Curve,
    val Specification: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetPropertyCurve]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetPropertyCurve
extends
    Parseable[AssetPropertyCurve]
{
    val Specification = parse_attribute (attribute ("""AssetPropertyCurve.AssetModel"""))
    def parse (context: Context): AssetPropertyCurve =
    {
        return (
            AssetPropertyCurve
            (
                Curve.parse (context),
                Specification (context)
            )
        )
    }
}

case class Bushing
(
    override val sup: Asset,
    val c1Capacitance: Double,
    val c1PowerFactor: Double,
    val c2Capacitance: Double,
    val c2PowerFactor: Double,
    val insulationKind: String,
    val Terminal: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[Bushing]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Bushing
extends
    Parseable[Bushing]
{
    val c1Capacitance = parse_element (element ("""Bushing.c1Capacitance"""))
    val c1PowerFactor = parse_element (element ("""Bushing.c1PowerFactor"""))
    val c2Capacitance = parse_element (element ("""Bushing.c2Capacitance"""))
    val c2PowerFactor = parse_element (element ("""Bushing.c2PowerFactor"""))
    val insulationKind = parse_attribute (attribute ("""Bushing.insulationKind"""))
    val Terminal = parse_attribute (attribute ("""Bushing.Terminal"""))
    def parse (context: Context): Bushing =
    {
        return (
            Bushing
            (
                Asset.parse (context),
                toDouble (c1Capacitance (context), context),
                toDouble (c1PowerFactor (context), context),
                toDouble (c2Capacitance (context), context),
                toDouble (c2PowerFactor (context), context),
                insulationKind (context),
                Terminal (context)
            )
        )
    }
}

case class BushingInsulationPF
(
    override val sup: IdentifiedObject,
    val testKind: String,
    val Bushing: String,
    val TransformerObservation: String,
    val status: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[BushingInsulationPF]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BushingInsulationPF
extends
    Parseable[BushingInsulationPF]
{
    val testKind = parse_attribute (attribute ("""BushingInsulationPF.testKind"""))
    val Bushing = parse_attribute (attribute ("""BushingInsulationPF.Bushing"""))
    val TransformerObservation = parse_attribute (attribute ("""BushingInsulationPF.TransformerObservation"""))
    val status = parse_attribute (attribute ("""BushingInsulationPF.status"""))
    def parse (context: Context): BushingInsulationPF =
    {
        return (
            BushingInsulationPF
            (
                IdentifiedObject.parse (context),
                testKind (context),
                Bushing (context),
                TransformerObservation (context),
                status (context)
            )
        )
    }
}

case class Cabinet
(
    override val sup: AssetContainer
)
extends
    Element
{
    def this () = { this (null) }
    def AssetContainer: AssetContainer = sup.asInstanceOf[AssetContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[Cabinet]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Cabinet
extends
    Parseable[Cabinet]
{
    def parse (context: Context): Cabinet =
    {
        return (
            Cabinet
            (
                AssetContainer.parse (context)
            )
        )
    }
}

case class CoolingPowerRating
(
    override val sup: IdentifiedObject,
    val coolingKind: String,
    val powerRating: Double,
    val stage: Int
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CoolingPowerRating]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CoolingPowerRating
extends
    Parseable[CoolingPowerRating]
{
    val coolingKind = parse_attribute (attribute ("""CoolingPowerRating.coolingKind"""))
    val powerRating = parse_element (element ("""CoolingPowerRating.powerRating"""))
    val stage = parse_element (element ("""CoolingPowerRating.stage"""))
    def parse (context: Context): CoolingPowerRating =
    {
        return (
            CoolingPowerRating
            (
                IdentifiedObject.parse (context),
                coolingKind (context),
                toDouble (powerRating (context), context),
                toInteger (stage (context), context)
            )
        )
    }
}

case class DimensionsInfo
(
    override val sup: IdentifiedObject,
    val orientation: String,
    val sizeDepth: Double,
    val sizeDiameter: Double,
    val sizeLength: Double,
    val sizeWidth: Double
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DimensionsInfo]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DimensionsInfo
extends
    Parseable[DimensionsInfo]
{
    val orientation = parse_element (element ("""DimensionsInfo.orientation"""))
    val sizeDepth = parse_element (element ("""DimensionsInfo.sizeDepth"""))
    val sizeDiameter = parse_element (element ("""DimensionsInfo.sizeDiameter"""))
    val sizeLength = parse_element (element ("""DimensionsInfo.sizeLength"""))
    val sizeWidth = parse_element (element ("""DimensionsInfo.sizeWidth"""))
    def parse (context: Context): DimensionsInfo =
    {
        return (
            DimensionsInfo
            (
                IdentifiedObject.parse (context),
                orientation (context),
                toDouble (sizeDepth (context), context),
                toDouble (sizeDiameter (context), context),
                toDouble (sizeLength (context), context),
                toDouble (sizeWidth (context), context)
            )
        )
    }
}

case class DuctBank
(
    override val sup: AssetContainer,
    val circuitCount: Int
)
extends
    Element
{
    def this () = { this (null, 0) }
    def AssetContainer: AssetContainer = sup.asInstanceOf[AssetContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[DuctBank]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DuctBank
extends
    Parseable[DuctBank]
{
    val circuitCount = parse_element (element ("""DuctBank.circuitCount"""))
    def parse (context: Context): DuctBank =
    {
        return (
            DuctBank
            (
                AssetContainer.parse (context),
                toInteger (circuitCount (context), context)
            )
        )
    }
}

case class FACTSDevice
(
    override val sup: Asset,
    val kind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[FACTSDevice]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FACTSDevice
extends
    Parseable[FACTSDevice]
{
    val kind = parse_attribute (attribute ("""FACTSDevice.kind"""))
    def parse (context: Context): FACTSDevice =
    {
        return (
            FACTSDevice
            (
                Asset.parse (context),
                kind (context)
            )
        )
    }
}

case class Facility
(
    override val sup: AssetContainer,
    val kind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def AssetContainer: AssetContainer = sup.asInstanceOf[AssetContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[Facility]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Facility
extends
    Parseable[Facility]
{
    val kind = parse_element (element ("""Facility.kind"""))
    def parse (context: Context): Facility =
    {
        return (
            Facility
            (
                AssetContainer.parse (context),
                kind (context)
            )
        )
    }
}

case class FailureEvent
(
    override val sup: ActivityRecord,
    val corporateCode: String,
    val failureIsolationMethod: String,
    val faultLocatingMethod: String,
    val location: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { return (clone ().asInstanceOf[FailureEvent]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FailureEvent
extends
    Parseable[FailureEvent]
{
    val corporateCode = parse_element (element ("""FailureEvent.corporateCode"""))
    val failureIsolationMethod = parse_attribute (attribute ("""FailureEvent.failureIsolationMethod"""))
    val faultLocatingMethod = parse_element (element ("""FailureEvent.faultLocatingMethod"""))
    val location = parse_element (element ("""FailureEvent.location"""))
    def parse (context: Context): FailureEvent =
    {
        return (
            FailureEvent
            (
                ActivityRecord.parse (context),
                corporateCode (context),
                failureIsolationMethod (context),
                faultLocatingMethod (context),
                location (context)
            )
        )
    }
}

case class FinancialInfo
(
    override val sup: IdentifiedObject,
    val account: String,
    val actualPurchaseCost: Double,
    val costDescription: String,
    val costType: String,
    val financialValue: Double,
    val plantTransferDateTime: String,
    val purchaseDateTime: String,
    val purchaseOrderNumber: String,
    val valueDateTime: String,
    val warrantyEndDateTime: String,
    val Asset: String,
    val quantity: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, 0.0, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[FinancialInfo]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FinancialInfo
extends
    Parseable[FinancialInfo]
{
    val account = parse_element (element ("""FinancialInfo.account"""))
    val actualPurchaseCost = parse_element (element ("""FinancialInfo.actualPurchaseCost"""))
    val costDescription = parse_element (element ("""FinancialInfo.costDescription"""))
    val costType = parse_element (element ("""FinancialInfo.costType"""))
    val financialValue = parse_element (element ("""FinancialInfo.financialValue"""))
    val plantTransferDateTime = parse_element (element ("""FinancialInfo.plantTransferDateTime"""))
    val purchaseDateTime = parse_element (element ("""FinancialInfo.purchaseDateTime"""))
    val purchaseOrderNumber = parse_element (element ("""FinancialInfo.purchaseOrderNumber"""))
    val valueDateTime = parse_element (element ("""FinancialInfo.valueDateTime"""))
    val warrantyEndDateTime = parse_element (element ("""FinancialInfo.warrantyEndDateTime"""))
    val Asset = parse_attribute (attribute ("""FinancialInfo.Asset"""))
    val quantity = parse_attribute (attribute ("""FinancialInfo.quantity"""))
    def parse (context: Context): FinancialInfo =
    {
        return (
            FinancialInfo
            (
                IdentifiedObject.parse (context),
                account (context),
                toDouble (actualPurchaseCost (context), context),
                costDescription (context),
                costType (context),
                toDouble (financialValue (context), context),
                plantTransferDateTime (context),
                purchaseDateTime (context),
                purchaseOrderNumber (context),
                valueDateTime (context),
                warrantyEndDateTime (context),
                Asset (context),
                quantity (context)
            )
        )
    }
}

case class GenericAssetModelOrMaterial
(
    override val sup: AssetModel,
    val estimatedUnitCost: Double,
    val stockItem: Boolean,
    val CUAsset: String,
    val CUWorkEquipmentAsset: String,
    val TypeAssetCatalogue: String,
    val quantity: String
)
extends
    Element
{
    def this () = { this (null, 0.0, false, null, null, null, null) }
    def AssetModel: AssetModel = sup.asInstanceOf[AssetModel]
    override def copy (): Row = { return (clone ().asInstanceOf[GenericAssetModelOrMaterial]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GenericAssetModelOrMaterial
extends
    Parseable[GenericAssetModelOrMaterial]
{
    val estimatedUnitCost = parse_element (element ("""GenericAssetModelOrMaterial.estimatedUnitCost"""))
    val stockItem = parse_element (element ("""GenericAssetModelOrMaterial.stockItem"""))
    val CUAsset = parse_attribute (attribute ("""GenericAssetModelOrMaterial.CUAsset"""))
    val CUWorkEquipmentAsset = parse_attribute (attribute ("""GenericAssetModelOrMaterial.CUWorkEquipmentAsset"""))
    val TypeAssetCatalogue = parse_attribute (attribute ("""GenericAssetModelOrMaterial.TypeAssetCatalogue"""))
    val quantity = parse_attribute (attribute ("""GenericAssetModelOrMaterial.quantity"""))
    def parse (context: Context): GenericAssetModelOrMaterial =
    {
        return (
            GenericAssetModelOrMaterial
            (
                AssetModel.parse (context),
                toDouble (estimatedUnitCost (context), context),
                toBoolean (stockItem (context), context),
                CUAsset (context),
                CUWorkEquipmentAsset (context),
                TypeAssetCatalogue (context),
                quantity (context)
            )
        )
    }
}

case class Joint
(
    override val sup: Asset,
    val configurationKind: String,
    val fillKind: String,
    val insulation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[Joint]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Joint
extends
    Parseable[Joint]
{
    val configurationKind = parse_attribute (attribute ("""Joint.configurationKind"""))
    val fillKind = parse_attribute (attribute ("""Joint.fillKind"""))
    val insulation = parse_element (element ("""Joint.insulation"""))
    def parse (context: Context): Joint =
    {
        return (
            Joint
            (
                Asset.parse (context),
                configurationKind (context),
                fillKind (context),
                insulation (context)
            )
        )
    }
}

case class Medium
(
    override val sup: IdentifiedObject,
    val kind: String,
    val volumeSpec: Double,
    val Specification: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Medium]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Medium
extends
    Parseable[Medium]
{
    val kind = parse_attribute (attribute ("""Medium.kind"""))
    val volumeSpec = parse_element (element ("""Medium.volumeSpec"""))
    val Specification = parse_attribute (attribute ("""Medium.Specification"""))
    def parse (context: Context): Medium =
    {
        return (
            Medium
            (
                IdentifiedObject.parse (context),
                kind (context),
                toDouble (volumeSpec (context), context),
                Specification (context)
            )
        )
    }
}

case class Pole
(
    override val sup: Structure,
    val baseKind: String,
    val breastBlock: Boolean,
    val classification: String,
    val construction: String,
    val diameter: Double,
    val jpaReference: String,
    val len: Double,  // length
    val preservativeKind: String,
    val speciesType: String,
    val treatedDateTime: String,
    val treatmentKind: String
)
extends
    Element
{
    def this () = { this (null, null, false, null, null, 0.0, null, 0.0, null, null, null, null) }
    def Structure: Structure = sup.asInstanceOf[Structure]
    override def copy (): Row = { return (clone ().asInstanceOf[Pole]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Pole
extends
    Parseable[Pole]
{
    val baseKind = parse_attribute (attribute ("""Pole.baseKind"""))
    val breastBlock = parse_element (element ("""Pole.breastBlock"""))
    val classification = parse_element (element ("""Pole.classification"""))
    val construction = parse_element (element ("""Pole.construction"""))
    val diameter = parse_element (element ("""Pole.diameter"""))
    val jpaReference = parse_element (element ("""Pole.jpaReference"""))
    val len = parse_element (element ("""Pole.len"""))
    val preservativeKind = parse_attribute (attribute ("""Pole.preservativeKind"""))
    val speciesType = parse_element (element ("""Pole.speciesType"""))
    val treatedDateTime = parse_element (element ("""Pole.treatedDateTime"""))
    val treatmentKind = parse_attribute (attribute ("""Pole.treatmentKind"""))
    def parse (context: Context): Pole =
    {
        return (
            Pole
            (
                Structure.parse (context),
                baseKind (context),
                toBoolean (breastBlock (context), context),
                classification (context),
                construction (context),
                toDouble (diameter (context), context),
                jpaReference (context),
                toDouble (len (context), context),
                preservativeKind (context),
                speciesType (context),
                treatedDateTime (context),
                treatmentKind (context)
            )
        )
    }
}

case class Reconditioning
(
    override val sup: IdentifiedObject,
    val dateTime: String,
    val Asset: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Reconditioning]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Reconditioning
extends
    Parseable[Reconditioning]
{
    val dateTime = parse_element (element ("""Reconditioning.dateTime"""))
    val Asset = parse_attribute (attribute ("""Reconditioning.Asset"""))
    def parse (context: Context): Reconditioning =
    {
        return (
            Reconditioning
            (
                IdentifiedObject.parse (context),
                dateTime (context),
                Asset (context)
            )
        )
    }
}

case class ReliabilityInfo
(
    override val sup: IdentifiedObject,
    val mTTR: Double,
    val momFailureRate: Double,
    val Specification: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ReliabilityInfo]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReliabilityInfo
extends
    Parseable[ReliabilityInfo]
{
    val mTTR = parse_element (element ("""ReliabilityInfo.mTTR"""))
    val momFailureRate = parse_element (element ("""ReliabilityInfo.momFailureRate"""))
    val Specification = parse_attribute (attribute ("""ReliabilityInfo.Specification"""))
    def parse (context: Context): ReliabilityInfo =
    {
        return (
            ReliabilityInfo
            (
                IdentifiedObject.parse (context),
                toDouble (mTTR (context), context),
                toDouble (momFailureRate (context), context),
                Specification (context)
            )
        )
    }
}

case class Specification
(
    override val sup: Document
)
extends
    Element
{
    def this () = { this (null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[Specification]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Specification
extends
    Parseable[Specification]
{
    def parse (context: Context): Specification =
    {
        return (
            Specification
            (
                Document.parse (context)
            )
        )
    }
}

case class Streetlight
(
    override val sup: Asset,
    val armLength: Double,
    val lampKind: String,
    val lightRating: Double,
    val Pole: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, 0.0, null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[Streetlight]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Streetlight
extends
    Parseable[Streetlight]
{
    val armLength = parse_element (element ("""Streetlight.armLength"""))
    val lampKind = parse_attribute (attribute ("""Streetlight.lampKind"""))
    val lightRating = parse_element (element ("""Streetlight.lightRating"""))
    val Pole = parse_attribute (attribute ("""Streetlight.Pole"""))
    def parse (context: Context): Streetlight =
    {
        return (
            Streetlight
            (
                Asset.parse (context),
                toDouble (armLength (context), context),
                lampKind (context),
                toDouble (lightRating (context), context),
                Pole (context)
            )
        )
    }
}

case class Structure
(
    override val sup: AssetContainer,
    val fumigantAppliedDate: String,
    val fumigantName: String,
    val height: Double,
    val materialKind: String,
    val ratedVoltage: Double,
    val removeWeed: Boolean,
    val weedRemovedDate: String
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, null, 0.0, false, null) }
    def AssetContainer: AssetContainer = sup.asInstanceOf[AssetContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[Structure]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Structure
extends
    Parseable[Structure]
{
    val fumigantAppliedDate = parse_element (element ("""Structure.fumigantAppliedDate"""))
    val fumigantName = parse_element (element ("""Structure.fumigantName"""))
    val height = parse_element (element ("""Structure.height"""))
    val materialKind = parse_attribute (attribute ("""Structure.materialKind"""))
    val ratedVoltage = parse_element (element ("""Structure.ratedVoltage"""))
    val removeWeed = parse_element (element ("""Structure.removeWeed"""))
    val weedRemovedDate = parse_element (element ("""Structure.weedRemovedDate"""))
    def parse (context: Context): Structure =
    {
        return (
            Structure
            (
                AssetContainer.parse (context),
                fumigantAppliedDate (context),
                fumigantName (context),
                toDouble (height (context), context),
                materialKind (context),
                toDouble (ratedVoltage (context), context),
                toBoolean (removeWeed (context), context),
                weedRemovedDate (context)
            )
        )
    }
}

case class StructureSupport
(
    override val sup: Asset,
    val anchorKind: String,
    val anchorRodCount: Int,
    val anchorRodLength: Double,
    val direction: Double,
    val kind: String,
    val len: Double,  // length
    val siz: String,  // InternalRow.size
    val securedStructure: String
)
extends
    Element
{
    def this () = { this (null, null, 0, 0.0, 0.0, null, 0.0, null, null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[StructureSupport]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StructureSupport
extends
    Parseable[StructureSupport]
{
    val anchorKind = parse_attribute (attribute ("""StructureSupport.anchorKind"""))
    val anchorRodCount = parse_element (element ("""StructureSupport.anchorRodCount"""))
    val anchorRodLength = parse_element (element ("""StructureSupport.anchorRodLength"""))
    val direction = parse_element (element ("""StructureSupport.direction"""))
    val kind = parse_attribute (attribute ("""StructureSupport.kind"""))
    val len = parse_element (element ("""StructureSupport.len"""))
    val siz = parse_element (element ("""StructureSupport.siz"""))
    val securedStructure = parse_attribute (attribute ("""StructureSupport.securedStructure"""))
    def parse (context: Context): StructureSupport =
    {
        return (
            StructureSupport
            (
                Asset.parse (context),
                anchorKind (context),
                toInteger (anchorRodCount (context), context),
                toDouble (anchorRodLength (context), context),
                toDouble (direction (context), context),
                kind (context),
                toDouble (len (context), context),
                siz (context),
                securedStructure (context)
            )
        )
    }
}

case class Tower
(
    override val sup: Structure,
    val constructionKind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Structure: Structure = sup.asInstanceOf[Structure]
    override def copy (): Row = { return (clone ().asInstanceOf[Tower]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Tower
extends
    Parseable[Tower]
{
    val constructionKind = parse_attribute (attribute ("""Tower.constructionKind"""))
    def parse (context: Context): Tower =
    {
        return (
            Tower
            (
                Structure.parse (context),
                constructionKind (context)
            )
        )
    }
}

case class TransformerObservation
(
    override val sup: IdentifiedObject,
    val bushingTemp: Double,
    val dga: String,
    val freqResp: String,
    val furfuralDP: String,
    val hotSpotTemp: Double,
    val oilColor: String,
    val oilDielectricStrength: Double,
    val oilIFT: String,
    val oilLevel: String,
    val oilNeutralizationNumber: String,
    val pumpVibration: String,
    val topOilTemp: Double,
    val waterContent: String,
    val Reconditioning: String,
    val Transformer: String,
    val status: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, 0.0, null, 0.0, null, null, null, null, 0.0, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerObservation]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerObservation
extends
    Parseable[TransformerObservation]
{
    val bushingTemp = parse_element (element ("""TransformerObservation.bushingTemp"""))
    val dga = parse_element (element ("""TransformerObservation.dga"""))
    val freqResp = parse_element (element ("""TransformerObservation.freqResp"""))
    val furfuralDP = parse_element (element ("""TransformerObservation.furfuralDP"""))
    val hotSpotTemp = parse_element (element ("""TransformerObservation.hotSpotTemp"""))
    val oilColor = parse_element (element ("""TransformerObservation.oilColor"""))
    val oilDielectricStrength = parse_element (element ("""TransformerObservation.oilDielectricStrength"""))
    val oilIFT = parse_element (element ("""TransformerObservation.oilIFT"""))
    val oilLevel = parse_element (element ("""TransformerObservation.oilLevel"""))
    val oilNeutralizationNumber = parse_element (element ("""TransformerObservation.oilNeutralizationNumber"""))
    val pumpVibration = parse_element (element ("""TransformerObservation.pumpVibration"""))
    val topOilTemp = parse_element (element ("""TransformerObservation.topOilTemp"""))
    val waterContent = parse_element (element ("""TransformerObservation.waterContent"""))
    val Reconditioning = parse_attribute (attribute ("""TransformerObservation.Reconditioning"""))
    val Transformer = parse_attribute (attribute ("""TransformerObservation.Transformer"""))
    val status = parse_attribute (attribute ("""TransformerObservation.status"""))
    def parse (context: Context): TransformerObservation =
    {
        return (
            TransformerObservation
            (
                IdentifiedObject.parse (context),
                toDouble (bushingTemp (context), context),
                dga (context),
                freqResp (context),
                furfuralDP (context),
                toDouble (hotSpotTemp (context), context),
                oilColor (context),
                toDouble (oilDielectricStrength (context), context),
                oilIFT (context),
                oilLevel (context),
                oilNeutralizationNumber (context),
                pumpVibration (context),
                toDouble (topOilTemp (context), context),
                waterContent (context),
                Reconditioning (context),
                Transformer (context),
                status (context)
            )
        )
    }
}

case class UndergroundStructure
(
    override val sup: Structure,
    val hasVentilation: Boolean,
    val kind: String,
    val material: String,
    val sealingWarrantyExpiresDate: String
)
extends
    Element
{
    def this () = { this (null, false, null, null, null) }
    def Structure: Structure = sup.asInstanceOf[Structure]
    override def copy (): Row = { return (clone ().asInstanceOf[UndergroundStructure]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UndergroundStructure
extends
    Parseable[UndergroundStructure]
{
    val hasVentilation = parse_element (element ("""UndergroundStructure.hasVentilation"""))
    val kind = parse_attribute (attribute ("""UndergroundStructure.kind"""))
    val material = parse_element (element ("""UndergroundStructure.material"""))
    val sealingWarrantyExpiresDate = parse_element (element ("""UndergroundStructure.sealingWarrantyExpiresDate"""))
    def parse (context: Context): UndergroundStructure =
    {
        return (
            UndergroundStructure
            (
                Structure.parse (context),
                toBoolean (hasVentilation (context), context),
                kind (context),
                material (context),
                sealingWarrantyExpiresDate (context)
            )
        )
    }
}

case class WindingInsulation
(
    override val sup: IdentifiedObject,
    val insulationPFStatus: String,
    val insulationResistance: String,
    val leakageReactance: Double,
    val FromWinding: String,
    val ToWinding: String,
    val TransformerObservation: String,
    val status: String
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindingInsulation]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindingInsulation
extends
    Parseable[WindingInsulation]
{
    val insulationPFStatus = parse_element (element ("""WindingInsulation.insulationPFStatus"""))
    val insulationResistance = parse_element (element ("""WindingInsulation.insulationResistance"""))
    val leakageReactance = parse_element (element ("""WindingInsulation.leakageReactance"""))
    val FromWinding = parse_attribute (attribute ("""WindingInsulation.FromWinding"""))
    val ToWinding = parse_attribute (attribute ("""WindingInsulation.ToWinding"""))
    val TransformerObservation = parse_attribute (attribute ("""WindingInsulation.TransformerObservation"""))
    val status = parse_attribute (attribute ("""WindingInsulation.status"""))
    def parse (context: Context): WindingInsulation =
    {
        return (
            WindingInsulation
            (
                IdentifiedObject.parse (context),
                insulationPFStatus (context),
                insulationResistance (context),
                toDouble (leakageReactance (context), context),
                FromWinding (context),
                ToWinding (context),
                TransformerObservation (context),
                status (context)
            )
        )
    }
}

object InfAssets
{
    def register: Unit =
    {
        AssetPropertyCurve.register
        Bushing.register
        BushingInsulationPF.register
        Cabinet.register
        CoolingPowerRating.register
        DimensionsInfo.register
        DuctBank.register
        FACTSDevice.register
        Facility.register
        FailureEvent.register
        FinancialInfo.register
        GenericAssetModelOrMaterial.register
        Joint.register
        Medium.register
        Pole.register
        Reconditioning.register
        ReliabilityInfo.register
        Specification.register
        Streetlight.register
        Structure.register
        StructureSupport.register
        Tower.register
        TransformerObservation.register
        UndergroundStructure.register
        WindingInsulation.register
    }
}