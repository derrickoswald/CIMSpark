package ch.ninecode.cim.CIMTool

/**
 * CIM relationship role.
 *
 * @param xuid Unique identifier in the model.
 * @param name The attribute name.
 * @param src Source class.
 * @param dst Destination class.
 * @param note Textual notes attached to the relationship.
 * @param card Cardinality of the relationship.
 * @param aggregate TBD.
 * @param sideA TBD.
 * @param mate Corresponding relationship end on the other class.
 */
case class Role (
    xuid: String,
    name: String,
    src: Class,
    dst: Class,
    note: String,
    card: String,
    aggregate: Boolean,
    sideA: Boolean,
    var mate: Role = null)
{
    lazy val upper: Int = if (card.equals ("1") || card.endsWith ("..1")) 1 else 0
    lazy val lower: Int = if (card.equals ("*") || card.startsWith ("0..")) 0 else 1
    lazy val many_to_many: Boolean = ((card == "0..*") || (card == "1..*")) && ((mate.card == "0..*") || (mate.card == "1..*"))
    def for_class (cls: Class): Boolean = src == cls
    override def hashCode: Int = xuid.hashCode
    override def toString: String = "" + name + " from " + src.name + " to " + dst.name
}
