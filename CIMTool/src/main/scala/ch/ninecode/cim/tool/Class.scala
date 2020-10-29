package ch.ninecode.cim.tool

/**
 * CIM class.
 *
 * @param xuid       Unique identifier in the model.
 * @param name       The class name.
 * @param note       Textual notes attached to the class.
 * @param pkg        Containing package.
 * @param stereotype UML stereotype for the class if any, otherwise <code>null</code>.
 * @param sup        The superclass if any, otherwise <code>null</code>.
 */
case class Class (
    xuid: String,
    name: String,
    note: String,
    var pkg: Package,
    stereotype: String,
    sup: Class)
    extends
        ProgramaticName
{
    override def toString: String = s"${pkg.name}:$name${if (null != stereotype) s" ($stereotype)" else ""}${if (null != sup) s" subclass of ${sup.name}" else ""}"
}

object Class
{
    def apply (row: Row, pkg: Package): Class =
        Class(row.getXUID, kludgeName(row, pkg), row.getNote, pkg, if (row.hasStereotype) row.getStereotype else null, null)

    /**
     * Override the name of "Profile" and "ResourceCertification" to avoid case class clashes
     *
     * @param row the row of class information
     * @param pkg the package this class belongs to
     * @return normally just the name, but in conflicting cases a modified name
     *         GenericDataSet.Profile => GenericDataSet.Profile2
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
