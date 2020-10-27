package ch.ninecode.cim

/**
 * Logging level enumeration.
 */
object LogLevels extends Enumeration
{
    type LogLevels = Value
    val ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN = Value

    def toLog4j (level: Value): org.apache.log4j.Level =
        level match
        {
            case ALL => org.apache.log4j.Level.ALL
            case DEBUG => org.apache.log4j.Level.DEBUG
            case ERROR => org.apache.log4j.Level.ERROR
            case FATAL => org.apache.log4j.Level.FATAL
            case INFO => org.apache.log4j.Level.INFO
            case OFF => org.apache.log4j.Level.ALL
            case TRACE => org.apache.log4j.Level.ALL
            case WARN => org.apache.log4j.Level.WARN
        }
}

/**
 * Options for CIM export.
 *
 * @param valid        <code>false</code> if either help or version requested (i.e. don't proceed with execution).
 * @param unittest     <code>true</code> when running unit tests.
 * @param loglevel     Logging level for messages.
 * @param master       Spark master URL. See [[https://spark.apache.org/docs/latest/submitting-applications.html#master-urls]].
 * @param sparkopts    Spark options. See [[https://spark.apache.org/docs/latest/configuration.html]].
 * @param cimopts      CIMReader options. See [[https://github.com/derrickoswald/CIMSpark/tree/master/CIMReader#reader-api]].
 * @param all          Export the entire "as-read-in" CIM file. Useful after doing some processing, such as stripe de-duplicating or topological processing to avoid having to redo that processing again.
 * @param islands      If <code>true</code>, export every topological island.
 * @param transformers If <code>true</code>, export every transformer service area.
 * @param outputfile   The output file name for --all option.
 * @param outputdir    Output directory for --islands and --transformers option without --cassandra option.
 * @param cassandra    Save the output of the --transformers option to Cassandra instead of files.
 * @param host         The Cassandra seed node to save the transformers to.
 * @param port         The Cassandra native transport port to connect to.
 * @param keyspace     The keyspace to store the transformers under (table transformer_service_area).
 * @param replication  The Casandra keyspace replication factor to use - if the keyspace needs to be created.
 * @param files        The list of CIM files to process.
 */
final case class CIMExportOptions
(
    var valid: Boolean = true,
    unittest: Boolean = false,
    loglevel: LogLevels.Value = LogLevels.OFF,
    master: String = "",
    sparkopts: Map[String, String] = Map(
        "spark.graphx.pregel.checkpointInterval" -> "8",
        "spark.serializer" -> "org.apache.spark.serializer.KryoSerializer",
        "spark.kryo.registrator" -> "ch.ninecode.cim.CIMRegistrator",
        "spark.ui.showConsoleProgress" -> "false",
        "spark.debug.maxToStringFields" -> "250",
        "spark.sql.catalog.casscatalog" -> "com.datastax.spark.connector.datasource.CassandraCatalog"),
    cimopts: Map[String, String] = Map(
        "ch.ninecode.cim.do_topo_islands" -> "true"
    ),
    all: Boolean = false,
    islands: Boolean = false,
    transformers: Boolean = false,
    outputfile: String = "export.rdf",
    outputdir: String = "simulation/",
    cassandra: Boolean = false,
    host: String = "localhost",
    port: Int = 9042,
    keyspace: String = "cimexport",
    replication: Int = 1,
    topology: Boolean = false,
    files: Seq[String] = Seq()
)
