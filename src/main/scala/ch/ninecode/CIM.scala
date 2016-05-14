package ch.ninecode

import java.lang.NumberFormatException
import java.util.regex.Pattern
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet

import org.apache.spark.sql.Row

class Result (val context: Context)
{
    var properties = new HashMap[String, String]
}

trait Parser
{
    def steps (): Array[(String, Result) ⇒ Unit]
    def parse (xml: String, result: Result): Unit =
        for (f <- steps)
            f (xml, result)
}

abstract class Element (val key: String) extends Serializable with Row
{
    def copy (): org.apache.spark.sql.Row = new IdentifiedElement (key)
    override def get (i: Int): Any =
    {
        if (0 != i)
            throw new IllegalArgumentException ("only one property")
        else
            key
    }
    def length: Int = 1
    def apply(i: Int): Any =
    {
        if (0 != i)
            throw new IllegalArgumentException ("only one property")
        else
            key
    }

  /** Checks whether the value at position i is null. */
  def isNullAt(i: Int): Boolean = get(i) == null

  /**
   * Returns the value at position i as a primitive boolean.
   *
   * @throws ClassCastException when data type does not match.
   * @throws NullPointerException when value is null.
   */
  def getBoolean(i: Int): Boolean = getAnyValAs[Boolean](i)

  /**
   * Returns the value at position i as a primitive byte.
   *
   * @throws ClassCastException when data type does not match.
   * @throws NullPointerException when value is null.
   */
  def getByte(i: Int): Byte = getAnyValAs[Byte](i)

  /**
   * Returns the value at position i as a primitive short.
   *
   * @throws ClassCastException when data type does not match.
   * @throws NullPointerException when value is null.
   */
  def getShort(i: Int): Short = getAnyValAs[Short](i)

  /**
   * Returns the value at position i as a primitive int.
   *
   * @throws ClassCastException when data type does not match.
   * @throws NullPointerException when value is null.
   */
  def getInt(i: Int): Int = getAnyValAs[Int](i)

  /**
   * Returns the value at position i as a primitive long.
   *
   * @throws ClassCastException when data type does not match.
   * @throws NullPointerException when value is null.
   */
  def getLong(i: Int): Long = getAnyValAs[Long](i)

  /**
   * Returns the value at position i as a primitive float.
   * Throws an exception if the type mismatches or if the value is null.
   *
   * @throws ClassCastException when data type does not match.
   * @throws NullPointerException when value is null.
   */
  def getFloat(i: Int): Float = getAnyValAs[Float](i)

  /**
   * Returns the value at position i as a primitive double.
   *
   * @throws ClassCastException when data type does not match.
   * @throws NullPointerException when value is null.
   */
  def getDouble(i: Int): Double = getAnyValAs[Double](i)

  /**
   * Returns the value at position i as a String object.
   *
   * @throws ClassCastException when data type does not match.
   */
  def getString(i: Int): String = getAs[String](i)


  /**
   * Returns the value of a given fieldName.
   *
   * @throws UnsupportedOperationException when schema is not defined.
   * @throws ClassCastException when data type does not match.
   * @throws NullPointerException when value is null.
   */
  private def getAnyValAs[T <: AnyVal](i: Int): T =
    if (isNullAt(i)) throw new NullPointerException(s"Value at index $i in null")
    else getAs[T](i)

  /**
   * Return a Scala Seq representing the row. Elements are placed in the same order in the Seq.
   */
  def toSeq: Seq[Any] = {
    val n = length
    val values = new Array[Any](n)
    var i = 0
    while (i < n) {
      values.update(i, get(i))
      i += 1
    }
    values.toSeq
  }
}

object Element extends Parser
{
    override def steps () = Array ()

    /**
     * Parse one XML element from a string.
     * @param pattern the regular expression pattern to look for
     * @param index the number of the capture group to extract from within the pattern
     * @param xml the text to parse
     * @param context the context for the substring in the XML and
     * line number and position context for reporting in case of an error
     * @return the matched group from the regular expression
     */
    def parse_element (pattern: Pattern, index: Int, xml:String, context: Context): String =
    {
        val optional = true

        var ret:String = null
        val matcher = pattern.matcher (xml)
        if (matcher.find ())
            ret = matcher.group (index)
        else
            if (!optional)
                throw new Exception ("regular expression " + pattern.toString () + " not found while parsing at line " + context.line_number ())

        return (ret)
    }

    /**
     * Parse one attribute from an XML string.
     * @param pattern the regular expression pattern to look for
     * @param index the number of the capture group to extract from within the pattern
     * @param xml the text to parse
     * @param context the context for the substring in the XML and
     * line number and position context for reporting in case of an error
     * @return the attribute value (with leading # stripped off)
     */
    def parse_attribute (pattern: Pattern, index: Int, xml:String, context: Context): String =
    {
        var ret = parse_element (pattern, index, xml, context)
        if ((null != ret) && ret.startsWith ("#")) // remove '#'
            ret = ret.substring (1)

        return (ret)
    }

    /**
     * Extract and store a property function generator.
     *
     * Using the provided regular expression, parse out the value of the given property
     * which has the given group index and store it under the property name provided.
     * Complain with an exception if the property is not found and mandatory is true.
     *
     * Curry the function with a string to parse and the parsing result/context.
     *
     * @param regex The regular expression with at least one group
     * that can pick out the property value - which will be a string so it can be
     * stored in the properties collection.
     * @param index The group index of the property pattern within the regular expression.
     * @param name The name of the property under which to store the
     * value in the properties collection.
     * @param mandatory If true and the property is not found by the regular expression,
     * throw an exception.
     * @param xml The substring to parse.
     * @param context The context object with character offsets and linenumber index array.
     */
    def parse_element (regex: Pattern, index: Int, name: String, mandatory: Boolean)(xml: String, result: Result): Unit =
    {
        val context = result.context
        val value = Element.parse_element (regex, index, xml, context)
        if (null != value)
            result.properties.put (name, value)
        else
            if (mandatory)
                throw new Exception ("mandatory " + name + " value not found while parsing at line " + context.line_number () + " with text: '" + xml + "'")
    }

    def parse_attribute (regex: Pattern, index: Int, name: String, mandatory: Boolean)(xml: String, result: Result): Unit =
    {
        val context = result.context
        val value = Element.parse_attribute (regex, index, xml, context)
        if (null != value)
            result.properties.put (name, value)
        else
            if (mandatory)
                throw new Exception ("mandatory " + name + " value not found while parsing at line " + context.line_number () + " with text: '" + xml + "'")
    }
}

case class Unknown (override val key: String, guts: String, line: Int, start: Long, end: Long) extends Element (key)

object Unknown extends Parser
{
    override def steps () = Array (Element.parse)
    def unpickle (xml: String, result: Result): Unknown =
    {
        parse (xml, result)
        val ret = Unknown (xml.hashCode().toString(), xml, result.context.line_number (), result.context.start, result.context.end)
        return (ret)
    }
}

class IdentifiedElement (val id: String) extends Element (id)

object IdentifiedElement extends Parser
{
    val idex = Pattern.compile ("""rdf:ID=("|')([\s\S]*?)\1""")
    override def steps () = Array (
        Element.parse,
        Element.parse_attribute (idex, 2, "id", true)_)
}

abstract class NamedElement (override val id: String, val alias: String, val description: String, val name: String) extends IdentifiedElement (id)

object NamedElement extends Parser
{
    val aliex = Pattern.compile ("""<cim:IdentifiedObject.aliasName>([\s\S]*?)<\/cim:IdentifiedObject.aliasName>""")
    val desex = Pattern.compile ("""<cim:IdentifiedObject.description>([\s\S]*?)<\/cim:NameTypeAuthority.description>""")
    val namex = Pattern.compile ("""<cim:IdentifiedObject.name>([\s\S]*?)<\/cim:IdentifiedObject.name>""")
    override def steps () = Array (
        IdentifiedElement.parse,
        Element.parse_element (aliex, 1, "name", false)_,
        Element.parse_element (desex, 1, "name", false)_,
        Element.parse_element (namex, 1, "name", false)_)
}

abstract class PowerSystemResource (override val id: String, override val alias: String, override val description: String, override val name: String, val typ: String) extends NamedElement (id, alias, description, name)

object PowerSystemResource extends Parser
{
    val typex = Pattern.compile ("""<cim:PowerSystemResource.PSRType\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    override def steps () = Array (
        NamedElement.parse,
        Element.parse_element (typex, 2, "type", false)_)
}

abstract class LocatedElement (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, val location: String, val container: String) extends PowerSystemResource (id, alias, description, name, typ)

object LocatedElement extends Parser
{
    val locex = Pattern.compile ("""<cim:PowerSystemResource.Location>([\s\S]*?)<\/cim:PowerSystemResource.Location>""")
    val conex = Pattern.compile ("""<cim:Equipment.EquipmentContainer\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    override def steps () = Array (
        PowerSystemResource.parse,
        Element.parse_element (locex, 1, "location", true)_,
        Element.parse_attribute (conex, 2, "container", false)_
    )
}

//        <cim:PSRType rdf:ID="PSRType_Substation">
//                <cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>
//        </cim:PSRType>
case class PSRType (override val id: String, override val alias: String, override val description: String, override val name: String) extends NamedElement (id, alias, description, name)

object PSRType extends Parser
{
    override def steps () = Array (NamedElement.parse)
    def unpickle (xml: String, result: Result): PSRType =
    {
        parse (xml, result)
        val ret = PSRType (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""))
        return (ret)
    }
}

//    <cim:SvStatus rdf:ID="in_use">
//        <cim:SvStatus.inService>true</cim:SvStatus.inService>
//    </cim:SvStatus>

case class SvStatus (override val id: String, val inservice: String) extends IdentifiedElement (id)

object SvStatus extends Parser
{
    val statex = Pattern.compile ("""<cim:SvStatus.inService>([\s\S]*?)<\/cim:SvStatus.inService>""")

    override def steps () = Array (
        IdentifiedElement.parse,
        Element.parse_element (statex, 1, "status", true)_)
    def unpickle (xml: String, result: Result): SvStatus =
    {
        parse (xml, result)
        val ret = SvStatus (result.properties ("id"), result.properties.getOrElse ("status", ""))
        return (ret)
    }
}

class Container (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String) extends PowerSystemResource (id, alias, description, name, typ)

//        <cim:Line rdf:ID="_subnetwork_349554">
//                <cim:IdentifiedObject.name>ABG2236|ABG7246|APP197|FLT13|FLU20|FLU21|FLU22|FLU23|HAS332|HAS333|HAS334|HAS335|MUF2681|MUF2682|PIN2</cim:IdentifiedObject.name>
//        </cim:Line>
case class Line (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String) extends Container (id, alias, description, name, typ)

object Line extends Parser
{
    override def steps () = Array (PowerSystemResource.parse)
    def unpickle (xml: String, result: Result): Line =
    {
        parse (xml, result)
        val ret = Line (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("typ", ""))
        return (ret)
    }
}

//    <cim:Substation rdf:ID="VOR1">
//        <cim:IdentifiedObject.name>Gebsta_01_SIG_SEV_FUC_OeV</cim:IdentifiedObject.name>
//        <cim:IdentifiedObject.description>unknown internal</cim:IdentifiedObject.description>
//        <cim:IdentifiedObject.aliasName>226431392</cim:IdentifiedObject.aliasName>
//    </cim:Substation>

case class Substation (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String) extends Container (id, alias, description, name, typ)

object Substation extends Parser
{
    override def steps () = Array (PowerSystemResource.parse)
    def unpickle (xml: String, result: Result): Substation =
    {
        parse (xml, result)
        val ret = Substation (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("typ", ""))
        return (ret)
    }
}

//        <cim:VoltageLevel rdf:ID="FUE1">
//                <cim:IdentifiedObject.name>unbekannt</cim:IdentifiedObject.name>
//                <cim:IdentifiedObject.aliasName>8145953</cim:IdentifiedObject.aliasName>
//                <cim:IdentifiedObject.description>VoltageLevel</cim:IdentifiedObject.description>
//                <cim:PowerSystemResource.Location>_location_1610613248_427074625_8145957</cim:PowerSystemResource.Location>
//                <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Substation"/>
//                <cim:VoltageLevel.Substation rdf:resource="#STA1"/>
//        </cim:VoltageLevel>
case class VoltageLevel (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, val location: String, val substation: String) extends Container (id, alias, description, name, typ)

object VoltageLevel extends Parser
{
    val locex = Pattern.compile ("""<cim:PowerSystemResource.Location>([\s\S]*?)<\/cim:PowerSystemResource.Location>""")
    val staex = Pattern.compile ("""<cim:VoltageLevel.Substation\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    override def steps () = Array (
        PowerSystemResource.parse,
        Element.parse_element (locex, 1, "location", false)_,
        Element.parse_element (staex, 2, "substation", false)_)
    def unpickle (xml: String, result: Result): VoltageLevel =
    {
        parse (xml, result)
        val ret = VoltageLevel (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties.getOrElse ("location", ""), result.properties.getOrElse ("substation", ""))
        return (ret)
    }
}

//    <cim:Bay rdf:ID="FEL5256">
//        <cim:IdentifiedObject.name>Gitter</cim:IdentifiedObject.name>
//        <cim:IdentifiedObject.aliasName>225186939</cim:IdentifiedObject.aliasName>
//        <cim:IdentifiedObject.description>Bay</cim:IdentifiedObject.description>
//        <cim:PowerSystemResource.Location>_location_1621084416_427078125_244066523</cim:PowerSystemResource.Location>
//        <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Substation"/>
//        <cim:Bay.Substation rdf:resource="#STA223"/>
//    </cim:Bay>

case class Bay (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, val location: String, val station: String) extends Container (id, alias, description, name, typ)

object Bay extends Parser
{
    val locex = Pattern.compile ("""<cim:PowerSystemResource.Location>([\s\S]*?)<\/cim:PowerSystemResource.Location>""")
    val staex = Pattern.compile ("""<cim:Bay.Substation\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    override def steps () = Array (
        PowerSystemResource.parse,
        Element.parse_element (locex, 1, "location", false)_,
        Element.parse_element (staex, 2, "substation", false)_)
    def unpickle (xml: String, result: Result): Bay =
    {
        parse (xml, result)
        val ret = Bay (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties.getOrElse ("location", ""), result.properties.getOrElse ("substation", ""))
        return (ret)
    }
}

//    <cim:ConnectivityNode rdf:ID="PIN3">
//        <cim:IdentifiedObject.name>TAK389415</cim:IdentifiedObject.name>
//        <cim:IdentifiedObject.description>FLT62 pin 1</cim:IdentifiedObject.description>
//        <cim:IdentifiedObject.aliasName>211215039</cim:IdentifiedObject.aliasName>
//        <cim:ConnectivityNode.ConnectivityNodeContainer rdf:resource="#ABG136225..."/>
//    </cim:ConnectivityNode>

case class ConnectivityNode (override val id: String, override val alias: String, override val description: String, override val name: String, val container: String) extends NamedElement (id, alias, description, name)

object ConnectivityNode extends Parser
{
    val connex = Pattern.compile ("""<cim:ConnectivityNode.ConnectivityNodeContainer\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    override def steps () = Array (
        NamedElement.parse,
        Element.parse_attribute (connex, 2, "container", true)_)
    def unpickle (xml: String, result: Result): ConnectivityNode =
    {
        parse (xml, result)
        val ret = ConnectivityNode (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("container", ""))
        return (ret)
    }
}

//        <cim:BaseVoltage rdf:ID="BaseVoltage_0.400000000000">
//                <cim:IdentifiedObject.name>400.000 V</cim:IdentifiedObject.name>
//                <cim:BaseVoltage.nominalVoltage>0.400000000000</cim:BaseVoltage.nominalVoltage>
//        </cim:BaseVoltage>

case class BaseVoltage (override val id: String, override val alias: String, override val description: String, override val name: String, val voltage: Double) extends NamedElement (id, alias, description, name)

object BaseVoltage extends Parser
{
    val voltex = Pattern.compile ("""<cim:BaseVoltage.nominalVoltage>([\s\S]*?)<\/cim:BaseVoltage.nominalVoltage>""")
    override def steps () = Array (
        NamedElement.parse,
        Element.parse_attribute (voltex, 1, "voltage", true)_)
    def unpickle (xml: String, result: Result): BaseVoltage =
    {
        parse (xml, result)
        try
        {
            val voltage = result.properties ("voltage")
            val v = voltage.toDouble * 1000.0
            return (BaseVoltage (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), v))
        }
        catch
        {
            case nfe: NumberFormatException ⇒ throw new Exception ("unparsable voltage value found for a voltage element while parsing at line " + result.context.line_number ())
        }
    }

}

//        <cim:CoordinateSystem rdf:ID="wgs_84">
//                <cim:IdentifiedObject.name>WGS 84</cim:IdentifiedObject.name>
//                <cim:CoordinateSystem.crsUrn>EPSG::4326</cim:crsUrn>
//        </cim:CoordinateSystem>

case class CoordinateSystem (override val id: String, override val alias: String, override val description: String, override val name: String, val urn: String) extends NamedElement (id, alias, description, name)

object CoordinateSystem extends Parser
{
    val urnex = Pattern.compile ("""<cim:CoordinateSystem.crsUrn>([\s\S]*?)<\/cim:CoordinateSystem.crsUrn>""")
    override def steps () = Array (NamedElement.parse, Element.parse_attribute (urnex, 1, "urn", true)_)
    def unpickle (xml: String, result: Result): CoordinateSystem =
    {
        parse (xml, result)
        val urn = result.properties ("urn")
        return (CoordinateSystem (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), urn))
    }
}

//    <cim:Location rdf:ID="_location_5773088_1107287243_317923">
//            <cim:Location.CoordinateSystem>wgs_84</cim:Location.CoordinateSystem>
//            <cim:Location.type>geographic</cim:Location.type>
//    </cim:Location>

case class Location (override val id: String, override val alias: String, override val description: String, override val name: String, val cs: String, val typ: String) extends NamedElement (id, alias, description, name)

object Location extends Parser
{
    val csex = Pattern.compile ("""<cim:Location.CoordinateSystem>([\s\S]*?)<\/cim:Location.CoordinateSystem>""")
    val typex = Pattern.compile ("""<cim:Location.type>([\s\S]*?)<\/cim:Location.type>""")
    override def steps () = Array (
        NamedElement.parse,
        Element.parse_element (csex, 1, "cs", true)_,
        Element.parse_element (typex, 1, "type", true)_)
    def unpickle (xml: String, result: Result): Location =
    {
        parse (xml, result)
        val ret = Location (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties ("cs"), result.properties ("type"))
        return (ret)
    }
}

//    <cim:PositionPoint>
//            <cim:PositionPoint.Location>_location_5773088_1107287243_317923</cim:PositionPoint.Location>
//            <cim:PositionPoint.sequenceNumber>0</cim:sequenceNumber>
//            <cim:PositionPoint.xPosition>8.78184724183</cim:xPosition>
//            <cim:PositionPoint.yPosition>47.0400997930</cim:yPosition>
//    </cim:PositionPoint>

case class PositionPoint (override val id: String, override val alias: String, override val description: String, override val name: String, val location: String, val sequence: Int, val x: Double, val y: Double) extends NamedElement (id, alias, description, name)

object PositionPoint extends Parser
{
    val idex = Pattern.compile ("""rdf:ID=("|')([\s\S]*?)\1""")
    val aliex = Pattern.compile ("""<cim:IdentifiedObject.aliasName>([\s\S]*?)<\/cim:IdentifiedObject.aliasName>""")
    val desex = Pattern.compile ("""<cim:IdentifiedObject.description>([\s\S]*?)<\/cim:NameTypeAuthority.description>""")
    val namex = Pattern.compile ("""<cim:IdentifiedObject.name>([\s\S]*?)<\/cim:IdentifiedObject.name>""")
    val locex = Pattern.compile ("""<cim:PositionPoint.Location>([\s\S]*?)<\/cim:PositionPoint.Location>""")
    val seqex = Pattern.compile ("""<cim:PositionPoint.sequenceNumber>([\s\S]*?)<\/cim:PositionPoint.sequenceNumber>""")
    val xposex = Pattern.compile ("""<cim:PositionPoint.xPosition>([\s\S]*?)<\/cim:PositionPoint.xPosition>""")
    val yposex = Pattern.compile ("""<cim:PositionPoint.yPosition>([\s\S]*?)<\/cim:PositionPoint.yPosition>""")

    override def steps () = Array (
//        NamedElement.parse, - removed to make PositionPoint mRID optional
        Element.parse,
        Element.parse_attribute (idex, 2, "id", false)_,
        Element.parse_element (aliex, 1, "name", false)_,
        Element.parse_element (desex, 1, "name", false)_,
        Element.parse_element (namex, 1, "name", false)_,

        Element.parse_attribute (locex, 1, "location", true)_,
        Element.parse_attribute (seqex, 1, "sequence", true)_,
        Element.parse_attribute (xposex, 1, "x", true)_,
        Element.parse_attribute (yposex, 1, "y", true)_)
    def unpickle (xml: String, result: Result): PositionPoint =
    {
        parse (xml, result)
        val location = result.properties ("location")
        try
        {
            val sequence = result.properties ("sequence").toInt
            val key = if (result.properties.contains ("id")) result.properties ("id") else (location + "_seq_" + sequence)
            try
            {
                val x = result.properties ("x").toDouble
                val y = result.properties ("y").toDouble
                val ret = PositionPoint (key, result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), location, sequence, x, y)
                return (ret)
            }
            catch
            {
                case nfe: NumberFormatException ⇒ throw new Exception ("unparsable coordinate value found for a position point element while parsing at line " + result.context.line_number ())
            }
        }
        catch
        {
            case nfe: NumberFormatException ⇒ throw new Exception ("unparsable sequence value found for a position point element while parsing at line " + result.context.line_number ())
        }
    }
}

//        <cim:Asset rdf:ID="_busbar_1772383_asset">
//                <cim:Asset.type>Busbar</cim:Asset.type>
//                <cim:IdentifiedObject.name>Busbar_SAM143</cim:IdentifiedObject.name>
//                <cim:Asset.Location>_location_1610657792_427078125_1772388</cim:Asset.Location>
//                <cim:Asset.PowerSystemResources rdf:resource="#_busbar_1772383"/>
//                <cim:Asset.AssetInfo rdf:resource="#_busbar_spec_566593648"/>
//        </cim:Asset>

case class Asset (override val id: String, override val alias: String, override val description: String, override val name: String, val typ: String, val asset: String, val info: String) extends NamedElement (id, alias, description, name)

object Asset extends Parser
{
    val typex = Pattern.compile ("""<cim:Asset.type>([\s\S]*?)<\/cim:Asset.type>""")
    val assex = Pattern.compile ("""<cim:Asset.PowerSystemResources\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val infox = Pattern.compile ("""<cim:Asset.AssetInfo\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    def typ = Element.parse_element (typex, 1, "type", true)_
    def ass = Element.parse_attribute (assex, 2, "asset", true)_
    def inf = Element.parse_attribute (infox, 2, "info", true)_
    override def steps () = Array (NamedElement.parse, typ, ass, inf)
    def unpickle (xml: String, result: Result): Asset =
    {
        parse (xml, result)
        val ret = Asset (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties ("type"), result.properties ("asset"), result.properties ("info"))
        return (ret)
    }
}

//    <cim:EnergyConsumer rdf:ID="HAS33">
//        <cim:IdentifiedObject.name>HAS33</cim:IdentifiedObject.name>
//        <cim:PowerSystemResource.Location>_location_692959_336864939_209172715</cim:PowerSystemResource.Location>
//        <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Unknown"/>
//        <cim:ConductingEquipment.BaseVoltage rdf:resource="#BaseVoltage_400"/>
//        <cim:Equipment.EquipmentContainer rdf:resource="#ABG46428.."/>
//        <cim:EnergyConsumer.PhaseConnection rdf:resource="http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseShuntConnectionKind.Y"/>
//    </cim:EnergyConsumer>

case class EnergyConsumer (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, override val location: String, override val container: String, val voltage: String, val phase: String) extends LocatedElement (id, alias, description, name, location, container, typ)

object EnergyConsumer extends Parser
{
    val volex = Pattern.compile ("""<cim:ConductingEquipment.BaseVoltage\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val fazex = Pattern.compile ("""<cim:EnergyConsumer.PhaseConnection\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    override def steps () = Array (
        LocatedElement.parse,
        Element.parse_attribute (volex, 2, "voltage", true)_,
        Element.parse_attribute (fazex, 2, "phase", true)_)
    def unpickle (xml: String, result: Result): EnergyConsumer =
    {
        parse (xml, result)
        val ret = EnergyConsumer (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("location"), result.properties.getOrElse ("container", ""), result.properties ("voltage"), result.properties ("phase"))
        return (ret)
    }
}

//<cim:Terminal rdf:ID="_house_connection_1469932_terminal">
//    <cim:IdentifiedObject.name>HAS1_terminal</cim:IdentifiedObject.name>
//    <cim:Terminal.sequenceNumber>1</cim:Terminal.sequenceNumber>
//    <cim:Terminal.phases rdf:resource="http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseCode.ABC"/>
//    <cim:Terminal.ConnectivityNode rdf:resource="#_node_1469932"/>
//    <cim:Terminal.ConductingEquipment rdf:resource="#_house_connection_1469932"/>
//</cim:Terminal>

//    <cim:Terminal rdf:ID="HAS33_terminal">
//        <cim:IdentifiedObject.name>HAS33_terminal</cim:IdentifiedObject.name>
//        <cim:ACDCTerminal.sequenceNumber>1</cim:ACDCTerminal.sequenceNumber>
//        <cim:Terminal.phases rdf:resource="http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseCode.ABC"/>
//        <cim:Terminal.ConnectivityNode rdf:resource="#HAS33_node"/>
//        <cim:Terminal.ConductingEquipment rdf:resource="#HAS33"/>
//    </cim:Terminal>
case class Terminal (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, val sequence: Int, val phase: String, val connectivity: String, val equipment: String) extends PowerSystemResource (id, alias, description, name, typ)

object Terminal extends Parser
{
    val seqex = Pattern.compile ("""<cim:Terminal.sequenceNumber>([\s\S]*?)<\/cim:Terminal.sequenceNumber>""") // ToDo: legacy... to be removed
    val seqey = Pattern.compile ("""<cim:ACDCTerminal.sequenceNumber>([\s\S]*?)<\/cim:ACDCTerminal.sequenceNumber>""")
    val fazex = Pattern.compile ("""<cim:Terminal.phases\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val conex = Pattern.compile ("""<cim:Terminal.ConnectivityNode\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val eqpex = Pattern.compile ("""<cim:Terminal.ConductingEquipment\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    override def steps () = Array (
        PowerSystemResource.parse,
        Element.parse_element (seqex, 1, "sequence", false)_,
        Element.parse_element (seqey, 1, "sequence", false)_,
        Element.parse_attribute (fazex, 2, "phase", false)_,
        Element.parse_attribute (conex, 2, "connectivity", false)_,  // allow for unconnected terminals
        Element.parse_attribute (eqpex, 2, "equipment", true)_)
    def unpickle (xml: String, result: Result): Terminal =
    {
        parse (xml, result)
        var seq = result.properties.getOrElse ("sequence", "")
        var num = 0
        if ("" != seq)
            try
            {
                num = seq.toInt
            }
            catch
            {
                case nfe: NumberFormatException ⇒ throw new Exception ("unparsable sequence value found for a terminal element while parsing at line " + result.context.line_number ())
            }
        else
            throw new Exception ("mandatory sequence value not found for a terminal element while parsing at line " + result.context.line_number ())
        val ret = Terminal (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), num, result.properties.getOrElse ("phase", ""), result.properties.getOrElse ("connectivity", ""), result.properties ("equipment"))
        return (ret)
    }
}

//        <cim:BusbarInfo rdf:ID="_busbar_spec_566593648">
//                <cim:IdentifiedObject.name>unbekannt EWS</cim:IdentifiedObject.name>
//        </cim:BusbarInfo>

case class BusbarInfo (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String) extends PowerSystemResource (id, alias, description, name, typ)

object BusbarInfo extends Parser
{
    override def steps () = Array (PowerSystemResource.parse)
    def unpickle (xml: String, result: Result): BusbarInfo =
    {
        parse (xml, result)
        val ret = BusbarInfo (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""))
        return (ret)
    }
}

//    <cim:BusbarSection rdf:ID="SAM52">
//        <cim:IdentifiedObject.name>SAM52</cim:IdentifiedObject.name>
//        <cim:IdentifiedObject.aliasName>216654297</cim:IdentifiedObject.aliasName>
//        <cim:PowerSystemResource.Location>_location_1621084416_427078125_304411534</cim:PowerSystemResource.Location>
//        <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Substation"/>
//        <cim:ConductingEquipment.BaseVoltage rdf:resource="#BaseVoltage_400"/>
//        <cim:Equipment.EquipmentContainer rdf:resource="#STA223"/>
//        <cim:BusbarSection.Substation rdf:resource="#STA223"/>
//        <cim:BusbarSection.PhaseConnection rdf:resource="http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseShuntConnectionKind.Y"/>
//    </cim:BusbarSection>

case class BusbarSection (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, override val location: String, override val container: String, val voltage: String, val substation: String, val phase: String) extends LocatedElement (id, alias, description, name, typ, location, container)

object BusbarSection extends Parser
{
    val volex = Pattern.compile ("""<cim:ConductingEquipment.BaseVoltage\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val subex = Pattern.compile ("""<cim:BusbarSection.Substation\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val fazex = Pattern.compile ("""<cim:BusbarSection.PhaseConnectione\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    override def steps () = Array (
        LocatedElement.parse,
        Element.parse_attribute (volex, 2, "voltage", false)_,
        Element.parse_attribute (subex, 2, "substation", false)_,
        Element.parse_attribute (fazex, 2, "phase", false)_
        )
    def unpickle (xml: String, result: Result): BusbarSection =
    {
        parse (xml, result)
        BusbarSection (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("location"), result.properties.getOrElse ("container", ""), result.properties.getOrElse ("voltage", ""), result.properties.getOrElse ("substation", ""), result.properties.getOrElse ("phase", ""))
    }
}

// <cim:Connector rdf:ID="ABG490">
//         <cim:IdentifiedObject.name>ABG490</cim:IdentifiedObject.name>
//         <cim:PowerSystemResource.Location>_location_1610657792_427087417_2101413</cim:PowerSystemResource.Location>
//         <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Unknown"/>
//         <cim:ConductingEquipment.BaseVoltage rdf:resource="#BaseVoltage_0.400000000000"/>
//         <cim:Equipment.aggregate>true</cim:Equipment.aggregate>
//         <cim:Equipment.normallyInService>true</cim:Equipment.normallyInService>
//         <cim:Equipment.EquipmentContainer rdf:resource="#KAB76"/>
// </cim:Connector>
//    <cim:Connector rdf:ID="ABG398">
//        <cim:IdentifiedObject.name>ABG398</cim:IdentifiedObject.name>
//        <cim:IdentifiedObject.aliasName>224465500</cim:IdentifiedObject.aliasName>
//        <cim:PowerSystemResource.Location>_location_1621084416_427088941_224465502</cim:PowerSystemResource.Location>
//        <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Unknown"/>
//        <cim:ConductingEquipment.BaseVoltage rdf:resource="#BaseVoltage_16000"/>
//        <cim:Equipment.aggregate>true</cim:Equipment.aggregate>
//        <cim:Equipment.normallyInService>true</cim:Equipment.normallyInService>
//        <cim:Connector.Bay rdf:resource="#FEL5261"/>
//    </cim:Connector>

case class Connector (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, override val location: String, override val container: String, val voltage: String, val aggregate: String, val inservice: String) extends LocatedElement (id, alias, description, name, typ, location, container)

object Connector extends Parser
{
    val volex = Pattern.compile ("""<cim:ConductingEquipment.BaseVoltage\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val aggex = Pattern.compile ("""<cim:Equipment.aggregate>([\s\S]*?)<\/cim:Equipment.aggregate>""")
    val serex = Pattern.compile ("""<cim:Equipment.normallyInService>([\s\S]*?)<\/cim:Equipment.normallyInService>""")

    override def steps () = Array (
        LocatedElement.parse,
        Element.parse_attribute (volex, 2, "voltage", true)_,
        Element.parse_attribute (aggex, 1, "aggregate", true)_,
        Element.parse_attribute (serex, 1, "inservice", true)_)
    def unpickle (xml: String, result: Result): Connector =
    {
        parse (xml, result)
        Connector (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("location"), result.properties.getOrElse ("container", ""), result.properties ("voltage"), result.properties ("aggregate"), result.properties ("inservice"))
    }
}

//    <cim:Junction rdf:ID="MUF66">
//        <cim:IdentifiedObject.name>MUF66</cim:IdentifiedObject.name>
//        <cim:IdentifiedObject.aliasName>210841217</cim:IdentifiedObject.aliasName>
//        <cim:PowerSystemResource.Location>_location_696466_1069833313_210841219</cim:PowerSystemResource.Location>
//        <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Unknown"/>
//        <cim:ConductingEquipment.BaseVoltage rdf:resource="#BaseVoltage_400"/>
//        <cim:Equipment.EquipmentContainer rdf:resource="#ABG1796|ABG1964|HAS42|KLE103349|KLE410|KLE411|KLE412|MUF66|MUF817"/>
//    </cim:Junction>

case class Junction (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, override val location: String, override val container: String, val voltage: String) extends LocatedElement (id, alias, description, name, typ, location, container)

object Junction extends Parser
{
    val volex = Pattern.compile ("""<cim:ConductingEquipment.BaseVoltage\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    override def steps () = Array (
        LocatedElement.parse,
        Element.parse_attribute (volex, 2, "voltage", true)_)
    def unpickle (xml: String, result: Result): Junction =
    {
        parse (xml, result)
        Junction (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("location"), result.properties.getOrElse ("container", ""), result.properties ("voltage"))
    }
}

// <cim:CableInfo rdf:ID="_cable_spec_566593874">
//    <cim:IdentifiedObject.name>TT 4x1x70</cim:IdentifiedObject.name>
// </cim:CableInfo>

case class CableInfo (override val id: String, override val alias: String, override val description: String, override val name: String) extends NamedElement (id, alias, description, name)

object CableInfo extends Parser
{
    override def steps () = Array (NamedElement.parse)
    def unpickle (xml: String, result: Result): CableInfo =
    {
        parse (xml, result)
        val ret = CableInfo (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""))
        return (ret)
    }
}

//    <cim:ACLineSegment rdf:ID="KLE78867">
//        <cim:IdentifiedObject.name>Unbekannt</cim:IdentifiedObject.name>
//        <cim:IdentifiedObject.aliasName>224366389</cim:IdentifiedObject.aliasName>
//        <cim:PowerSystemResource.Location>_location_1621084416_426953125_255072024</cim:PowerSystemResource.Location>
//        <cim:Conductor.length>97.49800033</cim:Conductor.length>
//        <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Unknown"/>
//        <cim:ConductingEquipment.BaseVoltage rdf:resource="BaseVoltage_400"/>
//        <cim:ConductingEquipment.SvStatus rdf:resource="#in_use"/>
//        <cim:Equipment.EquipmentContainer rdf:resource="#STA223"/>
//    </cim:ACLineSegment>

case class ACLineSegment (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, override val location: String, override val container: String, val len: String, val voltage: String, val status: String) extends LocatedElement (id, alias, description, name, typ, location, container)

object ACLineSegment extends Parser
{
    val lenex = Pattern.compile ("""<cim:Conductor.length>([\s\S]*?)<\/cim:Conductor.length>""")
    val volex = Pattern.compile ("""<cim:ConductingEquipment.BaseVoltage\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val staex = Pattern.compile ("""<cim:ConductingEquipment.SvStatus\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    override def steps () = Array (
        LocatedElement.parse,
        Element.parse_element (lenex, 1, "length", false)_,
        Element.parse_attribute (volex, 2, "voltage", false)_,
        Element.parse_attribute (staex, 2, "status", false)_)
    def unpickle (xml: String, result: Result): ACLineSegment =
    {
        parse (xml, result)
        val length = result.properties.get ("length") match
        {
            case Some (value) ⇒ value
            case None ⇒ "0"
        }
        val volts = result.properties.get ("voltage") match
        {
            case Some (value) ⇒ value
            case None ⇒ "0"
        }
        val ret = ACLineSegment (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("location"), result.properties.getOrElse ("container", ""), length, volts, result.properties.getOrElse ("status", ""))
        return (ret)
    }
}

//<cim:ACLineSegmentPhase rdf:ID="_internal_line_2094357_phase_A">
//   <cim:IdentifiedObject.name>KLE8207_phase_A</cim:IdentifiedObject.name>
//   <cim:ACLineSegmentPhase.phase rdf:resource="http://iec.ch/TC57/2010/CIM-schema-cim15#SinglePhaseKind.A"/>
//   <cim:ACLineSegmentPhase.ACLineSegment rdf:resource="_internal_line_2094357"/>
//</cim:ACLineSegmentPhase>

case class ACLineSegmentPhase (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, val phase: String, val segment: String) extends PowerSystemResource (id, alias, description, name, typ)

object ACLineSegmentPhase extends Parser
{
    val fazex = Pattern.compile ("""<cim:ACLineSegmentPhase.phase\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val segex = Pattern.compile ("""<cim:ACLineSegmentPhase.ACLineSegment\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    def faz = Element.parse_attribute (fazex, 2, "phase", true)_
    def seg = Element.parse_attribute (segex, 2, "segment", true)_
    override def steps () = Array (
        PowerSystemResource.parse,
        faz,
        seg)
    def unpickle (xml: String, result: Result): ACLineSegmentPhase =
    {
        parse (xml, result)
        val ret = ACLineSegmentPhase (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties apply "phase", result.properties apply "segment")
        return (ret)
    }
}

//        <cim:SwitchInfo rdf:ID="_switch_spec_566593661">
//                <cim:IdentifiedObject.name>G4</cim:IdentifiedObject.name>
//        </cim:SwitchInfo>

case class SwitchInfo (override val id: String, override val alias: String, override val description: String, override val name: String) extends NamedElement (id, alias, description, name)

object SwitchInfo extends Parser
{
    override def steps () = Array (NamedElement.parse)
    def unpickle (xml: String, result: Result): SwitchInfo =
    {
        parse (xml, result)
        val ret = SwitchInfo (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""))
        return (ret)
    }
}

abstract class SwitchElement (override val id: String, override val alias: String, override val description: String, override val name: String, override val location: String, override val typ: String, override val container: String, val voltage: String, val normalOpen: Boolean, val current: String) extends LocatedElement (id, alias, description, name, typ, location, container)

object SwitchElement extends Parser
{
    val voltex = Pattern.compile ("""<cim:BaseVoltage.nominalVoltage>([\s\S]*?)<\/cim:BaseVoltage.nominalVoltage>""")
    val opnex = Pattern.compile ("""<cim:Switch.normalOpen>([\s\S]*?)<\/cim:Switch.normalOpen>""")
    val ampsex = Pattern.compile ("""<cim:Switch.ratedCurrent>([\s\S]*?)<\/cim:Switch.ratedCurrent>""")

    override def steps () = Array (
        LocatedElement.parse,
        Element.parse_attribute (voltex, 1, "voltage", false)_,
        Element.parse_element (opnex, 1, "normalOpen", false)_,
        Element.parse_attribute (ampsex, 1, "current", false)_)
}

//    <cim:LoadBreakSwitch rdf:ID="_switch_1977502">
//            <cim:IdentifiedObject.name>TEI568</cim:IdentifiedObject.name>
//            <cim:PowerSystemResource.Location>_location_1610720512_427087414_1977506</cim:PowerSystemResource.Location>
//            <cim:Switch.normalOpen>false</cim:Switch.normalOpen>
//            <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Substation"/>
//            <cim:Equipment.EquipmentContainer rdf:resource="_substation_251865"/>
//    </cim:LoadBreakSwitch>

//        <cim:Switch rdf:ID="FLT13">
//                <cim:IdentifiedObject.name>FLT13</cim:IdentifiedObject.name>
//                <cim:IdentifiedObject.aliasName>1555060</cim:IdentifiedObject.aliasName>
//                <cim:IdentifiedObject.description>OverheadSwitch</cim:IdentifiedObject.description>
//                <cim:ConductingEquipment.BaseVoltage rdf:resource="#BaseVoltage_0.400000000000"/>
//                <cim:PowerSystemResource.Location>_location_1121749_712623534_1555062</cim:PowerSystemResource.Location>
//                <cim:Switch.normalOpen>false</cim:Switch.normalOpen>
//                <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Overhead"/>
//                <cim:Equipment.EquipmentContainer rdf:resource="#ABG2236|ABG7246|APP197|FLE111|FLE112|FLE114|FLE115|FLE116|FLE117|FLE118|FLE119|FLT13|FLU20|FLU21|FLU22|FLU23|HAS332|HAS333|HAS334|HAS335|KLE572|KLE573|KLE574|KLE575|KLE576|MUF2681|MUF2682|PIN1|PIN2"/>
//        </cim:Switch>

case class Switch (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, override val location: String, override val container: String, override val voltage: String, override val normalOpen: Boolean, override val current: String) extends SwitchElement (id, alias, description, name, typ, location, container, voltage, normalOpen, current)

object Switch extends Parser
{
    override def steps () = Array (
        SwitchElement.parse)
    def unpickle (xml: String, result: Result): Switch =
    {
        parse (xml, result)
        try
        {
            val voltage = result.properties.get ("voltage") match
            {
                case Some (value) ⇒ value
                case None ⇒ ""
            }
            val open = result.properties.get ("normalOpen") match
            {
                case Some (value) ⇒ value.toBoolean
                case None ⇒ false
            }
            val current = result.properties.get ("current") match
            {
                case Some (value) ⇒ value
                case None ⇒ ""
            }
            val ret = Switch (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("location"), result.properties.getOrElse ("container", ""), voltage, open, current)
            return (ret)
        }
        catch
        {
            case iae: IllegalArgumentException ⇒ throw new Exception ("unparsable boolean value found for a normalOpen element while parsing at line " + result.context.line_number ())
        }
    }
}

//        <cim:PowerTransformerInfo rdf:ID="_power_transformer_2083545">
//                <cim:IdentifiedObject.name>Rauscher + Stöckli 100 kVA</cim:IdentifiedObject.name>
//                <cim:PowerTransformerInfo.TransformerTankInfo rdf:resource="#_power_xfrmr_spec_2083545"/>
//        </cim:PowerTransformerInfo>
case class PowerTransformerInfo (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, val info: String) extends PowerSystemResource (id, alias, description, name, typ)

object PowerTransformerInfo extends Parser
{
    val infex = Pattern.compile ("""<cim:PowerTransformerInfo.TransformerTankInfo\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    override def steps () = Array (
        PowerSystemResource.parse,
        Element.parse_attribute (infex, 2, "info", true)_)
    def unpickle (xml: String, result: Result): PowerTransformerInfo =
    {
        parse (xml, result)
        val ret = PowerTransformerInfo (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("info"))
        return (ret)
    }
}

//        <cim:TransformerTankInfo rdf:ID="_power_xfrmr_spec_2083545">
//                <cim:IdentifiedObject.name>Rauscher + Stöckli 100 kVA tank</cim:IdentifiedObject.name>
//                <cim:TransformerTankInfo.PowerTransformerInfo rdf:resource="#_power_transformer_2083545"/>
//        </cim:TransformerTankInfo>

case class TransformerTankInfo (override val id: String, override val alias: String, override val description: String, override val name: String,  override val typ: String, val info: String) extends PowerSystemResource (id, alias, description, name, typ)

object TransformerTankInfo extends Parser
{
    val infex = Pattern.compile ("""<cim:TransformerTankInfo.PowerTransformerInfo\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    def inf = Element.parse_attribute (infex, 2, "info", true)_
    override def steps () = Array (NamedElement.parse, inf)
    def unpickle (xml: String, result: Result): TransformerTankInfo =
    {
        parse (xml, result)
        val ret = TransformerTankInfo (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("info"))
        return (ret)
    }
}

//        <cim:TransformerEndInfo rdf:ID="_power_transformer_2083545_end_info_1">
//                <cim:IdentifiedObject.name>Rauscher + Stöckli 100 kVA_tei_1</cim:IdentifiedObject.name>
//                <cim:TransformerEndInfo.endNumber>1</cim:TransformerEndInfo.endNumber>
//        </cim:TransformerEndInfo>
case class TransformerEndInfo (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, val end: Integer) extends PowerSystemResource (id, alias, description, name, typ)

object TransformerEndInfo extends Parser
{
    val numex = Pattern.compile ("""<cim:TransformerEndInfo.endNumber>([\s\S]*?)<\/cim:TransformerEndInfo.endNumber>""")

    override def steps () = Array (
        PowerSystemResource.parse,
        Element.parse_element (numex, 1, "end", true)_)
    def unpickle (xml: String, result: Result): TransformerEndInfo =
    {
        parse (xml, result)
        val end = result.properties ("end")
        try
        {
            val num = end.toInt
            val ret = TransformerEndInfo (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), num)
            return (ret)
        }
        catch
        {
            case nfe: NumberFormatException ⇒ throw new Exception ("unparsable end value found for a transformer end info element while parsing at line " + result.context.line_number ())
        }
    }
}

//        <cim:PowerTransformer rdf:ID="_transformer_2083545">
//                <cim:IdentifiedObject.name>TRA79</cim:IdentifiedObject.name>
//                <cim:PowerSystemResource.Location>_location_1610630656_427085543_2083549</cim:PowerSystemResource.Location>
//                <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Unknown"/>
//                <cim:Equipment.EquipmentContainer rdf:resource="#_substation_244441"/>
//        </cim:PowerTransformer>

//    <cim:PowerTransformer rdf:ID="TRA5390">
//        <cim:IdentifiedObject.name>630kVA</cim:IdentifiedObject.name>
//        <cim:IdentifiedObject.aliasName>223472225</cim:IdentifiedObject.aliasName>
//        <cim:IdentifiedObject.description>PowerTransformer</cim:IdentifiedObject.description>
//        <cim:PowerSystemResource.Location>_location_1622792960_427088994_298017819</cim:PowerSystemResource.Location>
//        <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Unknown"/>
//        <cim:PowerTransformer.Bay rdf:resource="#FEL5161"/>
//    </cim:PowerTransformer>

case class PowerTransformer (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, override val location: String, override val container: String) extends LocatedElement (id, alias, description, name, location, container, typ)

object PowerTransformer extends Parser
{
    override def steps () = Array (
        LocatedElement.parse)
    def unpickle (xml: String, result: Result): PowerTransformer =
    {
        parse (xml, result)
        val ret = PowerTransformer (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("location"), result.properties.getOrElse ("container", ""))
        return (ret)
    }
}

//       <cim:TransformerTank rdf:ID="_transformer_2083545_tank">
//                <cim:IdentifiedObject.name>TRA79_tank</cim:IdentifiedObject.name>
//                <cim:TransformerTank.PowerTransformer rdf:resource="#_transformer_2083545"/>
//        </cim:TransformerTank>
case class TransformerTank (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, val transformer: String) extends PowerSystemResource (id, alias, description, name, typ)

object TransformerTank extends Parser
{
    val traex = Pattern.compile ("""<cim:TransformerTank.PowerTransformer\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    def tra = Element.parse_attribute (traex, 2, "transformer", true)_
    override def steps () = Array (NamedElement.parse, tra)
    def unpickle (xml: String, result: Result): TransformerTank =
    {
        parse (xml, result)
        val ret = TransformerTank (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("transformer"))
        return (ret)
    }
}

//        <cim:TransformerTankEnd rdf:ID="_transformer_2083545_tank_end_1">
//                <cim:TransformerEnd.endNumber>1</cim:TransformerEnd.endNumber>
//                <cim:IdentifiedObject.name>TRA79_tank_end_1</cim:IdentifiedObject.name>
//                <cim:TransformerTankEnd.phases rdf:resource="http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseCode.ABC"/>
//                <cim:TransformerTankEnd.TransformerTank rdf:resource="#_transformer_2083545_tank"/>
//                <cim:TransformerEnd.Terminal rdf:resource="#_transformer_2083545_terminal_1"/>
//                <cim:TransformerEnd.BaseVoltage rdf:resource="#BaseVoltage_16.0000000000"/>
//        </cim:TransformerTankEnd>
case class TransformerTankEnd (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, val end: Integer, val phases: String, val tank: String, val terminal: String, val voltage: String) extends PowerSystemResource (id, alias, description, name, typ)

object TransformerTankEnd extends Parser
{
    val endex = Pattern.compile ("""<cim:TransformerEnd.endNumber>([\s\S]*?)<\/cim:TransformerEnd.endNumber>""")
    val fazex = Pattern.compile ("""<cim:TransformerTankEnd.phases\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val tnkex = Pattern.compile ("""<cim:TransformerTankEnd.TransformerTank\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val trmex = Pattern.compile ("""<cim:TransformerEnd.Terminal\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val volex = Pattern.compile ("""<cim:TransformerEnd.BaseVoltage\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")

    override def steps () = Array (
        PowerSystemResource.parse,
        Element.parse_element (endex, 1, "end", true)_,
        Element.parse_attribute (fazex, 2, "phases", true)_,
        Element.parse_attribute (tnkex, 2, "tank", true)_,
        Element.parse_attribute (trmex, 2, "terminal", true)_,
        Element.parse_attribute (volex, 2, "voltage", true)_)
    def unpickle (xml: String, result: Result): TransformerTankEnd =
    {
        parse (xml, result)
        val end = result.properties ("end")
        try
        {
            val num = end.toInt
            val ret = TransformerTankEnd (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), num, result.properties ("phases"), result.properties ("tank"), result.properties ("terminal"), result.properties ("voltage"))
            return (ret)
        }
        catch
        {
            case nfe: NumberFormatException ⇒ throw new Exception ("unparsable end value found for a tank end element while parsing at line " + result.context.line_number ())
        }
    }
}

//        <cim:Fuse rdf:ID="SIG1">
//                <cim:IdentifiedObject.name>unbekannt</cim:IdentifiedObject.name>
//                <cim:IdentifiedObject.aliasName>8146036</cim:IdentifiedObject.aliasName>
//                <cim:IdentifiedObject.description>Fuse SIG1 SIC1</cim:IdentifiedObject.description>
//                <cim:ConductingEquipment.BaseVoltage rdf:resource="#BaseVoltage_0.00000000000"/>
//                <cim:PowerSystemResource.Location>_location_1610613248_427074972_8146037</cim:PowerSystemResource.Location>
//                <cim:Switch.normalOpen>true</cim:Switch.normalOpen>
//                <cim:Switch.ratedCurrent>100.000 A</cim:Switch.ratedCurrent>
//                <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Substation"/>
//                <cim:Equipment.EquipmentContainer rdf:resource="#STA1"/>
//        </cim:Fuse>
case class Fuse (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, override val location: String, override val container: String, override val voltage: String, override val normalOpen: Boolean, override val current: String) extends SwitchElement (id, alias, description, name, typ, location, container, voltage, normalOpen, current)

object Fuse extends Parser
{
    override def steps () = Array (
        SwitchElement.parse)
    def unpickle (xml: String, result: Result): Fuse =
    {
        parse (xml, result)
        try
        {
            val voltage = result.properties.get ("voltage") match
            {
                case Some (value) ⇒ value
                case None ⇒ ""
            }
            val open = result.properties.get ("normalOpen") match
            {
                case Some (value) ⇒ value.toBoolean
                case None ⇒ false
            }
            val typ = result.properties.get ("type") match
            {
                case Some (value) ⇒ value
                case None ⇒ ""
            }
            val current = result.properties.get ("current") match
            {
                case Some (value) ⇒ value
                case None ⇒ ""
            }
            val ret = Fuse (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("location"), result.properties.getOrElse ("container", ""), voltage, open, current)
            return (ret)
        }
        catch
        {
            case iae: IllegalArgumentException ⇒ throw new Exception ("unparsable boolean value found for a normalOpen element while parsing at line " + result.context.line_number ())
        }
    }
}

//        <cim:Disconnector rdf:ID="TRE1">
//                <cim:IdentifiedObject.name>unbekannt normal</cim:IdentifiedObject.name>
//                <cim:IdentifiedObject.aliasName>8146017</cim:IdentifiedObject.aliasName>
//                <cim:IdentifiedObject.description>Disconnector</cim:IdentifiedObject.description>
//                <cim:ConductingEquipment.BaseVoltage rdf:resource="#BaseVoltage_0.00000000000"/>
//                <cim:PowerSystemResource.Location>_location_1610613248_427074933_8146018</cim:PowerSystemResource.Location>
//                <cim:Switch.normalOpen>false</cim:Switch.normalOpen>
//                <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Substation"/>
//                <cim:Equipment.EquipmentContainer rdf:resource="#STA1"/>
//        </cim:Disconnector>
case class Disconnector (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, override val location: String, override val container: String, override val voltage: String, override val normalOpen: Boolean, override val current: String) extends SwitchElement (id, alias, description, name, typ, location, container, voltage, normalOpen, current)

object Disconnector extends Parser
{
    override def steps () = Array (
        SwitchElement.parse)
    def unpickle (xml: String, result: Result): Disconnector =
    {
        parse (xml, result)
        try
        {
            val voltage = result.properties.get ("voltage") match
            {
                case Some (value) ⇒ value
                case None ⇒ ""
            }
            val open = result.properties.get ("normalOpen") match
            {
                case Some (value) ⇒ value.toBoolean
                case None ⇒ false
            }
            val typ = result.properties.get ("type") match
            {
                case Some (value) ⇒ value
                case None ⇒ ""
            }
            val current = result.properties.get ("current") match
            {
                case Some (value) ⇒ value
                case None ⇒ ""
            }
            val ret = Disconnector (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("location"), result.properties.getOrElse ("container", ""),  voltage, open, current)
            return (ret)
        }
        catch
        {
            case iae: IllegalArgumentException ⇒ throw new Exception ("unparsable boolean value found for a normalOpen element while parsing at line " + result.context.line_number ())
        }
    }
}

//        <cim:GroundDisconnector rdf:ID="ERS1">
//                <cim:IdentifiedObject.name>unbekannt</cim:IdentifiedObject.name>
//                <cim:IdentifiedObject.aliasName>8145982</cim:IdentifiedObject.aliasName>
//                <cim:IdentifiedObject.description>GroundDisconnector</cim:IdentifiedObject.description>
//                <cim:PowerSystemResource.Location>_location_1610613248_427074619_8145983</cim:PowerSystemResource.Location>
//                <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Substation"/>
//                <cim:Equipment.EquipmentContainer rdf:resource="#STA1"/>
//        </cim:GroundDisconnector>
case class GroundDisconnector (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, override val location: String, override val container: String, override val voltage: String, override val normalOpen: Boolean, override val current: String) extends SwitchElement (id, alias, description, name, typ, location, container, voltage, normalOpen, current)

object GroundDisconnector extends Parser
{
    override def steps () = Array (
        SwitchElement.parse)
    def unpickle (xml: String, result: Result): GroundDisconnector =
    {
        parse (xml, result)
        try
        {
            val voltage = result.properties.get ("voltage") match
            {
                case Some (value) ⇒ value
                case None ⇒ ""
            }
            val open = result.properties.get ("normalOpen") match
            {
                case Some (value) ⇒ value.toBoolean
                case None ⇒ false
            }
            val current = result.properties.get ("current") match
            {
                case Some (value) ⇒ value
                case None ⇒ ""
            }
            val ret = GroundDisconnector (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("location"), result.properties.getOrElse ("container", ""), voltage, open, current)
            return (ret)
        }
        catch
        {
            case iae: IllegalArgumentException ⇒ throw new Exception ("unparsable boolean value found for a normalOpen element while parsing at line " + result.context.line_number ())
        }
    }
}

//        <cim:ProtectionEquipment rdf:ID="SRE1">
//                <cim:IdentifiedObject.name>unbekannt</cim:IdentifiedObject.name>
//                <cim:IdentifiedObject.aliasName>8145907</cim:IdentifiedObject.aliasName>
//                <cim:IdentifiedObject.description>ProtectionEquipment</cim:IdentifiedObject.description>
//                <cim:PowerSystemResource.Location>_location_1610613248_427085208_8145908</cim:PowerSystemResource.Location>
//                <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Substation"/>
//                <cim:Equipment.EquipmentContainer rdf:resource="#SRE1"/>
//        </cim:ProtectionEquipment>^M
case class ProtectionEquipment (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, override val location: String, override val container: String) extends LocatedElement (id, alias, description, name, typ, location, container)

object ProtectionEquipment extends Parser
{
    override def steps () = Array (
        LocatedElement.parse)
    def unpickle (xml: String, result: Result): ProtectionEquipment =
    {
        parse (xml, result)
        val ret = ProtectionEquipment (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("location"), result.properties.getOrElse ("container", ""))
        return (ret)
    }
}

//        <cim:CurrentTransformer rdf:ID="STW1">
//                <cim:IdentifiedObject.name>unbekannt</cim:IdentifiedObject.name>
//                <cim:IdentifiedObject.aliasName>8146007</cim:IdentifiedObject.aliasName>
//                <cim:IdentifiedObject.description>CurrentTransformer</cim:IdentifiedObject.description>
//                <cim:PowerSystemResource.Location>_location_1610613248_427074596_8146008</cim:PowerSystemResource.Location>
//                <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Substation"/>
//                <cim:Equipment.EquipmentContainer rdf:resource="#STA1"/>
//        </cim:CurrentTransformer>^M
case class CurrentTransformer (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, override val location: String, override val container: String) extends LocatedElement (id, alias, description, name, typ, location, container)

object CurrentTransformer extends Parser
{
    override def steps () = Array (
        LocatedElement.parse)
    def unpickle (xml: String, result: Result): CurrentTransformer =
    {
        parse (xml, result)
        val ret = CurrentTransformer (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("location"), result.properties.getOrElse ("container", ""))
        return (ret)
    }
}

//        <cim:CurrentRelay rdf:ID="PRE1">
//                <cim:IdentifiedObject.name>unbekannt</cim:IdentifiedObject.name>
//                <cim:IdentifiedObject.aliasName>8145905</cim:IdentifiedObject.aliasName>
//                <cim:IdentifiedObject.description>CurrentRelay</cim:IdentifiedObject.description>
//                <cim:PowerSystemResource.Location>_location_1610613248_427085208_8145908</cim:PowerSystemResource.Location>
//                <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Substation"/>
//                <cim:Equipment.EquipmentContainer rdf:resource="#PRE1"/>
//        </cim:CurrentRelay>
case class CurrentRelay (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, override val location: String, override val container: String) extends LocatedElement (id, alias, description, name, typ, location, container)

object CurrentRelay extends Parser
{
    override def steps () = Array (
        LocatedElement.parse)
    def unpickle (xml: String, result: Result): CurrentRelay =
    {
        parse (xml, result)
        val ret = CurrentRelay (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("location"), result.properties.getOrElse ("container", ""))
        return (ret)
    }
}

//    <cim:SolarGeneratingUnit rdf:ID="EEA828">
//        <cim:IdentifiedObject.name>EEA828</cim:IdentifiedObject.name>
//        <cim:IdentifiedObject.aliasName>327689371</cim:IdentifiedObject.aliasName>
//        <cim:PowerSystemResource.Location>_location_1755791_1170577924_327689372</cim:PowerSystemResource.Location>
//        <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Unknown"/>
//        <cim:Equipment.EquipmentContainer rdf:resource="#EEA828|MST154744"/>
//    </cim:SolarGeneratingUnit>

case class SolarGeneratingUnit (override val id: String, override val alias: String, override val description: String, override val name: String, override val typ: String, override val location: String, override val container: String) extends LocatedElement (id, alias, description, name, typ, location, container)

object SolarGeneratingUnit extends Parser
{
    override def steps () = Array (
        LocatedElement.parse)
    def unpickle (xml: String, result: Result): SolarGeneratingUnit =
    {
        parse (xml, result)
        val ret = SolarGeneratingUnit (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties ("location"), result.properties.getOrElse ("container", ""))
        return (ret)
    }
}

// <cim:ServiceLocation rdf:ID="MST11">
//         <cim:IdentifiedObject.name>MST11</cim:IdentifiedObject.name>
//         <cim:PowerSystemResource.Location>_location_1121749_1210301218_8141426</cim:PowerSystemResource.Location>
//         <cim:PowerSystemResource.PSRType rdf:resource="#PSRType_Unknown"/>
//         <cim:Equipment.EquipmentContainer rdf:resource="#EEA11|MST11|VER19669"/>
// </cim:ServiceLocation>

//    <cim:ServiceLocation rdf:ID="11100002858">
//        <cim:IdentifiedObject.description>ServiceLocation</cim:IdentifiedObject.description>
//        <cim:IdentifiedObject.name></cim:IdentifiedObject.name>
//        <cim:IdentifiedObject.aliasName>Anschlussobjekt</cim:IdentifiedObject.aliasName>
//        <cim:Location.mainAddress>A 1285,,Albligen,3183,Schwarzenburg</cim:Location.mainAddress>
//    </cim:ServiceLocation>

case class ServiceLocation (override val id: String, override val alias: String, override val description: String, override val name: String, val typ: String, val location: String, val container: String) extends NamedElement (id, alias, description, name)

object ServiceLocation extends Parser
{
    val locex = Pattern.compile ("""<cim:PowerSystemResource.Location>([\s\S]*?)<\/cim:PowerSystemResource.Location>""")
    val conex = Pattern.compile ("""<cim:Equipment.EquipmentContainer\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val addex = Pattern.compile ("""<cim:Location.mainAddress>([\s\S]*?)<\/cim:Location.mainAddress>""")
    override def steps () = Array (
        NamedElement.parse,
        Element.parse_element (locex, 1, "location", false)_,
        Element.parse_attribute (conex, 2, "container", false)_,
        Element.parse_element (addex, 1, "location", false)_
        )
    def unpickle (xml: String, result: Result): ServiceLocation =
    {
        parse (xml, result)

        val ret = ServiceLocation (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("type", ""), result.properties.getOrElse ("location", ""), result.properties.getOrElse ("container", ""))
        return (ret)
    }
}

//    <cim:UsagePointLocation rdf:ID="61708">
//        <cim:IdentifiedObject.description>UsagePointLocation</cim:IdentifiedObject.description>
//        <cim:IdentifiedObject.name></cim:IdentifiedObject.name>
//        <cim:IdentifiedObject.aliasName>Verbrauchsstelle</cim:IdentifiedObject.aliasName>
//        <cim:Location.mainAddress>,,,,</cim:Location.mainAddress>
//    </cim:UsagePointLocation>

case class UsagePointLocation (override val id: String, override val alias: String, override val description: String, override val name: String, val location: String) extends NamedElement (id, alias, description, name)

object UsagePointLocation extends Parser
{
    val addex = Pattern.compile ("""<cim:Location.mainAddress>([\s\S]*?)<\/cim:Location.mainAddress>""")
    override def steps () = Array (
        NamedElement.parse,
        Element.parse_element (addex, 1, "location", false)_
        )
    def unpickle (xml: String, result: Result): UsagePointLocation =
    {
        parse (xml, result)

        val ret = UsagePointLocation (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("location", ""))
        return (ret)
    }
}

//    <cim:ServiceCategory rdf:ID="NETZ">
//        <cim:IdentifiedObject.description>ServiceCategory</cim:IdentifiedObject.description>
//        <cim:IdentifiedObject.name></cim:IdentifiedObject.name>
//        <cim:IdentifiedObject.aliasName>Vertragsart</cim:IdentifiedObject.aliasName>
//    </cim:ServiceCategory>

case class ServiceCategory (override val id: String, override val alias: String, override val description: String, override val name: String) extends NamedElement (id, alias, description, name)

object ServiceCategory extends Parser
{
    override def steps () = Array (
        NamedElement.parse
        )
    def unpickle (xml: String, result: Result): ServiceCategory =
    {
        parse (xml, result)

        val ret = ServiceCategory (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""))
        return (ret)
    }
}

//    <cim:PricingStructure rdf:ID="N5_SD_P">
//        <cim:IdentifiedObject.description>PricingStructure</cim:IdentifiedObject.description>
//        <cim:IdentifiedObject.name></cim:IdentifiedObject.name>
//        <cim:IdentifiedObject.aliasName>Tariftyp</cim:IdentifiedObject.aliasName>
//        <cim:PricingStructure.code>102</cim:PricingStructure.code>
//        <cim:ServiceCategory rdf:resource="NETZ"/>
//    </cim:PricingStructure>

case class PricingStructure (override val id: String, override val alias: String, override val description: String, override val name: String, val code: String, val category: String) extends NamedElement (id, alias, description, name)

object PricingStructure extends Parser
{
    val codex = Pattern.compile ("""<cim:PricingStructure.code>([\s\S]*?)<\/cim:PricingStructure.code>""")
    val catex = Pattern.compile ("""<cim:ServiceCategory\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    override def steps () = Array (
        NamedElement.parse,
        Element.parse_element (codex, 1, "code", false)_,
        Element.parse_element (catex, 2, "category", false)_
        )
    def unpickle (xml: String, result: Result): PricingStructure =
    {
        parse (xml, result)

        val ret = PricingStructure (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("code", ""), result.properties.getOrElse ("category", ""))
        return (ret)
    }
}

//<cim:Customer rdf:ID="_customer_1845515577">
//    <cim:IdentifiedObject.name>HAS14_1</cim:IdentifiedObject.name>
//    <cim:Customer.kind rdf:resource="http://iec.ch/TC57/2010/CIM-schema-cim15#CustomerKind.residential"/>
//    <cim:Customer.locale>fr_CH</cim:Customer.locale>
//    <cim:Customer.service>_ao_902716339</cim:Customer.service>
//</cim:Customer>

//    <cim:Customer rdf:ID="80340129">
//        <cim:IdentifiedObject.description>Customer</cim:IdentifiedObject.description>
//        <cim:IdentifiedObject.name>Centre d'infrastructure de Grolley,Site de Moudon,Gr déf &amp; log Sud</cim:IdentifiedObject.name>
//        <cim:IdentifiedObject.aliasName>Geschaeftspartner</cim:IdentifiedObject.aliasName>
//        <cim:Customer.kind></cim:Customer.kind>
//    </cim:Customer>

case class Customer (override val id: String, override val alias: String, override val description: String, override val name: String, val kind: String, val locale: String, val service: String) extends NamedElement (id, alias, description, name)

object Customer extends Parser
{
    val kinex = Pattern.compile ("""<cim:Customer.kind\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val locex = Pattern.compile ("""<cim:Customer.locale>([\s\S]*?)<\/cim:Customer.locale>""")
    val serex = Pattern.compile ("""<cim:Customer.service>([\s\S]*?)<\/cim:Customer.service>""")

    def kind = Element.parse_attribute (kinex, 2, "kind", false)_
    def loc = Element.parse_element (locex, 1, "locale", false)_
    def serv = Element.parse_element (serex, 1, "service", false)_
    override def steps () = Array (NamedElement.parse, kind, loc, serv)
    def unpickle (xml: String, result: Result): Customer =
    {
        parse (xml, result)
        val ret = Customer (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("kind", ""), result.properties.getOrElse ("locale", ""), result.properties.getOrElse ("service", ""))
        return (ret)
    }
}

//    <cim:CustomerAgreement rdf:ID="41250281">
//        <cim:IdentifiedObject.description>CustomerAgreement</cim:IdentifiedObject.description>
//        <cim:IdentifiedObject.name></cim:IdentifiedObject.name>
//        <cim:IdentifiedObject.aliasName>Vertrag</cim:IdentifiedObject.aliasName>
//        <cim:ServiceCategory rdf:resource="NETZ"/>
//        <cim:Customer rdf:resource="80340129"/>
//    </cim:CustomerAgreement>
case class CustomerAgreement (override val id: String, override val alias: String, override val description: String, override val name: String, val category: String, val customer: String) extends NamedElement (id, alias, description, name)

object CustomerAgreement extends Parser
{
    val catex = Pattern.compile ("""<cim:ServiceCategory\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val cusex = Pattern.compile ("""<cim:Customer\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    override def steps () = Array (
        NamedElement.parse,
        Element.parse_element (catex, 2, "category", false)_,
        Element.parse_element (cusex, 2, "customer", false)_
        )
    def unpickle (xml: String, result: Result): CustomerAgreement =
    {
        parse (xml, result)

        val ret = CustomerAgreement (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("category", ""),result.properties.getOrElse ("customer", ""))
        return (ret)
    }
}

//    <cim:UsagePoint rdf:ID="1189756">
//        <cim:IdentifiedObject.description>UsagePoint</cim:IdentifiedObject.description>
//        <cim:IdentifiedObject.name></cim:IdentifiedObject.name>
//        <cim:IdentifiedObject.aliasName>Versorgungsanlage</cim:IdentifiedObject.aliasName>
//        <cim:UsagePoint.outageRegion>unknown</cim:UsagePoint.outageRegion>
//        <cim:UsagePoint.nominalServiceVoltage>-1</cim:UsagePoint.nominalServiceVoltage>
//        <cim:UsagePoint.ratedPower>-1</cim:UsagePoint.ratedPower>
//        <cim:UsagePoint.ratedCurrent>-1</cim:UsagePoint.ratedCurrent>
//        <cim:ServiceLocation rdf:resource="11100002858"/>
//        <cim:UsagePointLocationLocation rdf:resource="61708"/>
//        <cim:CustomerAgreement rdf:resource="41250281"/>
//        <cim:PricingStructure rdf:resource="N5_SD_P"/>
//    </cim:UsagePoint>
case class UsagePoint (override val id: String, override val alias: String, override val description: String, override val name: String, val outageregion: String, val nominalvoltage: String, val ratedpower: String, val ratedcurrent: String, val servicepoint: String, val usagepointlocation: String, val customeragreement: String, val pricingstructure: String) extends NamedElement (id, alias, description, name)

object UsagePoint extends Parser
{
    val outex = Pattern.compile ("""<cim:UsagePoint.outageRegion>([\s\S]*?)<\/cim:UsagePoint.outageRegion>""")
    val volex = Pattern.compile ("""<cim:UsagePoint.nominalServiceVoltage>([\s\S]*?)<\/cim:UsagePoint.nominalServiceVoltage>""")
    val powex = Pattern.compile ("""<cim:UsagePoint.ratedPower>([\s\S]*?)<\/cim:UsagePoint.ratedPower>""")
    val curex = Pattern.compile ("""<cim:UsagePoint.ratedCurrent>([\s\S]*?)<\/cim:UsagePoint.ratedCurrent>""")
    val locex = Pattern.compile ("""<cim:ServiceLocation\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val uplex = Pattern.compile ("""<cim:UsagePointLocationLocation\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val cusex = Pattern.compile ("""<cim:CustomerAgreement\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val priex = Pattern.compile ("""<cim:PricingStructure\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    override def steps () = Array (
        NamedElement.parse,
        Element.parse_element (outex, 1, "outageregion", false)_,
        Element.parse_element (volex, 1, "voltage", false)_,
        Element.parse_element (powex, 1, "power", false)_,
        Element.parse_element (curex, 1, "current", false)_,
        Element.parse_element (locex, 2, "servicelocation", false)_,
        Element.parse_element (uplex, 2, "usagelocation", false)_,
        Element.parse_element (cusex, 2, "customer", false)_,
        Element.parse_element (priex, 2, "pricing", false)_
        )
    def unpickle (xml: String, result: Result): UsagePoint =
    {
        parse (xml, result)

        val ret = UsagePoint (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""),
                result.properties.getOrElse ("outageregion", ""),
                result.properties.getOrElse ("voltage", ""),
                result.properties.getOrElse ("power", ""),
                result.properties.getOrElse ("current", ""),
                result.properties.getOrElse ("servicelocation", ""),
                result.properties.getOrElse ("usagelocation", ""),
                result.properties.getOrElse ("customer", ""),
                result.properties.getOrElse ("pricing", "")
                )

        return (ret)
    }
}
//        <cim:NameTypeAuthority rdf:ID="sap_isu">
//                <cim:NameTypeAuthority.name>SAP IS-U</cim:NameTypeAuthority.name>
//                <cim:NameTypeAuthority.description>SAP&apos;s Industry Specific Solution for Utilities Industry. It is also referred to as SAP IS-U/CCS (Customer Care and Services). SAP Utilities (SAP IS-U) is a sales and information system for utilities.</cim:NameTypeAuthority.description>
//        </cim:NameTypeAuthority>
case class NameTypeAuthority (override val id: String, val description: String, val name: String) extends IdentifiedElement (id)

object NameTypeAuthority extends Parser
{
    val namex = Pattern.compile ("""<cim:NameTypeAuthority.name>([\s\S]*?)<\/cim:NameTypeAuthority.name>""")
    val desex = Pattern.compile ("""<cim:NameTypeAuthority.description>([\s\S]*?)<\/cim:NameTypeAuthority.description>""")
    override def steps () = Array (
        IdentifiedElement.parse,
        Element.parse_attribute (namex, 1, "name", false)_,
        Element.parse_attribute (desex, 1, "description", false)_)
    def unpickle (xml: String, result: Result): NameTypeAuthority =
    {
        parse (xml, result)
        return (NameTypeAuthority (result.properties ("id"), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", "")))
    }
}

//        <cim:NameType rdf:ID="sap">
//                <cim:NameType.name>SAP link</cim:NameType.name>
//                <cim:NameType.description>Foreign key to SAP IS-U system record.</cim:NameType.description>
//                <cim:NameType.NameTypeAuthority rdf:resource="#sap_isu"/>
//        </cim:NameType>

case class NameType (override val id: String, val description: String, val name: String, val authority: String) extends IdentifiedElement (id)

object NameType extends Parser
{
    val namex = Pattern.compile ("""<cim:NameType.name>([\s\S]*?)<\/cim:NameType.name>""")
    val desex = Pattern.compile ("""<cim:NameType.description>([\s\S]*?)<\/cim:NameType.description>""")
    val autex = Pattern.compile ("""<cim:NameType.NameTypeAuthority\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    override def steps () = Array (
        IdentifiedElement.parse,
        Element.parse_attribute (namex, 1, "name", false)_,
        Element.parse_attribute (desex, 1, "description", false)_,
        Element.parse_attribute (autex, 2, "authority", true)_)
    def unpickle (xml: String, result: Result): NameType =
    {
        parse (xml, result)
        return (NameType (result.properties ("id"), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties ("authority")))
    }
}

//        <cim:Name rdf:ID="AO_ID_MST11">
//                <cim:Name.name>ST-704</cim:Name.name>
//                <cim:Name.IdentifiedObject rdf:resource="#MST11"/>
//                <cim:Name.NameType rdf:resource="#sap"/>
//        </cim:Name>

case class Name (override val id: String, override val alias: String, override val description: String, override val name: String, val object_name: String, val obj: String, val typ: String) extends NamedElement (id, alias, description, name)

object Name extends Parser
{
    val namex = Pattern.compile ("""<cim:Name.name>([\s\S]*?)<\/cim:Name.name>""")
    val objex = Pattern.compile ("""<cim:Name.IdentifiedObject\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    val typex = Pattern.compile ("""<cim:Name.NameType\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>""")
    override def steps () = Array (
        NamedElement.parse,
        Element.parse_attribute (namex, 1, "object_name", true)_,
        Element.parse_attribute (objex, 2, "object", true)_,
        Element.parse_attribute (typex, 2, "type", false)_)
    def unpickle (xml: String, result: Result): Name =
    {
        parse (xml, result)
        val typ = result.properties.get ("type") match
        {
            case Some (value) ⇒ value
            case None ⇒ ""
        }
        return (Name (result.properties ("id"), result.properties.getOrElse ("alias", ""), result.properties.getOrElse ("description", ""), result.properties.getOrElse ("name", ""), result.properties ("object_name"), result.properties ("object"), typ))
    }
}

//    <cim:UserAttribute rdf:ID="MST2_HAS33">
//        <cim:UserAttribute.name>MST2</cim:UserAttribute.name>
//        <cim:UserAttribute.value>HAS33</cim:UserAttribute.value>
//        <cim:UserAttribute.sequenceNumber>1</cim:UserAttribute.sequenceNumber>
//    </cim:UserAttribute>

case class UserAttribute (override val id: String, val name: String, val value: String, val sequence: String) extends IdentifiedElement (id)

object UserAttribute extends Parser
{
    val namex = Pattern.compile ("""<cim:UserAttribute.name>([\s\S]*?)<\/cim:UserAttribute.name>""")
    val valex = Pattern.compile ("""<cim:UserAttribute.value>([\s\S]*?)<\/cim:UserAttribute.value>""")
    val seqex = Pattern.compile ("""<cim:UserAttribute.sequenceNumber>([\s\S]*?)<\/cim:UserAttribute.sequenceNumber>""")
    override def steps () = Array (
        IdentifiedElement.parse,
        Element.parse_attribute (namex, 1, "name", true)_,
        Element.parse_attribute (valex, 1, "value", true)_,
        Element.parse_attribute (seqex, 1, "sequence", false)_)
    def unpickle (xml: String, result: Result): UserAttribute =
    {
        parse (xml, result)
        val typ = result.properties.get ("type") match
        {
            case Some (value) ⇒ value
            case None ⇒ ""
        }
        return (UserAttribute (result.properties ("id"), result.properties.getOrElse ("name", ""), result.properties.getOrElse ("value", ""), result.properties.getOrElse ("sequence", "")))
    }
}

class CIM (var xml:String, var start: Long = 0L, var end: Long = 0L)
{
    if (end == 0L)
        end = start + xml.length ()
    val matcher = CIM.rddex.matcher (xml)
    val context = new Context (start, start, ArrayBuffer (0L))
    context.index_string (xml, context.start)
    val result = new Result (context)

    var key: String = "";
    var value: Element = null;

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
                    val rest = matcher.group (2)
                    val element = name match
                    {
                        case "cim:PSRType" ⇒ PSRType.unpickle (rest, result)
                        case "cim:SvStatus" ⇒ SvStatus.unpickle (rest, result)
                        case "cim:Line" ⇒ Line.unpickle (rest, result)
                        case "cim:Substation" ⇒ Substation.unpickle (rest, result)
                        case "cim:VoltageLevel" ⇒ VoltageLevel.unpickle (rest, result)
                        case "cim:Bay" ⇒ Bay.unpickle (rest, result)
                        case "cim:ConnectivityNode" ⇒ ConnectivityNode.unpickle (rest, result)
                        case "cim:BaseVoltage" ⇒ BaseVoltage.unpickle (rest, result)
                        case "cim:CoordinateSystem" ⇒ CoordinateSystem.unpickle (rest, result)
                        case "cim:Location" ⇒ Location.unpickle (rest, result)
                        case "cim:PositionPoint" ⇒ PositionPoint.unpickle (rest, result);
                        case "cim:Asset" ⇒ Asset.unpickle (rest, result)
                        case "cim:EnergyConsumer" ⇒ EnergyConsumer.unpickle (rest, result)
                        case "cim:Terminal" ⇒ Terminal.unpickle (rest, result)
                        case "cim:BusbarInfo" ⇒ BusbarInfo.unpickle (rest, result)
                        case "cim:BusbarSection" ⇒ BusbarSection.unpickle (rest, result)
                        case "cim:Connector" ⇒ Connector.unpickle (rest, result)
                        case "cim:Junction" ⇒ Junction.unpickle (rest, result)
                        case "cim:CableInfo" ⇒ CableInfo.unpickle (rest, result)
                        case "cim:ACLineSegment" ⇒ ACLineSegment.unpickle (rest, result)
                        case "cim:ACLineSegmentPhase" ⇒ ACLineSegmentPhase.unpickle (rest, result)
                        case "cim:SwitchInfo" ⇒ SwitchInfo.unpickle (rest, result)
                        case "cim:Switch" ⇒ Switch.unpickle (rest, result)
                        case "cim:LoadBreakSwitch" ⇒ Switch.unpickle (rest, result)
                        case "cim:PowerTransformerInfo" ⇒ PowerTransformerInfo.unpickle (rest, result)
                        case "cim:TransformerTankInfo" ⇒ TransformerTankInfo.unpickle (rest, result)
                        case "cim:TransformerEndInfo" ⇒ TransformerEndInfo.unpickle (rest, result)
                        case "cim:PowerTransformer" ⇒ PowerTransformer.unpickle (rest, result)
                        case "cim:TransformerTank" ⇒ TransformerTank.unpickle (rest, result)
                        case "cim:TransformerTankEnd" ⇒ TransformerTankEnd.unpickle (rest, result)
                        case "cim:Fuse" ⇒ Fuse.unpickle (rest, result)
                        case "cim:Disconnector" ⇒ Disconnector.unpickle (rest, result)
                        case "cim:GroundDisconnector" ⇒ GroundDisconnector.unpickle (rest, result)
                        case "cim:ProtectionEquipment" ⇒ ProtectionEquipment.unpickle (rest, result)
                        case "cim:CurrentTransformer" ⇒ CurrentTransformer.unpickle (rest, result)
                        case "cim:CurrentRelay" ⇒ CurrentRelay.unpickle (rest, result)
                        case "cim:SolarGeneratingUnit" ⇒ SolarGeneratingUnit.unpickle (rest, result)

                        case "cim:ServiceLocation" ⇒ ServiceLocation.unpickle (rest, result)
                        case "cim:UsagePointLocation" ⇒ UsagePointLocation.unpickle (rest, result)
                        case "cim:ServiceCategory" ⇒ ServiceCategory.unpickle (rest, result)
                        case "cim:PricingStructure" ⇒ PricingStructure.unpickle (rest, result)
                        case "cim:Customer" ⇒ Customer.unpickle (rest, result)
                        case "cim:CustomerAgreement" ⇒ CustomerAgreement.unpickle (rest, result)
                        case "cim:UsagePoint" ⇒ UsagePoint.unpickle (rest, result)

                        case "cim:NameTypeAuthority" ⇒ NameTypeAuthority.unpickle (rest, result)
                        case "cim:NameType" ⇒ NameType.unpickle (rest, result)
                        case "cim:Name" ⇒ Name.unpickle (rest, result)
                        case "cim:UserAttribute" ⇒ UserAttribute.unpickle (rest, result)

                        case _ ⇒ Unknown.unpickle (rest, result)
                    }
                    key = element.key
                    value = element

                    // return success unless there was unrecognized text before the match
                    // that wasn't at the start of the xml
                    ret = (context.end == (matcher.start () + context.start)) || (context.end == context.start)

                    // set up for next parse
                    result.properties = new HashMap[String, String] ()
                    context.end = matcher.end () + context.start
                    found = true
                }
        }

        return (ret)
    }

    def parse (): HashMap[String, Element] =
    {
        val ret = HashMap[String, Element] ()

        while (parse_one ())
            ret.put (key, value)

        return (ret)
    }
}

object CIM
{
    val CHUNK = 1024*1024*128
    val OVERREAD = 2048 // should be large enough that no RDF element is bigger than this
    val rddex = Pattern.compile ("""\s*<(cim:[^>\.\s]+)([>\s][\s\S]*?)<\/\1>\s*""") // important to consume leading and trailing whitespace

// naive way to make a RDD using "built in" xml processing:
// Prerequisites:
//    need scala-xml_2.11-1.0.6-SNAPSHOT.jar on the classpath)
//    need 3GB of memory in the spark shell (otherwise you slay the compiler)
// import scala.xml.XML
// val xml = XML.loadFile ("/opt/data/dump_all.xml") // (takes about 30 seconds)
// var myrdd = sc.parallelize (xml match { case <rdf:RDF>{ xs @ _* }</rdf:RDF> ⇒ xs })
// ---- this generates an rdd of scala.xml.Node, which isn't so useful because it's still not understood:
// myrdd.takeSample (false, 1)(0).toString ()
// res4: String =
//    <cim:PositionPoint xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" xmlns:cim="http://iec.ch/TC57/2010/CIM-schema-cim15#" xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#">
//        <cim:PositionPoint.Location>_location_5773116_916781250_815217</cim:PositionPoint.Location>
//        <cim:sequenceNumber>3</cim:sequenceNumber>
//        <cim:xPosition>8.52872251591</cim:xPosition>
//        <cim:yPosition>46.9914604142</cim:yPosition>
//    </cim:PositionPoint>


// fast ~ 0.55 seconds, but this fails in the scala-shell of Spark (for non-trivial files):
//                val source = scala.io.Source.fromFile (args (0))
//                val xml = try source.mkString finally source.close ()

//            var xml = ""
// slow 17 seconds      xml = xml + buf.view (0, i).mkString
// slow 2 seconds       xml = xml + String.valueOf (buf.slice (0, i))
// OK 0.83 seconds:
//            val sb = new StringBuilder (size)
//            do
//            {
//                i = isr.read (buf, 0, CHUNK)
//                if (0 < i)
//                    sb.appendAll (buf, 0, i)
//            }

    def read (filename: String, offset: Long, size: Long = CHUNK, overread: Long = OVERREAD): String =
    {
        var ret: String = null

        val file = new File (filename)
        if (file.exists ()) // avoid FileNotFoundException
        {
            val fis = new FileInputStream (file)
            val isr = new InputStreamReader (fis, "UTF8")
            val skipped = isr.skip (offset)
            if (offset == skipped)
            {
                val buf = new Array[Char] (CHUNK)
                val sint: Int = if (size > Int.MaxValue) Int.MaxValue else size.asInstanceOf[Int]
                val sb = new StringBuilder (sint)
                var count:Long = 0
                var stop = false
                do
                {
                    val max = size + overread - count
                    val actual = isr.read (buf, 0, if (max > CHUNK) CHUNK else max.asInstanceOf[Int])
                    if (0 < actual)
                    {
                        sb.appendAll (buf, 0, actual)
                        count += actual
                    }
                    else
                        stop = true
                }
                while (!stop && (count < size + overread))
                isr.close ()
                ret = sb.toString ()
            }
            else
                println ("CIM XML input file cannot be skipped to offset " + offset + ", actual " + skipped)
        }
        else
            println ("CIM XML input file '" + filename + "' not found")

        return (ret)
    }

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
                var xml = read (filename, offset)
                offset += CHUNK
                val before = System.nanoTime
                reading += (before - start) / 1000

                val parser = new CIM (xml)
                xml = null
                val map = parser.parse ()
                result ++= map

                val after = System.nanoTime
                parsing += (after - before) / 1000
                print (".")
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


