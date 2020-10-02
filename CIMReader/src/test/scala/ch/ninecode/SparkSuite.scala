package ch.ninecode

import java.io.File

import scala.reflect.ClassTag
import scala.reflect.classTag

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession

import ch.ninecode.cim.CIMClasses

import org.scalatest.Outcome
import org.scalatest.funsuite.FixtureAnyFunSuite

class SparkSuite extends FixtureAnyFunSuite with Unzip
{
    type FixtureParam = SparkSession

    /**
     * Delete files and directories recursively.
     *
     * @param path The starting path.
     */
    def deleteRecursive (path: File): Unit =
    {
        if (path.isDirectory)
            for (subpath <- path.list)
                deleteRecursive (new File (path, subpath))
        val _ = path.delete
    }

    def withFixture (test: OneArgTest): Outcome =
    {
        // create the configuration

        val configuration = new SparkConf (false)
            .setAppName ("CIMSparkSuite")
            .setMaster ("local[2]")
            .set ("spark.driver.memory", "1g")
            .set ("spark.executor.memory", "1g")
            .set ("spark.ui.port", "4041")
            .set ("spark.ui.showConsoleProgress", "false")
            .registerKryoClasses (CIMClasses.list)
            .set ("spark.kryo.registrator", "ch.ninecode.cim.CIMRegistrator")
        // can't turn on "required" because many Spark internal classes are not registered:
        // IllegalArgumentException: Class is not registered: org.apache.spark.sql.Row
        // .set ("spark.kryo.registrationRequired", "true")

        val session = SparkSession.builder ().config (configuration).getOrCreate () // create the fixture
        session.sparkContext.setLogLevel ("ERROR") // Valid log levels include: ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN
        try
        withFixture (test.toNoArgTest (session)) // "loan" the fixture to the test
        finally session.stop () // clean up the fixture
    }

    def readFile (filename: String, options: Map[String, String] = Map [String, String]())(implicit spark: SparkSession): DataFrame =
    {
        spark.read.format ("ch.ninecode.cim").options (options).load (filename) // ToDo: why doesn't this work? load (filename.split (","):_*)
    }

    /**
     * Get the named RDD.
     *
     * @param name  The name of the RDD, usually the same as the CIM class.
     * @param spark The Spark session which persisted the named RDD.
     * @tparam T The type of objects contained in the named RDD.
     * @return The typed RDD, e.g. <code>RDD[T]</code>.
     * @example                                                   The RDD of all elements is somewhat special,
     *                                                            currently it is named Elements (plural), so this method must be used:
     * {{{val elements: RDD[Element] = get[Element]("Elements")}}}.
     *
     */
    def get[T: ClassTag] (name: String)(implicit spark: SparkSession): RDD[T] =
    {

        val rdd: collection.Map[Int, RDD[_]] = spark.sparkContext.getPersistentRDDs
        rdd.find (_._2.name == name) match
        {
            case Some ((_, rdd: RDD[_])) =>
                rdd.asInstanceOf [RDD[T]]
            case Some (_) =>
                null
            case None =>
                null
        }
    }


    /**
     * Get the typed RDD.
     *
     * Convenience method where the name of the RDD is the same as the contained
     * class type (the usual case).
     *
     * @param spark The Spark session which persisted the typed RDD.
     * @tparam T The type of the RDD, e.g. <code>RDD[T]</code>.
     * @return The RDD with the given type of objects, e.g. <code>RDD[ACLineSegment]</code>.
     */
    def get[T: ClassTag] (implicit spark: SparkSession): RDD[T] =
    {
        val classname = classTag [T].runtimeClass.getName
        val name = classname.substring (classname.lastIndexOf (".") + 1)
        get (name)
    }

    def using[T <: AutoCloseable, R] (resource: T)(block: T => R): R =
    {
        try
        {
            block (resource)
        }
        finally
        {
            resource.close ()
        }
    }
}
