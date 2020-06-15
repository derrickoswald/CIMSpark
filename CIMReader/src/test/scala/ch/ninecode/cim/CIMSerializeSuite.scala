package ch.ninecode.cim

import java.io.File
import java.io.FileInputStream

import scala.reflect.ClassTag

import org.apache.spark.SparkConf
import org.apache.spark.serializer.KryoSerializer
import org.apache.spark.serializer.SerializerInstance

import ch.ninecode.Unzip
import ch.ninecode.model.BasicElement
import ch.ninecode.model.Element
import ch.ninecode.model.IdentifiedObject

import org.scalatest.BeforeAndAfter
import org.scalatest.Outcome
import org.scalatest.funsuite.FixtureAnyFunSuite

class CIMSerializeSuite extends FixtureAnyFunSuite with BeforeAndAfter with Unzip
{
    override type FixtureParam = SerializerInstance

    val KRYO_REGISTRATION_REQUIRED = "spark.kryo.registrationRequired"
    val KRYO_RESISTRATOR = "spark.kryo.registrator"

    val FILE_DEPOT = "data/"
    val FILENAME = "DemoData"

    before
    {
        new Unzip ().unzip (s"$FILE_DEPOT$FILENAME.zip", FILE_DEPOT)
    }

    after
    {
        val _ = new File (s"$FILE_DEPOT$FILENAME.rdf").delete
    }

//    def toBytes (buffer: java.nio.ByteBuffer): String =
//    {
//        buffer.array.map (b => if (b >= 32 && b <= 126) b.asInstanceOf[Char].toString else s" ${b.toHexString} ").mkString ("")
//    }

    def check[T <: Element: ClassTag](t: T)(implicit serializer: SerializerInstance): Int =
    {
        val buffer = serializer.serialize (t)
        val bytes = buffer.remaining
        // info (s"$bytes bytes", None)
        // info (s"${toBytes (buffer)}", None)
        val o = serializer.deserialize[T] (buffer)
        assert (o.bitfields.sameElements (t.bitfields))
        assert (o === t)
        bytes
    }

    override protected def withFixture (test: OneArgTest): Outcome =
    {
        val configuration = new SparkConf (false)
            .set (KRYO_REGISTRATION_REQUIRED, "true")
            .registerKryoClasses (CIMClasses.list)
            .set (KRYO_RESISTRATOR, "ch.ninecode.cim.CIMRegistrator")

        // val serializer = new org.apache.spark.serializer.JavaSerializer (configuration).newInstance ()
        val serializer = new KryoSerializer (configuration).newInstance ()
        withFixture (test.toNoArgTest (serializer))
    }

    test ("basic")
    {
        implicit serializer =>
            val MRID = "_20480b94-e981-4a76-9c88-4aef3d1b8be2"
            val basic = BasicElement (
                null,
                mRID = MRID
            )
            basic.bitfields = BasicElement.fieldsToBitfields ("mRID")
            val obj = IdentifiedObject (
                Element = basic,
                aliasName = "KAB0202002",
                description = "a simple identified object",
                mRID = MRID,
                name = "GKN 3x150se/150 1/0.6 kV",
                DiagramObjects = "object1" :: "object2" :: Nil
            )
            obj.bitfields = IdentifiedObject.fieldsToBitfields ("aliasName", "description", "mRID", "name", "DiagramObjects")
            check (obj)
    }

    test ("simple")
    {
        implicit serializer =>

            val filename = s"$FILE_DEPOT$FILENAME.rdf"
            val fis = new FileInputStream (filename)
            val size = fis.available ()
            fis.close ()

            val (xml, start, end) = CHIM.read (filename: String, 0L, size, 0L)
            val parser = new CHIM (xml, start, end)
            val result = CHIM.parse (parser)
            assert (result._2.size === 0)

            val total = result._1.values.map (check).sum
            info (s"$total bytes", None)
    }
}
