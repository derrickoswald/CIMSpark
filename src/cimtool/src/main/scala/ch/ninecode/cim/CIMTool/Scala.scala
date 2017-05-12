package ch.ninecode.cim.CIMTool

import scala.collection.mutable.Set
import scala.collection.mutable.SortedSet

case class Scala (parser: ModelParser, pkg: Package)
{
    val parses: Iterable[(String, String)] =
    {
        val ret = Set[(String, String)]()

        for (cls <- parser.classes.filter (_._2.pkg == pkg))
            ret.add (("cim:" + cls._2.name, "parse_" + cls._2.name.replace ("-", "_")))

        ret
    }

    def valid_class_name (s: String): String =
    {
        val name = s match
        {
            // ToDo: all keywords
            case "type" => "typ"
            case "val" => "_val"
            case "class" => "_class"
            case "%" => "percent"
            case "length" => "len"
            case "" => "attr" // ToDo: WTF?
            case _ => 
                val identifier = (if (s.charAt (0).isDigit) "_" else "") +
                s.replace (" ", "_").replace ("-", "_").replace ("""/""", """_""").replace (""".""", """_""").replace (""",""", """_""")
                if (identifier.endsWith ("_")) identifier + "1" else identifier
        }
        if (name == "Unit")
            "Unit_"
        else
            name
    }

    def valid_attribute_name (attribute: Attribute): String =
    {
        val s = attribute.name
        val name = s match
        {
            // ToDo: all keywords
            case "type" => "typ"
            case "val" => "_val"
            case "class" => "_class"
            case "%" => "percent"
            case "length" => "len"
            case "size" => "size1"
            case "lock" => "lock1"
            case "" => "attr" // ToDo: WTF?
            case _ => 
                val identifier = (if (s.charAt (0).isDigit) "_" else "") +
                s.replace (" ", "_").replace ("-", "_").replace ("""/""", """_""").replace (""".""", """_""").replace (""",""", """_""")
                if (identifier.endsWith ("_")) identifier + "1" else identifier
        }
        val stupid_name =
            if (name == attribute.cls.name)
                name + "_attr"
            else if ((attribute.cls.sup != null) && (name == attribute.cls.sup.name))
                name + "_attr"
            else
                name
        stupid_name
    }

    def valid_role_name (role: Role): String =
    {
        val s = role.name
        val name = s match
        {
            // ToDo: all keywords
            case "type" => "typ"
            case "val" => "_val"
            case "class" => "_class"
            case "%" => "percent"
            case "length" => "len"
            case "" => "attr" // ToDo: WTF?
            case _ => 
                val identifier = (if (s.charAt (0).isDigit) "_" else "") +
                s.replace (" ", "_").replace ("-", "_").replace ("""/""", """_""").replace (""".""", """_""").replace (""",""", """_""")
                if (identifier.endsWith ("_")) identifier + "1" else identifier
        }
        val stupid_name =
            if (name == role.src.name)
                name + "_attr"
            else if ((role.src.sup != null) && (name == role.src.sup.name))
                name + "_attr"
            else
                name
        stupid_name
    }

    val register: String =
    {
        "_" + valid_class_name (pkg.name)
    }

    def details (attribute: Attribute): (String, String, String) =
    {
        val domain = parser.domains.find (_.name == attribute.typ) match
        {
            case Some (dom) => dom
            //Domain (xuid, name, note, stereotype, noenum, value, unit, multiplier, denominatorUnit, denominatorMultiplier)
            case None => Domain ("", "String", "", "", null, "String", "", "", "", "")
        }
        val (datatype, initializer, function) = domain.name match
        {
            case "Time" => ("String", "null", "")
            case "Integer" => ("Int", "0", "toInteger")
            case "Float" => ("Double", "0.0", "toDouble")
            case "Decimal" => ("Double", "0.0", "toDouble")
            case "Boolean" => ("Boolean", "false", "toBoolean")
            case "Date" => ("String", "null", "")
            case "Duration" => ("String", "null", "")
            case "String" => ("String", "null", "")
            case "DateTime" => ("String", "null", "")
            case "MonthDay" => ("String", "null", "")
            case _ =>
                domain.value match
                    {
                        case "Time" => ("String", "null", "")
                        case "Integer" => ("Int", "0", "toInteger")
                        case "Float" => ("Double", "0.0", "toDouble")
                        case "Decimal" => ("Double", "0.0", "toDouble")
                        case "Boolean" => ("Boolean", "false", "toBoolean")
                        case "Date" => ("String", "null", "")
                        case "Duration" => ("String", "null", "")
                        case "String" => ("String", "null", "")
                        case "DateTime" => ("String", "null", "")
                        case "MonthDay" => ("String", "null", "")
                        case _ => ("String", "null", "")
                    }
        }
        (datatype, initializer, function)
    }

    def asText (): String =
    {
        val classes = parser.classes.filter (_._2.pkg == pkg)
        implicit val ordering = new Ordering[(String, Int)]
        {
           def compare (a: (String, Int), b: (String, Int)) = a._1.compareTo (b._1)
        }
        val case_classes = SortedSet[(String,Int)]()
        for (cls <- classes)
            // special handling for Domain
            if ((pkg.name != "Domain") || (cls._2.stereotype == "Compound"))
                case_classes.add ((valid_class_name (cls._2.name), cls._1))

        val requires = Set[Package]()
        val p = new StringBuilder ()
        for (c <- case_classes)
        {
            val cls = classes (c._2)
            val name = valid_class_name (cls.name)
            val attr = parser.attributes.getOrElse(c._2, List[Attribute]()).filter (_.name != "") // ToDo: why empty names?
            def myrole (role: Role): Boolean =
            {
                def many_to_many: Boolean = ((role.card == "0..*") && (role.mate.card == "0..*") && role.sideA)
                role.src == cls && ((role.upper == 1) || many_to_many)
            }
            val rols = parser.roles.filter (myrole)
            val (attributes, roles) = if ((attr.length + rols.size) > 21)
            {
                println ("warning: " + pkg.name + "." + cls.name + " has too many attributes/roles (" + attr.length + "/" + rols.size + ") for a Scala case class")
                // ToDo: better method
                val at = attr.takeRight (21) // use takeRight so GeneratingUnit.ratedNetMaxP is included
                val n = 21 - at.length
                val rl = rols.takeRight (Math.max (0, n))
                (at, rl)
            }
            else
                (attr, rols)
            val s = new StringBuilder ()
            if (null != cls.note)
                s.append (JavaDoc (cls.note, 0).asText ())
            s.append ("case class ")
            s.append (name)
            s.append ("""
                |(
                |    override val sup: """.stripMargin)
            if (null != cls.sup)
                s.append (cls.sup.name)
            else
                s.append ("""BasicElement""")
            val initializers = new StringBuilder ()
            for (attribute <- attributes)
            {
                if (initializers.length > 0)
                    initializers.append (", ")
                s.append (""",
                |
                |""".stripMargin)
                s.append (JavaDoc (attribute.notes, 4).asText ())
                val n = valid_attribute_name (attribute)
                s.append ("""    val """);
                s.append (n);
                s.append (""": """)
                val (datatype, initializer, function) = details (attribute)
                s.append (datatype)
                initializers.append (initializer)
            }
            for (role <- roles)
                if (role.upper == 1)
                {
                    if (initializers.length > 0)
                        initializers.append (", ")
                    initializers.append ("""null""")
                    s.append (""",
                    |
                    |""".stripMargin)
                    s.append (JavaDoc (role.note, 4).asText ())
                    val n = valid_role_name (role)
                    s.append ("""    val """);
                    s.append (n);
                    s.append (""": String""".stripMargin)
                }
                else if (role.card == "0..*")
                {
                    if (initializers.length > 0)
                        initializers.append (", ")
                    initializers.append ("""List()""")
                    s.append (""",
                    |
                    |""".stripMargin)
                    s.append (JavaDoc (role.note, 4).asText ())
                    val n = valid_role_name (role)
                    s.append ("""    val """);
                    s.append (n);
                    s.append (""": List[String]""".stripMargin)
                }
            s.append ("""
            |)
            |extends
            |    Element
            |{
            |    def this () = { this (null""".stripMargin)
            if (initializers.length > 0)
                s.append (""", """)
            s.append (initializers.toString)
            s.append (""") }
            |    def """.stripMargin)
            if (null != cls.sup)
            {
                s.append (cls.sup.name)
                s.append (""": """)
                s.append (cls.sup.name)
                s.append (""" = sup.asInstanceOf[""")
                s.append (cls.sup.name)
            }
            else
                s.append ("""Element: Element = sup.asInstanceOf[Element""")
            s.append ("""]
            |    override def copy (): Row = { return (clone ().asInstanceOf[""".stripMargin)
            s.append (name)
            s.append ("""]); }
            |    override def get (i: Int): Object =
            |    {
            |        if (i < productArity)
            |            productElement (i).asInstanceOf[AnyRef]
            |        else
            |            throw new IllegalArgumentException ("invalid property index " + i)
            |    }
            |    override def length: Int = productArity
            |}
            |
            |object """.stripMargin)
            s.append (name)
            s.append ("""
            |extends
            |    Parseable[""".stripMargin)
            s.append (name)
            s.append ("""]
            |{
            |""".stripMargin)
            for (attribute <- attributes)
            {
                val n = valid_attribute_name (attribute)
                s.append ("""    val """.stripMargin)
                s.append (n);
                s.append (""" = parse_element (element ("""")
                s.append ("""""""")
                s.append (name);
                s.append (""".""")
                s.append (attribute.name);
                s.append ("""""""")
                s.append (""""))_
                |""".stripMargin)
            }
            for (role <- roles)
                if (role.upper == 1)
                {
                    val n = valid_role_name (role)
                    s.append ("""    val """.stripMargin)
                    s.append (n);
                    s.append (""" = parse_attribute (attribute ("""")
                    s.append ("""""""")
                    s.append (name);
                    s.append (""".""")
                    s.append (role.name);
                    s.append ("""""""")
                    s.append (""""))_
                    |""".stripMargin)
                }
                else if (role.card == "0..*")
                {
                    val n = valid_role_name (role)
                    s.append ("""    val """.stripMargin)
                    s.append (n);
                    s.append (""" = parse_attributes (attribute ("""")
                    s.append ("""""""")
                    s.append (name);
                    s.append (""".""")
                    s.append (role.name);
                    s.append ("""""""")
                    s.append (""""))_
                    |""".stripMargin)
                }

            s.append ("""    def parse (context: Context): """)
            s.append (name)
            s.append (""" = 
            |    {
            |        """.stripMargin)
            s.append (name)
            s.append ("""(
            |            """.stripMargin)
            if (null != cls.sup)
                s.append (cls.sup.name)
            else
                s.append ("""BasicElement""")
            s.append (""".parse (context)""")
            for (attribute <- attributes)
            {
                s.append (""",
                |""".stripMargin)
                val n = valid_attribute_name (attribute)
                s.append ("""            """)
                val (datatype, initializer, function) = details (attribute)
                if (function != "")
                {
                    s.append (function)
                    s.append (""" (""")
                }
                s.append (n)
                s.append (""" (context)""")
                if (function != "")
                    s.append (""", context)""")
            }
            for (role <- roles)
                if ((role.upper == 1) || (role.card == "0..*"))
                {
                    s.append (""",
                    |""".stripMargin)
                    val n = valid_role_name (role)
                    s.append ("""            """)
                    s.append (n)
                    s.append (""" (context)""")
                }
            s.append ("""
            |        )
            |    }
            |}
            |
            |""".stripMargin)

            p.append (s)
        }

        if (case_classes.size > 0)
        {
            val v = new StringBuilder ()
            val r = scala.collection.mutable.SortedSet[String]()
            requires.foreach ((p) => r.add (p.name))

            v.append ("""package ch.ninecode.model
            |
            |import org.apache.spark.sql.Row
            |
            |import ch.ninecode.cim.Context
            |
            |""".stripMargin)
            v.append (JavaDoc (pkg.notes, 0).asText ())
            v.append ("""
                |""".stripMargin)
            v.append (p.toString)

            v.append ("""object """)
            v.append (register)
            v.append ("""
                |{
                |    def register: Unit =
                |    {
                |""".stripMargin)
            for (cl <- case_classes)
            {
                v.append ("""        """)
                v.append (cl._1)
                v.append (""".register
                |""".stripMargin)
            }
            v.append ("""    }
            |}""".stripMargin)

            v.toString
        }
        else
            ""
    }
}