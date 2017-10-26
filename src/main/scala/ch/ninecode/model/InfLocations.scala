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
 * @param Locations [[ch.ninecode.model.Location Location]] The spatail description of a piece of property.
 * @group InfLocations
 * @groupname InfLocations Package InfLocations
 */
case class LandProperty
(
    override val sup: IdentifiedObject,
    demographicKind: String,
    externalRecordReference: String,
    kind: String,
    status: String,
    AssetContainers: List[String],
    Locations: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[LandProperty] }
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
        implicit val clz: String = LandProperty.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LandProperty.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LandProperty.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (LandProperty.fields (position), x))
        emitattr (0, demographicKind)
        emitelem (1, externalRecordReference)
        emitattr (2, kind)
        emitattr (3, status)
        emitattrs (4, AssetContainers)
        emitattrs (5, Locations)
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
    val fields: Array[String] = Array[String] (
        "demographicKind",
        "externalRecordReference",
        "kind",
        "status",
        "AssetContainers",
        "Locations"
    )
    val demographicKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val externalRecordReference: Fielder = parse_element (element (cls, fields(1)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val status: Fielder = parse_attribute (attribute (cls, fields(3)))
    val AssetContainers: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Locations: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): LandProperty =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LandProperty (
            IdentifiedObject.parse (context),
            mask (demographicKind (), 0),
            mask (externalRecordReference (), 1),
            mask (kind (), 2),
            mask (status (), 3),
            masks (AssetContainers (), 4),
            masks (Locations (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AssetContainers", "AssetContainer", true),
        Relationship ("Locations", "Location", true)
    )
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
case class LocationGrant
(
    override val sup: Agreement,
    propertyData: String,
    LandProperty: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { clone ().asInstanceOf[LocationGrant] }
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
    val fields: Array[String] = Array[String] (
        "propertyData",
        "LandProperty"
    )
    val propertyData: Fielder = parse_element (element (cls, fields(0)))
    val LandProperty: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): LocationGrant =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LocationGrant (
            Agreement.parse (context),
            mask (propertyData (), 0),
            mask (LandProperty (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LandProperty", "LandProperty", false)
    )
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
case class RedLine
(
    override val sup: IdentifiedObject,
    status: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[RedLine] }
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
    val fields: Array[String] = Array[String] (
        "status"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): RedLine =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RedLine (
            IdentifiedObject.parse (context),
            mask (status (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
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
case class RightOfWay
(
    override val sup: Agreement,
    propertyData: String,
    LandProperties: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { clone ().asInstanceOf[RightOfWay] }
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
        implicit val clz: String = RightOfWay.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RightOfWay.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (RightOfWay.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "propertyData",
        "LandProperties"
    )
    val propertyData: Fielder = parse_element (element (cls, fields(0)))
    val LandProperties: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): RightOfWay =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RightOfWay (
            Agreement.parse (context),
            mask (propertyData (), 0),
            masks (LandProperties (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LandProperties", "LandProperty", true)
    )
}

/**
 * Route that is followed, for example by service crews.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param typ Classification by utility's work management standards and practices.
 * @param Locations [[ch.ninecode.model.Location Location]] <em>undocumented</em>
 * @group InfLocations
 * @groupname InfLocations Package InfLocations
 */
case class Route
(
    override val sup: IdentifiedObject,
    status: String,
    typ: String,
    Locations: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Route] }
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
        implicit val clz: String = Route.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Route.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Route.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Route.fields (position), x))
        emitattr (0, status)
        emitelem (1, typ)
        emitattrs (2, Locations)
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
    val fields: Array[String] = Array[String] (
        "status",
        "type",
        "Locations"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val typ: Fielder = parse_element (element (cls, fields(1)))
    val Locations: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): Route =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Route (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            mask (typ (), 1),
            masks (Locations (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Locations", "Location", true)
    )
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
case class Zone
(
    override val sup: Location,
    kind: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Location: Location = sup.asInstanceOf[Location]
    override def copy (): Row = { clone ().asInstanceOf[Zone] }
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
    val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): Zone =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Zone (
            Location.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
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