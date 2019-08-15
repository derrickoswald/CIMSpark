package ch.ninecode.cim.tool

import java.io.Closeable
import java.io.File
import java.util.Properties

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object CIMTool
{
    def using[T <: Closeable, R] (resource: T)(block: T => R): R =
    {
        try
        {
            block (resource)
        }
        finally
        {
            resource.close ()
        }
    }

    val properties: Properties =
    {
        using (this.getClass.getResourceAsStream ("/application.properties"))
        {
            input ⇒
                val p = new Properties ()
                p.load (input)
                p
        }
    }

    val APPLICATION_NAME: String = properties.getProperty ("artifactId")
    val APPLICATION_VERSION: String = properties.getProperty ("version")

    def main (args : Array[String])
    {
        val optionparser = new CIMToolOptionParser (APPLICATION_NAME, APPLICATION_VERSION)

        optionparser.parse (args, CIMToolOptions ()) match
        {
            case Some (options) ⇒
                if (!optionparser.justInfo)
                {
                    System.setProperty (org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, options.loglevel.toString);
                    val log: Logger = LoggerFactory.getLogger (getClass)
                    val file = options.cim.file
                    log.info ("""generating CIM classes from file "%s"""".format (file))
                    val parser = ModelParser (new File ("private_data/" + file))
                    options.target.generator (parser, options).generate ()
                }
                if (!options.unittest)
                    sys.exit (0)
            case None ⇒
                sys.exit (1)
        }
    }
}
