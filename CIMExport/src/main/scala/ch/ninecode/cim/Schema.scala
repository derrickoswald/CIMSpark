package ch.ninecode.cim

import java.util.regex.Pattern

import scala.io.Source

import org.apache.log4j.Level
import org.apache.spark.sql.SparkSession
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.datastax.spark.connector.cql.CassandraConnector

/**
 * Create the schema in Cassandra.
 *
 * The schema file itself requires adjustment of cassandra.yaml to enable user defined functions
 * and scripted user defined functions:
 *
 * $ sed --in-place 's/enable_user_defined_functions: false/enable_user_defined_functions: true/g' /etc/cassandra/cassandra.yaml \
 * $ sed --in-place 's/enable_scripted_user_defined_functions: false/enable_scripted_user_defined_functions: true/g' /etc/cassandra/cassandra.yaml
 *
 * @param session  the Spark session
 * @param resource the schema file (cqlsh commands) to process
 * @param loglevel the level to log messages at
 */
final case class Schema (session: SparkSession, resource: String, loglevel: Level)
{
    org.apache.log4j.LogManager.getLogger(getClass).setLevel(loglevel)
    val log: Logger = LoggerFactory.getLogger(getClass)

    // check if we can get the schema generation script
    def script: Option[String] =
    {
        val schema = this.getClass.getResourceAsStream(resource)
        if (null != schema)
        {
            val source = Source.fromInputStream(schema, "UTF-8")
            val statements = source.getLines.mkString("\n")
            source.close
            Some(statements)
        }
        else
            None
    }

    // check if keyspace name is legal, and quote it if necessary
    def validateKeyspace (name: String): Option[String] =
    {
        val regex = Pattern.compile("""^([a-z][a-z0-9_]{0,47})|([a-zA-Z0-9_]{1,48})$""")
        val matcher = regex.matcher(name)
        if (matcher.matches)
        {
            if (null != matcher.group(1))
                Some(matcher.group(1))
            else
                Some(s""""${matcher.group(2)}"""")
        }
        else
            None
    }

    /**
     * Generate a function to edit each line of the schema file.
     *
     * @return a function that can transform an input line of the schema file to the correct keyspace and replication factor
     */
    def editor (keyspace: String, replication: Int): String => String =
    {
        val DEFAULT_KEYSPACE = """cimexport"""
        val DEFAULT_REPLICATION = 1
        val REPLICATION_TRIGGER = """'replication_factor': """

        val old_replication_string = s"$REPLICATION_TRIGGER$DEFAULT_REPLICATION"
        val new_replication_string = s"$REPLICATION_TRIGGER$replication"

        /*
         * The edit function.
         *
         * @param line the string to transform.
         * @return the updated string
         */
        def edit (line: String): String =
        {
            val s = if (keyspace != DEFAULT_KEYSPACE)
                line.replace(DEFAULT_KEYSPACE, keyspace)
            else
                line

            if (replication != DEFAULT_REPLICATION)
                s.replace(old_replication_string, new_replication_string)
            else
                s
        }

        edit
    }

    /**
     * Create the schema according to the simulation_schema.sql file.
     *
     * The file is in a special form:
     *   - DDL statements are separated by a blank line
     *   - only DDL is permitted in the schema script
     *   - the keyspace must be cimexport - which is changed according to <code>keyspace</code> via simple global substitution
     *   - the replication factor must be 1 - which is changed according to <code>replication</code> via simple global substitution
     *
     * @param keyspace    the target keyspace to create (if it does not exist)
     * @param replication the replication factor for the keyspace (if it does not exist)
     * @return <code>true</code> if all DDL executed successfully, <code>false</code> if the schema file doesn't exist or there were errors
     */
    def make (
        connector: CassandraConnector = CassandraConnector(session.sparkContext.getConf),
        keyspace: String = "cimapplication",
        replication: Int = 2
    ): Boolean =
    {
        script match
        {
            case Some(text) =>
                validateKeyspace(keyspace) match
                {
                    case Some(keyspace) =>
                        log.info(s"""ensuring Cassandra keyspace $keyspace exists""")

                        // separate at blank lines and change keyspace
                        val statements = text.split("\n\n").map(editor(keyspace, replication))

                        // need to apply each DDL separately
                        statements.forall(
                            sql =>
                            {
                                try
                                {
                                    val _ = connector.withSessionDo(session => session.execute(sql))
                                    true
                                }
                                catch
                                {
                                    case exception: Exception =>
                                        log.error(s"""failed to create schema in Cassandra keyspace $keyspace""", exception)
                                        false
                                }
                            }
                        )
                    case None =>
                        log.error(s"""invalid keyspace name (max 48 alphanumeric or underscore): $keyspace""")
                        false
                }
            case None =>
                log.error(s"""failed to get schema sql resource: $resource""")
                false
        }
    }
}
