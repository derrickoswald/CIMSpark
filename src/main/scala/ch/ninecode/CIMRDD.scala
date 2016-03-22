package ch.ninecode

import java.io.FileInputStream
import java.io.File

import org.apache.hadoop.conf.Configuration

import org.apache.spark.rdd.RDD
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.hive.thriftserver.HiveThriftServer2

//// NOTE: in order to get maven and scala to work together in Eclipse
//// I needed to install the maven-scala plugin from here:
//// http://alchim31.free.fr/m2e-scala/update-site/

/**
 * Wrapper class for CIM.
 *
 * This class isolates the Spark related dependencies, so the CIM
 * class remains unencumbered by the heavy overhead.
 *
 */
object CIMRDD
{
    def read (filename: String, offset: Long = 0, length: Long = 0): String =
    {
        val in = new FileInputStream (filename)
        in.skip (offset)
        val bytes = new Array[Byte] (length.asInstanceOf[Int]); // ToDo: handle file sizes bigger than 2GB
        in.read (bytes)
        val text = new org.apache.hadoop.io.Text ()
        text.append (bytes, 0, length.asInstanceOf[Int])
        val xml = text.toString ()

        return (xml)
    }

    def rddFile (sc: SparkContext, filename: String, offset: Long = 0, length: Long = 0): RDD[Element] =
    {
        var size: Long = length
        if (0 == size)
            size = new File (filename).length () - offset
        val xml = CIMRDD.read (filename, offset, size)
        val parser = new CIM (xml, offset, offset + size)
        val map = parser.parse ()
        return (sc.parallelize (map.values.toSeq))
    }

    def rddHadoop (sc: SparkContext, hdfs: String): RDD[Element] =
    {
        // make a config
        val configuration = new Configuration (sc.hadoopConfiguration)
        configuration.set ("mapreduce.input.fileinputformat.inputdir", hdfs);

        // RDD[(String, Element)]
        val rdd = sc.newAPIHadoopRDD (configuration, classOf[CIMInputFormat], classOf[String], classOf[Element])
        return (rdd.values)
    }

    def main (args:Array[String])
    {
        val conf = new SparkConf ().setAppName ("CIMScala")
//        val master = if (args.size > 0) args (0) else "local"
//        conf.setMaster (master)
        val spark = new SparkContext (conf)

        try
        {
            if (args.size > 0)
            {
                // set up the SQL context
                val sql_context = new HiveContext (spark)
                println ("context established")

                // start the thrift JDBC server on port 10000
                HiveThriftServer2.startWithContext (sql_context)
                println ("thriftserver started")

                val filename = args (0)

                // show databases
                println ("databases")
                var sql = "show databases";
                val databases = sql_context.sql (sql)
                for (database <- databases)
                   println (database)

                sql = "create temporary table elements using ch.ninecode.cim options (path 'file://" + filename + "')"
                val dataframe = sql_context.sql (sql)
                val count = sql_context.sql ("select count(*) from elements")
                println ("dataframe created with " + count.head().getLong(0) + " elements")

                println ("tables")
                val tables = sql_context.tableNames ()
                for (table <- tables)
                   println (table)

                println ("Press [Return] to exit...")
                System.console().readLine()
            }
            else
                println ("CIM XML input file not specified")
        }
        finally
        {
            spark.stop ();
        }
    }
}
