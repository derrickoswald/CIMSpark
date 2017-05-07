package ch.ninecode.cim.CIMTool

import scala.collection.mutable.Set

case class JavaScript (parser: ModelParser, pkg: Package)
{
    def parses (): Iterable[(String, String)] =
    {
        val ret = Set[(String, String)]()

        for (cls <- parser.classes.filter (_._2.pkg == pkg))
            ret.add (("cim:" + cls._2.name, "parse_" + cls._2.name.replace ("-", "_")))

        ret
    }

    def asText (): String =
    {
        val requires = Set[Package]()
        val provides = Set[String]()
        val p = new StringBuilder ()
        for (cls <- parser.classes.filter (_._2.pkg == pkg))
        {
            val name = cls._2.name.replace ("-", "_")
            provides.add ("parse_" + name)
            val attributes = parser.attributes.getOrElse(cls._1, List[Attribute]())
            val s = new StringBuilder ()
            if (null != cls._2.note)
                s.append (JavaDoc (cls._2.note, 8).asText ())
            s.append ("        function parse_")
            s.append (name)
            s.append (""" (context, sub)
                |        {
                |            var obj;
                |            var bucket;
                |""".stripMargin)
            if (null != cls._2.sup)
            {
                val sup_pkg = cls._2.sup.pkg
                val prefix = if (sup_pkg != pkg) { requires.add (sup_pkg); sup_pkg.name + "." } else ""
                s.append ("""
                   |            obj = """.stripMargin)
                s.append (prefix)
                s.append ("""parse_""".stripMargin)
                s.append (cls._2.sup.name)
                s.append (""" (context, sub);""".stripMargin)
            }
            else
                s.append ("""
                   |            obj = base.parse_Element (context, sub);""".stripMargin)
            s.append ("""
               |            obj.cls = """".stripMargin)
            s.append (cls._2.name)
            s.append ("""";
               |""".stripMargin)
            for (attribute <- attributes)
            {
                val n = attribute.name.replace ("""/""", """\/""")
                s.append ("""            obj["""");
                s.append (attribute.name);
                s.append (""""] = base.parse_element (/<cim:""");
                s.append (cls._2.name);
                s.append (""".""");
                s.append (n);
                s.append (""">([\s\S]*?)<\/cim:""");
                s.append (cls._2.name);
                s.append (""".""");
                s.append (n);
                s.append (""">/g, sub, context, true);
                |""".stripMargin)
            }
            val roles = parser.roles.filter(_.src == cls._2)
            for (role <- roles)
                if (role.upper == 1)
                {
                    val n = role.name.replace ("""/""", """\/""")
                    s.append ("""            obj["""");
                    s.append (role.name);
                    s.append (""""] = base.parse_attribute (/<cim:""");
                    s.append (cls._2.name);
                    s.append (""".""");
                    s.append (n);
                    s.append ("""\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>/g, sub, context, true);
                    |""".stripMargin)
                }

            s.append ("""            bucket = context.parsed.""")
            s.append (name)
            s.append (""";""")
            s.append ("""
               |            if (null == bucket)
               |                context.parsed.""".stripMargin)
            s.append (name)
            s.append (""" = bucket = {};
               |            bucket[obj.id] = obj;
               |
               |            return (obj);
               |        }
               |
               |""".stripMargin)

            p.append (s)
        }

        if (provides.size > 0)
        {
            val v = new StringBuilder ()
            val r = scala.collection.mutable.SortedSet[String]()
            requires.foreach ((p) => r.add (p.name))

            v.append ("""define
                |(
                |    ["model/base"""".stripMargin)
            val includes = r.map ((p) => "\"model/" + p + "\"").mkString (", ")
            if (includes != "")
                v.append (""", """)
            v.append (includes)
            v.append ("""],
                |""".stripMargin)
            v.append (JavaDoc (pkg.notes, 4).asText ())
            v.append ("""    function (base""")
            val parameters = r.mkString (", ")
            if (parameters != "")
                v.append (""", """)
            v.append (parameters)
            v.append (""")
                |    {
                |
                |""".stripMargin)
            v.append (p.toString)
            v.append ("""        return (
                |            {
                |""".stripMargin)
            val functions = provides.map ((p) => "                " + p + ": " + p).mkString (",\n")
            v.append (functions)
            v.append ("""
                |            }
                |        );
                |    }
                |);""".stripMargin)

            v.toString
        }
        else
            ""
    }
}