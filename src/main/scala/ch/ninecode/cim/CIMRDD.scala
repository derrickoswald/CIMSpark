package ch.ninecode.cim

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.hive.thriftserver.HiveThriftServer2
import org.slf4j.LoggerFactory

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
    private val log = LoggerFactory.getLogger(getClass)

    def main (args:Array[String])
    {
        val conf = new SparkConf ()
        conf.setAppName ("CIMReader JDBC Server")
        conf.setMaster ("spark://sandbox:7077")
        val spark = new SparkContext (conf)

        try
        {
            if (args.size > 0)
            {
                // set up the SQL context
                val session_builder = SparkSession.builder()
                session_builder.enableHiveSupport()
                val sql_context = session_builder.getOrCreate().sqlContext
                log.info ("context established")

                // set the port if it was specified, otherwise use the default of port 10000
                if (args.size > 1)
                {
                    val port = args(1)
                    // ToDo: check it's a number
                    sql_context.setConf("hive.server2.thrift.port", port)
                }

                // start the thrift JDBC server
                HiveThriftServer2.startWithContext (sql_context)
                log.info ("thriftserver started")

                var filename = args (0)
                if (!filename.startsWith ("file:") && !filename.startsWith ("hdfs:"))
                {
                    log.warn ("filename without scheme, changing " + filename + " to " + "file://" + filename)
                    filename = "file://" + filename
                }

                // show databases
//                log.info ("databases")
//                var sql = "show databases";
//                val databases = sql_context.sql (sql)
//                for (database <- databases)
//                   log.info (database.toString ())

                log.info ("create temporary table")
                var sql = "create temporary table elements using ch.ninecode.cim options (path '" + filename + "')"
                val dataframe = sql_context.sql (sql)
                val count = sql_context.sql ("select count(*) from elements")
                println ("dataframe created with " + count.head().getLong(0) + " elements")

                log.info ("tables")
                val tables = sql_context.tableNames ()
                for (table <- tables)
                   log.info (table.toString ())

                println ("Press [Return] to exit...")
                System.console().readLine()
            }
            else
                log.error ("CIM XML input file not specified")
        }
        finally
        {
            spark.stop ();
        }
    }
}
