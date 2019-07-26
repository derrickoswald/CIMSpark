package ch.ninecode.cim.CIMTool

import scala.collection.mutable

case class JavaScript (parser: ModelParser, pkg: Package)
{
    def parses (): Iterable[(String, String)] =
    {
        val ret = mutable.Set[(String, String)]()

        for (cls <- parser.classes.filter (_._2.pkg == pkg))
            ret.add (("cim:" + cls._2.name, "parse_" + cls._2.name.replace ("-", "_")))

        ret
    }

    def asText (): String =
    {
        val requires = mutable.Set[Package]()
        val provides = mutable.Set[(String,String)]()
        val enumerations = mutable.Set[String]()
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
        val classes2 = bunch2.map (x ⇒ x.cls)

        def valid_attribute_name (name: String): String =
        {
            val n = name.replace (" ", "_").replace (".", "_").replace (",", "_").replace ("/", "_").replace ("-", "_").replace ("%", "_")
            if (n.charAt (0).isDigit)
                "_" + n
            else
                n
        }
        def valid_role_name (name: String): String = if (name == "") "unknown" else name.replace (" ", "_").replace (".", "_").replace (",", "_").replace ("""/""", """\/""")
        def isPrimitive (typ: String): Boolean =
        {
            val domain = parser.domains.filter (_.name == typ)
            domain.nonEmpty && ((domain.head.stereotype == "Primitive") || (domain.head.stereotype == "CIMDatatype"))
        }
        def isEnumeration (typ: String): Boolean =
        {
            val domain = parser.domains.filter (_.name == typ)
            domain.nonEmpty && (domain.head.stereotype == "enumeration")
        }
        val p = new StringBuilder ()

        // do the enumerations
        for (cls <- classes2)
        {
            val s = new StringBuilder ()

            // get name
            val name = cls.name.replace ("-", "_")
            val attributes = parser.attributesFor (cls)

            if (cls.stereotype == "enumeration")
            {
                provides.add ((name, name))
                enumerations.add (name)

                // add javaDoc
                if (null != cls.note)
                    s.append (JavaDoc (cls.note, 8).asText)

                // https://stijndewitt.com/2014/01/26/enums-in-javascript/
                //            let SizeEnum = {
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
                s.append ("        let %s =\n        {\n".format (name))
                s.append (attributes.map (attribute ⇒ """            "%s": "%s"""".format (valid_attribute_name (attribute.name), attribute.name)).mkString (",\n"))
                s.append ("\n        };\n        Object.freeze (%s);\n\n".format (name))
            }

            p.append (s)
        }

        // do the regular classes
        for (cls <- classes2)
        {
            val s = new StringBuilder ()

            // get name
            val name = cls.name.replace ("-", "_")
            // MarketManagement has a class called Domain that conflicts with the Domain package
            val internalname = if (name == "Domain") "Domain_" else name
            val attributes = parser.attributesFor (cls)
            val roles = parser.rolesFor (cls)

            if (cls.stereotype != "enumeration")
            {
                provides.add ((name, internalname))

                // add javaDoc
                if (null != cls.note)
                    s.append (JavaDoc (cls.note, 8).asText)

                // determine superclass and it's package (note package has a dot suffix)
                val (superclass_package, superclass) =
                    if (null != cls.sup)
                    {
                        val sup_pkg = cls.sup.pkg
                        val superclass_package = if (sup_pkg != pkg) { requires.add (sup_pkg); sup_pkg.name + "." } else ""
                        val superclass = cls.sup.name
                        (superclass_package, superclass)
                    }
                    else
                        ("base.", "Element")

                // output class declaration
                s.append ("        class %s extends %s%s".format (internalname, superclass_package, superclass))
                // output constructor and store function
                s.append ("""
                    |        {
                    |            constructor (template, cim_data)
                    |            {
                    |                super (template, cim_data);
                    |                let bucket = cim_data.%s;
                    |                if (null == bucket)
                    |                   cim_data.%s = bucket = {};
                    |                bucket[template.id] = template;
                    |            }
                    |
                    |            remove (obj, cim_data)
                    |            {
                    |               super.remove (obj, cim_data);
                    |               delete cim_data.%s[obj.id];
                    |            }
                    |""".stripMargin.format (name, name, name))


                // output parse function
                s.append ("""
                    |            parse (context, sub)
                    |            {
                    |                let obj = %s%s.prototype.parse.call (this, context, sub);
                    |                obj.cls = "%s";
                    |""".stripMargin.format (superclass_package, superclass, cls.name))
                for (attribute <- attributes)
                {
                    val n = attribute.name.replace ("""/""", """\/""")
                    val fn = attribute.typ match
                    {
                        case "Boolean" => "base.to_boolean"
                        case "DateTime" => "base.to_datetime"
                        case "Float" => "base.to_float"
                        case _ => "base.to_string"
                    }
                    if (enumerations.contains (attribute.typ) || !isPrimitive (attribute.typ))
                        s.append (
                            """                base.parse_attribute (/<cim:%s.%s\s+rdf:resource\s*?=\s*?(["'])([\s\S]*?)\1\s*?\/>/g, obj, "%s", sub, context);
                              |""".stripMargin.format (cls.name, n, attribute.name))
                    else
                        s.append (
                            """                base.parse_element (/<cim:%s.%s>([\s\S]*?)<\/cim:%s.%s>/g, obj, "%s", %s, sub, context);
                            |""".stripMargin.format (cls.name, n, cls.name, n, attribute.name, fn))
                }
                for (role <- roles)
                {
                    val n = valid_role_name (role.name)
                    s.append (
                        """                base.%s (/<cim:%s.%s\s+rdf:resource\s*?=\s*?(["'])([\s\S]*?)\1\s*?\/>/g, obj, "%s", sub, context);
                        |""".stripMargin.format (if (role.upper == 1) "parse_attribute" else "parse_attributes", cls.name, n, role.name))
                }
                // special handling for mRID in IdentifiedObject
                if (cls.name == "IdentifiedObject")
                    s.append ("""
                    |
                    |                if (null == obj.mRID)
                    |                    obj.mRID = obj.id;
                    |                if ((null != obj.mRID) && (obj.id != obj.mRID))
                    |                {
                    |                    if ("undefined" !== typeof (console))
                    |                        console.log ("***Warning*** rdf:ID !== mRID [" + obj.id + " !== " + obj.mRID + "]");
                    |                    else
                    |                        print ("***Warning*** rdf:ID !== mRID [" + obj.id + " !== " + obj.mRID + "]");
                    |                    obj.id = obj.mRID;
                    |                }
                    |""".stripMargin)
                s.append (
                    """                let bucket = context.parsed.%s;
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
                if (null != cls.sup)
                    s.append ("""                let fields = %s%s.prototype.export.call (this, obj, false);""".stripMargin.format (superclass_package, superclass))
                else
                    s.append ("""                let fields = [];""")
                s.append ("\n\n")
                for (attribute <- attributes)
                {
                    val n = attribute.name.replace ("""/""", """\/""")
                    val fn = attribute.typ match
                    {
                        case "Boolean" => "base.from_boolean"
                        case "DateTime" => "base.from_datetime"
                        case "Float" => "base.from_float"
                        case _ => "base.from_string"
                    }
                    if ((cls.name != "IdentifiedObject") || (n != "mRID"))
                        if (enumerations.contains (attribute.typ) || !isPrimitive (attribute.typ))
                            s.append (
                                """                base.export_attribute (obj, "%s", "%s", "%s", fields);
                                |""".stripMargin.format (cls.name, attribute.name, n))
                        else
                            s.append (
                                """                base.export_element (obj, "%s", "%s", "%s",  %s, fields);
                                |""".stripMargin.format (cls.name, attribute.name, n, fn))
                }
                for (role <- roles)
                {
                    val n = valid_role_name (role.name)
                    s.append (
                        """                base.%s (obj, "%s", "%s", "%s", fields);
                          |""".stripMargin.format (if (role.upper == 1) "export_attribute" else "export_attributes", cls.name, role.name, n))
                }
                s.append (
                    """                if (full)
                    |                    base.Element.prototype.export.call (this, obj, fields);
                    |
                    |                return (fields);
                    |            }
                    |""".stripMargin.format (name))

                // output the template function
                s.append ("""
                    |            template ()
                    |            {
                    |                return (
                    |                    `
                    |                    <fieldset>
                    |                    <legend class='col-form-legend'><a class="collapse-link" data-toggle="collapse" href="#%s_collapse" aria-expanded="true" aria-controls="%s_collapse" style="margin-left: 10px;">%s</a></legend>
                    |                    <div id="%s_collapse" class="collapse in show" style="margin-left: 10px;">
                    |                    `
                    |                    + %s%s.prototype.template.call (this) +
                    |                    `
                    |""".stripMargin.format (name, name, name, name, superclass_package, superclass))
                for (attribute <- attributes)
                {
                    val ref = parser.classes.find (x ⇒ x._2.name == attribute.typ && x._2.pkg.name != "Domain" && x._2.stereotype != "enumeration" )
                    ref match
                    {
                        case Some (x) ⇒
                            s.append ("                    {{#%s}}<div><b>%s</b>: <a href='#' onclick='require([&quot;cimmap&quot;], function(cimmap) {cimmap.select (&quot;{{%s}}&quot;);}); return false;'>{{%s}}</a></div>{{/%s}}\\n".format (attribute.name, attribute.name, attribute.name, attribute.name, attribute.name))
                        case None ⇒
                            s.append ("                    {{#%s}}<div><b>%s</b>: {{%s}}</div>{{/%s}}\n".format (attribute.name, attribute.name, attribute.name, attribute.name))
                    }
                }
                for (role <- roles)
                    if (role.upper == 1)
                        s.append ("                    {{#%s}}<div><b>%s</b>: <a href='#' onclick='require([&quot;cimmap&quot;], function(cimmap) {cimmap.select (&quot;{{%s}}&quot;);}); return false;'>{{%s}}</a></div>{{/%s}}\n".format (role.name, role.name, role.name, role.name, role.name))
                    else
                        s.append ("                    {{#%s}}<div><b>%s</b>: <a href='#' onclick='require([&quot;cimmap&quot;], function(cimmap) {cimmap.select (&quot;{{.}}&quot;);}); return false;'>{{.}}</a></div>{{/%s}}\n".format (role.name, role.name, role.name))
                s.append (
                    """                    </div>
                    |                    </fieldset>
                    |
                    |                    `
                    |                );
                    |            }
                    |""".stripMargin)

                // output the condition function
                s.append ("""
                    |            condition (obj)
                    |            {
                    |                super.condition (obj);""".stripMargin)
                for (attribute <- attributes.filter (x ⇒ isEnumeration (x.typ)))
                {
                    val varname = attribute.name + attribute.typ
                    val qualifiedname = if (enumerations.contains (attribute.typ))
                        attribute.typ // local enumeration
                    else
                    {
                        val domain = parser.domains.filter (_.name == attribute.typ).head // a domain
                        if (domain.pkg == pkg)
                            attribute.typ // local
                        else
                        {
                            // add it to requires if necessary
                            if (!requires.contains (domain.pkg))
                                requires.add (domain.pkg)
                            domain.pkg.name + "." + attribute.typ
                        }
                    }
                    s.append ("\n                obj[\"%s\"] = [{ id: '', selected: (!obj[\"%s\"])}]; for (let property in %s) obj[\"%s\"].push ({ id: property, selected: obj[\"%s\"] && obj[\"%s\"].endsWith ('.' + property)});".format (varname, attribute.name, qualifiedname, varname, attribute.name, attribute.name))
                }
                for (role ← roles.filter (_.upper != 1))
                {
                    val n = valid_role_name (role.name)
                    s.append ("\n                if (obj[\"%s\"]) obj[\"%s_string\"] = obj[\"%s\"].join ();".format (n, n, n))
                }
                s.append ("""
                    |            }
                    |""".stripMargin)

                // output the uncondition function
                s.append ("""
                    |            uncondition (obj)
                    |            {
                    |                super.uncondition (obj);""".stripMargin)
                for (attribute <- attributes.filter (x ⇒ isEnumeration (x.typ)))
                {
                    val varname = attribute.name.replace ("""/""", """\/""") + attribute.typ
                    s.append ("\n                delete obj[\"%s\"];".format (varname))
                }
                for (role ← roles.filter (_.upper != 1))
                    s.append ("\n                delete obj[\"%s_string\"];".format (valid_role_name (role.name)))
                s.append ("""
                    |            }
                    |""".stripMargin)

                // output the editing template function
                s.append ("""
                    |            edit_template ()
                    |            {
                    |                return (
                    |                    `
                    |                    <fieldset>
                    |                    <legend class='col-form-legend'><a class="collapse-link" data-toggle="collapse" href="#{{id}}_%s_collapse" aria-expanded="true" aria-controls="{{id}}_%s_collapse" style="margin-left: 10px;">%s</a></legend>
                    |                    <div id="{{id}}_%s_collapse" class="collapse in show" style="margin-left: 10px;">
                    |                    `
                    |                    + %s%s.prototype.edit_template.call (this) +
                    |                    `
                    |""".stripMargin.format (name, name, name, name, superclass_package, superclass))
                for (attribute <- attributes)
                {
                    if (isEnumeration (attribute.typ))
                    {
                        val varname = attribute.name + attribute.typ
                        // output a selection (needs condition(obj) to get the array of strings)
                        s.append ("                    <div class='form-group row'><label class='col-sm-4 col-form-label' for='{{id}}_%s'>%s: </label><div class='col-sm-8'><select id='{{id}}_%s' class='form-control custom-select'>{{#%s}}<option value='{{id}}'{{#selected}} selected{{/selected}}>{{id}}</option>{{/%s}}</select></div></div>\n".format (attribute.name, attribute.name, attribute.name, varname, varname))
                    }
                    else
                        attribute.typ match
                        {
                            case "Boolean" =>
                                s.append ("                    <div class='form-group row'><div class='col-sm-4' for='{{id}}_%s'>%s: </div><div class='col-sm-8'><div class='form-check'><input id='{{id}}_%s' class='form-check-input' type='checkbox'{{#%s}} checked{{/%s}}></div></div></div>\n".format (attribute.name, attribute.name, attribute.name, attribute.name, attribute.name))
    //                        case "DateTime" =>
    //                        case "Float" =>
                            case _ =>
                                s.append ("                    <div class='form-group row'><label class='col-sm-4 col-form-label' for='{{id}}_%s'>%s: </label><div class='col-sm-8'><input id='{{id}}_%s' class='form-control' type='text'{{#%s}} value='{{%s}}'{{/%s}}></div></div>\n".format (attribute.name, attribute.name, attribute.name, attribute.name, attribute.name, attribute.name))
                        }
                }
                for (role <- roles)
                    if (role.upper == 1)
                        s.append ("                    <div class='form-group row'><label class='col-sm-4 col-form-label' for='{{id}}_%s'>%s: </label><div class='col-sm-8'><input id='{{id}}_%s' class='form-control' type='text'{{#%s}} value='{{%s}}'{{/%s}}></div></div>\n".format (role.name, role.name, role.name, role.name, role.name, role.name))
                    else
                        if (role.many_to_many)
                            s.append ("                    <div class='form-group row'><label class='col-sm-4 col-form-label' for='{{id}}_%s'>%s: </label><div class='col-sm-8'><input id='{{id}}_%s' class='form-control' type='text'{{#%s}} value='{{%s_string}}'{{/%s}}></div></div>\n".format (role.name, role.name, role.name, role.name, role.name, role.name))
                s.append (
                    """                    </div>
                    |                    </fieldset>
                    |                    `
                    |                );
                    |            }
                    |""".stripMargin)

                // output the editing form submit function
                s.append ("""
                    |            submit (id, obj)
                    |            {
                    |%s                obj = obj || { id: id, cls: "%s" };
                    |                super.submit (id, obj);
                    |""".stripMargin.format (if (attributes.nonEmpty || roles.exists (r ⇒ r.upper == 1 || r.many_to_many)) "                let temp;\n\n" else "", cls.name))
                for (attribute <- attributes)
                    if (isEnumeration (attribute.typ))
                    {
                        val qualifiedname = if (enumerations.contains (attribute.typ))
                            attribute.typ // local enumeration
                        else
                        {
                            val domain = parser.domains.filter (_.name == attribute.typ).head // a domain
                            if (domain.pkg == pkg)
                                attribute.typ // local
                            else
                            {
                                // add it to requires if necessary
                                if (!requires.contains (domain.pkg))
                                    requires.add (pkg)
                                domain.pkg.name + "." + attribute.typ
                            }
                        }
                        s.append ("                temp = %s[document.getElementById (id + \"_%s\").value]; if (temp) obj[\"%s\"] = \"http://iec.ch/TC57/2013/CIM-schema-cim16#%s.\" + temp; else delete obj[\"%s\"];\n".format (qualifiedname, attribute.name, attribute.name, attribute.typ, attribute.name))
                    }
                    else
                        attribute.typ match
                        {
                            case "Boolean" =>
                                s.append ("                temp = document.getElementById (id + \"_%s\").checked; if (temp) obj[\"%s\"] = true;\n".format (attribute.name, attribute.name))
                            case _ =>
                                s.append ("                temp = document.getElementById (id + \"_%s\").value; if (\"\" !== temp) obj[\"%s\"] = temp;\n".format (attribute.name, attribute.name))
                        }
                for (role <- roles)
                    if (role.upper == 1)
                        s.append ("                temp = document.getElementById (id + \"_%s\").value; if (\"\" !== temp) obj[\"%s\"] = temp;\n".format (role.name, role.name))
                    else
                        if (role.many_to_many)
                            s.append ("                temp = document.getElementById (id + \"_%s\").value; if (\"\" !== temp) obj[\"%s\"] = temp.split (\",\");\n".format (role.name, role.name))

                s.append ("""
                    |                return (obj);
                    |            }
                    |""".stripMargin)

                // output the relations
                if (roles.nonEmpty)
                {
                    s.append ("""
                        |            relations ()
                        |            {
                        |                return (
                        |                    super.relations ().concat (
                        |                        [
                        |""".stripMargin)
                    val array = roles.map (role ⇒ """["%s", "%s", "%s", "%s", "%s"]""".format (valid_role_name (role.name), role.card, role.mate.card, valid_role_name (role.dst.name), role.mate.name))
                    s.append (array.mkString ("                            ", ",\n                            ", "\n"))
                    s.append (
                        """                        ]
                        |                    )
                        |                );
                        |            }
                        |""".stripMargin)
                }

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
            val functions = provides.map ((p) => "                " + p._1 + ": " + p._2).mkString (",\n")
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