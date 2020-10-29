package ch.ninecode.cim

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.execution.datasources.InMemoryFileIndex
import org.apache.spark.sql.sources.BaseRelation
import org.apache.spark.sql.sources.RelationProvider
import org.slf4j.LoggerFactory

class DefaultSource
    extends
        RelationProvider
{
    private val log = LoggerFactory.getLogger(getClass)

    def isGlobPath (pattern: Path): Boolean = pattern.toString.exists("{}[]*?\\".toSet.contains)

    def globPath (fs: FileSystem, path: Path): Seq[Path] = fs.globStatus(path).map(_.getPath)

    def globPathIfNecessary (fs: FileSystem, pattern: Path): Seq[Path] = if (isGlobPath(pattern)) globPath(fs, pattern) else Seq(pattern)

    override def createRelation (
        sqlContext: SQLContext,
        parameters: Map[String, String]): BaseRelation =
    {
        val session = sqlContext.sparkSession
        val files = parameters.getOrElse("path", sys.error("'path' must be specified for CIM data."))
        log.info(s"createRelation for files $files")
        val allPaths: Seq[String] = files.split(",")
        val globbedPaths = allPaths.flatMap
        {
            path =>
                val hdfsPath = new Path(path)
                val configuration = new Configuration(session.sparkContext.hadoopConfiguration)
                val fs = hdfsPath.getFileSystem(configuration)
                val qualified = hdfsPath.makeQualified(fs.getUri, fs.getWorkingDirectory)
                val globPath = globPathIfNecessary(fs, qualified)
                if (globPath.isEmpty)
                    throw new java.io.FileNotFoundException(s"Path does not exist: $qualified")
                globPath.foreach(
                    p =>
                    {
                        if (!fs.exists(p))
                            throw new java.io.FileNotFoundException(s"Path does not exist: $p")
                    }
                )
                globPath
        }
        val fileCatalog = new InMemoryFileIndex(session, globbedPaths, parameters, None)
        new CIMRelation(fileCatalog, parameters)(session)
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
