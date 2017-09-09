package ch.ninecode.cim.CIMTool

/**
 * CIM domain.
 *
 * @param xuid Unique identifier in the model.
 * @param name The domain name.
 * @param note Textual notes attached to the domain.
 * @param stereotype The stereotype for the domain.
 * @param enumeration The list of legal values for the domain.
 * @param value The domain value.
 * @param unit The domain unit.
 * @param multiplier The unit multiplier.
 * @param denominatorUnit The denominator unit.
 * @param denominatorMultiplier The denominator unit multiplier.
 */
case class Domain (
    xuid: String,
    name: String,
    note: String,
    stereotype: String,
    enumeration: scala.collection.immutable.Set[String],
    value: String,
    unit: String,
    multiplier: String,
    denominatorUnit: String,
    denominatorMultiplier: String)
