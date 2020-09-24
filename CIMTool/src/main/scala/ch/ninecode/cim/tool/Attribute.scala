package ch.ninecode.cim.tool

/**
 * CIM attribute for a class.
 *
 * @param xuid       Unique identifier in the model.
 * @param name       The attribute name.
 * @param pkg        Containing package.
 * @param cls        Containing class.
 * @param notes      Textual notes attached to the attribute.
 * @param typ        The type of attribute.
 * @param classifier Domain Object class if any.
 * @param dflt       The default value for the attribute.
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
extends
    ProgramaticName
{
    lazy val attribute_name: String =
    {
        val attr = valid_class_name
        val stupid_name =
            if (attr == cls.name)
                s"${attr}_attr"
            else
                if ((cls.sup != null) && (name == cls.sup.name))
                    s"${attr}_attr"
                else
                    attr
        stupid_name
    }

    def classifierString: String = if (null != classifier) s" (${classifier.name})" else ""

    override def toString: String = s"${pkg.name}:${cls.name}.$name $typ $classifierString"
}
