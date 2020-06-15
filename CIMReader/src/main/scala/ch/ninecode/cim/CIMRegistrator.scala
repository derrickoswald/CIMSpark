package ch.ninecode.cim

import com.esotericsoftware.kryo.Kryo
import org.apache.spark.serializer.KryoRegistrator

import ch.ninecode.model.BasicElement
import ch.ninecode.model.BasicElementSerializer
import ch.ninecode.model.Unknown
import ch.ninecode.model.UnknownSerializer

class CIMRegistrator extends KryoRegistrator
{
    override def registerClasses (kryo: Kryo)
    {
        kryo.register (classOf[BasicElement], BasicElementSerializer)
        kryo.register (classOf[Unknown], UnknownSerializer)
        val infos = new CHIM ("").classes
        infos.foreach (info => kryo.register (info.subsetter.runtime_class, info.serializer))
    }
}
