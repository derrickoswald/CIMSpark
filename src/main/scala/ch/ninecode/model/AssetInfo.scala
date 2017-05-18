package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses.
 * They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */

/**
 * Busbar section data.
 * @param sup Reference to the superclass object.
 * @param ratedCurrent Rated current.
 * @param ratedVoltage Rated voltage.
 */
case class BusbarSectionInfo
(
    override val sup: Element,
    val ratedCurrent: Double,
    val ratedVoltage: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[BusbarSectionInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BusbarSectionInfo
extends
    Parseable[BusbarSectionInfo]
{
    val sup = AssetInfo.parse _
    val ratedCurrent = parse_element (element ("""BusbarSectionInfo.ratedCurrent"""))_
    val ratedVoltage = parse_element (element ("""BusbarSectionInfo.ratedVoltage"""))_
    def parse (context: Context): BusbarSectionInfo =
    {
        BusbarSectionInfo(
            sup (context),
            toDouble (ratedCurrent (context), context),
            toDouble (ratedVoltage (context), context)
        )
    }
}

/**
 * Kind of cable construction.
 * @param sup Reference to the superclass object.
 * @param compacted Compacted cable.
 * @param compressed Compressed cable.
 * @param other Other kind of cable construction.
 * @param sector Sector cable.
 * @param segmental Segmental cable.
 * @param solid Solid cable.
 * @param stranded Stranded cable.
 */
case class CableConstructionKind
(
    override val sup: Element,
    val compacted: String,
    val compressed: String,
    val other: String,
    val sector: String,
    val segmental: String,
    val solid: String,
    val stranded: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CableConstructionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CableConstructionKind
extends
    Parseable[CableConstructionKind]
{
    val sup = BasicElement.parse _
    val compacted = parse_attribute (attribute ("""CableConstructionKind.compacted"""))_
    val compressed = parse_attribute (attribute ("""CableConstructionKind.compressed"""))_
    val other = parse_attribute (attribute ("""CableConstructionKind.other"""))_
    val sector = parse_attribute (attribute ("""CableConstructionKind.sector"""))_
    val segmental = parse_attribute (attribute ("""CableConstructionKind.segmental"""))_
    val solid = parse_attribute (attribute ("""CableConstructionKind.solid"""))_
    val stranded = parse_attribute (attribute ("""CableConstructionKind.stranded"""))_
    def parse (context: Context): CableConstructionKind =
    {
        CableConstructionKind(
            sup (context),
            compacted (context),
            compressed (context),
            other (context),
            sector (context),
            segmental (context),
            solid (context),
            stranded (context)
        )
    }
}

/**
 * Cable data.
 * @param sup Reference to the superclass object.
 * @param constructionKind Kind of construction of this cable.
 * @param diameterOverCore Diameter over the core, including any semi-con screen; should be the insulating layer's inside diameter.
 * @param diameterOverInsulation Diameter over the insulating layer, excluding outer screen.
 * @param diameterOverJacket Diameter over the outermost jacketing layer.
 * @param diameterOverScreen Diameter over the outer screen; should be the shield's inside diameter.
 * @param isStrandFill True if wire strands are extruded in a way to fill the voids in the cable.
 * @param nominalTemperature Maximum nominal design operating temperature.
 * @param outerJacketKind Kind of outer jacket of this cable.
 * @param sheathAsNeutral True if sheath / shield is used as a neutral (i.e., bonded).
 * @param shieldMaterial Material of the shield.
 */
case class CableInfo
(
    override val sup: Element,
    val constructionKind: String,
    val diameterOverCore: Double,
    val diameterOverInsulation: Double,
    val diameterOverJacket: Double,
    val diameterOverScreen: Double,
    val isStrandFill: Boolean,
    val nominalTemperature: Double,
    val outerJacketKind: String,
    val sheathAsNeutral: Boolean,
    val shieldMaterial: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0, false, 0.0, null, false, null) }
    def WireInfo: WireInfo = sup.asInstanceOf[WireInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[CableInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CableInfo
extends
    Parseable[CableInfo]
{
    val sup = WireInfo.parse _
    val constructionKind = parse_attribute (attribute ("""CableInfo.constructionKind"""))_
    val diameterOverCore = parse_element (element ("""CableInfo.diameterOverCore"""))_
    val diameterOverInsulation = parse_element (element ("""CableInfo.diameterOverInsulation"""))_
    val diameterOverJacket = parse_element (element ("""CableInfo.diameterOverJacket"""))_
    val diameterOverScreen = parse_element (element ("""CableInfo.diameterOverScreen"""))_
    val isStrandFill = parse_element (element ("""CableInfo.isStrandFill"""))_
    val nominalTemperature = parse_element (element ("""CableInfo.nominalTemperature"""))_
    val outerJacketKind = parse_attribute (attribute ("""CableInfo.outerJacketKind"""))_
    val sheathAsNeutral = parse_element (element ("""CableInfo.sheathAsNeutral"""))_
    val shieldMaterial = parse_attribute (attribute ("""CableInfo.shieldMaterial"""))_
    def parse (context: Context): CableInfo =
    {
        CableInfo(
            sup (context),
            constructionKind (context),
            toDouble (diameterOverCore (context), context),
            toDouble (diameterOverInsulation (context), context),
            toDouble (diameterOverJacket (context), context),
            toDouble (diameterOverScreen (context), context),
            toBoolean (isStrandFill (context), context),
            toDouble (nominalTemperature (context), context),
            outerJacketKind (context),
            toBoolean (sheathAsNeutral (context), context),
            shieldMaterial (context)
        )
    }
}

/**
 * Kind of cable outer jacket.
 * @param sup Reference to the superclass object.
 * @param insulating Insulating cable outer jacket.
 * @param linearLowDensityPolyethylene Linear low density polyethylene cable outer jacket.
 * @param none Cable has no outer jacket.
 * @param other Pther kind of cable outer jacket.
 * @param polyethylene Polyethylene cable outer jacket.
 * @param pvc PVC cable outer jacket.
 * @param semiconducting Semiconducting cable outer jacket.
 */
case class CableOuterJacketKind
(
    override val sup: Element,
    val insulating: String,
    val linearLowDensityPolyethylene: String,
    val none: String,
    val other: String,
    val polyethylene: String,
    val pvc: String,
    val semiconducting: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CableOuterJacketKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CableOuterJacketKind
extends
    Parseable[CableOuterJacketKind]
{
    val sup = BasicElement.parse _
    val insulating = parse_attribute (attribute ("""CableOuterJacketKind.insulating"""))_
    val linearLowDensityPolyethylene = parse_attribute (attribute ("""CableOuterJacketKind.linearLowDensityPolyethylene"""))_
    val none = parse_attribute (attribute ("""CableOuterJacketKind.none"""))_
    val other = parse_attribute (attribute ("""CableOuterJacketKind.other"""))_
    val polyethylene = parse_attribute (attribute ("""CableOuterJacketKind.polyethylene"""))_
    val pvc = parse_attribute (attribute ("""CableOuterJacketKind.pvc"""))_
    val semiconducting = parse_attribute (attribute ("""CableOuterJacketKind.semiconducting"""))_
    def parse (context: Context): CableOuterJacketKind =
    {
        CableOuterJacketKind(
            sup (context),
            insulating (context),
            linearLowDensityPolyethylene (context),
            none (context),
            other (context),
            polyethylene (context),
            pvc (context),
            semiconducting (context)
        )
    }
}

/**
 * Kind of cable shield material.
 * @param sup Reference to the superclass object.
 * @param aluminum Aluminum cable shield.
 * @param copper Copper cable shield.
 * @param lead Lead cable shield.
 * @param other Other kind of cable shield material.
 * @param steel Steel cable shield.
 */
case class CableShieldMaterialKind
(
    override val sup: Element,
    val aluminum: String,
    val copper: String,
    val lead: String,
    val other: String,
    val steel: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CableShieldMaterialKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CableShieldMaterialKind
extends
    Parseable[CableShieldMaterialKind]
{
    val sup = BasicElement.parse _
    val aluminum = parse_attribute (attribute ("""CableShieldMaterialKind.aluminum"""))_
    val copper = parse_attribute (attribute ("""CableShieldMaterialKind.copper"""))_
    val lead = parse_attribute (attribute ("""CableShieldMaterialKind.lead"""))_
    val other = parse_attribute (attribute ("""CableShieldMaterialKind.other"""))_
    val steel = parse_attribute (attribute ("""CableShieldMaterialKind.steel"""))_
    def parse (context: Context): CableShieldMaterialKind =
    {
        CableShieldMaterialKind(
            sup (context),
            aluminum (context),
            copper (context),
            lead (context),
            other (context),
            steel (context)
        )
    }
}

/**
 * Concentric neutral cable data.
 * @param sup Reference to the superclass object.
 * @param diameterOverNeutral Diameter over the concentric neutral strands.
 * @param neutralStrandCount Number of concentric neutral strands.
 * @param neutralStrandGmr Geometric mean radius of the neutral strand.
 * @param neutralStrandRDC20 DC resistance per unit length of the neutral strand at 20 �C.
 * @param neutralStrandRadius Outside radius of the neutral strand.
 */
case class ConcentricNeutralCableInfo
(
    override val sup: Element,
    val diameterOverNeutral: Double,
    val neutralStrandCount: Int,
    val neutralStrandGmr: Double,
    val neutralStrandRDC20: Double,
    val neutralStrandRadius: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0, 0.0, 0.0, 0.0) }
    def CableInfo: CableInfo = sup.asInstanceOf[CableInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[ConcentricNeutralCableInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConcentricNeutralCableInfo
extends
    Parseable[ConcentricNeutralCableInfo]
{
    val sup = CableInfo.parse _
    val diameterOverNeutral = parse_element (element ("""ConcentricNeutralCableInfo.diameterOverNeutral"""))_
    val neutralStrandCount = parse_element (element ("""ConcentricNeutralCableInfo.neutralStrandCount"""))_
    val neutralStrandGmr = parse_element (element ("""ConcentricNeutralCableInfo.neutralStrandGmr"""))_
    val neutralStrandRDC20 = parse_element (element ("""ConcentricNeutralCableInfo.neutralStrandRDC20"""))_
    val neutralStrandRadius = parse_element (element ("""ConcentricNeutralCableInfo.neutralStrandRadius"""))_
    def parse (context: Context): ConcentricNeutralCableInfo =
    {
        ConcentricNeutralCableInfo(
            sup (context),
            toDouble (diameterOverNeutral (context), context),
            toInteger (neutralStrandCount (context), context),
            toDouble (neutralStrandGmr (context), context),
            toDouble (neutralStrandRDC20 (context), context),
            toDouble (neutralStrandRadius (context), context)
        )
    }
}

/**
 * No-load test results determine core admittance parameters.
 * They include exciting current and core loss measurements from applying voltage to one winding. The excitation may be positive sequence or zero sequence. The test may be repeated at different voltages to measure saturation.
 * @param sup Reference to the superclass object.
 * @param energisedEndVoltage Voltage applied to the winding (end) during test.
 * @param excitingCurrent Exciting current measured from a positive-sequence or single-phase excitation test.
 * @param excitingCurrentZero Exciting current measured from a zero-sequence open-circuit excitation test.
 * @param loss Losses measured from a positive-sequence or single-phase excitation test.
 * @param lossZero Losses measured from a zero-sequence excitation test.
 * @param EnergisedEnd Transformer end that current is applied to in this no-load test.
 */
case class NoLoadTest
(
    override val sup: Element,
    val energisedEndVoltage: Double,
    val excitingCurrent: Double,
    val excitingCurrentZero: Double,
    val loss: Double,
    val lossZero: Double,
    val EnergisedEnd: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def TransformerTest: TransformerTest = sup.asInstanceOf[TransformerTest]
    override def copy (): Row = { return (clone ().asInstanceOf[NoLoadTest]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NoLoadTest
extends
    Parseable[NoLoadTest]
{
    val sup = TransformerTest.parse _
    val energisedEndVoltage = parse_element (element ("""NoLoadTest.energisedEndVoltage"""))_
    val excitingCurrent = parse_element (element ("""NoLoadTest.excitingCurrent"""))_
    val excitingCurrentZero = parse_element (element ("""NoLoadTest.excitingCurrentZero"""))_
    val loss = parse_element (element ("""NoLoadTest.loss"""))_
    val lossZero = parse_element (element ("""NoLoadTest.lossZero"""))_
    val EnergisedEnd = parse_attribute (attribute ("""NoLoadTest.EnergisedEnd"""))_
    def parse (context: Context): NoLoadTest =
    {
        NoLoadTest(
            sup (context),
            toDouble (energisedEndVoltage (context), context),
            toDouble (excitingCurrent (context), context),
            toDouble (excitingCurrentZero (context), context),
            toDouble (loss (context), context),
            toDouble (lossZero (context), context),
            EnergisedEnd (context)
        )
    }
}

/**
 * Open-circuit test results verify winding turn ratios and phase shifts.
 * They include induced voltage and phase shift measurements on open-circuit windings, with voltage applied to the energised end. For three-phase windings, the excitation can be a positive sequence (the default) or a zero sequence.
 * @param sup Reference to the superclass object.
 * @param energisedEndStep Tap step number for the energised end of the test pair.
 * @param energisedEndVoltage Voltage applied to the winding (end) during test.
 * @param openEndStep Tap step number for the open end of the test pair.
 * @param openEndVoltage Voltage measured at the open-circuited end, with the energised end set to rated voltage and all other ends open.
 * @param phaseShift Phase shift measured at the open end with the energised end set to rated voltage and all other ends open.
 * @param EnergisedEnd Transformer end that current is applied to in this open-circuit test.
 * @param OpenEnd Transformer end measured for induced voltage and angle in this open-circuit test.
 */
case class OpenCircuitTest
(
    override val sup: Element,
    val energisedEndStep: Int,
    val energisedEndVoltage: Double,
    val openEndStep: Int,
    val openEndVoltage: Double,
    val phaseShift: Double,
    val EnergisedEnd: String,
    val OpenEnd: String
)
extends
    Element
{
    def this () = { this (null, 0, 0.0, 0, 0.0, 0.0, null, null) }
    def TransformerTest: TransformerTest = sup.asInstanceOf[TransformerTest]
    override def copy (): Row = { return (clone ().asInstanceOf[OpenCircuitTest]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OpenCircuitTest
extends
    Parseable[OpenCircuitTest]
{
    val sup = TransformerTest.parse _
    val energisedEndStep = parse_element (element ("""OpenCircuitTest.energisedEndStep"""))_
    val energisedEndVoltage = parse_element (element ("""OpenCircuitTest.energisedEndVoltage"""))_
    val openEndStep = parse_element (element ("""OpenCircuitTest.openEndStep"""))_
    val openEndVoltage = parse_element (element ("""OpenCircuitTest.openEndVoltage"""))_
    val phaseShift = parse_element (element ("""OpenCircuitTest.phaseShift"""))_
    val EnergisedEnd = parse_attribute (attribute ("""OpenCircuitTest.EnergisedEnd"""))_
    val OpenEnd = parse_attribute (attribute ("""OpenCircuitTest.OpenEnd"""))_
    def parse (context: Context): OpenCircuitTest =
    {
        OpenCircuitTest(
            sup (context),
            toInteger (energisedEndStep (context), context),
            toDouble (energisedEndVoltage (context), context),
            toInteger (openEndStep (context), context),
            toDouble (openEndVoltage (context), context),
            toDouble (phaseShift (context), context),
            EnergisedEnd (context),
            OpenEnd (context)
        )
    }
}

/**
 * Overhead wire data.
 * @param sup Reference to the superclass object.
 */
case class OverheadWireInfo
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def WireInfo: WireInfo = sup.asInstanceOf[WireInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[OverheadWireInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OverheadWireInfo
extends
    Parseable[OverheadWireInfo]
{
    val sup = WireInfo.parse _
    def parse (context: Context): OverheadWireInfo =
    {
        OverheadWireInfo(
            sup (context)
        )
    }
}

/**
 * Set of power transformer data, from an equipment library.
 * @param sup Reference to the superclass object.
 */
case class PowerTransformerInfo
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[PowerTransformerInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerTransformerInfo
extends
    Parseable[PowerTransformerInfo]
{
    val sup = AssetInfo.parse _
    def parse (context: Context): PowerTransformerInfo =
    {
        PowerTransformerInfo(
            sup (context)
        )
    }
}

/**
 * Short-circuit test results determine mesh impedance parameters.
 * They include load losses and leakage impedances. For three-phase windings, the excitation can be a positive sequence (the default) or a zero sequence. There shall be at least one grounded winding.
 * @param sup Reference to the superclass object.
 * @param energisedEndStep Tap step number for the energised end of the test pair.
 * @param groundedEndStep Tap step number for the grounded end of the test pair.
 * @param leakageImpedance Leakage impedance measured from a positive-sequence or single-phase short-circuit test.
 * @param leakageImpedanceZero Leakage impedance measured from a zero-sequence short-circuit test.
 * @param loss Load losses from a positive-sequence or single-phase short-circuit test.
 * @param lossZero Load losses from a zero-sequence short-circuit test.
 * @param EnergisedEnd Transformer end that voltage is applied to in this short-circuit test.
 *        The test voltage is chosen to induce rated current in the energised end.
 */
case class ShortCircuitTest
(
    override val sup: Element,
    val energisedEndStep: Int,
    val groundedEndStep: Int,
    val leakageImpedance: Double,
    val leakageImpedanceZero: Double,
    val loss: Double,
    val lossZero: Double,
    val EnergisedEnd: String
)
extends
    Element
{
    def this () = { this (null, 0, 0, 0.0, 0.0, 0.0, 0.0, null) }
    def TransformerTest: TransformerTest = sup.asInstanceOf[TransformerTest]
    override def copy (): Row = { return (clone ().asInstanceOf[ShortCircuitTest]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ShortCircuitTest
extends
    Parseable[ShortCircuitTest]
{
    val sup = TransformerTest.parse _
    val energisedEndStep = parse_element (element ("""ShortCircuitTest.energisedEndStep"""))_
    val groundedEndStep = parse_element (element ("""ShortCircuitTest.groundedEndStep"""))_
    val leakageImpedance = parse_element (element ("""ShortCircuitTest.leakageImpedance"""))_
    val leakageImpedanceZero = parse_element (element ("""ShortCircuitTest.leakageImpedanceZero"""))_
    val loss = parse_element (element ("""ShortCircuitTest.loss"""))_
    val lossZero = parse_element (element ("""ShortCircuitTest.lossZero"""))_
    val EnergisedEnd = parse_attribute (attribute ("""ShortCircuitTest.EnergisedEnd"""))_
    def parse (context: Context): ShortCircuitTest =
    {
        ShortCircuitTest(
            sup (context),
            toInteger (energisedEndStep (context), context),
            toInteger (groundedEndStep (context), context),
            toDouble (leakageImpedance (context), context),
            toDouble (leakageImpedanceZero (context), context),
            toDouble (loss (context), context),
            toDouble (lossZero (context), context),
            EnergisedEnd (context)
        )
    }
}

/**
 * Properties of shunt capacitor, shunt reactor or switchable bank of shunt capacitor or reactor assets.
 * @param sup Reference to the superclass object.
 * @param maxPowerLoss Maximum allowed apparent power loss.
 * @param ratedCurrent Rated current.
 * @param ratedReactivePower Rated reactive power.
 * @param ratedVoltage Rated voltage.
 * @param ShuntCompensatorControl
 */
case class ShuntCompensatorInfo
(
    override val sup: Element,
    val maxPowerLoss: Double,
    val ratedCurrent: Double,
    val ratedReactivePower: Double,
    val ratedVoltage: Double,
    val ShuntCompensatorControl: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[ShuntCompensatorInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ShuntCompensatorInfo
extends
    Parseable[ShuntCompensatorInfo]
{
    val sup = AssetInfo.parse _
    val maxPowerLoss = parse_element (element ("""ShuntCompensatorInfo.maxPowerLoss"""))_
    val ratedCurrent = parse_element (element ("""ShuntCompensatorInfo.ratedCurrent"""))_
    val ratedReactivePower = parse_element (element ("""ShuntCompensatorInfo.ratedReactivePower"""))_
    val ratedVoltage = parse_element (element ("""ShuntCompensatorInfo.ratedVoltage"""))_
    val ShuntCompensatorControl = parse_attribute (attribute ("""ShuntCompensatorInfo.ShuntCompensatorControl"""))_
    def parse (context: Context): ShuntCompensatorInfo =
    {
        ShuntCompensatorInfo(
            sup (context),
            toDouble (maxPowerLoss (context), context),
            toDouble (ratedCurrent (context), context),
            toDouble (ratedReactivePower (context), context),
            toDouble (ratedVoltage (context), context),
            ShuntCompensatorControl (context)
        )
    }
}

/**
 * Switch data.
 * @param sup Reference to the superclass object.
 * @param breakingCapacity The maximum fault current a breaking device can break safely under prescribed conditions of use.
 * @param isSinglePhase If true, it is a single phase switch.
 * @param isUnganged If true, the switch is not ganged (i.e., a switch phase may be operated separately from other phases).
 * @param ratedCurrent Rated current.
 * @param ratedVoltage Rated voltage.
 */
case class SwitchInfo
(
    override val sup: Element,
    val breakingCapacity: Double,
    val isSinglePhase: Boolean,
    val isUnganged: Boolean,
    val ratedCurrent: Double,
    val ratedVoltage: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, false, false, 0.0, 0.0) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[SwitchInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SwitchInfo
extends
    Parseable[SwitchInfo]
{
    val sup = AssetInfo.parse _
    val breakingCapacity = parse_element (element ("""SwitchInfo.breakingCapacity"""))_
    val isSinglePhase = parse_element (element ("""SwitchInfo.isSinglePhase"""))_
    val isUnganged = parse_element (element ("""SwitchInfo.isUnganged"""))_
    val ratedCurrent = parse_element (element ("""SwitchInfo.ratedCurrent"""))_
    val ratedVoltage = parse_element (element ("""SwitchInfo.ratedVoltage"""))_
    def parse (context: Context): SwitchInfo =
    {
        SwitchInfo(
            sup (context),
            toDouble (breakingCapacity (context), context),
            toBoolean (isSinglePhase (context), context),
            toBoolean (isUnganged (context), context),
            toDouble (ratedCurrent (context), context),
            toDouble (ratedVoltage (context), context)
        )
    }
}

/**
 * Tap changer data.
 * @param sup Reference to the superclass object.
 * @param bil Basic Insulation Level (BIL) expressed as the impulse crest voltage of a nominal wave, typically 1.2 X 50 microsecond.
 *        This is a measure of the ability of the insulation to withstand very high voltage surges.
 * @param ctRating Built-in current transformer primary rating.
 * @param ctRatio Built-in current transducer ratio.
 * @param frequency Frequency at which the ratings apply.
 * @param highStep Highest possible tap step position, advance from neutral.
 * @param isTcul Whether this tap changer has under load tap changing capabilities.
 * @param lowStep Lowest possible tap step position, retard from neutral.
 * @param neutralStep The neutral tap step position for the winding.
 * @param neutralU Voltage at which the winding operates at the neutral tap setting.
 * @param ptRatio Built-in voltage transducer ratio.
 * @param ratedApparentPower Rated apparent power.
 * @param ratedCurrent Rated current.
 * @param ratedVoltage Rated voltage.
 * @param stepPhaseIncrement Phase shift per step position.
 * @param stepVoltageIncrement Tap step increment, in per cent of rated voltage, per step position.
 */
case class TapChangerInfo
(
    override val sup: Element,
    val bil: Double,
    val ctRating: Double,
    val ctRatio: Double,
    val frequency: Double,
    val highStep: Int,
    val isTcul: Boolean,
    val lowStep: Int,
    val neutralStep: Int,
    val neutralU: Double,
    val ptRatio: Double,
    val ratedApparentPower: Double,
    val ratedCurrent: Double,
    val ratedVoltage: Double,
    val stepPhaseIncrement: Double,
    val stepVoltageIncrement: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0, false, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[TapChangerInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TapChangerInfo
extends
    Parseable[TapChangerInfo]
{
    val sup = AssetInfo.parse _
    val bil = parse_element (element ("""TapChangerInfo.bil"""))_
    val ctRating = parse_element (element ("""TapChangerInfo.ctRating"""))_
    val ctRatio = parse_element (element ("""TapChangerInfo.ctRatio"""))_
    val frequency = parse_element (element ("""TapChangerInfo.frequency"""))_
    val highStep = parse_element (element ("""TapChangerInfo.highStep"""))_
    val isTcul = parse_element (element ("""TapChangerInfo.isTcul"""))_
    val lowStep = parse_element (element ("""TapChangerInfo.lowStep"""))_
    val neutralStep = parse_element (element ("""TapChangerInfo.neutralStep"""))_
    val neutralU = parse_element (element ("""TapChangerInfo.neutralU"""))_
    val ptRatio = parse_element (element ("""TapChangerInfo.ptRatio"""))_
    val ratedApparentPower = parse_element (element ("""TapChangerInfo.ratedApparentPower"""))_
    val ratedCurrent = parse_element (element ("""TapChangerInfo.ratedCurrent"""))_
    val ratedVoltage = parse_element (element ("""TapChangerInfo.ratedVoltage"""))_
    val stepPhaseIncrement = parse_element (element ("""TapChangerInfo.stepPhaseIncrement"""))_
    val stepVoltageIncrement = parse_element (element ("""TapChangerInfo.stepVoltageIncrement"""))_
    def parse (context: Context): TapChangerInfo =
    {
        TapChangerInfo(
            sup (context),
            toDouble (bil (context), context),
            toDouble (ctRating (context), context),
            toDouble (ctRatio (context), context),
            toDouble (frequency (context), context),
            toInteger (highStep (context), context),
            toBoolean (isTcul (context), context),
            toInteger (lowStep (context), context),
            toInteger (neutralStep (context), context),
            toDouble (neutralU (context), context),
            toDouble (ptRatio (context), context),
            toDouble (ratedApparentPower (context), context),
            toDouble (ratedCurrent (context), context),
            toDouble (ratedVoltage (context), context),
            toDouble (stepPhaseIncrement (context), context),
            toDouble (stepVoltageIncrement (context), context)
        )
    }
}

/**
 * Tape shield cable data.
 * @param sup Reference to the superclass object.
 * @param tapeLap Percentage of the tape shield width that overlaps in each wrap, typically 10% to 25%.
 * @param tapeThickness Thickness of the tape shield, before wrapping.
 */
case class TapeShieldCableInfo
(
    override val sup: Element,
    val tapeLap: Double,
    val tapeThickness: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def CableInfo: CableInfo = sup.asInstanceOf[CableInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[TapeShieldCableInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TapeShieldCableInfo
extends
    Parseable[TapeShieldCableInfo]
{
    val sup = CableInfo.parse _
    val tapeLap = parse_element (element ("""TapeShieldCableInfo.tapeLap"""))_
    val tapeThickness = parse_element (element ("""TapeShieldCableInfo.tapeThickness"""))_
    def parse (context: Context): TapeShieldCableInfo =
    {
        TapeShieldCableInfo(
            sup (context),
            toDouble (tapeLap (context), context),
            toDouble (tapeThickness (context), context)
        )
    }
}

/**
 * Transformer end data.
 * @param sup Reference to the superclass object.
 * @param connectionKind Kind of connection.
 * @param emergencyS Apparent power that the winding can carry under emergency conditions (also called long-term emergency power).
 * @param endNumber Number for this transformer end, corresponding to the end's order in the PowerTransformer.vectorGroup attribute.
 *        Highest voltage winding should be 1.
 * @param insulationU Basic insulation level voltage rating.
 * @param phaseAngleClock Winding phase angle where 360 degrees are represented with clock hours, so the valid values are {0, ..., 11}.
 *        For example, to express the second winding in code 'Dyn11', set attributes as follows: 'endNumber'=2, 'connectionKind' = Yn and 'phaseAngleClock' = 11.
 * @param r DC resistance.
 * @param ratedS Normal apparent power rating.
 * @param ratedU Rated voltage: phase-phase for three-phase windings, and either phase-phase or phase-neutral for single-phase windings.
 * @param shortTermS Apparent power that this winding can carry for a short period of time (in emergency).
 * @param CoreAdmittance Core admittance calculated from this transformer end datasheet, representing magnetising current and core losses.
 *        The full values of the transformer should be supplied for one transformer end info only.
 * @param ToMeshImpedances All mesh impedances between this 'from' and other 'to' transformer ends.
 * @param TransformerStarImpedance Transformer star impedance calculated from this transformer end datasheet.
 * @param TransformerTankInfo Transformer tank data that this end description is part of.
 */
case class TransformerEndInfo
(
    override val sup: Element,
    val connectionKind: String,
    val emergencyS: Double,
    val endNumber: Int,
    val insulationU: Double,
    val phaseAngleClock: Int,
    val r: Double,
    val ratedS: Double,
    val ratedU: Double,
    val shortTermS: Double,
    val CoreAdmittance: String,
    val ToMeshImpedances: List[String],
    val TransformerStarImpedance: String,
    val TransformerTankInfo: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, null, List(), null, null) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerEndInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerEndInfo
extends
    Parseable[TransformerEndInfo]
{
    val sup = AssetInfo.parse _
    val connectionKind = parse_attribute (attribute ("""TransformerEndInfo.connectionKind"""))_
    val emergencyS = parse_element (element ("""TransformerEndInfo.emergencyS"""))_
    val endNumber = parse_element (element ("""TransformerEndInfo.endNumber"""))_
    val insulationU = parse_element (element ("""TransformerEndInfo.insulationU"""))_
    val phaseAngleClock = parse_element (element ("""TransformerEndInfo.phaseAngleClock"""))_
    val r = parse_element (element ("""TransformerEndInfo.r"""))_
    val ratedS = parse_element (element ("""TransformerEndInfo.ratedS"""))_
    val ratedU = parse_element (element ("""TransformerEndInfo.ratedU"""))_
    val shortTermS = parse_element (element ("""TransformerEndInfo.shortTermS"""))_
    val CoreAdmittance = parse_attribute (attribute ("""TransformerEndInfo.CoreAdmittance"""))_
    val ToMeshImpedances = parse_attributes (attribute ("""TransformerEndInfo.ToMeshImpedances"""))_
    val TransformerStarImpedance = parse_attribute (attribute ("""TransformerEndInfo.TransformerStarImpedance"""))_
    val TransformerTankInfo = parse_attribute (attribute ("""TransformerEndInfo.TransformerTankInfo"""))_
    def parse (context: Context): TransformerEndInfo =
    {
        TransformerEndInfo(
            sup (context),
            connectionKind (context),
            toDouble (emergencyS (context), context),
            toInteger (endNumber (context), context),
            toDouble (insulationU (context), context),
            toInteger (phaseAngleClock (context), context),
            toDouble (r (context), context),
            toDouble (ratedS (context), context),
            toDouble (ratedU (context), context),
            toDouble (shortTermS (context), context),
            CoreAdmittance (context),
            ToMeshImpedances (context),
            TransformerStarImpedance (context),
            TransformerTankInfo (context)
        )
    }
}

/**
 * Set of transformer tank data, from an equipment library.
 * @param sup Reference to the superclass object.
 * @param PowerTransformerInfo Power transformer data that this tank description is part of.
 */
case class TransformerTankInfo
(
    override val sup: Element,
    val PowerTransformerInfo: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerTankInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerTankInfo
extends
    Parseable[TransformerTankInfo]
{
    val sup = AssetInfo.parse _
    val PowerTransformerInfo = parse_attribute (attribute ("""TransformerTankInfo.PowerTransformerInfo"""))_
    def parse (context: Context): TransformerTankInfo =
    {
        TransformerTankInfo(
            sup (context),
            PowerTransformerInfo (context)
        )
    }
}

/**
 * Test result for transformer ends, such as short-circuit, open-circuit (excitation) or no-load test.
 * @param sup Reference to the superclass object.
 * @param basePower Base power at which the tests are conducted, usually equal to the rateds of one of the involved transformer ends.
 * @param temperature Temperature at which the test is conducted.
 */
case class TransformerTest
(
    override val sup: Element,
    val basePower: Double,
    val temperature: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerTest]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerTest
extends
    Parseable[TransformerTest]
{
    val sup = IdentifiedObject.parse _
    val basePower = parse_element (element ("""TransformerTest.basePower"""))_
    val temperature = parse_element (element ("""TransformerTest.temperature"""))_
    def parse (context: Context): TransformerTest =
    {
        TransformerTest(
            sup (context),
            toDouble (basePower (context), context),
            toDouble (temperature (context), context)
        )
    }
}

/**
 * Wire data that can be specified per line segment phase, or for the line segment as a whole in case its phases all have the same wire characteristics.
 * @param sup Reference to the superclass object.
 * @param coreRadius (if there is a different core material) Radius of the central core.
 * @param coreStrandCount (if used) Number of strands in the steel core.
 * @param gmr Geometric mean radius.
 *        If we replace the conductor by a thin walled tube of radius GMR, then its reactance is identical to the reactance of the actual conductor.
 * @param insulated True if conductor is insulated.
 * @param insulationMaterial (if insulated conductor) Material used for insulation.
 * @param insulationThickness (if insulated conductor) Thickness of the insulation.
 * @param material Conductor material.
 * @param rAC25 AC resistance per unit length of the conductor at 25 �C.
 * @param rAC50 AC resistance per unit length of the conductor at 50 �C.
 * @param rAC75 AC resistance per unit length of the conductor at 75 �C.
 * @param rDC20 DC resistance per unit length of the conductor at 20 �C.
 * @param radius Outside radius of the wire.
 * @param ratedCurrent Current carrying capacity of the wire under stated thermal conditions.
 * @param sizeDescription Describes the wire gauge or cross section (e.g., 4/0, #2, 336.5).
 * @param strandCount Number of strands in the conductor.
 * @param PerLengthParameters All per-length parameters calculated from this wire datasheet.
 */
case class WireInfo
(
    override val sup: Element,
    val coreRadius: Double,
    val coreStrandCount: Int,
    val gmr: Double,
    val insulated: Boolean,
    val insulationMaterial: String,
    val insulationThickness: Double,
    val material: String,
    val rAC25: Double,
    val rAC50: Double,
    val rAC75: Double,
    val rDC20: Double,
    val radius: Double,
    val ratedCurrent: Double,
    val sizeDescription: String,
    val strandCount: Int,
    val PerLengthParameters: List[String]
)
extends
    Element
{
    def this () = { this (null, 0.0, 0, 0.0, false, null, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0, List()) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[WireInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WireInfo
extends
    Parseable[WireInfo]
{
    val sup = AssetInfo.parse _
    val coreRadius = parse_element (element ("""WireInfo.coreRadius"""))_
    val coreStrandCount = parse_element (element ("""WireInfo.coreStrandCount"""))_
    val gmr = parse_element (element ("""WireInfo.gmr"""))_
    val insulated = parse_element (element ("""WireInfo.insulated"""))_
    val insulationMaterial = parse_attribute (attribute ("""WireInfo.insulationMaterial"""))_
    val insulationThickness = parse_element (element ("""WireInfo.insulationThickness"""))_
    val material = parse_attribute (attribute ("""WireInfo.material"""))_
    val rAC25 = parse_element (element ("""WireInfo.rAC25"""))_
    val rAC50 = parse_element (element ("""WireInfo.rAC50"""))_
    val rAC75 = parse_element (element ("""WireInfo.rAC75"""))_
    val rDC20 = parse_element (element ("""WireInfo.rDC20"""))_
    val radius = parse_element (element ("""WireInfo.radius"""))_
    val ratedCurrent = parse_element (element ("""WireInfo.ratedCurrent"""))_
    val sizeDescription = parse_element (element ("""WireInfo.sizeDescription"""))_
    val strandCount = parse_element (element ("""WireInfo.strandCount"""))_
    val PerLengthParameters = parse_attributes (attribute ("""WireInfo.PerLengthParameters"""))_
    def parse (context: Context): WireInfo =
    {
        WireInfo(
            sup (context),
            toDouble (coreRadius (context), context),
            toInteger (coreStrandCount (context), context),
            toDouble (gmr (context), context),
            toBoolean (insulated (context), context),
            insulationMaterial (context),
            toDouble (insulationThickness (context), context),
            material (context),
            toDouble (rAC25 (context), context),
            toDouble (rAC50 (context), context),
            toDouble (rAC75 (context), context),
            toDouble (rDC20 (context), context),
            toDouble (radius (context), context),
            toDouble (ratedCurrent (context), context),
            sizeDescription (context),
            toInteger (strandCount (context), context),
            PerLengthParameters (context)
        )
    }
}

/**
 * Kind of wire insulation.
 * @param sup Reference to the superclass object.
 * @param asbestosAndVarnishedCambric Asbestos and varnished cambric wire insulation.
 * @param beltedPilc Belted pilc wire insulation.
 * @param butyl Butyl wire insulation.
 * @param crosslinkedPolyethylene Crosslinked polyethylene wire insulation.
 * @param ethylenePropyleneRubber Ethylene propylene rubber wire insulation.
 * @param highMolecularWeightPolyethylene High nolecular weight polyethylene wire insulation.
 * @param highPressureFluidFilled High pressure fluid filled wire insulation.
 * @param lowCapacitanceRubber Low capacitance rubber wire insulation.
 * @param oilPaper Oil paper wire insulation.
 * @param other Other kind of wire insulation.
 * @param ozoneResistantRubber Ozone resistant rubber wire insulation.
 * @param rubber Rubber wire insulation.
 * @param siliconRubber Silicon rubber wire insulation.
 * @param treeResistantHighMolecularWeightPolyethylene Tree resistant high molecular weight polyethylene wire insulation.
 * @param treeRetardantCrosslinkedPolyethylene Tree retardant crosslinked polyethylene wire insulation.
 * @param unbeltedPilc Unbelted pilc wire insulation.
 * @param varnishedCambricCloth Varnished cambric cloth wire insulation.
 * @param varnishedDacronGlass Varnished dacron glass wire insulation.
 */
case class WireInsulationKind
(
    override val sup: Element,
    val asbestosAndVarnishedCambric: String,
    val beltedPilc: String,
    val butyl: String,
    val crosslinkedPolyethylene: String,
    val ethylenePropyleneRubber: String,
    val highMolecularWeightPolyethylene: String,
    val highPressureFluidFilled: String,
    val lowCapacitanceRubber: String,
    val oilPaper: String,
    val other: String,
    val ozoneResistantRubber: String,
    val rubber: String,
    val siliconRubber: String,
    val treeResistantHighMolecularWeightPolyethylene: String,
    val treeRetardantCrosslinkedPolyethylene: String,
    val unbeltedPilc: String,
    val varnishedCambricCloth: String,
    val varnishedDacronGlass: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[WireInsulationKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WireInsulationKind
extends
    Parseable[WireInsulationKind]
{
    val sup = BasicElement.parse _
    val asbestosAndVarnishedCambric = parse_attribute (attribute ("""WireInsulationKind.asbestosAndVarnishedCambric"""))_
    val beltedPilc = parse_attribute (attribute ("""WireInsulationKind.beltedPilc"""))_
    val butyl = parse_attribute (attribute ("""WireInsulationKind.butyl"""))_
    val crosslinkedPolyethylene = parse_attribute (attribute ("""WireInsulationKind.crosslinkedPolyethylene"""))_
    val ethylenePropyleneRubber = parse_attribute (attribute ("""WireInsulationKind.ethylenePropyleneRubber"""))_
    val highMolecularWeightPolyethylene = parse_attribute (attribute ("""WireInsulationKind.highMolecularWeightPolyethylene"""))_
    val highPressureFluidFilled = parse_attribute (attribute ("""WireInsulationKind.highPressureFluidFilled"""))_
    val lowCapacitanceRubber = parse_attribute (attribute ("""WireInsulationKind.lowCapacitanceRubber"""))_
    val oilPaper = parse_attribute (attribute ("""WireInsulationKind.oilPaper"""))_
    val other = parse_attribute (attribute ("""WireInsulationKind.other"""))_
    val ozoneResistantRubber = parse_attribute (attribute ("""WireInsulationKind.ozoneResistantRubber"""))_
    val rubber = parse_attribute (attribute ("""WireInsulationKind.rubber"""))_
    val siliconRubber = parse_attribute (attribute ("""WireInsulationKind.siliconRubber"""))_
    val treeResistantHighMolecularWeightPolyethylene = parse_attribute (attribute ("""WireInsulationKind.treeResistantHighMolecularWeightPolyethylene"""))_
    val treeRetardantCrosslinkedPolyethylene = parse_attribute (attribute ("""WireInsulationKind.treeRetardantCrosslinkedPolyethylene"""))_
    val unbeltedPilc = parse_attribute (attribute ("""WireInsulationKind.unbeltedPilc"""))_
    val varnishedCambricCloth = parse_attribute (attribute ("""WireInsulationKind.varnishedCambricCloth"""))_
    val varnishedDacronGlass = parse_attribute (attribute ("""WireInsulationKind.varnishedDacronGlass"""))_
    def parse (context: Context): WireInsulationKind =
    {
        WireInsulationKind(
            sup (context),
            asbestosAndVarnishedCambric (context),
            beltedPilc (context),
            butyl (context),
            crosslinkedPolyethylene (context),
            ethylenePropyleneRubber (context),
            highMolecularWeightPolyethylene (context),
            highPressureFluidFilled (context),
            lowCapacitanceRubber (context),
            oilPaper (context),
            other (context),
            ozoneResistantRubber (context),
            rubber (context),
            siliconRubber (context),
            treeResistantHighMolecularWeightPolyethylene (context),
            treeRetardantCrosslinkedPolyethylene (context),
            unbeltedPilc (context),
            varnishedCambricCloth (context),
            varnishedDacronGlass (context)
        )
    }
}

/**
 * Kind of wire material.
 * @param sup Reference to the superclass object.
 * @param aaac Aluminum-alloy conductor steel reinforced.
 * @param acsr Aluminum conductor steel reinforced.
 * @param aluminum Aluminum wire.
 * @param aluminumAlloy Aluminum-alloy wire.
 * @param aluminumAlloySteel Aluminum-alloy-steel wire.
 * @param aluminumSteel Aluminum-steel wire.
 * @param copper Copper wire.
 * @param other Other wire material.
 * @param steel Steel wire.
 */
case class WireMaterialKind
(
    override val sup: Element,
    val aaac: String,
    val acsr: String,
    val aluminum: String,
    val aluminumAlloy: String,
    val aluminumAlloySteel: String,
    val aluminumSteel: String,
    val copper: String,
    val other: String,
    val steel: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[WireMaterialKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WireMaterialKind
extends
    Parseable[WireMaterialKind]
{
    val sup = BasicElement.parse _
    val aaac = parse_attribute (attribute ("""WireMaterialKind.aaac"""))_
    val acsr = parse_attribute (attribute ("""WireMaterialKind.acsr"""))_
    val aluminum = parse_attribute (attribute ("""WireMaterialKind.aluminum"""))_
    val aluminumAlloy = parse_attribute (attribute ("""WireMaterialKind.aluminumAlloy"""))_
    val aluminumAlloySteel = parse_attribute (attribute ("""WireMaterialKind.aluminumAlloySteel"""))_
    val aluminumSteel = parse_attribute (attribute ("""WireMaterialKind.aluminumSteel"""))_
    val copper = parse_attribute (attribute ("""WireMaterialKind.copper"""))_
    val other = parse_attribute (attribute ("""WireMaterialKind.other"""))_
    val steel = parse_attribute (attribute ("""WireMaterialKind.steel"""))_
    def parse (context: Context): WireMaterialKind =
    {
        WireMaterialKind(
            sup (context),
            aaac (context),
            acsr (context),
            aluminum (context),
            aluminumAlloy (context),
            aluminumAlloySteel (context),
            aluminumSteel (context),
            copper (context),
            other (context),
            steel (context)
        )
    }
}

/**
 * Identification, spacing and configuration of the wires of a conductor with respect to a structure.
 * @param sup Reference to the superclass object.
 * @param phase Single phase or neutral designation for the wire with this position.
 * @param xCoord Signed horizontal distance from the wire at this position to a common reference point.
 * @param yCoord Signed vertical distance from the wire at this position: above ground (positive value) or burial depth below ground (negative value).
 * @param WireSpacingInfo Wire spacing data this wire position belongs to.
 */
case class WirePosition
(
    override val sup: Element,
    val phase: String,
    val xCoord: Double,
    val yCoord: Double,
    val WireSpacingInfo: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WirePosition]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WirePosition
extends
    Parseable[WirePosition]
{
    val sup = IdentifiedObject.parse _
    val phase = parse_attribute (attribute ("""WirePosition.phase"""))_
    val xCoord = parse_element (element ("""WirePosition.xCoord"""))_
    val yCoord = parse_element (element ("""WirePosition.yCoord"""))_
    val WireSpacingInfo = parse_attribute (attribute ("""WirePosition.WireSpacingInfo"""))_
    def parse (context: Context): WirePosition =
    {
        WirePosition(
            sup (context),
            phase (context),
            toDouble (xCoord (context), context),
            toDouble (yCoord (context), context),
            WireSpacingInfo (context)
        )
    }
}

/**
 * Wire spacing data that associates multiple wire positions with the line segment, and allows to calculate line segment impedances.
 * Number of phases can be derived from the number of associated wire positions whose phase is not neutral.
 * @param sup Reference to the superclass object.
 * @param isCable If true, this spacing data describes a cable.
 * @param phaseWireCount Number of wire sub-conductors in the symmetrical bundle (typically between 1 and 4).
 * @param phaseWireSpacing Distance between wire sub-conductors in a symmetrical bundle.
 * @param usage Usage of the associated wires.
 * @param DuctBank
 * @param Structures
 */
case class WireSpacingInfo
(
    override val sup: Element,
    val isCable: Boolean,
    val phaseWireCount: Int,
    val phaseWireSpacing: Double,
    val usage: String,
    val DuctBank: String,
    val Structures: List[String]
)
extends
    Element
{
    def this () = { this (null, false, 0, 0.0, null, null, List()) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[WireSpacingInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WireSpacingInfo
extends
    Parseable[WireSpacingInfo]
{
    val sup = AssetInfo.parse _
    val isCable = parse_element (element ("""WireSpacingInfo.isCable"""))_
    val phaseWireCount = parse_element (element ("""WireSpacingInfo.phaseWireCount"""))_
    val phaseWireSpacing = parse_element (element ("""WireSpacingInfo.phaseWireSpacing"""))_
    val usage = parse_attribute (attribute ("""WireSpacingInfo.usage"""))_
    val DuctBank = parse_attribute (attribute ("""WireSpacingInfo.DuctBank"""))_
    val Structures = parse_attributes (attribute ("""WireSpacingInfo.Structures"""))_
    def parse (context: Context): WireSpacingInfo =
    {
        WireSpacingInfo(
            sup (context),
            toBoolean (isCable (context), context),
            toInteger (phaseWireCount (context), context),
            toDouble (phaseWireSpacing (context), context),
            usage (context),
            DuctBank (context),
            Structures (context)
        )
    }
}

/**
 * Kind of wire usage.
 * @param sup Reference to the superclass object.
 * @param distribution Wire is used in medium voltage network.
 * @param other Other kind of wire usage.
 * @param secondary Wire is used in low voltage circuit.
 * @param transmission Wire is used in extra-high voltage or high voltage network.
 */
case class WireUsageKind
(
    override val sup: Element,
    val distribution: String,
    val other: String,
    val secondary: String,
    val transmission: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[WireUsageKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WireUsageKind
extends
    Parseable[WireUsageKind]
{
    val sup = BasicElement.parse _
    val distribution = parse_attribute (attribute ("""WireUsageKind.distribution"""))_
    val other = parse_attribute (attribute ("""WireUsageKind.other"""))_
    val secondary = parse_attribute (attribute ("""WireUsageKind.secondary"""))_
    val transmission = parse_attribute (attribute ("""WireUsageKind.transmission"""))_
    def parse (context: Context): WireUsageKind =
    {
        WireUsageKind(
            sup (context),
            distribution (context),
            other (context),
            secondary (context),
            transmission (context)
        )
    }
}

object _AssetInfo
{
    def register: Unit =
    {
        BusbarSectionInfo.register
        CableConstructionKind.register
        CableInfo.register
        CableOuterJacketKind.register
        CableShieldMaterialKind.register
        ConcentricNeutralCableInfo.register
        NoLoadTest.register
        OpenCircuitTest.register
        OverheadWireInfo.register
        PowerTransformerInfo.register
        ShortCircuitTest.register
        ShuntCompensatorInfo.register
        SwitchInfo.register
        TapChangerInfo.register
        TapeShieldCableInfo.register
        TransformerEndInfo.register
        TransformerTankInfo.register
        TransformerTest.register
        WireInfo.register
        WireInsulationKind.register
        WireMaterialKind.register
        WirePosition.register
        WireSpacingInfo.register
        WireUsageKind.register
    }
}