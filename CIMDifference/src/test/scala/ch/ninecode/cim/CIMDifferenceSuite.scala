package ch.ninecode.cim

import java.io.BufferedOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.zip.ZipInputStream

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession

import org.scalatest.BeforeAndAfter
import org.scalatest.Outcome
import org.scalatest.funsuite.FixtureAnyFunSuite

import ch.ninecode.model.Element

class CIMDifferenceSuite extends FixtureAnyFunSuite with BeforeAndAfter
{
    type FixtureParam = SparkSession

    val FILE_DEPOT = "data/"
    val OUTPUT = "diff.rdf"
    val BEFORE = s"${FILE_DEPOT}DemoData.rdf"
    val AFTER = s"${FILE_DEPOT}DemoDataModified.rdf"
    val TARGET = s"$FILE_DEPOT$OUTPUT"

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
         * @param file      The Zip file.
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
                val path = s"$directory${entry.getName}"
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
         * @param zip  The Zip input stream for the file.
         * @param path The path to extract he file to.
         * @throws IOException If there is a problem with the zip extraction
         */
        @throws[IOException]
        private def extractFile (zip: ZipInputStream, path: String): Unit =
        {
            val bos = new BufferedOutputStream (new FileOutputStream (path))
            val bytesIn = new Array[Byte](4096)
            var read = -1
            while (
            {
                read = zip.read (bytesIn)
                read != -1
            })
                bos.write (bytesIn, 0, read)
            bos.close ()
        }
    }

    before
    {
        // unpack the zip files
        new Unzip ().unzip (s"${FILE_DEPOT}DemoData.zip", FILE_DEPOT)
        new Unzip ().unzip (s"${FILE_DEPOT}DemoDataModified.zip", FILE_DEPOT)
    }

    after
    {
        // erase the unpacked files
        new File (BEFORE).delete
        new File (AFTER).delete
        new File (TARGET).delete
    }

    def withFixture (test: OneArgTest): Outcome =
    {
        // create the configuration
        val configuration = new SparkConf (false)
            .setAppName ("CIMDifferenceSuite")
            .setMaster ("local[2]")
            .set ("spark.driver.memory", "2g")
            .set ("spark.executor.memory", "2g")
            .set ("spark.ui.showConsoleProgress", "false")
            .registerKryoClasses (CIMClasses.list)
            .set ("spark.kryo.registrator", "ch.ninecode.cim.CIMRegistrator")

        val session = SparkSession.builder ().config (configuration).getOrCreate () // create the fixture
        session.sparkContext.setLogLevel ("INFO") // Valid log levels include: ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN
        try
        withFixture (test.toNoArgTest (session)) // "loan" the fixture to the test
        finally session.stop () // clean up the fixture
    }

    def readFile (filename: String, options: Map[String, String] = Map [String, String]())(implicit spark: SparkSession): DataFrame =
    {
        spark.read.format ("ch.ninecode.cim").options (options).load (filename) // ToDo: why doesn't this work? load (filename.split (","):_*)
    }

    test ("Basic")
    {
        implicit spark =>
            val options = CIMDifferenceOptions (
                from = Seq (BEFORE),
                to = Seq (AFTER),
                mode = Mode.ChangeSet,
                description = "test changeset",
                name = "Test",
                output = TARGET
            )
            CIMDifference (spark, options).execute ()

            // cleanup
            spark.sparkContext.getPersistentRDDs.foreach (
                x =>
                {
                    val (_, rdd) = x
                    val _ = rdd.unpersist (true).setName (null)
                }
            )

            // check
            val cimopts = Map [String, String](
                "ch.ninecode.cim.apply_changesets" -> "true",
            )
            val count = readFile (s"$BEFORE,$TARGET", cimopts).count

            val cimopts_ref = Map [String, String](
                "ch.ninecode.cim.name_template" -> "%s_ref",
            )
            val count_ref = readFile (AFTER, cimopts_ref).count

            println (s"reference $count_ref result $count")
            assert (count_ref == count, "element count doesn't match")

            var elements_ref: RDD[Element] = null
            var elements: RDD[Element] = null
            spark.sparkContext.getPersistentRDDs.foreach (
                x =>
                {
                    val (_, rdd) = x
                    if (rdd.name == s"Element_ref")
                        elements_ref = rdd.asInstanceOf [RDD[Element]]
                    else
                        if (rdd.name == s"Element")
                            elements = rdd.asInstanceOf [RDD[Element]]
                }
            )

            val ref = elements_ref.keyBy (_.id)
            val result = elements.keyBy (_.id)
            val join = ref.fullOuterJoin (result)

            def check (elements: (String, (Option[Element], Option[Element]))): Option[String] =
            {
                val (_, (left, right)) = elements
                left match
                {
                    case Some (l) =>
                        right match
                        {
                            case Some (r) =>
                                val ls = l.export
                                val rs = r.export
                                if (ls != rs)
                                    Some (s"reference ${l.id} doesn't match result ${r.id}")
                                else
                                    None
                            case None =>
                                Some (s"${l.id} not found in result")
                        }
                    case None =>
                        right match
                        {
                            case Some (r) =>
                                Some (s"${r.id} not found in reference")
                            case None =>
                                None
                        }
                }
            }

            val errors = join.flatMap (check)
            val errorcount = errors.count
            assert (0 == errorcount, s"errors: ${errors.take (25).mkString ("\n")}")
    }
}