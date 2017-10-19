package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * An identification of a party acting in a electricity market business process.
 *
 * This class is used to identify organizations that can participate in market management and/or market operations.
 *
 * @param sup [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by both MarketManagement and MarketOperations packages.
 */
case class MarketParticipant
(
    override val sup: Organisation,
    MarketDocument: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketParticipant.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MarketParticipant.fields (position), x))
        emitattrs (0, MarketDocument)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketParticipant rdf:ID=\"%s\">\n%s\t</cim:MarketParticipant>".format (id, export_fields)
    }
}

object MarketParticipant
extends
    Parseable[MarketParticipant]
{
    val fields: Array[String] = Array[String] (
        "MarketDocument"
    )
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): MarketParticipant =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def masks (field: Fields, position: Int): List[String] = { if (field._2) fields |= 1 << position; field._1 }
        val ret = MarketParticipant (
            Organisation.parse (context),
            masks (MarketDocument (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MarketDocument", "MarketDocument", true)
    )
}

/**
 * The external intended behaviour played by a party within the electricity market.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param roleType Defined using an enumerated list of types of market roles for use when a finite list of types are desired.
 * @param status Status of the market role.
 * @param typ The kind of market roles that can be played by parties for given domains within the electricity market.
 *        Types are flexible using dataType of string for free-entry of role types.
 * @param MarketParticipant [[ch.ninecode.model.MarketParticipant MarketParticipant]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by both MarketManagement and MarketOperations packages.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List()) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketRole.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketRole.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketRole.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MarketRole.fields (position), x))
        emitattr (0, roleType)
        emitattr (1, status)
        emitelem (2, typ)
        emitattrs (3, MarketParticipant)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketRole rdf:ID=\"%s\">\n%s\t</cim:MarketRole>".format (id, export_fields)
    }
}

object MarketRole
extends
    Parseable[MarketRole]
{
    val fields: Array[String] = Array[String] (
        "roleType",
        "status",
        "type",
        "MarketParticipant"
    )
    val roleType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val status: Fielder = parse_attribute (attribute (cls, fields(1)))
    val typ: Fielder = parse_element (element (cls, fields(2)))
    val MarketParticipant: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): MarketRole =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        def masks (field: Fields, position: Int): List[String] = { if (field._2) fields |= 1 << position; field._1 }
        val ret = MarketRole (
            IdentifiedObject.parse (context),
            mask (roleType (), 0),
            mask (status (), 1),
            mask (typ (), 2),
            masks (MarketParticipant (), 3)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MarketParticipant", "MarketParticipant", true)
    )
}

/**
 * A resource that is registered through the market participant registration system.
 *
 * Examples include generating unit, load, and non-physical generator or load.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
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
 * @param priceSetFlagDA Price setting flag: indicates whether a resource is capable of setting the Market Clearing Price (Y) for the DA market, and if not, indicates whether the resource shall submit bids for energy at \$ 0 (S) or not (N)
 *        
 *        Initially in the RegisteredGenerator class.
 *        It wasmove to the RegisteredResource class for the participating load dispatch purpose
 * @param priceSetFlagRT Price setting flag: indicates whether a resource is capable of setting the Market Clearing Price (Y) for the RT market, and if not, indicates whether the resource shall submit bids for energy at \$ 0 (S) or not (N)
 *        
 *        Initially in the RegisteredGenerator class.
 *        It wasmove to the RegisteredResource class for the participating load dispatch purpose
 * @param registrationStatus Registration Status of resource - Active, Mothballed, Planned, or Decommissioned.
 * @param resourceAdequacyFlag Indication that this resource participates inthe resource adequacy function.
 * @param startEffectiveDate start effective date
 * @param ACAFlag Indication that this resource is associated with an Adjacent Control Area
 * @param ASSPOptimizationFlag Indication that the resource participates in the optimization process by default.
 * @param AdjacentCASet [[ch.ninecode.model.AdjacentCASet AdjacentCASet]] <em>undocumented</em>
 * @param AggregateNode [[ch.ninecode.model.AggregateNode AggregateNode]] <em>undocumented</em>
 * @param DefaultBid [[ch.ninecode.model.DefaultBid DefaultBid]] <em>undocumented</em>
 * @param ECAFlag Indication that this resource is associated with an Embedded Control area
 * @param ForbiddenRegion [[ch.ninecode.model.ForbiddenRegion ForbiddenRegion]] <em>undocumented</em>
 * @param HostControlArea [[ch.ninecode.model.HostControlArea HostControlArea]] <em>undocumented</em>
 * @param InterTie [[ch.ninecode.model.SchedulingPoint SchedulingPoint]] <em>undocumented</em>
 * @param LMPMFlag LMPM flag: indicates whether the resource is subject to the LMPM test (Yes/No)
 * @param MktConnectivityNode [[ch.ninecode.model.MktConnectivityNode MktConnectivityNode]] <em>undocumented</em>
 * @param MktOrganisation [[ch.ninecode.model.MktOrganisation MktOrganisation]] <em>undocumented</em>
 * @param Pnode [[ch.ninecode.model.Pnode Pnode]] A registered resource injects power at one or more connectivity nodes related to a pnode
 * @param RampRateCurve [[ch.ninecode.model.RampRateCurve RampRateCurve]] <em>undocumented</em>
 * @param ResourceCapacity [[ch.ninecode.model.ResourceCapacity ResourceCapacity]] <em>undocumented</em>
 * @param ResourceCertification [[ch.ninecode.model.ResourceCertification ResourceCertification]] <em>undocumented</em>
 * @param ResourceVerifiableCosts [[ch.ninecode.model.ResourceVerifiableCosts ResourceVerifiableCosts]] <em>undocumented</em>
 * @param SMPMFlag SMPM flag: indicates whether the resource is subject to the SMPM test (Yes/No)
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketCommon
 * @groupname MarketCommon Package MarketCommon
 * @groupdesc MarketCommon This package contains the common objects shared by both MarketManagement and MarketOperations packages.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null, null, null, null, null, null, null, null, null, List(), null, null, List(), null, List(), null, null, null, null, List(), List(), List(), null, null, List(), List()) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Long = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RegisteredResource.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegisteredResource.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegisteredResource.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (RegisteredResource.fields (position), x))
        emitelem (0, commercialOpDate)
        emitattr (1, contingencyAvailFlag)
        emitattr (2, dispatchFlag)
        emitelem (3, endEffectiveDate)
        emitattr (4, flexibleOfferFlag)
        emitattr (5, hourlyPredispatch)
        emitattr (6, isAggregatedRes)
        emitelem (7, lastModified)
        emitattr (8, marketParticipationFlag)
        emitelem (9, maxBaseSelfSchedQty_1)
        emitelem (10, maxOnTime)
        emitelem (11, minDispatchTime)
        emitelem (12, minOffTime)
        emitelem (13, minOnTime)
        emitattr (14, mustOfferFlag)
        emitattr (15, nonMarket)
        emitattr (16, pointOfDeliveryFlag)
        emitattr (17, priceSetFlagDA)
        emitattr (18, priceSetFlagRT)
        emitattr (19, registrationStatus)
        emitattr (20, resourceAdequacyFlag)
        emitelem (21, startEffectiveDate)
        emitattr (22, ACAFlag)
        emitattr (23, ASSPOptimizationFlag)
        emitattr (24, AdjacentCASet)
        emitattrs (25, AggregateNode)
        emitattr (26, DefaultBid)
        emitattr (27, ECAFlag)
        emitattrs (28, ForbiddenRegion)
        emitattr (29, HostControlArea)
        emitattrs (30, InterTie)
        emitattr (31, LMPMFlag)
        emitattr (32, MktConnectivityNode)
        emitattr (33, MktOrganisation)
        emitattr (34, Pnode)
        emitattrs (35, RampRateCurve)
        emitattrs (36, ResourceCapacity)
        emitattrs (37, ResourceCertification)
        emitattr (38, ResourceVerifiableCosts)
        emitattr (39, SMPMFlag)
        emitattrs (40, SubControlArea)
        emitattrs (41, TimeSeries)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RegisteredResource rdf:ID=\"%s\">\n%s\t</cim:RegisteredResource>".format (id, export_fields)
    }
}

object RegisteredResource
extends
    Parseable[RegisteredResource]
{
    val fields: Array[String] = Array[String] (
        "commercialOpDate",
        "contingencyAvailFlag",
        "dispatchFlag",
        "endEffectiveDate",
        "flexibleOfferFlag",
        "hourlyPredispatch",
        "isAggregatedRes",
        "lastModified",
        "marketParticipationFlag",
        "maxBaseSelfSchedQty ",
        "maxOnTime",
        "minDispatchTime",
        "minOffTime",
        "minOnTime",
        "mustOfferFlag",
        "nonMarket",
        "pointOfDeliveryFlag",
        "priceSetFlagDA",
        "priceSetFlagRT",
        "registrationStatus",
        "resourceAdequacyFlag",
        "startEffectiveDate",
        "ACAFlag",
        "ASSPOptimizationFlag",
        "AdjacentCASet",
        "AggregateNode",
        "DefaultBid",
        "ECAFlag",
        "ForbiddenRegion",
        "HostControlArea",
        "InterTie",
        "LMPMFlag",
        "MktConnectivityNode",
        "MktOrganisation",
        "Pnode",
        "RampRateCurve",
        "ResourceCapacity",
        "ResourceCertification",
        "ResourceVerifiableCosts",
        "SMPMFlag",
        "SubControlArea",
        "TimeSeries"
    )
    val commercialOpDate: Fielder = parse_element (element (cls, fields(0)))
    val contingencyAvailFlag: Fielder = parse_attribute (attribute (cls, fields(1)))
    val dispatchFlag: Fielder = parse_attribute (attribute (cls, fields(2)))
    val endEffectiveDate: Fielder = parse_element (element (cls, fields(3)))
    val flexibleOfferFlag: Fielder = parse_attribute (attribute (cls, fields(4)))
    val hourlyPredispatch: Fielder = parse_attribute (attribute (cls, fields(5)))
    val isAggregatedRes: Fielder = parse_attribute (attribute (cls, fields(6)))
    val lastModified: Fielder = parse_element (element (cls, fields(7)))
    val marketParticipationFlag: Fielder = parse_attribute (attribute (cls, fields(8)))
    val maxBaseSelfSchedQty_1: Fielder = parse_element (element (cls, fields(9)))
    val maxOnTime: Fielder = parse_element (element (cls, fields(10)))
    val minDispatchTime: Fielder = parse_element (element (cls, fields(11)))
    val minOffTime: Fielder = parse_element (element (cls, fields(12)))
    val minOnTime: Fielder = parse_element (element (cls, fields(13)))
    val mustOfferFlag: Fielder = parse_attribute (attribute (cls, fields(14)))
    val nonMarket: Fielder = parse_attribute (attribute (cls, fields(15)))
    val pointOfDeliveryFlag: Fielder = parse_attribute (attribute (cls, fields(16)))
    val priceSetFlagDA: Fielder = parse_attribute (attribute (cls, fields(17)))
    val priceSetFlagRT: Fielder = parse_attribute (attribute (cls, fields(18)))
    val registrationStatus: Fielder = parse_attribute (attribute (cls, fields(19)))
    val resourceAdequacyFlag: Fielder = parse_attribute (attribute (cls, fields(20)))
    val startEffectiveDate: Fielder = parse_element (element (cls, fields(21)))
    val ACAFlag: Fielder = parse_attribute (attribute (cls, fields(22)))
    val ASSPOptimizationFlag: Fielder = parse_attribute (attribute (cls, fields(23)))
    val AdjacentCASet: Fielder = parse_attribute (attribute (cls, fields(24)))
    val AggregateNode: FielderMultiple = parse_attributes (attribute (cls, fields(25)))
    val DefaultBid: Fielder = parse_attribute (attribute (cls, fields(26)))
    val ECAFlag: Fielder = parse_attribute (attribute (cls, fields(27)))
    val ForbiddenRegion: FielderMultiple = parse_attributes (attribute (cls, fields(28)))
    val HostControlArea: Fielder = parse_attribute (attribute (cls, fields(29)))
    val InterTie: FielderMultiple = parse_attributes (attribute (cls, fields(30)))
    val LMPMFlag: Fielder = parse_attribute (attribute (cls, fields(31)))
    val MktConnectivityNode: Fielder = parse_attribute (attribute (cls, fields(32)))
    val MktOrganisation: Fielder = parse_attribute (attribute (cls, fields(33)))
    val Pnode: Fielder = parse_attribute (attribute (cls, fields(34)))
    val RampRateCurve: FielderMultiple = parse_attributes (attribute (cls, fields(35)))
    val ResourceCapacity: FielderMultiple = parse_attributes (attribute (cls, fields(36)))
    val ResourceCertification: FielderMultiple = parse_attributes (attribute (cls, fields(37)))
    val ResourceVerifiableCosts: Fielder = parse_attribute (attribute (cls, fields(38)))
    val SMPMFlag: Fielder = parse_attribute (attribute (cls, fields(39)))
    val SubControlArea: FielderMultiple = parse_attributes (attribute (cls, fields(40)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(41)))

    def parse (context: Context): RegisteredResource =
    {
        implicit val ctx: Context = context
        var fields: Long = 0L
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1L << position; field._1 }
        def masks (field: Fields, position: Int): List[String] = { if (field._2) fields |= 1 << position; field._1 }
        val ret = RegisteredResource (
            PowerSystemResource.parse (context),
            mask (commercialOpDate (), 0),
            mask (contingencyAvailFlag (), 1),
            mask (dispatchFlag (), 2),
            mask (endEffectiveDate (), 3),
            mask (flexibleOfferFlag (), 4),
            mask (hourlyPredispatch (), 5),
            mask (isAggregatedRes (), 6),
            mask (lastModified (), 7),
            mask (marketParticipationFlag (), 8),
            toDouble (mask (maxBaseSelfSchedQty_1 (), 9)),
            toDouble (mask (maxOnTime (), 10)),
            toDouble (mask (minDispatchTime (), 11)),
            toDouble (mask (minOffTime (), 12)),
            toDouble (mask (minOnTime (), 13)),
            mask (mustOfferFlag (), 14),
            mask (nonMarket (), 15),
            mask (pointOfDeliveryFlag (), 16),
            mask (priceSetFlagDA (), 17),
            mask (priceSetFlagRT (), 18),
            mask (registrationStatus (), 19),
            mask (resourceAdequacyFlag (), 20),
            mask (startEffectiveDate (), 21),
            mask (ACAFlag (), 22),
            mask (ASSPOptimizationFlag (), 23),
            mask (AdjacentCASet (), 24),
            masks (AggregateNode (), 25),
            mask (DefaultBid (), 26),
            mask (ECAFlag (), 27),
            masks (ForbiddenRegion (), 28),
            mask (HostControlArea (), 29),
            masks (InterTie (), 30),
            mask (LMPMFlag (), 31),
            mask (MktConnectivityNode (), 32),
            mask (MktOrganisation (), 33),
            mask (Pnode (), 34),
            masks (RampRateCurve (), 35),
            masks (ResourceCapacity (), 36),
            masks (ResourceCertification (), 37),
            mask (ResourceVerifiableCosts (), 38),
            mask (SMPMFlag (), 39),
            masks (SubControlArea (), 40),
            masks (TimeSeries (), 41)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AdjacentCASet", "AdjacentCASet", false),
        Relationship ("AggregateNode", "AggregateNode", true),
        Relationship ("DefaultBid", "DefaultBid", false),
        Relationship ("ForbiddenRegion", "ForbiddenRegion", true),
        Relationship ("HostControlArea", "HostControlArea", false),
        Relationship ("InterTie", "SchedulingPoint", true),
        Relationship ("MktConnectivityNode", "MktConnectivityNode", false),
        Relationship ("MktOrganisation", "MktOrganisation", false),
        Relationship ("Pnode", "Pnode", false),
        Relationship ("RampRateCurve", "RampRateCurve", true),
        Relationship ("ResourceCapacity", "ResourceCapacity", true),
        Relationship ("ResourceCertification", "ResourceCertification", true),
        Relationship ("ResourceVerifiableCosts", "ResourceVerifiableCosts", false),
        Relationship ("SubControlArea", "SubControlArea", true),
        Relationship ("TimeSeries", "TimeSeries", true)
    )
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