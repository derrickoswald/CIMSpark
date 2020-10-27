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
 * @group CSC
 * @groupname CSC Package CSC
 */
final case class CCAinverter
(
    Element: BasicElement = null
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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:CCAinverter rdf:%s=\"%s\">\n%s\t</cim:CCAinverter>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object CCAinverter
    extends
        CIMParseable[CCAinverter]
{

    def parse (context: CIMContext): CCAinverter =
    {
        val ret = CCAinverter(
            BasicElement.parse(context)
        )
        ret
    }

    def serializer: Serializer[CCAinverter] = CCAinverterSerializer
}

object CCAinverterSerializer extends CIMSerializer[CCAinverter]
{
    def write (kryo: Kryo, output: Output, obj: CCAinverter): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CCAinverter]): CCAinverter =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = CCAinverter(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group CSC
 * @groupname CSC Package CSC
 */
final case class CCArectifierControl
(
    Element: BasicElement = null
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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:CCArectifierControl rdf:%s=\"%s\">\n%s\t</cim:CCArectifierControl>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object CCArectifierControl
    extends
        CIMParseable[CCArectifierControl]
{

    def parse (context: CIMContext): CCArectifierControl =
    {
        val ret = CCArectifierControl(
            BasicElement.parse(context)
        )
        ret
    }

    def serializer: Serializer[CCArectifierControl] = CCArectifierControlSerializer
}

object CCArectifierControlSerializer extends CIMSerializer[CCArectifierControl]
{
    def write (kryo: Kryo, output: Output, obj: CCArectifierControl): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CCArectifierControl]): CCArectifierControl =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = CCArectifierControl(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group CSC
 * @groupname CSC Package CSC
 */
final case class CSCtype1
(
    CSCDynamics: CSCDynamics = null
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
    override def sup: CSCDynamics = CSCDynamics

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:CSCtype1 rdf:%s=\"%s\">\n%s\t</cim:CSCtype1>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object CSCtype1
    extends
        CIMParseable[CSCtype1]
{

    def parse (context: CIMContext): CSCtype1 =
    {
        val ret = CSCtype1(
            CSCDynamics.parse(context)
        )
        ret
    }

    def serializer: Serializer[CSCtype1] = CSCtype1Serializer
}

object CSCtype1Serializer extends CIMSerializer[CSCtype1]
{
    def write (kryo: Kryo, output: Output, obj: CSCtype1): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        CSCDynamicsSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CSCtype1]): CSCtype1 =
    {
        val parent = CSCDynamicsSerializer.read(kryo, input, classOf[CSCDynamics])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = CSCtype1(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group CSC
 * @groupname CSC Package CSC
 */
final case class IdcInverterControl
(
    Element: BasicElement = null
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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:IdcInverterControl rdf:%s=\"%s\">\n%s\t</cim:IdcInverterControl>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object IdcInverterControl
    extends
        CIMParseable[IdcInverterControl]
{

    def parse (context: CIMContext): IdcInverterControl =
    {
        val ret = IdcInverterControl(
            BasicElement.parse(context)
        )
        ret
    }

    def serializer: Serializer[IdcInverterControl] = IdcInverterControlSerializer
}

object IdcInverterControlSerializer extends CIMSerializer[IdcInverterControl]
{
    def write (kryo: Kryo, output: Output, obj: IdcInverterControl): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IdcInverterControl]): IdcInverterControl =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = IdcInverterControl(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group CSC
 * @groupname CSC Package CSC
 */
final case class IgnAngleContInverter
(
    Element: BasicElement = null
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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:IgnAngleContInverter rdf:%s=\"%s\">\n%s\t</cim:IgnAngleContInverter>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object IgnAngleContInverter
    extends
        CIMParseable[IgnAngleContInverter]
{

    def parse (context: CIMContext): IgnAngleContInverter =
    {
        val ret = IgnAngleContInverter(
            BasicElement.parse(context)
        )
        ret
    }

    def serializer: Serializer[IgnAngleContInverter] = IgnAngleContInverterSerializer
}

object IgnAngleContInverterSerializer extends CIMSerializer[IgnAngleContInverter]
{
    def write (kryo: Kryo, output: Output, obj: IgnAngleContInverter): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IgnAngleContInverter]): IgnAngleContInverter =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = IgnAngleContInverter(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group CSC
 * @groupname CSC Package CSC
 */
final case class VDCOL
(
    Element: BasicElement = null
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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:VDCOL rdf:%s=\"%s\">\n%s\t</cim:VDCOL>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object VDCOL
    extends
        CIMParseable[VDCOL]
{

    def parse (context: CIMContext): VDCOL =
    {
        val ret = VDCOL(
            BasicElement.parse(context)
        )
        ret
    }

    def serializer: Serializer[VDCOL] = VDCOLSerializer
}

object VDCOLSerializer extends CIMSerializer[VDCOL]
{
    def write (kryo: Kryo, output: Output, obj: VDCOL): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[VDCOL]): VDCOL =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = VDCOL(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _CSC
{
    def register: List[CIMClassInfo] =
    {
        List(
            CCAinverter.register,
            CCArectifierControl.register,
            CSCtype1.register,
            IdcInverterControl.register,
            IgnAngleContInverter.register,
            VDCOL.register
        )
    }
}