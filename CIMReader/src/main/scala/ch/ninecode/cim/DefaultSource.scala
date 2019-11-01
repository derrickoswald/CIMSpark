package ch.ninecode.cim

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.spark.deploy.SparkHadoopUtil
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.execution.datasources.InMemoryFileIndex
import org.apache.spark.sql.sources.BaseRelation
import org.apache.spark.sql.sources.RelationProvider
import org.slf4j.LoggerFactory

class DefaultSource
extends
    RelationProvider
{
    private val log = LoggerFactory.getLogger (getClass) 
    
    override def createRelation (
        sqlContext: SQLContext,
        parameters: Map[String, String]): BaseRelation =
    {
        val session = sqlContext.sparkSession
        val files = parameters.getOrElse ("path", sys.error("'path' must be specified for CIM data."))
        log.info (s"createRelation for files $files")
        val allPaths: Seq[String] = files.split (",")
        val globbedPaths = allPaths.flatMap
        {
            path =>
                val hdfsPath = new Path (path)
                val configuration = new Configuration (session.sparkContext.hadoopConfiguration)
                val fs = hdfsPath.getFileSystem (configuration)
                val qualified = hdfsPath.makeQualified (fs.getUri, fs.getWorkingDirectory)
                val globPath = SparkHadoopUtil.get.globPathIfNecessary (qualified)
                if (globPath.isEmpty)
                    throw new java.io.FileNotFoundException (s"Path does not exist: $qualified")
                if (!fs.exists(globPath.head))
                    throw new java.io.FileNotFoundException (s"Path does not exist: ${globPath.head}")
                globPath
        }
        val fileCatalog = new InMemoryFileIndex (session, globbedPaths, parameters, None)
        val partitionSchema = fileCatalog.partitionSpec().partitionColumns
        val format = new CIMFileFormat ()
        val dataSchema = format.inferSchema (session, parameters, fileCatalog.allFiles ()).get
        new CIMRelation (fileCatalog, partitionSchema, dataSchema, format, parameters) (session)
    }
}

// or alternatively, if extending a FileFormat, like so:
//class DefaultSource
//extends
//    CIMFileFormat
//{
//}
// then DataSource uses the CIMFileFormat with HadoopFsRelation - which doesn't allow for subsetting, named RDD setup, Join, Edges etc.
// see https://github.com/apache/spark/blob/branch-2.0/sql/core/src/main/scala/org/apache/spark/sql/execution/datasources/DataSource.scala
