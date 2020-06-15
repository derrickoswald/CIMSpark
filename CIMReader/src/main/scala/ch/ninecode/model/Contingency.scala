package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * An event threatening system reliability, consisting of one or more contingency elements.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param mustStudy Set true if must study this contingency.
 * @param ContingencyElement [[ch.ninecode.model.ContingencyElement ContingencyElement]] A contingency can have any number of contingency elements.
 * @group Contingency
 * @groupname Contingency Package Contingency
 * @groupdesc Contingency Contingencies to be studied.
 */
final case class Contingency
(
    IdentifiedObject: IdentifiedObject = null,
    mustStudy: Boolean = false,
    ContingencyElement: List[String] = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Contingency.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Contingency.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Contingency.fields (position), x))
        emitelem (0, mustStudy)
        emitattrs (1, ContingencyElement)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Contingency rdf:ID=\"%s\">\n%s\t</cim:Contingency>".format (id, export_fields)
    }
}

object Contingency
extends
    CIMParseable[Contingency]
{
    override val fields: Array[String] = Array[String] (
        "mustStudy",
        "ContingencyElement"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ContingencyElement", "ContingencyElement", "0..*", "1")
    )
    val mustStudy: Fielder = parse_element (element (cls, fields(0)))
    val ContingencyElement: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): Contingency =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Contingency (
            IdentifiedObject.parse (context),
            toBoolean (mask (mustStudy (), 0)),
            masks (ContingencyElement (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ContingencySerializer extends CIMSerializer[Contingency]
{
    def write (kryo: Kryo, output: Output, obj: Contingency): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.mustStudy),
            () => writeList (obj.ContingencyElement, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Contingency]): Contingency =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Contingency (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An element of a system event to be studied by contingency analysis, representing a change in status of a single piece of equipment.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Contingency [[ch.ninecode.model.Contingency Contingency]] A contingency element belongs to one contingency.
 * @group Contingency
 * @groupname Contingency Package Contingency
 * @groupdesc Contingency Contingencies to be studied.
 */
final case class ContingencyElement
(
    IdentifiedObject: IdentifiedObject = null,
    Contingency: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ContingencyElement.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ContingencyElement.fields (position), value)
        emitattr (0, Contingency)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ContingencyElement rdf:ID=\"%s\">\n%s\t</cim:ContingencyElement>".format (id, export_fields)
    }
}

object ContingencyElement
extends
    CIMParseable[ContingencyElement]
{
    override val fields: Array[String] = Array[String] (
        "Contingency"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Contingency", "Contingency", "1", "0..*")
    )
    val Contingency: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): ContingencyElement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ContingencyElement (
            IdentifiedObject.parse (context),
            mask (Contingency (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ContingencyElementSerializer extends CIMSerializer[ContingencyElement]
{
    def write (kryo: Kryo, output: Output, obj: ContingencyElement): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Contingency)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ContingencyElement]): ContingencyElement =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ContingencyElement (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Equipment whose in service status is to change, such as a power transformer or AC line segment.
 *
 * @param ContingencyElement [[ch.ninecode.model.ContingencyElement ContingencyElement]] Reference to the superclass object.
 * @param contingentStatus The status for the associated equipment when in the contingency state.
 *        This status is independent of the case to which the contingency is originally applied, but defines the equipment status when the contingency is applied.
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] The single piece of equipment to which to apply the contingency.
 * @group Contingency
 * @groupname Contingency Package Contingency
 * @groupdesc Contingency Contingencies to be studied.
 */
final case class ContingencyEquipment
(
    ContingencyElement: ContingencyElement = null,
    contingentStatus: String = null,
    Equipment: String = null
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
    override def sup: ContingencyElement = ContingencyElement

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
        implicit val clz: String = ContingencyEquipment.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ContingencyEquipment.fields (position), value)
        emitattr (0, contingentStatus)
        emitattr (1, Equipment)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ContingencyEquipment rdf:ID=\"%s\">\n%s\t</cim:ContingencyEquipment>".format (id, export_fields)
    }
}

object ContingencyEquipment
extends
    CIMParseable[ContingencyEquipment]
{
    override val fields: Array[String] = Array[String] (
        "contingentStatus",
        "Equipment"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Equipment", "Equipment", "1", "0..*")
    )
    val contingentStatus: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Equipment: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): ContingencyEquipment =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ContingencyEquipment (
            ContingencyElement.parse (context),
            mask (contingentStatus (), 0),
            mask (Equipment (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ContingencyEquipmentSerializer extends CIMSerializer[ContingencyEquipment]
{
    def write (kryo: Kryo, output: Output, obj: ContingencyEquipment): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.contingentStatus),
            () => output.writeString (obj.Equipment)
        )
        ContingencyElementSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ContingencyEquipment]): ContingencyEquipment =
    {
        val parent = ContingencyElementSerializer.read (kryo, input, classOf[ContingencyElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ContingencyEquipment (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _Contingency
{
    def register: List[CIMClassInfo] =
    {
        List (
            Contingency.register,
            ContingencyElement.register,
            ContingencyEquipment.register
        )
    }
}