package ch.ninecode.cim.CIMTool


case class Member (
    name: String,
    variable: String,
    overrid: Boolean,
    comment: String,
    reference: Boolean,
    multiple: Boolean,
    datatype: String,
    initializer: String,
    function: String)
{

    def edit (s: String): String =
    {
        // turn Fortran squared syntax into HTML
        val l1 = s.replace ("^2", "<sup>2</sup>")
        // escape dollar signs that are interpreted as macros
        val l2 = l1.replace ("$", "\\$")
        // remove leading equals signs to avoid looking like a heading
        val l3 = l2.split ('\n')
        val l4 = l3.map ((l) => if (l.startsWith ("=")) "&equals;" + l.substring (1) else l)
        l4.mkString ("\n")
    }

    def asterisks (s: String): String =
    {
        s.replace ("\n", "\n *        ")
    }

    def javaDoc (): String =
    {
        val jd = JavaDoc (comment, 0)
        " * @param " + variable +
        (if (jd.summary == "")
            " <em>undocumented</em>"
        else
            " " + 
            asterisks (edit (jd.summary)) +
            (if (jd.body == "")
                ""
            else
                "\n *        " +
                asterisks (edit (jd.body))))
    }
}