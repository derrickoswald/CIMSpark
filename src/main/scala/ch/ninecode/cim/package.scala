package ch.ninecode

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.DataFrameReader
import org.apache.spark.sql.DataFrameWriter
import org.apache.spark.sql.SQLContext
import org.slf4j.LoggerFactory

package object cim
{


    /**
     * Adds a method, `cim`, to DataFrameWriter that allows you to write CIM files using
     * the DataFileWriter
     */
    implicit class CIMDataFrameWriter[T] (writer: DataFrameWriter[T])
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
