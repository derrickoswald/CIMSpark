package ch.ninecode

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.DataFrameReader
import org.apache.spark.sql.DataFrameWriter
import org.apache.spark.sql.SQLContext

import ch.ninecode.cim.CIMRelation

package object cim
{
    /**
     * Adds a method, `cimFile`, to SQLContext that allows reading data stored in CIM.
     */
    @deprecated("use read.cim()", "1.1.0")
    implicit class CIMContext(sqlContext: SQLContext)
    {
        def cimFile (filePath: String, minPartitions: Int = 0) =
            sqlContext.baseRelationToDataFrame (
                new CIMRelation (Array (filePath), None, None, Map.empty)(sqlContext))
    }

    /**
     * Adds a method, `cim`, to DataFrameWriter that allows you to write CIM files using
     * the DataFileWriter
     */
    implicit class CIMDataFrameWriter (writer: DataFrameWriter)
    {
        def cim: String ⇒ Unit = writer.format ("ch.ninecode.cim").save
    }

    /**
     * Adds a method, `cim`, to DataFrameReader that allows you to read CIM files using
     * the DataFileReader
     */
    implicit class CIMDataFrameReader (reader: DataFrameReader)
    {
        def cim: String ⇒ DataFrame = reader.format ("ch.ninecode.cim").load
    }
}
