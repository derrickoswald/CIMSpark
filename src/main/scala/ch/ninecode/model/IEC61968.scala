package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * The IEC 61968 subpackages of the CIM are developed, standardized and maintained by IEC TC57 Working Group 14: interfaces for distribution management (WG14).
 * Currently, normative parts of the model support the needs of information exchange defined in IEC 61968-3, IEC 61968-4, IEC 61968-9 and in IEC 61968-13.
 */

/**
 * IEC 61968 version number assigned to this UML model.
 * @param sup Reference to the superclass object.
 * @param date Form is YYYY-MM-DD for example for January 5, 2009 it is 2009-01-05.
 * @param version Form is IEC61968CIMXXvYY where XX is the major CIM package version and the YY is the minor version.
 *        For example IEC61968CIM10v17.
 */
case class IEC61968CIMVersion
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
    override def copy (): Row = { clone ().asInstanceOf[IEC61968CIMVersion] }
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
        (if (null != date) "\t\t<cim:IEC61968CIMVersion.date>" + date + "</cim:IEC61968CIMVersion.date>\n" else "") +
        (if (null != version) "\t\t<cim:IEC61968CIMVersion.version>" + version + "</cim:IEC61968CIMVersion.version>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:IEC61968CIMVersion rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:IEC61968CIMVersion>"
    }
}

object IEC61968CIMVersion
extends
    Parseable[IEC61968CIMVersion]
{
    val date: (Context) => String = parse_element (element ("""IEC61968CIMVersion.date"""))
    val version: (Context) => String = parse_element (element ("""IEC61968CIMVersion.version"""))
    def parse (context: Context): IEC61968CIMVersion =
    {
        IEC61968CIMVersion(
            BasicElement.parse (context),
            date (context),
            version (context)
        )
    }
}

private[ninecode] object _IEC61968
{
    def register: List[ClassInfo] =
    {
        List (
            IEC61968CIMVersion.register
        )
    }
}