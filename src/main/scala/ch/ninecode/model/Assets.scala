package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

/*
 * Package: Assets
 */

case class Asset
(
    override val sup: IdentifiedObject,
    val critical: Boolean,
    val initialCondition: String,
    val initialLossOfLife: Double,
    val lotNumber: String,
    val purchasePrice: Double,  // decimal
    val serialNumber: String,
    val typ: String,  // type
    val utcNumber: String,
    val AssetContainer: String,
    val AssetInfo: String,
    val ErpInventory: String,
    val ErpItemMaster: String,
    val FinancialInfo: String,
    val Location: String,
    val acceptanceTest: String,
    val electronicAddress: String,
    val lifecycle: String,
    val status: String
)
extends
    Element
{
    def this () = { this (null, false, null, 0.0, null, 0.0, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Asset]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Asset
extends
    Parseable[Asset]
{
    val critical = parse_element (element ("""Asset.critical"""))_
    val initialCondition = parse_element (element ("""Asset.initialCondition"""))_
    val initialLossOfLife = parse_element (element ("""Asset.initialLossOfLife"""))_
    val lotNumber = parse_element (element ("""Asset.lotNumber"""))_
    val purchasePrice = parse_element (element ("""Asset.purchasePrice"""))_
    val serialNumber = parse_element (element ("""Asset.serialNumber"""))_
    val typ = parse_element (element ("""Asset.typ"""))_
    val utcNumber = parse_element (element ("""Asset.utcNumber"""))_
    val AssetContainer = parse_attribute (attribute ("""Asset.AssetContainer"""))_
    val AssetInfo = parse_attribute (attribute ("""Asset.AssetInfo"""))_
    val ErpInventory = parse_attribute (attribute ("""Asset.ErpInventory"""))_
    val ErpItemMaster = parse_attribute (attribute ("""Asset.ErpItemMaster"""))_
    val FinancialInfo = parse_attribute (attribute ("""Asset.FinancialInfo"""))_
    val Location = parse_attribute (attribute ("""Asset.Location"""))_
    val acceptanceTest = parse_attribute (attribute ("""Asset.acceptanceTest"""))_
    val electronicAddress = parse_attribute (attribute ("""Asset.electronicAddress"""))_
    val lifecycle = parse_attribute (attribute ("""Asset.lifecycle"""))_
    val status = parse_attribute (attribute ("""Asset.status"""))_
    def parse (context: Context): Asset =
    {
        return (
            Asset
            (
                IdentifiedObject.parse (context),
                toBoolean (critical (context), context),
                initialCondition (context),
                toDouble (initialLossOfLife (context), context),
                lotNumber (context),
                toDouble (purchasePrice (context), context),
                serialNumber (context),
                typ (context),
                utcNumber (context),
                AssetContainer (context),
                AssetInfo (context),
                ErpInventory (context),
                ErpItemMaster (context),
                FinancialInfo (context),
                Location (context),
                acceptanceTest (context),
                electronicAddress (context),
                lifecycle (context),
                status (context)
            )
        )
    }
}

case class AssetContainer
(
    override val sup: Asset
)
extends
    Element
{
    def this () = { this (null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetContainer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetContainer
extends
    Parseable[AssetContainer]
{
    def parse (context: Context): AssetContainer =
    {
        return (
            AssetContainer
            (
                Asset.parse (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[AssetFunction]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetFunction
extends
    Parseable[AssetFunction]
{
    val configID = parse_element (element ("""AssetFunction.configID"""))_
    val firmwareID = parse_element (element ("""AssetFunction.firmwareID"""))_
    val hardwareID = parse_element (element ("""AssetFunction.hardwareID"""))_
    val password = parse_element (element ("""AssetFunction.password"""))_
    val programID = parse_element (element ("""AssetFunction.programID"""))_
    def parse (context: Context): AssetFunction =
    {
        return (
            AssetFunction
            (
                IdentifiedObject.parse (context),
                configID (context),
                firmwareID (context),
                hardwareID (context),
                password (context),
                programID (context)
            )
        )
    }
}

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
    override def copy (): Row = { return (clone ().asInstanceOf[AssetInfo]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetInfo
extends
    Parseable[AssetInfo]
{
    val AssetModel = parse_attribute (attribute ("""AssetInfo.AssetModel"""))_
    def parse (context: Context): AssetInfo =
    {
        return (
            AssetInfo
            (
                IdentifiedObject.parse (context),
                AssetModel (context)
            )
        )
    }
}

object Assets
{
    def register: Unit =
    {
        Asset.register
        AssetContainer.register
        AssetFunction.register
        AssetInfo.register
    }
}
