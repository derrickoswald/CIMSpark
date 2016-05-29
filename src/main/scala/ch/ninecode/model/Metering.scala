package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

case class UsagePoint
(
    override val sup: Element,
    // val amiBillingReady: String, Implementation restriction: case classes cannot have more than 22 parameters.
    val checkBilling: Boolean,
    val connectionState: String,
    val estimatedLoad: Double,
    val grounded: Boolean,
    val isSdp: Boolean,
    val isVirtual: Boolean,
    val minimalUsageExpected: Boolean,
    val nominalServiceVoltage: Double,
    val outageRegion: String,
    val phaseCode: String,
    val ratedCurrent: Double,
    val ratedPower: Double,
    val readCycle: String,
    val readRoute: String,
    val serviceDeliveryRemark: String,
    val servicePriority: String,
    val CustomerAgreement: String,
    val ServiceCategory: String,
    val ServiceLocation: String,
    val ServiceSupplier: String,
    val UsagePointLocation: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[UsagePoint]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UsagePoint
extends
    Parseable[UsagePoint]
with
    Parser
{
    //val amiBillingReady = parse_element (element ("""UsagePoint.amiBillingReady"""))_
    val checkBilling = parse_element (element ("""UsagePoint.checkBilling"""))_
    val connectionState = parse_element (element ("""UsagePoint.connectionState"""))_
    val estimatedLoad = parse_element (element ("""UsagePoint.estimatedLoad"""))_
    val grounded = parse_element (element ("""UsagePoint.grounded"""))_
    val isSdp = parse_element (element ("""UsagePoint.isSdp"""))_
    val isVirtual = parse_element (element ("""UsagePoint.isSdp"""))_
    val minimalUsageExpected = parse_element (element ("""UsagePoint.minimalUsageExpected"""))_
    val nominalServiceVoltage = parse_element (element ("""UsagePoint.nominalServiceVoltage"""))_
    val outageRegion = parse_element (element ("""UsagePoint.outageRegion"""))_
    val phaseCode = parse_element (element ("""UsagePoint.phaseCode"""))_
    val ratedCurrent = parse_element (element ("""UsagePoint.ratedCurrent"""))_
    val ratedPower = parse_element (element ("""UsagePoint.ratedPower"""))_
    val readCycle = parse_element (element ("""UsagePoint.readCycle"""))_
    val readRoute = parse_element (element ("""UsagePoint.readRoute"""))_
    val serviceDeliveryRemark = parse_element (element ("""UsagePoint.serviceDeliveryRemark"""))_
    val servicePriority = parse_element (element ("""UsagePoint.servicePriority"""))_
    val CustomerAgreement = parse_attribute (attribute ("""UsagePoint.CustomerAgreement"""))_
    val ServiceCategory = parse_attribute (attribute ("""UsagePoint.ServiceCategory"""))_
    val ServiceLocation = parse_attribute (attribute ("""UsagePoint.ServiceLocation"""))_
    val ServiceSupplier = parse_attribute (attribute ("""UsagePoint.ServiceSupplier"""))_
    val UsagePointLocation = parse_attribute (attribute ("""UsagePoint.UsagePointLocation"""))_
    def parse (context: Context): UsagePoint =
    {
        return (
            UsagePoint
            (
                IdentifiedObject.parse (context),
                //amiBillingReady (context),
                toBoolean (checkBilling (context), context),
                connectionState (context),
                toDouble (estimatedLoad (context), context),
                toBoolean (grounded (context), context),
                toBoolean (isSdp (context), context),
                toBoolean (isVirtual (context), context),
                toBoolean (minimalUsageExpected (context), context),
                toDouble (nominalServiceVoltage (context), context),
                outageRegion (context),
                phaseCode (context),
                toDouble (ratedCurrent (context), context),
                toDouble (ratedPower (context), context),
                readCycle (context),
                readRoute (context),
                serviceDeliveryRemark (context),
                servicePriority (context),
                CustomerAgreement (context),
                ServiceCategory (context),
                ServiceLocation (context),
                ServiceSupplier (context),
                UsagePointLocation (context)
            )
        )
    }
}

case class UsagePointLocation
(
    override val sup: Element,
    val accessMethod: String,
    val remark: String,
    val siteAccessProblem: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[UsagePointLocation]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UsagePointLocation
extends
    Parseable[UsagePointLocation]
with
    Parser
{
    val accessMethod = parse_element (element ("""UsagePointLocation.accessMethod"""))_
    val remark = parse_element (element ("""UsagePointLocation.remark"""))_
    val siteAccessProblem = parse_element (element ("""UsagePointLocation.siteAccessProblem"""))_
    def parse (context: Context): UsagePointLocation =
    {
        return (
            UsagePointLocation
            (
                Location.parse (context),
                accessMethod (context),
                remark (context),
                siteAccessProblem (context)
            )
        )
    }
}

object Metering
{
    def register: Unit =
    {
        UsagePoint.register
        UsagePointLocation.register
    }
}
