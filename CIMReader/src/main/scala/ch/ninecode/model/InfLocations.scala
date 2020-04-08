package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Information about a particular piece of (land) property such as its use.
 *
 * Ownership of the property may be determined through associations to Organisations and/or ErpPersons.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param demographicKind Demographics around the site.
 * @param externalRecordReference Reference allocated by the governing organisation (such as municipality) to this piece of land that has a formal reference to Surveyor General's records.
 *        The governing organisation is specified in associated Organisation.
 * @param kind Kind of (land) property, categorised according to its main functional use from the utility's perspective.
 * @param status <em>undocumented</em>
 * @param AssetContainers [[ch.ninecode.model.AssetContainer AssetContainer]] <em>undocumented</em>
 * @param ErpOrganisationRoles [[ch.ninecode.model.PropertyOrganisationRole PropertyOrganisationRole]] <em>undocumented</em>
 * @param ErpPersonRoles [[ch.ninecode.model.PersonPropertyRole PersonPropertyRole]] <em>undocumented</em>
 * @param ErpSiteLevelDatas [[ch.ninecode.model.ErpSiteLevelData ErpSiteLevelData]] <em>undocumented</em>
 * @param LocationGrants [[ch.ninecode.model.LocationGrant LocationGrant]] All location grants this land property has.
 * @param Locations [[ch.ninecode.model.Location Location]] The spatail description of a piece of property.
 * @param RightOfWays [[ch.ninecode.model.RightOfWay RightOfWay]] All rights of way this land property has.
 * @group InfLocations
 * @groupname InfLocations Package InfLocations
 */
final case class LandProperty
(
    override val sup: IdentifiedObject = null,
    demographicKind: String = null,
    externalRecordReference: String = null,
    kind: String = null,
    status: String = null,
    AssetContainers: List[String] = null,
    ErpOrganisationRoles: List[String] = null,
    ErpPersonRoles: List[String] = null,
    ErpSiteLevelDatas: List[String] = null,
    LocationGrants: List[String] = null,
    Locations: List[String] = null,
    RightOfWays: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LandProperty.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LandProperty.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LandProperty.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (LandProperty.fields (position), x))
        emitattr (0, demographicKind)
        emitelem (1, externalRecordReference)
        emitattr (2, kind)
        emitattr (3, status)
        emitattrs (4, AssetContainers)
        emitattrs (5, ErpOrganisationRoles)
        emitattrs (6, ErpPersonRoles)
        emitattrs (7, ErpSiteLevelDatas)
        emitattrs (8, LocationGrants)
        emitattrs (9, Locations)
        emitattrs (10, RightOfWays)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LandProperty rdf:ID=\"%s\">\n%s\t</cim:LandProperty>".format (id, export_fields)
    }
}

object LandProperty
extends
    Parseable[LandProperty]
{
    override val fields: Array[String] = Array[String] (
        "demographicKind",
        "externalRecordReference",
        "kind",
        "status",
        "AssetContainers",
        "ErpOrganisationRoles",
        "ErpPersonRoles",
        "ErpSiteLevelDatas",
        "LocationGrants",
        "Locations",
        "RightOfWays"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AssetContainers", "AssetContainer", "0..*", "0..*"),
        Relationship ("ErpOrganisationRoles", "PropertyOrganisationRole", "0..*", "1.."),
        Relationship ("ErpPersonRoles", "PersonPropertyRole", "0..*", "1"),
        Relationship ("ErpSiteLevelDatas", "ErpSiteLevelData", "0..*", "0..1"),
        Relationship ("LocationGrants", "LocationGrant", "0..*", "0..1"),
        Relationship ("Locations", "Location", "0..*", "0..*"),
        Relationship ("RightOfWays", "RightOfWay", "0..*", "0..*")
    )
    val demographicKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val externalRecordReference: Fielder = parse_element (element (cls, fields(1)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val status: Fielder = parse_attribute (attribute (cls, fields(3)))
    val AssetContainers: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val ErpOrganisationRoles: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val ErpPersonRoles: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val ErpSiteLevelDatas: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val LocationGrants: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val Locations: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val RightOfWays: FielderMultiple = parse_attributes (attribute (cls, fields(10)))

    def parse (context: Context): LandProperty =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LandProperty (
            IdentifiedObject.parse (context),
            mask (demographicKind (), 0),
            mask (externalRecordReference (), 1),
            mask (kind (), 2),
            mask (status (), 3),
            masks (AssetContainers (), 4),
            masks (ErpOrganisationRoles (), 5),
            masks (ErpPersonRoles (), 6),
            masks (ErpSiteLevelDatas (), 7),
            masks (LocationGrants (), 8),
            masks (Locations (), 9),
            masks (RightOfWays (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A grant provides a right, as defined by type, for a parcel of land.
 *
 * Note that the association to Location, Asset, Organisation, etc. for the Grant is inherited from Agreement, a type of Document.
 *
 * @param sup [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @param propertyData Property related information that describes the Grant's land parcel.
 *        For example, it may be a deed book number, deed book page number, and parcel number.
 * @param LandProperty [[ch.ninecode.model.LandProperty LandProperty]] Land property this location grant applies to.
 * @group InfLocations
 * @groupname InfLocations Package InfLocations
 */
final case class LocationGrant
(
    override val sup: Agreement = null,
    propertyData: String = null,
    LandProperty: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Agreement: Agreement = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LocationGrant.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LocationGrant.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LocationGrant.fields (position), value)
        emitelem (0, propertyData)
        emitattr (1, LandProperty)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LocationGrant rdf:ID=\"%s\">\n%s\t</cim:LocationGrant>".format (id, export_fields)
    }
}

object LocationGrant
extends
    Parseable[LocationGrant]
{
    override val fields: Array[String] = Array[String] (
        "propertyData",
        "LandProperty"
    )
    override val relations: List[Relationship] = List (
        Relationship ("LandProperty", "LandProperty", "0..1", "0..*")
    )
    val propertyData: Fielder = parse_element (element (cls, fields(0)))
    val LandProperty: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): LocationGrant =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LocationGrant (
            Agreement.parse (context),
            mask (propertyData (), 0),
            mask (LandProperty (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class is used for handling the accompanying annotations, time stamp, author, etc. of designs, drawings and maps.
 *
 * A red line can be associated with any Location object.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @group InfLocations
 * @groupname InfLocations Package InfLocations
 */
final case class RedLine
(
    override val sup: IdentifiedObject = null,
    status: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RedLine.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RedLine.fields (position), value)
        emitattr (0, status)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RedLine rdf:ID=\"%s\">\n%s\t</cim:RedLine>".format (id, export_fields)
    }
}

object RedLine
extends
    Parseable[RedLine]
{
    override val fields: Array[String] = Array[String] (
        "status"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): RedLine =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RedLine (
            IdentifiedObject.parse (context),
            mask (status (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A right-of-way (ROW) is for land where it is lawful to use for a public road, an electric power line, etc.
 *
 * Note that the association to Location, Asset, Organisation, etc. for the Grant is inherited from Agreement, a type of Document.
 *
 * @param sup [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @param propertyData Property related information that describes the ROW's land parcel.
 *        For example, it may be a deed book number, deed book page number, and parcel number.
 * @param LandProperties [[ch.ninecode.model.LandProperty LandProperty]] All land properties this right of way applies to.
 * @group InfLocations
 * @groupname InfLocations Package InfLocations
 */
final case class RightOfWay
(
    override val sup: Agreement = null,
    propertyData: String = null,
    LandProperties: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Agreement: Agreement = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RightOfWay.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RightOfWay.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RightOfWay.fields (position), x))
        emitelem (0, propertyData)
        emitattrs (1, LandProperties)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RightOfWay rdf:ID=\"%s\">\n%s\t</cim:RightOfWay>".format (id, export_fields)
    }
}

object RightOfWay
extends
    Parseable[RightOfWay]
{
    override val fields: Array[String] = Array[String] (
        "propertyData",
        "LandProperties"
    )
    override val relations: List[Relationship] = List (
        Relationship ("LandProperties", "LandProperty", "0..*", "0..*")
    )
    val propertyData: Fielder = parse_element (element (cls, fields(0)))
    val LandProperties: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): RightOfWay =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RightOfWay (
            Agreement.parse (context),
            mask (propertyData (), 0),
            masks (LandProperties (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Route that is followed, for example by service crews.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param type Classification by utility's work management standards and practices.
 * @param Crews [[ch.ninecode.model.OldCrew OldCrew]] <em>undocumented</em>
 * @param Locations [[ch.ninecode.model.Location Location]] <em>undocumented</em>
 * @group InfLocations
 * @groupname InfLocations Package InfLocations
 */
final case class Route
(
    override val sup: IdentifiedObject = null,
    status: String = null,
    `type`: String = null,
    Crews: List[String] = null,
    Locations: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Route.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Route.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Route.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Route.fields (position), x))
        emitattr (0, status)
        emitelem (1, `type`)
        emitattrs (2, Crews)
        emitattrs (3, Locations)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Route rdf:ID=\"%s\">\n%s\t</cim:Route>".format (id, export_fields)
    }
}

object Route
extends
    Parseable[Route]
{
    override val fields: Array[String] = Array[String] (
        "status",
        "type",
        "Crews",
        "Locations"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Crews", "OldCrew", "0..*", "0..1"),
        Relationship ("Locations", "Location", "0..*", "0..*")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val `type`: Fielder = parse_element (element (cls, fields(1)))
    val Crews: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Locations: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): Route =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Route (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            mask (`type` (), 1),
            masks (Crews (), 2),
            masks (Locations (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Area divided off from other areas.
 *
 * It may be part of the electrical network, a land area where special restrictions apply, weather areas, etc. For weather, it is an area where a set of relatively homogenous weather measurements apply.
 *
 * @param sup [[ch.ninecode.model.Location Location]] Reference to the superclass object.
 * @param kind Kind of this zone.
 * @group InfLocations
 * @groupname InfLocations Package InfLocations
 */
final case class Zone
(
    override val sup: Location = null,
    kind: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Location: Location = sup
    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Zone.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Zone.fields (position), value)
        emitattr (0, kind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Zone rdf:ID=\"%s\">\n%s\t</cim:Zone>".format (id, export_fields)
    }
}

object Zone
extends
    Parseable[Zone]
{
    override val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): Zone =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Zone (
            Location.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _InfLocations
{
    def register: List[ClassInfo] =
    {
        List (
            LandProperty.register,
            LocationGrant.register,
            RedLine.register,
            RightOfWay.register,
            Route.register,
            Zone.register
        )
    }
}