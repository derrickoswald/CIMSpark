package ch.ninecode

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.DataFrameReader
import org.apache.spark.sql.DataFrameWriter

/**
 * Spark Common Information Model (CIM) reader.
 * Implements an Apache Spark file reader for CIM classes,
 * generating an RDD for all Element objects and one for each specific
 * CIM class.
 * The reader fits into the overall Spark architecture as shown in the following image:
 *
 * <img src="https://camo.githubusercontent.com/88a29d3c7147bc4019dc828efe42243b43941211/68747470733a2f2f7261776769742e636f6d2f6465727269636b6f7377616c642f43494d5265616465722f6d61737465722f696d672f4f766572766965772e737667">
 *
 * The architecture follows the standard Relation/InputFormat structure as other readers:
 *
 * <img src="https://camo.githubusercontent.com/06309e734ecc4e84ff0c84236ed022eb4a64b8d4/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6465727269636b6f7377616c642f43494d537061726b406d61737465722f43494d5265616465722f696d672f4172636869746563747572652e737667">
 *
 */
package object cim
{

    /**
     * Adds a method, `cim`, to DataFrameWriter that allows you to write CIM files using
     * the DataFileWriter
     */
    implicit class CIMDataFrameWriter[T] (writer: DataFrameWriter[T])
    {
        def cim: String => Unit = writer.format("ch.ninecode.cim").save
    }

    /**
     * Adds a method, `cim`, to DataFrameReader that allows you to read CIM files using
     * the DataFileReader
     */
    implicit class CIMDataFrameReader (reader: DataFrameReader)
    {
        def cim: String => DataFrame = reader.format("ch.ninecode.cim").load
    }

}
