package ch.ninecode.cim.tool

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
    def this (row: Row, pkg: Package) = this (row.getXUID, Class.kludgeName (row, pkg), row.getNote, pkg, if (row.hasStereotype) row.getStereotype else null, null)
    override def toString: String = "%s:%s%s%s".format (pkg.name, name, (if (null != stereotype) s" ($stereotype)" else ""), (if (null != sup) s" subclass of ${sup.name}" else ""))
}

object Class
{
    /**
     * Override the name of "Profile" and "ResourceCerzification" to avoid case class clashes
     * @param row the row of class information
     * @param pkg the package this class belongs to
     * @return normally just the name, but in conflicting cases a modified name
     *         GenerticDataSet.Profile => GenerticDataSet.Profile2
     *         InfMarketOperations.ResourceCertification =>InfMarketOperations.ResourceCertification2
     */
    def kludgeName (row: Row, pkg: Package): String =
    {
        val name = row.getName
        pkg.name match
        {
            case "GenericDataSet" =>
                name match
                {
                    case "Profile" => "Profile2"
                    case _ => name
                }
            case "InfMarketOperations" =>
                name match
                {
                    case "ResourceCertification" => "ResourceCertification2"
                    case _ => name
                }
            case _ =>
                name
        }
    }
}
