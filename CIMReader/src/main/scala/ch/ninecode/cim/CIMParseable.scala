package ch.ninecode.cim

import scala.reflect.ClassTag
import scala.reflect.classTag
import scala.reflect.runtime.universe.TypeTag

/**
 * Typed base class for registration and subsetting.
 * Provides facilities to register subclasses with the CHIM parsing framework
 * and forms the subsetting 'typed object' to specify RDDs of specific CIM classes.
 * Typical usage:
 * {{{
 * object Terminal extends Parseable[Terminal]
 * {
 *     // implement Parser abstract method
 *     def parse (context: Context): Terminal = ???
 * }
 * }}}
 *
 * @tparam A The CIM class type.
 */
abstract class CIMParseable[+A <: Product : ClassTag : TypeTag] extends CIMParser
{
    val runtime_class: Class[_] = classTag[A].runtimeClass
    val classname: String = runtime_class.getName
    val cls: String = classname.substring (classname.lastIndexOf (".") + 1)
    val subsetter: CIMSubsetter[_ <: Product] = new CIMSubsetter[A]()
    def register: CIMClassInfo =
        CIMClassInfo (cls, this, subsetter, relations)
    def mask (field: Field, position: Int) (implicit bitfields: Array[Int]): String =
    {
        field match
        {
            case Some (string) =>
                bitfields(position / 32) |= (1 << (position % 32))
                string
            case None =>
                null
        }
    }
    def masks (fields: Fields, position: Int) (implicit bitfields: Array[Int]): List[String] =
    {
        fields match
        {
            case Some (list) =>
                bitfields(position / 32) |= (1 << (position % 32))
                list
            case None =>
                null
        }
    }
}
