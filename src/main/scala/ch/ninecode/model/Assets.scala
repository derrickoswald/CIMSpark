package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */

/**
 * Acceptance test for assets.
 */
case class AcceptanceTest
(

    override val sup: BasicElement,

    /**
     * Date and time the asset was last tested using the 'type' of test and yielding the current status in 'success' attribute.
     */
    val dateTime: String,

    /**
     * True if asset has passed acceptance test and may be placed in or is in service.
     * It is set to false if asset is removed from service and is required to be tested again before being placed back in service, possibly in a new location. Since asset may go through multiple tests during its lifecycle, the date of each acceptance test may be recorded in 'Asset.ActivityRecord.status.dateTime'.
     */
    val success: Boolean,

    /**
     * Type of test or group of tests that was conducted on 'dateTime'.
     */
    val typ: String
)
extends
    Element
{
    def this () = { this (null, null, false, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AcceptanceTest]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AcceptanceTest
extends
    Parseable[AcceptanceTest]
{
    val sup = BasicElement.parse _
    val dateTime = parse_element (element ("""AcceptanceTest.dateTime"""))_
    val success = parse_element (element ("""AcceptanceTest.success"""))_
    val typ = parse_element (element ("""AcceptanceTest.type"""))_
    def parse (context: Context): AcceptanceTest =
    {
        AcceptanceTest(
            sup (context),
            dateTime (context),
            toBoolean (success (context), context),
            typ (context)
        )
    }
}

/**
 * Tangible resource of the utility, including power system equipment, various end devices, cabinets, buildings, etc.
 * For electrical network equipment, the role of the asset is defined through PowerSystemResource and its subclasses, defined mainly in the Wires model (refer to IEC61970-301 and model package IEC61970::Wires). Asset description places emphasis on the physical characteristics of the equipment fulfilling that role.
 */
case class Asset
(

    override val sup: IdentifiedObject,

    /**
     * Information on acceptance test.
     */
    val acceptanceTest: String,

    /**
     * True if asset is considered critical for some reason (for example, a pole with critical attachments).
     */
    val critical: Boolean,

    /**
     * Electronic address.
     */
    val electronicAddress: String,

    /**
     * Condition of asset in inventory or at time of installation.
     * Examples include new, rebuilt, overhaul required, other. Refer to inspection data for information on the most current condition of the asset.
     */
    val initialCondition: String,

    /**
     * Whenever an asset is reconditioned, percentage of expected life for the asset when it was new; zero for new devices.
     */
    val initialLossOfLife: Double,

    /**
     * Lifecycle dates for this asset.
     */
    val lifecycle: String,

    /**
     * Lot number for this asset.
     * Even for the same model and version number, many assets are manufactured in lots.
     */
    val lotNumber: String,

    /**
     * Purchase price of asset.
     */
    val purchasePrice: Double,

    /**
     * Serial number of this asset.
     */
    val serialNumber: String,

    /**
     * Status of this asset.
     */
    val status: String,

    /**
     * Utility-specific classification of Asset and its subtypes, according to their corporate standards, practices, and existing IT systems (e.g., for management of assets, maintenance, work, outage, customers, etc.).
     */
    val typ: String,

    /**
     * Uniquely tracked commodity (UTC) number.
     */
    val utcNumber: String,

    /**
     * All activity records created for this asset.
     */
    val ActivityRecords: List[String],

    /**
     * Container of this asset.
     */
    val AssetContainer: String,

    /**
     * Data applicable to this asset.
     */
    val AssetInfo: String,

    val AssetPropertyCurves: List[String],

    val ErpInventory: String,

    val ErpItemMaster: String,

    val ErpRecDeliveryItems: List[String],

    val FinancialInfo: String,

    /**
     * Location of this asset.
     */
    val Location: String,

    /**
     * All roles an organisation plays for this asset.
     */
    val OrganisationRoles: List[String],

    /**
     * All power system resources used to electrically model this asset.
     * For example, transformer asset is electrically modelled with a transformer and its windings and tap changer.
     */
    val PowerSystemResources: List[String]
)
extends
    Element
{
    def this () = { this (null, null, false, null, null, 0.0, null, null, 0.0, null, null, null, null, List(), null, null, List(), null, null, List(), null, null, List(), List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Asset]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Asset
extends
    Parseable[Asset]
{
    val sup = IdentifiedObject.parse _
    val acceptanceTest = parse_attribute (attribute ("""Asset.acceptanceTest"""))_
    val critical = parse_element (element ("""Asset.critical"""))_
    val electronicAddress = parse_attribute (attribute ("""Asset.electronicAddress"""))_
    val initialCondition = parse_element (element ("""Asset.initialCondition"""))_
    val initialLossOfLife = parse_element (element ("""Asset.initialLossOfLife"""))_
    val lifecycle = parse_attribute (attribute ("""Asset.lifecycle"""))_
    val lotNumber = parse_element (element ("""Asset.lotNumber"""))_
    val purchasePrice = parse_element (element ("""Asset.purchasePrice"""))_
    val serialNumber = parse_element (element ("""Asset.serialNumber"""))_
    val status = parse_attribute (attribute ("""Asset.status"""))_
    val typ = parse_element (element ("""Asset.type"""))_
    val utcNumber = parse_element (element ("""Asset.utcNumber"""))_
    val ActivityRecords = parse_attributes (attribute ("""Asset.ActivityRecords"""))_
    val AssetContainer = parse_attribute (attribute ("""Asset.AssetContainer"""))_
    val AssetInfo = parse_attribute (attribute ("""Asset.AssetInfo"""))_
    val AssetPropertyCurves = parse_attributes (attribute ("""Asset.AssetPropertyCurves"""))_
    val ErpInventory = parse_attribute (attribute ("""Asset.ErpInventory"""))_
    val ErpItemMaster = parse_attribute (attribute ("""Asset.ErpItemMaster"""))_
    val ErpRecDeliveryItems = parse_attributes (attribute ("""Asset.ErpRecDeliveryItems"""))_
    val FinancialInfo = parse_attribute (attribute ("""Asset.FinancialInfo"""))_
    val Location = parse_attribute (attribute ("""Asset.Location"""))_
    val OrganisationRoles = parse_attributes (attribute ("""Asset.OrganisationRoles"""))_
    val PowerSystemResources = parse_attributes (attribute ("""Asset.PowerSystemResources"""))_
    def parse (context: Context): Asset =
    {
        Asset(
            sup (context),
            acceptanceTest (context),
            toBoolean (critical (context), context),
            electronicAddress (context),
            initialCondition (context),
            toDouble (initialLossOfLife (context), context),
            lifecycle (context),
            lotNumber (context),
            toDouble (purchasePrice (context), context),
            serialNumber (context),
            status (context),
            typ (context),
            utcNumber (context),
            ActivityRecords (context),
            AssetContainer (context),
            AssetInfo (context),
            AssetPropertyCurves (context),
            ErpInventory (context),
            ErpItemMaster (context),
            ErpRecDeliveryItems (context),
            FinancialInfo (context),
            Location (context),
            OrganisationRoles (context),
            PowerSystemResources (context)
        )
    }
}

/**
 * Asset that is aggregation of other assets such as conductors, transformers, switchgear, land, fences, buildings, equipment, vehicles, etc.
 */
case class AssetContainer
(

    override val sup: Asset
)
extends
    Element
{
    def this () = { this (null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetContainer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetContainer
extends
    Parseable[AssetContainer]
{
    val sup = Asset.parse _
    def parse (context: Context): AssetContainer =
    {
        AssetContainer(
            sup (context)
        )
    }
}

/**
 * Function performed by an asset.
 */
case class AssetFunction
(

    override val sup: IdentifiedObject,

    /**
     * Configuration specified for this function.
     */
    val configID: String,

    /**
     * Firmware version.
     */
    val firmwareID: String,

    /**
     * Hardware version.
     */
    val hardwareID: String,

    /**
     * Password needed to access this function.
     */
    val password: String,

    /**
     * Name of program.
     */
    val programID: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetFunction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetFunction
extends
    Parseable[AssetFunction]
{
    val sup = IdentifiedObject.parse _
    val configID = parse_element (element ("""AssetFunction.configID"""))_
    val firmwareID = parse_element (element ("""AssetFunction.firmwareID"""))_
    val hardwareID = parse_element (element ("""AssetFunction.hardwareID"""))_
    val password = parse_element (element ("""AssetFunction.password"""))_
    val programID = parse_element (element ("""AssetFunction.programID"""))_
    def parse (context: Context): AssetFunction =
    {
        AssetFunction(
            sup (context),
            configID (context),
            firmwareID (context),
            hardwareID (context),
            password (context),
            programID (context)
        )
    }
}

/**
 * Set of attributes of an asset, representing typical datasheet information of a physical device that can be instantiated and shared in different data exchange contexts:
- as attributes of an asset instance (installed or in stock)
- as attributes of an asset model (product by a manufacturer)
 * - as attributes of a type asset (generic type of an asset as used in designs/extension planning).
 */
case class AssetInfo
(

    override val sup: IdentifiedObject,

    /**
     * Asset model described by this data.
     */
    val AssetModel: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetInfo
extends
    Parseable[AssetInfo]
{
    val sup = IdentifiedObject.parse _
    val AssetModel = parse_attribute (attribute ("""AssetInfo.AssetModel"""))_
    def parse (context: Context): AssetInfo =
    {
        AssetInfo(
            sup (context),
            AssetModel (context)
        )
    }
}

/**
 * Potential hazard related to the location of an asset.
 * Examples are trees growing under overhead power lines, a park being located by a substation (i.e., children climb fence to recover a ball), a lake near an overhead distribution line (fishing pole/line contacting power lines), dangerous neighbour, etc.
 */
case class AssetLocationHazard
(

    override val sup: Hazard,

    /**
     * The location of this hazard.
     */
    val Locations: List[String]
)
extends
    Element
{
    def this () = { this (null, List()) }
    def Hazard: Hazard = sup.asInstanceOf[Hazard]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetLocationHazard]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetLocationHazard
extends
    Parseable[AssetLocationHazard]
{
    val sup = Hazard.parse _
    val Locations = parse_attributes (attribute ("""AssetLocationHazard.Locations"""))_
    def parse (context: Context): AssetLocationHazard =
    {
        AssetLocationHazard(
            sup (context),
            Locations (context)
        )
    }
}

/**
 * Model of an asset, either a product of a specific manufacturer or a generic asset model or material item.
 * Datasheet characteristics are available through the associated AssetInfo subclass and can be shared with asset or power system resource instances.
 */
case class AssetModel
(

    override val sup: IdentifiedObject,

    /**
     * Data applicable to this asset model.
     */
    val AssetInfo: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetModel]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetModel
extends
    Parseable[AssetModel]
{
    val sup = IdentifiedObject.parse _
    val AssetInfo = parse_attribute (attribute ("""AssetModel.AssetInfo"""))_
    def parse (context: Context): AssetModel =
    {
        AssetModel(
            sup (context),
            AssetInfo (context)
        )
    }
}

/**
 * Usage for an asset model.
 */
case class AssetModelUsageKind
(

    override val sup: BasicElement,

    /**
     * Asset model is intended for use in customer substation.
     */
    val customerSubstation: String,

    /**
     * Asset model is intended for use in distribution overhead network.
     */
    val distributionOverhead: String,

    /**
     * Asset model is intended for use in underground distribution network.
     */
    val distributionUnderground: String,

    /**
     * Other kind of asset model usage.
     */
    val other: String,

    /**
     * Asset model is intended for use as streetlight.
     */
    val streetlight: String,

    /**
     * Asset model is intended for use in substation.
     */
    val substation: String,

    /**
     * Asset model is intended for use in transmission network.
     */
    val transmission: String,

    /**
     * Usage of the asset model is unknown.
     */
    val unknown: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetModelUsageKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetModelUsageKind
extends
    Parseable[AssetModelUsageKind]
{
    val sup = BasicElement.parse _
    val customerSubstation = parse_attribute (attribute ("""AssetModelUsageKind.customerSubstation"""))_
    val distributionOverhead = parse_attribute (attribute ("""AssetModelUsageKind.distributionOverhead"""))_
    val distributionUnderground = parse_attribute (attribute ("""AssetModelUsageKind.distributionUnderground"""))_
    val other = parse_attribute (attribute ("""AssetModelUsageKind.other"""))_
    val streetlight = parse_attribute (attribute ("""AssetModelUsageKind.streetlight"""))_
    val substation = parse_attribute (attribute ("""AssetModelUsageKind.substation"""))_
    val transmission = parse_attribute (attribute ("""AssetModelUsageKind.transmission"""))_
    val unknown = parse_attribute (attribute ("""AssetModelUsageKind.unknown"""))_
    def parse (context: Context): AssetModelUsageKind =
    {
        AssetModelUsageKind(
            sup (context),
            customerSubstation (context),
            distributionOverhead (context),
            distributionUnderground (context),
            other (context),
            streetlight (context),
            substation (context),
            transmission (context),
            unknown (context)
        )
    }
}

/**
 * Role an organisation plays with respect to asset.
 */
case class AssetOrganisationRole
(

    override val sup: OrganisationRole
)
extends
    Element
{
    def this () = { this (null) }
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetOrganisationRole]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetOrganisationRole
extends
    Parseable[AssetOrganisationRole]
{
    val sup = OrganisationRole.parse _
    def parse (context: Context): AssetOrganisationRole =
    {
        AssetOrganisationRole(
            sup (context)
        )
    }
}

/**
 * Owner of the asset.
 */
case class AssetOwner
(

    override val sup: AssetOrganisationRole
)
extends
    Element
{
    def this () = { this (null) }
    def AssetOrganisationRole: AssetOrganisationRole = sup.asInstanceOf[AssetOrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetOwner]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetOwner
extends
    Parseable[AssetOwner]
{
    val sup = AssetOrganisationRole.parse _
    def parse (context: Context): AssetOwner =
    {
        AssetOwner(
            sup (context)
        )
    }
}

/**
 * Organisation that is a user of the asset.
 */
case class AssetUser
(

    override val sup: AssetOrganisationRole
)
extends
    Element
{
    def this () = { this (null) }
    def AssetOrganisationRole: AssetOrganisationRole = sup.asInstanceOf[AssetOrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetUser]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetUser
extends
    Parseable[AssetUser]
{
    val sup = AssetOrganisationRole.parse _
    def parse (context: Context): AssetUser =
    {
        AssetUser(
            sup (context)
        )
    }
}

/**
 * Communication media such as fibre optic cable, power-line, telephone, etc.
 */
case class ComMedia
(

    override val sup: Asset
)
extends
    Element
{
    def this () = { this (null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[ComMedia]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ComMedia
extends
    Parseable[ComMedia]
{
    val sup = Asset.parse _
    def parse (context: Context): ComMedia =
    {
        ComMedia(
            sup (context)
        )
    }
}

/**
 * Kind of corporate standard.
 */
case class CorporateStandardKind
(

    override val sup: BasicElement,

    /**
     * Asset model is used experimentally.
     */
    val experimental: String,

    /**
     * Other kind of corporate standard for the asset model.
     */
    val other: String,

    /**
     * Asset model is used as corporate standard.
     */
    val standard: String,

    /**
     * Asset model usage is under evaluation.
     */
    val underEvaluation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CorporateStandardKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CorporateStandardKind
extends
    Parseable[CorporateStandardKind]
{
    val sup = BasicElement.parse _
    val experimental = parse_attribute (attribute ("""CorporateStandardKind.experimental"""))_
    val other = parse_attribute (attribute ("""CorporateStandardKind.other"""))_
    val standard = parse_attribute (attribute ("""CorporateStandardKind.standard"""))_
    val underEvaluation = parse_attribute (attribute ("""CorporateStandardKind.underEvaluation"""))_
    def parse (context: Context): CorporateStandardKind =
    {
        CorporateStandardKind(
            sup (context),
            experimental (context),
            other (context),
            standard (context),
            underEvaluation (context)
        )
    }
}

/**
 * Dates for lifecycle events of an asset.
 */
case class LifecycleDate
(

    override val sup: BasicElement,

    /**
     * (if applicable) Date current installation was completed, which may not be the same as the in-service date.
     * Asset may have been installed at other locations previously. Ignored if asset is (1) not currently installed (e.g., stored in a depot) or (2) not intended to be installed (e.g., vehicle, tool).
     */
    val installationDate: String,

    /**
     * Date the asset was manufactured.
     */
    val manufacturedDate: String,

    /**
     * Date the asset was purchased.
     * Note that even though an asset may have been purchased, it may not have been received into inventory at the time of purchase.
     */
    val purchaseDate: String,

    /**
     * Date the asset was received and first placed into inventory.
     */
    val receivedDate: String,

    /**
     * (if applicable) Date when the asset was last removed from service.
     * Ignored if (1) not intended to be in service, or (2) currently in service.
     */
    val removalDate: String,

    /**
     * (if applicable) Date the asset is permanently retired from service and may be scheduled for disposal.
     * Ignored if asset is (1) currently in service, or (2) permanently removed from service.
     */
    val retiredDate: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[LifecycleDate]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LifecycleDate
extends
    Parseable[LifecycleDate]
{
    val sup = BasicElement.parse _
    val installationDate = parse_element (element ("""LifecycleDate.installationDate"""))_
    val manufacturedDate = parse_element (element ("""LifecycleDate.manufacturedDate"""))_
    val purchaseDate = parse_element (element ("""LifecycleDate.purchaseDate"""))_
    val receivedDate = parse_element (element ("""LifecycleDate.receivedDate"""))_
    val removalDate = parse_element (element ("""LifecycleDate.removalDate"""))_
    val retiredDate = parse_element (element ("""LifecycleDate.retiredDate"""))_
    def parse (context: Context): LifecycleDate =
    {
        LifecycleDate(
            sup (context),
            installationDate (context),
            manufacturedDate (context),
            purchaseDate (context),
            receivedDate (context),
            removalDate (context),
            retiredDate (context)
        )
    }
}

/**
 * Organisation that maintains assets.
 */
case class Maintainer
(

    override val sup: AssetOrganisationRole
)
extends
    Element
{
    def this () = { this (null) }
    def AssetOrganisationRole: AssetOrganisationRole = sup.asInstanceOf[AssetOrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[Maintainer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Maintainer
extends
    Parseable[Maintainer]
{
    val sup = AssetOrganisationRole.parse _
    def parse (context: Context): Maintainer =
    {
        Maintainer(
            sup (context)
        )
    }
}

/**
 * Organisation that manufactures asset products.
 */
case class Manufacturer
(

    override val sup: OrganisationRole
)
extends
    Element
{
    def this () = { this (null) }
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[Manufacturer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Manufacturer
extends
    Parseable[Manufacturer]
{
    val sup = OrganisationRole.parse _
    def parse (context: Context): Manufacturer =
    {
        Manufacturer(
            sup (context)
        )
    }
}

/**
 * Documented procedure for various types of work or work tasks on assets.
 */
case class Procedure
(

    override val sup: Document,

    /**
     * Textual description of this procedure.
     */
    val instruction: String,

    /**
     * Kind of procedure.
     */
    val kind: String,

    /**
     * Sequence number in a sequence of procedures being performed.
     */
    val sequenceNumber: String,

    /**
     * All assets to which this procedure applies.
     */
    val Assets: List[String],

    val Limits: List[String],

    /**
     * Document containing this measurement.
     */
    val Measurements: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, List(), List(), List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[Procedure]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Procedure
extends
    Parseable[Procedure]
{
    val sup = Document.parse _
    val instruction = parse_element (element ("""Procedure.instruction"""))_
    val kind = parse_attribute (attribute ("""Procedure.kind"""))_
    val sequenceNumber = parse_element (element ("""Procedure.sequenceNumber"""))_
    val Assets = parse_attributes (attribute ("""Procedure.Assets"""))_
    val Limits = parse_attributes (attribute ("""Procedure.Limits"""))_
    val Measurements = parse_attributes (attribute ("""Procedure.Measurements"""))_
    def parse (context: Context): Procedure =
    {
        Procedure(
            sup (context),
            instruction (context),
            kind (context),
            sequenceNumber (context),
            Assets (context),
            Limits (context),
            Measurements (context)
        )
    }
}

/**
 * A data set recorded each time a procedure is executed.
 * Observed results are captured in associated measurement values and/or values for properties relevant to the type of procedure performed.
 */
case class ProcedureDataSet
(

    override val sup: Document,

    /**
     * Date and time procedure was completed.
     */
    val completedDateTime: String,

    val MeasurementValues: List[String],

    /**
     * Procedure capturing this data set.
     */
    val Procedure: String,

    val TransformerObservations: List[String]
)
extends
    Element
{
    def this () = { this (null, null, List(), null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[ProcedureDataSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProcedureDataSet
extends
    Parseable[ProcedureDataSet]
{
    val sup = Document.parse _
    val completedDateTime = parse_element (element ("""ProcedureDataSet.completedDateTime"""))_
    val MeasurementValues = parse_attributes (attribute ("""ProcedureDataSet.MeasurementValues"""))_
    val Procedure = parse_attribute (attribute ("""ProcedureDataSet.Procedure"""))_
    val TransformerObservations = parse_attributes (attribute ("""ProcedureDataSet.TransformerObservations"""))_
    def parse (context: Context): ProcedureDataSet =
    {
        ProcedureDataSet(
            sup (context),
            completedDateTime (context),
            MeasurementValues (context),
            Procedure (context),
            TransformerObservations (context)
        )
    }
}

/**
 * Kind of procedure.
 */
case class ProcedureKind
(

    override val sup: BasicElement,

    val diagnosis: String,

    val inspection: String,

    val maintenance: String,

    val other: String,

    val test: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ProcedureKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProcedureKind
extends
    Parseable[ProcedureKind]
{
    val sup = BasicElement.parse _
    val diagnosis = parse_attribute (attribute ("""ProcedureKind.diagnosis"""))_
    val inspection = parse_attribute (attribute ("""ProcedureKind.inspection"""))_
    val maintenance = parse_attribute (attribute ("""ProcedureKind.maintenance"""))_
    val other = parse_attribute (attribute ("""ProcedureKind.other"""))_
    val test = parse_attribute (attribute ("""ProcedureKind.test"""))_
    def parse (context: Context): ProcedureKind =
    {
        ProcedureKind(
            sup (context),
            diagnosis (context),
            inspection (context),
            maintenance (context),
            other (context),
            test (context)
        )
    }
}

/**
 * Asset model by a specific manufacturer.
 */
case class ProductAssetModel
(

    override val sup: AssetModel,

    /**
     * Kind of corporate standard for this asset model.
     */
    val corporateStandardKind: String,

    /**
     * Manufacturer's model number.
     */
    val modelNumber: String,

    /**
     * Version number for product model, which indicates vintage of the product.
     */
    val modelVersion: String,

    /**
     * Intended usage for this asset model.
     */
    val usageKind: String,

    /**
     * Total manufactured weight of asset.
     */
    val weightTotal: Double,

    /**
     * Generic asset model or material satisified by this product asset model.
     */
    val GenericAssetModelOrMaterial: String,

    /**
     * Manufacturer of this asset model.
     */
    val Manufacturer: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0.0, null, null) }
    def AssetModel: AssetModel = sup.asInstanceOf[AssetModel]
    override def copy (): Row = { return (clone ().asInstanceOf[ProductAssetModel]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProductAssetModel
extends
    Parseable[ProductAssetModel]
{
    val sup = AssetModel.parse _
    val corporateStandardKind = parse_attribute (attribute ("""ProductAssetModel.corporateStandardKind"""))_
    val modelNumber = parse_element (element ("""ProductAssetModel.modelNumber"""))_
    val modelVersion = parse_element (element ("""ProductAssetModel.modelVersion"""))_
    val usageKind = parse_attribute (attribute ("""ProductAssetModel.usageKind"""))_
    val weightTotal = parse_element (element ("""ProductAssetModel.weightTotal"""))_
    val GenericAssetModelOrMaterial = parse_attribute (attribute ("""ProductAssetModel.GenericAssetModelOrMaterial"""))_
    val Manufacturer = parse_attribute (attribute ("""ProductAssetModel.Manufacturer"""))_
    def parse (context: Context): ProductAssetModel =
    {
        ProductAssetModel(
            sup (context),
            corporateStandardKind (context),
            modelNumber (context),
            modelVersion (context),
            usageKind (context),
            toDouble (weightTotal (context), context),
            GenericAssetModelOrMaterial (context),
            Manufacturer (context)
        )
    }
}

/**
 * Physically controls access to AssetContainers.
 */
case class Seal
(

    override val sup: IdentifiedObject,

    /**
     * Date and time this seal has been applied.
     */
    val appliedDateTime: String,

    /**
     * Condition of seal.
     */
    val condition: String,

    /**
     * Kind of seal.
     */
    val kind: String,

    /**
     * (reserved word) Seal number.
     */
    val sealNumber: String,

    /**
     * Asset container to which this seal is applied.
     */
    val AssetContainer: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Seal]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Seal
extends
    Parseable[Seal]
{
    val sup = IdentifiedObject.parse _
    val appliedDateTime = parse_element (element ("""Seal.appliedDateTime"""))_
    val condition = parse_attribute (attribute ("""Seal.condition"""))_
    val kind = parse_attribute (attribute ("""Seal.kind"""))_
    val sealNumber = parse_element (element ("""Seal.sealNumber"""))_
    val AssetContainer = parse_attribute (attribute ("""Seal.AssetContainer"""))_
    def parse (context: Context): Seal =
    {
        Seal(
            sup (context),
            appliedDateTime (context),
            condition (context),
            kind (context),
            sealNumber (context),
            AssetContainer (context)
        )
    }
}

/**
 * Kind of seal condition.
 */
case class SealConditionKind
(

    override val sup: BasicElement,

    /**
     * Seal is broken.
     */
    val broken: String,

    /**
     * Seal is locked.
     */
    val locked: String,

    /**
     * Seal is missing.
     */
    val missing: String,

    /**
     * Seal is open.
     */
    val open: String,

    /**
     * Other kind of seal condition.
     */
    val other: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SealConditionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SealConditionKind
extends
    Parseable[SealConditionKind]
{
    val sup = BasicElement.parse _
    val broken = parse_attribute (attribute ("""SealConditionKind.broken"""))_
    val locked = parse_attribute (attribute ("""SealConditionKind.locked"""))_
    val missing = parse_attribute (attribute ("""SealConditionKind.missing"""))_
    val open = parse_attribute (attribute ("""SealConditionKind.open"""))_
    val other = parse_attribute (attribute ("""SealConditionKind.other"""))_
    def parse (context: Context): SealConditionKind =
    {
        SealConditionKind(
            sup (context),
            broken (context),
            locked (context),
            missing (context),
            open (context),
            other (context)
        )
    }
}

/**
 * Kind of seal.
 */
case class SealKind
(

    override val sup: BasicElement,

    /**
     * Lead seal.
     */
    val lead: String,

    /**
     * Lock seal.
     */
    val lock1: String,

    /**
     * Other kind of seal.
     */
    val other: String,

    /**
     * Steel seal.
     */
    val steel: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SealKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SealKind
extends
    Parseable[SealKind]
{
    val sup = BasicElement.parse _
    val lead = parse_attribute (attribute ("""SealKind.lead"""))_
    val lock1 = parse_attribute (attribute ("""SealKind.lock"""))_
    val other = parse_attribute (attribute ("""SealKind.other"""))_
    val steel = parse_attribute (attribute ("""SealKind.steel"""))_
    def parse (context: Context): SealKind =
    {
        SealKind(
            sup (context),
            lead (context),
            lock1 (context),
            other (context),
            steel (context)
        )
    }
}

object _Assets
{
    def register: Unit =
    {
        AcceptanceTest.register
        Asset.register
        AssetContainer.register
        AssetFunction.register
        AssetInfo.register
        AssetLocationHazard.register
        AssetModel.register
        AssetModelUsageKind.register
        AssetOrganisationRole.register
        AssetOwner.register
        AssetUser.register
        ComMedia.register
        CorporateStandardKind.register
        LifecycleDate.register
        Maintainer.register
        Manufacturer.register
        Procedure.register
        ProcedureDataSet.register
        ProcedureKind.register
        ProductAssetModel.register
        Seal.register
        SealConditionKind.register
        SealKind.register
    }
}