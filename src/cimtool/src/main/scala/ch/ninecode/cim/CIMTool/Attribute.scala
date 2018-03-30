package ch.ninecode.cim.CIMTool

/**
 * CIM attribute for a class.
 *
 * @param xuid Unique identifier in the model.
 * @param name The attribute name.
 * @param pkg Containing package.
 * @param cls Containing class.
 * @param notes Textual notes attached to the attribute.
 * @param typ The type of attribute.
 * @param classifier Domain Object class if any.
 * @param dflt The default value for the attribute.
 */
case class Attribute (
    xuid: String,
    name: String,
    pkg: Package,
    cls: Class,
    notes: String,
    typ: String,
    classifier: Class,
    dflt: String)
{
    override def toString: String = pkg.name + ":" + cls.name + "." + name + " " + typ + (if (null != classifier) " (" + classifier.name + ")" else "")
}
