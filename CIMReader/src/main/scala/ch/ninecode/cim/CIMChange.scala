package ch.ninecode.cim

import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import ch.ninecode.model._

/**
 * Handle applying (and eventually generating) CIM ChangeSet difference files.
 *
 * For each ChangeSet, apply the ObjectCreation, ObjectDeletion, and ObjectModification members to the model.
 *
 * @param spark   The Spark session this class is running in.
 * @param storage The storage level to cache the resultant RDD.
 */
case class CIMChange (spark: SparkSession, storage: StorageLevel = StorageLevel.MEMORY_AND_DISK_SER)
    extends
        CIMRDD
        with
        Serializable
{
    implicit val session: SparkSession = spark
    implicit val level: StorageLevel = storage // for put()
    implicit val log: Logger = LoggerFactory.getLogger(getClass)

    /**
     * Index of TargetObject field in ChangeSetMember bitmask.
     */
    lazy val targetMask: Int = ChangeSetMember.fields.indexOf("TargetObject")

    lazy val changeset_classes: Array[String] = Array(
        "ChangeSet",
        "ObjectDeletion",
        "ObjectCreation",
        "ObjectModification",
        "ObjectReverseModification"
    )
    // note delete both the ObjectDeletion element and the target object

    /**
     * Lambda function for deletion.
     *
     * @param deletion the ChangeSetMember object
     * @return a list with both keys, the deleted object and the ObjectDeletion to be deleted
     */
    def lambda (deletion: ObjectDeletion): List[(String, String)] =
    {
        List((deletion.id, ""), (deletion.ChangeSetMember.TargetObject, ""))
    }

    /**
     * Lambda function for creation.
     *
     * @param creation the ChangeSetMember object
     * @return a list with both keys, the created object and the ObjectCreation to be deleted
     */
    def lambda (creation: ObjectCreation): List[(String, Option[String])] =
    {
        // handle the case where there is no TargetObject id given, so use the PropertiesObject id
        val member = creation.ChangeSetMember
        val newid = if (0 != (member.bitfields(targetMask / 32) & (1 << (targetMask % 32))))
            creation.ChangeSetMember.TargetObject
        else
            creation.ChangeSetMember.PropertiesObject
        // return both the properties object with the new name and the ObjectCreation object with nothing
        List(
            (creation.ChangeSetMember.PropertiesObject, Some(newid)),
            (creation.id, None),
        )
    }

    /**
     * Lambda function for modification.
     *
     * @param modification the ChangeSetMember objects, pairs of the target id and
     *                     tuples of direction, ChangeSetMember id and PropertiesObject
     * @return a list with keys of the object to be modified and the ChangeSetMember objects to be deleted,
     *         and ordered values of the reverse and forward PropertiesObject to be applied
     */
    def lambda (modification: (String, Iterable[(String, String, Element)])): List[(String, Option[(Option[Element], Option[Element])])] =
    {
        val (id, members) = modification
        var reverse: Option[(String, Element)] = None
        var forward: Option[(String, Element)] = None
        for (member <- members)
            member match
            {
                case ("reverse", rev, element) => reverse = Some((rev, element))
                case ("forward", fwd, element) => forward = Some((fwd, element))
                case _ => // WTF?
            }
        List[Option[(String, Option[(Option[Element], Option[Element])])]](
            Some((id, Some((reverse.map(_._2), forward.map(_._2))))),
            reverse match
            { case Some(rev) => Some((rev._1, None))
            case _ => None
            }, // ObjectReverseModification
            reverse match
            { case Some(rev) => Some((rev._2.id, None))
            case _ => None
            }, // PropertiesObject
            forward match
            { case Some(fwd) => Some((fwd._1, None))
            case _ => None
            }, // ObjectModification
            forward match
            { case Some(fwd) => Some((fwd._2.id, None))
            case _ => None
            } // PropertiesObject
        ).flatten
    }

    /**
     * Replace lines starting with trigger by replacement text.
     *
     * @param text        the array to edit
     * @param trigger     the trigger string
     * @param replacement the entire line of replacement text for lines starting with trigger
     */
    def edit (text: Array[String], trigger: String, replacement: String): Unit =
    {
        for (i <- text.indices)
            if (text(i).startsWith(trigger))
                text(i) = replacement
    }

    /**
     * Convert text back into a CIM element.
     *
     * @param text    the composite text object
     * @param default a default element if something goes wrong in parsing the text
     * @return the new CIM element
     */
    def parse (text: String, default: Element): Element =
    {
        val chim = new CHIM(xml = text, start = 0, finish = text.length)
        if (chim.parse_one())
            chim.value
        else
        {
            log.error(chim.context.errors.mkString("\n"))
            default
        }
    }

    /**
     * Change the id of an element.
     *
     * @param element the element to rename
     * @param new_id  the new mRID
     * @return the renamed element
     */
    def rename (element: Element, new_id: String): Element =
    {
        val cls = element.baseclass
        val text = element.`export`.split("\n")
        edit(text, s"""	<cim:$cls rdf:%s="%s">""", s"""	<cim:$cls rdf:ID="$new_id">""")
        edit(text, s"""		<cim:IdentifiedObject.mRID>""", s"""		<cim:IdentifiedObject.mRID>$new_id</cim:IdentifiedObject.mRID>""")
        val newtext = text.mkString("\n")
        parse(newtext, element)
    }

    /**
     * Extract the part of a CIM text object before the first space.
     *
     * @param string the CIM text line
     * @return the first part of the line
     */
    def toTrigger (string: String): String =
    {
        val parts = string.split(" ")
        parts(0)
    }

    /**
     * Remove properties from an element.
     *
     * @param element    the element to remove properties from
     * @param properties the element with the properties to remove from element
     * @return the modified element
     */
    def remove (element: Element, properties: Element): Element =
    {
        val text = element.`export`.split("\n")
        val removals = properties.`export`.split("\n")
        val triggers = removals.slice(1, removals.length - 1).map(toTrigger)
        val updated = for (i <- text.indices; if triggers.forall(x => !text(i).startsWith(x)))
            yield text(i)
        val newtext = updated.mkString("\n")
        parse(newtext, element)
    }

    /**
     * Append properties to an element.
     *
     * @param element    the element to add properties to
     * @param properties the element with the properties to add to element
     * @return the modified element
     */
    def append (element: Element, properties: Element): Element =
    {
        val text = element.`export`.split("\n")
        val added = properties.`export`.split("\n")
        val additions = added.slice(1, added.length - 1)
        val newtext = Array.concat(text.slice(0, text.length - 1), additions, Array(text(text.length - 1))).mkString("\n")
        parse(newtext, element)
    }

    def insert (arg: (Element, Option[Option[String]])): Option[Element] =
    {
        val (element, newid) = arg
        newid match
        {
            case Some(idmaybe) =>
                idmaybe match
                {
                    case Some(id) =>
                        if (id != element.id) // does the id need to change?
                            Some(rename(element, id)) // change the PropertiesObject mRID
                        else
                            Some(element) // use the PropertiesObject as is
                    case None =>
                        None // delete the ObjectCreation element
                }
            case None =>
                Some(element) // keep old elements that have nothing to do with the creation
        }
    }

    def update (arg: (Element, Option[Option[(Option[Element], Option[Element])]])): Option[Element] =
    {
        val (element, todo) = arg
        todo match
        {
            case Some(editmaybe) =>
                editmaybe match
                {
                    case Some((reverse, forward)) =>
                        var e = element
                        reverse match
                        {
                            case Some(properties) =>
                                e = remove(e, properties)
                            case None =>
                        }
                        forward match
                        {
                            case Some(properties) =>
                                e = append(e, properties)
                            case None =>
                        }
                        Some(e)
                    case None =>
                        None // delete the ObjectModification and ObjectReverseModification elements
                }
            case None =>
                Some(element) // keep old elements that have no changes
        }
    }

    case class ChangeSetMap (
        changesets: RDD[ChangeSet],
        deletions: RDD[ObjectDeletion],
        additions: RDD[ObjectCreation],
        modifications: RDD[ObjectModification],
        reversemodifications: RDD[ObjectReverseModification]
    )

    def getChangeSets (changes: RDD[Element]): ChangeSetMap =
    {
        var changesets: RDD[ChangeSet] = null
        var deletions: RDD[ObjectDeletion] = null
        var additions: RDD[ObjectCreation] = null
        var modifications: RDD[ObjectModification] = null
        var reversemodifications: RDD[ObjectReverseModification] = null

        def splitter (subsetter: CIMSubsetter[_]): Unit =
        {
            subsetter.cls match
            {
                case "ChangeSet" => changesets = changes.flatMap(x => subsetter.asThisClass(x).asInstanceOf[Option[ChangeSet]])
                case "ObjectDeletion" => deletions = changes.flatMap(x => subsetter.asThisClass(x).asInstanceOf[Option[ObjectDeletion]])
                case "ObjectCreation" => additions = changes.flatMap(x => subsetter.asThisClass(x).asInstanceOf[Option[ObjectCreation]])
                case "ObjectModification" => modifications = changes.flatMap(x => subsetter.asThisClass(x).asInstanceOf[Option[ObjectModification]])
                case "ObjectReverseModification" => reversemodifications = changes.flatMap(x => subsetter.asThisClass(x).asInstanceOf[Option[ObjectReverseModification]])
                case _ =>
            }
        }

        CHIM.apply_to_all_classes(splitter)
        ChangeSetMap(changesets, deletions, additions, modifications, reversemodifications)
    }

    def apply_changes: RDD[Element] =
    {
        // get the elements RDD
        var elements = getOrElse[Element]

        // get the ChangeSet(s)
        val changes = elements.filter(x => changeset_classes.contains(x.baseclass)) // reduce the work as much as possible
        val map: ChangeSetMap = getChangeSets(changes)

        val changesets = map.changesets.collect
        for (changeset <- changesets)
        {
            val id = changeset.id
            val name = changeset.DataSet.name
            val description = changeset.DataSet.description
            log.info(s"""applying changeset $id, name: "$name" description: "$description"""")

            // delete the ChangeSet object too
            val csrdd = spark.sparkContext.parallelize(Seq((id, "")))

            // process deletions
            val del = map.deletions.filter(_.ChangeSetMember.Changeset == id)
            val doomed = csrdd.union(del.flatMap(lambda))
            elements = elements.keyBy(_.id).subtractByKey(doomed).values

            // process additions
            val add = map.additions.filter(_.ChangeSetMember.Changeset == id)
            val pairs = add.flatMap(lambda)
            elements = elements.keyBy(_.id).leftOuterJoin(pairs).values.flatMap(insert)

            // process modifications
            val revs = map.reversemodifications.filter(_.ChangeSetMember.Changeset == id)
            val mods = map.modifications.filter(_.ChangeSetMember.Changeset == id)
            val revsplus = elements.keyBy(_.id).join(revs.keyBy(_.ChangeSetMember.PropertiesObject)).values.map(_.swap)
            val modsplus = elements.keyBy(_.id).join(mods.keyBy(_.ChangeSetMember.PropertiesObject)).values.map(_.swap)
            // we may have modifications with only reverse or only forward components
            val revspluskeyed = revsplus.map(x => (x._1.ChangeSetMember.TargetObject, ("reverse", x._1.id, x._2)))
            val modspluskeyed = modsplus.map(x => (x._1.ChangeSetMember.TargetObject, ("forward", x._1.id, x._2)))
            val deltas = modspluskeyed.union(revspluskeyed).groupByKey.flatMap(lambda)
            elements = elements.keyBy(_.id).leftOuterJoin(deltas).values.flatMap(update)
            // swap the old Elements RDD for the new one
            put (elements, false)
        }

        elements
    }
}