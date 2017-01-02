package ch.ninecode.model

import org.apache.spark.sql.Row
import org.apache.spark.sql.types.SQLUserDefinedType

// NOTE: ElementUDT is actually in this artifact 
import org.apache.spark.sql.types.ElementUDT

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
