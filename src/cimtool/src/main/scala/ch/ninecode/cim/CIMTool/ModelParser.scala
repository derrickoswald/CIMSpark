package ch.ninecode.cim.CIMTool

import scala.collection.mutable.Map
import scala.collection.mutable.Set

import java.io.File
import java.nio.file.{Paths, Files}
import java.nio.charset.StandardCharsets

import com.healthmarketscience.jackcess._

/**
 * CIM package.
 * @param xuid Unique identifier in the model.
 * @param name The package name.
 * @param global Flag indicating whether or not it is a global package.
 * @param notes Textual notes attached to the package.
 * @param parent The parent package if any, otherwise <code>null</code>.
 */
case class Package (
    xuid: String,
    name: String,
    global: Boolean,
    notes: String,
    var parent: Package = null)

/**
 * CIM class.
 * @param xuid Unique identifier in the model.
 * @param name The class name.
 * @param notes Textual notes attached to the class.
 * @param pkg Containing package.
 * @param stereotype UML stereotype for the class.
 */
case class Class (
    xuid: String,
    name: String,
    note: String,
    pkg: Package,
    stereotype: String,
    var sup: Class = null)

/**
 * CIM attribute for a class.
 * @param xuid Unique identifier in the model.
 * @param name The attribute name.
 * @param pkg Containing package.
 * @param cls Containing class.
 * @param notes Textual notes attached to the attribute.
 * @param classifier Domain Object class if any.
 * @param dflt The default value for the attribute.
 */
case class Attribute (
    xuid: String,
    name: String,
    pkg: Package,
    cls: Class,
    notes: String,
    classifier: Class,
    dflt: String)

/**
 * CIM relationship role.
 * @param xuid Unique identifier in the model.
 * @param name The attribute name.
 * @param src Source class.
 * @param dst Destination class.
 * @param note Textual notes attached to the relationship.
 * @param card Cardinality of the relationship.
 * @param aggregate TBD.
 * @param sideA TBD.
 * @param mate Corresponding relationship end on the other class.
 */
case class Role (
    xuid: String,
    name: String,
    src: Class,
    dst: Class,
    note: String,
    card: String,
    aggregate: Boolean,
    sideA: Boolean,
    var mate: Role = null)
{
    def upper = if (card.equals ("1") || card.endsWith ("..1")) 1 else 0
    def lower = if (card.equals ("*") || card.startsWith ("0..")) 0 else 1
    override def hashCode: Int = xuid.hashCode
    override def toString: String = "" + name + " from " + src.name + " to " + dst.name
}

case class ModelParser (db: Database)
{
    val packages = Map[Int,Package]()
    val classes = Map[Int,Class]()
    val attributes = Map[Int,List[Attribute]]()
    val roles = Set[Role]()

    def getPackageTable = db.getTable ("t_package")
    def getObjectTable = db.getTable ("t_object")
    def getConnectorTable = db.getTable ("t_connector")
    def getAttributeTable = db.getTable ("t_attribute")
    def globalPackage = packages.find (_._2.global) match { case Some (p) => p._2 case _ => null }

    def gatherPackageIDs =
    {
        val it = getPackageTable.iterator ()
        while (it.hasNext ())
        {
            val row = new Row (it.next ())
            val global = row.getName.equals ("Model")
            val pkg = Package (row.getXUID, row.getName, global, row.getNotes)
            packages.put (row.getPackageID, pkg)
        }
    }

    def extractPackages =
    {
        val it = getPackageTable.iterator ()
        while (it.hasNext ())
        {
            val row = new Row (it.next ())
            val pkg = packages(row.getPackageID)
            if (!pkg.global)
                pkg.parent = packages.getOrElse (row.getParentID, globalPackage)
        }
    }

    def extractClasses =
    {
        val it = getObjectTable.iterator ()
        while (it.hasNext ())
        {
            val row = new Row (it.next ())
            if (row.getObjectType.equals ("Class"))
            {
                val pkg = packages.getOrElse (row.getPackageID, globalPackage)
                val stereotype = if (row.hasStereotype) row.getStereotype else null
                val cls = Class (row.getXUID, row.getName, row.getNote, pkg, stereotype)
                classes.put (row.getObjectID, cls)
            }
        }
    }

    def extractAttributes
    {
        val it = getAttributeTable.iterator ()
        while (it.hasNext ())
        {
            val row = new Row (it.next ())
            val cls = classes.getOrElse (row.getObjectID, null)
            if (null != cls)
            {
                val classifier = if (row.hasClassifier) classes.getOrElse (row.getClassifier, null) else null
                val dflt = if (row.hasDefault) row.getDefault else null
                val attribute = Attribute (row.getXUID, row.getName, cls.pkg, cls, row.getNotes, classifier, dflt)
                val id = row.getObjectID
                if (attributes.contains (id))
                    attributes.put (id, attributes(id) :+ attribute)
                else
                    attributes.put (id, List (attribute))
            }
            else
                System.out.println("Could not find the domain of attribute " + row.getName + ". Domain ID = " + row.getObjectID);
        }
    }

    def extractAssociations
    {
        val it = getConnectorTable.iterator ()
        while (it.hasNext ())
        {
            val row = new Row (it.next ())
            val typ = row.getConnectorType
            if (typ.equals ("Generalization") || typ.equals ("Association"))
            {
                val src = classes.getOrElse (row.getStartObjectID, null)
                val dst = classes.getOrElse (row.getEndObjectID, null)
                if ((null != src) && (null != dst))
                {
                    if (typ.equals ("Generalization"))
                        src.sup  = dst
                    else
                    {
                        val rolea = Role (row.getXUID, row.getDestRole, src, dst, row.getDestRoleNote, row.getDestCard, row.getDestIsAggregate, true)
                        val roleb = Role (row.getXUID, row.getSourceRole, dst, src, row.getSourceRoleNote, row.getSourceCard, row.getSourceIsAggregate, false);
                        rolea.mate = roleb
                        roleb.mate = rolea
                        roles.add (rolea)
                        roles.add (roleb)
                    }
                }
            }
        }
    }

    def showPackages =
    {
        for (pkg <- packages)
            println (pkg._2)
    }

    def showClasses =
    {
        for (cls <- classes)
            println (cls._2)
    }

    def showAttributes =
    {
        for (class_attributes <- attributes)
            for (attribute <- class_attributes._2)
                println (attribute)
    }

    def showRoles =
    {
        for (role <- roles)
            println (role)
    }

    def run =
    {
        gatherPackageIDs
        extractPackages
        extractClasses
        extractAttributes
        extractAssociations
    }
}

object ModelParser
{
  
    def main(args : Array[String])
    {
        val parser = ModelParser (DatabaseBuilder.open (new File ("private_data/iec61970cim17v16_iec61968cim13v10_iec62325cim03v14.eap")))
        parser.run
        val dir = new File ("target/model/")
        dir.mkdir
        val files = scala.collection.mutable.SortedSet[String]()
        val switch_cases = new StringBuilder ()
        switch_cases.append ("""                switch (element)
            |                {
            |""".stripMargin)
        for (pkg <- parser.packages)
        {
            val p = pkg._2
            val js = JavaScript (parser, p);
            val s = js.asText ()
            if (s.trim != "")
            {
                files.add (p.name);
                for (provided <- js.parses)
                {
                    switch_cases.append ("""
                        |                    case """".stripMargin)
                    switch_cases.append (provided._1)
                    switch_cases.append ("""":
                        |                        """.stripMargin)
                    switch_cases.append (p.name)
                    switch_cases.append (".")
                    switch_cases.append (provided._2)
                    switch_cases.append (""" (subcontext, guts);
                        |                        break;
                        |""".stripMargin)
                }
                println ("target/model/" + p.name + ".js:")
                Files.write (Paths.get ("target/model/" + p.name + ".js"), s.getBytes (StandardCharsets.UTF_8))
            }
        }
        switch_cases.append ("""
            |
            |                    default:
            |                        if (context.parsed.ignored < 3)
            |                            if ("undefined" != typeof (console))
            |                                console.log ("unrecognized element type '" + result[1] + "' at line " + base.line_number (subcontext));
            |                            else
            |                                print ("unrecognized element type '" + result[1] + "' at line " + base.line_number (subcontext));
            |                        context.parsed.ignored++;
            |                        break;
            |                }
            |""".stripMargin)
        Files.write (Paths.get ("target/switch_cases.js"), switch_cases.toString.getBytes (StandardCharsets.UTF_8))
        val decl = """    ["model/base", """"  + files.map ("""model/""" + _).mkString ("""", """") + """"],"""
        val fn = """    function (base, """ + files.mkString (""", """) + """)"""
        Files.write (Paths.get ("target/cim_header.js"), (decl + "\n" + fn).getBytes (StandardCharsets.UTF_8))

//        println ("Packages: " + parser.packages.size)
//        parser.showPackages
//        println ("Classes: " + parser.classes.size)
//        parser.showClasses
//        println ("Attributes: " + parser.attributes.map (_._2.size).sum)
//        parser.showAttributes
//        println ("Roles: " + parser.roles.size)
//        parser.showRoles
    }
}
