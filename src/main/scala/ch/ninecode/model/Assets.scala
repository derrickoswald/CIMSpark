package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Acceptance test for assets.
 *
 * @param sup Reference to the superclass object.
 * @param dateTime Date and time the asset was last tested using the 'type' of test and yielding the current status in 'success' attribute.
 * @param success True if asset has passed acceptance test and may be placed in or is in service.
 *        It is set to false if asset is removed from service and is required to be tested again before being placed back in service, possibly in a new location. Since asset may go through multiple tests during its lifecycle, the date of each acceptance test may be recorded in 'Asset.ActivityRecord.status.dateTime'.
 * @param typ Type of test or group of tests that was conducted on 'dateTime'.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class AcceptanceTest
(
    override val sup: BasicElement,
    dateTime: String,
    success: Boolean,
    typ: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, false, null) }
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AcceptanceTest] }
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
        implicit val clz: String = AcceptanceTest.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AcceptanceTest.fields (position), value)
        emitelem (0, dateTime)
        emitelem (1, success)
        emitelem (2, typ)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AcceptanceTest rdf:ID=\"%s\">\n%s\t</cim:AcceptanceTest>".format (id, export_fields)
    }
}

object AcceptanceTest
extends
    Parseable[AcceptanceTest]
{
    val fields: Array[String] = Array[String] (
        "dateTime",
        "success",
        "type"
    )
    val dateTime: Fielder = parse_element (element (cls, fields(0)))
    val success: Fielder = parse_element (element (cls, fields(1)))
    val typ: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): AcceptanceTest =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = AcceptanceTest (
            BasicElement.parse (context),
            mask (dateTime (), 0),
            toBoolean (mask (success (), 1)),
            mask (typ (), 2)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Tangible resource of the utility, including power system equipment, various end devices, cabinets, buildings, etc.
 *
 * For electrical network equipment, the role of the asset is defined through PowerSystemResource and its subclasses, defined mainly in the Wires model (refer to IEC61970-301 and model package IEC61970::Wires). Asset description places emphasis on the physical characteristics of the equipment fulfilling that role.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param acceptanceTest Information on acceptance test.
 * @param critical True if asset is considered critical for some reason (for example, a pole with critical attachments).
 * @param electronicAddress Electronic address.
 * @param initialCondition Condition of asset in inventory or at time of installation.
 *        Examples include new, rebuilt, overhaul required, other. Refer to inspection data for information on the most current condition of the asset.
 * @param initialLossOfLife Whenever an asset is reconditioned, percentage of expected life for the asset when it was new; zero for new devices.
 * @param lifecycle Lifecycle dates for this asset.
 * @param lotNumber Lot number for this asset.
 *        Even for the same model and version number, many assets are manufactured in lots.
 * @param purchasePrice Purchase price of asset.
 * @param serialNumber Serial number of this asset.
 * @param status Status of this asset.
 * @param typ Utility-specific classification of Asset and its subtypes, according to their corporate standards, practices, and existing IT systems (e.g., for management of assets, maintenance, work, outage, customers, etc.).
 * @param utcNumber Uniquely tracked commodity (UTC) number.
 * @param ActivityRecords [[ch.ninecode.model.ActivityRecord ActivityRecord]] All activity records created for this asset.
 * @param AssetContainer [[ch.ninecode.model.AssetContainer AssetContainer]] Container of this asset.
 * @param AssetInfo [[ch.ninecode.model.AssetInfo AssetInfo]] Data applicable to this asset.
 * @param AssetPropertyCurves [[ch.ninecode.model.AssetPropertyCurve AssetPropertyCurve]] <em>undocumented</em>
 * @param ErpInventory [[ch.ninecode.model.ErpInventory ErpInventory]] <em>undocumented</em>
 * @param ErpItemMaster [[ch.ninecode.model.ErpItemMaster ErpItemMaster]] <em>undocumented</em>
 * @param ErpRecDeliveryItems [[ch.ninecode.model.ErpRecDelvLineItem ErpRecDelvLineItem]] <em>undocumented</em>
 * @param FinancialInfo [[ch.ninecode.model.FinancialInfo FinancialInfo]] <em>undocumented</em>
 * @param Location [[ch.ninecode.model.Location Location]] Location of this asset.
 * @param OrganisationRoles [[ch.ninecode.model.AssetOrganisationRole AssetOrganisationRole]] All roles an organisation plays for this asset.
 * @param PowerSystemResources [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] All power system resources used to electrically model this asset.
 *        For example, transformer asset is electrically modelled with a transformer and its windings and tap changer.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class Asset
(
    override val sup: IdentifiedObject,
    acceptanceTest: String,
    critical: Boolean,
    electronicAddress: String,
    initialCondition: String,
    initialLossOfLife: Double,
    lifecycle: String,
    lotNumber: String,
    purchasePrice: Double,
    serialNumber: String,
    status: String,
    typ: String,
    utcNumber: String,
    ActivityRecords: List[String],
    AssetContainer: String,
    AssetInfo: String,
    AssetPropertyCurves: List[String],
    ErpInventory: String,
    ErpItemMaster: String,
    ErpRecDeliveryItems: List[String],
    FinancialInfo: String,
    Location: String,
    OrganisationRoles: List[String],
    PowerSystemResources: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, false, null, null, 0.0, null, null, 0.0, null, null, null, null, List(), null, null, List(), null, null, List(), null, null, List(), List()) }
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
    override def copy (): Row = { clone ().asInstanceOf[Asset] }
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
        implicit val clz: String = Asset.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Asset.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Asset.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Asset.fields (position), x))
        emitattr (0, acceptanceTest)
        emitelem (1, critical)
        emitattr (2, electronicAddress)
        emitelem (3, initialCondition)
        emitelem (4, initialLossOfLife)
        emitattr (5, lifecycle)
        emitelem (6, lotNumber)
        emitelem (7, purchasePrice)
        emitelem (8, serialNumber)
        emitattr (9, status)
        emitelem (10, typ)
        emitelem (11, utcNumber)
        emitattrs (12, ActivityRecords)
        emitattr (13, AssetContainer)
        emitattr (14, AssetInfo)
        emitattrs (15, AssetPropertyCurves)
        emitattr (16, ErpInventory)
        emitattr (17, ErpItemMaster)
        emitattrs (18, ErpRecDeliveryItems)
        emitattr (19, FinancialInfo)
        emitattr (20, Location)
        emitattrs (21, OrganisationRoles)
        emitattrs (22, PowerSystemResources)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Asset rdf:ID=\"%s\">\n%s\t</cim:Asset>".format (id, export_fields)
    }
}

object Asset
extends
    Parseable[Asset]
{
    val fields: Array[String] = Array[String] (
        "acceptanceTest",
        "critical",
        "electronicAddress",
        "initialCondition",
        "initialLossOfLife",
        "lifecycle",
        "lotNumber",
        "purchasePrice",
        "serialNumber",
        "status",
        "type",
        "utcNumber",
        "ActivityRecords",
        "AssetContainer",
        "AssetInfo",
        "AssetPropertyCurves",
        "ErpInventory",
        "ErpItemMaster",
        "ErpRecDeliveryItems",
        "FinancialInfo",
        "Location",
        "OrganisationRoles",
        "PowerSystemResources"
    )
    val acceptanceTest: Fielder = parse_attribute (attribute (cls, fields(0)))
    val critical: Fielder = parse_element (element (cls, fields(1)))
    val electronicAddress: Fielder = parse_attribute (attribute (cls, fields(2)))
    val initialCondition: Fielder = parse_element (element (cls, fields(3)))
    val initialLossOfLife: Fielder = parse_element (element (cls, fields(4)))
    val lifecycle: Fielder = parse_attribute (attribute (cls, fields(5)))
    val lotNumber: Fielder = parse_element (element (cls, fields(6)))
    val purchasePrice: Fielder = parse_element (element (cls, fields(7)))
    val serialNumber: Fielder = parse_element (element (cls, fields(8)))
    val status: Fielder = parse_attribute (attribute (cls, fields(9)))
    val typ: Fielder = parse_element (element (cls, fields(10)))
    val utcNumber: Fielder = parse_element (element (cls, fields(11)))
    val ActivityRecords: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val AssetContainer: Fielder = parse_attribute (attribute (cls, fields(13)))
    val AssetInfo: Fielder = parse_attribute (attribute (cls, fields(14)))
    val AssetPropertyCurves: FielderMultiple = parse_attributes (attribute (cls, fields(15)))
    val ErpInventory: Fielder = parse_attribute (attribute (cls, fields(16)))
    val ErpItemMaster: Fielder = parse_attribute (attribute (cls, fields(17)))
    val ErpRecDeliveryItems: FielderMultiple = parse_attributes (attribute (cls, fields(18)))
    val FinancialInfo: Fielder = parse_attribute (attribute (cls, fields(19)))
    val Location: Fielder = parse_attribute (attribute (cls, fields(20)))
    val OrganisationRoles: FielderMultiple = parse_attributes (attribute (cls, fields(21)))
    val PowerSystemResources: FielderMultiple = parse_attributes (attribute (cls, fields(22)))

    def parse (context: Context): Asset =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        def masks (field: Fields, position: Int): List[String] = { if (field._2) fields |= 1 << position; field._1 }
        val ret = Asset (
            IdentifiedObject.parse (context),
            mask (acceptanceTest (), 0),
            toBoolean (mask (critical (), 1)),
            mask (electronicAddress (), 2),
            mask (initialCondition (), 3),
            toDouble (mask (initialLossOfLife (), 4)),
            mask (lifecycle (), 5),
            mask (lotNumber (), 6),
            toDouble (mask (purchasePrice (), 7)),
            mask (serialNumber (), 8),
            mask (status (), 9),
            mask (typ (), 10),
            mask (utcNumber (), 11),
            masks (ActivityRecords (), 12),
            mask (AssetContainer (), 13),
            mask (AssetInfo (), 14),
            masks (AssetPropertyCurves (), 15),
            mask (ErpInventory (), 16),
            mask (ErpItemMaster (), 17),
            masks (ErpRecDeliveryItems (), 18),
            mask (FinancialInfo (), 19),
            mask (Location (), 20),
            masks (OrganisationRoles (), 21),
            masks (PowerSystemResources (), 22)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ActivityRecords", "ActivityRecord", true),
        Relationship ("AssetContainer", "AssetContainer", false),
        Relationship ("AssetInfo", "AssetInfo", false),
        Relationship ("AssetPropertyCurves", "AssetPropertyCurve", true),
        Relationship ("ErpInventory", "ErpInventory", false),
        Relationship ("ErpItemMaster", "ErpItemMaster", false),
        Relationship ("ErpRecDeliveryItems", "ErpRecDelvLineItem", true),
        Relationship ("FinancialInfo", "FinancialInfo", false),
        Relationship ("Location", "Location", false),
        Relationship ("OrganisationRoles", "AssetOrganisationRole", true),
        Relationship ("PowerSystemResources", "PowerSystemResource", true)
    )
}

/**
 * Asset that is aggregation of other assets such as conductors, transformers, switchgear, land, fences, buildings, equipment, vehicles, etc.
 *
 * @param sup [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class AssetContainer
(
    override val sup: Asset
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
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
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { clone ().asInstanceOf[AssetContainer] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:AssetContainer rdf:ID=\"%s\">\n%s\t</cim:AssetContainer>".format (id, export_fields)
    }
}

object AssetContainer
extends
    Parseable[AssetContainer]
{

    def parse (context: Context): AssetContainer =
    {
        implicit val ctx: Context = context
        val ret = AssetContainer (
            Asset.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Function performed by an asset.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param configID Configuration specified for this function.
 * @param firmwareID Firmware version.
 * @param hardwareID Hardware version.
 * @param password Password needed to access this function.
 * @param programID Name of program.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class AssetFunction
(
    override val sup: IdentifiedObject,
    configID: String,
    firmwareID: String,
    hardwareID: String,
    password: String,
    programID: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null) }
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
    override def copy (): Row = { clone ().asInstanceOf[AssetFunction] }
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
        implicit val clz: String = AssetFunction.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AssetFunction.fields (position), value)
        emitelem (0, configID)
        emitelem (1, firmwareID)
        emitelem (2, hardwareID)
        emitelem (3, password)
        emitelem (4, programID)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetFunction rdf:ID=\"%s\">\n%s\t</cim:AssetFunction>".format (id, export_fields)
    }
}

object AssetFunction
extends
    Parseable[AssetFunction]
{
    val fields: Array[String] = Array[String] (
        "configID",
        "firmwareID",
        "hardwareID",
        "password",
        "programID"
    )
    val configID: Fielder = parse_element (element (cls, fields(0)))
    val firmwareID: Fielder = parse_element (element (cls, fields(1)))
    val hardwareID: Fielder = parse_element (element (cls, fields(2)))
    val password: Fielder = parse_element (element (cls, fields(3)))
    val programID: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: Context): AssetFunction =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = AssetFunction (
            IdentifiedObject.parse (context),
            mask (configID (), 0),
            mask (firmwareID (), 1),
            mask (hardwareID (), 2),
            mask (password (), 3),
            mask (programID (), 4)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Set of attributes of an asset, representing typical datasheet information of a physical device that can be instantiated and shared in different data exchange contexts:
 * - as attributes of an asset instance (installed or in stock)
 * - as attributes of an asset model (product by a manufacturer)
 *
 * - as attributes of a type asset (generic type of an asset as used in designs/extension planning).
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param AssetModel [[ch.ninecode.model.AssetModel AssetModel]] Asset model described by this data.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class AssetInfo
(
    override val sup: IdentifiedObject,
    AssetModel: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
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
    override def copy (): Row = { clone ().asInstanceOf[AssetInfo] }
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
        implicit val clz: String = AssetInfo.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AssetInfo.fields (position), value)
        emitattr (0, AssetModel)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetInfo rdf:ID=\"%s\">\n%s\t</cim:AssetInfo>".format (id, export_fields)
    }
}

object AssetInfo
extends
    Parseable[AssetInfo]
{
    val fields: Array[String] = Array[String] (
        "AssetModel"
    )
    val AssetModel: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): AssetInfo =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = AssetInfo (
            IdentifiedObject.parse (context),
            mask (AssetModel (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AssetModel", "AssetModel", false)
    )
}

/**
 * Potential hazard related to the location of an asset.
 *
 * Examples are trees growing under overhead power lines, a park being located by a substation (i.e., children climb fence to recover a ball), a lake near an overhead distribution line (fishing pole/line contacting power lines), dangerous neighbour, etc.
 *
 * @param sup [[ch.ninecode.model.Hazard Hazard]] Reference to the superclass object.
 * @param Locations [[ch.ninecode.model.Location Location]] The location of this hazard.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class AssetLocationHazard
(
    override val sup: Hazard,
    Locations: List[String]
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
    def Hazard: Hazard = sup.asInstanceOf[Hazard]
    override def copy (): Row = { clone ().asInstanceOf[AssetLocationHazard] }
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
        implicit val clz: String = AssetLocationHazard.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (AssetLocationHazard.fields (position), x))
        emitattrs (0, Locations)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetLocationHazard rdf:ID=\"%s\">\n%s\t</cim:AssetLocationHazard>".format (id, export_fields)
    }
}

object AssetLocationHazard
extends
    Parseable[AssetLocationHazard]
{
    val fields: Array[String] = Array[String] (
        "Locations"
    )
    val Locations: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): AssetLocationHazard =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def masks (field: Fields, position: Int): List[String] = { if (field._2) fields |= 1 << position; field._1 }
        val ret = AssetLocationHazard (
            Hazard.parse (context),
            masks (Locations (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Locations", "Location", true)
    )
}

/**
 * Model of an asset, either a product of a specific manufacturer or a generic asset model or material item.
 *
 * Datasheet characteristics are available through the associated AssetInfo subclass and can be shared with asset or power system resource instances.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param AssetInfo [[ch.ninecode.model.AssetInfo AssetInfo]] Data applicable to this asset model.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class AssetModel
(
    override val sup: IdentifiedObject,
    AssetInfo: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
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
    override def copy (): Row = { clone ().asInstanceOf[AssetModel] }
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
        implicit val clz: String = AssetModel.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AssetModel.fields (position), value)
        emitattr (0, AssetInfo)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetModel rdf:ID=\"%s\">\n%s\t</cim:AssetModel>".format (id, export_fields)
    }
}

object AssetModel
extends
    Parseable[AssetModel]
{
    val fields: Array[String] = Array[String] (
        "AssetInfo"
    )
    val AssetInfo: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): AssetModel =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = AssetModel (
            IdentifiedObject.parse (context),
            mask (AssetInfo (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AssetInfo", "AssetInfo", false)
    )
}

/**
 * Role an organisation plays with respect to asset.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class AssetOrganisationRole
(
    override val sup: OrganisationRole
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[AssetOrganisationRole] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:AssetOrganisationRole rdf:ID=\"%s\">\n%s\t</cim:AssetOrganisationRole>".format (id, export_fields)
    }
}

object AssetOrganisationRole
extends
    Parseable[AssetOrganisationRole]
{

    def parse (context: Context): AssetOrganisationRole =
    {
        implicit val ctx: Context = context
        val ret = AssetOrganisationRole (
            OrganisationRole.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Owner of the asset.
 *
 * @param sup [[ch.ninecode.model.AssetOrganisationRole AssetOrganisationRole]] Reference to the superclass object.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class AssetOwner
(
    override val sup: AssetOrganisationRole
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
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
    def AssetOrganisationRole: AssetOrganisationRole = sup.asInstanceOf[AssetOrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[AssetOwner] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:AssetOwner rdf:ID=\"%s\">\n%s\t</cim:AssetOwner>".format (id, export_fields)
    }
}

object AssetOwner
extends
    Parseable[AssetOwner]
{

    def parse (context: Context): AssetOwner =
    {
        implicit val ctx: Context = context
        val ret = AssetOwner (
            AssetOrganisationRole.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Organisation that is a user of the asset.
 *
 * @param sup [[ch.ninecode.model.AssetOrganisationRole AssetOrganisationRole]] Reference to the superclass object.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class AssetUser
(
    override val sup: AssetOrganisationRole
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
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
    def AssetOrganisationRole: AssetOrganisationRole = sup.asInstanceOf[AssetOrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[AssetUser] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:AssetUser rdf:ID=\"%s\">\n%s\t</cim:AssetUser>".format (id, export_fields)
    }
}

object AssetUser
extends
    Parseable[AssetUser]
{

    def parse (context: Context): AssetUser =
    {
        implicit val ctx: Context = context
        val ret = AssetUser (
            AssetOrganisationRole.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Communication media such as fibre optic cable, power-line, telephone, etc.
 *
 * @param sup [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class ComMedia
(
    override val sup: Asset
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
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
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { clone ().asInstanceOf[ComMedia] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:ComMedia rdf:ID=\"%s\">\n%s\t</cim:ComMedia>".format (id, export_fields)
    }
}

object ComMedia
extends
    Parseable[ComMedia]
{

    def parse (context: Context): ComMedia =
    {
        implicit val ctx: Context = context
        val ret = ComMedia (
            Asset.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Dates for lifecycle events of an asset.
 *
 * @param sup Reference to the superclass object.
 * @param installationDate (if applicable) Date current installation was completed, which may not be the same as the in-service date.
 *        Asset may have been installed at other locations previously. Ignored if asset is (1) not currently installed (e.g., stored in a depot) or (2) not intended to be installed (e.g., vehicle, tool).
 * @param manufacturedDate Date the asset was manufactured.
 * @param purchaseDate Date the asset was purchased.
 *        Note that even though an asset may have been purchased, it may not have been received into inventory at the time of purchase.
 * @param receivedDate Date the asset was received and first placed into inventory.
 * @param removalDate (if applicable) Date when the asset was last removed from service.
 *        Ignored if (1) not intended to be in service, or (2) currently in service.
 * @param retiredDate (if applicable) Date the asset is permanently retired from service and may be scheduled for disposal.
 *        Ignored if asset is (1) currently in service, or (2) permanently removed from service.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class LifecycleDate
(
    override val sup: BasicElement,
    installationDate: String,
    manufacturedDate: String,
    purchaseDate: String,
    receivedDate: String,
    removalDate: String,
    retiredDate: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null) }
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[LifecycleDate] }
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
        implicit val clz: String = LifecycleDate.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LifecycleDate.fields (position), value)
        emitelem (0, installationDate)
        emitelem (1, manufacturedDate)
        emitelem (2, purchaseDate)
        emitelem (3, receivedDate)
        emitelem (4, removalDate)
        emitelem (5, retiredDate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LifecycleDate rdf:ID=\"%s\">\n%s\t</cim:LifecycleDate>".format (id, export_fields)
    }
}

object LifecycleDate
extends
    Parseable[LifecycleDate]
{
    val fields: Array[String] = Array[String] (
        "installationDate",
        "manufacturedDate",
        "purchaseDate",
        "receivedDate",
        "removalDate",
        "retiredDate"
    )
    val installationDate: Fielder = parse_element (element (cls, fields(0)))
    val manufacturedDate: Fielder = parse_element (element (cls, fields(1)))
    val purchaseDate: Fielder = parse_element (element (cls, fields(2)))
    val receivedDate: Fielder = parse_element (element (cls, fields(3)))
    val removalDate: Fielder = parse_element (element (cls, fields(4)))
    val retiredDate: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: Context): LifecycleDate =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = LifecycleDate (
            BasicElement.parse (context),
            mask (installationDate (), 0),
            mask (manufacturedDate (), 1),
            mask (purchaseDate (), 2),
            mask (receivedDate (), 3),
            mask (removalDate (), 4),
            mask (retiredDate (), 5)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Organisation that maintains assets.
 *
 * @param sup [[ch.ninecode.model.AssetOrganisationRole AssetOrganisationRole]] Reference to the superclass object.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class Maintainer
(
    override val sup: AssetOrganisationRole
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
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
    def AssetOrganisationRole: AssetOrganisationRole = sup.asInstanceOf[AssetOrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[Maintainer] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Maintainer rdf:ID=\"%s\">\n%s\t</cim:Maintainer>".format (id, export_fields)
    }
}

object Maintainer
extends
    Parseable[Maintainer]
{

    def parse (context: Context): Maintainer =
    {
        implicit val ctx: Context = context
        val ret = Maintainer (
            AssetOrganisationRole.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Organisation that manufactures asset products.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class Manufacturer
(
    override val sup: OrganisationRole
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[Manufacturer] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Manufacturer rdf:ID=\"%s\">\n%s\t</cim:Manufacturer>".format (id, export_fields)
    }
}

object Manufacturer
extends
    Parseable[Manufacturer]
{

    def parse (context: Context): Manufacturer =
    {
        implicit val ctx: Context = context
        val ret = Manufacturer (
            OrganisationRole.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Documented procedure for various types of work or work tasks on assets.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param instruction Textual description of this procedure.
 * @param kind Kind of procedure.
 * @param sequenceNumber Sequence number in a sequence of procedures being performed.
 * @param Assets [[ch.ninecode.model.Asset Asset]] All assets to which this procedure applies.
 * @param Limits [[ch.ninecode.model.Limit Limit]] <em>undocumented</em>
 * @param Measurements [[ch.ninecode.model.Measurement Measurement]] Document containing this measurement.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class Procedure
(
    override val sup: Document,
    instruction: String,
    kind: String,
    sequenceNumber: String,
    Assets: List[String],
    Limits: List[String],
    Measurements: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), List(), List()) }
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[Procedure] }
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
        implicit val clz: String = Procedure.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Procedure.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Procedure.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Procedure.fields (position), x))
        emitelem (0, instruction)
        emitattr (1, kind)
        emitelem (2, sequenceNumber)
        emitattrs (3, Assets)
        emitattrs (4, Limits)
        emitattrs (5, Measurements)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Procedure rdf:ID=\"%s\">\n%s\t</cim:Procedure>".format (id, export_fields)
    }
}

object Procedure
extends
    Parseable[Procedure]
{
    val fields: Array[String] = Array[String] (
        "instruction",
        "kind",
        "sequenceNumber",
        "Assets",
        "Limits",
        "Measurements"
    )
    val instruction: Fielder = parse_element (element (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(2)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Limits: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Measurements: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): Procedure =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        def masks (field: Fields, position: Int): List[String] = { if (field._2) fields |= 1 << position; field._1 }
        val ret = Procedure (
            Document.parse (context),
            mask (instruction (), 0),
            mask (kind (), 1),
            mask (sequenceNumber (), 2),
            masks (Assets (), 3),
            masks (Limits (), 4),
            masks (Measurements (), 5)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Assets", "Asset", true),
        Relationship ("Limits", "Limit", true),
        Relationship ("Measurements", "Measurement", true)
    )
}

/**
 * A data set recorded each time a procedure is executed.
 *
 * Observed results are captured in associated measurement values and/or values for properties relevant to the type of procedure performed.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param completedDateTime Date and time procedure was completed.
 * @param MeasurementValues [[ch.ninecode.model.MeasurementValue MeasurementValue]] <em>undocumented</em>
 * @param Procedure [[ch.ninecode.model.Procedure Procedure]] Procedure capturing this data set.
 * @param TransformerObservations [[ch.ninecode.model.TransformerObservation TransformerObservation]] <em>undocumented</em>
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class ProcedureDataSet
(
    override val sup: Document,
    completedDateTime: String,
    MeasurementValues: List[String],
    Procedure: String,
    TransformerObservations: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), null, List()) }
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[ProcedureDataSet] }
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
        implicit val clz: String = ProcedureDataSet.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProcedureDataSet.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ProcedureDataSet.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ProcedureDataSet.fields (position), x))
        emitelem (0, completedDateTime)
        emitattrs (1, MeasurementValues)
        emitattr (2, Procedure)
        emitattrs (3, TransformerObservations)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProcedureDataSet rdf:ID=\"%s\">\n%s\t</cim:ProcedureDataSet>".format (id, export_fields)
    }
}

object ProcedureDataSet
extends
    Parseable[ProcedureDataSet]
{
    val fields: Array[String] = Array[String] (
        "completedDateTime",
        "MeasurementValues",
        "Procedure",
        "TransformerObservations"
    )
    val completedDateTime: Fielder = parse_element (element (cls, fields(0)))
    val MeasurementValues: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Procedure: Fielder = parse_attribute (attribute (cls, fields(2)))
    val TransformerObservations: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): ProcedureDataSet =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        def masks (field: Fields, position: Int): List[String] = { if (field._2) fields |= 1 << position; field._1 }
        val ret = ProcedureDataSet (
            Document.parse (context),
            mask (completedDateTime (), 0),
            masks (MeasurementValues (), 1),
            mask (Procedure (), 2),
            masks (TransformerObservations (), 3)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MeasurementValues", "MeasurementValue", true),
        Relationship ("Procedure", "Procedure", false),
        Relationship ("TransformerObservations", "TransformerObservation", true)
    )
}

/**
 * Asset model by a specific manufacturer.
 *
 * @param sup [[ch.ninecode.model.AssetModel AssetModel]] Reference to the superclass object.
 * @param corporateStandardKind Kind of corporate standard for this asset model.
 * @param modelNumber Manufacturer's model number.
 * @param modelVersion Version number for product model, which indicates vintage of the product.
 * @param usageKind Intended usage for this asset model.
 * @param weightTotal Total manufactured weight of asset.
 * @param GenericAssetModelOrMaterial [[ch.ninecode.model.GenericAssetModelOrMaterial GenericAssetModelOrMaterial]] Generic asset model or material satisified by this product asset model.
 * @param Manufacturer [[ch.ninecode.model.Manufacturer Manufacturer]] Manufacturer of this asset model.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class ProductAssetModel
(
    override val sup: AssetModel,
    corporateStandardKind: String,
    modelNumber: String,
    modelVersion: String,
    usageKind: String,
    weightTotal: Double,
    GenericAssetModelOrMaterial: String,
    Manufacturer: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, 0.0, null, null) }
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
    def AssetModel: AssetModel = sup.asInstanceOf[AssetModel]
    override def copy (): Row = { clone ().asInstanceOf[ProductAssetModel] }
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
        implicit val clz: String = ProductAssetModel.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProductAssetModel.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ProductAssetModel.fields (position), value)
        emitattr (0, corporateStandardKind)
        emitelem (1, modelNumber)
        emitelem (2, modelVersion)
        emitattr (3, usageKind)
        emitelem (4, weightTotal)
        emitattr (5, GenericAssetModelOrMaterial)
        emitattr (6, Manufacturer)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProductAssetModel rdf:ID=\"%s\">\n%s\t</cim:ProductAssetModel>".format (id, export_fields)
    }
}

object ProductAssetModel
extends
    Parseable[ProductAssetModel]
{
    val fields: Array[String] = Array[String] (
        "corporateStandardKind",
        "modelNumber",
        "modelVersion",
        "usageKind",
        "weightTotal",
        "GenericAssetModelOrMaterial",
        "Manufacturer"
    )
    val corporateStandardKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val modelNumber: Fielder = parse_element (element (cls, fields(1)))
    val modelVersion: Fielder = parse_element (element (cls, fields(2)))
    val usageKind: Fielder = parse_attribute (attribute (cls, fields(3)))
    val weightTotal: Fielder = parse_element (element (cls, fields(4)))
    val GenericAssetModelOrMaterial: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Manufacturer: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): ProductAssetModel =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = ProductAssetModel (
            AssetModel.parse (context),
            mask (corporateStandardKind (), 0),
            mask (modelNumber (), 1),
            mask (modelVersion (), 2),
            mask (usageKind (), 3),
            toDouble (mask (weightTotal (), 4)),
            mask (GenericAssetModelOrMaterial (), 5),
            mask (Manufacturer (), 6)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("GenericAssetModelOrMaterial", "GenericAssetModelOrMaterial", false),
        Relationship ("Manufacturer", "Manufacturer", false)
    )
}

/**
 * Physically controls access to AssetContainers.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param appliedDateTime Date and time this seal has been applied.
 * @param condition Condition of seal.
 * @param kind Kind of seal.
 * @param sealNumber (reserved word) Seal number.
 * @param AssetContainer [[ch.ninecode.model.AssetContainer AssetContainer]] Asset container to which this seal is applied.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class Seal
(
    override val sup: IdentifiedObject,
    appliedDateTime: String,
    condition: String,
    kind: String,
    sealNumber: String,
    AssetContainer: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null) }
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
    override def copy (): Row = { clone ().asInstanceOf[Seal] }
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
        implicit val clz: String = Seal.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Seal.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Seal.fields (position), value)
        emitelem (0, appliedDateTime)
        emitattr (1, condition)
        emitattr (2, kind)
        emitelem (3, sealNumber)
        emitattr (4, AssetContainer)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Seal rdf:ID=\"%s\">\n%s\t</cim:Seal>".format (id, export_fields)
    }
}

object Seal
extends
    Parseable[Seal]
{
    val fields: Array[String] = Array[String] (
        "appliedDateTime",
        "condition",
        "kind",
        "sealNumber",
        "AssetContainer"
    )
    val appliedDateTime: Fielder = parse_element (element (cls, fields(0)))
    val condition: Fielder = parse_attribute (attribute (cls, fields(1)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val sealNumber: Fielder = parse_element (element (cls, fields(3)))
    val AssetContainer: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): Seal =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = Seal (
            IdentifiedObject.parse (context),
            mask (appliedDateTime (), 0),
            mask (condition (), 1),
            mask (kind (), 2),
            mask (sealNumber (), 3),
            mask (AssetContainer (), 4)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AssetContainer", "AssetContainer", false)
    )
}

private[ninecode] object _Assets
{
    def register: List[ClassInfo] =
    {
        List (
            AcceptanceTest.register,
            Asset.register,
            AssetContainer.register,
            AssetFunction.register,
            AssetInfo.register,
            AssetLocationHazard.register,
            AssetModel.register,
            AssetOrganisationRole.register,
            AssetOwner.register,
            AssetUser.register,
            ComMedia.register,
            LifecycleDate.register,
            Maintainer.register,
            Manufacturer.register,
            Procedure.register,
            ProcedureDataSet.register,
            ProductAssetModel.register,
            Seal.register
        )
    }
}