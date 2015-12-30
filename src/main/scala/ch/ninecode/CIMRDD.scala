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
        val conf = new SparkConf ().setAppName ("CIMScala")
//        val master = if (args.size > 0) args (0) else "local"
//        conf.setMaster (master)
        val spark = new SparkContext (conf)

        try
        {
            if (args.size > 0)
            {
                val rdd = rddFile (spark, args (0))
                val pf: PartialFunction[(String, ch.ninecode.Element), (String, ch.ninecode.Location)] =
                {
                    case x: (String, Element)
                        if x._2.getClass () == classOf[ch.ninecode.Location] => (x._1, x._2.asInstanceOf[ch.ninecode.Location])
                }
                val locations = rdd.collect (pf)
                println ("collected " + locations.count () + " locations")
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
