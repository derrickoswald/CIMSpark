package ch.ninecode.cim.tool

import scopt.OptionParser

@SuppressWarnings (Array ("org.wartremover.warts.NonUnitStatements"))
class CIMToolOptionsParser (APPLICATION_NAME: String, APPLICATION_VERSION: String)
    extends OptionParser[CIMToolOptions](APPLICATION_NAME)
{
    head (APPLICATION_NAME, APPLICATION_VERSION)

    val default = new CIMToolOptions
    var unittest = false
    var helpout = false
    var versionout = false

    implicit val VersionRead: CIMVersionReader = new CIMVersionReader
    implicit val TargetRead: TargetReader = new TargetReader
    implicit val LogLevelsRead: scopt.Read[LogLevels.Value] = scopt.Read.reads (LogLevels.withName)

    override def terminate (exitState: Either[String, Unit]): Unit =
    {
        if ((helpout || versionout) && !unittest)
            exitState match
            {
                case Left (_) => sys.exit (1)
                case Right (_) => sys.exit (0)
            }
    }

    opt [Unit]("unittest")
        .hidden ()
        .action ((_, c) =>
        {
            unittest = true; c.copy (unittest = true)
        })
        .text (s"unit testing - don't call sys.exit() [${default.unittest}]")

    opt [LogLevels.Value]("log")
        .action ((x, c) => c.copy (loglevel = x))
        .text (s"log level, one of ${LogLevels.values.mkString (",")} [${default.loglevel}]")

    opt [CIMVersion]("cim")
        .action ((x, c) => c.copy (cim = x))
        .text (s"cim version, one of ${VersionRead.versions.mkString (",")} [${default.cim.name}]")

    opt [Target]("target")
        .action ((x, c) => c.copy (target = x))
        .text (s"output target language, one of ${TargetRead.languages.mkString (",")} [${default.target.name}]")

    opt [String]("directory")
        .action ((x, c) => c.copy (directory = x))
        .text (s"output directory [${default.directory}]")

    help ("help")
        .hidden ()
        .validate (Unit =>
        {
            helpout = true; Right (Unit)
        })

    version ("version")
        .validate (Unit =>
        {
            versionout = true; Right (Unit)
        })
        .text (
            {
                val version = APPLICATION_VERSION.split ("-")
                s"Scala: ${version (0)}, Spark: ${version (1)}, $APPLICATION_NAME: ${version (2)}"
            }
        )

    checkConfig (o =>
    {
        o.valid = !(helpout || versionout); Right (Unit)
    })

    note (
        """
Generates CIM class files.

Reads CIM UML model files available from the CIM Users Group (https://cimug.ucaiug.org/)
in Enterprise Architect (SparX Systems https://www.sparxsystems.com/) .eap format
and creates source code class files for either Scala or Javascript.
"""
    )
}
