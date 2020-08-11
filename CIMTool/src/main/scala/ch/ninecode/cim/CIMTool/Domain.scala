package ch.ninecode.cim.CIMTool

/**
 * CIM domain.
 *
 * @param xuid        Unique identifier in the model.
 * @param name        The domain name.
 * @param note        Textual notes attached to the domain.
 * @param stereotype  The stereotype for the domain.
 * @param pkg         The package of this domain.
 * @param enumeration The list of legal values for the domain.
 * @param value       The domain value.
 */
case class Domain (
    xuid: String,
    name: String,
    note: String,
    stereotype: String,
    pkg: Package,
    enumeration: scala.collection.immutable.Set[String],
    value: String)
