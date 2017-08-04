package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

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
    override val sup: BasicElement,
    date: String,
    version: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[IEC61970CIMVersion] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != date) "\t\t<cim:IEC61970CIMVersion.date>" + date + "</cim:IEC61970CIMVersion.date>\n" else "") +
        (if (null != version) "\t\t<cim:IEC61970CIMVersion.version>" + version + "</cim:IEC61970CIMVersion.version>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:IEC61970CIMVersion rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:IEC61970CIMVersion>\n"
    }
}

object IEC61970CIMVersion
extends
    Parseable[IEC61970CIMVersion]
{
    val date: (Context) => String = parse_element (element ("""IEC61970CIMVersion.date"""))
    val version: (Context) => String = parse_element (element ("""IEC61970CIMVersion.version"""))
    def parse (context: Context): IEC61970CIMVersion =
    {
        IEC61970CIMVersion(
            BasicElement.parse (context),
            date (context),
            version (context)
        )
    }
}

private[ninecode] object _IEC61970
{
    def register: List[ClassInfo] =
    {
        List (
            IEC61970CIMVersion.register
        )
    }
}