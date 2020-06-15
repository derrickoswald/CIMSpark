package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * IEC 62325 version number assigned to this UML model.
 *
 * @param Element Reference to the superclass object.
 * @param date Form is YYYY-MM-DD for example for January 5, 2009 it is 2009-01-05.
 * @param version Form is IEC62325CIMXXvYY where XX is the major CIM package version and the YY is the minor version.
 *        For example IEC62325CIM10v03.
 * @group IEC62325
 * @groupname IEC62325 Package IEC62325
 * @groupdesc IEC62325 The IEC 62325 subpackages of the CIM are developed, standardized and maintained by the IEC TC57.
 */
final case class IEC62325CIMVersion
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = IEC62325CIMVersion.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (IEC62325CIMVersion.fields (position), value)
        emitelem (0, date)
        emitelem (1, version)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IEC62325CIMVersion rdf:ID=\"%s\">\n%s\t</cim:IEC62325CIMVersion>".format (id, export_fields)
    }
}

object IEC62325CIMVersion
extends
    CIMParseable[IEC62325CIMVersion]
{
    override val fields: Array[String] = Array[String] (
        "date",
        "version"
    )
    val date: Fielder = parse_element (element (cls, fields(0)))
    val version: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: CIMContext): IEC62325CIMVersion =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IEC62325CIMVersion (
            BasicElement.parse (context),
            mask (date (), 0),
            mask (version (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[IEC62325CIMVersion] = IEC62325CIMVersionSerializer
}

object IEC62325CIMVersionSerializer extends CIMSerializer[IEC62325CIMVersion]
{
    def write (kryo: Kryo, output: Output, obj: IEC62325CIMVersion): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.date),
            () => output.writeString (obj.version)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IEC62325CIMVersion]): IEC62325CIMVersion =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = IEC62325CIMVersion (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _IEC62325
{
    def register: List[CIMClassInfo] =
    {
        List (
            IEC62325CIMVersion.register
        )
    }
}