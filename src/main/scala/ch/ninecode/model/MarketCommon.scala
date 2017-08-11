package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * This package contains the common objects shared by both MarketManagement and MarketOperations packages.
 */

/**
 * An identification of a party acting in a electricity market business process.
 * This class is used to identify organizations that can participate in market management and/or market operations.
 * @param sup Reference to the superclass object.
 * @param MarketDocument <em>undocumented</em>
 */
case class MarketParticipant
(
    override val sup: Organisation,
    MarketDocument: List[String]
)
extends
    Element
{
    def this () = { this (null, List()) }
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { clone ().asInstanceOf[MarketParticipant] }
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
        (if (null != MarketDocument) MarketDocument.map (x => "\t\t<cim:MarketParticipant.MarketDocument rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:MarketParticipant rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketParticipant>"
    }
}

object MarketParticipant
extends
    Parseable[MarketParticipant]
{
    val MarketDocument: (Context) => List[String] = parse_attributes (attribute ("""MarketParticipant.MarketDocument"""))
    def parse (context: Context): MarketParticipant =
    {
        MarketParticipant(
            Organisation.parse (context),
            MarketDocument (context)
        )
    }
}

/**
 * The external intended behaviour played by a party within the electricity market.
 * @param sup Reference to the superclass object.
 * @param roleType Defined using an enumerated list of types of market roles for use when a finite list of types are desired.
 * @param status Status of the market role.
 * @param typ The kind of market roles that can be played by parties for given domains within the electricity market.
 *        Types are flexible using dataType of string for free-entry of role types.
 * @param MarketParticipant <em>undocumented</em>
 */
case class MarketRole
(
    override val sup: IdentifiedObject,
    roleType: String,
    status: String,
    typ: String,
    MarketParticipant: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MarketRole] }
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
        (if (null != roleType) "\t\t<cim:MarketRole.roleType rdf:resource=\"#" + roleType + "\"/>\n" else "") +
        (if (null != status) "\t\t<cim:MarketRole.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:MarketRole.type>" + typ + "</cim:MarketRole.type>\n" else "") +
        (if (null != MarketParticipant) MarketParticipant.map (x => "\t\t<cim:MarketRole.MarketParticipant rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:MarketRole rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketRole>"
    }
}

object MarketRole
extends
    Parseable[MarketRole]
{
    val roleType: (Context) => String = parse_attribute (attribute ("""MarketRole.roleType"""))
    val status: (Context) => String = parse_attribute (attribute ("""MarketRole.status"""))
    val typ: (Context) => String = parse_element (element ("""MarketRole.type"""))
    val MarketParticipant: (Context) => List[String] = parse_attributes (attribute ("""MarketRole.MarketParticipant"""))
    def parse (context: Context): MarketRole =
    {
        MarketRole(
            IdentifiedObject.parse (context),
            roleType (context),
            status (context),
            typ (context),
            MarketParticipant (context)
        )
    }
}

/**
 * A resource that is registered through the market participant registration system.
 * Examples include generating unit, load, and non-physical generator or load.
 * @param sup Reference to the superclass object.
 * @param commercialOpDate Resource Commercial Operation Date.
 * @param contingencyAvailFlag contingent operating reserve availiability (Yes/No).
 *        Resource is availiable to participate with capacity in contingency dispatch.
 * @param dispatchFlag Dispatch flag: indicates whether the resource is dispatchable (Y/N)
 *        It is move to the RegisteredResource class for the participating load dispatch purpose
 * @param endEffectiveDate end effective date
 * @param flexibleOfferFlag flexible offer flag (Y/N)
 * @param hourlyPredispatch Indicates need to dispatch before the start of the operating hour.
 *        Only relevent in Real-Time Market. Applies to generation, intertie and participating load resource. Value (Y/N)
 * @param isAggregatedRes a flag to indicate if a resource is an aggregated resource
 * @param lastModified Indication of the last time this item was modified/versioned.
 * @param marketParticipationFlag Market Participation flag: indicates whether the resource participate in the market (Y/N)
 * @param maxBaseSelfSchedQty_1 maximum base self schedule quantity
 * @param maxOnTime maximum on time after start up
 * @param minDispatchTime minimum number of consecutive hours a resource shall be dispatched if bid is accepted
 * @param minOffTime minimum off time after shut  down
 * @param minOnTime minimum on time after start up
 * @param mustOfferFlag Must offer flag: indicates whether the unit is subject to the must offer provisions (Y/N)
 * @param nonMarket Flag to indicate that the Resource is not participating in the Market Operations.
 * @param pointOfDeliveryFlag Indication that the registered resource is a Point of Delivery (YES) resource which implies there is a POD Loss Factor.
 * @param priceSetFlagDA Price setting flag: indicates whether a resource is capable of setting the Market Clearing Price (Y) for the DA market, and if not, indicates whether the resource shall submit bids for energy at $ 0 (S) or not (N)

Initially in the RegisteredGenerator class.
 *        It wasmove to the RegisteredResource class for the participating load dispatch purpose
 * @param priceSetFlagRT Price setting flag: indicates whether a resource is capable of setting the Market Clearing Price (Y) for the RT market, and if not, indicates whether the resource shall submit bids for energy at $ 0 (S) or not (N)

Initially in the RegisteredGenerator class.
 *        It wasmove to the RegisteredResource class for the participating load dispatch purpose
 * @param registrationStatus Registration Status of resource - Active, Mothballed, Planned, or Decommissioned.
 * @param resourceAdequacyFlag Indication that this resource participates inthe resource adequacy function.
 * @param startEffectiveDate start effective date
 * @param ACAFlag Indication that this resource is associated with an Adjacent Control Area
 * @param ASSPOptimizationFlag Indication that the resource participates in the optimization process by default.
 * @param AdjacentCASet <em>undocumented</em>
 * @param AggregateNode <em>undocumented</em>
 * @param DefaultBid <em>undocumented</em>
 * @param ECAFlag Indication that this resource is associated with an Embedded Control area
 * @param ForbiddenRegion <em>undocumented</em>
 * @param HostControlArea <em>undocumented</em>
 * @param InterTie <em>undocumented</em>
 * @param LMPMFlag LMPM flag: indicates whether the resource is subject to the LMPM test (Yes/No)
 * @param MktConnectivityNode <em>undocumented</em>
 * @param MktOrganisation <em>undocumented</em>
 * @param Pnode A registered resource injects power at one or more connectivity nodes related to a pnode
 * @param RampRateCurve <em>undocumented</em>
 * @param ResourceCapacity <em>undocumented</em>
 * @param ResourceCertification <em>undocumented</em>
 * @param ResourceVerifiableCosts <em>undocumented</em>
 * @param SMPMFlag SMPM flag: indicates whether the resource is subject to the SMPM test (Yes/No)
 * @param SubControlArea <em>undocumented</em>
 * @param TimeSeries <em>undocumented</em>
 */
case class RegisteredResource
(
    override val sup: PowerSystemResource,
    commercialOpDate: String,
    contingencyAvailFlag: String,
    dispatchFlag: String,
    endEffectiveDate: String,
    flexibleOfferFlag: String,
    hourlyPredispatch: String,
    isAggregatedRes: String,
    lastModified: String,
    marketParticipationFlag: String,
    maxBaseSelfSchedQty_1: Double,
    maxOnTime: Double,
    minDispatchTime: Double,
    minOffTime: Double,
    minOnTime: Double,
    mustOfferFlag: String,
    nonMarket: String,
    pointOfDeliveryFlag: String,
    priceSetFlagDA: String,
    priceSetFlagRT: String,
    registrationStatus: String,
    resourceAdequacyFlag: String,
    startEffectiveDate: String,
    ACAFlag: String,
    ASSPOptimizationFlag: String,
    AdjacentCASet: String,
    AggregateNode: List[String],
    DefaultBid: String,
    ECAFlag: String,
    ForbiddenRegion: List[String],
    HostControlArea: String,
    InterTie: List[String],
    LMPMFlag: String,
    MktConnectivityNode: String,
    MktOrganisation: String,
    Pnode: String,
    RampRateCurve: List[String],
    ResourceCapacity: List[String],
    ResourceCertification: List[String],
    ResourceVerifiableCosts: String,
    SMPMFlag: String,
    SubControlArea: List[String],
    TimeSeries: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null, null, null, null, null, null, null, null, null, List(), null, null, List(), null, List(), null, null, null, null, List(), List(), List(), null, null, List(), List()) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[RegisteredResource] }
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
        (if (null != commercialOpDate) "\t\t<cim:RegisteredResource.commercialOpDate>" + commercialOpDate + "</cim:RegisteredResource.commercialOpDate>\n" else "") +
        (if (null != contingencyAvailFlag) "\t\t<cim:RegisteredResource.contingencyAvailFlag rdf:resource=\"#" + contingencyAvailFlag + "\"/>\n" else "") +
        (if (null != dispatchFlag) "\t\t<cim:RegisteredResource.dispatchFlag rdf:resource=\"#" + dispatchFlag + "\"/>\n" else "") +
        (if (null != endEffectiveDate) "\t\t<cim:RegisteredResource.endEffectiveDate>" + endEffectiveDate + "</cim:RegisteredResource.endEffectiveDate>\n" else "") +
        (if (null != flexibleOfferFlag) "\t\t<cim:RegisteredResource.flexibleOfferFlag rdf:resource=\"#" + flexibleOfferFlag + "\"/>\n" else "") +
        (if (null != hourlyPredispatch) "\t\t<cim:RegisteredResource.hourlyPredispatch rdf:resource=\"#" + hourlyPredispatch + "\"/>\n" else "") +
        (if (null != isAggregatedRes) "\t\t<cim:RegisteredResource.isAggregatedRes rdf:resource=\"#" + isAggregatedRes + "\"/>\n" else "") +
        (if (null != lastModified) "\t\t<cim:RegisteredResource.lastModified>" + lastModified + "</cim:RegisteredResource.lastModified>\n" else "") +
        (if (null != marketParticipationFlag) "\t\t<cim:RegisteredResource.marketParticipationFlag rdf:resource=\"#" + marketParticipationFlag + "\"/>\n" else "") +
        "\t\t<cim:RegisteredResource.maxBaseSelfSchedQty >" + maxBaseSelfSchedQty_1 + "</cim:RegisteredResource.maxBaseSelfSchedQty >\n" +
        "\t\t<cim:RegisteredResource.maxOnTime>" + maxOnTime + "</cim:RegisteredResource.maxOnTime>\n" +
        "\t\t<cim:RegisteredResource.minDispatchTime>" + minDispatchTime + "</cim:RegisteredResource.minDispatchTime>\n" +
        "\t\t<cim:RegisteredResource.minOffTime>" + minOffTime + "</cim:RegisteredResource.minOffTime>\n" +
        "\t\t<cim:RegisteredResource.minOnTime>" + minOnTime + "</cim:RegisteredResource.minOnTime>\n" +
        (if (null != mustOfferFlag) "\t\t<cim:RegisteredResource.mustOfferFlag rdf:resource=\"#" + mustOfferFlag + "\"/>\n" else "") +
        (if (null != nonMarket) "\t\t<cim:RegisteredResource.nonMarket rdf:resource=\"#" + nonMarket + "\"/>\n" else "") +
        (if (null != pointOfDeliveryFlag) "\t\t<cim:RegisteredResource.pointOfDeliveryFlag rdf:resource=\"#" + pointOfDeliveryFlag + "\"/>\n" else "") +
        (if (null != priceSetFlagDA) "\t\t<cim:RegisteredResource.priceSetFlagDA rdf:resource=\"#" + priceSetFlagDA + "\"/>\n" else "") +
        (if (null != priceSetFlagRT) "\t\t<cim:RegisteredResource.priceSetFlagRT rdf:resource=\"#" + priceSetFlagRT + "\"/>\n" else "") +
        (if (null != registrationStatus) "\t\t<cim:RegisteredResource.registrationStatus rdf:resource=\"#" + registrationStatus + "\"/>\n" else "") +
        (if (null != resourceAdequacyFlag) "\t\t<cim:RegisteredResource.resourceAdequacyFlag rdf:resource=\"#" + resourceAdequacyFlag + "\"/>\n" else "") +
        (if (null != startEffectiveDate) "\t\t<cim:RegisteredResource.startEffectiveDate>" + startEffectiveDate + "</cim:RegisteredResource.startEffectiveDate>\n" else "") +
        (if (null != ACAFlag) "\t\t<cim:RegisteredResource.ACAFlag rdf:resource=\"#" + ACAFlag + "\"/>\n" else "") +
        (if (null != ASSPOptimizationFlag) "\t\t<cim:RegisteredResource.ASSPOptimizationFlag rdf:resource=\"#" + ASSPOptimizationFlag + "\"/>\n" else "") +
        (if (null != AdjacentCASet) "\t\t<cim:RegisteredResource.AdjacentCASet rdf:resource=\"#" + AdjacentCASet + "\"/>\n" else "") +
        (if (null != AggregateNode) AggregateNode.map (x => "\t\t<cim:RegisteredResource.AggregateNode rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != DefaultBid) "\t\t<cim:RegisteredResource.DefaultBid rdf:resource=\"#" + DefaultBid + "\"/>\n" else "") +
        (if (null != ECAFlag) "\t\t<cim:RegisteredResource.ECAFlag rdf:resource=\"#" + ECAFlag + "\"/>\n" else "") +
        (if (null != ForbiddenRegion) ForbiddenRegion.map (x => "\t\t<cim:RegisteredResource.ForbiddenRegion rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != HostControlArea) "\t\t<cim:RegisteredResource.HostControlArea rdf:resource=\"#" + HostControlArea + "\"/>\n" else "") +
        (if (null != InterTie) InterTie.map (x => "\t\t<cim:RegisteredResource.InterTie rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != LMPMFlag) "\t\t<cim:RegisteredResource.LMPMFlag rdf:resource=\"#" + LMPMFlag + "\"/>\n" else "") +
        (if (null != MktConnectivityNode) "\t\t<cim:RegisteredResource.MktConnectivityNode rdf:resource=\"#" + MktConnectivityNode + "\"/>\n" else "") +
        (if (null != MktOrganisation) "\t\t<cim:RegisteredResource.MktOrganisation rdf:resource=\"#" + MktOrganisation + "\"/>\n" else "") +
        (if (null != Pnode) "\t\t<cim:RegisteredResource.Pnode rdf:resource=\"#" + Pnode + "\"/>\n" else "") +
        (if (null != RampRateCurve) RampRateCurve.map (x => "\t\t<cim:RegisteredResource.RampRateCurve rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ResourceCapacity) ResourceCapacity.map (x => "\t\t<cim:RegisteredResource.ResourceCapacity rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ResourceCertification) ResourceCertification.map (x => "\t\t<cim:RegisteredResource.ResourceCertification rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ResourceVerifiableCosts) "\t\t<cim:RegisteredResource.ResourceVerifiableCosts rdf:resource=\"#" + ResourceVerifiableCosts + "\"/>\n" else "") +
        (if (null != SMPMFlag) "\t\t<cim:RegisteredResource.SMPMFlag rdf:resource=\"#" + SMPMFlag + "\"/>\n" else "") +
        (if (null != SubControlArea) SubControlArea.map (x => "\t\t<cim:RegisteredResource.SubControlArea rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != TimeSeries) TimeSeries.map (x => "\t\t<cim:RegisteredResource.TimeSeries rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:RegisteredResource rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RegisteredResource>"
    }
}

object RegisteredResource
extends
    Parseable[RegisteredResource]
{
    val commercialOpDate: (Context) => String = parse_element (element ("""RegisteredResource.commercialOpDate"""))
    val contingencyAvailFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.contingencyAvailFlag"""))
    val dispatchFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.dispatchFlag"""))
    val endEffectiveDate: (Context) => String = parse_element (element ("""RegisteredResource.endEffectiveDate"""))
    val flexibleOfferFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.flexibleOfferFlag"""))
    val hourlyPredispatch: (Context) => String = parse_attribute (attribute ("""RegisteredResource.hourlyPredispatch"""))
    val isAggregatedRes: (Context) => String = parse_attribute (attribute ("""RegisteredResource.isAggregatedRes"""))
    val lastModified: (Context) => String = parse_element (element ("""RegisteredResource.lastModified"""))
    val marketParticipationFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.marketParticipationFlag"""))
    val maxBaseSelfSchedQty_1: (Context) => String = parse_element (element ("""RegisteredResource.maxBaseSelfSchedQty """))
    val maxOnTime: (Context) => String = parse_element (element ("""RegisteredResource.maxOnTime"""))
    val minDispatchTime: (Context) => String = parse_element (element ("""RegisteredResource.minDispatchTime"""))
    val minOffTime: (Context) => String = parse_element (element ("""RegisteredResource.minOffTime"""))
    val minOnTime: (Context) => String = parse_element (element ("""RegisteredResource.minOnTime"""))
    val mustOfferFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.mustOfferFlag"""))
    val nonMarket: (Context) => String = parse_attribute (attribute ("""RegisteredResource.nonMarket"""))
    val pointOfDeliveryFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.pointOfDeliveryFlag"""))
    val priceSetFlagDA: (Context) => String = parse_attribute (attribute ("""RegisteredResource.priceSetFlagDA"""))
    val priceSetFlagRT: (Context) => String = parse_attribute (attribute ("""RegisteredResource.priceSetFlagRT"""))
    val registrationStatus: (Context) => String = parse_attribute (attribute ("""RegisteredResource.registrationStatus"""))
    val resourceAdequacyFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.resourceAdequacyFlag"""))
    val startEffectiveDate: (Context) => String = parse_element (element ("""RegisteredResource.startEffectiveDate"""))
    val ACAFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.ACAFlag"""))
    val ASSPOptimizationFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.ASSPOptimizationFlag"""))
    val AdjacentCASet: (Context) => String = parse_attribute (attribute ("""RegisteredResource.AdjacentCASet"""))
    val AggregateNode: (Context) => List[String] = parse_attributes (attribute ("""RegisteredResource.AggregateNode"""))
    val DefaultBid: (Context) => String = parse_attribute (attribute ("""RegisteredResource.DefaultBid"""))
    val ECAFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.ECAFlag"""))
    val ForbiddenRegion: (Context) => List[String] = parse_attributes (attribute ("""RegisteredResource.ForbiddenRegion"""))
    val HostControlArea: (Context) => String = parse_attribute (attribute ("""RegisteredResource.HostControlArea"""))
    val InterTie: (Context) => List[String] = parse_attributes (attribute ("""RegisteredResource.InterTie"""))
    val LMPMFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.LMPMFlag"""))
    val MktConnectivityNode: (Context) => String = parse_attribute (attribute ("""RegisteredResource.MktConnectivityNode"""))
    val MktOrganisation: (Context) => String = parse_attribute (attribute ("""RegisteredResource.MktOrganisation"""))
    val Pnode: (Context) => String = parse_attribute (attribute ("""RegisteredResource.Pnode"""))
    val RampRateCurve: (Context) => List[String] = parse_attributes (attribute ("""RegisteredResource.RampRateCurve"""))
    val ResourceCapacity: (Context) => List[String] = parse_attributes (attribute ("""RegisteredResource.ResourceCapacity"""))
    val ResourceCertification: (Context) => List[String] = parse_attributes (attribute ("""RegisteredResource.ResourceCertification"""))
    val ResourceVerifiableCosts: (Context) => String = parse_attribute (attribute ("""RegisteredResource.ResourceVerifiableCosts"""))
    val SMPMFlag: (Context) => String = parse_attribute (attribute ("""RegisteredResource.SMPMFlag"""))
    val SubControlArea: (Context) => List[String] = parse_attributes (attribute ("""RegisteredResource.SubControlArea"""))
    val TimeSeries: (Context) => List[String] = parse_attributes (attribute ("""RegisteredResource.TimeSeries"""))
    def parse (context: Context): RegisteredResource =
    {
        RegisteredResource(
            PowerSystemResource.parse (context),
            commercialOpDate (context),
            contingencyAvailFlag (context),
            dispatchFlag (context),
            endEffectiveDate (context),
            flexibleOfferFlag (context),
            hourlyPredispatch (context),
            isAggregatedRes (context),
            lastModified (context),
            marketParticipationFlag (context),
            toDouble (maxBaseSelfSchedQty_1 (context), context),
            toDouble (maxOnTime (context), context),
            toDouble (minDispatchTime (context), context),
            toDouble (minOffTime (context), context),
            toDouble (minOnTime (context), context),
            mustOfferFlag (context),
            nonMarket (context),
            pointOfDeliveryFlag (context),
            priceSetFlagDA (context),
            priceSetFlagRT (context),
            registrationStatus (context),
            resourceAdequacyFlag (context),
            startEffectiveDate (context),
            ACAFlag (context),
            ASSPOptimizationFlag (context),
            AdjacentCASet (context),
            AggregateNode (context),
            DefaultBid (context),
            ECAFlag (context),
            ForbiddenRegion (context),
            HostControlArea (context),
            InterTie (context),
            LMPMFlag (context),
            MktConnectivityNode (context),
            MktOrganisation (context),
            Pnode (context),
            RampRateCurve (context),
            ResourceCapacity (context),
            ResourceCertification (context),
            ResourceVerifiableCosts (context),
            SMPMFlag (context),
            SubControlArea (context),
            TimeSeries (context)
        )
    }
}

private[ninecode] object _MarketCommon
{
    def register: List[ClassInfo] =
    {
        List (
            MarketParticipant.register,
            MarketRole.register,
            RegisteredResource.register
        )
    }
}