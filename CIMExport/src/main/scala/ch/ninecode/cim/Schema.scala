package ch.ninecode.cim

import scala.io.Source

import com.datastax.spark.connector.cql.CassandraConnector
import org.apache.spark.sql.SparkSession
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/*
 * Create the schema in Cassandra.
 */
case class Schema (session: SparkSession, keyspace: String, verbose: Boolean)
{
    if (verbose)
        org.apache.log4j.LogManager.getLogger (getClass.getName).setLevel (org.apache.log4j.Level.INFO)
    implicit val log: Logger = LoggerFactory.getLogger (getClass)

    val resource = """/export_schema.sql"""
    val default_keyspace = """cimexport"""

    def toKeySpace (lines: String): String =
    {
        if (keyspace != default_keyspace)
            lines.replace (default_keyspace, keyspace)
        else
            lines
    }

    /**
     * Create the schema according to the export_schema.sql file.
     *
     * The file is in a special form:
     *   - DDL statements are separated by a blank line
     *   - only DDL is permitted in the schema script
     *   - the keyspace must be cimexport - which is changed according to keyspace via simple global substitution
     *
     * @return <code>true</code> if all DDL executed successsuflly, <code>false</code> if the schema file doesn't exist or there were errors
     */
    def make: Boolean =
    {
        val schema = this.getClass.getResourceAsStream (resource)
        if (null != schema)
        {
            log.info ("""ensuring Cassandra keyspace %s exists""".format (keyspace))

            // separate at blank lines and change keyspace
            val sqls = Source.fromInputStream (schema, "UTF-8").getLines.mkString ("\n").split ("\n\n").map (toKeySpace)

            // need to apply each DDL separately
            sqls.forall (
                sql ⇒
                {
                    try
                    {
                        CassandraConnector (session.sparkContext.getConf).withSessionDo (session => session.execute (sql))
                        true
                    }

                    catch
                    {
                        case exception: Exception ⇒ log.error ("""failed to create schema in Cassandra keyspace %s""".format (keyspace), exception)
                            false
                    }
                }
            )
        }
        else
        {
            log.error ("""failed to get schema sql resource: %s""".format (resource))
            false
        }
    }
}
