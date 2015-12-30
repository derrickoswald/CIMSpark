package ch.ninecode

import org.apache.spark.rdd.RDD
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

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
    def rddFile (sc: SparkContext, filename: String): RDD[(String, Element)] =
    {
        val xml = CIM.read (filename)
        val parser = new CIM ()
        val result = parser.parse (xml)
        return (sc.parallelize (result.PowerSystemResources.toSeq))
    }

    def main (args:Array[String])
    {
        val master = if (args.size > 0) args (0) else "local"
        val conf = new SparkConf ().setAppName ("CIMScala").setMaster (master)
        val sc = new SparkContext (conf)

        if (args.size > 0)
        {
            val xml = CIM.read (args (0))
            rddFile (sc, xml)
        }
        else
            println ("CIM XML input file not specified")
    }
}
