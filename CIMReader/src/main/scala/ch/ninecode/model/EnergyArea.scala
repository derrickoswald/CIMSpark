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
 * @group EnergyArea
 * @groupname EnergyArea Package EnergyArea
 */
final case class BlockDispatchComponent
(
    EnergyComponent: EnergyComponent = null
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
    override def sup: EnergyComponent = EnergyComponent

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
        "\t<cim:BlockDispatchComponent rdf:%s=\"%s\">\n%s\t</cim:BlockDispatchComponent>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object BlockDispatchComponent
    extends
        CIMParseable[BlockDispatchComponent]
{

    def parse (context: CIMContext): BlockDispatchComponent =
    {
        val ret = BlockDispatchComponent(
            EnergyComponent.parse(context)
        )
        ret
    }

    def serializer: Serializer[BlockDispatchComponent] = BlockDispatchComponentSerializer
}

object BlockDispatchComponentSerializer extends CIMSerializer[BlockDispatchComponent]
{
    def write (kryo: Kryo, output: Output, obj: BlockDispatchComponent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        EnergyComponentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BlockDispatchComponent]): BlockDispatchComponent =
    {
        val parent = EnergyComponentSerializer.read(kryo, input, classOf[EnergyComponent])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = BlockDispatchComponent(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group EnergyArea
 * @groupname EnergyArea Package EnergyArea
 */
final case class BlockDispatchInstruction
(
    IdentifiedObject: IdentifiedObject = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        "\t<cim:BlockDispatchInstruction rdf:%s=\"%s\">\n%s\t</cim:BlockDispatchInstruction>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object BlockDispatchInstruction
    extends
        CIMParseable[BlockDispatchInstruction]
{

    def parse (context: CIMContext): BlockDispatchInstruction =
    {
        val ret = BlockDispatchInstruction(
            IdentifiedObject.parse(context)
        )
        ret
    }

    def serializer: Serializer[BlockDispatchInstruction] = BlockDispatchInstructionSerializer
}

object BlockDispatchInstructionSerializer extends CIMSerializer[BlockDispatchInstruction]
{
    def write (kryo: Kryo, output: Output, obj: BlockDispatchInstruction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BlockDispatchInstruction]): BlockDispatchInstruction =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = BlockDispatchInstruction(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group EnergyArea
 * @groupname EnergyArea Package EnergyArea
 */
final case class BlockDispatchOrder
(
    IdentifiedObject: IdentifiedObject = null,
    p: Double = 0.0,
    sequence: Int = 0
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = BlockDispatchOrder.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(BlockDispatchOrder.fields(position), value)

        emitelem(0, p)
        emitelem(1, sequence)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:BlockDispatchOrder rdf:%s=\"%s\">\n%s\t</cim:BlockDispatchOrder>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object BlockDispatchOrder
    extends
        CIMParseable[BlockDispatchOrder]
{
    override val fields: Array[String] = Array[String](
        "p",
        "sequence"
    )
    val p: Fielder = parse_element(element(cls, fields(0)))
    val sequence: Fielder = parse_element(element(cls, fields(1)))

    def parse (context: CIMContext): BlockDispatchOrder =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BlockDispatchOrder(
            IdentifiedObject.parse(context),
            toDouble(mask(p(), 0)),
            toInteger(mask(sequence(), 1))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BlockDispatchOrder] = BlockDispatchOrderSerializer
}

object BlockDispatchOrderSerializer extends CIMSerializer[BlockDispatchOrder]
{
    def write (kryo: Kryo, output: Output, obj: BlockDispatchOrder): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.p),
            () => output.writeInt(obj.sequence)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BlockDispatchOrder]): BlockDispatchOrder =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = BlockDispatchOrder(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readInt else 0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group EnergyArea
 * @groupname EnergyArea Package EnergyArea
 */
final case class EnergyComponent
(
    IdentifiedObject: IdentifiedObject = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        "\t<cim:EnergyComponent rdf:%s=\"%s\">\n%s\t</cim:EnergyComponent>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object EnergyComponent
    extends
        CIMParseable[EnergyComponent]
{

    def parse (context: CIMContext): EnergyComponent =
    {
        val ret = EnergyComponent(
            IdentifiedObject.parse(context)
        )
        ret
    }

    def serializer: Serializer[EnergyComponent] = EnergyComponentSerializer
}

object EnergyComponentSerializer extends CIMSerializer[EnergyComponent]
{
    def write (kryo: Kryo, output: Output, obj: EnergyComponent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnergyComponent]): EnergyComponent =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = EnergyComponent(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group EnergyArea
 * @groupname EnergyArea Package EnergyArea
 */
final case class EnergyGroup
(
    PowerSystemResource: PowerSystemResource = null,
    isSlack: Boolean = false,
    p: Double = 0.0
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
    override def sup: PowerSystemResource = PowerSystemResource

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
        implicit val clz: String = EnergyGroup.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(EnergyGroup.fields(position), value)

        emitelem(0, isSlack)
        emitelem(1, p)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:EnergyGroup rdf:%s=\"%s\">\n%s\t</cim:EnergyGroup>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object EnergyGroup
    extends
        CIMParseable[EnergyGroup]
{
    override val fields: Array[String] = Array[String](
        "isSlack",
        "p"
    )
    val isSlack: Fielder = parse_element(element(cls, fields(0)))
    val p: Fielder = parse_element(element(cls, fields(1)))

    def parse (context: CIMContext): EnergyGroup =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnergyGroup(
            PowerSystemResource.parse(context),
            toBoolean(mask(isSlack(), 0)),
            toDouble(mask(p(), 1))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[EnergyGroup] = EnergyGroupSerializer
}

object EnergyGroupSerializer extends CIMSerializer[EnergyGroup]
{
    def write (kryo: Kryo, output: Output, obj: EnergyGroup): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeBoolean(obj.isSlack),
            () => output.writeDouble(obj.p)
        )
        PowerSystemResourceSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnergyGroup]): EnergyGroup =
    {
        val parent = PowerSystemResourceSerializer.read(kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = EnergyGroup(
            parent,
            if (isSet(0)) input.readBoolean else false,
            if (isSet(1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group EnergyArea
 * @groupname EnergyArea Package EnergyArea
 */
final case class EnergyTypeReference
(
    IdentifiedObject: IdentifiedObject = null,
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = EnergyTypeReference.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(EnergyTypeReference.fields(position), value)

        emitattr(0, kind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:EnergyTypeReference rdf:%s=\"%s\">\n%s\t</cim:EnergyTypeReference>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object EnergyTypeReference
    extends
        CIMParseable[EnergyTypeReference]
{
    override val fields: Array[String] = Array[String](
        "kind"
    )
    val kind: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): EnergyTypeReference =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnergyTypeReference(
            IdentifiedObject.parse(context),
            mask(kind(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[EnergyTypeReference] = EnergyTypeReferenceSerializer
}

object EnergyTypeReferenceSerializer extends CIMSerializer[EnergyTypeReference]
{
    def write (kryo: Kryo, output: Output, obj: EnergyTypeReference): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.kind)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnergyTypeReference]): EnergyTypeReference =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = EnergyTypeReference(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group EnergyArea
 * @groupname EnergyArea Package EnergyArea
 */
final case class ProportionalDistributionComponent
(
    EnergyComponent: EnergyComponent = null,
    distributionFactor: Double = 0.0
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
    override def sup: EnergyComponent = EnergyComponent

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
        implicit val clz: String = ProportionalDistributionComponent.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(ProportionalDistributionComponent.fields(position), value)

        emitelem(0, distributionFactor)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ProportionalDistributionComponent rdf:%s=\"%s\">\n%s\t</cim:ProportionalDistributionComponent>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ProportionalDistributionComponent
    extends
        CIMParseable[ProportionalDistributionComponent]
{
    override val fields: Array[String] = Array[String](
        "distributionFactor"
    )
    val distributionFactor: Fielder = parse_element(element(cls, fields(0)))

    def parse (context: CIMContext): ProportionalDistributionComponent =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ProportionalDistributionComponent(
            EnergyComponent.parse(context),
            toDouble(mask(distributionFactor(), 0))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ProportionalDistributionComponent] = ProportionalDistributionComponentSerializer
}

object ProportionalDistributionComponentSerializer extends CIMSerializer[ProportionalDistributionComponent]
{
    def write (kryo: Kryo, output: Output, obj: ProportionalDistributionComponent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.distributionFactor)
        )
        EnergyComponentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ProportionalDistributionComponent]): ProportionalDistributionComponent =
    {
        val parent = EnergyComponentSerializer.read(kryo, input, classOf[EnergyComponent])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ProportionalDistributionComponent(
            parent,
            if (isSet(0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _EnergyArea
{
    def register: List[CIMClassInfo] =
    {
        List(
            BlockDispatchComponent.register,
            BlockDispatchInstruction.register,
            BlockDispatchOrder.register,
            EnergyComponent.register,
            EnergyGroup.register,
            EnergyTypeReference.register,
            ProportionalDistributionComponent.register
        )
    }
}