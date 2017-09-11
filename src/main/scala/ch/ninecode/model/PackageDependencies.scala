package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * The version of dependencies description among top level subpackages of the combined CIM model.
 *
 * This is not the same as the combined packages version.
 *
 * @param sup Reference to the superclass object.
 * @param date Date of last change to the main package dependencies in format YYYY-MM-DD.
 *        This is updated when the version attribute is updated.
 * @param version The version of the main subpackages of the combined CIM model.
 *        The format is simply an integer.  The version (and date) initial values should be updated any time the dependencies in the model change and require an actual change to the diagrams within this package.
 * @group PackageDependencies
 * @groupname PackageDependencies Package PackageDependencies
 * @groupdesc PackageDependencies This package shows all the root level subpackage dependencies of the combined CIM model.
 */
case class PackageDependenciesCIMVersion
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
    override def copy (): Row = { clone ().asInstanceOf[PackageDependenciesCIMVersion] }
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
        (if (null != date) "\t\t<cim:PackageDependenciesCIMVersion.date>" + date + "</cim:PackageDependenciesCIMVersion.date>\n" else "") +
        (if (null != version) "\t\t<cim:PackageDependenciesCIMVersion.version>" + version + "</cim:PackageDependenciesCIMVersion.version>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PackageDependenciesCIMVersion rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PackageDependenciesCIMVersion>"
    }
}

object PackageDependenciesCIMVersion
extends
    Parseable[PackageDependenciesCIMVersion]
{
    val date = parse_element (element ("""PackageDependenciesCIMVersion.date"""))
    val version = parse_element (element ("""PackageDependenciesCIMVersion.version"""))
    def parse (context: Context): PackageDependenciesCIMVersion =
    {
        PackageDependenciesCIMVersion(
            BasicElement.parse (context),
            date (context),
            version (context)
        )
    }
    val relations: List[Relationship] = List ()
}

private[ninecode] object _PackageDependencies
{
    def register: List[ClassInfo] =
    {
        List (
            PackageDependenciesCIMVersion.register
        )
    }
}