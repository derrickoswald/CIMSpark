package ch.ninecode.cim

import java.io.BufferedOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.Properties
import java.util.zip.ZipInputStream

import ch.ninecode.cim.CIMExportMain.getClass
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test

class CIMExportSuiteIT
    extends
        ch.ninecode.SparkSuite
{
    import CIMExportSuiteIT._

    val properties: Properties =
    {
        val in = this.getClass.getResourceAsStream ("/configuration.properties")
        val p = new Properties ()
        p.load (in)
        in.close ()
        p
    }
    val PORT: String = properties.getProperty ("nativeTransportPort")

    @Test def Main ()
    {
        CIMExportMain.main (
            Array (
                "--unittest",
                "--master", "local[2]",
                "--logging", "INFO",
                "--transformers",
                "--cassandra",
                "--host", "localhost",
                "--port", PORT,
                "--keyspace", "test",
                "--replication", "1",
                DEMO_DATA))
    }
}

object CIMExportSuiteIT
{
    val FILE_DEPOT = "data/"

    val DEMO_DATA: String = FILE_DEPOT + "DemoData.rdf"

    /**
     * This utility extracts files and directories of a standard zip file to
     * a destination directory.
     *
     * @author www.codejava.net
     *
     */
    class Unzip
    {
        /**
         * Extracts a zip file specified by the file to a directory.
         *
         * The directory will be created if does not exist.
         *
         * @param file The Zip file.
         * @param directory The directory to extract it to
         * @throws IOException If there is a problem with the zip extraction
         */
        @throws[IOException]
        def unzip (file: String, directory: String): Unit =
        {
            val dir = new File (directory)
            if (!dir.exists)
                dir.mkdir
            val zip = new ZipInputStream (new FileInputStream (file))
            var entry = zip.getNextEntry
            // iterates over entries in the zip file
            while (null != entry)
            {
                val path = directory + entry.getName
                val time = entry.getLastModifiedTime
                if (!entry.isDirectory)
                {
                    // if the entry is a file, extracts it
                    extractFile (zip, path)
                    if (null != time)
                        new File (path).setLastModified (time.toMillis)
                }
                else
                // if the entry is a directory, make the directory
                    new File (path).mkdir
                zip.closeEntry ()
                entry = zip.getNextEntry
            }
            zip.close ()
        }

        /**
         * Extracts a zip entry (file entry).
         *
         * @param zip The Zip input stream for the file.
         * @param path The path to extract he file to.
         * @throws IOException If there is a problem with the zip extraction
         */
        @throws[IOException]
        private def extractFile (zip: ZipInputStream, path: String): Unit =
        {
            val bos = new BufferedOutputStream (new FileOutputStream (path))
            val bytesIn = new Array[Byte](4096)
            var read = -1
            while ({ read = zip.read (bytesIn); read != -1 })
                bos.write (bytesIn, 0, read)
            bos.close ()
        }
    }

    @BeforeClass def before ()
    {
        // unpack the zip file
        new Unzip ().unzip (FILE_DEPOT + "DemoData.zip", FILE_DEPOT)
    }

    @AfterClass def after ()
    {
        // erase the unpacked file
        new File (DEMO_DATA).delete
    }
}