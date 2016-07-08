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
    def register: Unit =
    {
        CHIM.LOOKUP += (("cim" + ":" + cls, this.asInstanceOf[Parseable[Product]]))
        val schema = ScalaReflection.schemaFor[A].dataType.asInstanceOf[StructType]
        CHIM.SUBSETTERS += (("cim" + ":" + cls, new CIMSubsetter[A] (schema)))
    }
}

// needed to get around error: trait Element accesses protected method clone inside a concrete trait method.
// Add an accessor in a class extending class Object as a workaround.
class ObjectPlus extends Object { protected def cloneplus = clone }

@SQLUserDefinedType(udt = classOf[ElementUDT])
sealed trait Element
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


// just to get a schema in CIMRelation
// must be here in this file to avoid error: illegal inheritance from sealed trait Element
case class dummy
(
    override val sup: Element = null
)
extends
    Element

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
case class Unknown (
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

//
// BEGIN CASE CLASS SECTION
//
// Classes are organized by package and arranged alphabetically within a package.
// They cannot be in separate files due to a limitation in Scala (error: illegal inheritance from sealed trait Element).
// If you sort the Outline mode in Eclipse, it is a little easier to find a class.
// All attributes have been included for the classes below except:
//   - m:n relations, e.g. ConnectDisconnectFunctions in Switch
//   - containment attributes and relations
//   - gargantuan classes, e.g. SolarGeneratingUnit
// At the end of a package section is an object with the same name as the package, e.g. Common,
// used to register the classes at runtime.
// ** It is important to include any new classes in their package object so they are registered **
//

/*
 * Package: AssetInfo
 */

case class CableInfo
(
    override val sup: WireInfo,
    val constructionKind: String,
    val diameterOverCore: Double,
    val diameterOverInsulation: Double,
    val diameterOverJacket: Double,
    val diameterOverScreen: Double,
    val isStrandFill: Boolean,
    val nominalTemperature: Double,
    val outerJacketKind: String,
    val sheathAsNeutral: Boolean,
    val shieldMaterial: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0, false, 0.0, null, false, null) }
    def WireInfo: WireInfo = sup.asInstanceOf[WireInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[CableInfo]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CableInfo
extends
    Parseable[CableInfo]
{
    val constructionKind = parse_attribute (attribute ("""CableInfo.constructionKind"""))_

    val diameterOverCore = parse_element (element ("""CableInfo.diameterOverCore"""))_
    val diameterOverInsulation = parse_element (element ("""CableInfo.diameterOverInsulation"""))_
    val diameterOverJacket = parse_element (element ("""CableInfo.diameterOverJacket"""))_
    val diameterOverScreen = parse_element (element ("""CableInfo.diameterOverScreen"""))_
    val isStrandFill = parse_element (element ("""CableInfo.isStrandFill"""))_
    val nominalTemperature = parse_element (element ("""CableInfo.nominalTemperature"""))_
    val outerJacketKind = parse_attribute (attribute ("""CableInfo.outerJacketKind"""))_
    val sheathAsNeutral = parse_element (element ("""CableInfo.sheathAsNeutral"""))_
    val shieldMaterial = parse_attribute (attribute ("""CableInfo.shieldMaterial"""))_
    def parse (context: Context): CableInfo =
    {
        return (
            CableInfo
            (
                WireInfo.parse (context),
                constructionKind (context),
                toDouble (diameterOverCore (context), context),
                toDouble (diameterOverInsulation (context), context),
                toDouble (diameterOverJacket (context), context),
                toDouble (diameterOverScreen (context), context),
                toBoolean (isStrandFill (context), context),
                toDouble (nominalTemperature (context), context),
                outerJacketKind (context),
                toBoolean (sheathAsNeutral (context), context),
                shieldMaterial (context)
            )
        )
    }
}

case class SwitchInfo
(
    override val sup: AssetInfo,
    val breakingCapacity: Double,
    val isSinglePhase: Boolean,
    val isUnganged: Boolean,
    val ratedCurrent: Double,
    val ratedVoltage: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, false, false, 0.0, 0.0) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[SwitchInfo]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SwitchInfo
extends
    Parseable[SwitchInfo]
{
    val breakingCapacity = parse_element (element ("""SwitchInfo.breakingCapacity"""))_
    val isSinglePhase = parse_element (element ("""SwitchInfo.isSinglePhase"""))_
    val isUnganged = parse_element (element ("""SwitchInfo.isUnganged"""))_
    val ratedCurrent = parse_element (element ("""SwitchInfo.ratedCurrent"""))_
    val ratedVoltage = parse_element (element ("""SwitchInfo.ratedVoltage"""))_
    def parse (context: Context): SwitchInfo =
    {
        return (
            SwitchInfo
            (
                AssetInfo.parse (context),
                toDouble (breakingCapacity (context), context),
                toBoolean (isSinglePhase (context), context),
                toBoolean (isUnganged (context), context),
                toDouble (ratedCurrent (context), context),
                toDouble (ratedVoltage (context), context)
            )
        )
    }
}

case class TapChangerInfo
(
    override val sup: AssetInfo,
    val bil: Double,
    val ctRating: Double,
    val ctRatio: Double,
    val frequency: Double,
    val highStep: Int,
    val isTcul: Boolean,
    val lowStep: Int,
    val neutralStep: Int,
    val neutralU: Double,
    val ptRatio: Double,
    val ratedApparentPower: Double,
    val ratedCurrent: Double,
    val ratedVoltage: Double,
    val stepPhaseIncrement: Double,
    val stepVoltageIncrement: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0, false, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[TapChangerInfo]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TapChangerInfo
extends
    Parseable[TapChangerInfo]
{
    val bil = parse_element (element ("""TapChangerInfo.bil"""))_
    val ctRating = parse_element (element ("""TapChangerInfo.ctRating"""))_
    val ctRatio = parse_element (element ("""TapChangerInfo.ctRatio"""))_
    val frequency = parse_element (element ("""TapChangerInfo.frequency"""))_
    val highStep = parse_element (element ("""TapChangerInfo.highStep"""))_
    val isTcul = parse_element (element ("""TapChangerInfo.isTcul"""))_
    val lowStep = parse_element (element ("""TapChangerInfo.lowStep"""))_
    val neutralStep = parse_element (element ("""TapChangerInfo.neutralStep"""))_
    val neutralU = parse_element (element ("""TapChangerInfo.neutralU"""))_
    val ptRatio = parse_element (element ("""TapChangerInfo.ptRatio"""))_
    val ratedApparentPower = parse_element (element ("""TapChangerInfo.ratedApparentPower"""))_
    val ratedCurrent = parse_element (element ("""TapChangerInfo.ratedCurrent"""))_
    val ratedVoltage = parse_element (element ("""TapChangerInfo.ratedVoltage"""))_
    val stepPhaseIncrement = parse_element (element ("""TapChangerInfo.stepPhaseIncrement"""))_
    val stepVoltageIncrement = parse_element (element ("""TapChangerInfo.stepVoltageIncrement"""))_
    def parse (context: Context): TapChangerInfo =
    {
        return (
            TapChangerInfo
            (
                AssetInfo.parse (context),
                toDouble (bil (context), context),
                toDouble (ctRating (context), context),
                toDouble (ctRatio (context), context),
                toDouble (frequency (context), context),
                toInteger (highStep (context), context),
                toBoolean (isTcul (context), context),
                toInteger (lowStep (context), context),
                toInteger (neutralStep (context), context),
                toDouble (neutralU (context), context),
                toDouble (ptRatio (context), context),
                toDouble (ratedApparentPower (context), context),
                toDouble (ratedCurrent (context), context),
                toDouble (ratedVoltage (context), context),
                toDouble (stepPhaseIncrement (context), context),
                toDouble (stepVoltageIncrement (context), context)
            )
        )
    }
}

case class TapeShieldCableInfo
(
    override val sup: CableInfo,
    val tapeLap: Double,
    val tapeThickness: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def CableInfo: CableInfo = sup.asInstanceOf[CableInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[TapeShieldCableInfo]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TapeShieldCableInfo
extends
    Parseable[TapeShieldCableInfo]
{
    val tapeLap = parse_element (element ("""TapeShieldCableInfo.tapeLap"""))_
    val tapeThickness = parse_element (element ("""TapeShieldCableInfo.tapeThickness"""))_
    def parse (context: Context): TapeShieldCableInfo =
    {
        return (
            TapeShieldCableInfo
            (
                CableInfo.parse (context),
                toDouble (tapeLap (context), context),
                toDouble (tapeThickness (context), context)
            )
        )
    }
}

case class WireInfo
(
    override val sup: AssetInfo,
    val coreRadius: Double,
    val coreStrandCount: Int,
    val gmr: Double,
    val insulated: Boolean,
    val insulationMaterial: String,
    val insulationThickness: Double,
    val material: String,
    val rAC25: Double,
    val rAC50: Double,
    val rAC75: Double,
    val rDC20: Double,
    val radius: Double,
    val ratedCurrent: Double,
    val sizeDescription: String,
    val strandCount: Int
)
extends
    Element
{
    def this () = { this (null, 0.0, 0, 0.0, false, null, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0 ) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[WireInfo]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WireInfo
extends
    Parseable[WireInfo]
{
    val coreRadius = parse_element (element ("""WireInfo.coreRadius"""))_
    val coreStrandCount = parse_element (element ("""WireInfo.coreStrandCount"""))_
    val gmr = parse_element (element ("""WireInfo.gmr"""))_
    val insulated = parse_element (element ("""WireInfo.insulated"""))_
    val insulationMaterial = parse_attribute (attribute ("""WireInfo.insulationMaterial"""))_
    val insulationThickness = parse_element (element ("""WireInfo.insulationThickness"""))_
    val material = parse_attribute (attribute ("""WireInfo.material"""))_
    val rAC25 = parse_element (element ("""WireInfo.rAC25"""))_
    val rAC50 = parse_element (element ("""WireInfo.rAC50"""))_
    val rAC75 = parse_element (element ("""WireInfo.rAC75"""))_
    val rDC20 = parse_element (element ("""WireInfo.rDC20"""))_
    val radius = parse_element (element ("""WireInfo.radius"""))_
    val ratedCurrent = parse_element (element ("""WireInfo.ratedCurrent"""))_
    val sizeDescription = parse_element (element ("""WireInfo.sizeDescription"""))_
    val strandCount = parse_element (element ("""WireInfo.strandCount"""))_
    def parse (context: Context): WireInfo =
    {
        return (
            WireInfo
            (
                AssetInfo.parse (context),
                toDouble (coreRadius (context), context),
                toInteger (coreStrandCount (context), context),
                toDouble (gmr (context), context),
                toBoolean (insulated (context), context),
                insulationMaterial (context),
                toDouble (insulationThickness (context), context),
                material (context),
                toDouble (rAC25 (context), context),
                toDouble (rAC50 (context), context),
                toDouble (rAC75 (context), context),
                toDouble (rDC20 (context), context),
                toDouble (radius (context), context),
                toDouble (ratedCurrent (context), context),
                sizeDescription (context),
                toInteger (strandCount (context), context)
            )
        )
    }
}

/*
 * Package: Assets
 */

case class AssetInfo
(
    override val sup: IdentifiedObject,
    val AssetModel: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetInfo]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetInfo
extends
    Parseable[AssetInfo]
{
    val AssetModel = parse_attribute (attribute ("""AssetInfo.AssetModel"""))_
    def parse (context: Context): AssetInfo =
    {
        return (
            AssetInfo
            (
                IdentifiedObject.parse (context),
                AssetModel (context)
            )
        )
    }
}

/*
 * Package: Common
 */

case class ActivityRecord
(
    override val sup: IdentifiedObject,
    val createdDateTime: String,
    val reason: String,
    val severity: String,
    val typ: String,
    val status: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ActivityRecord]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ActivityRecord
extends
    Parseable[ActivityRecord]
{
    val createdDateTime = parse_element (element ("""ActivityRecord.createdDateTime"""))_
    val reason = parse_element (element ("""ActivityRecord.reason"""))_
    val severity = parse_element (element ("""ActivityRecord.severity"""))_
    val typ = parse_element (element ("""ActivityRecord.type"""))_
    val status = parse_attribute (attribute ("""ActivityRecord.status"""))_
    def parse (context: Context): ActivityRecord =
    {
        return (
            ActivityRecord
            (
                IdentifiedObject.parse (context),
                createdDateTime (context),
                reason (context),
                severity (context),
                typ (context),
                status (context)
            )
        )
    }
}

case class Agreement
(
    override val sup: Document,
    val signDate: String, // ToDo: Date handling
    val validityInterval: String // ToDo: DateTime handling
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[Agreement]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Agreement
extends
    Parseable[Agreement]
{
    val signDate = parse_element (element ("""Agreement.signDate"""))_
    val validityInterval = parse_attribute (attribute ("""Agreement.validityInterval"""))_
    def parse (context: Context): Agreement =
    {
        return (
            Agreement
            (
                Document.parse (context),
                signDate (context),
                validityInterval (context)
            )
        )
    }
}

case class Appointment
(
    override val sup: IdentifiedObject,
    val callAhead: Boolean,
    val meetingInterval: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Appointment]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Appointment
extends
    Parseable[Appointment]
{
    val callAhead = parse_element (element ("""Appointment.callAhead"""))_
    val meetingInterval = parse_attribute (attribute ("""Appointment.meetingInterval"""))_
    def parse (context: Context): Appointment =
    {
        return (
            Appointment
            (
                IdentifiedObject.parse (context),
                toBoolean (callAhead (context), context),
                meetingInterval (context)
            )
        )
    }
}

case class ConfigurationEvent
(
    override val sup: ActivityRecord,
    val effectiveDateTime: String,
    val modifiedBy: String,
    val remark: String,
    val ChangedAsset: String,
    val ChangedDocument: String,
    val ChangedLocation: String,
    val ChangedOrganisationRole: String,
    val ChangedPersonRole: String,
    val ChangedServiceCategory: String,
    val ChangedUsagePoint: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { return (clone ().asInstanceOf[ConfigurationEvent]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConfigurationEvent
extends
    Parseable[ConfigurationEvent]
{
    val effectiveDateTime = parse_element (element ("""ConfigurationEvent.effectiveDateTime"""))_
    val modifiedBy = parse_element (element ("""ConfigurationEvent.modifiedBy"""))_
    val remark = parse_element (element ("""ConfigurationEvent.remark"""))_
    val ChangedAsset = parse_attribute (attribute ("""ConfigurationEvent.ChangedAsset"""))_
    val ChangedDocument = parse_attribute (attribute ("""ConfigurationEvent.ChangedDocument"""))_
    val ChangedLocation = parse_attribute (attribute ("""ConfigurationEvent.ChangedLocation"""))_
    val ChangedOrganisationRole = parse_attribute (attribute ("""ConfigurationEvent.ChangedOrganisationRole"""))_
    val ChangedPersonRole = parse_attribute (attribute ("""ConfigurationEvent.ChangedPersonRole"""))_
    val ChangedServiceCategory = parse_attribute (attribute ("""ConfigurationEvent.ChangedServiceCategory"""))_
    val ChangedUsagePoint = parse_attribute (attribute ("""ConfigurationEvent.ChangedUsagePoint"""))_
    def parse (context: Context): ConfigurationEvent =
    {
        return (
            ConfigurationEvent
            (
                ActivityRecord.parse (context),
                effectiveDateTime (context),
                modifiedBy (context),
                remark (context),
                ChangedAsset (context),
                ChangedDocument (context),
                ChangedLocation (context),
                ChangedOrganisationRole (context),
                ChangedPersonRole (context),
                ChangedServiceCategory (context),
                ChangedUsagePoint (context)
            )
        )
    }
}

case class CoordinateSystem
(
    override val sup: IdentifiedObject,
    val crsUrn: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CoordinateSystem]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CoordinateSystem
extends
    Parseable[CoordinateSystem]
{
    val crsUrn = parse_element (element ("""CoordinateSystem.crsUrn"""))_
    def parse (context: Context): CoordinateSystem =
    {
        return (
            CoordinateSystem
            (
                IdentifiedObject.parse (context),
                crsUrn (context)
            )
        )
    }
}

case class Crew
(
    override val sup: IdentifiedObject,
    val CrewType: String,
    val status: String

)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Crew]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Crew
extends
    Parseable[Crew]
{
    val CrewType = parse_attribute (attribute ("""Crew.CrewType"""))_
    val status = parse_attribute (attribute ("""Crew.status"""))_
    def parse (context: Context): Crew =
    {
        return (
            Crew
            (
                IdentifiedObject.parse (context),
                CrewType (context),
                status (context)
            )
        )
    }
}

case class CrewMember
(
    override val sup: OperationPersonRole,
    val Crew: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def OperationPersonRole: OperationPersonRole = sup.asInstanceOf[OperationPersonRole]
    override def copy (): Row = { return (clone ().asInstanceOf[CrewMember]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CrewMember
extends
    Parseable[CrewMember]
{
    val Crew = parse_attribute (attribute ("""CrewMember.Crew"""))_
    def parse (context: Context): CrewMember =
    {
        return (
            CrewMember
            (
                OperationPersonRole.parse (context),
                Crew (context)
            )
        )
    }
}

case class CrewType
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[CrewType]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CrewType
extends
    Parseable[CrewType]
{
    def parse (context: Context): CrewType =
    {
        return (
            CrewType
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

case class Document
(
    override val sup: IdentifiedObject,
    val authorName: String,
    val comment: String,
    val createdDateTime: String, // ToDo: DateTime handling
    val lastModifiedDateTime: String, // ToDo: DateTime handling
    val revisionNumber: String,
    val subject: String,
    val title: String,
    val typ: String,
    val docStatus: String,
    val electronicAddress: String,
    val status: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Document]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Document
extends
    Parseable[Document]
{
    val authorName = parse_element (element ("""Document.authorName"""))_
    val comment = parse_element (element ("""Document.comment"""))_
    val createdDateTime = parse_element (element ("""Document.createdDateTime"""))_
    val lastModifiedDateTime = parse_element (element ("""Document.lastModifiedDateTime"""))_
    val revisionNumber = parse_element (element ("""Document.revisionNumber"""))_
    val subject = parse_element (element ("""Document.subject"""))_
    val title = parse_element (element ("""Document.title"""))_
    val typ = parse_element (element ("""Document.type"""))_
    val docStatus = parse_attribute (attribute ("""Document.docStatus"""))_
    val electronicAddress = parse_attribute (attribute ("""Document.electronicAddress"""))_
    val status = parse_attribute (attribute ("""Document.status"""))_
    def parse (context: Context): Document =
    {
        return (
            Document
            (
                IdentifiedObject.parse (context),
                authorName (context),
                comment (context),
                createdDateTime (context),
                lastModifiedDateTime (context),
                revisionNumber (context),
                subject (context),
                title (context),
                typ (context),
                docStatus (context),
                electronicAddress (context),
                status (context)
            )
        )
    }
}

case class ElectronicAddress
(
    override val sup: Element,
    val email1: String,
    val email2: String,
    val lan: String,
    val mac: String,
    val password: String,
    val radio: String,
    val userID: String,
    val web: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ElectronicAddress]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ElectronicAddress
extends
    Parseable[ElectronicAddress]
{
    val email1 = parse_element (element ("""ElectronicAddress.email1"""))_
    val email2 = parse_element (element ("""ElectronicAddress.email2"""))_
    val lan = parse_element (element ("""ElectronicAddress.lan"""))_
    val mac = parse_element (element ("""ElectronicAddress.mac"""))_
    val password = parse_element (element ("""ElectronicAddress.password"""))_
    val radio = parse_element (element ("""ElectronicAddress.radio"""))_
    val userID = parse_element (element ("""ElectronicAddress.userID"""))_
    val web = parse_element (element ("""ElectronicAddress.web"""))_
    def parse (context: Context): ElectronicAddress =
    {
        return (
            ElectronicAddress
            (
                BasicElement.parse (context),
                email1 (context),
                email2 (context),
                lan (context),
                mac (context),
                password (context),
                radio (context),
                userID (context),
                web (context)
            )
        )
    }
}

case class Hazard
(
    override val sup: IdentifiedObject,
    val typ: String,
    val status: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Hazard]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Hazard
extends
    Parseable[Hazard]
{
    val typ = parse_element (element ("""Hazard.type"""))_
    val status = parse_attribute (attribute ("""Hazard.status"""))_
    def parse (context: Context): Hazard =
    {
        return (
            Hazard
            (
                IdentifiedObject.parse (context),
                typ (context),
                status (context)
            )
        )
    }
}

case class Location
(
    override val sup: IdentifiedObject,
    val direction: String,
    val geoInfoReference: String,
    val typ: String,
    val CoordinateSystem: String,
    val electronicAddress: String,
    val mainAddress: String,
    val phone1: String,
    val phone2: String,
    val secondaryAddress: String,
    val status: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Location]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Location
extends
    Parseable[Location]
{
    val direction = parse_element (element ("""Location.direction"""))_
    val geoInfoReference = parse_element (element ("""Location.geoInfoReference"""))_
    val typ = parse_element (element ("""Location.type"""))_
    val CoordinateSystem = parse_attribute (attribute ("""Location.CoordinateSystem"""))_
    val electronicAddress = parse_attribute (attribute ("""Location.electronicAddress"""))_
    val mainAddress = parse_attribute (attribute ("""Location.mainAddress"""))_
    val phone1 = parse_attribute (attribute ("""Location.phone1"""))_
    val phone2 = parse_attribute (attribute ("""Location.phone2"""))_
    val secondaryAddress = parse_attribute (attribute ("""Location.secondaryAddress"""))_
    val status = parse_attribute (attribute ("""Location.status"""))_
    def parse (context: Context): Location =
    {
        return (
            Location
            (
                IdentifiedObject.parse (context),
                direction (context),
                geoInfoReference (context),
                typ (context),
                CoordinateSystem (context),
                electronicAddress (context),
                mainAddress (context),
                phone1 (context),
                phone2 (context),
                secondaryAddress (context),
                status (context)
            )
        )
    }
}

case class OperationPersonRole
(
    override val sup: PersonRole
)
extends
    Element
{
    def this () = { this (null) }
    def PersonRole: PersonRole = sup.asInstanceOf[PersonRole]
    override def copy (): Row = { return (clone ().asInstanceOf[OperationPersonRole]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OperationPersonRole
extends
    Parseable[OperationPersonRole]
{
    def parse (context: Context): OperationPersonRole =
    {
        return (
            OperationPersonRole
            (
                PersonRole.parse (context)
            )
        )
    }
}

case class Operator
(
    override val sup: OperationPersonRole
)
extends
    Element
{
    def this () = { this (null) }
    def OperationPersonRole: OperationPersonRole = sup.asInstanceOf[OperationPersonRole]
    override def copy (): Row = { return (clone ().asInstanceOf[Operator]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Operator
extends
    Parseable[Operator]
{
    def parse (context: Context): Operator =
    {
        return (
            Operator
            (
                OperationPersonRole.parse (context)
            )
        )
    }
}

case class Organisation
(
    override val sup: IdentifiedObject,
    val electronicAddress: String,
    val phone1: String,
    val phone2: String,
    val postalAddress: String,
    val streetAddress: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Organisation]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Organisation
extends
    Parseable[Organisation]
{
    val electronicAddress = parse_attribute (attribute ("""Organisation.electronicAddress"""))_
    val phone1 = parse_attribute (attribute ("""Organisation.phone1"""))_
    val phone2 = parse_attribute (attribute ("""Organisation.phone2"""))_
    val postalAddress = parse_attribute (attribute ("""Organisation.postalAddress"""))_
    val streetAddress = parse_attribute (attribute ("""Organisation.streetAddress"""))_
    def parse (context: Context): Organisation =
    {
        return (
            Organisation
            (
                IdentifiedObject.parse (context),
                electronicAddress (context),
                phone1 (context),
                phone2 (context),
                postalAddress (context),
                streetAddress (context)
            )
        )
    }
}

case class OrganisationRole
(
    override val sup: IdentifiedObject,
    val Organisation: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[OrganisationRole]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OrganisationRole
extends
    Parseable[OrganisationRole]
{
    val Organisation = parse_attribute (attribute ("""OrganisationRole.Organisation"""))_
    def parse (context: Context): OrganisationRole =
    {
        return (
            OrganisationRole
            (
                IdentifiedObject.parse (context),
                Organisation (context)
            )
        )
    }
}

case class Ownership
(
    override val sup: IdentifiedObject,
    val share: String,  // ToDo: PerCent handling
    val Asset: String,
    val AssetOwner: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Ownership]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Ownership
extends
    Parseable[Ownership]
{
    val share = parse_element (element ("""Ownership.share"""))_
    val Asset = parse_attribute (attribute ("""Ownership.Asset"""))_
    val AssetOwner = parse_attribute (attribute ("""Ownership.AssetOwner"""))_
    def parse (context: Context): Ownership =
    {
        return (
            Ownership
            (
                IdentifiedObject.parse (context),
                share (context),
                Asset (context),
                AssetOwner (context)
            )
        )
    }
}

case class Person
(
    override val sup: IdentifiedObject,
    val firstName: String,
    val lastName: String,
    val mName: String,
    val prefix: String,
    val specialNeed: String,
    val suffix: String,
    val electronicAddress: String,
    val landlinePhone: String,
    val mobilePhone: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Person]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Person
extends
    Parseable[Person]
{
    val firstName = parse_element (element ("""Person.firstName"""))_
    val lastName = parse_element (element ("""Person.lastName"""))_
    val mName = parse_element (element ("""Person.mName"""))_
    val prefix = parse_element (element ("""Person.prefix"""))_
    val specialNeed = parse_element (element ("""Person.specialNeed"""))_
    val suffix = parse_element (element ("""Person.suffix"""))_
    val electronicAddress = parse_attribute (attribute ("""Person.electronicAddress"""))_
    val landlinePhone = parse_attribute (attribute ("""Person.landlinePhone"""))_
    val mobilePhone = parse_attribute (attribute ("""Person.mobilePhone"""))_
    def parse (context: Context): Person =
    {
        return (
            Person
            (
                IdentifiedObject.parse (context),
                firstName (context),
                lastName (context),
                mName (context),
                prefix (context),
                specialNeed (context),
                suffix (context),
                electronicAddress (context),
                landlinePhone (context),
                mobilePhone (context)
            )
        )
    }
}

case class PersonRole
(
    override val sup: IdentifiedObject,
    val Person: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[PersonRole]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PersonRole
extends
    Parseable[PersonRole]
{
    val Person = parse_attribute (attribute ("""PersonRole.Person"""))_
    def parse (context: Context): PersonRole =
    {
        return (
            PersonRole
            (
                IdentifiedObject.parse (context),
                Person (context)
            )
        )
    }
}

case class PositionPoint (
    override val sup: Element,
    sequenceNumber: Int,
    xPosition: String,
    yPosition: String,
    zPosition: String,
    Location: String
)
extends
    Element
{
    def this () = { this (null, 0, null, null, null, null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[PositionPoint]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PositionPoint
extends
    Parseable[PositionPoint]
{
    val sequenceNumber = parse_element (element ("""PositionPoint.sequenceNumber"""))_
    val xPosition = parse_element (element ("""PositionPoint.xPosition"""))_
    val yPosition = parse_element (element ("""PositionPoint.yPosition"""))_
    val zPosition = parse_element (element ("""PositionPoint.zPosition"""))_
    val Location = parse_attribute (attribute ("""PositionPoint.Location"""))_
    def parse (context: Context): PositionPoint =
    {
        return (
            PositionPoint
            (
                // ToDo: PositionPoint need not have an id
                // If it doesn't have one it will need to be generated.
                BasicElement.parse (context),
                toInteger (sequenceNumber (context), context),
                xPosition (context),
                yPosition (context),
                zPosition (context),
                Location (context)
            )
        )
    }
}

case class PostalAddress (
    override val sup: Element,
    poBox: String,
    postalCode: String,
    streetDetail: String,
    townDetail: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[PostalAddress]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PostalAddress
extends
    Parseable[PostalAddress]
{
    val poBox = parse_element (element ("""PostalAddress.poBox"""))_
    val postalCode = parse_element (element ("""PostalAddress.postalCode"""))_
    val streetDetail = parse_attribute (attribute ("""PostalAddress.streetDetail"""))_
    val townDetail = parse_attribute (attribute ("""PostalAddress.townDetail"""))_
    def parse (context: Context): PostalAddress =
    {
        return (
            PostalAddress
            (
                BasicElement.parse (context),
                poBox (context),
                postalCode (context),
                streetDetail (context),
                townDetail (context)
            )
        )
    }
}

case class Priority (
    override val sup: Element,
    justification: String,
    rank: Int,
    typ: String
)
extends
    Element
{
    def this () = { this (null, null, 0, null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[Priority]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Priority
extends
    Parseable[Priority]
{
    val justification = parse_element (element ("""Priority.justification"""))_
    val rank = parse_element (element ("""Priority.rank"""))_
    val typ = parse_element (element ("""Priority.type"""))_
    def parse (context: Context): Priority =
    {
        return (
            Priority
            (
                BasicElement.parse (context),
                justification (context),
                toInteger (rank (context), context),
                typ (context)
            )
        )
    }
}

case class ScheduledEvent
(
    override val sup: IdentifiedObject,
    val duration: Double,
    val typ: String,
    val ScheduledEventData: String,
    val status: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ScheduledEvent]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ScheduledEvent
extends
    Parseable[ScheduledEvent]
{
    val duration = parse_element (element ("""ScheduledEvent.duration"""))_
    val typ = parse_element (element ("""ScheduledEvent.type"""))_
    val ScheduledEventData = parse_attribute (attribute ("""ScheduledEvent.ScheduledEventData"""))_
    val status = parse_attribute (attribute ("""ScheduledEvent.status"""))_
    def parse (context: Context): ScheduledEvent =
    {
        return (
            ScheduledEvent
            (
                IdentifiedObject.parse (context),
                toDouble (duration (context), context),
                typ (context),
                ScheduledEventData (context),
                status (context)
            )
        )
    }
}

case class ScheduledEventData
(
    override val sup: Element,
    val InspectionDataSet: String,
    val estimatedWindow: String,
    val requestedWindow: String,
    val status: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ScheduledEventData]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ScheduledEventData
extends
    Parseable[ScheduledEventData]
{
    val InspectionDataSet = parse_attribute (attribute ("""ScheduledEventData.InspectionDataSet"""))_
    val estimatedWindow = parse_attribute (attribute ("""ScheduledEventData.estimatedWindow"""))_
    val requestedWindow = parse_attribute (attribute ("""ScheduledEventData.requestedWindow"""))_
    val status = parse_attribute (attribute ("""ScheduledEventData.status"""))_
    def parse (context: Context): ScheduledEventData =
    {
        return (
            ScheduledEventData
            (
                BasicElement.parse (context),
                InspectionDataSet (context),
                estimatedWindow (context),
                requestedWindow  (context),
                status (context)
            )
        )
    }
}

case class Status (
    override val sup: Element,
    dateTime: String,
    reason: String,
    remark: String,
    value: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[Status]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Status
extends
    Parseable[Status]
{
    val dateTime = parse_element (element ("""Status.dateTime"""))_
    val reason = parse_element (element ("""Status.reason"""))_
    val remark = parse_element (element ("""Status.remark"""))_
    val value = parse_element (element ("""Status.value"""))_
    def parse (context: Context): Status =
    {
        return (
            Status
            (
                BasicElement.parse (context),
                dateTime (context),
                reason (context),
                remark (context),
                value (context)
            )
        )
    }
}

case class StreetAddress (
    override val sup: Element,
    status: String,
    streetDetail: String,
    townDetail: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[StreetAddress]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StreetAddress
extends
    Parseable[StreetAddress]
{
    val status = parse_attribute (attribute ("""StreetAddress.status"""))_
    val streetDetail = parse_attribute (attribute ("""StreetAddress.streetDetail"""))_
    val townDetail = parse_attribute (attribute ("""StreetAddress.townDetail"""))_
    def parse (context: Context): StreetAddress =
    {
        return (
            StreetAddress
            (
                BasicElement.parse (context),
                status (context),
                streetDetail (context),
                townDetail (context)
            )
        )
    }
}

case class StreetDetail (
    override val sup: Element,
    addressGeneral: String,
    buildingName: String,
    code: String,
    name: String,
    number: String,
    prefix: String,
    suffix: String,
    suiteNumber: String,
    typ: String,
    withinTownLimits: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[StreetDetail]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StreetDetail
extends
    Parseable[StreetDetail]
{
    val addressGeneral = parse_element (element ("""StreetDetail.addressGeneral"""))_
    val buildingName = parse_element (element ("""StreetDetail.buildingName"""))_
    val code = parse_element (element ("""StreetDetail.code"""))_
    val name = parse_element (element ("""StreetDetail.name"""))_
    val number = parse_element (element ("""StreetDetail.number"""))_
    val prefix = parse_element (element ("""StreetDetail.prefix"""))_
    val suffix = parse_element (element ("""StreetDetail.suffix"""))_
    val suiteNumber = parse_element (element ("""StreetDetail.suiteNumber"""))_
    val typ = parse_element (element ("""StreetDetail.type"""))_
    val withinTownLimits = parse_element (element ("""StreetDetail.withinTownLimits"""))_
    def parse (context: Context): StreetDetail =
    {
        return (
            StreetDetail
            (
                BasicElement.parse (context),
                addressGeneral (context),
                buildingName (context),
                code (context),
                name (context),
                number (context),
                prefix (context),
                suffix (context),
                suiteNumber (context),
                typ (context),
                withinTownLimits (context)
            )
        )
    }
}

case class TelephoneNumber (
    override val sup: Element,
    areaCode: String,
    cityCode: String,
    countryCode: String,
    extension: String,
    localNumber: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[TelephoneNumber]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TelephoneNumber
extends
    Parseable[TelephoneNumber]
{
    val areaCode = parse_element (element ("""TelephoneNumber.areaCode"""))_
    val cityCode = parse_element (element ("""TelephoneNumber.cityCode"""))_
    val countryCode = parse_element (element ("""TelephoneNumber.countryCode"""))_
    val extension = parse_element (element ("""TelephoneNumber.extension"""))_
    val localNumber = parse_element (element ("""TelephoneNumber.localNumber"""))_
    def parse (context: Context): TelephoneNumber =
    {
        return (
            TelephoneNumber
            (
                BasicElement.parse (context),
                areaCode (context),
                cityCode (context),
                countryCode (context),
                extension (context),
                localNumber (context)
            )
        )
    }
}

case class TimePoint
(
    override val sup: IdentifiedObject,
    val dateTime: String,
    val relativeTimeInterval: Double,
    val sequenceNumber: Int,
    val TimeSchedule: String,
    val status: String,
    val window: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TimePoint]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TimePoint
extends
    Parseable[TimePoint]
{
    val dateTime = parse_element (element ("""TimePoint.dateTime"""))_
    val relativeTimeInterval = parse_element (element ("""TimePoint.relativeTimeInterval"""))_
    val sequenceNumber = parse_element (element ("""TimePoint.sequenceNumber"""))_
    val TimeSchedule = parse_attribute (attribute ("""TimePoint.TimeSchedule"""))_
    val status = parse_attribute (attribute ("""TimePoint.status"""))_
    val window = parse_attribute (attribute ("""TimePoint.window"""))_
    def parse (context: Context): TimePoint =
    {
        return (
            TimePoint
            (
                IdentifiedObject.parse (context),
                dateTime (context),
                toDouble (relativeTimeInterval (context), context),
                toInteger (sequenceNumber (context), context),
                TimeSchedule (context),
                status (context),
                window (context)
            )
        )
    }
}

case class TimeSchedule
(
    override val sup: Document,
    val disabled: Boolean,
    val offset: Double,
    val recurrencePattern: String,
    val recurrencePeriod: Double,
    val scheduleInterval: String
)
extends
    Element
{
    def this () = { this (null, false, 0.0, null, 0.0, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[TimeSchedule]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TimeSchedule
extends
    Parseable[TimeSchedule]
{
    val disabled = parse_element (element ("""TimeSchedule.disabled"""))_
    val offset = parse_element (element ("""TimeSchedule.offset"""))_
    val recurrencePattern = parse_element (element ("""TimeSchedule.recurrencePattern"""))_
    val recurrencePeriod = parse_element (element ("""TimeSchedule.recurrencePeriod"""))_
    val scheduleInterval = parse_attribute (attribute ("""TimeSchedule.scheduleInterval"""))_
    def parse (context: Context): TimeSchedule =
    {
        return (
            TimeSchedule
            (
                Document.parse (context),
                toBoolean (disabled (context), context),
                toDouble (offset (context), context),
                recurrencePattern (context),
                toDouble (recurrencePeriod (context), context),
                scheduleInterval (context)
            )
        )
    }
}

case class TownDetail (
    override val sup: Element,
    code: String,
    country: String,
    name: String,
    section: String,
    stateOrProvince: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[TownDetail]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TownDetail
extends
    Parseable[TownDetail]
{
    val code = parse_element (element ("""TownDetail.code"""))_
    val country = parse_element (element ("""TownDetail.country"""))_
    val name = parse_element (element ("""TownDetail.name"""))_
    val section = parse_element (element ("""TownDetail.section"""))_
    val stateOrProvince = parse_element (element ("""TownDetail.stateOrProvince"""))_
    def parse (context: Context): TownDetail =
    {
        return (
            TownDetail
            (
                BasicElement.parse (context),
                code (context),
                country (context),
                name (context),
                section (context),
                stateOrProvince (context)
            )
        )
    }
}

case class UserAttribute (
    override val sup: Element,
    name: String,
    sequenceNumber: Int,
    val PropertySpecification: String,
    val RatingSpecification: String,
    val Transaction: String,
    val value: String
)
extends
    Element
{ Location
    def this () = { this (null, null, 0, null, null, null, null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[UserAttribute]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UserAttribute
extends
    Parseable[UserAttribute]
{
    val name = parse_element (element ("""UserAttribute.name"""))_
    val sequenceNumber = parse_element (element ("""UserAttribute.sequenceNumber"""))_
    val PropertySpecification = parse_attribute (attribute ("""UserAttribute.PropertySpecification"""))_
    val RatingSpecification = parse_attribute (attribute ("""UserAttribute.RatingSpecification"""))_
    val Transaction = parse_attribute (attribute ("""UserAttribute.Transaction"""))_
    val value = parse_element (element ("""UserAttribute.value"""))_
    def parse (context: Context): UserAttribute =
    {
        return (
            UserAttribute
            (
                BasicElement.parse (context),
                name (context),
                toInteger (sequenceNumber (context), context),
                PropertySpecification (context),
                RatingSpecification (context),
                Transaction (context),
                value (context)
            )
        )
    }
}

object Common
{
    def register: Unit =
    {
        CoordinateSystem.register
        Location.register
        PositionPoint.register
        UserAttribute.register
    }
}

/*
 * Core
 */

case class ACDCTerminal
(
    override val sup: IdentifiedObject,
    val connected: Boolean,
    val sequenceNumber: Int,
    val BusNameMarker: String
)
extends
    Element
{
    def this () = { this (null, false, 0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ACDCTerminal]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ACDCTerminal
extends
    Parseable[ACDCTerminal]
{
    val connected = parse_attribute (attribute ("""ACDCTerminal.connected"""))_
    val sequenceNumber = parse_element (element ("""ACDCTerminal.sequenceNumber"""))_
    val BusNameMarker = parse_attribute (attribute ("""ACDCTerminal.BusNameMarker"""))_
    def parse (context: Context): ACDCTerminal =
    {
        return (
            ACDCTerminal
            (
                IdentifiedObject.parse (context),
                toBoolean (connected (context), context),
                toInteger (sequenceNumber (context), context),
                BusNameMarker (context)
            )
        )
    }
}

case class BaseVoltage
(
    override val sup: IdentifiedObject,
    val nominalVoltage: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[BaseVoltage]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BaseVoltage
extends
    Parseable[BaseVoltage]
{
    val nominalVoltage = parse_element (element ("""BaseVoltage.nominalVoltage"""))_

    def parse (context: Context): BaseVoltage =
    {
        return (
            BaseVoltage
            (
                IdentifiedObject.parse (context),
                toDouble (nominalVoltage (context), context)
            )
        )
    }
}

case class Bay
(
    override val sup: EquipmentContainer,
    val bayEnergyMeasFlag: Boolean,
    val bayPowerMeasFlag: Boolean,
    val Substation: String,
    val VoltageLevel: String
)
extends
    Element
{
    def this () = { this (null, false, false, null, null) }
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[Bay]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Bay
extends
    Parseable[Bay]
{
    val bayEnergyMeasFlag = parse_element (element ("""Bay.bayEnergyMeasFlag"""))_
    val bayPowerMeasFlag = parse_element (element ("""Bay.bayPowerMeasFlag"""))_
    val Substation = parse_attribute (attribute ("""Bay.Substation"""))_
    val VoltageLevel = parse_attribute (attribute ("""Bay.VoltageLevel"""))_
    def parse (context: Context): Bay =
    {
        return (
            Bay
            (
                EquipmentContainer.parse (context),
                toBoolean (bayEnergyMeasFlag (context), context),
                toBoolean (bayPowerMeasFlag (context), context),
                Substation (context),
                VoltageLevel (context)
            )
        )
    }
}

case class ConductingEquipment
(
    override val sup: Equipment,
    val BaseVoltage: String,
    val GroundingAction: String,
    val JumpingAction: String,
    val SvStatus: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { return (clone ().asInstanceOf[ConductingEquipment]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConductingEquipment
extends
    Parseable[ConductingEquipment]
{
    val BaseVoltage = parse_attribute (attribute ("""ConductingEquipment.BaseVoltage"""))_
    val GroundingAction = parse_attribute (attribute ("""ConductingEquipment.GroundingAction"""))_
    val JumpingAction = parse_attribute (attribute ("""ConductingEquipment.JumpingAction"""))_
    val SvStatus = parse_attribute (attribute ("""ConductingEquipment.SvStatus"""))_
    def parse (context: Context): ConductingEquipment =
    {
        return (
            ConductingEquipment
            (
                Equipment.parse (context),
                BaseVoltage (context),
                GroundingAction (context),
                JumpingAction (context),
                SvStatus (context)
            )
        )
    }
}

case class ConnectivityNode
(
    override val sup: IdentifiedObject,
    val ConnectivityNodeContainer: String,
    val TopologicalNode: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ConnectivityNode]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConnectivityNode
extends
    Parseable[ConnectivityNode]
{
    val ConnectivityNodeContainer = parse_attribute (attribute ("""ConnectivityNode.ConnectivityNodeContainer"""))_
    val TopologicalNode = parse_attribute (attribute ("""ConnectivityNode.TopologicalNode"""))_

    def parse (context: Context): ConnectivityNode =
    {
        return (
            ConnectivityNode
            (
                IdentifiedObject.parse (context),
                ConnectivityNodeContainer (context),
                TopologicalNode (context)
            )
        )
    }
}

case class ConnectivityNodeContainer
(
    override val sup: PowerSystemResource
)
extends
    Element
{
    def this () = { this (null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[ConnectivityNodeContainer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConnectivityNodeContainer
extends
    Parseable[ConnectivityNodeContainer]
{
    def parse (context: Context): ConnectivityNodeContainer =
    {
        return (
            ConnectivityNodeContainer
            (
                PowerSystemResource.parse (context)
            )
        )
    }
}

case class Equipment
(
    override val sup: PowerSystemResource,
    val aggregate: Boolean,
    val normallyInService: Boolean,
    val EquipmentContainer: String
)
extends
    Element
{
    def this () = { this (null, false, false, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[Equipment]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Equipment
extends
    Parseable[Equipment]
{
    val aggregate = parse_element (element ("""Equipment.aggregate"""))_
    val normallyInService = parse_element (element ("""Equipment.normallyInService"""))_
    val EquipmentContainer = parse_attribute (attribute ("""Equipment.EquipmentContainer"""))_
    def parse (context: Context): Equipment =
    {
        return (
            Equipment
            (
                PowerSystemResource.parse (context),
                toBoolean (aggregate (context), context),
                toBoolean (normallyInService (context), context),
                EquipmentContainer (context)
            )
        )
    }
}

case class EquipmentContainer
(
    override val sup: ConnectivityNodeContainer
)
extends
    Element
{
    def this () = { this (null) }
    def ConnectivityNodeContainer: ConnectivityNodeContainer = sup.asInstanceOf[ConnectivityNodeContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[EquipmentContainer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EquipmentContainer
extends
    Parseable[EquipmentContainer]
{
    def parse (context: Context): EquipmentContainer =
    {
        return (
            EquipmentContainer
            (
                ConnectivityNodeContainer.parse (context)
            )
        )
    }
}

/**
 * Top level CIM object.
 */

case class IdentifiedObject
(
    override val sup: Element,
    val aliasName: String,
    val description: String,
    val mRID: String,
    val name: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup
    override def id: String = mRID
    override def copy (): Row = { return (clone ().asInstanceOf[IdentifiedObject]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IdentifiedObject
extends
    Parseable[IdentifiedObject]
{
    val aliasName = parse_element (element ("""IdentifiedObject.aliasName"""))_
    val description = parse_element (element ("""IdentifiedObject.description"""))_
    val name = parse_element (element ("""IdentifiedObject.name"""))_

    def parse (context: Context): IdentifiedObject =
    {
        val element = BasicElement.parse (context)
        return (
            IdentifiedObject (
                element,
                aliasName (context),
                description (context),
                element.mRID,
                name (context)
            )
        )
    }
}

case class Name
(
    override val sup: IdentifiedObject,
    val name: String,
    val IdentifiedObj: String,
    val NameType: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Name]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Name
extends
    Parseable[Name]
{
    def parse (context: Context): Name =
    {
        val name = parse_element (element ("""Name.name"""))_
        val IdentifiedObj = parse_attribute (attribute ("""Name.IdentifiedObject"""))_
        val NameType = parse_attribute (attribute ("""Name.NameType"""))_
        return (
            Name
            (
                IdentifiedObject.parse (context),
                name (context),
                IdentifiedObj (context),
                NameType (context)
            )
        )
    }
}

case class NameType (
    override val sup: Element,
    description: String,
    name: String,
    NameTypeAuthority: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[NameType]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NameType
extends
    Parseable[NameType]
{
    val description = parse_element (element ("""NameType.description"""))_
    val name = parse_element (element ("""NameType.name"""))_
    val NameTypeAuthority = parse_attribute (attribute ("""NameType.NameTypeAuthority"""))_
    def parse (context: Context): NameType =
    {
        return (
            NameType
            (
                BasicElement.parse (context),
                description (context),
                name (context),
                NameTypeAuthority (context)
            )
        )
    }
}

case class NameTypeAuthority (
    override val sup: Element,
    description: String,
    name: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[NameTypeAuthority]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NameTypeAuthority
extends
    Parseable[NameTypeAuthority]
{
    val description = parse_element (element ("""NameTypeAuthority.description"""))_
    val name = parse_element (element ("""NameTypeAuthority.name"""))_
    def parse (context: Context): NameTypeAuthority =
    {
        return (
            NameTypeAuthority
            (
                BasicElement.parse (context),
                description (context),
                name (context)
            )
        )
    }
}

case class PSRType
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[PSRType]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PSRType
extends
    Parseable[PSRType]
{
    def parse (context: Context): PSRType =
    {
        return (
            PSRType
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

case class PowerSystemResource
(
    override val sup: IdentifiedObject,
    val AssetDataSheet: String,
    val Location: String,
    val PSRType: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[PowerSystemResource]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerSystemResource
extends
    Parseable[PowerSystemResource]
{
    val AssetDataSheet = parse_attribute (attribute ("""PowerSystemResource.AssetDataSheet"""))_
    val Location = parse_attribute (attribute ("""PowerSystemResource.Location"""))_
    val PSRType = parse_attribute (attribute ("""PowerSystemResource.PSRType"""))_
    def parse (context: Context): PowerSystemResource =
    {
        return (
            PowerSystemResource
            (
                IdentifiedObject.parse (context),
                AssetDataSheet (context),
                Location (context),
                PSRType (context)
            )
        )
    }
}

case class Substation
(
    override val sup: ConnectivityNodeContainer,
    val Region: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def ConnectivityNodeContainer: ConnectivityNodeContainer = sup.asInstanceOf[ConnectivityNodeContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[Substation]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Substation
extends
    Parseable[Substation]
{
    val Region = parse_attribute (attribute ("""Substation.Region"""))_
    def parse (context: Context): Substation =
    {
        return (
            Substation
            (
                ConnectivityNodeContainer.parse (context),
                Region (context)
            )
        )
    }
}

case class Terminal
(
    override val sup: ACDCTerminal,
    val phases: String,
    val Bushing: String,
    val ConductingEquipment: String,
    val ConnectivityNode: String,
    val SvPowerFlow: String,
    val TopologicalNode: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def ACDCTerminal: ACDCTerminal = sup.asInstanceOf[ACDCTerminal]
    override def copy (): Row = { return (clone ().asInstanceOf[Terminal]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Terminal
extends
    Parseable[Terminal]
{
    val phases = parse_attribute (attribute ("""Terminal.phases"""))_
    val Bushing = parse_attribute (attribute ("""Terminal.Bushing"""))_
    val ConductingEquipment = parse_attribute (attribute ("""Terminal.ConductingEquipment"""))_
    val ConnectivityNode = parse_attribute (attribute ("""Terminal.ConnectivityNode"""))_
    val SvPowerFlow = parse_attribute (attribute ("""Terminal.SvPowerFlow"""))_
    val TopologicalNode = parse_attribute (attribute ("""Terminal.TopologicalNode"""))_
    def parse (context: Context): Terminal =
    {
        return (
            Terminal
            (
                ACDCTerminal.parse (context),
                phases (context),
                Bushing (context),
                ConductingEquipment (context),
                ConnectivityNode (context),
                SvPowerFlow (context),
                TopologicalNode (context)
            )
        )
    }
}

case class VoltageLevel
(
    override val sup: EquipmentContainer,
    val highVoltageLimit: Double,
    val lowVoltageLimit: Double,
    val BaseVoltage: String,
    val Substation: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null) }
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[VoltageLevel]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VoltageLevel
extends
    Parseable[VoltageLevel]
{
    val highVoltageLimit = parse_element (element ("""VoltageLevel.highVoltageLimit"""))_
    val lowVoltageLimit = parse_element (element ("""VoltageLevel.lowVoltageLimit"""))_
    val BaseVoltage = parse_attribute (attribute ("""VoltageLevel.BaseVoltage"""))_
    val Substation = parse_attribute (attribute ("""VoltageLevel.Substation"""))_
    def parse (context: Context): VoltageLevel =
    {
        return (
            VoltageLevel
            (
                EquipmentContainer.parse (context),
                toDouble (highVoltageLimit (context), context),
                toDouble (lowVoltageLimit (context), context),
                BaseVoltage (context),
                Substation (context)
            )
        )
    }
}

object Core
{
    def register: Unit =
    {
        ACDCTerminal.register
        BaseVoltage.register
        Bay.register
        ConductingEquipment.register
        ConnectivityNode.register
        ConnectivityNodeContainer.register
        Equipment.register
        EquipmentContainer.register
        IdentifiedObject.register
        Name.register
        NameType.register
        NameTypeAuthority.register
        PSRType.register
        PowerSystemResource.register
        Substation.register
        Terminal.register
        VoltageLevel.register
    }
}

/*
 * Customers
 */

case class Customer
(
    override val sup: OrganisationRole,
    val kind: String,
    val locale: String,
    val pucNumber: String,
    val specialNeed: String,
    val vip: Boolean,
    val priority: String,
    val status: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, false, null, null) }
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[Customer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Customer
extends
    Parseable[Customer]
{
    val kind = parse_attribute (attribute ("""Customer.kind"""))_
    val locale = parse_element (element ("""Customer.locale"""))_
    val pucNumber = parse_element (element ("""Customer.pucNumber"""))_
    val specialNeed = parse_element (element ("""Customer.specialNeed"""))_
    val vip = parse_element (element ("""Customer.vip"""))_
    val priority = parse_attribute (attribute ("""Customer.priority"""))_
    val status = parse_attribute (attribute ("""Customer.status"""))_
    def parse (context: Context): Customer =
    {
        return (
            Customer
            (
                OrganisationRole.parse (context),
                kind (context),
                locale (context),
                pucNumber (context),
                specialNeed (context),
                toBoolean (vip (context), context),
                priority (context),
                status (context)
            )
        )
    }
}

case class CustomerAgreement
(
    override val sup: Agreement,
    val loadMgmt: String,
    val Customer: String,
    val CustomerAccount: String,
    val ServiceCategory: String,
    val ServiceSupplier: String,
    val StandardIndustryCode: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { return (clone ().asInstanceOf[CustomerAgreement]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CustomerAgreement
extends
    Parseable[CustomerAgreement]
{
    val loadMgmt = parse_element (element ("""CustomerAgreement.loadMgmt"""))_
    val Customer = parse_attribute (attribute ("""CustomerAgreement.Customer"""))_
    val CustomerAccount = parse_attribute (attribute ("""CustomerAgreement.CustomerAccount"""))_
    val ServiceCategory = parse_attribute (attribute ("""CustomerAgreement.ServiceCategory"""))_
    val ServiceSupplier = parse_attribute (attribute ("""CustomerAgreement.ServiceSupplier"""))_
    val StandardIndustryCode = parse_attribute (attribute ("""CustomerAgreement.StandardIndustryCode"""))_
    def parse (context: Context): CustomerAgreement =
    {
        return (
            CustomerAgreement
            (
                Agreement.parse (context),
                loadMgmt (context),
                Customer (context),
                CustomerAccount (context),
                ServiceCategory (context),
                ServiceSupplier (context),
                StandardIndustryCode (context)
            )
        )
    }
}

case class PricingStructure
(
    override val sup: Document,
    val code: String,
    val dailyCeilingUsage: String,
    val dailyEstimatedUsage: String,
    val dailyFloorUsage: String,
    val revenueKind: String,
    val taxExemption: Boolean,
    val ServiceCategory: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, false, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[PricingStructure]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PricingStructure
extends
    Parseable[PricingStructure]
{
    val code = parse_element (element ("""PricingStructure.code"""))_
    val dailyCeilingUsage = parse_element (element ("""PricingStructure.dailyCeilingUsage"""))_
    val dailyEstimatedUsage = parse_element (element ("""PricingStructure.dailyEstimatedUsage"""))_
    val dailyFloorUsage = parse_element (element ("""PricingStructure.dailyFloorUsage"""))_
    val revenueKind = parse_attribute (attribute ("""PricingStructure.revenueKind"""))_
    val taxExemption = parse_element (element ("""PricingStructure.taxExemption"""))_
    val ServiceCategory = parse_attribute (attribute ("""PricingStructure.ServiceCategory"""))_
    def parse (context: Context): PricingStructure =
    {
        return (
            PricingStructure
            (
                Document.parse (context),
                code (context),
                dailyCeilingUsage (context),
                dailyEstimatedUsage (context),
                dailyFloorUsage (context),
                revenueKind (context),
                toBoolean (taxExemption (context), context),
                ServiceCategory (context)
            )
        )
    }
}

case class ServiceCategory
(
    override val sup: IdentifiedObject,
    val kind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ServiceCategory]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ServiceCategory
extends
    Parseable[ServiceCategory]
{
    val kind = parse_attribute (attribute ("""ServiceCategory.kind"""))_
    def parse (context: Context): ServiceCategory =
    {
        return (
            ServiceCategory
            (
                IdentifiedObject.parse (context),
                kind (context)
            )
        )
    }
}

case class ServiceLocation
(
    override val sup: Location,
    val accessMethod: String,
    val needsInspection: Boolean,
    val siteAccessProblem: String
)
extends
    Element
{
    def this () = { this (null, null, false, null) }
    def Location: Location = sup.asInstanceOf[Location]
    override def copy (): Row = { return (clone ().asInstanceOf[ServiceLocation]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ServiceLocation
extends
    Parseable[ServiceLocation]
{
    val accessMethod = parse_element (element ("""ServiceLocation.accessMethod"""))_
    val needsInspection = parse_element (element ("""ServiceLocation.needsInspection"""))_
    val siteAccessProblem = parse_element (element ("""ServiceLocation.siteAccessProblem"""))_
    def parse (context: Context): ServiceLocation =
    {
        return (
            ServiceLocation
            (
                Location.parse (context),
                accessMethod (context),
                toBoolean (needsInspection (context), context),
                siteAccessProblem (context)
            )
        )
    }
}

object Customers
{
    def register: Unit =
    {
        Agreement.register
        Customer.register
        CustomerAgreement.register
        Document.register
        OrganisationRole.register
        PricingStructure.register
        ServiceCategory.register
        ServiceLocation.register
    }
}

/*
 * Metering
 */

case class UsagePoint
(
    override val sup: IdentifiedObject,
    // val amiBillingReady: String, Implementation restriction: case classes cannot have more than 22 parameters.
    val checkBilling: Boolean,
    val connectionState: String,
    val estimatedLoad: Double,
    val grounded: Boolean,
    val isSdp: Boolean,
    val isVirtual: Boolean,
    val minimalUsageExpected: Boolean,
    val nominalServiceVoltage: Double,
    val outageRegion: String,
    val phaseCode: String,
    val ratedCurrent: Double,
    val ratedPower: Double,
    val readCycle: String,
    val readRoute: String,
    val serviceDeliveryRemark: String,
    val servicePriority: String,
    val CustomerAgreement: String,
    val ServiceCategory: String,
    val ServiceLocation: String,
    val ServiceSupplier: String,
    val UsagePointLocation: String
)
extends
    Element
{
    def this () = { this (null, false, null, 0.0, false, false, false, false, 0.0, null, null, 0.0, 0.0, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[UsagePoint]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UsagePoint
extends
    Parseable[UsagePoint]
{
    //val amiBillingReady = parse_element (element ("""UsagePoint.amiBillingReady"""))_
    val checkBilling = parse_element (element ("""UsagePoint.checkBilling"""))_
    val connectionState = parse_element (element ("""UsagePoint.connectionState"""))_
    val estimatedLoad = parse_element (element ("""UsagePoint.estimatedLoad"""))_
    val grounded = parse_element (element ("""UsagePoint.grounded"""))_
    val isSdp = parse_element (element ("""UsagePoint.isSdp"""))_
    val isVirtual = parse_element (element ("""UsagePoint.isSdp"""))_
    val minimalUsageExpected = parse_element (element ("""UsagePoint.minimalUsageExpected"""))_
    val nominalServiceVoltage = parse_element (element ("""UsagePoint.nominalServiceVoltage"""))_
    val outageRegion = parse_element (element ("""UsagePoint.outageRegion"""))_
    val phaseCode = parse_element (element ("""UsagePoint.phaseCode"""))_
    val ratedCurrent = parse_element (element ("""UsagePoint.ratedCurrent"""))_
    val ratedPower = parse_element (element ("""UsagePoint.ratedPower"""))_
    val readCycle = parse_element (element ("""UsagePoint.readCycle"""))_
    val readRoute = parse_element (element ("""UsagePoint.readRoute"""))_
    val serviceDeliveryRemark = parse_element (element ("""UsagePoint.serviceDeliveryRemark"""))_
    val servicePriority = parse_element (element ("""UsagePoint.servicePriority"""))_
    val CustomerAgreement = parse_attribute (attribute ("""UsagePoint.CustomerAgreement"""))_
    val ServiceCategory = parse_attribute (attribute ("""UsagePoint.ServiceCategory"""))_
    val ServiceLocation = parse_attribute (attribute ("""UsagePoint.ServiceLocation"""))_
    val ServiceSupplier = parse_attribute (attribute ("""UsagePoint.ServiceSupplier"""))_
    val UsagePointLocation = parse_attribute (attribute ("""UsagePoint.UsagePointLocation"""))_
    def parse (context: Context): UsagePoint =
    {
        return (
            UsagePoint
            (
                IdentifiedObject.parse (context),
                //amiBillingReady (context),
                toBoolean (checkBilling (context), context),
                connectionState (context),
                toDouble (estimatedLoad (context), context),
                toBoolean (grounded (context), context),
                toBoolean (isSdp (context), context),
                toBoolean (isVirtual (context), context),
                toBoolean (minimalUsageExpected (context), context),
                toDouble (nominalServiceVoltage (context), context),
                outageRegion (context),
                phaseCode (context),
                toDouble (ratedCurrent (context), context),
                toDouble (ratedPower (context), context),
                readCycle (context),
                readRoute (context),
                serviceDeliveryRemark (context),
                servicePriority (context),
                CustomerAgreement (context),
                ServiceCategory (context),
                ServiceLocation (context),
                ServiceSupplier (context),
                UsagePointLocation (context)
            )
        )
    }
}

case class UsagePointLocation
(
    override val sup: Location,
    val accessMethod: String,
    val remark: String,
    val siteAccessProblem: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Location: Location = sup.asInstanceOf[Location]
    override def copy (): Row = { return (clone ().asInstanceOf[UsagePointLocation]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UsagePointLocation
extends
    Parseable[UsagePointLocation]
{
    val accessMethod = parse_element (element ("""UsagePointLocation.accessMethod"""))_
    val remark = parse_element (element ("""UsagePointLocation.remark"""))_
    val siteAccessProblem = parse_element (element ("""UsagePointLocation.siteAccessProblem"""))_
    def parse (context: Context): UsagePointLocation =
    {
        return (
            UsagePointLocation
            (
                Location.parse (context),
                accessMethod (context),
                remark (context),
                siteAccessProblem (context)
            )
        )
    }
}

object Metering
{
    def register: Unit =
    {
        UsagePoint.register
        UsagePointLocation.register
    }
}

/*
 * Production
 */

case class GeneratingUnit
(
    override val sup: Equipment,
    val ratedNetMaxP: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { return (clone ().asInstanceOf[GeneratingUnit]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GeneratingUnit
extends
    Parseable[GeneratingUnit]
{
    val ratedNetMaxP = parse_element (element ("""GeneratingUnit.ratedNetMaxP"""))_
    def parse (context: Context): GeneratingUnit =
    {
        return (
            GeneratingUnit
            (
                Equipment.parse (context),
                toDouble (ratedNetMaxP (context), context)
            )
        )
    }
}

case class SolarGeneratingUnit
(
    override val sup: GeneratingUnit,
    // ToDo: non-standard... should be in Asset
    val commissioningDate: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { return (clone ().asInstanceOf[SolarGeneratingUnit]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SolarGeneratingUnit
extends
    Parseable[SolarGeneratingUnit]
{
    val commissioningDate = parse_element (element ("""SolarGeneratingUnit.commissioningDate"""))_
    def parse (context: Context): SolarGeneratingUnit =
    {
        return (
            SolarGeneratingUnit
            (
                GeneratingUnit.parse (context),
                commissioningDate (context)
            )
        )
    }
}

object Production
{
    def register: Unit =
    {
        GeneratingUnit.register
        SolarGeneratingUnit.register
    }
}

/*
 * Protection
 */

case class CurrentRelay
(
    override val sup: ProtectionEquipment,
    val currentLimit1: Double,
    val currentLimit2: Double,
    val currentLimit3: Double,
    val inverseTimeFlag: Boolean,
    val timeDelay1: Double,
    val timeDelay2: Double,
    val timeDelay3: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0) }
    def ProtectionEquipment: ProtectionEquipment = sup.asInstanceOf[ProtectionEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[CurrentRelay]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CurrentRelay
extends
    Parseable[CurrentRelay]
{
    val currentLimit1 = parse_element (element ("""CurrentRelay.currentLimit1"""))_
    val currentLimit2 = parse_element (element ("""CurrentRelay.currentLimit2"""))_
    val currentLimit3 = parse_element (element ("""CurrentRelay.currentLimit3"""))_
    val inverseTimeFlag = parse_element (element ("""CurrentRelay.inverseTimeFlag"""))_
    val timeDelay1 = parse_element (element ("""CurrentRelay.timeDelay1"""))_
    val timeDelay2 = parse_element (element ("""CurrentRelay.timeDelay2"""))_
    val timeDelay3 = parse_element (element ("""CurrentRelay.timeDelay2"""))_
    def parse (context: Context): CurrentRelay =
    {
        return (
            CurrentRelay
            (
                ProtectionEquipment.parse (context),
                toDouble (currentLimit1 (context), context),
                toDouble (currentLimit2 (context), context),
                toDouble (currentLimit3 (context), context),
                toBoolean (inverseTimeFlag (context), context),
                toDouble (timeDelay1 (context), context),
                toDouble (timeDelay2 (context), context),
                toDouble (timeDelay3 (context), context)
            )
        )
    }
}

case class ProtectionEquipment
(
    override val sup: Equipment,
    val highLimit: Double,
    val lowLimit: Double,
    val powerDirectionFlag: Boolean,
    val relayDelayTime: Double,
    val unitMultiplier: String,
    val unitSymbol: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, false, 0.0, null, null) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { return (clone ().asInstanceOf[ProtectionEquipment]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProtectionEquipment
extends
    Parseable[ProtectionEquipment]
{
    val highLimit = parse_element (element ("""ProtectionEquipment.highLimit"""))_
    val lowLimit = parse_element (element ("""ProtectionEquipment.lowLimit"""))_
    val powerDirectionFlag = parse_element (element ("""ProtectionEquipment.powerDirectionFlag"""))_
    val relayDelayTime = parse_element (element ("""ProtectionEquipment.relayDelayTime"""))_
    val unitMultiplier = parse_element (element ("""ProtectionEquipment.unitMultiplier"""))_
    val unitSymbol = parse_element (element ("""ProtectionEquipment.unitSymbol"""))_
    def parse (context: Context): ProtectionEquipment =
    {
        return (
            ProtectionEquipment
            (
                Equipment.parse (context),
                toDouble (highLimit (context), context),
                toDouble (lowLimit (context), context),
                toBoolean (powerDirectionFlag (context), context),
                toDouble (relayDelayTime (context), context),
                unitMultiplier (context),
                unitSymbol (context)
            )
        )
    }
}

object Protection
{
    def register: Unit =
    {
        CurrentRelay.register
        ProtectionEquipment.register
    }
}

/*
 * StateVariables
 */

case class StateVariable (
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[StateVariable]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StateVariable
extends
    Parseable[StateVariable]
{
    def parse (context: Context): StateVariable =
    {
        return (
            StateVariable
            (
                BasicElement.parse (context)
            )
        )
    }
}

case class SvStatus (
    override val sup: StateVariable,
    val inService: Boolean,
    val ConductingEquipment: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def StateVariable: StateVariable = sup.asInstanceOf[StateVariable]
    override def copy (): Row = { return (clone ().asInstanceOf[SvStatus]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SvStatus
extends
    Parseable[SvStatus]
{
    def parse (context: Context): SvStatus =
    {
        val inService = parse_element (element ("""SvStatus.inService"""))_
        val ConductingEquipment = parse_attribute (attribute ("""SvStatus.ConductingEquipment"""))_
        return (
            SvStatus
            (
                StateVariable.parse (context),
                toBoolean (inService (context), context),
                ConductingEquipment (context)
            )
        )
    }
}

object StateVariables
{
    def register: Unit =
    {
        StateVariable.register
        SvStatus.register
    }
}

/*
 * Wires
 */

case class ACLineSegment
(
    override val sup: Conductor,
    val b0ch: Double,
    val bch: Double,
    val g0ch: Double,
    val gch: Double,
    val r0: Double,
    val r: Double,
    val shortCircuitEndTemperature: Double,
    val x0: Double,
    val x: Double,
    val LineGroundingAction: String,
    val LineJumpingAction: String,
    val PerLengthImpedance: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null) }
    def Conductor: Conductor = sup.asInstanceOf[Conductor]
    override def copy (): Row = { return (clone ().asInstanceOf[ACLineSegment]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ACLineSegment
extends
    Parseable[ACLineSegment]
{
    val b0ch = parse_element (element ("""ACLineSegment.b0ch"""))_
    val bch = parse_element (element ("""ACLineSegment.bch"""))_
    val g0ch = parse_element (element ("""ACLineSegment.g0ch"""))_
    val gch = parse_element (element ("""ACLineSegment.gch"""))_
    val r0 = parse_element (element ("""ACLineSegment.r0"""))_
    val r = parse_element (element ("""ACLineSegment.r"""))_
    val shortCircuitEndTemperature = parse_element (element ("""ACLineSegment.shortCircuitEndTemperature"""))_
    val x0 = parse_element (element ("""ACLineSegment.x0"""))_
    val x = parse_element (element ("""ACLineSegment.x"""))_
    val LineGroundingAction = parse_attribute (attribute ("""ACLineSegment.LineGroundingAction"""))_
    val LineJumpingAction = parse_attribute (attribute ("""ACLineSegment.LineJumpingAction"""))_
    val PerLengthImpedance = parse_attribute (attribute ("""ACLineSegment.PerLengthImpedance"""))_
    def parse (context: Context): ACLineSegment =
    {
        return (
            ACLineSegment
            (
                Conductor.parse (context),
                toDouble (b0ch (context), context),
                toDouble (bch (context), context),
                toDouble (g0ch (context), context),
                toDouble (gch (context), context),
                toDouble (r0 (context), context),
                toDouble (r (context), context),
                toDouble (shortCircuitEndTemperature (context), context),
                toDouble (x0 (context), context),
                toDouble (x (context), context),
                LineGroundingAction (context),
                LineJumpingAction (context),
                PerLengthImpedance (context)
            )
        )
    }
}

case class ACLineSegmentPhase
(
    override val sup: PowerSystemResource,
    val phase: String,
    val ACLineSegment: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[ACLineSegmentPhase]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ACLineSegmentPhase
extends
    Parseable[ACLineSegmentPhase]
{
    val phase = parse_attribute (attribute ("""ACLineSegmentPhase.phase"""))_
    val ACLineSegment = parse_attribute (attribute ("""ACLineSegmentPhase.ACLineSegment"""))_
    def parse (context: Context): ACLineSegmentPhase =
    {
        return (
            ACLineSegmentPhase
            (
                PowerSystemResource.parse (context),
                phase (context),
                ACLineSegment (context)
            )
        )
    }
}

case class BusbarSection
(
    override val sup: Connector,
    val ipMax: Double,
    val VoltageControlZone: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def Connector: Connector = sup.asInstanceOf[Connector]
    override def copy (): Row = { return (clone ().asInstanceOf[BusbarSection]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BusbarSection
extends
    Parseable[BusbarSection]
{
    val ipMax = parse_element (element ("""BusbarSection.ipMax"""))_
    val VoltageControlZone = parse_attribute (attribute ("""BusbarSection.VoltageControlZone"""))_
    def parse (context: Context): BusbarSection =
    {
        return (
            BusbarSection
            (
                Connector.parse (context),
                toDouble (ipMax (context), context),
                VoltageControlZone (context)
            )
        )
    }
}

case class Conductor
(
    override val sup: ConductingEquipment,
    val len: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[Conductor]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Conductor
extends
    Parseable[Conductor]
{
    val len = parse_element (element ("""Conductor.length"""))_
    def parse (context: Context): Conductor =
    {
        return (
            Conductor
            (
                ConductingEquipment.parse (context),
                toDouble (len (context), context)
            )
        )
    }
}

case class Connector
(
    override val sup: ConductingEquipment
)
extends
    Element
{
    def this () = { this (null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[Connector]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Connector
extends
    Parseable[Connector]
{
    def parse (context: Context): Connector =
    {
        return (
            Connector
            (
                ConductingEquipment.parse (context)
            )
        )
    }
}

case class Disconnector
(
    override val sup: Switch
)
extends
    Element
{
    def this () = { this (null) }
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { return (clone ().asInstanceOf[Disconnector]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Disconnector
extends
    Parseable[Disconnector]
{
    def parse (context: Context): Disconnector =
    {
        return (
            Disconnector
            (
                Switch.parse (context)
            )
        )
    }
}

case class EnergyConsumer
(
    override val sup: ConductingEquipment,
    val customerCount: Int,
    val grounded: Boolean,
    val p: Double,
    val pfixed: Double,
    val pfixedPct: Double,
    val phaseConnection: String,
    val q: Double,
    val qfixed: Double,
    val qfixedPct: Double,
    val LoadDynamics: String,
    val LoadResponse: String,
    val PowerCutZone: String
)
extends
    Element
{
    def this () = { this (null, 0, false, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, null, null, null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyConsumer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyConsumer
extends
    Parseable[EnergyConsumer]
{
    val customerCount = parse_element (element ("""EnergyConsumer.customerCount"""))_
    val grounded = parse_element (element ("""EnergyConsumer.grounded"""))_
    val p = parse_element (element ("""EnergyConsumer.p"""))_
    val pfixed = parse_element (element ("""EnergyConsumer.pfixed"""))_
    val pfixedPct = parse_element (element ("""EnergyConsumer.pfixedPct"""))_
    val phaseConnection = parse_attribute (attribute ("""EnergyConsumer.phaseConnection"""))_
    val q = parse_element (element ("""EnergyConsumer.q"""))_
    val qfixed = parse_element (element ("""EnergyConsumer.qfixed"""))_
    val qfixedPct = parse_element (element ("""EnergyConsumer.qfixedPct"""))_
    val LoadDynamics = parse_attribute (attribute ("""EnergyConsumer.LoadDynamics"""))_
    val LoadResponse = parse_attribute (attribute ("""EnergyConsumer.LoadResponse"""))_
    val PowerCutZone = parse_attribute (attribute ("""EnergyConsumer.PowerCutZone"""))_
    def parse (context: Context): EnergyConsumer =
    {
        return (
            EnergyConsumer
            (
                ConductingEquipment.parse (context),
                toInteger (customerCount (context), context),
                toBoolean (grounded (context), context),
                toDouble (p (context), context),
                toDouble (pfixed (context), context),
                toDouble (pfixedPct (context), context),
                phaseConnection (context),
                toDouble (q (context), context),
                toDouble (qfixed (context), context),
                toDouble (qfixedPct (context), context),
                LoadDynamics (context),
                LoadResponse (context),
                PowerCutZone (context)
            )
        )
    }
}

case class Fuse
(
    override val sup: Switch
)
extends
    Element
{
    def this () = { this (null) }
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { return (clone ().asInstanceOf[Fuse]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Fuse
extends
    Parseable[Fuse]
{
    def parse (context: Context): Fuse =
    {
        return (
            Fuse
            (
                Switch.parse (context)
            )
        )
    }
}

case class GroundDisconnector
(
    override val sup: Switch
)
extends
    Element
{
    def this () = { this (null) }
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { return (clone ().asInstanceOf[GroundDisconnector]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GroundDisconnector
extends
    Parseable[GroundDisconnector]
{
    def parse (context: Context): GroundDisconnector =
    {
        return (
            GroundDisconnector
            (
                Switch.parse (context)
            )
        )
    }
}

case class Junction
(
    override val sup: Connector
)
extends
    Element
{
    def this () = { this (null) }
    def Connector: Connector = sup.asInstanceOf[Connector]
    override def copy (): Row = { return (clone ().asInstanceOf[Junction]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Junction
extends
    Parseable[Junction]
{
    def parse (context: Context): Junction =
    {
        return (
            Junction
            (
                Connector.parse (context)
            )
        )
    }
}

case class Line
(
    override val sup: ConnectivityNodeContainer,
    val Region: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def ConnectivityNodeContainer: ConnectivityNodeContainer = sup.asInstanceOf[ConnectivityNodeContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[Line]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Line
extends
    Parseable[Line]
{
    val Region = parse_attribute (attribute ("""Line.Region"""))_
    def parse (context: Context): Line =
    {
        return (
            Line
            (
                ConnectivityNodeContainer.parse (context),
                Region (context)
            )
        )
    }
}

case class PowerTransformer
(
    override val sup: ConductingEquipment,
    val beforeShCircuitHighestOperatingCurrent: Double,
    val beforeShCircuitHighestOperatingVoltage: Double,
    val beforeShortCircuitAnglePf: Double,
    val highSideMinOperatingU: Double,
    val isPartOfGeneratorUnit: Boolean,
    val operationalValuesConsidered: Boolean,
    val vectorGroup: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, false, false, null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[PowerTransformer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerTransformer
extends
    Parseable[PowerTransformer]
{
    val beforeShCircuitHighestOperatingCurrent = parse_element (element ("""PowerTransformer.beforeShCircuitHighestOperatingCurrent"""))_
    val beforeShCircuitHighestOperatingVoltage = parse_element (element ("""PowerTransformer.beforeShCircuitHighestOperatingVoltage"""))_
    val beforeShortCircuitAnglePf = parse_element (element ("""PowerTransformer.beforeShortCircuitAnglePf"""))_
    val highSideMinOperatingU = parse_element (element ("""PowerTransformer.highSideMinOperatingU"""))_
    val isPartOfGeneratorUnit = parse_element (element ("""PowerTransformer.isPartOfGeneratorUnit"""))_
    val operationalValuesConsidered = parse_element (element ("""PowerTransformer.operationalValuesConsidered"""))_
    val vectorGroup = parse_element (element ("""PowerTransformer.vectorGroup"""))_
    def parse (context: Context): PowerTransformer =
    {
        return (
            PowerTransformer
            (
                ConductingEquipment.parse (context),
                toDouble (beforeShCircuitHighestOperatingCurrent (context), context),
                toDouble (beforeShCircuitHighestOperatingVoltage (context), context),
                toDouble (beforeShortCircuitAnglePf (context), context),
                toDouble (highSideMinOperatingU (context), context),
                toBoolean (isPartOfGeneratorUnit (context), context),
                toBoolean (operationalValuesConsidered (context), context),
                vectorGroup (context)
            )
        )
    }
}

case class PowerTransformerEnd
(
    override val sup: TransformerEnd,
    val b0: Double,
    val b: Double,
    val connectionKind: String,
    val g0: Double,
    val g: Double,
    val phaseAngleClock: Int,
    val r0: Double,
    val r: Double,
    val ratedS: Double,
    val ratedU: Double,
    val x0: Double,
    val x: Double,
    val PowerTransformer: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def TransformerEnd: TransformerEnd = sup.asInstanceOf[TransformerEnd]
    override def copy (): Row = { return (clone ().asInstanceOf[PowerTransformer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerTransformerEnd
extends
    Parseable[PowerTransformerEnd]
{
    val b0 = parse_element (element ("""PowerTransformerEnd.b0"""))_
    val b = parse_element (element ("""PowerTransformerEnd.b"""))_
    val connectionKind = parse_attribute (attribute ("""PowerTransformerEnd.connectionKind"""))_
    val g0 = parse_element (element ("""PowerTransformerEnd.g0"""))_
    val g = parse_element (element ("""PowerTransformerEnd.g"""))_
    val phaseAngleClock = parse_element (element ("""PowerTransformerEnd.phaseAngleClock"""))_
    val r0 = parse_element (element ("""PowerTransformerEnd.r0"""))_
    val r = parse_element (element ("""PowerTransformerEnd.r"""))_
    val ratedS = parse_element (element ("""PowerTransformerEnd.ratedS"""))_
    val ratedU = parse_element (element ("""PowerTransformerEnd.ratedU"""))_
    val x0 = parse_element (element ("""PowerTransformerEnd.x0"""))_
    val x = parse_element (element ("""PowerTransformerEnd.x"""))_
    val PowerTransformer = parse_attribute (attribute ("""PowerTransformerEnd.PowerTransformer"""))_
    def parse (context: Context): PowerTransformerEnd =
    {
        return (
            PowerTransformerEnd
            (
                TransformerEnd.parse (context),
                toDouble (b0 (context), context),
                toDouble (b (context), context),
                connectionKind (context),
                toDouble (g0 (context), context),
                toDouble (g (context), context),
                toInteger (phaseAngleClock (context), context),
                toDouble (r0 (context), context),
                toDouble (r (context), context),
                toDouble (ratedS (context), context),
                toDouble (ratedU (context), context),
                toDouble (x0 (context), context),
                toDouble (x (context), context),
                PowerTransformer (context)
            )
        )
    }
}

case class Switch
(
    override val sup: ConductingEquipment,
    val normalOpen: Boolean,
    val open: Boolean,
    // ToDo: should be Double
    val ratedCurrent: String,
    val retained: Boolean,
    val switchOnCount: Int,
    // ToDo: Date handling
    //val switchOnDate: Date
    val CompositeSwitch: String,
    val Outage: String,
    val SwitchAction: String
)
extends
    Element
{
    def this () = { this (null, false, false, null, false, 0, null, null, null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[Switch]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Switch
extends
    Parseable[Switch]
{
    val normalOpen = parse_element (element ("""Switch.normalOpen"""))_
    val open = parse_element (element ("""Switch.open"""))_
    val ratedCurrent = parse_element (element ("""Switch.ratedCurrent"""))_
    val retained = parse_element (element ("""Switch.retained"""))_
    val switchOnCount = parse_element (element ("""Switch.switchOnCount"""))_
    val CompositeSwitch = parse_attribute (attribute ("""Switch.CompositeSwitch"""))_
    val Outage = parse_attribute (attribute ("""Switch.Outage"""))_
    val SwitchAction = parse_attribute (attribute ("""Switch.SwitchAction"""))_
    def parse (context: Context): Switch =
    {
        return (
            Switch
            (
                ConductingEquipment.parse (context),
                toBoolean (normalOpen (context), context),
                toBoolean (open (context), context),
                ratedCurrent (context),
                toBoolean (retained (context), context),
                toInteger (switchOnCount (context), context),
                CompositeSwitch (context),
                Outage (context),
                SwitchAction (context)
            )
        )
    }
}

case class TransformerEnd
(
    override val sup: IdentifiedObject,
    val bmagSat: Double,
    val endNumber: Int,
    val grounded: Boolean,
    val magBaseU: Double,
    val magSatFlux: Double,
    val rground: Double,
    val xground: Double,
    val BaseVoltage: String,
    val CoreAdmittance: String,
    val PhaseTapChanger: String,
    val RatioTapChanger: String,
    val StarImpedance: String,
    val Terminal: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0, false, 0.0, 0.0, 0.0, 0.0, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerEnd]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerEnd
extends
    Parseable[TransformerEnd]
{
    val bmagSat = parse_element (element ("""TransformerEnd.bmagSat"""))_
    val endNumber = parse_element (element ("""TransformerEnd.endNumber"""))_
    val grounded = parse_element (element ("""TransformerEnd.grounded"""))_
    val magBaseU = parse_element (element ("""TransformerEnd.magBaseU"""))_
    val magSatFlux = parse_element (element ("""TransformerEnd.magSatFlux"""))_
    val rground = parse_element (element ("""TransformerEnd.rground"""))_
    val xground = parse_element (element ("""TransformerEnd.xground"""))_
    val BaseVoltage = parse_attribute (attribute ("""TransformerEnd.BaseVoltage"""))_
    val CoreAdmittance = parse_attribute (attribute ("""TransformerEnd.CoreAdmittance"""))_
    val PhaseTapChanger = parse_attribute (attribute ("""TransformerEnd.PhaseTapChanger"""))_
    val RatioTapChanger = parse_attribute (attribute ("""TransformerEnd.RatioTapChanger"""))_
    val StarImpedance = parse_attribute (attribute ("""TransformerEnd.StarImpedance"""))_
    val Terminal = parse_attribute (attribute ("""TransformerEnd.Terminal"""))_
    def parse (context: Context): TransformerEnd =
    {
        return (
            TransformerEnd
            (
                IdentifiedObject.parse (context),
                toDouble (bmagSat (context), context),
                toInteger (endNumber (context), context),
                toBoolean (grounded (context), context),
                toDouble (magBaseU (context), context),
                toDouble (magSatFlux (context), context),
                toDouble (rground (context), context),
                toDouble (xground (context), context),
                BaseVoltage (context),
                CoreAdmittance (context),
                PhaseTapChanger (context),
                RatioTapChanger (context),
                StarImpedance (context),
                Terminal (context)
            )
        )
    }
}

case class TransformerTank
(
    override val sup: Equipment,
    PowerTransformer: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerTank]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerTank
extends
    Parseable[TransformerTank]
{
    val PowerTransformer = parse_attribute (attribute ("""TransformerTank.PowerTransformer"""))_
    def parse (context: Context): TransformerTank =
    {
        return (
            TransformerTank
            (
                Equipment.parse (context),
                PowerTransformer (context)
            )
        )
    }
}

case class TransformerTankEnd
(
    override val sup: TransformerEnd,
    val phases: String,
    val TransformerTank: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def TransformerEnd: TransformerEnd = sup.asInstanceOf[TransformerEnd]
    override def copy (): Row = { return (clone ().asInstanceOf[TransformerTankEnd]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerTankEnd
extends
    Parseable[TransformerTankEnd]
{
    val phases = parse_attribute (attribute ("""TransformerTankEnd.phases"""))_
    val TransformerTank = parse_attribute (attribute ("""TransformerTankEnd.TransformerTank"""))_
    def parse (context: Context): TransformerTankEnd =
    {
        return (
            TransformerTankEnd
            (
                TransformerEnd.parse (context),
                phases (context),
                TransformerTank (context)
            )
        )
    }
}

object Wires
{
    def register: Unit =
    {
        ACLineSegment.register
        ACLineSegmentPhase.register
        BusbarSection.register
        Conductor.register
        Connector.register
        Disconnector.register
        EnergyConsumer.register
        Fuse.register
        GroundDisconnector.register
        Junction.register
        Line.register
        PowerTransformer.register
        PowerTransformerEnd.register
        Switch.register
        TransformerEnd.register
        TransformerTank.register
        TransformerTankEnd.register
    }
}

/*
 * Work
 */

case class WorkLocation
(
    override val sup: Location,
    val OneCallRequest: String
)
extends
    Element
{
    def this () = { this (null, null) }
    override def copy (): Row = { return (clone ().asInstanceOf[WorkLocation]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkLocation
extends
    Parseable[WorkLocation]
{
    val OneCallRequest = parse_element (element ("""WorkLocation.OneCallRequest"""))_
    def parse (context: Context): WorkLocation =
    {
        return (
            WorkLocation
            (
                Location.parse (context),
                OneCallRequest (context)
            )
        )
    }
}

object Work
{
    def register: Unit =
    {
        WorkLocation.register
    }
}

//
// END CASE CLASS SECTION
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
    Common.register
    Core.register
    Customers.register
    Metering.register
    Production.register
    Protection.register
    StateVariables.register
    Wires.register
    Work.register

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
