package ch.ninecode.cim.tool

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import scala.collection.mutable
import scala.collection.SortedSet

case class Scala (parser: ModelParser, options: CIMToolOptions) extends CodeGenerator
{
    val log: Logger = LoggerFactory.getLogger (getClass)

    def register (pkg: Package): String =
    {
        s"_${pkg.valid_class_name}"
    }

    def details (classes: SortedSet[Class]) (attribute: Attribute): Member =
    {
        val name = attribute.name
        val variable = attribute.attribute_name
        val comment = attribute.notes
        parser.domains.find (_.name == attribute.typ) match
        {
            case Some (dom) =>
                dom.stereotype match
                {
                    case "Primitive" =>
                        dom.name match
                        {
                            case "Time" =>
                                Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "Integer" => Member (name, variable, false, comment, false, "0..1", "0..*", "Int", "0", "toInteger", null)
                            case "Float" =>
                                Member (name, variable, false, comment, false, "0..1", "0..*", "Double", "0.0", "toDouble", null)
                            case "Decimal" => Member (name, variable, false, comment, false, "0..1", "0..*", "Double", "0.0", "toDouble", null)
                            case "Boolean" => Member (name, variable, false, comment, false, "0..1", "0..*", "Boolean", "false", "toBoolean", null)
                            case "Date" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "Duration" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "String" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "DateTime" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "MonthDay" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "URI" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case _ =>
                                throw new Exception ("""unknown primitive type "%s"""".format (dom.name))
                        }
                    case "enumeration" =>
                        Member (name, variable, false, comment, true, "0..1", "0..*", "String", "null", "", null)
                    case "Compound" =>
                        Member (name, variable, false, comment, true, "0..1", "0..*", "String", "null", "",
                            classes.find (_.name == attribute.typ) match
                            {
                                case Some (clz: Class) => clz.valid_class_name
                                case None => null
                            }
                        )
                    case "CIMDatatype" =>
                        dom.value match
                        {
                            case "Time" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "Integer" => Member (name, variable, false, comment, false, "0..1", "0..*", "Int", "0", "toInteger", null)
                            case "Float" => Member (name, variable, false, comment, false, "0..1", "0..*", "Double", "0.0", "toDouble", null)
                            case "Decimal" => Member (name, variable, false, comment, false, "0..1", "0..*", "Double", "0.0", "toDouble", null)
                            case "Boolean" => Member (name, variable, false, comment, false, "0..1", "0..*", "Boolean", "false", "toBoolean", null)
                            case "Date" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "Duration" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "String" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "DateTime" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case "MonthDay" => Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                            case _ =>
                                Member (name, variable, false, comment, false, "0..1", "0..*", "String", "null", "", null)
                        }
                    case _ =>
                        throw new Exception ("""unknown Domain stereotype "%s"""".format (dom.stereotype))
                }
            case None =>
                classes.find (_.name == attribute.typ) match
                {
                    case Some (clz: Class) =>
                        Member (name, variable, false, comment, true, "0..1", "0..*", "String", "null", "", clz.valid_class_name)
                    case None =>
                        Member (name, variable, false, comment, true, "0..1", "", "String", "null", "", null)
                }
        }
    }

    def details (role: Role): Member =
    {
        val name = role.name
        val variable = role.role_name
        val comment = role.note
        val referenced_class = role.dst.valid_class_name
        if (role.upper == 1)
            Member (name, variable, false, comment, true, role.card, role.mate.card, "String", "null", "", referenced_class)
        else
            Member (name, variable, false, comment, true, role.card, role.mate.card, "List[String]", "null", "", referenced_class)
    }

    def asText (pkg: Package): String =
    {
        val case_classes = parser.classesFor (pkg)
        val p = new StringBuilder ()
        for (cls <- case_classes)
        {
            val name = cls.valid_class_name
            val identified_object = name == "IdentifiedObject" // special handling for IdentifiedObject.mRID
            implicit val ordering: Ordering[Member] = new Ordering[Member]
            {
                def unquote (variable: String): String = if ('`' == variable.charAt (0)) variable.substring (1, variable.length - 1) else variable
                def compare (a: Member, b: Member): Int =
                    if (a.name == "sup")
                        -1
                    else if (b.name == "sup")
                        1
                    else
                    {
                        val a_ = unquote (a.variable)
                        val b_ = unquote (b.variable)
                        if (a_.charAt (0).isLower)
                            if (b_.charAt (0).isLower)
                                a_.compareTo (b_)
                            else
                                -1
                        else
                            if (b_.charAt (0).isLower)
                                1
                            else
                                a_.compareTo (b_)
                    }
            }
            val sup = Member ("sup", "sup", true, "Reference to the superclass object.", false, "1", "", if (null != cls.sup) cls.sup.name else "BasicElement", "null", "", if (null == cls.sup) null else cls.sup.valid_class_name)
            val members: mutable.SortedSet[Member] =
                mutable.SortedSet[Member](sup) ++
                    parser.attributesFor (cls).map (details (case_classes)).toSet
                        .union (parser.rolesFor (cls).map (details).toSet)
            val fields: mutable.SortedSet[Member] = members.filter ("sup" != _.name)
            val s = new StringBuilder ()
            s.append (JavaDoc (cls.note, 0, members, pkg.name, "Package %s".format (pkg.name), pkg.notes).asText)
            s.append ("final case class ")
            s.append (name)
            s.append ("""
                |(
                |""".stripMargin)
            val initializers = new StringBuilder ()
            for (product <- members)
            {
                if (initializers.nonEmpty)
                {
                    initializers.append (", ")
                    s.append (""",
                    |""".stripMargin)
                }
                initializers.append (product.initializer)
                s.append ("""    """)
                if (product.over) s.append ("""override val """)
                s.append (product.variable)
                s.append (""": """)
                s.append (product.datatype)
                s.append (""" = """)
                s.append (product.initializer)
            }

            s.append ("""
            |)
            |extends
            |    Element
            |{
            |    /**
            |     * Return the superclass object.
            |     *
            |     * @return The typed superclass nested object.
            |     * @group Hierarchy
            |     * @groupname Hierarchy Class Hierarchy Related
            |     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
            |     */
            |    def """.stripMargin)
            if (null != cls.sup)
            {
                s.append (cls.sup.name)
                s.append (""": """)
                s.append (cls.sup.name)
                s.append (""" = sup""")
            }
            else
                s.append (""" Element: Element = sup.asInstanceOf[Element]""")
            s.append ("""
            |    //
            |    // Row overrides
            |    //
            |
            |    /**
            |     * Return a copy of this object as a Row.
            |     *
            |     * Creates a clone of this object for use in Row manipulations.
            |     *
            |     * @return The copy of the object.
            |     * @group Row
            |     * @groupname Row SQL Row Implementation
            |     * @groupdesc Row Members related to implementing the SQL Row interface
            |     */
            |    override def copy (): Row = { clone ().asInstanceOf[Row] }""".stripMargin)
            s.append ("""
            |    override def export_fields: String =
            |    {
            |""".stripMargin.format (name))
            if (fields.exists (_.name != "sup"))
            {
                s.append ("""        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
                    |        implicit val clz: String = %s.cls
                    |""".stripMargin.format (name))
                if (fields.exists (!_.reference))
                    s.append ("        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (%s.fields (position), value)\n".format (name))
                if (fields.exists (x => x.reference && !x.multiple))
                    s.append ("        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (%s.fields (position), value)\n".format (name))
                if (fields.exists (_.multiple))
                    s.append ("        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (%s.fields (position), x))\n".format (name))
                s.append (fields.iterator.zipWithIndex.map (x => { val emit = if (x._1.multiple) "emitattrs" else if (x._1.reference) "emitattr" else "emitelem"; s"$emit (${x._2}, ${x._1.variable})" }).mkString ("        ", "\n        ", "\n"))
                s.append ("        s.toString\n")
            }
            else
                s.append ("        sup.export_fields\n")
            s.append ("""    }
                |    override def export: String =
                |    {
                |        "\t<cim:%s rdf:ID=\"%s\">\n%s\t</cim:%s>".format (id, export_fields)
                |    }
                |}
                |""".stripMargin.format (cls.name, "%s", "%s", cls.name))
            s.append ("""
                |object %s
                |extends
                |    Parseable[%s]
                |{
                |""".stripMargin.format (name, name))

            val any = members.exists (_.name != "sup")
            if (any)
            {
                // output the fields map
                s.append (fields.iterator.map (x => "\"%s\"".format (x.name)).mkString ("    override val fields: Array[String] = Array[String] (\n        ", ",\n        ", "\n    )\n"))

                // output the relations list
                val relationships = members.filter (member => (member.name != "sup") && (null != member.referenced_class))
                if (relationships.nonEmpty)
                    s.append (relationships.iterator.map (
                        member => """        Relationship ("%s", "%s", "%s", "%s")""".format (member.variable, member.referenced_class, member.this_cardinality, member.mate_cardinality)).mkString ("    override val relations: List[Relationship] = List (\n", ",\n", "\n    )\n"))

                // output the field parsers
                def pa (m: Member): String =
                {
                    if (m.reference)
                        if (m.multiple)
                            "parse_attributes (attribute"
                        else
                            "parse_attribute (attribute"
                    else
                        "parse_element (element"
                }
                s.append (fields.iterator.zipWithIndex.map (x => { val fielder = if (x._1.multiple) "FielderMultiple" else "Fielder"; s"val ${x._1.variable}: $fielder = ${pa (x._1)} (cls, fields(${x._2})))" }).mkString ("    ", "\n    ", "\n"))
            }
            // output the parse method
            s.append ("""
            |    def parse (context: Context): %s =
            |    {
            |""".stripMargin.format (name))
            if (any)
            {
                s.append ("        implicit val ctx: Context = context\n")
                val initializer = (for (_ <- 0 until 1 + (fields.size / 32)) yield "0").mkString (",")
                s.append ("        implicit val bitfields: Array[Int] = Array(%s)\n".format (initializer))
            }
            if (identified_object)
                s.append ("        val base = BasicElement.parse (context)\n")
            s.append ("        val ret = %s (\n".format (name))
            // add field parser calls
            def wrap (members: Iterator[(Member, String)]): String =
                members.map (x => if (x._1.function != "") s"${x._1.function} (${x._2})" else x._2).mkString ("            ", ",\n            ", "\n")
            def masker (x: (Member, Int)): String =
            {
                val mask = if (x._1.multiple) "masks" else "mask"
                s"$mask (${x._1.variable} (), ${x._2 - 1})"
            }
            s.append (
                if (identified_object)
                    wrap (members.iterator.zipWithIndex.map (x => (x._1, if (x._1.name == "sup") "base" else if (x._1.name == "mRID") s"{val _ = ${masker (x)}; base.id}" else masker (x) )))
                else
                    wrap (members.iterator.zipWithIndex.map (x => (x._1, if (x._1.name == "sup") s"${x._1.datatype}.parse (context)" else masker (x))))
            )
            s.append ("        )\n")
            if (any)
                s.append ("        ret.bitfields = bitfields\n")
            s.append ("        ret\n    }\n")
            s.append ("""}
                |
                |""".stripMargin)

            p.append (s)
        }

        if (case_classes.nonEmpty)
        {
            val v = new StringBuilder ()

            v.append ("""package ch.ninecode.model
            |
            |import org.apache.spark.sql.Row
            |
            |import ch.ninecode.cim.ClassInfo
            |import ch.ninecode.cim.Context
            |import ch.ninecode.cim.Parseable
            |import ch.ninecode.cim.Relationship
            |
            |""".stripMargin)
            v.append (p.toString)

            v.append ("""private[ninecode] object """)
            v.append (register (pkg))
            v.append ("""
                |{
                |    def register: List[ClassInfo] =
                |    {
                |""".stripMargin)
            v.append (case_classes.map (cls => s"${cls.valid_class_name}.register").mkString ("        List (\n            ", ",\n            ", "\n        )"))
            v.append ("""
                |    }
                |}""".stripMargin)

            v.toString
        }
        else
            ""
    }

    def generate (): Unit =
    {
        new File ("%s/model".format (options.directory)).mkdirs
        val sc = Scala (parser, options)

        val packages = scala.collection.mutable.SortedSet[(String, Int)]()
        for (pkg <- parser.packages)
        {
            packages.add ((sc.register (pkg._2), pkg._1))
        }
        val register = new StringBuilder ()
        register.append ("""    lazy val classes: List[ClassInfo] =
                           |        List (
                           |""".stripMargin)
        var registers: List[String] = List[String]()
        val pkg_doc = new StringBuilder ()
        pkg_doc.append (
            """package ch.ninecode
              |
              |/**
              | * ==Overview==
              | * Provides Common Information Model (CIM) classes for electrical, topological, asset, spatial
              | * and other categories of objects that are germane to electric network operations.
              | *
              | * Some examples are shown in the following image:
              | *
              | * <img src="https://cdn.jsdelivr.net/gh/derrickoswald/CIMSparkPresentation@master/img/information.svg" width="700">
              | *
              | * These classes are the types of, and objects contained in, the RDD that are created by the CIMReader,
              | * e.g. RDD[Switch].
              | *
              | * Classes are nested according to the hierarchical package structure found in CIM.
              | *
              | * Each class has the reference to its parent class, available as the generic <code>sup</code> field,
              | * and also as a typed reference of the same name as the parent class.
              | *
              | * This is illustrated in the following image, where the object with id TE1932 (a Switch) is found in
              | * RDD[Switch] and all RDD for which the relation 'a Switch "Is A" <em>X</em>' holds,
              | * e.g. RDD[ConductingEquipment]:
              | *
              | * <img src="https://cdn.jsdelivr.net/gh/derrickoswald/CIMSparkPresentation@master/img/nested.svg" width="700">
              | *
              | * The packages and their descriptions are itemized below.
              | *
              | * A short summary of all classes is found below that.
              | * The classes can be ordered by package (Grouped) or alphabetically.
              | * The classes are also listed in the panel on the left for easy reference.
              |""".stripMargin)
        var package_docs: List[String] = List[String]()
        for (q <- packages)
        {
            val pkg = parser.packages (q._2)
            val s = sc.asText (pkg)
            if (s.trim != "")
            {
                val file = "%s/model/%s.scala".format (options.directory, pkg.name)
                log.info (file)
                Files.write (Paths.get (file), s.getBytes (StandardCharsets.UTF_8))
                registers = registers :+ """            %s.register""".format (sc.register (pkg))
                package_docs = package_docs :+ " *"
                package_docs = package_docs :+ s" * ===${pkg.name}==="
                package_docs = package_docs :+ JavaDoc (pkg.notes, 0).contents
            }
            else
                log.debug ("no text generated for package %s (%s)".format (pkg.xuid, pkg.name))
        }
        register.append (registers.mkString (",\n"))
        register.append ("""
                           |        ).flatten
                           |""".stripMargin)
        Files.write (Paths.get ("%s/chim_register.scala".format (options.directory)), register.toString.getBytes (StandardCharsets.UTF_8))
        pkg_doc.append (package_docs.mkString ("\n"))
        pkg_doc.append ("""
                         | */
                         |package object model
                         |{
                         |}
                         |""".stripMargin)
        Files.write (Paths.get ("%s/model/package.scala".format (options.directory)), pkg_doc.toString.getBytes (StandardCharsets.UTF_8))
    }
}
