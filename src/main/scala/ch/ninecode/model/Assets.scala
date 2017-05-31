package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */

/**
 * Acceptance test for assets.
 * @param sup Reference to the superclass object.
 * @param dateTime Date and time the asset was last tested using the 'type' of test and yielding the current status in 'success' attribute.
 * @param success True if asset has passed acceptance test and may be placed in or is in service.
 *        It is set to false if asset is removed from service and is required to be tested again before being placed back in service, possibly in a new location. Since asset may go through multiple tests during its lifecycle, the date of each acceptance test may be recorded in 'Asset.ActivityRecord.status.dateTime'.
 * @param typ Type of test or group of tests that was conducted on 'dateTime'.
 */
case class AcceptanceTest
(
    override val sup: BasicElement,
    val dateTime: String,
    val success: Boolean,
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
    val dateTime = parse_element (element ("""AcceptanceTest.dateTime"""))
    val success = parse_element (element ("""AcceptanceTest.success"""))
    val typ = parse_element (element ("""AcceptanceTest.type"""))
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
 * @param sup Reference to the superclass object.
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
 * @param ActivityRecords All activity records created for this asset.
 * @param AssetContainer Container of this asset.
 * @param AssetInfo Data applicable to this asset.
 * @param AssetPropertyCurves
 * @param ErpInventory
 * @param ErpItemMaster
 * @param ErpRecDeliveryItems
 * @param FinancialInfo
 * @param Location Location of this asset.
 * @param OrganisationRoles All roles an organisation plays for this asset.
 * @param PowerSystemResources All power system resources used to electrically model this asset.
 *        For example, transformer asset is electrically modelled with a transformer and its windings and tap changer.
 */
case class Asset
(
    override val sup: IdentifiedObject,
    val acceptanceTest: String,
    val critical: Boolean,
    val electronicAddress: String,
    val initialCondition: String,
    val initialLossOfLife: Double,
    val lifecycle: String,
    val lotNumber: String,
    val purchasePrice: Double,
    val serialNumber: String,
    val status: String,
    val typ: String,
    val utcNumber: String,
    val ActivityRecords: List[String],
    val AssetContainer: String,
    val AssetInfo: String,
    val AssetPropertyCurves: List[String],
    val ErpInventory: String,
    val ErpItemMaster: String,
    val ErpRecDeliveryItems: List[String],
    val FinancialInfo: String,
    val Location: String,
    val OrganisationRoles: List[String],
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
    val acceptanceTest = parse_attribute (attribute ("""Asset.acceptanceTest"""))
    val critical = parse_element (element ("""Asset.critical"""))
    val electronicAddress = parse_attribute (attribute ("""Asset.electronicAddress"""))
    val initialCondition = parse_element (element ("""Asset.initialCondition"""))
    val initialLossOfLife = parse_element (element ("""Asset.initialLossOfLife"""))
    val lifecycle = parse_attribute (attribute ("""Asset.lifecycle"""))
    val lotNumber = parse_element (element ("""Asset.lotNumber"""))
    val purchasePrice = parse_element (element ("""Asset.purchasePrice"""))
    val serialNumber = parse_element (element ("""Asset.serialNumber"""))
    val status = parse_attribute (attribute ("""Asset.status"""))
    val typ = parse_element (element ("""Asset.type"""))
    val utcNumber = parse_element (element ("""Asset.utcNumber"""))
    val ActivityRecords = parse_attributes (attribute ("""Asset.ActivityRecords"""))
    val AssetContainer = parse_attribute (attribute ("""Asset.AssetContainer"""))
    val AssetInfo = parse_attribute (attribute ("""Asset.AssetInfo"""))
    val AssetPropertyCurves = parse_attributes (attribute ("""Asset.AssetPropertyCurves"""))
    val ErpInventory = parse_attribute (attribute ("""Asset.ErpInventory"""))
    val ErpItemMaster = parse_attribute (attribute ("""Asset.ErpItemMaster"""))
    val ErpRecDeliveryItems = parse_attributes (attribute ("""Asset.ErpRecDeliveryItems"""))
    val FinancialInfo = parse_attribute (attribute ("""Asset.FinancialInfo"""))
    val Location = parse_attribute (attribute ("""Asset.Location"""))
    val OrganisationRoles = parse_attributes (attribute ("""Asset.OrganisationRoles"""))
    val PowerSystemResources = parse_attributes (attribute ("""Asset.PowerSystemResources"""))
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
 * @param configID Configuration specified for this function.
 * @param firmwareID Firmware version.
 * @param hardwareID Hardware version.
 * @param password Password needed to access this function.
 * @param programID Name of program.
 */
case class AssetFunction
(
    override val sup: IdentifiedObject,
    val configID: String,
    val firmwareID: String,
    val hardwareID: String,
    val password: String,
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
    val configID = parse_element (element ("""AssetFunction.configID"""))
    val firmwareID = parse_element (element ("""AssetFunction.firmwareID"""))
    val hardwareID = parse_element (element ("""AssetFunction.hardwareID"""))
    val password = parse_element (element ("""AssetFunction.password"""))
    val programID = parse_element (element ("""AssetFunction.programID"""))
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
 * @param sup Reference to the superclass object.
 * @param AssetModel Asset model described by this data.
 */
case class AssetInfo
(
    override val sup: IdentifiedObject,
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
    val AssetModel = parse_attribute (attribute ("""AssetInfo.AssetModel"""))
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
 * @param sup Reference to the superclass object.
 * @param Locations The location of this hazard.
 */
case class AssetLocationHazard
(
    override val sup: Hazard,
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
    val Locations = parse_attributes (attribute ("""AssetLocationHazard.Locations"""))
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
 * @param sup Reference to the superclass object.
 * @param AssetInfo Data applicable to this asset model.
 */
case class AssetModel
(
    override val sup: IdentifiedObject,
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
    val AssetInfo = parse_attribute (attribute ("""AssetModel.AssetInfo"""))
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
 * @param sup Reference to the superclass object.
 * @param customerSubstation Asset model is intended for use in customer substation.
 * @param distributionOverhead Asset model is intended for use in distribution overhead network.
 * @param distributionUnderground Asset model is intended for use in underground distribution network.
 * @param other Other kind of asset model usage.
 * @param streetlight Asset model is intended for use as streetlight.
 * @param substation Asset model is intended for use in substation.
 * @param transmission Asset model is intended for use in transmission network.
 * @param unknown Usage of the asset model is unknown.
 */
case class AssetModelUsageKind
(
    override val sup: BasicElement,
    val customerSubstation: String,
    val distributionOverhead: String,
    val distributionUnderground: String,
    val other: String,
    val streetlight: String,
    val substation: String,
    val transmission: String,
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
    val customerSubstation = parse_attribute (attribute ("""AssetModelUsageKind.customerSubstation"""))
    val distributionOverhead = parse_attribute (attribute ("""AssetModelUsageKind.distributionOverhead"""))
    val distributionUnderground = parse_attribute (attribute ("""AssetModelUsageKind.distributionUnderground"""))
    val other = parse_attribute (attribute ("""AssetModelUsageKind.other"""))
    val streetlight = parse_attribute (attribute ("""AssetModelUsageKind.streetlight"""))
    val substation = parse_attribute (attribute ("""AssetModelUsageKind.substation"""))
    val transmission = parse_attribute (attribute ("""AssetModelUsageKind.transmission"""))
    val unknown = parse_attribute (attribute ("""AssetModelUsageKind.unknown"""))
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
 * @param experimental Asset model is used experimentally.
 * @param other Other kind of corporate standard for the asset model.
 * @param standard Asset model is used as corporate standard.
 * @param underEvaluation Asset model usage is under evaluation.
 */
case class CorporateStandardKind
(
    override val sup: BasicElement,
    val experimental: String,
    val other: String,
    val standard: String,
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
    val experimental = parse_attribute (attribute ("""CorporateStandardKind.experimental"""))
    val other = parse_attribute (attribute ("""CorporateStandardKind.other"""))
    val standard = parse_attribute (attribute ("""CorporateStandardKind.standard"""))
    val underEvaluation = parse_attribute (attribute ("""CorporateStandardKind.underEvaluation"""))
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
 */
case class LifecycleDate
(
    override val sup: BasicElement,
    val installationDate: String,
    val manufacturedDate: String,
    val purchaseDate: String,
    val receivedDate: String,
    val removalDate: String,
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
    val installationDate = parse_element (element ("""LifecycleDate.installationDate"""))
    val manufacturedDate = parse_element (element ("""LifecycleDate.manufacturedDate"""))
    val purchaseDate = parse_element (element ("""LifecycleDate.purchaseDate"""))
    val receivedDate = parse_element (element ("""LifecycleDate.receivedDate"""))
    val removalDate = parse_element (element ("""LifecycleDate.removalDate"""))
    val retiredDate = parse_element (element ("""LifecycleDate.retiredDate"""))
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
 * @param instruction Textual description of this procedure.
 * @param kind Kind of procedure.
 * @param sequenceNumber Sequence number in a sequence of procedures being performed.
 * @param Assets All assets to which this procedure applies.
 * @param Limits
 * @param Measurements Document containing this measurement.
 */
case class Procedure
(
    override val sup: Document,
    val instruction: String,
    val kind: String,
    val sequenceNumber: String,
    val Assets: List[String],
    val Limits: List[String],
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
    val instruction = parse_element (element ("""Procedure.instruction"""))
    val kind = parse_attribute (attribute ("""Procedure.kind"""))
    val sequenceNumber = parse_element (element ("""Procedure.sequenceNumber"""))
    val Assets = parse_attributes (attribute ("""Procedure.Assets"""))
    val Limits = parse_attributes (attribute ("""Procedure.Limits"""))
    val Measurements = parse_attributes (attribute ("""Procedure.Measurements"""))
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
 * @param sup Reference to the superclass object.
 * @param completedDateTime Date and time procedure was completed.
 * @param MeasurementValues
 * @param Procedure Procedure capturing this data set.
 * @param TransformerObservations
 */
case class ProcedureDataSet
(
    override val sup: Document,
    val completedDateTime: String,
    val MeasurementValues: List[String],
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
    val completedDateTime = parse_element (element ("""ProcedureDataSet.completedDateTime"""))
    val MeasurementValues = parse_attributes (attribute ("""ProcedureDataSet.MeasurementValues"""))
    val Procedure = parse_attribute (attribute ("""ProcedureDataSet.Procedure"""))
    val TransformerObservations = parse_attributes (attribute ("""ProcedureDataSet.TransformerObservations"""))
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
 * @param sup Reference to the superclass object.
 * @param diagnosis
 * @param inspection
 * @param maintenance
 * @param other
 * @param test
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
    val diagnosis = parse_attribute (attribute ("""ProcedureKind.diagnosis"""))
    val inspection = parse_attribute (attribute ("""ProcedureKind.inspection"""))
    val maintenance = parse_attribute (attribute ("""ProcedureKind.maintenance"""))
    val other = parse_attribute (attribute ("""ProcedureKind.other"""))
    val test = parse_attribute (attribute ("""ProcedureKind.test"""))
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
 * @param sup Reference to the superclass object.
 * @param corporateStandardKind Kind of corporate standard for this asset model.
 * @param modelNumber Manufacturer's model number.
 * @param modelVersion Version number for product model, which indicates vintage of the product.
 * @param usageKind Intended usage for this asset model.
 * @param weightTotal Total manufactured weight of asset.
 * @param GenericAssetModelOrMaterial Generic asset model or material satisified by this product asset model.
 * @param Manufacturer Manufacturer of this asset model.
 */
case class ProductAssetModel
(
    override val sup: AssetModel,
    val corporateStandardKind: String,
    val modelNumber: String,
    val modelVersion: String,
    val usageKind: String,
    val weightTotal: Double,
    val GenericAssetModelOrMaterial: String,
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
    val corporateStandardKind = parse_attribute (attribute ("""ProductAssetModel.corporateStandardKind"""))
    val modelNumber = parse_element (element ("""ProductAssetModel.modelNumber"""))
    val modelVersion = parse_element (element ("""ProductAssetModel.modelVersion"""))
    val usageKind = parse_attribute (attribute ("""ProductAssetModel.usageKind"""))
    val weightTotal = parse_element (element ("""ProductAssetModel.weightTotal"""))
    val GenericAssetModelOrMaterial = parse_attribute (attribute ("""ProductAssetModel.GenericAssetModelOrMaterial"""))
    val Manufacturer = parse_attribute (attribute ("""ProductAssetModel.Manufacturer"""))
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
 * @param sup Reference to the superclass object.
 * @param appliedDateTime Date and time this seal has been applied.
 * @param condition Condition of seal.
 * @param kind Kind of seal.
 * @param sealNumber (reserved word) Seal number.
 * @param AssetContainer Asset container to which this seal is applied.
 */
case class Seal
(
    override val sup: IdentifiedObject,
    val appliedDateTime: String,
    val condition: String,
    val kind: String,
    val sealNumber: String,
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
    val appliedDateTime = parse_element (element ("""Seal.appliedDateTime"""))
    val condition = parse_attribute (attribute ("""Seal.condition"""))
    val kind = parse_attribute (attribute ("""Seal.kind"""))
    val sealNumber = parse_element (element ("""Seal.sealNumber"""))
    val AssetContainer = parse_attribute (attribute ("""Seal.AssetContainer"""))
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
 * @param sup Reference to the superclass object.
 * @param broken Seal is broken.
 * @param locked Seal is locked.
 * @param missing Seal is missing.
 * @param open Seal is open.
 * @param other Other kind of seal condition.
 */
case class SealConditionKind
(
    override val sup: BasicElement,
    val broken: String,
    val locked: String,
    val missing: String,
    val open: String,
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
    val broken = parse_attribute (attribute ("""SealConditionKind.broken"""))
    val locked = parse_attribute (attribute ("""SealConditionKind.locked"""))
    val missing = parse_attribute (attribute ("""SealConditionKind.missing"""))
    val open = parse_attribute (attribute ("""SealConditionKind.open"""))
    val other = parse_attribute (attribute ("""SealConditionKind.other"""))
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
 * @param sup Reference to the superclass object.
 * @param lead Lead seal.
 * @param lock1 Lock seal.
 * @param other Other kind of seal.
 * @param steel Steel seal.
 */
case class SealKind
(
    override val sup: BasicElement,
    val lead: String,
    val lock1: String,
    val other: String,
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
    val lead = parse_attribute (attribute ("""SealKind.lead"""))
    val lock1 = parse_attribute (attribute ("""SealKind.lock"""))
    val other = parse_attribute (attribute ("""SealKind.other"""))
    val steel = parse_attribute (attribute ("""SealKind.steel"""))
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