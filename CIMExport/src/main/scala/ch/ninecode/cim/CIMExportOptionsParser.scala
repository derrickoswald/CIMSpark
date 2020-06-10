package ch.ninecode.cim

import scopt.OptionParser

class CIMExportOptionsParser (APPLICATION_NAME: String, APPLICATION_VERSION: String)
    extends OptionParser[CIMExportOptions](APPLICATION_NAME)
{
    head (APPLICATION_NAME, APPLICATION_VERSION)

    val default = new CIMExportOptions
    var unittest = false
    var helpout = false
    var versionout = false
    val COMMA = ","
    val EQUAL = "="

    implicit val LogLevelsRead: scopt.Read[LogLevels.Value] = scopt.Read.reads (LogLevels.withName)

    implicit val mapRead: scopt.Read[Map[String,String]] = scopt.Read.reads (
        s =>
        {
            val pairs = for (p <- s.split (COMMA); kv = p.split (EQUAL))
                yield
                {
                    if (2 == kv.length)
                        Some ((kv(0), kv(1)))
                    else
                    {
                        reportError (s"unrecognized key=value pair '$p'")
                        helpout = true
                        None
                    }
                }
            pairs.flatten.toMap
        }
    )

    override def terminate (exitState: Either[String, Unit]): Unit =
    {
        if ((helpout || versionout) && !unittest)
            exitState match
            {
                case Left (_) => sys.exit (1)
                case Right (_) => sys.exit (0)
            }
    }

    opt[Unit]("unittest")
        .hidden ()
        .action ((_, c) => { unittest = true; c.copy (unittest = true) })
        .text (s"unit testing - don't call sys.exit() [${default.unittest}}]")

    opt[LogLevels.Value]("log")
        .action ((x, c) => c.copy (loglevel = x))
        .text (s"log level, one of ${LogLevels.values.iterator.mkString (COMMA)} [${default.loglevel}]")

    opt[String]("master")
        .valueName ("MASTER_URL")
        .action ((x, c) => c.copy (master = x))
        .text (s"local[*], spark://host:port, mesos://host:port, yarn [${default.master}]")

    opt[Map[String,String]]("sparkopts")
        .valueName (s"k1${EQUAL}v1${COMMA}k2${EQUAL}v2")
        .action ((x, c) => c.copy (sparkopts = x))
        .text (s"Spark options [${default.sparkopts.map (x => s"${x._1}$EQUAL${x._2}").mkString (COMMA)}]")

    opt[Map[String,String]]("cimopts")
        .valueName (s"k1${EQUAL}v1${COMMA}k2${EQUAL}v2")
        .action ((x, c) => c.copy (cimopts = x))
        .text (s"CIMReader options [${default.cimopts.map (x => s"${x._1}$EQUAL${x._2}").mkString (COMMA)}]")

    opt[Unit]("all")
        .action ((_, c) => c.copy (all = true))
        .text (s"export entire processed file [${default.all}]")

    opt[Unit]("islands")
        .action ((_, c) => c.copy (islands = true))
        .text (s"export topological islands [${default.islands}]")

    opt[Unit]("transformers")
        .action ((_, c) => c.copy (transformers = true))
        .text (s"export transformer service areas [${default.transformers}]")

    opt[String]("outputfile")
        .valueName ("<file>")
        .action ((x, c) => c.copy (outputfile = x))
        .text (s"output file name [${default.outputfile}]")

    opt[String]("outputdir")
        .valueName ("<dir>")
        .action ((x, c) => c.copy (outputdir = x))
        .text (s"output directory name [${default.outputdir}]")

    opt[Unit]("cassandra")
        .action ((_, c) => c.copy (cassandra = true))
        .text (s"output transformer metadata to cassandra [${default.cassandra}]")

    opt[String]("host")
        .valueName ("<cassandra>")
        .action ((x, c) => c.copy (host = x))
        .text (s"Cassandra connection host (listen_address or seed in cassandra.yaml) [${default.host}]")

    opt[Int]("port")
        .valueName ("<port_number>")
        .action ((x, c) => c.copy (port = x))
        .text (s"Cassandra connection port [${default.port}]")

    opt[String]("keyspace")
        .valueName ("<name>")
        .action ((x, c) => c.copy (keyspace = x))
        .text (s"keyspace to use if Cassandra is specified [${default.keyspace}]")

    opt[Int]("replication")
        .valueName ("<number>")
        .action ((x, c) => c.copy (replication = x))
        .text (s"replication factor to use if Cassandra is specified and the keyspace doesn't exist [${default.replication}]")

    arg[String]("<CIM> <CIM> ...")
        .unbounded ()
        .action ((x, c) => c.copy (files = c.files :+ x))
        .text ("CIM rdf files to process")

    help ("help")
        .hidden ()
        .validate (Unit => { helpout = true; Right (Unit) })

    version ("version")
        .validate (Unit => { versionout = true; Right (Unit) })
        .text (
            {
                val version = APPLICATION_VERSION.split ("-")
                s"Scala: ${version(0)}, Spark: ${version(1)}, $APPLICATION_NAME: ${version(2)}"
            }
        )

    checkConfig (o => { o.valid = !(helpout || versionout); Right (Unit) })

    note ("""
Extracts subsets of CIM files based on topology.
""")

}
