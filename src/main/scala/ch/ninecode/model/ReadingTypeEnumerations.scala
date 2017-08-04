package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable


case class AccumulationKind
(
    override val sup: BasicElement,
    boundedQuantity: String,
    bulkQuantity: String,
    continuousCumulative: String,
    cumulative: String,
    deltaData: String,
    indicating: String,
    instantaneous: String,
    latchingQuantity: String,
    none: String,
    summation: String,
    timeDelay: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AccumulationKind] }
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
        (if (null != boundedQuantity) "\t\t<cim:AccumulationKind.boundedQuantity rdf:resource=\"#" + boundedQuantity + "\"/>\n" else "") +
        (if (null != bulkQuantity) "\t\t<cim:AccumulationKind.bulkQuantity rdf:resource=\"#" + bulkQuantity + "\"/>\n" else "") +
        (if (null != continuousCumulative) "\t\t<cim:AccumulationKind.continuousCumulative rdf:resource=\"#" + continuousCumulative + "\"/>\n" else "") +
        (if (null != cumulative) "\t\t<cim:AccumulationKind.cumulative rdf:resource=\"#" + cumulative + "\"/>\n" else "") +
        (if (null != deltaData) "\t\t<cim:AccumulationKind.deltaData rdf:resource=\"#" + deltaData + "\"/>\n" else "") +
        (if (null != indicating) "\t\t<cim:AccumulationKind.indicating rdf:resource=\"#" + indicating + "\"/>\n" else "") +
        (if (null != instantaneous) "\t\t<cim:AccumulationKind.instantaneous rdf:resource=\"#" + instantaneous + "\"/>\n" else "") +
        (if (null != latchingQuantity) "\t\t<cim:AccumulationKind.latchingQuantity rdf:resource=\"#" + latchingQuantity + "\"/>\n" else "") +
        (if (null != none) "\t\t<cim:AccumulationKind.none rdf:resource=\"#" + none + "\"/>\n" else "") +
        (if (null != summation) "\t\t<cim:AccumulationKind.summation rdf:resource=\"#" + summation + "\"/>\n" else "") +
        (if (null != timeDelay) "\t\t<cim:AccumulationKind.timeDelay rdf:resource=\"#" + timeDelay + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AccumulationKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AccumulationKind>\n"
    }
}

object AccumulationKind
extends
    Parseable[AccumulationKind]
{
    val boundedQuantity: (Context) => String = parse_attribute (attribute ("""AccumulationKind.boundedQuantity"""))
    val bulkQuantity: (Context) => String = parse_attribute (attribute ("""AccumulationKind.bulkQuantity"""))
    val continuousCumulative: (Context) => String = parse_attribute (attribute ("""AccumulationKind.continuousCumulative"""))
    val cumulative: (Context) => String = parse_attribute (attribute ("""AccumulationKind.cumulative"""))
    val deltaData: (Context) => String = parse_attribute (attribute ("""AccumulationKind.deltaData"""))
    val indicating: (Context) => String = parse_attribute (attribute ("""AccumulationKind.indicating"""))
    val instantaneous: (Context) => String = parse_attribute (attribute ("""AccumulationKind.instantaneous"""))
    val latchingQuantity: (Context) => String = parse_attribute (attribute ("""AccumulationKind.latchingQuantity"""))
    val none: (Context) => String = parse_attribute (attribute ("""AccumulationKind.none"""))
    val summation: (Context) => String = parse_attribute (attribute ("""AccumulationKind.summation"""))
    val timeDelay: (Context) => String = parse_attribute (attribute ("""AccumulationKind.timeDelay"""))
    def parse (context: Context): AccumulationKind =
    {
        AccumulationKind(
            BasicElement.parse (context),
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
    average: String,
    excess: String,
    fifthMaximum: String,
    fourthMaximum: String,
    highThreshold: String,
    lowThreshold: String,
    maximum: String,
    minimum: String,
    nominal: String,
    none: String,
    normal: String,
    secondMaximum: String,
    secondMinimum: String,
    sum: String,
    thirdMaximum: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AggregateKind] }
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
        (if (null != average) "\t\t<cim:AggregateKind.average rdf:resource=\"#" + average + "\"/>\n" else "") +
        (if (null != excess) "\t\t<cim:AggregateKind.excess rdf:resource=\"#" + excess + "\"/>\n" else "") +
        (if (null != fifthMaximum) "\t\t<cim:AggregateKind.fifthMaximum rdf:resource=\"#" + fifthMaximum + "\"/>\n" else "") +
        (if (null != fourthMaximum) "\t\t<cim:AggregateKind.fourthMaximum rdf:resource=\"#" + fourthMaximum + "\"/>\n" else "") +
        (if (null != highThreshold) "\t\t<cim:AggregateKind.highThreshold rdf:resource=\"#" + highThreshold + "\"/>\n" else "") +
        (if (null != lowThreshold) "\t\t<cim:AggregateKind.lowThreshold rdf:resource=\"#" + lowThreshold + "\"/>\n" else "") +
        (if (null != maximum) "\t\t<cim:AggregateKind.maximum rdf:resource=\"#" + maximum + "\"/>\n" else "") +
        (if (null != minimum) "\t\t<cim:AggregateKind.minimum rdf:resource=\"#" + minimum + "\"/>\n" else "") +
        (if (null != nominal) "\t\t<cim:AggregateKind.nominal rdf:resource=\"#" + nominal + "\"/>\n" else "") +
        (if (null != none) "\t\t<cim:AggregateKind.none rdf:resource=\"#" + none + "\"/>\n" else "") +
        (if (null != normal) "\t\t<cim:AggregateKind.normal rdf:resource=\"#" + normal + "\"/>\n" else "") +
        (if (null != secondMaximum) "\t\t<cim:AggregateKind.secondMaximum rdf:resource=\"#" + secondMaximum + "\"/>\n" else "") +
        (if (null != secondMinimum) "\t\t<cim:AggregateKind.secondMinimum rdf:resource=\"#" + secondMinimum + "\"/>\n" else "") +
        (if (null != sum) "\t\t<cim:AggregateKind.sum rdf:resource=\"#" + sum + "\"/>\n" else "") +
        (if (null != thirdMaximum) "\t\t<cim:AggregateKind.thirdMaximum rdf:resource=\"#" + thirdMaximum + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AggregateKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AggregateKind>\n"
    }
}

object AggregateKind
extends
    Parseable[AggregateKind]
{
    val average: (Context) => String = parse_attribute (attribute ("""AggregateKind.average"""))
    val excess: (Context) => String = parse_attribute (attribute ("""AggregateKind.excess"""))
    val fifthMaximum: (Context) => String = parse_attribute (attribute ("""AggregateKind.fifthMaximum"""))
    val fourthMaximum: (Context) => String = parse_attribute (attribute ("""AggregateKind.fourthMaximum"""))
    val highThreshold: (Context) => String = parse_attribute (attribute ("""AggregateKind.highThreshold"""))
    val lowThreshold: (Context) => String = parse_attribute (attribute ("""AggregateKind.lowThreshold"""))
    val maximum: (Context) => String = parse_attribute (attribute ("""AggregateKind.maximum"""))
    val minimum: (Context) => String = parse_attribute (attribute ("""AggregateKind.minimum"""))
    val nominal: (Context) => String = parse_attribute (attribute ("""AggregateKind.nominal"""))
    val none: (Context) => String = parse_attribute (attribute ("""AggregateKind.none"""))
    val normal: (Context) => String = parse_attribute (attribute ("""AggregateKind.normal"""))
    val secondMaximum: (Context) => String = parse_attribute (attribute ("""AggregateKind.secondMaximum"""))
    val secondMinimum: (Context) => String = parse_attribute (attribute ("""AggregateKind.secondMinimum"""))
    val sum: (Context) => String = parse_attribute (attribute ("""AggregateKind.sum"""))
    val thirdMaximum: (Context) => String = parse_attribute (attribute ("""AggregateKind.thirdMaximum"""))
    def parse (context: Context): AggregateKind =
    {
        AggregateKind(
            BasicElement.parse (context),
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
    air: String,
    carbon: String,
    ch4: String,
    co2: String,
    communication: String,
    coolingFluid: String,
    electricityPrimaryMetered: String,
    electricitySecondaryMetered: String,
    hch: String,
    heatingFluid: String,
    insulativeGas: String,
    insulativeOil: String,
    internet: String,
    naturalGas: String,
    none: String,
    nonpotableWater: String,
    nox: String,
    pfc: String,
    potableWater: String,
    propane: String,
    refuse: String,
    sf6: String,
    so2: String,
    steam: String,
    tvLicence: String,
    wasteWater: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CommodityKind] }
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
        (if (null != air) "\t\t<cim:CommodityKind.air rdf:resource=\"#" + air + "\"/>\n" else "") +
        (if (null != carbon) "\t\t<cim:CommodityKind.carbon rdf:resource=\"#" + carbon + "\"/>\n" else "") +
        (if (null != ch4) "\t\t<cim:CommodityKind.ch4 rdf:resource=\"#" + ch4 + "\"/>\n" else "") +
        (if (null != co2) "\t\t<cim:CommodityKind.co2 rdf:resource=\"#" + co2 + "\"/>\n" else "") +
        (if (null != communication) "\t\t<cim:CommodityKind.communication rdf:resource=\"#" + communication + "\"/>\n" else "") +
        (if (null != coolingFluid) "\t\t<cim:CommodityKind.coolingFluid rdf:resource=\"#" + coolingFluid + "\"/>\n" else "") +
        (if (null != electricityPrimaryMetered) "\t\t<cim:CommodityKind.electricityPrimaryMetered rdf:resource=\"#" + electricityPrimaryMetered + "\"/>\n" else "") +
        (if (null != electricitySecondaryMetered) "\t\t<cim:CommodityKind.electricitySecondaryMetered rdf:resource=\"#" + electricitySecondaryMetered + "\"/>\n" else "") +
        (if (null != hch) "\t\t<cim:CommodityKind.hch rdf:resource=\"#" + hch + "\"/>\n" else "") +
        (if (null != heatingFluid) "\t\t<cim:CommodityKind.heatingFluid rdf:resource=\"#" + heatingFluid + "\"/>\n" else "") +
        (if (null != insulativeGas) "\t\t<cim:CommodityKind.insulativeGas rdf:resource=\"#" + insulativeGas + "\"/>\n" else "") +
        (if (null != insulativeOil) "\t\t<cim:CommodityKind.insulativeOil rdf:resource=\"#" + insulativeOil + "\"/>\n" else "") +
        (if (null != internet) "\t\t<cim:CommodityKind.internet rdf:resource=\"#" + internet + "\"/>\n" else "") +
        (if (null != naturalGas) "\t\t<cim:CommodityKind.naturalGas rdf:resource=\"#" + naturalGas + "\"/>\n" else "") +
        (if (null != none) "\t\t<cim:CommodityKind.none rdf:resource=\"#" + none + "\"/>\n" else "") +
        (if (null != nonpotableWater) "\t\t<cim:CommodityKind.nonpotableWater rdf:resource=\"#" + nonpotableWater + "\"/>\n" else "") +
        (if (null != nox) "\t\t<cim:CommodityKind.nox rdf:resource=\"#" + nox + "\"/>\n" else "") +
        (if (null != pfc) "\t\t<cim:CommodityKind.pfc rdf:resource=\"#" + pfc + "\"/>\n" else "") +
        (if (null != potableWater) "\t\t<cim:CommodityKind.potableWater rdf:resource=\"#" + potableWater + "\"/>\n" else "") +
        (if (null != propane) "\t\t<cim:CommodityKind.propane rdf:resource=\"#" + propane + "\"/>\n" else "") +
        (if (null != refuse) "\t\t<cim:CommodityKind.refuse rdf:resource=\"#" + refuse + "\"/>\n" else "") +
        (if (null != sf6) "\t\t<cim:CommodityKind.sf6 rdf:resource=\"#" + sf6 + "\"/>\n" else "") +
        (if (null != so2) "\t\t<cim:CommodityKind.so2 rdf:resource=\"#" + so2 + "\"/>\n" else "") +
        (if (null != steam) "\t\t<cim:CommodityKind.steam rdf:resource=\"#" + steam + "\"/>\n" else "") +
        (if (null != tvLicence) "\t\t<cim:CommodityKind.tvLicence rdf:resource=\"#" + tvLicence + "\"/>\n" else "") +
        (if (null != wasteWater) "\t\t<cim:CommodityKind.wasteWater rdf:resource=\"#" + wasteWater + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CommodityKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CommodityKind>\n"
    }
}

object CommodityKind
extends
    Parseable[CommodityKind]
{
    val air: (Context) => String = parse_attribute (attribute ("""CommodityKind.air"""))
    val carbon: (Context) => String = parse_attribute (attribute ("""CommodityKind.carbon"""))
    val ch4: (Context) => String = parse_attribute (attribute ("""CommodityKind.ch4"""))
    val co2: (Context) => String = parse_attribute (attribute ("""CommodityKind.co2"""))
    val communication: (Context) => String = parse_attribute (attribute ("""CommodityKind.communication"""))
    val coolingFluid: (Context) => String = parse_attribute (attribute ("""CommodityKind.coolingFluid"""))
    val electricityPrimaryMetered: (Context) => String = parse_attribute (attribute ("""CommodityKind.electricityPrimaryMetered"""))
    val electricitySecondaryMetered: (Context) => String = parse_attribute (attribute ("""CommodityKind.electricitySecondaryMetered"""))
    val hch: (Context) => String = parse_attribute (attribute ("""CommodityKind.hch"""))
    val heatingFluid: (Context) => String = parse_attribute (attribute ("""CommodityKind.heatingFluid"""))
    val insulativeGas: (Context) => String = parse_attribute (attribute ("""CommodityKind.insulativeGas"""))
    val insulativeOil: (Context) => String = parse_attribute (attribute ("""CommodityKind.insulativeOil"""))
    val internet: (Context) => String = parse_attribute (attribute ("""CommodityKind.internet"""))
    val naturalGas: (Context) => String = parse_attribute (attribute ("""CommodityKind.naturalGas"""))
    val none: (Context) => String = parse_attribute (attribute ("""CommodityKind.none"""))
    val nonpotableWater: (Context) => String = parse_attribute (attribute ("""CommodityKind.nonpotableWater"""))
    val nox: (Context) => String = parse_attribute (attribute ("""CommodityKind.nox"""))
    val pfc: (Context) => String = parse_attribute (attribute ("""CommodityKind.pfc"""))
    val potableWater: (Context) => String = parse_attribute (attribute ("""CommodityKind.potableWater"""))
    val propane: (Context) => String = parse_attribute (attribute ("""CommodityKind.propane"""))
    val refuse: (Context) => String = parse_attribute (attribute ("""CommodityKind.refuse"""))
    val sf6: (Context) => String = parse_attribute (attribute ("""CommodityKind.sf6"""))
    val so2: (Context) => String = parse_attribute (attribute ("""CommodityKind.so2"""))
    val steam: (Context) => String = parse_attribute (attribute ("""CommodityKind.steam"""))
    val tvLicence: (Context) => String = parse_attribute (attribute ("""CommodityKind.tvLicence"""))
    val wasteWater: (Context) => String = parse_attribute (attribute ("""CommodityKind.wasteWater"""))
    def parse (context: Context): CommodityKind =
    {
        CommodityKind(
            BasicElement.parse (context),
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
    forward: String,
    lagging: String,
    leading: String,
    net: String,
    none: String,
    q1minusQ4: String,
    q1plusQ2: String,
    q1plusQ3: String,
    q1plusQ4: String,
    q2minusQ3: String,
    q2plusQ3: String,
    q2plusQ4: String,
    q3minusQ2: String,
    q3plusQ4: String,
    quadrant1: String,
    quadrant2: String,
    quadrant3: String,
    quadrant4: String,
    reverse: String,
    total: String,
    totalByPhase: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FlowDirectionKind] }
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
        (if (null != forward) "\t\t<cim:FlowDirectionKind.forward rdf:resource=\"#" + forward + "\"/>\n" else "") +
        (if (null != lagging) "\t\t<cim:FlowDirectionKind.lagging rdf:resource=\"#" + lagging + "\"/>\n" else "") +
        (if (null != leading) "\t\t<cim:FlowDirectionKind.leading rdf:resource=\"#" + leading + "\"/>\n" else "") +
        (if (null != net) "\t\t<cim:FlowDirectionKind.net rdf:resource=\"#" + net + "\"/>\n" else "") +
        (if (null != none) "\t\t<cim:FlowDirectionKind.none rdf:resource=\"#" + none + "\"/>\n" else "") +
        (if (null != q1minusQ4) "\t\t<cim:FlowDirectionKind.q1minusQ4 rdf:resource=\"#" + q1minusQ4 + "\"/>\n" else "") +
        (if (null != q1plusQ2) "\t\t<cim:FlowDirectionKind.q1plusQ2 rdf:resource=\"#" + q1plusQ2 + "\"/>\n" else "") +
        (if (null != q1plusQ3) "\t\t<cim:FlowDirectionKind.q1plusQ3 rdf:resource=\"#" + q1plusQ3 + "\"/>\n" else "") +
        (if (null != q1plusQ4) "\t\t<cim:FlowDirectionKind.q1plusQ4 rdf:resource=\"#" + q1plusQ4 + "\"/>\n" else "") +
        (if (null != q2minusQ3) "\t\t<cim:FlowDirectionKind.q2minusQ3 rdf:resource=\"#" + q2minusQ3 + "\"/>\n" else "") +
        (if (null != q2plusQ3) "\t\t<cim:FlowDirectionKind.q2plusQ3 rdf:resource=\"#" + q2plusQ3 + "\"/>\n" else "") +
        (if (null != q2plusQ4) "\t\t<cim:FlowDirectionKind.q2plusQ4 rdf:resource=\"#" + q2plusQ4 + "\"/>\n" else "") +
        (if (null != q3minusQ2) "\t\t<cim:FlowDirectionKind.q3minusQ2 rdf:resource=\"#" + q3minusQ2 + "\"/>\n" else "") +
        (if (null != q3plusQ4) "\t\t<cim:FlowDirectionKind.q3plusQ4 rdf:resource=\"#" + q3plusQ4 + "\"/>\n" else "") +
        (if (null != quadrant1) "\t\t<cim:FlowDirectionKind.quadrant1 rdf:resource=\"#" + quadrant1 + "\"/>\n" else "") +
        (if (null != quadrant2) "\t\t<cim:FlowDirectionKind.quadrant2 rdf:resource=\"#" + quadrant2 + "\"/>\n" else "") +
        (if (null != quadrant3) "\t\t<cim:FlowDirectionKind.quadrant3 rdf:resource=\"#" + quadrant3 + "\"/>\n" else "") +
        (if (null != quadrant4) "\t\t<cim:FlowDirectionKind.quadrant4 rdf:resource=\"#" + quadrant4 + "\"/>\n" else "") +
        (if (null != reverse) "\t\t<cim:FlowDirectionKind.reverse rdf:resource=\"#" + reverse + "\"/>\n" else "") +
        (if (null != total) "\t\t<cim:FlowDirectionKind.total rdf:resource=\"#" + total + "\"/>\n" else "") +
        (if (null != totalByPhase) "\t\t<cim:FlowDirectionKind.totalByPhase rdf:resource=\"#" + totalByPhase + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FlowDirectionKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FlowDirectionKind>\n"
    }
}

object FlowDirectionKind
extends
    Parseable[FlowDirectionKind]
{
    val forward: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.forward"""))
    val lagging: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.lagging"""))
    val leading: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.leading"""))
    val net: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.net"""))
    val none: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.none"""))
    val q1minusQ4: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.q1minusQ4"""))
    val q1plusQ2: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.q1plusQ2"""))
    val q1plusQ3: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.q1plusQ3"""))
    val q1plusQ4: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.q1plusQ4"""))
    val q2minusQ3: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.q2minusQ3"""))
    val q2plusQ3: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.q2plusQ3"""))
    val q2plusQ4: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.q2plusQ4"""))
    val q3minusQ2: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.q3minusQ2"""))
    val q3plusQ4: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.q3plusQ4"""))
    val quadrant1: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.quadrant1"""))
    val quadrant2: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.quadrant2"""))
    val quadrant3: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.quadrant3"""))
    val quadrant4: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.quadrant4"""))
    val reverse: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.reverse"""))
    val total: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.total"""))
    val totalByPhase: (Context) => String = parse_attribute (attribute ("""FlowDirectionKind.totalByPhase"""))
    def parse (context: Context): FlowDirectionKind =
    {
        FlowDirectionKind(
            BasicElement.parse (context),
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
    billingPeriod: String,
    daily: String,
    monthly: String,
    none: String,
    seasonal: String,
    specifiedPeriod: String,
    weekly: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MacroPeriodKind] }
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
        (if (null != billingPeriod) "\t\t<cim:MacroPeriodKind.billingPeriod rdf:resource=\"#" + billingPeriod + "\"/>\n" else "") +
        (if (null != daily) "\t\t<cim:MacroPeriodKind.daily rdf:resource=\"#" + daily + "\"/>\n" else "") +
        (if (null != monthly) "\t\t<cim:MacroPeriodKind.monthly rdf:resource=\"#" + monthly + "\"/>\n" else "") +
        (if (null != none) "\t\t<cim:MacroPeriodKind.none rdf:resource=\"#" + none + "\"/>\n" else "") +
        (if (null != seasonal) "\t\t<cim:MacroPeriodKind.seasonal rdf:resource=\"#" + seasonal + "\"/>\n" else "") +
        (if (null != specifiedPeriod) "\t\t<cim:MacroPeriodKind.specifiedPeriod rdf:resource=\"#" + specifiedPeriod + "\"/>\n" else "") +
        (if (null != weekly) "\t\t<cim:MacroPeriodKind.weekly rdf:resource=\"#" + weekly + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MacroPeriodKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MacroPeriodKind>\n"
    }
}

object MacroPeriodKind
extends
    Parseable[MacroPeriodKind]
{
    val billingPeriod: (Context) => String = parse_attribute (attribute ("""MacroPeriodKind.billingPeriod"""))
    val daily: (Context) => String = parse_attribute (attribute ("""MacroPeriodKind.daily"""))
    val monthly: (Context) => String = parse_attribute (attribute ("""MacroPeriodKind.monthly"""))
    val none: (Context) => String = parse_attribute (attribute ("""MacroPeriodKind.none"""))
    val seasonal: (Context) => String = parse_attribute (attribute ("""MacroPeriodKind.seasonal"""))
    val specifiedPeriod: (Context) => String = parse_attribute (attribute ("""MacroPeriodKind.specifiedPeriod"""))
    val weekly: (Context) => String = parse_attribute (attribute ("""MacroPeriodKind.weekly"""))
    def parse (context: Context): MacroPeriodKind =
    {
        MacroPeriodKind(
            BasicElement.parse (context),
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
    alarm: String,
    apTitle: String,
    apparentPowerFactor: String,
    applicationContext: String,
    assetNumber: String,
    audibleVolume: String,
    bandwidth: String,
    batteryCarryover: String,
    batteryVoltage: String,
    billCarryover: String,
    billLastPeriod: String,
    billToDate: String,
    broadcastAddress: String,
    connectionFee: String,
    currency: String,
    current: String,
    currentAngle: String,
    currentImbalance: String,
    dataOverflowAlarm: String,
    date: String,
    demand: String,
    demandLimit: String,
    demandReset: String,
    deviceAddressType1: String,
    deviceAddressType2: String,
    deviceAddressType3: String,
    deviceAddressType4: String,
    deviceClass: String,
    diagnostic: String,
    distance: String,
    distortionPowerFactor: String,
    distortionVoltAmp: String,
    electronicSerialNumber: String,
    emergencyLimit: String,
    encoderTamper: String,
    endDeviceID: String,
    energization: String,
    energizationLoadSide: String,
    energy: String,
    fan: String,
    frequency: String,
    frequencyExcursion: String,
    fund: String,
    groupAddressType1: String,
    groupAddressType2: String,
    groupAddressType3: String,
    groupAddressType4: String,
    ieee1366ASAI: String,
    ieee1366ASIDI: String,
    ieee1366ASIFI: String,
    ieee1366CAIDI: String,
    ieee1366CAIFI: String,
    ieee1366CEMIn: String,
    ieee1366CEMSMIn: String,
    ieee1366CTAIDI: String,
    ieee1366MAIFI: String,
    ieee1366MAIFIe: String,
    ieee1366MomentaryInterruption: String,
    ieee1366MomentaryInterruptionEvent: String,
    ieee1366SAIDI: String,
    ieee1366SAIFI: String,
    ieee1366SustainedInterruption: String,
    interruptionBehaviour: String,
    inversionTamper: String,
    ipAddress: String,
    lineLoss: String,
    loadInterrupt: String,
    loadShed: String,
    loss: String,
    macAddress: String,
    maintenance: String,
    mfgAssignedConfigurationID: String,
    mfgAssignedPhysicalSerialNumber: String,
    mfgAssignedProductNumber: String,
    mfgAssignedUniqueCommunicationAddress: String,
    multiCastAddress: String,
    negativeSequence: String,
    none: String,
    oneWayAddress: String,
    phasorPowerFactor: String,
    phasorReactivePower: String,
    physicalTamper: String,
    positiveSequence: String,
    power: String,
    powerFactor: String,
    powerLossTamper: String,
    powerOutage: String,
    powerQuality: String,
    powerRestoration: String,
    programmed: String,
    pushbutton: String,
    quantityPower: String,
    relayActivation: String,
    relayCycle: String,
    removalTamper: String,
    reprogrammingTamper: String,
    reverseRotationTamper: String,
    sag: String,
    signalStrength: String,
    signaltoNoiseRatio: String,
    swell: String,
    switchArmed: String,
    switchDisabled: String,
    switchPosition: String,
    tamper: String,
    tapPosition: String,
    tariffRate: String,
    temperature: String,
    totalHarmonicDistortion: String,
    transformerLoss: String,
    twoWayAddress: String,
    unipedeVoltageDip10to15: String,
    unipedeVoltageDip15to30: String,
    unipedeVoltageDip30to60: String,
    unipedeVoltageDip60to90: String,
    unipedeVoltageDip90to100: String,
    voltage: String,
    voltageAngle: String,
    voltageExcursion: String,
    voltageImbalance: String,
    volume: String,
    volumetricFlow: String,
    watchdogTimeout: String,
    zeroFlowDuration: String,
    zeroSequence: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MeasurementKind] }
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
        (if (null != alarm) "\t\t<cim:MeasurementKind.alarm rdf:resource=\"#" + alarm + "\"/>\n" else "") +
        (if (null != apTitle) "\t\t<cim:MeasurementKind.apTitle rdf:resource=\"#" + apTitle + "\"/>\n" else "") +
        (if (null != apparentPowerFactor) "\t\t<cim:MeasurementKind.apparentPowerFactor rdf:resource=\"#" + apparentPowerFactor + "\"/>\n" else "") +
        (if (null != applicationContext) "\t\t<cim:MeasurementKind.applicationContext rdf:resource=\"#" + applicationContext + "\"/>\n" else "") +
        (if (null != assetNumber) "\t\t<cim:MeasurementKind.assetNumber rdf:resource=\"#" + assetNumber + "\"/>\n" else "") +
        (if (null != audibleVolume) "\t\t<cim:MeasurementKind.audibleVolume rdf:resource=\"#" + audibleVolume + "\"/>\n" else "") +
        (if (null != bandwidth) "\t\t<cim:MeasurementKind.bandwidth rdf:resource=\"#" + bandwidth + "\"/>\n" else "") +
        (if (null != batteryCarryover) "\t\t<cim:MeasurementKind.batteryCarryover rdf:resource=\"#" + batteryCarryover + "\"/>\n" else "") +
        (if (null != batteryVoltage) "\t\t<cim:MeasurementKind.batteryVoltage rdf:resource=\"#" + batteryVoltage + "\"/>\n" else "") +
        (if (null != billCarryover) "\t\t<cim:MeasurementKind.billCarryover rdf:resource=\"#" + billCarryover + "\"/>\n" else "") +
        (if (null != billLastPeriod) "\t\t<cim:MeasurementKind.billLastPeriod rdf:resource=\"#" + billLastPeriod + "\"/>\n" else "") +
        (if (null != billToDate) "\t\t<cim:MeasurementKind.billToDate rdf:resource=\"#" + billToDate + "\"/>\n" else "") +
        (if (null != broadcastAddress) "\t\t<cim:MeasurementKind.broadcastAddress rdf:resource=\"#" + broadcastAddress + "\"/>\n" else "") +
        (if (null != connectionFee) "\t\t<cim:MeasurementKind.connectionFee rdf:resource=\"#" + connectionFee + "\"/>\n" else "") +
        (if (null != currency) "\t\t<cim:MeasurementKind.currency rdf:resource=\"#" + currency + "\"/>\n" else "") +
        (if (null != current) "\t\t<cim:MeasurementKind.current rdf:resource=\"#" + current + "\"/>\n" else "") +
        (if (null != currentAngle) "\t\t<cim:MeasurementKind.currentAngle rdf:resource=\"#" + currentAngle + "\"/>\n" else "") +
        (if (null != currentImbalance) "\t\t<cim:MeasurementKind.currentImbalance rdf:resource=\"#" + currentImbalance + "\"/>\n" else "") +
        (if (null != dataOverflowAlarm) "\t\t<cim:MeasurementKind.dataOverflowAlarm rdf:resource=\"#" + dataOverflowAlarm + "\"/>\n" else "") +
        (if (null != date) "\t\t<cim:MeasurementKind.date rdf:resource=\"#" + date + "\"/>\n" else "") +
        (if (null != demand) "\t\t<cim:MeasurementKind.demand rdf:resource=\"#" + demand + "\"/>\n" else "") +
        (if (null != demandLimit) "\t\t<cim:MeasurementKind.demandLimit rdf:resource=\"#" + demandLimit + "\"/>\n" else "") +
        (if (null != demandReset) "\t\t<cim:MeasurementKind.demandReset rdf:resource=\"#" + demandReset + "\"/>\n" else "") +
        (if (null != deviceAddressType1) "\t\t<cim:MeasurementKind.deviceAddressType1 rdf:resource=\"#" + deviceAddressType1 + "\"/>\n" else "") +
        (if (null != deviceAddressType2) "\t\t<cim:MeasurementKind.deviceAddressType2 rdf:resource=\"#" + deviceAddressType2 + "\"/>\n" else "") +
        (if (null != deviceAddressType3) "\t\t<cim:MeasurementKind.deviceAddressType3 rdf:resource=\"#" + deviceAddressType3 + "\"/>\n" else "") +
        (if (null != deviceAddressType4) "\t\t<cim:MeasurementKind.deviceAddressType4 rdf:resource=\"#" + deviceAddressType4 + "\"/>\n" else "") +
        (if (null != deviceClass) "\t\t<cim:MeasurementKind.deviceClass rdf:resource=\"#" + deviceClass + "\"/>\n" else "") +
        (if (null != diagnostic) "\t\t<cim:MeasurementKind.diagnostic rdf:resource=\"#" + diagnostic + "\"/>\n" else "") +
        (if (null != distance) "\t\t<cim:MeasurementKind.distance rdf:resource=\"#" + distance + "\"/>\n" else "") +
        (if (null != distortionPowerFactor) "\t\t<cim:MeasurementKind.distortionPowerFactor rdf:resource=\"#" + distortionPowerFactor + "\"/>\n" else "") +
        (if (null != distortionVoltAmp) "\t\t<cim:MeasurementKind.distortionVoltAmp rdf:resource=\"#" + distortionVoltAmp + "\"/>\n" else "") +
        (if (null != electronicSerialNumber) "\t\t<cim:MeasurementKind.electronicSerialNumber rdf:resource=\"#" + electronicSerialNumber + "\"/>\n" else "") +
        (if (null != emergencyLimit) "\t\t<cim:MeasurementKind.emergencyLimit rdf:resource=\"#" + emergencyLimit + "\"/>\n" else "") +
        (if (null != encoderTamper) "\t\t<cim:MeasurementKind.encoderTamper rdf:resource=\"#" + encoderTamper + "\"/>\n" else "") +
        (if (null != endDeviceID) "\t\t<cim:MeasurementKind.endDeviceID rdf:resource=\"#" + endDeviceID + "\"/>\n" else "") +
        (if (null != energization) "\t\t<cim:MeasurementKind.energization rdf:resource=\"#" + energization + "\"/>\n" else "") +
        (if (null != energizationLoadSide) "\t\t<cim:MeasurementKind.energizationLoadSide rdf:resource=\"#" + energizationLoadSide + "\"/>\n" else "") +
        (if (null != energy) "\t\t<cim:MeasurementKind.energy rdf:resource=\"#" + energy + "\"/>\n" else "") +
        (if (null != fan) "\t\t<cim:MeasurementKind.fan rdf:resource=\"#" + fan + "\"/>\n" else "") +
        (if (null != frequency) "\t\t<cim:MeasurementKind.frequency rdf:resource=\"#" + frequency + "\"/>\n" else "") +
        (if (null != frequencyExcursion) "\t\t<cim:MeasurementKind.frequencyExcursion rdf:resource=\"#" + frequencyExcursion + "\"/>\n" else "") +
        (if (null != fund) "\t\t<cim:MeasurementKind.fund rdf:resource=\"#" + fund + "\"/>\n" else "") +
        (if (null != groupAddressType1) "\t\t<cim:MeasurementKind.groupAddressType1 rdf:resource=\"#" + groupAddressType1 + "\"/>\n" else "") +
        (if (null != groupAddressType2) "\t\t<cim:MeasurementKind.groupAddressType2 rdf:resource=\"#" + groupAddressType2 + "\"/>\n" else "") +
        (if (null != groupAddressType3) "\t\t<cim:MeasurementKind.groupAddressType3 rdf:resource=\"#" + groupAddressType3 + "\"/>\n" else "") +
        (if (null != groupAddressType4) "\t\t<cim:MeasurementKind.groupAddressType4 rdf:resource=\"#" + groupAddressType4 + "\"/>\n" else "") +
        (if (null != ieee1366ASAI) "\t\t<cim:MeasurementKind.ieee1366ASAI rdf:resource=\"#" + ieee1366ASAI + "\"/>\n" else "") +
        (if (null != ieee1366ASIDI) "\t\t<cim:MeasurementKind.ieee1366ASIDI rdf:resource=\"#" + ieee1366ASIDI + "\"/>\n" else "") +
        (if (null != ieee1366ASIFI) "\t\t<cim:MeasurementKind.ieee1366ASIFI rdf:resource=\"#" + ieee1366ASIFI + "\"/>\n" else "") +
        (if (null != ieee1366CAIDI) "\t\t<cim:MeasurementKind.ieee1366CAIDI rdf:resource=\"#" + ieee1366CAIDI + "\"/>\n" else "") +
        (if (null != ieee1366CAIFI) "\t\t<cim:MeasurementKind.ieee1366CAIFI rdf:resource=\"#" + ieee1366CAIFI + "\"/>\n" else "") +
        (if (null != ieee1366CEMIn) "\t\t<cim:MeasurementKind.ieee1366CEMIn rdf:resource=\"#" + ieee1366CEMIn + "\"/>\n" else "") +
        (if (null != ieee1366CEMSMIn) "\t\t<cim:MeasurementKind.ieee1366CEMSMIn rdf:resource=\"#" + ieee1366CEMSMIn + "\"/>\n" else "") +
        (if (null != ieee1366CTAIDI) "\t\t<cim:MeasurementKind.ieee1366CTAIDI rdf:resource=\"#" + ieee1366CTAIDI + "\"/>\n" else "") +
        (if (null != ieee1366MAIFI) "\t\t<cim:MeasurementKind.ieee1366MAIFI rdf:resource=\"#" + ieee1366MAIFI + "\"/>\n" else "") +
        (if (null != ieee1366MAIFIe) "\t\t<cim:MeasurementKind.ieee1366MAIFIe rdf:resource=\"#" + ieee1366MAIFIe + "\"/>\n" else "") +
        (if (null != ieee1366MomentaryInterruption) "\t\t<cim:MeasurementKind.ieee1366MomentaryInterruption rdf:resource=\"#" + ieee1366MomentaryInterruption + "\"/>\n" else "") +
        (if (null != ieee1366MomentaryInterruptionEvent) "\t\t<cim:MeasurementKind.ieee1366MomentaryInterruptionEvent rdf:resource=\"#" + ieee1366MomentaryInterruptionEvent + "\"/>\n" else "") +
        (if (null != ieee1366SAIDI) "\t\t<cim:MeasurementKind.ieee1366SAIDI rdf:resource=\"#" + ieee1366SAIDI + "\"/>\n" else "") +
        (if (null != ieee1366SAIFI) "\t\t<cim:MeasurementKind.ieee1366SAIFI rdf:resource=\"#" + ieee1366SAIFI + "\"/>\n" else "") +
        (if (null != ieee1366SustainedInterruption) "\t\t<cim:MeasurementKind.ieee1366SustainedInterruption rdf:resource=\"#" + ieee1366SustainedInterruption + "\"/>\n" else "") +
        (if (null != interruptionBehaviour) "\t\t<cim:MeasurementKind.interruptionBehaviour rdf:resource=\"#" + interruptionBehaviour + "\"/>\n" else "") +
        (if (null != inversionTamper) "\t\t<cim:MeasurementKind.inversionTamper rdf:resource=\"#" + inversionTamper + "\"/>\n" else "") +
        (if (null != ipAddress) "\t\t<cim:MeasurementKind.ipAddress rdf:resource=\"#" + ipAddress + "\"/>\n" else "") +
        (if (null != lineLoss) "\t\t<cim:MeasurementKind.lineLoss rdf:resource=\"#" + lineLoss + "\"/>\n" else "") +
        (if (null != loadInterrupt) "\t\t<cim:MeasurementKind.loadInterrupt rdf:resource=\"#" + loadInterrupt + "\"/>\n" else "") +
        (if (null != loadShed) "\t\t<cim:MeasurementKind.loadShed rdf:resource=\"#" + loadShed + "\"/>\n" else "") +
        (if (null != loss) "\t\t<cim:MeasurementKind.loss rdf:resource=\"#" + loss + "\"/>\n" else "") +
        (if (null != macAddress) "\t\t<cim:MeasurementKind.macAddress rdf:resource=\"#" + macAddress + "\"/>\n" else "") +
        (if (null != maintenance) "\t\t<cim:MeasurementKind.maintenance rdf:resource=\"#" + maintenance + "\"/>\n" else "") +
        (if (null != mfgAssignedConfigurationID) "\t\t<cim:MeasurementKind.mfgAssignedConfigurationID rdf:resource=\"#" + mfgAssignedConfigurationID + "\"/>\n" else "") +
        (if (null != mfgAssignedPhysicalSerialNumber) "\t\t<cim:MeasurementKind.mfgAssignedPhysicalSerialNumber rdf:resource=\"#" + mfgAssignedPhysicalSerialNumber + "\"/>\n" else "") +
        (if (null != mfgAssignedProductNumber) "\t\t<cim:MeasurementKind.mfgAssignedProductNumber rdf:resource=\"#" + mfgAssignedProductNumber + "\"/>\n" else "") +
        (if (null != mfgAssignedUniqueCommunicationAddress) "\t\t<cim:MeasurementKind.mfgAssignedUniqueCommunicationAddress rdf:resource=\"#" + mfgAssignedUniqueCommunicationAddress + "\"/>\n" else "") +
        (if (null != multiCastAddress) "\t\t<cim:MeasurementKind.multiCastAddress rdf:resource=\"#" + multiCastAddress + "\"/>\n" else "") +
        (if (null != negativeSequence) "\t\t<cim:MeasurementKind.negativeSequence rdf:resource=\"#" + negativeSequence + "\"/>\n" else "") +
        (if (null != none) "\t\t<cim:MeasurementKind.none rdf:resource=\"#" + none + "\"/>\n" else "") +
        (if (null != oneWayAddress) "\t\t<cim:MeasurementKind.oneWayAddress rdf:resource=\"#" + oneWayAddress + "\"/>\n" else "") +
        (if (null != phasorPowerFactor) "\t\t<cim:MeasurementKind.phasorPowerFactor rdf:resource=\"#" + phasorPowerFactor + "\"/>\n" else "") +
        (if (null != phasorReactivePower) "\t\t<cim:MeasurementKind.phasorReactivePower rdf:resource=\"#" + phasorReactivePower + "\"/>\n" else "") +
        (if (null != physicalTamper) "\t\t<cim:MeasurementKind.physicalTamper rdf:resource=\"#" + physicalTamper + "\"/>\n" else "") +
        (if (null != positiveSequence) "\t\t<cim:MeasurementKind.positiveSequence rdf:resource=\"#" + positiveSequence + "\"/>\n" else "") +
        (if (null != power) "\t\t<cim:MeasurementKind.power rdf:resource=\"#" + power + "\"/>\n" else "") +
        (if (null != powerFactor) "\t\t<cim:MeasurementKind.powerFactor rdf:resource=\"#" + powerFactor + "\"/>\n" else "") +
        (if (null != powerLossTamper) "\t\t<cim:MeasurementKind.powerLossTamper rdf:resource=\"#" + powerLossTamper + "\"/>\n" else "") +
        (if (null != powerOutage) "\t\t<cim:MeasurementKind.powerOutage rdf:resource=\"#" + powerOutage + "\"/>\n" else "") +
        (if (null != powerQuality) "\t\t<cim:MeasurementKind.powerQuality rdf:resource=\"#" + powerQuality + "\"/>\n" else "") +
        (if (null != powerRestoration) "\t\t<cim:MeasurementKind.powerRestoration rdf:resource=\"#" + powerRestoration + "\"/>\n" else "") +
        (if (null != programmed) "\t\t<cim:MeasurementKind.programmed rdf:resource=\"#" + programmed + "\"/>\n" else "") +
        (if (null != pushbutton) "\t\t<cim:MeasurementKind.pushbutton rdf:resource=\"#" + pushbutton + "\"/>\n" else "") +
        (if (null != quantityPower) "\t\t<cim:MeasurementKind.quantityPower rdf:resource=\"#" + quantityPower + "\"/>\n" else "") +
        (if (null != relayActivation) "\t\t<cim:MeasurementKind.relayActivation rdf:resource=\"#" + relayActivation + "\"/>\n" else "") +
        (if (null != relayCycle) "\t\t<cim:MeasurementKind.relayCycle rdf:resource=\"#" + relayCycle + "\"/>\n" else "") +
        (if (null != removalTamper) "\t\t<cim:MeasurementKind.removalTamper rdf:resource=\"#" + removalTamper + "\"/>\n" else "") +
        (if (null != reprogrammingTamper) "\t\t<cim:MeasurementKind.reprogrammingTamper rdf:resource=\"#" + reprogrammingTamper + "\"/>\n" else "") +
        (if (null != reverseRotationTamper) "\t\t<cim:MeasurementKind.reverseRotationTamper rdf:resource=\"#" + reverseRotationTamper + "\"/>\n" else "") +
        (if (null != sag) "\t\t<cim:MeasurementKind.sag rdf:resource=\"#" + sag + "\"/>\n" else "") +
        (if (null != signalStrength) "\t\t<cim:MeasurementKind.signalStrength rdf:resource=\"#" + signalStrength + "\"/>\n" else "") +
        (if (null != signaltoNoiseRatio) "\t\t<cim:MeasurementKind.signaltoNoiseRatio rdf:resource=\"#" + signaltoNoiseRatio + "\"/>\n" else "") +
        (if (null != swell) "\t\t<cim:MeasurementKind.swell rdf:resource=\"#" + swell + "\"/>\n" else "") +
        (if (null != switchArmed) "\t\t<cim:MeasurementKind.switchArmed rdf:resource=\"#" + switchArmed + "\"/>\n" else "") +
        (if (null != switchDisabled) "\t\t<cim:MeasurementKind.switchDisabled rdf:resource=\"#" + switchDisabled + "\"/>\n" else "") +
        (if (null != switchPosition) "\t\t<cim:MeasurementKind.switchPosition rdf:resource=\"#" + switchPosition + "\"/>\n" else "") +
        (if (null != tamper) "\t\t<cim:MeasurementKind.tamper rdf:resource=\"#" + tamper + "\"/>\n" else "") +
        (if (null != tapPosition) "\t\t<cim:MeasurementKind.tapPosition rdf:resource=\"#" + tapPosition + "\"/>\n" else "") +
        (if (null != tariffRate) "\t\t<cim:MeasurementKind.tariffRate rdf:resource=\"#" + tariffRate + "\"/>\n" else "") +
        (if (null != temperature) "\t\t<cim:MeasurementKind.temperature rdf:resource=\"#" + temperature + "\"/>\n" else "") +
        (if (null != totalHarmonicDistortion) "\t\t<cim:MeasurementKind.totalHarmonicDistortion rdf:resource=\"#" + totalHarmonicDistortion + "\"/>\n" else "") +
        (if (null != transformerLoss) "\t\t<cim:MeasurementKind.transformerLoss rdf:resource=\"#" + transformerLoss + "\"/>\n" else "") +
        (if (null != twoWayAddress) "\t\t<cim:MeasurementKind.twoWayAddress rdf:resource=\"#" + twoWayAddress + "\"/>\n" else "") +
        (if (null != unipedeVoltageDip10to15) "\t\t<cim:MeasurementKind.unipedeVoltageDip10to15 rdf:resource=\"#" + unipedeVoltageDip10to15 + "\"/>\n" else "") +
        (if (null != unipedeVoltageDip15to30) "\t\t<cim:MeasurementKind.unipedeVoltageDip15to30 rdf:resource=\"#" + unipedeVoltageDip15to30 + "\"/>\n" else "") +
        (if (null != unipedeVoltageDip30to60) "\t\t<cim:MeasurementKind.unipedeVoltageDip30to60 rdf:resource=\"#" + unipedeVoltageDip30to60 + "\"/>\n" else "") +
        (if (null != unipedeVoltageDip60to90) "\t\t<cim:MeasurementKind.unipedeVoltageDip60to90 rdf:resource=\"#" + unipedeVoltageDip60to90 + "\"/>\n" else "") +
        (if (null != unipedeVoltageDip90to100) "\t\t<cim:MeasurementKind.unipedeVoltageDip90to100 rdf:resource=\"#" + unipedeVoltageDip90to100 + "\"/>\n" else "") +
        (if (null != voltage) "\t\t<cim:MeasurementKind.voltage rdf:resource=\"#" + voltage + "\"/>\n" else "") +
        (if (null != voltageAngle) "\t\t<cim:MeasurementKind.voltageAngle rdf:resource=\"#" + voltageAngle + "\"/>\n" else "") +
        (if (null != voltageExcursion) "\t\t<cim:MeasurementKind.voltageExcursion rdf:resource=\"#" + voltageExcursion + "\"/>\n" else "") +
        (if (null != voltageImbalance) "\t\t<cim:MeasurementKind.voltageImbalance rdf:resource=\"#" + voltageImbalance + "\"/>\n" else "") +
        (if (null != volume) "\t\t<cim:MeasurementKind.volume rdf:resource=\"#" + volume + "\"/>\n" else "") +
        (if (null != volumetricFlow) "\t\t<cim:MeasurementKind.volumetricFlow rdf:resource=\"#" + volumetricFlow + "\"/>\n" else "") +
        (if (null != watchdogTimeout) "\t\t<cim:MeasurementKind.watchdogTimeout rdf:resource=\"#" + watchdogTimeout + "\"/>\n" else "") +
        (if (null != zeroFlowDuration) "\t\t<cim:MeasurementKind.zeroFlowDuration rdf:resource=\"#" + zeroFlowDuration + "\"/>\n" else "") +
        (if (null != zeroSequence) "\t\t<cim:MeasurementKind.zeroSequence rdf:resource=\"#" + zeroSequence + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MeasurementKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MeasurementKind>\n"
    }
}

object MeasurementKind
extends
    Parseable[MeasurementKind]
{
    val alarm: (Context) => String = parse_attribute (attribute ("""MeasurementKind.alarm"""))
    val apTitle: (Context) => String = parse_attribute (attribute ("""MeasurementKind.apTitle"""))
    val apparentPowerFactor: (Context) => String = parse_attribute (attribute ("""MeasurementKind.apparentPowerFactor"""))
    val applicationContext: (Context) => String = parse_attribute (attribute ("""MeasurementKind.applicationContext"""))
    val assetNumber: (Context) => String = parse_attribute (attribute ("""MeasurementKind.assetNumber"""))
    val audibleVolume: (Context) => String = parse_attribute (attribute ("""MeasurementKind.audibleVolume"""))
    val bandwidth: (Context) => String = parse_attribute (attribute ("""MeasurementKind.bandwidth"""))
    val batteryCarryover: (Context) => String = parse_attribute (attribute ("""MeasurementKind.batteryCarryover"""))
    val batteryVoltage: (Context) => String = parse_attribute (attribute ("""MeasurementKind.batteryVoltage"""))
    val billCarryover: (Context) => String = parse_attribute (attribute ("""MeasurementKind.billCarryover"""))
    val billLastPeriod: (Context) => String = parse_attribute (attribute ("""MeasurementKind.billLastPeriod"""))
    val billToDate: (Context) => String = parse_attribute (attribute ("""MeasurementKind.billToDate"""))
    val broadcastAddress: (Context) => String = parse_attribute (attribute ("""MeasurementKind.broadcastAddress"""))
    val connectionFee: (Context) => String = parse_attribute (attribute ("""MeasurementKind.connectionFee"""))
    val currency: (Context) => String = parse_attribute (attribute ("""MeasurementKind.currency"""))
    val current: (Context) => String = parse_attribute (attribute ("""MeasurementKind.current"""))
    val currentAngle: (Context) => String = parse_attribute (attribute ("""MeasurementKind.currentAngle"""))
    val currentImbalance: (Context) => String = parse_attribute (attribute ("""MeasurementKind.currentImbalance"""))
    val dataOverflowAlarm: (Context) => String = parse_attribute (attribute ("""MeasurementKind.dataOverflowAlarm"""))
    val date: (Context) => String = parse_attribute (attribute ("""MeasurementKind.date"""))
    val demand: (Context) => String = parse_attribute (attribute ("""MeasurementKind.demand"""))
    val demandLimit: (Context) => String = parse_attribute (attribute ("""MeasurementKind.demandLimit"""))
    val demandReset: (Context) => String = parse_attribute (attribute ("""MeasurementKind.demandReset"""))
    val deviceAddressType1: (Context) => String = parse_attribute (attribute ("""MeasurementKind.deviceAddressType1"""))
    val deviceAddressType2: (Context) => String = parse_attribute (attribute ("""MeasurementKind.deviceAddressType2"""))
    val deviceAddressType3: (Context) => String = parse_attribute (attribute ("""MeasurementKind.deviceAddressType3"""))
    val deviceAddressType4: (Context) => String = parse_attribute (attribute ("""MeasurementKind.deviceAddressType4"""))
    val deviceClass: (Context) => String = parse_attribute (attribute ("""MeasurementKind.deviceClass"""))
    val diagnostic: (Context) => String = parse_attribute (attribute ("""MeasurementKind.diagnostic"""))
    val distance: (Context) => String = parse_attribute (attribute ("""MeasurementKind.distance"""))
    val distortionPowerFactor: (Context) => String = parse_attribute (attribute ("""MeasurementKind.distortionPowerFactor"""))
    val distortionVoltAmp: (Context) => String = parse_attribute (attribute ("""MeasurementKind.distortionVoltAmp"""))
    val electronicSerialNumber: (Context) => String = parse_attribute (attribute ("""MeasurementKind.electronicSerialNumber"""))
    val emergencyLimit: (Context) => String = parse_attribute (attribute ("""MeasurementKind.emergencyLimit"""))
    val encoderTamper: (Context) => String = parse_attribute (attribute ("""MeasurementKind.encoderTamper"""))
    val endDeviceID: (Context) => String = parse_attribute (attribute ("""MeasurementKind.endDeviceID"""))
    val energization: (Context) => String = parse_attribute (attribute ("""MeasurementKind.energization"""))
    val energizationLoadSide: (Context) => String = parse_attribute (attribute ("""MeasurementKind.energizationLoadSide"""))
    val energy: (Context) => String = parse_attribute (attribute ("""MeasurementKind.energy"""))
    val fan: (Context) => String = parse_attribute (attribute ("""MeasurementKind.fan"""))
    val frequency: (Context) => String = parse_attribute (attribute ("""MeasurementKind.frequency"""))
    val frequencyExcursion: (Context) => String = parse_attribute (attribute ("""MeasurementKind.frequencyExcursion"""))
    val fund: (Context) => String = parse_attribute (attribute ("""MeasurementKind.fund"""))
    val groupAddressType1: (Context) => String = parse_attribute (attribute ("""MeasurementKind.groupAddressType1"""))
    val groupAddressType2: (Context) => String = parse_attribute (attribute ("""MeasurementKind.groupAddressType2"""))
    val groupAddressType3: (Context) => String = parse_attribute (attribute ("""MeasurementKind.groupAddressType3"""))
    val groupAddressType4: (Context) => String = parse_attribute (attribute ("""MeasurementKind.groupAddressType4"""))
    val ieee1366ASAI: (Context) => String = parse_attribute (attribute ("""MeasurementKind.ieee1366ASAI"""))
    val ieee1366ASIDI: (Context) => String = parse_attribute (attribute ("""MeasurementKind.ieee1366ASIDI"""))
    val ieee1366ASIFI: (Context) => String = parse_attribute (attribute ("""MeasurementKind.ieee1366ASIFI"""))
    val ieee1366CAIDI: (Context) => String = parse_attribute (attribute ("""MeasurementKind.ieee1366CAIDI"""))
    val ieee1366CAIFI: (Context) => String = parse_attribute (attribute ("""MeasurementKind.ieee1366CAIFI"""))
    val ieee1366CEMIn: (Context) => String = parse_attribute (attribute ("""MeasurementKind.ieee1366CEMIn"""))
    val ieee1366CEMSMIn: (Context) => String = parse_attribute (attribute ("""MeasurementKind.ieee1366CEMSMIn"""))
    val ieee1366CTAIDI: (Context) => String = parse_attribute (attribute ("""MeasurementKind.ieee1366CTAIDI"""))
    val ieee1366MAIFI: (Context) => String = parse_attribute (attribute ("""MeasurementKind.ieee1366MAIFI"""))
    val ieee1366MAIFIe: (Context) => String = parse_attribute (attribute ("""MeasurementKind.ieee1366MAIFIe"""))
    val ieee1366MomentaryInterruption: (Context) => String = parse_attribute (attribute ("""MeasurementKind.ieee1366MomentaryInterruption"""))
    val ieee1366MomentaryInterruptionEvent: (Context) => String = parse_attribute (attribute ("""MeasurementKind.ieee1366MomentaryInterruptionEvent"""))
    val ieee1366SAIDI: (Context) => String = parse_attribute (attribute ("""MeasurementKind.ieee1366SAIDI"""))
    val ieee1366SAIFI: (Context) => String = parse_attribute (attribute ("""MeasurementKind.ieee1366SAIFI"""))
    val ieee1366SustainedInterruption: (Context) => String = parse_attribute (attribute ("""MeasurementKind.ieee1366SustainedInterruption"""))
    val interruptionBehaviour: (Context) => String = parse_attribute (attribute ("""MeasurementKind.interruptionBehaviour"""))
    val inversionTamper: (Context) => String = parse_attribute (attribute ("""MeasurementKind.inversionTamper"""))
    val ipAddress: (Context) => String = parse_attribute (attribute ("""MeasurementKind.ipAddress"""))
    val lineLoss: (Context) => String = parse_attribute (attribute ("""MeasurementKind.lineLoss"""))
    val loadInterrupt: (Context) => String = parse_attribute (attribute ("""MeasurementKind.loadInterrupt"""))
    val loadShed: (Context) => String = parse_attribute (attribute ("""MeasurementKind.loadShed"""))
    val loss: (Context) => String = parse_attribute (attribute ("""MeasurementKind.loss"""))
    val macAddress: (Context) => String = parse_attribute (attribute ("""MeasurementKind.macAddress"""))
    val maintenance: (Context) => String = parse_attribute (attribute ("""MeasurementKind.maintenance"""))
    val mfgAssignedConfigurationID: (Context) => String = parse_attribute (attribute ("""MeasurementKind.mfgAssignedConfigurationID"""))
    val mfgAssignedPhysicalSerialNumber: (Context) => String = parse_attribute (attribute ("""MeasurementKind.mfgAssignedPhysicalSerialNumber"""))
    val mfgAssignedProductNumber: (Context) => String = parse_attribute (attribute ("""MeasurementKind.mfgAssignedProductNumber"""))
    val mfgAssignedUniqueCommunicationAddress: (Context) => String = parse_attribute (attribute ("""MeasurementKind.mfgAssignedUniqueCommunicationAddress"""))
    val multiCastAddress: (Context) => String = parse_attribute (attribute ("""MeasurementKind.multiCastAddress"""))
    val negativeSequence: (Context) => String = parse_attribute (attribute ("""MeasurementKind.negativeSequence"""))
    val none: (Context) => String = parse_attribute (attribute ("""MeasurementKind.none"""))
    val oneWayAddress: (Context) => String = parse_attribute (attribute ("""MeasurementKind.oneWayAddress"""))
    val phasorPowerFactor: (Context) => String = parse_attribute (attribute ("""MeasurementKind.phasorPowerFactor"""))
    val phasorReactivePower: (Context) => String = parse_attribute (attribute ("""MeasurementKind.phasorReactivePower"""))
    val physicalTamper: (Context) => String = parse_attribute (attribute ("""MeasurementKind.physicalTamper"""))
    val positiveSequence: (Context) => String = parse_attribute (attribute ("""MeasurementKind.positiveSequence"""))
    val power: (Context) => String = parse_attribute (attribute ("""MeasurementKind.power"""))
    val powerFactor: (Context) => String = parse_attribute (attribute ("""MeasurementKind.powerFactor"""))
    val powerLossTamper: (Context) => String = parse_attribute (attribute ("""MeasurementKind.powerLossTamper"""))
    val powerOutage: (Context) => String = parse_attribute (attribute ("""MeasurementKind.powerOutage"""))
    val powerQuality: (Context) => String = parse_attribute (attribute ("""MeasurementKind.powerQuality"""))
    val powerRestoration: (Context) => String = parse_attribute (attribute ("""MeasurementKind.powerRestoration"""))
    val programmed: (Context) => String = parse_attribute (attribute ("""MeasurementKind.programmed"""))
    val pushbutton: (Context) => String = parse_attribute (attribute ("""MeasurementKind.pushbutton"""))
    val quantityPower: (Context) => String = parse_attribute (attribute ("""MeasurementKind.quantityPower"""))
    val relayActivation: (Context) => String = parse_attribute (attribute ("""MeasurementKind.relayActivation"""))
    val relayCycle: (Context) => String = parse_attribute (attribute ("""MeasurementKind.relayCycle"""))
    val removalTamper: (Context) => String = parse_attribute (attribute ("""MeasurementKind.removalTamper"""))
    val reprogrammingTamper: (Context) => String = parse_attribute (attribute ("""MeasurementKind.reprogrammingTamper"""))
    val reverseRotationTamper: (Context) => String = parse_attribute (attribute ("""MeasurementKind.reverseRotationTamper"""))
    val sag: (Context) => String = parse_attribute (attribute ("""MeasurementKind.sag"""))
    val signalStrength: (Context) => String = parse_attribute (attribute ("""MeasurementKind.signalStrength"""))
    val signaltoNoiseRatio: (Context) => String = parse_attribute (attribute ("""MeasurementKind.signaltoNoiseRatio"""))
    val swell: (Context) => String = parse_attribute (attribute ("""MeasurementKind.swell"""))
    val switchArmed: (Context) => String = parse_attribute (attribute ("""MeasurementKind.switchArmed"""))
    val switchDisabled: (Context) => String = parse_attribute (attribute ("""MeasurementKind.switchDisabled"""))
    val switchPosition: (Context) => String = parse_attribute (attribute ("""MeasurementKind.switchPosition"""))
    val tamper: (Context) => String = parse_attribute (attribute ("""MeasurementKind.tamper"""))
    val tapPosition: (Context) => String = parse_attribute (attribute ("""MeasurementKind.tapPosition"""))
    val tariffRate: (Context) => String = parse_attribute (attribute ("""MeasurementKind.tariffRate"""))
    val temperature: (Context) => String = parse_attribute (attribute ("""MeasurementKind.temperature"""))
    val totalHarmonicDistortion: (Context) => String = parse_attribute (attribute ("""MeasurementKind.totalHarmonicDistortion"""))
    val transformerLoss: (Context) => String = parse_attribute (attribute ("""MeasurementKind.transformerLoss"""))
    val twoWayAddress: (Context) => String = parse_attribute (attribute ("""MeasurementKind.twoWayAddress"""))
    val unipedeVoltageDip10to15: (Context) => String = parse_attribute (attribute ("""MeasurementKind.unipedeVoltageDip10to15"""))
    val unipedeVoltageDip15to30: (Context) => String = parse_attribute (attribute ("""MeasurementKind.unipedeVoltageDip15to30"""))
    val unipedeVoltageDip30to60: (Context) => String = parse_attribute (attribute ("""MeasurementKind.unipedeVoltageDip30to60"""))
    val unipedeVoltageDip60to90: (Context) => String = parse_attribute (attribute ("""MeasurementKind.unipedeVoltageDip60to90"""))
    val unipedeVoltageDip90to100: (Context) => String = parse_attribute (attribute ("""MeasurementKind.unipedeVoltageDip90to100"""))
    val voltage: (Context) => String = parse_attribute (attribute ("""MeasurementKind.voltage"""))
    val voltageAngle: (Context) => String = parse_attribute (attribute ("""MeasurementKind.voltageAngle"""))
    val voltageExcursion: (Context) => String = parse_attribute (attribute ("""MeasurementKind.voltageExcursion"""))
    val voltageImbalance: (Context) => String = parse_attribute (attribute ("""MeasurementKind.voltageImbalance"""))
    val volume: (Context) => String = parse_attribute (attribute ("""MeasurementKind.volume"""))
    val volumetricFlow: (Context) => String = parse_attribute (attribute ("""MeasurementKind.volumetricFlow"""))
    val watchdogTimeout: (Context) => String = parse_attribute (attribute ("""MeasurementKind.watchdogTimeout"""))
    val zeroFlowDuration: (Context) => String = parse_attribute (attribute ("""MeasurementKind.zeroFlowDuration"""))
    val zeroSequence: (Context) => String = parse_attribute (attribute ("""MeasurementKind.zeroSequence"""))
    def parse (context: Context): MeasurementKind =
    {
        MeasurementKind(
            BasicElement.parse (context),
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
    fifteenMinute: String,
    fiveMinute: String,
    fixedBlock10Min: String,
    fixedBlock15Min: String,
    fixedBlock1Min: String,
    fixedBlock20Min: String,
    fixedBlock30Min: String,
    fixedBlock5Min: String,
    fixedBlock60Min: String,
    none: String,
    oneMinute: String,
    present: String,
    previous: String,
    rollingBlock10MinIntvl1MinSubIntvl: String,
    rollingBlock10MinIntvl2MinSubIntvl: String,
    rollingBlock10MinIntvl5MinSubIntvl: String,
    rollingBlock15MinIntvl1MinSubIntvl: String,
    rollingBlock15MinIntvl3MinSubIntvl: String,
    rollingBlock15MinIntvl5MinSubIntvl: String,
    rollingBlock30MinIntvl10MinSubIntvl: String,
    rollingBlock30MinIntvl15MinSubIntvl: String,
    rollingBlock30MinIntvl2MinSubIntvl: String,
    rollingBlock30MinIntvl3MinSubIntvl: String,
    rollingBlock30MinIntvl5MinSubIntvl: String,
    rollingBlock30MinIntvl6MinSubIntvl: String,
    rollingBlock5MinIntvl1MinSubIntvl: String,
    rollingBlock60MinIntvl10MinSubIntvl: String,
    rollingBlock60MinIntvl12MinSubIntvl: String,
    rollingBlock60MinIntvl15MinSubIntvl: String,
    rollingBlock60MinIntvl20MinSubIntvl: String,
    rollingBlock60MinIntvl30MinSubIntvl: String,
    rollingBlock60MinIntvl4MinSubIntvl: String,
    rollingBlock60MinIntvl5MinSubIntvl: String,
    rollingBlock60MinIntvl6MinSubIntvl: String,
    sixtyMinute: String,
    tenMinute: String,
    thirtyMinute: String,
    threeMinute: String,
    twentyMinute: String,
    twentyfourHour: String,
    twoMinute: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MeasuringPeriodKind] }
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
        (if (null != fifteenMinute) "\t\t<cim:MeasuringPeriodKind.fifteenMinute rdf:resource=\"#" + fifteenMinute + "\"/>\n" else "") +
        (if (null != fiveMinute) "\t\t<cim:MeasuringPeriodKind.fiveMinute rdf:resource=\"#" + fiveMinute + "\"/>\n" else "") +
        (if (null != fixedBlock10Min) "\t\t<cim:MeasuringPeriodKind.fixedBlock10Min rdf:resource=\"#" + fixedBlock10Min + "\"/>\n" else "") +
        (if (null != fixedBlock15Min) "\t\t<cim:MeasuringPeriodKind.fixedBlock15Min rdf:resource=\"#" + fixedBlock15Min + "\"/>\n" else "") +
        (if (null != fixedBlock1Min) "\t\t<cim:MeasuringPeriodKind.fixedBlock1Min rdf:resource=\"#" + fixedBlock1Min + "\"/>\n" else "") +
        (if (null != fixedBlock20Min) "\t\t<cim:MeasuringPeriodKind.fixedBlock20Min rdf:resource=\"#" + fixedBlock20Min + "\"/>\n" else "") +
        (if (null != fixedBlock30Min) "\t\t<cim:MeasuringPeriodKind.fixedBlock30Min rdf:resource=\"#" + fixedBlock30Min + "\"/>\n" else "") +
        (if (null != fixedBlock5Min) "\t\t<cim:MeasuringPeriodKind.fixedBlock5Min rdf:resource=\"#" + fixedBlock5Min + "\"/>\n" else "") +
        (if (null != fixedBlock60Min) "\t\t<cim:MeasuringPeriodKind.fixedBlock60Min rdf:resource=\"#" + fixedBlock60Min + "\"/>\n" else "") +
        (if (null != none) "\t\t<cim:MeasuringPeriodKind.none rdf:resource=\"#" + none + "\"/>\n" else "") +
        (if (null != oneMinute) "\t\t<cim:MeasuringPeriodKind.oneMinute rdf:resource=\"#" + oneMinute + "\"/>\n" else "") +
        (if (null != present) "\t\t<cim:MeasuringPeriodKind.present rdf:resource=\"#" + present + "\"/>\n" else "") +
        (if (null != previous) "\t\t<cim:MeasuringPeriodKind.previous rdf:resource=\"#" + previous + "\"/>\n" else "") +
        (if (null != rollingBlock10MinIntvl1MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock10MinIntvl1MinSubIntvl rdf:resource=\"#" + rollingBlock10MinIntvl1MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock10MinIntvl2MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock10MinIntvl2MinSubIntvl rdf:resource=\"#" + rollingBlock10MinIntvl2MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock10MinIntvl5MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock10MinIntvl5MinSubIntvl rdf:resource=\"#" + rollingBlock10MinIntvl5MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock15MinIntvl1MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock15MinIntvl1MinSubIntvl rdf:resource=\"#" + rollingBlock15MinIntvl1MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock15MinIntvl3MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock15MinIntvl3MinSubIntvl rdf:resource=\"#" + rollingBlock15MinIntvl3MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock15MinIntvl5MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock15MinIntvl5MinSubIntvl rdf:resource=\"#" + rollingBlock15MinIntvl5MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock30MinIntvl10MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock30MinIntvl10MinSubIntvl rdf:resource=\"#" + rollingBlock30MinIntvl10MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock30MinIntvl15MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock30MinIntvl15MinSubIntvl rdf:resource=\"#" + rollingBlock30MinIntvl15MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock30MinIntvl2MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock30MinIntvl2MinSubIntvl rdf:resource=\"#" + rollingBlock30MinIntvl2MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock30MinIntvl3MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock30MinIntvl3MinSubIntvl rdf:resource=\"#" + rollingBlock30MinIntvl3MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock30MinIntvl5MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock30MinIntvl5MinSubIntvl rdf:resource=\"#" + rollingBlock30MinIntvl5MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock30MinIntvl6MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock30MinIntvl6MinSubIntvl rdf:resource=\"#" + rollingBlock30MinIntvl6MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock5MinIntvl1MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock5MinIntvl1MinSubIntvl rdf:resource=\"#" + rollingBlock5MinIntvl1MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock60MinIntvl10MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock60MinIntvl10MinSubIntvl rdf:resource=\"#" + rollingBlock60MinIntvl10MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock60MinIntvl12MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock60MinIntvl12MinSubIntvl rdf:resource=\"#" + rollingBlock60MinIntvl12MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock60MinIntvl15MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock60MinIntvl15MinSubIntvl rdf:resource=\"#" + rollingBlock60MinIntvl15MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock60MinIntvl20MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock60MinIntvl20MinSubIntvl rdf:resource=\"#" + rollingBlock60MinIntvl20MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock60MinIntvl30MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock60MinIntvl30MinSubIntvl rdf:resource=\"#" + rollingBlock60MinIntvl30MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock60MinIntvl4MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock60MinIntvl4MinSubIntvl rdf:resource=\"#" + rollingBlock60MinIntvl4MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock60MinIntvl5MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock60MinIntvl5MinSubIntvl rdf:resource=\"#" + rollingBlock60MinIntvl5MinSubIntvl + "\"/>\n" else "") +
        (if (null != rollingBlock60MinIntvl6MinSubIntvl) "\t\t<cim:MeasuringPeriodKind.rollingBlock60MinIntvl6MinSubIntvl rdf:resource=\"#" + rollingBlock60MinIntvl6MinSubIntvl + "\"/>\n" else "") +
        (if (null != sixtyMinute) "\t\t<cim:MeasuringPeriodKind.sixtyMinute rdf:resource=\"#" + sixtyMinute + "\"/>\n" else "") +
        (if (null != tenMinute) "\t\t<cim:MeasuringPeriodKind.tenMinute rdf:resource=\"#" + tenMinute + "\"/>\n" else "") +
        (if (null != thirtyMinute) "\t\t<cim:MeasuringPeriodKind.thirtyMinute rdf:resource=\"#" + thirtyMinute + "\"/>\n" else "") +
        (if (null != threeMinute) "\t\t<cim:MeasuringPeriodKind.threeMinute rdf:resource=\"#" + threeMinute + "\"/>\n" else "") +
        (if (null != twentyMinute) "\t\t<cim:MeasuringPeriodKind.twentyMinute rdf:resource=\"#" + twentyMinute + "\"/>\n" else "") +
        (if (null != twentyfourHour) "\t\t<cim:MeasuringPeriodKind.twentyfourHour rdf:resource=\"#" + twentyfourHour + "\"/>\n" else "") +
        (if (null != twoMinute) "\t\t<cim:MeasuringPeriodKind.twoMinute rdf:resource=\"#" + twoMinute + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MeasuringPeriodKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MeasuringPeriodKind>\n"
    }
}

object MeasuringPeriodKind
extends
    Parseable[MeasuringPeriodKind]
{
    val fifteenMinute: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.fifteenMinute"""))
    val fiveMinute: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.fiveMinute"""))
    val fixedBlock10Min: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock10Min"""))
    val fixedBlock15Min: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock15Min"""))
    val fixedBlock1Min: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock1Min"""))
    val fixedBlock20Min: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock20Min"""))
    val fixedBlock30Min: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock30Min"""))
    val fixedBlock5Min: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock5Min"""))
    val fixedBlock60Min: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.fixedBlock60Min"""))
    val none: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.none"""))
    val oneMinute: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.oneMinute"""))
    val present: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.present"""))
    val previous: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.previous"""))
    val rollingBlock10MinIntvl1MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock10MinIntvl1MinSubIntvl"""))
    val rollingBlock10MinIntvl2MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock10MinIntvl2MinSubIntvl"""))
    val rollingBlock10MinIntvl5MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock10MinIntvl5MinSubIntvl"""))
    val rollingBlock15MinIntvl1MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock15MinIntvl1MinSubIntvl"""))
    val rollingBlock15MinIntvl3MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock15MinIntvl3MinSubIntvl"""))
    val rollingBlock15MinIntvl5MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock15MinIntvl5MinSubIntvl"""))
    val rollingBlock30MinIntvl10MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl10MinSubIntvl"""))
    val rollingBlock30MinIntvl15MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl15MinSubIntvl"""))
    val rollingBlock30MinIntvl2MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl2MinSubIntvl"""))
    val rollingBlock30MinIntvl3MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl3MinSubIntvl"""))
    val rollingBlock30MinIntvl5MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl5MinSubIntvl"""))
    val rollingBlock30MinIntvl6MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock30MinIntvl6MinSubIntvl"""))
    val rollingBlock5MinIntvl1MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock5MinIntvl1MinSubIntvl"""))
    val rollingBlock60MinIntvl10MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl10MinSubIntvl"""))
    val rollingBlock60MinIntvl12MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl12MinSubIntvl"""))
    val rollingBlock60MinIntvl15MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl15MinSubIntvl"""))
    val rollingBlock60MinIntvl20MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl20MinSubIntvl"""))
    val rollingBlock60MinIntvl30MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl30MinSubIntvl"""))
    val rollingBlock60MinIntvl4MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl4MinSubIntvl"""))
    val rollingBlock60MinIntvl5MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl5MinSubIntvl"""))
    val rollingBlock60MinIntvl6MinSubIntvl: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.rollingBlock60MinIntvl6MinSubIntvl"""))
    val sixtyMinute: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.sixtyMinute"""))
    val tenMinute: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.tenMinute"""))
    val thirtyMinute: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.thirtyMinute"""))
    val threeMinute: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.threeMinute"""))
    val twentyMinute: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.twentyMinute"""))
    val twentyfourHour: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.twentyfourHour"""))
    val twoMinute: (Context) => String = parse_attribute (attribute ("""MeasuringPeriodKind.twoMinute"""))
    def parse (context: Context): MeasuringPeriodKind =
    {
        MeasuringPeriodKind(
            BasicElement.parse (context),
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

private[ninecode] object _ReadingTypeEnumerations
{
    def register: List[ClassInfo] =
    {
        List (
            AccumulationKind.register,
            AggregateKind.register,
            CommodityKind.register,
            FlowDirectionKind.register,
            MacroPeriodKind.register,
            MeasurementKind.register,
            MeasuringPeriodKind.register
        )
    }
}