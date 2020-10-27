package ch.ninecode.cim

import java.io.File

import org.apache.spark.sql.SparkSession

class CIMIntegrityCheckSuite extends ch.ninecode.SparkSuite
{
    val FILE_DEPOT = "data/"

    override def run (testName: Option[String], args: org.scalatest.Args): org.scalatest.Status =
    {
        // unpack the zip files
        new Unzip().unzip(s"${FILE_DEPOT}DemoData.zip", FILE_DEPOT)

        // run the tests
        val ret = super.run(testName, args)

        // erase the unpacked files
        deleteRecursive(new File(s"${FILE_DEPOT}DemoData.rdf"))

        ret
    }

    test("Integrity")
    {
        implicit spark: SparkSession =>

            val filename = s"${FILE_DEPOT}DemoData.rdf"
            val elements = readFile(filename)
            // grep "rdf:ID" DemoData.rdf | wc  =>  1742
            assert(1742 == elements.count, "# elements")
            val check = new CIMIntegrityChecker(spark)
            val errors = check.checkAll match
            {
                case Some(string) => string;
                case None => "no errors"
            }
            assert(errors == "no errors", "expected no errors")
    }
}
