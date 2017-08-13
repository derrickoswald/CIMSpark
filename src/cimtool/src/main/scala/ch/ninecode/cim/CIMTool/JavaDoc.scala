package ch.ninecode.cim.CIMTool

import java.util.regex.Pattern

case class JavaDoc (note: String, leftpad: Int, members: Iterable[Member] = List())
{
    lazy val spaces: String = (for (i <- 0 until leftpad) yield " ").mkString ("")
    val regex: Pattern = Pattern.compile ("""([\s\S^.]*?\.)\s*?(\p{Upper}.*)|([\s\S]*[\n])(.*)""")
    val (summary, body) =
        if (null == note)
            ("", "")
        else
        {
            val n = note.replace ("\r\n", "\n").split ("\n").map (_.trim).mkString ("\n")
            val matcher = regex.matcher (n)
            val found = matcher.find ()
            if (found)
                ({ (if (null != matcher.group (1)) matcher.group (1) else matcher.group (3)).trim },
                 { (if (null != matcher.group (2)) matcher.group (2) else matcher.group (4)).trim })
            else
                (n.trim, "")
        }

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
        s.replace ("\n", "\n * ")
    }

    def asText (): String =
    {
        if ((null != note) && (note != ""))
        {
            val s = new StringBuilder ()
            s.append ("""/**
                | * """.stripMargin)
            s.append (asterisks (edit (summary)))
            if ("" != body)
            {
                s.append ("""
                    | * """.stripMargin)
                s.append (asterisks (edit (body)))
            }
            for (member <- members)
                s.append ("\n" + member.javaDoc)
            s.append ("""
                | */
                |""".stripMargin)

            s.toString.split ("\n").map (st => spaces + st).mkString ("\n") + "\n"
        }
        else
            ""
    }
}
