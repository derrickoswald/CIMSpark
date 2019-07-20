package ch.ninecode.cim.CIMTool

import java.util.regex.Pattern

case class JavaDoc (note: String, leftpad: Int, members: Iterable[Member] = List(), group: String = "", group_name: String = "", group_description: String = "")
{
    lazy val spaces: String = (for (i <- 0 until leftpad) yield " ").mkString ("")
    val regex: Pattern = Pattern.compile ("""([\s\S^.]*?\.)\s*?(\p{Upper}.*)|([\s\S]*[\n])(.*)""", Pattern.DOTALL)
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
        val l4 = l3.map (l => if (l.startsWith ("=")) "&equals;" + l.substring (1) else l)
        l4.mkString ("\n")
    }

    def asterisks (s: String): String =
    {
        s.replace ("\n", "\n * ")
    }

    def addGroupStuff (s: StringBuilder): Unit =
    {
        s.append ("""
          | * @group """.stripMargin)
        s.append (group)
        if ("" != group_name)
        {
            s.append (
                """
                    | * @groupname """.stripMargin)
            s.append (group)
            s.append (" ")
            s.append (group_name)
        }
        if ("" != group_description)
        {
            s.
            append (
            """
                | * @groupdesc """.stripMargin)
            s.append (group)
            s.append (" ")
            s.append (group_description)
        }

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
                s.append ("\n" + member.javaDoc)
        }
        if ("" != group)
            addGroupStuff (s)
        s.toString
    }

    def asText: String =
    {
        val s = contents
        if ("" != contents)
        {
            val s = new StringBuilder ()

            s.append (
                """/**
                  |""".stripMargin)
            s.append (contents)
            s.append (
                """
                  | */
                  |""".stripMargin)

            s.toString.split ("\n").map (st => spaces + st).mkString ("\n") + "\n"
        }
        else
            ""
    }
}
