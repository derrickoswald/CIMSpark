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
    lazy val regex: Pattern = Pattern.compile ("""([\s\S^.]*?\.)\s*?(\p{Upper}.*)|([\s\S]*[\n])(.*)""", Pattern.DOTALL)
    lazy val (summary, body) =
        if (null != note)
        {
            val n = note.replace ("\r\n", "\n").split ("\n").map (_.trim).mkString ("\n")
            val matcher = regex.matcher (n)
            if (matcher.find ())
            {
                val h = matcher.group (1)
                val d = matcher.group (2)
                val (header, description) = if ((null == h) || (null == d))
                    (matcher.group (3), matcher.group (4))
                else
                    (h, d)
                (toList (header), toList (description))
            }
            else
                (toList (n), List ())
        }
    else
        (List (), List ())

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

    def toList (s: String): List[String] = if ("" == s) List () else edit (s).split ("\n").toList

    def groupStuff: List[String] =
    {
        def compose (prefix: String, suffix: String): Option[String] =
        {
            if ((null != group) && ("" != group) && (null != suffix))
                if ("" == suffix)
                    Some (s"$prefix $group")
                else
                    Some (s"$prefix $group $suffix")
            else
                None
        }

        val strings =
            compose ("@group", "") ::
            compose ("@groupname", group_name) ::
            compose ("@groupdesc", group_description) ::
            Nil
        strings.flatten
    }

    def asterisk (s: String): String = if ("" == s) " *" else s" * $s"

    def contents: String =
    {
        val text: List[String] = if ((null != note) && (note != ""))
        {
            val b = (if (body.nonEmpty) (List ("") :: body :: Nil).flatten else List ())
            val m = for (member <- members.toList)
                yield member.javaDoc
            (summary ::
                b ::
                List ("") ::
                m ::
                Nil).flatten
        }
        else
            List ()
        (text :: groupStuff :: Nil).flatten.map (asterisk).mkString ("\n")
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
