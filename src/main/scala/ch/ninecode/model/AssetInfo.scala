package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

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
    override def copy (): Row = { return (clone ().asInstanceOf[BusbarSectionInfo]); }
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
    val ratedCurrent = parse_element (element ("""BusbarSectionInfo.ratedCurrent"""))_
    val ratedVoltage = parse_element (element ("""BusbarSectionInfo.ratedVoltage"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[CableInfo]); }
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
    override def copy (): Row = { return (clone ().asInstanceOf[ConcentricNeutralCableInfo]); }
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
    val diameterOverNeutral = parse_element (element ("""ConcentricNeutralCableInfo.diameterOverNeutral"""))_
    val neutralStrandCount = parse_element (element ("""ConcentricNeutralCableInfo.neutralStrandCount"""))_
    val neutralStrandGmr = parse_element (element ("""ConcentricNeutralCableInfo.neutralStrandGmr"""))_
    val neutralStrandRDC20 = parse_element (element ("""ConcentricNeutralCableInfo.neutralStrandRDC20"""))_
    val neutralStrandRadius = parse_element (element ("""ConcentricNeutralCableInfo.neutralStrandRadius"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[NoLoadTest]); }
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
    val energisedEndVoltage = parse_element (element ("""NoLoadTest.energisedEndVoltage"""))_
    val excitingCurrent = parse_element (element ("""NoLoadTest.excitingCurrent"""))_
    val excitingCurrentZero = parse_element (element ("""NoLoadTest.excitingCurrentZero"""))_
    val loss = parse_element (element ("""NoLoadTest.loss"""))_
    val lossZero = parse_element (element ("""NoLoadTest.lossZero"""))_
    val EnergisedEnd = parse_attribute (attribute ("""NoLoadTest.EnergisedEnd"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[OpenCircuitTest]); }
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
    val energisedEndStep = parse_element (element ("""OpenCircuitTest.energisedEndStep"""))_
    val energisedEndVoltage = parse_element (element ("""OpenCircuitTest.energisedEndVoltage"""))_
    val openEndStep = parse_element (element ("""OpenCircuitTest.openEndStep"""))_
    val openEndVoltage = parse_element (element ("""OpenCircuitTest.openEndVoltage"""))_
    val phaseShift = parse_element (element ("""OpenCircuitTest.phaseShift"""))_
    val EnergisedEnd = parse_attribute (attribute ("""OpenCircuitTest.EnergisedEnd"""))_
    val OpenEnd = parse_attribute (attribute ("""OpenCircuitTest.OpenEnd"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[OverheadWireInfo]); }
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
    override def copy (): Row = { return (clone ().asInstanceOf[PowerTransformerInfo]); }
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
    override def copy (): Row = { return (clone ().asInstanceOf[ShortCircuitTest]); }
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
    val energisedEndStep = parse_element (element ("""ShortCircuitTest.energisedEndStep"""))_
    val groundedEndStep = parse_element (element ("""ShortCircuitTest.groundedEndStep"""))_
    val leakageImpedance = parse_element (element ("""ShortCircuitTest.leakageImpedance"""))_
    val leakageImpedanceZero = parse_element (element ("""ShortCircuitTest.leakageImpedanceZero"""))_
    val loss = parse_element (element ("""ShortCircuitTest.loss"""))_
    val lossZero = parse_element (element ("""ShortCircuitTest.lossZero"""))_
    val EnergisedEnd = parse_attribute (attribute ("""ShortCircuitTest.EnergisedEnd"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[ShuntCompensatorInfo]); }
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
    val maxPowerLoss = parse_element (element ("""ShuntCompensatorInfo.maxPowerLoss"""))_
    val ratedCurrent = parse_element (element ("""ShuntCompensatorInfo.ratedCurrent"""))_
    val ratedReactivePower = parse_element (element ("""ShuntCompensatorInfo.ratedReactivePower"""))_
    val ratedVoltage = parse_element (element ("""ShuntCompensatorInfo.ratedVoltage"""))_
    val shuntCompensatorControl = parse_attribute (attribute ("""ShuntCompensatorInfo.shuntCompensatorControl"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[SwitchInfo]); }
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
    val breakingCapacity = parse_element (element ("""SwitchInfo.breakingCapacity"""))_
    val isSinglePhase = parse_element (element ("""SwitchInfo.isSinglePhase"""))_
    val isUnganged = parse_element (element ("""SwitchInfo.isUnganged"""))_
    val ratedCurrent = parse_element (element ("""SwitchInfo.ratedCurrent"""))_
    val ratedVoltage = parse_element (element ("""SwitchInfo.ratedVoltage"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[TapChangerInfo]); }
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
    override def copy (): Row = { return (clone ().asInstanceOf[TapeShieldCableInfo]); }
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
    val tapeLap = parse_element (element ("""TapeShieldCableInfo.tapeLap"""))_
    val tapeThickness = parse_element (element ("""TapeShieldCableInfo.tapeThickness"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerEndInfo]); }
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
    val TransformerStarImpedence = parse_attribute (attribute ("""TransformerEndInfo.TransformerStarImpedence"""))_
    val TransformerTankInfo = parse_attribute (attribute ("""TransformerEndInfo.TransformerTankInfo"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerTankInfo]); }
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
    val PowerTransformerInfo = parse_attribute (attribute ("""TransformerTankInfo.PowerTransformerInfo"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerTest]); }
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
    val basePower = parse_element (element ("""TransformerTest.basePower"""))_
    val temperature = parse_element (element ("""TransformerTest.temperature"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[WireInfo]); }
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
    override def copy (): Row = { return (clone ().asInstanceOf[WirePosition]); }
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
    val phase = parse_attribute (attribute ("""WirePosition.phase"""))_
    val xCoord = parse_element (element ("""WirePosition.xCoord"""))_
    val yCoord = parse_element (element ("""WirePosition.yCoord"""))_
    val WireSpacingInfo = parse_attribute (attribute ("""WirePosition.WireSpacingInfo"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[WireSpacingInfo]); }
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
    val isCable = parse_element (element ("""WireSpacingInfo.isCable"""))_
    val phaseWireCount = parse_element (element ("""WireSpacingInfo.phaseWireCount"""))_
    val phaseWireSpacing = parse_element (element ("""WireSpacingInfo.phaseWireSpacing"""))_
    val usage = parse_attribute (attribute ("""WireSpacingInfo.usage"""))_
    val DuctBank = parse_attribute (attribute ("""WireSpacingInfo.DuctBank"""))_
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

