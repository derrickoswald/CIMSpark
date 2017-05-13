package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses.
 * They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */

/**
 * Busbar section data.
 */
case class BusbarSectionInfo
(

    override val sup: AssetInfo,

    /**
     * Rated current.
     */
    val ratedCurrent: Double,

    /**
     * Rated voltage.
     */
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
 */
case class CableConstructionKind
(

    override val sup: BasicElement,

    /**
     * Compacted cable.
     */
    val compacted: String,

    /**
     * Compressed cable.
     */
    val compressed: String,

    /**
     * Other kind of cable construction.
     */
    val other: String,

    /**
     * Sector cable.
     */
    val sector: String,

    /**
     * Segmental cable.
     */
    val segmental: String,

    /**
     * Solid cable.
     */
    val solid: String,

    /**
     * Stranded cable.
     */
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
 */
case class CableInfo
(

    override val sup: WireInfo,

    /**
     * Kind of construction of this cable.
     */
    val constructionKind: String,

    /**
     * Diameter over the core, including any semi-con screen; should be the insulating layer's inside diameter.
     */
    val diameterOverCore: Double,

    /**
     * Diameter over the insulating layer, excluding outer screen.
     */
    val diameterOverInsulation: Double,

    /**
     * Diameter over the outermost jacketing layer.
     */
    val diameterOverJacket: Double,

    /**
     * Diameter over the outer screen; should be the shield's inside diameter.
     */
    val diameterOverScreen: Double,

    /**
     * True if wire strands are extruded in a way to fill the voids in the cable.
     */
    val isStrandFill: Boolean,

    /**
     * Maximum nominal design operating temperature.
     */
    val nominalTemperature: Double,

    /**
     * Kind of outer jacket of this cable.
     */
    val outerJacketKind: String,

    /**
     * True if sheath / shield is used as a neutral (i.e., bonded).
     */
    val sheathAsNeutral: Boolean,

    /**
     * Material of the shield.
     */
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
 */
case class CableOuterJacketKind
(

    override val sup: BasicElement,

    /**
     * Insulating cable outer jacket.
     */
    val insulating: String,

    /**
     * Linear low density polyethylene cable outer jacket.
     */
    val linearLowDensityPolyethylene: String,

    /**
     * Cable has no outer jacket.
     */
    val none: String,

    /**
     * Pther kind of cable outer jacket.
     */
    val other: String,

    /**
     * Polyethylene cable outer jacket.
     */
    val polyethylene: String,

    /**
     * PVC cable outer jacket.
     */
    val pvc: String,

    /**
     * Semiconducting cable outer jacket.
     */
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
 */
case class CableShieldMaterialKind
(

    override val sup: BasicElement,

    /**
     * Aluminum cable shield.
     */
    val aluminum: String,

    /**
     * Copper cable shield.
     */
    val copper: String,

    /**
     * Lead cable shield.
     */
    val lead: String,

    /**
     * Other kind of cable shield material.
     */
    val other: String,

    /**
     * Steel cable shield.
     */
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
 */
case class ConcentricNeutralCableInfo
(

    override val sup: CableInfo,

    /**
     * Diameter over the concentric neutral strands.
     */
    val diameterOverNeutral: Double,

    /**
     * Number of concentric neutral strands.
     */
    val neutralStrandCount: Int,

    /**
     * Geometric mean radius of the neutral strand.
     */
    val neutralStrandGmr: Double,

    /**
     * DC resistance per unit length of the neutral strand at 20 �C.
     */
    val neutralStrandRDC20: Double,

    /**
     * Outside radius of the neutral strand.
     */
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
 */
case class NoLoadTest
(

    override val sup: TransformerTest,

    /**
     * Voltage applied to the winding (end) during test.
     */
    val energisedEndVoltage: Double,

    /**
     * Exciting current measured from a positive-sequence or single-phase excitation test.
     */
    val excitingCurrent: Double,

    /**
     * Exciting current measured from a zero-sequence open-circuit excitation test.
     */
    val excitingCurrentZero: Double,

    /**
     * Losses measured from a positive-sequence or single-phase excitation test.
     */
    val loss: Double,

    /**
     * Losses measured from a zero-sequence excitation test.
     */
    val lossZero: Double,

    /**
     * Transformer end that current is applied to in this no-load test.
     */
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
 */
case class OpenCircuitTest
(

    override val sup: TransformerTest,

    /**
     * Tap step number for the energised end of the test pair.
     */
    val energisedEndStep: Int,

    /**
     * Voltage applied to the winding (end) during test.
     */
    val energisedEndVoltage: Double,

    /**
     * Tap step number for the open end of the test pair.
     */
    val openEndStep: Int,

    /**
     * Voltage measured at the open-circuited end, with the energised end set to rated voltage and all other ends open.
     */
    val openEndVoltage: Double,

    /**
     * Phase shift measured at the open end with the energised end set to rated voltage and all other ends open.
     */
    val phaseShift: Double,

    /**
     * Transformer end that current is applied to in this open-circuit test.
     */
    val EnergisedEnd: String,

    /**
     * Transformer end measured for induced voltage and angle in this open-circuit test.
     */
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
 */
case class OverheadWireInfo
(

    override val sup: WireInfo
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
 */
case class PowerTransformerInfo
(

    override val sup: AssetInfo
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
 */
case class ShortCircuitTest
(

    override val sup: TransformerTest,

    /**
     * Tap step number for the energised end of the test pair.
     */
    val energisedEndStep: Int,

    /**
     * Tap step number for the grounded end of the test pair.
     */
    val groundedEndStep: Int,

    /**
     * Leakage impedance measured from a positive-sequence or single-phase short-circuit test.
     */
    val leakageImpedance: Double,

    /**
     * Leakage impedance measured from a zero-sequence short-circuit test.
     */
    val leakageImpedanceZero: Double,

    /**
     * Load losses from a positive-sequence or single-phase short-circuit test.
     */
    val loss: Double,

    /**
     * Load losses from a zero-sequence short-circuit test.
     */
    val lossZero: Double,

    /**
     * Transformer end that voltage is applied to in this short-circuit test.
     * The test voltage is chosen to induce rated current in the energised end.
     */
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
 */
case class ShuntCompensatorInfo
(

    override val sup: AssetInfo,

    /**
     * Maximum allowed apparent power loss.
     */
    val maxPowerLoss: Double,

    /**
     * Rated current.
     */
    val ratedCurrent: Double,

    /**
     * Rated reactive power.
     */
    val ratedReactivePower: Double,

    /**
     * Rated voltage.
     */
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
 */
case class SwitchInfo
(

    override val sup: AssetInfo,

    /**
     * The maximum fault current a breaking device can break safely under prescribed conditions of use.
     */
    val breakingCapacity: Double,

    /**
     * If true, it is a single phase switch.
     */
    val isSinglePhase: Boolean,

    /**
     * If true, the switch is not ganged (i.e., a switch phase may be operated separately from other phases).
     */
    val isUnganged: Boolean,

    /**
     * Rated current.
     */
    val ratedCurrent: Double,

    /**
     * Rated voltage.
     */
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
 */
case class TapChangerInfo
(

    override val sup: AssetInfo,

    /**
     * Basic Insulation Level (BIL) expressed as the impulse crest voltage of a nominal wave, typically 1.2 X 50 microsecond.
     * This is a measure of the ability of the insulation to withstand very high voltage surges.
     */
    val bil: Double,

    /**
     * Built-in current transformer primary rating.
     */
    val ctRating: Double,

    /**
     * Built-in current transducer ratio.
     */
    val ctRatio: Double,

    /**
     * Frequency at which the ratings apply.
     */
    val frequency: Double,

    /**
     * Highest possible tap step position, advance from neutral.
     */
    val highStep: Int,

    /**
     * Whether this tap changer has under load tap changing capabilities.
     */
    val isTcul: Boolean,

    /**
     * Lowest possible tap step position, retard from neutral.
     */
    val lowStep: Int,

    /**
     * The neutral tap step position for the winding.
     */
    val neutralStep: Int,

    /**
     * Voltage at which the winding operates at the neutral tap setting.
     */
    val neutralU: Double,

    /**
     * Built-in voltage transducer ratio.
     */
    val ptRatio: Double,

    /**
     * Rated apparent power.
     */
    val ratedApparentPower: Double,

    /**
     * Rated current.
     */
    val ratedCurrent: Double,

    /**
     * Rated voltage.
     */
    val ratedVoltage: Double,

    /**
     * Phase shift per step position.
     */
    val stepPhaseIncrement: Double,

    /**
     * Tap step increment, in per cent of rated voltage, per step position.
     */
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
 */
case class TapeShieldCableInfo
(

    override val sup: CableInfo,

    /**
     * Percentage of the tape shield width that overlaps in each wrap, typically 10% to 25%.
     */
    val tapeLap: Double,

    /**
     * Thickness of the tape shield, before wrapping.
     */
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
 */
case class TransformerEndInfo
(

    override val sup: AssetInfo,

    /**
     * Kind of connection.
     */
    val connectionKind: String,

    /**
     * Apparent power that the winding can carry under emergency conditions (also called long-term emergency power).
     */
    val emergencyS: Double,

    /**
     * Number for this transformer end, corresponding to the end's order in the PowerTransformer.vectorGroup attribute.
     * Highest voltage winding should be 1.
     */
    val endNumber: Int,

    /**
     * Basic insulation level voltage rating.
     */
    val insulationU: Double,

    /**
     * Winding phase angle where 360 degrees are represented with clock hours, so the valid values are {0, ..., 11}.
     * For example, to express the second winding in code 'Dyn11', set attributes as follows: 'endNumber'=2, 'connectionKind' = Yn and 'phaseAngleClock' = 11.
     */
    val phaseAngleClock: Int,

    /**
     * DC resistance.
     */
    val r: Double,

    /**
     * Normal apparent power rating.
     */
    val ratedS: Double,

    /**
     * Rated voltage: phase-phase for three-phase windings, and either phase-phase or phase-neutral for single-phase windings.
     */
    val ratedU: Double,

    /**
     * Apparent power that this winding can carry for a short period of time (in emergency).
     */
    val shortTermS: Double,

    /**
     * Core admittance calculated from this transformer end datasheet, representing magnetising current and core losses.
     * The full values of the transformer should be supplied for one transformer end info only.
     */
    val CoreAdmittance: String,

    /**
     * All mesh impedances between this 'from' and other 'to' transformer ends.
     */
    val ToMeshImpedances: List[String],

    /**
     * Transformer star impedance calculated from this transformer end datasheet.
     */
    val TransformerStarImpedance: String,

    /**
     * Transformer tank data that this end description is part of.
     */
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
 */
case class TransformerTankInfo
(

    override val sup: AssetInfo,

    /**
     * Power transformer data that this tank description is part of.
     */
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
 */
case class TransformerTest
(

    override val sup: IdentifiedObject,

    /**
     * Base power at which the tests are conducted, usually equal to the rateds of one of the involved transformer ends.
     */
    val basePower: Double,

    /**
     * Temperature at which the test is conducted.
     */
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
 */
case class WireInfo
(

    override val sup: AssetInfo,

    /**
     * (if there is a different core material) Radius of the central core.
     */
    val coreRadius: Double,

    /**
     * (if used) Number of strands in the steel core.
     */
    val coreStrandCount: Int,

    /**
     * Geometric mean radius.
     * If we replace the conductor by a thin walled tube of radius GMR, then its reactance is identical to the reactance of the actual conductor.
     */
    val gmr: Double,

    /**
     * True if conductor is insulated.
     */
    val insulated: Boolean,

    /**
     * (if insulated conductor) Material used for insulation.
     */
    val insulationMaterial: String,

    /**
     * (if insulated conductor) Thickness of the insulation.
     */
    val insulationThickness: Double,

    /**
     * Conductor material.
     */
    val material: String,

    /**
     * AC resistance per unit length of the conductor at 25 �C.
     */
    val rAC25: Double,

    /**
     * AC resistance per unit length of the conductor at 50 �C.
     */
    val rAC50: Double,

    /**
     * AC resistance per unit length of the conductor at 75 �C.
     */
    val rAC75: Double,

    /**
     * DC resistance per unit length of the conductor at 20 �C.
     */
    val rDC20: Double,

    /**
     * Outside radius of the wire.
     */
    val radius: Double,

    /**
     * Current carrying capacity of the wire under stated thermal conditions.
     */
    val ratedCurrent: Double,

    /**
     * Describes the wire gauge or cross section (e.g., 4/0, #2, 336.5).
     */
    val sizeDescription: String,

    /**
     * Number of strands in the conductor.
     */
    val strandCount: Int,

    /**
     * All per-length parameters calculated from this wire datasheet.
     */
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
 */
case class WireInsulationKind
(

    override val sup: BasicElement,

    /**
     * Asbestos and varnished cambric wire insulation.
     */
    val asbestosAndVarnishedCambric: String,

    /**
     * Belted pilc wire insulation.
     */
    val beltedPilc: String,

    /**
     * Butyl wire insulation.
     */
    val butyl: String,

    /**
     * Crosslinked polyethylene wire insulation.
     */
    val crosslinkedPolyethylene: String,

    /**
     * Ethylene propylene rubber wire insulation.
     */
    val ethylenePropyleneRubber: String,

    /**
     * High nolecular weight polyethylene wire insulation.
     */
    val highMolecularWeightPolyethylene: String,

    /**
     * High pressure fluid filled wire insulation.
     */
    val highPressureFluidFilled: String,

    /**
     * Low capacitance rubber wire insulation.
     */
    val lowCapacitanceRubber: String,

    /**
     * Oil paper wire insulation.
     */
    val oilPaper: String,

    /**
     * Other kind of wire insulation.
     */
    val other: String,

    /**
     * Ozone resistant rubber wire insulation.
     */
    val ozoneResistantRubber: String,

    /**
     * Rubber wire insulation.
     */
    val rubber: String,

    /**
     * Silicon rubber wire insulation.
     */
    val siliconRubber: String,

    /**
     * Tree resistant high molecular weight polyethylene wire insulation.
     */
    val treeResistantHighMolecularWeightPolyethylene: String,

    /**
     * Tree retardant crosslinked polyethylene wire insulation.
     */
    val treeRetardantCrosslinkedPolyethylene: String,

    /**
     * Unbelted pilc wire insulation.
     */
    val unbeltedPilc: String,

    /**
     * Varnished cambric cloth wire insulation.
     */
    val varnishedCambricCloth: String,

    /**
     * Varnished dacron glass wire insulation.
     */
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
 */
case class WireMaterialKind
(

    override val sup: BasicElement,

    /**
     * Aluminum-alloy conductor steel reinforced.
     */
    val aaac: String,

    /**
     * Aluminum conductor steel reinforced.
     */
    val acsr: String,

    /**
     * Aluminum wire.
     */
    val aluminum: String,

    /**
     * Aluminum-alloy wire.
     */
    val aluminumAlloy: String,

    /**
     * Aluminum-alloy-steel wire.
     */
    val aluminumAlloySteel: String,

    /**
     * Aluminum-steel wire.
     */
    val aluminumSteel: String,

    /**
     * Copper wire.
     */
    val copper: String,

    /**
     * Other wire material.
     */
    val other: String,

    /**
     * Steel wire.
     */
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
 */
case class WirePosition
(

    override val sup: IdentifiedObject,

    /**
     * Single phase or neutral designation for the wire with this position.
     */
    val phase: String,

    /**
     * Signed horizontal distance from the wire at this position to a common reference point.
     */
    val xCoord: Double,

    /**
     * Signed vertical distance from the wire at this position: above ground (positive value) or burial depth below ground (negative value).
     */
    val yCoord: Double,

    /**
     * Wire spacing data this wire position belongs to.
     */
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
 */
case class WireSpacingInfo
(

    override val sup: AssetInfo,

    /**
     * If true, this spacing data describes a cable.
     */
    val isCable: Boolean,

    /**
     * Number of wire sub-conductors in the symmetrical bundle (typically between 1 and 4).
     */
    val phaseWireCount: Int,

    /**
     * Distance between wire sub-conductors in a symmetrical bundle.
     */
    val phaseWireSpacing: Double,

    /**
     * Usage of the associated wires.
     */
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
 */
case class WireUsageKind
(

    override val sup: BasicElement,

    /**
     * Wire is used in medium voltage network.
     */
    val distribution: String,

    /**
     * Other kind of wire usage.
     */
    val other: String,

    /**
     * Wire is used in low voltage circuit.
     */
    val secondary: String,

    /**
     * Wire is used in extra-high voltage or high voltage network.
     */
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