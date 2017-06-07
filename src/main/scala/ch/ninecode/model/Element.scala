package ch.ninecode.model

import java.util.regex.Pattern

import org.apache.spark.sql.Row
import org.apache.spark.sql.types.SQLUserDefinedType

// NOTE: ElementUDT is actually in this artifact 
import org.apache.spark.sql.types.ElementUDT

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Parser

@SQLUserDefinedType(udt = classOf[ElementUDT])
trait Element
extends 
    Row
with 
    Serializable
with 
    Cloneable 
{
    def sup: Element = null
    def id: String = if (null == sup) "0" else (sup.id)
    override def length: Int = 1
    override def get (i: Int): Object =
    {
        if (0 == i)
            sup
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def copy(): Row = { throw new Exception("not implemented yet") }
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
    override def copy(): Row = { return (clone().asInstanceOf[Element]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BasicElement
    extends Parser
{
    /**
     * Parse an element.
     * Simply extracts the id.
     */
    val mRID = parse_element ((Pattern.compile("""rdf:ID=("|')([\s\S]*?)\1>?"""), 2))
    override def parse(context: Context): BasicElement =
    {
        new BasicElement (null, mRID (context))
    }
}

/**
 * Unknown element
 * Default parsed element, when no other more specific class applies
 */
case class Unknown(
    override val sup: Element = null,
    guts: String,
    line: Int,
    start: Long,
    end: Long)
      extends Element
{
    def this() = { this(null, null, 0, 0l, 0l) }
    def Element: Element = sup
    override def copy(): Row = { return (clone().asInstanceOf[Unknown]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
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
    var name: String = "";

    def parse(context: Context): Unknown =
    {
        if ((Context.DEBUG) && (context.errors.size < Context.MAXERRORS))
            context.errors += "Unknown element \"" + name + "\" at line " + context.line_number()
        Unknown (
            BasicElement.parse(context),
            context.subxml,
            context.line_number(),
            context.start,
            context.end)
    }
}
