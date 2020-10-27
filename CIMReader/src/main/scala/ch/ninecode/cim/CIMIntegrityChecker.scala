package ch.ninecode.cim

import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.SparkSession
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import scala.language.existentials

class Worker[C <: Product, P <: Product] (relation: CIMRelationship, child: String, childrdd: RDD[C], parent: String, parentrdd: RDD[P]) extends Serializable
{
    def filter_predicate[X <: Product] (obj: X): Boolean =
    {
        val cls: Class[_] = obj.getClass
        val method = cls.getDeclaredMethod(relation.field)
        method.setAccessible(true)

        null != method.invoke(obj) // null != equipment.EquipmentContainer
    }

    def foreign_key[X <: Product] (obj: X): String =
    {
        val cls: Class[_] = obj.getClass
        val method = cls.getDeclaredMethod(relation.field)
        method.setAccessible(true)

        method.invoke(obj).toString // equipment.EquipmentContainer
    }

    def foreign_keys[X <: Product] (obj: X): List[(String, X)] =
    {
        val cls: Class[_] = obj.getClass
        val method = cls.getDeclaredMethod(relation.field)
        method.setAccessible(true)

        val items = method.invoke(obj).asInstanceOf[List[String]]
        if (null != items && items.nonEmpty)
            items.map((_, obj))
        else
            List()
    }

    def primary_key[X <: Product] (obj: X): String =
    {
        val cls: Class[_] = obj.getClass
        val method = cls.getDeclaredMethod("id")
        method.setAccessible(true)

        method.invoke(obj).toString // container.id
    }

    def message (child: String, field: String, parent: String)(problem: (String, Product)): String =
    {
        val (key: String, obj: Product) = problem
        s"$child ${primary_key(obj)} field $field references $parent $key that is not present"
    }

    def run (): String =
    {
        val children: RDD[(String, C)] forSome
        {type C <: Product} =
            if (relation.multiple)
                childrdd.flatMap(foreign_keys)
            else
                childrdd.filter(filter_predicate).keyBy(foreign_key)
        val missing: RDD[(String, X)] forSome
        {type X <: Product} = if (null != parentrdd)
        {
            val parents: RDD[(String, P)] forSome
            {type P <: Product} = parentrdd.keyBy(primary_key)

            // equipment that say's it has a container but doesn't reference an existing element
            children.subtractByKey(parents)
        }
        else
            children

        missing.map(message(child, relation.field, parent)).collect.mkString("\n")
    }
}

/**
 * Check relationships in CIM data.
 *
 */
class CIMIntegrityChecker (spark: SparkSession) extends CIMRDD with Serializable
{
    implicit val session: SparkSession = spark
    implicit val log: Logger = LoggerFactory.getLogger(getClass)

    def check (classes: List[CIMClassInfo], info: CIMClassInfo)(relation: CIMRelationship): String =
    {
        // val equipment: RDD[Equipment] = getOrElse[Equipment]
        // val equipment: RDD[Equipment] = spark.sparkContext.getPersistentRDDs.filter (_._2.name == "Equipment").head._2.asInstanceOf[RDD[Equipment]]

        type childrdd = info.subsetter.rddtype
        val companion: CIMClassInfo = classes.find(_.name == relation.clazz).getOrElse(ch.ninecode.model.Unknown.register)
        type parentrdd = companion.subsetter.rddtype

        if (log.isDebugEnabled)
            log.debug(s"${info.name}.${relation.field} => ${relation.clazz}")
        spark.sparkContext.getPersistentRDDs.find(_._2.name == info.name).map(x => x._2)
            .fold("")
            {
                case rdd: childrdd =>
                    //val container: RDD[EquipmentContainer] = spark.sparkContext.getPersistentRDDs.filter (_._2.name == "EquipmentContainer").head._2.asInstanceOf[RDD[EquipmentContainer]]
                    spark.sparkContext.getPersistentRDDs.find(_._2.name == companion.name).map(x => x._2)
                        .fold(
                            // every instance is an error
                            new Worker(relation, info.name, rdd, companion.name, null).run()
                        )
                        {
                            case pcc: parentrdd =>
                                new Worker(relation, info.name, rdd, companion.name, pcc).run()
                        }
            }

    }

    def checkClass (classes: List[CIMClassInfo])(info: CIMClassInfo): Option[String] =
    {
        if (info.relations.nonEmpty)
        {
            val s = info.relations.map(check(classes, info)).fold("")((a, b) => a match
            {
                case "" => b;
                case string1: String => b match
                {
                    case "" => a;
                    case string2: String => s"$string1\n$string2"
                }
            })
            if (s != "")
                Some(s)
            else
                None
        }
        else
            None
    }

    def checkAll: Option[String] =
    {
        val classes: List[CIMClassInfo] = new CHIM("").classes
        val errors: Seq[Option[String]] = classes.map(checkClass(classes))
        errors.fold(None)((a, b) => a match
        {
            case None => b;
            case Some(string1) => b match
            {
                case Some(string2) => Some(s"$string1\n$string2");
                case None => a
            }
        })
    }
}


//    def filter_predicate (equipment: Equipment): Boolean =
//    {
//        null != equipment.EquipmentContainer
//    }
//
//    def foreign_key (equipment: Equipment): String =
//    {
//        equipment.EquipmentContainer
//    }
//
//    def primary_key (container: EquipmentContainer): String =
//    {
//        container.id
//    }
//
//    def message (problem: (String, Equipment)): String =
//    {
//        val key = problem._1
//        val equipment = problem._2
//        val s = new StringBuilder ()
//        s.append ("Equipment ")
//        s.append (equipment.id)
//        s.append (" references ")
//        s.append ("EquipmentContainer")
//        s.append (" ")
//        s.append (key)
//        s.append (" that is not present")
//        s.toString
//    }