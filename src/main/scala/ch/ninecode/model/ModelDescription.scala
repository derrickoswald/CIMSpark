package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The package describes meta data for the exchange of power system model data.
 */

/**
 * Identity contain comon descriptive information.
 * @param sup Reference to the superclass object.
 * @param description
 * @param name
 * @param version
 */
case class Description
(override val sup: BasicElement,
val description: String,
val name: String,
val version: Int
)
extends
    Element
{
    def this () = { this (null, null, null, 0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Description]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Description
extends
    Parseable[Description]
{
    val sup = BasicElement.parse _
    val description = parse_element (element ("""Description.description"""))_
    val name = parse_element (element ("""Description.name"""))_
    val version = parse_element (element ("""Description.version"""))_
    def parse (context: Context): Description =
    {
        Description(
            sup (context),
            description (context),
            name (context),
            toInteger (version (context), context)
        )
    }
}

case class DescriptionID
(override val sup: Description,
val uri: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Description: Description = sup.asInstanceOf[Description]
    override def copy (): Row = { return (clone ().asInstanceOf[DescriptionID]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DescriptionID
extends
    Parseable[DescriptionID]
{
    val sup = Description.parse _
    val uri = parse_element (element ("""DescriptionID.uri"""))_
    def parse (context: Context): DescriptionID =
    {
        DescriptionID(
            sup (context),
            uri (context)
        )
    }
}

case class DifferenceModel
(override val sup: Model,
val forwardDifferences: String,
val reverseDifferences: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Model: Model = sup.asInstanceOf[Model]
    override def copy (): Row = { return (clone ().asInstanceOf[DifferenceModel]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DifferenceModel
extends
    Parseable[DifferenceModel]
{
    val sup = Model.parse _
    val forwardDifferences = parse_attribute (attribute ("""DifferenceModel.forwardDifferences"""))_
    val reverseDifferences = parse_attribute (attribute ("""DifferenceModel.reverseDifferences"""))_
    def parse (context: Context): DifferenceModel =
    {
        DifferenceModel(
            sup (context),
            forwardDifferences (context),
            reverseDifferences (context)
        )
    }
}

case class FullModel
(override val sup: FullModelDocumentElement
)
extends
    Element
{
    def this () = { this (null) }
    def FullModelDocumentElement: FullModelDocumentElement = sup.asInstanceOf[FullModelDocumentElement]
    override def copy (): Row = { return (clone ().asInstanceOf[FullModel]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FullModel
extends
    Parseable[FullModel]
{
    val sup = FullModelDocumentElement.parse _
    def parse (context: Context): FullModel =
    {
        FullModel(
            sup (context)
        )
    }
}

case class FullModelDocumentElement
(override val sup: BasicElement
)
extends
    Element
{
    def this () = { this (null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[FullModelDocumentElement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FullModelDocumentElement
extends
    Parseable[FullModelDocumentElement]
{
    val sup = BasicElement.parse _
    def parse (context: Context): FullModelDocumentElement =
    {
        FullModelDocumentElement(
            sup (context)
        )
    }
}

case class Model
(override val sup: BasicElement,
val created: String,
val description: String,
val modelingAuthoritySet: String,
val profile: String,
val scenarioTime: String,
val version: String,
val DependentOn: List[String],
val Supersedes: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, List(), List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Model]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Model
extends
    Parseable[Model]
{
    val sup = BasicElement.parse _
    val created = parse_element (element ("""Model.created"""))_
    val description = parse_element (element ("""Model.description"""))_
    val modelingAuthoritySet = parse_attribute (attribute ("""Model.modelingAuthoritySet"""))_
    val profile = parse_attribute (attribute ("""Model.profile"""))_
    val scenarioTime = parse_element (element ("""Model.scenarioTime"""))_
    val version = parse_element (element ("""Model.version"""))_
    val DependentOn = parse_attributes (attribute ("""Model.DependentOn"""))_
    val Supersedes = parse_attributes (attribute ("""Model.Supersedes"""))_
    def parse (context: Context): Model =
    {
        Model(
            sup (context),
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

case class ModelDescriptionCIMVersion
(override val sup: BasicElement,
val date: String,
val version: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ModelDescriptionCIMVersion]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ModelDescriptionCIMVersion
extends
    Parseable[ModelDescriptionCIMVersion]
{
    val sup = BasicElement.parse _
    val date = parse_element (element ("""ModelDescriptionCIMVersion.date"""))_
    val version = parse_element (element ("""ModelDescriptionCIMVersion.version"""))_
    def parse (context: Context): ModelDescriptionCIMVersion =
    {
        ModelDescriptionCIMVersion(
            sup (context),
            date (context),
            version (context)
        )
    }
}

case class Statements
(override val sup: FullModelDocumentElement
)
extends
    Element
{
    def this () = { this (null) }
    def FullModelDocumentElement: FullModelDocumentElement = sup.asInstanceOf[FullModelDocumentElement]
    override def copy (): Row = { return (clone ().asInstanceOf[Statements]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Statements
extends
    Parseable[Statements]
{
    val sup = FullModelDocumentElement.parse _
    def parse (context: Context): Statements =
    {
        Statements(
            sup (context)
        )
    }
}

/**
 * URI is a string following the rules defined by the W3C/IETF URI Planning Interest Group in a set of RFCs of which one is RFC 3305.
 * @param sup Reference to the superclass object.
 */
case class URI
(override val sup: BasicElement
)
extends
    Element
{
    def this () = { this (null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[URI]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object URI
extends
    Parseable[URI]
{
    val sup = BasicElement.parse _
    def parse (context: Context): URI =
    {
        URI(
            sup (context)
        )
    }
}

object _ModelDescription
{
    def register: Unit =
    {
        Description.register
        DescriptionID.register
        DifferenceModel.register
        FullModel.register
        FullModelDocumentElement.register
        Model.register
        ModelDescriptionCIMVersion.register
        Statements.register
        URI.register
    }
}