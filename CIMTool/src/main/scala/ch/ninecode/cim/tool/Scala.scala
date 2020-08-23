package ch.ninecode.cim.tool

import scala.collection.mutable
import scala.collection.SortedSet

import org.slf4j.Logger
import org.slf4j.LoggerFactory

case class Scala (parser: ModelParser, options: CIMToolOptions) extends CodeGenerator
{
    val log: Logger = LoggerFactory.getLogger (getClass)

    val package_doc_header: String =
        """ * ==Overview==
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
          | * Each class has the reference to its parent class, available as the <code>sup</code> method,
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
          | * The classes are also listed in the panel on the left for easy reference.""".stripMargin

    implicit val ordering: Ordering[Member] = new Ordering[Member]
    {
        def unquote (variable: String): String = if ('`' == variable.charAt (0)) variable.substring (1, variable.length - 1) else variable

        def compare (a: Member, b: Member): Int =
            if (a.isSuper)
                -1
            else
                if (b.isSuper)
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

    def register (pkg: Package): String =
    {
        s"_${pkg.valid_class_name}"
    }

    def details (classes: SortedSet[Class])(attribute: Attribute): Member =
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
                                throw new Exception (s"""unknown primitive type "${dom.name}"""")
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
                        throw new Exception (s"""unknown Domain stereotype "${dom.stereotype}"""")
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

    def declareClass (name: String, members: SortedSet[Member]): String =
    {
        def initializers: List[String] =
        {
            for (product <- members.toList)
                yield
                    {
                        val over = if (product.over) "override val " else ""
                        s"    $over${product.variable}: ${product.datatype} = ${product.initializer}"
                    }
        }
        s"""final case class $name
           |(
           |${initializers.mkString (",\n|")}
           |)
           |extends
           |    Element""".stripMargin
    }

    def superclass (cls: Class): String =
    {
        val sup = if (null != cls.sup)
            cls.sup.name
        else
            "Element"
        s"""
           |    /**
           |     * Return the superclass object.
           |     *
           |     * @return The typed superclass nested object.
           |     * @group Hierarchy
           |     * @groupname Hierarchy Class Hierarchy Related
           |     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
           |     */
           |    override def sup: $sup = $sup""".stripMargin
    }

    def row_overrides: String =
    {
        s"""
           |
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
           |    override def copy (): Row = { clone ().asInstanceOf[Row] }
           |""".stripMargin
    }

    def exportFields (name: String, fields: SortedSet[Member]): String =
    {
        val ref = if (fields.exists (!_.reference))
            s"        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element ($name.fields (position), value)\n|"
        else
            ""
        val single = if (fields.exists (x => x.reference && !x.multiple))
            s"        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute ($name.fields (position), value)\n|"
        else
            ""
        val multiple = if (fields.exists (_.multiple))
            s"        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute ($name.fields (position), x))\n|"
        else
            ""
        val emits = fields.iterator.zipWithIndex.map (
            x =>
            {
                val (member, index) = x
                val emit = if (member.multiple)
                    "emitattrs"
                else
                    if (member.reference)
                        "emitattr"
                    else
                        "emitelem"
                s"$emit ($index, ${member.variable})"
            }
        ).mkString ("        ", "\n        ", "")
        if (fields.nonEmpty)
        {
            s"""
               |    override def export_fields: String =
               |    {
               |        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
               |        implicit val clz: String = $name.cls
               |$ref$single$multiple$emits
               |        s.toString
               |    }""".stripMargin
        }
        else
            s"""
               |    override def export_fields: String =
               |    {
               |        sup.export_fields
               |    }""".stripMargin
    }

    def export (cls: Class): String =
    {
        s"""
           |    override def export: String =
           |    {
           |        "\\t<cim:${cls.name} rdf:ID=\\"%s\\">\\n%s\\t</cim:${cls.name}>".format (id, export_fields)
           |    }""".stripMargin
    }

    def declareObject (name: String): String =
    {
        s"""
           |object $name
           |extends
           |    CIMParseable[$name]""".stripMargin
    }

    def parseRelationships (fields: SortedSet[Member]): String =
    {
        if (fields.nonEmpty)
        {
            // output the fields map
            val fieldmap = fields.iterator.map (x => s""""${x.name}"""")
                .mkString ("    override val fields: Array[String] = Array[String] (\n        ", ",\n        ", "\n    )\n")

            // output the relations list
            val references = fields.filter (member => (null != member.referenced_class))
            val relationships = if (references.nonEmpty)
                (for (r <- references.iterator) // need to use iterator here because SortedSet is brain dead
                    yield
                        s"""        CIMRelationship ("${r.variable}", "${r.referenced_class}", "${r.this_cardinality}", "${r.mate_cardinality}")"""
                    ).mkString ("    override val relations: List[CIMRelationship] = List (\n", ",\n", "\n    )\n")
            else
                ""

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

            val parsers = (for (x <- fields.iterator.zipWithIndex)
                yield
                    {
                        val (member, index) = x
                        val fielder = if (member.multiple) "FielderMultiple" else "Fielder"
                        s"val ${member.variable}: $fielder = ${pa (member)} (cls, fields(${index})))"
                    }
                ).mkString ("    ", "\n    ", "\n")
            s"$fieldmap$relationships$parsers"
        }
        else
            ""
    }

    def parse (name: String, members: SortedSet[Member]): String =
    {
        val identified_object = name == "IdentifiedObject" // special handling for IdentifiedObject.mRID
        val fields: SortedSet[Member] = members.filter (!_.isSuper)
        val boilerplate = if (fields.nonEmpty)
        {
            val initializer = (for (_ <- 0 until 1 + (fields.size / 32)) yield "0").mkString (",")
            s"""
               |        implicit val ctx: CIMContext = context
               |        implicit val bitfields: Array[Int] = Array($initializer)""".stripMargin
        }
        else
            ""
        val base = if (identified_object)
            s"""
               |        val base = BasicElement.parse (context)""".stripMargin
        else
            ""

        // add field parser calls
        def wrap (members: Iterator[(Member, String)]): String =
            members.map (x => if (x._1.function != "") s"${x._1.function} (${x._2})" else x._2).mkString ("            ", ",\n            ", "")

        def masker (x: (Member, Int)): String =
        {
            val (member, index) = x
            val mask = if (member.multiple) "masks" else "mask"
            s"$mask (${member.variable} (), ${index - 1})"
        }

        val parsers = if (identified_object)
            wrap (members.iterator.zipWithIndex.map (x => (x._1, if (x._1.isSuper) "base" else
                if (x._1.name == "mRID") s"{val _ = ${masker (x)}; base.id}" else masker (x))))
        else
            wrap (members.iterator.zipWithIndex.map (x => (x._1, if (x._1.isSuper) s"${x._1.datatype}.parse (context)" else masker (x))))

        val update = if (fields.nonEmpty)
            """
               |        ret.bitfields = bitfields"""
        else
            ""

        // output the parse method
        s"""
           |    def parse (context: CIMContext): $name =
           |    {$boilerplate$base
           |        val ret = $name (
           |$parsers
           |        )$update
           |        ret
           |    }
           |""".stripMargin
    }

    def serializer (name: String): String =
    {
        s"""
           |    def serializer: Serializer[${name}] = ${name}Serializer
           |""".stripMargin
    }

    def write (arg: (Member, Int))(implicit identified_object: Boolean): String =
    {
        val (member, _) = arg
        if (identified_object && member.name == "mRID")
            "Unit"
        else
            member.datatype match
            {
                case "String" => s"output.writeString (obj.${member.variable})"
                case "Int" => s"output.writeInt (obj.${member.variable})"
                case "Double" => s"output.writeDouble (obj.${member.variable})"
                case "Boolean" => s"output.writeBoolean (obj.${member.variable})"
                case "List[String]" => s"writeList (obj.${member.variable}, output)"
                case _ =>
                    throw new Exception (s"unhandled type ${member.datatype}")
            }
    }

    def read (arg: (Member, Int))(implicit identified_object: Boolean): String =
    {
        val (member, index) = arg
        if (identified_object && member.name == "mRID")
            "parent.mRID"
        else
        {
            val kernel = member.datatype match
            {
                case "String" => "input.readString"
                case "Int" => "input.readInt"
                case "Double" => "input.readDouble"
                case "Boolean" => "input.readBoolean"
                case "List[String]" => s"readList (input)"
                case _ =>
                    throw new Exception (s"unhandled type ${member.datatype}")
            }
            // adding "${member.variable} =" to use named parameters causes the compiler to run out of memory
            s"if (isSet ($index)) $kernel else ${member.initializer}"
        }
    }

    def serialize (cls: Class, name: String, members: SortedSet[Member]): String =
    {
        implicit val identified_object: Boolean = name == "IdentifiedObject" // special handling for IdentifiedObject.mRID
        val fields = members.filter (x => !x.isSuper).toSeq

        val writers = fields.zipWithIndex.map (write).map (w => s"            () => $w").mkString (",\n")
        val readers = (Seq ("parent") ++ fields.zipWithIndex.map (read)).map (r => s"            $r").mkString (",\n")

        // output the serializer/deserializer class
        val supser = if (null == cls.sup)
            "BasicElement"
        else
            cls.sup.name
        val supobj = if (null == cls.sup)
            "obj.sup.asInstanceOf[BasicElement]"
        else
            "obj.sup"
        s"""
           |object ${name}Serializer extends CIMSerializer[$name]
           |{
           |    def write (kryo: Kryo, output: Output, obj: $name): Unit =
           |    {
           |        val toSerialize: Array[() => Unit] = Array (
           |$writers
           |        )
           |        ${supser}Serializer.write (kryo, output, $supobj)
           |        implicit val bitfields: Array[Int] = obj.bitfields
           |        writeBitfields (output)
           |        writeFields (toSerialize)
           |    }
           |
           |    def read (kryo: Kryo, input: Input, cls: Class[$name]): $name =
           |    {
           |        val parent = ${supser}Serializer.read (kryo, input, classOf[${supser}])
           |        implicit val bitfields: Array[Int] = readBitfields (input)
           |        val obj = $name (
           |$readers
           |        )
           |        obj.bitfields = bitfields
           |        obj
           |    }
           |}
           |""".stripMargin
    }

    def asText (pkg: Package): String =
    {
        val case_classes = parser.classesFor (pkg)
        var hasRelationShip = false
        val p = new StringBuilder ()
        for (cls <- case_classes)
        {
            val name = cls.valid_class_name
            val supname = if (null == cls.sup)
                "Element"
            else
                cls.sup.name
            val supclass = Member (supname, supname, false, "Reference to the superclass object.", false, "1", "", if (null != cls.sup) cls.sup.name else "BasicElement", "null", "", if (null == cls.sup) null else cls.sup.valid_class_name, true)
            val members: mutable.SortedSet[Member] =
                mutable.SortedSet[Member](supclass) ++
                    parser.attributesFor (cls).map (details (case_classes)).toSet
                        .union (parser.rolesFor (cls).map (details).toSet)
            val fields: mutable.SortedSet[Member] = members.filter (!_.isSuper)
            hasRelationShip |= fields.exists (member => null != member.referenced_class)
            val s = new StringBuilder ()
                .append (JavaDoc (cls.note, 0, members, pkg.name, s"Package ${pkg.name}", pkg.notes).asText)
                .append (declareClass (name, members))
                .append ("\n{")
                .append (superclass (cls))
                .append (row_overrides)
                .append (exportFields (name, fields))
                .append (export (cls))
                .append ("\n}\n")
                .append (declareObject (name))
                .append ("\n{\n")
                .append (parseRelationships (fields))
                .append (parse (name, members))
                .append (serializer (name))
                .append ("}\n")
                .append (serialize (cls, name, members))
                .append ("\n")

            p.append (s)
        }

        if (case_classes.nonEmpty)
        {
            val v = new StringBuilder ()

                .append (
                    s"""package ch.ninecode.model
                       |
                       |import com.esotericsoftware.kryo.Kryo
                       |import com.esotericsoftware.kryo.Serializer
                       |import com.esotericsoftware.kryo.io.Input
                       |import com.esotericsoftware.kryo.io.Output
                       |import org.apache.spark.sql.Row
                       |
                       |import ch.ninecode.cim.CIMClassInfo
                       |import ch.ninecode.cim.CIMContext
                       |import ch.ninecode.cim.CIMParseable
                       |${if (hasRelationShip) "import ch.ninecode.cim.CIMRelationship" else ""}
                       |import ch.ninecode.cim.CIMSerializer
                       |
                       |""".stripMargin)
                .append (p.toString)
                .append ("""private[ninecode] object """)
                .append (register (pkg))
                .append (
                    """
                      |{
                      |    def register: List[CIMClassInfo] =
                      |    {
                      |""".stripMargin)
                .append (case_classes.map (cls => s"${cls.valid_class_name}.register").mkString ("        List (\n            ", ",\n            ", "\n        )"))
                .append (
                    """
                      |    }
                      |}""".stripMargin)

            v.toString
        }
        else
            ""
    }

    def writeRegistration (registers: List[String]): Unit =
    {
        val register =
            s"""    lazy val classes: List[CIMClassInfo] =
               |        List (
               |${registers.mkString (",\n")}
               |        ).flatten
               |""".stripMargin
        save (s"${options.directory}/chim_register.scala", register)
    }

    def writePackage (package_docs: List[String]): Unit =
    {
        val pkg_doc =
            s"""package ch.ninecode
               |
               |/**
               |$package_doc_header
               |${package_docs.mkString ("\n")}
               | */
               |package object model
               |{
               |}
               |""".stripMargin
        save (s"${options.directory}/model/package.scala", pkg_doc)
    }

    def generate (): Unit =
    {
        val dir = s"${options.directory}/model"
        mkdir (dir)
        val sc = Scala (parser, options)

        val packages = scala.collection.mutable.SortedSet[(String, Int)]()
        for (pkg <- parser.packages)
        {
            packages.add ((sc.register (pkg._2), pkg._1))
        }
        var registers: List[String] = List [String]()
        var package_docs: List[String] = List [String]()
        for (q <- packages)
        {
            val pkg = parser.packages (q._2)
            val s = sc.asText (pkg)
            if (s.trim != "")
            {
                val file = s"$dir/${pkg.name}.scala"
                log.info (file)
                save (file, s)
                registers = registers :+ s"""            ${sc.register (pkg)}.register"""
                package_docs = package_docs :+ " *"
                package_docs = package_docs :+ s" * ===${pkg.name}==="
                if (pkg.notes != null)
                    package_docs = package_docs :+ JavaDoc (pkg.notes, 0).contents
            }
            else
                log.debug (s"no text generated for package ${pkg.xuid} (${pkg.name})")
        }

        // write the registration code
        writeRegistration (registers)

        // write the package file
        writePackage (package_docs)
    }
}
