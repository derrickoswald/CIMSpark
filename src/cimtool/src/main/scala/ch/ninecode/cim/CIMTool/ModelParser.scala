package ch.ninecode.cim.CIMTool

import java.io.File
import java.nio.file.{Files, Paths}
import java.nio.charset.StandardCharsets

import com.healthmarketscience.jackcess.Database
import com.healthmarketscience.jackcess.DatabaseBuilder
import com.healthmarketscience.jackcess.Table

import scala.collection.mutable

case class ModelParser (db: Database)
{
    val packages: mutable.Map[Int, Package] = mutable.Map[Int,Package]()
    val classes: mutable.Map[Int, Class] = mutable.Map[Int,Class]()
    val attributes: mutable.Map[Int, List[Attribute]] = mutable.Map[Int,List[Attribute]]()
    val roles: mutable.Set[Role] = mutable.Set[Role]()
    val domains: mutable.Set[Domain] = mutable.Set[Domain]()

    lazy val getPackageTable: Table = db.getTable ("t_package")
    lazy val getObjectTable: Table = db.getTable ("t_object")
    lazy val getConnectorTable: Table = db.getTable ("t_connector")
    lazy val getAttributeTable: Table = db.getTable ("t_attribute")
    lazy val globalPackage: Package = packages.find (_._2.global) match { case Some (p) => p._2 case _ => null }

    def gatherPackageIDs (): Unit =
    {
        val it = getPackageTable.iterator ()
        while (it.hasNext)
        {
            val row = Row (it.next ())
            val global = row.getName.equals ("Model")
            val pkg = Package (row.getXUID, row.getName, global, row.getNotes)
            packages.put (row.getPackageID, pkg)
        }
    }

    def extractPackages (): Unit =
    {
        val it = getPackageTable.iterator ()
        while (it.hasNext)
        {
            val row = Row (it.next ())
            val pkg = packages(row.getPackageID)
            if (!pkg.global)
                pkg.parent = packages.getOrElse (row.getParentID, globalPackage)
        }
    }

    def extractClasses (): Unit =
    {
        val it = getObjectTable.iterator ()
        while (it.hasNext)
        {
            val row = Row (it.next ())
            if (row.getObjectType.equals ("Class") || row.getObjectType.equals ("Enumeration"))
            {
                val pkg = packages.getOrElse (row.getPackageID, globalPackage)
                val stereotype = if (row.hasStereotype) row.getStereotype else null
                val cls = Class (row.getXUID, row.getName, row.getNote, pkg, stereotype)
                classes.put (row.getObjectID, cls)
            }
        }
    }

    def extractAttributes (): Unit =
    {
        val it = getAttributeTable.iterator ()
        while (it.hasNext)
        {
            val row = Row (it.next ())
            val cls_id = row.getObjectID
            val cls = classes.getOrElse (cls_id, null)
            if (null != cls)
            {
                val classifier = if (row.hasClassifier) classes.getOrElse (row.getClassifier, null) else null
                val dflt = if (row.hasDefault) row.getDefault else null
                val attribute = Attribute (row.getXUID, row.getName, cls.pkg, cls, row.getNotes, row.getType, classifier, dflt)
                if (attributes.contains (cls_id))
                    attributes.put (cls_id, attributes(cls_id) :+ attribute)
                else
                    attributes.put (cls_id, List (attribute))
            }
            else
                System.out.println("Could not find the domain of attribute " + row.getName + ". Domain ID = " + cls_id)
        }
    }

    def extractAssociations (): Unit =
    {
        val it = getConnectorTable.iterator ()
        while (it.hasNext)
        {
            val row = Row (it.next ())
            val typ = row.getConnectorType
            if (typ.equals ("Generalization") || typ.equals ("Association") || typ.equals ("Aggregation"))
            {
                val src = classes.getOrElse (row.getStartObjectID, null)
                val dst = classes.getOrElse (row.getEndObjectID, null)
                if ((null != src) && (null != dst))
                {
                    if (typ.equals ("Generalization"))
                        src.sup  = dst
                    else
                    {
                        val rolea = Role (row.getXUID, row.getDestRole, src, dst, row.getDestRoleNote, row.getDestCard, row.getDestIsAggregate, sideA = true)
                        val roleb = Role (row.getXUID, row.getSourceRole, dst, src, row.getSourceRoleNote, row.getSourceCard, row.getSourceIsAggregate, sideA = false)
                        rolea.mate = roleb
                        roleb.mate = rolea
                        roles.add (rolea)
                        roles.add (roleb)
                    }
                }
            }
        }
    }

    def extractDomains (): Unit =
    {
        packages.find (p => p._2.name == "Domain" || p._2.name == "DomainProfile") match
        {
            case Some (pkg) =>
                val it = getObjectTable.iterator ()
                while (it.hasNext)
                {
                    val row = Row (it.next ())
                    if (row.getObjectType.equals ("Class") && (row.getPackageID == pkg._1))
                    {
                        val cls_id = row.getObjectID
                        val xuid = row.getXUID
                        val name = row.getName
                        val note = row.getNote
                        val stereotype = if (row.hasStereotype) row.getStereotype else null
                        val noenum = scala.collection.immutable.Set[String]()
                        val domain = stereotype match
                        {
                            case "Primitive" =>
                                Domain (xuid, name, note, stereotype, noenum, "", "", "", "", "")
                            case "CIMDatatype" =>
                                val details = attributes(cls_id)
                                val value = details.find (_.name == "value") match { case Some(attribute) => attribute.typ case None => null }
                                val unit = details.find (_.name == "unit") match { case Some(attribute) => attribute.dflt case None => null }
                                val multiplier = details.find (_.name == "multiplier") match { case Some(attribute) => attribute.dflt case None => null }
                                val denominatorUnit = details.find (_.name == "denominatorUnit") match { case Some(attribute) => attribute.dflt case None => null }
                                val denominatorMultiplier = details.find (_.name == "denominatorMultiplier") match { case Some(attribute) => attribute.dflt case None => null }
                                Domain (xuid, name, note, stereotype, noenum, value, unit, multiplier, denominatorUnit, denominatorMultiplier)
                            case "enumeration" =>
                                val enumeration = attributes(cls_id).map (_.name).toSet
                                Domain (xuid, name, note, stereotype, enumeration, "", "", "", "", "")
                            case _ =>
                                null
                        }
                        if (null != domain)
                            domains.add (domain)
                    }
                }
            case None =>
                System.out.println("Could not find the Domain package")
        }
    }

    def showPackages (): Unit =
    {
        for (pkg <- packages)
            println (pkg._2)
    }

    def showClasses (): Unit =
    {
        for (cls <- classes)
            println (cls._2)
    }

    def showAttributes (): Unit =
    {
        for (class_attributes <- attributes)
            for (attribute <- class_attributes._2)
                println (attribute)
    }

    def showRoles (): Unit =
    {
        for (role <- roles)
            println (role)
    }

    def run (): Unit =
    {
        gatherPackageIDs ()
        extractPackages ()
        extractClasses ()
        extractAttributes ()
        extractAssociations ()
        extractDomains ()
    }
}

object ModelParser
{
    val VERSION = "16"
    val SCALA = true

    def main(args : Array[String])
    {
        val file = VERSION match
        {
            case "14" => "iec61970cim14v15_iec61968cim10v31_combined.eap"
            case "15" => "iec61970cim15v33_iec61968cim11v13_iec62325cim01v07.eap"
            case "16" => "iec61970cim16v29a_iec61968cim12v08_iec62325cim03v01a.eap"
            case "ENTSOE" => "ENTSOE_CGMES_v2.4.15_7Aug2014.eap"
            case "17" => "iec61970cim17v22_iec61968cim13v11_iec62325cim03v14.eap"
        }

        val parser = ModelParser (DatabaseBuilder.open (new File ("private_data/" + file)))
        parser.run ()
//        println ("Packages: " + parser.packages.size)
//        parser.showPackages
//        println ("Classes: " + parser.classes.size)
//        parser.showClasses
//        println ("Attributes: " + parser.attributes.map (_._2.size).sum)
//        parser.showAttributes
//        println ("Roles: " + parser.roles.size)
//        parser.showRoles

        val dir = new File ("target/model/")
        dir.mkdir
        if (SCALA)
        {
            val packages = mutable.SortedSet[(String, Int)]()
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
                  | * <img src="https://rawgit.com/derrickoswald/CIMSparkPresentation/master/img/information.svg" width="700">
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
                  | * <img src="https://rawgit.com/derrickoswald/CIMSparkPresentation/master/img/nested.svg" width="700">
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
            for (pkg <- parser.packages)
            {
                val p = pkg._2
                val js = JavaScript (parser, p)
                val s = js.asText ()
                if (s.trim != "")
                {
                    files.add (p.name)
                    println ("target/model/" + p.name + ".js:")
                    Files.write (Paths.get ("target/model/" + p.name + ".js"), s.getBytes (StandardCharsets.UTF_8))
                }
            }
            val decl = """    ["model/base", """"  + files.map ("""model/""" + _).mkString ("""", """") + """"],"""
            val fn = """    function (base, """ + files.mkString (""", """) + """)"""
            Files.write (Paths.get ("target/cim_header.js"), (decl + "\n" + fn).getBytes (StandardCharsets.UTF_8))
        }
    }
}
