package ch.ninecode.cim

import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import ch.ninecode.model._

/**
 * Handle normalization.
 *
 * For each element with a 1:N relation, ensure the N referece the 1 and not vice versa.
 *
 * @param spark   The Spark session this class is running in.
 * @param storage The storage level to cache the resultant RDD.
 */
class CIMNormalize (spark: SparkSession, storage: StorageLevel = StorageLevel.MEMORY_AND_DISK_SER)
    extends
        CIMRDD
        with
        Serializable
{
    implicit val session: SparkSession = spark
    implicit val level: StorageLevel = storage // for put()
    implicit val log: Logger = LoggerFactory.getLogger (getClass)

    /**
     * Retrieve a (static) companion object.
     *
     * @param name the class name of the object with the companion to get
     * @param man  the type information for the object
     * @tparam T the trait of the companion object (what to cast it to)
     * @return the companion object as type T
     */
    def companion[T] (name: String)(implicit man: Manifest[T]): T =
        Class.forName (s"${name}$$").getField ("MODULE$").get (man.runtimeClass).asInstanceOf [T]

    /**
     * A denormalized relation to be fixed.
     *
     * @param parent       the id of the object containing the denormalized list
     * @param parent_class the class of the denormalized object
     * @param relationship the relationship (from the static list in the companion object of the class or superclass with the 1:N relation)
     * @param referred     the list of N element id that need to be fixed
     */
    case class Relation (parent: String, parent_class: String, relationship: CIMRelationship, referred: List[String])

    /**
     * Identify objects that are broken.
     *
     * @param arg the id and element to check for denormalized relation
     * @return a list of denormalized 1:N relations
     */
    def get_denormalized (arg: (String, Element)): List[Relation] =
    {
        var ret = List [Relation]()

        val id = arg._1
        val element = arg._2

        var clz = element
        val parent = element.getClass.getName
        val parent_class = parent.substring (parent.lastIndexOf (".") + 1)
        while (null != clz)
        {
            val name = clz.getClass.getName
            val relationships = companion [CIMParser](name).relations
            val fields = companion [CIMParser](name).fields
            val onesies = relationships.filter (_.heavyside)
            onesies.foreach (relationship =>
            {
                val list = clz.get (fields.indexOf (relationship.field) + 1).asInstanceOf [List[String]]
                if (null != list && list.nonEmpty) // could also check bitfields instead of checking for null
                    ret = ret :+ Relation (id, parent_class, relationship, list)
            }
            )
            clz = clz.sup
        }

        ret
    }

    /**
     * Create a new Element with the (possibly child) class's field set to value.
     *
     * Recursively hunts for <code>child</code> class in the hierarchical <code>element</code>
     * and sets its <code>field</code> to <code>value</code>.
     *
     * @param element the element to copy with the changed field
     * @param child   the name of the class with the field
     * @param field   the field to set
     * @param value   the value to set the field to
     * @param setbit  if <code>true</code> set the bitfield of the field, else clear it
     * @return the new (cloned) element with the field set
     */
    def set (element: Element, child: String, field: String, value: String, setbit: Boolean = true): Element =
    {
        val fields = (for (i <- 0 until element.length) yield element.get (i)).toArray // current field data
        val clz = element.getClass
        val class_name = clz.getName
        val bitfields = element.bitfields.clone ()
        if (child == class_name.substring (class_name.lastIndexOf (".") + 1)) // e.g. ACLineSegment
        {
            val field_names = companion [CIMParser](class_name).fields
            val index = field_names.indexOf (field)
            if (-1 != index)
            {
                log.debug ("%s:%s.%s = %s".format (child, element.id, field, if (null == value) "null" else value.toString))
                fields (index + 1) = value
                bitfields (index / 32) = if (setbit)
                    bitfields (index / 32) | (1 << (index % 32))
                else
                    bitfields (index / 32) & ~(1 << (index % 32))
            }
            else
                log.error ("field %s not found in class %s, value cannot be set".format (field, class_name))
        }
        else
            fields (0) = set (element.sup, child, field, value)
        val c = clz.getConstructors.filter (_.getParameterCount == fields.length).head
        val obj = c.newInstance (fields: _*)
        val new_element = obj.asInstanceOf [Element]
        new_element.bitfields = bitfields
        new_element
    }

    /**
     * Remove the denormalized fields given by the relations.
     *
     * @param arg the id and a tuple of the original element and the relations to remove
     * @return a tuple of the id and a new (fixed) element
     */
    def remove (arg: (String, (Element, Iterable[Relation]))): (String, Element) =
    {
        val id = arg._1
        val element = arg._2._1
        val relations = arg._2._2

        val new_element = relations.foldLeft (element)((element, relation) => set (element, relation.parent_class, relation.relationship.field, null, false))
        (id, new_element)
    }

    /**
     * Add the normalized fields given by the relation.
     *
     * @param arg the id and a tuple of the original element and the relations to add
     * @return a tuple of the id and a new (fixed) element
     */
    def add (arg: (String, (Element, Iterable[Relation]))): (String, Element) =
    {
        val id = arg._1
        val element = arg._2._1
        val relations = arg._2._2

        val new_element = relations.foldLeft (element)((element, relation) => set (element, relation.relationship.clazz, relation.parent_class, relation.parent))
        (id, new_element)
    }

    //    def replace (arg: (String, (Element, Option[Element]))): (String, Element) =
    //    {
    //        (arg._1, arg._2._2 match { case Some (element) => element case None => arg._2._1 })
    //    }

    def do_normalization (): RDD[Element] =
    {
        // get the elements RDD keyed by id
        val old_elements = getOrElse [Element]
        val elements = old_elements.keyBy (_.id)
        val all = elements.count

        // get the objects that are denormalized, i.e. contain N references in a 1:N relationship
        val relations: RDD[Relation] = elements.flatMap (get_denormalized).persist (storage)
        val bad = relations.count
        log.info ("normalizing %d of %d elements".format (bad, all))

        // get the broken objects and the relations that need deleting
        val broken: RDD[(String, Iterable[Relation])] = relations.groupBy (_.parent).persist (storage)

        // get the fixed objects
        val fixed: RDD[(String, Element)] = elements.join (broken).map (remove).persist (storage)

        // get a cleaned elements RDD, after this the denormalization is only held in the relations RDD
        // slightly slower: elements.leftOuterJoin (fixed).map (replace).persist (storage)
        val cleaned = elements.subtractByKey (fixed).union (fixed).persist (storage)

        // invert the relation
        val fixme: RDD[(String, Iterable[Relation])] = relations.flatMap (relation => relation.referred.map (id => (id, relation))).groupByKey.persist (storage)

        // get the fixed objects
        val fixed2: RDD[(String, Element)] = cleaned.join (fixme).map (add).persist (storage)

        // construct the new elements RDD
        // slightly slower: cleaned.leftOuterJoin (fixed2).map (replace).values
        val new_elements: RDD[Element] = cleaned.subtractByKey (fixed2).union (fixed2).values

        // swap the old Elements RDD for the new one
        put (new_elements, true)

        new_elements
    }
}
