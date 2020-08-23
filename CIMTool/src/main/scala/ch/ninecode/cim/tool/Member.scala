package ch.ninecode.cim.tool

/**
 * CIM class member
 *
 * @param name             attribute name
 * @param variable         variable name derived from attribute name, but safe for program declaration
 * @param over             predicate for 'is an override'
 * @param comment          comment text from CIM model
 * @param reference        predicate for 'is a reference to another CIM class or domain
 * @param this_cardinality relation cardinality on "this" side, e.g. 1 in "1:n"
 * @param mate_cardinality relation cardinality on "other" side, e.g. n in "1:n"
 * @param datatype         attribute data type
 * @param initializer      initializer string
 * @param function         conversion function from String to <code>datatype</code>
 * @param referenced_class referenced CIM class if <code>reference</code> is <code>true</code>
 * @param isSuper          predicate for this member references the superclass
 */
case class Member (
    name: String,
    variable: String,
    over: Boolean,
    comment: String,
    reference: Boolean,
    this_cardinality: String,
    mate_cardinality: String,
    datatype: String,
    initializer: String,
    function: String,
    referenced_class: String,
    isSuper: Boolean = false)
{
    /**
     * Predicate for 'is this a many-to-many relation'.
     *
     * @return <code>true</code> if this is an n:m relation
     */
    def multiple: Boolean = !(this_cardinality.equals ("1") || this_cardinality.endsWith ("..1"))

    /**
     * Heuristic conversion of summary or body into Javadoc format.
     *
     * @param s the string to edit
     * @return the Javadoc string
     */
    def edit (s: String): String =
    {
        // turn Fortran squared syntax into HTML
        val l1 = s.replace ("^2", "<sup>2</sup>")
        // escape dollar signs that are interpreted as macros
        val l2 = l1.replace ("$", """\$""")
        // remove leading equals signs to avoid looking like a heading
        val l3 = l2.split ('\n')
        val l4 = l3.map (l => if (l.startsWith ("=")) s"&equals;${l.substring (1)}" else l)
        l4.mkString ("\n")
    }

    def variableAsDoc: String =
    {
        if (variable.charAt (0) == '`')
            variable.substring (1, variable.length - 1)
        else
            variable
    }

    /**
     * Generate the Javadoc string for a member.
     *
     * @return text suitable for use as a Javadoc
     */
    def javaDoc: String =
    {
        val jd = JavaDoc (comment, 0)
        val ref = if (null != referenced_class)
            s" [[ch.ninecode.model.$referenced_class $referenced_class]]"
        else
            ""
        val summary = if (jd.summary.nonEmpty)
            jd.summary.mkString ("\n *        ")
        else
            "<em>undocumented</em>"
        val body = if (jd.body.nonEmpty)
            jd.body.mkString ("\n *        ", "\n *        ", "")
        else
            ""
        s"@param $variableAsDoc$ref $summary$body"
    }
}