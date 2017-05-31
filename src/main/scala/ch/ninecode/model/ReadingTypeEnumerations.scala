package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


case class AccumulationKind
(
    override val sup: BasicElement,
    val boundedQuantity: String,
    val bulkQuantity: String,
    val continuousCumulative: String,
    val cumulative: String,
    val deltaData: String,
    val indicating: String,
    val instantaneous: String,
    val latchingQuantity: String,
    val none: String,
    val summation: String,
    val timeDelay: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AccumulationKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AccumulationKind
extends
    Parseable[AccumulationKind]
{
    val sup = BasicElement.parse _
    val boundedQuantity = parse_attribute (attribute ("""AccumulationKind.boundedQuantity"""))
    val bulkQuantity = parse_attribute (attribute ("""AccumulationKind.bulkQuantity"""))
    val continuousCumulative = parse_attribute (attribute ("""AccumulationKind.continuousCumulative"""))
    val cumulative = parse_attribute (attribute ("""AccumulationKind.cumulative"""))
    val deltaData = parse_attribute (attribute ("""AccumulationKind.deltaData"""))
    val indicating = parse_attribute (attribute ("""AccumulationKind.indicating"""))
    val instantaneous = parse_attribute (attribute ("""AccumulationKind.instantaneous"""))
    val latchingQuantity = parse_attribute (attribute ("""AccumulationKind.latchingQuantity"""))
    val none = parse_attribute (attribute ("""AccumulationKind.none"""))
    val summation = parse_attribute (attribute ("""AccumulationKind.summation"""))
    val timeDelay = parse_attribute (attribute ("""AccumulationKind.timeDelay"""))
    def parse (context: Context): AccumulationKind =
    {
        AccumulationKind(
            sup (context),
            boundedQuantity (context),
            bulkQuantity (context),
            continuousCumulative (context),
            cumulative (context),
            deltaData (context),
            indicating (context),
            instantaneous (context),
            latchingQuantity (context),
            none (context),
            summation (context),
            timeDelay (context)
        )
    }
}

case class AggregateKind
(
    override val sup: BasicElement,
    val average: String,
    val excess: String,
    val fifthMaximum: String,
    val fourthMaximum: String,
    val highThreshold: String,
    val lowThreshold: String,
    val maximum: String,
    val minimum: String,
    val nominal: String,
    val none: String,
    val normal: String,
    val secondMaximum: String,
    val secondMinimum: String,
    val sum: String,
    val thirdMaximum: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AggregateKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AggregateKind
extends
    Parseable[AggregateKind]
{
    val sup = BasicElement.parse _
    val average = parse_attribute (attribute ("""AggregateKind.average"""))
    val excess = parse_attribute (attribute ("""AggregateKind.excess"""))
    val fifthMaximum = parse_attribute (attribute ("""AggregateKind.fifthMaximum"""))
    val fourthMaximum = parse_attribute (attribute ("""AggregateKind.fourthMaximum"""))
    val highThreshold = parse_attribute (attribute ("""AggregateKind.highThreshold"""))
    val lowThreshold = parse_attribute (attribute ("""AggregateKind.lowThreshold"""))
    val maximum = parse_attribute (attribute ("""AggregateKind.maximum"""))
    val minimum = parse_attribute (attribute ("""AggregateKind.minimum"""))
    val nominal = parse_attribute (attribute ("""AggregateKind.nominal"""))
    val none = parse_attribute (attribute ("""AggregateKind.none"""))
    val normal = parse_attribute (attribute ("""AggregateKind.normal"""))
    val secondMaximum = parse_attribute (attribute ("""AggregateKind.secondMaximum"""))
    val secondMinimum = parse_attribute (attribute ("""AggregateKind.secondMinimum"""))
    val sum = parse_attribute (attribute ("""AggregateKind.sum"""))
    val thirdMaximum = parse_attribute (attribute ("""AggregateKind.thirdMaximum"""))
    def parse (context: Context): AggregateKind =
    {
        AggregateKind(
            sup (context),
            average (context),
            excess (context),
            fifthMaximum (context),
            fourthMaximum (context),
            highThreshold (context),
            lowThreshold (context),
            maximum (context),
            minimum (context),
            nominal (context),
            none (context),
            normal (context),
            secondMaximum (context),
            secondMinimum (context),
            sum (context),
            thirdMaximum (context)
        )
    }
}

case class CommodityKind
(
    override val sup: BasicElement,
    val air: String,
    val carbon: String,
    val ch4: String,
    val co2: String,
    val communication: String,
    val coolingFluid: String,
    val electricityPrimaryMetered: String,
    val electricitySecondaryMetered: String,
    val hch: String,
    val heatingFluid: String,
    val insulativeGas: String,
    val insulativeOil: String,
    val internet: String,
    val naturalGas: String,
    val none: String,
    val nonpotableWater: String,
    val nox: String,
    val pfc: String,
    val potableWater: String,
    val propane: String,
    val refuse: String,
    val sf6: String,
    val so2: String,
    val steam: String,
    val tvLicence: String,
    val wasteWater: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CommodityKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CommodityKind
extends
    Parseable[CommodityKind]
{
    val sup = BasicElement.parse _
    val air = parse_attribute (attribute ("""CommodityKind.air"""))
    val carbon = parse_attribute (attribute ("""CommodityKind.carbon"""))
    val ch4 = parse_attribute (attribute ("""CommodityKind.ch4"""))
    val co2 = parse_attribute (attribute ("""CommodityKind.co2"""))
    val communication = parse_attribute (attribute ("""CommodityKind.communication"""))
    val coolingFluid = parse_attribute (attribute ("""CommodityKind.coolingFluid"""))
    val electricityPrimaryMetered = parse_attribute (attribute ("""CommodityKind.electricityPrimaryMetered"""))
    val electricitySecondaryMetered = parse_attribute (attribute ("""CommodityKind.electricitySecondaryMetered"""))
    val hch = parse_attribute (attribute ("""CommodityKind.hch"""))
    val heatingFluid = parse_attribute (attribute ("""CommodityKind.heatingFluid"""))
    val insulativeGas = parse_attribute (attribute ("""CommodityKind.insulativeGas"""))
    val insulativeOil = parse_attribute (attribute ("""CommodityKind.insulativeOil"""))
    val internet = parse_attribute (attribute ("""CommodityKind.internet"""))
    val naturalGas = parse_attribute (attribute ("""CommodityKind.naturalGas"""))
    val none = parse_attribute (attribute ("""CommodityKind.none"""))
    val nonpotableWater = parse_attribute (attribute ("""CommodityKind.nonpotableWater"""))
    val nox = parse_attribute (attribute ("""CommodityKind.nox"""))
    val pfc = parse_attribute (attribute ("""CommodityKind.pfc"""))
    val potableWater = parse_attribute (attribute ("""CommodityKind.potableWater"""))
    val propane = parse_attribute (attribute ("""CommodityKind.propane"""))
    val refuse = parse_attribute (attribute ("""CommodityKind.refuse"""))
    val sf6 = parse_attribute (attribute ("""CommodityKind.sf6"""))
    val so2 = parse_attribute (attribute ("""CommodityKind.so2"""))
    val steam = parse_attribute (attribute ("""CommodityKind.steam"""))
    val tvLicence = parse_attribute (attribute ("""CommodityKind.tvLicence"""))
    val wasteWater = parse_attribute (attribute ("""CommodityKind.wasteWater"""))
    def parse (context: Context): CommodityKind =
    {
        CommodityKind(
            sup (context),
            air (context),
            carbon (context),
            ch4 (context),
            co2 (context),
            communication (context),
            coolingFluid (context),
            electricityPrimaryMetered (context),
            electricitySecondaryMetered (context),
            hch (context),
            heatingFluid (context),
            insulativeGas (context),
            insulativeOil (context),
            internet (context),
            naturalGas (context),
            none (context),
            nonpotableWater (context),
            nox (context),
            pfc (context),
            potableWater (context),
            propane (context),
            refuse (context),
            sf6 (context),
            so2 (context),
            steam (context),
            tvLicence (context),
            wasteWater (context)
        )
    }
}

case class FlowDirectionKind
(
    override val sup: BasicElement,
    val forward: String,
    val lagging: String,
    val leading: String,
    val net: String,
    val none: String,
    val q1minusQ4: String,
    val q1plusQ2: String,
    val q1plusQ3: String,
    val q1plusQ4: String,
    val q2minusQ3: String,
    val q2plusQ3: String,
    val q2plusQ4: String,
    val q3minusQ2: String,
    val q3plusQ4: String,
    val quadrant1: String,
    val quadrant2: String,
    val quadrant3: String,
    val quadrant4: String,
    val reverse: String,
    val total: String,
    val totalByPhase: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[FlowDirectionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FlowDirectionKind
extends
    Parseable[FlowDirectionKind]
{
    val sup = BasicElement.parse _
    val forward = parse_attribute (attribute ("""FlowDirectionKind.forward"""))
    val lagging = parse_attribute (attribute ("""FlowDirectionKind.lagging"""))
    val leading = parse_attribute (attribute ("""FlowDirectionKind.leading"""))
    val net = parse_attribute (attribute ("""FlowDirectionKind.net"""))
    val none = parse_attribute (attribute ("""FlowDirectionKind.none"""))
    val q1minusQ4 = parse_attribute (attribute ("""FlowDirectionKind.q1minusQ4"""))
    val q1plusQ2 = parse_attribute (attribute ("""FlowDirectionKind.q1plusQ2"""))
    val q1plusQ3 = parse_attribute (attribute ("""FlowDirectionKind.q1plusQ3"""))
    val q1plusQ4 = parse_attribute (attribute ("""FlowDirectionKind.q1plusQ4"""))
    val q2minusQ3 = parse_attribute (attribute ("""FlowDirectionKind.q2minusQ3"""))
    val q2plusQ3 = parse_attribute (attribute ("""FlowDirectionKind.q2plusQ3"""))
    val q2plusQ4 = parse_attribute (attribute ("""FlowDirectionKind.q2plusQ4"""))
    val q3minusQ2 = parse_attribute (attribute ("""FlowDirectionKind.q3minusQ2"""))
    val q3plusQ4 = parse_attribute (attribute ("""FlowDirectionKind.q3plusQ4"""))
    val quadrant1 = parse_attribute (attribute ("""FlowDirectionKind.quadrant1"""))
    val quadrant2 = parse_attribute (attribute ("""FlowDirectionKind.quadrant2"""))
    val quadrant3 = parse_attribute (attribute ("""FlowDirectionKind.quadrant3"""))
    val quadrant4 = parse_attribute (attribute ("""FlowDirectionKind.quadrant4"""))
    val reverse = parse_attribute (attribute ("""FlowDirectionKind.reverse"""))
    val total = parse_attribute (attribute ("""FlowDirectionKind.total"""))
    val totalByPhase = parse_attribute (attribute ("""FlowDirectionKind.totalByPhase"""))
    def parse (context: Context): FlowDirectionKind =
    {
        FlowDirectionKind(
            sup (context),
            forward (context),
            lagging (context),
            leading (context),
            net (context),
            none (context),
            q1minusQ4 (context),
            q1plusQ2 (context),
            q1plusQ3 (context),
            q1plusQ4 (context),
            q2minusQ3 (context),
            q2plusQ3 (context),
            q2plusQ4 (context),
            q3minusQ2 (context),
            q3plusQ4 (context),
            quadrant1 (context),
            quadrant2 (context),
            quadrant3 (context),
            quadrant4 (context),
            reverse (context),
            total (context),
            totalByPhase (context)
        )
    }
}

case class MacroPeriodKind
(
    override val sup: BasicElement,
    val billingPeriod: String,
    val daily: String,
    val monthly: String,
    val none: String,
    val seasonal: String,
    val specifiedPeriod: String,
    val weekly: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MacroPeriodKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MacroPeriodKind
extends
    Parseable[MacroPeriodKind]
{
    val sup = BasicElement.parse _
    val billingPeriod = parse_attribute (attribute ("""MacroPeriodKind.billingPeriod"""))
    val daily = parse_attribute (attribute ("""MacroPeriodKind.daily"""))
    val monthly = parse_attribute (attribute ("""MacroPeriodKind.monthly"""))
    val none = parse_attribute (attribute ("""MacroPeriodKind.none"""))
    val seasonal = parse_attribute (attribute ("""MacroPeriodKind.seasonal"""))
    val specifiedPeriod = parse_attribute (attribute ("""MacroPeriodKind.specifiedPeriod"""))
    val weekly = parse_attribute (attribute ("""MacroPeriodKind.weekly"""))
    def parse (context: Context): MacroPeriodKind =
    {
        MacroPeriodKind(
            sup (context),
            billingPeriod (context),
            daily (context),
            monthly (context),
            none (context),
            seasonal (context),
            specifiedPeriod (context),
            weekly (context)
        )
    }
}

case class MeasurementKind
(
    override val sup: BasicElement,
    val alarm: String,
    val apTitle: String,
    val apparentPowerFactor: String,
    val applicationContext: String,
    val assetNumber: String,
    val audibleVolume: String,
    val bandwidth: String,
    val batteryCarryover: String,
    val batteryVoltage: String,
    val billCarryover: String,
    val billLastPeriod: String,
    val billToDate: String,
    val broadcastAddress: String,
    val connectionFee: String,
    val currency: String,
    val current: String,
    val currentAngle: String,
    val currentImbalance: String,
    val dataOverflowAlarm: String,
    val date: String,
    val demand: String,
    val demandLimit: String,
    val demandReset: String,
    val deviceAddressType1: String,
    val deviceAddressType2: String,
    val deviceAddressType3: String,
    val deviceAddressType4: String,
    val deviceClass: String,
    val diagnostic: String,
    val distance: String,
    val distortionPowerFactor: String,
    val distortionVoltAmp: String,
    val electronicSerialNumber: String,
    val emergencyLimit: String,
    val encoderTamper: String,
    val endDeviceID: String,
    val energization: String,
    val energizationLoadSide: String,
    val energy: String,
    val fan: String,
    val frequency: String,
    val frequencyExcursion: String,
    val fund: String,
    val groupAddressType1: String,
    val groupAddressType2: String,
    val groupAddressType3: String,
    val groupAddressType4: String,
    val ieee1366ASAI: String,
    val ieee1366ASIDI: String,
    val ieee1366ASIFI: String,
    val ieee1366CAIDI: String,
    val ieee1366CAIFI: String,
    val ieee1366CEMIn: String,
    val ieee1366CEMSMIn: String,
    val ieee1366CTAIDI: String,
    val ieee1366MAIFI: String,
    val ieee1366MAIFIe: String,
    val ieee1366MomentaryInterruption: String,
    val ieee1366MomentaryInterruptionEvent: String,
    val ieee1366SAIDI: String,
    val ieee1366SAIFI: String,
    val ieee1366SustainedInterruption: String,
    val interruptionBehaviour: String,
    val inversionTamper: String,
    val ipAddress: String,
    val lineLoss: String,
    val loadInterrupt: String,
    val loadShed: String,
    val loss: String,
    val macAddress: String,
    val maintenance: String,
    val mfgAssignedConfigurationID: String,
    val mfgAssignedPhysicalSerialNumber: String,
    val mfgAssignedProductNumber: String,
    val mfgAssignedUniqueCommunicationAddress: String,
    val multiCastAddress: String,
    val negativeSequence: String,
    val none: String,
    val oneWayAddress: String,
    val phasorPowerFactor: String,
    val phasorReactivePower: String,
    val physicalTamper: String,
    val positiveSequence: String,
    val power: String,
    val powerFactor: String,
    val powerLossTamper: String,
    val powerOutage: String,
    val powerQuality: String,
    val powerRestoration: String,
    val programmed: String,
    val pushbutton: String,
    val quantityPower: String,
    val relayActivation: String,
    val relayCycle: String,
    val removalTamper: String,
    val reprogrammingTamper: String,
    val reverseRotationTamper: String,
    val sag: String,
    val signalStrength: String,
    val signaltoNoiseRatio: String,
    val swell: String,
    val switchArmed: String,
    val switchDisabled: String,
    val switchPosition: String,
    val tamper: String,
    val tapPosition: String,
    val tariffRate: String,
    val temperature: String,
    val totalHarmonicDistortion: String,
    val transformerLoss: String,
    val twoWayAddress: String,
    val unipedeVoltageDip10to15: String,
    val unipedeVoltageDip15to30: String,
    val unipedeVoltageDip30to60: String,
    val unipedeVoltageDip60to90: String,
    val unipedeVoltageDip90to100: String,
    val voltage: String,
    val voltageAngle: String,
    val voltageExcursion: String,
    val voltageImbalance: String,
    val volume: String,
    val volumetricFlow: String,
    val watchdogTimeout: String,
    val zeroFlowDuration: String,
    val zeroSequence: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MeasurementKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeasurementKind
extends
    Parseable[MeasurementKind]
{
    val sup = BasicElement.parse _
    val alarm = parse_attribute (attribute ("""MeasurementKind.alarm"""))
    val apTitle = parse_attribute (attribute ("""MeasurementKind.apTitle"""))
    val apparentPowerFactor = parse_attribute (attribute ("""MeasurementKind.apparentPowerFactor"""))
    val applicationContext = parse_attribute (attribute ("""MeasurementKind.applicationContext"""))
    val assetNumber = parse_attribute (attribute ("""MeasurementKind.assetNumber"""))
    val audibleVolume = parse_attribute (attribute ("""MeasurementKind.audibleVolume"""))
    val bandwidth = parse_attribute (attribute ("""MeasurementKind.bandwidth"""))
    val batteryCarryover = parse_attribute (attribute ("""MeasurementKind.batteryCarryover"""))
    val batteryVoltage = parse_attribute (attribute ("""MeasurementKind.batteryVoltage"""))
    val billCarryover = parse_attribute (attribute ("""MeasurementKind.billCarryover"""))
    val billLastPeriod = parse_attribute (attribute ("""MeasurementKind.billLastPeriod"""))
    val billToDate = parse_attribute (attribute ("""MeasurementKind.billToDate"""))
    val broadcastAddress = parse_attribute (attribute ("""MeasurementKind.broadcastAddress"""))
    val connectionFee = parse_attribute (attribute ("""MeasurementKind.connectionFee"""))
    val currency = parse_attribute (attribute ("""MeasurementKind.currency"""))
    val current = parse_attribute (attribute ("""MeasurementKind.current"""))
    val currentAngle = parse_attribute (attribute ("""MeasurementKind.currentAngle"""))
    val currentImbalance = parse_attribute (attribute ("""MeasurementKind.currentImbalance"""))
    val dataOverflowAlarm = parse_attribute (attribute ("""MeasurementKind.dataOverflowAlarm"""))
    val date = parse_attribute (attribute ("""MeasurementKind.date"""))
    val demand = parse_attribute (attribute ("""MeasurementKind.demand"""))
    val demandLimit = parse_attribute (attribute ("""MeasurementKind.demandLimit"""))
    val demandReset = parse_attribute (attribute ("""MeasurementKind.demandReset"""))
    val deviceAddressType1 = parse_attribute (attribute ("""MeasurementKind.deviceAddressType1"""))
    val deviceAddressType2 = parse_attribute (attribute ("""MeasurementKind.deviceAddressType2"""))
    val deviceAddressType3 = parse_attribute (attribute ("""MeasurementKind.deviceAddressType3"""))
    val deviceAddressType4 = parse_attribute (attribute ("""MeasurementKind.deviceAddressType4"""))
    val deviceClass = parse_attribute (attribute ("""MeasurementKind.deviceClass"""))
    val diagnostic = parse_attribute (attribute ("""MeasurementKind.diagnostic"""))
    val distance = parse_attribute (attribute ("""MeasurementKind.distance"""))
    val distortionPowerFactor = parse_attribute (attribute ("""MeasurementKind.distortionPowerFactor"""))
    val distortionVoltAmp = parse_attribute (attribute ("""MeasurementKind.distortionVoltAmp"""))
    val electronicSerialNumber = parse_attribute (attribute ("""MeasurementKind.electronicSerialNumber"""))
    val emergencyLimit = parse_attribute (attribute ("""MeasurementKind.emergencyLimit"""))
    val encoderTamper = parse_attribute (attribute ("""MeasurementKind.encoderTamper"""))
    val endDeviceID = parse_attribute (attribute ("""MeasurementKind.endDeviceID"""))
    val energization = parse_attribute (attribute ("""MeasurementKind.energization"""))
    val energizationLoadSide = parse_attribute (attribute ("""MeasurementKind.energizationLoadSide"""))
    val energy = parse_attribute (attribute ("""MeasurementKind.energy"""))
    val fan = parse_attribute (attribute ("""MeasurementKind.fan"""))
    val frequency = parse_attribute (attribute ("""MeasurementKind.frequency"""))
    val frequencyExcursion = parse_attribute (attribute ("""MeasurementKind.frequencyExcursion"""))
    val fund = parse_attribute (attribute ("""MeasurementKind.fund"""))
    val groupAddressType1 = parse_attribute (attribute ("""MeasurementKind.groupAddressType1"""))
    val groupAddressType2 = parse_attribute (attribute ("""MeasurementKind.groupAddressType2"""))
    val groupAddressType3 = parse_attribute (attribute ("""MeasurementKind.groupAddressType3"""))
    val groupAddressType4 = parse_attribute (attribute ("""MeasurementKind.groupAddressType4"""))
    val ieee1366ASAI = parse_attribute (attribute ("""MeasurementKind.ieee1366ASAI"""))
    val ieee1366ASIDI = parse_attribute (attribute ("""MeasurementKind.ieee1366ASIDI"""))
    val ieee1366ASIFI = parse_attribute (attribute ("""MeasurementKind.ieee1366ASIFI"""))
    val ieee1366CAIDI = parse_attribute (attribute ("""MeasurementKind.ieee1366CAIDI"""))
    val ieee1366CAIFI = parse_attribute (attribute ("""MeasurementKind.ieee1366CAIFI"""))
    val ieee1366CEMIn = parse_attribute (attribute ("""MeasurementKind.ieee1366CEMIn"""))
    val ieee1366CEMSMIn = parse_attribute (attribute ("""MeasurementKind.ieee1366CEMSMIn"""))
    val ieee1366CTAIDI = parse_attribute (attribute ("""MeasurementKind.ieee1366CTAIDI"""))
    val ieee1366MAIFI = parse_attribute (attribute ("""MeasurementKind.ieee1366MAIFI"""))
    val ieee1366MAIFIe = parse_attribute (attribute ("""MeasurementKind.ieee1366MAIFIe"""))
    val ieee1366MomentaryInterruption = parse_attribute (attribute ("""MeasurementKind.ieee1366MomentaryInterruption"""))
    val ieee1366MomentaryInterruptionEvent = parse_attribute (attribute ("""MeasurementKind.ieee1366MomentaryInterruptionEvent"""))
    val ieee1366SAIDI = parse_attribute (attribute ("""MeasurementKind.ieee1366SAIDI"""))
    val ieee1366SAIFI = parse_attribute (attribute ("""MeasurementKind.ieee1366SAIFI"""))
    val ieee1366SustainedInterruption = parse_attribute (attribute ("""MeasurementKind.ieee1366SustainedInterruption"""))
    val interruptionBehaviour = parse_attribute (attribute ("""MeasurementKind.interruptionBehaviour"""))
    val inversionTamper = parse_attribute (attribute ("""MeasurementKind.inversionTamper"""))
    val ipAddress = parse_attribute (attribute ("""MeasurementKind.ipAddress"""))
    val lineLoss = parse_attribute (attribute ("""MeasurementKind.lineLoss"""))
    val loadInterrupt = parse_attribute (attribute ("""MeasurementKind.loadInterrupt"""))
    val loadShed = parse_attribute (attribute ("""MeasurementKind.loadShed"""))
    val loss = parse_attribute (attribute ("""MeasurementKind.loss"""))
    val macAddress = parse_attribute (attribute ("""MeasurementKind.macAddress"""))
    val maintenance = parse_attribute (attribute ("""MeasurementKind.maintenance"""))
    val mfgAssignedConfigurationID = parse_attribute (attribute ("""MeasurementKind.mfgAssignedConfigurationID"""))
    val mfgAssignedPhysicalSerialNumber = parse_attribute (attribute ("""MeasurementKind.mfgAssignedPhysicalSerialNumber"""))
    val mfgAssignedProductNumber = parse_attribute (attribute ("""MeasurementKind.mfgAssignedProductNumber"""))
    val mfgAssignedUniqueCommunicationAddress = parse_attribute (attribute ("""MeasurementKind.mfgAssignedUniqueCommunicationAddress"""))
    val multiCastAddress = parse_attribute (attribute ("""MeasurementKind.multiCastAddress"""))
    val negativeSequence = parse_attribute (attribute ("""MeasurementKind.negativeSequence"""))
    val none = parse_attribute (attribute ("""MeasurementKind.none"""))
    val oneWayAddress = parse_attribute (attribute ("""MeasurementKind.oneWayAddress"""))
    val phasorPowerFactor = parse_attribute (attribute ("""MeasurementKind.phasorPowerFactor"""))
    val phasorReactivePower = parse_attribute (attribute ("""MeasurementKind.phasorReactivePower"""))
    val physicalTamper = parse_attribute (attribute ("""MeasurementKind.physicalTamper"""))
    val positiveSequence = parse_attribute (attribute ("""MeasurementKind.positiveSequence"""))
    val power = parse_attribute (attribute ("""MeasurementKind.power"""))
    val powerFactor = parse_attribute (attribute ("""MeasurementKind.powerFactor"""))
    val powerLossTamper = parse_attribute (attribute ("""MeasurementKind.powerLossTamper"""))
    val powerOutage = parse_attribute (attribute ("""MeasurementKind.powerOutage"""))
    val powerQuality = parse_attribute (attribute ("""MeasurementKind.powerQuality"""))
    val powerRestoration = parse_attribute (attribute ("""MeasurementKind.powerRestoration"""))
    val programmed = parse_attribute (attribute ("""MeasurementKind.programmed"""))
    val pushbutton = parse_attribute (attribute ("""MeasurementKind.pushbutton"""))
    val quantityPower = parse_attribute (attribute ("""MeasurementKind.quantityPower"""))
    val relayActivation = parse_attribute (attribute ("""MeasurementKind.relayActivation"""))
    val relayCycle = parse_attribute (attribute ("""MeasurementKind.relayCycle"""))
    val removalTamper = parse_attribute (attribute ("""MeasurementKind.removalTamper"""))
    val reprogrammingTamper = parse_attribute (attribute ("""MeasurementKind.reprogrammingTamper"""))
    val reverseRotationTamper = parse_attribute (attribute ("""MeasurementKind.reverseRotationTamper"""))
    val sag = parse_attribute (attribute ("""MeasurementKind.sag"""))
    val signalStrength = parse_attribute (attribute ("""MeasurementKind.signalStrength"""))
    val signaltoNoiseRatio = parse_attribute (attribute ("""MeasurementKind.signaltoNoiseRatio"""))
    val swell = parse_attribute (attribute ("""MeasurementKind.swell"""))
    val switchArmed = parse_attribute (attribute ("""MeasurementKind.switchArmed"""))
    val switchDisabled = parse_attribute (attribute ("""MeasurementKind.switchDisabled"""))
    val switchPosition = parse_attribute (attribute ("""MeasurementKind.switchPosition"""))
    val tamper = parse_attribute (attribute ("""MeasurementKind.tamper"""))
    val tapPosition = parse_attribute (attribute ("""MeasurementKind.tapPosition"""))
    val tariffRate = parse_attribute (attribute ("""MeasurementKind.tariffRate"""))
    val temperature = parse_attribute (attribute ("""MeasurementKind.temperature"""))
    val totalHarmonicDistortion = parse_attribute (attribute ("""MeasurementKind.totalHarmonicDistortion"""))
    val transformerLoss = parse_attribute (attribute ("""MeasurementKind.transformerLoss"""))
    val twoWayAddress = parse_attribute (attribute ("""MeasurementKind.twoWayAddress"""))
    val unipedeVoltageDip10to15 = parse_attribute (attribute ("""MeasurementKind.unipedeVoltageDip10to15"""))
    val unipedeVoltageDip15to30 = parse_attribute (attribute ("""MeasurementKind.unipedeVoltageDip15to30"""))
    val unipedeVoltageDip30to60 = parse_attribute (attribute ("""MeasurementKind.unipedeVoltageDip30to60"""))
    val unipedeVoltageDip60to90 = parse_attribute (attribute ("""MeasurementKind.unipedeVoltageDip60to90"""))
    val unipedeVoltageDip90to100 = parse_attribute (attribute ("""MeasurementKind.unipedeVoltageDip90to100"""))
    val voltage = parse_attribute (attribute ("""MeasurementKind.voltage"""))
    val voltageAngle = parse_attribute (attribute ("""MeasurementKind.voltageAngle"""))
    val voltageExcursion = parse_attribute (attribute ("""MeasurementKind.voltageExcursion"""))
    val voltageImbalance = parse_attribute (attribute ("""MeasurementKind.voltageImbalance"""))
    val volume = parse_attribute (attribute ("""MeasurementKind.volume"""))
    val volumetricFlow = parse_attribute (attribute ("""MeasurementKind.volumetricFlow"""))
    val watchdogTimeout = parse_attribute (attribute ("""MeasurementKind.watchdogTimeout"""))
    val zeroFlowDuration = parse_attribute (attribute ("""MeasurementKind.zeroFlowDuration"""))
    val zeroSequence = parse_attribute (attribute ("""MeasurementKind.zeroSequence"""))
    def parse (context: Context): MeasurementKind =
    {
        MeasurementKind(
            sup (context),
            alarm (context),
            apTitle (context),
            apparentPowerFactor (context),
            applicationContext (context),
            assetNumber (context),
            audibleVolume (context),
            bandwidth (context),
            batteryCarryover (context),
            batteryVoltage (context),
            billCarryover (context),
            billLastPeriod (context),
            billToDate (context),
            broadcastAddress (context),
            connectionFee (context),
            currency (context),
            current (context),
            currentAngle (context),
            currentImbalance (context),
            dataOverflowAlarm (context),
            date (context),
            demand (context),
            demandLimit (context),
            demandReset (context),
            deviceAddressType1 (context),
            deviceAddressType2 (context),
            deviceAddressType3 (context),
            deviceAddressType4 (context),
            deviceClass (context),
            diagnostic (context),
            distance (context),
            distortionPowerFactor (context),
            distortionVoltAmp (context),
            electronicSerialNumber (context),
            emergencyLimit (context),
            encoderTamper (context),
            endDeviceID (context),
            energization (context),
            energizationLoadSide (context),
            energy (context),
            fan (context),
            frequency (context),
            frequencyExcursion (context),
            fund (context),
            groupAddressType1 (context),
            groupAddressType2 (context),
            groupAddressType3 (context),
            groupAddressType4 (context),
            ieee1366ASAI (context),
            ieee1366ASIDI (context),
            ieee1366ASIFI (context),
            ieee1366CAIDI (context),
            ieee1366CAIFI (context),
            ieee1366CEMIn (context),
            ieee1366CEMSMIn (context),
            ieee1366CTAIDI (context),
            ieee1366MAIFI (context),
            ieee1366MAIFIe (context),
            ieee1366MomentaryInterruption (context),
            ieee1366MomentaryInterruptionEvent (context),
            ieee1366SAIDI (context),
            ieee1366SAIFI (context),
            ieee1366SustainedInterruption (context),
            interruptionBehaviour (context),
            inversionTamper (context),
            ipAddress (context),
            lineLoss (context),
            loadInterrupt (context),
            loadShed (context),
            loss (context),
            macAddress (context),
            maintenance (context),
            mfgAssignedConfigurationID (context),
            mfgAssignedPhysicalSerialNumber (context),
            mfgAssignedProductNumber (context),
            mfgAssignedUniqueCommunicationAddress (context),
            multiCastAddress (context),
            negativeSequence (context),
            none (context),
            oneWayAddress (context),
            phasorPowerFactor (context),
            phasorReactivePower (context),
            physicalTamper (context),
            positiveSequence (context),
            power (context),
            powerFactor (context),
            powerLossTamper (context),
            powerOutage (context),
            powerQuality (context),
            powerRestoration (context),
            programmed (context),
            pushbutton (context),
            quantityPower (context),
            relayActivation (context),
            relayCycle (context),
            removalTamper (context),
            reprogrammingTamper (context),
            reverseRotationTamper (context),
            sag (context),
            signalStrength (context),
            signaltoNoiseRatio (context),
            swell (context),
            switchArmed (context),
            switchDisabled (context),
            switchPosition (context),
            tamper (context),
            tapPosition (context),
            tariffRate (context),
            temperature (context),
            totalHarmonicDistortion (context),
            transformerLoss (context),
            twoWayAddress (context),
            unipedeVoltageDip10to15 (context),
            unipedeVoltageDip15to30 (context),
            unipedeVoltageDip30to60 (context),
            unipedeVoltageDip60to90 (context),
            unipedeVoltageDip90to100 (context),
            voltage (context),
            voltageAngle (context),
            voltageExcursion (context),
            voltageImbalance (context),
            volume (context),
            volumetricFlow (context),
            watchdogTimeout (context),
            zeroFlowDuration (context),
            zeroSequence (context)
        )
    }
}

case class MeasuringPeriodKind
(
    override val sup: BasicElement,
    val fifteenMinute: String,
    val fiveMinute: String,
    val fixedBlock10Min: String,
    val fixedBlock15Min: String,
    val fixedBlock1Min: String,
    val fixedBlock20Min: String,
    val fixedBlock30Min: String,
    val fixedBlock5Min: String,
    val fixedBlock60Min: String,
    val none: String,
    val oneMinute: String,
    val present: String,
    val previous: String,
    val rollingBlock10MinIntvl1MinSubIntvl: String,
    val rollingBlock10MinIntvl2MinSubIntvl: String,
    val rollingBlock10MinIntvl5MinSubIntvl: String,
    val rollingBlock15MinIntvl1MinSubIntvl: String,
    val rollingBlock15MinIntvl3MinSubIntvl: String,
    val rollingBlock15MinIntvl5MinSubIntvl: String,
    val rollingBlock30MinIntvl10MinSubIntvl: String,
    val rollingBlock30MinIntvl15MinSubIntvl: String,
    val rollingBlock30MinIntvl2MinSubIntvl: String,
    val rollingBlock30MinIntvl3MinSubIntvl: String,
    val rollingBlock30MinIntvl5MinSubIntvl: String,
    val rollingBlock30MinIntvl6MinSubIntvl: String,
    val rollingBlock5MinIntvl1MinSubIntvl: String,
    val rollingBlock60MinIntvl10MinSubIntvl: String,
    val rollingBlock60MinIntvl12MinSubIntvl: String,
    val rollingBlock60MinIntvl15MinSubIntvl: String,
    val rollingBlock60MinIntvl20MinSubIntvl: String,
    val rollingBlock60MinIntvl30MinSubIntvl: String,
    val rollingBlock60MinIntvl4MinSubIntvl: String,
    val rollingBlock60MinIntvl5MinSubIntvl: String,
    val rollingBlock60MinIntvl6MinSubIntvl: String,
    val sixtyMinute: String,
    val tenMinute: String,
    val thirtyMinute: String,
    val threeMinute: String,
    val twentyMinute: String,
    val twentyfourHour: String,
    val twoMinute: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MeasuringPeriodKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeasuringPeriodKind
extends
    Parseable[MeasuringPeriodKind]
{
    val sup = BasicElement.parse _
    val fifteenMinute = parse_attribute (attribute ("""MeasuringPeriodKind.fifteenMinute"""))
    val fiveMinute = parse_attribute (attribute ("""MeasuringPeriodKind.fiveMinute"""))
    val fixedBlock10Min = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock10Min"""))
    val fixedBlock15Min = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock15Min"""))
    val fixedBlock1Min = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock1Min"""))
    val fixedBlock20Min = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock20Min"""))
    val fixedBlock30Min = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock30Min"""))
    val fixedBlock5Min = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock5Min"""))
    val fixedBlock60Min = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock60Min"""))
    val none = parse_attribute (attribute ("""MeasuringPeriodKind.none"""))
    val oneMinute = parse_attribute (attribute ("""MeasuringPeriodKind.oneMinute"""))
    val present = parse_attribute (attribute ("""MeasuringPeriodKind.present"""))
    val previous = parse_attribute (attribute ("""MeasuringPeriodKind.previous"""))
    val rollingBlock10MinIntvl1MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock10MinIntvl1MinSubIntvl"""))
    val rollingBlock10MinIntvl2MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock10MinIntvl2MinSubIntvl"""))
    val rollingBlock10MinIntvl5MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock10MinIntvl5MinSubIntvl"""))
    val rollingBlock15MinIntvl1MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock15MinIntvl1MinSubIntvl"""))
    val rollingBlock15MinIntvl3MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock15MinIntvl3MinSubIntvl"""))
    val rollingBlock15MinIntvl5MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock15MinIntvl5MinSubIntvl"""))
    val rollingBlock30MinIntvl10MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl10MinSubIntvl"""))
    val rollingBlock30MinIntvl15MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl15MinSubIntvl"""))
    val rollingBlock30MinIntvl2MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl2MinSubIntvl"""))
    val rollingBlock30MinIntvl3MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl3MinSubIntvl"""))
    val rollingBlock30MinIntvl5MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl5MinSubIntvl"""))
    val rollingBlock30MinIntvl6MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl6MinSubIntvl"""))
    val rollingBlock5MinIntvl1MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock5MinIntvl1MinSubIntvl"""))
    val rollingBlock60MinIntvl10MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl10MinSubIntvl"""))
    val rollingBlock60MinIntvl12MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl12MinSubIntvl"""))
    val rollingBlock60MinIntvl15MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl15MinSubIntvl"""))
    val rollingBlock60MinIntvl20MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl20MinSubIntvl"""))
    val rollingBlock60MinIntvl30MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl30MinSubIntvl"""))
    val rollingBlock60MinIntvl4MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl4MinSubIntvl"""))
    val rollingBlock60MinIntvl5MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl5MinSubIntvl"""))
    val rollingBlock60MinIntvl6MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl6MinSubIntvl"""))
    val sixtyMinute = parse_attribute (attribute ("""MeasuringPeriodKind.sixtyMinute"""))
    val tenMinute = parse_attribute (attribute ("""MeasuringPeriodKind.tenMinute"""))
    val thirtyMinute = parse_attribute (attribute ("""MeasuringPeriodKind.thirtyMinute"""))
    val threeMinute = parse_attribute (attribute ("""MeasuringPeriodKind.threeMinute"""))
    val twentyMinute = parse_attribute (attribute ("""MeasuringPeriodKind.twentyMinute"""))
    val twentyfourHour = parse_attribute (attribute ("""MeasuringPeriodKind.twentyfourHour"""))
    val twoMinute = parse_attribute (attribute ("""MeasuringPeriodKind.twoMinute"""))
    def parse (context: Context): MeasuringPeriodKind =
    {
        MeasuringPeriodKind(
            sup (context),
            fifteenMinute (context),
            fiveMinute (context),
            fixedBlock10Min (context),
            fixedBlock15Min (context),
            fixedBlock1Min (context),
            fixedBlock20Min (context),
            fixedBlock30Min (context),
            fixedBlock5Min (context),
            fixedBlock60Min (context),
            none (context),
            oneMinute (context),
            present (context),
            previous (context),
            rollingBlock10MinIntvl1MinSubIntvl (context),
            rollingBlock10MinIntvl2MinSubIntvl (context),
            rollingBlock10MinIntvl5MinSubIntvl (context),
            rollingBlock15MinIntvl1MinSubIntvl (context),
            rollingBlock15MinIntvl3MinSubIntvl (context),
            rollingBlock15MinIntvl5MinSubIntvl (context),
            rollingBlock30MinIntvl10MinSubIntvl (context),
            rollingBlock30MinIntvl15MinSubIntvl (context),
            rollingBlock30MinIntvl2MinSubIntvl (context),
            rollingBlock30MinIntvl3MinSubIntvl (context),
            rollingBlock30MinIntvl5MinSubIntvl (context),
            rollingBlock30MinIntvl6MinSubIntvl (context),
            rollingBlock5MinIntvl1MinSubIntvl (context),
            rollingBlock60MinIntvl10MinSubIntvl (context),
            rollingBlock60MinIntvl12MinSubIntvl (context),
            rollingBlock60MinIntvl15MinSubIntvl (context),
            rollingBlock60MinIntvl20MinSubIntvl (context),
            rollingBlock60MinIntvl30MinSubIntvl (context),
            rollingBlock60MinIntvl4MinSubIntvl (context),
            rollingBlock60MinIntvl5MinSubIntvl (context),
            rollingBlock60MinIntvl6MinSubIntvl (context),
            sixtyMinute (context),
            tenMinute (context),
            thirtyMinute (context),
            threeMinute (context),
            twentyMinute (context),
            twentyfourHour (context),
            twoMinute (context)
        )
    }
}

object _ReadingTypeEnumerations
{
    def register: Unit =
    {
        AccumulationKind.register
        AggregateKind.register
        CommodityKind.register
        FlowDirectionKind.register
        MacroPeriodKind.register
        MeasurementKind.register
        MeasuringPeriodKind.register
    }
}