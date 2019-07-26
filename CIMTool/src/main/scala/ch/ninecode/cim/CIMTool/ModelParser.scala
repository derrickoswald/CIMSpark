package ch.ninecode.cim.CIMTool

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.StandardCharsets

import scala.collection.JavaConversions._
import scala.collection.SortedSet

import com.healthmarketscience.jackcess.Database
import com.healthmarketscience.jackcess.DatabaseBuilder
import com.healthmarketscience.jackcess.Table

case class ModelParser (db: Database)
{
    type ID = Int

    lazy val getPackageTable: Table =   db.getTable ("t_package")
    lazy val getObjectTable: Table =    db.getTable ("t_object")
    lazy val getConnectorTable: Table = db.getTable ("t_connector")
    lazy val getAttributeTable: Table = db.getTable ("t_attribute")

    lazy val packages: Map[ID, Package] = extractPackages
    lazy val classes: Map[ID, Class] = extractClasses
    lazy val attributes: Map[ID, List[Attribute]] = extractAttributes
    lazy val roles: Set[Role] = extractAssociations
    lazy val domains: Set[Domain] = extractDomains

    lazy val globalPackage: Package = packages.values.find (_.global).orNull

    def extractPackages: Map[ID, Package] =
    {
        val packs = getPackageTable
            .iterator
            .map (Row (_))
            .map (row ⇒ (row.getPackageID, (row.getParentID, new Package (row))))
            .toMap

        // adjust parent values
        val global = packs.values.map (_._2).find (_.global).orNull
        packs.mapValues (
            row ⇒
            {
                val (parent, pkg) = row
                if (pkg.global)
                    pkg
                else
                    pkg.copy (parent = packs.getOrElse (parent, (0, global))._2)
            }
        )
    }

    def extractClasses: Map[ID, Class] =
    {
        val skip = Array ("Boundary", "Note", "Package", "Text", "Object", "Constraint")
        val clses = getObjectTable
            .iterator
            .map (Row (_))
            .filter (row ⇒ !skip.contains (row.getObjectType))
            .map (row ⇒ (row.getObjectID, row))
            .toMap
            .mapValues (
                row ⇒
                {
                    val pkg = packages.getOrElse (row.getPackageID, globalPackage)
                    val typ = row.getObjectType
                    if (!typ.equals ("Class") && !typ.equals ("Enumeration"))
                        throw new Exception ("pkg: %s name: %s unhandled type: %s".format (pkg.name, row.getName, typ))
                    new Class (row, pkg)
                }
            )

        // get a map of superclass id values
        val supers = (
            for (
                row ← getConnectorTable.iterator.map (Row (_));
                typ = row.getConnectorType
                if typ.equals ("Generalization")
            )
                yield (row.getStartObjectID, row.getEndObjectID)
            ).toMap

        // adjust superclasses
        for ((id, cls) ← clses)
            yield
                if (supers.contains (id))
                    (id, cls.copy (sup = clses.getOrElse (supers(id), null)))
                else
                    (id, cls)
    }

    def extractAttributes: Map[ID,List[Attribute]] =
    {
        val ret = scala.collection.mutable.Map[ID,List[Attribute]] ()

        for (
            row ← getAttributeTable.iterator.map (Row (_));
            cls_id = row.getObjectID;
            cls = classes.getOrElse (cls_id, null)
        )
            if (null != cls)
            {
                val attribute = Attribute (
                    row.getXUID,
                    row.getName,
                    cls.pkg,
                    cls,
                    row.getNotes,
                    row.getType,
                    if (row.hasClassifier) classes.getOrElse (row.getClassifier, null) else null,
                    if (row.hasDefault) row.getDefault else null)
                if (ret.contains (cls_id))
                    ret.put (cls_id, ret(cls_id) :+ attribute)
                else
                    ret.put (cls_id, List (attribute))
            }
            else
                println("Could not find the domain of attribute " + row.getName + ". Domain ID = " + cls_id)

        ret.toMap
    }

    def extractAssociations: Set[Role] =
    {
        val ret = scala.collection.mutable.Set[Role] ()
        for (
            row ← getConnectorTable.iterator.map (Row (_));
            typ = row.getConnectorType
            if typ.equals ("Association") || typ.equals ("Aggregation");
            src = classes.getOrElse (row.getStartObjectID, null);
            dst = classes.getOrElse (row.getEndObjectID, null)
            if (null != src) && (null != dst)
        )
            {
                val rolea = Role (row.getXUID, row.getDestRole, src, dst, row.getDestRoleNote, row.getDestCard, row.getDestIsAggregate, sideA = true)
                val roleb = Role (row.getXUID, row.getSourceRole, dst, src, row.getSourceRoleNote, row.getSourceCard, row.getSourceIsAggregate, sideA = false)
                rolea.mate = roleb
                roleb.mate = rolea
                ret.add (rolea)
                ret.add (roleb)
            }
        ret.toSet
    }

    def extractDomains: Set[Domain] =
    {
        val noenum = Set[String]()
        val ret = for (
            row ← getObjectTable.iterator.map (Row (_))
            if row.getObjectType.equals ("Class");
            cls_id = row.getObjectID;
            xuid = row.getXUID;
            name = row.getName;
            note = row.getNote;
            stereotype = if (row.hasStereotype) row.getStereotype else null;
            domain = stereotype match
            {
                case "Primitive" =>
                    Domain (xuid, name, note, stereotype, packages.getOrElse (row.getPackageID, null), noenum, "")
                case "CIMDatatype" =>
                    val details = attributes(cls_id)
                    val value = details.find (_.name == "value") match { case Some(attribute) => attribute.typ case None => null }
                    Domain (xuid, name, note, stereotype, packages.getOrElse (row.getPackageID, null), noenum, value)
                case "Compound" =>
                    val details = attributes(cls_id)
                    val value = details.find (_.name == "value") match { case Some(attribute) => attribute.typ case None => null }
                    Domain (xuid, name, note, stereotype, packages.getOrElse (row.getPackageID, null), noenum, value)
                case "enumeration" =>
                    val enumeration = if (attributes.contains (cls_id)) attributes(cls_id).map (_.name).toSet else Set[String]()
                    Domain (xuid, name, note, stereotype, packages.getOrElse (row.getPackageID, null), enumeration, "")
                case _ =>
                    null
            }
            if null != domain
        )
            yield domain

        ret.toSet
    }

//    def showPackages (): Unit =
//    {
//        for (pkg ← packages)
//            println (pkg._2)
//    }
//
//    def showClasses (): Unit =
//    {
//        for (cls ← classes)
//            println (cls._2)
//    }
//
//    def showAttributes (): Unit =
//    {
//        for (class_attributes ← attributes; attribute ← class_attributes._2)
//            println (attribute)
//    }
//
//    def showRoles (): Unit =
//    {
//        for (role ← roles)
//            println (role)
//    }
//
//    def showDomains (): Unit =
//    {
//        for (domain ← domains)
//            println (domain)
//    }

    /**
     * Create a list of classes in the package.
     *
     * Eliminates primitives, datatypes and enumerations.
     *
     * @param pkg the package to get the classes for
     * @return a sorted list of classes in the package
     */
    def classesFor (pkg: Package): SortedSet[Class] =
    {
        implicit val ordering: Ordering[Class] = new Ordering[Class]
        {
            def compare (a: Class, b: Class): Int = a.name.compareTo (b.name)
        }

        def stereo (cls: Class): Boolean =
            (cls.stereotype != "enumeration") &&
            (cls.stereotype != "CIMDatatype") &&
            (cls.stereotype != "Primitive")

        SortedSet[Class](classes.values.filter (cls ⇒ cls.pkg == pkg && stereo (cls)).toSeq:_*)
    }

    def objectIdFor (cls: Class): Int = { classes.find (_._2.xuid == cls.xuid) match { case Some (c: (ID, Class)) ⇒ c._1 case _ ⇒ 0 } }
    def attributesFor (cls: Class): List[Attribute] = attributes.getOrElse (objectIdFor (cls), List[Attribute]())
    def rolesFor (cls: Class): List[Role] = roles.filter (r ⇒ r.src == cls && r.name != "").toList
}

object ModelParser
{
    val VERSION = "17"
    val SCALA = false

    def main (args : Array[String])
    {
        val file = VERSION match
        {
            case "14" => "iec61970cim14v15_iec61968cim10v31_combined.eap"
            case "15" => "iec61970cim15v33_iec61968cim11v13_iec62325cim01v07.eap"
            case "16" => "iec61970cim16v29a_iec61968cim12v08_iec62325cim03v01a.eap"
            case "ENTSOE" => "ENTSOE_CGMES_v2.4.15_7Aug2014.eap"
            case "17" => "iec61970cim17v34_iec61968cim13v12_iec62325cim03v17a.eap"
        }

        val parser = ModelParser (DatabaseBuilder.open (new File ("private_data/" + file)))

//        println ("Packages: " + parser.packages.size)
//        parser.showPackages ()
//        println ("Classes: " + parser.classes.size)
//        parser.showClasses ()
//        println ("Attributes: " + parser.attributes.map (_._2.size).sum)
//        parser.showAttributes ()
//        println ("Roles: " + parser.roles.size)
//        parser.showRoles ()
//        println ("Domains: " + parser.domains.size)
//        parser.showDomains ()
        val dir = new File ("target/model/")
        dir.mkdir
        if (SCALA)
        {
            val packages = scala.collection.mutable.SortedSet[(String, Int)]()
            for (pkg <- parser.packages)
            {
                val scala = Scala (parser, pkg._2)
                packages.add ((scala.register, pkg._1))
            }
            val register = new StringBuilder ()
            register.append ("""    def classes: List[ClassInfo] =
                |        List (
                |""".stripMargin)
            var registers: List[String] = List[String]()
            val pkgdoc = new StringBuilder ()
            pkgdoc.append (
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
                  | * The classes are alos listed in the panel on the left for easy reference.
                  |""".stripMargin)
            var package_docs: List[String] = List[String]()
            for (q <- packages)
            {
                val pkg = parser.packages (q._2)
                val scala = Scala (parser, pkg)
                val s = scala.asText ()
                if (s.trim != "")
                {
                    println ("target/model/" + pkg.name + ".scala:")
                    Files.write (Paths.get ("target/model/" + pkg.name + ".scala"), s.getBytes (StandardCharsets.UTF_8))
                    registers = registers :+ """            """ + scala.register + """.register"""
                    package_docs = package_docs :+ """ *"""
                    package_docs = package_docs :+ """ * ===""".stripMargin + pkg.name + """==="""
                    package_docs = package_docs :+ JavaDoc (pkg.notes, 0).contents
                }
            }
            register.append (registers.mkString (",\n"))
            register.append ("""
                |        ).flatten
                |""".stripMargin)
            Files.write (Paths.get ("target/chim_register.scala"), register.toString.getBytes (StandardCharsets.UTF_8))
            pkgdoc.append (package_docs.mkString ("\n"))
            pkgdoc.append ("""
                  | */
                  |package object model
                  |{
                  |}
                  |""".stripMargin)
            Files.write (Paths.get ("target/model/package.scala"), pkgdoc.toString.getBytes (StandardCharsets.UTF_8))
        }
        else
        {
            val files = scala.collection.mutable.SortedSet[String]()
            def do_package (p: Package): Unit =
            {
                val js = JavaScript (parser, p)
                val s = js.asText ()
                if (s.trim != "")
                {
                    files.add (p.name)
                    println ("target/model/" + p.name + ".js:")
                    Files.write (Paths.get ("target/model/" + p.name + ".js"), s.getBytes (StandardCharsets.UTF_8))
                }
            }
            for (pkg <- parser.packages)
            {
                val p = pkg._2
                // shenanigans to avoid the circular dependency between the Wires package and the LoadModel package
                if ("LoadModel" == p.name)
                {
                    // put all classes that don't depend on Wires in LoadModel
                    val p_no_wires = p.copy (name = "LoadModel2")
                    parser.classes.foreach (
                        cls ⇒
                            if (cls._2.pkg == p && cls._2.sup.pkg.name == "Wires")
                                cls._2.pkg = p_no_wires
                    )
                    do_package (p)
                    do_package (p_no_wires)
                }
                // shenanigans to avoid the circular dependency between the Assets package and the InfAssets package
                else if ("InfAssets" == p.name)
                {
                    // put all classes derived from Assets in InfAssets2
                    val p_sub_assets = p.copy (name = "InfAssets2")
                    parser.classes.foreach (
                        cls ⇒
                            if (cls._2.pkg == p && (null != cls._2.sup) && cls._2.sup.pkg.name == "Assets")
                                cls._2.pkg = p_sub_assets
                    )
                    do_package (p)
                    do_package (p_sub_assets)
                }
                else
                    do_package (p)
            }
            val decl = """    ["model/base", """"  + files.map ("""model/""" + _).mkString ("""", """") + """"],"""
            val fn = """    function (base, """ + files.mkString (""", """) + """)"""
            Files.write (Paths.get ("target/cim_header.js"), (decl + "\n" + fn).getBytes (StandardCharsets.UTF_8))
        }
    }
}
