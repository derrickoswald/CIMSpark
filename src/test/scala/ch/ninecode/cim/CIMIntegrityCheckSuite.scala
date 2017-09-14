package ch.ninecode.cim

import java.util

import org.apache.spark.sql.SparkSession

class CIMIntegrityCheckSuite extends ch.ninecode.SparkSuite
{
    val FILE_DEPOT = "private_data/"

    test ("Integrity")
    {
        implicit spark: SparkSession ⇒

        val filename =
            FILE_DEPOT + "TRA5200" + ".rdf"
        val options = new util.HashMap[String, String] ().asInstanceOf[util.Map[String,String]]
        val elements = readFile (filename, options)
        println (elements.count + " elements")
        val check = new CIMIntegrityChecker (spark)
        val errors: Option[String] = check.checkAll
        println (errors match { case Some (string) ⇒ string; case None ⇒ "no errors" })
    }
}
