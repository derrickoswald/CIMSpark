package ch.ninecode.cim.tool

import java.util.regex.Pattern

case class JavaDoc (
    note: String,
    leftpad: Int,
    members: Iterable[Member] = List(),
    group: String = null,
    group_name: String = null,
    group_description: String = null)
{
    lazy val spaces: String = (for (_ <- 0 until leftpad) yield " ").mkString ("")
    val regex: Pattern = Pattern.compile ("""([\s\S^.]*?\.)\s*?(\p{Upper}.*)|([\s\S]*[\n])(.*)""", Pattern.DOTALL)
    val (summary, body) =
        if (null != note)
        {
            val n = note.replace ("\r\n", "\n").split ("\n").map (_.trim).mkString ("\n")
            val matcher = regex.matcher (n)
            if (matcher.find ())
                ({ (if (null != matcher.group (1)) matcher.group (1) else matcher.group (3)).trim },
                 { (if (null != matcher.group (2)) matcher.group (2) else matcher.group (4)).trim })
            else
                (n.trim, "")
        }
    else
        ("", "")

    def edit (s: String): String =
    {
        // turn Fortran squared syntax into HTML
        val l1 = s.replace ("^2", "<sup>2</sup>")
        // escape dollar signs that are interpreted as macros
        val l2 = l1.replace ("$", "\\$")
        // remove leading equals signs to avoid looking like a heading
        val l3 = l2.split ('\n')
        val l4 = l3.map (l => if (l.startsWith ("=")) s"&equals;${l.substring (1)}" else l)
        l4.mkString ("\n")
    }

    def asterisks (s: String): String =
    {
        s.replace ("\n", "\n * ")
    }

    def addGroupStuff (s: StringBuilder): Unit =
    {
        if ((null != group) && ("" != group))
            s.append (s"\n * @group $group")
        if ((null != group_name) && ("" != group_name))
            s.append (s"\n * @groupname $group $group_name")
        if ((null != group_description) && ("" != group_description))
            s.append (s"\n * @groupdesc $group $group_description")
    }

    def contents: String =
    {
        val s = new StringBuilder ()
        if ((null != note) && (note != ""))
        {
            s.append (""" * """)
            s.append (asterisks (edit (summary)))
            if ("" != body)
            {
                s.append ("""
                      | *
                      | * """.stripMargin)
                s.append (asterisks (edit (body)))
            }
            s.append ("""
                        | *""".stripMargin)
            for (member <- members)
                s.append (s"\n${member.javaDoc}")
        }
        addGroupStuff (s)
        s.toString
    }

    def asText: String =
    {
        val s = contents
        if ("" != s)
        {
           s"""/**
              |$s
              | */
              |""".stripMargin.split ("\n").map (st => s"$spaces$st").mkString ("", "\n", "\n")
        }
        else
            ""
    }
}
