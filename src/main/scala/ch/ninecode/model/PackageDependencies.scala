package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package shows all the root level subpackage dependencies of the combined CIM model.
 */

/**
 * The version of dependencies description among top level subpackages of the combined CIM model.
 * This is not the same as the combined packages version.
 * @param sup Reference to the superclass object.
 * @param date Date of last change to the main package dependencies in format YYYY-MM-DD.
 *        This is updated when the version attribute is updated.
 * @param version The version of the main subpackages of the combined CIM model.
 *        The format is simply an integer.  The version (and date) initial values should be updated any time the dependencies in the model change and require an actual change to the diagrams within this package.
 */
case class PackageDependenciesCIMVersion
(
    override val sup: Element,
    val date: String,
    val version: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PackageDependenciesCIMVersion]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PackageDependenciesCIMVersion
extends
    Parseable[PackageDependenciesCIMVersion]
{
    val sup = BasicElement.parse _
    val date = parse_element (element ("""PackageDependenciesCIMVersion.date"""))
    val version = parse_element (element ("""PackageDependenciesCIMVersion.version"""))
    def parse (context: Context): PackageDependenciesCIMVersion =
    {
        PackageDependenciesCIMVersion(
            sup (context),
            date (context),
            version (context)
        )
    }
}

object _PackageDependencies
{
    def register: Unit =
    {
        PackageDependenciesCIMVersion.register
    }
}