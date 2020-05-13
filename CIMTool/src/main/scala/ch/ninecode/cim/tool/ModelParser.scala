package ch.ninecode.cim.tool

import java.io.File
import java.nio.charset.Charset

import scala.collection.JavaConverters.asScalaIteratorConverter
import scala.collection.SortedSet

import com.healthmarketscience.jackcess.Database
import com.healthmarketscience.jackcess.DatabaseBuilder
import com.healthmarketscience.jackcess.Table

case class ModelParser (model: File)
{
    type ID = Int

    // override the normal UTF8 encoding for Windows-1252
    val db: Database = new DatabaseBuilder (model).setCharset (Charset.forName ("Windows-1252")).open ()

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
            .asScala
            .map (Row)
            .map (row => (row.getPackageID, (row.getParentID, Package (row))))
            .toMap

        // adjust parent values
        val global = packs.values.map (_._2).find (_.global).orNull
        packs.mapValues (
            row =>
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
        val classes = getObjectTable
            .iterator
            .asScala
            .map (Row)
            .filter (row => !skip.contains (row.getObjectType))
            .map (row => (row.getObjectID, row))
            .toMap
            .mapValues (
                row =>
                {
                    val pkg = packages.getOrElse (row.getPackageID, globalPackage)
                    val typ = row.getObjectType
                    if (!typ.equals ("Class") && !typ.equals ("Enumeration"))
                        throw new Exception ("pkg: %s name: %s unhandled type: %s".format (pkg.name, row.getName, typ))
                    Class (row, pkg)
                }
            )

        // get a map of superclass id values
        val supers = (
            for (
                row <- getConnectorTable.iterator.asScala.map (Row);
                typ = row.getConnectorType
                if typ.equals ("Generalization")
            )
                yield (row.getStartObjectID, row.getEndObjectID)
            ).toMap

        // adjust superclasses
        for ((id, cls) <- classes)
            yield
                if (supers.contains (id))
                    (id, cls.copy (sup = classes.getOrElse (supers(id), null)))
                else
                    (id, cls)
    }

    def extractAttributes: Map[ID,List[Attribute]] =
    {
        val ret = scala.collection.mutable.Map[ID,List[Attribute]] ()

        for (
            row <- getAttributeTable.iterator.asScala.map (Row);
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
                println (s"Could not find the domain of attribute '${row.getName}'. Domain ID = $cls_id")

        ret.toMap
    }

    def extractAssociations: Set[Role] =
    {
        val ret = for (
            row <- getConnectorTable.iterator.asScala.map (Row);
            typ = row.getConnectorType
            if typ.equals ("Association") || typ.equals ("Aggregation");
            src = classes.getOrElse (row.getStartObjectID, null);
            dst = classes.getOrElse (row.getEndObjectID, null)
            if (null != src) && (null != dst)
        )
            yield
            {
                val role_1 = Role (row.getXUID, row.getDestRole, src, dst, row.getDestRoleNote, row.getDestCard, row.getDestIsAggregate, sideA = true)
                val role_2 = Role (row.getXUID, row.getSourceRole, dst, src, row.getSourceRoleNote, row.getSourceCard, row.getSourceIsAggregate, sideA = false)
                role_1.mate = role_2
                role_2.mate = role_1
                role_1 :: role_2 :: Nil
            }

        ret.flatten.toSet
    }

    def extractDomains: Set[Domain] =
    {
        val empty = Set[String]()
        val ret = for (
            row <- getObjectTable.iterator.asScala.map (Row)
            if row.getObjectType.equals ("Class");
            cls_id = row.getObjectID;
            xuid = row.getXUID;
            name = row.getName;
            note = row.getNote;
            stereotype = if (row.hasStereotype) row.getStereotype else null;
            domain = stereotype match
            {
                case "Primitive" =>
                    Domain (xuid, name, note, stereotype, packages.getOrElse (row.getPackageID, null), empty, "")
                case "CIMDatatype" | "Compound"=>
                    val details = attributes(cls_id)
                    val value = details.find (_.name == "value") match { case Some(attribute) => attribute.typ case None => null }
                    Domain (xuid, name, note, stereotype, packages.getOrElse (row.getPackageID, null), empty, value)
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
        implicit val ordering: Ordering[Class] = (a: Class, b: Class) => a.name.compareTo (b.name)

        def stereo (cls: Class): Boolean =
            (cls.stereotype != "enumeration") &&
            (cls.stereotype != "CIMDatatype") &&
            (cls.stereotype != "Primitive")

        SortedSet[Class](classes.values.filter (cls => cls.pkg == pkg && stereo (cls)).toSeq:_*)
    }

    def objectIdFor (cls: Class): Int = { classes.find (_._2.xuid == cls.xuid) match { case Some (c: (ID, Class)) => c._1 case _ => 0 } }
    def attributesFor (cls: Class): List[Attribute] = attributes.getOrElse (objectIdFor (cls), List[Attribute]())
    def rolesFor (cls: Class): List[Role] = roles.filter (r => r.src == cls && r.name != "").toList
}
