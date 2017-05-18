package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The IEC 62325 subpackages of the CIM are developed, standardized and maintained by IEC TC57 Working Group 16.
 */

/**
 * IEC 62325 version number assigned to this UML model.
 * @param sup Reference to the superclass object.
 * @param date Form is YYYY-MM-DD for example for January 5, 2009 it is 2009-01-05.
 * @param version Form is IEC62325CIMXXvYY where XX is the major CIM package version and the YY is the minor version.
 *        For example IEC62325CIM10v03.
 */
case class IEC62325CIMVersion
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
    override def copy (): Row = { return (clone ().asInstanceOf[IEC62325CIMVersion]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IEC62325CIMVersion
extends
    Parseable[IEC62325CIMVersion]
{
    val sup = BasicElement.parse _
    val date = parse_element (element ("""IEC62325CIMVersion.date"""))_
    val version = parse_element (element ("""IEC62325CIMVersion.version"""))_
    def parse (context: Context): IEC62325CIMVersion =
    {
        IEC62325CIMVersion(
            sup (context),
            date (context),
            version (context)
        )
    }
}

object _IEC62325
{
    def register: Unit =
    {
        IEC62325CIMVersion.register
    }
}