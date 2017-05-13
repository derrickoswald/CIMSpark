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
    def javaDoc (): String =
    {
        val jd = JavaDoc (comment, 0)
        " * @param " + variable +
        (if (jd.summary == "")
            ""
        else
            " " + 
            jd.summary +
            (if (jd.body == "")
                ""
            else
                "\n *        " +
                jd.body.replace ("\n", "\n *        ")))
    }
}