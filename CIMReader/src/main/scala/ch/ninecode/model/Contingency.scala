package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * An event threatening system reliability, consisting of one or more contingency elements.
 *
 * @param sup                [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param mustStudy          Set true if must study this contingency.
 * @param ContingencyElement [[ch.ninecode.model.ContingencyElement ContingencyElement]] A contingency can have any number of contingency elements.
 * @group Contingency
 * @groupname Contingency Package Contingency
 * @groupdesc Contingency Contingencies to be studied.
 */
case class Contingency
(
    override val sup: IdentifiedObject,
    mustStudy: Boolean,
    ContingencyElement: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, false, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf [IdentifiedObject]

    override def copy (): Row =
    {
        clone ().asInstanceOf [Contingency]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Contingency.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Contingency.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Contingency.fields (position), x))

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
        Parseable[Contingency]
{
    override val fields: Array[String] = Array [String](
        "mustStudy",
        "ContingencyElement"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ContingencyElement", "ContingencyElement", "0..*", "1")
    )
    val mustStudy: Fielder = parse_element (element (cls, fields (0)))
    val ContingencyElement: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: Context): Contingency =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = Contingency (
            IdentifiedObject.parse (context),
            toBoolean (mask (mustStudy (), 0)),
            masks (ContingencyElement (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An element of a system event to be studied by contingency analysis, representing a change in status of a single piece of equipment.
 *
 * @param sup         [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Contingency [[ch.ninecode.model.Contingency Contingency]] A contingency element belongs to one contingency.
 * @group Contingency
 * @groupname Contingency Package Contingency
 * @groupdesc Contingency Contingencies to be studied.
 */
case class ContingencyElement
(
    override val sup: IdentifiedObject,
    Contingency: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf [IdentifiedObject]

    override def copy (): Row =
    {
        clone ().asInstanceOf [ContingencyElement]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

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
        Parseable[ContingencyElement]
{
    override val fields: Array[String] = Array [String](
        "Contingency"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Contingency", "Contingency", "1", "0..*")
    )
    val Contingency: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: Context): ContingencyElement =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = ContingencyElement (
            IdentifiedObject.parse (context),
            mask (Contingency (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A equipment to which the in service status is to change such as a power transformer or AC line segment.
 *
 * @param sup              [[ch.ninecode.model.ContingencyElement ContingencyElement]] Reference to the superclass object.
 * @param contingentStatus The status for the associated equipment when in the contingency state.
 *                         This status is independent of the case to which the contingency is originally applied, but defines the equipment status when the contingency is applied.
 * @param Equipment        [[ch.ninecode.model.Equipment Equipment]] The single piece of equipment to which to apply the contingency.
 * @group Contingency
 * @groupname Contingency Package Contingency
 * @groupdesc Contingency Contingencies to be studied.
 */
case class ContingencyEquipment
(
    override val sup: ContingencyElement,
    contingentStatus: String,
    Equipment: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ContingencyElement: ContingencyElement = sup.asInstanceOf [ContingencyElement]

    override def copy (): Row =
    {
        clone ().asInstanceOf [ContingencyEquipment]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

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
        Parseable[ContingencyEquipment]
{
    override val fields: Array[String] = Array [String](
        "contingentStatus",
        "Equipment"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Equipment", "Equipment", "1", "0..*")
    )
    val contingentStatus: Fielder = parse_attribute (attribute (cls, fields (0)))
    val Equipment: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: Context): ContingencyEquipment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = ContingencyEquipment (
            ContingencyElement.parse (context),
            mask (contingentStatus (), 0),
            mask (Equipment (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _Contingency
{
    def register: List[ClassInfo] =
    {
        List (
            Contingency.register,
            ContingencyElement.register,
            ContingencyEquipment.register
        )
    }
}