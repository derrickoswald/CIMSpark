package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Static var compensator whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param DynamicsFunctionBlock [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param StaticVarCompensator [[ch.ninecode.model.StaticVarCompensator StaticVarCompensator]] Static Var Compensator to which Static Var Compensator dynamics model applies.
 * @group StaticVarCompensatorDynamics
 * @groupname StaticVarCompensatorDynamics Package StaticVarCompensatorDynamics
 * @groupdesc StaticVarCompensatorDynamics Static var compensator (SVC) models.
 */
final case class StaticVarCompensatorDynamics
(
    DynamicsFunctionBlock: DynamicsFunctionBlock = null,
    StaticVarCompensator: String = null
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
    override def sup: DynamicsFunctionBlock = DynamicsFunctionBlock

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
        implicit val clz: String = StaticVarCompensatorDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StaticVarCompensatorDynamics.fields (position), value)
        emitattr (0, StaticVarCompensator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StaticVarCompensatorDynamics rdf:ID=\"%s\">\n%s\t</cim:StaticVarCompensatorDynamics>".format (id, export_fields)
    }
}

object StaticVarCompensatorDynamics
extends
    Parseable[StaticVarCompensatorDynamics]
{
    override val fields: Array[String] = Array[String] (
        "StaticVarCompensator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("StaticVarCompensator", "StaticVarCompensator", "1", "0..1")
    )
    val StaticVarCompensator: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): StaticVarCompensatorDynamics =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StaticVarCompensatorDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (StaticVarCompensator (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _StaticVarCompensatorDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            StaticVarCompensatorDynamics.register
        )
    }
}