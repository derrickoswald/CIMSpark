package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable

import ch.ninecode.cim.CIMSerializer

/**
 * IEC 61968 version number assigned to this UML model.
 *
 * @param Element Reference to the superclass object.
 * @param date    (const=2016-10-31) Form is YYYY-MM-DD for example for January 5, 2009 it is 2009-01-05.
 * @param version (const=IEC61968CIM13v09) Form is IEC61968CIMXXvYY[a-z] where XX is the major CIM package version and the YY is the minor version.
 *                For example IEC61968CIM10v17a.
 *                The letter on the version number indicates the changes are due to National Committee comments.
 * @group IEC61968
 * @groupname IEC61968 Package IEC61968
 * @groupdesc IEC61968 The IEC 61968 subpackages of the CIM are developed, standardized and maintained by IEC TC57 Working Group 14: interfaces for distribution management (WG14).
 *            Currently, normative parts of the model support the needs of information exchange defined in IEC 61968-3, IEC 61968-4, IEC 61968-9 and in IEC 61968-13.
 */
final case class IEC61968CIMVersion
(
    Element: BasicElement = null,
    date: String = null,
    version: String = null
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = IEC61968CIMVersion.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (IEC61968CIMVersion.fields (position), value)

        emitelem (0, date)
        emitelem (1, version)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:IEC61968CIMVersion rdf:ID=\"%s\">\n%s\t</cim:IEC61968CIMVersion>".format (id, export_fields)
    }
}

object IEC61968CIMVersion
    extends
        CIMParseable[IEC61968CIMVersion]
{
    override val fields: Array[String] = Array [String](
        "date",
        "version"
    )
    val date: Fielder = parse_element (element (cls, fields (0)))
    val version: Fielder = parse_element (element (cls, fields (1)))

    def parse (context: CIMContext): IEC61968CIMVersion =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = IEC61968CIMVersion (
            BasicElement.parse (context),
            mask (date (), 0),
            mask (version (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[IEC61968CIMVersion] = IEC61968CIMVersionSerializer
}

object IEC61968CIMVersionSerializer extends CIMSerializer[IEC61968CIMVersion]
{
    def write (kryo: Kryo, output: Output, obj: IEC61968CIMVersion): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.date),
            () => output.writeString (obj.version)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IEC61968CIMVersion]): IEC61968CIMVersion =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = IEC61968CIMVersion (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _IEC61968
{
    def register: List[CIMClassInfo] =
    {
        List (
            IEC61968CIMVersion.register
        )
    }
}