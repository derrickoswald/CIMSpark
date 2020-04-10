package ch.ninecode.cim.tool

/**
 * CIM package.
 *
 * @param xuid Unique identifier in the model.
 * @param name The package name.
 * @param global Flag indicating whether or not it is a global package.
 * @param notes Textual notes attached to the package.
 * @param parent The parent package if any, otherwise <code>null</code>.
 */
case class Package (
    xuid: String,
    name: String,
    global: Boolean,
    notes: String,
    parent: Package = null)
extends
    ProgramaticName
{
   override def toString: String = "%s%s%s".format (if (null != parent) s"${parent.name}:" else "", name, if (global) " global" else "")
}

object Package
{
    def apply (row: Row): Package = Package (row.getXUID, row.getName, row.getName.equals ("Model"), row.getNotes, null)
}