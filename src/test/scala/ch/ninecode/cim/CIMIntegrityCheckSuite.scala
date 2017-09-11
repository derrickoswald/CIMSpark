package ch.ninecode.cim

import java.util

import org.apache.spark.sql.SparkSession
import org.apache.spark.rdd.RDD

class CIMIntegrityCheckSuite extends ch.ninecode.SparkSuite
{
    val FILE_DEPOT = "private_data/"

    test ("Integrity")
    {
        implicit spark: SparkSession ⇒

        val filename =
            FILE_DEPOT + "bkw_cim_export_haelig" + ".rdf"
        val options = new util.HashMap[String, String] ().asInstanceOf[util.Map[String,String]]
        val elements = readFile (filename, options)
        println (elements.count + " elements")
        val check = new CIMIntegrityChecker (spark)
        val errors: Option[String] = check.checkAll
        println (errors match { case Some (string) ⇒ string; case None ⇒ "no errors" })
    }
}