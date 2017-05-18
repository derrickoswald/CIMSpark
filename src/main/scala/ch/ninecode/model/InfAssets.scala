package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The package is used to define asset-level models for objects.
 * Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.
 */

/**
 * Kind of anchor.
 * @param sup Reference to the superclass object.
 * @param concrete
 * @param helix
 * @param multiHelix
 * @param other
 * @param rod
 * @param screw
 * @param unknown
 */
case class AnchorKind
(
    override val sup: Element,
    val concrete: String,
    val helix: String,
    val multiHelix: String,
    val other: String,
    val rod: String,
    val screw: String,
    val unknown: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AnchorKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AnchorKind
extends
    Parseable[AnchorKind]
{
    val sup = BasicElement.parse _
    val concrete = parse_attribute (attribute ("""AnchorKind.concrete"""))
    val helix = parse_attribute (attribute ("""AnchorKind.helix"""))
    val multiHelix = parse_attribute (attribute ("""AnchorKind.multiHelix"""))
    val other = parse_attribute (attribute ("""AnchorKind.other"""))
    val rod = parse_attribute (attribute ("""AnchorKind.rod"""))
    val screw = parse_attribute (attribute ("""AnchorKind.screw"""))
    val unknown = parse_attribute (attribute ("""AnchorKind.unknown"""))
    def parse (context: Context): AnchorKind =
    {
        AnchorKind(
            sup (context),
            concrete (context),
            helix (context),
            multiHelix (context),
            other (context),
            rod (context),
            screw (context),
            unknown (context)
        )
    }
}

/**
 * An Asset Property that is described through curves rather than as a data point.
 * The relationship is to be defined between an independent variable (X-axis) and one or two dependent variables (Y1-axis and Y2-axis).
 * @param sup Reference to the superclass object.
 * @param Specification
 */
case class AssetPropertyCurve
(
    override val sup: Element,
    val Specification: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetPropertyCurve]) }
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
    val sup = Curve.parse _
    val Specification = parse_attribute (attribute ("""AssetPropertyCurve.Specification"""))
    def parse (context: Context): AssetPropertyCurve =
    {
        AssetPropertyCurve(
            sup (context),
            Specification (context)
        )
    }
}

/**
 * Bushing asset.
 * @param sup Reference to the superclass object.
 * @param c1Capacitance Factory measured capacitance, measured between the power factor tap and the bushing conductor.
 * @param c1PowerFactor Factory measured insulation power factor, measured between the power factor tap and the bushing conductor.
 * @param c2Capacitance Factory measured capacitance measured between the power factor tap and ground.
 * @param c2PowerFactor Factory measured insulation power factor, measured between the power factor tap and ground.
 * @param insulationKind Kind of insulation.
 * @param Terminal
 */
case class Bushing
(
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[Bushing]) }
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
    val sup = Asset.parse _
    val c1Capacitance = parse_element (element ("""Bushing.c1Capacitance"""))
    val c1PowerFactor = parse_element (element ("""Bushing.c1PowerFactor"""))
    val c2Capacitance = parse_element (element ("""Bushing.c2Capacitance"""))
    val c2PowerFactor = parse_element (element ("""Bushing.c2PowerFactor"""))
    val insulationKind = parse_attribute (attribute ("""Bushing.insulationKind"""))
    val Terminal = parse_attribute (attribute ("""Bushing.Terminal"""))
    def parse (context: Context): Bushing =
    {
        Bushing(
            sup (context),
            toDouble (c1Capacitance (context), context),
            toDouble (c1PowerFactor (context), context),
            toDouble (c2Capacitance (context), context),
            toDouble (c2PowerFactor (context), context),
            insulationKind (context),
            Terminal (context)
        )
    }
}

/**
 * Insulation kind for bushings.
 * @param sup Reference to the superclass object.
 * @param compound
 * @param other
 * @param paperoil
 * @param solidPorcelain
 */
case class BushingInsulationKind
(
    override val sup: Element,
    val compound: String,
    val other: String,
    val paperoil: String,
    val solidPorcelain: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BushingInsulationKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BushingInsulationKind
extends
    Parseable[BushingInsulationKind]
{
    val sup = BasicElement.parse _
    val compound = parse_attribute (attribute ("""BushingInsulationKind.compound"""))
    val other = parse_attribute (attribute ("""BushingInsulationKind.other"""))
    val paperoil = parse_attribute (attribute ("""BushingInsulationKind.paperoil"""))
    val solidPorcelain = parse_attribute (attribute ("""BushingInsulationKind.solidPorcelain"""))
    def parse (context: Context): BushingInsulationKind =
    {
        BushingInsulationKind(
            sup (context),
            compound (context),
            other (context),
            paperoil (context),
            solidPorcelain (context)
        )
    }
}

/**
 * Bushing insulation power factor condition as a result of a test.
 * Typical status values are: Acceptable, Minor Deterioration or Moisture Absorption, Major Deterioration or Moisture Absorption, Failed.
 * @param sup Reference to the superclass object.
 * @param status
 * @param testKind Kind of test for this bushing.
 * @param Bushing
 * @param TransformerObservation
 */
case class BushingInsulationPF
(
    override val sup: Element,
    val status: String,
    val testKind: String,
    val Bushing: String,
    val TransformerObservation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[BushingInsulationPF]) }
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
    val sup = IdentifiedObject.parse _
    val status = parse_attribute (attribute ("""BushingInsulationPF.status"""))
    val testKind = parse_attribute (attribute ("""BushingInsulationPF.testKind"""))
    val Bushing = parse_attribute (attribute ("""BushingInsulationPF.Bushing"""))
    val TransformerObservation = parse_attribute (attribute ("""BushingInsulationPF.TransformerObservation"""))
    def parse (context: Context): BushingInsulationPF =
    {
        BushingInsulationPF(
            sup (context),
            status (context),
            testKind (context),
            Bushing (context),
            TransformerObservation (context)
        )
    }
}

/**
 * Kind of PF test for bushing insulation.
 * @param sup Reference to the superclass object.
 * @param c1 Power factor tap-to-ground.
 * @param c2 Power factor tap-to-conductor.
 */
case class BushingInsulationPfTestKind
(
    override val sup: Element,
    val c1: String,
    val c2: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BushingInsulationPfTestKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BushingInsulationPfTestKind
extends
    Parseable[BushingInsulationPfTestKind]
{
    val sup = BasicElement.parse _
    val c1 = parse_attribute (attribute ("""BushingInsulationPfTestKind.c1"""))
    val c2 = parse_attribute (attribute ("""BushingInsulationPfTestKind.c2"""))
    def parse (context: Context): BushingInsulationPfTestKind =
    {
        BushingInsulationPfTestKind(
            sup (context),
            c1 (context),
            c2 (context)
        )
    }
}

/**
 * Enclosure that offers protection to the equipment it contains and/or safety to people/animals outside it.
 * @param sup Reference to the superclass object.
 */
case class Cabinet
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def AssetContainer: AssetContainer = sup.asInstanceOf[AssetContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[Cabinet]) }
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
    val sup = AssetContainer.parse _
    def parse (context: Context): Cabinet =
    {
        Cabinet(
            sup (context)
        )
    }
}

/**
 * Kind of cooling.
 * @param sup Reference to the superclass object.
 * @param forcedAir
 * @param forcedOilAndAir
 * @param other
 * @param selfCooling
 */
case class CoolingKind
(
    override val sup: Element,
    val forcedAir: String,
    val forcedOilAndAir: String,
    val other: String,
    val selfCooling: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CoolingKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CoolingKind
extends
    Parseable[CoolingKind]
{
    val sup = BasicElement.parse _
    val forcedAir = parse_attribute (attribute ("""CoolingKind.forcedAir"""))
    val forcedOilAndAir = parse_attribute (attribute ("""CoolingKind.forcedOilAndAir"""))
    val other = parse_attribute (attribute ("""CoolingKind.other"""))
    val selfCooling = parse_attribute (attribute ("""CoolingKind.selfCooling"""))
    def parse (context: Context): CoolingKind =
    {
        CoolingKind(
            sup (context),
            forcedAir (context),
            forcedOilAndAir (context),
            other (context),
            selfCooling (context)
        )
    }
}

/**
 * There are often stages of power which are associated with stages of cooling.
 * For instance, a transformer may be rated 121kV on the primary, 15kV on the secondary and 4kV on the tertiary winding. These are voltage ratings and the power ratings are generally the same for all three windings and independent of the voltage ratings, there are instances where the tertiary may have a lower power rating.
 * @param sup Reference to the superclass object.
 * @param coolingKind Kind of cooling system.
 * @param powerRating The power rating associated with type of cooling specified for this stage.
 * @param stage Stage of cooling and associated power rating.
 * @param Reconditionings
 */
case class CoolingPowerRating
(
    override val sup: Element,
    val coolingKind: String,
    val powerRating: Double,
    val stage: Int,
    val Reconditionings: List[String]
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CoolingPowerRating]) }
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
    val sup = IdentifiedObject.parse _
    val coolingKind = parse_attribute (attribute ("""CoolingPowerRating.coolingKind"""))
    val powerRating = parse_element (element ("""CoolingPowerRating.powerRating"""))
    val stage = parse_element (element ("""CoolingPowerRating.stage"""))
    val Reconditionings = parse_attributes (attribute ("""CoolingPowerRating.Reconditionings"""))
    def parse (context: Context): CoolingPowerRating =
    {
        CoolingPowerRating(
            sup (context),
            coolingKind (context),
            toDouble (powerRating (context), context),
            toInteger (stage (context), context),
            Reconditionings (context)
        )
    }
}

/**
 * As applicable, the basic linear, area, or volume dimensions of an asset, asset type (AssetModel) or other type of object (such as land area).
 * Units and multipliers are specified per dimension.
 * @param sup Reference to the superclass object.
 * @param orientation A description of the orientation of the object relative to the dimensions.
 *        As an example, a vault may have north-south orientation for the sizeLength measurement and sizeDepth may be the height of the vault.
 * @param sizeDepth Depth measurement.
 * @param sizeDiameter Diameter measurement.
 * @param sizeLength Length measurement.
 * @param sizeWidth Width measurement.
 * @param Specifications
 */
case class DimensionsInfo
(
    override val sup: Element,
    val orientation: String,
    val sizeDepth: Double,
    val sizeDiameter: Double,
    val sizeLength: Double,
    val sizeWidth: Double,
    val Specifications: List[String]
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DimensionsInfo]) }
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
    val sup = IdentifiedObject.parse _
    val orientation = parse_element (element ("""DimensionsInfo.orientation"""))
    val sizeDepth = parse_element (element ("""DimensionsInfo.sizeDepth"""))
    val sizeDiameter = parse_element (element ("""DimensionsInfo.sizeDiameter"""))
    val sizeLength = parse_element (element ("""DimensionsInfo.sizeLength"""))
    val sizeWidth = parse_element (element ("""DimensionsInfo.sizeWidth"""))
    val Specifications = parse_attributes (attribute ("""DimensionsInfo.Specifications"""))
    def parse (context: Context): DimensionsInfo =
    {
        DimensionsInfo(
            sup (context),
            orientation (context),
            toDouble (sizeDepth (context), context),
            toDouble (sizeDiameter (context), context),
            toDouble (sizeLength (context), context),
            toDouble (sizeWidth (context), context),
            Specifications (context)
        )
    }
}

/**
 * A duct contains individual wires in the layout as specified with associated wire spacing instances; number of them gives the number of conductors in this duct.
 * @param sup Reference to the superclass object.
 * @param circuitCount Number of circuits in duct bank.
 *        Refer to associations between a duct (ConductorAsset) and an ACLineSegment to understand which circuits are in which ducts.
 */
case class DuctBank
(
    override val sup: Element,
    val circuitCount: Int
)
extends
    Element
{
    def this () = { this (null, 0) }
    def AssetContainer: AssetContainer = sup.asInstanceOf[AssetContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[DuctBank]) }
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
    val sup = AssetContainer.parse _
    val circuitCount = parse_element (element ("""DuctBank.circuitCount"""))
    def parse (context: Context): DuctBank =
    {
        DuctBank(
            sup (context),
            toInteger (circuitCount (context), context)
        )
    }
}

/**
 * FACTS device asset.
 * @param sup Reference to the superclass object.
 * @param kind Kind of FACTS device.
 */
case class FACTSDevice
(
    override val sup: Element,
    val kind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[FACTSDevice]) }
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
    val sup = Asset.parse _
    val kind = parse_attribute (attribute ("""FACTSDevice.kind"""))
    def parse (context: Context): FACTSDevice =
    {
        FACTSDevice(
            sup (context),
            kind (context)
        )
    }
}

/**
 * Kind of FACTS device.
 * @param sup Reference to the superclass object.
 * @param statcom Static synchronous compensator.
 * @param svc Static VAr compensator.
 * @param tcpar Thyristor-controlled phase-angle regulator.
 * @param tcsc Thyristor-controlled series capacitor.
 * @param tcvl Thyristor-controlled voltage limiter.
 * @param tsbr Thyristor-switched braking resistor.
 * @param tssc Thyristor-switched series capacitor.
 * @param upfc Unified power flow controller.
 */
case class FACTSDeviceKind
(
    override val sup: Element,
    val statcom: String,
    val svc: String,
    val tcpar: String,
    val tcsc: String,
    val tcvl: String,
    val tsbr: String,
    val tssc: String,
    val upfc: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[FACTSDeviceKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FACTSDeviceKind
extends
    Parseable[FACTSDeviceKind]
{
    val sup = BasicElement.parse _
    val statcom = parse_attribute (attribute ("""FACTSDeviceKind.statcom"""))
    val svc = parse_attribute (attribute ("""FACTSDeviceKind.svc"""))
    val tcpar = parse_attribute (attribute ("""FACTSDeviceKind.tcpar"""))
    val tcsc = parse_attribute (attribute ("""FACTSDeviceKind.tcsc"""))
    val tcvl = parse_attribute (attribute ("""FACTSDeviceKind.tcvl"""))
    val tsbr = parse_attribute (attribute ("""FACTSDeviceKind.tsbr"""))
    val tssc = parse_attribute (attribute ("""FACTSDeviceKind.tssc"""))
    val upfc = parse_attribute (attribute ("""FACTSDeviceKind.upfc"""))
    def parse (context: Context): FACTSDeviceKind =
    {
        FACTSDeviceKind(
            sup (context),
            statcom (context),
            svc (context),
            tcpar (context),
            tcsc (context),
            tcvl (context),
            tsbr (context),
            tssc (context),
            upfc (context)
        )
    }
}

/**
 * A facility may contain buildings, storage facilities, switching facilities, power generation, manufacturing facilities, maintenance facilities, etc.
 * @param sup Reference to the superclass object.
 * @param kind Kind of this facility.
 */
case class Facility
(
    override val sup: Element,
    val kind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def AssetContainer: AssetContainer = sup.asInstanceOf[AssetContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[Facility]) }
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
    val sup = AssetContainer.parse _
    val kind = parse_element (element ("""Facility.kind"""))
    def parse (context: Context): Facility =
    {
        Facility(
            sup (context),
            kind (context)
        )
    }
}

/**
 * An event where an asset has failed to perform its functions within specified parameters.
 * @param sup Reference to the superclass object.
 * @param corporateCode Code for asset failure.
 * @param failureIsolationMethod How the asset failure was isolated from the system.
 * @param faultLocatingMethod The method used for locating the faulted part of the asset.
 *        For example, cable options include: Cap Discharge-Thumping, Bridge Method, Visual Inspection, Other.
 * @param location Failure location on an object.
 */
case class FailureEvent
(
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[FailureEvent]) }
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
    val sup = ActivityRecord.parse _
    val corporateCode = parse_element (element ("""FailureEvent.corporateCode"""))
    val failureIsolationMethod = parse_attribute (attribute ("""FailureEvent.failureIsolationMethod"""))
    val faultLocatingMethod = parse_element (element ("""FailureEvent.faultLocatingMethod"""))
    val location = parse_element (element ("""FailureEvent.location"""))
    def parse (context: Context): FailureEvent =
    {
        FailureEvent(
            sup (context),
            corporateCode (context),
            failureIsolationMethod (context),
            faultLocatingMethod (context),
            location (context)
        )
    }
}

/**
 * How the failure has been isolated.
 * @param sup Reference to the superclass object.
 * @param breakerOperation
 * @param burnedInTheClear
 * @param fuse
 * @param manuallyIsolated
 * @param other
 */
case class FailureIsolationMethodKind
(
    override val sup: Element,
    val breakerOperation: String,
    val burnedInTheClear: String,
    val fuse: String,
    val manuallyIsolated: String,
    val other: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[FailureIsolationMethodKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FailureIsolationMethodKind
extends
    Parseable[FailureIsolationMethodKind]
{
    val sup = BasicElement.parse _
    val breakerOperation = parse_attribute (attribute ("""FailureIsolationMethodKind.breakerOperation"""))
    val burnedInTheClear = parse_attribute (attribute ("""FailureIsolationMethodKind.burnedInTheClear"""))
    val fuse = parse_attribute (attribute ("""FailureIsolationMethodKind.fuse"""))
    val manuallyIsolated = parse_attribute (attribute ("""FailureIsolationMethodKind.manuallyIsolated"""))
    val other = parse_attribute (attribute ("""FailureIsolationMethodKind.other"""))
    def parse (context: Context): FailureIsolationMethodKind =
    {
        FailureIsolationMethodKind(
            sup (context),
            breakerOperation (context),
            burnedInTheClear (context),
            fuse (context),
            manuallyIsolated (context),
            other (context)
        )
    }
}

/**
 * Various current financial properties associated with a particular asset.
 * Historical properties may be determined by ActivityRecords associated with the asset.
 * @param sup Reference to the superclass object.
 * @param account The account to which this actual material item is charged.
 * @param actualPurchaseCost The actual purchase cost of this particular asset.
 * @param costDescription Description of the cost.
 * @param costType Type of cost to which this Material Item belongs.
 * @param financialValue Value of asset as of 'valueDateTime'.
 * @param plantTransferDateTime Date and time asset's financial value was put in plant for regulatory accounting purposes (e.g., for rate base calculations).
 *        This is sometime referred to as the "in-service date".
 * @param purchaseDateTime Date and time asset was purchased.
 * @param purchaseOrderNumber Purchase order identifier.
 * @param quantity The quantity of the asset if per unit length, for example conductor.
 * @param valueDateTime Date and time at which the financial value was last established.
 * @param warrantyEndDateTime Date and time warranty on asset expires.
 * @param Asset
 */
case class FinancialInfo
(
    override val sup: Element,
    val account: String,
    val actualPurchaseCost: Double,
    val costDescription: String,
    val costType: String,
    val financialValue: Double,
    val plantTransferDateTime: String,
    val purchaseDateTime: String,
    val purchaseOrderNumber: String,
    val quantity: String,
    val valueDateTime: String,
    val warrantyEndDateTime: String,
    val Asset: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, 0.0, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[FinancialInfo]) }
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
    val sup = IdentifiedObject.parse _
    val account = parse_element (element ("""FinancialInfo.account"""))
    val actualPurchaseCost = parse_element (element ("""FinancialInfo.actualPurchaseCost"""))
    val costDescription = parse_element (element ("""FinancialInfo.costDescription"""))
    val costType = parse_element (element ("""FinancialInfo.costType"""))
    val financialValue = parse_element (element ("""FinancialInfo.financialValue"""))
    val plantTransferDateTime = parse_element (element ("""FinancialInfo.plantTransferDateTime"""))
    val purchaseDateTime = parse_element (element ("""FinancialInfo.purchaseDateTime"""))
    val purchaseOrderNumber = parse_element (element ("""FinancialInfo.purchaseOrderNumber"""))
    val quantity = parse_attribute (attribute ("""FinancialInfo.quantity"""))
    val valueDateTime = parse_element (element ("""FinancialInfo.valueDateTime"""))
    val warrantyEndDateTime = parse_element (element ("""FinancialInfo.warrantyEndDateTime"""))
    val Asset = parse_attribute (attribute ("""FinancialInfo.Asset"""))
    def parse (context: Context): FinancialInfo =
    {
        FinancialInfo(
            sup (context),
            account (context),
            toDouble (actualPurchaseCost (context), context),
            costDescription (context),
            costType (context),
            toDouble (financialValue (context), context),
            plantTransferDateTime (context),
            purchaseDateTime (context),
            purchaseOrderNumber (context),
            quantity (context),
            valueDateTime (context),
            warrantyEndDateTime (context),
            Asset (context)
        )
    }
}

/**
 * Generic asset or material item that may be used for planning, work or design purposes.
 * @param sup Reference to the superclass object.
 * @param estimatedUnitCost Estimated unit cost (or cost per unit length) of this type of asset.
 *        It does not include labor to install/construct or configure it.
 * @param quantity The value, unit of measure, and multiplier for the quantity.
 * @param stockItem True if item is a stock item (default).
 * @param CUAsset
 * @param CUWorkEquipmentAsset
 * @param TypeAssetCatalogue
 */
case class GenericAssetModelOrMaterial
(
    override val sup: Element,
    val estimatedUnitCost: Double,
    val quantity: String,
    val stockItem: Boolean,
    val CUAsset: String,
    val CUWorkEquipmentAsset: String,
    val TypeAssetCatalogue: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, false, null, null, null) }
    def AssetModel: AssetModel = sup.asInstanceOf[AssetModel]
    override def copy (): Row = { return (clone ().asInstanceOf[GenericAssetModelOrMaterial]) }
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
    val sup = AssetModel.parse _
    val estimatedUnitCost = parse_element (element ("""GenericAssetModelOrMaterial.estimatedUnitCost"""))
    val quantity = parse_attribute (attribute ("""GenericAssetModelOrMaterial.quantity"""))
    val stockItem = parse_element (element ("""GenericAssetModelOrMaterial.stockItem"""))
    val CUAsset = parse_attribute (attribute ("""GenericAssetModelOrMaterial.CUAsset"""))
    val CUWorkEquipmentAsset = parse_attribute (attribute ("""GenericAssetModelOrMaterial.CUWorkEquipmentAsset"""))
    val TypeAssetCatalogue = parse_attribute (attribute ("""GenericAssetModelOrMaterial.TypeAssetCatalogue"""))
    def parse (context: Context): GenericAssetModelOrMaterial =
    {
        GenericAssetModelOrMaterial(
            sup (context),
            toDouble (estimatedUnitCost (context), context),
            quantity (context),
            toBoolean (stockItem (context), context),
            CUAsset (context),
            CUWorkEquipmentAsset (context),
            TypeAssetCatalogue (context)
        )
    }
}

/**
 * Joint connects two or more cables.
 * It includes the portion of cable under wipes, welds, or other seals.
 * @param sup Reference to the superclass object.
 * @param configurationKind Configuration of joint.
 * @param fillKind Material used to fill the joint.
 * @param insulation The type of insulation around the joint, classified according to the utility's asset management standards and practices.
 */
case class Joint
(
    override val sup: Element,
    val configurationKind: String,
    val fillKind: String,
    val insulation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[Joint]) }
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
    val sup = Asset.parse _
    val configurationKind = parse_attribute (attribute ("""Joint.configurationKind"""))
    val fillKind = parse_attribute (attribute ("""Joint.fillKind"""))
    val insulation = parse_element (element ("""Joint.insulation"""))
    def parse (context: Context): Joint =
    {
        Joint(
            sup (context),
            configurationKind (context),
            fillKind (context),
            insulation (context)
        )
    }
}

/**
 * Kind of configuration for joints.
 * @param sup Reference to the superclass object.
 * @param other
 * @param wires1to1
 * @param wires2to1
 * @param wires3to1
 */
case class JointConfigurationKind
(
    override val sup: Element,
    val other: String,
    val wires1to1: String,
    val wires2to1: String,
    val wires3to1: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[JointConfigurationKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object JointConfigurationKind
extends
    Parseable[JointConfigurationKind]
{
    val sup = BasicElement.parse _
    val other = parse_attribute (attribute ("""JointConfigurationKind.other"""))
    val wires1to1 = parse_attribute (attribute ("""JointConfigurationKind.wires1to1"""))
    val wires2to1 = parse_attribute (attribute ("""JointConfigurationKind.wires2to1"""))
    val wires3to1 = parse_attribute (attribute ("""JointConfigurationKind.wires3to1"""))
    def parse (context: Context): JointConfigurationKind =
    {
        JointConfigurationKind(
            sup (context),
            other (context),
            wires1to1 (context),
            wires2to1 (context),
            wires3to1 (context)
        )
    }
}

/**
 * Kind of fill for Joint.
 * @param sup Reference to the superclass object.
 * @param airNoFilling
 * @param asphaltic
 * @param bluefill254
 * @param epoxy
 * @param insoluseal
 * @param noFillPrefab
 * @param noVoid
 * @param oil
 * @param other
 * @param petrolatum
 */
case class JointFillKind
(
    override val sup: Element,
    val airNoFilling: String,
    val asphaltic: String,
    val bluefill254: String,
    val epoxy: String,
    val insoluseal: String,
    val noFillPrefab: String,
    val noVoid: String,
    val oil: String,
    val other: String,
    val petrolatum: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[JointFillKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object JointFillKind
extends
    Parseable[JointFillKind]
{
    val sup = BasicElement.parse _
    val airNoFilling = parse_attribute (attribute ("""JointFillKind.airNoFilling"""))
    val asphaltic = parse_attribute (attribute ("""JointFillKind.asphaltic"""))
    val bluefill254 = parse_attribute (attribute ("""JointFillKind.bluefill254"""))
    val epoxy = parse_attribute (attribute ("""JointFillKind.epoxy"""))
    val insoluseal = parse_attribute (attribute ("""JointFillKind.insoluseal"""))
    val noFillPrefab = parse_attribute (attribute ("""JointFillKind.noFillPrefab"""))
    val noVoid = parse_attribute (attribute ("""JointFillKind.noVoid"""))
    val oil = parse_attribute (attribute ("""JointFillKind.oil"""))
    val other = parse_attribute (attribute ("""JointFillKind.other"""))
    val petrolatum = parse_attribute (attribute ("""JointFillKind.petrolatum"""))
    def parse (context: Context): JointFillKind =
    {
        JointFillKind(
            sup (context),
            airNoFilling (context),
            asphaltic (context),
            bluefill254 (context),
            epoxy (context),
            insoluseal (context),
            noFillPrefab (context),
            noVoid (context),
            oil (context),
            other (context),
            petrolatum (context)
        )
    }
}

/**
 * A substance that either (1) provides the means of transmission of a force or effect, such as hydraulic fluid, or (2) is used for a surrounding or enveloping substance, such as oil in a transformer or circuit breaker.
 * @param sup Reference to the superclass object.
 * @param kind Kind of this medium.
 * @param volumeSpec The volume of the medium specified for this application.
 *        Note that the actual volume is a type of measurement associated witht the asset.
 * @param Assets
 * @param Specification
 */
case class Medium
(
    override val sup: Element,
    val kind: String,
    val volumeSpec: Double,
    val Assets: List[String],
    val Specification: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, List(), null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Medium]) }
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
    val sup = IdentifiedObject.parse _
    val kind = parse_attribute (attribute ("""Medium.kind"""))
    val volumeSpec = parse_element (element ("""Medium.volumeSpec"""))
    val Assets = parse_attributes (attribute ("""Medium.Assets"""))
    val Specification = parse_attribute (attribute ("""Medium.Specification"""))
    def parse (context: Context): Medium =
    {
        Medium(
            sup (context),
            kind (context),
            toDouble (volumeSpec (context), context),
            Assets (context),
            Specification (context)
        )
    }
}

/**
 * Kind of medium.
 * @param sup Reference to the superclass object.
 * @param gas
 * @param liquid
 * @param solid
 */
case class MediumKind
(
    override val sup: Element,
    val gas: String,
    val liquid: String,
    val solid: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MediumKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MediumKind
extends
    Parseable[MediumKind]
{
    val sup = BasicElement.parse _
    val gas = parse_attribute (attribute ("""MediumKind.gas"""))
    val liquid = parse_attribute (attribute ("""MediumKind.liquid"""))
    val solid = parse_attribute (attribute ("""MediumKind.solid"""))
    def parse (context: Context): MediumKind =
    {
        MediumKind(
            sup (context),
            gas (context),
            liquid (context),
            solid (context)
        )
    }
}

/**
 * Pole asset.
 * @param sup Reference to the superclass object.
 * @param baseKind Kind of base for this pole.
 * @param breastBlock True if a block of material has been attached to base of pole in ground for stability.
 *        This technique is used primarily when anchors can not be used.
 * @param classification Pole class: 1, 2, 3, 4, 5, 6, 7, H1, H2, Other, Unknown.
 * @param construction The framing structure mounted on the pole.
 * @param diameter Diameter of the pole.
 * @param jpaReference Joint pole agreement reference number.
 * @param len Length of the pole (inclusive of any section of the pole that may be underground post-installation).
 * @param preservativeKind Kind of preservative for this pole.
 * @param speciesType Pole species.
 *        Aluminum, Aluminum Davit, Concrete, Fiberglass, Galvanized Davit, Galvanized, Steel Davit Primed, Steel Davit, Steel Standard Primed, Steel, Truncated, Wood-Treated, Wood-Hard, Wood-Salt Treated, Wood-Soft, Wood, Other, Unknown.
 * @param treatedDateTime Date and time pole was last treated with preservative.
 * @param treatmentKind Kind of treatment for this pole.
 */
case class Pole
(
    override val sup: Element,
    val baseKind: String,
    val breastBlock: Boolean,
    val classification: String,
    val construction: String,
    val diameter: Double,
    val jpaReference: String,
    val len: Double,
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
    override def copy (): Row = { return (clone ().asInstanceOf[Pole]) }
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
    val sup = Structure.parse _
    val baseKind = parse_attribute (attribute ("""Pole.baseKind"""))
    val breastBlock = parse_element (element ("""Pole.breastBlock"""))
    val classification = parse_element (element ("""Pole.classification"""))
    val construction = parse_element (element ("""Pole.construction"""))
    val diameter = parse_element (element ("""Pole.diameter"""))
    val jpaReference = parse_element (element ("""Pole.jpaReference"""))
    val len = parse_element (element ("""Pole.length"""))
    val preservativeKind = parse_attribute (attribute ("""Pole.preservativeKind"""))
    val speciesType = parse_element (element ("""Pole.speciesType"""))
    val treatedDateTime = parse_element (element ("""Pole.treatedDateTime"""))
    val treatmentKind = parse_attribute (attribute ("""Pole.treatmentKind"""))
    def parse (context: Context): Pole =
    {
        Pole(
            sup (context),
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
    }
}

/**
 * Kind of base for poles.
 * @param sup Reference to the superclass object.
 * @param asphalt
 * @param cement
 * @param dirt
 * @param other
 * @param unknown
 */
case class PoleBaseKind
(
    override val sup: Element,
    val asphalt: String,
    val cement: String,
    val dirt: String,
    val other: String,
    val unknown: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PoleBaseKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PoleBaseKind
extends
    Parseable[PoleBaseKind]
{
    val sup = BasicElement.parse _
    val asphalt = parse_attribute (attribute ("""PoleBaseKind.asphalt"""))
    val cement = parse_attribute (attribute ("""PoleBaseKind.cement"""))
    val dirt = parse_attribute (attribute ("""PoleBaseKind.dirt"""))
    val other = parse_attribute (attribute ("""PoleBaseKind.other"""))
    val unknown = parse_attribute (attribute ("""PoleBaseKind.unknown"""))
    def parse (context: Context): PoleBaseKind =
    {
        PoleBaseKind(
            sup (context),
            asphalt (context),
            cement (context),
            dirt (context),
            other (context),
            unknown (context)
        )
    }
}

/**
 * Preservative kind for poles.
 * @param sup Reference to the superclass object.
 * @param cellon
 * @param chemonite
 * @param creosote
 * @param naphthena
 * @param other
 * @param penta
 * @param unknown
 */
case class PolePreservativeKind
(
    override val sup: Element,
    val cellon: String,
    val chemonite: String,
    val creosote: String,
    val naphthena: String,
    val other: String,
    val penta: String,
    val unknown: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PolePreservativeKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PolePreservativeKind
extends
    Parseable[PolePreservativeKind]
{
    val sup = BasicElement.parse _
    val cellon = parse_attribute (attribute ("""PolePreservativeKind.cellon"""))
    val chemonite = parse_attribute (attribute ("""PolePreservativeKind.chemonite"""))
    val creosote = parse_attribute (attribute ("""PolePreservativeKind.creosote"""))
    val naphthena = parse_attribute (attribute ("""PolePreservativeKind.naphthena"""))
    val other = parse_attribute (attribute ("""PolePreservativeKind.other"""))
    val penta = parse_attribute (attribute ("""PolePreservativeKind.penta"""))
    val unknown = parse_attribute (attribute ("""PolePreservativeKind.unknown"""))
    def parse (context: Context): PolePreservativeKind =
    {
        PolePreservativeKind(
            sup (context),
            cellon (context),
            chemonite (context),
            creosote (context),
            naphthena (context),
            other (context),
            penta (context),
            unknown (context)
        )
    }
}

/**
 * Kind of treatment for poles.
 * @param sup Reference to the superclass object.
 * @param butt
 * @param full
 * @param grayStain
 * @param greenStain
 * @param natural
 * @param other
 * @param penta
 * @param unknown
 */
case class PoleTreatmentKind
(
    override val sup: Element,
    val butt: String,
    val full: String,
    val grayStain: String,
    val greenStain: String,
    val natural: String,
    val other: String,
    val penta: String,
    val unknown: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PoleTreatmentKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PoleTreatmentKind
extends
    Parseable[PoleTreatmentKind]
{
    val sup = BasicElement.parse _
    val butt = parse_attribute (attribute ("""PoleTreatmentKind.butt"""))
    val full = parse_attribute (attribute ("""PoleTreatmentKind.full"""))
    val grayStain = parse_attribute (attribute ("""PoleTreatmentKind.grayStain"""))
    val greenStain = parse_attribute (attribute ("""PoleTreatmentKind.greenStain"""))
    val natural = parse_attribute (attribute ("""PoleTreatmentKind.natural"""))
    val other = parse_attribute (attribute ("""PoleTreatmentKind.other"""))
    val penta = parse_attribute (attribute ("""PoleTreatmentKind.penta"""))
    val unknown = parse_attribute (attribute ("""PoleTreatmentKind.unknown"""))
    def parse (context: Context): PoleTreatmentKind =
    {
        PoleTreatmentKind(
            sup (context),
            butt (context),
            full (context),
            grayStain (context),
            greenStain (context),
            natural (context),
            other (context),
            penta (context),
            unknown (context)
        )
    }
}

/**
 * Reconditioning information for an asset.
 * @param sup Reference to the superclass object.
 * @param dateTime Date and time this reconditioning (or a major overhaul) has been performed.
 * @param Asset
 */
case class Reconditioning
(
    override val sup: Element,
    val dateTime: String,
    val Asset: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Reconditioning]) }
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
    val sup = IdentifiedObject.parse _
    val dateTime = parse_element (element ("""Reconditioning.dateTime"""))
    val Asset = parse_attribute (attribute ("""Reconditioning.Asset"""))
    def parse (context: Context): Reconditioning =
    {
        Reconditioning(
            sup (context),
            dateTime (context),
            Asset (context)
        )
    }
}

/**
 * Information regarding the experienced and expected reliability of a specific asset, type of asset, or asset model.
 * @param sup Reference to the superclass object.
 * @param mTTR Mean time to repair (MTTR - hours).
 * @param momFailureRate Momentary failure rate (temporary failures/kft-year).
 * @param Assets
 * @param Specification
 */
case class ReliabilityInfo
(
    override val sup: Element,
    val mTTR: Double,
    val momFailureRate: Double,
    val Assets: List[String],
    val Specification: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, List(), null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ReliabilityInfo]) }
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
    val sup = IdentifiedObject.parse _
    val mTTR = parse_element (element ("""ReliabilityInfo.mTTR"""))
    val momFailureRate = parse_element (element ("""ReliabilityInfo.momFailureRate"""))
    val Assets = parse_attributes (attribute ("""ReliabilityInfo.Assets"""))
    val Specification = parse_attribute (attribute ("""ReliabilityInfo.Specification"""))
    def parse (context: Context): ReliabilityInfo =
    {
        ReliabilityInfo(
            sup (context),
            toDouble (mTTR (context), context),
            toDouble (momFailureRate (context), context),
            Assets (context),
            Specification (context)
        )
    }
}

/**
 * Specification can be used for various purposes relative to an asset, a logical device (PowerSystemResource), location, etc.
 * Examples include documents supplied by manufacturers such as asset installation instructions, asset maintenance instructions, etc.
 * @param sup Reference to the superclass object.
 */
case class Specification
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[Specification]) }
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
    val sup = Document.parse _
    def parse (context: Context): Specification =
    {
        Specification(
            sup (context)
        )
    }
}

/**
 * Streetlight asset.
 * @param sup Reference to the superclass object.
 * @param armLength Length of arm.
 *        Note that a new light may be placed on an existing arm.
 * @param lampKind Lamp kind.
 * @param lightRating Power rating of light.
 * @param Pole Pole to which thiss streetlight is attached.
 */
case class Streetlight
(
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[Streetlight]) }
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
    val sup = Asset.parse _
    val armLength = parse_element (element ("""Streetlight.armLength"""))
    val lampKind = parse_attribute (attribute ("""Streetlight.lampKind"""))
    val lightRating = parse_element (element ("""Streetlight.lightRating"""))
    val Pole = parse_attribute (attribute ("""Streetlight.Pole"""))
    def parse (context: Context): Streetlight =
    {
        Streetlight(
            sup (context),
            toDouble (armLength (context), context),
            lampKind (context),
            toDouble (lightRating (context), context),
            Pole (context)
        )
    }
}

/**
 * Kind of lamp for the streetlight.
 * @param sup Reference to the superclass object.
 * @param highPressureSodium
 * @param mercuryVapor
 * @param metalHalide
 * @param other
 */
case class StreetlightLampKind
(
    override val sup: Element,
    val highPressureSodium: String,
    val mercuryVapor: String,
    val metalHalide: String,
    val other: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[StreetlightLampKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StreetlightLampKind
extends
    Parseable[StreetlightLampKind]
{
    val sup = BasicElement.parse _
    val highPressureSodium = parse_attribute (attribute ("""StreetlightLampKind.highPressureSodium"""))
    val mercuryVapor = parse_attribute (attribute ("""StreetlightLampKind.mercuryVapor"""))
    val metalHalide = parse_attribute (attribute ("""StreetlightLampKind.metalHalide"""))
    val other = parse_attribute (attribute ("""StreetlightLampKind.other"""))
    def parse (context: Context): StreetlightLampKind =
    {
        StreetlightLampKind(
            sup (context),
            highPressureSodium (context),
            mercuryVapor (context),
            metalHalide (context),
            other (context)
        )
    }
}

/**
 * Construction holding assets such as conductors, transformers, switchgear, etc.
 * Where applicable, number of conductors can be derived from the number of associated wire spacing instances.
 * @param sup Reference to the superclass object.
 * @param fumigantAppliedDate Date fumigant was last applied.
 * @param fumigantName Name of fumigant.
 * @param height Visible height of structure above ground level for overhead construction (e.g., Pole or Tower) or below ground level for an underground vault, manhole, etc.
 *        Refer to associated DimensionPropertiesInfo for other types of dimensions.
 * @param materialKind Material this structure is made of.
 * @param ratedVoltage Maximum rated voltage of the equipment that can be mounted on/contained within the structure.
 * @param removeWeed True if weeds are to be removed around asset.
 * @param weedRemovedDate Date weed were last removed.
 */
case class Structure
(
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[Structure]) }
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
    val sup = AssetContainer.parse _
    val fumigantAppliedDate = parse_element (element ("""Structure.fumigantAppliedDate"""))
    val fumigantName = parse_element (element ("""Structure.fumigantName"""))
    val height = parse_element (element ("""Structure.height"""))
    val materialKind = parse_attribute (attribute ("""Structure.materialKind"""))
    val ratedVoltage = parse_element (element ("""Structure.ratedVoltage"""))
    val removeWeed = parse_element (element ("""Structure.removeWeed"""))
    val weedRemovedDate = parse_element (element ("""Structure.weedRemovedDate"""))
    def parse (context: Context): Structure =
    {
        Structure(
            sup (context),
            fumigantAppliedDate (context),
            fumigantName (context),
            toDouble (height (context), context),
            materialKind (context),
            toDouble (ratedVoltage (context), context),
            toBoolean (removeWeed (context), context),
            weedRemovedDate (context)
        )
    }
}

/**
 * Kind of material used for structures.
 * @param sup Reference to the superclass object.
 * @param concrete
 * @param other
 * @param steel
 * @param wood
 */
case class StructureMaterialKind
(
    override val sup: Element,
    val concrete: String,
    val other: String,
    val steel: String,
    val wood: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[StructureMaterialKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StructureMaterialKind
extends
    Parseable[StructureMaterialKind]
{
    val sup = BasicElement.parse _
    val concrete = parse_attribute (attribute ("""StructureMaterialKind.concrete"""))
    val other = parse_attribute (attribute ("""StructureMaterialKind.other"""))
    val steel = parse_attribute (attribute ("""StructureMaterialKind.steel"""))
    val wood = parse_attribute (attribute ("""StructureMaterialKind.wood"""))
    def parse (context: Context): StructureMaterialKind =
    {
        StructureMaterialKind(
            sup (context),
            concrete (context),
            other (context),
            steel (context),
            wood (context)
        )
    }
}

/**
 * Support for structure assets.
 * @param sup Reference to the superclass object.
 * @param anchorKind (if anchor) Kind of anchor.
 * @param anchorRodCount (if anchor) Number of rods used.
 * @param anchorRodLength (if anchor) Length of rod used.
 * @param direction Direction of this support structure.
 * @param kind Kind of structure support.
 * @param len Length of this support structure.
 * @param size1 Size of this support structure.
 * @param SecuredStructure
 */
case class StructureSupport
(
    override val sup: Element,
    val anchorKind: String,
    val anchorRodCount: Int,
    val anchorRodLength: Double,
    val direction: Double,
    val kind: String,
    val len: Double,
    val size1: String,
    val SecuredStructure: String
)
extends
    Element
{
    def this () = { this (null, null, 0, 0.0, 0.0, null, 0.0, null, null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[StructureSupport]) }
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
    val sup = Asset.parse _
    val anchorKind = parse_attribute (attribute ("""StructureSupport.anchorKind"""))
    val anchorRodCount = parse_element (element ("""StructureSupport.anchorRodCount"""))
    val anchorRodLength = parse_element (element ("""StructureSupport.anchorRodLength"""))
    val direction = parse_element (element ("""StructureSupport.direction"""))
    val kind = parse_attribute (attribute ("""StructureSupport.kind"""))
    val len = parse_element (element ("""StructureSupport.length"""))
    val size1 = parse_element (element ("""StructureSupport.size"""))
    val SecuredStructure = parse_attribute (attribute ("""StructureSupport.SecuredStructure"""))
    def parse (context: Context): StructureSupport =
    {
        StructureSupport(
            sup (context),
            anchorKind (context),
            toInteger (anchorRodCount (context), context),
            toDouble (anchorRodLength (context), context),
            toDouble (direction (context), context),
            kind (context),
            toDouble (len (context), context),
            size1 (context),
            SecuredStructure (context)
        )
    }
}

/**
 * Kind of structure support.
 * @param sup Reference to the superclass object.
 * @param anchor
 * @param guy
 */
case class StructureSupportKind
(
    override val sup: Element,
    val anchor: String,
    val guy: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[StructureSupportKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StructureSupportKind
extends
    Parseable[StructureSupportKind]
{
    val sup = BasicElement.parse _
    val anchor = parse_attribute (attribute ("""StructureSupportKind.anchor"""))
    val guy = parse_attribute (attribute ("""StructureSupportKind.guy"""))
    def parse (context: Context): StructureSupportKind =
    {
        StructureSupportKind(
            sup (context),
            anchor (context),
            guy (context)
        )
    }
}

/**
 * Tower asset.
 * Dimensions of the Tower are specified in associated DimensionsInfo class.
 * @param sup Reference to the superclass object.
 * @param constructionKind Construction structure on the tower.
 */
case class Tower
(
    override val sup: Element,
    val constructionKind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Structure: Structure = sup.asInstanceOf[Structure]
    override def copy (): Row = { return (clone ().asInstanceOf[Tower]) }
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
    val sup = Structure.parse _
    val constructionKind = parse_attribute (attribute ("""Tower.constructionKind"""))
    def parse (context: Context): Tower =
    {
        Tower(
            sup (context),
            constructionKind (context)
        )
    }
}

/**
 * Kind of tower construction.
 * @param sup Reference to the superclass object.
 * @param suspension
 * @param tension
 */
case class TowerConstructionKind
(
    override val sup: Element,
    val suspension: String,
    val tension: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TowerConstructionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TowerConstructionKind
extends
    Parseable[TowerConstructionKind]
{
    val sup = BasicElement.parse _
    val suspension = parse_attribute (attribute ("""TowerConstructionKind.suspension"""))
    val tension = parse_attribute (attribute ("""TowerConstructionKind.tension"""))
    def parse (context: Context): TowerConstructionKind =
    {
        TowerConstructionKind(
            sup (context),
            suspension (context),
            tension (context)
        )
    }
}

/**
 * Common information captured during transformer inspections and/or diagnostics.
 * Note that some properties may be measured through other means and therefore have measurement values in addition to the observed values recorded here.
 * @param sup Reference to the superclass object.
 * @param bushingTemp Bushing temperature.
 * @param dga Dissolved Gas Analysis.
 *        Typical values are: Acceptable, Overheating, Corona, Sparking, Arcing.
 * @param freqResp Frequency Response Analysis.
 *        Typical values are: acceptable, slight movement, significant movement, failed, near failure. A graphic of the response diagram, which is a type of document, may be associated with this analysis through the recursive document relationship of the ProcedureDataSet.
 * @param furfuralDP Overall measure of furfural in oil and mechanical strength of paper.
 *        DP, the degree of polymerization, is the strength of the paper. Furfural is a measure of furfural compounds, often expressed in parts per million.
 * @param hotSpotTemp Hotspot oil temperature.
 * @param oilColor Oil Quality Analysis-Color.
 * @param oilDielectricStrength Oil Quality Analysis-Dielectric Strength.
 * @param oilIFT Oil Quality Analysis- inter facial tension (IFT) - number-Dynes/CM.
 * @param oilLevel The level of oil in the transformer.
 * @param oilNeutralizationNumber Oil Quality Analysis-Neutralization Number - Number - Mg KOH.
 * @param pumpVibration Pump vibration, with typical values being: nominal, high.
 * @param status
 * @param topOilTemp Top oil temperature.
 * @param waterContent Water Content expressed in parts per million.
 * @param Reconditioning
 * @param Transformer
 */
case class TransformerObservation
(
    override val sup: Element,
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
    val status: String,
    val topOilTemp: Double,
    val waterContent: String,
    val Reconditioning: String,
    val Transformer: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, 0.0, null, 0.0, null, null, null, null, null, 0.0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerObservation]) }
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
    val sup = IdentifiedObject.parse _
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
    val status = parse_attribute (attribute ("""TransformerObservation.status"""))
    val topOilTemp = parse_element (element ("""TransformerObservation.topOilTemp"""))
    val waterContent = parse_element (element ("""TransformerObservation.waterContent"""))
    val Reconditioning = parse_attribute (attribute ("""TransformerObservation.Reconditioning"""))
    val Transformer = parse_attribute (attribute ("""TransformerObservation.Transformer"""))
    def parse (context: Context): TransformerObservation =
    {
        TransformerObservation(
            sup (context),
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
            status (context),
            toDouble (topOilTemp (context), context),
            waterContent (context),
            Reconditioning (context),
            Transformer (context)
        )
    }
}

/**
 * Underground structure.
 * @param sup Reference to the superclass object.
 * @param hasVentilation True if vault is ventilating.
 * @param kind True if vault is ventilating.
 * @param material Primary material of underground structure.
 * @param sealingWarrantyExpiresDate Date sealing warranty expires.
 */
case class UndergroundStructure
(
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[UndergroundStructure]) }
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
    val sup = Structure.parse _
    val hasVentilation = parse_element (element ("""UndergroundStructure.hasVentilation"""))
    val kind = parse_attribute (attribute ("""UndergroundStructure.kind"""))
    val material = parse_element (element ("""UndergroundStructure.material"""))
    val sealingWarrantyExpiresDate = parse_element (element ("""UndergroundStructure.sealingWarrantyExpiresDate"""))
    def parse (context: Context): UndergroundStructure =
    {
        UndergroundStructure(
            sup (context),
            toBoolean (hasVentilation (context), context),
            kind (context),
            material (context),
            sealingWarrantyExpiresDate (context)
        )
    }
}

/**
 * Kind of underground structure.
 * @param sup Reference to the superclass object.
 * @param burd
 * @param enclosure
 * @param handhole
 * @param manhole
 * @param pad
 * @param pullbox
 * @param subsurfaceEnclosure
 * @param trench
 * @param tunnel
 * @param vault
 */
case class UndergroundStructureKind
(
    override val sup: Element,
    val burd: String,
    val enclosure: String,
    val handhole: String,
    val manhole: String,
    val pad: String,
    val pullbox: String,
    val subsurfaceEnclosure: String,
    val trench: String,
    val tunnel: String,
    val vault: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[UndergroundStructureKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UndergroundStructureKind
extends
    Parseable[UndergroundStructureKind]
{
    val sup = BasicElement.parse _
    val burd = parse_attribute (attribute ("""UndergroundStructureKind.burd"""))
    val enclosure = parse_attribute (attribute ("""UndergroundStructureKind.enclosure"""))
    val handhole = parse_attribute (attribute ("""UndergroundStructureKind.handhole"""))
    val manhole = parse_attribute (attribute ("""UndergroundStructureKind.manhole"""))
    val pad = parse_attribute (attribute ("""UndergroundStructureKind.pad"""))
    val pullbox = parse_attribute (attribute ("""UndergroundStructureKind.pullbox"""))
    val subsurfaceEnclosure = parse_attribute (attribute ("""UndergroundStructureKind.subsurfaceEnclosure"""))
    val trench = parse_attribute (attribute ("""UndergroundStructureKind.trench"""))
    val tunnel = parse_attribute (attribute ("""UndergroundStructureKind.tunnel"""))
    val vault = parse_attribute (attribute ("""UndergroundStructureKind.vault"""))
    def parse (context: Context): UndergroundStructureKind =
    {
        UndergroundStructureKind(
            sup (context),
            burd (context),
            enclosure (context),
            handhole (context),
            manhole (context),
            pad (context),
            pullbox (context),
            subsurfaceEnclosure (context),
            trench (context),
            tunnel (context),
            vault (context)
        )
    }
}

/**
 * Winding insulation condition as a result of a test.
 * @param sup Reference to the superclass object.
 * @param insulationPFStatus Status of Winding Insulation Power Factor as of statusDate: Acceptable, Minor Deterioration or Moisture Absorption, Major Deterioration or Moisture Absorption, Failed.
 * @param insulationResistance For testType, status of Winding Insulation Resistance as of statusDate.
 *        Typical values are: Acceptable, Questionable, Failed.
 * @param leakageReactance As of statusDate, the leakage reactance measured at the "from" winding with the "to" winding short-circuited and all other windings open-circuited.
 * @param status
 * @param FromWinding
 * @param ToWinding
 * @param TransformerObservation
 */
case class WindingInsulation
(
    override val sup: Element,
    val insulationPFStatus: String,
    val insulationResistance: String,
    val leakageReactance: Double,
    val status: String,
    val FromWinding: String,
    val ToWinding: String,
    val TransformerObservation: String
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindingInsulation]) }
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
    val sup = IdentifiedObject.parse _
    val insulationPFStatus = parse_element (element ("""WindingInsulation.insulationPFStatus"""))
    val insulationResistance = parse_element (element ("""WindingInsulation.insulationResistance"""))
    val leakageReactance = parse_element (element ("""WindingInsulation.leakageReactance"""))
    val status = parse_attribute (attribute ("""WindingInsulation.status"""))
    val FromWinding = parse_attribute (attribute ("""WindingInsulation.FromWinding"""))
    val ToWinding = parse_attribute (attribute ("""WindingInsulation.ToWinding"""))
    val TransformerObservation = parse_attribute (attribute ("""WindingInsulation.TransformerObservation"""))
    def parse (context: Context): WindingInsulation =
    {
        WindingInsulation(
            sup (context),
            insulationPFStatus (context),
            insulationResistance (context),
            toDouble (leakageReactance (context), context),
            status (context),
            FromWinding (context),
            ToWinding (context),
            TransformerObservation (context)
        )
    }
}

object _InfAssets
{
    def register: Unit =
    {
        AnchorKind.register
        AssetPropertyCurve.register
        Bushing.register
        BushingInsulationKind.register
        BushingInsulationPF.register
        BushingInsulationPfTestKind.register
        Cabinet.register
        CoolingKind.register
        CoolingPowerRating.register
        DimensionsInfo.register
        DuctBank.register
        FACTSDevice.register
        FACTSDeviceKind.register
        Facility.register
        FailureEvent.register
        FailureIsolationMethodKind.register
        FinancialInfo.register
        GenericAssetModelOrMaterial.register
        Joint.register
        JointConfigurationKind.register
        JointFillKind.register
        Medium.register
        MediumKind.register
        Pole.register
        PoleBaseKind.register
        PolePreservativeKind.register
        PoleTreatmentKind.register
        Reconditioning.register
        ReliabilityInfo.register
        Specification.register
        Streetlight.register
        StreetlightLampKind.register
        Structure.register
        StructureMaterialKind.register
        StructureSupport.register
        StructureSupportKind.register
        Tower.register
        TowerConstructionKind.register
        TransformerObservation.register
        UndergroundStructure.register
        UndergroundStructureKind.register
        WindingInsulation.register
    }
}