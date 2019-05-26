package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * An Asset Property that is described through curves rather than as a data point.
 *
 * The relationship is to be defined between an independent variable (X-axis) and one or two dependent variables (Y1-axis and Y2-axis).
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param Assets [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
 * @param Specification [[ch.ninecode.model.Specification Specification]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
<ul>
	<li>Assets can have names, through inheritance to the Naming package</li>
	<li>Assets are physical entities which have a lifecycle</li>
	<li>One or more assets can be associated to create a PowerSystemResource</li>
	<li>Assets can be grouped (aggregated) with other Assets</li>
	<li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
	<li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
</ul>
The following sections describe the packages in the Assets package.
The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
case class AssetPropertyCurve
(
    override val sup: Curve,
    Assets: List[String],
    Specification: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AssetPropertyCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AssetPropertyCurve.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (AssetPropertyCurve.fields (position), x))
        emitattrs (0, Assets)
        emitattr (1, Specification)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetPropertyCurve rdf:ID=\"%s\">\n%s\t</cim:AssetPropertyCurve>".format (id, export_fields)
    }
}

object AssetPropertyCurve
extends
    Parseable[AssetPropertyCurve]
{
    override val fields: Array[String] = Array[String] (
        "Assets",
        "Specification"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Assets", "Asset", "0..*", "0..*"),
        Relationship ("Specification", "Specification", "0..1", "0..*")
    )
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Specification: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): AssetPropertyCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AssetPropertyCurve (
            Curve.parse (context),
            masks (Assets (), 0),
            mask (Specification (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Bushing insulation power factor condition as a result of a test.
 *
 * Typical status values are: Acceptable, Minor Deterioration or Moisture Absorption, Major Deterioration or Moisture Absorption, Failed.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param testKind Kind of test for this bushing.
 * @param Bushing [[ch.ninecode.model.Bushing Bushing]] <em>undocumented</em>
 * @param TransformerObservation [[ch.ninecode.model.TransformerObservation TransformerObservation]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
<ul>
	<li>Assets can have names, through inheritance to the Naming package</li>
	<li>Assets are physical entities which have a lifecycle</li>
	<li>One or more assets can be associated to create a PowerSystemResource</li>
	<li>Assets can be grouped (aggregated) with other Assets</li>
	<li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
	<li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
</ul>
The following sections describe the packages in the Assets package.
The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
case class BushingInsulationPF
(
    override val sup: IdentifiedObject,
    status: String,
    testKind: String,
    Bushing: String,
    TransformerObservation: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BushingInsulationPF.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BushingInsulationPF.fields (position), value)
        emitattr (0, status)
        emitattr (1, testKind)
        emitattr (2, Bushing)
        emitattr (3, TransformerObservation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BushingInsulationPF rdf:ID=\"%s\">\n%s\t</cim:BushingInsulationPF>".format (id, export_fields)
    }
}

object BushingInsulationPF
extends
    Parseable[BushingInsulationPF]
{
    override val fields: Array[String] = Array[String] (
        "status",
        "testKind",
        "Bushing",
        "TransformerObservation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Bushing", "Bushing", "0..1", "0..*"),
        Relationship ("TransformerObservation", "TransformerObservation", "0..1", "0..*")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val testKind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Bushing: Fielder = parse_attribute (attribute (cls, fields(2)))
    val TransformerObservation: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): BushingInsulationPF =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BushingInsulationPF (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            mask (testKind (), 1),
            mask (Bushing (), 2),
            mask (TransformerObservation (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * There are often stages of power which are associated with stages of cooling.
 *
 * For instance, a transformer may be rated 121kV on the primary, 15kV on the secondary and 4kV on the tertiary winding. These are voltage ratings and the power ratings are generally the same for all three windings and independent of the voltage ratings, there are instances where the tertiary may have a lower power rating.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param coolingKind Kind of cooling system.
 * @param powerRating The power rating associated with type of cooling specified for this stage.
 * @param stage Stage of cooling and associated power rating.
 * @param Reconditionings [[ch.ninecode.model.Reconditioning Reconditioning]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
<ul>
	<li>Assets can have names, through inheritance to the Naming package</li>
	<li>Assets are physical entities which have a lifecycle</li>
	<li>One or more assets can be associated to create a PowerSystemResource</li>
	<li>Assets can be grouped (aggregated) with other Assets</li>
	<li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
	<li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
</ul>
The following sections describe the packages in the Assets package.
The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
case class CoolingPowerRating
(
    override val sup: IdentifiedObject,
    coolingKind: String,
    powerRating: Double,
    stage: Int,
    Reconditionings: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CoolingPowerRating.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CoolingPowerRating.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CoolingPowerRating.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (CoolingPowerRating.fields (position), x))
        emitattr (0, coolingKind)
        emitelem (1, powerRating)
        emitelem (2, stage)
        emitattrs (3, Reconditionings)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CoolingPowerRating rdf:ID=\"%s\">\n%s\t</cim:CoolingPowerRating>".format (id, export_fields)
    }
}

object CoolingPowerRating
extends
    Parseable[CoolingPowerRating]
{
    override val fields: Array[String] = Array[String] (
        "coolingKind",
        "powerRating",
        "stage",
        "Reconditionings"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Reconditionings", "Reconditioning", "0..*", "0..*")
    )
    val coolingKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val powerRating: Fielder = parse_element (element (cls, fields(1)))
    val stage: Fielder = parse_element (element (cls, fields(2)))
    val Reconditionings: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): CoolingPowerRating =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CoolingPowerRating (
            IdentifiedObject.parse (context),
            mask (coolingKind (), 0),
            toDouble (mask (powerRating (), 1)),
            toInteger (mask (stage (), 2)),
            masks (Reconditionings (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * As applicable, the basic linear, area, or volume dimensions of an asset, asset type (AssetModel) or other type of object (such as land area).
 *
 * Units and multipliers are specified per dimension.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param orientation A description of the orientation of the object relative to the dimensions.
 *        As an example, a vault may have north-south orientation for the sizeLength measurement and sizeDepth may be the height of the vault.
 * @param sizeDepth Depth measurement.
 * @param sizeDiameter Diameter measurement.
 * @param sizeLength Length measurement.
 * @param sizeWidth Width measurement.
 * @param Specifications [[ch.ninecode.model.Specification Specification]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
<ul>
	<li>Assets can have names, through inheritance to the Naming package</li>
	<li>Assets are physical entities which have a lifecycle</li>
	<li>One or more assets can be associated to create a PowerSystemResource</li>
	<li>Assets can be grouped (aggregated) with other Assets</li>
	<li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
	<li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
</ul>
The following sections describe the packages in the Assets package.
The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
case class DimensionsInfo
(
    override val sup: IdentifiedObject,
    orientation: String,
    sizeDepth: Double,
    sizeDiameter: Double,
    sizeLength: Double,
    sizeWidth: Double,
    Specifications: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DimensionsInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DimensionsInfo.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (DimensionsInfo.fields (position), x))
        emitelem (0, orientation)
        emitelem (1, sizeDepth)
        emitelem (2, sizeDiameter)
        emitelem (3, sizeLength)
        emitelem (4, sizeWidth)
        emitattrs (5, Specifications)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DimensionsInfo rdf:ID=\"%s\">\n%s\t</cim:DimensionsInfo>".format (id, export_fields)
    }
}

object DimensionsInfo
extends
    Parseable[DimensionsInfo]
{
    override val fields: Array[String] = Array[String] (
        "orientation",
        "sizeDepth",
        "sizeDiameter",
        "sizeLength",
        "sizeWidth",
        "Specifications"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Specifications", "Specification", "0..*", "0..*")
    )
    val orientation: Fielder = parse_element (element (cls, fields(0)))
    val sizeDepth: Fielder = parse_element (element (cls, fields(1)))
    val sizeDiameter: Fielder = parse_element (element (cls, fields(2)))
    val sizeLength: Fielder = parse_element (element (cls, fields(3)))
    val sizeWidth: Fielder = parse_element (element (cls, fields(4)))
    val Specifications: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): DimensionsInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DimensionsInfo (
            IdentifiedObject.parse (context),
            mask (orientation (), 0),
            toDouble (mask (sizeDepth (), 1)),
            toDouble (mask (sizeDiameter (), 2)),
            toDouble (mask (sizeLength (), 3)),
            toDouble (mask (sizeWidth (), 4)),
            masks (Specifications (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Pole asset.
 *
 * @param sup [[ch.ninecode.model.Structure Structure]] Reference to the superclass object.
 * @param baseKind Kind of base for this pole.
 * @param breastBlock True if a block of material has been attached to base of pole in ground for stability.
 *        This technique is used primarily when anchors can not be used.
 * @param classification Pole class: 1, 2, 3, 4, 5, 6, 7, H1, H2, Other, Unknown.
 * @param construction The framing structure mounted on the pole.
 * @param diameter Diameter of the pole.
 * @param jpaReference Joint pole agreement reference number.
 * @param length Length of the pole (inclusive of any section of the pole that may be underground post-installation).
 * @param preservativeKind Kind of preservative for this pole.
 * @param speciesType Pole species.
 *        Aluminum, Aluminum Davit, Concrete, Fiberglass, Galvanized Davit, Galvanized, Steel Davit Primed, Steel Davit, Steel Standard Primed, Steel, Truncated, Wood-Treated, Wood-Hard, Wood-Salt Treated, Wood-Soft, Wood, Other, Unknown.
 * @param treatedDateTime Date and time pole was last treated with preservative.
 * @param treatmentKind Kind of treatment for this pole.
 * @param Streetlights [[ch.ninecode.model.Streetlight Streetlight]] All streetlights attached to this pole.
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
<ul>
	<li>Assets can have names, through inheritance to the Naming package</li>
	<li>Assets are physical entities which have a lifecycle</li>
	<li>One or more assets can be associated to create a PowerSystemResource</li>
	<li>Assets can be grouped (aggregated) with other Assets</li>
	<li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
	<li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
</ul>
The following sections describe the packages in the Assets package.
The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
case class Pole
(
    override val sup: Structure,
    baseKind: String,
    breastBlock: Boolean,
    classification: String,
    construction: String,
    diameter: Double,
    jpaReference: String,
    len: Double,
    preservativeKind: String,
    speciesType: String,
    treatedDateTime: String,
    treatmentKind: String,
    Streetlights: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, false, null, null, 0.0, null, 0.0, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Pole.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Pole.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Pole.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Pole.fields (position), x))
        emitattr (0, baseKind)
        emitelem (1, breastBlock)
        emitelem (2, classification)
        emitelem (3, construction)
        emitelem (4, diameter)
        emitelem (5, jpaReference)
        emitelem (6, len)
        emitattr (7, preservativeKind)
        emitelem (8, speciesType)
        emitelem (9, treatedDateTime)
        emitattr (10, treatmentKind)
        emitattrs (11, Streetlights)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Pole rdf:ID=\"%s\">\n%s\t</cim:Pole>".format (id, export_fields)
    }
}

object Pole
extends
    Parseable[Pole]
{
    override val fields: Array[String] = Array[String] (
        "baseKind",
        "breastBlock",
        "classification",
        "construction",
        "diameter",
        "jpaReference",
        "length",
        "preservativeKind",
        "speciesType",
        "treatedDateTime",
        "treatmentKind",
        "Streetlights"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Streetlights", "Streetlight", "0..*", "0..1")
    )
    val baseKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val breastBlock: Fielder = parse_element (element (cls, fields(1)))
    val classification: Fielder = parse_element (element (cls, fields(2)))
    val construction: Fielder = parse_element (element (cls, fields(3)))
    val diameter: Fielder = parse_element (element (cls, fields(4)))
    val jpaReference: Fielder = parse_element (element (cls, fields(5)))
    val len: Fielder = parse_element (element (cls, fields(6)))
    val preservativeKind: Fielder = parse_attribute (attribute (cls, fields(7)))
    val speciesType: Fielder = parse_element (element (cls, fields(8)))
    val treatedDateTime: Fielder = parse_element (element (cls, fields(9)))
    val treatmentKind: Fielder = parse_attribute (attribute (cls, fields(10)))
    val Streetlights: FielderMultiple = parse_attributes (attribute (cls, fields(11)))

    def parse (context: Context): Pole =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Pole (
            Structure.parse (context),
            mask (baseKind (), 0),
            toBoolean (mask (breastBlock (), 1)),
            mask (classification (), 2),
            mask (construction (), 3),
            toDouble (mask (diameter (), 4)),
            mask (jpaReference (), 5),
            toDouble (mask (len (), 6)),
            mask (preservativeKind (), 7),
            mask (speciesType (), 8),
            mask (treatedDateTime (), 9),
            mask (treatmentKind (), 10),
            masks (Streetlights (), 11)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Reconditioning information for an asset.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dateTime Date and time this reconditioning (or a major overhaul) has been performed.
 * @param Asset [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
 * @param PowerRatings [[ch.ninecode.model.CoolingPowerRating CoolingPowerRating]] <em>undocumented</em>
 * @param TransformerObservations [[ch.ninecode.model.TransformerObservation TransformerObservation]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
<ul>
	<li>Assets can have names, through inheritance to the Naming package</li>
	<li>Assets are physical entities which have a lifecycle</li>
	<li>One or more assets can be associated to create a PowerSystemResource</li>
	<li>Assets can be grouped (aggregated) with other Assets</li>
	<li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
	<li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
</ul>
The following sections describe the packages in the Assets package.
The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
case class Reconditioning
(
    override val sup: IdentifiedObject,
    dateTime: String,
    Asset: String,
    PowerRatings: List[String],
    TransformerObservations: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Reconditioning.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Reconditioning.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Reconditioning.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Reconditioning.fields (position), x))
        emitelem (0, dateTime)
        emitattr (1, Asset)
        emitattrs (2, PowerRatings)
        emitattrs (3, TransformerObservations)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Reconditioning rdf:ID=\"%s\">\n%s\t</cim:Reconditioning>".format (id, export_fields)
    }
}

object Reconditioning
extends
    Parseable[Reconditioning]
{
    override val fields: Array[String] = Array[String] (
        "dateTime",
        "Asset",
        "PowerRatings",
        "TransformerObservations"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Asset", "Asset", "0..1", "0..*"),
        Relationship ("PowerRatings", "CoolingPowerRating", "0..*", "0..*"),
        Relationship ("TransformerObservations", "TransformerObservation", "0..*", "1")
    )
    val dateTime: Fielder = parse_element (element (cls, fields(0)))
    val Asset: Fielder = parse_attribute (attribute (cls, fields(1)))
    val PowerRatings: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val TransformerObservations: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): Reconditioning =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Reconditioning (
            IdentifiedObject.parse (context),
            mask (dateTime (), 0),
            mask (Asset (), 1),
            masks (PowerRatings (), 2),
            masks (TransformerObservations (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Information regarding the experienced and expected reliability of a specific asset, type of asset, or asset model.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param mTTR Mean time to repair (MTTR - hours).
 * @param momFailureRate Momentary failure rate (temporary failures/kft-year).
 * @param Assets [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
 * @param Specification [[ch.ninecode.model.Specification Specification]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
<ul>
	<li>Assets can have names, through inheritance to the Naming package</li>
	<li>Assets are physical entities which have a lifecycle</li>
	<li>One or more assets can be associated to create a PowerSystemResource</li>
	<li>Assets can be grouped (aggregated) with other Assets</li>
	<li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
	<li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
</ul>
The following sections describe the packages in the Assets package.
The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
case class ReliabilityInfo
(
    override val sup: IdentifiedObject,
    mTTR: Double,
    momFailureRate: Double,
    Assets: List[String],
    Specification: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ReliabilityInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ReliabilityInfo.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ReliabilityInfo.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ReliabilityInfo.fields (position), x))
        emitelem (0, mTTR)
        emitelem (1, momFailureRate)
        emitattrs (2, Assets)
        emitattr (3, Specification)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ReliabilityInfo rdf:ID=\"%s\">\n%s\t</cim:ReliabilityInfo>".format (id, export_fields)
    }
}

object ReliabilityInfo
extends
    Parseable[ReliabilityInfo]
{
    override val fields: Array[String] = Array[String] (
        "mTTR",
        "momFailureRate",
        "Assets",
        "Specification"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Assets", "Asset", "0..*", "0..*"),
        Relationship ("Specification", "Specification", "0..1", "0..*")
    )
    val mTTR: Fielder = parse_element (element (cls, fields(0)))
    val momFailureRate: Fielder = parse_element (element (cls, fields(1)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Specification: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): ReliabilityInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ReliabilityInfo (
            IdentifiedObject.parse (context),
            toDouble (mask (mTTR (), 0)),
            toDouble (mask (momFailureRate (), 1)),
            masks (Assets (), 2),
            mask (Specification (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Specification can be used for various purposes relative to an asset, a logical device (PowerSystemResource), location, etc.
 *
 * Examples include documents supplied by manufacturers such as asset installation instructions, asset maintenance instructions, etc.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param AssetProperites [[ch.ninecode.model.UserAttribute UserAttribute]] UserAttributes used to specify further properties of the asset covered with this specification.
 *        Use 'name' to specify what kind of property it is, and 'value.value' attribute for the actual value.
 * @param AssetPropertyCurves [[ch.ninecode.model.AssetPropertyCurve AssetPropertyCurve]] <em>undocumented</em>
 * @param DimensionsInfos [[ch.ninecode.model.DimensionsInfo DimensionsInfo]] <em>undocumented</em>
 * @param Mediums [[ch.ninecode.model.Medium Medium]] <em>undocumented</em>
 * @param QualificationRequirements [[ch.ninecode.model.QualificationRequirement QualificationRequirement]] <em>undocumented</em>
 * @param Ratings [[ch.ninecode.model.UserAttribute UserAttribute]] UserAttributes used to specify ratings of the asset covered by this specification.
 *        Ratings also can be used to set the initial value of operational measurement limits. Use 'name' to specify what kind of rating it is (e.g., voltage, current), and 'value' attribute for the actual value and unit information of the rating.
 * @param ReliabilityInfos [[ch.ninecode.model.ReliabilityInfo ReliabilityInfo]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
<ul>
	<li>Assets can have names, through inheritance to the Naming package</li>
	<li>Assets are physical entities which have a lifecycle</li>
	<li>One or more assets can be associated to create a PowerSystemResource</li>
	<li>Assets can be grouped (aggregated) with other Assets</li>
	<li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
	<li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
</ul>
The following sections describe the packages in the Assets package.
The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
case class Specification
(
    override val sup: Document,
    AssetProperites: List[String],
    AssetPropertyCurves: List[String],
    DimensionsInfos: List[String],
    Mediums: List[String],
    QualificationRequirements: List[String],
    Ratings: List[String],
    ReliabilityInfos: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List(), List(), List(), List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Specification.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Specification.fields (position), x))
        emitattrs (0, AssetProperites)
        emitattrs (1, AssetPropertyCurves)
        emitattrs (2, DimensionsInfos)
        emitattrs (3, Mediums)
        emitattrs (4, QualificationRequirements)
        emitattrs (5, Ratings)
        emitattrs (6, ReliabilityInfos)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Specification rdf:ID=\"%s\">\n%s\t</cim:Specification>".format (id, export_fields)
    }
}

object Specification
extends
    Parseable[Specification]
{
    override val fields: Array[String] = Array[String] (
        "AssetProperites",
        "AssetPropertyCurves",
        "DimensionsInfos",
        "Mediums",
        "QualificationRequirements",
        "Ratings",
        "ReliabilityInfos"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AssetProperites", "UserAttribute", "0..*", "0..1"),
        Relationship ("AssetPropertyCurves", "AssetPropertyCurve", "0..*", "0..1"),
        Relationship ("DimensionsInfos", "DimensionsInfo", "0..*", "0..*"),
        Relationship ("Mediums", "Medium", "0..*", "0..1"),
        Relationship ("QualificationRequirements", "QualificationRequirement", "0..*", "0..*"),
        Relationship ("Ratings", "UserAttribute", "0..*", "0..1"),
        Relationship ("ReliabilityInfos", "ReliabilityInfo", "0..*", "0..1")
    )
    val AssetProperites: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val AssetPropertyCurves: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val DimensionsInfos: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Mediums: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val QualificationRequirements: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Ratings: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val ReliabilityInfos: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): Specification =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Specification (
            Document.parse (context),
            masks (AssetProperites (), 0),
            masks (AssetPropertyCurves (), 1),
            masks (DimensionsInfos (), 2),
            masks (Mediums (), 3),
            masks (QualificationRequirements (), 4),
            masks (Ratings (), 5),
            masks (ReliabilityInfos (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Tower asset.
 *
 * Dimensions of the Tower are specified in associated DimensionsInfo class.
 *
 * @param sup [[ch.ninecode.model.Structure Structure]] Reference to the superclass object.
 * @param constructionKind Construction structure on the tower.
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
<ul>
	<li>Assets can have names, through inheritance to the Naming package</li>
	<li>Assets are physical entities which have a lifecycle</li>
	<li>One or more assets can be associated to create a PowerSystemResource</li>
	<li>Assets can be grouped (aggregated) with other Assets</li>
	<li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
	<li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
</ul>
The following sections describe the packages in the Assets package.
The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
case class Tower
(
    override val sup: Structure,
    constructionKind: String
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Tower.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Tower.fields (position), value)
        emitattr (0, constructionKind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Tower rdf:ID=\"%s\">\n%s\t</cim:Tower>".format (id, export_fields)
    }
}

object Tower
extends
    Parseable[Tower]
{
    override val fields: Array[String] = Array[String] (
        "constructionKind"
    )
    val constructionKind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): Tower =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Tower (
            Structure.parse (context),
            mask (constructionKind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Common information captured during transformer inspections and/or diagnostics.
 *
 * Note that some properties may be measured through other means and therefore have measurement values in addition to the observed values recorded here.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
 * @param status <em>undocumented</em>
 * @param topOilTemp Top oil temperature.
 * @param waterContent Water Content expressed in parts per million.
 * @param BushingInsultationPFs [[ch.ninecode.model.BushingInsulationPF BushingInsulationPF]] <em>undocumented</em>
 * @param ProcedureDataSets [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] <em>undocumented</em>
 * @param Reconditioning [[ch.ninecode.model.Reconditioning Reconditioning]] <em>undocumented</em>
 * @param Transformer [[ch.ninecode.model.TransformerTank TransformerTank]] <em>undocumented</em>
 * @param WindingInsulationPFs [[ch.ninecode.model.WindingInsulation WindingInsulation]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
<ul>
	<li>Assets can have names, through inheritance to the Naming package</li>
	<li>Assets are physical entities which have a lifecycle</li>
	<li>One or more assets can be associated to create a PowerSystemResource</li>
	<li>Assets can be grouped (aggregated) with other Assets</li>
	<li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
	<li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
</ul>
The following sections describe the packages in the Assets package.
The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
case class TransformerObservation
(
    override val sup: IdentifiedObject,
    bushingTemp: Double,
    dga: String,
    freqResp: String,
    furfuralDP: String,
    hotSpotTemp: Double,
    oilColor: String,
    oilDielectricStrength: Double,
    oilIFT: String,
    oilLevel: String,
    oilNeutralizationNumber: String,
    pumpVibration: String,
    status: String,
    topOilTemp: Double,
    waterContent: String,
    BushingInsultationPFs: List[String],
    ProcedureDataSets: List[String],
    Reconditioning: String,
    Transformer: String,
    WindingInsulationPFs: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null, 0.0, null, 0.0, null, null, null, null, null, 0.0, null, List(), List(), null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TransformerObservation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransformerObservation.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransformerObservation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (TransformerObservation.fields (position), x))
        emitelem (0, bushingTemp)
        emitelem (1, dga)
        emitelem (2, freqResp)
        emitelem (3, furfuralDP)
        emitelem (4, hotSpotTemp)
        emitelem (5, oilColor)
        emitelem (6, oilDielectricStrength)
        emitelem (7, oilIFT)
        emitelem (8, oilLevel)
        emitelem (9, oilNeutralizationNumber)
        emitelem (10, pumpVibration)
        emitattr (11, status)
        emitelem (12, topOilTemp)
        emitelem (13, waterContent)
        emitattrs (14, BushingInsultationPFs)
        emitattrs (15, ProcedureDataSets)
        emitattr (16, Reconditioning)
        emitattr (17, Transformer)
        emitattrs (18, WindingInsulationPFs)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransformerObservation rdf:ID=\"%s\">\n%s\t</cim:TransformerObservation>".format (id, export_fields)
    }
}

object TransformerObservation
extends
    Parseable[TransformerObservation]
{
    override val fields: Array[String] = Array[String] (
        "bushingTemp",
        "dga",
        "freqResp",
        "furfuralDP",
        "hotSpotTemp",
        "oilColor",
        "oilDielectricStrength",
        "oilIFT",
        "oilLevel",
        "oilNeutralizationNumber",
        "pumpVibration",
        "status",
        "topOilTemp",
        "waterContent",
        "BushingInsultationPFs",
        "ProcedureDataSets",
        "Reconditioning",
        "Transformer",
        "WindingInsulationPFs"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BushingInsultationPFs", "BushingInsulationPF", "0..*", "0..1"),
        Relationship ("ProcedureDataSets", "ProcedureDataSet", "0..*", "0..*"),
        Relationship ("Reconditioning", "Reconditioning", "1", "0..*"),
        Relationship ("Transformer", "TransformerTank", "0..1", "0..*"),
        Relationship ("WindingInsulationPFs", "WindingInsulation", "0..*", "0..1")
    )
    val bushingTemp: Fielder = parse_element (element (cls, fields(0)))
    val dga: Fielder = parse_element (element (cls, fields(1)))
    val freqResp: Fielder = parse_element (element (cls, fields(2)))
    val furfuralDP: Fielder = parse_element (element (cls, fields(3)))
    val hotSpotTemp: Fielder = parse_element (element (cls, fields(4)))
    val oilColor: Fielder = parse_element (element (cls, fields(5)))
    val oilDielectricStrength: Fielder = parse_element (element (cls, fields(6)))
    val oilIFT: Fielder = parse_element (element (cls, fields(7)))
    val oilLevel: Fielder = parse_element (element (cls, fields(8)))
    val oilNeutralizationNumber: Fielder = parse_element (element (cls, fields(9)))
    val pumpVibration: Fielder = parse_element (element (cls, fields(10)))
    val status: Fielder = parse_attribute (attribute (cls, fields(11)))
    val topOilTemp: Fielder = parse_element (element (cls, fields(12)))
    val waterContent: Fielder = parse_element (element (cls, fields(13)))
    val BushingInsultationPFs: FielderMultiple = parse_attributes (attribute (cls, fields(14)))
    val ProcedureDataSets: FielderMultiple = parse_attributes (attribute (cls, fields(15)))
    val Reconditioning: Fielder = parse_attribute (attribute (cls, fields(16)))
    val Transformer: Fielder = parse_attribute (attribute (cls, fields(17)))
    val WindingInsulationPFs: FielderMultiple = parse_attributes (attribute (cls, fields(18)))

    def parse (context: Context): TransformerObservation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TransformerObservation (
            IdentifiedObject.parse (context),
            toDouble (mask (bushingTemp (), 0)),
            mask (dga (), 1),
            mask (freqResp (), 2),
            mask (furfuralDP (), 3),
            toDouble (mask (hotSpotTemp (), 4)),
            mask (oilColor (), 5),
            toDouble (mask (oilDielectricStrength (), 6)),
            mask (oilIFT (), 7),
            mask (oilLevel (), 8),
            mask (oilNeutralizationNumber (), 9),
            mask (pumpVibration (), 10),
            mask (status (), 11),
            toDouble (mask (topOilTemp (), 12)),
            mask (waterContent (), 13),
            masks (BushingInsultationPFs (), 14),
            masks (ProcedureDataSets (), 15),
            mask (Reconditioning (), 16),
            mask (Transformer (), 17),
            masks (WindingInsulationPFs (), 18)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Underground structure.
 *
 * @param sup [[ch.ninecode.model.Structure Structure]] Reference to the superclass object.
 * @param hasVentilation True if vault is ventilating.
 * @param kind True if vault is ventilating.
 * @param material Primary material of underground structure.
 * @param sealingWarrantyExpiresDate Date sealing warranty expires.
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
<ul>
	<li>Assets can have names, through inheritance to the Naming package</li>
	<li>Assets are physical entities which have a lifecycle</li>
	<li>One or more assets can be associated to create a PowerSystemResource</li>
	<li>Assets can be grouped (aggregated) with other Assets</li>
	<li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
	<li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
</ul>
The following sections describe the packages in the Assets package.
The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
case class UndergroundStructure
(
    override val sup: Structure,
    hasVentilation: Boolean,
    kind: String,
    material: String,
    sealingWarrantyExpiresDate: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = UndergroundStructure.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (UndergroundStructure.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (UndergroundStructure.fields (position), value)
        emitelem (0, hasVentilation)
        emitattr (1, kind)
        emitelem (2, material)
        emitelem (3, sealingWarrantyExpiresDate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UndergroundStructure rdf:ID=\"%s\">\n%s\t</cim:UndergroundStructure>".format (id, export_fields)
    }
}

object UndergroundStructure
extends
    Parseable[UndergroundStructure]
{
    override val fields: Array[String] = Array[String] (
        "hasVentilation",
        "kind",
        "material",
        "sealingWarrantyExpiresDate"
    )
    val hasVentilation: Fielder = parse_element (element (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val material: Fielder = parse_element (element (cls, fields(2)))
    val sealingWarrantyExpiresDate: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): UndergroundStructure =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = UndergroundStructure (
            Structure.parse (context),
            toBoolean (mask (hasVentilation (), 0)),
            mask (kind (), 1),
            mask (material (), 2),
            mask (sealingWarrantyExpiresDate (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Winding insulation condition as a result of a test.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param insulationPFStatus Status of Winding Insulation Power Factor as of statusDate: Acceptable, Minor Deterioration or Moisture Absorption, Major Deterioration or Moisture Absorption, Failed.
 * @param insulationResistance For testType, status of Winding Insulation Resistance as of statusDate.
 *        Typical values are: Acceptable, Questionable, Failed.
 * @param leakageReactance As of statusDate, the leakage reactance measured at the "from" winding with the "to" winding short-circuited and all other windings open-circuited.
 * @param status <em>undocumented</em>
 * @param FromWinding [[ch.ninecode.model.TransformerEnd TransformerEnd]] <em>undocumented</em>
 * @param ToWinding [[ch.ninecode.model.TransformerEnd TransformerEnd]] <em>undocumented</em>
 * @param TransformerObservation [[ch.ninecode.model.TransformerObservation TransformerObservation]] <em>undocumented</em>
 * @group InfAssets
 * @groupname InfAssets Package InfAssets
 * @groupdesc InfAssets The package is used to define asset-level models for objects. Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
<ul>
	<li>Assets can have names, through inheritance to the Naming package</li>
	<li>Assets are physical entities which have a lifecycle</li>
	<li>One or more assets can be associated to create a PowerSystemResource</li>
	<li>Assets can be grouped (aggregated) with other Assets</li>
	<li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
	<li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
</ul>
The following sections describe the packages in the Assets package.
The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 */
case class WindingInsulation
(
    override val sup: IdentifiedObject,
    insulationPFStatus: String,
    insulationResistance: String,
    leakageReactance: Double,
    status: String,
    FromWinding: String,
    ToWinding: String,
    TransformerObservation: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0.0, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WindingInsulation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindingInsulation.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindingInsulation.fields (position), value)
        emitelem (0, insulationPFStatus)
        emitelem (1, insulationResistance)
        emitelem (2, leakageReactance)
        emitattr (3, status)
        emitattr (4, FromWinding)
        emitattr (5, ToWinding)
        emitattr (6, TransformerObservation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindingInsulation rdf:ID=\"%s\">\n%s\t</cim:WindingInsulation>".format (id, export_fields)
    }
}

object WindingInsulation
extends
    Parseable[WindingInsulation]
{
    override val fields: Array[String] = Array[String] (
        "insulationPFStatus",
        "insulationResistance",
        "leakageReactance",
        "status",
        "FromWinding",
        "ToWinding",
        "TransformerObservation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("FromWinding", "TransformerEnd", "1", "0..*"),
        Relationship ("ToWinding", "TransformerEnd", "1", "0..*"),
        Relationship ("TransformerObservation", "TransformerObservation", "0..1", "0..*")
    )
    val insulationPFStatus: Fielder = parse_element (element (cls, fields(0)))
    val insulationResistance: Fielder = parse_element (element (cls, fields(1)))
    val leakageReactance: Fielder = parse_element (element (cls, fields(2)))
    val status: Fielder = parse_attribute (attribute (cls, fields(3)))
    val FromWinding: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ToWinding: Fielder = parse_attribute (attribute (cls, fields(5)))
    val TransformerObservation: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): WindingInsulation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = WindingInsulation (
            IdentifiedObject.parse (context),
            mask (insulationPFStatus (), 0),
            mask (insulationResistance (), 1),
            toDouble (mask (leakageReactance (), 2)),
            mask (status (), 3),
            mask (FromWinding (), 4),
            mask (ToWinding (), 5),
            mask (TransformerObservation (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _InfAssets
{
    def register: List[ClassInfo] =
    {
        List (
            AssetPropertyCurve.register,
            BushingInsulationPF.register,
            CoolingPowerRating.register,
            DimensionsInfo.register,
            Pole.register,
            Reconditioning.register,
            ReliabilityInfo.register,
            Specification.register,
            Tower.register,
            TransformerObservation.register,
            UndergroundStructure.register,
            WindingInsulation.register
        )
    }
}