package ch.ninecode.cim

import scopt.OptionParser

class CIMDifferenceOptionsParser (APPLICATION_NAME: String, APPLICATION_VERSION: String)
    extends OptionParser[CIMDifferenceOptions](APPLICATION_NAME)
{
    head(APPLICATION_NAME, APPLICATION_VERSION)

    val default = new CIMDifferenceOptions
    var unittest = false
    var helpout = false
    var versionout = false
    val COMMA = ","
    val EQUAL = "="

    implicit val logLevelsRead: scopt.Read[LogLevels.Value] = scopt.Read.reads(LogLevels.withName)

    implicit val modeRead: scopt.Read[Mode.Value] = scopt.Read.reads(Mode.withName)

    override def terminate (exitState: Either[String, Unit]): Unit =
    {
        if ((helpout || versionout) && !unittest)
            exitState match
            {
                case Left(_) => sys.exit(1)
                case Right(_) => sys.exit(0)
            }
    }

    opt[Unit]("unittest")
        .hidden()
        .action((_, c) =>
        {
            unittest = true
            c.copy(unittest = true)
        })
        .text(s"unit testing - don't call sys.exit() [${default.unittest}}]")

    opt[LogLevels.Value]("log")
        .action((x, c) => c.copy(loglevel = x))
        .text(s"log level, one of ${LogLevels.values.iterator.mkString(COMMA)} [${default.loglevel}]")

    opt[String]("master")
        .valueName("MASTER_URL")
        .action((x, c) => c.copy(master = x))
        .text(s"local[*], spark://host:port, mesos://host:port, yarn [${default.master}]")

    opt[Map[String, String]]("sparkopts")
        .valueName(s"k1${EQUAL}v1${COMMA}k2${EQUAL}v2")
        .action((x, c) => c.copy(sparkopts = x))
        .text(s"Spark options [${default.sparkopts.map(x => s"${x._1}$EQUAL${x._2}").mkString(COMMA)}]")

    opt[Map[String, String]]("cimopts")
        .valueName(s"k1${EQUAL}v1${COMMA}k2${EQUAL}v2")
        .action((x, c) => c.copy(cimopts = x))
        .text(s"CIMReader options [${default.cimopts.map(x => s"${x._1}$EQUAL${x._2}").mkString(COMMA)}]")

    opt[String]("from")
        .minOccurs(1)
        .unbounded()
        .action((x, c) => c.copy(from = c.from :+ x))
        .text("CIM rdf files from which the difference is taken")

    opt[String]("to")
        .minOccurs(1)
        .unbounded()
        .action((x, c) => c.copy(to = c.to :+ x))
        .text("CIM rdf files to which the difference is given")

    opt[Mode.Value]("mode")
        .action((x, c) => c.copy(mode = x))
        .text(s"difference mode, one of ${Mode.values.iterator.mkString(COMMA)} [${default.mode}]")

    opt[String]("output")
        .action((x, c) => c.copy(output = x))
        .text("output file to create")

    help("help")
        .hidden()
        .validate(Unit =>
        {
            helpout = true
            Right(Unit)
        })

    version("version")
        .validate(Unit =>
        {
            versionout = true
            Right(Unit)
        })
        .text(
            {
                val version = APPLICATION_VERSION.split("-")
                s"Scala: ${version(0)}, Spark: ${version(1)}, $APPLICATION_NAME: ${version(2)}"
            }
        )

    checkConfig(o =>
    {
        if ((o.mode != Mode.Summary) && ("" == o.output))
            Left(s"output file must be specified with --output for modes other than ${Mode.Summary}")
        else
        {
            o.valid = !(helpout || versionout)
            Right(Unit)
        }
    })

    note(
        """
Generates a difference between two CIM files.
""")

}
