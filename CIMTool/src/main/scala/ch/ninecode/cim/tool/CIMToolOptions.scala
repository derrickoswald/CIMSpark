package ch.ninecode.cim.tool

object LogLevels extends Enumeration
{
    type LogLevels = Value
    val ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN = Value
}

final case class CIMToolOptions (

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
    loglevel: LogLevels.Value = LogLevels.WARN,

    /**
     * Version of CIM to generate.
     */
    cim: CIMVersion = cim100,

    /**
     * Target language.
     */
    target: Target = scalalanguage,

    /**
     * Output directory
     */
    directory: String = "target"

)
