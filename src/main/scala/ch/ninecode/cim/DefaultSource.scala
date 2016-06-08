package ch.ninecode.cim

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.sources.HadoopFsRelation
import org.apache.spark.sql.sources.HadoopFsRelationProvider
import org.apache.spark.sql.types.StructType

class DefaultSource extends HadoopFsRelationProvider
{
    def createRelation (
        sqlContext: SQLContext,
        paths: Array[String],
        dataSchema: Option[StructType],
        partitionColumns: Option[StructType],
        parameters: Map[String, String]): HadoopFsRelation =
    {
        new CIMRelation (paths, dataSchema, partitionColumns, parameters)(sqlContext)
    }
}
