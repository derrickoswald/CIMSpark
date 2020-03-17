package ch.ninecode.model

import java.util.regex.Pattern

import org.apache.spark.sql.Row
import org.apache.spark.sql.types.SQLUserDefinedType

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Parser
import ch.ninecode.cim.Parser.namespace
import ch.ninecode.cim.Relationship
// NOTE: ElementUDT is actually in this artifact
import org.apache.spark.sql.types.ElementUDT

/**
 * Lowest level class in the CIM hierarchy.
 *
 * All CIM model objects inherit from this class, either directly or indirectly.
 *
 * Provides overridable functionality to:
 *
 - access the typed superclass for each object (implemented as <code>null</code> in this trait)
 - access the unique ID for each object
 - access the class name and hierarchy class list
 - act as a Row object for use in SQL DataFrames ([[length]], [[get]] and [[copy]])
 - export the object as XML (implemented as <code>""</code> in this trait)
 *
 * @group Added
 * @groupname Added Classes added by CIMReader
 * @groupdesc Low level classes needed to parse the hierarchical CIM classes and generate nested RDD of.
 */
@SQLUserDefinedType(udt = classOf[ElementUDT])
trait Element
extends
    Row
with
    Serializable
with
    Cloneable
with
    Product
{
    /**
     * Get the superclass object.
     *
     * @return The typed superclass (in this case <code>null</code>).
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def sup: Element = null

    /**
     * Return the unique ID for the object, the mRID for IdentifiedObject derived classes.
     *
     * @return The object ID.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def id: String = if (null == sup) "0" else sup.id

    /**
     * Valid fields bitmap.
     *
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the fields array.
     *
     * For classes constructed manually, we initially fill this in with the worst case scenario.
     * ToDo: this won't work for classes with more than 96 fields (so far none).
     */
    var bitfields: Array[Int] = Array(-1, -1, -1)

    /**
     * Is a field present predicate.
     *
     * Determines if the field at the given position was encountered while parsing.
     *
     * @param position the field position in the fields array
     * @return <code>true</code> if the field was parsed, <code>false</code> otherwise.
     */
    def mask (position: Int): Boolean = 0 != (bitfields(position / 32) & (1 << (position % 32)))

    /**
     * Flag for rdf:about elements.
     *
     * @return <code>true</code> if this is an rdf:about element, <code>false</code> otherwise.
     */
    def about: Boolean = if (null == sup) false else sup.about

    /**
     * This class name.
     *
     * @return the class name without the package prefixes
     */
    def baseclass: String =
    {
        if (null == sup)
            "Element"
        else
        {
            val s = getClass.getName
            s.substring (s.lastIndexOf (".") + 1)
        }
    }

    /**
     * This class and the hierarchical list of classes this class derives from.
     *
     * @return the list of classes without the package prefixes.
     */
    def classes: Seq[String] =
    {
        Seq (baseclass) ++ (if (null == sup) Seq () else sup.classes)
    }

    //
    // Row overrides
    //

    /**
     * The number of fields in the object definition.
     *
     * @return The number of defined fields for use in Row manipulations.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def length: Int = 1

    /**
     * Get the value of the field at index <code>i</code>.
     *
     * @param i The index of the field desired.
     * @return The value stored in the field, or <code>null</code> if none.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def get (i: Int): Object =
    {
        if (0 == i)
            sup
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { throw new Exception ("copy() should be overridden in derived classes") }

    /**
     * Emit one XML element.
     *
     * @example &lt;cim:IdentifiedObject.name&gt;WGS 84&lt;/cim:IdentifiedObject.name&gt;
     *
     * @param field The name of the field.
     * @param value The value of the field.
     * @param clz The class name (e.g. ACLineSegment) of this element
     * @param s The builder to write into.
     */
    def emit_element (field: String, value: Any)(implicit clz: String, s: StringBuilder): Unit =
    {
        if (null != value)
        {
            s.append ("\t\t<")
            s.append (namespace)
            s.append (":")
            s.append (clz)
            s.append (".")
            s.append (field)
            s.append (">")
            s.append (value.toString)
            s.append ("</")
            s.append (namespace)
            s.append (":")
            s.append (clz)
            s.append (".")
            s.append (field)
            s.append (">\n")
        }
    }

    /**
     * Emit one XML attribute.
     *
     * @example &lt;cim:Location.CoordinateSystem rdf:resource="#wgs84"/&gt;
     *
     * @param field The name of the field.
     * @param value The value of the field.
     * @param clz The class name (e.g. ACLineSegment) of this element
     * @param s The builder to write into.
     */
    def emit_attribute (field: String, value: Any)(implicit clz: String, s: StringBuilder): Unit =
    {
        if (null != value)
        {
            s.append ("\t\t<")
            s.append (namespace)
            s.append (":")
            s.append (clz)
            s.append (".")
            s.append (field)
            s.append (" rdf:resource=\"")
            val v = value.toString
            if (!v.startsWith ("http://")) s.append ("#") // relative
            s.append (v)
            s.append ("\"/>\n")
        }
    }

    /**
     * Return a string containing the fields of this object suitable for inclusion in an XML object.
     *
     * @return A string with the fields coded in XML
     * @group Serialization
     * @groupname Serialization Export Implementation
     * @groupdesc Serialization Members related to export of CIM classes
     */
    def export_fields: String = ""

    /**
     * Return a string containing this object as XML.
     *
     * @return The XML corresponding to this object.
     * @group Serialization
     * @groupname Serialization Export Implementation
     * @groupdesc Serialization Members related to export of CIM classes
     */
    def export: String = ""
}

/**
 * Top level element.
 *
 * Not all elements really have an mRID (classes in package Common like PositionPoint and PostalAddress)
 * But Spark needs identifiers for joins, so, for now all elements have an mRID.
 *
 * @param sup Reference to the superclass object.
 * @param mRID Master resource identifier issued by a model authority. By convention, this is used as the RDF id in the CIM XML.
 * @group Added
 * @groupname Added Classes added by CIMReader
 * @groupdesc Low level classes needed to parse the hierarchical CIM classes and generate nested RDD of.
 */
case class BasicElement
(
    override val sup: Element = null,
    mRID: String = null
)
extends
    Element
{
    /**
     * Zero arg constructor.
     */
    def this () = { this (null, null) }

    /**
     * Return the unique ID for the object, the mRID for IdentifiedObject derived classes.
     *
     * @return The object ID.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def id: String = mRID

    /**
     * Set true for elements with rdf:about instead of rdf:ID.
     */
    var _about: Boolean = false

    /**
     * Flag for rdf:about elements.
     *
     * @return <code>true</code> if this is an rdf:about element, <code>false</code> otherwise.
     */
    override def about: Boolean = _about

    override def copy(): Row = clone ().asInstanceOf[Element]
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
}

object BasicElement
    extends Parser
{
    // ToDo: this could probably be handled by an OR case in one regular expression:

    /**
     * Parse an element.
     * Simply extracts the rdf:ID.
     */
    val ID: FielderFunction = parse_element ((Pattern.compile("""rdf:ID=("|')([\s\S]*?)\1>?"""), 2))
    /**
     * Parse an element.
     * Simply extracts the rdf:about.
     */
    val about: FielderFunction = parse_element ((Pattern.compile("""rdf:about=("|')([\s\S]*?)\1>?"""), 2))

    override def parse (context: Context): BasicElement =
    {
        implicit val ctx: Context = context
        val id = ID.apply ().orNull
        val ab = about.apply ()
        val mRID = ab match
        {
            case Some (mrid) =>
                if ('#' == mrid.charAt (0)) mrid.substring (1) else mrid // remove '#'
            case None =>
                id // id may be null anyway
        }
        val basic = BasicElement (null, mRID)
        basic._about = ab.isDefined
        basic
    }
}

/**
 * Unknown element.
 *
 * Default parsed element, when no other more specific class applies.
 *
 * @param sup Reference to the superclass object.
 * @param guts Internal contents of the XML element with the unrecognized name.
 * @param line The line number on which the unknown XML element starts, <em>in Spark this is relative to the split being processed</em>.
 * @param start The starting character position of the unknown XML element, <em>in Spark this is relative to the split being processed</em>.
 * @param end The ending character position of the unknown XML element, <em>in Spark this is relative to the split being processed</em>.
 * @group Added
 * @groupname Added Classes added by CIMReader
 * @groupdesc Low level classes needed to parse the hierarchical CIM classes and generate nested RDD of.
 */
case class Unknown(
    override val sup: Element = null,
    guts: String,
    line: Int,
    start: Long,
    end: Long)
extends
    Element
{
    /**
     * Zero arg constructor.
     */
    def this() = { this (null, null, 0, 0L, 0L) }
    def Element: Element = sup
    override def copy (): Row = { clone ().asInstanceOf[Unknown] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
}

object Unknown
extends
    Parseable[Unknown]
{
    /**
     * The current element name.
     * Used for error messages.
     */
    var name: String = ""

    def parse(context: Context): Unknown =
    {
        if (Context.DEBUG && (context.errors.size < Context.MAXERRORS))
            context.errors += s"""Unknown element "$name" at line ${context.line_number()}"""
        Unknown (
            BasicElement.parse(context),
            context.subxml,
            context.line_number(),
            context.start,
            context.end)
    }
    override val relations: List[Relationship] = List ()
}
