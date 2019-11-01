package ch.ninecode.cim

import scopt.OptionParser

class CIMExportOptionsParser (APPLICATION_NAME: String, APPLICATION_VERSION: String)
    extends OptionParser[ExportOptions](APPLICATION_NAME)
{
    head (APPLICATION_NAME, APPLICATION_VERSION)

    val default = new ExportOptions
    var unittest = false
    var helpout = false
    var versionout = false

    implicit val LogLevelsRead: scopt.Read[LogLevels.Value] = scopt.Read.reads (LogLevels.withName)

    implicit val mapRead: scopt.Read[Map[String,String]] = scopt.Read.reads (
        s =>
        {
            var ret = Map[String, String] ()
            val ss = s.split (",")
            for (p <- ss)
            {
                val kv = p.split ("=")
                ret = ret + ((kv(0), kv(1)))
            }
            ret
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

    opt [Unit]("unittest").
        hidden ().
        action ((_, c) => { unittest = true; c.copy (unittest = true) }).
        text ("unit testing - don't call sys.exit() [%s]".format (default.unittest))

    opt [LogLevels.Value]("log").
        action ((x, c) => c.copy (loglevel = x)).
        text ("log level, one of %s [%s]".format (LogLevels.values.iterator.mkString (","), default.loglevel))

    opt [String]("master").valueName ("MASTER_URL").
        action ((x, c) ⇒ c.copy (master = x)).
        text ("local[*], spark://host:port, mesos://host:port, yarn [%s]".format (default.master))

    opt[Map[String,String]]("sparkopts").valueName ("k1=v1,k2=v2").
        action ((x, c) => c.copy (sparkopts = x)).
        text ("Spark options [%s]".format (default.sparkopts.map (x ⇒ s"${x._1}=${x._2}").mkString (",")))

    opt[Map[String,String]]("cimopts").valueName ("k1=v1,k2=v2").
        action ((x, c) => c.copy (cimopts = x)).
        text ("CIMReader options [%s]".format (default.cimopts.map (x ⇒ s"${x._1}=${x._2}").mkString (",")))

    opt[Unit]("all").
        action ((_, c) => c.copy (all = true)).
        text ("export entire processed file [%s]".format (default.all))

    opt[Unit]("islands").
        action ((_, c) => c.copy (islands = true)).
        text ("export topological islands [%s]".format (default.islands))

    opt[Unit]("transformers").
        action ((_, c) => c.copy (transformers = true)).
        text ("export transformer service areas [%s]".format (default.transformers))

    opt[String]("outputfile").valueName ("<file>").
        action ((x, c) => c.copy (outputfile = x)).
        text ("output file name [%s]".format (default.outputfile))

    opt[String]("outputdir").valueName ("<dir>").
        action ((x, c) => c.copy (outputdir = x)).
        text ("output directory name [%s]".format (default.outputdir))

    opt[Unit]("cassandra").
        action ((_, c) => c.copy (cassandra = true)).
        text ("output transformer metadata to cassandra [%s]".format (default.cassandra))

    opt [String]("host").valueName ("<cassandra>").
        action ((x, c) ⇒ c.copy (host = x)).
        text ("Cassandra connection host (listen_address or seed in cassandra.yaml) [%s]".format (default.host))

    opt [Int]("port").valueName ("<port_number>").
        action ((x, c) ⇒ c.copy (port = x)).
        text ("Cassandra connection port [%s]".format (default.port))

    opt [String]("keyspace").valueName ("<name>").
        action ((x, c) ⇒ c.copy (keyspace = x)).
        text ("keyspace to use if Cassandra is specified [%s]".format (default.keyspace))

    opt [Int]("replication").valueName ("<number>").
        action ((x, c) ⇒ c.copy (replication = x)).
        text ("replication factor to use if Cassandra is specified and the keyspace doesn't exist [%s]".format (default.replication))

    arg[String]("<CIM> <CIM> ...").unbounded ().
        action ((x, c) => c.copy (files = c.files :+ x)).
        text ("CIM rdf files to process")

    help ("help").
        hidden ().
        validate (Unit => { helpout = true; Right (Unit) })

    version ("version").
        validate (Unit => { versionout = true; Right (Unit) }).
            text ("Scala: %s, Spark: %s, %s: %s".format (
                APPLICATION_VERSION.split ("-")(0),
                APPLICATION_VERSION.split ("-")(1),
                APPLICATION_NAME,
                APPLICATION_VERSION.split ("-")(2)
            )
        )

    checkConfig (o => { o.valid = !(helpout || versionout); Right (Unit) })

    note ("""
Extracts subsets of CIM files based on topology.
""")

}
