package ch.ninecode.cim

import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output

abstract class CIMSerializer[T] extends Serializer[T]
{
    val INTSIZE = 0
    val SHORTSIZE = 1
    val BYTESIZE = 2

    def writeBitfields (output: Output)(implicit bitfields: Array[Int]): Unit =
    {
        val length = bitfields.length // maximum of 4, so it fits in the 4 least significant bits
        val size = if (bitfields.forall(x => x == (x & 0xff))) // all fit in a byte
            BYTESIZE
        else
            if (bitfields.forall(x => x == (x & 0xffff))) // all fit in a short
                SHORTSIZE
            else
                INTSIZE
        val coded = length | (size << 4)

        // generate the serialized bytes
        output.writeByte(coded)
        size match
        {
            case INTSIZE => output.writeInts(bitfields)
            case SHORTSIZE => output.writeShorts(bitfields.map(_.asInstanceOf[Short]))
            case BYTESIZE => output.writeBytes(bitfields.map(_.asInstanceOf[Byte]))
        }
    }

    def readBitfields (input: Input): Array[Int] =
    {
        val coded = input.readByte
        val length = coded & 0xf
        val size = (coded >> 4) & 0xf
        size match
        {
            case INTSIZE => input.readInts(length)
            case SHORTSIZE => input.readShorts(length).map(_.asInstanceOf[Int]).map(_ & 0xffff)
            case BYTESIZE => input.readBytes(length).map(_.asInstanceOf[Int]).map(_ & 0xff)
        }
    }

    def writeList (list: List[String], output: Output): Unit =
    {
        if (null != list)
        {
            output.writeVarInt(list.length, true)
            list.foreach(output.writeString)
        }
        else
            output.writeVarInt(-1, true)
    }

    def readList (input: Input): List[String] =
    {
        val l = input.readVarInt(true)
        if (l >= 0)
        {
            val s = for (_ <- 0 until l)
                yield input.readString
            s.toList
        }
        else
            null
    }

    def isSet (i: Int)(implicit bitfields: Array[Int]): Boolean = 0 != (bitfields(i / 32) & (1 << (i % 32)))

    def writeFields (fields: Array[() => Unit])(implicit bitfields: Array[Int]): Unit =
    {
        for (i <- fields.indices)
            if (isSet(i))
                fields(i)()
    }
}
