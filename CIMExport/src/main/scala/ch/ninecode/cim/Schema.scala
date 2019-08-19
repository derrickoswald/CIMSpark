package ch.ninecode.cim

import scala.io.Source

import com.datastax.spark.connector.cql.CassandraConnector
import org.apache.spark.sql.SparkSession
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/*
 * Create the schema in Cassandra.
 */
case class Schema (session: SparkSession, keyspace: String, replication: Int = 2, verbose: Boolean)
{
    if (verbose)
        org.apache.log4j.LogManager.getLogger (getClass.getName).setLevel (org.apache.log4j.Level.INFO)
    implicit val log: Logger = LoggerFactory.getLogger (getClass)

    val RESOURCE = """/export_schema.sql"""

    /**
     * Generate a function to edit each line of the schema file.
     *
     * @return a function that can transform an input line of the schema file to the correct keyspace and replication factor
     */
    def editor: String ⇒ String =
    {
        val DEFAULT_KEYSPACE = """cimexport"""
        val DEFAULT_REPLICATION = 2
        val REPLICATION_TRIGGER = """'replication_factor': """

        val old_replication_string = REPLICATION_TRIGGER + DEFAULT_REPLICATION.toString
        val new_replication_string = REPLICATION_TRIGGER + replication.toString

        /**
         * The edit function.
         *
         * @param line the string to transforme.
         * @return the updated string
         */
        def edit (line: String): String =
        {
            val s = if (keyspace != DEFAULT_KEYSPACE)
                line.replace (DEFAULT_KEYSPACE, keyspace)
            else
                line

            if (replication != DEFAULT_REPLICATION)
                s.replace (old_replication_string, new_replication_string)
            else
                s
        }

        edit
    }

    /**
     * Create the schema according to the export_schema.sql file.
     *
     * The file is in a special form:
     *   - DDL statements are separated by a blank line
     *   - only DDL is permitted in the schema script
     *   - the keyspace must be cimexport - which is changed according to <code>keyspace</code> via simple global substitution
     *   - the replication factor must be 2 - which is changed according to <code>replication</code> via simple global substitution
     *
     * @return <code>true</code> if all DDL executed successsuflly, <code>false</code> if the schema file doesn't exist or there were errors
     */
    def make: Boolean =
    {
        val schema = this.getClass.getResourceAsStream (RESOURCE)
        if (null != schema)
        {
            log.info ("""ensuring Cassandra keyspace %s exists""".format (keyspace))

            // separate at blank lines and change keyspace
            val sqls = Source.fromInputStream (schema, "UTF-8").getLines.mkString ("\n").split ("\n\n").map (editor)

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
                        case exception: Exception ⇒
                            log.error ("""failed to create schema in Cassandra keyspace %s""".format (keyspace), exception)
                            false
                    }
                }
            )
        }
        else
        {
            log.error ("""failed to get schema sql resource: %s""".format (RESOURCE))
            false
        }
    }
}
