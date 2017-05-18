package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Top package for IEC 61970.
 */

/**
 * This is the IEC 61970 CIM version number assigned to this UML model.
 * @param sup Reference to the superclass object.
 * @param date Form is YYYY-MM-DD for example for January 5, 2009 it is 2009-01-05.
 * @param version Form is IEC61970CIMXXvYY where XX is the major CIM package version and the YY is the minor version.
 *        For example IEC61970CIM13v18.
 */
case class IEC61970CIMVersion
(
    override val sup: Element,
    val date: String,
    val version: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[IEC61970CIMVersion]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IEC61970CIMVersion
extends
    Parseable[IEC61970CIMVersion]
{
    val sup = BasicElement.parse _
    val date = parse_element (element ("""IEC61970CIMVersion.date"""))_
    val version = parse_element (element ("""IEC61970CIMVersion.version"""))_
    def parse (context: Context): IEC61970CIMVersion =
    {
        IEC61970CIMVersion(
            sup (context),
            date (context),
            version (context)
        )
    }
}

object _IEC61970
{
    def register: Unit =
    {
        IEC61970CIMVersion.register
    }
}