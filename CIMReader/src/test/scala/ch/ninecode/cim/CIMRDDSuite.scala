package ch.ninecode.cim

import java.io.File

import scala.util.Random

import org.apache.hadoop.conf.Configuration
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.Row
import org.apache.spark.sql.SparkSession

import ch.ninecode.model.Element
import ch.ninecode.model.Unknown

class CIMRDDSuite extends ch.ninecode.SparkSuite
{
    val FILE_DEPOT = "data/"
    val FILENAME1x = s"${FILE_DEPOT}RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_EQ_v2.xml"
    val FILENAME2x = s"${FILE_DEPOT}RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_TP_v2.xml"
    val FILENAME3x = s"${FILE_DEPOT}RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_SSH_v2.xml"

    override def run (testName: Option[String], args: org.scalatest.Args): org.scalatest.Status =
    {
        // unpack the zip file
        new Unzip().unzip(s"${FILE_DEPOT}CGMES_v2.4.15_TestConfigurations_v4.0.3.zip", FILE_DEPOT)
        new Unzip().unzip(s"${FILE_DEPOT}RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_v2.zip", s"${FILE_DEPOT}RealGrid/")
        // run the tests
        val ret = super.run(testName, args)
        // erase the unpacked files
        deleteRecursive(new File(s"${FILE_DEPOT}MicroGrid/"))
        deleteRecursive(new File(s"${FILE_DEPOT}MicroGrid_Error/"))
        deleteRecursive(new File(s"${FILE_DEPOT}MiniGrid/"))
        deleteRecursive(new File(s"${FILE_DEPOT}SmallGrid/"))
        deleteRecursive(new File(s"${FILE_DEPOT}RealGrid/"))
        ret
    }

    // number of elements in the file
    // get number of lines at the top level with:
    // grep -P "^[\t]<cim" RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_EQ_v2.xml | wc
    val ELEMENTS1x = 127686
    // for TP & SSH there is no leading tab character
    // grep -P "^<cim" RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_TP_v2.xml | wc
    val ELEMENTS2x = 36431
    val ELEMENTS3x = 43798

    // number of elements in a 1MB chunk
    // tail --bytes=+3145728 RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_EQ_v2.xml | head --bytes=1048576 | grep -P "^[\t]<cim" | wc
    val OFFSET = 3145728
    val PARTIAL_MAP_SIZE = 2858

    def rddFile (filename: String, offset: Long = 0, length: Long = 0)(implicit session: SparkSession): RDD[Row] =
    {
        val size = if (0L != length) length else new File(filename).length() - offset
        val (xml, start, end) = CHIM.read(filename, offset, size)
        // println (s"${start}:${end} ${offset}+${size} ${xml.substring (0, 50)}")
        val parser = new CHIM(xml, start, end)
        val result = CHIM.parse(parser)
        // exclude six OperationalLimitType.limitType in the entsoe namespace:
        assert(result._2.count(!_.contains("<entsoe:")) === 0)
        session.sparkContext.parallelize(result._1.values.toSeq)
    }

    def rddHadoop (map: Map[String, String])(implicit session: SparkSession): RDD[Element] =
    {
        val configuration = map.foldLeft(new Configuration(session.sparkContext.hadoopConfiguration))((c, e) =>
        {
            c.set(e._1, e._2);
            c
        })
        session.sparkContext.newAPIHadoopRDD(configuration, classOf[CIMInputFormat], classOf[String], classOf[Element]).values
    }

    test("Create")
    {
        implicit session: SparkSession =>

            val xml =
                """yadda yadda <cim:PSRType rdf:ID="PSRType_Substation">
                  |<cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>
                  |</cim:PSRType> foo bar""".stripMargin
            val parser = new CHIM(xml.toString)
            val result = CHIM.parse(parser)
            assert(result._1.size === 1)
            assert(result._2.length === 0)
            val rdd = session.sparkContext.parallelize(result._1.toSeq, 2)
            assert(rdd.count() === 1)
    }

    test("Read")
    {
        implicit session: SparkSession =>

            val rdd = rddFile(FILENAME1x)
            assert(rdd.count() === ELEMENTS1x)
    }

    test("Read Partial")
    {
        implicit session: SparkSession =>

            val _ = session.version // reference unused parameter session
            val (xml, start, end) = CHIM.read(FILENAME1x, OFFSET, 1024 * 1024) // exactly a megabyte
            //println (s"${start}:${end} ${OFFSET}+${1024 * 1024} ${xml.substring (0, 50)}")
            val parser = new CHIM(xml, start, end, OFFSET, OFFSET + (1024 * 1024))
            val result = CHIM.parse(parser)
            assert(result._1.size === PARTIAL_MAP_SIZE)
            assert(result._2.length === 0)
            assert(!result._1.exists(_.getClass == classOf[Unknown]))
    }

    test("Merge Partial")
    {
        implicit session: SparkSession =>

            val size = new File(FILENAME2x).length().toInt
            var offset = 0
            var count = 0 // count of elements
            val random = new Random()
            var last: RDD[String] = null // previous result
            while (offset < size)
            {
                var piece = random.nextInt(size / 10)
                if (offset + piece > size)
                    piece = size - offset
                val (xml, start, end) = CHIM.read(FILENAME2x, offset, piece)
                // println (s"${start}:${end} ${offset}+${piece} ${xml.substring (0, 50)}")
                val parser = new CHIM(xml, start, end, offset, offset + piece)
                val result = CHIM.parse(parser)
                // println (s"${result._1.size} elements and ${result._2.size} unknowns")
                assert(result._2.count(!_.contains("<entsoe:")) === 0)
                val rdd = session.sparkContext.parallelize(result._1.keys.toSeq)
                val _ = if (null != last)
                {
                    val int = rdd.intersection(last)
                    if (int.count() != 0)
                    {
                        val i1 = int.collect()
                        println(s"There were non-zero intersections between rdd1 and rdd2 (${i1.length}) like:")
                        for (i <- i1.indices)
                            println(i1(i))
                    }
                    assert(int.count() == 0)
                }
                last = rdd
                offset += piece
                count += result._1.size
            }
            assert(count === ELEMENTS2x)
    }

    test("Hadoop")
    {
        implicit session: SparkSession =>

            val rdd = rddHadoop(Map("mapreduce.input.fileinputformat.inputdir" -> FILENAME2x))
            val unknowns = rdd.collect({ case x: Any if x.getClass == classOf[Unknown] => x.asInstanceOf[Unknown] })
            if (unknowns.count() != 0)
            {
                val u = unknowns.first()
                markup(s"There were non-zero unknowns (${unknowns.count()}) like @line ${u.line} when parsing text starting at ${u.start} and last parse ending at ${u.end} with internal text '${u.guts}'")
            }
            assert(rdd.count() === ELEMENTS2x)
    }

    test("Multiple Files")
    {
        implicit session: SparkSession =>

            val rdd1 = rddHadoop(Map(("mapreduce.input.fileinputformat.inputdir", FILENAME2x)))
            val rdd2 = rddHadoop(Map(("mapreduce.input.fileinputformat.inputdir", FILENAME3x)))
            val rdd3 = rddHadoop(Map(("mapreduce.input.fileinputformat.inputdir", s"$FILENAME2x,$FILENAME3x")))
            assert(rdd1.count() === ELEMENTS2x)
            assert(rdd2.count() === ELEMENTS3x)
            assert(rdd3.count() === (ELEMENTS2x + ELEMENTS3x))
    }

    test("Splits")
    {
        implicit session: SparkSession =>

            val rdd1 = rddHadoop(Map(("mapreduce.input.fileinputformat.inputdir", FILENAME2x)))
            val rdd2 = rddHadoop(Map(("mapreduce.input.fileinputformat.inputdir", FILENAME2x), ("mapreduce.input.fileinputformat.split.maxsize", "655360")))
            assert(rdd1.count() === ELEMENTS2x)
            assert(rdd2.count() === ELEMENTS2x)
    }
}

