package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Used to define the type of generation for scheduling purposes.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param EnergySource [[ch.ninecode.model.EnergySource EnergySource]] Energy Source of a particular Energy Scheduling Type
 * @group InfEnergySource
 * @groupname InfEnergySource Package InfEnergySource
 */
case class EnergySchedulingType
(
    override val sup: IdentifiedObject,
    EnergySource: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[EnergySchedulingType] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnergySchedulingType.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (EnergySchedulingType.fields (position), x))
        emitattrs (0, EnergySource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergySchedulingType rdf:ID=\"%s\">\n%s\t</cim:EnergySchedulingType>".format (id, export_fields)
    }
}

object EnergySchedulingType
extends
    Parseable[EnergySchedulingType]
{
    override val fields: Array[String] = Array[String] (
        "EnergySource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnergySource", "EnergySource", "0..*", "0..1")
    )
    val EnergySource: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): EnergySchedulingType =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = EnergySchedulingType (
            IdentifiedObject.parse (context),
            masks (EnergySource (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _InfEnergySource
{
    def register: List[ClassInfo] =
    {
        List (
            EnergySchedulingType.register
        )
    }
}