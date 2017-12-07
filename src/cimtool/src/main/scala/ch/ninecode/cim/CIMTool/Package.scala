package ch.ninecode.cim.CIMTool

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
    var parent: Package = null)
{
    override def toString: String = (if (null != parent) parent.name + ":" else "") + name +  (if (global) " global" else "")
}