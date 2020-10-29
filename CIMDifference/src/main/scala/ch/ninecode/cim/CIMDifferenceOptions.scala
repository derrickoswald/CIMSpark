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

object Mode extends Enumeration
{
    type Mode = Value
    val Summary, HumanReadable, ChangeSet = Value
}

/**
 * Options for CIM export.
 *
 * @param valid     <code>false</code> if either help or version requested (i.e. don't proceed with execution).
 * @param unittest  <code>true</code> when running unit tests.
 * @param loglevel  Logging level for messages.
 * @param master    Spark master URL. See [[https://spark.apache.org/docs/latest/submitting-applications.html#master-urls]].
 * @param sparkopts Spark options. See [[https://spark.apache.org/docs/latest/configuration.html]].
 * @param cimopts   CIMReader options. See [[https://github.com/derrickoswald/CIMSpark/tree/master/CIMReader#reader-api]].
 */
final case class CIMDifferenceOptions (
    var valid: Boolean = true,
    unittest: Boolean = false,
    loglevel: LogLevels.Value = LogLevels.OFF,
    master: String = "",
    sparkopts: Map[String, String] = Map(
        "spark.graphx.pregel.checkpointInterval" -> "8",
        "spark.serializer" -> "org.apache.spark.serializer.KryoSerializer",
        "spark.kryo.registrator" -> "ch.ninecode.cim.CIMRegistrator",
        "spark.ui.showConsoleProgress" -> "false",
        "spark.sql.debug.maxToStringFields" -> "250",
        "spark.sql.catalog.casscatalog" -> "com.datastax.spark.connector.datasource.CassandraCatalog"),
    cimopts: Map[String, String] = Map(),
    from: Seq[String] = Seq(),
    to: Seq[String] = Seq(),
    mode: Mode.Value = Mode.Summary,
    output: String = "",
    description: String = "",
    name: String = ""
)
