package ch.ninecode.cim

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.LocatedFileStatus
import org.apache.hadoop.fs.Path
import org.apache.hadoop.fs.permission.FsAction
import org.apache.hadoop.fs.permission.FsPermission
import org.apache.spark.rdd.RDD

import ch.ninecode.model.Element

abstract class CIMDifferenceProcessor
{
    /**
     * A suitable file system configuration.
     */
    lazy val hdfs_configuration: Configuration =
    {
        val configuration = new Configuration()
        configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem")
        configuration.set("fs.file.impl", "org.apache.hadoop.fs.LocalFileSystem")
        configuration
    }

    /**
     * Permission mask for complete access.
     */
    lazy val wideOpen = new FsPermission(FsAction.ALL, FsAction.ALL, FsAction.ALL)

    /**
     * Save an RDD of String into a single file.
     *
     * @param rdd          the RDD[String] with the file contents
     * @param dst          the name of the file to be created
     * @param header_bytes a sequence of bytes to be prepended onto the file
     * @param tailer_bytes a sequence of bytes to be appended to the file
     * @param temp         the name of the temporary directory to be used
     */
    def save (rdd: RDD[String], dst: String, header_bytes: Array[Byte] = Array(), tailer_bytes: Array[Byte] = Array(), temp: String = "/tmp/difference.rdf"): Unit =
    {
        // setup
        val target = new Path(dst)
        val dstfs = FileSystem.get(target.toUri, hdfs_configuration)
        val work = new Path(dstfs.getWorkingDirectory, temp)
        dstfs.delete(work, true)

        // write the file
        rdd.saveAsTextFile(work.toUri.toString)

        // get a list of generated paths
        val srcfs = FileSystem.get(work.toUri, hdfs_configuration)
        val r = srcfs.listFiles(work, false)
        var files: List[Path] = List()
        while (r.hasNext)
        {
            val f: LocatedFileStatus = r.next
            if (f.getPath.getName != "_SUCCESS")
                files = f.getPath :: files
        }
        files = files.reverse

        // delete any existing file and make required directories
        dstfs.delete(target, false)
        val parent = target.getParent
        if ((null != parent) && ("" != parent.toString))
        {
            if (dstfs.mkdirs(parent, wideOpen))
                dstfs.setPermission(parent, wideOpen)
        }

        // manually copy all the partition parts
        val out = dstfs.create(target)
        out.write(header_bytes)
        val buf = new Array[Byte](1048576)
        for (f <- files)
        {
            val in = srcfs.open(f)
            var length = in.available
            while (length > 0)
            {
                val count = in.read(buf)
                out.write(buf, 0, count)
                length = length - count
            }
            in.close()
        }
        out.write(tailer_bytes)
        out.close()

        // delete the stupid .crc file
        val index = dst.lastIndexOf("/")
        val crc = if (-1 != index) s"${dst.substring(0, index + 1)}.${dst.substring(index + 1)}.crc" else s".$dst.crc"
        dstfs.delete(new Path(crc), false)

        // clean up temporary directory
        dstfs.delete(work, true)
    }

    /**
     * Perform the difference function on the supplied full outer join.
     *
     * val left = (1,"a"), (2, "b"), (3, "c")
     * val right = (0,"x"), (2, "y"), (4, "z")
     * val join = left.fullOuterJoin (right)
     * (4,(None,Some(z))), (0,(None,Some(x))), (1,(Some(a),None)), (2,(Some(b),Some(y))), (3,(Some(c),None))
     *
     * @param join the full outer join between the from and to CIM files
     */
    def execute (join: RDD[(String, (Option[Element], Option[Element]))]): Unit
}
