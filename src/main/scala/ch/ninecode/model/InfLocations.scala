package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * Demographic kind of a land property.
 * @param sup Reference to the superclass object.
 * @param other
 * @param rural
 * @param urban
 */
case class DemographicKind
(
    override val sup: Element,
    val other: String,
    val rural: String,
    val urban: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DemographicKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DemographicKind
extends
    Parseable[DemographicKind]
{
    val sup = BasicElement.parse _
    val other = parse_attribute (attribute ("""DemographicKind.other"""))
    val rural = parse_attribute (attribute ("""DemographicKind.rural"""))
    val urban = parse_attribute (attribute ("""DemographicKind.urban"""))
    def parse (context: Context): DemographicKind =
    {
        DemographicKind(
            sup (context),
            other (context),
            rural (context),
            urban (context)
        )
    }
}

/**
 * Information about a particular piece of (land) property such as its use.
 * Ownership of the property may be determined through associations to Organisations and/or ErpPersons.
 * @param sup Reference to the superclass object.
 * @param demographicKind Demographics around the site.
 * @param externalRecordReference Reference allocated by the governing organisation (such as municipality) to this piece of land that has a formal reference to Surveyor General's records.
 *        The governing organisation is specified in associated Organisation.
 * @param kind Kind of (land) property, categorised according to its main functional use from the utility's perspective.
 * @param status
 * @param AssetContainers
 * @param Locations The spatail description of a piece of property.
 */
case class LandProperty
(
    override val sup: Element,
    val demographicKind: String,
    val externalRecordReference: String,
    val kind: String,
    val status: String,
    val AssetContainers: List[String],
    val Locations: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, List(), List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[LandProperty]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LandProperty
extends
    Parseable[LandProperty]
{
    val sup = IdentifiedObject.parse _
    val demographicKind = parse_attribute (attribute ("""LandProperty.demographicKind"""))
    val externalRecordReference = parse_element (element ("""LandProperty.externalRecordReference"""))
    val kind = parse_attribute (attribute ("""LandProperty.kind"""))
    val status = parse_attribute (attribute ("""LandProperty.status"""))
    val AssetContainers = parse_attributes (attribute ("""LandProperty.AssetContainers"""))
    val Locations = parse_attributes (attribute ("""LandProperty.Locations"""))
    def parse (context: Context): LandProperty =
    {
        LandProperty(
            sup (context),
            demographicKind (context),
            externalRecordReference (context),
            kind (context),
            status (context),
            AssetContainers (context),
            Locations (context)
        )
    }
}

/**
 * Kind of (land) property.
 * @param sup Reference to the superclass object.
 * @param building Site enclosed within a building.
 * @param customerPremise Site with a customer.
 * @param depot Storehouse for supplies that also serves as a station for supporting crews.
 * @param external Property owned or used by an external party that is not a customer.
 * @param gridSupplyPoint Substation where the distribution and transmission networks meet and hence have mixed ownership and mixed operational control.
 * @param store Place of storage (e.g., a warehouse) to put aside, or accumulate, material and equipment for use when needed.
 * @param substation Transmission network switchyard.
 */
case class LandPropertyKind
(
    override val sup: Element,
    val building: String,
    val customerPremise: String,
    val depot: String,
    val external: String,
    val gridSupplyPoint: String,
    val store: String,
    val substation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[LandPropertyKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LandPropertyKind
extends
    Parseable[LandPropertyKind]
{
    val sup = BasicElement.parse _
    val building = parse_attribute (attribute ("""LandPropertyKind.building"""))
    val customerPremise = parse_attribute (attribute ("""LandPropertyKind.customerPremise"""))
    val depot = parse_attribute (attribute ("""LandPropertyKind.depot"""))
    val external = parse_attribute (attribute ("""LandPropertyKind.external"""))
    val gridSupplyPoint = parse_attribute (attribute ("""LandPropertyKind.gridSupplyPoint"""))
    val store = parse_attribute (attribute ("""LandPropertyKind.store"""))
    val substation = parse_attribute (attribute ("""LandPropertyKind.substation"""))
    def parse (context: Context): LandPropertyKind =
    {
        LandPropertyKind(
            sup (context),
            building (context),
            customerPremise (context),
            depot (context),
            external (context),
            gridSupplyPoint (context),
            store (context),
            substation (context)
        )
    }
}

/**
 * A grant provides a right, as defined by type, for a parcel of land.
 * Note that the association to Location, Asset, Organisation, etc. for the Grant is inherited from Agreement, a type of Document.
 * @param sup Reference to the superclass object.
 * @param propertyData Property related information that describes the Grant's land parcel.
 *        For example, it may be a deed book number, deed book page number, and parcel number.
 * @param LandProperty Land property this location grant applies to.
 */
case class LocationGrant
(
    override val sup: Element,
    val propertyData: String,
    val LandProperty: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { return (clone ().asInstanceOf[LocationGrant]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LocationGrant
extends
    Parseable[LocationGrant]
{
    val sup = Agreement.parse _
    val propertyData = parse_element (element ("""LocationGrant.propertyData"""))
    val LandProperty = parse_attribute (attribute ("""LocationGrant.LandProperty"""))
    def parse (context: Context): LocationGrant =
    {
        LocationGrant(
            sup (context),
            propertyData (context),
            LandProperty (context)
        )
    }
}

/**
 * This class is used for handling the accompanying annotations, time stamp, author, etc. of designs, drawings and maps.
 * A red line can be associated with any Location object.
 * @param sup Reference to the superclass object.
 * @param status
 */
case class RedLine
(
    override val sup: Element,
    val status: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[RedLine]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RedLine
extends
    Parseable[RedLine]
{
    val sup = IdentifiedObject.parse _
    val status = parse_attribute (attribute ("""RedLine.status"""))
    def parse (context: Context): RedLine =
    {
        RedLine(
            sup (context),
            status (context)
        )
    }
}

/**
 * A right-of-way (ROW) is for land where it is lawful to use for a public road, an electric power line, etc.
 * Note that the association to Location, Asset, Organisation, etc. for the Grant is inherited from Agreement, a type of Document.
 * @param sup Reference to the superclass object.
 * @param propertyData Property related information that describes the ROW's land parcel.
 *        For example, it may be a deed book number, deed book page number, and parcel number.
 * @param LandProperties All land properties this right of way applies to.
 */
case class RightOfWay
(
    override val sup: Element,
    val propertyData: String,
    val LandProperties: List[String]
)
extends
    Element
{
    def this () = { this (null, null, List()) }
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { return (clone ().asInstanceOf[RightOfWay]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RightOfWay
extends
    Parseable[RightOfWay]
{
    val sup = Agreement.parse _
    val propertyData = parse_element (element ("""RightOfWay.propertyData"""))
    val LandProperties = parse_attributes (attribute ("""RightOfWay.LandProperties"""))
    def parse (context: Context): RightOfWay =
    {
        RightOfWay(
            sup (context),
            propertyData (context),
            LandProperties (context)
        )
    }
}

/**
 * Route that is followed, for example by service crews.
 * @param sup Reference to the superclass object.
 * @param status
 * @param typ Classification by utility's work management standards and practices.
 * @param Locations
 */
case class Route
(
    override val sup: Element,
    val status: String,
    val typ: String,
    val Locations: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Route]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Route
extends
    Parseable[Route]
{
    val sup = IdentifiedObject.parse _
    val status = parse_attribute (attribute ("""Route.status"""))
    val typ = parse_element (element ("""Route.type"""))
    val Locations = parse_attributes (attribute ("""Route.Locations"""))
    def parse (context: Context): Route =
    {
        Route(
            sup (context),
            status (context),
            typ (context),
            Locations (context)
        )
    }
}

/**
 * Area divided off from other areas.
 * It may be part of the electrical network, a land area where special restrictions apply, weather areas, etc. For weather, it is an area where a set of relatively homogenous weather measurements apply.
 * @param sup Reference to the superclass object.
 * @param kind Kind of this zone.
 */
case class Zone
(
    override val sup: Element,
    val kind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Location: Location = sup.asInstanceOf[Location]
    override def copy (): Row = { return (clone ().asInstanceOf[Zone]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Zone
extends
    Parseable[Zone]
{
    val sup = Location.parse _
    val kind = parse_attribute (attribute ("""Zone.kind"""))
    def parse (context: Context): Zone =
    {
        Zone(
            sup (context),
            kind (context)
        )
    }
}

/**
 * Kind of zone.
 * @param sup Reference to the superclass object.
 * @param electricalNetwork
 * @param other
 * @param specialRestrictionLand
 * @param weatherZone
 */
case class ZoneKind
(
    override val sup: Element,
    val electricalNetwork: String,
    val other: String,
    val specialRestrictionLand: String,
    val weatherZone: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ZoneKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ZoneKind
extends
    Parseable[ZoneKind]
{
    val sup = BasicElement.parse _
    val electricalNetwork = parse_attribute (attribute ("""ZoneKind.electricalNetwork"""))
    val other = parse_attribute (attribute ("""ZoneKind.other"""))
    val specialRestrictionLand = parse_attribute (attribute ("""ZoneKind.specialRestrictionLand"""))
    val weatherZone = parse_attribute (attribute ("""ZoneKind.weatherZone"""))
    def parse (context: Context): ZoneKind =
    {
        ZoneKind(
            sup (context),
            electricalNetwork (context),
            other (context),
            specialRestrictionLand (context),
            weatherZone (context)
        )
    }
}

object _InfLocations
{
    def register: Unit =
    {
        DemographicKind.register
        LandProperty.register
        LandPropertyKind.register
        LocationGrant.register
        RedLine.register
        RightOfWay.register
        Route.register
        Zone.register
        ZoneKind.register
    }
}