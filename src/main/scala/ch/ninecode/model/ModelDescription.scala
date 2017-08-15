package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Identity contain comon descriptive information.
 *
 * @param sup Reference to the superclass object.
 * @param description <em>undocumented</em>
 * @param name <em>undocumented</em>
 * @param version <em>undocumented</em>
 * @group ModelDescription
 * @groupname ModelDescription Package ModelDescription
 * @groupdesc ModelDescription The package describes meta data for the exchange of power system model data.
 */
case class Description
(
    override val sup: BasicElement,
    description: String,
    name: String,
    version: Int
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Description] }
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
        (if (null != description) "\t\t<cim:Description.description>" + description + "</cim:Description.description>\n" else "") +
        (if (null != name) "\t\t<cim:Description.name>" + name + "</cim:Description.name>\n" else "") +
        "\t\t<cim:Description.version>" + version + "</cim:Description.version>\n"
    }
    override def export: String =
    {
        "\t<cim:Description rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Description>"
    }
}

object Description
extends
    Parseable[Description]
{
    val description = parse_element (element ("""Description.description"""))
    val name = parse_element (element ("""Description.name"""))
    val version = parse_element (element ("""Description.version"""))
    def parse (context: Context): Description =
    {
        Description(
            BasicElement.parse (context),
            description (context),
            name (context),
            toInteger (version (context), context)
        )
    }
}

/**

 * @group ModelDescription
 * @groupname ModelDescription Package ModelDescription
 * @groupdesc ModelDescription The package describes meta data for the exchange of power system model data.
 */
case class DescriptionID
(
    override val sup: Description,
    uri: String
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
    def Description: Description = sup.asInstanceOf[Description]
    override def copy (): Row = { clone ().asInstanceOf[DescriptionID] }
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
        (if (null != uri) "\t\t<cim:DescriptionID.uri>" + uri + "</cim:DescriptionID.uri>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DescriptionID rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DescriptionID>"
    }
}

object DescriptionID
extends
    Parseable[DescriptionID]
{
    val uri = parse_element (element ("""DescriptionID.uri"""))
    def parse (context: Context): DescriptionID =
    {
        DescriptionID(
            Description.parse (context),
            uri (context)
        )
    }
}

/**

 * @group ModelDescription
 * @groupname ModelDescription Package ModelDescription
 * @groupdesc ModelDescription The package describes meta data for the exchange of power system model data.
 */
case class DifferenceModel
(
    override val sup: Model,
    forwardDifferences: String,
    reverseDifferences: String
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
    def Model: Model = sup.asInstanceOf[Model]
    override def copy (): Row = { clone ().asInstanceOf[DifferenceModel] }
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
        (if (null != forwardDifferences) "\t\t<cim:DifferenceModel.forwardDifferences rdf:resource=\"#" + forwardDifferences + "\"/>\n" else "") +
        (if (null != reverseDifferences) "\t\t<cim:DifferenceModel.reverseDifferences rdf:resource=\"#" + reverseDifferences + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DifferenceModel rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DifferenceModel>"
    }
}

object DifferenceModel
extends
    Parseable[DifferenceModel]
{
    val forwardDifferences = parse_attribute (attribute ("""DifferenceModel.forwardDifferences"""))
    val reverseDifferences = parse_attribute (attribute ("""DifferenceModel.reverseDifferences"""))
    def parse (context: Context): DifferenceModel =
    {
        DifferenceModel(
            Model.parse (context),
            forwardDifferences (context),
            reverseDifferences (context)
        )
    }
}

/**

 * @group ModelDescription
 * @groupname ModelDescription Package ModelDescription
 * @groupdesc ModelDescription The package describes meta data for the exchange of power system model data.
 */
case class FullModel
(
    override val sup: FullModelDocumentElement
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
    def FullModelDocumentElement: FullModelDocumentElement = sup.asInstanceOf[FullModelDocumentElement]
    override def copy (): Row = { clone ().asInstanceOf[FullModel] }
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
        "\t<cim:FullModel rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FullModel>"
    }
}

object FullModel
extends
    Parseable[FullModel]
{
    def parse (context: Context): FullModel =
    {
        FullModel(
            FullModelDocumentElement.parse (context)
        )
    }
}

/**

 * @group ModelDescription
 * @groupname ModelDescription Package ModelDescription
 * @groupdesc ModelDescription The package describes meta data for the exchange of power system model data.
 */
case class FullModelDocumentElement
(
    override val sup: BasicElement
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FullModelDocumentElement] }
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
        "\t<cim:FullModelDocumentElement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FullModelDocumentElement>"
    }
}

object FullModelDocumentElement
extends
    Parseable[FullModelDocumentElement]
{
    def parse (context: Context): FullModelDocumentElement =
    {
        FullModelDocumentElement(
            BasicElement.parse (context)
        )
    }
}

/**

 * @group ModelDescription
 * @groupname ModelDescription Package ModelDescription
 * @groupdesc ModelDescription The package describes meta data for the exchange of power system model data.
 */
case class Model
(
    override val sup: BasicElement,
    created: String,
    description: String,
    modelingAuthoritySet: String,
    profile: String,
    scenarioTime: String,
    version: String,
    DependentOn: List[String],
    Supersedes: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Model] }
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
        (if (null != created) "\t\t<cim:Model.created>" + created + "</cim:Model.created>\n" else "") +
        (if (null != description) "\t\t<cim:Model.description>" + description + "</cim:Model.description>\n" else "") +
        (if (null != modelingAuthoritySet) "\t\t<cim:Model.modelingAuthoritySet rdf:resource=\"#" + modelingAuthoritySet + "\"/>\n" else "") +
        (if (null != profile) "\t\t<cim:Model.profile rdf:resource=\"#" + profile + "\"/>\n" else "") +
        (if (null != scenarioTime) "\t\t<cim:Model.scenarioTime>" + scenarioTime + "</cim:Model.scenarioTime>\n" else "") +
        (if (null != version) "\t\t<cim:Model.version>" + version + "</cim:Model.version>\n" else "") +
        (if (null != DependentOn) DependentOn.map (x => "\t\t<cim:Model.DependentOn rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Supersedes) Supersedes.map (x => "\t\t<cim:Model.Supersedes rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Model rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Model>"
    }
}

object Model
extends
    Parseable[Model]
{
    val created = parse_element (element ("""Model.created"""))
    val description = parse_element (element ("""Model.description"""))
    val modelingAuthoritySet = parse_attribute (attribute ("""Model.modelingAuthoritySet"""))
    val profile = parse_attribute (attribute ("""Model.profile"""))
    val scenarioTime = parse_element (element ("""Model.scenarioTime"""))
    val version = parse_element (element ("""Model.version"""))
    val DependentOn = parse_attributes (attribute ("""Model.DependentOn"""))
    val Supersedes = parse_attributes (attribute ("""Model.Supersedes"""))
    def parse (context: Context): Model =
    {
        Model(
            BasicElement.parse (context),
            created (context),
            description (context),
            modelingAuthoritySet (context),
            profile (context),
            scenarioTime (context),
            version (context),
            DependentOn (context),
            Supersedes (context)
        )
    }
}

/**

 * @group ModelDescription
 * @groupname ModelDescription Package ModelDescription
 * @groupdesc ModelDescription The package describes meta data for the exchange of power system model data.
 */
case class ModelDescriptionCIMVersion
(
    override val sup: BasicElement,
    date: String,
    version: String
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ModelDescriptionCIMVersion] }
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
        (if (null != date) "\t\t<cim:ModelDescriptionCIMVersion.date>" + date + "</cim:ModelDescriptionCIMVersion.date>\n" else "") +
        (if (null != version) "\t\t<cim:ModelDescriptionCIMVersion.version>" + version + "</cim:ModelDescriptionCIMVersion.version>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ModelDescriptionCIMVersion rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ModelDescriptionCIMVersion>"
    }
}

object ModelDescriptionCIMVersion
extends
    Parseable[ModelDescriptionCIMVersion]
{
    val date = parse_element (element ("""ModelDescriptionCIMVersion.date"""))
    val version = parse_element (element ("""ModelDescriptionCIMVersion.version"""))
    def parse (context: Context): ModelDescriptionCIMVersion =
    {
        ModelDescriptionCIMVersion(
            BasicElement.parse (context),
            date (context),
            version (context)
        )
    }
}

/**

 * @group ModelDescription
 * @groupname ModelDescription Package ModelDescription
 * @groupdesc ModelDescription The package describes meta data for the exchange of power system model data.
 */
case class Statements
(
    override val sup: FullModelDocumentElement
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
    def FullModelDocumentElement: FullModelDocumentElement = sup.asInstanceOf[FullModelDocumentElement]
    override def copy (): Row = { clone ().asInstanceOf[Statements] }
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
        "\t<cim:Statements rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Statements>"
    }
}

object Statements
extends
    Parseable[Statements]
{
    def parse (context: Context): Statements =
    {
        Statements(
            FullModelDocumentElement.parse (context)
        )
    }
}

private[ninecode] object _ModelDescription
{
    def register: List[ClassInfo] =
    {
        List (
            Description.register,
            DescriptionID.register,
            DifferenceModel.register,
            FullModel.register,
            FullModelDocumentElement.register,
            Model.register,
            ModelDescriptionCIMVersion.register,
            Statements.register
        )
    }
}