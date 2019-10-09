package ch.ninecode.cim.tool

object LogLevels extends Enumeration
{
    type LogLevels = Value
    val ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN = Value
}

/**
 * Options when running CIMTool.
 *
 * @param valid     <code>false</code> if either help or version requested (i.e. don't proceed with execution).
 * @param unittest  <code>true</code> when running unit tests.
 * @param loglevel  Logging level for messages.
 * @param cim       Version of CIM to generate.
 * @param target    Target language. See [[ch.ninecode.cim.tool.Target]]
 * @param directory Output directory.
 */
final case class CIMToolOptions (
    var valid: Boolean = true,
    unittest: Boolean = false,
    loglevel: LogLevels.Value = LogLevels.WARN,
    cim: CIMVersion = cim100,
    target: Target = scala_language,
    directory: String = "target"
)
