package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:BlockDispatchComponent rdf:ID=\"%s\">\n%s\t</cim:BlockDispatchComponent>".format (id, export_fields)
    }
}

object BlockDispatchComponent
extends
    CIMParseable[BlockDispatchComponent]
{

    def parse (context: CIMContext): BlockDispatchComponent =
    {
        val ret = BlockDispatchComponent (
            EnergyComponent.parse (context)
        )
        ret
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:BlockDispatchInstruction rdf:ID=\"%s\">\n%s\t</cim:BlockDispatchInstruction>".format (id, export_fields)
    }
}

object BlockDispatchInstruction
extends
    CIMParseable[BlockDispatchInstruction]
{

    def parse (context: CIMContext): BlockDispatchInstruction =
    {
        val ret = BlockDispatchInstruction (
            IdentifiedObject.parse (context)
        )
        ret
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BlockDispatchOrder.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BlockDispatchOrder.fields (position), value)
        emitelem (0, p)
        emitelem (1, sequence)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BlockDispatchOrder rdf:ID=\"%s\">\n%s\t</cim:BlockDispatchOrder>".format (id, export_fields)
    }
}

object BlockDispatchOrder
extends
    CIMParseable[BlockDispatchOrder]
{
    override val fields: Array[String] = Array[String] (
        "p",
        "sequence"
    )
    val p: Fielder = parse_element (element (cls, fields(0)))
    val sequence: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: CIMContext): BlockDispatchOrder =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BlockDispatchOrder (
            IdentifiedObject.parse (context),
            toDouble (mask (p (), 0)),
            toInteger (mask (sequence (), 1))
        )
        ret.bitfields = bitfields
        ret
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:EnergyComponent rdf:ID=\"%s\">\n%s\t</cim:EnergyComponent>".format (id, export_fields)
    }
}

object EnergyComponent
extends
    CIMParseable[EnergyComponent]
{

    def parse (context: CIMContext): EnergyComponent =
    {
        val ret = EnergyComponent (
            IdentifiedObject.parse (context)
        )
        ret
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnergyGroup.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EnergyGroup.fields (position), value)
        emitelem (0, isSlack)
        emitelem (1, p)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergyGroup rdf:ID=\"%s\">\n%s\t</cim:EnergyGroup>".format (id, export_fields)
    }
}

object EnergyGroup
extends
    CIMParseable[EnergyGroup]
{
    override val fields: Array[String] = Array[String] (
        "isSlack",
        "p"
    )
    val isSlack: Fielder = parse_element (element (cls, fields(0)))
    val p: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: CIMContext): EnergyGroup =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnergyGroup (
            PowerSystemResource.parse (context),
            toBoolean (mask (isSlack (), 0)),
            toDouble (mask (p (), 1))
        )
        ret.bitfields = bitfields
        ret
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnergyTypeReference.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyTypeReference.fields (position), value)
        emitattr (0, kind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergyTypeReference rdf:ID=\"%s\">\n%s\t</cim:EnergyTypeReference>".format (id, export_fields)
    }
}

object EnergyTypeReference
extends
    CIMParseable[EnergyTypeReference]
{
    override val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): EnergyTypeReference =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnergyTypeReference (
            IdentifiedObject.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ProportionalDistributionComponent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProportionalDistributionComponent.fields (position), value)
        emitelem (0, distributionFactor)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProportionalDistributionComponent rdf:ID=\"%s\">\n%s\t</cim:ProportionalDistributionComponent>".format (id, export_fields)
    }
}

object ProportionalDistributionComponent
extends
    CIMParseable[ProportionalDistributionComponent]
{
    override val fields: Array[String] = Array[String] (
        "distributionFactor"
    )
    val distributionFactor: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): ProportionalDistributionComponent =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ProportionalDistributionComponent (
            EnergyComponent.parse (context),
            toDouble (mask (distributionFactor (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _EnergyArea
{
    def register: List[CIMClassInfo] =
    {
        List (
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