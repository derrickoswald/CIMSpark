package ch.ninecode.cim

/**
 * Logging level enumeration.
 */
object LogLevels extends Enumeration
{
    type LogLevels = Value
    val ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN = Value
    def toLog4j (level: Value): org.apache.log4j.Level =
        level match {
            case ALL   => org.apache.log4j.Level.ALL
            case DEBUG => org.apache.log4j.Level.DEBUG
            case ERROR => org.apache.log4j.Level.ERROR
            case FATAL => org.apache.log4j.Level.FATAL
            case INFO  => org.apache.log4j.Level.INFO
            case OFF   => org.apache.log4j.Level.ALL
            case TRACE => org.apache.log4j.Level.ALL
            case WARN  => org.apache.log4j.Level.WARN
        }
}

final case class ExportOptions
(
    /**
     * False if either help or version requested (i.e. don't proceed with execution).
     */
    var valid: Boolean = true,

    /**
     * True when running unit tests.
     */
    unittest: Boolean = false,

    /**
     * Logging level for messages.
     */
    loglevel: LogLevels.Value = LogLevels.OFF,

    /**
     * Spark master URL.
     * See https://spark.apache.org/docs/latest/submitting-applications.html#master-urls.
     */
    master: String = "",

    /**
     * Spark options.
     * See https://spark.apache.org/docs/latest/configuration.html.
     */
    sparkopts: Map[String,String] = Map (
        "spark.graphx.pregel.checkpointInterval" → "8",
        "spark.serializer" → "org.apache.spark.serializer.KryoSerializer",
        "spark.ui.showConsoleProgress" → "false"),

    /**
     * CIMReader options.
     * See https://github.com/derrickoswald/CIMSpark/tree/master/CIMReader#reader-api.
     */
    cimopts: Map[String,String] = Map (
        "ch.ninecode.cim.do_topo_islands" → "true"
    ),

    /**
     * Export the entire "as-read-in" CIM file.
     *
     * Useful after doing some processing, such as stripe de-duplicating or topological processing,
     * to avoid having to redo that processing again.
     */
    all: Boolean = false,

    /**
     * If <code>true</code>, export every topological island.
     */
    islands: Boolean = false,

    /**
     * If <code>true</code>, export every transformer service area.
     */
    transformers: Boolean = false,

    /**
     * Output file name for --all option.
     */
    outputfile: String = "export.rdf",

    /**
     * Output directory for --islands and --transformers option.
     */
    outputdir: String = "simulation/",

    /**
     * Save the output of the --transformes option to Cassandra instead of files.
     */
    cassandra: Boolean = false,

    /**
     * The Cassandra seed node to save the transformers to.
     */
    host: String = "localhost",

    /**
     * The Cassandra native transport port to connect to.
     */
    port: Int = 9042,

    /**
     * The keyspace to store the transformers under (table transformer_service_area).
     */
    keyspace: String = "cimexport",

    /**
     * The Casandra keyspace replication factor to use - if the keyspace needs to be created.
     */
    replication: Int = 1,

    /**
     * The list of CIM files to process.
     */
    files: Seq[String] = Seq()
)
