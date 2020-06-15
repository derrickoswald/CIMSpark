package ch.ninecode.cim

import java.nio.ByteBuffer

import scala.reflect.ClassTag

import com.esotericsoftware.kryo.Kryo
import org.apache.spark.SparkConf
import org.apache.spark.serializer.KryoRegistrator
import org.apache.spark.serializer.KryoSerializer
import org.apache.spark.serializer.SerializerInstance

import ch.ninecode.Unzip
import ch.ninecode.model._
import org.scalatest.Outcome
import org.scalatest.funsuite.FixtureAnyFunSuite

class CIMRegistrator extends KryoRegistrator
{
    override def registerClasses (kryo: Kryo)
    {
        kryo.register (classOf[IdentifiedObject], IdentifiedObjectSerializer)
    }
}

class CIMSerializeSuite extends FixtureAnyFunSuite with Unzip
{
    override type FixtureParam = SerializerInstance

    val KRYO_REGISTRATION_REQUIRED = "spark.kryo.registrationRequired"
    val KRYO_RESISTRATOR = "spark.kryo.registrator"

    def toBytes (buffer: ByteBuffer): String =
    {
        buffer.array.map (b => if (b >= 32 && b <= 126) b.asInstanceOf[Char].toString else s" ${b.toHexString} ").mkString ("")
    }

    def check[T <: Element: ClassTag](t: T)(implicit serializer: SerializerInstance): Unit =
    {
        val buffer = serializer.serialize (t)
        info (s"${buffer.remaining} bytes", None)
        info (s"${toBytes (buffer)}", None)
        val o = serializer.deserialize[T] (buffer)
        assert (o === t)
        assert (o.bitfields.sameElements (t.bitfields))
    }

    override protected def withFixture (test: OneArgTest): Outcome =
    {
        val configuration = new SparkConf (false)
            .set (KRYO_REGISTRATION_REQUIRED, "true")
//            .registerKryoClasses (CIMClasses.list)
            .set (KRYO_RESISTRATOR, "ch.ninecode.cim.CIMRegistrator")
            .registerKryoClasses (Array (classOf[ch.ninecode.model.IdentifiedObject]))

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

}
