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
        // order the classes based on their superclass to avoid "ReferenceError: can't access lexical declaration `blah' before initialization"
        val classes: List[(Int, Class)] = parser.classes.filter (_._2.pkg == pkg).toList
        case class Joe (name: String, superclass: String, superclass_package: String, objectID: Int, cls: Class)
        val bunch: List[Joe] = classes.map (
            cls ⇒
            {
                val (superclass, superclass_package) =
                    if (null != cls._2.sup)
                    {
                        val sup_pkg = cls._2.sup.pkg
                        val superclass_package = if (sup_pkg != pkg) { requires.add (sup_pkg); sup_pkg.name} else ""
                        val superclass = cls._2.sup.name
                        (superclass, superclass_package)
                    }
                    else
                        ("Element", "base")

                Joe (cls._2.name.replace ("-", "_"), superclass, superclass_package, cls._1, cls._2)
            })
        // define a Directed Acyclic Graph
        case class DAG (parent: Joe, var children: List[DAG])
        val graph = DAG (Joe ("Element", null, null, 0, null), List())
        def get (name: String)(dag: DAG): DAG =
        {
            if (dag.parent.name == name)
                dag
            else
                dag.children.find (get (name)(_) != null) match { case Some (d) ⇒ d case None ⇒ null }
        }
        def add (joes: List[Joe]): Unit =
        {
            if (joes.nonEmpty)
            {
                val head = joes.head
                val rest = joes.tail
                val name = if (head.superclass_package == "") head.superclass else "Element" // outside our package might as well be Element
                val dag = get (name) (graph)
                if (null != dag)
                {
                    dag.children = dag.children :+ DAG (head, List())
                    add (rest)
                }
                else
                    // add everyone else first
                    add (rest :+ head)
            }
        }
        // make the graph
        add (bunch)
        // read out the graph breadth first (or at least every superclass is ahead of it's subclasses)
        def read (dags: List[DAG]): List[Joe] =
        {
            dags.map (_.parent) ++: dags.flatMap (x ⇒ read (x.children))
        }

        val bunch2 = read (graph.children)
        val classes2 = bunch2.map (x ⇒ (x.objectID, x.cls))
        val p = new StringBuilder ()
        for (cls <- classes2)
        {
            val s = new StringBuilder ()

            // get name
            val name = cls._2.name.replace ("-", "_")
            provides.add (name)

            // add javaDoc
            if (null != cls._2.note)
                s.append (JavaDoc (cls._2.note, 8).asText)

            // determine superclass and it's package (note package has a dot suffix
            val (superclass_package, superclass) =
                if (null != cls._2.sup)
                {
                    val sup_pkg = cls._2.sup.pkg
                    val superclass_package = if (sup_pkg != pkg) { requires.add (sup_pkg); sup_pkg.name + "." } else ""
                    val superclass = cls._2.sup.name
                    (superclass_package, superclass)
                }
                else
                    ("base.", "Element")

            // output class declaration
            s.append ("        class ")
            s.append (name)
            s.append (" extends ")
            s.append (superclass_package)
            s.append (superclass)
            s.append ("\n        {")

            // output constructor and store function
            s.append ("""
                |            constructor (template, cim_data)
                |            {
                |                super (template, cim_data);
                |                this._id = template.id;
                |                var bucket = cim_data.%s;
                |                if (null == bucket)
                |                   cim_data.%s = bucket = {};
                |                bucket[this._id] = template;
                |            }
                |
                |            remove (cim_data)
                |            {
                |               super.remove (cim_data);
                |               delete cim_data.%s[this._id];
                |            }
                |""".stripMargin.format (name, name, name))


            // output parse function
            val attributes = parser.attributes.getOrElse (cls._1, List[Attribute]())
            s.append ("""
                |            parse (context, sub)
                |            {
                |                var obj;
                |
                |                obj = %s%s.prototype.parse.call (this, context, sub);
                |                obj.cls = "%s";
                |""".stripMargin.format (superclass_package, superclass, cls._2.name))
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
                    """                base.parse_element (/<cim:%s.%s>([\s\S]*?)<\/cim:%s.%s>/g, obj, "%s", %s, sub, context);
                    |""".stripMargin.format (cls._2.name, n, cls._2.name, n, attribute.name, fn))
            }
            val roles = parser.roles.filter(_.src == cls._2)
            for (role <- roles)
                if (role.upper == 1)
                {
                    val n = role.name.replace ("""/""", """\/""")
                    s.append (
                        """                base.parse_attribute (/<cim:%s.%s\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>/g, obj, "%s", sub, context);
                        |""".stripMargin.format (cls._2.name, n, role.name))
                }
            // special handling for mRID in IdentifiedObject
            if (cls._2.name == "IdentifiedObject")
                s.append ("""                if (null == obj.mRID)
                |                    obj.mRID = obj.id;
                |                if ((null != obj.mRID) && (obj.id != obj.mRID))
                |                {
                |                    if ("undefined" != typeof (console))
                |                        console.log ("***Warning*** rdf:ID != mRID [" + obj.id + " != " + obj.mRID + "]");
                |                    else
                |                        print ("***Warning*** rdf:ID != mRID [" + obj.id + " != " + obj.mRID + "]");
                |                    obj.id = obj.mRID;
                |                }
                |""".stripMargin)
            s.append ("""
                |                var bucket = context.parsed.%s;
                |                if (null == bucket)
                |                   context.parsed.%s = bucket = {};
                |                bucket[obj.id] = obj;
                |
                |                return (obj);
                |            }
                |
                |""".stripMargin.format (name, name))

            // output the export function
            s.append (
                """            export (obj, full)
                  |            {
                  |""".stripMargin.format (name))
            if (null != cls._2.sup)
                s.append ("""                var fields = %s%s.prototype.export.call (this, obj, false);""".stripMargin.format (superclass_package, superclass))
            else
                s.append ("""                var fields = [];""")
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
                        """                base.export_element (obj, "%s", "%s", %s, fields);
                        |""".stripMargin.format (cls._2.name, n, fn))
            }
            for (role <- roles)
                if (role.upper == 1)
                {
                    val n = role.name.replace ("""/""", """\/""")
                    s.append (
                        """                base.export_attribute (obj, "%s", "%s", fields);
                          |""".stripMargin.format (cls._2.name, n, role.name))
                }
            s.append (
                """                if (full)
                |                    base.Element.prototype.export.call (this, obj, fields)
                |
                |                return (fields);
                |            }
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