package org.apache.spark.sql.types

import org.apache.spark.sql.types.DataType
import org.apache.spark.sql.types.NullType
import org.apache.spark.sql.types.SQLUserDefinedType
import org.apache.spark.sql.types.UserDefinedType

import org.apache.spark.sql.Row
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.GenericInternalRow
import org.apache.spark.sql.catalyst.expressions.GenericMutableRow
import org.apache.spark.sql.catalyst.expressions.UnsafeRow
import org.apache.spark.unsafe.types.UTF8String
import ch.ninecode.model._

// needed to get around error: trait Element accesses protected method clone inside a concrete trait method.
// Add an accessor in a class extending class Object as a workaround.
/*class ObjectPlus extends Object { protected def cloneplus = clone }*/

@SQLUserDefinedType(udt = classOf[ElementUDT])
trait Element
extends 
    Row
with 
    Serializable
with 
    Cloneable 
{
  def sup: Element = null
  def id: String = if (null == sup) "0" else (sup.id)
  override def length: Int = 1
  override def get (i: Int): Object =
    {
        if (0 == i)
            sup
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
  override def copy(): Row = { throw new Exception("not implemented yet") }
}

// HACK:
// This needs to be defined within package org.apache.spark.sql.types 
// because UserDefinedType became private with Spark 2.0.x
// it will be reintroduced with Spark 2.1.x, see https://issues.apache.org/jira/browse/SPARK-13326
/**
 * User-defined type for [[Element]].
 */
class ElementUDT extends UserDefinedType[Element]
{
    // The following type and it's serialization took a lot of trial and error.
    // This is what didn't work for a data type for sup:
    // this
    //   - leads to infinite recursion and stack overflow
    // new StructType ()
    //   - results in illegal index (1) because something doesn't use member count
    // NullType
    //   - works at the cluster level (only uses serialization),
    //     but a second "smarter" deserialization at the client always returns null in the GenericInternalRow
    // stub
    //   - where stub is an instance of another class ElementUDT_stub extends UserDefinedType[Element]
    //     results in the same serialization/deserialization issues as above, but one level away
    // StructType (StructField ("sup", StringType, true) :: Nil)
    //   - works except for hive-thriftserver
    //     where it doesn't handle user defined types (UDT)
    //     see addNonNullColumnValue in https://github.com/apache/spark/blob/master/sql/hive-thriftserver/src/main/scala/org/apache/spark/sql/hive/thriftserver/SparkExecuteStatementOperation.scala
    //     results in scala.MatchError: ch.ninecode.model.ElementUDT@7c008354 (of class ch.ninecode.model.ElementUDT)
    override def sqlType: DataType = NullType

    override def pyUDT: String = "org.apache.spark.sql.types.ElementUDT"

    override def serialize (obj: Element): Any =
    {
          val output = new Array[Any](1)
          output (0) = UTF8String.fromString (obj.id.toString)
          val r = new GenericMutableRow (output)
          r
    }

    override def deserialize (datum: Any): Element =
    {
        datum match
        {
            case row: UnsafeRow => // only GenericInternalRow and InternalRow are used, kept for reference
            {
                var dd = row.getUTF8String (0)
                var ee = if (null == dd) "" else dd.toString ()
                BasicElement (null, ee)
            }
            case row: GenericInternalRow =>
            {
                var dd = row.getUTF8String (0)
                var ee = if (null == dd) "" else dd.toString ()
                BasicElement (null, ee)
            }
            case row: InternalRow =>
            {
                var dd = row.getUTF8String (0)
                var ee = if (null == dd) "" else dd.toString ()
                BasicElement (null, ee)
            }
            case _: Any =>
            {
                println ("in _")
                BasicElement (null, "foo")
            }
        }
    }

    override def userClass: Class[Element] = classOf[Element]

    override def equals (o: Any): Boolean =
    {
        o match
        {
            case v: ElementUDT => true
            case _ => false
        }
    }

    override def hashCode(): Int = classOf[ElementUDT].getName.hashCode()

    override def typeName: String = "element"

    override def asNullable: ElementUDT = this
}