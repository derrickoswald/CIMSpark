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
        val enumerations = Set[String]()
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

        def valid_attribute_name (name: String): String = name.replace (" ", "_").replace (".", "_").replace (",", "_")

        val p = new StringBuilder ()

        // do the enumerations
        for (cls <- classes2)
        {
            val s = new StringBuilder ()

            // get name
            val name = cls._2.name.replace ("-", "_")
            val attributes = parser.attributes.getOrElse (cls._1, List[Attribute]())
            val roles = parser.roles.filter(_.src == cls._2)

            if (cls._2.stereotype == "enumeration")
            {
                enumerations.add (name)

                // add javaDoc
                if (null != cls._2.note)
                    s.append (JavaDoc (cls._2.note, 8).asText)

                // https://stijndewitt.com/2014/01/26/enums-in-javascript/
                //            var SizeEnum = {
                //                SMALL: 1,
                //                MEDIUM: 2,
                //                LARGE: 3,
                //                properties: {
                //                    1: {name: "small", value: 1, code: "S"},
                //                    2: {name: "medium", value: 2, code: "M"},
                //                    3: {name: "large", value: 3, code: "L"}
                //                }
                //            };

                // output enumeration declaration
                s.append ("        var %s =\n        {\n".format (name))
                s.append (attributes.map (attribute ⇒ """            %s: "%s"""".format (valid_attribute_name (attribute.name), attribute.name)).mkString (",\n"))
                s.append ("\n        };\n        Object.freeze (%s);\n\n".format (name))
            }

            p.append (s)
        }

        // do the regular classes
        for (cls <- classes2)
        {
            val s = new StringBuilder ()

            // get name
            val name = cls._2.name.replace ("-", "_")
            val attributes = parser.attributes.getOrElse (cls._1, List[Attribute]())
            val roles = parser.roles.filter(_.src == cls._2)

            if (cls._2.stereotype != "enumeration")
            {
                provides.add (name)

                // add javaDoc
                if (null != cls._2.note)
                    s.append (JavaDoc (cls._2.note, 8).asText)

                // determine superclass and it's package (note package has a dot suffix)
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
                s.append ("        class %s extends %s%s".format (name, superclass_package, superclass))
                // output constructor and store function
                s.append ("""
                    |        {
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
                    if (enumerations.contains (attribute.typ))
                        s.append (
                            """                base.parse_attribute (/<cim:%s.%s\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>/g, obj, "%s", sub, context);
                              |""".stripMargin.format (cls._2.name, n, attribute.name))
                    else
                        s.append (
                            """                base.parse_element (/<cim:%s.%s>([\s\S]*?)<\/cim:%s.%s>/g, obj, "%s", %s, sub, context);
                            |""".stripMargin.format (cls._2.name, n, cls._2.name, n, attribute.name, fn))
                }
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
                    |""".stripMargin.format (name))

                // output the template function
                s.append ("""
                    |
                    |            template ()
                    |            {
                    |                return (
                    |                    `
                    |                    <a data-toggle="collapse" href="#%s_collapse" aria-expanded="true" aria-controls="%s_collapse">%s</a>
                    |                    <div id="%s_collapse" class="collapse in" style="margin-left: 10px;">
                    |                    `
                    |                    + %s%s.prototype.template.call (this) +
                    |                    `
                    |""".stripMargin.format (name, name, name, name, superclass_package, superclass))
                for (attribute <- attributes)
                    s.append ("                    {{#%s}}<div><b>%s</b>: {{%s}}</div>{{/%s}}\n".format (attribute.name, attribute.name, attribute.name, attribute.name))
                for (role <- roles.filter (_.upper == 1))
                    s.append ("                    {{#%s}}<div><b>%s</b>: <a href='#' onclick='require([&quot;cimmap&quot;], function(cimmap) {cimmap.select (&quot;{{%s}}&quot;);})'>{{%s}}</a></div>{{/%s}}\n".format (role.name, role.name, role.name, role.name, role.name))
                s.append (
                    """                    </div>
                    |                    `
                    |                );
                    |            }
                    |""".stripMargin)

                // output the condition function
                s.append ("""
                            |            condition (obj)
                            |            {
                            |                super.condition (obj);""".stripMargin)
                for (attribute <- attributes.filter (x ⇒ enumerations.contains (x.typ)))
                {
                    val name = attribute.name.replace ("""/""", """\/""")
                    s.append ("\n                obj.%s = []; if (!obj.%s) obj.%s.push ({ id: '', selected: true}); for (var property in %s) obj.%s.push ({ id: property, selected: obj.%s && obj.%s.endsWith ('.' + property)});".format (attribute.typ, name, attribute.typ, attribute.typ, attribute.typ, name, name))
                }
                s.append ("""
                            |            }
                            |""".stripMargin)

                // output the uncondition function
                s.append ("""
                            |            uncondition (obj)
                            |            {
                            |                super.uncondition (obj);""".stripMargin)
                for (attribute <- attributes.filter (x ⇒ enumerations.contains (x.typ)))
                    s.append ("\n                delete obj.%s;".format (attribute.typ))
                s.append ("""
                            |            }
                            |""".stripMargin)

                // output the editing template function
                s.append ("""
                            |            edit_template ()
                            |            {
                            |                return (
                            |                    `
                            |                    <a data-toggle="collapse" href="#%s_collapse" aria-expanded="true" aria-controls="%s_collapse">%s</a>
                            |                    <div id="%s_collapse" class="collapse in" style="margin-left: 10px;">
                            |                    `
                            |                    + %s%s.prototype.edit_template.call (this) +
                            |                    `
                            |""".stripMargin.format (name, name, name, name, superclass_package, superclass))
                for (attribute <- attributes)
                {
                    if (enumerations.contains (attribute.typ))
                    {
                        // output a selection (needs condition(obj) to get the array of strings
                        s.append ("                    <form class='form-inline'><div class='input-group'><label>%s: <select id='%s'>{{#%s}}<option value='{{id}}'{{#selected}} selected{{/selected}}>{{id}}</option>{{/%s}}</select></label></div></form>\n".format (attribute.name, attribute.name, attribute.typ, attribute.typ))

                    }
                    else
                        attribute.typ match
                        {
                            case "Boolean" =>
                                s.append ("                    <form class='form-inline'><div class='form-check'><label class='form-check-label'>%s: <input id='%s' class='form-check-input' type='checkbox'{{#%s}} checked{{/%s}}></label></div></form>\n".format (attribute.name, attribute.name, attribute.name, attribute.name))
    //                        case "DateTime" =>
    //                        case "Float" =>
                            case _ =>
                                s.append ("                    <form class='form-inline'><div class='input-group'><label>%s: <input id='%s' type='text'{{#%s}} value='{{%s}}'{{/%s}}></label></div></form>\n".format (attribute.name, attribute.name, attribute.name, attribute.name, attribute.name))
                        }
                }
                for (role <- roles.filter (_.upper == 1))
                    s.append ("                    <form class='form-inline'><div class='input-group'><label>%s: <input id='%s' type='text'{{#%s}} value='{{%s}}'{{/%s}}></label></div></form>\n".format (role.name, role.name, role.name, role.name, role.name))
                s.append (
                    """                    </div>
                      |                    `
                      |                );
                      |           }
                      |""".stripMargin)
                s.append (
                    """        }
                    |
                    |""".stripMargin)
            }

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