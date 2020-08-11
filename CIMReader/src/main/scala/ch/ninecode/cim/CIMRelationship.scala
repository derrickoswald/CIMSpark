package ch.ninecode.cim

/**
 * Relation description between CIM classes.
 *
 * @param field            the name of the field in this CIM class holding the reference to the other class
 * @param clazz            the class name of the other class
 * @param this_cardinality the cardinality of this side of the relation
 * @param mate_cardinality the cardinality on the other side of the relation
 */
case class CIMRelationship (
    field: String,
    clazz: String,
    this_cardinality: String,
    mate_cardinality: String)
{
    /**
     * Predicate that indicates this side of the relation can be more that one object.
     *
     * @return <code>true</code> if this relation is many:something
     */
    def multiple: Boolean = !(this_cardinality.equals ("1") || this_cardinality.endsWith ("..1"))

    /**
     * Predicate that indicates this side of the relation can be more that one object and the other side is one (1).
     *
     * @return <code>true</code> if this relation is many:1
     */
    def heavyside: Boolean = multiple && (mate_cardinality.equals ("1") || mate_cardinality.endsWith ("..1"))
}

