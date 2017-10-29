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
                s.append (JavaDoc (cls._2.note, 8).asText)
            s.append (
                """        function parse_%s (context, sub)
                |        {
                |            var obj;
                |            var bucket;
                |
                |""".stripMargin.format (name))
            if (null != cls._2.sup)
            {
                val sup_pkg = cls._2.sup.pkg
                val prefix = if (sup_pkg != pkg) { requires.add (sup_pkg); sup_pkg.name + "." } else ""
                s.append ("""            obj = %sparse_%s (context, sub);""".format (prefix, cls._2.sup.name))
            }
            else
                s.append ("""            obj = base.parse_Element (context, sub);""")
            s.append (
                """
                |            obj.cls = "%s";
                |""".stripMargin.format (cls._2.name))
            for (attribute <- attributes)
            {
                val n = attribute.name.replace ("""/""", """\/""")
                var fn = attribute.typ match
                {
                    case "Boolean" => "base.to_boolean"
                    case "DateTime" => "base.to_datetime"
                    case "Float" => "base.to_float"
                    case _ => "base.to_string"
                }
                s.append (
                    """            base.parse_element (/<cim:%s.%s>([\s\S]*?)<\/cim:%s.%s>/g, obj, "%s", %s, sub, context);
                    |""".stripMargin.format (cls._2.name, n, cls._2.name, n, attribute.name, fn))
            }
            val roles = parser.roles.filter(_.src == cls._2)
            for (role <- roles)
                if (role.upper == 1)
                {
                    val n = role.name.replace ("""/""", """\/""")
                    s.append (
                        """            base.parse_attribute (/<cim:%s.%s\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>/g, obj, "%s", sub, context);
                        |""".stripMargin.format (cls._2.name, n, role.name))
                }
            // special handling for mRID in IdentifiedObject
            if (cls._2.name == "IdentifiedObject")
                s.append ("""            if (null == obj.mRID)
                |                obj.mRID = obj.id;
                |            if ((null != obj.mRID) && (obj.id != obj.mRID))
                |            {
                |                if ("undefined" != typeof (console))
                |                    console.log ("***Warning*** rdf:ID != mRID [" + obj.id + " != " + obj.mRID + "]");
                |                else
                |                    print ("***Warning*** rdf:ID != mRID [" + obj.id + " != " + obj.mRID + "]");
                |                obj.id = obj.mRID;
                |            }
                |""".stripMargin)
            s.append (
                """            bucket = context.parsed.%s;
                |            if (null == bucket)
                |                context.parsed.%s = bucket = {};
                |            bucket[obj.id] = obj;
                |
                |            return (obj);
                |        }
                |
                |""".stripMargin.format (name, name))

            // output the export function
            provides.add ("export_" + name)
            s.append (
                """        function export_%s (obj, exporters, full)
                  |        {
                  |""".stripMargin.format (name))
            if (null != cls._2.sup)
                s.append ("""            var fields = exporters["%s"](obj, exporters, false);""".format (cls._2.sup.name))
            else
                s.append ("""            var fields = [];""")
            s.append ("\n\n")
            for (attribute <- attributes)
            {
                val n = attribute.name.replace ("""/""", """\/""")
                var fn = attribute.typ match
                {
                    case "Boolean" => "base.from_boolean"
                    case "DateTime" => "base.from_datetime"
                    case "Float" => "base.from_float"
                    case _ => "base.from_string"
                }
                if ((cls._2.name != "IdentifiedObject") || (n != "mRID"))
                    s.append (
                        """            base.export_element (obj, "%s", "%s", %s, fields);
                        |""".stripMargin.format (cls._2.name, n, fn))
            }
            for (role <- roles)
                if (role.upper == 1)
                {
                    val n = role.name.replace ("""/""", """\/""")
                    s.append (
                        """            base.export_attribute (obj, "%s", "%s", fields);
                          |""".stripMargin.format (cls._2.name, n, role.name))
                }
            s.append (
                """            if (full)
                |                base.export_Element (obj, fields)
                |
                |            return (fields);
                |        }
                |
                |""".stripMargin.format (name))

            p.append (s)
        }

        if (provides.nonEmpty)
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
            v.append (JavaDoc (pkg.notes, 4).asText)
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