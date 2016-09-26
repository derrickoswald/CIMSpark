package ch.ninecode.model

import java.io.File
import java.io.FileInputStream
import java.util.regex.Pattern

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap
import scala.reflect.ClassTag
import scala.reflect.classTag
import scala.reflect.runtime.universe.TypeTag

import org.apache.spark.sql.catalyst.expressions.GenericInternalRow
import org.apache.spark.sql.catalyst.expressions.GenericMutableRow
import org.apache.spark.sql.catalyst.expressions.UnsafeRow
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.types.DataType
import org.apache.spark.sql.types.NullType
import org.apache.spark.sql.types.SQLUserDefinedType
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.UserDefinedType
import org.apache.spark.unsafe.types.UTF8String
import org.apache.spark.sql.Row

import ch.ninecode.Context
import ch.ninecode.cim.CIMSubsetter

// From SparkR package:
//busbars = sql (sqlContext, "select * from BusbarSection")
//rbusbars = SparkR::collect (busbars, stringsAsFactors=FALSE)
//# first busbar
//b = rbusbars[1,]
//# sup - first column = list of 1
//b = rbusbars[1,][[1]]
//# Connector
//b = rbusbars[1,][[1]][[1]]
//# ConductingEquipment
//b = rbusbars[1,][[1]][[1]][[1]]
//# Equipment
//b = rbusbars[1,][[1]][[1]][[1]][[1]]
//# PowerSystemResource
//b = rbusbars[1,][[1]][[1]][[1]][[1]][[1]]
//# IdentifiedObject
//b = rbusbars[1,][[1]][[1]][[1]][[1]][[1]][[1]]

case class SerializableObject (name: String) extends Serializable

trait Parser
{
    val namespace = "cim"
    val rddex = Pattern.compile ("""\s*<(""" + namespace + """:[^>\.\s]+)([>\s][\s\S]*?)<\/\1>\s*""") // important to consume leading and trailing whitespace
    def element (name: String) = (Pattern.compile ("""<""" + namespace + """:""" + name + """>([\s\S]*?)<\/""" + namespace + """:""" + name + """>"""), 1)
    def attribute (name: String) = (Pattern.compile ("""<""" + namespace + """:""" + name + """\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>"""), 2)

    /**
     * Abstract parse function.
     * To be overridden in each implemented class.
     */
    def parse (context: Context): Element

    /**
     * Parse one XML element from a string.
     * @param pattern the regular expression pattern to look for
     * @param index the number of the capture group to extract from within the pattern
     * @param context the context for the substring in the XML and
     * line number and position context for reporting in case of an error
     * @return the matched group from the regular expression
     */
    def parse_element (pattern: Tuple2[Pattern, Int])(context: Context): String =
    {
        var ret:String = null

        val matcher = pattern._1.matcher (context.xml)
        if (matcher.find ())
        {
            ret = matcher.group (pattern._2)
            if (context.DEBUG)
                context.coverage += Tuple2 (matcher.start (), matcher.end ())
        }

        return (ret)
    }

    /**
     * Parse one attribute from an XML string.
     * @param pattern the regular expression pattern to look for
     * @param index the number of the capture group to extract from within the pattern
     * @param context the context for the substring in the XML and
     * line number and position context for reporting in case of an error
     * @return the attribute value (with leading # stripped off)
     */
    def parse_attribute (pattern: Tuple2[Pattern, Int])(context: Context): String =
    {
        var ret = parse_element (pattern)(context)
        if ((null != ret) && ret.startsWith ("#")) // remove '#'
            ret = ret.substring (1)

        return (ret)
    }

    def toBoolean (string: String, context: Context): Boolean =
    {
        var ret = false

        if ((null != string) && ("" != string))
            try
            {
                ret = string.toBoolean
            }
            catch
            {
                case nfe: IllegalArgumentException ⇒ throw new Exception ("unparsable boolean (" + string + ") found while parsing at line " + context.line_number ())
            }

        return (ret);
    }

    def toInteger (string: String, context: Context): Int =
    {
        var ret: Int = 0

        if ((null != string) && ("" != string))
            try
            {
                ret = string.toInt
            }
            catch
            {
                case nfe: NumberFormatException ⇒ throw new Exception ("unparsable integer (" + string + ") found while parsing at line " + context.line_number ())
            }

        return (ret);
    }

    def toDouble (string: String, context: Context): Double =
    {
        var ret = 0.0

        if ((null != string) && ("" != string))
            try
            {
                ret = string.toDouble
            }
            catch
            {
                case nfe: NumberFormatException ⇒ throw new Exception ("unparsable double (" + string + ") found while parsing at line " + context.line_number ())
            }

        return (ret);
    }
}

abstract class Parseable[A <: Product : ClassTag : TypeTag]
extends
    Parser
{
    def runtime_class = classTag[A].runtimeClass
    def classname = runtime_class.getName
    def cls: String = { classname.substring (classname.lastIndexOf (".") + 1) }
//    def elementClassTag: ClassTag[A] = classTag[A]
//    def elementTypeTag: TypeTag[A] = typeTag[A]
//    type myrddtype <: RDD[A]
//    def cast(e: Element) = e.asInstanceOf[A]
//    type mytype <: A
//    def instance () =
//    {
//        val mirror = ru.runtimeMirror (getClass.getClassLoader)
//        val classA = ru.typeOf[A].typeSymbol.asClass
//        val class_mirror = mirror.reflectClass (classA)
//        val constructors = ru.typeOf[A].declaration (ru.nme.CONSTRUCTOR).asTerm.alternatives
//        val constructor = constructors(1).asMethod  // ToDo: this requires zero args constructor be the second one defined
//        val constructor_mirror = class_mirror.reflectConstructor (constructor)
//
//        val a = constructor_mirror()
//        (a.asInstanceOf[Product], typeTag[A])
//    }
    val schema = ScalaReflection.schemaFor[A].dataType.asInstanceOf[StructType]
    // try to avoid deadlock due to https://issues.scala-lang.org/browse/SI-6240
    // and described in http://docs.scala-lang.org/overviews/reflection/thread-safety.html
    val lock: AnyRef = SerializableObject ("scalasucks")
    def register: Unit =
        lock.synchronized
        {
            CHIM.LOOKUP += (("cim" + ":" + cls, this.asInstanceOf[Parseable[Product]]))
            CHIM.SUBSETTERS += (("cim" + ":" + cls, new CIMSubsetter[A] (schema)))
        }
}

// needed to get around error: trait Element accesses protected method clone inside a concrete trait method.
// Add an accessor in a class extending class Object as a workaround.
class ObjectPlus extends Object { protected def cloneplus = clone }

@SQLUserDefinedType(udt = classOf[ElementUDT])
trait Element
extends
    ObjectPlus
with
    Row
with
    Serializable
with
    Cloneable
{
    def sup: Element = null
    def id: String = if (null == sup) "0" else (sup.id)

    override def hashCode (): Int =
    {
        if (null == sup) 0 else sup.hashCode()
    }

    override def equals (other: Any): Boolean =
    {
        other match
        {
            case that: Element => this.sup == that.sup
            case _ => false
        }
    }

    override def copy (): Row =
    {
        val ret: Row = cloneplus.asInstanceOf[Element]
        return (ret)
    }

    override def get (i: Int): Any =
    {
        if (0 == i)
            sup
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = 1
}

/**
 * User-defined type for [[Element]].
 */
class ElementUDT extends UserDefinedType[Element]
{
    // The following type and it's serialization took a lot of trial and error.
    // This is what didn't work for a data type for sup:
    // this
    //   - leads to infinite recursion and stack overflow
    // new StructType ()
    //   - results in illegal index (1) because something doesn't use member count
    // NullType
    //   - works at the cluster level (only uses serialization),
    //     but a second "smarter" deserialization at the client always returns null in the GenericInternalRow
    // stub
    //   - where stub is an instance of another class ElementUDT_stub extends UserDefinedType[Element]
    //     results in the same serialization/deserialization issues as above, but one level away
    // StructType (StructField ("sup", StringType, true) :: Nil)
    //   - works except for hive-thriftserver
    //     where it doesn't handle user defined types (UDT)
    //     see addNonNullColumnValue in https://github.com/apache/spark/blob/master/sql/hive-thriftserver/src/main/scala/org/apache/spark/sql/hive/thriftserver/SparkExecuteStatementOperation.scala
    //     results in scala.MatchError: ch.ninecode.model.ElementUDT@7c008354 (of class ch.ninecode.model.ElementUDT)
    override def sqlType: DataType = NullType

    override def pyUDT: String = "ch.ninecode.cim.ElementUDT"

    override def serialize (obj: Any): InternalRow =
    {
        obj match
        {
            case e: Element =>
            {
                val output = new Array[Any](1)
                output (0) = UTF8String.fromString (e.id.toString)
                val r = new GenericMutableRow (output)
                r
            }
            case _: Any =>
            {
                println ("output _")
                val r = new GenericMutableRow (0)
                r
            }
        }
    }

    override def deserialize (datum: Any): Element =
    {
        datum match
        {
            case row: UnsafeRow => // only GenericInternalRow and InternalRow are used, kept for reference
            {
                var dd = row.getUTF8String (0)
                var ee = if (null == dd) "" else dd.toString ()
                BasicElement (null, ee)
            }
            case row: GenericInternalRow =>
            {
                var dd = row.getUTF8String (0)
                var ee = if (null == dd) "" else dd.toString ()
                BasicElement (null, ee)
            }
            case row: InternalRow =>
            {
                var dd = row.getUTF8String (0)
                var ee = if (null == dd) "" else dd.toString ()
                BasicElement (null, ee)
            }
            case _: Any =>
            {
                println ("in _")
                BasicElement (null, "foo")
            }
        }
    }

    override def userClass: Class[Element] = classOf[Element]

    override def equals (o: Any): Boolean =
    {
        o match
        {
            case v: ElementUDT => true
            case _ => false
        }
    }

    override def hashCode(): Int = classOf[ElementUDT].getName.hashCode()

    override def typeName: String = "element"

    override def asNullable: ElementUDT = this
}

/**
 * Top level element.
 * Not all elements really have an mRID (classes in package Common like PositionPoint and PostalAddress)
 * But our exporter gives them one, and Spark needs identifiers for joins, so for now all elements have an mRID.
 */
case class BasicElement
(
    override val sup: Element = null,
    val mRID: String = null
)
extends
    Element
{
    def this () = { this (null, null) }
    override def id: String = mRID
    override def copy (): Row = { return (clone ().asInstanceOf[Element]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BasicElement
extends
    Parser
{
    /**
     * Parse an element.
     * Simply extracts the id.
     */
    val mRID = parse_element ((Pattern.compile ("""rdf:ID=("|')([\s\S]*?)\1>?"""), 2))_
    override def parse (context: Context): BasicElement =
    {
        return (
            new BasicElement
            (
                null,
                mRID (context)
            )
        )
    }
}

/**
 * Unknown element
 * Default parsed element, when no other more specific class applies
 */
case class Unknown
(
    override val sup: Element = null,
    guts: String,
    line: Int,
    start: Long,
    end: Long
)
extends
    Element
{
    def this () = { this (null, null, 0, 0l, 0l) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[Unknown]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Unknown
extends
    Parser
{
    def parse (context: Context): Unknown =
    {
        if ((context.DEBUG) && (context.errors.size < context.MAXERRORS))
            context.errors += "Unknown element \"" + context.name + "\" at line " + context.line_number ()
        return (
            Unknown
            (
                BasicElement.parse (context),
                context.xml,
                context.line_number (),
                context.start,
                context.end
            )
        )
    }
}

// Classes are organized by CIM package in .scala files and arranged alphabetically within the package.
// All attributes have been included for the classes except:
//   - m:n relations, e.g. ConnectDisconnectFunctions in Switch
//   - containment attributes and relations
//   - some gargantuan classes, e.g. SolarGeneratingUnit
// At the end of a package .scala file is an object with the same name as the package, e.g. Common,
// used to register the classes at runtime.
// ** It is important to include any new classes in their package object so they are registered **
//

/**
 * Common Hierarchical Information Model
 * CIM classes for parsing RDF files.
 */
class CHIM (var xml:String, var start: Long = 0L, var end: Long = 0L) extends Serializable
{
    if (end == 0L)
        end = start + xml.length ()
    val context = new Context (xml, start, start, ArrayBuffer (0L))
    context.index_string (xml, context.start)
    val matcher = Unknown.rddex.matcher (xml) // ToDo: there must be an easier way to get a constant out of a Trait

    var value: Element = null;
    _AssetInfo.register
    Assets.register
    Common.register
    Core.register
    Customers.register
    Metering.register
    Production.register
    Protection.register
    StateVariables.register
    Wires.register
    _Work.register

    def progress (): Float =
    {
        (context.end - context.start).asInstanceOf[Float] / xml.length ().asInstanceOf[Float]
    }

    def parse_one (): Boolean =
    {
        var ret = false
        var found = false
        if (context.end < end)
            while (!found && matcher.find ())
            {
                val name = matcher.group (1)
                // heuristic (along with the while and the 'not a dot' in rddex regular expression)
                // that allows jumping into the middle of a large file:
                // top level RDF elements do not have a period in their name
                if (!name.contains ('.'))
                {
                    context.xml = matcher.group (2)
                    context.name = name
                    value = CHIM.LOOKUP.getOrElse (name, Unknown).parse (context)

                    // return success unless there was unrecognized text before the match
                    // that wasn't at the start of the xml
                    ret = (context.end == (matcher.start () + context.start)) || (context.end == context.start)
                    // or there is non-whitespace not covered
                    if (context.DEBUG)
                        if (!context.covered () && context.STOP_ON_ERROR)
                            ret = true

                    // set up for next parse
                    context.end = matcher.end () + context.start
                    context.coverage.clear ()
                    found = true
                }
            }
        return (ret)
    }

    def parse (): HashMap[String, Element] =
    {
        var print = true
        val ret = HashMap[String, Element] ()
        while (parse_one ())
            ret.put (value.id, value)

        return (ret)
    }
}

object CHIM
{
    val CHUNK = 1024*1024*64
    val OVERREAD = 4096 // should be large enough that no RDF element is bigger than this

    val LOOKUP = new HashMap[String, Parseable[Product]]
    val SUBSETTERS = new HashMap[String, CIMSubsetter[_]]

    def apply_to_all_classes (fn: (CIMSubsetter[_]) => Unit) =
    {
        val chim = new CHIM ("") // ensure registration has occured
        for ((name, subsetter) <- SUBSETTERS.iterator)
            fn (subsetter)
    }

    def adjustment (buffer: Array[Byte], low: Int, high: Int, also_upper_bound: Boolean): Tuple2[Int, Int] =
    {
        var lo = low
        var hi = high

        // skip to next UTF-8 non-continuation byte (high order bit zero)
        // by advancing past at most 4 bytes
        var i = 0
        if ((buffer(lo) & 0xc0) != 0xc0) // check for the start of a UTF-8 character
            while ((lo < high) && (0 != (buffer(lo) & 0x80)) && (i < 4))
            {
                lo += 1
                i += 1
            }

        // avoid eating a partial UTF-8 character at the end of the buffer
        var j = 0
        if (also_upper_bound)
        {
            var done = false
            while (!done && (hi - 1 >= lo) && (0 != (buffer(hi - 1) & 0x80)) && (j < 4))
            {
                hi -= 1
                j += 1
                if ((buffer(hi) & 0xc0) == 0xc0)
                    done = true
            }
        }

        (i, j)
    }

    def read (filename: String, offset: Long, size: Long = CHUNK, overread: Long = OVERREAD) =
    {
        var ret: String = null

        var limit: Long = 0L
        val file = new File (filename)
        if (file.exists ()) // avoid FileNotFoundException
        {
            // open the file and skip to the starting offset
            val fis = new FileInputStream (file)
            val gross = fis.available ()
            val skipped = fis.skip (offset)
            if (offset == skipped)
            {
                // the amount extra to read so we get a complete RDF element at the end
                val extra = if (gross > offset + size + overread) overread else Math.max (0, gross - offset - size)
                // the size including extra as an integer
                val span: Int = if ((size + extra) > Int.MaxValue) Int.MaxValue else (size + extra).asInstanceOf[Int]
                // allocate a stringbuilder big enough
                val sb = new StringBuilder (span)
                // the number of bytes read in so far
                var count:Long = 0
                // a flag to indicate a file read error
                var stop = false
                // a chunk sized byte buffer with room for one more partial UTF-8 character
                val buffer = new Array[Byte] (CHUNK + 4)
                // place in the buffer where to start putting the bytes being read in
                var lo = 0
                do
                {
                    // calculate how much there is still to read in
                    val max = size + overread - count
                    val actual = fis.read (buffer, lo, if (max > CHUNK) CHUNK else max.asInstanceOf[Int])
                    if (0 < actual)
                    {
                        // high water mark for valid bytes in the buffer
                        var hi = actual + lo

                        // strip any BOM(Byte Order Mark) i.e. 0xEF,0xBB,0xBF
                        if ((0 == offset) && (0 == count)) // start of the file
                            if ((actual >= 3) && (buffer (lo) == 0xef) && (buffer (lo + 1) == 0xbb) && (buffer (lo + 2) == 0xbf))
                                lo += 3

                        // get minor adjustment to land on UTF-8 character boundary
                        var (i, j) = adjustment (buffer, lo, hi, count + actual < gross) // upper bound too if not at the end of the file

                        val tripwire: Boolean = ((count + actual >= size) && (0 == limit)) // first time crossing the requested end boundary
                        if (tripwire)
                        {
                            val stub = new String (buffer, lo + i, (size - count).asInstanceOf[Int], "UTF8")
                            limit = sb.length + stub.length
                        }

                        // form the string and add it to the buffer
                        val s = new String (buffer, lo + i, hi - j, "UTF8")
                        sb.append (s)

                        // move the partial UTF-8 character at the end of the buffer to the beginning
                        i = 0
                        while (j > 0)
                        {
                            buffer(i) = buffer(hi)
                            i += 1
                            j -= 1
                        }

                        // update the count of bytes read in
                        count += actual
                    }
                    else
                        stop = true
                }
                while (!stop && (count < size + overread))
                fis.close ()
                ret = sb.toString ()
            }
            else
                println ("CIM XML input file cannot be skipped to offset " + offset + ", actual " + skipped)
        }
        else
            println ("CIM XML input file '" + filename + "' not found")

        (ret, offset, offset + limit)
    }

    /**
     * Main program for testing purposes.
     */
    def main (args: Array[String])
    {
        if (args.size > 0)
        {
            val filename = args (0)
            val fis = new FileInputStream (filename)
            val size = fis.available ()
            fis.close ();

            val result = new HashMap[String, Element]
            var offset = 0L
            var reading = 0.0
            var parsing = 0.0
            while (offset < size)
            {
                val start = System.nanoTime
                var (xml, lo, hi) = read (filename, offset)
                offset += CHUNK
                val before = System.nanoTime
                reading += (before - start) / 1000

                val parser = new CHIM (xml)
                xml = null
                val map = parser.parse ()
                result ++= map

                val after = System.nanoTime
                parsing += (after - before) / 1000
                print (".")

                for (error <- parser.context.errors)
                    println (error)
            }
            println ()

            println ("reading %g seconds".format (reading / 1e6))
            println ("parsing %g seconds".format (parsing / 1e6))
            println (result.size + " identified elements parsed")
            val subset = result.filter (_._2.getClass() == classOf[Unknown])
            println (subset.size + " unknown elements")
        }
        else
            println ("CIM XML input file not specified")
    }
}
