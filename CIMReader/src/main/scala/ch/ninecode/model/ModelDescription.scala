package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Identity contain comon descriptive information.
 *
 * @param sup         Reference to the superclass object.
 * @param description <em>undocumented</em>
 * @param name        <em>undocumented</em>
 * @param version     <em>undocumented</em>
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
    def this () =
    {
        this (null, null, null, 0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [Description]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Description.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Description.fields (position), value)

        emitelem (0, description)
        emitelem (1, name)
        emitelem (2, version)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Description rdf:ID=\"%s\">\n%s\t</cim:Description>".format (id, export_fields)
    }
}

object Description
    extends
        Parseable[Description]
{
    override val fields: Array[String] = Array [String](
        "description",
        "name",
        "version"
    )
    val description: Fielder = parse_element (element (cls, fields (0)))
    val name: Fielder = parse_element (element (cls, fields (1)))
    val version: Fielder = parse_element (element (cls, fields (2)))

    def parse (context: Context): Description =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = Description (
            BasicElement.parse (context),
            mask (description (), 0),
            mask (name (), 1),
            toInteger (mask (version (), 2))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 *
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
    def this () =
    {
        this (null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Description: Description = sup.asInstanceOf [Description]

    override def copy (): Row =
    {
        clone ().asInstanceOf [DescriptionID]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DescriptionID.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DescriptionID.fields (position), value)

        emitelem (0, uri)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DescriptionID rdf:ID=\"%s\">\n%s\t</cim:DescriptionID>".format (id, export_fields)
    }
}

object DescriptionID
    extends
        Parseable[DescriptionID]
{
    override val fields: Array[String] = Array [String](
        "uri"
    )
    val uri: Fielder = parse_element (element (cls, fields (0)))

    def parse (context: Context): DescriptionID =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = DescriptionID (
            Description.parse (context),
            mask (uri (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 *
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
    def this () =
    {
        this (null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Model: Model = sup.asInstanceOf [Model]

    override def copy (): Row =
    {
        clone ().asInstanceOf [DifferenceModel]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DifferenceModel.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DifferenceModel.fields (position), value)

        emitattr (0, forwardDifferences)
        emitattr (1, reverseDifferences)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DifferenceModel rdf:ID=\"%s\">\n%s\t</cim:DifferenceModel>".format (id, export_fields)
    }
}

object DifferenceModel
    extends
        Parseable[DifferenceModel]
{
    override val fields: Array[String] = Array [String](
        "forwardDifferences",
        "reverseDifferences"
    )
    override val relations: List[Relationship] = List (
        Relationship ("forwardDifferences", "Statements", "0..1", ""),
        Relationship ("reverseDifferences", "Statements", "0..1", "")
    )
    val forwardDifferences: Fielder = parse_attribute (attribute (cls, fields (0)))
    val reverseDifferences: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: Context): DifferenceModel =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = DifferenceModel (
            Model.parse (context),
            mask (forwardDifferences (), 0),
            mask (reverseDifferences (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 *
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
    def this () =
    {
        this (null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def FullModelDocumentElement: FullModelDocumentElement = sup.asInstanceOf [FullModelDocumentElement]

    override def copy (): Row =
    {
        clone ().asInstanceOf [FullModel]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
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
        "\t<cim:FullModel rdf:ID=\"%s\">\n%s\t</cim:FullModel>".format (id, export_fields)
    }
}

object FullModel
    extends
        Parseable[FullModel]
{

    def parse (context: Context): FullModel =
    {
        implicit val ctx: Context = context
        val ret = FullModel (
            FullModelDocumentElement.parse (context)
        )
        ret
    }
}

/**
 *
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
    def this () =
    {
        this (null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [FullModelDocumentElement]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
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
        "\t<cim:FullModelDocumentElement rdf:ID=\"%s\">\n%s\t</cim:FullModelDocumentElement>".format (id, export_fields)
    }
}

object FullModelDocumentElement
    extends
        Parseable[FullModelDocumentElement]
{

    def parse (context: Context): FullModelDocumentElement =
    {
        implicit val ctx: Context = context
        val ret = FullModelDocumentElement (
            BasicElement.parse (context)
        )
        ret
    }
}

/**
 *
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
    Depending: List[String],
    SupersededBy: List[String],
    Supersedes: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null, null, null, null, List (), List (), List (), List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [Model]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Model.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Model.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Model.fields (position), x))

        emitelem (0, created)
        emitelem (1, description)
        emitelem (2, modelingAuthoritySet)
        emitelem (3, profile)
        emitelem (4, scenarioTime)
        emitelem (5, version)
        emitattrs (6, DependentOn)
        emitattrs (7, Depending)
        emitattrs (8, SupersededBy)
        emitattrs (9, Supersedes)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Model rdf:ID=\"%s\">\n%s\t</cim:Model>".format (id, export_fields)
    }
}

object Model
    extends
        Parseable[Model]
{
    override val fields: Array[String] = Array [String](
        "created",
        "description",
        "modelingAuthoritySet",
        "profile",
        "scenarioTime",
        "version",
        "DependentOn",
        "Depending",
        "SupersededBy",
        "Supersedes"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DependentOn", "Model", "0..*", "0..*"),
        Relationship ("Depending", "Model", "0..*", "0..*"),
        Relationship ("SupersededBy", "Model", "0..*", "0..*"),
        Relationship ("Supersedes", "Model", "0..*", "0..*")
    )
    val created: Fielder = parse_element (element (cls, fields (0)))
    val description: Fielder = parse_element (element (cls, fields (1)))
    val modelingAuthoritySet: Fielder = parse_element (element (cls, fields (2)))
    val profile: Fielder = parse_element (element (cls, fields (3)))
    val scenarioTime: Fielder = parse_element (element (cls, fields (4)))
    val version: Fielder = parse_element (element (cls, fields (5)))
    val DependentOn: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val Depending: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val SupersededBy: FielderMultiple = parse_attributes (attribute (cls, fields (8)))
    val Supersedes: FielderMultiple = parse_attributes (attribute (cls, fields (9)))

    def parse (context: Context): Model =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = Model (
            BasicElement.parse (context),
            mask (created (), 0),
            mask (description (), 1),
            mask (modelingAuthoritySet (), 2),
            mask (profile (), 3),
            mask (scenarioTime (), 4),
            mask (version (), 5),
            masks (DependentOn (), 6),
            masks (Depending (), 7),
            masks (SupersededBy (), 8),
            masks (Supersedes (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 *
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
    def this () =
    {
        this (null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [ModelDescriptionCIMVersion]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ModelDescriptionCIMVersion.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ModelDescriptionCIMVersion.fields (position), value)

        emitelem (0, date)
        emitelem (1, version)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ModelDescriptionCIMVersion rdf:ID=\"%s\">\n%s\t</cim:ModelDescriptionCIMVersion>".format (id, export_fields)
    }
}

object ModelDescriptionCIMVersion
    extends
        Parseable[ModelDescriptionCIMVersion]
{
    override val fields: Array[String] = Array [String](
        "date",
        "version"
    )
    val date: Fielder = parse_element (element (cls, fields (0)))
    val version: Fielder = parse_element (element (cls, fields (1)))

    def parse (context: Context): ModelDescriptionCIMVersion =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = ModelDescriptionCIMVersion (
            BasicElement.parse (context),
            mask (date (), 0),
            mask (version (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 *
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
    def this () =
    {
        this (null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def FullModelDocumentElement: FullModelDocumentElement = sup.asInstanceOf [FullModelDocumentElement]

    override def copy (): Row =
    {
        clone ().asInstanceOf [Statements]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
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
        "\t<cim:Statements rdf:ID=\"%s\">\n%s\t</cim:Statements>".format (id, export_fields)
    }
}

object Statements
    extends
        Parseable[Statements]
{

    def parse (context: Context): Statements =
    {
        implicit val ctx: Context = context
        val ret = Statements (
            FullModelDocumentElement.parse (context)
        )
        ret
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