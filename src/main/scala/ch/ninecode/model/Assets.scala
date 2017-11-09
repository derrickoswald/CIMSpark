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
 * @param `type` Type of test or group of tests that was conducted on 'dateTime'.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class AcceptanceTest
(
    override val sup: BasicElement,
    dateTime: String,
    success: Boolean,
    `type`: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, false, null) }
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
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AcceptanceTest.fields (position), value)
        emitelem (0, dateTime)
        emitelem (1, success)
        emitelem (2, `type`)
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
    override val fields: Array[String] = Array[String] (
        "dateTime",
        "success",
        "type"
    )
    val dateTime: Fielder = parse_element (element (cls, fields(0)))
    val success: Fielder = parse_element (element (cls, fields(1)))
    val `type`: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): AcceptanceTest =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AcceptanceTest (
            BasicElement.parse (context),
            mask (dateTime (), 0),
            toBoolean (mask (success (), 1)),
            mask (`type` (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Tangible resource of the utility, including power system equipment, various end devices, cabinets, buildings, etc.
 *
 * For electrical network equipment, the role of the asset is defined through PowerSystemResource and its subclasses, defined mainly in the Wires model (refer to IEC61970-301 and model package IEC61970::Wires). Asset description places emphasis on the physical characteristics of the equipment fulfilling that role.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param acceptanceTest [[ch.ninecode.model.AcceptanceTest AcceptanceTest]] Information on acceptance test.
 * @param critical True if asset is considered critical for some reason (for example, a pole with critical attachments).
 * @param electronicAddress Electronic address.
 * @param initialCondition Condition of asset in inventory or at time of installation.
 *        Examples include new, rebuilt, overhaul required, other. Refer to inspection data for information on the most current condition of the asset.
 * @param initialLossOfLife Whenever an asset is reconditioned, percentage of expected life for the asset when it was new; zero for new devices.
 * @param lifecycle [[ch.ninecode.model.LifecycleDate LifecycleDate]] Lifecycle dates for this asset.
 * @param lotNumber Lot number for this asset.
 *        Even for the same model and version number, many assets are manufactured in lots.
 * @param purchasePrice Purchase price of asset.
 * @param serialNumber Serial number of this asset.
 * @param status Status of this asset.
 * @param `type` Utility-specific classification of Asset and its subtypes, according to their corporate standards, practices, and existing IT systems (e.g., for management of assets, maintenance, work, outage, customers, etc.).
 * @param utcNumber Uniquely tracked commodity (UTC) number.
 * @param ActivityRecords [[ch.ninecode.model.ActivityRecord ActivityRecord]] All activity records created for this asset.
 * @param AssetContainer [[ch.ninecode.model.AssetContainer AssetContainer]] Container of this asset.
 * @param AssetInfo [[ch.ninecode.model.AssetInfo AssetInfo]] Data applicable to this asset.
 * @param AssetPropertyCurves [[ch.ninecode.model.AssetPropertyCurve AssetPropertyCurve]] <em>undocumented</em>
 * @param ConfigurationEvents [[ch.ninecode.model.ConfigurationEvent ConfigurationEvent]] All configuration events created for this asset.
 * @param ErpInventory [[ch.ninecode.model.ErpInventory ErpInventory]] <em>undocumented</em>
 * @param ErpItemMaster [[ch.ninecode.model.ErpItemMaster ErpItemMaster]] <em>undocumented</em>
 * @param ErpRecDeliveryItems [[ch.ninecode.model.ErpRecDelvLineItem ErpRecDelvLineItem]] <em>undocumented</em>
 * @param FinancialInfo [[ch.ninecode.model.FinancialInfo FinancialInfo]] <em>undocumented</em>
 * @param Location [[ch.ninecode.model.Location Location]] Location of this asset.
 * @param Measurements [[ch.ninecode.model.Measurement Measurement]] <em>undocumented</em>
 * @param Mediums [[ch.ninecode.model.Medium Medium]] <em>undocumented</em>
 * @param OperationTags [[ch.ninecode.model.OperationTag OperationTag]] All operation tags place on this asset.
 * @param OrganisationRoles [[ch.ninecode.model.AssetOrganisationRole AssetOrganisationRole]] All roles an organisation plays for this asset.
 * @param Ownerships [[ch.ninecode.model.Ownership Ownership]] All ownerships of this asset.
 * @param PowerSystemResources [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] All power system resources used to electrically model this asset.
 *        For example, transformer asset is electrically modelled with a transformer and its windings and tap changer.
 * @param Procedures [[ch.ninecode.model.Procedure Procedure]] All procedures applicable to this asset.
 * @param Reconditionings [[ch.ninecode.model.Reconditioning Reconditioning]] <em>undocumented</em>
 * @param ReliabilityInfos [[ch.ninecode.model.ReliabilityInfo ReliabilityInfo]] <em>undocumented</em>
 * @param ReplacementWorkTasks [[ch.ninecode.model.WorkTask WorkTask]] All work tasks on replacement of this old asset.
 * @param ScheduledEvents [[ch.ninecode.model.ScheduledEvent ScheduledEvent]] <em>undocumented</em>
 * @param WorkTasks [[ch.ninecode.model.WorkTask WorkTask]] All non-replacement work tasks performed on this asset.
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
    `type`: String,
    utcNumber: String,
    ActivityRecords: List[String],
    AssetContainer: String,
    AssetInfo: String,
    AssetPropertyCurves: List[String],
    ConfigurationEvents: List[String],
    ErpInventory: String,
    ErpItemMaster: String,
    ErpRecDeliveryItems: List[String],
    FinancialInfo: String,
    Location: String,
    Measurements: List[String],
    Mediums: List[String],
    OperationTags: List[String],
    OrganisationRoles: List[String],
    Ownerships: List[String],
    PowerSystemResources: List[String],
    Procedures: List[String],
    Reconditionings: List[String],
    ReliabilityInfos: List[String],
    ReplacementWorkTasks: List[String],
    ScheduledEvents: List[String],
    WorkTasks: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, false, null, null, 0.0, null, null, 0.0, null, null, null, null, List(), null, null, List(), List(), null, null, List(), null, null, List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List()) }
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
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Asset.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Asset.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Asset.fields (position), x))
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
        emitelem (10, `type`)
        emitelem (11, utcNumber)
        emitattrs (12, ActivityRecords)
        emitattr (13, AssetContainer)
        emitattr (14, AssetInfo)
        emitattrs (15, AssetPropertyCurves)
        emitattrs (16, ConfigurationEvents)
        emitattr (17, ErpInventory)
        emitattr (18, ErpItemMaster)
        emitattrs (19, ErpRecDeliveryItems)
        emitattr (20, FinancialInfo)
        emitattr (21, Location)
        emitattrs (22, Measurements)
        emitattrs (23, Mediums)
        emitattrs (24, OperationTags)
        emitattrs (25, OrganisationRoles)
        emitattrs (26, Ownerships)
        emitattrs (27, PowerSystemResources)
        emitattrs (28, Procedures)
        emitattrs (29, Reconditionings)
        emitattrs (30, ReliabilityInfos)
        emitattrs (31, ReplacementWorkTasks)
        emitattrs (32, ScheduledEvents)
        emitattrs (33, WorkTasks)
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
    override val fields: Array[String] = Array[String] (
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
        "ConfigurationEvents",
        "ErpInventory",
        "ErpItemMaster",
        "ErpRecDeliveryItems",
        "FinancialInfo",
        "Location",
        "Measurements",
        "Mediums",
        "OperationTags",
        "OrganisationRoles",
        "Ownerships",
        "PowerSystemResources",
        "Procedures",
        "Reconditionings",
        "ReliabilityInfos",
        "ReplacementWorkTasks",
        "ScheduledEvents",
        "WorkTasks"
    )
    override val relations: List[Relationship] = List (
        Relationship ("acceptanceTest", "AcceptanceTest", "0..1", "0..*"),
        Relationship ("lifecycle", "LifecycleDate", "0..1", "0..*"),
        Relationship ("ActivityRecords", "ActivityRecord", "0..*", "0..*"),
        Relationship ("AssetContainer", "AssetContainer", "0..1", "0..*"),
        Relationship ("AssetInfo", "AssetInfo", "0..1", "0..*"),
        Relationship ("AssetPropertyCurves", "AssetPropertyCurve", "0..*", "0..*"),
        Relationship ("ConfigurationEvents", "ConfigurationEvent", "0..*", "0..1"),
        Relationship ("ErpInventory", "ErpInventory", "0..1", "0..1"),
        Relationship ("ErpItemMaster", "ErpItemMaster", "0..1", "0..1"),
        Relationship ("ErpRecDeliveryItems", "ErpRecDelvLineItem", "0..*", "0..*"),
        Relationship ("FinancialInfo", "FinancialInfo", "0..1", "0..1"),
        Relationship ("Location", "Location", "0..1", "0..*"),
        Relationship ("Measurements", "Measurement", "0..*", "0..1"),
        Relationship ("Mediums", "Medium", "0..*", "0..*"),
        Relationship ("OperationTags", "OperationTag", "0..*", "0..1"),
        Relationship ("OrganisationRoles", "AssetOrganisationRole", "0..*", "0..*"),
        Relationship ("Ownerships", "Ownership", "0..*", "0..1"),
        Relationship ("PowerSystemResources", "PowerSystemResource", "0..*", "0..*"),
        Relationship ("Procedures", "Procedure", "0..*", "0..*"),
        Relationship ("Reconditionings", "Reconditioning", "0..*", "0..1"),
        Relationship ("ReliabilityInfos", "ReliabilityInfo", "0..*", "0..*"),
        Relationship ("ReplacementWorkTasks", "WorkTask", "0..*", "0..1"),
        Relationship ("ScheduledEvents", "ScheduledEvent", "0..*", "0..*"),
        Relationship ("WorkTasks", "WorkTask", "0..*", "0..*")
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
    val `type`: Fielder = parse_element (element (cls, fields(10)))
    val utcNumber: Fielder = parse_element (element (cls, fields(11)))
    val ActivityRecords: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val AssetContainer: Fielder = parse_attribute (attribute (cls, fields(13)))
    val AssetInfo: Fielder = parse_attribute (attribute (cls, fields(14)))
    val AssetPropertyCurves: FielderMultiple = parse_attributes (attribute (cls, fields(15)))
    val ConfigurationEvents: FielderMultiple = parse_attributes (attribute (cls, fields(16)))
    val ErpInventory: Fielder = parse_attribute (attribute (cls, fields(17)))
    val ErpItemMaster: Fielder = parse_attribute (attribute (cls, fields(18)))
    val ErpRecDeliveryItems: FielderMultiple = parse_attributes (attribute (cls, fields(19)))
    val FinancialInfo: Fielder = parse_attribute (attribute (cls, fields(20)))
    val Location: Fielder = parse_attribute (attribute (cls, fields(21)))
    val Measurements: FielderMultiple = parse_attributes (attribute (cls, fields(22)))
    val Mediums: FielderMultiple = parse_attributes (attribute (cls, fields(23)))
    val OperationTags: FielderMultiple = parse_attributes (attribute (cls, fields(24)))
    val OrganisationRoles: FielderMultiple = parse_attributes (attribute (cls, fields(25)))
    val Ownerships: FielderMultiple = parse_attributes (attribute (cls, fields(26)))
    val PowerSystemResources: FielderMultiple = parse_attributes (attribute (cls, fields(27)))
    val Procedures: FielderMultiple = parse_attributes (attribute (cls, fields(28)))
    val Reconditionings: FielderMultiple = parse_attributes (attribute (cls, fields(29)))
    val ReliabilityInfos: FielderMultiple = parse_attributes (attribute (cls, fields(30)))
    val ReplacementWorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(31)))
    val ScheduledEvents: FielderMultiple = parse_attributes (attribute (cls, fields(32)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(33)))

    def parse (context: Context): Asset =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0,0)
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
            mask (`type` (), 10),
            mask (utcNumber (), 11),
            masks (ActivityRecords (), 12),
            mask (AssetContainer (), 13),
            mask (AssetInfo (), 14),
            masks (AssetPropertyCurves (), 15),
            masks (ConfigurationEvents (), 16),
            mask (ErpInventory (), 17),
            mask (ErpItemMaster (), 18),
            masks (ErpRecDeliveryItems (), 19),
            mask (FinancialInfo (), 20),
            mask (Location (), 21),
            masks (Measurements (), 22),
            masks (Mediums (), 23),
            masks (OperationTags (), 24),
            masks (OrganisationRoles (), 25),
            masks (Ownerships (), 26),
            masks (PowerSystemResources (), 27),
            masks (Procedures (), 28),
            masks (Reconditionings (), 29),
            masks (ReliabilityInfos (), 30),
            masks (ReplacementWorkTasks (), 31),
            masks (ScheduledEvents (), 32),
            masks (WorkTasks (), 33)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Asset that is aggregation of other assets such as conductors, transformers, switchgear, land, fences, buildings, equipment, vehicles, etc.
 *
 * @param sup [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param Assets [[ch.ninecode.model.Asset Asset]] All assets within this container asset.
 * @param LandProperties [[ch.ninecode.model.LandProperty LandProperty]] <em>undocumented</em>
 * @param Seals [[ch.ninecode.model.Seal Seal]] All seals applied to this asset container.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class AssetContainer
(
    override val sup: Asset,
    Assets: List[String],
    LandProperties: List[String],
    Seals: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List(), List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AssetContainer.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (AssetContainer.fields (position), x))
        emitattrs (0, Assets)
        emitattrs (1, LandProperties)
        emitattrs (2, Seals)
        s.toString
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
    override val fields: Array[String] = Array[String] (
        "Assets",
        "LandProperties",
        "Seals"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Assets", "Asset", "0..*", "0..1"),
        Relationship ("LandProperties", "LandProperty", "0..*", "0..*"),
        Relationship ("Seals", "Seal", "0..*", "0..1")
    )
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val LandProperties: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Seals: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): AssetContainer =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AssetContainer (
            Asset.parse (context),
            masks (Assets (), 0),
            masks (LandProperties (), 1),
            masks (Seals (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
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
    override val fields: Array[String] = Array[String] (
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
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AssetFunction (
            IdentifiedObject.parse (context),
            mask (configID (), 0),
            mask (firmwareID (), 1),
            mask (hardwareID (), 2),
            mask (password (), 3),
            mask (programID (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
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
 * @param Assets [[ch.ninecode.model.Asset Asset]] All assets described by this data.
 * @param PowerSystemResources [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] All power system resources with this datasheet information.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class AssetInfo
(
    override val sup: IdentifiedObject,
    AssetModel: String,
    Assets: List[String],
    PowerSystemResources: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), List()) }
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
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AssetInfo.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (AssetInfo.fields (position), x))
        emitattr (0, AssetModel)
        emitattrs (1, Assets)
        emitattrs (2, PowerSystemResources)
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
    override val fields: Array[String] = Array[String] (
        "AssetModel",
        "Assets",
        "PowerSystemResources"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AssetModel", "AssetModel", "0..1", "0..1"),
        Relationship ("Assets", "Asset", "0..*", "0..1"),
        Relationship ("PowerSystemResources", "PowerSystemResource", "0..*", "0..1")
    )
    val AssetModel: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val PowerSystemResources: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): AssetInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AssetInfo (
            IdentifiedObject.parse (context),
            mask (AssetModel (), 0),
            masks (Assets (), 1),
            masks (PowerSystemResources (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (AssetLocationHazard.fields (position), x))
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
    override val fields: Array[String] = Array[String] (
        "Locations"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Locations", "Location", "0..*", "0..*")
    )
    val Locations: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): AssetLocationHazard =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AssetLocationHazard (
            Hazard.parse (context),
            masks (Locations (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model of an asset, either a product of a specific manufacturer or a generic asset model or material item.
 *
 * Datasheet characteristics are available through the associated AssetInfo subclass and can be shared with asset or power system resource instances.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param AssetInfo [[ch.ninecode.model.AssetInfo AssetInfo]] Data applicable to this asset model.
 * @param ErpInventoryCounts [[ch.ninecode.model.ErpInventoryCount ErpInventoryCount]] <em>undocumented</em>
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class AssetModel
(
    override val sup: IdentifiedObject,
    AssetInfo: String,
    ErpInventoryCounts: List[String]
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
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AssetModel.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (AssetModel.fields (position), x))
        emitattr (0, AssetInfo)
        emitattrs (1, ErpInventoryCounts)
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
    override val fields: Array[String] = Array[String] (
        "AssetInfo",
        "ErpInventoryCounts"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AssetInfo", "AssetInfo", "0..1", "0..1"),
        Relationship ("ErpInventoryCounts", "ErpInventoryCount", "0..*", "0..1")
    )
    val AssetInfo: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ErpInventoryCounts: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): AssetModel =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AssetModel (
            IdentifiedObject.parse (context),
            mask (AssetInfo (), 0),
            masks (ErpInventoryCounts (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Role an organisation plays with respect to asset.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param Assets [[ch.ninecode.model.Asset Asset]] All assets for this organisation role.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class AssetOrganisationRole
(
    override val sup: OrganisationRole,
    Assets: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AssetOrganisationRole.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (AssetOrganisationRole.fields (position), x))
        emitattrs (0, Assets)
        s.toString
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
    override val fields: Array[String] = Array[String] (
        "Assets"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Assets", "Asset", "0..*", "0..*")
    )
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): AssetOrganisationRole =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AssetOrganisationRole (
            OrganisationRole.parse (context),
            masks (Assets (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Owner of the asset.
 *
 * @param sup [[ch.ninecode.model.AssetOrganisationRole AssetOrganisationRole]] Reference to the superclass object.
 * @param Ownerships [[ch.ninecode.model.Ownership Ownership]] All ownerships of this owner.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class AssetOwner
(
    override val sup: AssetOrganisationRole,
    Ownerships: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AssetOwner.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (AssetOwner.fields (position), x))
        emitattrs (0, Ownerships)
        s.toString
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
    override val fields: Array[String] = Array[String] (
        "Ownerships"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Ownerships", "Ownership", "0..*", "0..1")
    )
    val Ownerships: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): AssetOwner =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AssetOwner (
            AssetOrganisationRole.parse (context),
            masks (Ownerships (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
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
    override val fields: Array[String] = Array[String] (
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
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LifecycleDate (
            BasicElement.parse (context),
            mask (installationDate (), 0),
            mask (manufacturedDate (), 1),
            mask (purchaseDate (), 2),
            mask (receivedDate (), 3),
            mask (removalDate (), 4),
            mask (retiredDate (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
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
}

/**
 * Organisation that manufactures asset products.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param ProductAssetModels [[ch.ninecode.model.ProductAssetModel ProductAssetModel]] All asset models by this manufacturer.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
case class Manufacturer
(
    override val sup: OrganisationRole,
    ProductAssetModels: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Manufacturer.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Manufacturer.fields (position), x))
        emitattrs (0, ProductAssetModels)
        s.toString
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
    override val fields: Array[String] = Array[String] (
        "ProductAssetModels"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProductAssetModels", "ProductAssetModel", "0..*", "0..1")
    )
    val ProductAssetModels: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): Manufacturer =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Manufacturer (
            OrganisationRole.parse (context),
            masks (ProductAssetModels (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Documented procedure for various types of work or work tasks on assets.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param instruction Textual description of this procedure.
 * @param kind Kind of procedure.
 * @param sequenceNumber Sequence number in a sequence of procedures being performed.
 * @param Assets [[ch.ninecode.model.Asset Asset]] All assets to which this procedure applies.
 * @param CompatibleUnits [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param Limits [[ch.ninecode.model.Limit Limit]] <em>undocumented</em>
 * @param Measurements [[ch.ninecode.model.Measurement Measurement]] Document containing this measurement.
 * @param ProcedureDataSets [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] All data sets captured by this procedure.
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
    CompatibleUnits: List[String],
    Limits: List[String],
    Measurements: List[String],
    ProcedureDataSets: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), List(), List(), List(), List()) }
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
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Procedure.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Procedure.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Procedure.fields (position), x))
        emitelem (0, instruction)
        emitattr (1, kind)
        emitelem (2, sequenceNumber)
        emitattrs (3, Assets)
        emitattrs (4, CompatibleUnits)
        emitattrs (5, Limits)
        emitattrs (6, Measurements)
        emitattrs (7, ProcedureDataSets)
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
    override val fields: Array[String] = Array[String] (
        "instruction",
        "kind",
        "sequenceNumber",
        "Assets",
        "CompatibleUnits",
        "Limits",
        "Measurements",
        "ProcedureDataSets"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Assets", "Asset", "0..*", "0..*"),
        Relationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..*"),
        Relationship ("Limits", "Limit", "0..*", "0..*"),
        Relationship ("Measurements", "Measurement", "0..*", "0..*"),
        Relationship ("ProcedureDataSets", "ProcedureDataSet", "0..*", "0..1")
    )
    val instruction: Fielder = parse_element (element (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(2)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Limits: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val Measurements: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val ProcedureDataSets: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): Procedure =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Procedure (
            Document.parse (context),
            mask (instruction (), 0),
            mask (kind (), 1),
            mask (sequenceNumber (), 2),
            masks (Assets (), 3),
            masks (CompatibleUnits (), 4),
            masks (Limits (), 5),
            masks (Measurements (), 6),
            masks (ProcedureDataSets (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
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
 * @param Properties [[ch.ninecode.model.UserAttribute UserAttribute]] UserAttributes used to specify further properties of this procedure data set.
 *        Use 'name' to specify what kind of property it is, and 'value.value' attribute for the actual value.
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
    Properties: List[String],
    TransformerObservations: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), null, List(), List()) }
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
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProcedureDataSet.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ProcedureDataSet.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ProcedureDataSet.fields (position), x))
        emitelem (0, completedDateTime)
        emitattrs (1, MeasurementValues)
        emitattr (2, Procedure)
        emitattrs (3, Properties)
        emitattrs (4, TransformerObservations)
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
    override val fields: Array[String] = Array[String] (
        "completedDateTime",
        "MeasurementValues",
        "Procedure",
        "Properties",
        "TransformerObservations"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MeasurementValues", "MeasurementValue", "0..*", "0..*"),
        Relationship ("Procedure", "Procedure", "0..1", "0..*"),
        Relationship ("Properties", "UserAttribute", "0..*", "0..*"),
        Relationship ("TransformerObservations", "TransformerObservation", "0..*", "0..*")
    )
    val completedDateTime: Fielder = parse_element (element (cls, fields(0)))
    val MeasurementValues: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Procedure: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Properties: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val TransformerObservations: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): ProcedureDataSet =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ProcedureDataSet (
            Document.parse (context),
            mask (completedDateTime (), 0),
            masks (MeasurementValues (), 1),
            mask (Procedure (), 2),
            masks (Properties (), 3),
            masks (TransformerObservations (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
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
 * @param AssetModelCatalogueItems [[ch.ninecode.model.AssetModelCatalogueItem AssetModelCatalogueItem]] <em>undocumented</em>
 * @param GenericAssetModelOrMaterial [[ch.ninecode.model.GenericAssetModelOrMaterial GenericAssetModelOrMaterial]] Generic asset model or material satisified by this product asset model.
 * @param Manufacturer [[ch.ninecode.model.Manufacturer Manufacturer]] Manufacturer of this asset model.
 * @param OperationalRestrictions [[ch.ninecode.model.OperationalRestriction OperationalRestriction]] All operational restrictions applying to this asset model.
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
    AssetModelCatalogueItems: List[String],
    GenericAssetModelOrMaterial: String,
    Manufacturer: String,
    OperationalRestrictions: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, 0.0, List(), null, null, List()) }
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
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProductAssetModel.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ProductAssetModel.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ProductAssetModel.fields (position), x))
        emitattr (0, corporateStandardKind)
        emitelem (1, modelNumber)
        emitelem (2, modelVersion)
        emitattr (3, usageKind)
        emitelem (4, weightTotal)
        emitattrs (5, AssetModelCatalogueItems)
        emitattr (6, GenericAssetModelOrMaterial)
        emitattr (7, Manufacturer)
        emitattrs (8, OperationalRestrictions)
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
    override val fields: Array[String] = Array[String] (
        "corporateStandardKind",
        "modelNumber",
        "modelVersion",
        "usageKind",
        "weightTotal",
        "AssetModelCatalogueItems",
        "GenericAssetModelOrMaterial",
        "Manufacturer",
        "OperationalRestrictions"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AssetModelCatalogueItems", "AssetModelCatalogueItem", "0..*", "0..1"),
        Relationship ("GenericAssetModelOrMaterial", "GenericAssetModelOrMaterial", "0..1", "0..*"),
        Relationship ("Manufacturer", "Manufacturer", "0..1", "0..*"),
        Relationship ("OperationalRestrictions", "OperationalRestriction", "0..*", "0..1")
    )
    val corporateStandardKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val modelNumber: Fielder = parse_element (element (cls, fields(1)))
    val modelVersion: Fielder = parse_element (element (cls, fields(2)))
    val usageKind: Fielder = parse_attribute (attribute (cls, fields(3)))
    val weightTotal: Fielder = parse_element (element (cls, fields(4)))
    val AssetModelCatalogueItems: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val GenericAssetModelOrMaterial: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Manufacturer: Fielder = parse_attribute (attribute (cls, fields(7)))
    val OperationalRestrictions: FielderMultiple = parse_attributes (attribute (cls, fields(8)))

    def parse (context: Context): ProductAssetModel =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ProductAssetModel (
            AssetModel.parse (context),
            mask (corporateStandardKind (), 0),
            mask (modelNumber (), 1),
            mask (modelVersion (), 2),
            mask (usageKind (), 3),
            toDouble (mask (weightTotal (), 4)),
            masks (AssetModelCatalogueItems (), 5),
            mask (GenericAssetModelOrMaterial (), 6),
            mask (Manufacturer (), 7),
            masks (OperationalRestrictions (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
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
    override val fields: Array[String] = Array[String] (
        "appliedDateTime",
        "condition",
        "kind",
        "sealNumber",
        "AssetContainer"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AssetContainer", "AssetContainer", "0..1", "0..*")
    )
    val appliedDateTime: Fielder = parse_element (element (cls, fields(0)))
    val condition: Fielder = parse_attribute (attribute (cls, fields(1)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val sealNumber: Fielder = parse_element (element (cls, fields(3)))
    val AssetContainer: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): Seal =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Seal (
            IdentifiedObject.parse (context),
            mask (appliedDateTime (), 0),
            mask (condition (), 1),
            mask (kind (), 2),
            mask (sealNumber (), 3),
            mask (AssetContainer (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
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