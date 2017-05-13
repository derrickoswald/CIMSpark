package ch.ninecode.cim.CIMTool

import java.util.regex.Pattern

case class JavaDoc (note: String, leftpad: Int, members: Iterable[Member] = List())
{
    lazy val spaces = (for (i <- 0 until leftpad) yield " ").mkString ("")
    val regex = Pattern.compile ("""([\s\S^.]*?\.)\s*?(\p{Upper}.*)|([\s\S]*[\n])(.*)""")
    val (summary, body) =
        if (null == note)
            ("", "")
        else
        {
            val matcher = regex.matcher (note)
            val found = matcher.find ()
            if (found)
                ({ (if (null != matcher.group (1)) matcher.group (1) else matcher.group (3)).trim },
                 { (if (null != matcher.group (2)) matcher.group (2) else matcher.group (4)).trim })
             else
                 (note.trim, "")
        }

    def asText (): String =
    {
        if ((null != note) && (note != ""))
        {
            val s = new StringBuilder ()
            s.append ("""/**
                | * """.stripMargin)
            s.append (summary)
            if ("" != body)
            {
                s.append ("""
                    | * """.stripMargin)
                s.append (body.replace ("\n", "\n * "))
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
