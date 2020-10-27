package ch.ninecode

import java.io.BufferedOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

trait Unzip
{

    trait Using
    {
        def using[T <: AutoCloseable, R] (resource: T)(block: T => R): R =
        {
            try
            {
                block(resource)
            }
            finally
            {
                resource.close()
            }
        }
    }

    /**
     * This utility extracts files and directories of a standard zip file to
     * a destination directory.
     */
    class Unzip extends Using
    {
        // the maximum number of bytes at a time to read from the zip file
        val BUFFER_SIZE = 4096

        /**
         * Make directories.
         *
         * @param directory the directory path to create
         */
        def mkdir (directory: String): Unit =
        {
            val dir = new File(directory)
            if (!dir.exists)
            {
                val _ = dir.mkdir
            }
        }

        /**
         * Iterates over entries in the zip file.
         *
         * Note: Since there is no way to know if the zip is exhausted except by
         * attempting getNextEntry, calling hasNext will attempt to read the next entry
         * and store the value in a var for next() to return.
         *
         * @param zip the opened zip input stream
         */
        case class ZipEntries (zip: ZipInputStream) extends Iterator[ZipEntry]
        {
            @SuppressWarnings(Array("org.wartremover.warts.Var", "org.wartremover.warts.Null"))
            var entry: ZipEntry = _

            override def hasNext: Boolean =
            {
                if (null == entry)
                    entry = zip.getNextEntry
                null != entry
            }

            @SuppressWarnings(Array("org.wartremover.warts.Null"))
            override def next (): ZipEntry =
            {
                val ret = entry
                entry = null
                ret
            }
        }

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
            mkdir(directory)
            using(new ZipInputStream(new FileInputStream(file)))
            {
                zip =>
                    for (entry <- ZipEntries(zip))
                    {
                        val path = s"$directory${entry.getName}"
                        if (entry.isDirectory)
                            mkdir(path) // if the entry is a directory, make the directory
                        else
                            extractFile(zip, path) // if the entry is a file, extract it
                        zip.closeEntry()
                    }
            }
        }

        /**
         * Iterator over the bytes in the zip entry.
         *
         * Note: Since there is no way to know if the entry is exhausted except by reading,
         * since the available() method doesn't signal EOF until next() has returned -1,
         * which, if you ask me, is kind of useless, so
         * we need to guard against a -1 return in next(),
         * which leads to one extra 0 byte write at the end.
         *
         * @param zip   the zip stream opened at the entry
         * @param bytes an array to store the entry bytes in
         */
        case class Bytes (zip: ZipInputStream, bytes: Array[Byte]) extends Iterator[Int]
        {
            override def hasNext: Boolean = 0 != zip.available()

            override def next (): Int =
            {
                val n = zip.read(bytes)
                if (-1 == n) 0 else n
            }
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
            val bytes = new Array[Byte](BUFFER_SIZE)
            using(new BufferedOutputStream(new FileOutputStream(path)))
            {
                bos =>
                    for (read <- Bytes(zip, bytes))
                        bos.write(bytes, 0, read)
            }
        }
    }

}