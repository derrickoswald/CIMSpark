package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


case class AccumulationKind
(

    override val sup: BasicElement,

    /**
     * A time-independent cumulative quantity much a BulkQuantity or a LatchingQuantity, except that the accumulation stops at the maximum or minimum values.
     * When the maximum is reached, any additional positive accumulation is discarded, but negative accumulation may be accepted (thus lowering the counter.) Likewise, when the negative bound is reached, any additional negative accumulation is discarded, but positive accumulation is accepted (thus increasing the counter.)
     */
    val boundedQuantity: String,

    /**
     * A value from a register which represents the bulk quantity of a commodity.
     * This quantity is computed as the integral of the commodity usage rate. This value is typically used as the basis for the dial reading at the meter, and as a result, will roll over upon reaching a maximum dial value.
     */
    val bulkQuantity: String,

    /**
     * The sum of the previous billing period values and the present period value.
     * Note: �ContinuousCumulative� is commonly used in conjunction with �demand.� The �ContinuousCumulative Demand� would be the cumulative sum of the previous billing period maximum demand values (as occurring with each demand reset) summed with the present period maximum demand value (which has yet to be reset.)
     */
    val continuousCumulative: String,

    /**
     * The sum of the previous billing period values.
     * Note: �Cumulative� is commonly used in conjunction with �demand.� Each demand reset causes the maximum demand value for the present billing period (since the last demand reset) to accumulate as an accumulative total of all maximum demands. So instead of �zeroing� the demand register, a demand reset has the affect of adding the present maximum demand to this accumulating total.
     */
    val cumulative: String,

    /**
     * The difference between the value at the end of the prescribed interval and the beginning of the interval.
     * This is used for incremental interval data.
     */
    val deltaData: String,

    /**
     * As if a needle is swung out on the meter face to a value to indicate the current value. (Note: An �indicating� value is typically measured over hundreds of milliseconds or greater, or may imply a �pusher� mechanism to capture a value.
     * Compare this to �instantaneous� which is measured over a shorter period of time.)
     */
    val indicating: String,

    /**
     * Typically measured over the fastest period of time allowed by the definition of the metric (usually milliseconds or tens of milliseconds.) (Note: �Instantaneous� was moved to attribute #3 in 61968-9Ed2 from attribute #1 in 61968-9Ed1.)
     */
    val instantaneous: String,

    /**
     * When this description is applied to a metered value, it implies that the value is a time-independent cumulative quantity much a BulkQuantity, except that it latches upon the maximum value upon reaching that value.
     * Any additional accumulation (positive or negative) is discarded until a reset occurs.
     */
    val latchingQuantity: String,

    /**
     * Not Applicable, or implied by the unit of measure.
     */
    val none: String,

    /**
     * A form of accumulation which is selective with respect to time.
     * Note : �Summation� could be considered a specialization of �Bulk Quantity� according to the rules of inheritance where �Summation� selectively accumulates pulses over a timing pattern, and �BulkQuantity� accumulates pulses all of the time.
     */
    val summation: String,

    /**
     * A form of computation which introduces a time delay characteristic to the data value
     */
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
    val boundedQuantity = parse_attribute (attribute ("""AccumulationKind.boundedQuantity"""))_
    val bulkQuantity = parse_attribute (attribute ("""AccumulationKind.bulkQuantity"""))_
    val continuousCumulative = parse_attribute (attribute ("""AccumulationKind.continuousCumulative"""))_
    val cumulative = parse_attribute (attribute ("""AccumulationKind.cumulative"""))_
    val deltaData = parse_attribute (attribute ("""AccumulationKind.deltaData"""))_
    val indicating = parse_attribute (attribute ("""AccumulationKind.indicating"""))_
    val instantaneous = parse_attribute (attribute ("""AccumulationKind.instantaneous"""))_
    val latchingQuantity = parse_attribute (attribute ("""AccumulationKind.latchingQuantity"""))_
    val none = parse_attribute (attribute ("""AccumulationKind.none"""))_
    val summation = parse_attribute (attribute ("""AccumulationKind.summation"""))_
    val timeDelay = parse_attribute (attribute ("""AccumulationKind.timeDelay"""))_
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

    /**
     * The value represents an amount over which a threshold was exceeded.
     */
    val excess: String,

    /**
     * The fifth highest value observed
     */
    val fifthMaximum: String,

    /**
     * The fourth highest value observed
     */
    val fourthMaximum: String,

    /**
     * The value represents a programmed threshold.
     */
    val highThreshold: String,

    /**
     * The value represents a programmed threshold.
     */
    val lowThreshold: String,

    /**
     * The highest value observed
     */
    val maximum: String,

    /**
     * The smallest value observed
     */
    val minimum: String,

    val nominal: String,

    /**
     * Not Applicable
     */
    val none: String,

    val normal: String,

    /**
     * The second highest value observed
     */
    val secondMaximum: String,

    /**
     * The second smallest value observed
     */
    val secondMinimum: String,

    /**
     * The accumulated sum
     */
    val sum: String,

    /**
     * The third highest value observed
     */
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
    val average = parse_attribute (attribute ("""AggregateKind.average"""))_
    val excess = parse_attribute (attribute ("""AggregateKind.excess"""))_
    val fifthMaximum = parse_attribute (attribute ("""AggregateKind.fifthMaximum"""))_
    val fourthMaximum = parse_attribute (attribute ("""AggregateKind.fourthMaximum"""))_
    val highThreshold = parse_attribute (attribute ("""AggregateKind.highThreshold"""))_
    val lowThreshold = parse_attribute (attribute ("""AggregateKind.lowThreshold"""))_
    val maximum = parse_attribute (attribute ("""AggregateKind.maximum"""))_
    val minimum = parse_attribute (attribute ("""AggregateKind.minimum"""))_
    val nominal = parse_attribute (attribute ("""AggregateKind.nominal"""))_
    val none = parse_attribute (attribute ("""AggregateKind.none"""))_
    val normal = parse_attribute (attribute ("""AggregateKind.normal"""))_
    val secondMaximum = parse_attribute (attribute ("""AggregateKind.secondMaximum"""))_
    val secondMinimum = parse_attribute (attribute ("""AggregateKind.secondMinimum"""))_
    val sum = parse_attribute (attribute ("""AggregateKind.sum"""))_
    val thirdMaximum = parse_attribute (attribute ("""AggregateKind.thirdMaximum"""))_
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

    /**
     * Methane CH<sub>4</sub>
     */
    val ch4: String,

    /**
     * Carbon Dioxide CO<sub>2</sub>
     */
    val co2: String,

    /**
     * A measurement of the communication infrastructure itself.
     */
    val communication: String,

    /**
     * The cool fluid returns warmer than when it was sent.
     * The heat conveyed may be metered.
     */
    val coolingFluid: String,

    /**
     * It is possible for a meter to be outfitted with an external VT and/or CT.
     * The meter might not be aware of these devices, and the display not compensate for their presence. Ultimately, when these scalars are applied, the value that represents the service value is called the �primary metered� value. The �index� in sub-category 3 mirrors those of sub-category 0.
     */
    val electricityPrimaryMetered: String,

    /**
     * All types of metered quantities.
     * This type of reading comes from the meter and represents a �secondary� metered value.
     */
    val electricitySecondaryMetered: String,

    /**
     * Hexachlorocyclohexane HCH
     */
    val hch: String,

    /**
     * This fluid is likely in liquid form.
     * It is not necessarily water or water based. The warm fluid returns cooler than when it was sent. The heat conveyed may be metered.
     */
    val heatingFluid: String,

    /**
     * (SF<sub>6</sub> is found separately below.)
     */
    val insulativeGas: String,

    val insulativeOil: String,

    /**
     * Internet service
     */
    val internet: String,

    val naturalGas: String,

    /**
     * Not Applicable
     */
    val none: String,

    /**
     * Reclaimed water � possibly used for irrigation but not sufficiently treated to be considered safe for drinking.
     */
    val nonpotableWater: String,

    /**
     * Nitrous Oxides NO<sub>X</sub>
     */
    val nox: String,

    /**
     * Perfluorocarbons PFC
     */
    val pfc: String,

    /**
     * Drinkable water
     */
    val potableWater: String,

    val propane: String,

    /**
     * trash
     */
    val refuse: String,

    /**
     * Sulfurhexafluoride SF<sub>6</sub>
     */
    val sf6: String,

    /**
     * Sulfur Dioxide SO<sub>2</sub>
     */
    val so2: String,

    /**
     * Water in steam form, usually used for heating.
     */
    val steam: String,

    /**
     * Television
     */
    val tvLicence: String,

    /**
     * (Sewerage)
     */
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
    val air = parse_attribute (attribute ("""CommodityKind.air"""))_
    val carbon = parse_attribute (attribute ("""CommodityKind.carbon"""))_
    val ch4 = parse_attribute (attribute ("""CommodityKind.ch4"""))_
    val co2 = parse_attribute (attribute ("""CommodityKind.co2"""))_
    val communication = parse_attribute (attribute ("""CommodityKind.communication"""))_
    val coolingFluid = parse_attribute (attribute ("""CommodityKind.coolingFluid"""))_
    val electricityPrimaryMetered = parse_attribute (attribute ("""CommodityKind.electricityPrimaryMetered"""))_
    val electricitySecondaryMetered = parse_attribute (attribute ("""CommodityKind.electricitySecondaryMetered"""))_
    val hch = parse_attribute (attribute ("""CommodityKind.hch"""))_
    val heatingFluid = parse_attribute (attribute ("""CommodityKind.heatingFluid"""))_
    val insulativeGas = parse_attribute (attribute ("""CommodityKind.insulativeGas"""))_
    val insulativeOil = parse_attribute (attribute ("""CommodityKind.insulativeOil"""))_
    val internet = parse_attribute (attribute ("""CommodityKind.internet"""))_
    val naturalGas = parse_attribute (attribute ("""CommodityKind.naturalGas"""))_
    val none = parse_attribute (attribute ("""CommodityKind.none"""))_
    val nonpotableWater = parse_attribute (attribute ("""CommodityKind.nonpotableWater"""))_
    val nox = parse_attribute (attribute ("""CommodityKind.nox"""))_
    val pfc = parse_attribute (attribute ("""CommodityKind.pfc"""))_
    val potableWater = parse_attribute (attribute ("""CommodityKind.potableWater"""))_
    val propane = parse_attribute (attribute ("""CommodityKind.propane"""))_
    val refuse = parse_attribute (attribute ("""CommodityKind.refuse"""))_
    val sf6 = parse_attribute (attribute ("""CommodityKind.sf6"""))_
    val so2 = parse_attribute (attribute ("""CommodityKind.so2"""))_
    val steam = parse_attribute (attribute ("""CommodityKind.steam"""))_
    val tvLicence = parse_attribute (attribute ("""CommodityKind.tvLicence"""))_
    val wasteWater = parse_attribute (attribute ("""CommodityKind.wasteWater"""))_
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

    /**
     * "Delivered," or "Imported" as defined 61968-2.
     * Forward Active Energy is a positive kWh value as one would naturally expect to find as energy is supplied by the utility and consumed at the service.
     */
    val forward: String,

    /**
     * Typically used to describe that a power factor is lagging the reference value.
     * Note 1: When used to describe VA, �lagging� describes a form of measurement where reactive power is considered in all four quadrants, but real power is considered only in quadrants I and IV.
     */
    val lagging: String,

    /**
     * Typically used to describe that a power factor is leading the reference value.
     * Note: Leading power factors typically indicate capacitive loading.
     */
    val leading: String,

    /**
     * |Forward| - |Reverse|, See 61968-2.
     * Note: In some systems, the value passed as a �net� value could become negative. In other systems the value passed as a �net� value is always a positive number, and rolls-over and rolls-under as needed.
     */
    val net: String,

    /**
     * Not Applicable (N/A)
     */
    val none: String,

    /**
     * Q1 minus Q4
     */
    val q1minusQ4: String,

    /**
     * Reactive positive quadrants. (The term �lagging� is preferred.)
     */
    val q1plusQ2: String,

    /**
     * Quadrants 1 and 3
     */
    val q1plusQ3: String,

    /**
     * Quadrants 1 and 4 usually represent forward active energy
     */
    val q1plusQ4: String,

    /**
     * Q2 minus Q3
     */
    val q2minusQ3: String,

    /**
     * Quadrants 2 and 3 usually represent reverse active energy
     */
    val q2plusQ3: String,

    /**
     * Quadrants 2 and 4
     */
    val q2plusQ4: String,

    /**
     * Q3 minus Q2
     */
    val q3minusQ2: String,

    /**
     * Reactive negative quadrants. (The term �leading� is preferred.)
     */
    val q3plusQ4: String,

    /**
     * Q1 only
     */
    val quadrant1: String,

    /**
     * Q2 only
     */
    val quadrant2: String,

    /**
     * Q3 only
     */
    val quadrant3: String,

    /**
     * Q4 only
     */
    val quadrant4: String,

    /**
     * Reverse Active Energy is equivalent to "Received," or "Exported" as defined in 61968-2.
     * Reverse Active Energy is a positive kWh value as one would expect to find when energy is backfed by the service onto the utility network.
     */
    val reverse: String,

    /**
     * |Forward| + |Reverse|, See 61968-2.
     * The sum of the commodity in all quadrants Q1+Q2+Q3+Q4.
     */
    val total: String,

    /**
     * In polyphase metering, the total by phase energy register is incremented when the sum of the absolute values of the phase energies is greater than zero:
    
    &lt;img src="HTS_1.
     * PNG" width="234" height="16" border="0" alt="graphic"/&gt;
     */
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
    val forward = parse_attribute (attribute ("""FlowDirectionKind.forward"""))_
    val lagging = parse_attribute (attribute ("""FlowDirectionKind.lagging"""))_
    val leading = parse_attribute (attribute ("""FlowDirectionKind.leading"""))_
    val net = parse_attribute (attribute ("""FlowDirectionKind.net"""))_
    val none = parse_attribute (attribute ("""FlowDirectionKind.none"""))_
    val q1minusQ4 = parse_attribute (attribute ("""FlowDirectionKind.q1minusQ4"""))_
    val q1plusQ2 = parse_attribute (attribute ("""FlowDirectionKind.q1plusQ2"""))_
    val q1plusQ3 = parse_attribute (attribute ("""FlowDirectionKind.q1plusQ3"""))_
    val q1plusQ4 = parse_attribute (attribute ("""FlowDirectionKind.q1plusQ4"""))_
    val q2minusQ3 = parse_attribute (attribute ("""FlowDirectionKind.q2minusQ3"""))_
    val q2plusQ3 = parse_attribute (attribute ("""FlowDirectionKind.q2plusQ3"""))_
    val q2plusQ4 = parse_attribute (attribute ("""FlowDirectionKind.q2plusQ4"""))_
    val q3minusQ2 = parse_attribute (attribute ("""FlowDirectionKind.q3minusQ2"""))_
    val q3plusQ4 = parse_attribute (attribute ("""FlowDirectionKind.q3plusQ4"""))_
    val quadrant1 = parse_attribute (attribute ("""FlowDirectionKind.quadrant1"""))_
    val quadrant2 = parse_attribute (attribute ("""FlowDirectionKind.quadrant2"""))_
    val quadrant3 = parse_attribute (attribute ("""FlowDirectionKind.quadrant3"""))_
    val quadrant4 = parse_attribute (attribute ("""FlowDirectionKind.quadrant4"""))_
    val reverse = parse_attribute (attribute ("""FlowDirectionKind.reverse"""))_
    val total = parse_attribute (attribute ("""FlowDirectionKind.total"""))_
    val totalByPhase = parse_attribute (attribute ("""FlowDirectionKind.totalByPhase"""))_
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

    /**
     * Captured during the billing period starting at midnight of the first day of the billing period (as defined by the billing cycle day).
     * If during the current billing period, it specifies a period from the start of the current billing period until "now".
     */
    val billingPeriod: String,

    /**
     * Daily Period starting at midnight.
     * If for the current day, this specifies the time from midnight to "now".
     */
    val daily: String,

    /**
     * Monthly period starting at midnight on the first day of the month.
     * If within the current month, this specifies the period from the start of the month until "now."
     */
    val monthly: String,

    /**
     * Not Applicable
     */
    val none: String,

    /**
     * A season of time spanning multiple months.
     * E.g. "Summer," "Spring," "Fall," and "Winter" based cycle. If within the current season, it specifies the period from the start of the current season until "now."
     */
    val seasonal: String,

    /**
     * For the period defined by the start and end of the TimePeriod element in the message.
     */
    val specifiedPeriod: String,

    /**
     * Weekly period starting at midnight on the first day of the week and ending the instant before midnight the last day of the week.
     * If within the current week, it specifies the period from the start of the week until "now."
     */
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
    val billingPeriod = parse_attribute (attribute ("""MacroPeriodKind.billingPeriod"""))_
    val daily = parse_attribute (attribute ("""MacroPeriodKind.daily"""))_
    val monthly = parse_attribute (attribute ("""MacroPeriodKind.monthly"""))_
    val none = parse_attribute (attribute ("""MacroPeriodKind.none"""))_
    val seasonal = parse_attribute (attribute ("""MacroPeriodKind.seasonal"""))_
    val specifiedPeriod = parse_attribute (attribute ("""MacroPeriodKind.specifiedPeriod"""))_
    val weekly = parse_attribute (attribute ("""MacroPeriodKind.weekly"""))_
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

    /**
     * Sound
     */
    val audibleVolume: String,

    val bandwidth: String,

    val batteryCarryover: String,

    val batteryVoltage: String,

    /**
     * Customer�s bill for the (Currency)
     */
    val billCarryover: String,

    /**
     * Customer�s bill for the previous billing period (Currency)
     */
    val billLastPeriod: String,

    /**
     * Customer�s bill, as known thus far within the present billing period (Currency)
     */
    val billToDate: String,

    val broadcastAddress: String,

    /**
     * Monthly fee for connection to commodity.
     */
    val connectionFee: String,

    /**
     * funds
     */
    val currency: String,

    val current: String,

    val currentAngle: String,

    val currentImbalance: String,

    val dataOverflowAlarm: String,

    val date: String,

    val demand: String,

    val demandLimit: String,

    /**
     * Usually expressed as a count as part of a billing cycle
     */
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

    /**
     * Usually expressed as a �count�
     */
    val frequencyExcursion: String,

    /**
     * Dup with �currency�
     */
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

    /**
     * Not Applicable
     */
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

    /**
     * Usually expressed as a count
     */
    val relayCycle: String,

    val removalTamper: String,

    val reprogrammingTamper: String,

    val reverseRotationTamper: String,

    /**
     * or Voltage Dip
     */
    val sag: String,

    val signalStrength: String,

    /**
     * Moved here from Attribute #9 UOM
     */
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

    /**
     * Clarified  from Ed. 1. to indicate fluid volume
     */
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
    val alarm = parse_attribute (attribute ("""MeasurementKind.alarm"""))_
    val apTitle = parse_attribute (attribute ("""MeasurementKind.apTitle"""))_
    val apparentPowerFactor = parse_attribute (attribute ("""MeasurementKind.apparentPowerFactor"""))_
    val applicationContext = parse_attribute (attribute ("""MeasurementKind.applicationContext"""))_
    val assetNumber = parse_attribute (attribute ("""MeasurementKind.assetNumber"""))_
    val audibleVolume = parse_attribute (attribute ("""MeasurementKind.audibleVolume"""))_
    val bandwidth = parse_attribute (attribute ("""MeasurementKind.bandwidth"""))_
    val batteryCarryover = parse_attribute (attribute ("""MeasurementKind.batteryCarryover"""))_
    val batteryVoltage = parse_attribute (attribute ("""MeasurementKind.batteryVoltage"""))_
    val billCarryover = parse_attribute (attribute ("""MeasurementKind.billCarryover"""))_
    val billLastPeriod = parse_attribute (attribute ("""MeasurementKind.billLastPeriod"""))_
    val billToDate = parse_attribute (attribute ("""MeasurementKind.billToDate"""))_
    val broadcastAddress = parse_attribute (attribute ("""MeasurementKind.broadcastAddress"""))_
    val connectionFee = parse_attribute (attribute ("""MeasurementKind.connectionFee"""))_
    val currency = parse_attribute (attribute ("""MeasurementKind.currency"""))_
    val current = parse_attribute (attribute ("""MeasurementKind.current"""))_
    val currentAngle = parse_attribute (attribute ("""MeasurementKind.currentAngle"""))_
    val currentImbalance = parse_attribute (attribute ("""MeasurementKind.currentImbalance"""))_
    val dataOverflowAlarm = parse_attribute (attribute ("""MeasurementKind.dataOverflowAlarm"""))_
    val date = parse_attribute (attribute ("""MeasurementKind.date"""))_
    val demand = parse_attribute (attribute ("""MeasurementKind.demand"""))_
    val demandLimit = parse_attribute (attribute ("""MeasurementKind.demandLimit"""))_
    val demandReset = parse_attribute (attribute ("""MeasurementKind.demandReset"""))_
    val deviceAddressType1 = parse_attribute (attribute ("""MeasurementKind.deviceAddressType1"""))_
    val deviceAddressType2 = parse_attribute (attribute ("""MeasurementKind.deviceAddressType2"""))_
    val deviceAddressType3 = parse_attribute (attribute ("""MeasurementKind.deviceAddressType3"""))_
    val deviceAddressType4 = parse_attribute (attribute ("""MeasurementKind.deviceAddressType4"""))_
    val deviceClass = parse_attribute (attribute ("""MeasurementKind.deviceClass"""))_
    val diagnostic = parse_attribute (attribute ("""MeasurementKind.diagnostic"""))_
    val distance = parse_attribute (attribute ("""MeasurementKind.distance"""))_
    val distortionPowerFactor = parse_attribute (attribute ("""MeasurementKind.distortionPowerFactor"""))_
    val distortionVoltAmp = parse_attribute (attribute ("""MeasurementKind.distortionVoltAmp"""))_
    val electronicSerialNumber = parse_attribute (attribute ("""MeasurementKind.electronicSerialNumber"""))_
    val emergencyLimit = parse_attribute (attribute ("""MeasurementKind.emergencyLimit"""))_
    val encoderTamper = parse_attribute (attribute ("""MeasurementKind.encoderTamper"""))_
    val endDeviceID = parse_attribute (attribute ("""MeasurementKind.endDeviceID"""))_
    val energization = parse_attribute (attribute ("""MeasurementKind.energization"""))_
    val energizationLoadSide = parse_attribute (attribute ("""MeasurementKind.energizationLoadSide"""))_
    val energy = parse_attribute (attribute ("""MeasurementKind.energy"""))_
    val fan = parse_attribute (attribute ("""MeasurementKind.fan"""))_
    val frequency = parse_attribute (attribute ("""MeasurementKind.frequency"""))_
    val frequencyExcursion = parse_attribute (attribute ("""MeasurementKind.frequencyExcursion"""))_
    val fund = parse_attribute (attribute ("""MeasurementKind.fund"""))_
    val groupAddressType1 = parse_attribute (attribute ("""MeasurementKind.groupAddressType1"""))_
    val groupAddressType2 = parse_attribute (attribute ("""MeasurementKind.groupAddressType2"""))_
    val groupAddressType3 = parse_attribute (attribute ("""MeasurementKind.groupAddressType3"""))_
    val groupAddressType4 = parse_attribute (attribute ("""MeasurementKind.groupAddressType4"""))_
    val ieee1366ASAI = parse_attribute (attribute ("""MeasurementKind.ieee1366ASAI"""))_
    val ieee1366ASIDI = parse_attribute (attribute ("""MeasurementKind.ieee1366ASIDI"""))_
    val ieee1366ASIFI = parse_attribute (attribute ("""MeasurementKind.ieee1366ASIFI"""))_
    val ieee1366CAIDI = parse_attribute (attribute ("""MeasurementKind.ieee1366CAIDI"""))_
    val ieee1366CAIFI = parse_attribute (attribute ("""MeasurementKind.ieee1366CAIFI"""))_
    val ieee1366CEMIn = parse_attribute (attribute ("""MeasurementKind.ieee1366CEMIn"""))_
    val ieee1366CEMSMIn = parse_attribute (attribute ("""MeasurementKind.ieee1366CEMSMIn"""))_
    val ieee1366CTAIDI = parse_attribute (attribute ("""MeasurementKind.ieee1366CTAIDI"""))_
    val ieee1366MAIFI = parse_attribute (attribute ("""MeasurementKind.ieee1366MAIFI"""))_
    val ieee1366MAIFIe = parse_attribute (attribute ("""MeasurementKind.ieee1366MAIFIe"""))_
    val ieee1366MomentaryInterruption = parse_attribute (attribute ("""MeasurementKind.ieee1366MomentaryInterruption"""))_
    val ieee1366MomentaryInterruptionEvent = parse_attribute (attribute ("""MeasurementKind.ieee1366MomentaryInterruptionEvent"""))_
    val ieee1366SAIDI = parse_attribute (attribute ("""MeasurementKind.ieee1366SAIDI"""))_
    val ieee1366SAIFI = parse_attribute (attribute ("""MeasurementKind.ieee1366SAIFI"""))_
    val ieee1366SustainedInterruption = parse_attribute (attribute ("""MeasurementKind.ieee1366SustainedInterruption"""))_
    val interruptionBehaviour = parse_attribute (attribute ("""MeasurementKind.interruptionBehaviour"""))_
    val inversionTamper = parse_attribute (attribute ("""MeasurementKind.inversionTamper"""))_
    val ipAddress = parse_attribute (attribute ("""MeasurementKind.ipAddress"""))_
    val lineLoss = parse_attribute (attribute ("""MeasurementKind.lineLoss"""))_
    val loadInterrupt = parse_attribute (attribute ("""MeasurementKind.loadInterrupt"""))_
    val loadShed = parse_attribute (attribute ("""MeasurementKind.loadShed"""))_
    val loss = parse_attribute (attribute ("""MeasurementKind.loss"""))_
    val macAddress = parse_attribute (attribute ("""MeasurementKind.macAddress"""))_
    val maintenance = parse_attribute (attribute ("""MeasurementKind.maintenance"""))_
    val mfgAssignedConfigurationID = parse_attribute (attribute ("""MeasurementKind.mfgAssignedConfigurationID"""))_
    val mfgAssignedPhysicalSerialNumber = parse_attribute (attribute ("""MeasurementKind.mfgAssignedPhysicalSerialNumber"""))_
    val mfgAssignedProductNumber = parse_attribute (attribute ("""MeasurementKind.mfgAssignedProductNumber"""))_
    val mfgAssignedUniqueCommunicationAddress = parse_attribute (attribute ("""MeasurementKind.mfgAssignedUniqueCommunicationAddress"""))_
    val multiCastAddress = parse_attribute (attribute ("""MeasurementKind.multiCastAddress"""))_
    val negativeSequence = parse_attribute (attribute ("""MeasurementKind.negativeSequence"""))_
    val none = parse_attribute (attribute ("""MeasurementKind.none"""))_
    val oneWayAddress = parse_attribute (attribute ("""MeasurementKind.oneWayAddress"""))_
    val phasorPowerFactor = parse_attribute (attribute ("""MeasurementKind.phasorPowerFactor"""))_
    val phasorReactivePower = parse_attribute (attribute ("""MeasurementKind.phasorReactivePower"""))_
    val physicalTamper = parse_attribute (attribute ("""MeasurementKind.physicalTamper"""))_
    val positiveSequence = parse_attribute (attribute ("""MeasurementKind.positiveSequence"""))_
    val power = parse_attribute (attribute ("""MeasurementKind.power"""))_
    val powerFactor = parse_attribute (attribute ("""MeasurementKind.powerFactor"""))_
    val powerLossTamper = parse_attribute (attribute ("""MeasurementKind.powerLossTamper"""))_
    val powerOutage = parse_attribute (attribute ("""MeasurementKind.powerOutage"""))_
    val powerQuality = parse_attribute (attribute ("""MeasurementKind.powerQuality"""))_
    val powerRestoration = parse_attribute (attribute ("""MeasurementKind.powerRestoration"""))_
    val programmed = parse_attribute (attribute ("""MeasurementKind.programmed"""))_
    val pushbutton = parse_attribute (attribute ("""MeasurementKind.pushbutton"""))_
    val quantityPower = parse_attribute (attribute ("""MeasurementKind.quantityPower"""))_
    val relayActivation = parse_attribute (attribute ("""MeasurementKind.relayActivation"""))_
    val relayCycle = parse_attribute (attribute ("""MeasurementKind.relayCycle"""))_
    val removalTamper = parse_attribute (attribute ("""MeasurementKind.removalTamper"""))_
    val reprogrammingTamper = parse_attribute (attribute ("""MeasurementKind.reprogrammingTamper"""))_
    val reverseRotationTamper = parse_attribute (attribute ("""MeasurementKind.reverseRotationTamper"""))_
    val sag = parse_attribute (attribute ("""MeasurementKind.sag"""))_
    val signalStrength = parse_attribute (attribute ("""MeasurementKind.signalStrength"""))_
    val signaltoNoiseRatio = parse_attribute (attribute ("""MeasurementKind.signaltoNoiseRatio"""))_
    val swell = parse_attribute (attribute ("""MeasurementKind.swell"""))_
    val switchArmed = parse_attribute (attribute ("""MeasurementKind.switchArmed"""))_
    val switchDisabled = parse_attribute (attribute ("""MeasurementKind.switchDisabled"""))_
    val switchPosition = parse_attribute (attribute ("""MeasurementKind.switchPosition"""))_
    val tamper = parse_attribute (attribute ("""MeasurementKind.tamper"""))_
    val tapPosition = parse_attribute (attribute ("""MeasurementKind.tapPosition"""))_
    val tariffRate = parse_attribute (attribute ("""MeasurementKind.tariffRate"""))_
    val temperature = parse_attribute (attribute ("""MeasurementKind.temperature"""))_
    val totalHarmonicDistortion = parse_attribute (attribute ("""MeasurementKind.totalHarmonicDistortion"""))_
    val transformerLoss = parse_attribute (attribute ("""MeasurementKind.transformerLoss"""))_
    val twoWayAddress = parse_attribute (attribute ("""MeasurementKind.twoWayAddress"""))_
    val unipedeVoltageDip10to15 = parse_attribute (attribute ("""MeasurementKind.unipedeVoltageDip10to15"""))_
    val unipedeVoltageDip15to30 = parse_attribute (attribute ("""MeasurementKind.unipedeVoltageDip15to30"""))_
    val unipedeVoltageDip30to60 = parse_attribute (attribute ("""MeasurementKind.unipedeVoltageDip30to60"""))_
    val unipedeVoltageDip60to90 = parse_attribute (attribute ("""MeasurementKind.unipedeVoltageDip60to90"""))_
    val unipedeVoltageDip90to100 = parse_attribute (attribute ("""MeasurementKind.unipedeVoltageDip90to100"""))_
    val voltage = parse_attribute (attribute ("""MeasurementKind.voltage"""))_
    val voltageAngle = parse_attribute (attribute ("""MeasurementKind.voltageAngle"""))_
    val voltageExcursion = parse_attribute (attribute ("""MeasurementKind.voltageExcursion"""))_
    val voltageImbalance = parse_attribute (attribute ("""MeasurementKind.voltageImbalance"""))_
    val volume = parse_attribute (attribute ("""MeasurementKind.volume"""))_
    val volumetricFlow = parse_attribute (attribute ("""MeasurementKind.volumetricFlow"""))_
    val watchdogTimeout = parse_attribute (attribute ("""MeasurementKind.watchdogTimeout"""))_
    val zeroFlowDuration = parse_attribute (attribute ("""MeasurementKind.zeroFlowDuration"""))_
    val zeroSequence = parse_attribute (attribute ("""MeasurementKind.zeroSequence"""))_
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

    /**
     * 15-minute
     */
    val fifteenMinute: String,

    /**
     * 5-minute
     */
    val fiveMinute: String,

    /**
     * 10-minute Fixed Block
     */
    val fixedBlock10Min: String,

    /**
     * 15-minute Fixed Block
     */
    val fixedBlock15Min: String,

    /**
     * 1-minute Fixed Block
     */
    val fixedBlock1Min: String,

    /**
     * 20-minute Fixed Block
     */
    val fixedBlock20Min: String,

    /**
     * 30-minute Fixed Block
     */
    val fixedBlock30Min: String,

    /**
     * 5-minute Fixed Block
     */
    val fixedBlock5Min: String,

    /**
     * 60-minute Fixed Block
     */
    val fixedBlock60Min: String,

    /**
     * Not Applicable
     */
    val none: String,

    /**
     * 1-minute
     */
    val oneMinute: String,

    /**
     * Within the present period of time
     */
    val present: String,

    /**
     * Shifted within the previous monthly cycle and data set
     */
    val previous: String,

    /**
     * 10-minute Rolling Block with 1-minute sub-intervals
     */
    val rollingBlock10MinIntvl1MinSubIntvl: String,

    /**
     * 10-minute Rolling Block with 2-minute sub-intervals
     */
    val rollingBlock10MinIntvl2MinSubIntvl: String,

    /**
     * 10-minute Rolling Block with 5-minute sub-intervals
     */
    val rollingBlock10MinIntvl5MinSubIntvl: String,

    /**
     * 15-minute Rolling Block with 1-minute sub-intervals
     */
    val rollingBlock15MinIntvl1MinSubIntvl: String,

    /**
     * 15-minute Rolling Block with 3-minute sub-intervals
     */
    val rollingBlock15MinIntvl3MinSubIntvl: String,

    /**
     * 15-minute Rolling Block with 5-minute sub-intervals
     */
    val rollingBlock15MinIntvl5MinSubIntvl: String,

    /**
     * 30-minute Rolling Block with 10-minute sub-intervals
     */
    val rollingBlock30MinIntvl10MinSubIntvl: String,

    /**
     * 30-minute Rolling Block with 15-minute sub-intervals
     */
    val rollingBlock30MinIntvl15MinSubIntvl: String,

    /**
     * 30-minute Rolling Block with 2-minute sub-intervals
     */
    val rollingBlock30MinIntvl2MinSubIntvl: String,

    /**
     * 30-minute Rolling Block with 3-minute sub-intervals
     */
    val rollingBlock30MinIntvl3MinSubIntvl: String,

    /**
     * 30-minute Rolling Block with 5-minute sub-intervals
     */
    val rollingBlock30MinIntvl5MinSubIntvl: String,

    /**
     * 30-minute Rolling Block with 6-minute sub-intervals
     */
    val rollingBlock30MinIntvl6MinSubIntvl: String,

    /**
     * 5-minute Rolling Block with 1-minute sub-intervals
     */
    val rollingBlock5MinIntvl1MinSubIntvl: String,

    /**
     * 60-minute Rolling Block with 10-minute sub-intervals
     */
    val rollingBlock60MinIntvl10MinSubIntvl: String,

    /**
     * 60-minute Rolling Block with 12-minute sub-intervals
     */
    val rollingBlock60MinIntvl12MinSubIntvl: String,

    /**
     * 60-minute Rolling Block with 15-minute sub-intervals
     */
    val rollingBlock60MinIntvl15MinSubIntvl: String,

    /**
     * 60-minute Rolling Block with 20-minute sub-intervals
     */
    val rollingBlock60MinIntvl20MinSubIntvl: String,

    /**
     * 60-minute Rolling Block with 30-minute sub-intervals
     */
    val rollingBlock60MinIntvl30MinSubIntvl: String,

    /**
     * 60-minute Rolling Block with 4-minute sub-intervals
     */
    val rollingBlock60MinIntvl4MinSubIntvl: String,

    /**
     * 60-minute Rolling Block with 5-minute sub-intervals
     */
    val rollingBlock60MinIntvl5MinSubIntvl: String,

    /**
     * 60-minute Rolling Block with 6-minute sub-intervals
     */
    val rollingBlock60MinIntvl6MinSubIntvl: String,

    /**
     * 60-minute
     */
    val sixtyMinute: String,

    /**
     * 10-minute
     */
    val tenMinute: String,

    /**
     * 30-minute
     */
    val thirtyMinute: String,

    /**
     * 3-minute
     */
    val threeMinute: String,

    /**
     * 20-minute interval
     */
    val twentyMinute: String,

    /**
     * 24-hour
     */
    val twentyfourHour: String,

    /**
     * 2-minute
     */
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
    val fifteenMinute = parse_attribute (attribute ("""MeasuringPeriodKind.fifteenMinute"""))_
    val fiveMinute = parse_attribute (attribute ("""MeasuringPeriodKind.fiveMinute"""))_
    val fixedBlock10Min = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock10Min"""))_
    val fixedBlock15Min = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock15Min"""))_
    val fixedBlock1Min = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock1Min"""))_
    val fixedBlock20Min = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock20Min"""))_
    val fixedBlock30Min = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock30Min"""))_
    val fixedBlock5Min = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock5Min"""))_
    val fixedBlock60Min = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock60Min"""))_
    val none = parse_attribute (attribute ("""MeasuringPeriodKind.none"""))_
    val oneMinute = parse_attribute (attribute ("""MeasuringPeriodKind.oneMinute"""))_
    val present = parse_attribute (attribute ("""MeasuringPeriodKind.present"""))_
    val previous = parse_attribute (attribute ("""MeasuringPeriodKind.previous"""))_
    val rollingBlock10MinIntvl1MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock10MinIntvl1MinSubIntvl"""))_
    val rollingBlock10MinIntvl2MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock10MinIntvl2MinSubIntvl"""))_
    val rollingBlock10MinIntvl5MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock10MinIntvl5MinSubIntvl"""))_
    val rollingBlock15MinIntvl1MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock15MinIntvl1MinSubIntvl"""))_
    val rollingBlock15MinIntvl3MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock15MinIntvl3MinSubIntvl"""))_
    val rollingBlock15MinIntvl5MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock15MinIntvl5MinSubIntvl"""))_
    val rollingBlock30MinIntvl10MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl10MinSubIntvl"""))_
    val rollingBlock30MinIntvl15MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl15MinSubIntvl"""))_
    val rollingBlock30MinIntvl2MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl2MinSubIntvl"""))_
    val rollingBlock30MinIntvl3MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl3MinSubIntvl"""))_
    val rollingBlock30MinIntvl5MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl5MinSubIntvl"""))_
    val rollingBlock30MinIntvl6MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl6MinSubIntvl"""))_
    val rollingBlock5MinIntvl1MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock5MinIntvl1MinSubIntvl"""))_
    val rollingBlock60MinIntvl10MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl10MinSubIntvl"""))_
    val rollingBlock60MinIntvl12MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl12MinSubIntvl"""))_
    val rollingBlock60MinIntvl15MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl15MinSubIntvl"""))_
    val rollingBlock60MinIntvl20MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl20MinSubIntvl"""))_
    val rollingBlock60MinIntvl30MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl30MinSubIntvl"""))_
    val rollingBlock60MinIntvl4MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl4MinSubIntvl"""))_
    val rollingBlock60MinIntvl5MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl5MinSubIntvl"""))_
    val rollingBlock60MinIntvl6MinSubIntvl = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl6MinSubIntvl"""))_
    val sixtyMinute = parse_attribute (attribute ("""MeasuringPeriodKind.sixtyMinute"""))_
    val tenMinute = parse_attribute (attribute ("""MeasuringPeriodKind.tenMinute"""))_
    val thirtyMinute = parse_attribute (attribute ("""MeasuringPeriodKind.thirtyMinute"""))_
    val threeMinute = parse_attribute (attribute ("""MeasuringPeriodKind.threeMinute"""))_
    val twentyMinute = parse_attribute (attribute ("""MeasuringPeriodKind.twentyMinute"""))_
    val twentyfourHour = parse_attribute (attribute ("""MeasuringPeriodKind.twentyfourHour"""))_
    val twoMinute = parse_attribute (attribute ("""MeasuringPeriodKind.twoMinute"""))_
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