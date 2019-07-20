package ch.ninecode.cim.CIMTool

/**
 * CIM class.
 *
 * @param xuid Unique identifier in the model.
 * @param name The class name.
 * @param note Textual notes attached to the class.
 * @param pkg Containing package.
 * @param stereotype UML stereotype for the class.
 */
case class Class (
    xuid: String,
    name: String,
    note: String,
    var pkg: Package,
    stereotype: String,
    sup: Class = null)
{
    def this (row: Row, pkg: Package) = this (row.getXUID, row.getName, row.getNote, pkg, if (row.hasStereotype) row.getStereotype else null, null)
    override def toString: String = pkg.name + ":" + name + (if (null != stereotype) " (" + stereotype + ")" else "") + (if (null != sup) " subclass of " + sup.name else "")
}
