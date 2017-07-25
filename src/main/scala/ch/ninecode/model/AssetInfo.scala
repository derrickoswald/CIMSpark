package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/*
 * Package: AssetInfo
 */

case class BusbarSectionInfo
(
    override val sup: AssetInfo,
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
    val ratedCurrent = parse_element (element ("""BusbarSectionInfo.ratedCurrent"""))
    val ratedVoltage = parse_element (element ("""BusbarSectionInfo.ratedVoltage"""))
    def parse (context: Context): BusbarSectionInfo =
    {
        return (
            BusbarSectionInfo
            (
                AssetInfo.parse (context),
                toDouble (ratedCurrent (context), context),
                toDouble (ratedVoltage (context), context)
            )
        )
    }
}

case class CableInfo
(
    override val sup: WireInfo,
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
    val constructionKind = parse_attribute (attribute ("""CableInfo.constructionKind"""))

    val diameterOverCore = parse_element (element ("""CableInfo.diameterOverCore"""))
    val diameterOverInsulation = parse_element (element ("""CableInfo.diameterOverInsulation"""))
    val diameterOverJacket = parse_element (element ("""CableInfo.diameterOverJacket"""))
    val diameterOverScreen = parse_element (element ("""CableInfo.diameterOverScreen"""))
    val isStrandFill = parse_element (element ("""CableInfo.isStrandFill"""))
    val nominalTemperature = parse_element (element ("""CableInfo.nominalTemperature"""))
    val outerJacketKind = parse_attribute (attribute ("""CableInfo.outerJacketKind"""))
    val sheathAsNeutral = parse_element (element ("""CableInfo.sheathAsNeutral"""))
    val shieldMaterial = parse_attribute (attribute ("""CableInfo.shieldMaterial"""))
    def parse (context: Context): CableInfo =
    {
        return (
            CableInfo
            (
                WireInfo.parse (context),
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
        )
    }
}

case class ConcentricNeutralCableInfo
(
    override val sup: CableInfo,
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
    val diameterOverNeutral = parse_element (element ("""ConcentricNeutralCableInfo.diameterOverNeutral"""))
    val neutralStrandCount = parse_element (element ("""ConcentricNeutralCableInfo.neutralStrandCount"""))
    val neutralStrandGmr = parse_element (element ("""ConcentricNeutralCableInfo.neutralStrandGmr"""))
    val neutralStrandRDC20 = parse_element (element ("""ConcentricNeutralCableInfo.neutralStrandRDC20"""))
    val neutralStrandRadius = parse_element (element ("""ConcentricNeutralCableInfo.neutralStrandRadius"""))
    def parse (context: Context): ConcentricNeutralCableInfo =
    {
        return (
            ConcentricNeutralCableInfo
            (
                CableInfo.parse (context),
                toDouble (diameterOverNeutral (context), context),
                toInteger (neutralStrandCount (context), context),
                toDouble (neutralStrandGmr (context), context),
                toDouble (neutralStrandRDC20 (context), context),
                toDouble (neutralStrandRadius (context), context)
            )
        )
    }
}

case class NoLoadTest
(
    override val sup: TransformerTest,
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
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null)}
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
    val energisedEndVoltage = parse_element (element ("""NoLoadTest.energisedEndVoltage"""))
    val excitingCurrent = parse_element (element ("""NoLoadTest.excitingCurrent"""))
    val excitingCurrentZero = parse_element (element ("""NoLoadTest.excitingCurrentZero"""))
    val loss = parse_element (element ("""NoLoadTest.loss"""))
    val lossZero = parse_element (element ("""NoLoadTest.lossZero"""))
    val EnergisedEnd = parse_attribute (attribute ("""NoLoadTest.EnergisedEnd"""))
    def parse (context: Context): NoLoadTest =
    {
        return (
            NoLoadTest
            (
                TransformerTest.parse (context),
                toDouble (energisedEndVoltage (context), context),
                toDouble (excitingCurrent (context), context),
                toDouble (excitingCurrentZero (context), context),
                toDouble (loss (context), context),
                toDouble (lossZero (context), context),
                EnergisedEnd (context)
            )
        )
    }
}

case class OpenCircuitTest
(
    override val sup: TransformerTest,
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
    val energisedEndStep = parse_element (element ("""OpenCircuitTest.energisedEndStep"""))
    val energisedEndVoltage = parse_element (element ("""OpenCircuitTest.energisedEndVoltage"""))
    val openEndStep = parse_element (element ("""OpenCircuitTest.openEndStep"""))
    val openEndVoltage = parse_element (element ("""OpenCircuitTest.openEndVoltage"""))
    val phaseShift = parse_element (element ("""OpenCircuitTest.phaseShift"""))
    val EnergisedEnd = parse_attribute (attribute ("""OpenCircuitTest.EnergisedEnd"""))
    val OpenEnd = parse_attribute (attribute ("""OpenCircuitTest.OpenEnd"""))
    def parse (context: Context): OpenCircuitTest =
    {
        return (
            OpenCircuitTest
            (
                TransformerTest.parse (context),
                toInteger (energisedEndStep (context), context),
                toDouble (energisedEndVoltage (context), context),
                toInteger (openEndStep (context), context),
                toDouble (openEndVoltage (context), context),
                toDouble (phaseShift (context), context),
                EnergisedEnd (context),
                OpenEnd (context)
            )
        )
    }
}

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
    def parse (context: Context): OverheadWireInfo =
    {
        return (
            OverheadWireInfo
            (
                WireInfo.parse (context)
            )
        )
    }
}

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
    override def isNullAt(i: Int): Boolean = 
    { 
      if (i < productArity)
            if (productElement (i).isInstanceOf[AnyRef]) {
              return true
            }
        else
            throw new IllegalArgumentException ("invalid property index " + i)
      return false
    }
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
    def parse (context: Context): PowerTransformerInfo =
    {
        return (
            PowerTransformerInfo
            (
                AssetInfo.parse (context)
            )
        )
    }
}

case class ShortCircuitTest
(
    override val sup: TransformerTest,
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
    val energisedEndStep = parse_element (element ("""ShortCircuitTest.energisedEndStep"""))
    val groundedEndStep = parse_element (element ("""ShortCircuitTest.groundedEndStep"""))
    val leakageImpedance = parse_element (element ("""ShortCircuitTest.leakageImpedance"""))
    val leakageImpedanceZero = parse_element (element ("""ShortCircuitTest.leakageImpedanceZero"""))
    val loss = parse_element (element ("""ShortCircuitTest.loss"""))
    val lossZero = parse_element (element ("""ShortCircuitTest.lossZero"""))
    val EnergisedEnd = parse_attribute (attribute ("""ShortCircuitTest.EnergisedEnd"""))
    def parse (context: Context): ShortCircuitTest =
    {
        return (
            ShortCircuitTest
            (
                TransformerTest.parse (context),
                toInteger (energisedEndStep (context), context),
                toInteger (groundedEndStep (context), context),
                toDouble (leakageImpedance (context), context),
                toDouble (leakageImpedanceZero (context), context),
                toDouble (loss (context), context),
                toDouble (lossZero (context), context),
                EnergisedEnd (context)
            )
        )
    }
}

case class ShuntCompensatorInfo
(
    override val sup: AssetInfo,
    val maxPowerLoss: Double,
    val ratedCurrent: Double,
    val ratedReactivePower: Double,
    val ratedVoltage: Double,
    val shuntCompensatorControl: String
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
    val maxPowerLoss = parse_element (element ("""ShuntCompensatorInfo.maxPowerLoss"""))
    val ratedCurrent = parse_element (element ("""ShuntCompensatorInfo.ratedCurrent"""))
    val ratedReactivePower = parse_element (element ("""ShuntCompensatorInfo.ratedReactivePower"""))
    val ratedVoltage = parse_element (element ("""ShuntCompensatorInfo.ratedVoltage"""))
    val shuntCompensatorControl = parse_attribute (attribute ("""ShuntCompensatorInfo.shuntCompensatorControl"""))
    def parse (context: Context): ShuntCompensatorInfo =
    {
        return (
            ShuntCompensatorInfo
            (
                AssetInfo.parse (context),
                toDouble (maxPowerLoss (context), context),
                toDouble (ratedCurrent (context), context),
                toDouble (ratedReactivePower (context), context),
                toDouble (ratedVoltage (context), context),
                shuntCompensatorControl (context)
            )
        )
    }
}

case class SwitchInfo
(
    override val sup: AssetInfo,
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
    val breakingCapacity = parse_element (element ("""SwitchInfo.breakingCapacity"""))
    val isSinglePhase = parse_element (element ("""SwitchInfo.isSinglePhase"""))
    val isUnganged = parse_element (element ("""SwitchInfo.isUnganged"""))
    val ratedCurrent = parse_element (element ("""SwitchInfo.ratedCurrent"""))
    val ratedVoltage = parse_element (element ("""SwitchInfo.ratedVoltage"""))
    def parse (context: Context): SwitchInfo =
    {
        return (
            SwitchInfo
            (
                AssetInfo.parse (context),
                toDouble (breakingCapacity (context), context),
                toBoolean (isSinglePhase (context), context),
                toBoolean (isUnganged (context), context),
                toDouble (ratedCurrent (context), context),
                toDouble (ratedVoltage (context), context)
            )
        )
    }
}

case class TapChangerInfo
(
    override val sup: AssetInfo,
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
    val bil = parse_element (element ("""TapChangerInfo.bil"""))
    val ctRating = parse_element (element ("""TapChangerInfo.ctRating"""))
    val ctRatio = parse_element (element ("""TapChangerInfo.ctRatio"""))
    val frequency = parse_element (element ("""TapChangerInfo.frequency"""))
    val highStep = parse_element (element ("""TapChangerInfo.highStep"""))
    val isTcul = parse_element (element ("""TapChangerInfo.isTcul"""))
    val lowStep = parse_element (element ("""TapChangerInfo.lowStep"""))
    val neutralStep = parse_element (element ("""TapChangerInfo.neutralStep"""))
    val neutralU = parse_element (element ("""TapChangerInfo.neutralU"""))
    val ptRatio = parse_element (element ("""TapChangerInfo.ptRatio"""))
    val ratedApparentPower = parse_element (element ("""TapChangerInfo.ratedApparentPower"""))
    val ratedCurrent = parse_element (element ("""TapChangerInfo.ratedCurrent"""))
    val ratedVoltage = parse_element (element ("""TapChangerInfo.ratedVoltage"""))
    val stepPhaseIncrement = parse_element (element ("""TapChangerInfo.stepPhaseIncrement"""))
    val stepVoltageIncrement = parse_element (element ("""TapChangerInfo.stepVoltageIncrement"""))
    def parse (context: Context): TapChangerInfo =
    {
        return (
            TapChangerInfo
            (
                AssetInfo.parse (context),
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
        )
    }
}

case class TapeShieldCableInfo
(
    override val sup: CableInfo,
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
    val tapeLap = parse_element (element ("""TapeShieldCableInfo.tapeLap"""))
    val tapeThickness = parse_element (element ("""TapeShieldCableInfo.tapeThickness"""))
    def parse (context: Context): TapeShieldCableInfo =
    {
        return (
            TapeShieldCableInfo
            (
                CableInfo.parse (context),
                toDouble (tapeLap (context), context),
                toDouble (tapeThickness (context), context)
            )
        )
    }
}

case class TransformerEndInfo
(
    override val sup: AssetInfo,
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
    val TransformerStarImpedence: String,
    val TransformerTankInfo: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, null, null, null) }
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
    val connectionKind = parse_attribute (attribute ("""TransformerEndInfo.connectionKind"""))
    val emergencyS = parse_element (element ("""TransformerEndInfo.emergencyS"""))
    val endNumber = parse_element (element ("""TransformerEndInfo.endNumber"""))
    val insulationU = parse_element (element ("""TransformerEndInfo.insulationU"""))
    val phaseAngleClock = parse_element (element ("""TransformerEndInfo.phaseAngleClock"""))
    val r = parse_element (element ("""TransformerEndInfo.r"""))
    val ratedS = parse_element (element ("""TransformerEndInfo.ratedS"""))
    val ratedU = parse_element (element ("""TransformerEndInfo.ratedU"""))
    val shortTermS = parse_element (element ("""TransformerEndInfo.shortTermS"""))
    val CoreAdmittance = parse_attribute (attribute ("""TransformerEndInfo.CoreAdmittance"""))
    val TransformerStarImpedence = parse_attribute (attribute ("""TransformerEndInfo.TransformerStarImpedence"""))
    val TransformerTankInfo = parse_attribute (attribute ("""TransformerEndInfo.TransformerTankInfo"""))
    def parse (context: Context): TransformerEndInfo =
    {
        return (
            TransformerEndInfo
            (
                AssetInfo.parse (context),
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
                TransformerStarImpedence (context),
                TransformerTankInfo (context)
            )
        )
    }
}

case class TransformerTankInfo
(
    override val sup: AssetInfo,
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
    val PowerTransformerInfo = parse_attribute (attribute ("""TransformerTankInfo.PowerTransformerInfo"""))
    def parse (context: Context): TransformerTankInfo =
    {
        return (
            TransformerTankInfo
            (
                AssetInfo.parse (context),
                PowerTransformerInfo (context)
            )
        )
    }
}

case class TransformerTest
(
    override val sup: IdentifiedObject,
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
    val basePower = parse_element (element ("""TransformerTest.basePower"""))
    val temperature = parse_element (element ("""TransformerTest.temperature"""))
    def parse (context: Context): TransformerTest =
    {
        return (
            TransformerTest
            (
                IdentifiedObject.parse (context),
                toDouble (basePower (context), context),
                toDouble (temperature (context), context)
            )
        )
    }
}

case class WireInfo
(
    override val sup: AssetInfo,
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
    val strandCount: Int
)
extends
    Element
{
    def this () = { this (null, 0.0, 0, 0.0, false, null, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0 ) }
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
    val coreRadius = parse_element (element ("""WireInfo.coreRadius"""))
    val coreStrandCount = parse_element (element ("""WireInfo.coreStrandCount"""))
    val gmr = parse_element (element ("""WireInfo.gmr"""))
    val insulated = parse_element (element ("""WireInfo.insulated"""))
    val insulationMaterial = parse_attribute (attribute ("""WireInfo.insulationMaterial"""))
    val insulationThickness = parse_element (element ("""WireInfo.insulationThickness"""))
    val material = parse_attribute (attribute ("""WireInfo.material"""))
    val rAC25 = parse_element (element ("""WireInfo.rAC25"""))
    val rAC50 = parse_element (element ("""WireInfo.rAC50"""))
    val rAC75 = parse_element (element ("""WireInfo.rAC75"""))
    val rDC20 = parse_element (element ("""WireInfo.rDC20"""))
    val radius = parse_element (element ("""WireInfo.radius"""))
    val ratedCurrent = parse_element (element ("""WireInfo.ratedCurrent"""))
    val sizeDescription = parse_element (element ("""WireInfo.sizeDescription"""))
    val strandCount = parse_element (element ("""WireInfo.strandCount"""))
    def parse (context: Context): WireInfo =
    {
        return (
            WireInfo
            (
                AssetInfo.parse (context),
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
                toInteger (strandCount (context), context)
            )
        )
    }
}

case class WirePosition
(
    override val sup: IdentifiedObject,
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
    val phase = parse_attribute (attribute ("""WirePosition.phase"""))
    val xCoord = parse_element (element ("""WirePosition.xCoord"""))
    val yCoord = parse_element (element ("""WirePosition.yCoord"""))
    val WireSpacingInfo = parse_attribute (attribute ("""WirePosition.WireSpacingInfo"""))
    def parse (context: Context): WirePosition =
    {
        return (
            WirePosition
            (
                IdentifiedObject.parse (context),
                phase (context),
                toDouble (xCoord (context), context),
                toDouble (yCoord (context), context),
                WireSpacingInfo (context)
            )
        )
    }
}

case class WireSpacingInfo
(
    override val sup: AssetInfo,
    val isCable: Boolean,
    val phaseWireCount: Int,
    val phaseWireSpacing: Double,
    val usage: String,
    val DuctBank: String
)
extends
    Element
{
    def this () = { this (null, false, 0, 0.0, null, null) }
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
    val isCable = parse_element (element ("""WireSpacingInfo.isCable"""))
    val phaseWireCount = parse_element (element ("""WireSpacingInfo.phaseWireCount"""))
    val phaseWireSpacing = parse_element (element ("""WireSpacingInfo.phaseWireSpacing"""))
    val usage = parse_attribute (attribute ("""WireSpacingInfo.usage"""))
    val DuctBank = parse_attribute (attribute ("""WireSpacingInfo.DuctBank"""))
    def parse (context: Context): WireSpacingInfo =
    {
        return (
            WireSpacingInfo
            (
                AssetInfo.parse (context),
                toBoolean (isCable (context), context),
                toInteger (phaseWireCount (context), context),
                toDouble (phaseWireSpacing (context), context),
                usage (context),
                DuctBank (context)
            )
        )
    }
}

object _AssetInfo
{
    def register: Unit =
    {
        BusbarSectionInfo.register
        CableInfo.register
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
        WirePosition.register
        WireSpacingInfo.register
    }
}

