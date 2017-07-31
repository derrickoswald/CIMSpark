package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.CIMSubsetter
import ch.ninecode.cim.Parseable

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
        sup.export_fields +
        (if (null != dateTime) "\t\t<cim:AcceptanceTest.dateTime>" + dateTime + "</cim:AcceptanceTest.dateTime>\n" else "") +
        "\t\t<cim:AcceptanceTest.success>" + success + "</cim:AcceptanceTest.success>\n" +
        (if (null != typ) "\t\t<cim:AcceptanceTest.type>" + typ + "</cim:AcceptanceTest.type>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AcceptanceTest rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AcceptanceTest>\n"
    }
}

object AcceptanceTest
extends
    Parseable[AcceptanceTest]
{
    val dateTime = parse_element (element ("""AcceptanceTest.dateTime"""))
    val success = parse_element (element ("""AcceptanceTest.success"""))
    val typ = parse_element (element ("""AcceptanceTest.type"""))
    def parse (context: Context): AcceptanceTest =
    {
        AcceptanceTest(
            BasicElement.parse (context),
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
        sup.export_fields +
        (if (null != acceptanceTest) "\t\t<cim:Asset.acceptanceTest rdf:resource=\"#" + acceptanceTest + "\"/>\n" else "") +
        "\t\t<cim:Asset.critical>" + critical + "</cim:Asset.critical>\n" +
        (if (null != electronicAddress) "\t\t<cim:Asset.electronicAddress rdf:resource=\"#" + electronicAddress + "\"/>\n" else "") +
        (if (null != initialCondition) "\t\t<cim:Asset.initialCondition>" + initialCondition + "</cim:Asset.initialCondition>\n" else "") +
        "\t\t<cim:Asset.initialLossOfLife>" + initialLossOfLife + "</cim:Asset.initialLossOfLife>\n" +
        (if (null != lifecycle) "\t\t<cim:Asset.lifecycle rdf:resource=\"#" + lifecycle + "\"/>\n" else "") +
        (if (null != lotNumber) "\t\t<cim:Asset.lotNumber>" + lotNumber + "</cim:Asset.lotNumber>\n" else "") +
        "\t\t<cim:Asset.purchasePrice>" + purchasePrice + "</cim:Asset.purchasePrice>\n" +
        (if (null != serialNumber) "\t\t<cim:Asset.serialNumber>" + serialNumber + "</cim:Asset.serialNumber>\n" else "") +
        (if (null != status) "\t\t<cim:Asset.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:Asset.type>" + typ + "</cim:Asset.type>\n" else "") +
        (if (null != utcNumber) "\t\t<cim:Asset.utcNumber>" + utcNumber + "</cim:Asset.utcNumber>\n" else "") +
        (if (null != ActivityRecords) ActivityRecords.map (x => "\t\t<cim:Asset.ActivityRecords rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != AssetContainer) "\t\t<cim:Asset.AssetContainer rdf:resource=\"#" + AssetContainer + "\"/>\n" else "") +
        (if (null != AssetInfo) "\t\t<cim:Asset.AssetInfo rdf:resource=\"#" + AssetInfo + "\"/>\n" else "") +
        (if (null != AssetPropertyCurves) AssetPropertyCurves.map (x => "\t\t<cim:Asset.AssetPropertyCurves rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ErpInventory) "\t\t<cim:Asset.ErpInventory rdf:resource=\"#" + ErpInventory + "\"/>\n" else "") +
        (if (null != ErpItemMaster) "\t\t<cim:Asset.ErpItemMaster rdf:resource=\"#" + ErpItemMaster + "\"/>\n" else "") +
        (if (null != ErpRecDeliveryItems) ErpRecDeliveryItems.map (x => "\t\t<cim:Asset.ErpRecDeliveryItems rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != FinancialInfo) "\t\t<cim:Asset.FinancialInfo rdf:resource=\"#" + FinancialInfo + "\"/>\n" else "") +
        (if (null != Location) "\t\t<cim:Asset.Location rdf:resource=\"#" + Location + "\"/>\n" else "") +
        (if (null != OrganisationRoles) OrganisationRoles.map (x => "\t\t<cim:Asset.OrganisationRoles rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != PowerSystemResources) PowerSystemResources.map (x => "\t\t<cim:Asset.PowerSystemResources rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Asset rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Asset>\n"
    }
}

object Asset
extends
    Parseable[Asset]
{
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
            IdentifiedObject.parse (context),
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:AssetContainer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AssetContainer>\n"
    }
}

object AssetContainer
extends
    Parseable[AssetContainer]
{
    def parse (context: Context): AssetContainer =
    {
        AssetContainer(
            Asset.parse (context)
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
        sup.export_fields +
        (if (null != configID) "\t\t<cim:AssetFunction.configID>" + configID + "</cim:AssetFunction.configID>\n" else "") +
        (if (null != firmwareID) "\t\t<cim:AssetFunction.firmwareID>" + firmwareID + "</cim:AssetFunction.firmwareID>\n" else "") +
        (if (null != hardwareID) "\t\t<cim:AssetFunction.hardwareID>" + hardwareID + "</cim:AssetFunction.hardwareID>\n" else "") +
        (if (null != password) "\t\t<cim:AssetFunction.password>" + password + "</cim:AssetFunction.password>\n" else "") +
        (if (null != programID) "\t\t<cim:AssetFunction.programID>" + programID + "</cim:AssetFunction.programID>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AssetFunction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AssetFunction>\n"
    }
}

object AssetFunction
extends
    Parseable[AssetFunction]
{
    val configID = parse_element (element ("""AssetFunction.configID"""))
    val firmwareID = parse_element (element ("""AssetFunction.firmwareID"""))
    val hardwareID = parse_element (element ("""AssetFunction.hardwareID"""))
    val password = parse_element (element ("""AssetFunction.password"""))
    val programID = parse_element (element ("""AssetFunction.programID"""))
    def parse (context: Context): AssetFunction =
    {
        AssetFunction(
            IdentifiedObject.parse (context),
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
        sup.export_fields +
        (if (null != AssetModel) "\t\t<cim:AssetInfo.AssetModel rdf:resource=\"#" + AssetModel + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AssetInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AssetInfo>\n"
    }
}

object AssetInfo
extends
    Parseable[AssetInfo]
{
    val AssetModel = parse_attribute (attribute ("""AssetInfo.AssetModel"""))
    def parse (context: Context): AssetInfo =
    {
        AssetInfo(
            IdentifiedObject.parse (context),
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
        sup.export_fields +
        (if (null != Locations) Locations.map (x => "\t\t<cim:AssetLocationHazard.Locations rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:AssetLocationHazard rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AssetLocationHazard>\n"
    }
}

object AssetLocationHazard
extends
    Parseable[AssetLocationHazard]
{
    val Locations = parse_attributes (attribute ("""AssetLocationHazard.Locations"""))
    def parse (context: Context): AssetLocationHazard =
    {
        AssetLocationHazard(
            Hazard.parse (context),
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
        sup.export_fields +
        (if (null != AssetInfo) "\t\t<cim:AssetModel.AssetInfo rdf:resource=\"#" + AssetInfo + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AssetModel rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AssetModel>\n"
    }
}

object AssetModel
extends
    Parseable[AssetModel]
{
    val AssetInfo = parse_attribute (attribute ("""AssetModel.AssetInfo"""))
    def parse (context: Context): AssetModel =
    {
        AssetModel(
            IdentifiedObject.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[AssetModelUsageKind] }
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
        (if (null != customerSubstation) "\t\t<cim:AssetModelUsageKind.customerSubstation rdf:resource=\"#" + customerSubstation + "\"/>\n" else "") +
        (if (null != distributionOverhead) "\t\t<cim:AssetModelUsageKind.distributionOverhead rdf:resource=\"#" + distributionOverhead + "\"/>\n" else "") +
        (if (null != distributionUnderground) "\t\t<cim:AssetModelUsageKind.distributionUnderground rdf:resource=\"#" + distributionUnderground + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:AssetModelUsageKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != streetlight) "\t\t<cim:AssetModelUsageKind.streetlight rdf:resource=\"#" + streetlight + "\"/>\n" else "") +
        (if (null != substation) "\t\t<cim:AssetModelUsageKind.substation rdf:resource=\"#" + substation + "\"/>\n" else "") +
        (if (null != transmission) "\t\t<cim:AssetModelUsageKind.transmission rdf:resource=\"#" + transmission + "\"/>\n" else "") +
        (if (null != unknown) "\t\t<cim:AssetModelUsageKind.unknown rdf:resource=\"#" + unknown + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AssetModelUsageKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AssetModelUsageKind>\n"
    }
}

object AssetModelUsageKind
extends
    Parseable[AssetModelUsageKind]
{
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
            BasicElement.parse (context),
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:AssetOrganisationRole rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AssetOrganisationRole>\n"
    }
}

object AssetOrganisationRole
extends
    Parseable[AssetOrganisationRole]
{
    def parse (context: Context): AssetOrganisationRole =
    {
        AssetOrganisationRole(
            OrganisationRole.parse (context)
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:AssetOwner rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AssetOwner>\n"
    }
}

object AssetOwner
extends
    Parseable[AssetOwner]
{
    def parse (context: Context): AssetOwner =
    {
        AssetOwner(
            AssetOrganisationRole.parse (context)
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:AssetUser rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AssetUser>\n"
    }
}

object AssetUser
extends
    Parseable[AssetUser]
{
    def parse (context: Context): AssetUser =
    {
        AssetUser(
            AssetOrganisationRole.parse (context)
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ComMedia rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ComMedia>\n"
    }
}

object ComMedia
extends
    Parseable[ComMedia]
{
    def parse (context: Context): ComMedia =
    {
        ComMedia(
            Asset.parse (context)
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
    override def copy (): Row = { clone ().asInstanceOf[CorporateStandardKind] }
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
        (if (null != experimental) "\t\t<cim:CorporateStandardKind.experimental rdf:resource=\"#" + experimental + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:CorporateStandardKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != standard) "\t\t<cim:CorporateStandardKind.standard rdf:resource=\"#" + standard + "\"/>\n" else "") +
        (if (null != underEvaluation) "\t\t<cim:CorporateStandardKind.underEvaluation rdf:resource=\"#" + underEvaluation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CorporateStandardKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CorporateStandardKind>\n"
    }
}

object CorporateStandardKind
extends
    Parseable[CorporateStandardKind]
{
    val experimental = parse_attribute (attribute ("""CorporateStandardKind.experimental"""))
    val other = parse_attribute (attribute ("""CorporateStandardKind.other"""))
    val standard = parse_attribute (attribute ("""CorporateStandardKind.standard"""))
    val underEvaluation = parse_attribute (attribute ("""CorporateStandardKind.underEvaluation"""))
    def parse (context: Context): CorporateStandardKind =
    {
        CorporateStandardKind(
            BasicElement.parse (context),
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
        sup.export_fields +
        (if (null != installationDate) "\t\t<cim:LifecycleDate.installationDate>" + installationDate + "</cim:LifecycleDate.installationDate>\n" else "") +
        (if (null != manufacturedDate) "\t\t<cim:LifecycleDate.manufacturedDate>" + manufacturedDate + "</cim:LifecycleDate.manufacturedDate>\n" else "") +
        (if (null != purchaseDate) "\t\t<cim:LifecycleDate.purchaseDate>" + purchaseDate + "</cim:LifecycleDate.purchaseDate>\n" else "") +
        (if (null != receivedDate) "\t\t<cim:LifecycleDate.receivedDate>" + receivedDate + "</cim:LifecycleDate.receivedDate>\n" else "") +
        (if (null != removalDate) "\t\t<cim:LifecycleDate.removalDate>" + removalDate + "</cim:LifecycleDate.removalDate>\n" else "") +
        (if (null != retiredDate) "\t\t<cim:LifecycleDate.retiredDate>" + retiredDate + "</cim:LifecycleDate.retiredDate>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LifecycleDate rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LifecycleDate>\n"
    }
}

object LifecycleDate
extends
    Parseable[LifecycleDate]
{
    val installationDate = parse_element (element ("""LifecycleDate.installationDate"""))
    val manufacturedDate = parse_element (element ("""LifecycleDate.manufacturedDate"""))
    val purchaseDate = parse_element (element ("""LifecycleDate.purchaseDate"""))
    val receivedDate = parse_element (element ("""LifecycleDate.receivedDate"""))
    val removalDate = parse_element (element ("""LifecycleDate.removalDate"""))
    val retiredDate = parse_element (element ("""LifecycleDate.retiredDate"""))
    def parse (context: Context): LifecycleDate =
    {
        LifecycleDate(
            BasicElement.parse (context),
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:Maintainer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Maintainer>\n"
    }
}

object Maintainer
extends
    Parseable[Maintainer]
{
    def parse (context: Context): Maintainer =
    {
        Maintainer(
            AssetOrganisationRole.parse (context)
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:Manufacturer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Manufacturer>\n"
    }
}

object Manufacturer
extends
    Parseable[Manufacturer]
{
    def parse (context: Context): Manufacturer =
    {
        Manufacturer(
            OrganisationRole.parse (context)
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
        sup.export_fields +
        (if (null != instruction) "\t\t<cim:Procedure.instruction>" + instruction + "</cim:Procedure.instruction>\n" else "") +
        (if (null != kind) "\t\t<cim:Procedure.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != sequenceNumber) "\t\t<cim:Procedure.sequenceNumber>" + sequenceNumber + "</cim:Procedure.sequenceNumber>\n" else "") +
        (if (null != Assets) Assets.map (x => "\t\t<cim:Procedure.Assets rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Limits) Limits.map (x => "\t\t<cim:Procedure.Limits rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Measurements) Measurements.map (x => "\t\t<cim:Procedure.Measurements rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Procedure rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Procedure>\n"
    }
}

object Procedure
extends
    Parseable[Procedure]
{
    val instruction = parse_element (element ("""Procedure.instruction"""))
    val kind = parse_attribute (attribute ("""Procedure.kind"""))
    val sequenceNumber = parse_element (element ("""Procedure.sequenceNumber"""))
    val Assets = parse_attributes (attribute ("""Procedure.Assets"""))
    val Limits = parse_attributes (attribute ("""Procedure.Limits"""))
    val Measurements = parse_attributes (attribute ("""Procedure.Measurements"""))
    def parse (context: Context): Procedure =
    {
        Procedure(
            Document.parse (context),
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
        sup.export_fields +
        (if (null != completedDateTime) "\t\t<cim:ProcedureDataSet.completedDateTime>" + completedDateTime + "</cim:ProcedureDataSet.completedDateTime>\n" else "") +
        (if (null != MeasurementValues) MeasurementValues.map (x => "\t\t<cim:ProcedureDataSet.MeasurementValues rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Procedure) "\t\t<cim:ProcedureDataSet.Procedure rdf:resource=\"#" + Procedure + "\"/>\n" else "") +
        (if (null != TransformerObservations) TransformerObservations.map (x => "\t\t<cim:ProcedureDataSet.TransformerObservations rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:ProcedureDataSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ProcedureDataSet>\n"
    }
}

object ProcedureDataSet
extends
    Parseable[ProcedureDataSet]
{
    val completedDateTime = parse_element (element ("""ProcedureDataSet.completedDateTime"""))
    val MeasurementValues = parse_attributes (attribute ("""ProcedureDataSet.MeasurementValues"""))
    val Procedure = parse_attribute (attribute ("""ProcedureDataSet.Procedure"""))
    val TransformerObservations = parse_attributes (attribute ("""ProcedureDataSet.TransformerObservations"""))
    def parse (context: Context): ProcedureDataSet =
    {
        ProcedureDataSet(
            Document.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[ProcedureKind] }
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
        (if (null != diagnosis) "\t\t<cim:ProcedureKind.diagnosis rdf:resource=\"#" + diagnosis + "\"/>\n" else "") +
        (if (null != inspection) "\t\t<cim:ProcedureKind.inspection rdf:resource=\"#" + inspection + "\"/>\n" else "") +
        (if (null != maintenance) "\t\t<cim:ProcedureKind.maintenance rdf:resource=\"#" + maintenance + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:ProcedureKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != test) "\t\t<cim:ProcedureKind.test rdf:resource=\"#" + test + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ProcedureKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ProcedureKind>\n"
    }
}

object ProcedureKind
extends
    Parseable[ProcedureKind]
{
    val diagnosis = parse_attribute (attribute ("""ProcedureKind.diagnosis"""))
    val inspection = parse_attribute (attribute ("""ProcedureKind.inspection"""))
    val maintenance = parse_attribute (attribute ("""ProcedureKind.maintenance"""))
    val other = parse_attribute (attribute ("""ProcedureKind.other"""))
    val test = parse_attribute (attribute ("""ProcedureKind.test"""))
    def parse (context: Context): ProcedureKind =
    {
        ProcedureKind(
            BasicElement.parse (context),
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
        sup.export_fields +
        (if (null != corporateStandardKind) "\t\t<cim:ProductAssetModel.corporateStandardKind rdf:resource=\"#" + corporateStandardKind + "\"/>\n" else "") +
        (if (null != modelNumber) "\t\t<cim:ProductAssetModel.modelNumber>" + modelNumber + "</cim:ProductAssetModel.modelNumber>\n" else "") +
        (if (null != modelVersion) "\t\t<cim:ProductAssetModel.modelVersion>" + modelVersion + "</cim:ProductAssetModel.modelVersion>\n" else "") +
        (if (null != usageKind) "\t\t<cim:ProductAssetModel.usageKind rdf:resource=\"#" + usageKind + "\"/>\n" else "") +
        "\t\t<cim:ProductAssetModel.weightTotal>" + weightTotal + "</cim:ProductAssetModel.weightTotal>\n" +
        (if (null != GenericAssetModelOrMaterial) "\t\t<cim:ProductAssetModel.GenericAssetModelOrMaterial rdf:resource=\"#" + GenericAssetModelOrMaterial + "\"/>\n" else "") +
        (if (null != Manufacturer) "\t\t<cim:ProductAssetModel.Manufacturer rdf:resource=\"#" + Manufacturer + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ProductAssetModel rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ProductAssetModel>\n"
    }
}

object ProductAssetModel
extends
    Parseable[ProductAssetModel]
{
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
            AssetModel.parse (context),
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
        sup.export_fields +
        (if (null != appliedDateTime) "\t\t<cim:Seal.appliedDateTime>" + appliedDateTime + "</cim:Seal.appliedDateTime>\n" else "") +
        (if (null != condition) "\t\t<cim:Seal.condition rdf:resource=\"#" + condition + "\"/>\n" else "") +
        (if (null != kind) "\t\t<cim:Seal.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != sealNumber) "\t\t<cim:Seal.sealNumber>" + sealNumber + "</cim:Seal.sealNumber>\n" else "") +
        (if (null != AssetContainer) "\t\t<cim:Seal.AssetContainer rdf:resource=\"#" + AssetContainer + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Seal rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Seal>\n"
    }
}

object Seal
extends
    Parseable[Seal]
{
    val appliedDateTime = parse_element (element ("""Seal.appliedDateTime"""))
    val condition = parse_attribute (attribute ("""Seal.condition"""))
    val kind = parse_attribute (attribute ("""Seal.kind"""))
    val sealNumber = parse_element (element ("""Seal.sealNumber"""))
    val AssetContainer = parse_attribute (attribute ("""Seal.AssetContainer"""))
    def parse (context: Context): Seal =
    {
        Seal(
            IdentifiedObject.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[SealConditionKind] }
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
        (if (null != broken) "\t\t<cim:SealConditionKind.broken rdf:resource=\"#" + broken + "\"/>\n" else "") +
        (if (null != locked) "\t\t<cim:SealConditionKind.locked rdf:resource=\"#" + locked + "\"/>\n" else "") +
        (if (null != missing) "\t\t<cim:SealConditionKind.missing rdf:resource=\"#" + missing + "\"/>\n" else "") +
        (if (null != open) "\t\t<cim:SealConditionKind.open rdf:resource=\"#" + open + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:SealConditionKind.other rdf:resource=\"#" + other + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SealConditionKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SealConditionKind>\n"
    }
}

object SealConditionKind
extends
    Parseable[SealConditionKind]
{
    val broken = parse_attribute (attribute ("""SealConditionKind.broken"""))
    val locked = parse_attribute (attribute ("""SealConditionKind.locked"""))
    val missing = parse_attribute (attribute ("""SealConditionKind.missing"""))
    val open = parse_attribute (attribute ("""SealConditionKind.open"""))
    val other = parse_attribute (attribute ("""SealConditionKind.other"""))
    def parse (context: Context): SealConditionKind =
    {
        SealConditionKind(
            BasicElement.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[SealKind] }
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
        (if (null != lead) "\t\t<cim:SealKind.lead rdf:resource=\"#" + lead + "\"/>\n" else "") +
        (if (null != lock1) "\t\t<cim:SealKind.lock rdf:resource=\"#" + lock1 + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:SealKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != steel) "\t\t<cim:SealKind.steel rdf:resource=\"#" + steel + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SealKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SealKind>\n"
    }
}

object SealKind
extends
    Parseable[SealKind]
{
    val lead = parse_attribute (attribute ("""SealKind.lead"""))
    val lock1 = parse_attribute (attribute ("""SealKind.lock"""))
    val other = parse_attribute (attribute ("""SealKind.other"""))
    val steel = parse_attribute (attribute ("""SealKind.steel"""))
    def parse (context: Context): SealKind =
    {
        SealKind(
            BasicElement.parse (context),
            lead (context),
            lock1 (context),
            other (context),
            steel (context)
        )
    }
}

object _Assets
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
            AssetModelUsageKind.register,
            AssetOrganisationRole.register,
            AssetOwner.register,
            AssetUser.register,
            ComMedia.register,
            CorporateStandardKind.register,
            LifecycleDate.register,
            Maintainer.register,
            Manufacturer.register,
            Procedure.register,
            ProcedureDataSet.register,
            ProcedureKind.register,
            ProductAssetModel.register,
            Seal.register,
            SealConditionKind.register,
            SealKind.register
        )
    }
}