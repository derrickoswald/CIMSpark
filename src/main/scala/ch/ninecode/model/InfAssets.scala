package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * The package is used to define asset-level models for objects.
 * Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.
 */

/**
 * Kind of anchor.
 * @param sup Reference to the superclass object.
 * @param concrete
 * @param helix
 * @param multiHelix
 * @param other
 * @param rod
 * @param screw
 * @param unknown
 */
case class AnchorKind
(
    override val sup: BasicElement,
    val concrete: String,
    val helix: String,
    val multiHelix: String,
    val other: String,
    val rod: String,
    val screw: String,
    val unknown: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AnchorKind] }
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
        (if (null != concrete) "\t\t<cim:AnchorKind.concrete rdf:resource=\"#" + concrete + "\"/>\n" else "") +
        (if (null != helix) "\t\t<cim:AnchorKind.helix rdf:resource=\"#" + helix + "\"/>\n" else "") +
        (if (null != multiHelix) "\t\t<cim:AnchorKind.multiHelix rdf:resource=\"#" + multiHelix + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:AnchorKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != rod) "\t\t<cim:AnchorKind.rod rdf:resource=\"#" + rod + "\"/>\n" else "") +
        (if (null != screw) "\t\t<cim:AnchorKind.screw rdf:resource=\"#" + screw + "\"/>\n" else "") +
        (if (null != unknown) "\t\t<cim:AnchorKind.unknown rdf:resource=\"#" + unknown + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AnchorKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AnchorKind>\n"
    }
}

object AnchorKind
extends
    Parseable[AnchorKind]
{
    val concrete = parse_attribute (attribute ("""AnchorKind.concrete"""))
    val helix = parse_attribute (attribute ("""AnchorKind.helix"""))
    val multiHelix = parse_attribute (attribute ("""AnchorKind.multiHelix"""))
    val other = parse_attribute (attribute ("""AnchorKind.other"""))
    val rod = parse_attribute (attribute ("""AnchorKind.rod"""))
    val screw = parse_attribute (attribute ("""AnchorKind.screw"""))
    val unknown = parse_attribute (attribute ("""AnchorKind.unknown"""))
    def parse (context: Context): AnchorKind =
    {
        AnchorKind(
            BasicElement.parse (context),
            concrete (context),
            helix (context),
            multiHelix (context),
            other (context),
            rod (context),
            screw (context),
            unknown (context)
        )
    }
}

/**
 * An Asset Property that is described through curves rather than as a data point.
 * The relationship is to be defined between an independent variable (X-axis) and one or two dependent variables (Y1-axis and Y2-axis).
 * @param sup Reference to the superclass object.
 * @param Specification
 */
case class AssetPropertyCurve
(
    override val sup: Curve,
    val Specification: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[AssetPropertyCurve] }
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
        (if (null != Specification) "\t\t<cim:AssetPropertyCurve.Specification rdf:resource=\"#" + Specification + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AssetPropertyCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AssetPropertyCurve>\n"
    }
}

object AssetPropertyCurve
extends
    Parseable[AssetPropertyCurve]
{
    val Specification = parse_attribute (attribute ("""AssetPropertyCurve.Specification"""))
    def parse (context: Context): AssetPropertyCurve =
    {
        AssetPropertyCurve(
            Curve.parse (context),
            Specification (context)
        )
    }
}

/**
 * Bushing asset.
 * @param sup Reference to the superclass object.
 * @param c1Capacitance Factory measured capacitance, measured between the power factor tap and the bushing conductor.
 * @param c1PowerFactor Factory measured insulation power factor, measured between the power factor tap and the bushing conductor.
 * @param c2Capacitance Factory measured capacitance measured between the power factor tap and ground.
 * @param c2PowerFactor Factory measured insulation power factor, measured between the power factor tap and ground.
 * @param insulationKind Kind of insulation.
 * @param Terminal
 */
case class Bushing
(
    override val sup: Asset,
    val c1Capacitance: Double,
    val c1PowerFactor: Double,
    val c2Capacitance: Double,
    val c2PowerFactor: Double,
    val insulationKind: String,
    val Terminal: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { clone ().asInstanceOf[Bushing] }
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
        "\t\t<cim:Bushing.c1Capacitance>" + c1Capacitance + "</cim:Bushing.c1Capacitance>\n" +
        "\t\t<cim:Bushing.c1PowerFactor>" + c1PowerFactor + "</cim:Bushing.c1PowerFactor>\n" +
        "\t\t<cim:Bushing.c2Capacitance>" + c2Capacitance + "</cim:Bushing.c2Capacitance>\n" +
        "\t\t<cim:Bushing.c2PowerFactor>" + c2PowerFactor + "</cim:Bushing.c2PowerFactor>\n" +
        (if (null != insulationKind) "\t\t<cim:Bushing.insulationKind rdf:resource=\"#" + insulationKind + "\"/>\n" else "") +
        (if (null != Terminal) "\t\t<cim:Bushing.Terminal rdf:resource=\"#" + Terminal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Bushing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Bushing>\n"
    }
}

object Bushing
extends
    Parseable[Bushing]
{
    val c1Capacitance = parse_element (element ("""Bushing.c1Capacitance"""))
    val c1PowerFactor = parse_element (element ("""Bushing.c1PowerFactor"""))
    val c2Capacitance = parse_element (element ("""Bushing.c2Capacitance"""))
    val c2PowerFactor = parse_element (element ("""Bushing.c2PowerFactor"""))
    val insulationKind = parse_attribute (attribute ("""Bushing.insulationKind"""))
    val Terminal = parse_attribute (attribute ("""Bushing.Terminal"""))
    def parse (context: Context): Bushing =
    {
        Bushing(
            Asset.parse (context),
            toDouble (c1Capacitance (context), context),
            toDouble (c1PowerFactor (context), context),
            toDouble (c2Capacitance (context), context),
            toDouble (c2PowerFactor (context), context),
            insulationKind (context),
            Terminal (context)
        )
    }
}

/**
 * Insulation kind for bushings.
 * @param sup Reference to the superclass object.
 * @param compound
 * @param other
 * @param paperoil
 * @param solidPorcelain
 */
case class BushingInsulationKind
(
    override val sup: BasicElement,
    val compound: String,
    val other: String,
    val paperoil: String,
    val solidPorcelain: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BushingInsulationKind] }
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
        (if (null != compound) "\t\t<cim:BushingInsulationKind.compound rdf:resource=\"#" + compound + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:BushingInsulationKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != paperoil) "\t\t<cim:BushingInsulationKind.paperoil rdf:resource=\"#" + paperoil + "\"/>\n" else "") +
        (if (null != solidPorcelain) "\t\t<cim:BushingInsulationKind.solidPorcelain rdf:resource=\"#" + solidPorcelain + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BushingInsulationKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BushingInsulationKind>\n"
    }
}

object BushingInsulationKind
extends
    Parseable[BushingInsulationKind]
{
    val compound = parse_attribute (attribute ("""BushingInsulationKind.compound"""))
    val other = parse_attribute (attribute ("""BushingInsulationKind.other"""))
    val paperoil = parse_attribute (attribute ("""BushingInsulationKind.paperoil"""))
    val solidPorcelain = parse_attribute (attribute ("""BushingInsulationKind.solidPorcelain"""))
    def parse (context: Context): BushingInsulationKind =
    {
        BushingInsulationKind(
            BasicElement.parse (context),
            compound (context),
            other (context),
            paperoil (context),
            solidPorcelain (context)
        )
    }
}

/**
 * Bushing insulation power factor condition as a result of a test.
 * Typical status values are: Acceptable, Minor Deterioration or Moisture Absorption, Major Deterioration or Moisture Absorption, Failed.
 * @param sup Reference to the superclass object.
 * @param status
 * @param testKind Kind of test for this bushing.
 * @param Bushing
 * @param TransformerObservation
 */
case class BushingInsulationPF
(
    override val sup: IdentifiedObject,
    val status: String,
    val testKind: String,
    val Bushing: String,
    val TransformerObservation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[BushingInsulationPF] }
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
        (if (null != status) "\t\t<cim:BushingInsulationPF.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != testKind) "\t\t<cim:BushingInsulationPF.testKind rdf:resource=\"#" + testKind + "\"/>\n" else "") +
        (if (null != Bushing) "\t\t<cim:BushingInsulationPF.Bushing rdf:resource=\"#" + Bushing + "\"/>\n" else "") +
        (if (null != TransformerObservation) "\t\t<cim:BushingInsulationPF.TransformerObservation rdf:resource=\"#" + TransformerObservation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BushingInsulationPF rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BushingInsulationPF>\n"
    }
}

object BushingInsulationPF
extends
    Parseable[BushingInsulationPF]
{
    val status = parse_attribute (attribute ("""BushingInsulationPF.status"""))
    val testKind = parse_attribute (attribute ("""BushingInsulationPF.testKind"""))
    val Bushing = parse_attribute (attribute ("""BushingInsulationPF.Bushing"""))
    val TransformerObservation = parse_attribute (attribute ("""BushingInsulationPF.TransformerObservation"""))
    def parse (context: Context): BushingInsulationPF =
    {
        BushingInsulationPF(
            IdentifiedObject.parse (context),
            status (context),
            testKind (context),
            Bushing (context),
            TransformerObservation (context)
        )
    }
}

/**
 * Kind of PF test for bushing insulation.
 * @param sup Reference to the superclass object.
 * @param c1 Power factor tap-to-ground.
 * @param c2 Power factor tap-to-conductor.
 */
case class BushingInsulationPfTestKind
(
    override val sup: BasicElement,
    val c1: String,
    val c2: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BushingInsulationPfTestKind] }
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
        (if (null != c1) "\t\t<cim:BushingInsulationPfTestKind.c1 rdf:resource=\"#" + c1 + "\"/>\n" else "") +
        (if (null != c2) "\t\t<cim:BushingInsulationPfTestKind.c2 rdf:resource=\"#" + c2 + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BushingInsulationPfTestKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BushingInsulationPfTestKind>\n"
    }
}

object BushingInsulationPfTestKind
extends
    Parseable[BushingInsulationPfTestKind]
{
    val c1 = parse_attribute (attribute ("""BushingInsulationPfTestKind.c1"""))
    val c2 = parse_attribute (attribute ("""BushingInsulationPfTestKind.c2"""))
    def parse (context: Context): BushingInsulationPfTestKind =
    {
        BushingInsulationPfTestKind(
            BasicElement.parse (context),
            c1 (context),
            c2 (context)
        )
    }
}

/**
 * Enclosure that offers protection to the equipment it contains and/or safety to people/animals outside it.
 * @param sup Reference to the superclass object.
 */
case class Cabinet
(
    override val sup: AssetContainer
)
extends
    Element
{
    def this () = { this (null) }
    def AssetContainer: AssetContainer = sup.asInstanceOf[AssetContainer]
    override def copy (): Row = { clone ().asInstanceOf[Cabinet] }
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
        "\t<cim:Cabinet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Cabinet>\n"
    }
}

object Cabinet
extends
    Parseable[Cabinet]
{
    def parse (context: Context): Cabinet =
    {
        Cabinet(
            AssetContainer.parse (context)
        )
    }
}

/**
 * Kind of cooling.
 * @param sup Reference to the superclass object.
 * @param forcedAir
 * @param forcedOilAndAir
 * @param other
 * @param selfCooling
 */
case class CoolingKind
(
    override val sup: BasicElement,
    val forcedAir: String,
    val forcedOilAndAir: String,
    val other: String,
    val selfCooling: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CoolingKind] }
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
        (if (null != forcedAir) "\t\t<cim:CoolingKind.forcedAir rdf:resource=\"#" + forcedAir + "\"/>\n" else "") +
        (if (null != forcedOilAndAir) "\t\t<cim:CoolingKind.forcedOilAndAir rdf:resource=\"#" + forcedOilAndAir + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:CoolingKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != selfCooling) "\t\t<cim:CoolingKind.selfCooling rdf:resource=\"#" + selfCooling + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CoolingKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CoolingKind>\n"
    }
}

object CoolingKind
extends
    Parseable[CoolingKind]
{
    val forcedAir = parse_attribute (attribute ("""CoolingKind.forcedAir"""))
    val forcedOilAndAir = parse_attribute (attribute ("""CoolingKind.forcedOilAndAir"""))
    val other = parse_attribute (attribute ("""CoolingKind.other"""))
    val selfCooling = parse_attribute (attribute ("""CoolingKind.selfCooling"""))
    def parse (context: Context): CoolingKind =
    {
        CoolingKind(
            BasicElement.parse (context),
            forcedAir (context),
            forcedOilAndAir (context),
            other (context),
            selfCooling (context)
        )
    }
}

/**
 * There are often stages of power which are associated with stages of cooling.
 * For instance, a transformer may be rated 121kV on the primary, 15kV on the secondary and 4kV on the tertiary winding. These are voltage ratings and the power ratings are generally the same for all three windings and independent of the voltage ratings, there are instances where the tertiary may have a lower power rating.
 * @param sup Reference to the superclass object.
 * @param coolingKind Kind of cooling system.
 * @param powerRating The power rating associated with type of cooling specified for this stage.
 * @param stage Stage of cooling and associated power rating.
 * @param Reconditionings
 */
case class CoolingPowerRating
(
    override val sup: IdentifiedObject,
    val coolingKind: String,
    val powerRating: Double,
    val stage: Int,
    val Reconditionings: List[String]
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CoolingPowerRating] }
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
        (if (null != coolingKind) "\t\t<cim:CoolingPowerRating.coolingKind rdf:resource=\"#" + coolingKind + "\"/>\n" else "") +
        "\t\t<cim:CoolingPowerRating.powerRating>" + powerRating + "</cim:CoolingPowerRating.powerRating>\n" +
        "\t\t<cim:CoolingPowerRating.stage>" + stage + "</cim:CoolingPowerRating.stage>\n" +
        (if (null != Reconditionings) Reconditionings.map (x => "\t\t<cim:CoolingPowerRating.Reconditionings rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:CoolingPowerRating rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CoolingPowerRating>\n"
    }
}

object CoolingPowerRating
extends
    Parseable[CoolingPowerRating]
{
    val coolingKind = parse_attribute (attribute ("""CoolingPowerRating.coolingKind"""))
    val powerRating = parse_element (element ("""CoolingPowerRating.powerRating"""))
    val stage = parse_element (element ("""CoolingPowerRating.stage"""))
    val Reconditionings = parse_attributes (attribute ("""CoolingPowerRating.Reconditionings"""))
    def parse (context: Context): CoolingPowerRating =
    {
        CoolingPowerRating(
            IdentifiedObject.parse (context),
            coolingKind (context),
            toDouble (powerRating (context), context),
            toInteger (stage (context), context),
            Reconditionings (context)
        )
    }
}

/**
 * As applicable, the basic linear, area, or volume dimensions of an asset, asset type (AssetModel) or other type of object (such as land area).
 * Units and multipliers are specified per dimension.
 * @param sup Reference to the superclass object.
 * @param orientation A description of the orientation of the object relative to the dimensions.
 *        As an example, a vault may have north-south orientation for the sizeLength measurement and sizeDepth may be the height of the vault.
 * @param sizeDepth Depth measurement.
 * @param sizeDiameter Diameter measurement.
 * @param sizeLength Length measurement.
 * @param sizeWidth Width measurement.
 * @param Specifications
 */
case class DimensionsInfo
(
    override val sup: IdentifiedObject,
    val orientation: String,
    val sizeDepth: Double,
    val sizeDiameter: Double,
    val sizeLength: Double,
    val sizeWidth: Double,
    val Specifications: List[String]
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DimensionsInfo] }
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
        (if (null != orientation) "\t\t<cim:DimensionsInfo.orientation>" + orientation + "</cim:DimensionsInfo.orientation>\n" else "") +
        "\t\t<cim:DimensionsInfo.sizeDepth>" + sizeDepth + "</cim:DimensionsInfo.sizeDepth>\n" +
        "\t\t<cim:DimensionsInfo.sizeDiameter>" + sizeDiameter + "</cim:DimensionsInfo.sizeDiameter>\n" +
        "\t\t<cim:DimensionsInfo.sizeLength>" + sizeLength + "</cim:DimensionsInfo.sizeLength>\n" +
        "\t\t<cim:DimensionsInfo.sizeWidth>" + sizeWidth + "</cim:DimensionsInfo.sizeWidth>\n" +
        (if (null != Specifications) Specifications.map (x => "\t\t<cim:DimensionsInfo.Specifications rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:DimensionsInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DimensionsInfo>\n"
    }
}

object DimensionsInfo
extends
    Parseable[DimensionsInfo]
{
    val orientation = parse_element (element ("""DimensionsInfo.orientation"""))
    val sizeDepth = parse_element (element ("""DimensionsInfo.sizeDepth"""))
    val sizeDiameter = parse_element (element ("""DimensionsInfo.sizeDiameter"""))
    val sizeLength = parse_element (element ("""DimensionsInfo.sizeLength"""))
    val sizeWidth = parse_element (element ("""DimensionsInfo.sizeWidth"""))
    val Specifications = parse_attributes (attribute ("""DimensionsInfo.Specifications"""))
    def parse (context: Context): DimensionsInfo =
    {
        DimensionsInfo(
            IdentifiedObject.parse (context),
            orientation (context),
            toDouble (sizeDepth (context), context),
            toDouble (sizeDiameter (context), context),
            toDouble (sizeLength (context), context),
            toDouble (sizeWidth (context), context),
            Specifications (context)
        )
    }
}

/**
 * A duct contains individual wires in the layout as specified with associated wire spacing instances; number of them gives the number of conductors in this duct.
 * @param sup Reference to the superclass object.
 * @param circuitCount Number of circuits in duct bank.
 *        Refer to associations between a duct (ConductorAsset) and an ACLineSegment to understand which circuits are in which ducts.
 */
case class DuctBank
(
    override val sup: AssetContainer,
    val circuitCount: Int
)
extends
    Element
{
    def this () = { this (null, 0) }
    def AssetContainer: AssetContainer = sup.asInstanceOf[AssetContainer]
    override def copy (): Row = { clone ().asInstanceOf[DuctBank] }
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
        "\t\t<cim:DuctBank.circuitCount>" + circuitCount + "</cim:DuctBank.circuitCount>\n"
    }
    override def export: String =
    {
        "\t<cim:DuctBank rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DuctBank>\n"
    }
}

object DuctBank
extends
    Parseable[DuctBank]
{
    val circuitCount = parse_element (element ("""DuctBank.circuitCount"""))
    def parse (context: Context): DuctBank =
    {
        DuctBank(
            AssetContainer.parse (context),
            toInteger (circuitCount (context), context)
        )
    }
}

/**
 * FACTS device asset.
 * @param sup Reference to the superclass object.
 * @param kind Kind of FACTS device.
 */
case class FACTSDevice
(
    override val sup: Asset,
    val kind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { clone ().asInstanceOf[FACTSDevice] }
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
        (if (null != kind) "\t\t<cim:FACTSDevice.kind rdf:resource=\"#" + kind + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FACTSDevice rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FACTSDevice>\n"
    }
}

object FACTSDevice
extends
    Parseable[FACTSDevice]
{
    val kind = parse_attribute (attribute ("""FACTSDevice.kind"""))
    def parse (context: Context): FACTSDevice =
    {
        FACTSDevice(
            Asset.parse (context),
            kind (context)
        )
    }
}

/**
 * Kind of FACTS device.
 * @param sup Reference to the superclass object.
 * @param statcom Static synchronous compensator.
 * @param svc Static VAr compensator.
 * @param tcpar Thyristor-controlled phase-angle regulator.
 * @param tcsc Thyristor-controlled series capacitor.
 * @param tcvl Thyristor-controlled voltage limiter.
 * @param tsbr Thyristor-switched braking resistor.
 * @param tssc Thyristor-switched series capacitor.
 * @param upfc Unified power flow controller.
 */
case class FACTSDeviceKind
(
    override val sup: BasicElement,
    val statcom: String,
    val svc: String,
    val tcpar: String,
    val tcsc: String,
    val tcvl: String,
    val tsbr: String,
    val tssc: String,
    val upfc: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FACTSDeviceKind] }
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
        (if (null != statcom) "\t\t<cim:FACTSDeviceKind.statcom rdf:resource=\"#" + statcom + "\"/>\n" else "") +
        (if (null != svc) "\t\t<cim:FACTSDeviceKind.svc rdf:resource=\"#" + svc + "\"/>\n" else "") +
        (if (null != tcpar) "\t\t<cim:FACTSDeviceKind.tcpar rdf:resource=\"#" + tcpar + "\"/>\n" else "") +
        (if (null != tcsc) "\t\t<cim:FACTSDeviceKind.tcsc rdf:resource=\"#" + tcsc + "\"/>\n" else "") +
        (if (null != tcvl) "\t\t<cim:FACTSDeviceKind.tcvl rdf:resource=\"#" + tcvl + "\"/>\n" else "") +
        (if (null != tsbr) "\t\t<cim:FACTSDeviceKind.tsbr rdf:resource=\"#" + tsbr + "\"/>\n" else "") +
        (if (null != tssc) "\t\t<cim:FACTSDeviceKind.tssc rdf:resource=\"#" + tssc + "\"/>\n" else "") +
        (if (null != upfc) "\t\t<cim:FACTSDeviceKind.upfc rdf:resource=\"#" + upfc + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FACTSDeviceKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FACTSDeviceKind>\n"
    }
}

object FACTSDeviceKind
extends
    Parseable[FACTSDeviceKind]
{
    val statcom = parse_attribute (attribute ("""FACTSDeviceKind.statcom"""))
    val svc = parse_attribute (attribute ("""FACTSDeviceKind.svc"""))
    val tcpar = parse_attribute (attribute ("""FACTSDeviceKind.tcpar"""))
    val tcsc = parse_attribute (attribute ("""FACTSDeviceKind.tcsc"""))
    val tcvl = parse_attribute (attribute ("""FACTSDeviceKind.tcvl"""))
    val tsbr = parse_attribute (attribute ("""FACTSDeviceKind.tsbr"""))
    val tssc = parse_attribute (attribute ("""FACTSDeviceKind.tssc"""))
    val upfc = parse_attribute (attribute ("""FACTSDeviceKind.upfc"""))
    def parse (context: Context): FACTSDeviceKind =
    {
        FACTSDeviceKind(
            BasicElement.parse (context),
            statcom (context),
            svc (context),
            tcpar (context),
            tcsc (context),
            tcvl (context),
            tsbr (context),
            tssc (context),
            upfc (context)
        )
    }
}

/**
 * A facility may contain buildings, storage facilities, switching facilities, power generation, manufacturing facilities, maintenance facilities, etc.
 * @param sup Reference to the superclass object.
 * @param kind Kind of this facility.
 */
case class Facility
(
    override val sup: AssetContainer,
    val kind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def AssetContainer: AssetContainer = sup.asInstanceOf[AssetContainer]
    override def copy (): Row = { clone ().asInstanceOf[Facility] }
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
        (if (null != kind) "\t\t<cim:Facility.kind>" + kind + "</cim:Facility.kind>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Facility rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Facility>\n"
    }
}

object Facility
extends
    Parseable[Facility]
{
    val kind = parse_element (element ("""Facility.kind"""))
    def parse (context: Context): Facility =
    {
        Facility(
            AssetContainer.parse (context),
            kind (context)
        )
    }
}

/**
 * An event where an asset has failed to perform its functions within specified parameters.
 * @param sup Reference to the superclass object.
 * @param corporateCode Code for asset failure.
 * @param failureIsolationMethod How the asset failure was isolated from the system.
 * @param faultLocatingMethod The method used for locating the faulted part of the asset.
 *        For example, cable options include: Cap Discharge-Thumping, Bridge Method, Visual Inspection, Other.
 * @param location Failure location on an object.
 */
case class FailureEvent
(
    override val sup: ActivityRecord,
    val corporateCode: String,
    val failureIsolationMethod: String,
    val faultLocatingMethod: String,
    val location: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { clone ().asInstanceOf[FailureEvent] }
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
        (if (null != corporateCode) "\t\t<cim:FailureEvent.corporateCode>" + corporateCode + "</cim:FailureEvent.corporateCode>\n" else "") +
        (if (null != failureIsolationMethod) "\t\t<cim:FailureEvent.failureIsolationMethod rdf:resource=\"#" + failureIsolationMethod + "\"/>\n" else "") +
        (if (null != faultLocatingMethod) "\t\t<cim:FailureEvent.faultLocatingMethod>" + faultLocatingMethod + "</cim:FailureEvent.faultLocatingMethod>\n" else "") +
        (if (null != location) "\t\t<cim:FailureEvent.location>" + location + "</cim:FailureEvent.location>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FailureEvent rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FailureEvent>\n"
    }
}

object FailureEvent
extends
    Parseable[FailureEvent]
{
    val corporateCode = parse_element (element ("""FailureEvent.corporateCode"""))
    val failureIsolationMethod = parse_attribute (attribute ("""FailureEvent.failureIsolationMethod"""))
    val faultLocatingMethod = parse_element (element ("""FailureEvent.faultLocatingMethod"""))
    val location = parse_element (element ("""FailureEvent.location"""))
    def parse (context: Context): FailureEvent =
    {
        FailureEvent(
            ActivityRecord.parse (context),
            corporateCode (context),
            failureIsolationMethod (context),
            faultLocatingMethod (context),
            location (context)
        )
    }
}

/**
 * How the failure has been isolated.
 * @param sup Reference to the superclass object.
 * @param breakerOperation
 * @param burnedInTheClear
 * @param fuse
 * @param manuallyIsolated
 * @param other
 */
case class FailureIsolationMethodKind
(
    override val sup: BasicElement,
    val breakerOperation: String,
    val burnedInTheClear: String,
    val fuse: String,
    val manuallyIsolated: String,
    val other: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FailureIsolationMethodKind] }
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
        (if (null != breakerOperation) "\t\t<cim:FailureIsolationMethodKind.breakerOperation rdf:resource=\"#" + breakerOperation + "\"/>\n" else "") +
        (if (null != burnedInTheClear) "\t\t<cim:FailureIsolationMethodKind.burnedInTheClear rdf:resource=\"#" + burnedInTheClear + "\"/>\n" else "") +
        (if (null != fuse) "\t\t<cim:FailureIsolationMethodKind.fuse rdf:resource=\"#" + fuse + "\"/>\n" else "") +
        (if (null != manuallyIsolated) "\t\t<cim:FailureIsolationMethodKind.manuallyIsolated rdf:resource=\"#" + manuallyIsolated + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:FailureIsolationMethodKind.other rdf:resource=\"#" + other + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FailureIsolationMethodKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FailureIsolationMethodKind>\n"
    }
}

object FailureIsolationMethodKind
extends
    Parseable[FailureIsolationMethodKind]
{
    val breakerOperation = parse_attribute (attribute ("""FailureIsolationMethodKind.breakerOperation"""))
    val burnedInTheClear = parse_attribute (attribute ("""FailureIsolationMethodKind.burnedInTheClear"""))
    val fuse = parse_attribute (attribute ("""FailureIsolationMethodKind.fuse"""))
    val manuallyIsolated = parse_attribute (attribute ("""FailureIsolationMethodKind.manuallyIsolated"""))
    val other = parse_attribute (attribute ("""FailureIsolationMethodKind.other"""))
    def parse (context: Context): FailureIsolationMethodKind =
    {
        FailureIsolationMethodKind(
            BasicElement.parse (context),
            breakerOperation (context),
            burnedInTheClear (context),
            fuse (context),
            manuallyIsolated (context),
            other (context)
        )
    }
}

/**
 * Various current financial properties associated with a particular asset.
 * Historical properties may be determined by ActivityRecords associated with the asset.
 * @param sup Reference to the superclass object.
 * @param account The account to which this actual material item is charged.
 * @param actualPurchaseCost The actual purchase cost of this particular asset.
 * @param costDescription Description of the cost.
 * @param costType Type of cost to which this Material Item belongs.
 * @param financialValue Value of asset as of 'valueDateTime'.
 * @param plantTransferDateTime Date and time asset's financial value was put in plant for regulatory accounting purposes (e.g., for rate base calculations).
 *        This is sometime referred to as the "in-service date".
 * @param purchaseDateTime Date and time asset was purchased.
 * @param purchaseOrderNumber Purchase order identifier.
 * @param quantity The quantity of the asset if per unit length, for example conductor.
 * @param valueDateTime Date and time at which the financial value was last established.
 * @param warrantyEndDateTime Date and time warranty on asset expires.
 * @param Asset
 */
case class FinancialInfo
(
    override val sup: IdentifiedObject,
    val account: String,
    val actualPurchaseCost: Double,
    val costDescription: String,
    val costType: String,
    val financialValue: Double,
    val plantTransferDateTime: String,
    val purchaseDateTime: String,
    val purchaseOrderNumber: String,
    val quantity: String,
    val valueDateTime: String,
    val warrantyEndDateTime: String,
    val Asset: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, 0.0, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[FinancialInfo] }
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
        (if (null != account) "\t\t<cim:FinancialInfo.account>" + account + "</cim:FinancialInfo.account>\n" else "") +
        "\t\t<cim:FinancialInfo.actualPurchaseCost>" + actualPurchaseCost + "</cim:FinancialInfo.actualPurchaseCost>\n" +
        (if (null != costDescription) "\t\t<cim:FinancialInfo.costDescription>" + costDescription + "</cim:FinancialInfo.costDescription>\n" else "") +
        (if (null != costType) "\t\t<cim:FinancialInfo.costType>" + costType + "</cim:FinancialInfo.costType>\n" else "") +
        "\t\t<cim:FinancialInfo.financialValue>" + financialValue + "</cim:FinancialInfo.financialValue>\n" +
        (if (null != plantTransferDateTime) "\t\t<cim:FinancialInfo.plantTransferDateTime>" + plantTransferDateTime + "</cim:FinancialInfo.plantTransferDateTime>\n" else "") +
        (if (null != purchaseDateTime) "\t\t<cim:FinancialInfo.purchaseDateTime>" + purchaseDateTime + "</cim:FinancialInfo.purchaseDateTime>\n" else "") +
        (if (null != purchaseOrderNumber) "\t\t<cim:FinancialInfo.purchaseOrderNumber>" + purchaseOrderNumber + "</cim:FinancialInfo.purchaseOrderNumber>\n" else "") +
        (if (null != quantity) "\t\t<cim:FinancialInfo.quantity rdf:resource=\"#" + quantity + "\"/>\n" else "") +
        (if (null != valueDateTime) "\t\t<cim:FinancialInfo.valueDateTime>" + valueDateTime + "</cim:FinancialInfo.valueDateTime>\n" else "") +
        (if (null != warrantyEndDateTime) "\t\t<cim:FinancialInfo.warrantyEndDateTime>" + warrantyEndDateTime + "</cim:FinancialInfo.warrantyEndDateTime>\n" else "") +
        (if (null != Asset) "\t\t<cim:FinancialInfo.Asset rdf:resource=\"#" + Asset + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FinancialInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FinancialInfo>\n"
    }
}

object FinancialInfo
extends
    Parseable[FinancialInfo]
{
    val account = parse_element (element ("""FinancialInfo.account"""))
    val actualPurchaseCost = parse_element (element ("""FinancialInfo.actualPurchaseCost"""))
    val costDescription = parse_element (element ("""FinancialInfo.costDescription"""))
    val costType = parse_element (element ("""FinancialInfo.costType"""))
    val financialValue = parse_element (element ("""FinancialInfo.financialValue"""))
    val plantTransferDateTime = parse_element (element ("""FinancialInfo.plantTransferDateTime"""))
    val purchaseDateTime = parse_element (element ("""FinancialInfo.purchaseDateTime"""))
    val purchaseOrderNumber = parse_element (element ("""FinancialInfo.purchaseOrderNumber"""))
    val quantity = parse_attribute (attribute ("""FinancialInfo.quantity"""))
    val valueDateTime = parse_element (element ("""FinancialInfo.valueDateTime"""))
    val warrantyEndDateTime = parse_element (element ("""FinancialInfo.warrantyEndDateTime"""))
    val Asset = parse_attribute (attribute ("""FinancialInfo.Asset"""))
    def parse (context: Context): FinancialInfo =
    {
        FinancialInfo(
            IdentifiedObject.parse (context),
            account (context),
            toDouble (actualPurchaseCost (context), context),
            costDescription (context),
            costType (context),
            toDouble (financialValue (context), context),
            plantTransferDateTime (context),
            purchaseDateTime (context),
            purchaseOrderNumber (context),
            quantity (context),
            valueDateTime (context),
            warrantyEndDateTime (context),
            Asset (context)
        )
    }
}

/**
 * Generic asset or material item that may be used for planning, work or design purposes.
 * @param sup Reference to the superclass object.
 * @param estimatedUnitCost Estimated unit cost (or cost per unit length) of this type of asset.
 *        It does not include labor to install/construct or configure it.
 * @param quantity The value, unit of measure, and multiplier for the quantity.
 * @param stockItem True if item is a stock item (default).
 * @param CUAsset
 * @param CUWorkEquipmentAsset
 * @param TypeAssetCatalogue
 */
case class GenericAssetModelOrMaterial
(
    override val sup: AssetModel,
    val estimatedUnitCost: Double,
    val quantity: String,
    val stockItem: Boolean,
    val CUAsset: String,
    val CUWorkEquipmentAsset: String,
    val TypeAssetCatalogue: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, false, null, null, null) }
    def AssetModel: AssetModel = sup.asInstanceOf[AssetModel]
    override def copy (): Row = { clone ().asInstanceOf[GenericAssetModelOrMaterial] }
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
        "\t\t<cim:GenericAssetModelOrMaterial.estimatedUnitCost>" + estimatedUnitCost + "</cim:GenericAssetModelOrMaterial.estimatedUnitCost>\n" +
        (if (null != quantity) "\t\t<cim:GenericAssetModelOrMaterial.quantity rdf:resource=\"#" + quantity + "\"/>\n" else "") +
        "\t\t<cim:GenericAssetModelOrMaterial.stockItem>" + stockItem + "</cim:GenericAssetModelOrMaterial.stockItem>\n" +
        (if (null != CUAsset) "\t\t<cim:GenericAssetModelOrMaterial.CUAsset rdf:resource=\"#" + CUAsset + "\"/>\n" else "") +
        (if (null != CUWorkEquipmentAsset) "\t\t<cim:GenericAssetModelOrMaterial.CUWorkEquipmentAsset rdf:resource=\"#" + CUWorkEquipmentAsset + "\"/>\n" else "") +
        (if (null != TypeAssetCatalogue) "\t\t<cim:GenericAssetModelOrMaterial.TypeAssetCatalogue rdf:resource=\"#" + TypeAssetCatalogue + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:GenericAssetModelOrMaterial rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GenericAssetModelOrMaterial>\n"
    }
}

object GenericAssetModelOrMaterial
extends
    Parseable[GenericAssetModelOrMaterial]
{
    val estimatedUnitCost = parse_element (element ("""GenericAssetModelOrMaterial.estimatedUnitCost"""))
    val quantity = parse_attribute (attribute ("""GenericAssetModelOrMaterial.quantity"""))
    val stockItem = parse_element (element ("""GenericAssetModelOrMaterial.stockItem"""))
    val CUAsset = parse_attribute (attribute ("""GenericAssetModelOrMaterial.CUAsset"""))
    val CUWorkEquipmentAsset = parse_attribute (attribute ("""GenericAssetModelOrMaterial.CUWorkEquipmentAsset"""))
    val TypeAssetCatalogue = parse_attribute (attribute ("""GenericAssetModelOrMaterial.TypeAssetCatalogue"""))
    def parse (context: Context): GenericAssetModelOrMaterial =
    {
        GenericAssetModelOrMaterial(
            AssetModel.parse (context),
            toDouble (estimatedUnitCost (context), context),
            quantity (context),
            toBoolean (stockItem (context), context),
            CUAsset (context),
            CUWorkEquipmentAsset (context),
            TypeAssetCatalogue (context)
        )
    }
}

/**
 * Joint connects two or more cables.
 * It includes the portion of cable under wipes, welds, or other seals.
 * @param sup Reference to the superclass object.
 * @param configurationKind Configuration of joint.
 * @param fillKind Material used to fill the joint.
 * @param insulation The type of insulation around the joint, classified according to the utility's asset management standards and practices.
 */
case class Joint
(
    override val sup: Asset,
    val configurationKind: String,
    val fillKind: String,
    val insulation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { clone ().asInstanceOf[Joint] }
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
        (if (null != configurationKind) "\t\t<cim:Joint.configurationKind rdf:resource=\"#" + configurationKind + "\"/>\n" else "") +
        (if (null != fillKind) "\t\t<cim:Joint.fillKind rdf:resource=\"#" + fillKind + "\"/>\n" else "") +
        (if (null != insulation) "\t\t<cim:Joint.insulation>" + insulation + "</cim:Joint.insulation>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Joint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Joint>\n"
    }
}

object Joint
extends
    Parseable[Joint]
{
    val configurationKind = parse_attribute (attribute ("""Joint.configurationKind"""))
    val fillKind = parse_attribute (attribute ("""Joint.fillKind"""))
    val insulation = parse_element (element ("""Joint.insulation"""))
    def parse (context: Context): Joint =
    {
        Joint(
            Asset.parse (context),
            configurationKind (context),
            fillKind (context),
            insulation (context)
        )
    }
}

/**
 * Kind of configuration for joints.
 * @param sup Reference to the superclass object.
 * @param other
 * @param wires1to1
 * @param wires2to1
 * @param wires3to1
 */
case class JointConfigurationKind
(
    override val sup: BasicElement,
    val other: String,
    val wires1to1: String,
    val wires2to1: String,
    val wires3to1: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[JointConfigurationKind] }
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
        (if (null != other) "\t\t<cim:JointConfigurationKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != wires1to1) "\t\t<cim:JointConfigurationKind.wires1to1 rdf:resource=\"#" + wires1to1 + "\"/>\n" else "") +
        (if (null != wires2to1) "\t\t<cim:JointConfigurationKind.wires2to1 rdf:resource=\"#" + wires2to1 + "\"/>\n" else "") +
        (if (null != wires3to1) "\t\t<cim:JointConfigurationKind.wires3to1 rdf:resource=\"#" + wires3to1 + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:JointConfigurationKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:JointConfigurationKind>\n"
    }
}

object JointConfigurationKind
extends
    Parseable[JointConfigurationKind]
{
    val other = parse_attribute (attribute ("""JointConfigurationKind.other"""))
    val wires1to1 = parse_attribute (attribute ("""JointConfigurationKind.wires1to1"""))
    val wires2to1 = parse_attribute (attribute ("""JointConfigurationKind.wires2to1"""))
    val wires3to1 = parse_attribute (attribute ("""JointConfigurationKind.wires3to1"""))
    def parse (context: Context): JointConfigurationKind =
    {
        JointConfigurationKind(
            BasicElement.parse (context),
            other (context),
            wires1to1 (context),
            wires2to1 (context),
            wires3to1 (context)
        )
    }
}

/**
 * Kind of fill for Joint.
 * @param sup Reference to the superclass object.
 * @param airNoFilling
 * @param asphaltic
 * @param bluefill254
 * @param epoxy
 * @param insoluseal
 * @param noFillPrefab
 * @param noVoid
 * @param oil
 * @param other
 * @param petrolatum
 */
case class JointFillKind
(
    override val sup: BasicElement,
    val airNoFilling: String,
    val asphaltic: String,
    val bluefill254: String,
    val epoxy: String,
    val insoluseal: String,
    val noFillPrefab: String,
    val noVoid: String,
    val oil: String,
    val other: String,
    val petrolatum: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[JointFillKind] }
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
        (if (null != airNoFilling) "\t\t<cim:JointFillKind.airNoFilling rdf:resource=\"#" + airNoFilling + "\"/>\n" else "") +
        (if (null != asphaltic) "\t\t<cim:JointFillKind.asphaltic rdf:resource=\"#" + asphaltic + "\"/>\n" else "") +
        (if (null != bluefill254) "\t\t<cim:JointFillKind.bluefill254 rdf:resource=\"#" + bluefill254 + "\"/>\n" else "") +
        (if (null != epoxy) "\t\t<cim:JointFillKind.epoxy rdf:resource=\"#" + epoxy + "\"/>\n" else "") +
        (if (null != insoluseal) "\t\t<cim:JointFillKind.insoluseal rdf:resource=\"#" + insoluseal + "\"/>\n" else "") +
        (if (null != noFillPrefab) "\t\t<cim:JointFillKind.noFillPrefab rdf:resource=\"#" + noFillPrefab + "\"/>\n" else "") +
        (if (null != noVoid) "\t\t<cim:JointFillKind.noVoid rdf:resource=\"#" + noVoid + "\"/>\n" else "") +
        (if (null != oil) "\t\t<cim:JointFillKind.oil rdf:resource=\"#" + oil + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:JointFillKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != petrolatum) "\t\t<cim:JointFillKind.petrolatum rdf:resource=\"#" + petrolatum + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:JointFillKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:JointFillKind>\n"
    }
}

object JointFillKind
extends
    Parseable[JointFillKind]
{
    val airNoFilling = parse_attribute (attribute ("""JointFillKind.airNoFilling"""))
    val asphaltic = parse_attribute (attribute ("""JointFillKind.asphaltic"""))
    val bluefill254 = parse_attribute (attribute ("""JointFillKind.bluefill254"""))
    val epoxy = parse_attribute (attribute ("""JointFillKind.epoxy"""))
    val insoluseal = parse_attribute (attribute ("""JointFillKind.insoluseal"""))
    val noFillPrefab = parse_attribute (attribute ("""JointFillKind.noFillPrefab"""))
    val noVoid = parse_attribute (attribute ("""JointFillKind.noVoid"""))
    val oil = parse_attribute (attribute ("""JointFillKind.oil"""))
    val other = parse_attribute (attribute ("""JointFillKind.other"""))
    val petrolatum = parse_attribute (attribute ("""JointFillKind.petrolatum"""))
    def parse (context: Context): JointFillKind =
    {
        JointFillKind(
            BasicElement.parse (context),
            airNoFilling (context),
            asphaltic (context),
            bluefill254 (context),
            epoxy (context),
            insoluseal (context),
            noFillPrefab (context),
            noVoid (context),
            oil (context),
            other (context),
            petrolatum (context)
        )
    }
}

/**
 * A substance that either (1) provides the means of transmission of a force or effect, such as hydraulic fluid, or (2) is used for a surrounding or enveloping substance, such as oil in a transformer or circuit breaker.
 * @param sup Reference to the superclass object.
 * @param kind Kind of this medium.
 * @param volumeSpec The volume of the medium specified for this application.
 *        Note that the actual volume is a type of measurement associated witht the asset.
 * @param Assets
 * @param Specification
 */
case class Medium
(
    override val sup: IdentifiedObject,
    val kind: String,
    val volumeSpec: Double,
    val Assets: List[String],
    val Specification: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, List(), null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Medium] }
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
        (if (null != kind) "\t\t<cim:Medium.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        "\t\t<cim:Medium.volumeSpec>" + volumeSpec + "</cim:Medium.volumeSpec>\n" +
        (if (null != Assets) Assets.map (x => "\t\t<cim:Medium.Assets rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Specification) "\t\t<cim:Medium.Specification rdf:resource=\"#" + Specification + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Medium rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Medium>\n"
    }
}

object Medium
extends
    Parseable[Medium]
{
    val kind = parse_attribute (attribute ("""Medium.kind"""))
    val volumeSpec = parse_element (element ("""Medium.volumeSpec"""))
    val Assets = parse_attributes (attribute ("""Medium.Assets"""))
    val Specification = parse_attribute (attribute ("""Medium.Specification"""))
    def parse (context: Context): Medium =
    {
        Medium(
            IdentifiedObject.parse (context),
            kind (context),
            toDouble (volumeSpec (context), context),
            Assets (context),
            Specification (context)
        )
    }
}

/**
 * Kind of medium.
 * @param sup Reference to the superclass object.
 * @param gas
 * @param liquid
 * @param solid
 */
case class MediumKind
(
    override val sup: BasicElement,
    val gas: String,
    val liquid: String,
    val solid: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MediumKind] }
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
        (if (null != gas) "\t\t<cim:MediumKind.gas rdf:resource=\"#" + gas + "\"/>\n" else "") +
        (if (null != liquid) "\t\t<cim:MediumKind.liquid rdf:resource=\"#" + liquid + "\"/>\n" else "") +
        (if (null != solid) "\t\t<cim:MediumKind.solid rdf:resource=\"#" + solid + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MediumKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MediumKind>\n"
    }
}

object MediumKind
extends
    Parseable[MediumKind]
{
    val gas = parse_attribute (attribute ("""MediumKind.gas"""))
    val liquid = parse_attribute (attribute ("""MediumKind.liquid"""))
    val solid = parse_attribute (attribute ("""MediumKind.solid"""))
    def parse (context: Context): MediumKind =
    {
        MediumKind(
            BasicElement.parse (context),
            gas (context),
            liquid (context),
            solid (context)
        )
    }
}

/**
 * Pole asset.
 * @param sup Reference to the superclass object.
 * @param baseKind Kind of base for this pole.
 * @param breastBlock True if a block of material has been attached to base of pole in ground for stability.
 *        This technique is used primarily when anchors can not be used.
 * @param classification Pole class: 1, 2, 3, 4, 5, 6, 7, H1, H2, Other, Unknown.
 * @param construction The framing structure mounted on the pole.
 * @param diameter Diameter of the pole.
 * @param jpaReference Joint pole agreement reference number.
 * @param len Length of the pole (inclusive of any section of the pole that may be underground post-installation).
 * @param preservativeKind Kind of preservative for this pole.
 * @param speciesType Pole species.
 *        Aluminum, Aluminum Davit, Concrete, Fiberglass, Galvanized Davit, Galvanized, Steel Davit Primed, Steel Davit, Steel Standard Primed, Steel, Truncated, Wood-Treated, Wood-Hard, Wood-Salt Treated, Wood-Soft, Wood, Other, Unknown.
 * @param treatedDateTime Date and time pole was last treated with preservative.
 * @param treatmentKind Kind of treatment for this pole.
 */
case class Pole
(
    override val sup: Structure,
    val baseKind: String,
    val breastBlock: Boolean,
    val classification: String,
    val construction: String,
    val diameter: Double,
    val jpaReference: String,
    val len: Double,
    val preservativeKind: String,
    val speciesType: String,
    val treatedDateTime: String,
    val treatmentKind: String
)
extends
    Element
{
    def this () = { this (null, null, false, null, null, 0.0, null, 0.0, null, null, null, null) }
    def Structure: Structure = sup.asInstanceOf[Structure]
    override def copy (): Row = { clone ().asInstanceOf[Pole] }
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
        (if (null != baseKind) "\t\t<cim:Pole.baseKind rdf:resource=\"#" + baseKind + "\"/>\n" else "") +
        "\t\t<cim:Pole.breastBlock>" + breastBlock + "</cim:Pole.breastBlock>\n" +
        (if (null != classification) "\t\t<cim:Pole.classification>" + classification + "</cim:Pole.classification>\n" else "") +
        (if (null != construction) "\t\t<cim:Pole.construction>" + construction + "</cim:Pole.construction>\n" else "") +
        "\t\t<cim:Pole.diameter>" + diameter + "</cim:Pole.diameter>\n" +
        (if (null != jpaReference) "\t\t<cim:Pole.jpaReference>" + jpaReference + "</cim:Pole.jpaReference>\n" else "") +
        "\t\t<cim:Pole.length>" + len + "</cim:Pole.length>\n" +
        (if (null != preservativeKind) "\t\t<cim:Pole.preservativeKind rdf:resource=\"#" + preservativeKind + "\"/>\n" else "") +
        (if (null != speciesType) "\t\t<cim:Pole.speciesType>" + speciesType + "</cim:Pole.speciesType>\n" else "") +
        (if (null != treatedDateTime) "\t\t<cim:Pole.treatedDateTime>" + treatedDateTime + "</cim:Pole.treatedDateTime>\n" else "") +
        (if (null != treatmentKind) "\t\t<cim:Pole.treatmentKind rdf:resource=\"#" + treatmentKind + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Pole rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Pole>\n"
    }
}

object Pole
extends
    Parseable[Pole]
{
    val baseKind = parse_attribute (attribute ("""Pole.baseKind"""))
    val breastBlock = parse_element (element ("""Pole.breastBlock"""))
    val classification = parse_element (element ("""Pole.classification"""))
    val construction = parse_element (element ("""Pole.construction"""))
    val diameter = parse_element (element ("""Pole.diameter"""))
    val jpaReference = parse_element (element ("""Pole.jpaReference"""))
    val len = parse_element (element ("""Pole.length"""))
    val preservativeKind = parse_attribute (attribute ("""Pole.preservativeKind"""))
    val speciesType = parse_element (element ("""Pole.speciesType"""))
    val treatedDateTime = parse_element (element ("""Pole.treatedDateTime"""))
    val treatmentKind = parse_attribute (attribute ("""Pole.treatmentKind"""))
    def parse (context: Context): Pole =
    {
        Pole(
            Structure.parse (context),
            baseKind (context),
            toBoolean (breastBlock (context), context),
            classification (context),
            construction (context),
            toDouble (diameter (context), context),
            jpaReference (context),
            toDouble (len (context), context),
            preservativeKind (context),
            speciesType (context),
            treatedDateTime (context),
            treatmentKind (context)
        )
    }
}

/**
 * Kind of base for poles.
 * @param sup Reference to the superclass object.
 * @param asphalt
 * @param cement
 * @param dirt
 * @param other
 * @param unknown
 */
case class PoleBaseKind
(
    override val sup: BasicElement,
    val asphalt: String,
    val cement: String,
    val dirt: String,
    val other: String,
    val unknown: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PoleBaseKind] }
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
        (if (null != asphalt) "\t\t<cim:PoleBaseKind.asphalt rdf:resource=\"#" + asphalt + "\"/>\n" else "") +
        (if (null != cement) "\t\t<cim:PoleBaseKind.cement rdf:resource=\"#" + cement + "\"/>\n" else "") +
        (if (null != dirt) "\t\t<cim:PoleBaseKind.dirt rdf:resource=\"#" + dirt + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:PoleBaseKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != unknown) "\t\t<cim:PoleBaseKind.unknown rdf:resource=\"#" + unknown + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PoleBaseKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PoleBaseKind>\n"
    }
}

object PoleBaseKind
extends
    Parseable[PoleBaseKind]
{
    val asphalt = parse_attribute (attribute ("""PoleBaseKind.asphalt"""))
    val cement = parse_attribute (attribute ("""PoleBaseKind.cement"""))
    val dirt = parse_attribute (attribute ("""PoleBaseKind.dirt"""))
    val other = parse_attribute (attribute ("""PoleBaseKind.other"""))
    val unknown = parse_attribute (attribute ("""PoleBaseKind.unknown"""))
    def parse (context: Context): PoleBaseKind =
    {
        PoleBaseKind(
            BasicElement.parse (context),
            asphalt (context),
            cement (context),
            dirt (context),
            other (context),
            unknown (context)
        )
    }
}

/**
 * Preservative kind for poles.
 * @param sup Reference to the superclass object.
 * @param cellon
 * @param chemonite
 * @param creosote
 * @param naphthena
 * @param other
 * @param penta
 * @param unknown
 */
case class PolePreservativeKind
(
    override val sup: BasicElement,
    val cellon: String,
    val chemonite: String,
    val creosote: String,
    val naphthena: String,
    val other: String,
    val penta: String,
    val unknown: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PolePreservativeKind] }
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
        (if (null != cellon) "\t\t<cim:PolePreservativeKind.cellon rdf:resource=\"#" + cellon + "\"/>\n" else "") +
        (if (null != chemonite) "\t\t<cim:PolePreservativeKind.chemonite rdf:resource=\"#" + chemonite + "\"/>\n" else "") +
        (if (null != creosote) "\t\t<cim:PolePreservativeKind.creosote rdf:resource=\"#" + creosote + "\"/>\n" else "") +
        (if (null != naphthena) "\t\t<cim:PolePreservativeKind.naphthena rdf:resource=\"#" + naphthena + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:PolePreservativeKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != penta) "\t\t<cim:PolePreservativeKind.penta rdf:resource=\"#" + penta + "\"/>\n" else "") +
        (if (null != unknown) "\t\t<cim:PolePreservativeKind.unknown rdf:resource=\"#" + unknown + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PolePreservativeKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PolePreservativeKind>\n"
    }
}

object PolePreservativeKind
extends
    Parseable[PolePreservativeKind]
{
    val cellon = parse_attribute (attribute ("""PolePreservativeKind.cellon"""))
    val chemonite = parse_attribute (attribute ("""PolePreservativeKind.chemonite"""))
    val creosote = parse_attribute (attribute ("""PolePreservativeKind.creosote"""))
    val naphthena = parse_attribute (attribute ("""PolePreservativeKind.naphthena"""))
    val other = parse_attribute (attribute ("""PolePreservativeKind.other"""))
    val penta = parse_attribute (attribute ("""PolePreservativeKind.penta"""))
    val unknown = parse_attribute (attribute ("""PolePreservativeKind.unknown"""))
    def parse (context: Context): PolePreservativeKind =
    {
        PolePreservativeKind(
            BasicElement.parse (context),
            cellon (context),
            chemonite (context),
            creosote (context),
            naphthena (context),
            other (context),
            penta (context),
            unknown (context)
        )
    }
}

/**
 * Kind of treatment for poles.
 * @param sup Reference to the superclass object.
 * @param butt
 * @param full
 * @param grayStain
 * @param greenStain
 * @param natural
 * @param other
 * @param penta
 * @param unknown
 */
case class PoleTreatmentKind
(
    override val sup: BasicElement,
    val butt: String,
    val full: String,
    val grayStain: String,
    val greenStain: String,
    val natural: String,
    val other: String,
    val penta: String,
    val unknown: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PoleTreatmentKind] }
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
        (if (null != butt) "\t\t<cim:PoleTreatmentKind.butt rdf:resource=\"#" + butt + "\"/>\n" else "") +
        (if (null != full) "\t\t<cim:PoleTreatmentKind.full rdf:resource=\"#" + full + "\"/>\n" else "") +
        (if (null != grayStain) "\t\t<cim:PoleTreatmentKind.grayStain rdf:resource=\"#" + grayStain + "\"/>\n" else "") +
        (if (null != greenStain) "\t\t<cim:PoleTreatmentKind.greenStain rdf:resource=\"#" + greenStain + "\"/>\n" else "") +
        (if (null != natural) "\t\t<cim:PoleTreatmentKind.natural rdf:resource=\"#" + natural + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:PoleTreatmentKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != penta) "\t\t<cim:PoleTreatmentKind.penta rdf:resource=\"#" + penta + "\"/>\n" else "") +
        (if (null != unknown) "\t\t<cim:PoleTreatmentKind.unknown rdf:resource=\"#" + unknown + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PoleTreatmentKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PoleTreatmentKind>\n"
    }
}

object PoleTreatmentKind
extends
    Parseable[PoleTreatmentKind]
{
    val butt = parse_attribute (attribute ("""PoleTreatmentKind.butt"""))
    val full = parse_attribute (attribute ("""PoleTreatmentKind.full"""))
    val grayStain = parse_attribute (attribute ("""PoleTreatmentKind.grayStain"""))
    val greenStain = parse_attribute (attribute ("""PoleTreatmentKind.greenStain"""))
    val natural = parse_attribute (attribute ("""PoleTreatmentKind.natural"""))
    val other = parse_attribute (attribute ("""PoleTreatmentKind.other"""))
    val penta = parse_attribute (attribute ("""PoleTreatmentKind.penta"""))
    val unknown = parse_attribute (attribute ("""PoleTreatmentKind.unknown"""))
    def parse (context: Context): PoleTreatmentKind =
    {
        PoleTreatmentKind(
            BasicElement.parse (context),
            butt (context),
            full (context),
            grayStain (context),
            greenStain (context),
            natural (context),
            other (context),
            penta (context),
            unknown (context)
        )
    }
}

/**
 * Reconditioning information for an asset.
 * @param sup Reference to the superclass object.
 * @param dateTime Date and time this reconditioning (or a major overhaul) has been performed.
 * @param Asset
 */
case class Reconditioning
(
    override val sup: IdentifiedObject,
    val dateTime: String,
    val Asset: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Reconditioning] }
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
        (if (null != dateTime) "\t\t<cim:Reconditioning.dateTime>" + dateTime + "</cim:Reconditioning.dateTime>\n" else "") +
        (if (null != Asset) "\t\t<cim:Reconditioning.Asset rdf:resource=\"#" + Asset + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Reconditioning rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Reconditioning>\n"
    }
}

object Reconditioning
extends
    Parseable[Reconditioning]
{
    val dateTime = parse_element (element ("""Reconditioning.dateTime"""))
    val Asset = parse_attribute (attribute ("""Reconditioning.Asset"""))
    def parse (context: Context): Reconditioning =
    {
        Reconditioning(
            IdentifiedObject.parse (context),
            dateTime (context),
            Asset (context)
        )
    }
}

/**
 * Information regarding the experienced and expected reliability of a specific asset, type of asset, or asset model.
 * @param sup Reference to the superclass object.
 * @param mTTR Mean time to repair (MTTR - hours).
 * @param momFailureRate Momentary failure rate (temporary failures/kft-year).
 * @param Assets
 * @param Specification
 */
case class ReliabilityInfo
(
    override val sup: IdentifiedObject,
    val mTTR: Double,
    val momFailureRate: Double,
    val Assets: List[String],
    val Specification: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, List(), null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ReliabilityInfo] }
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
        "\t\t<cim:ReliabilityInfo.mTTR>" + mTTR + "</cim:ReliabilityInfo.mTTR>\n" +
        "\t\t<cim:ReliabilityInfo.momFailureRate>" + momFailureRate + "</cim:ReliabilityInfo.momFailureRate>\n" +
        (if (null != Assets) Assets.map (x => "\t\t<cim:ReliabilityInfo.Assets rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Specification) "\t\t<cim:ReliabilityInfo.Specification rdf:resource=\"#" + Specification + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ReliabilityInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ReliabilityInfo>\n"
    }
}

object ReliabilityInfo
extends
    Parseable[ReliabilityInfo]
{
    val mTTR = parse_element (element ("""ReliabilityInfo.mTTR"""))
    val momFailureRate = parse_element (element ("""ReliabilityInfo.momFailureRate"""))
    val Assets = parse_attributes (attribute ("""ReliabilityInfo.Assets"""))
    val Specification = parse_attribute (attribute ("""ReliabilityInfo.Specification"""))
    def parse (context: Context): ReliabilityInfo =
    {
        ReliabilityInfo(
            IdentifiedObject.parse (context),
            toDouble (mTTR (context), context),
            toDouble (momFailureRate (context), context),
            Assets (context),
            Specification (context)
        )
    }
}

/**
 * Specification can be used for various purposes relative to an asset, a logical device (PowerSystemResource), location, etc.
 * Examples include documents supplied by manufacturers such as asset installation instructions, asset maintenance instructions, etc.
 * @param sup Reference to the superclass object.
 */
case class Specification
(
    override val sup: Document
)
extends
    Element
{
    def this () = { this (null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[Specification] }
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
        "\t<cim:Specification rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Specification>\n"
    }
}

object Specification
extends
    Parseable[Specification]
{
    def parse (context: Context): Specification =
    {
        Specification(
            Document.parse (context)
        )
    }
}

/**
 * Streetlight asset.
 * @param sup Reference to the superclass object.
 * @param armLength Length of arm.
 *        Note that a new light may be placed on an existing arm.
 * @param lampKind Lamp kind.
 * @param lightRating Power rating of light.
 * @param Pole Pole to which thiss streetlight is attached.
 */
case class Streetlight
(
    override val sup: Asset,
    val armLength: Double,
    val lampKind: String,
    val lightRating: Double,
    val Pole: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, 0.0, null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { clone ().asInstanceOf[Streetlight] }
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
        "\t\t<cim:Streetlight.armLength>" + armLength + "</cim:Streetlight.armLength>\n" +
        (if (null != lampKind) "\t\t<cim:Streetlight.lampKind rdf:resource=\"#" + lampKind + "\"/>\n" else "") +
        "\t\t<cim:Streetlight.lightRating>" + lightRating + "</cim:Streetlight.lightRating>\n" +
        (if (null != Pole) "\t\t<cim:Streetlight.Pole rdf:resource=\"#" + Pole + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Streetlight rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Streetlight>\n"
    }
}

object Streetlight
extends
    Parseable[Streetlight]
{
    val armLength = parse_element (element ("""Streetlight.armLength"""))
    val lampKind = parse_attribute (attribute ("""Streetlight.lampKind"""))
    val lightRating = parse_element (element ("""Streetlight.lightRating"""))
    val Pole = parse_attribute (attribute ("""Streetlight.Pole"""))
    def parse (context: Context): Streetlight =
    {
        Streetlight(
            Asset.parse (context),
            toDouble (armLength (context), context),
            lampKind (context),
            toDouble (lightRating (context), context),
            Pole (context)
        )
    }
}

/**
 * Kind of lamp for the streetlight.
 * @param sup Reference to the superclass object.
 * @param highPressureSodium
 * @param mercuryVapor
 * @param metalHalide
 * @param other
 */
case class StreetlightLampKind
(
    override val sup: BasicElement,
    val highPressureSodium: String,
    val mercuryVapor: String,
    val metalHalide: String,
    val other: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[StreetlightLampKind] }
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
        (if (null != highPressureSodium) "\t\t<cim:StreetlightLampKind.highPressureSodium rdf:resource=\"#" + highPressureSodium + "\"/>\n" else "") +
        (if (null != mercuryVapor) "\t\t<cim:StreetlightLampKind.mercuryVapor rdf:resource=\"#" + mercuryVapor + "\"/>\n" else "") +
        (if (null != metalHalide) "\t\t<cim:StreetlightLampKind.metalHalide rdf:resource=\"#" + metalHalide + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:StreetlightLampKind.other rdf:resource=\"#" + other + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StreetlightLampKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StreetlightLampKind>\n"
    }
}

object StreetlightLampKind
extends
    Parseable[StreetlightLampKind]
{
    val highPressureSodium = parse_attribute (attribute ("""StreetlightLampKind.highPressureSodium"""))
    val mercuryVapor = parse_attribute (attribute ("""StreetlightLampKind.mercuryVapor"""))
    val metalHalide = parse_attribute (attribute ("""StreetlightLampKind.metalHalide"""))
    val other = parse_attribute (attribute ("""StreetlightLampKind.other"""))
    def parse (context: Context): StreetlightLampKind =
    {
        StreetlightLampKind(
            BasicElement.parse (context),
            highPressureSodium (context),
            mercuryVapor (context),
            metalHalide (context),
            other (context)
        )
    }
}

/**
 * Construction holding assets such as conductors, transformers, switchgear, etc.
 * Where applicable, number of conductors can be derived from the number of associated wire spacing instances.
 * @param sup Reference to the superclass object.
 * @param fumigantAppliedDate Date fumigant was last applied.
 * @param fumigantName Name of fumigant.
 * @param height Visible height of structure above ground level for overhead construction (e.g., Pole or Tower) or below ground level for an underground vault, manhole, etc.
 *        Refer to associated DimensionPropertiesInfo for other types of dimensions.
 * @param materialKind Material this structure is made of.
 * @param ratedVoltage Maximum rated voltage of the equipment that can be mounted on/contained within the structure.
 * @param removeWeed True if weeds are to be removed around asset.
 * @param weedRemovedDate Date weed were last removed.
 */
case class Structure
(
    override val sup: AssetContainer,
    val fumigantAppliedDate: String,
    val fumigantName: String,
    val height: Double,
    val materialKind: String,
    val ratedVoltage: Double,
    val removeWeed: Boolean,
    val weedRemovedDate: String
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, null, 0.0, false, null) }
    def AssetContainer: AssetContainer = sup.asInstanceOf[AssetContainer]
    override def copy (): Row = { clone ().asInstanceOf[Structure] }
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
        (if (null != fumigantAppliedDate) "\t\t<cim:Structure.fumigantAppliedDate>" + fumigantAppliedDate + "</cim:Structure.fumigantAppliedDate>\n" else "") +
        (if (null != fumigantName) "\t\t<cim:Structure.fumigantName>" + fumigantName + "</cim:Structure.fumigantName>\n" else "") +
        "\t\t<cim:Structure.height>" + height + "</cim:Structure.height>\n" +
        (if (null != materialKind) "\t\t<cim:Structure.materialKind rdf:resource=\"#" + materialKind + "\"/>\n" else "") +
        "\t\t<cim:Structure.ratedVoltage>" + ratedVoltage + "</cim:Structure.ratedVoltage>\n" +
        "\t\t<cim:Structure.removeWeed>" + removeWeed + "</cim:Structure.removeWeed>\n" +
        (if (null != weedRemovedDate) "\t\t<cim:Structure.weedRemovedDate>" + weedRemovedDate + "</cim:Structure.weedRemovedDate>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Structure rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Structure>\n"
    }
}

object Structure
extends
    Parseable[Structure]
{
    val fumigantAppliedDate = parse_element (element ("""Structure.fumigantAppliedDate"""))
    val fumigantName = parse_element (element ("""Structure.fumigantName"""))
    val height = parse_element (element ("""Structure.height"""))
    val materialKind = parse_attribute (attribute ("""Structure.materialKind"""))
    val ratedVoltage = parse_element (element ("""Structure.ratedVoltage"""))
    val removeWeed = parse_element (element ("""Structure.removeWeed"""))
    val weedRemovedDate = parse_element (element ("""Structure.weedRemovedDate"""))
    def parse (context: Context): Structure =
    {
        Structure(
            AssetContainer.parse (context),
            fumigantAppliedDate (context),
            fumigantName (context),
            toDouble (height (context), context),
            materialKind (context),
            toDouble (ratedVoltage (context), context),
            toBoolean (removeWeed (context), context),
            weedRemovedDate (context)
        )
    }
}

/**
 * Kind of material used for structures.
 * @param sup Reference to the superclass object.
 * @param concrete
 * @param other
 * @param steel
 * @param wood
 */
case class StructureMaterialKind
(
    override val sup: BasicElement,
    val concrete: String,
    val other: String,
    val steel: String,
    val wood: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[StructureMaterialKind] }
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
        (if (null != concrete) "\t\t<cim:StructureMaterialKind.concrete rdf:resource=\"#" + concrete + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:StructureMaterialKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != steel) "\t\t<cim:StructureMaterialKind.steel rdf:resource=\"#" + steel + "\"/>\n" else "") +
        (if (null != wood) "\t\t<cim:StructureMaterialKind.wood rdf:resource=\"#" + wood + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StructureMaterialKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StructureMaterialKind>\n"
    }
}

object StructureMaterialKind
extends
    Parseable[StructureMaterialKind]
{
    val concrete = parse_attribute (attribute ("""StructureMaterialKind.concrete"""))
    val other = parse_attribute (attribute ("""StructureMaterialKind.other"""))
    val steel = parse_attribute (attribute ("""StructureMaterialKind.steel"""))
    val wood = parse_attribute (attribute ("""StructureMaterialKind.wood"""))
    def parse (context: Context): StructureMaterialKind =
    {
        StructureMaterialKind(
            BasicElement.parse (context),
            concrete (context),
            other (context),
            steel (context),
            wood (context)
        )
    }
}

/**
 * Support for structure assets.
 * @param sup Reference to the superclass object.
 * @param anchorKind (if anchor) Kind of anchor.
 * @param anchorRodCount (if anchor) Number of rods used.
 * @param anchorRodLength (if anchor) Length of rod used.
 * @param direction Direction of this support structure.
 * @param kind Kind of structure support.
 * @param len Length of this support structure.
 * @param size1 Size of this support structure.
 * @param SecuredStructure
 */
case class StructureSupport
(
    override val sup: Asset,
    val anchorKind: String,
    val anchorRodCount: Int,
    val anchorRodLength: Double,
    val direction: Double,
    val kind: String,
    val len: Double,
    val size1: String,
    val SecuredStructure: String
)
extends
    Element
{
    def this () = { this (null, null, 0, 0.0, 0.0, null, 0.0, null, null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { clone ().asInstanceOf[StructureSupport] }
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
        (if (null != anchorKind) "\t\t<cim:StructureSupport.anchorKind rdf:resource=\"#" + anchorKind + "\"/>\n" else "") +
        "\t\t<cim:StructureSupport.anchorRodCount>" + anchorRodCount + "</cim:StructureSupport.anchorRodCount>\n" +
        "\t\t<cim:StructureSupport.anchorRodLength>" + anchorRodLength + "</cim:StructureSupport.anchorRodLength>\n" +
        "\t\t<cim:StructureSupport.direction>" + direction + "</cim:StructureSupport.direction>\n" +
        (if (null != kind) "\t\t<cim:StructureSupport.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        "\t\t<cim:StructureSupport.length>" + len + "</cim:StructureSupport.length>\n" +
        (if (null != size1) "\t\t<cim:StructureSupport.size>" + size1 + "</cim:StructureSupport.size>\n" else "") +
        (if (null != SecuredStructure) "\t\t<cim:StructureSupport.SecuredStructure rdf:resource=\"#" + SecuredStructure + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StructureSupport rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StructureSupport>\n"
    }
}

object StructureSupport
extends
    Parseable[StructureSupport]
{
    val anchorKind = parse_attribute (attribute ("""StructureSupport.anchorKind"""))
    val anchorRodCount = parse_element (element ("""StructureSupport.anchorRodCount"""))
    val anchorRodLength = parse_element (element ("""StructureSupport.anchorRodLength"""))
    val direction = parse_element (element ("""StructureSupport.direction"""))
    val kind = parse_attribute (attribute ("""StructureSupport.kind"""))
    val len = parse_element (element ("""StructureSupport.length"""))
    val size1 = parse_element (element ("""StructureSupport.size"""))
    val SecuredStructure = parse_attribute (attribute ("""StructureSupport.SecuredStructure"""))
    def parse (context: Context): StructureSupport =
    {
        StructureSupport(
            Asset.parse (context),
            anchorKind (context),
            toInteger (anchorRodCount (context), context),
            toDouble (anchorRodLength (context), context),
            toDouble (direction (context), context),
            kind (context),
            toDouble (len (context), context),
            size1 (context),
            SecuredStructure (context)
        )
    }
}

/**
 * Kind of structure support.
 * @param sup Reference to the superclass object.
 * @param anchor
 * @param guy
 */
case class StructureSupportKind
(
    override val sup: BasicElement,
    val anchor: String,
    val guy: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[StructureSupportKind] }
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
        (if (null != anchor) "\t\t<cim:StructureSupportKind.anchor rdf:resource=\"#" + anchor + "\"/>\n" else "") +
        (if (null != guy) "\t\t<cim:StructureSupportKind.guy rdf:resource=\"#" + guy + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StructureSupportKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StructureSupportKind>\n"
    }
}

object StructureSupportKind
extends
    Parseable[StructureSupportKind]
{
    val anchor = parse_attribute (attribute ("""StructureSupportKind.anchor"""))
    val guy = parse_attribute (attribute ("""StructureSupportKind.guy"""))
    def parse (context: Context): StructureSupportKind =
    {
        StructureSupportKind(
            BasicElement.parse (context),
            anchor (context),
            guy (context)
        )
    }
}

/**
 * Tower asset.
 * Dimensions of the Tower are specified in associated DimensionsInfo class.
 * @param sup Reference to the superclass object.
 * @param constructionKind Construction structure on the tower.
 */
case class Tower
(
    override val sup: Structure,
    val constructionKind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Structure: Structure = sup.asInstanceOf[Structure]
    override def copy (): Row = { clone ().asInstanceOf[Tower] }
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
        (if (null != constructionKind) "\t\t<cim:Tower.constructionKind rdf:resource=\"#" + constructionKind + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Tower rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Tower>\n"
    }
}

object Tower
extends
    Parseable[Tower]
{
    val constructionKind = parse_attribute (attribute ("""Tower.constructionKind"""))
    def parse (context: Context): Tower =
    {
        Tower(
            Structure.parse (context),
            constructionKind (context)
        )
    }
}

/**
 * Kind of tower construction.
 * @param sup Reference to the superclass object.
 * @param suspension
 * @param tension
 */
case class TowerConstructionKind
(
    override val sup: BasicElement,
    val suspension: String,
    val tension: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TowerConstructionKind] }
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
        (if (null != suspension) "\t\t<cim:TowerConstructionKind.suspension rdf:resource=\"#" + suspension + "\"/>\n" else "") +
        (if (null != tension) "\t\t<cim:TowerConstructionKind.tension rdf:resource=\"#" + tension + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TowerConstructionKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TowerConstructionKind>\n"
    }
}

object TowerConstructionKind
extends
    Parseable[TowerConstructionKind]
{
    val suspension = parse_attribute (attribute ("""TowerConstructionKind.suspension"""))
    val tension = parse_attribute (attribute ("""TowerConstructionKind.tension"""))
    def parse (context: Context): TowerConstructionKind =
    {
        TowerConstructionKind(
            BasicElement.parse (context),
            suspension (context),
            tension (context)
        )
    }
}

/**
 * Common information captured during transformer inspections and/or diagnostics.
 * Note that some properties may be measured through other means and therefore have measurement values in addition to the observed values recorded here.
 * @param sup Reference to the superclass object.
 * @param bushingTemp Bushing temperature.
 * @param dga Dissolved Gas Analysis.
 *        Typical values are: Acceptable, Overheating, Corona, Sparking, Arcing.
 * @param freqResp Frequency Response Analysis.
 *        Typical values are: acceptable, slight movement, significant movement, failed, near failure. A graphic of the response diagram, which is a type of document, may be associated with this analysis through the recursive document relationship of the ProcedureDataSet.
 * @param furfuralDP Overall measure of furfural in oil and mechanical strength of paper.
 *        DP, the degree of polymerization, is the strength of the paper. Furfural is a measure of furfural compounds, often expressed in parts per million.
 * @param hotSpotTemp Hotspot oil temperature.
 * @param oilColor Oil Quality Analysis-Color.
 * @param oilDielectricStrength Oil Quality Analysis-Dielectric Strength.
 * @param oilIFT Oil Quality Analysis- inter facial tension (IFT) - number-Dynes/CM.
 * @param oilLevel The level of oil in the transformer.
 * @param oilNeutralizationNumber Oil Quality Analysis-Neutralization Number - Number - Mg KOH.
 * @param pumpVibration Pump vibration, with typical values being: nominal, high.
 * @param status
 * @param topOilTemp Top oil temperature.
 * @param waterContent Water Content expressed in parts per million.
 * @param Reconditioning
 * @param Transformer
 */
case class TransformerObservation
(
    override val sup: IdentifiedObject,
    val bushingTemp: Double,
    val dga: String,
    val freqResp: String,
    val furfuralDP: String,
    val hotSpotTemp: Double,
    val oilColor: String,
    val oilDielectricStrength: Double,
    val oilIFT: String,
    val oilLevel: String,
    val oilNeutralizationNumber: String,
    val pumpVibration: String,
    val status: String,
    val topOilTemp: Double,
    val waterContent: String,
    val Reconditioning: String,
    val Transformer: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, 0.0, null, 0.0, null, null, null, null, null, 0.0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TransformerObservation] }
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
        "\t\t<cim:TransformerObservation.bushingTemp>" + bushingTemp + "</cim:TransformerObservation.bushingTemp>\n" +
        (if (null != dga) "\t\t<cim:TransformerObservation.dga>" + dga + "</cim:TransformerObservation.dga>\n" else "") +
        (if (null != freqResp) "\t\t<cim:TransformerObservation.freqResp>" + freqResp + "</cim:TransformerObservation.freqResp>\n" else "") +
        (if (null != furfuralDP) "\t\t<cim:TransformerObservation.furfuralDP>" + furfuralDP + "</cim:TransformerObservation.furfuralDP>\n" else "") +
        "\t\t<cim:TransformerObservation.hotSpotTemp>" + hotSpotTemp + "</cim:TransformerObservation.hotSpotTemp>\n" +
        (if (null != oilColor) "\t\t<cim:TransformerObservation.oilColor>" + oilColor + "</cim:TransformerObservation.oilColor>\n" else "") +
        "\t\t<cim:TransformerObservation.oilDielectricStrength>" + oilDielectricStrength + "</cim:TransformerObservation.oilDielectricStrength>\n" +
        (if (null != oilIFT) "\t\t<cim:TransformerObservation.oilIFT>" + oilIFT + "</cim:TransformerObservation.oilIFT>\n" else "") +
        (if (null != oilLevel) "\t\t<cim:TransformerObservation.oilLevel>" + oilLevel + "</cim:TransformerObservation.oilLevel>\n" else "") +
        (if (null != oilNeutralizationNumber) "\t\t<cim:TransformerObservation.oilNeutralizationNumber>" + oilNeutralizationNumber + "</cim:TransformerObservation.oilNeutralizationNumber>\n" else "") +
        (if (null != pumpVibration) "\t\t<cim:TransformerObservation.pumpVibration>" + pumpVibration + "</cim:TransformerObservation.pumpVibration>\n" else "") +
        (if (null != status) "\t\t<cim:TransformerObservation.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        "\t\t<cim:TransformerObservation.topOilTemp>" + topOilTemp + "</cim:TransformerObservation.topOilTemp>\n" +
        (if (null != waterContent) "\t\t<cim:TransformerObservation.waterContent>" + waterContent + "</cim:TransformerObservation.waterContent>\n" else "") +
        (if (null != Reconditioning) "\t\t<cim:TransformerObservation.Reconditioning rdf:resource=\"#" + Reconditioning + "\"/>\n" else "") +
        (if (null != Transformer) "\t\t<cim:TransformerObservation.Transformer rdf:resource=\"#" + Transformer + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransformerObservation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransformerObservation>\n"
    }
}

object TransformerObservation
extends
    Parseable[TransformerObservation]
{
    val bushingTemp = parse_element (element ("""TransformerObservation.bushingTemp"""))
    val dga = parse_element (element ("""TransformerObservation.dga"""))
    val freqResp = parse_element (element ("""TransformerObservation.freqResp"""))
    val furfuralDP = parse_element (element ("""TransformerObservation.furfuralDP"""))
    val hotSpotTemp = parse_element (element ("""TransformerObservation.hotSpotTemp"""))
    val oilColor = parse_element (element ("""TransformerObservation.oilColor"""))
    val oilDielectricStrength = parse_element (element ("""TransformerObservation.oilDielectricStrength"""))
    val oilIFT = parse_element (element ("""TransformerObservation.oilIFT"""))
    val oilLevel = parse_element (element ("""TransformerObservation.oilLevel"""))
    val oilNeutralizationNumber = parse_element (element ("""TransformerObservation.oilNeutralizationNumber"""))
    val pumpVibration = parse_element (element ("""TransformerObservation.pumpVibration"""))
    val status = parse_attribute (attribute ("""TransformerObservation.status"""))
    val topOilTemp = parse_element (element ("""TransformerObservation.topOilTemp"""))
    val waterContent = parse_element (element ("""TransformerObservation.waterContent"""))
    val Reconditioning = parse_attribute (attribute ("""TransformerObservation.Reconditioning"""))
    val Transformer = parse_attribute (attribute ("""TransformerObservation.Transformer"""))
    def parse (context: Context): TransformerObservation =
    {
        TransformerObservation(
            IdentifiedObject.parse (context),
            toDouble (bushingTemp (context), context),
            dga (context),
            freqResp (context),
            furfuralDP (context),
            toDouble (hotSpotTemp (context), context),
            oilColor (context),
            toDouble (oilDielectricStrength (context), context),
            oilIFT (context),
            oilLevel (context),
            oilNeutralizationNumber (context),
            pumpVibration (context),
            status (context),
            toDouble (topOilTemp (context), context),
            waterContent (context),
            Reconditioning (context),
            Transformer (context)
        )
    }
}

/**
 * Underground structure.
 * @param sup Reference to the superclass object.
 * @param hasVentilation True if vault is ventilating.
 * @param kind True if vault is ventilating.
 * @param material Primary material of underground structure.
 * @param sealingWarrantyExpiresDate Date sealing warranty expires.
 */
case class UndergroundStructure
(
    override val sup: Structure,
    val hasVentilation: Boolean,
    val kind: String,
    val material: String,
    val sealingWarrantyExpiresDate: String
)
extends
    Element
{
    def this () = { this (null, false, null, null, null) }
    def Structure: Structure = sup.asInstanceOf[Structure]
    override def copy (): Row = { clone ().asInstanceOf[UndergroundStructure] }
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
        "\t\t<cim:UndergroundStructure.hasVentilation>" + hasVentilation + "</cim:UndergroundStructure.hasVentilation>\n" +
        (if (null != kind) "\t\t<cim:UndergroundStructure.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != material) "\t\t<cim:UndergroundStructure.material>" + material + "</cim:UndergroundStructure.material>\n" else "") +
        (if (null != sealingWarrantyExpiresDate) "\t\t<cim:UndergroundStructure.sealingWarrantyExpiresDate>" + sealingWarrantyExpiresDate + "</cim:UndergroundStructure.sealingWarrantyExpiresDate>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:UndergroundStructure rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UndergroundStructure>\n"
    }
}

object UndergroundStructure
extends
    Parseable[UndergroundStructure]
{
    val hasVentilation = parse_element (element ("""UndergroundStructure.hasVentilation"""))
    val kind = parse_attribute (attribute ("""UndergroundStructure.kind"""))
    val material = parse_element (element ("""UndergroundStructure.material"""))
    val sealingWarrantyExpiresDate = parse_element (element ("""UndergroundStructure.sealingWarrantyExpiresDate"""))
    def parse (context: Context): UndergroundStructure =
    {
        UndergroundStructure(
            Structure.parse (context),
            toBoolean (hasVentilation (context), context),
            kind (context),
            material (context),
            sealingWarrantyExpiresDate (context)
        )
    }
}

/**
 * Kind of underground structure.
 * @param sup Reference to the superclass object.
 * @param burd
 * @param enclosure
 * @param handhole
 * @param manhole
 * @param pad
 * @param pullbox
 * @param subsurfaceEnclosure
 * @param trench
 * @param tunnel
 * @param vault
 */
case class UndergroundStructureKind
(
    override val sup: BasicElement,
    val burd: String,
    val enclosure: String,
    val handhole: String,
    val manhole: String,
    val pad: String,
    val pullbox: String,
    val subsurfaceEnclosure: String,
    val trench: String,
    val tunnel: String,
    val vault: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[UndergroundStructureKind] }
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
        (if (null != burd) "\t\t<cim:UndergroundStructureKind.burd rdf:resource=\"#" + burd + "\"/>\n" else "") +
        (if (null != enclosure) "\t\t<cim:UndergroundStructureKind.enclosure rdf:resource=\"#" + enclosure + "\"/>\n" else "") +
        (if (null != handhole) "\t\t<cim:UndergroundStructureKind.handhole rdf:resource=\"#" + handhole + "\"/>\n" else "") +
        (if (null != manhole) "\t\t<cim:UndergroundStructureKind.manhole rdf:resource=\"#" + manhole + "\"/>\n" else "") +
        (if (null != pad) "\t\t<cim:UndergroundStructureKind.pad rdf:resource=\"#" + pad + "\"/>\n" else "") +
        (if (null != pullbox) "\t\t<cim:UndergroundStructureKind.pullbox rdf:resource=\"#" + pullbox + "\"/>\n" else "") +
        (if (null != subsurfaceEnclosure) "\t\t<cim:UndergroundStructureKind.subsurfaceEnclosure rdf:resource=\"#" + subsurfaceEnclosure + "\"/>\n" else "") +
        (if (null != trench) "\t\t<cim:UndergroundStructureKind.trench rdf:resource=\"#" + trench + "\"/>\n" else "") +
        (if (null != tunnel) "\t\t<cim:UndergroundStructureKind.tunnel rdf:resource=\"#" + tunnel + "\"/>\n" else "") +
        (if (null != vault) "\t\t<cim:UndergroundStructureKind.vault rdf:resource=\"#" + vault + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:UndergroundStructureKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UndergroundStructureKind>\n"
    }
}

object UndergroundStructureKind
extends
    Parseable[UndergroundStructureKind]
{
    val burd = parse_attribute (attribute ("""UndergroundStructureKind.burd"""))
    val enclosure = parse_attribute (attribute ("""UndergroundStructureKind.enclosure"""))
    val handhole = parse_attribute (attribute ("""UndergroundStructureKind.handhole"""))
    val manhole = parse_attribute (attribute ("""UndergroundStructureKind.manhole"""))
    val pad = parse_attribute (attribute ("""UndergroundStructureKind.pad"""))
    val pullbox = parse_attribute (attribute ("""UndergroundStructureKind.pullbox"""))
    val subsurfaceEnclosure = parse_attribute (attribute ("""UndergroundStructureKind.subsurfaceEnclosure"""))
    val trench = parse_attribute (attribute ("""UndergroundStructureKind.trench"""))
    val tunnel = parse_attribute (attribute ("""UndergroundStructureKind.tunnel"""))
    val vault = parse_attribute (attribute ("""UndergroundStructureKind.vault"""))
    def parse (context: Context): UndergroundStructureKind =
    {
        UndergroundStructureKind(
            BasicElement.parse (context),
            burd (context),
            enclosure (context),
            handhole (context),
            manhole (context),
            pad (context),
            pullbox (context),
            subsurfaceEnclosure (context),
            trench (context),
            tunnel (context),
            vault (context)
        )
    }
}

/**
 * Winding insulation condition as a result of a test.
 * @param sup Reference to the superclass object.
 * @param insulationPFStatus Status of Winding Insulation Power Factor as of statusDate: Acceptable, Minor Deterioration or Moisture Absorption, Major Deterioration or Moisture Absorption, Failed.
 * @param insulationResistance For testType, status of Winding Insulation Resistance as of statusDate.
 *        Typical values are: Acceptable, Questionable, Failed.
 * @param leakageReactance As of statusDate, the leakage reactance measured at the "from" winding with the "to" winding short-circuited and all other windings open-circuited.
 * @param status
 * @param FromWinding
 * @param ToWinding
 * @param TransformerObservation
 */
case class WindingInsulation
(
    override val sup: IdentifiedObject,
    val insulationPFStatus: String,
    val insulationResistance: String,
    val leakageReactance: Double,
    val status: String,
    val FromWinding: String,
    val ToWinding: String,
    val TransformerObservation: String
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindingInsulation] }
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
        (if (null != insulationPFStatus) "\t\t<cim:WindingInsulation.insulationPFStatus>" + insulationPFStatus + "</cim:WindingInsulation.insulationPFStatus>\n" else "") +
        (if (null != insulationResistance) "\t\t<cim:WindingInsulation.insulationResistance>" + insulationResistance + "</cim:WindingInsulation.insulationResistance>\n" else "") +
        "\t\t<cim:WindingInsulation.leakageReactance>" + leakageReactance + "</cim:WindingInsulation.leakageReactance>\n" +
        (if (null != status) "\t\t<cim:WindingInsulation.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != FromWinding) "\t\t<cim:WindingInsulation.FromWinding rdf:resource=\"#" + FromWinding + "\"/>\n" else "") +
        (if (null != ToWinding) "\t\t<cim:WindingInsulation.ToWinding rdf:resource=\"#" + ToWinding + "\"/>\n" else "") +
        (if (null != TransformerObservation) "\t\t<cim:WindingInsulation.TransformerObservation rdf:resource=\"#" + TransformerObservation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindingInsulation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindingInsulation>\n"
    }
}

object WindingInsulation
extends
    Parseable[WindingInsulation]
{
    val insulationPFStatus = parse_element (element ("""WindingInsulation.insulationPFStatus"""))
    val insulationResistance = parse_element (element ("""WindingInsulation.insulationResistance"""))
    val leakageReactance = parse_element (element ("""WindingInsulation.leakageReactance"""))
    val status = parse_attribute (attribute ("""WindingInsulation.status"""))
    val FromWinding = parse_attribute (attribute ("""WindingInsulation.FromWinding"""))
    val ToWinding = parse_attribute (attribute ("""WindingInsulation.ToWinding"""))
    val TransformerObservation = parse_attribute (attribute ("""WindingInsulation.TransformerObservation"""))
    def parse (context: Context): WindingInsulation =
    {
        WindingInsulation(
            IdentifiedObject.parse (context),
            insulationPFStatus (context),
            insulationResistance (context),
            toDouble (leakageReactance (context), context),
            status (context),
            FromWinding (context),
            ToWinding (context),
            TransformerObservation (context)
        )
    }
}

object _InfAssets
{
    def register: Unit =
    {
        AnchorKind.register
        AssetPropertyCurve.register
        Bushing.register
        BushingInsulationKind.register
        BushingInsulationPF.register
        BushingInsulationPfTestKind.register
        Cabinet.register
        CoolingKind.register
        CoolingPowerRating.register
        DimensionsInfo.register
        DuctBank.register
        FACTSDevice.register
        FACTSDeviceKind.register
        Facility.register
        FailureEvent.register
        FailureIsolationMethodKind.register
        FinancialInfo.register
        GenericAssetModelOrMaterial.register
        Joint.register
        JointConfigurationKind.register
        JointFillKind.register
        Medium.register
        MediumKind.register
        Pole.register
        PoleBaseKind.register
        PolePreservativeKind.register
        PoleTreatmentKind.register
        Reconditioning.register
        ReliabilityInfo.register
        Specification.register
        Streetlight.register
        StreetlightLampKind.register
        Structure.register
        StructureMaterialKind.register
        StructureSupport.register
        StructureSupportKind.register
        Tower.register
        TowerConstructionKind.register
        TransformerObservation.register
        UndergroundStructure.register
        UndergroundStructureKind.register
        WindingInsulation.register
    }
}