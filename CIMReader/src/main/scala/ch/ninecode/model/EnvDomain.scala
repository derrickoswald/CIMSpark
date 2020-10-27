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
 * Vertical displacement relative to either sealevel, ground or the center of the earth.
 *
 * @param Element      Reference to the superclass object.
 * @param displacement <em>undocumented</em>
 * @param kind         <em>undocumented</em>
 * @group EnvDomain
 * @groupname EnvDomain Package EnvDomain
 */
final case class RelativeDisplacement
(
    Element: BasicElement = null,
    displacement: Double = 0.0,
    kind: String = null
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
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = RelativeDisplacement.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(RelativeDisplacement.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(RelativeDisplacement.fields(position), value)

        emitelem(0, displacement)
        emitattr(1, kind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:RelativeDisplacement rdf:%s=\"%s\">\n%s\t</cim:RelativeDisplacement>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object RelativeDisplacement
    extends
        CIMParseable[RelativeDisplacement]
{
    override val fields: Array[String] = Array[String](
        "displacement",
        "kind"
    )
    val displacement: Fielder = parse_element(element(cls, fields(0)))
    val kind: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): RelativeDisplacement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RelativeDisplacement(
            BasicElement.parse(context),
            toDouble(mask(displacement(), 0)),
            mask(kind(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RelativeDisplacement] = RelativeDisplacementSerializer
}

object RelativeDisplacementSerializer extends CIMSerializer[RelativeDisplacement]
{
    def write (kryo: Kryo, output: Output, obj: RelativeDisplacement): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.displacement),
            () => output.writeString(obj.kind)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RelativeDisplacement]): RelativeDisplacement =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = RelativeDisplacement(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _EnvDomain
{
    def register: List[CIMClassInfo] =
    {
        List(
            RelativeDisplacement.register
        )
    }
}