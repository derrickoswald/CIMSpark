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
    Specification: String
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
        emitattr (0, Specification)
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
    val fields: Array[String] = Array[String] (
        "Specification"
    )
    val Specification: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): AssetPropertyCurve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AssetPropertyCurve (
            Curve.parse (context),
            mask (Specification (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Specification", "Specification", false)
    )
}

/**
 * Bushing asset.
 *
 * @param sup [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param c1Capacitance Factory measured capacitance, measured between the power factor tap and the bushing conductor.
 * @param c1PowerFactor Factory measured insulation power factor, measured between the power factor tap and the bushing conductor.
 * @param c2Capacitance Factory measured capacitance measured between the power factor tap and ground.
 * @param c2PowerFactor Factory measured insulation power factor, measured between the power factor tap and ground.
 * @param insulationKind Kind of insulation.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] <em>undocumented</em>
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
case class Bushing
(
    override val sup: Asset,
    c1Capacitance: Double,
    c1PowerFactor: Double,
    c2Capacitance: Double,
    c2PowerFactor: Double,
    insulationKind: String,
    Terminal: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Bushing.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Bushing.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Bushing.fields (position), value)
        emitelem (0, c1Capacitance)
        emitelem (1, c1PowerFactor)
        emitelem (2, c2Capacitance)
        emitelem (3, c2PowerFactor)
        emitattr (4, insulationKind)
        emitattr (5, Terminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Bushing rdf:ID=\"%s\">\n%s\t</cim:Bushing>".format (id, export_fields)
    }
}

object Bushing
extends
    Parseable[Bushing]
{
    val fields: Array[String] = Array[String] (
        "c1Capacitance",
        "c1PowerFactor",
        "c2Capacitance",
        "c2PowerFactor",
        "insulationKind",
        "Terminal"
    )
    val c1Capacitance: Fielder = parse_element (element (cls, fields(0)))
    val c1PowerFactor: Fielder = parse_element (element (cls, fields(1)))
    val c2Capacitance: Fielder = parse_element (element (cls, fields(2)))
    val c2PowerFactor: Fielder = parse_element (element (cls, fields(3)))
    val insulationKind: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): Bushing =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Bushing (
            Asset.parse (context),
            toDouble (mask (c1Capacitance (), 0)),
            toDouble (mask (c1PowerFactor (), 1)),
            toDouble (mask (c2Capacitance (), 2)),
            toDouble (mask (c2PowerFactor (), 3)),
            mask (insulationKind (), 4),
            mask (Terminal (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Terminal", "Terminal", false)
    )
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
    val fields: Array[String] = Array[String] (
        "status",
        "testKind",
        "Bushing",
        "TransformerObservation"
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
    val relations: List[Relationship] = List (
        Relationship ("Bushing", "Bushing", false),
        Relationship ("TransformerObservation", "TransformerObservation", false)
    )
}

/**
 * Enclosure that offers protection to the equipment it contains and/or safety to people/animals outside it.
 *
 * @param sup [[ch.ninecode.model.AssetContainer AssetContainer]] Reference to the superclass object.
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
case class Cabinet
(
    override val sup: AssetContainer
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Cabinet rdf:ID=\"%s\">\n%s\t</cim:Cabinet>".format (id, export_fields)
    }
}

object Cabinet
extends
    Parseable[Cabinet]
{

    def parse (context: Context): Cabinet =
    {
        implicit val ctx: Context = context
        val ret = Cabinet (
            AssetContainer.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (CoolingPowerRating.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "coolingKind",
        "powerRating",
        "stage",
        "Reconditionings"
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
    val relations: List[Relationship] = List (
        Relationship ("Reconditionings", "Reconditioning", true)
    )
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (DimensionsInfo.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "orientation",
        "sizeDepth",
        "sizeDiameter",
        "sizeLength",
        "sizeWidth",
        "Specifications"
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
    val relations: List[Relationship] = List (
        Relationship ("Specifications", "Specification", true)
    )
}

/**
 * A duct contains individual wires in the layout as specified with associated wire spacing instances; number of them gives the number of conductors in this duct.
 *
 * @param sup [[ch.ninecode.model.AssetContainer AssetContainer]] Reference to the superclass object.
 * @param circuitCount Number of circuits in duct bank.
 *        Refer to associations between a duct (ConductorAsset) and an ACLineSegment to understand which circuits are in which ducts.
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
case class DuctBank
(
    override val sup: AssetContainer,
    circuitCount: Int
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DuctBank.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DuctBank.fields (position), value)
        emitelem (0, circuitCount)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DuctBank rdf:ID=\"%s\">\n%s\t</cim:DuctBank>".format (id, export_fields)
    }
}

object DuctBank
extends
    Parseable[DuctBank]
{
    val fields: Array[String] = Array[String] (
        "circuitCount"
    )
    val circuitCount: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): DuctBank =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DuctBank (
            AssetContainer.parse (context),
            toInteger (mask (circuitCount (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * FACTS device asset.
 *
 * @param sup [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param kind Kind of FACTS device.
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
case class FACTSDevice
(
    override val sup: Asset,
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FACTSDevice.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FACTSDevice.fields (position), value)
        emitattr (0, kind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FACTSDevice rdf:ID=\"%s\">\n%s\t</cim:FACTSDevice>".format (id, export_fields)
    }
}

object FACTSDevice
extends
    Parseable[FACTSDevice]
{
    val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): FACTSDevice =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FACTSDevice (
            Asset.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A facility may contain buildings, storage facilities, switching facilities, power generation, manufacturing facilities, maintenance facilities, etc.
 *
 * @param sup [[ch.ninecode.model.AssetContainer AssetContainer]] Reference to the superclass object.
 * @param kind Kind of this facility.
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
case class Facility
(
    override val sup: AssetContainer,
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Facility.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Facility.fields (position), value)
        emitelem (0, kind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Facility rdf:ID=\"%s\">\n%s\t</cim:Facility>".format (id, export_fields)
    }
}

object Facility
extends
    Parseable[Facility]
{
    val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): Facility =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Facility (
            AssetContainer.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * An event where an asset has failed to perform its functions within specified parameters.
 *
 * @param sup [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param corporateCode Code for asset failure.
 * @param failureIsolationMethod How the asset failure was isolated from the system.
 * @param faultLocatingMethod The method used for locating the faulted part of the asset.
 *        For example, cable options include: Cap Discharge-Thumping, Bridge Method, Visual Inspection, Other.
 * @param location Failure location on an object.
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
case class FailureEvent
(
    override val sup: ActivityRecord,
    corporateCode: String,
    failureIsolationMethod: String,
    faultLocatingMethod: String,
    location: String
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FailureEvent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FailureEvent.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FailureEvent.fields (position), value)
        emitelem (0, corporateCode)
        emitattr (1, failureIsolationMethod)
        emitelem (2, faultLocatingMethod)
        emitelem (3, location)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FailureEvent rdf:ID=\"%s\">\n%s\t</cim:FailureEvent>".format (id, export_fields)
    }
}

object FailureEvent
extends
    Parseable[FailureEvent]
{
    val fields: Array[String] = Array[String] (
        "corporateCode",
        "failureIsolationMethod",
        "faultLocatingMethod",
        "location"
    )
    val corporateCode: Fielder = parse_element (element (cls, fields(0)))
    val failureIsolationMethod: Fielder = parse_attribute (attribute (cls, fields(1)))
    val faultLocatingMethod: Fielder = parse_element (element (cls, fields(2)))
    val location: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): FailureEvent =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FailureEvent (
            ActivityRecord.parse (context),
            mask (corporateCode (), 0),
            mask (failureIsolationMethod (), 1),
            mask (faultLocatingMethod (), 2),
            mask (location (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Various current financial properties associated with a particular asset.
 *
 * Historical properties may be determined by ActivityRecords associated with the asset.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
 * @param Asset [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
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
case class FinancialInfo
(
    override val sup: IdentifiedObject,
    account: String,
    actualPurchaseCost: Double,
    costDescription: String,
    costType: String,
    financialValue: Double,
    plantTransferDateTime: String,
    purchaseDateTime: String,
    purchaseOrderNumber: String,
    quantity: String,
    valueDateTime: String,
    warrantyEndDateTime: String,
    Asset: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null, 0.0, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FinancialInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FinancialInfo.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FinancialInfo.fields (position), value)
        emitelem (0, account)
        emitelem (1, actualPurchaseCost)
        emitelem (2, costDescription)
        emitelem (3, costType)
        emitelem (4, financialValue)
        emitelem (5, plantTransferDateTime)
        emitelem (6, purchaseDateTime)
        emitelem (7, purchaseOrderNumber)
        emitattr (8, quantity)
        emitelem (9, valueDateTime)
        emitelem (10, warrantyEndDateTime)
        emitattr (11, Asset)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FinancialInfo rdf:ID=\"%s\">\n%s\t</cim:FinancialInfo>".format (id, export_fields)
    }
}

object FinancialInfo
extends
    Parseable[FinancialInfo]
{
    val fields: Array[String] = Array[String] (
        "account",
        "actualPurchaseCost",
        "costDescription",
        "costType",
        "financialValue",
        "plantTransferDateTime",
        "purchaseDateTime",
        "purchaseOrderNumber",
        "quantity",
        "valueDateTime",
        "warrantyEndDateTime",
        "Asset"
    )
    val account: Fielder = parse_element (element (cls, fields(0)))
    val actualPurchaseCost: Fielder = parse_element (element (cls, fields(1)))
    val costDescription: Fielder = parse_element (element (cls, fields(2)))
    val costType: Fielder = parse_element (element (cls, fields(3)))
    val financialValue: Fielder = parse_element (element (cls, fields(4)))
    val plantTransferDateTime: Fielder = parse_element (element (cls, fields(5)))
    val purchaseDateTime: Fielder = parse_element (element (cls, fields(6)))
    val purchaseOrderNumber: Fielder = parse_element (element (cls, fields(7)))
    val quantity: Fielder = parse_attribute (attribute (cls, fields(8)))
    val valueDateTime: Fielder = parse_element (element (cls, fields(9)))
    val warrantyEndDateTime: Fielder = parse_element (element (cls, fields(10)))
    val Asset: Fielder = parse_attribute (attribute (cls, fields(11)))

    def parse (context: Context): FinancialInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FinancialInfo (
            IdentifiedObject.parse (context),
            mask (account (), 0),
            toDouble (mask (actualPurchaseCost (), 1)),
            mask (costDescription (), 2),
            mask (costType (), 3),
            toDouble (mask (financialValue (), 4)),
            mask (plantTransferDateTime (), 5),
            mask (purchaseDateTime (), 6),
            mask (purchaseOrderNumber (), 7),
            mask (quantity (), 8),
            mask (valueDateTime (), 9),
            mask (warrantyEndDateTime (), 10),
            mask (Asset (), 11)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Asset", "Asset", false)
    )
}

/**
 * Generic asset or material item that may be used for planning, work or design purposes.
 *
 * @param sup [[ch.ninecode.model.AssetModel AssetModel]] Reference to the superclass object.
 * @param estimatedUnitCost Estimated unit cost (or cost per unit length) of this type of asset.
 *        It does not include labor to install/construct or configure it.
 * @param quantity The value, unit of measure, and multiplier for the quantity.
 * @param stockItem True if item is a stock item (default).
 * @param CUAsset [[ch.ninecode.model.CUAsset CUAsset]] <em>undocumented</em>
 * @param CUWorkEquipmentAsset [[ch.ninecode.model.CUWorkEquipmentItem CUWorkEquipmentItem]] <em>undocumented</em>
 * @param TypeAssetCatalogue [[ch.ninecode.model.TypeAssetCatalogue TypeAssetCatalogue]] <em>undocumented</em>
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
case class GenericAssetModelOrMaterial
(
    override val sup: AssetModel,
    estimatedUnitCost: Double,
    quantity: String,
    stockItem: Boolean,
    CUAsset: String,
    CUWorkEquipmentAsset: String,
    TypeAssetCatalogue: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, false, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GenericAssetModelOrMaterial.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GenericAssetModelOrMaterial.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GenericAssetModelOrMaterial.fields (position), value)
        emitelem (0, estimatedUnitCost)
        emitattr (1, quantity)
        emitelem (2, stockItem)
        emitattr (3, CUAsset)
        emitattr (4, CUWorkEquipmentAsset)
        emitattr (5, TypeAssetCatalogue)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GenericAssetModelOrMaterial rdf:ID=\"%s\">\n%s\t</cim:GenericAssetModelOrMaterial>".format (id, export_fields)
    }
}

object GenericAssetModelOrMaterial
extends
    Parseable[GenericAssetModelOrMaterial]
{
    val fields: Array[String] = Array[String] (
        "estimatedUnitCost",
        "quantity",
        "stockItem",
        "CUAsset",
        "CUWorkEquipmentAsset",
        "TypeAssetCatalogue"
    )
    val estimatedUnitCost: Fielder = parse_element (element (cls, fields(0)))
    val quantity: Fielder = parse_attribute (attribute (cls, fields(1)))
    val stockItem: Fielder = parse_element (element (cls, fields(2)))
    val CUAsset: Fielder = parse_attribute (attribute (cls, fields(3)))
    val CUWorkEquipmentAsset: Fielder = parse_attribute (attribute (cls, fields(4)))
    val TypeAssetCatalogue: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): GenericAssetModelOrMaterial =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = GenericAssetModelOrMaterial (
            AssetModel.parse (context),
            toDouble (mask (estimatedUnitCost (), 0)),
            mask (quantity (), 1),
            toBoolean (mask (stockItem (), 2)),
            mask (CUAsset (), 3),
            mask (CUWorkEquipmentAsset (), 4),
            mask (TypeAssetCatalogue (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("CUAsset", "CUAsset", false),
        Relationship ("CUWorkEquipmentAsset", "CUWorkEquipmentItem", false),
        Relationship ("TypeAssetCatalogue", "TypeAssetCatalogue", false)
    )
}

/**
 * Joint connects two or more cables.
 *
 * It includes the portion of cable under wipes, welds, or other seals.
 *
 * @param sup [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param configurationKind Configuration of joint.
 * @param fillKind Material used to fill the joint.
 * @param insulation The type of insulation around the joint, classified according to the utility's asset management standards and practices.
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
case class Joint
(
    override val sup: Asset,
    configurationKind: String,
    fillKind: String,
    insulation: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Joint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Joint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Joint.fields (position), value)
        emitattr (0, configurationKind)
        emitattr (1, fillKind)
        emitelem (2, insulation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Joint rdf:ID=\"%s\">\n%s\t</cim:Joint>".format (id, export_fields)
    }
}

object Joint
extends
    Parseable[Joint]
{
    val fields: Array[String] = Array[String] (
        "configurationKind",
        "fillKind",
        "insulation"
    )
    val configurationKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val fillKind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val insulation: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): Joint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Joint (
            Asset.parse (context),
            mask (configurationKind (), 0),
            mask (fillKind (), 1),
            mask (insulation (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A substance that either (1) provides the means of transmission of a force or effect, such as hydraulic fluid, or (2) is used for a surrounding or enveloping substance, such as oil in a transformer or circuit breaker.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param kind Kind of this medium.
 * @param volumeSpec The volume of the medium specified for this application.
 *        Note that the actual volume is a type of measurement associated witht the asset.
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
case class Medium
(
    override val sup: IdentifiedObject,
    kind: String,
    volumeSpec: Double,
    Assets: List[String],
    Specification: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Medium.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Medium.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Medium.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Medium.fields (position), x))
        emitattr (0, kind)
        emitelem (1, volumeSpec)
        emitattrs (2, Assets)
        emitattr (3, Specification)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Medium rdf:ID=\"%s\">\n%s\t</cim:Medium>".format (id, export_fields)
    }
}

object Medium
extends
    Parseable[Medium]
{
    val fields: Array[String] = Array[String] (
        "kind",
        "volumeSpec",
        "Assets",
        "Specification"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val volumeSpec: Fielder = parse_element (element (cls, fields(1)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Specification: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): Medium =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Medium (
            IdentifiedObject.parse (context),
            mask (kind (), 0),
            toDouble (mask (volumeSpec (), 1)),
            masks (Assets (), 2),
            mask (Specification (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Assets", "Asset", true),
        Relationship ("Specification", "Specification", false)
    )
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
 * @param len Length of the pole (inclusive of any section of the pole that may be underground post-installation).
 * @param preservativeKind Kind of preservative for this pole.
 * @param speciesType Pole species.
 *        Aluminum, Aluminum Davit, Concrete, Fiberglass, Galvanized Davit, Galvanized, Steel Davit Primed, Steel Davit, Steel Standard Primed, Steel, Truncated, Wood-Treated, Wood-Hard, Wood-Salt Treated, Wood-Soft, Wood, Other, Unknown.
 * @param treatedDateTime Date and time pole was last treated with preservative.
 * @param treatmentKind Kind of treatment for this pole.
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
    treatmentKind: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, false, null, null, 0.0, null, 0.0, null, null, null, null) }
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
    val fields: Array[String] = Array[String] (
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
        "treatmentKind"
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
            mask (treatmentKind (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Reconditioning information for an asset.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dateTime Date and time this reconditioning (or a major overhaul) has been performed.
 * @param Asset [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
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
    Asset: String
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
        emitelem (0, dateTime)
        emitattr (1, Asset)
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
    val fields: Array[String] = Array[String] (
        "dateTime",
        "Asset"
    )
    val dateTime: Fielder = parse_element (element (cls, fields(0)))
    val Asset: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): Reconditioning =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Reconditioning (
            IdentifiedObject.parse (context),
            mask (dateTime (), 0),
            mask (Asset (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Asset", "Asset", false)
    )
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ReliabilityInfo.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "mTTR",
        "momFailureRate",
        "Assets",
        "Specification"
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
    val relations: List[Relationship] = List (
        Relationship ("Assets", "Asset", true),
        Relationship ("Specification", "Specification", false)
    )
}

/**
 * Specification can be used for various purposes relative to an asset, a logical device (PowerSystemResource), location, etc.
 *
 * Examples include documents supplied by manufacturers such as asset installation instructions, asset maintenance instructions, etc.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
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
    override val sup: Document
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
        sup.export_fields
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

    def parse (context: Context): Specification =
    {
        implicit val ctx: Context = context
        val ret = Specification (
            Document.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Streetlight asset.
 *
 * @param sup [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param armLength Length of arm.
 *        Note that a new light may be placed on an existing arm.
 * @param lampKind Lamp kind.
 * @param lightRating Power rating of light.
 * @param Pole [[ch.ninecode.model.Pole Pole]] Pole to which thiss streetlight is attached.
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
case class Streetlight
(
    override val sup: Asset,
    armLength: Double,
    lampKind: String,
    lightRating: Double,
    Pole: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Streetlight.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Streetlight.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Streetlight.fields (position), value)
        emitelem (0, armLength)
        emitattr (1, lampKind)
        emitelem (2, lightRating)
        emitattr (3, Pole)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Streetlight rdf:ID=\"%s\">\n%s\t</cim:Streetlight>".format (id, export_fields)
    }
}

object Streetlight
extends
    Parseable[Streetlight]
{
    val fields: Array[String] = Array[String] (
        "armLength",
        "lampKind",
        "lightRating",
        "Pole"
    )
    val armLength: Fielder = parse_element (element (cls, fields(0)))
    val lampKind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val lightRating: Fielder = parse_element (element (cls, fields(2)))
    val Pole: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): Streetlight =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Streetlight (
            Asset.parse (context),
            toDouble (mask (armLength (), 0)),
            mask (lampKind (), 1),
            toDouble (mask (lightRating (), 2)),
            mask (Pole (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Pole", "Pole", false)
    )
}

/**
 * Construction holding assets such as conductors, transformers, switchgear, etc.
 *
 * Where applicable, number of conductors can be derived from the number of associated wire spacing instances.
 *
 * @param sup [[ch.ninecode.model.AssetContainer AssetContainer]] Reference to the superclass object.
 * @param fumigantAppliedDate Date fumigant was last applied.
 * @param fumigantName Name of fumigant.
 * @param height Visible height of structure above ground level for overhead construction (e.g., Pole or Tower) or below ground level for an underground vault, manhole, etc.
 *        Refer to associated DimensionPropertiesInfo for other types of dimensions.
 * @param materialKind Material this structure is made of.
 * @param ratedVoltage Maximum rated voltage of the equipment that can be mounted on/contained within the structure.
 * @param removeWeed True if weeds are to be removed around asset.
 * @param weedRemovedDate Date weed were last removed.
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
case class Structure
(
    override val sup: AssetContainer,
    fumigantAppliedDate: String,
    fumigantName: String,
    height: Double,
    materialKind: String,
    ratedVoltage: Double,
    removeWeed: Boolean,
    weedRemovedDate: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0.0, null, 0.0, false, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Structure.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Structure.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Structure.fields (position), value)
        emitelem (0, fumigantAppliedDate)
        emitelem (1, fumigantName)
        emitelem (2, height)
        emitattr (3, materialKind)
        emitelem (4, ratedVoltage)
        emitelem (5, removeWeed)
        emitelem (6, weedRemovedDate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Structure rdf:ID=\"%s\">\n%s\t</cim:Structure>".format (id, export_fields)
    }
}

object Structure
extends
    Parseable[Structure]
{
    val fields: Array[String] = Array[String] (
        "fumigantAppliedDate",
        "fumigantName",
        "height",
        "materialKind",
        "ratedVoltage",
        "removeWeed",
        "weedRemovedDate"
    )
    val fumigantAppliedDate: Fielder = parse_element (element (cls, fields(0)))
    val fumigantName: Fielder = parse_element (element (cls, fields(1)))
    val height: Fielder = parse_element (element (cls, fields(2)))
    val materialKind: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ratedVoltage: Fielder = parse_element (element (cls, fields(4)))
    val removeWeed: Fielder = parse_element (element (cls, fields(5)))
    val weedRemovedDate: Fielder = parse_element (element (cls, fields(6)))

    def parse (context: Context): Structure =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Structure (
            AssetContainer.parse (context),
            mask (fumigantAppliedDate (), 0),
            mask (fumigantName (), 1),
            toDouble (mask (height (), 2)),
            mask (materialKind (), 3),
            toDouble (mask (ratedVoltage (), 4)),
            toBoolean (mask (removeWeed (), 5)),
            mask (weedRemovedDate (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Support for structure assets.
 *
 * @param sup [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param anchorKind (if anchor) Kind of anchor.
 * @param anchorRodCount (if anchor) Number of rods used.
 * @param anchorRodLength (if anchor) Length of rod used.
 * @param direction Direction of this support structure.
 * @param kind Kind of structure support.
 * @param len Length of this support structure.
 * @param size1 Size of this support structure.
 * @param SecuredStructure [[ch.ninecode.model.Structure Structure]] <em>undocumented</em>
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
case class StructureSupport
(
    override val sup: Asset,
    anchorKind: String,
    anchorRodCount: Int,
    anchorRodLength: Double,
    direction: Double,
    kind: String,
    len: Double,
    size1: String,
    SecuredStructure: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0, 0.0, 0.0, null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = StructureSupport.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (StructureSupport.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StructureSupport.fields (position), value)
        emitattr (0, anchorKind)
        emitelem (1, anchorRodCount)
        emitelem (2, anchorRodLength)
        emitelem (3, direction)
        emitattr (4, kind)
        emitelem (5, len)
        emitelem (6, size1)
        emitattr (7, SecuredStructure)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StructureSupport rdf:ID=\"%s\">\n%s\t</cim:StructureSupport>".format (id, export_fields)
    }
}

object StructureSupport
extends
    Parseable[StructureSupport]
{
    val fields: Array[String] = Array[String] (
        "anchorKind",
        "anchorRodCount",
        "anchorRodLength",
        "direction",
        "kind",
        "length",
        "size",
        "SecuredStructure"
    )
    val anchorKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val anchorRodCount: Fielder = parse_element (element (cls, fields(1)))
    val anchorRodLength: Fielder = parse_element (element (cls, fields(2)))
    val direction: Fielder = parse_element (element (cls, fields(3)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(4)))
    val len: Fielder = parse_element (element (cls, fields(5)))
    val size1: Fielder = parse_element (element (cls, fields(6)))
    val SecuredStructure: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): StructureSupport =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = StructureSupport (
            Asset.parse (context),
            mask (anchorKind (), 0),
            toInteger (mask (anchorRodCount (), 1)),
            toDouble (mask (anchorRodLength (), 2)),
            toDouble (mask (direction (), 3)),
            mask (kind (), 4),
            toDouble (mask (len (), 5)),
            mask (size1 (), 6),
            mask (SecuredStructure (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("SecuredStructure", "Structure", false)
    )
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
    val fields: Array[String] = Array[String] (
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
    val relations: List[Relationship] = List (

    )
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
 * @param Reconditioning [[ch.ninecode.model.Reconditioning Reconditioning]] <em>undocumented</em>
 * @param Transformer [[ch.ninecode.model.TransformerTank TransformerTank]] <em>undocumented</em>
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
    Reconditioning: String,
    Transformer: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null, 0.0, null, 0.0, null, null, null, null, null, 0.0, null, null, null) }
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
        emitattr (14, Reconditioning)
        emitattr (15, Transformer)
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
    val fields: Array[String] = Array[String] (
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
        "Reconditioning",
        "Transformer"
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
    val Reconditioning: Fielder = parse_attribute (attribute (cls, fields(14)))
    val Transformer: Fielder = parse_attribute (attribute (cls, fields(15)))

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
            mask (Reconditioning (), 14),
            mask (Transformer (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Reconditioning", "Reconditioning", false),
        Relationship ("Transformer", "TransformerTank", false)
    )
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
    val fields: Array[String] = Array[String] (
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
    val relations: List[Relationship] = List (

    )
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
    val fields: Array[String] = Array[String] (
        "insulationPFStatus",
        "insulationResistance",
        "leakageReactance",
        "status",
        "FromWinding",
        "ToWinding",
        "TransformerObservation"
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
    val relations: List[Relationship] = List (
        Relationship ("FromWinding", "TransformerEnd", false),
        Relationship ("ToWinding", "TransformerEnd", false),
        Relationship ("TransformerObservation", "TransformerObservation", false)
    )
}

private[ninecode] object _InfAssets
{
    def register: List[ClassInfo] =
    {
        List (
            AssetPropertyCurve.register,
            Bushing.register,
            BushingInsulationPF.register,
            Cabinet.register,
            CoolingPowerRating.register,
            DimensionsInfo.register,
            DuctBank.register,
            FACTSDevice.register,
            Facility.register,
            FailureEvent.register,
            FinancialInfo.register,
            GenericAssetModelOrMaterial.register,
            Joint.register,
            Medium.register,
            Pole.register,
            Reconditioning.register,
            ReliabilityInfo.register,
            Specification.register,
            Streetlight.register,
            Structure.register,
            StructureSupport.register,
            Tower.register,
            TransformerObservation.register,
            UndergroundStructure.register,
            WindingInsulation.register
        )
    }
}